package globuswoo.crawlers;

import java.net.InetAddress;
import java.net.URL;

public class UrlExistance {

    public static boolean getExistance(String url) {

        try {
            
            InetAddress address = InetAddress.getByName(new URL(url).getHost());
            String ipaddress = address.getHostAddress();
            //System.out.println("SERVER IP ADDRESS : " + ipaddress);
            
        } catch (Exception ex) {
            //System.out.println("EX-- "+ex);
            return false;
        }

        return true;
    }
}
