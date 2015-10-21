package globuswoo.crawlers;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP_Address extends Thread {

    public String IP_address = "NA";
    public String Analytics = "NA";
    public String Doctype = "NA";
    public String Encoding = "NA";
    public String Directory_Browsing = "NA";
    public String Server_Signature = "NA";
    public String Technology = "NA";
    public String Technology1 = "NA";
    public String Technology2 = "NA";
    public String Technology3 = "NA";


    public void setTechnologiesDetails() {

        InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();
            // System.out.println("Current IP address : " + ip.getHostAddress());
            IP_address = "" + ip.getHostAddress();
            // System.out.println("Analytics : "+"Missing");
            Analytics = "" + "Missing";
            // System.out.println("Doctype :"+" HTML5");
            Doctype = "" + " HTML5";
            // System.out.println("Encoding :"+" UTF-8");
            Encoding = "" + " UTF-8";
            //System.out.println("Directory Browsing :"+" NO");
            Directory_Browsing = "" + " NO";
            // System.out.println("Server Signature :"+" NO");
            Server_Signature = "" + " NO";

            System.out.println("Technology : " + "Apache Tomcat" + "     Web server");
            Technology = "" + "Apache Tomcat" + "     Web server";
            System.out.println("Technology1 : " + "Java" + "     Programming Language");
            Technology1 = "" + "Java" + "     Programming Language";
            System.out.println("Technology2 : " + "jQuery" + "     JavaScript framework");
            Technology2 = "" + "jQuery" + "     JavaScript framework";
            System.out.println("Technology3 : " + "Modernizr" + "     Javascript framework");
            Technology3 = "" + "Modernizr" + "     Javascript framework";

        } catch (UnknownHostException e) {

            e.printStackTrace();
        }

    }
}
