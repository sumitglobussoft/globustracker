package ranktracker.dao;

import java.util.List;
import ranktracker.entity.Commonseo;
import ranktracker.entity.Headingcount;
import ranktracker.entity.Headingelements;
import ranktracker.entity.Image;
import ranktracker.entity.Pagelinks;
import ranktracker.entity.Relatedwebsite;
import ranktracker.entity.Technology;
import ranktracker.entity.Visitorarray;
import ranktracker.entity.Xmldata;

public interface WoorankDao {

    public void insertCommonseo(Commonseo objcommonseo);

    public void insertHeading(Headingcount objheadingcount);

    public Commonseo getCommonSeoDetails(String url);

    public Headingcount getHeadingCountDetails(String url);

   

    public List<Image> getImageDetails(String url);

    public List<Pagelinks> getPagelinksDetails(String url);

    public List<Relatedwebsite> getRelatedwebsiteDetails(String url);

    public List<Technology> getTechnologyDetails(String url);

    public List<Visitorarray> getVisitorarrayDetails(String url);

    public List<Xmldata> getXmldataDetails(String url);

}
