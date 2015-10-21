<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css"/>
<link rel="stylesheet" href="https://s3.amazonaws.com/css_ranktracker/tablestyle.css" />
<link rel="stylesheet" type="text/css" href="http://www.highcharts.com/highslide/highslide.css" />
<link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css_ranktracker/rankup.css" />
<link href="https://s3.amazonaws.com/css_ranktracker/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
<!--link rel="stylesheet" href="https://s3.amazonaws.com/css_ranktracker/serpkeypopup.css"/-->
<style type="text/css">
    <%@include  file="views/css_ranktracker/serpkeypopup.css" %>
    .close_btn
    {
        width: 16px;
        height: 16px;
        float: right;
        margin:5px 5px 0 0;
    }
    ul.actionMessage
    {
        list-style: none;
        font-family: arial;
        font-size:15px;
        color:#BC0909;
        width:600px;
        float:left;
    }
    #social_site_new > ul > li.sc_links {
        float: left;
        height: auto;
        width: 32.3% !important;
    }
    .google, .yahoo, .bing, .social_data, .video {
        background: none repeat scroll 0 0 #464541;
        border-right: 1px solid #666666;
        color: #FFFFFF;
        float: left;
        font-family: "Trebuchet MS",Arial,Helvetica,sans-serif;
        font-size: 23px;
        height: 33px;
        padding-top: 10px;
        text-align: center;
        width: 326px;
    }
    #social_site_new > ul > li.sc_links > a {
        color: #999999;
        float: left;
        font-family: "Trebuchet MS",Arial,Helvetica,sans-serif;
        font-size: 22px;
        height: auto;
        padding-top: 10px;
        text-align: center;
        width: 83%;
    }
    .social_site_div {
        margin-top: 0px !important;
        margin-left: -9px;
    }
    tbody {color:white;}

    .goals{
        background: none repeat scroll 0 0 #FFFFFF;
        border:1px solid #999;
        border-radius: 5px;
        color: #393939;
        font-family: "Trebuchet MS",Arial,Helvetica,sans-serif;
        font-size: 14px;
        height: 36px;
        margin-bottom: 10px;
        padding: 5px;
        width: 350px;
    }
    #dashboard_footer {   position: relative;}
    .chart_div {
        float: left;
        height: 226px;
        width: 1000px;
    }
    #body {
        height: 74%;
        padding-bottom: 80px;
    }
    #add_url
    {
        background: none repeat scroll 0 0 #1A8FCC;
        cursor: pointer;
        font-family: "Trebuchet MS",Arial,Helvetica,sans-serif;
        font-size: 20px;
        margin-left: 830px;
        width: 130px;
        color: white;
        margin-bottom: 10px;
        text-shadow: 0 0 3px #333333;
        border-radius: 8px
    }

    #add_url:hover
    {
        background: none repeat scroll 0 0 #76981E;
        cursor: pointer;
        font-family: "Trebuchet MS",Arial,Helvetica,sans-serif;
        font-size: 20px;
        margin-left: 830px;
        width: 130px;
        color: white;
        margin-bottom: 10px;
        text-shadow: 0 0 3px #333333;
        border-radius: 8px
    }
    .rankbg {
        margin: 10px 0 21px 301px !important;   
    }

    .add_site_div {
        float: none;
        margin: 0 auto;
    }


    #keyword_table1 {
        border: 1px solid #DFDFDF;
        width: 99%;
        -moz-border-radius: 3px;
        -webkit-border-radius: 3px;
        border-radius: 3px;
        font-family: "Trebuchet MS",Arial,Helvetica,sans-serif;
        color: #333;
        margin-left: 7px;
    }

</style>

