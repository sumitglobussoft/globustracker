/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author user
 */
// note:  This code uses UserAgentsGoogle.txt, UserAgentsYahoo.txt & UserAgentsBing.txt which should be placed in directory ranktracker_crawler_google
// beside to crawlerRunningParameter.properties file in server
public class UserAgents {

    public static String getRandomUserAgent() {
        String ua = "";
        try {
            // Open the file 
            FileInputStream fstream = new FileInputStream("UserAgents.txt");
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
            ua = lines.get(new Random().nextInt(lines.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ua;
    }
    
    public static String getRandomUserAgentGoogle() {
        String ua = "";
        try {
            // Open the file 
            FileInputStream fstream = new FileInputStream("UserAgentsGoogle.txt");
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
            ua = lines.get(new Random().nextInt(lines.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ua;
    }

    public static String getRandomUserAgentYahoo() {
        String ua = "";
        try {
            // Open the file 
            FileInputStream fstream = new FileInputStream("UserAgentsYahoo.txt");
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
            ua = lines.get(new Random().nextInt(lines.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ua;
    }

    public static String getRandomUserAgentBing() {
        String ua = "";
        try {
            // Open the file 
            FileInputStream fstream = new FileInputStream("UserAgentsBing.txt");
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
            ua = lines.get(new Random().nextInt(lines.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ua;
    }
}
