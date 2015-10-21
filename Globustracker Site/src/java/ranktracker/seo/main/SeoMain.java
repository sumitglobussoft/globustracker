/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.seo.main;

import org.json.JSONObject;
import ranktracker.seo.moz.MozMain;

/**
 *
 * @author GLB-170
 */
public class SeoMain {

    public JSONObject getSeoDetails(String url) {
        try {
            url=url.replace("http://", "").replace("https://", "");
            
            JSONObject result= new JSONObject();
            
            result.put("moz_details", new MozMain().getMozDetails(url));
            
            return result;
            
        } catch (Exception e) {
        }
        return null;
    }

}
