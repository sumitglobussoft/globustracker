package globuswoo.crawlers;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class KeywordsConsistency extends Thread{

    public ArrayList<String> kname2 = new ArrayList<>();

    public ArrayList<String> kname = new ArrayList<>();
    public ArrayList<String> kfreq = new ArrayList<>();
    public ArrayList<String> ktitle = new ArrayList<>();
    public ArrayList<String> kdesc = new ArrayList<>();
    public ArrayList<String> khead = new ArrayList<>();

    Thread t = new Thread("KeywordsConsistency");
    String description;
    String title;
    String heading;
    Document doc;
    ArrayList<String> keywords;
    
    @Override
    public void run(){
    
         kname2 = keywords;

        for (int i = 0; i < kname2.size(); i++) {
            String temp = getfreq(doc, kname2.get(i));
            if (!temp.equals("NA")) {
                kname.add("" + kname2.get(i));
                kfreq.add("" + temp);
                ktitle.add("" + getTitle(title, kname2.get(i)));
                khead.add("" + getHeading(heading, kname2.get(i)));
                kdesc.add("" + getDesc(description, kname2.get(i)));
            }
        }
    }
    
//    public static void main(String[] args) throws IOException {
//        Document doc = Jsoup.connect("http://www.amazon.com").get();
//        ArrayList<String> keywords = new ArrayList<>();
//        String title = "NA";
//        String description = "NA";
//        HeadingStructure hs = new HeadingStructure();
//        String allheadings = "NA";
//
//     //   hs.setElements(doc);
//       // allheadings = hs.getAllHeadings();
//
//        try {
//            String temp[] = doc.select("meta[name=keywords]").attr("content").split(",");
//            for (int i = 0; i < temp.length; i++) {
//                keywords.add("" + temp[i]);
//
//            }
//        } catch (Exception e) {
//        }
//
//        try {
//            title = doc.title() + "";
//
//        } catch (Exception e) {
//        }
//
////******************************Description*************************************
//        try {
//            description = doc.select("meta[name=description]").attr("content");
//        } catch (Exception e) {
//        }
//
//        System.out.println("[#]TITLE: " + doc.title());
//
//        System.out.println("[#]DESCRIPTION: " + description);
//
//        System.out.println("[#]Keywords" + keywords);
//        System.out.println("[#]All Headings " + allheadings);
//
//        (new KeywordsConsistency()).setKeywordConsistency(keywords, description, title, allheadings, doc);
//
//    }

    public void setKeywordConsistency(ArrayList<String> keywords, String description,
            String title, String heading, Document doc) {

//        this.keywords=keywords;
//        this.title=title;
//        this.description=description;
//        this.heading=heading;
//        this.doc=doc;
//        t.start();
//        System.out.println("" + t.getName() + "IS RUNNING");
        
        kname2 = keywords;

        for (int i = 0; i < kname2.size(); i++) {
            String temp = getfreq(doc, kname2.get(i));
            if (!temp.equals("NA")) {
                kname.add("" + kname2.get(i));
                kfreq.add("" + temp);
                ktitle.add("" + getTitle(title, kname2.get(i)));
                khead.add("" + getHeading(heading, kname2.get(i)));
                kdesc.add("" + getDesc(description, kname2.get(i)));
            }
        }
        
    }

    public void disp() {

        for (int i = 0; i < kname.size(); i++) {
            System.out.println("-----------------------");
            System.out.println("NAME: " + kname.get(i));
            System.out.println("FREQ:" + kfreq.get(i));
            System.out.println("TITLE:" + ktitle.get(i));
            System.out.println("HEADING:" + khead.get(i));
            System.out.println("DESCRIPTION:" + kdesc.get(i));
        }
    }

    public String getDesc(String title, String key) {
        String temp = "No";

        title = title.toLowerCase();
        key = key.toLowerCase();

        if (title.contains(key)) {
            temp = "Yes";
        }
        return temp;
    }

    public String getTitle(String title, String key) {
        String temp = "No";

        title = title.toLowerCase();
        key = key.toLowerCase();

        if (title.contains(key)) {
            temp = "Yes";
        }

        return temp;
    }

    public String getHeading(String title, String key) {
        String temp = "No";

        title = title.toLowerCase();
        key = key.toLowerCase();

        if (title.contains(key)) {
            temp = "Yes";
        }

        return temp;
    }

    public String getfreq(Document doc, String key) {
        String freq = "NA";
        int count = 0;
        try {

            String str = doc.text() + "";
            String findStr = key;

            str = str.toLowerCase();
            findStr = findStr.toLowerCase();

            int lastIndex = 0;

            while (lastIndex != -1) {

                lastIndex = str.indexOf(findStr, lastIndex);

                if (lastIndex != -1) {
                    count++;
                    lastIndex += findStr.length();
                }
            }
            if (count > 0) {
                freq = "" + count;
            }

        } catch (Exception e) {

        }
        return freq;
    }
}
