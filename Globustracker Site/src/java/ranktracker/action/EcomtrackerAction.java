/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.dao.CampaignsDao;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Serpkeywords;
import ranktracker.form.EcomtrackerForm;
import ranktracker.service.CampaignsService;

/**
 *
 * @author GLB-115
 */
public class EcomtrackerAction extends ActionSupport {

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     * objResponse The HttpServletResponse object
     */
    private HttpServletResponse objResponse;
    /**
     * objHttpSession The HttpSession object
     */
    private HttpSession objHttpSession;
    /**
     * objCampaignsService The service layer object variable for
     * CampaignsService
     */
    private CampaignsService objCampaignsService;
    /**
     * lstCampaigns The list containing Campaigns objects
     */
    private List<Campaigns> lstCampaigns;
    private CampaignsDao objCampaignsDao;
    private List<EcomtrackerForm> lstEcomtrackerDetails;

    /**
     * The method retrieves tempKeywords based on campaign id
     *
     * @return struts return value
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        try {
            Integer customerID = 337;
            System.out.println("customerID = " + customerID);

            lstCampaigns = objCampaignsDao.getEcomCampaigns(customerID);
            Collection<Serpkeywords> ecomKeywords = null;
            for (Campaigns campaign : lstCampaigns) {
                ecomKeywords = campaign.getSerpkeywordsCollection();
                break;
            }
            lstEcomtrackerDetails = (List<EcomtrackerForm>) objCampaignsDao.getEcomComparisons(ecomKeywords);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public List<Campaigns> getLstCampaigns() {
        return lstCampaigns;
    }

    public void setLstCampaigns(List<Campaigns> lstCampaigns) {
        this.lstCampaigns = lstCampaigns;
    }

    public CampaignsDao getObjCampaignsDao() {
        return objCampaignsDao;
    }

    public void setObjCampaignsDao(CampaignsDao objCampaignsDao) {
        this.objCampaignsDao = objCampaignsDao;
    }

    public CampaignsService getObjCampaignsService() {
        return objCampaignsService;
    }

    public void setObjCampaignsService(CampaignsService objCampaignsService) {
        this.objCampaignsService = objCampaignsService;
    }

    public List<EcomtrackerForm> getLstEcomtrackerDetails() {
        return lstEcomtrackerDetails;
    }

    public void setLstEcomtrackerDetails(EcomtrackerForm lstEcomtrackerDetails) {
        this.lstEcomtrackerDetails = (List<EcomtrackerForm>) lstEcomtrackerDetails;
    }
}
