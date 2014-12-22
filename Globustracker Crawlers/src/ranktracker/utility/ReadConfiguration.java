/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Kalpana
 * @method readProperties() : read the start keyword id ,end keyword id, start track id and end track id from properties file
 * if signifier crawler has to be run again with the existing start track id and end track id then parameter has to be read from properties file
 */
public class ReadConfiguration {

    public static Integer[] readProperties() {
        Integer[] configuration = new Integer[4];
        try {
            FileInputStream fis = new FileInputStream("crawlerRunningParameter.properties");
            Properties p = new Properties();
            p.load(fis);
            String sKeywordId = p.getProperty("sKeywordId");
            String eKeywordId = p.getProperty("eKeywordId");
            String sTrackId = p.getProperty("sTrackId");
            String eTrackId = p.getProperty("eTrackId");
            configuration[0] = Integer.parseInt(sKeywordId);
            configuration[1] = Integer.parseInt(eKeywordId);
            configuration[2] = Integer.parseInt(sTrackId);
            configuration[3] = Integer.parseInt(eTrackId);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return configuration;
    }

    public static void main(String[] args) {  
        readProperties();
    }
}
