package globuswoo.crawlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.SocketException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.net.whois.WhoisClient;

public class DomainInformation extends Thread {

    private static Pattern pattern;
    private Matcher matcher;
    Thread t = new Thread("DomainInformation");
    String url;

    public void run() {
        String temp1 = url.replace("http://", "");
        String temp2 = temp1.replace("www.", "");
        String temp3 = temp2.replace("https://", "");
        url = temp3;
        //System.out.println("URL INFO: " + url);
        String info = (new DomainInformation()).getWhois("" + url);

        try {

            BufferedReader br = new BufferedReader(new StringReader("" + info));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                if (strLine.contains("Updated Date")) {
                    String buf[] = strLine.split(":");
                    updated_date = buf[1];
                } else if (strLine.contains("Creation Date")) {
                    String buf[] = strLine.split(":");
                    created_date = buf[1];
                } else if (strLine.contains("Expiration Date")) {
                    String buf[] = strLine.split(":");
                    expited_date = buf[1];
                }
            }

            br.close();
        } catch (Exception qw) {
        }
    }
//***************************REGEX WHOIS PARSER*********************************
    private static final String WHOIS_SERVER_PATTERN = "Whois Server:\\s(.*)";

    static {
        pattern = Pattern.compile(WHOIS_SERVER_PATTERN);
    }

    public String updated_date = "NA";
    public String created_date = "NA";
    public String expited_date = "NA";
   
    public void setInfo(String url) {
        
        String temp1 = url.replace("http://", "");
        String temp2 = temp1.replace("www.", "");
        String temp3 = temp2.replace("https://", "");
        url = temp3;

        String info = (new DomainInformation()).getWhois("" + url);

        try {

            BufferedReader br = new BufferedReader(new StringReader("" + info));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                if (strLine.contains("Updated Date")) {
                    String buf[] = strLine.split(":");
                    updated_date = buf[1];
                } else if (strLine.contains("Creation Date")) {
                    String buf[] = strLine.split(":");
                    created_date = buf[1];
                } else if (strLine.contains("Expiration Date")) {
                    String buf[] = strLine.split(":");
                    expited_date = buf[1];
                }
            }

            br.close();
        } catch (Exception qw) {
        }

    }

//***********************************example google.com*************************
    public String getWhois(String domainName) {

        StringBuilder result = new StringBuilder("");

        WhoisClient whois = new WhoisClient();
        try {

            whois.connect(WhoisClient.DEFAULT_HOST);

            // whois =google.com
            String whoisData1 = whois.query("=" + domainName);

            // append first result
            result.append(whoisData1);
            whois.disconnect();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