<!-- Body start -->
<div id="body">              

    <!--dashboard_wrapper-->
    <div class="dashboard_wrapper">
        <div class="social_site_new" id="social_site_new">                            	 
            <ul>
                <li class="sc_links"><a href="#google">GOOGLE &nbsp;&nbsp;<img src="https://s3.amazonaws.com/images_ranktracker/google_icon.png" style="border:none;" width="24" height="24" alt="" /></a></li>                        
                <li class="sc_links"><a href="#yahoo">YAHOO &nbsp;&nbsp;<img src="https://s3.amazonaws.com/images_ranktracker/yahooicon.png" style="border:none;" width="24" height="24" alt="" /></a></li>
                <li class="sc_links"><a href="#bing">BING &nbsp;&nbsp;<img src="https://s3.amazonaws.com/images_ranktracker/bingicon.png" style="border:none;" width="24" height="24" alt="" /></a></li>    
            </ul>

            <div id="google">
                <div class="add_site_details_div ggle" style="display:block;">

                    <table id="keyword_table1">

                        <tr>
                            <th><h3>Keyword</h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/flipkart.jpg" style="border:none;" width="24" height="24" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/snapdeal.jpg" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/amazon.jpg" style="border:none;" width="24" height="24" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/ebay.jpg" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/ShopClues.png" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/Myntra.jpg" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/HomeShop18.png" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/Tradus.jpg" style="border:none;" width="40" height="30" alt="" /></h3></th>                                                                                                      
                        </tr>

                        <s:iterator value="lstEcomtrackerDetails">
                            <tr>
                                <td style="text-align: left;"><s:property value="keyword" /></td>
                                <s:if test="%{rankGoogleFlipkart!=501 && rankGoogleFlipkart!=0}">
                                    <td style="text-align: center;"><s:property value="rankGoogleFlipkart" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankGoogleSnapdeal!=501 && rankGoogleSnapdeal!=0}">
                                    <td style="text-align: center;"><s:property value="rankGoogleSnapdeal" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankGoogleAmazon!=501 && rankGoogleAmazon!=0}">
                                    <td style="text-align: center;"><s:property value="rankGoogleAmazon" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankGoogleEbay!=501 && rankGoogleEbay!=0}">
                                    <td style="text-align: center;"><s:property value="rankGoogleEbay" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankGoogleShopclues!=501 && rankGoogleShopclues!=0}">
                                    <td style="text-align: center;"><s:property value="rankGoogleShopclues" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankGoogleMyntra!=501 && rankGoogleMyntra!=0}">
                                    <td style="text-align: center;"><s:property value="rankGoogleMyntra" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankGoogleHomeshop18!=501 && rankGoogleHomeshop18!=0}">
                                    <td style="text-align: center;"><s:property value="rankGoogleHomeshop18" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankGoogleTradus!=501 && rankGoogleTradus!=0}">
                                    <td style="text-align: center;"><s:property value="rankGoogleTradus" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>                                                                             
                            </tr>
                        </s:iterator>   

                    </table>

                </div>
            </div>
            <!--end google-->

            <!--Yahoo-->
            <div id="yahoo" style="display:none;">
                <div class="add_site_details_div ggle" style="display:block;">

                    <table id="keyword_table1">

                        <tr>
                            <th><h3>Keyword</h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/flipkart.jpg" style="border:none;" width="24" height="24" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/snapdeal.jpg" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/amazon.jpg" style="border:none;" width="24" height="24" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/ebay.jpg" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/ShopClues.png" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/Myntra.jpg" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/HomeShop18.png" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/Tradus.jpg" style="border:none;" width="40" height="30" alt="" /></h3></th>                                                                                                      
                        </tr>

                        <s:iterator value="lstEcomtrackerDetails">
                            <tr>
                                <td style="text-align: left;"><s:property value="keyword" /></td>
                                <s:if test="%{rankYahooFlipkart!=501 && rankYahooFlipkart!=0}">
                                    <td style="text-align: center;"><s:property value="rankYahooFlipkart" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankYahooSnapdeal!=501 && rankYahooSnapdeal!=0}">
                                    <td style="text-align: center;"><s:property value="rankYahooSnapdeal" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankYahooAmazon!=501 && rankYahooAmazon!=0}">
                                    <td style="text-align: center;"><s:property value="rankYahooAmazon" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankYahooEbay!=501 && rankYahooEbay!=0}">
                                    <td style="text-align: center;"><s:property value="rankYahooEbay" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankYahooShopclues!=501 && rankYahooShopclues!=0}">
                                    <td style="text-align: center;"><s:property value="rankYahooShopclues" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankYahooMyntra!=501 && rankYahooMyntra!=0}">
                                    <td style="text-align: center;"><s:property value="rankYahooMyntra" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankYahooHomeshop18!=501 && rankYahooHomeshop18!=0}">
                                    <td style="text-align: center;"><s:property value="rankYahooHomeshop18" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankYahooTradus!=501 && rankYahooTradus!=0}">
                                    <td style="text-align: center;"><s:property value="rankYahooTradus" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>                                                                                                                           
                            </tr>
                        </s:iterator>   

                    </table>

                </div>
            </div>
            <!--end yahoo-->

            <!--Bing-->
            <div id="bing" style="display:none;">
                <div class="add_site_details_div ggle" style="display:block;">

                    <table id="keyword_table1">

                        <tr>
                            <th><h3>Keyword</h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/flipkart.jpg" style="border:none;" width="24" height="24" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/snapdeal.jpg" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/amazon.jpg" style="border:none;" width="24" height="24" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/ebay.jpg" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/ShopClues.png" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/Myntra.jpg" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/HomeShop18.png" style="border:none;" width="40" height="30" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/Tradus.jpg" style="border:none;" width="40" height="30" alt="" /></h3></th>                                                                                                      
                        </tr>

                        <s:iterator value="lstEcomtrackerDetails">
                            <tr>
                                <td style="text-align: left;"><s:property value="keyword" /></td>
                                <s:if test="%{rankBingFlipkart!=501 && rankBingFlipkart!=0}">
                                    <td style="text-align: center;"><s:property value="rankBingFlipkart" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankBingSnapdeal!=501 && rankBingSnapdeal!=0}">
                                    <td style="text-align: center;"><s:property value="rankBingSnapdeal" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankBingAmazon!=501 && rankBingAmazon!=0}">
                                    <td style="text-align: center;"><s:property value="rankBingAmazon" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankBingEbay!=501 && rankBingEbay!=0}">
                                    <td style="text-align: center;"><s:property value="rankBingEbay" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankBingShopclues!=501 && rankBingShopclues!=0}">
                                    <td style="text-align: center;"><s:property value="rankBingShopclues" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankBingMyntra!=501 && rankBingMyntra!=0}">
                                    <td style="text-align: center;"><s:property value="rankBingMyntra" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankBingHomeshop18!=501 && rankBingHomeshop18!=0}">
                                    <td style="text-align: center;"><s:property value="rankBingHomeshop18" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>
                                <s:if test="%{rankBingTradus!=501 && rankBingTradus!=0}">
                                    <td style="text-align: center;"><s:property value="rankBingTradus" /></td>
                                </s:if>
                                <s:else >
                                    <td style="text-align: center;">N/A</td>
                                </s:else>                                                                             
                            </tr>
                        </s:iterator> 

                    </table>

                </div>
            </div>
            <!--end Bing-->

        </div>

    </div>

    <!--end dashboard_wrapper-->

