/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.get.post.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Nitesh Shah
 */
public class FetchSource {

    public HttpsURLConnection conn;
    private List<String> cookies = new ArrayList<>();
    public List<Cookie> lstCookie = new ArrayList<>();
    List<Cookie> lstCookieDuplicate = new ArrayList<>();
    List<Cookie> lstCookieForCurrentuse = new ArrayList<>();
    List<String> cookieNames = new ArrayList<>();

    public FetchSource() {
        System.out.println("Created PostFetchSource object");
    }

    public String fetchPageSourceWithoutProxyPOST(String newurl, String urlParameter, String referer, String host) throws IOException {
        int sizofPostParam = 0;
        String a[] = urlParameter.split("&");
        sizofPostParam = a.length;
        System.out.println("checking post data");

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(50000)
                .setConnectTimeout(50000)
                .setConnectionRequestTimeout(50000)
                .build();

        CloseableHttpClient httpclient = HttpClients.custom()
                .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0")
                .setDefaultRequestConfig(requestConfig)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {

            HttpPost httppost = new HttpPost(newurl);
            if (host != null || host != "") {
                httppost.addHeader("Host", host);
            }
            httppost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0");
            httppost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httppost.addHeader("Accept-Language", "en-US,en;q=0.5");
            httppost.addHeader("Accept-Encoding", "gzip, deflate");

            if (newurl.equals("http://iconosquare.com/controller_ajax.php")) {
                httppost.addHeader("X-Requested-With", "XMLHttpRequest");
                httppost.addHeader("Pragma", "no-cache");
                httppost.addHeader("Cache-Control", "no-cache");
            }
            if (referer != null || referer != "") {
                httppost.addHeader("Referer", referer);
            }

            httppost.addHeader("Connection", "keep-alive");
            httppost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            ArrayList<NameValuePair> postParameters;
            postParameters = new ArrayList<>(sizofPostParam);
            for (int i = 0; i < sizofPostParam; i++) {
                postParameters.add(new BasicNameValuePair(a[i].split("=")[0], a[i].split("=")[1]));
            }
            httppost.setEntity(new UrlEncodedFormEntity(postParameters));

            HttpClientContext context = HttpClientContext.create();
            CookieStore cookieStore = new BasicCookieStore();

            if (lstCookie != null) {
                for (Cookie postParameter : lstCookie) {
                    cookieStore.addCookie(postParameter);
                }
                context.setCookieStore(cookieStore);
            }

            CloseableHttpResponse resp = httpclient.execute(httppost, context);
            System.out.println("  POST METHOD  ");
            System.out.println("1. Response status : " + httppost.getRequestLine());
            System.out.println("2. Response Code   : " + resp.getStatusLine().getStatusCode());
            responsestatus = resp.getStatusLine().toString();

            List<Cookie> lstCookieForHere = context.getCookieStore().getCookies();
            if (lstCookieDuplicate != null) {
                lstCookieDuplicate.clear();
            }

            for (Cookie lstCookieForHere2 : lstCookieForHere) {
                boolean isfound = false;
                try {
                    for (Cookie lstCookieForHere1 : lstCookie) {
                        if (lstCookieForHere1.getName().equals(lstCookieForHere2.getName())) {
                            isfound = true;
                            lstCookieDuplicate.add(lstCookieForHere2);
                            lstCookieForCurrentuse.add(lstCookieForHere1);
                            break;
                        }
                    }
                    if (!isfound) {
                        lstCookie.add(lstCookieForHere2);
                    }
                } catch (Exception Ex) {
                    lstCookie.add(lstCookieForHere2);
                }
            }

            if (lstCookieForCurrentuse != null) {
                for (Cookie lstCookieForHere1 : lstCookieForCurrentuse) {
                    lstCookie.remove(lstCookieForHere1);
                }
            }

            if (lstCookieDuplicate != null) {
                for (Cookie lstCookieForHere1 : lstCookieDuplicate) {
                    lstCookie.add(lstCookieForHere1);
                }
            }

            Header[] CookieData = resp.getAllHeaders();
            for (Header CookieData1 : CookieData) {
                String valCheck = CookieData1.getName();
                if ("Location".equals(CookieData1.getName())) {
                    return "redirect Url :" + CookieData1.getValue();
                }

            }

            System.out.println("3. Response Status Code : " + responsestatus);

            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
                    || responsestatus.contains("407") || responsestatus.contains("404") || responsestatus.contains("405")
                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")
                    || responsestatus.contains("ClientProtocolException") || responsestatus.contains("SocketTimeoutException")
                    || responsestatus == null || "".equals(responsestatus)) {
                return null;
            } else {
                HttpEntity entity = resp.getEntity();
                long aa = entity.getContentLength();
                if (entity != null) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();

                    }

                }
                EntityUtils.consume(entity);
            }

        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
            return null;
        } finally {
            httpclient.close();
        }

        return responsebody;
    }

    public String fetchPageSourceWithProxyPOST(String newurl, String urlParameter, String referer, String host, String proxyIP, String proxyPort, String proxyUsername, String proxyPassword) throws IOException {

        String resCode = "";
        CredentialsProvider credsprovider = new BasicCredentialsProvider();

        int proxyPortInt = Integer.parseInt(proxyPort);
        int sizofPostParam = 0;
        String a[] = urlParameter.split("&");
        sizofPostParam = a.length;
        System.out.println("checking post data");

        credsprovider.setCredentials(
                new AuthScope(proxyIP, proxyPortInt),
                new UsernamePasswordCredentials(proxyUsername, proxyPassword));
        HttpHost proxy = new HttpHost(proxyIP, proxyPortInt);
        //----------------------------------------------------------------------
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(50000)
                .setConnectTimeout(50000)
                .setConnectionRequestTimeout(50000)
                .build();

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0")
                .setDefaultRequestConfig(requestConfig)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {

            HttpPost httppost = new HttpPost(newurl);
            if (host != null || host != "") {
                httppost.addHeader("Host", host);
            }
            httppost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0");
            httppost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httppost.addHeader("Accept-Language", "en-US,en;q=0.5");
            httppost.addHeader("Accept-Encoding", "gzip, deflate");

            if (referer != null || referer != "") {
                httppost.addHeader("Referer", referer);
            }

            httppost.addHeader("Connection", "keep-alive");
            httppost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            ArrayList<NameValuePair> postParameters;
            postParameters = new ArrayList<>(sizofPostParam);
            for (int i = 0; i < sizofPostParam; i++) {
                postParameters.add(new BasicNameValuePair(a[i].split("=")[0], a[i].split("=")[1]));
            }
            httppost.setEntity(new UrlEncodedFormEntity(postParameters));

            HttpClientContext context = HttpClientContext.create();
            CookieStore cookieStore = new BasicCookieStore();

            if (lstCookie != null) {
                for (Cookie postParameter : lstCookie) {
                    cookieStore.addCookie(postParameter);
                }
                context.setCookieStore(cookieStore);
            }

            CloseableHttpResponse resp = httpclient.execute(httppost, context);
            System.out.println("  POST METHOD  ");
            System.out.println("1. Response status : " + httppost.getRequestLine());
            System.out.println("2. Response Code   : " + resp.getStatusLine().getStatusCode());
            resCode = "" + resp.getStatusLine().getStatusCode();
            responsestatus = resp.getStatusLine().toString();

            List<Cookie> lstCookieForHere = context.getCookieStore().getCookies();
            if (lstCookieDuplicate != null) {
                lstCookieDuplicate.clear();
            }

            for (Cookie lstCookieForHere2 : lstCookieForHere) {
                boolean isfound = false;
                try {
                    for (Cookie lstCookieForHere1 : lstCookie) {
                        if (lstCookieForHere1.getName().equals(lstCookieForHere2.getName())) {
                            isfound = true;
                            lstCookieDuplicate.add(lstCookieForHere2);
                            lstCookieForCurrentuse.add(lstCookieForHere1);
                            break;
                        }
                    }
                    if (!isfound) {
                        lstCookie.add(lstCookieForHere2);
                    }
                } catch (Exception Ex) {
                    lstCookie.add(lstCookieForHere2);
                }
            }

            if (lstCookieForCurrentuse != null) {
                for (Cookie lstCookieForHere1 : lstCookieForCurrentuse) {
                    lstCookie.remove(lstCookieForHere1);
                }
            }

            if (lstCookieDuplicate != null) {
                for (Cookie lstCookieForHere1 : lstCookieDuplicate) {
                    lstCookie.add(lstCookieForHere1);
                }
            }

            Header[] CookieData = resp.getAllHeaders();
            for (Header CookieData1 : CookieData) {
                String valCheck = CookieData1.getName();
                if ("Location".equals(CookieData1.getName())) {
                    // getSourceWithProxy(CookieData1.getValue());
                    return "redirect Url :" + CookieData1.getValue();
                }

            }

            System.out.println("3. Response Status Code : " + responsestatus);

            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
                    || responsestatus.contains("407") || responsestatus.contains("404") || responsestatus.contains("405")
                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")
                    || responsestatus.contains("ClientProtocolException") || responsestatus.contains("SocketTimeoutException")
                    || responsestatus == null || "".equals(responsestatus)) {
                return null;
            } else {
                HttpEntity entity = resp.getEntity();
                long aa = entity.getContentLength();
                if (entity != null) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();

                    }

                }
                EntityUtils.consume(entity);
            }

        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
            return null;
        } finally {
            httpclient.close();
        }

        return responsebody;
    }

    public static int generateRandomPort() {

        int portNo;
        Random random = new Random();
        int[] portList = new int[98];
        int portBegin = 1601;   //1601

        for (int k = 0; k < portList.length; k++) {
            portList[k] = portBegin;
            portBegin = portBegin + 1;
        }

        int num = random.nextInt(98);
        portNo = portList[num];
        return portNo;
    }

    public String fetchPageSourceWithoutProxyGET(String newurl, String referer, String Host) throws IOException {

        Random r = new Random();
        String resCode = "";

        //----------------------------------------------------------------------
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(50000)
                .setConnectTimeout(50000)
                .setConnectionRequestTimeout(50000)
                .build();

        CloseableHttpClient httpclient = HttpClients.custom()
                //                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0")
                .setDefaultRequestConfig(requestConfig)
                //                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {
//            httpclient.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);

            HttpGet httpget = new HttpGet(newurl);
            if (Host != null || Host != "") {
                httpget.addHeader("Host", Host);
            }
            httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0");
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            if (referer != null || referer != "") {

                httpget.addHeader("Referer", referer);
            }
            httpget.addHeader("Connection", "keep-alive");

            HttpClientContext context = HttpClientContext.create();
            CookieStore cookieStore = new BasicCookieStore();

            if (lstCookie != null) {
                for (Cookie postParameter : lstCookie) {
                    cookieStore.addCookie(postParameter);
                }
                context.setCookieStore(cookieStore);
            }
            CloseableHttpResponse resp = null;
            try {
                resp = httpclient.execute(httpget, context);
            } catch (Exception e) {
                System.out.println("error::::::");
//                e.printStackTrace();
            };

            List<Cookie> lstCookieForHere = context.getCookieStore().getCookies();
            if (lstCookieDuplicate != null) {
                lstCookieDuplicate.clear();
            }

            for (Cookie lstCookieForHere2 : lstCookieForHere) {
                boolean isfound = false;
                try {
                    for (Cookie lstCookieForHere1 : lstCookie) {
                        if (lstCookieForHere1.getName().equals(lstCookieForHere2.getName())) {
                            isfound = true;
                            lstCookieDuplicate.add(lstCookieForHere2);
                            lstCookieForCurrentuse.add(lstCookieForHere1);
                            break;
                        }
                    }
                    if (!isfound) {
                        lstCookie.add(lstCookieForHere2);
                    }
                } catch (Exception Ex) {
                    lstCookie.add(lstCookieForHere2);
                }
            }

            if (lstCookieForCurrentuse != null) {
                for (Cookie lstCookieForHere1 : lstCookieForCurrentuse) {
                    lstCookie.remove(lstCookieForHere1);
                }
            }

            if (lstCookieDuplicate != null) {
                for (Cookie lstCookieForHere1 : lstCookieDuplicate) {
                    lstCookie.add(lstCookieForHere1);
                }
            }

            System.out.println("  GET METHOD  ");
            System.out.println("1. Response status : " + httpget.getRequestLine());
            System.out.println("2. Response Code   : " + resp.getStatusLine().getStatusCode());
            resCode = "" + resp.getStatusLine().getStatusCode();
            responsestatus = resp.getStatusLine().toString();

            Header[] CookieData = resp.getAllHeaders();
            for (Header CookieData1 : CookieData) {

                if (CookieData1.getName() == "Location") {
                    // getSourceWithProxy(CookieData1.getValue(),"","");
                    return "redirect Url :" + CookieData1.getValue();
                }

            }

            System.out.println("3. Response Status Code : " + responsestatus);

            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
                    || responsestatus.contains("407") || responsestatus.contains("404") || responsestatus.contains("405")
                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")
                    || responsestatus.contains("ClientProtocolException") || responsestatus.contains("SocketTimeoutException")
                    || responsestatus == null || "".equals(responsestatus)) {
                return null;
            } else {
                HttpEntity entity = resp.getEntity();
                if (entity != null) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
//                        System.out.println("Response Body : " + responsebody);
                    }
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

    public String fetchPageSourceWithProxyGET(String newurl, String referer, String Host, String proxyIP, String proxyPort, String proxyUsername, String proxyPassword) throws IOException {

        int proxyPortInt = Integer.parseInt(proxyPort);

        String resCode = "";
        CredentialsProvider credsprovider = new BasicCredentialsProvider();

        credsprovider.setCredentials(
                new AuthScope(proxyIP, proxyPortInt),
                new UsernamePasswordCredentials(proxyUsername, proxyPassword));
        HttpHost proxy = new HttpHost(proxyIP, proxyPortInt);
        //----------------------------------------------------------------------
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(50000)
                .setConnectTimeout(50000)
                .setConnectionRequestTimeout(50000)
                .build();

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0")
                .setDefaultRequestConfig(requestConfig)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        try {

            HttpGet httpget = new HttpGet(newurl);
            if (Host != null || Host != "") {
                httpget.addHeader("Host", Host);
            }
            httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0");
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            if (referer != null || referer != "") {

                httpget.addHeader("Referer", referer);
            }
            httpget.addHeader("Connection", "keep-alive");

            HttpClientContext context = HttpClientContext.create();
            CookieStore cookieStore = new BasicCookieStore();

            if (lstCookie != null) {
                for (Cookie postParameter : lstCookie) {
                    cookieStore.addCookie(postParameter);
                }
                context.setCookieStore(cookieStore);
            }
            CloseableHttpResponse resp = null;
            try {
                resp = httpclient.execute(httpget, context);
            } catch (Exception e) {
                System.out.println("error::::::");
//                e.printStackTrace();
            };

            List<Cookie> lstCookieForHere = context.getCookieStore().getCookies();
            if (lstCookieDuplicate != null) {
                lstCookieDuplicate.clear();
            }

            for (Cookie lstCookieForHere2 : lstCookieForHere) {
                boolean isfound = false;
                try {
                    for (Cookie lstCookieForHere1 : lstCookie) {
                        if (lstCookieForHere1.getName().equals(lstCookieForHere2.getName())) {
                            isfound = true;
                            lstCookieDuplicate.add(lstCookieForHere2);
                            lstCookieForCurrentuse.add(lstCookieForHere1);
                            break;
                        }
                    }
                    if (!isfound) {
                        lstCookie.add(lstCookieForHere2);
                    }
                } catch (Exception Ex) {
                    lstCookie.add(lstCookieForHere2);
                }
            }

            if (lstCookieForCurrentuse != null) {
                for (Cookie lstCookieForHere1 : lstCookieForCurrentuse) {
                    lstCookie.remove(lstCookieForHere1);
                }
            }

            if (lstCookieDuplicate != null) {
                for (Cookie lstCookieForHere1 : lstCookieDuplicate) {
                    lstCookie.add(lstCookieForHere1);
                }
            }

            System.out.println("  GET METHOD  ");
            System.out.println("1. Response status : " + httpget.getRequestLine());
            System.out.println("2. Response Code   : " + resp.getStatusLine().getStatusCode());
            resCode = "" + resp.getStatusLine().getStatusCode();
            responsestatus = resp.getStatusLine().toString();

            Header[] CookieData = resp.getAllHeaders();
            for (Header CookieData1 : CookieData) {

                if (CookieData1.getName() == "Location") {
                    // getSourceWithProxy(CookieData1.getValue(),"","");
                    return "redirect Url :" + CookieData1.getValue();
                }

            }

            System.out.println("3. Response Status Code : " + responsestatus);

            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
                    || responsestatus.contains("407") || responsestatus.contains("404") || responsestatus.contains("405")
                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")
                    || responsestatus.contains("ClientProtocolException") || responsestatus.contains("SocketTimeoutException")
                    || responsestatus == null || "".equals(responsestatus)) {
                return null;
            } else {
                HttpEntity entity = resp.getEntity();
                if (entity != null) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
//                        System.out.println("Response Body : " + responsebody);
                    }
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

}
