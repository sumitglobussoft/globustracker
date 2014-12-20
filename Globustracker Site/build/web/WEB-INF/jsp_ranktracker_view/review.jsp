
<!DOCTYPE html">
<%@page import="java.util.Date" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
    <head>
        <title>Best Rank Tracker | SERP Tracker | Youtube Rank Tracker | Social Signals Tracker</title>
        <link rel="shortcut icon" href="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content=""/>
        <meta property="description" content="" />
        <meta property="og:title" content="" />
        <meta property="og:type" content="" />
        <meta property="og:url" content="http://globustracker.com/" />
        <meta property="og:image" content="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />   
        <!--        <script src="https://s3.amazonaws.com/js_ranktracker/jquery-1.9.1.js" ></script>-->
        <link rel="stylesheet" href="https://s3.amazonaws.com/css_ranktracker/reviewstyle.css" type="text/css" media="screen" charset="utf-8">
        <style type="text/css">
            <%@ include file="../css_ranktracker/style.css" %>
        </style>
        <!--        <script src="https://s3.amazonaws.com/js_ranktracker/jquery.min.js"></script>-->
        <!--        <script src="https://s3.amazonaws.com/js_ranktracker/ddaccordion.js"></script>-->
        <script src="https://s3.amazonaws.com/js_ranktracker/jq-btsp.min0e16.js"></script>
        <!--        <script src="https://s3.amazonaws.com/js_ranktracker/review.min33f1.js"></script>-->
        <script src="https://s3.amazonaws.com/js_ranktracker/commons.min95e2.js"></script>
        <script type="text/javascript">
            var _gaq = _gaq || [];
            _gaq.push(['_setAccount', 'UA-12074781-1']);
            _gaq.push(['_setAllowAnchor', true]);
            _gaq.push(['_trackPageview']);
            (function() {
                var ga = document.createElement('script');
                ga.type = 'text/javascript';
                ga.async = true;
                ga.src = ('https:' === document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                var s = document.getElementsByTagName('script')[0];
                s.parentNode.insertBefore(ga, s);
            })();

        </script>
        <style type="text/css">
            #slidy-container {
                margin: 0 auto;
                overflow: hidden;
                width: 100%;
            }
            #slidy img {
                float: left;
                width: 20%;
            }
            .ipad-thumb {
                margin-top: -2px;
            }
        </style>
        <style type="text/css">
            /* ----------------- header -------------------- */
            #header1 
            {
                background:url(https://s3.amazonaws.com/images_ranktracker/header_bg.png);
                height:124px;
                clear:left;
            }
            .header1_wrapper
            {
                width:1000px;
                height:124px;
                margin:0 auto;
                background:url(https://s3.amazonaws.com/images_ranktracker/header_bg.png);
            }

            .header1_logo
            {
                width:291px;
                height:47px;
                float:left;
                margin-top: 0px;
            }
            .header1_logo a img
            {
                border:none;
                padding:14px;
            }

            .btn_for_all
            {
                float: right;
                height: 33px;
                margin-left: 20px;
                margin-top: 25px;
                width: 139px;
            }
            .btn_for_all a
            {
                background: url("https://s3.amazonaws.com/images_ranktracker/btn_img.png") repeat scroll 0 0 transparent;
                color: #FFFFFF;
                float: left;
                font-family: Arial,Helvetica,sans-serif;
                font-size: 14px;
                height: 20px;
                padding: 8px 5px 5px;
                text-align: center;
                text-decoration: none;
                width: 129px;
            }
            .btn_for_all a:hover
            {
                width:129px;
                height:20px;
                background:url(https://s3.amazonaws.com/images_ranktracker/hover_btn.png);
                padding:8px 5px 5px;
                font-family:Arial, Helvetica, sans-serif;
                font-size:14px;
                color:#fff;
            }

            .btn_for_all a.active
            {
                width:129px;
                height:20px;
                background:url(https://s3.amazonaws.com/images_ranktracker/hover_btn.png);
                padding:8px 5px 5px;
                font-family:Arial, Helvetica, sans-serif;
                font-size:14px;
                color:#fff;
            }	

            /* ----------------- menu -------------------- */
            #menu li ul{
                display:none;
                position:absolute;
                z-index: 90000;
            }
            #menu li:hover ul{
                display:block;
                background:#198eca;
                height:auto; width:120px; 
                margin: 0;
                padding: 0 0 0 10px;
            }
            #menu li ul li{
                clear:both;
                border-style:none;
            }
            #menu li ul li a{
                clear:both;
                border-style:none;
                text-decoration: none;
            }
            #menu li ul li a{
                clear:both;
                border-style:none;
                text-decoration: none;
                color: #fff;
            }
            #menu li ul li a:hover{
                clear:both;
                border-style:none;
                text-decoration: none;
                color: #B7FF00 !important;
            }
            .header_logo {
                float: left;
                height: 68px !important;
                margin-top: 0;
                width: 291px;
            }
            #menu li a span span {
                color: #FFFFFF;
                font-family: Arial,Helvetica,sans-serif;
                font-size: 15px;
                font-weight: bold;
                height: auto;
                padding: 0 45px;
                text-shadow: 0 0 3px #333333;
                margin-top: 22px;
            }
            #menu li a {
                color: #FFFFFF;
                cursor: pointer;
                font-family: Arial,Helvetica,sans-serif;
                font-size: 15px;
                font-weight: bold;
                line-height: 38px;
                text-shadow: 0 0 3px #333333;
            }

            /* ----------------- footer -------------------- */
            #dashboard_footer {
                bottom:0;
                width:100%;
                height:60px;
                margin-top:10px;
                float:left;	/* Height of the footer */
                background:url(https://s3.amazonaws.com/images_ranktracker/footer_bg.png);
            }
            .dashboard_footer_wrapper
            {
                width:1000px;
                height:52px;
                margin:0 auto;
                background:url(https://s3.amazonaws.com/images_ranktracker/footer_bg.png);
            }
            .dashboard_footer_bottom {
                clear: left;
                color: #FFFFFF;
                float: left;
                font-family: Arial,Helvetica,sans-serif;
                font-size: 12px;
                margin-top: 23px;
                text-align: center;
                width: 970px;
            }
            table tbody td{font-size: 12px;
                           padding: 5px 0 5px 10px;
                           text-overflow: ellipsis;
                           white-space: nowrap;}

            .comment {
                width: 400px;
                background-color: #f0f0f0;
                margin: 10px;
            }
            a.morelink {
                text-decoration:none;
                outline: none;
            }
            .morecontent span {
                display: none;

            }
            table tbody td:first-child {
                border-left: 0 none;
                overflow-x: hidden;
            }
            .h2_tab{ max-width: 520px;
                     white-space: normal;}
            </style>
        </head>
        <body>

            <div id="header1">		
            <div class="header1_wrapper">
                <div class="header1_logo"><a href="home.action"><img src="https://s3.amazonaws.com/images_ranktracker/Globustracker-logo-present.png" alt="" /></a></div>
                <div class="btn_for_all"><a href="payment.action">Try it for FREE!</a></div>

                <!--menu-->
                <div id="menu">
                    <ul class="menu">

                        <c:choose>
                            <c:when test="${requestScope.highlight == 'HOME'}">
                                <li id="menu_active"><a href="home.action"><span><span>HOME</span></span></a></li>
                                            </c:when>
                                            <c:otherwise>
                                <li><a href="home.action"><span><span>HOME</span></span></a></li>
                                            </c:otherwise>
                                        </c:choose>

                        <c:choose>
                            <c:when test="${requestScope.highlight == 'FEATURES'}">
                                <li id="menu_active"><a href="features.action"><span><span>FEATURES</span></span></a></li>
                                            </c:when>
                                            <c:otherwise>
                                <li><a href="features.action"><span><span>FEATURES</span></span></a></li>
                                            </c:otherwise>
                                        </c:choose>

                        <c:choose>
                            <c:when test="${requestScope.highlight == 'PRICING'}">
                                <li id="menu_active"><a href="tour.action"><span><span>PRICING</span></span></a></li>
                                            </c:when>
                                            <c:otherwise>
                                <li ><a href="pricing.action"><span><span>PRICING</span></span></a></li>
                                            </c:otherwise>
                                        </c:choose>


                        <c:choose>
                            <c:when test="${requestScope.highlight == 'TOUR'}">
                                <li id="menu_active"><a href="tour.action"><span><span>TAKE A TOUR</span></span></a></li>
                                            </c:when>
                                            <c:otherwise>
                                <li><a href="tour.action"><span><span>TAKE A TOUR</span></span></a></li>
                                            </c:otherwise>
                                        </c:choose>


                        <!--li><a href="http://blog.globustracker.com" target="_blank"><span><span>BLOG</span></span></a></li-->

                        <c:choose>
                            <c:when test="${requestScope.highlight == 'CONTACT'}">
                                <li id="menu_active"><a href="contact.action"><span><span>CONTACT</span></span></a></li>
                                            </c:when>
                                            <c:otherwise>
                                <li><a href="contact.action"><span><span>CONTACT</span></span></a></li>
                                            </c:otherwise>
                                        </c:choose>

                        <c:choose>
                            <c:when test="${requestScope.highlight == 'FAQ'}">
                                <li id="menu_active"><a href="faq.action"><span><span>FAQ</span></span></a></li>
                                            </c:when>
                                            <c:otherwise>
                                <li><a href="faq.action"><span><span>FAQ</span></span></a></li>
                                            </c:otherwise>
                                        </c:choose>

                    </ul>
                </div>
                <!--end menu-->
            </div>	
        </div>
        <!-- Header end -->

        <div id="wrapper">
            <div id="accordion-container">
                <h2 class="accordion-header">Visitors</h2>
                <div class="accordion-content" style="display: block">
                    <div class="module" id="module-visitors">
                        <input type="hidden" id="websearchurl" value="${website}<%--= session.getAttribute("websearchurl")--%>"/>
                        <div class="module-content">
                            <h2>Review of <span style="font-weight: 700; color: #3dbe2c">${website}
                                    <%--= session.getAttribute("websearchurl")--%></span></h2><span>on &nbsp;<%= new Date()%> </span>
                        </div>                        
                        <div class="module-content">
                            <h2>Visitors</h2>
                            <div id="criterium-url" class="criterium result-0 ">
                                <div class="criterium-head">
                                    <h3>Get Visitors</h3>
                                    <div class="icons"></div>
                                </div>
                            </div>

                            <div id="module-section-title-measure" class="module-section">Measure</div>
                            <div id="set1Loader">
                                <div style="text-align:center; display: block" ><img width="350" height="80" src="https://s3.amazonaws.com/images_ranktracker/load.gif"/></div>
                            </div>
                            <div id="visitorsnew">
                                <div id="module-visitors" class="module">
                                    <div class="module-content">
                                        <h2></h2>

                                        <div id="criterium-trafic_ranking" class="criterium result-0 ">
                                            <div class="criterium-head">
                                                <h3 class="simple-tooltip" data-original-title="Low impact" rel="tooltip" data-placement="left">
                                                    <span class="icn"></span>
                                                    Traffic Rank
                                                </h3>
                                                <div class="icons"> </div>
                                            </div>

                                            <div class="criterium-content" id="trafficrank">
                                                <div class="part text ">
                                                    <p>
                                                        <span class="bold" id="globalrank"><%--= rp.objVisitorsInfo.global_rank   commonseo--%></span>
                                                        <span class="superscript">th</span>
                                                        most visited website in
                                                        <span class="bold">the World</span>
                                                    </p>
                                                    <p>
                                                        <a class="wooindex-bl" href="https://index.woorank.com/en/reviews?country=us" target="_blank">
                                                            <span class="bold" id="countryRank"><%-- rp.objVisitorsInfo.country_rank    commonseo--%></span>
                                                            <span class="superscript">th</span>
                                                            most visited website in
                                                            <span class="bold flag us"></span>
                                                            United States
                                                        </a>
                                                    </p>
                                                </div>
                                            </div>
                                            <div class="criterium-advice-click">
                                                <span>?</span>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="delimiter"></div>
                                </div>
                                <div id="criterium-visitors_loc" class="criterium result-0 open-crit">

                                    <div class="criterium-head">
                                        <h3 class="simple-tooltip" data-original-title="Low impact" rel="tooltip" data-placement="left">
                                            <span class="icn"></span>
                                            Visitors Localization
                                        </h3>
                                        <div class="icons"> </div>
                                    </div>
                                    <div id="set11Loader">
                                        <div style="text-align:center; display: block" ><img width="350" height="80" src="https://s3.amazonaws.com/images_ranktracker/load.gif"/></div>
                                    </div>                               
                                    <!-- Start of VIsitors Localization --> 
                                    <div class="criterium-content" id="localozation" >
                                        <div class="part table ">
                                            <table class="">
                                                <thead>
                                                    <tr>
                                                        <th>Popular Countries</th>
                                                        <th>
                                                            <a target="_blank" href="http://en.wikipedia.org/wiki/Country_code_top-level_domain" rel="nofollow">Percent of Visitors</a>
                                                        </th>
                                                        <th>Rank</th>
                                                        <!--<th></th>-->
                                                    </tr>
                                                </thead>
                                                <tbody id="visitortable">



                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <!-- End of Visitors Localization -->                 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



                <h2 class="accordion-header">Social</h2>
                <div class="accordion-content" style="display: block">
                    <div class="module" id="module-social">
                        <div class="module-content">
                            <h2> Facebook Page</h2>
                            <div class="criterium result-0 " id="criterium-facebook_brand_page">
                                <div class="criterium-head">
                                    <!-- jdfjdfj  _-->
                                    <div class="icons">
                                    </div>
                                </div>
                                <div id="set2Loader">
                                    <div style="text-align:center; display: block" ><img width="350" height="80" src="https://s3.amazonaws.com/images_ranktracker/load.gif"/></div>
                                </div>
                                <div id="facebook">
                                    <div class="criterium-content" >

                                        <div class="part image fb-cover">
                                            <img alt="" src='<%--= rp.objFacebookStructure.facebook_image   commonseo--%>' id="facebookImage">
                                        </div>

                                        <div class="part text fb-text-iconbloc">
                                            <p><span class="icon fb-fancount">Likes</span><span id="facebookLikes"></span></p>
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>Talking About</p>
                                            <p id="takingAbout"></p>
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>URL</p>
                                            <p><a target="_blank" href="#" class="fb-page-url"><span class="fb-bold" id="facebookUrl"><%--= rp.objFacebookStructure.facebook_url   commonseo--%></span></a>
                                            </p>
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>Name</p>
                                            <p id="facebookName"><%--= rp.objFacebookStructure.facebook_name   commonseo--%></p>
                                        </div>



                                        <div class="part text fb-text-bloc">
                                            <p>Products</p>
                                            <p id="facebookProduct"><%--= rp.objFacebookStructure.facebook_products--%></p>
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>Company Overview</p>
                                            <p id="facebookOverview"><%--= rp.objFacebookStructure.facebook_overview--%></p>
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>About</p>
                                            <p id="facebookAbout"><%--= rp.objFacebookStructure.facebook_about--%></p>
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>Mission</p>
                                            <p id="facebookMission"><%--= rp.objFacebookStructure.facebook_mission--%></p>
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>Address</p>
                                            <p id="facebookAddress"><%--= rp.objFacebookStructure.facebook_address--%></p>
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>Phone</p>
                                            <p id="facebookPhone"><%--= rp.objFacebookStructure.facebook_phone--%></p>
                                        </div>
                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">
                                        These data regarding the Facebook Page are publicly available.
                                    </div>
                                </div>

                                <div class="delimiter"></div>
                            </div>
                        </div>
                    </div>

                    <div class="module" id="module-social">
                        <div class="module-content">
                            <h2> Google+ Page </h2>
                            <div class="criterium result-0 " id="criterium-facebook_brand_page">
                                <div class="criterium-head">

                                    <div class="icons">
                                    </div>
                                </div>                              
                                <div id="googleplus">
                                    <div class="criterium-content" >

                                        <div class="part image fb-cover">
                                            <img alt="" src="" id="googleImage">
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>URL</p>
                                            <p><a target="_blank" href="#" class="fb-page-url">
                                                    <span class="fb-bold" id="googleUrl"><%--= rp.objGoogleplus.URL--%></span></a>
                                            </p>
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>Name</p>
                                            <p id="googleName"><%--= rp.objGoogleplus.Name--%></p>
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>Company_Overview</p>
                                            <p id="googleOverview"><%--= rp.objGoogleplus.Company_Overview--%></p>
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>Introduction</p>
                                            <p id="googleIntroduction"><%--= rp.objGoogleplus.Introduction--%></p>
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>Verified</p>
                                            <p id="googleVerified"><%--= rp.objGoogleplus.Verified--%></p>
                                        </div>

                                        <div class="part text fb-text-bloc">
                                            <p>Tagline</p>
                                            <p id="googleTagline"><%--= rp.objGoogleplus.Tagline--%></p>
                                        </div>

                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">
                                        This page is your business listing in Google+. Being active in this social network is important
                                        for claiming your brand, influencing your search engine rankings and interacting with your network. 
                                        You might also consider managing your profile with Google My Business (formerly Google Places). 

                                    </div>
                                    <div class="delimiter"></div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

                <h2 class="accordion-header">Mobile</h2>

                <div class="accordion-content" style="display: block">
                    <div id="module-mobile" class="module">
                        <div class="module-content">
                            <h2>Mobile</h2>
                            <div id="set3Loader">
                                <div style="text-align:center; display: block" ><img width="350" height="80" src="https://s3.amazonaws.com/images_ranktracker/load.gif"/></div>
                            </div>
                            <div id="mobile">
                                <div class="criterium result-0 " id="criterium-mobile_rendering">

                                    <div class="criterium-head">

                                        <h3 data-original-title="Low impact" rel="tooltip" data-placement="left" class="simple-tooltip">
                                            <span class="icn"></span>Mobile Rendering
                                        </h3>

                                        <div class="icons">
                                            <i class="importance-2 simple-tooltip" data-placement="top" rel="tooltip" data-original-title="Medium impact">Medium impact</i>
                                        </div>
                                    </div>
                                    <div class="mobile-content">
                                        <div class="part image iphone-thumb">

                                            <img alt="Your website on an iPhone" itemprop="screenshot" src="<%--= rp.objmobilerenderingo.iphoneView   commonseo --%>" id="iphoneView">

                                        </div>
                                        <div class="part image ipad-thumb">
                                            <img alt="Your website on an iPad" itemprop="screenshot" src="<%--= rp.objmobilerenderingo.ipadView   commonseo--%>" id="ipadView">
                                        </div>
                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">
                                        <p>The number of people using the Mobile Web is huge; over <a target="_blank" href="#" rel="nofollow">75 percent</a>
                                            of consumers have access to smart phones. ?<a target="_blank" href="#" rel="nofollow">?Your website</a> should <a target="_blank" href="#" rel="nofollow">look nice</a> on the most popular mobile devices.
                                            <br>
                                            <br>Tip: Use an analytics tool to track mobile usage of your website.</p>
                                    </div>
                                    <div class="delimiter"></div>
                                </div>
                                <div class="criterium result-1 " id="criterium-mobile_load_time">
                                    <div class="criterium-head">

                                        <h3 data-original-title="Passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                            <span class="icn"></span>Mobile Load Time
                                        </h3>

                                        <div class="icons">
                                            <i class="solvability-2 simple-tooltip" data-placement="top" rel="tooltip" data-original-title="Low Impact">Low Impact</i>
                                        </div>
                                    </div>

                                    <div class="criterium-content">
                                        <div class="part progressbar ">
                                            <div class="content">
                                                <span class="bar"><span style="width:62%;" class="colored-bar">Average&nbsp;&nbsp;&nbsp;&nbsp;</span><span data-abs-value="#" class="value">Average</span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">
                                        <p>Try to load your website on a mobile device and measure the download time. If your website takes more than five seconds to download on a mobile device, you will
                                            <a target="_blank" href="#" rel="nofollow">lose 74 percent of your audience</a>!
                                            <br>
                                            <br>Mobile usage is growing fast, especially in North America, where it will soon outpace desktop browsing usage. <a target="_blank" href="#" rel="nofollow">Make sure your site loads fast</a> 
                                            and that it looks nice on all types of mobile devices. Be sure to not use Flash, and keep photos and videos to a minimum.
                                            <br>
                                            <br>Here are <a target="_blank" href="#" rel="nofollow">two useful tips</a> from Google&trade; for optimizing your mobile site speed.</p>

                                    </div>

                                    <div class="delimiter"></div>
                                </div>
                                <div class="criterium result-1 " id="criterium-mobile_optimization">
                                    <div class="criterium-head">

                                        <h3 data-original-title="Passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                            <span class="icn"></span>Mobile Optimization
                                        </h3>

                                        <div class="icons">
                                            <i class="importance-2 simple-tooltip" data-placement="top" rel="tooltip" data-original-title="Medium impact">Medium impact</i>
                                            <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">
                                                <i class="icn icn-gear"></i><i class="icn icn-gear"></i><i class="icn icn-gear"></i>

                                            </i>
                                        </div>
                                    </div>

                                    <div class="criterium-content">
                                        <div class="part text ">
                                            <p>This web page is super optimized for Mobile Visitors</p>
                                        </div>

                                        <div class="part text checklist">
                                            <p><span class="icon grey-found"></span>Mobile CSS</p>
                                            <p><span class="icon grey-missing weak"></span>Mobile Redirection</p>
                                        </div>

                                        <div class="part text ">
                                            <p>Additional mobile optimization techniques:</p>
                                        </div>

                                        <div class="part text checklist">
                                            <p><span class="icon grey-found weak"></span>Meta Viewport Tag</p>
                                            <p><span class="icon grey-missing weak"></span>Apple Icon</p>
                                            <p><span class="icon grey-found weak"></span>Flash content</p>
                                        </div>

                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">

                                        <p><a target="_blank" href="#" rel="nofollow">Optimize the mobile experience</a> even further with the following options:</p>

                                        <ul>
                                            <li><a target="_blank" href="#" rel="nofollow">Mobile CSS</a>
                                            </li>
                                            <li><a target="_blank" href="#" rel="nofollow">Meta Viewport Tag</a>
                                            </li>
                                            <li><a target="_blank" href="#" rel="nofollow">Apple Icon</a>
                                            </li>
                                            <li><a target="_blank" href="#" rel="nofollow">Mobile Redirection</a>
                                            </li>
                                            <li><a target="_blank" href="#" rel="nofollow">No Flash content</a>
                                            </li>
                                        </ul>
                                        <p></p>
                                    </div>

                                    <div class="delimiter"></div>
                                </div>
                            </div>
                        </div>
                    </div>      

                    <!--                    <p class="first-p"></p>
                                        <p class="last-p"><a href="#">Mobile</a>
                                        </p>
                    
                    
                                        <div id="criterium-mobile_rendering" class="criterium result-0 open-crit">
                                            <div class="criterium-head">
                                                <h3 class="simple-tooltip" data-original-title="Low impact" rel="tooltip" data-placement="left">
                                                    <span class="icn"></span>
                                                    Mobile Rendering
                                                </h3>
                                                <div class="icons">
                                                    <span class="importance-1 simple-tooltip" data-original-title="" rel="tooltip" data-placement="top">
                                                        <span class="icn icn-bullet-impact"></span>
                                                        <span class="icn icn-bullet-impact"></span>
                                                        <span class="icn icn-bullet-impact"></span>
                    
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="criterium-content">
                                                <div class="part image iphone-thumb">
                                                    <img alt="Your website on an iPhone" itemprop="screenshot" src="http://sitescreens.woorank.com/ebay.in.iphone.png">
                                                </div>
                                                <div class="part image ipad-thumb">
                                                    <img alt="Your website on an iPad" itemprop="screenshot" src="http://sitescreens.woorank.com/ebay.in.ipad.png">
                                                </div>
                                            </div>
                                            <div class="criterium-advice-click">
                                                <span>?</span>
                                            </div>
                                            <div class="criterium-advice" style="display: block;">
                                                <p>
                                                    The number of people using the Mobile Web is huge; over
                                                    <a target="_blank" href="http://www.ourmobileplanet.com/en/" rel="nofollow">75 percent</a>
                                                    of consumers have access to smartphones. ?
                                                    <a target="_blank" href="http://blog.woorank.com/2012/11/6-tips-15-free-tools-awesome-mobile-websites/" rel="nofollow">?Your website</a>
                                                    should
                                                    <a target="_blank" href="http://goo.gl/We7mf0" rel="nofollow">look nice</a>
                                                    on the most popular mobile devices.
                                                    <br>
                                                    <br>
                                                </p>
                                            </div>
                                            <div class="delimiter"></div>
                                        </div>-->

                </div>

                <h2 class="accordion-header">SEO</h2>

                <div class="accordion-content" style="display: block">
                    <div class="module" id="module-seo">
                        <div class="module-content">
                            <h2>SEO</h2>
                            <div id="set4Loader">
                                <div style="text-align:center; display: block" ><img width="350" height="80" src="https://s3.amazonaws.com/images_ranktracker/load.gif"/></div>
                            </div>
                            <div id="seo">
                                <div class="criterium result-2 " id="criterium-www_resolve">

                                    <div class="criterium-head">
                                        <span class="crit-score-pond hidden">1.196</span>

                                        <h3 data-original-title="Room for improvement" rel="tooltip" data-placement="left" class="simple-tooltip">
                                            WWW Resolve
                                        </h3>

                                        <div class="icons">
                                            <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                            <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                        </div>
                                    </div>
                                    <div class="criterium-content">
                                        <div class="part text " >
                                            <p id="wwwresolve"><%-- out.print("" + rp.www_resolve);  commonseo--%></p>
                                        </div>
                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">
                                        <p>Ut wisi enim ad minim veniam,
                                            <a target="_blank" href="#" class="" rel="nofollow"></a>and <a target="_blank" href="#" class="" rel="nofollow">Lorem</a></p>
                                        <p><a target="_blank" href="#" rel="nofollow">Redirecting requests</a> from a non-preferred hostname is <a target="_blank" href="#">important</a> </p>
                                        <p>Once your preferred domain is set, use a.</p>
                                    </div>

                                    <div class="delimiter"></div>
                                </div>
                                <div class="criterium result-3 " id="criterium-clean_url">
                                    <div class="criterium-head">

                                        <h3 data-original-title="Errors to fix" rel="tooltip" data-placement="left" class="simple-tooltip">
                                            URL Rewrite
                                        </h3>
                                        <div class="icons" >
                                            <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">Low impact</i>
                                            <i data-original-title="Hard to solve" rel="tooltip" data-placement="top" class="solvability-2 simple-tooltip">Hard to solve</i>
                                        </div>
                                    </div>
                                    <div class="criterium-content">
                                        <div class="part text " id="urlDomain">

                                        </div>
                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">
                                        <p>Consider <a target="_blank" href="http://coding.smashingmagazine.com/2011/11/02/introduction-to-url-rewriting/" rel="nofollow">rewriting your URLs</a>.
                                            <br><a target="_blank" href="#" rel="nofollow">Need Lorem</a> Claritas
                                        </p>
                                    </div>

                                    <div class="delimiter"></div>
                                </div>
                                <div class="criterium result-3 " id="criterium-ip_canonicalization">
                                    <div class="criterium-head">


                                        <h3 data-original-title="Errors to fix" rel="tooltip" data-placement="left" class="simple-tooltip">
                                            IP Canonicalization
                                        </h3>

                                        <div class="icons">
                                            <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">Low impact</i>
                                            <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                        </div>
                                    </div>
                                    <div class="criterium-content">
                                        <div class="part text ">
                                            <p id="ipCanonicalization"><%-- out.print("" + rp.ipcanonicalization);  commonseo--%></p>
                                        </div>
                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">
                                    </div>

                                    <div class="delimiter"></div>
                                </div>
                                <div class="criterium result-3 " id="criterium-robots_txt">
                                    <div class="criterium-head">

                                        <h3 data-original-title="Errors to fix" rel="tooltip" data-placement="left" class="simple-tooltip">
                                            Robots.txt
                                        </h3>

                                        <div class="icons">
                                            <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                            <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                        </div>
                                    </div>
                                    <div class="criterium-content">
                                        <div class="part text ">
                                            <p><span class="italic" id="robots"><%-- out.print("" + rp.robots);--%></span>
                                            </p>
                                        </div>

                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sin aliud quid voles, postea.
                                            Num igitur utiliorem tibi hunc Triarium putas esse posse, quam si tua sint Puteolis granaria?</p>
                                        <p>A <a target="_blank" href="#" rel="nofollow">robots.txt file</a> 
                                            Expectoque quid ad id, quod quaerebam, respondeas. Deinde disputat, quod cuiusque generis animantium statui deceat extremum. Quibusnam praeteritis?.</p>
                                    </div>

                                    <div class="delimiter"></div>
                                </div>
                                <div class="criterium result-3 " id="criterium-xml_sitemaps">
                                    <div class="criterium-head">
                                        <h3 data-original-title="Errors to fix" rel="tooltip" data-placement="left" class="simple-tooltip">
                                            XML Sitemap
                                        </h3>
                                        <div class="icons">
                                            <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">Low impact</i>
                                            <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                        </div>
                                    </div>
                                    <div class="criterium-content">
                                        <div class="part text ">


                                            <table id="xmltable"> 
                                                <tr><td>SN.</td><td>Path</td></tr>

                                            </table>



                                            <center>
                                                <a id="seeMoreRecords" value="More">Show More</a></br>
                                                <a id="seeLessRecords" value="Less">Show Less</a>
                                            </center>

                                        </div>


                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">


                                        <p>A <a target="_blank" href="#" rel="nofollow">robots.txt file</a> Expectoque quid ad id, quod quaerebam, respondeas. 
                                            Deinde disputat, quod cuiusque generis animantium statui deceat extremum. Quibusnam praeteritis?.</p>
                                    </div>

                                    <div class="delimiter"></div>
                                </div>
                                <div class="criterium result-3 " id="criterium-underscores_url">
                                    <div class="criterium-head">

                                        <h3 data-original-title="Errors to fix" rel="tooltip" data-placement="left" class="simple-tooltip">
                                            Underscores in the URLs
                                        </h3>

                                        <div class="icons">
                                            <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">Low impact</i>
                                            <i data-original-title="Hard to solve" rel="tooltip" data-placement="top" class="solvability-2 simple-tooltip">Hard to solve</i>
                                        </div>
                                    </div>
                                    <div class="criterium-content">
                                        <div class="part text ">
                                            <p id="underscores"><%--= rp.underscores_in_url--%></p>
                                        </div>

                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">

                                        Ita multo sanguine profuso in laetitia et in victoria est mortuus. Si longus, levis; Duo Reges: constructio interrete. 
                                        Gloriosa ostentatio in constituendo summo bono. Tu quidem reddes; Que Manilium, ab iisque M. Nihil opus est exemplis hoc facere longius.
                                    </div>

                                    <div class="delimiter"></div>
                                </div>
                                <div class="criterium result-0 " id="criterium-google_preview">
                                    <div class="criterium-head">

                                        <h3>
                                            Google Preview
                                        </h3>

                                        <div class="icons">
                                            <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                            <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                        </div>
                                    </div>
                                    <div class="criterium-content">
                                        <div class="part text google-preview">
                                            <p id="reviewGoogleTitle"><%---= rp.gps.line1--%></p>
                                            <p><span class="bold" id="reviewGoogleDesc"><%--= rp.gps.line2--%></span>/</p>
                                            <p id="reviewGoogleUrl"><%--= rp.gps.line3--%></p>
                                        </div>

                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">
                                        This is an example of what your title and description will look like in search results.

                                    </div>

                                    <div class="delimiter"></div>
                                </div>

                                <div class="criterium result-1 " id="criterium-flash">
                                    <div class="criterium-head">
                                        <span class="crit-score-pond hidden">0.478</span>

                                        <h3 class="simple-tooltip" data-original-title="Successfully passed" rel="tooltip" data-placement="left"> Google Publisher </h3>

                                        <div class="icons">
                                            <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">Low impact</i>
                                            <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                        </div>
                                    </div>
                                    <div class="criterium-content">
                                        <div class="part text ">
                                            <p id="googlePublisher"></p>
                                        </div>
                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">
                                        <p></p>
                                    </div>

                                    <div class="delimiter"></div>
                                </div>       

                                <div class="criterium result-1 " id="criterium-title">
                                    <div class="criterium-head">
                                        <span class="crit-score-pond hidden">1.435</span>

                                        <h3 data-original-title="Successfully passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                            Title
                                        </h3>

                                        <div class="icons">
                                            <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                            <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                        </div>
                                    </div>
                                    <div class="criterium-content">
                                        <div class="part text ">
                                            <p itemprop="headline" id="title"></p>
                                            <p><span class="bold">Length:</span><span id="titleLength"></span>character(s)</p>
                                        </div>

                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">
                                        <p>Lorem ipsum dolor sit amet, has ex posse vituperata, usu ea augue nulla impetus, ea audire utamur insolens quo. Eum quem sint vituperatoribus eu. 
                                            Pri ad vero recteque. Ut democritum necessitatibus vel, vel adhuc similique
                                            necessitatibus te.</p>
                                    </div>

                                    <div class="delimiter"></div>
                                </div>
                                <div class="criterium result-2 " id="criterium-description">
                                    <div class="criterium-head">
                                        <span class="crit-score-pond hidden">0.718</span>

                                        <h3 data-original-title="Room for improvement" rel="tooltip" data-placement="left" class="simple-tooltip">
                                            Description
                                        </h3>
                                        <div class="icons">
                                            <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                            <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                        </div>
                                    </div>
                                    <div class="criterium-content">
                                        <div class="part text ">
                                            <p itemprop="description" id="description"><%-- out.print (                                                        
                                                    "" + rp.description);--%></p>
                                            <p><span class="bold">Length:</span><%-- out.print (                                                        
                                                "" + rp.description.length());--%> character(s)</p>
                                        </div>

                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">
                                        <p>Ei iusto detracto scripserit qui, in choro option inciderint vim. Cu putent labores praesent eos, detraxit conceptam liberavisse cu vel.
                                            In nam minim forensibus. Ne cum impedit nominati laboramus, ei his integre oporteat
                                            persecuti.
                                        </p>
                                    </div>

                                    <div class="delimiter"></div>
                                </div>
                                <div class="criterium result-0 " id="criterium-meta_keywords">
                                    <div class="criterium-head">
                                        <h3>
                                            Meta Keywords
                                        </h3>
                                        <div class="icons">
                                        </div>
                                    </div>
                                    <div class="criterium-content">
                                        <div class="part text ">
                                            <p itemprop="keywords" id="keyword">


                                            </p>
                                            <p><span class="bold">Length:</span>  <abbr class="big-nbr-container">1<abbr>455</abbr></abbr>character(s)</p>
                                        </div>
                                    </div>
                                    <div class="criterium-advice-click"><span>?</span>
                                    </div>
                                    <div class="criterium-advice">
                                        <p>Ei iusto detracto scripserit qui, in choro option inciderint vim. Cu putent labores praesent eos, detraxit conceptam liberavisse cu vel. In nam minim forensibus.
                                            Ne cum impedit nominati laboramus, ei his integre oporteat
                                            persecuti.
                                        </p>
                                    </div>

                                    <div class="delimiter"></div>
                                </div>
                                <!--<div class="criterium result-3 " id="criterium-inside_pages">-->
                                <!--                                    <div class="criterium-head">
                                                                        <h3 data-original-title="Errors to fix" rel="tooltip" data-placement="left" class="simple-tooltip">
                                                                            Internal Pages Analysis
                                                                        </h3>
                                                                        <div class="icons">
                                                                            <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                                                            <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                                                        </div>
                                                                    </div>-->
                                <!--                                    <div class="criterium-content">
                                
                                                                        <div class="part table ">
                                                                            <table class="no-header">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th>Title</th>
                                                                                        <th>Description</th>
                                                                                        <th>Text/HTML</th>
                                                                                    </tr>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr class="">
                                                                                        <td><a href="#" target="_blank" rel="nofollow" class="">      </a>
                                                                                        </td>
                                                                                        <td>               </td>
                                                                                        <td></td>
                                                                                    </tr>
                                                                                    <tr class="">
                                                                                        <td><a href="#" target="_blank" rel="nofollow" class="">      </a>
                                                                                        </td>
                                                                                        <td>               </td>
                                                                                        <td></td>
                                                                                    </tr>
                                                                                    <tr class="">
                                                                                        <td><a href="#" target="_blank" rel="nofollow" class="">      </a>
                                                                                        </td>
                                                                                        <td>                </td>
                                                                                        <td></td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                
                                                                    </div>-->
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">

                                    <p></p>
                                </div>
                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-3 " id="criterium-headings">
                                <div class="criterium-head">

                                    <h3 data-original-title="Errors to fix" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        Headings
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">Low impact</i>
                                        <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p><span class="italic">H1  <span id="heading1"></span></span>
                                        </p>
                                        <p><span class="italic">H2  <span id="heading2"></span></span>
                                        </p>
                                        <p><span class="italic">H3  <span id="heading3"></span></span>
                                        </p>
                                        <p><span class="italic">H4  <span id="heading4"></span></span>
                                        </p>
                                        <p><span class="italic">H5 <span id="heading5"></span></span>
                                        </p>

                                        <table class="no-header open" id="headingstable">
                                            <tbody>
                                                <tr class="" id="h1elements">
                                                    <!--<td id="h1elements"></td>-->
                                                </tr>

                                                <tr class="over-max-v" id="h2elements">
                                                    <!--<td ></td>-->
                                                </tr>

                                                <tr class="over-max-v" id="h3elements">
                                                    <!--<td id="h3elements"></td>-->
                                                </tr>

                                                <tr class="over-max-v" id="h4elements">
                                                    <!--<td id="h4elements"></td>-->
                                                </tr>

                                                <tr class="over-max-v" id="h5elements">
                                                    <!--<td id="h5elements"></td>-->
                                                </tr>
                                            </tbody>
                                        </table>
                                        <center>
                                            <a id="seeMoreRecords4" value="More">Show More</a></br>
                                            <a id="seeLessRecords4" value="Less">Show Less</a>
                                        </center>
                                    </div>
                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">

                                    <p></p>
                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-1 " id="criterium-images">
                                <div class="criterium-head">
                                    <span class="crit-score-pond hidden">1.435</span>

                                    <h3 data-original-title="Successfully passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        Images
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                        <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div  class="part text ">
                                        <p></p>
                                        <div>
                                            <table id="imagestable">
                                                <tr><td>SN.</td><td>Path</td></tr>

                                            </table>
                                            <center>
                                                <a id="seeMoreRecords1" value="More">Show More</a></br>
                                                <a id="seeLessRecords1" value="Less">Show Less</a>
                                            </center>



                                        </div>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">

                                    <p>Sed haec quidem liberius ab eo dicuntur et saepius. Itaque his sapiens semper vacabit. Sed ad bona praeterita redeamus.
                                        Aliter autem vobis placet. Quid nunc honeste dicit?</p>
                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-3 " id="criterium-text_html_ratio">
                                <div class="criterium-head">

                                    <h3 data-original-title="Errors to fix" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        Text/HTML Ratio
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                        <i data-original-title="Hard to solve" rel="tooltip" data-placement="top" class="solvability-2 simple-tooltip">Hard to solve</i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p id="htmlRatio"><%-- =rp.texttohtmlratio--%></p>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">

                                    <p></p>
                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-1 " id="criterium-flash">
                                <div class="criterium-head">
                                    <span class="crit-score-pond hidden">0.478</span>

                                    <h3 class="simple-tooltip" data-original-title="Successfully passed" rel="tooltip" data-placement="left"> Flash </h3>

                                    <div class="icons">
                                        <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">Low impact</i>
                                        <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p id="flash"></p>
                                    </div>
                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">
                                    <p></p>
                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-1 " id="criterium-frames">
                                <div class="criterium-head">
                                    <span class="crit-score-pond hidden">0.478</span>

                                    <h3 data-original-title="Successfully passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        Frames
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">Low impact</i>
                                        <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p id="frames"><%--= rp.frames--%></p>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">

                                    <p></p>
                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-3 " id="criterium-blog">
                                <div class="criterium-head">

                                    <h3 data-original-title="Errors to fix" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        Blog
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                        <i data-original-title="Hard to solve" rel="tooltip" data-placement="top" class="solvability-2 simple-tooltip">Hard to solve</i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p>We have not found a Blog on this website.</p>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">

                                    <p>Utram tandem linguam nescio? Dicam, inquam, et quidem discendi causa magis, quam quo te aut Epicurum reprehensum velim. 
                                        Nam quibus rebus efficiuntur voluptates, eae non sunt in potestate sapientis.</p>
                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <!--                            <div class="criterium result-2 " id="criterium-inpage_keywords">
                                                            <div class="criterium-head">
                                                                <span class="crit-score-pond hidden">1.196</span>
                            
                                                                <h3 data-original-title="Room for improvement" rel="tooltip" data-placement="left" class="simple-tooltip">
                                                                    Keywords Consistency
                                                                </h3>
                            
                                                                <div class="icons">
                                                                    <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                                                    <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                                                </div>
                                                            </div>
                                                            <div class="criterium-content">
                            
                                                                <div class="part table ">
                                                                    <table class="no-header">
                                                                        <thead>
                                                                            <tr>
                                                                                <th></th>
                                                                                <th>Keywords</th>
                                                                                <th>Freq</th>
                                                                                <th>Title</th>
                                                                                <th>Desc</th>
                                                                                <th>&lt;H&gt;</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                            
                          
                        </tbody>
                    </table>
                </div>

            </div>
            <div class="criterium-advice-click"><span>?</span>
            </div>
            <div class="criterium-advice">
                <p></p>

            </div>

            <div class="delimiter"></div>
        </div>-->
                            <!--                            <div class="criterium result-0 " id="criterium-keywords_cloud">
                                                            <div class="criterium-head">
                            
                                                                <h3>
                                                                    Keywords Cloud
                                                                </h3>
                            
                                                                <div class="icons">
                                                                </div>
                                                            </div>
                                                            <div class="criterium-content">
                            
                                                                <div class="part cloud ">
                                                                    <ul class="cloud-container">
                                                                        <li>XYZ<span class="number">2</span>
                                                                        </li>
                                                                        <li>QWE<span class="number">2</span>
                                                                        </li>
                                                                        <li>ASD<span class="number">2</span>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                            
                                                            </div>
                                                            <div class="criterium-advice-click"><span>?</span>
                                                            </div>
                                                            <div class="criterium-advice">
                                                                <p></p>
                            
                                                            </div>
                            
                                                            <div class="delimiter"></div>
                                                        </div>-->
                            <div class="criterium result-1 " id="criterium-links_details">
                                <div class="criterium-head">
                                    <span class="crit-score-pond hidden">1.435</span>

                                    <h3 data-original-title="Successfully passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        In-Page Links
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">Low impact</i>
                                        <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p> <%--= rp.ipl.links.size()--%> </p>
                                    </div>
                                    <!-------Pie Chart Here---->
                                    <div class="part pie ">

                                    </div>
                                    <!-------Pie Chart End Here---->

                                    <div class="part table ">
                                        <table class="no-header" >

                                            <thead>
                                            <td>Links</td>
                                            <td>Type</td>
                                            <td>Juice</td>
                                            </thead>
                                            <tbody id="inpagelinkstable">

                                                <%-- for (int i = 0;
                                                    i< 2; i

                                                    
                                                        ++) {--%>

                                                <!--
                                                <tr class="">
                                                    <td id="links"><a href='<%--= rp.ipl.links.get(i)--%>' target="_blank" rel="nofollow" class="" id="links"><%--= rp.ipl.title.get(i)--%></a>
                                                    </td>
                                                    <td id="type"><%--= rp.ipl.type.get(i)--%></td>
                                                    <td>Passing Juice</td>
                                                </tr>
    
                                                
                                                <tr class="over-max">
                                                    <td id="links"><a href='<%--= rp.ipl.links.get(i)--%>' target="_blank" rel="nofollow" class="" id="type"><%--= rp.ipl.title.get(i)--%></a>
                                                    </td>
                                                    <td id="type"><%--= rp.ipl.type.get(i)--%></td>
                                                    <td>Passing Juice</td>
                                                </tr>
    
                                                -->
                                                <%-- }--%>

                                            </tbody>
                                        </table>

                                        <center>
                                            <a id="seeMoreRecords3" value="More">Show More</a></br>
                                            <a id="seeLessRecords3" value="Less">Show Less</a>
                                        </center>          


                                        <!--                                        <div class="show-links">
                                                                                    <a class="show-more" href="6">Show more</a>
                                                                                    <a class="show-less" href="6">Show less</a>
                                                                                </div>-->
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">
                                    <p></p>

                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <!--                            <div class="criterium result-1 " id="criterium-backlinks_counter">
                                                            <div class="criterium-head">
                                                                <span class="crit-score-pond hidden">7.177</span>
                            
                                                                <h3 data-original-title="Successfully passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                                                    Backlinks Counter
                                                                </h3>
                            
                                                                <div class="icons">
                                                                    <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                                                    <i data-original-title="Hard to solve" rel="tooltip" data-placement="top" class="solvability-2 simple-tooltip">Hard to solve</i>
                                                                </div>
                                                            </div>
                                                            <div class="criterium-content">
                            
                            
                            
                                                                <div class="part progressbar ">
                            
                                                                    <div class="content">
                            
                            
                                                                        <span class="bar"><span style="width:90%;" class="colored-bar"><abbr class="big-nbr-container">1<abbr>170</abbr><abbr>046</abbr></abbr>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                                                            <span class="value"><abbr class="big-nbr-container">1<abbr>170</abbr><abbr>046</abbr></abbr></span></span>
                                                                    </div>
                                                                </div>
                            
                                                            </div>
                                                            <div class="criterium-advice-click"><span>?</span>
                                                            </div>
                                                            <div class="criterium-advice">
                                                                <p>Lorem ipsum dolor sit amet, dolorem consequat ea est, ius ea noster perfecto constituto. Esse vero ridens et sed. Idque fabellas has et. Munere semper volutpat his ei.</p>
                                                                <p>Eam eu modus interesset theophrastus. Nec ea invidunt eleifend. Cu eius harum saepe mel. Ea odio tation sensibus mea, id vis elitr malorum. Per euripidis tincidunt accommodare no.</p>
                            
                                                            </div>
                            
                                                            <div class="delimiter"></div>
                                                        </div>-->
                            <div class="criterium result-1 " id="criterium-page_rank">
                                <div class="criterium-head">
                                    <span class="crit-score-pond hidden">7.177</span>

                                    <h3 data-original-title="Successfully passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        PageRank
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="High impact" rel="tooltip" data-placement="top" class="importance-3 simple-tooltip">High impact</i>
                                        <i data-original-title="Very hard to solve" rel="tooltip" data-placement="top" class="solvability-3 simple-tooltip">Very hard to solve</i>
                                    </div>
                                </div>
                                <div class="criterium-content">

                                    <div class="part progressbar ">

                                        <div class="content">

                                            <span class="bar"><span style="width:70%;" class="colored-bar" id="pageRank">
                                                    &nbsp;&nbsp;&nbsp;&nbsp;</span><span class="value">PR 7</span></span>
                                        </div>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">

                                    <p>Eos et case cetero, mucius doming ex vis.</p>
                                    <p>Eos et case cetero, mucius doming ex vis. Fugit labores pro cu, duo graece percipitur ne. Sed ad quis gubergren. His primis vidisse posidonium ut. Per ad copiosae principes, ad mei munere persius.</p>
                                    <p></p>
                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-0 " id="criterium-related_websites">
                                <div class="criterium-head">
                                    <!--<span class="crit-score-pond hidden">2.392</span>-->
                                    <h3>
                                        Related Websites
                                    </h3>

                                    <div class="icons">
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part table ">
                                        <table class="no-header" id="relatedtable">

                                            <tr>
                                                <td>N°</td>
                                                <td>URL</td>

                                            </tr>
                                        </table>
                                        <center>
                                            <a id="seeMoreRecords2" value="More">Show More</a></br>
                                            <a id="seeLessRecords2" value="Less">Show Less</a>
                                        </center>

                                    </div>
                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">
                                    <p></p>

                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-1 " id="criterium-indexed_pages">
                                <div class="criterium-head">
                                    <span class="crit-score-pond hidden">9.569</span>

                                    <h3 data-original-title="Successfully passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        Indexed Pages
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                        <i data-original-title="Hard to solve" rel="tooltip" data-placement="top" class="solvability-2 simple-tooltip">Hard to solve</i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part progressbar ">

                                        <div class="content has-title">
                                            <span class="bar"><span style="width:95%;" class="colored-bar"><abbr class="big-nbr-container">14<abbr>400</abbr></abbr>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                                <span class="value"><abbr class="big-nbr-container">14<abbr>400</abbr></abbr></span></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">
                                    <p></p>
                                    <p></p>

                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <!--                            <div class="criterium result-0 " id="criterium-popular_pages">
                                                            <div class="criterium-head">
                                                                <h3>
                                                                    Popular Pages
                                                                </h3>
                                                                <div class="icons">
                                                                </div>
                                                            </div>
                                                            <div class="criterium-content">
                                                                <div class="part text ">
                                                                    <p><a target="_blank" rel="nofollow" href="#" class="">XYZ</a>
                                                                    </p>
                                                                    <p><a target="_blank" rel="nofollow" href="#" class="">XYZ</a>
                                                                    </p>
                                                                    <p><a target="_blank" rel="nofollow" href="#" class="">XYZ</a>
                                                                    </p>
                                                                    <p><a target="_blank" rel="nofollow" href="#" class="">XYZ</a>
                                                                    </p>
                                                                </div>
                                                            </div>
                                                            <div class="criterium-advice-click"><span>?</span>
                                                            </div>
                                                            <div class="criterium-advice">
                                                                <p></p>
                            
                                                            </div>
                                                            <div class="delimiter"></div>
                                                        </div>-->
                            <div class="criterium result-1 " id="criterium-domain_creation">
                                <div class="criterium-head">
                                    <span class="crit-score-pond hidden">2.392</span>
                                    <h3 data-original-title="Successfully passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        Domain 1st Registered
                                    </h3>
                                    <div class="icons">
                                        <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p itemprop="dateCreated" id="domainCreated"><%--= rp.di.created_date--%></p>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">

                                    <p></p>
                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-1 " id="criterium-domain_expiration">
                                <div class="criterium-head">
                                    <span class="crit-score-pond hidden">2.392</span>

                                    <h3 data-original-title="Successfully passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        Domain Expiration
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                        <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p id="domainExpired"><%--= rp.di.expited_date--%></p>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">
                                    <p></p>

                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-1 " id="criterium-domain_expiration">
                                <div class="criterium-head">
                                    <span class="crit-score-pond hidden">2.392</span>

                                    <h3 data-original-title="Successfully passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        Domain Updated
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">Medium impact</i>
                                        <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">Easy to solve</i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p id="domainUpdated"><%--= rp.di.updated_date--%></p>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">
                                    <p></p>

                                </div>

                                <div class="delimiter"></div>
                            </div>        
                        </div>
                    </div>
                </div>
            </div>

            <h2 class="accordion-header">Technologies</h2>
            <div class="accordion-content" style="display: block">

                <div id="module-technologies" class="module">
                    <div class="module-content">
                        <h2>Technologies</h2>
                        <div id="set5Loader">
                            <div style="text-align:center; display: block" ><img width="350" height="80" src="https://s3.amazonaws.com/images_ranktracker/load.gif"/></div>
                        </div>
                        <div id="technologies">
                            <div class="criterium result-0 " id="criterium-ip_information">
                                <div class="criterium-head">

                                    <h3 data-original-title="Low impact" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        <span class="icn"></span>Server IP
                                    </h3>

                                    <div class="icons">
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p id="ipaddress"><%--= rp.ipaddress--%></p>
                                        <p itemprop="contentLocation"><span class="bold">Server location:</span>
                                            <i id="flagcode111" class=""></i>
                                            <span id="location"></span></p>
                                    </div>
                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">
                                    <p>Your server's IP address <a target="_blank" href="#" rel="nofollow">has little impact</a>
                                        on your SEO. Nevertheless, try to host your website on a server which is geographically close to your visitors. 
                                        Search engines take the geolocation of a server into account as well as the server speed.</p>
                                    <p>Use <a target="_blank" href="#" rel="nofollow">DNSstuff</a> for comprehensive reports on your server.</p>

                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-0 " id="criterium-technologies">
                                <div class="criterium-head">

                                    <h3 data-original-title="Low impact" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        <i class="icn"></i>Technologies
                                    </h3>

                                    <div class="icons">
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text " >
                                        <table class="no-header">

                                            <tbody id="technologytable">
                                            </tbody>
                                        </table>


                                        <p id="technologyused"></p>





                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">
                                    <p>Get to know the technologies used for your website. Some codes might slow down your website. Ask your webmaster to take a look at this.</p>

                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-2 " id="criterium-speed_tips">
                                <div class="criterium-head">

                                    <h3 data-original-title="To Improve" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        <span class="icn"></span>Speed Tips
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Medium impact" rel="tooltip" data-placement="top" class="importance-2 simple-tooltip">
                                            <i class="icn icn-bullet-impact"></i><i class="icn icn-bullet-impact"></i><i class="icn icn-bullet-impact"></i>
                                            <span>Medium impact</span>
                                        </i>
                                        <i data-original-title="Hard to solve" rel="tooltip" data-placement="top" class="solvability-2 simple-tooltip">
                                            <i class="icn icn-gear"></i><i class="icn icn-gear"></i><i class="icn icn-gear"></i>
                                            <span>Hard to solve</span>
                                        </i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p>Watch out: your website?s speed could be slightly improved.</p>
                                    </div>

                                    <div class="part text ">
                                        <p><span class="icon grey-found"></span>Perfect, your server is using a caching method to speed up page display.&nbsp;</p>
                                        <p><span class="icon grey-found"></span>Perfect, your website doesn't use nested tables.</p>
                                        <p><span class="icon grey-missing"></span>Too bad, your website is using inline styles.</p>
                                        <p><span class="icon grey-missing"></span>Too bad, your website has too many CSS files (more than 4).</p>
                                        <p><span class="icon grey-found"></span>Perfect, your website has few JavaScript files.</p>
                                        <p><span class="icon grey-found"></span>Perfect, your website takes advantage of <a target="_blank" href="#" rel="nofollow">gzip</a>.</p>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">
                                    <p>Website speed has a huge effect on SEO. ?<a target="_blank" href="#" rel="nofollow">??Speed-up your website</a> so search engines will reward you by sending more visitors.
                                        <br>Also, conversion rates are far higher for websites that load faster than their slower competitors.</p>

                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-3 " id="criterium-analytics_technologies">
                                <div class="criterium-head">


                                    <h3 data-original-title="Errors" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        <span class="icn"></span>Analytics
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">
                                            <i class="icn icn-bullet-impact"></i><i class="icn icn-bullet-impact"></i><i class="icn icn-bullet-impact"></i>
                                            <span>Low impact</span>
                                        </i>
                                        <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">
                                            <i class="icn icn-gear"></i><i class="icn icn-gear"></i><i class="icn icn-gear"></i>
                                            <span>Easy to solve</span>
                                        </i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <table class="no-head">
                                            <thead>
                                            <td></td>
                                            </thead>
                                            <tbody id="analyticstable">

                                            </tbody>
                                        </table>


                                        <p id="analytics"></p>

                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">
                                    <p>Web analytics let you measure visitor activity on your website. You should have at least one analytics tool installed. 
                                        It is also good to install one extra tool to have a confirmation of the results.</p>
                                    <p>Analytics Tools: <a target="_blank" href="#" rel="nofollow">Google&trade; Analytics</a>, <a target="_blank" href="#" rel="nofollow">Quantcast&trade;</a>, 
                                        <a target="_blank" href="#" rel="nofollow">SiteCatalyst&trade;</a>, <a target="_blank" href="#" rel="nofollow">Piwik&trade;</a>, <a target="_blank" href="#" rel="nofollow">chartbeat&trade;</a>, 
                                        <a target="_blank" href="#" rel="nofollow">Clicky&trade;</a>, <a target="_blank" href="#" rel="nofollow">ClickTale&trade;</a>, etc.</p>

                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-3 " id="criterium-w3c_validity">
                                <div class="criterium-head">


                                    <h3 data-original-title="Errors" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        <span class="icn"></span>W3C Validity
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">
                                            <i class="icn icn-bullet-impact"></i><i class="icn icn-bullet-impact"></i><i class="icn icn-bullet-impact"></i>
                                            <span>Low impact</span>
                                        </i>
                                        <i data-original-title="Hard to solve" rel="tooltip" data-placement="top" class="solvability-2 simple-tooltip">
                                            <i class="icn icn-gear"></i><i class="icn icn-gear"></i><i class="icn icn-gear"></i>
                                            <span>Hard to solve</span>
                                        </i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p><span class="bold first-letter-cap"></span><span id="w3cvalidity"></span><%--= rp.objw3cDoctypeEncoding.W3CValidity--%></p>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">

                                    <p>Use valid markup that contains no errors. Syntax errors can make your page difficult for search engines to index.</p>
                                    <p>To find the detected errors, run the <a target="_blank" href="#" rel="nofollow">W3C validation service,</a> or check 
                                        <a target="_blank" href="#" rel="nofollow">Validator.nu</a> to make sure you don't miss an error.</p>
                                    <p><a target="_blank" href="#" rel="nofollow">W3C</a> is a consortium that sets web standards.</p>
                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-0 " id="criterium-doctype">
                                <div class="criterium-head">

                                    <h3 data-original-title="Low impact" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        <i class="icn"></i>Doctype
                                    </h3>

                                    <div class="icons">
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p itemprop="fileFormat" id="doctype"><%--= rp.objw3cDoctypeEncoding.Doctype--%></p>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">
                                    <p>Declaring a <a target="_blank" href="#" rel="nofollow">doctype</a> helps web browsers to render content correctly.</p>

                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-1 " id="criterium-encoding">
                                <div class="criterium-head">

                                    <h3 data-original-title="Passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        <i class="icn"></i>Encoding
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">
                                            <i class="icn icn-bullet-impact"></i><i class="icn icn-bullet-impact"></i><i class="icn icn-bullet-impact"></i>
                                            <span>Low impact</span>
                                        </i>
                                        <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">
                                            <i class="icn icn-gear"></i><i class="icn icn-gear"></i><i class="icn icn-gear"></i>
                                            <span>Easy to solve</span>
                                        </i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p id="encoding"><%--= rp.objw3cDoctypeEncoding.Encoding--%></p>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">

                                    <p>Great, language/character encoding is specified.</p>
                                    <p>Specifying language/character encoding can prevent problems with the rendering of
                                        <a target="_blank" href="#" rel="nofollow">special characters</a>.</p>
                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-1 hidden " id="criterium-deprecated_html_element">
                                <div class="criterium-head">

                                    <h3 data-original-title="Passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        <span class="icn"></span>Deprecated HTML
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">
                                            <i class="icn icn-bullet-impact"></i><i class="icn icn-bullet-impact"></i><i class="icn icn-bullet-impact"></i>
                                            <span>Low impact</span>
                                        </i>
                                        <i data-original-title="Hard to solve" rel="tooltip" data-placement="top" class="solvability-2 simple-tooltip">
                                            <i class="icn icn-gear"></i><i class="icn icn-gear"></i><i class="icn icn-gear"></i>
                                            <span>Hard to solve</span>
                                        </i>
                                    </div>
                                </div>
                                <div class="criterium-content">

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">
                                    <p>Deprecated HTML tags are HTML tags that are no longer used. It is recommended that you remove or replace these HTML tags because they are now obsolete.</p>

                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-1 " id="criterium-directory_browsing">
                                <div class="criterium-head">

                                    <h3 data-original-title="Passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        <i class="icn"></i>Directory Browsing
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">
                                            <span class="icn icn-bullet-impact"></span><span class="icn icn-bullet-impact"></span><span class="icn icn-bullet-impact"></span>
                                            <span>Low impact</span>
                                        </i>
                                        <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">
                                            <span class="icn icn-gear"></span><span class="icn icn-gear"></span><span class="icn icn-gear"></span>
                                            <span>Easy to solve</span>
                                        </i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p>No</p>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">

                                    <p>Great! Your server prevents visitors from browsing your directory by accessing it directly, this is excellent from a security standpoint.</p>
                                </div>

                                <div class="delimiter"></div>
                            </div>
                            <div class="criterium result-1 " id="criterium-server_signature">
                                <div class="criterium-head">
                                    <span class="crit-score-pond hidden">0.46082949308756</span>

                                    <h3 data-original-title="Passed" rel="tooltip" data-placement="left" class="simple-tooltip">
                                        <span class="icn"></span>Server Signature
                                    </h3>

                                    <div class="icons">
                                        <i data-original-title="Low impact" rel="tooltip" data-placement="top" class="importance-1 simple-tooltip">
                                            <span class="icn icn-bullet-impact"></span><span class="icn icn-bullet-impact"></span><span class="icn icn-bullet-impact"></span>
                                            <span>Low impact</span>
                                        </i>
                                        <i data-original-title="Easy to solve" rel="tooltip" data-placement="top" class="solvability-1 simple-tooltip">
                                            <span class="icn icn-gear"></span><span class="icn icn-gear"></span><span class="icn icn-gear"></span>
                                            <span>Easy to solve</span>
                                        </i>
                                    </div>
                                </div>
                                <div class="criterium-content">
                                    <div class="part text ">
                                        <p>No</p>
                                    </div>

                                </div>
                                <div class="criterium-advice-click"><span>?</span>
                                </div>
                                <div class="criterium-advice">

                                    <p>Good, your server signature is off. This is excellent from a security standpoint.</p>
                                </div>

                                <div class="delimiter"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--
                    End Accordion
    -->

    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script type="text/javascript">

            $(document).ready(function() {
                $("#visitorsnew").hide();
                $("#facebook").hide();
                $("#googleplus").hide();
                $("#mobile").hide();
                $("#seo").hide();
                $("#technologies").hide();
                $("#localozation").hide();
                setTimeout(function() {
                    var url = document.getElementById('websearchurl').value;
                    var imagessrnumber = 1;
                    var pagelinkshumber = 1;
                    alert(url);
                    $.ajax({
                        type: 'POST',
                        url: '${contextPath}/reviews/visitors/' + url + "/",
                        data: {websearchurl: url},
                        beforeSend: function(xhr) {
                            xhr.setRequestHeader("Accept", "application/json");
                            xhr.setRequestHeader("Content-Type", "application/json");
                        },
                        success: function(responsejson) {
                            console.log(responsejson);

                            $('#set1Loader').hide();
                            $('#set2Loader').hide();
                            $('#set3Loader').hide();
                            $('#set4Loader').hide();
                            $('#set5Loader').hide();
                            $('#set11Loader').hide();
                            $("#visitorsnew").show();
                            $("#facebook").show();
                            $("#googleplus").show();
                            $("#mobile").show();
                            $("#seo").show();
                            $("#technologies").show();
                            $("#localozation").show();

                            $.each(responsejson.imagedata, function(key, value) {
//

                                for (var i = 0; i < 1; i++) {
                                    document.getElementById("imagestable").innerHTML = document.getElementById("imagestable").innerHTML + "<tr><td>" + imagessrnumber + "</td><td>" + value + "</td></tr>";
                                    imagessrnumber++;
                                }

                                var trs = $("#imagestable tr");
                                var btnMore = $("#seeMoreRecords1");
                                var btnLess = $("#seeLessRecords1");
                                var trsLength = trs.length;
                                var currentIndex = 3;

                                trs.hide();
                                trs.slice(0, 3).show();
                                checkButton();

                                btnMore.click(function(e) {
                                    e.preventDefault();
                                    $("#imagestable tr").slice(currentIndex, currentIndex + 6).show();
                                    currentIndex += 6;
                                    checkButton();
                                });

                                btnLess.click(function(e) {
                                    e.preventDefault();
                                    $("#imagestable tr").slice(currentIndex - 3, currentIndex).hide();
                                    currentIndex -= 3;
                                    checkButton();
                                });

                                function checkButton() {
                                    var currentLength = $("#imagestable tr:visible").length;

                                    if (currentLength >= trsLength) {
                                        btnMore.hide();
                                    } else {
                                        btnMore.show();
                                    }

                                    if (trsLength > 6 && currentLength > 6) {
                                        btnLess.show();
                                    } else {
                                        btnLess.hide();
                                    }

                                }
                            });

                            var type;
                            $.each(responsejson.pagelinksdata, function(i, j) {
//                                console.log(i);
//                                console.log(j);
                                for (var i = 0; i < 1; i++) {
                                    var sample = "<tr><td>" + j.links + "</td><td>" + j.type + "</td><td>" + j.title + "</td></tr>";
                                    $('#inpagelinkstable').append(sample);
                                }
//                                if (i.contains('type')) {
//                                    type = j;
//                                }
//                                if (!i.contains('type')) {
//                                    var sample = "<tr><td>" + j + "</td><td>" + type + "</td><td>Title</td></tr>";
//                                    $('#inpagelinkstable').append(sample);
//                                }

                                var trs = $("#inpagelinkstable tr");
                                var btnMore = $("#seeMoreRecords3");
                                var btnLess = $("#seeLessRecords3");
                                var trsLength = trs.length;
                                var currentIndex = 3;

                                trs.hide();
                                trs.slice(0, 3).show();
                                checkButton();

                                btnMore.click(function(e) {
                                    e.preventDefault();
                                    $("#inpagelinkstable tr").slice(currentIndex, currentIndex + 6).show();
                                    currentIndex += 6;
                                    checkButton();
                                });

                                btnLess.click(function(e) {
                                    e.preventDefault();
                                    $("#inpagelinkstable tr").slice(currentIndex - 3, currentIndex).hide();
                                    currentIndex -= 3;
                                    checkButton();
                                });

                                function checkButton() {
                                    var currentLength = $("#inpagelinkstable tr:visible").length;

                                    if (currentLength >= trsLength) {
                                        btnMore.hide();
                                    } else {
                                        btnMore.show();
                                    }

                                    if (trsLength > 6 && currentLength > 6) {
                                        btnLess.show();
                                    } else {
                                        btnLess.hide();
                                    }

                                }

                            });

                            var relatednumber = 1;
                            $.each(responsejson.relatedwebsite, function(key, value) {



                                for (var i = 0; i < 1; i++) {
                                    document.getElementById("relatedtable").innerHTML = document.getElementById("relatedtable").innerHTML + "<tr><td>" + relatednumber + "</td><td>" + value + "</td></tr>";
                                    relatednumber++;
                                }

                                var trs = $("#relatedtable tr");
                                var btnMore = $("#seeMoreRecords2");
                                var btnLess = $("#seeLessRecords2");
                                var trsLength = trs.length;
                                var currentIndex = 3;

                                trs.hide();
                                trs.slice(0, 3).show();
                                checkButton();

                                btnMore.click(function(e) {
                                    e.preventDefault();
                                    $("#relatedtable tr").slice(currentIndex, currentIndex + 4).show();
                                    currentIndex += 4;
                                    checkButton();
                                });

                                btnLess.click(function(e) {
                                    e.preventDefault();
                                    $("#relatedtable tr").slice(currentIndex - 3, currentIndex).hide();
                                    currentIndex -= 3;
                                    checkButton();
                                });

                                function checkButton() {
                                    var currentLength = $("#relatedtable tr:visible").length;

                                    if (currentLength >= trsLength) {
                                        btnMore.hide();
                                    } else {
                                        btnMore.show();
                                    }

                                    if (trsLength > 10 && currentLength > 10) {
                                        btnLess.show();
                                    } else {
                                        btnLess.hide();
                                    }

                                }


                            });


                            var tech;
                            $.each(responsejson.technologydata, function(i, j) {
//                                console.log(i);
//                                console.log(j);

                                if (i.contains('technologyused')) {
                                    var sample = "<tr><td>" + j + "</td><td>" + "</td><td></td></tr>";
                                    $('#technologytable').append(sample);
                                }

                                if (i.contains('analytics')) {
                                    var sample1 = "<tr><td>" + j + "</td><td>" + "</td><td></td></tr>";
                                    $('#analyticstable').append(sample1);
                                }

                            });

                            $.each(responsejson.visitorarray, function(i, j) {

//                                console.log(i);
//                                console.log(j);
//                                                               
//                                 if (i.contains('type')) {
//                                    type = j;
//                                }
//                                if (!i.contains('type')) {
                                var sample = "<tr><td>" + j.country + "</td><td>" + j.percent + "</td><td>" + j.rank + "</td></tr>";
                                $('#visitortable').append(sample);
//                                }


                            });
                            var xmlnumber = 1;
                            $.each(responsejson.xmldata, function(key, value) {

                                for (var i = 0; i < 1; i++) {

                                    document.getElementById("xmltable").innerHTML = document.getElementById("xmltable").innerHTML + "<tr><td>" + xmlnumber + "</td><td>" + value + "</td></tr>";
                                    xmlnumber++;
                                }
                                var trs = $("#xmltable tr");
                                var btnMore = $("#seeMoreRecords");
                                var btnLess = $("#seeLessRecords");
                                var trsLength = trs.length;
                                var currentIndex = 3;

                                trs.hide();
                                trs.slice(0, 3).show();
                                checkButton();

                                btnMore.click(function(e) {
                                    e.preventDefault();
                                    $("#xmltable tr").slice(currentIndex, currentIndex + 6).show();
                                    currentIndex += 6;
                                    checkButton();
                                });

                                btnLess.click(function(e) {
                                    e.preventDefault();
                                    $("#xmltable tr").slice(currentIndex - 3, currentIndex).hide();
                                    currentIndex -= 3;
                                    checkButton();
                                });

                                function checkButton() {
                                    var currentLength = $("#xmltable tr:visible").length;

                                    if (currentLength >= trsLength) {
                                        btnMore.hide();
                                    } else {
                                        btnMore.show();
                                    }

                                    if (trsLength > 6 && currentLength > 6) {
                                        btnLess.show();
                                    } else {
                                        btnLess.hide();
                                    }

                                }

                            });


                            $.each(responsejson.headingcount, function(key, value) {

                                if (key === 'heading1') {
                                    $('#heading1').text(value);
                                }
                                if (key === 'heading2') {
                                    document.getElementById("heading2").textContent = value;
                                }
                                if (key === 'heading3') {
                                    $('#heading3').html(value);
                                }
                                if (key === 'heading4') {
                                    $('#heading4').html(value);
                                }
                                if (key === 'heading5') {
                                    $('#heading5').html(value);
                                }
                            });
                            $.each(responsejson.headingelements, function(i, j) {

//                                console.log(i);
//                                console.log(j);


                                if (i.contains('h1elements')) {
                                    if (j.contains('h1')) {
                                        j = j.replace('h1', '');
                                    }
                                    $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H1&gt;</span>" + j + "</td></tr>");
//                                   
                                }
                                if (i.contains('h2elements')) {
                                    if (j.contains('h2')) {
                                        j = j.replace('h2', '');
                                    }
                                    $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H2&gt;</span>" + j + "</td></tr>");
//                                    $("#headingtable2").val("<td id=\"h2element\"><span class=\"bold\">&lt;h2&gt;</span></td><tr><td>" + "<span></span>" + j + "</td></td>");
                                }
                                if (i.contains('h3elements')) {
                                    if (j.contains('h3')) {
                                        j = j.replace('h3', '');
                                    }
                                    $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H3&gt;</span>" + j + "</td></tr>");
//                                    $("#headingtable3").val("<td id=\"h3element\"><span class=\"bold\">&lt;h3&gt;</span></td><tr><td>" + "<span></span>" + j + "</td></td>");
                                }
                                if (i.contains('h4element')) {
                                    if (j.contains('h4')) {
                                        j = j.replace('h4', '');
                                    }
                                    $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H4&gt;</span>" + j + "</td></tr>");
//                                    $("#headingtable4").val("<td id=\"h4element\"><span class=\"bold\">&lt;h4&gt;</span></td><tr><td>" + "<span></span>" + j + "</td></td>");
                                }
                                if (i.contains('h5element')) {
                                    if (j.contains('h5')) {
                                        j = j.replace('h5', '');
                                    }
                                    $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H5&gt;</span>" + j + "</td></tr>");
//                                    $("#headingtable5").val('<td id="h5element"><span class="bold">&lt;h5&gt;</span></td><tr><td><span></span>' + j + '</td></td>');

                                }

                            });

                            $.each(responsejson.visitmap, function(key, value) {

                                if (key === 'wwwresolve') {
                                    document.getElementById("wwwresolve").textContent = value;
                                }
                                if (key === 'ipCanonicalization') {
                                    document.getElementById("ipCanonicalization").textContent = value;
                                }
                                if (key === 'robots') {
                                    document.getElementById("robots").textContent = value;
                                }
                                if (key === 'underscores') {
                                    document.getElementById("underscores").textContent = value;
                                }
                                if (key === 'reviewGoogleTitle') {
                                    document.getElementById("reviewGoogleTitle").textContent = value;
                                }
                                if (key === 'reviewGoogleUrl') {
                                    document.getElementById("reviewGoogleUrl").textContent = value;
                                }
                                if (key === 'reviewGoogleDesc') {
                                    document.getElementById("reviewGoogleDesc").textContent = value;
                                }
                                if (key === 'googlePublisher') {
                                    document.getElementById("googlePublisher").textContent = value;
                                }
                                if (key === 'title') {
                                    document.getElementById("title").textContent = value;
                                }
                                if (key === 'titleLength') {
                                    document.getElementById("titleLength").textContent = value;
                                }
                                if (key === 'description') {
                                    document.getElementById("description").textContent = value;
                                }
                                if (key === 'keyword') {
                                    $("#keyword").text(value);
                                }
                                if (key === 'htmlRatio') {
                                    document.getElementById("htmlRatio").textContent = value;
                                }
                                if (key === 'flash') {
                                    document.getElementById("flash").textContent = value;
                                }
                                if (key === 'frames') {
                                    document.getElementById("frames").textContent = value;
                                }
                                if (key === 'pageRank') {
                                    document.getElementById("pageRank").textContent = value;
                                }
                                if (key === 'domainCreated') {
                                    document.getElementById("domainCreated").textContent = value;
                                }
                                if (key === 'domainUpdated') {
                                    document.getElementById("domainUpdated").textContent = value;
                                }
                                if (key === 'domainExpired') {
                                    document.getElementById("domainExpired").textContent = value;
                                }
                                if (key === 'ipaddress') {
                                    document.getElementById("ipaddress").textContent = value;
                                }
                                if (key === 'facebookUrl') {
                                    document.getElementById("facebookUrl").textContent = value;
                                }
                                if (key === 'facebookName') {
                                    document.getElementById("facebookName").textContent = value;
                                }
                                if (key === 'facebookLikes') {
                                    document.getElementById("facebookLikes").textContent = value;
                                }
                                if (key === 'facebookProduct') {
                                    document.getElementById("facebookProduct").textContent = value;
                                }
                                if (key === 'takingAbout') {
                                    document.getElementById("takingAbout").textContent = value;
                                }
                                if (key === 'facebookImage') {
                                    $("#facebookImage").attr('src', value);
                                }
                                if (key === 'facebookOverview') {
                                    document.getElementById("facebookOverview").textContent = value;
                                }
                                if (key === 'facebookAddress') {
                                    document.getElementById("facebookAddress").textContent = value;
                                }
                                if (key === 'facebookMission') {
                                    document.getElementById("facebookMission").textContent = value;
                                }
                                if (key === 'facebookPhone') {
                                    document.getElementById("facebookPhone").textContent = value;
                                }
                                if (key === 'facebookAbout') {
                                    document.getElementById("facebookAbout").textContent = value;
                                }
                                if (key === 'googleImage') {
                                    $("#googleImage").attr('src', value);
                                }
                                if (key === 'googleUrl') {
                                    document.getElementById("googleUrl").textContent = value;
                                }
                                if (key === 'googleName') {
                                    document.getElementById("googleName").textContent = value;
                                }
                                if (key === 'googleVerified') {
                                    document.getElementById("googleVerified").textContent = value;
                                }
                                if (key === 'googleTagline') {
                                    document.getElementById("googleTagline").textContent = value;
                                }
                                if (key === 'googleIntroduction') {
                                    document.getElementById("googleIntroduction").textContent = value;
                                }
                                if (key === 'googleOverview') {
                                    document.getElementById("googleOverview").textContent = value;
                                }
                                if (key === 'flagCode') {
                                    $("#flagcode111").attr('class', value);
                                }
                                if (key === 'location') {
                                    document.getElementById("location").textContent = value;
                                }
                                if (key === 'countryRank') {
                                    document.getElementById("countryRank").textContent = value;
                                }
                                if (key === 'globalrank') {
                                    document.getElementById("globalrank").textContent = value;
                                }
                                if (key === 'w3cvalidity') {
                                    document.getElementById("w3cvalidity").textContent = value;
                                }
                                if (key === 'encoding') {
                                    document.getElementById("encoding").textContent = value;
                                }
                                if (key === 'doctype') {
                                    document.getElementById("doctype").textContent = value;
                                }
                                if (key === 'urlDomain') {
                                    document.getElementById("urlDomain").textContent = value;
                                }
                                if (key === 'iphoneView') {
                                    $("#iphoneView").attr('src', value);
                                }
                                if (key === 'ipadView') {
                                    $("#ipadView").attr('src', value);
                                }
                            });
                        }
                    });
                }, 10000);
            });
            /* user defined variables */
            var timeOnSlide = 2,
                    // the time each image will remain static on the screen, measured in seconds
                    timeBetweenSlides = 2,
                    // the time taken to transition between images, measured in seconds

                    // test if the browser supports animation, and if it needs a vendor prefix to do so
                    animationstring = 'animation',
                    animation = false,
                    keyframeprefix = '',
                    domPrefixes = 'Webkit Moz O Khtml'.split(' '),
                    // array of possible vendor prefixes
                    pfx = '',
                    slidy = document.getElementById("slidy");
            if (slidy.style.animationName !== undefined) {
                animation = true;
            }
            // browser supports keyframe animation w/o prefixes

            if (animation === false) {
                for (var i = 0; i < domPrefixes.length; i++) {
                    if (slidy.style[ domPrefixes[i] + 'AnimationName' ] !== undefined) {
                        pfx = domPrefixes[ i ];
                        animationstring = pfx + 'Animation';
                        keyframeprefix = '-' + pfx.toLowerCase() + '-';
                        animation = true;
                        break;
                    }
                }
            }

            if (animation === false) {
                // animate in JavaScript fallback
            } else {
                var images = slidy.getElementsByTagName("img"),
                        firstImg = images[0],
                        // get the first image inside the "slidy" element.
                        imgWrap = firstImg.cloneNode(false); // copy it.
                slidy.appendChild(imgWrap); // add the clone to the end of the images
                var imgCount = images.length, // count the number of images in the slide, including the new cloned element
                        totalTime = (timeOnSlide + timeBetweenSlides) * (imgCount - 1), // calculate the total length of the animation by multiplying the number of _actual_ images by the amount of time for both static display of each image and motion between them
                        slideRatio = (timeOnSlide / totalTime) * 100, // determine the percentage of time an induvidual image is held static during the animation
                        moveRatio = (timeBetweenSlides / totalTime) * 100, // determine the percentage of time for an individual movement
                        basePercentage = 100 / imgCount, // work out how wide each image should be in the slidy, as a percentage.
                        position = 0, // set the initial position of the slidy element
                        css = document.createElement("style"); // start marking a new style sheet
                css.type = "text/css";
                css.innerHTML += "#slidy { text-align: left; margin: 0; font-size: 0; position: relative; width: " + (imgCount * 100) + "%;  }\n"; // set the width for the slidy container
                css.innerHTML += "#slidy img { float: left; width: " + basePercentage + "%; }\n";
                css.innerHTML += "@" + keyframeprefix + "keyframes slidy {\n";
                for (i = 0; i < (imgCount - 1); i++) { // 
                    position += slideRatio; // make the keyframe the position of the image
                    css.innerHTML += position + "% { left: -" + (i * 100) + "%; }\n";
                    position += moveRatio; // make the postion for the _next_ slide
                    css.innerHTML += position + "% { left: -" + ((i + 1) * 100) + "%; }\n";
                }
                css.innerHTML += "}\n";
                css.innerHTML += "#slidy { left: 0%; " + keyframeprefix + "transform: translate3d(0,0,0); " + keyframeprefix + "animation: " + totalTime + "s slidy infinite; }\n"; // call on the completed keyframe animation sequence
                document.body.appendChild(css); // add the new stylesheet to the end of the document
            }

    </script>

    <SCRIPT>
        $(document).ready(function() {
            var showChar = 100;
            var ellipsestext = "...";
            var moretext = "more";
            var lesstext = "less";
            $('.more').each(function() {
                var content = $(this).html();
                if (content.length > showChar) {

                    var c = content.substr(0, showChar);
                    var h = content.substr(showChar - 1, content.length - showChar);
                    var html = c + '<span class="moreelipses">' + ellipsestext + '</span>&nbsp;<span class="morecontent"><span>' + h + '</span>&nbsp;&nbsp;<a href="" class="morelink">' + moretext + '</a></span>';
                    $(this).html(html);
                }

            });
            $(".morelink").click(function() {
                if ($(this).hasClass("less")) {
                    $(this).removeClass("less");
                    $(this).html(moretext);
                } else {
                    $(this).addClass("less");
                    $(this).html(lesstext);
                }
                $(this).parent().prev().toggle();
                $(this).prev().toggle();
                return false;
            });
        });
    </SCRIPT>
    <script>




    </script>
    <!-- Footer start -->
    <div id="footer">		
        <div class="footer_wrapper">
            <!--<div class="footer_left">
                    <div class="footer_left_title">BENEFITS</div>
                <a href="#">Review Management</a>
                <a href="#">Social Media Monitoring</a>
                <a href="#">Marketing & Local SEO</a>
            </div>
            <div class="footer_mid">
                    <div class="footer_mid_title">BLOG</div>
                <a href="#">
                    FOHBOH® & CHATMETER DISRUPTS BILLION DOLLAR MYSTERY SHOPPING INDUSTRY WITH FOHBUZZ
                </a>
                                    <span>	Online Review Management in the new world: 3rd party reviews disappear from Google Places</span>                    
            </div>
            <div class="footer_right">
                    <div class="footer_right_title">CONNECT WITH US</div>
                <a href="#">Facebook</a>
                <a href="#">Twitter</a>
                <a href="#">Linkedin</a>
            </div>-->
            <!--menu-->
            <div id="footer_menu">
                <ul class="footer_menu">
                    <li><a href="privacy.action"><span><span>PRIVACY POLICY</span></span></a></li>
                    <li class="nav3"><a href="http://www.linkedin.com/groups/Globustracker-Reputation-Management-Tool-Indian-40949.S.158870491?" target="_blank"><span>
                                <img src="https://s3.amazonaws.com/images_ranktracker/link_icon.png" width="32" height="32" alt="" /></span></a></li>	
                    <li class="nav3"><a href="https://twitter.com/Globustrackerr" target="_blank"><span><img src="https://s3.amazonaws.com/images_ranktracker/twit_icon.png" width="32" height="32" alt="" /></span></a></li>								
                    <li class="nav3"><a href="https://www.facebook.com/pages/Globustracker/290801504407290" target="_blank"><span><img src="https://s3.amazonaws.com/images_ranktracker/fb_icon.png" width="32" height="32" alt="" /></span></a></li>			
                </ul>
            </div>
            <!--end menu-->
            <div class="footer_bottom">©2013-2014 GlobusTracker. All Rights Reserved. </div>
        </div>	
    </div>
    <!-- Footer end -->
</body>
</html>