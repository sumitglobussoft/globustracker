package globuswoo.crawlers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class MobileRendering {

    public String imageUrl;
    public String str = null;
    public String url_Domain = "NA";
    public String iphoneView1 = "NA";
    public String ipadView1 = "NA";
    public String dashboardImage1 = "NA";
    public String usabilityImage1 = "NA";

    public String saveImage(String getUrl_Domain) throws IOException {

        System.out.println("------------------------------------------" + getUrl_Domain);

        try {
            str = this.getClass().getClassLoader().getResource("").getPath();
            System.out.println("----------------" + str + "temp/");
            if (str.contains("%20")) {
                str = str.replaceAll("%20", " ");
                System.out.println(str);
            }
        } catch (Exception e) {
            str = System.getProperty("user.dir");
        }

//*******************************CODE FOR IPHONE IMAGE**************************
        try {
            url_Domain = getUrl_Domain.replace("http://www.", "");
            iphoneView1 = "http://s3.amazonaws.com/woothumbs/" + url_Domain + ".iphone.png";
            URL url = new URL(iphoneView1);
            String fileName = url.getFile();
            String destName = str + "temp" + fileName.substring(fileName.lastIndexOf("/"));
            System.out.println(destName);

            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destName);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (Exception e) {
        }
//*******************************CODE FOR IPAD IMAGE**************************
        try {
            url_Domain = getUrl_Domain.replace("http://www.", "");
            ipadView1 = "http://s3.amazonaws.com/woothumbs/" + url_Domain + ".ipad.png";
            URL url1 = new URL(ipadView1);
            String fileName1 = url1.getFile();
            String destName1 = str + "temp" + fileName1.substring(fileName1.lastIndexOf("/"));
            System.out.println(destName1);

            InputStream is1 = url1.openStream();
            OutputStream os1 = new FileOutputStream(destName1);

            byte[] b1 = new byte[2048];
            int length1;

            while ((length1 = is1.read(b1)) != -1) {
                os1.write(b1, 0, length1);
            }

            is1.close();
            os1.close();
        } catch (Exception e) {
        }
//*******************************CODE FOR DASHBOARD IMAGE***********************
        try {
            url_Domain = getUrl_Domain.replace("http://www.", "");
            dashboardImage1 = "http://s3.amazonaws.com/woothumbs/" + url_Domain + ".png";
            URL url2 = new URL(dashboardImage1);
            String fileName2 = url2.getFile();
            String destName2 = str + "temp" + fileName2.substring(fileName2.lastIndexOf("/"));
            System.out.println(destName2);

            InputStream is2 = url2.openStream();
            OutputStream os2 = new FileOutputStream(destName2);

            byte[] b2 = new byte[2048];
            int length2;

            while ((length2 = is2.read(b2)) != -1) {
                os2.write(b2, 0, length2);
            }

            is2.close();
            os2.close();
        } catch (Exception e) {
        }
        return str;
    }
}
