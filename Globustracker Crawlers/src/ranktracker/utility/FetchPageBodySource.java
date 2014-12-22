/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Repository;

/**
 * This class contains code to give request to any site depending on the URL without proxy
 * 
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
@Repository("fetchSource")
public class FetchPageBodySource {
    
    String userAgent;
    
    public  String getPageSource(String newurl){
           String responseBody = null; 
           CloseableHttpClient httpclient = HttpClients.createDefault();
            try {
                HttpGet httpget = new HttpGet(newurl);
                System.out.println("executing request " + httpget.getURI());
                ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response)
                                  throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }           
            };
                try {
                    responseBody = httpclient.execute(httpget, responseHandler);
                } catch (IOException ex) {
                    
                    ex.printStackTrace();
                } 
        } finally {
                try {
                    httpclient.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
       
        return responseBody;
    }
    
     /**
      * 
      * @param newurl
      * @return 
      */
     public  String getPageSourceYahoo(URI newurl, String filename){
           String responseBody = null; 
           CloseableHttpClient httpclient = HttpClients.createDefault();
            try {
                HttpGet httpget = new HttpGet(newurl);
                System.out.println("executing request " + httpget.getURI());
                ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response)
                                  throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }           
            };
                try {
                    responseBody = httpclient.execute(httpget, responseHandler);
                } catch (IOException ex) {
                    
                    ex.printStackTrace();
                } 
        } finally {
                try {
                    httpclient.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
        writeResponseFile(responseBody, filename);
        return responseBody;
    }
     
    /**
     * 
     * @param responseBody
     * @param filename 
     */
    public  void writeResponseFile(String responseBody,String filename){
          String str=getShowPage();
          try{
          File file;
          FileOutputStream fop=null;
          file=new File(str+"/"+filename);
              System.out.println("File Name ="+file.getAbsolutePath());
          if(!file.exists()){
              file.createNewFile();
              System.out.println("Created");
          }
          fop=new FileOutputStream(file);
          byte[] contentInBytes=responseBody.getBytes();
          fop.write(contentInBytes);
          fop.flush();
          fop.close();
          }catch(IOException e){
              e.printStackTrace();
          }
        }
    
    public  String getShowPage(){
        String str=null;
        try{
            str=this.getClass().getClassLoader().getResource("").getPath();
            if(str.contains("%20")){
                 str=str.replaceAll("%20", " ");
            }
        }catch(Exception e){
            str=System.getProperty("user.dir");
        }
        //System.out.println("File written  "+str);
        return str;
    }
}
