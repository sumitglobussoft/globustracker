/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.seo.moz;

/**
 *
 * @author GLB-170
 */
public class SeoMozCols {

    public Long getUrlMetricsCols() {
        return URLMetricsConstants.URLMETRICS_COL_TITLE
                + URLMetricsConstants.URLMETRICS_COL_URL
                + URLMetricsConstants.URLMETRICS_COL_SUBDOMAIN
                + URLMetricsConstants.URLMETRICS_COL_ROOT_DOMAIN
                + URLMetricsConstants.URLMETRICS_COL_EXTERNAL_LINKS
                + URLMetricsConstants.URLMETRICS_COL_SUBDMN_EXTERNAL_LINKS
                + URLMetricsConstants.URLMETRICS_COL_ROOTDMN_EXTERNAL_LINKS
                + URLMetricsConstants.URLMETRICS_COL_JUICE_PASSING_LINKS
                + URLMetricsConstants.URLMETRICS_COL_SUBDMN_LINKS
                + URLMetricsConstants.URLMETRICS_COL_ROOTDMN_LINKS
                + URLMetricsConstants.URLMETRICS_COL_LINKS
                + URLMetricsConstants.URLMETRICS_COL_SUBDMN_SUBDMN_LINKS
                + URLMetricsConstants.URLMETRICS_COL_ROOTDMN_ROOTDMN_LINKS
                + URLMetricsConstants.URLMETRICS_COL_MOZRANK
                + URLMetricsConstants.URLMETRICS_COL_SUBDMN_MOZRANK
                + URLMetricsConstants.URLMETRICS_COL_ROOTDMN_MOZRANK
                + URLMetricsConstants.URLMETRICS_COL_MOZTRUST
                + URLMetricsConstants.URLMETRICS_COL_SUBDMN_MOZTRUST
                + URLMetricsConstants.URLMETRICS_COL_ROOTDMN_MOZTRUST
                + URLMetricsConstants.URLMETRICS_COL_EXTERNAL_MOZRANK
                + URLMetricsConstants.URLMETRICS_COL_SUBDMN_EXTERNALDMN_JUICE
                + URLMetricsConstants.URLMETRICS_COL_ROOTDMN_EXTERNALDMN_JUICE
                + URLMetricsConstants.URLMETRICS_COL_SUBDMN_DOMAIN_JUICE
                + URLMetricsConstants.URLMETRICS_COL_ROOTDMN_DOMAIN_JUICE
                + URLMetricsConstants.URLMETRICS_COL_CANONICAL_URL
                + URLMetricsConstants.URLMETRICS_COL_HTTP_STATUS_CODE
                + URLMetricsConstants.URLMETRICS_COL_LINKS_TO_SUBDMN
                + URLMetricsConstants.URLMETRICS_COL_LINKS_TO_ROOTDMN
                + URLMetricsConstants.URLMETRICS_COL_ROOTDMN_LINKS_SUBDMN
                + URLMetricsConstants.URLMETRICS_COL_PAGE_AUTHORITY
                + URLMetricsConstants.URLMETRICS_COL_DOMAIN_AUTHORITY;

    }

    public Long getLinkMetricsCols() {
        return LinksConstants.LINKS_COL_ALL + LinksConstants.LINKS_COL_TITLE
                + LinksConstants.LINKS_COL_URL
                + LinksConstants.LINKS_COL_SUBDOMAIN
                + LinksConstants.LINKS_COL_ROOT_DOMAIN
                + LinksConstants.LINKS_COL_EXTERNAL_LINKS
                + LinksConstants.LINKS_COL_SUBDMN_EXTERNAL_LINKS
                + LinksConstants.LINKS_COL_ROOTDMN_EXTERNAL_LINKS
                + LinksConstants.LINKS_COL_JUICE_PASSING_LINKS
                + LinksConstants.LINKS_COL_SUBDMN_LINKS
                + LinksConstants.LINKS_COL_ROOTDMN_LINKS
                + LinksConstants.LINKS_COL_LINKS
                + LinksConstants.LINKS_COL_SUBDMN_SUBDMN_LINKS
                + LinksConstants.LINKS_COL_ROOTDMN_ROOTDMN_LINKS
                + LinksConstants.LINKS_COL_MOZRANK
                + LinksConstants.LINKS_COL_SUBDMN_MOZRANK
                + LinksConstants.LINKS_COL_ROOTDMN_MOZRANK
                + LinksConstants.LINKS_COL_MOZTRUST
                + LinksConstants.LINKS_COL_SUBDMN_MOZTRUST
                + LinksConstants.LINKS_COL_ROOTDMN_MOZTRUST
                + LinksConstants.LINKS_COL_EXTERNAL_MOZRANK
                + LinksConstants.LINKS_COL_SUBDMN_EXTERNALDMN_JUICE
                + LinksConstants.LINKS_COL_ROOTDMN_EXTERNALDMN_JUICE
                + LinksConstants.LINKS_COL_SUBDMN_DOMAIN_JUICE
                + LinksConstants.LINKS_COL_ROOTDMN_DOMAIN_JUICE
                + LinksConstants.LINKS_COL_CANONICAL_URL
                + LinksConstants.LINKS_COL_HTTP_STATUS_CODE
                + LinksConstants.LINKS_COL_LINKS_TO_SUBDMN
                + LinksConstants.LINKS_COL_LINKS_TO_ROOTDMN
                + LinksConstants.LINKS_COL_ROOTDMN_LINKS_SUBDMN
                + LinksConstants.LINKS_COL_PAGE_AUTHORITY
                + LinksConstants.LINKS_COL_DOMAIN_AUTHORITY;
    }

