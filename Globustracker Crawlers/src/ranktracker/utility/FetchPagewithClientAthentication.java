/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ranktracker.crawler.mail.SendMail;

/**
 *
 * @author User
 */
@Repository("fetchSourcewithAuthentication")
public class FetchPagewithClientAthentication {

    static Logger l = Logger.getLogger(FetchPageHttpClient.class.getName());

    /**
     * method to get source page from search engine using
     *
     * @param newurl
     * @param pagename
     * @throws IOException
     */
    public void fetchPageSourcefromClient(URI newurl, String pagename, int portNo) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        int returnresponse;
        int count = 0;
        try {
            HttpGet httpget = new HttpGet(newurl);
            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("403")
                    || responsestatus.contains("400") || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")) {
                do {
                    count++;
                    returnresponse = fetchPageSourcefromClient2(newurl, pagename, portno);
                    if (returnresponse == 503) {
                        System.out.println("PROX FAILURE");
                    }
                    if (count > 15) {
                        fetchPageSourcefromClientPlain(newurl, pagename);
                    }
                } while (returnresponse == 503 || returnresponse == 502);
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            System.out.println("Exception = " + e);
            do {
                count++;
                returnresponse = fetchPageSourcefromClient2(newurl, pagename, portno);
                if (returnresponse == 503) {
                    System.out.println("PROX FAILURE");
                }
                if (count > 15) {
                    fetchPageSourcefromClientPlain(newurl, pagename);
                }
            } while (returnresponse == 503 || returnresponse == 502);
        } finally {
            httpclient.close();
        }
    }

    /**
     * method to get URI body without proxy
     *
     * @param newurl
     * @param pagename
     * @throws IOException
     */
    public void fetchPageSourcefromClientPlain(URI newurl, String pagename) throws IOException {
        System.out.println("---------------Without Proxy-----------------");
        String responsebody;
        String userAgent = UserAgents.getRandomUserAgent();
        try (CloseableHttpClient httpclient = HttpClients.custom()
                .setUserAgent(userAgent)
                .build()) {
            HttpGet httpget = new HttpGet(newurl);
            System.out.println("executing request " + httpget.getURI());
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            responsebody = httpclient.execute(httpget, responseHandler);
        }
        writeResponseFile(responsebody, pagename);
    }

    public void writeResponseFile(String responseBody, String filename) {
        String str = getShowPage();
        File file;
        try {
            FileOutputStream fop = null;
            file = new File(str + "/" + filename);
            //System.out.println("File Name ="+file.getAbsolutePath());
            if (!file.exists()) {
                file.createNewFile();
                //System.out.println("Created");
            }
            fop = new FileOutputStream(file);
            byte[] contentInBytes = responseBody.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();

//                final byte[] messageBytes = responseBody.getBytes(Charset.forName("ISO-8859-1"));
//                final long appendSize = messageBytes.length;
//                final RandomAccessFile raf = new RandomAccessFile(file, "rw");
//                raf.seek(raf.length());
//                final MappedByteBuffer mbf;
//                try (FileChannel fc = raf.getChannel()) {
//                    mbf = fc.map(FileChannel.MapMode.READ_WRITE, fc.position(), appendSize);
//                }
//                mbf.put(messageBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getShowPage() {
        String str = null;
        try {
            str = this.getClass().getClassLoader().getResource("").getPath();
            if (str.contains("%20")) {
                str = str.replaceAll("%20", " ");
            }
        } catch (Exception e) {
            str = System.getProperty("user.dir");
        }
        return str;
    }

    public int fetchPageSourcefromClient2(URI newurl, String pagename, int portNo) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------

        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {
            HttpGet httpget = new HttpGet(newurl);
            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")) {
                return 503;
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            return 503;
        } finally {
            httpclient.close();
        }
        return 0;
    }

    /**
     * This crawler is with different proxy server
     *
     * @param newurl
     * @param pagename
     * @throws IOException
     */
    public String fetchPageSourcefromClientGoogle(URI newurl, String pagename, int portNo) throws IOException, InterruptedException {

        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0")
                .setDefaultRequestConfig(requestConfig)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        int count = 0;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Connection", "keep-alive");

            System.out.println("Response status " + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("403")
                    || responsestatus.contains("400") || responsestatus.contains("407") || responsestatus.contains("401")
                    || responsestatus.contains("402") || responsestatus.contains("404") || responsestatus.contains("405")
                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")
                    || responsestatus.contains("ClientProtocolException") || responsestatus.contains("SocketTimeoutException")
                    || "".equals(responsestatus)) {
                Thread.sleep(10000);
                do {
                    count++;
                    responsebody = fetchPageSourcefromClientGoogleSecond(newurl);
                    if (responsebody == null) {
                        Thread.sleep(10000);
                        System.out.println("PROX FAILURE");
                    }
                    if (count > 20) {
                        Thread.sleep(1000);
                        break;
                    }
                } while (responsebody == null || "".equals(responsebody));
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    // writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            System.out.println("Exception = " + e);
            do {
                count++;
                responsebody = fetchPageSourcefromClientGoogleSecond(newurl);
                if (responsebody == null) {
                    System.out.println("PROX FAILURE");
                }
                if (count > 15) {
                    Thread.sleep(50000);
//                    responsebody = fetchPageSourcefromClientGoogleSecond(newurl);
                    break;
                }
            } while (responsebody == null || "".equals(responsebody));
        } finally {
            httpclient.close();
        }
        return responsebody;
    }

    public String fetchPageSourcefromClientGoogleSecond(URI newurl) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0")
                .setDefaultRequestConfig(requestConfig)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Connection", "keep-alive");

            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
                    || responsestatus.contains("407") || responsestatus.contains("404") || responsestatus.contains("405")
                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")
                    || responsestatus.contains("ClientProtocolException") || responsestatus.contains("SocketTimeoutException")
                    || responsestatus == null || "".equals(responsestatus)) {
                return null;
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
//                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    // writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            return null;
        } finally {
            httpclient.close();
        }
        return responsebody;
    }

    public String fetchPageSourcefromClientBing(URI newurl, String pagename, int portNo) throws IOException, InterruptedException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0")
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        int count = 0;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Connection", "keep-alive");
            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("403")
                    || responsestatus.contains("400") || responsestatus.contains("407") || responsestatus.contains("401")
                    || responsestatus.contains("402") || responsestatus.contains("404") || responsestatus.contains("405")
                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")
                    || responsestatus.contains("ClientProtocolException") || responsestatus.contains("SocketTimeoutException")
                    || responsestatus == null || "".equals(responsestatus)) {
                Thread.sleep(10000);
                do {
                    count++;
                    responsebody = fetchPageSourcefromBingSecond(newurl, pagename);
                    if (responsebody == null) {
                        Thread.sleep(10000);
                        System.out.println("PROX FAILURE");
                    }
                    if (count > 20) {
//                            Thread.sleep(1000);
                        break;
                    }
                } while (responsebody == null || "".equals(responsebody));
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    // writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            System.out.println("Exception = " + e);
            do {
                count++;
                responsebody = fetchPageSourcefromBingSecond(newurl, pagename);
                if (responsebody == null) {
                    System.out.println("PROX FAILURE");
                }
                if (count > 15) {
                    Thread.sleep(50000);
                    responsebody = fetchPageSourcefromBingSecond(newurl, pagename);
                }
            } while (responsebody == null || "".equals(responsebody));
        } finally {
            httpclient.close();
        }
        return responsebody;
    }

    public String fetchPageSourcefromBingSecond(URI newurl, String pagename) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Connection", "keep-alive");
            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
                    || responsestatus.contains("407") || responsestatus.contains("404") || responsestatus.contains("405")
                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")
                    || responsestatus.contains("ClientProtocolException") || responsestatus.contains("SocketTimeoutException")
                    || responsestatus == null || "".equals(responsestatus)) {
                return null;
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    // writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            return null;
        } finally {
            httpclient.close();
        }
        return responsebody;
    }

    public String fetchPageSourcefromClientYahoo(String newurl) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Connection", "keep-alive");
            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            HttpEntity entity = resp.getEntity();
            System.out.println(resp.getStatusLine());
            if (entity != null) {
                System.out.println("Response content length: " + entity.getContentLength());
                BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                }
            }
            EntityUtils.consume(entity);
        } finally {
            httpclient.close();
        }
        return responsebody;
    }

    public int fetchPageSourcefromYahooSecond(URI newurl, String pagename, int portNo) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------

        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Connection", "keep-alive");
            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
