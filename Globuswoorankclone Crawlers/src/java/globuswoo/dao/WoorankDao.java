package globuswoo.dao;

import globuswoo.crawlers.HeadingStructure;
import java.util.List;
import globuswoo.entity.Commonseo;
import globuswoo.entity.Headingcount;
import globuswoo.entity.Headingelements;
import globuswoo.entity.Image;
import globuswoo.entity.Pagelinks;
import globuswoo.entity.Relatedwebsite;
import globuswoo.entity.Technology;
import globuswoo.entity.Visitorarray;
import globuswoo.entity.Xmldata;

public interface WoorankDao {

    public void insertCommonseo(Commonseo objcommonseo);

    public void insertHeading(Headingcount objheadingcount);

    public void insertHeadingElement(Headingelements objHeadingelements);

    public void insertPageLinks(Pagelinks objPagelinks);

    public void insertImage(Image objImage);

    public void insertRelatedWebsite(Relatedwebsite objRelatedwebsite);

    public void insertTechnology(Technology objTechnology);

    public void insertVisitor(Visitorarray objVisitorarray);

    public void insertXmlData(Xmldata objXmldata);

    public Commonseo getCommonSeoDetails(String url);

    public Headingcount getHeadingCountDetails(String url);

    public Headingelements getHeadingelementsDetails(String url);

    public Image getImageDetails(String url);

    public Pagelinks getPagelinksDetails(String url);

    public Relatedwebsite getRelatedwebsiteDetails(String url);

    public Technology getTechnologyDetails(String url);

    public Visitorarray getVisitorarrayDetails(String url);

    public Xmldata getXmldataDetails(String url);

    public void updateCommonseo(int id, String url, String pageRank, String titleLength, String title, String description, String descriptionLength, String flash, String frames, String htmlRatio, String facebookLikes, String facebookAbout, String facebookImage, String takingAbout, String googleImage, String googleFollower, String googleViews, String keyword, String globalRank, String countryRank, String w3cvalidity, String encoding, String doctype, String twitterimage, String twittercount, String twitterfolowing, String twitterfolowrs, String twitterdescrip, String twitterfavorites, String twitterdate, String twitterList, String indexedPages, String backlinksCounter, String mobileLoadTime, String trafficEstimation, String PinterestBoards, String PinterestPins, String PinterestLikes, String PinterestFollower, String PinterestFollowing, String PinterestImage, String PinterestName, String PinterestDescription, String linkedFollower, String linkedImage, String linkedDescription, String linkedSpecialties, String linkedWebsite, String linkedIndustry, String linkedType, String linkedHeadquater, String linkedCompany, String linkedFounded, String linkedEmployee, String aLexaRank, String facebookShareCount, String facebookLikesCount, String facebookComment, String facebookTotalCount, String facebookClickCount, String facebookCommentsBoxCount, String linkedInCount, String pinterestCount, String twitterCounts);

    public void updateHeadingcount(String url, String heading1, String heading2, String heading3, String heading4, String heading5);

    public void updateHeadingelements(String url, String h1elements, String h2elements, String h3elements, String h4elements, String h5elements);

    public void updateImage(String url, String src);

    public void updatePagelinks(String url, String links, String title, String type);

    public void updateRelatedwebsite(String url, String relatedLinks);

    public void updateTechnology(String url, String techUsed, String analytics);

    public void upadteVisitorarray(String url, String country, String percent, String rank);

    public void updateXmldata(String url, String xmlfiles);

}
