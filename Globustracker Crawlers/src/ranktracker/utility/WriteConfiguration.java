/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Kalpana Nagle<kalpana@globussft.com>
 */
public class WriteConfiguration {

    public static void writeProperties(Integer sKeywordId, Integer eKeywordId, Integer sTrackId, Integer eTrackId) {
        try {

            String content = "sKeywordId=" + sKeywordId + "\neKeywordId=" + eKeywordId + "\nsTrackId=" + sTrackId + "\neTrackId=" + eTrackId;
            File file = new File("crawlerRunningParameter.properties");
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