//            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
//                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
//                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")) {
//                return 503;
//            } 
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
                    || responsestatus.contains("407") || responsestatus.contains("404") || responsestatus.contains("405")
                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")
                    || responsestatus.contains("ClientProtocolException") || responsestatus.contains("SocketTimeoutException")
                    || responsestatus == null || "".equals(responsestatus)) {
//                return 503;
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            return 503;
        } finally {
            httpclient.close();
        }
        return 0;
    }

    // public void fetchPageSourcefromVimeo(URI newurl, String pagename) throws IOException {
    public String fetchPageSourcefromVimeo(String newurl) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        int returnresponse;
        int count = 0;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Cache-Control", "max-age=0");
            httpget.addHeader("Connection", "keep-alive");
            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();

            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("402") || responsestatus.contains("403") || responsestatus.contains("404")
                    || responsestatus.contains("407") || responsestatus.contains("406") || responsestatus.contains("SSLHandshakeException")
                    || responsestatus.contains("999") || responsestatus.contains("504") || responsestatus.contains("505")) {
//                do {
//                    count++;
//                    returnresponse = fetchPageSourcefromClientforVimeo2(newurl, pagename, portNo);
//                    if (returnresponse == 503) {
//                        System.out.println("PROX FAILURE Vimeo");
//                        try {
//                            Thread.sleep(1000);
//                            portNo = generateRandomPort();
//                        } catch (InterruptedException ex) {
//                            java.util.logging.Logger.getLogger(FetchPagewithClientAthentication.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                    if (count > 15) {
//                        fetchPageSourcefromClientforVimeo2(newurl, pagename, portNo);
//                    }
//                } while (returnresponse == 503 || returnresponse == 502);
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    //writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            System.out.println("Exception = " + e);
//            do {
//                count++;
//                returnresponse = fetchPageSourcefromClientforVimeo2(newurl, pagename, portNo);
//                if (returnresponse == 503) {
//                    System.out.println("PROX FAILURE Vimeo Exception");
//                    try {
//                        Thread.sleep(1000);
//                        portNo = generateRandomPort();
//                    } catch (InterruptedException ex) {
//                        java.util.logging.Logger.getLogger(FetchPagewithClientAthentication.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                if (count > 15) {
//                    fetchPageSourcefromClientforVimeo2(newurl, pagename, portNo);
//                }
//            } while (returnresponse == 503 || returnresponse == 502);
        } finally {
            httpclient.close();
        }
        return responsebody;
    }

    public int fetchPageSourcefromClientforVimeo2(URI newurl, String pagename, int portNo) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Cache-Control", "max-age=0");
            httpget.addHeader("Connection", "keep-alive");