    public Long getAnchorTextCols() {
        return AnchorTextConstants.ANCHOR_COL_ALL
                + AnchorTextConstants.ANCHOR_COL_TERM_OR_PHRASE
                + AnchorTextConstants.ANCHOR_COL_INTERNAL_PAGES_LINK
                + AnchorTextConstants.ANCHOR_COL_INTERNAL_SUBDMNS_LINK
                + AnchorTextConstants.ANCHOR_COL_EXTERNAL_PAGES_LINK
                + AnchorTextConstants.ANCHOR_COL_EXTERNAL_SUBDMNS_LINK
                + AnchorTextConstants.ANCHOR_COL_EXTERNAL_ROOTDMNS_LINK
                + AnchorTextConstants.ANCHOR_COL_INTERNAL_MOZRANK
                + AnchorTextConstants.ANCHOR_COL_EXTERNAL_MOZRANK
                + AnchorTextConstants.ANCHOR_COL_FLAGS;
    }

    public Long getTopPagesCols() {
        return TopPagesConstants.TOPPAGES_COL_ALL
                + TopPagesConstants.TOPPAGES_COL_TITLE
                + TopPagesConstants.TOPPAGES_COL_URL
                + TopPagesConstants.TOPPAGES_COL_SUBDOMAIN
                + TopPagesConstants.TOPPAGES_COL_ROOT_DOMAIN
                + TopPagesConstants.TOPPAGES_COL_EXTERNAL_LINKS
                + TopPagesConstants.TOPPAGES_COL_SUBDMN_EXTERNAL_LINKS
                + TopPagesConstants.TOPPAGES_COL_ROOTDMN_EXTERNAL_LINKS
                + TopPagesConstants.TOPPAGES_COL_JUICE_PASSING_LINKS
                + TopPagesConstants.TOPPAGES_COL_SUBDMN_LINKS
                + TopPagesConstants.TOPPAGES_COL_ROOTDMN_LINKS
                + TopPagesConstants.TOPPAGES_COL_LINKS
                + TopPagesConstants.TOPPAGES_COL_SUBDMN_SUBDMN_LINKS
                + TopPagesConstants.TOPPAGES_COL_ROOTDMN_ROOTDMN_LINKS
                + TopPagesConstants.TOPPAGES_COL_MOZRANK
                + TopPagesConstants.TOPPAGES_COL_SUBDMN_MOZRANK
                + TopPagesConstants.TOPPAGES_COL_ROOTDMN_MOZRANK
                + TopPagesConstants.TOPPAGES_COL_MOZTRUST
                + TopPagesConstants.TOPPAGES_COL_SUBDMN_MOZTRUST
                + TopPagesConstants.TOPPAGES_COL_ROOTDMN_MOZTRUST
                + TopPagesConstants.TOPPAGES_COL_EXTERNAL_MOZRANK
                + TopPagesConstants.TOPPAGES_COL_SUBDMN_EXTERNALDMN_JUICE
                + TopPagesConstants.TOPPAGES_COL_ROOTDMN_EXTERNALDMN_JUICE
                + TopPagesConstants.TOPPAGES_COL_SUBDMN_DOMAIN_JUICE
                + TopPagesConstants.TOPPAGES_COL_ROOTDMN_DOMAIN_JUICE
                + TopPagesConstants.TOPPAGES_COL_CANONICAL_URL
                + TopPagesConstants.TOPPAGES_COL_HTTP_STATUS_CODE
                + TopPagesConstants.TOPPAGES_COL_LINKS_TO_SUBDMN
                + TopPagesConstants.TOPPAGES_COL_LINKS_TO_ROOTDMN
                + TopPagesConstants.TOPPAGES_COL_ROOTDMN_LINKS_SUBDMN
                + TopPagesConstants.TOPPAGES_COL_PAGE_AUTHORITY
                + TopPagesConstants.TOPPAGES_COL_DOMAIN_AUTHORITY;
    }

}