</div>

<!-- Body end 
<script type="text/javascript" src="https://s3.amazonaws.com/js_ranktracker/jquery.js"></script>-->

<script type="text/javascript" src="http://www.highcharts.com/highslide/highslide-full.min.js"></script>
<script type="text/javascript" src="http://www.highcharts.com/highslide/highslide.config.js" charset="utf-8"></script>
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">

    $("#social_site_new").tabs();
    $(document).ready(function() {
        $("#fade_away").fadeOut(20000);
        $(".google").click(function() {
            $(".ggle").show();
            $(".yhoo").hide();
            $(".bng").hide();
        });
        $(".yahoo").click(function() {
            $(".ggle").hide();
            $(".yhoo").show();
            $(".bng").hide();
        });
        $(".bing").click(function() {
            $(".ggle").hide();
            $(".yhoo").hide();
            $(".bng").show();
        });
        });
</script>
<!--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>-->
<script src="https://s3.amazonaws.com/js_ranktracker/highcharts.js"></script>
<script src="https://s3.amazonaws.com/js_ranktracker/exporting.js"></script>
<script type="text/javascript" src="http://www.highcharts.com/highslide/highslide-full.min.js"></script>
<script type="text/javascript" src="http://www.highcharts.com/highslide/highslide.config.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="http://www.highcharts.com/highslide/highslide.css" />