//            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
                    || responsestatus.contains("407") || responsestatus.contains("406") || responsestatus.contains("SSLHandshakeException")
                    || responsestatus.contains("999") || responsestatus.contains("504") || responsestatus.contains("505")) {
                return 503;
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            return 503;
        } finally {
            httpclient.close();
        }
        return 0;
    }

    public void fetchPageSourceFromMetacafe(URI newurl, String pagename) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        int returnresponse;
        int count = 0;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Cache-Control", "max-age=0");
            httpget.addHeader("Connection", "keep-alive");
            System.out.println("Response status" + httpget.getRequestLine());

            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("402") || responsestatus.contains("403") || responsestatus.contains("404")
                    || responsestatus.contains("407") || responsestatus.contains("406") || responsestatus.contains("SSLHandshakeException")
                    || responsestatus.contains("999") || responsestatus.contains("504") || responsestatus.contains("505")) {
                do {
                    count++;
                    returnresponse = fetchPageSourceFromMetcafe2(newurl, pagename, portno);
                    if (returnresponse == 503) {
                        System.out.println("PROX FAILURE");
                    }
                    if (count > 15) {
                        fetchPageSourcefromClientPlain(newurl, pagename);
                    }
                } while (returnresponse == 503 || returnresponse == 502);
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            System.out.println("Exception = " + e);
            do {
                count++;
                returnresponse = fetchPageSourceFromMetcafe2(newurl, pagename, portno);
                if (returnresponse == 503) {
                    System.out.println("PROX FAILURE");
                }
                if (count > 15) {
                    fetchPageSourcefromClientPlain(newurl, pagename);
                }
            } while (returnresponse == 503 || returnresponse == 502);
        } finally {
            httpclient.close();
        }
    }

    public int fetchPageSourceFromMetcafe2(URI newurl, String pagename, int portNo) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Cache-Control", "max-age=0");
            httpget.addHeader("Connection", "keep-alive");
//            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
                    || responsestatus.contains("407") || responsestatus.contains("406") || responsestatus.contains("SSLHandshakeException")
                    || responsestatus.contains("999") || responsestatus.contains("504") || responsestatus.contains("505")) {
                return 503;
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            return 503;
        } finally {
            httpclient.close();
        }
        return 0;
    }

    public String fetchPageSourcefromYoutube(URI newurl) throws IOException, InterruptedException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        int returnresponse;
        int count = 0;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Connection", "keep-alive");
