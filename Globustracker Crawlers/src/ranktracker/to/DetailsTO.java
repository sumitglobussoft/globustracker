/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.to;

/**
 *
 * @author Anshuman
 */
public class DetailsTO {

   private String url;
   private String keyword;
   private String linkGoogle;
   private int crawlCount;
   private int keywordID;
   private int trackID;
   private boolean done=false;

   
    public DetailsTO(int keywordID ,String url, String keyword, String linkGoogle ) {
        this.url = url;
        this.keyword = keyword;
        this.linkGoogle = linkGoogle;
        this.crawlCount = 0;
        this.keywordID=keywordID;
    }
  
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getLinkGoogle() {
        return linkGoogle;
    }

    public void setLinkGoogle(String linkGoogle) {
        this.linkGoogle = linkGoogle;
    }

    public int getCrawlCount() {
        return crawlCount;
    }

    public void setCrawlCount(int crawlCount) {
        this.crawlCount = crawlCount;
    }
    
     public int getKeywordID() {
        return keywordID;
    }

    public void setKeywordID(int keywordID) {
        this.keywordID = keywordID;
    }
  
      public int getTrackID() {
        return trackID;
    }

    public void setTrackID(int trackID) {
        this.trackID = trackID;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
  
}
