package ranktracker.utility;

import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kalpana
 */
public interface FetchPage {

    public String fetchPageSourceString_Get(String urlToFetch, String region,int pageN0) throws IOException;
}