//            httpget.addHeader("Host","www.google.com");
//            httpget.addHeader("Referer","https://www.google.com/webhp?hl=en");
//            RequestConfig requestConfig = RequestConfig.custom()
//                    .setSocketTimeout(5000)
//                    .setConnectTimeout(5000)
//                    .setConnectionRequestTimeout(5000)
//                    .build();
//            httpget.setConfig(requestConfig);
            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("403")
                    || responsestatus.contains("400") || responsestatus.contains("407") || responsestatus.contains("401")
                    || responsestatus.contains("402") || responsestatus.contains("404") || responsestatus.contains("405")
                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")
                    || responsestatus.contains("ClientProtocolException") || responsestatus.contains("SocketTimeoutException")
                    || "".equals(responsestatus)) {
                Thread.sleep(10000);
                do {
                    count++;
                    responsebody = fetchPageSourcefromClientforYoutube2(newurl);
                    if (responsebody == null) {
                        Thread.sleep(10000);
                        System.out.println("PROX FAILURE");
                    }
                    if (count > 20) {
//                            Thread.sleep(1000);
                        break;
                    }
                } while (responsebody == null || "".equals(responsebody));
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    // writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            System.out.println("Exception = " + e);
            do {
                count++;
                responsebody = fetchPageSourcefromClientforYoutube2(newurl);
                if (responsebody == null) {
                    System.out.println("PROX FAILURE");
                }
                if (count > 15) {
                    Thread.sleep(50000);
                    responsebody = fetchPageSourcefromClientforYoutube2(newurl);
                }
            } while (responsebody == null || "".equals(responsebody));
        } finally {
            httpclient.close();
        }
        return responsebody;
    }

    public String fetchPageSourcefromClientforYoutube2(URI newurl) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Connection", "keep-alive");
//             RequestConfig requestConfig = RequestConfig.custom()
//                    .setSocketTimeout(5000)
//                    .setConnectTimeout(5000)
//                    .setConnectionRequestTimeout(5000)
//                    .build();
//            httpget.setConfig(requestConfig);
            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
                    || responsestatus.contains("407") || responsestatus.contains("404") || responsestatus.contains("405")
                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")
                    || responsestatus.contains("ClientProtocolException") || responsestatus.contains("SocketTimeoutException")
                    || responsestatus == null || "".equals(responsestatus)) {
                return null;
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    // writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            return null;
        } finally {
            httpclient.close();
        }
        return responsebody;
    }

    public String fetchPageSourcefromDailymotion(URI newurl) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Connection", "keep-alive");
            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            HttpEntity entity = resp.getEntity();
            System.out.println(resp.getStatusLine());
            if (entity != null) {
                System.out.println("Response content length: " + entity.getContentLength());
                BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                }
            }
            EntityUtils.consume(entity);
        } finally {
            httpclient.close();
        }
        return responsebody;
    }

    public int fetchPageSourcefromClientforDailymotion2(URI newurl, String pagename, int portNo) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Cache-Control", "max-age=0");
            httpget.addHeader("Connection", "keep-alive");
//            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
                    || responsestatus.contains("407") || responsestatus.contains("406") || responsestatus.contains("SSLHandshakeException")
                    || responsestatus.contains("999") || responsestatus.contains("504") || responsestatus.contains("505")) {
                return 503;
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            return 503;
        } finally {
            httpclient.close();
        }
        return 0;
    }

    public void fetchPageForCheckingIfSiteDown(String host, String clientemail) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        String responsestatus = null;
        try {
            host = "http://" + host;
            HttpGet httpget = new HttpGet(host);
            SendMail sendmail = new SendMail();

            System.out.println("Response status" + httpget.getRequestLine());

            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();

            System.out.println("respsttus =: " + responsestatus);

            if ((responsestatus.contains("400")) || (responsestatus.contains("401")) || (responsestatus.contains("402"))
                    || (responsestatus.contains("403")) || (responsestatus.contains("404"))) {
                System.out.println("Site is Down or Not Found");
                sendmail.sendMailForSite(host, clientemail);
            }
//            else if (responsestatus.contains("503")) {
//                fetchPageForCheckingIfSiteDown(host, clientemail);
//            }

            //    httpget.abort();
        } catch (IllegalStateException e) {
            System.out.println("Exception = " + e);
        } finally {
            httpclient.close();
        }
    }

    public String fetchPageSourcewithProxywithoutFile(String newurl) throws IOException {
        String[] proxyinfo = getProxyDetails().split(":");
        String ip = proxyinfo[0];
        int portno = Integer.parseInt(proxyinfo[1]);
        String username = proxyinfo[2];
        String password = proxyinfo[3];

        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope(ip, portno),
                new UsernamePasswordCredentials(username, password));
        HttpHost proxy = new HttpHost(ip, portno);
        //-----------------------------------------------------------------------
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {
            HttpGet httpget = new HttpGet(newurl);
            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")) {
                //return 503;
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    //writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);

            }
        } catch (IOException | IllegalStateException e) {
            //return 503;
        } finally {
            httpclient.close();
        }
        return responsebody;
    }

    public String getProxyDetails() {
        String proxy = "";
        try {
            // Open the file 
            FileInputStream fstream = new FileInputStream("Proxy.txt");
            ArrayList<String> lines;
            try (DataInputStream in = new DataInputStream(fstream)) {
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                lines = new ArrayList<>();
                String line = null;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }
            // Choose a random one from the list
            proxy = lines.get(new Random().nextInt(lines.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proxy;
    }
}
