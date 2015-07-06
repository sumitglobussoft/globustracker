/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.crawlers;

import globuswoo.entity.Commonseo;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author GLB-214
 */
public class Linkedin extends Thread {

    public String linkedFollower = "NA";
    public String linkedImage = "NA";
    public String linkedDescription = "NA";
    public String linkedSpecialties = "NA";
    public String linkedWebsite = "NA";
    public String linkedIndustry = "NA";
    public String linkedType = "NA";
    public String linkedHeadquater = "NA";
    public String linkedCompany = "NA";
    public String linkedFounded = "NA";
    public String linkedEmployee = "NA";
    public Commonseo data;
    public String complete_url;

    Linkedin() {
    }

    Linkedin(Commonseo data, String complete_url) {
        this.data = data;
        this.complete_url = complete_url;
    }

    @Override
    public void run() {
        try {
            setBusinessUrl(data, complete_url);
        } catch (Exception e) {
        }
    }

    public void setBusinessUrl(Commonseo data, String complete_url) throws IOException {

        try {
            System.out.println("   " + complete_url.replace(".com", ""));
            String url = complete_url.replace("http://www.", "").replace(".com", "");
            String googlestring = "https://www.google.com/search?q=" + url + "linkedin";
            System.out.println("    -- Google review Url: " + googlestring);
            Document doc = Jsoup.parse(Crawler.fetchGooglePageRank(googlestring));
            try {
                Element e1 = doc.select("div[class=s] div[class=kv] cite").first();
                System.out.println(" LinkedinUrl : " + e1.text());
                String linkedinurl = e1.text();
                getDetails(linkedinurl, data);
            } catch (Exception e) {
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getDetails(String linkedinurl, Commonseo data) throws IOException {
        try {

            Document doc1 = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy(linkedinurl));
            try {
                Element efollower = doc1.select("div[class=follow-content] p[class=followers-count] strong").first();
                System.out.println("1. Linkedin Follower : " + efollower.text());
                linkedFollower = efollower.text();
            } catch (Exception e) {
            }

            try {
                Element eimage = doc1.select("div[id=content] img").first();
                System.out.println("2. Linkedin Image : " + eimage.attr("src"));
                linkedImage = eimage.attr("src");
            } catch (Exception e) {
            }

            try {
                Element ediscription = doc1.select("dd[class=basic-info-description] p").first();
                System.out.println("3. Linkedin Description : " + ediscription.text());
                linkedDescription = ediscription.text();
            } catch (Exception e) {
            }

            try {
                Element especialties = doc1.select("div[class=specialties] p").first();
                System.out.println("4. Linkedin Specialties : " + especialties.text());
                linkedSpecialties = especialties.text();
            } catch (Exception e) {
            }

            try {
                Element ewebsite = doc1.select("dd[class=basic-info-about] li[class=website] p a").first();
                System.out.println("5. Linkedin Website : " + ewebsite.text());
                linkedWebsite = ewebsite.text();
            } catch (Exception e) {
            }

            try {
                Element eindustry = doc1.select("dd[class=basic-info-about] li[class=industry] p").first();
                System.out.println("6. Linkedin Industry : " + eindustry.text());
                linkedIndustry = eindustry.text();
            } catch (Exception e) {
            }

            try {
                Element etype = doc1.select("dd[class=basic-info-about] li[class=type] p").first();
                System.out.println("7. Linkedin Type : " + etype.text());
                linkedType = etype.text();
            } catch (Exception e) {
            }

            try {
                Element eheadquater = doc1.select("dd[class=basic-info-about] li[class=vcard hq] p").first();
                System.out.println("8. Linkedin headquater : " + eheadquater.text());
                linkedHeadquater = eheadquater.text();
            } catch (Exception e) {
            }

            try {
                Element ecompanysize = doc1.select("dd[class=basic-info-about] li[class=company-size] p").first();
                System.out.println("9. Linkedin Company Size : " + ecompanysize.text());
                linkedCompany = ecompanysize.text();
            } catch (Exception e) {
            }

            try {
                Element efounded = doc1.select("dd[class=basic-info-about] li[class=founded] p").first();
                System.out.println("10. Linkedin Founded : " + efounded.text());
                linkedFounded = efounded.text();
            } catch (Exception e) {
            }

            try {
                Element employe = doc1.select("div[class=company-employees module] a[class=employee-count]").first();
                System.out.println("11. Linkedin Employee : " + employe.text());
                linkedEmployee = employe.text();
            } catch (Exception e) {
            }

            data.setLinkedFollower(linkedFollower);
            data.setLinkedImage(linkedImage);
            data.setLinkedDescription(linkedDescription);
            data.setLinkedSpecialties(linkedSpecialties);
            data.setLinkedWebsite(linkedWebsite);
            data.setLinkedIndustry(linkedIndustry);
            data.setLinkedType(linkedType);
            data.setLinkedHeadquater(linkedHeadquater);
            data.setLinkedCompany(linkedCompany);
            data.setLinkedFounded(linkedFounded);
            data.setLinkedEmployee(linkedEmployee);

        } catch (Exception e) {
        }

    }
}
