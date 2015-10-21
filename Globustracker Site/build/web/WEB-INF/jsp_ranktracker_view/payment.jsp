<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">	
        <title>Best Rank Tracker | SERP Tracker | YouTube Rank Tracker | Social Signals Tracker</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Globussoft">
        <link rel="shortcut icon" href="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />

        <!-- stylesheets -->
        <link href="views/css_ranktracker/theme.css" rel="stylesheet" type="text/css"/>
        <link href="views/css_ranktracker/animate.css" rel="stylesheet" type="text/css"/>
        <link href="views/css_ranktracker/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="views/css_ranktracker/custom.css" rel="stylesheet" type="text/css"/>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

        <style>
            h2 {
                margin-bottom: 0;
            }
            ul {
                margin-bottom: 0;
            }
            .professional, .personal, .business, .master {
                min-height: 670px !important;
            }
        </style>

        <!-- javascript -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="views/js_ranktracker/bootstrap.min.js" type="text/javascript"></script>
        <script src="views/js_ranktracker/theme.js" type="text/javascript"></script>     
        <link href="views/css_ranktracker/main.css" rel="stylesheet" type="text/css"/>
        <script src="views/js_ranktracker/main.js" type="text/javascript"></script>

        <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    </head>
    <body id="pricing">
        <header class="navbar navbar-inverse white navbar-fixed-top" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="home.action" class="navbar-brand"><img src="views/images_ranktracker/Globustracker-logo-present.png" alt="GlobusTracker" class="img-responsive" style="width: 200px;"></a>
                </div>
                <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
                    <ul class="nav navbar-nav  navbar-right">
                        <li class="dropdown">
                            <a href="home.action" >
                                Home
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="home.action#tabs">
                                Features 
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="home.action#pricing" >
                                Pricing 
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="home.action#second-option" >
                                Faq
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="home.action#clients" >
                                Clients
                            </a>
                        </li>
                        <li>
                            <a href="contact.action">
                                Contact us
                            </a>
                        </li>
                        <li>
                            <a href="signIn.action" class="signup visible-md visible-lg">Sign In</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class='sidebarSmall'>
                <a href="#linkedin"><i class="fa fa-linkedin-square fa-3x blue"></i></a>
                <a href="#twitter"><i class="fa fa-twitter-square fa-3x blue"></i></a>
                <a href="#facebook"><i class="fa fa-facebook-square fa-3x blue"></i></a>
                <a href="#youtube"><i class="fa fa-youtube-square fa-3x blue"></i></a>
                <a href="#instagram"><i class="fa fa-instagram-square fa-3x blue"></i></a>
                <a href="#tumblr"><i class="fa fa-tumblr-square fa-3x blue"></i></a>
                <a href="#gplus"><i class="fa fa-google-plus-square fa-3x blue"></i></a>
            </div>
        </header>

        <div id="third-option">
            <div class="container-fluid">
                <div class="wrapper">
                    <!-- PRICING-TABLE CONTAINER -->
                    <div class="pricing-table group">
                        <h1 class="heading">PRICING PLANS</h1>

                        <p>These are the 10 plans that includes a pretty basic one</p>
                        <div class="row">
                            <!-- PERSONAL -->
                            <c:set var="counter" value="0"/>
                            <c:forEach items="${listPlans}" var="plans">
                                <c:set var="counter" value="${counter+1}"/>
                            <!--<h1>${listPlans.get(0).planID}</h1>-->
                                <c:if test="${counter%4 ==1}">

                                    <div class="block personal fl col-md-3">
                                        <h2 class="title">${plans.name}</h2>
                                        <!-- CONTENT -->
                                        <div class="content">
                                            <p class="price">
                                                <sup>$</sup>
                                                <span>${plans.amount}</span>
                                                <sub>/mon.</sub>
                                            </p>
                                        </div><!-- /CONTENT -->
                                        <!-- FEATURES -->
                                        <ul class="features" style="border: #2c968f 1px solid; border-bottom: 0; border-top: 0;">
                                            <li><span class="fa fa-check text-success"></span>${plans.campaigns} Campaigns</li>
                                            <li><span class="fa fa-check text-success"></span>${plans.users} Users</li>
                                            <li><span class="fa fa-check text-success"></span>${plans.keywords}  Keywords </li>
                                                <c:if test="${plans.googleAnalytics ==1}">
                                                <li><span class="fa fa-check text-success"></span>Google Analytics</li>
                                                </c:if>
                                                <c:if test="${plans.googleAnalytics ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Google Analytics</li>
                                                </c:if>
                                                <c:if test="${plans.keywordResearch ==1}">
                                                <li><span class="fa fa-check text-success"></span>Keyword Research</li>
                                                </c:if>
                                                <c:if test="${plans.keywordResearch ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Keyword Research</li>
                                                </c:if>
                                                <c:if test="${plans.webmastertools ==1}">
                                                <li><span class="fa fa-check text-success"></span>Webmaster Tool</li>
                                                </c:if>
                                                <c:if test="${plans.webmastertools ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Webmaster Tool</li>
                                                </c:if>
                                                <c:if test="${plans.websiteReview ==1}">
                                                <li><span class="fa fa-check text-success"></span>Website Review</li>
                                                </c:if>
                                                <c:if test="${plans.websiteReview ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Website Review</li>
                                                </c:if>
                                                <c:if test="${plans.accurateLocalRanking ==1}">
                                                <li><span class="fa fa-check text-success"></span>Accurate Local Ranking</li>
                                                </c:if>
                                                <c:if test="${plans.accurateLocalRanking ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Accurate Local Ranking</li>
                                                </c:if>
                                                <c:if test="${plans.linkAnalysis ==1}">
                                                <li><span class="fa fa-check text-success"></span>Link Analysis</li>
                                                </c:if>
                                                <c:if test="${plans.linkAnalysis ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Link Analysis</li>
                                                </c:if>
                                        </ul><!-- /FEATURES -->
                                        <!-- PT-FOOTER -->
                                        <div class="pt-footer">
                                            <a class="btn btn-0" href="sessionSaver.action?itemName=${plans.name}">&nbsp;&nbsp; Register &nbsp;&nbsp;</a>
                                        </div><!-- /PT-FOOTER -->
                                    </div>
                                </c:if>
                                <c:if test="${counter%4 ==2}">

                                    <div class="block professional fl col-md-3">
                                        <h2 class="title">${plans.name}</h2>
                                        <!-- CONTENT -->
                                        <div class="content">
                                            <p class="price">
                                                <sup>$</sup>
                                                <span>${plans.amount}</span>
                                                <sub>/mon.</sub>
                                            </p>
                                        </div><!-- /CONTENT -->
                                        <!-- FEATURES -->
                                        <ul class="features" style="border: #2c968f 1px solid; border-bottom: 0; border-top: 0;">
                                            <li><span class="fa fa-check text-success"></span>${plans.campaigns} Campaigns</li>
                                            <li><span class="fa fa-check text-success"></span>${plans.users} Users</li>
                                            <li><span class="fa fa-check text-success"></span>${plans.keywords}  Keywords </li>
                                                <c:if test="${plans.googleAnalytics ==1}">
                                                <li><span class="fa fa-check text-success"></span>Google Analytics</li>
                                                </c:if>
                                                <c:if test="${plans.googleAnalytics ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Google Analytics</li>
                                                </c:if>
                                                <c:if test="${plans.keywordResearch ==1}">
                                                <li><span class="fa fa-check text-success"></span>Keyword Research</li>
                                                </c:if>
                                                <c:if test="${plans.keywordResearch ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Keyword Research</li>
                                                </c:if>
                                                <c:if test="${plans.webmastertools ==1}">
                                                <li><span class="fa fa-check text-success"></span>Webmaster Tool</li>
                                                </c:if>
                                                <c:if test="${plans.webmastertools ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Webmaster Tool</li>
                                                </c:if>
                                                <c:if test="${plans.websiteReview ==1}">
                                                <li><span class="fa fa-check text-success"></span>Website Review</li>
                                                </c:if>
                                                <c:if test="${plans.websiteReview ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Website Review</li>
                                                </c:if>
                                                <c:if test="${plans.accurateLocalRanking ==1}">
                                                <li><span class="fa fa-check text-success"></span>Accurate Local Ranking</li>
                                                </c:if>
                                                <c:if test="${plans.accurateLocalRanking ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Accurate Local Ranking</li>
                                                </c:if>
                                                <c:if test="${plans.linkAnalysis ==1}">
                                                <li><span class="fa fa-check text-success"></span>Link Analysis</li>
                                                </c:if>
                                                <c:if test="${plans.linkAnalysis ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Link Analysis</li>
                                                </c:if>

                                        </ul><!-- /FEATURES -->
                                        <!-- PT-FOOTER -->
                                        <div class="pt-footer">
                                            <a class="btn btn-0" href="sessionSaver.action?itemName=${plans.name}">&nbsp;&nbsp; Register &nbsp;&nbsp;</a>
                                        </div><!-- /PT-FOOTER -->
                                    </div>
                                </c:if>
                                <c:if test="${counter%4 ==3}">

                                    <div class="block business fl col-md-3">
                                        <h2 class="title">${plans.name}</h2>
                                        <!-- CONTENT -->
                                        <div class="content">
                                            <p class="price">
                                                <sup>$</sup>
                                                <span>${plans.amount}</span>
                                                <sub>/mon.</sub>
                                            </p>
                                        </div><!-- /CONTENT -->
                                        <!-- FEATURES -->
                                        <ul class="features" style="border: #2c968f 1px solid; border-bottom: 0; border-top: 0;">
                                            <li><span class="fa fa-check text-success"></span>${plans.campaigns} Campaigns</li>
                                            <li><span class="fa fa-check text-success"></span>${plans.users} Users</li>
                                            <li><span class="fa fa-check text-success"></span>${plans.keywords}  Keywords </li>
                                                <c:if test="${plans.googleAnalytics ==1}">
                                                <li><span class="fa fa-check text-success"></span>Google Analytics</li>
                                                </c:if>
                                                <c:if test="${plans.googleAnalytics ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Google Analytics</li>
                                                </c:if>
                                                <c:if test="${plans.keywordResearch ==1}">
                                                <li><span class="fa fa-check text-success"></span>Keyword Research</li>
                                                </c:if>
                                                <c:if test="${plans.keywordResearch ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Keyword Research</li>
                                                </c:if>
                                                <c:if test="${plans.webmastertools ==1}">
                                                <li><span class="fa fa-check text-success"></span>Webmaster Tool</li>
                                                </c:if>
                                                <c:if test="${plans.webmastertools ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Webmaster Tool</li>
                                                </c:if>
                                                <c:if test="${plans.websiteReview ==1}">
                                                <li><span class="fa fa-check text-success"></span>Website Review</li>
                                                </c:if>
                                                <c:if test="${plans.websiteReview ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Website Review</li>
                                                </c:if>
                                                <c:if test="${plans.accurateLocalRanking ==1}">
                                                <li><span class="fa fa-check text-success"></span>Accurate Local Ranking</li>
                                                </c:if>
                                                <c:if test="${plans.accurateLocalRanking ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Accurate Local Ranking</li>
                                                </c:if>
                                                <c:if test="${plans.linkAnalysis ==1}">
                                                <li><span class="fa fa-check text-success"></span>Link Analysis</li>
                                                </c:if>
                                                <c:if test="${plans.linkAnalysis ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Link Analysis</li>
                                                </c:if>
                                        </ul><!-- /FEATURES -->
                                        <!-- PT-FOOTER -->
                                        <div class="pt-footer">
                                            <a class="btn btn-0" href="sessionSaver.action?itemName=${plans.name}">&nbsp;&nbsp; Register &nbsp;&nbsp;</a>
                                        </div><!-- /PT-FOOTER -->
                                    </div>
                                </c:if>
                                <c:if test="${counter%4 ==0}">

                                    <div class="block master fl col-md-3">
                                        <h2 class="title">${plans.name}</h2>
                                        <!-- CONTENT -->
                                        <div class="content">
                                            <p class="price">
                                                <sup>$</sup>
                                                <span>${plans.amount}</span>
                                                <sub>/mon.</sub>
                                            </p>
                                        </div><!-- /CONTENT -->
                                        <!-- FEATURES -->
                                        <ul class="features" style="border: #2c968f 1px solid; border-bottom: 0; border-top: 0;">
                                            <li><span class="fa fa-check text-success"></span>${plans.campaigns} Campaigns</li>
                                            <li><span class="fa fa-check text-success"></span>${plans.users} Users</li>
                                            <li><span class="fa fa-check text-success"></span>${plans.keywords}  Keywords </li>
                                                <c:if test="${plans.googleAnalytics ==1}">
                                                <li><span class="fa fa-check text-success"></span>Google Analytics</li>
                                                </c:if>
                                                <c:if test="${plans.googleAnalytics ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Google Analytics</li>
                                                </c:if>
                                                <c:if test="${plans.keywordResearch ==1}">
                                                <li><span class="fa fa-check text-success"></span>Keyword Research</li>
                                                </c:if>
                                                <c:if test="${plans.keywordResearch ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Keyword Research</li>
                                                </c:if>
                                                <c:if test="${plans.webmastertools ==1}">
                                                <li><span class="fa fa-check text-success"></span>Webmaster Tool</li>
                                                </c:if>
                                                <c:if test="${plans.webmastertools ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Webmaster Tool</li>
                                                </c:if>
                                                <c:if test="${plans.websiteReview ==1}">
                                                <li><span class="fa fa-check text-success"></span>Website Review</li>
                                                </c:if>
                                                <c:if test="${plans.websiteReview ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Website Review</li>
                                                </c:if>
                                                <c:if test="${plans.accurateLocalRanking ==1}">
                                                <li><span class="fa fa-check text-success"></span>Accurate Local Ranking</li>
                                                </c:if>
                                                <c:if test="${plans.accurateLocalRanking ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Accurate Local Ranking</li>
                                                </c:if>
                                                <c:if test="${plans.linkAnalysis ==1}">
                                                <li><span class="fa fa-check text-success"></span>Link Analysis</li>
                                                </c:if>
                                                <c:if test="${plans.linkAnalysis ==0}">
                                                <li><span class="fa fa-times text-danger"></span>Link Analysis</li>
                                                </c:if>
                                        </ul><!-- /FEATURES -->
                                        <!-- PT-FOOTER -->
                                        <div class="pt-footer">
                                            <a class="btn btn-0" href="sessionSaver.action?itemName=${plans.name}">&nbsp;&nbsp; Register &nbsp;&nbsp;</a>
                                        </div><!-- /PT-FOOTER -->
                                    </div>
                                </c:if>
                            </c:forEach>                                                      
                        </div>
                    </div><!-- /PRICING-TABLE -->
                </div>
            </div>
        </div>

        <div id="footer-white">
            <div class="row credits" style="margin-top:-41px">
                <div class="col-md-12">
                    ©2013-2014 GlobusTracker. All Rights Reserved.
                </div>
            </div>
        </div>

        <script type='text/javascript'>
            var _glc = _glc || [];
            _glc.push('all_ag9zfmNsaWNrZGVza2NoYXRyDgsSBXVzZXJzGMKCkH0M');
            var glcpath = (('https:' == document.location.protocol) ? 'https://my.clickdesk.com/clickdesk-ui/browser/' :
                    'http://my.clickdesk.com/clickdesk-ui/browser/');
            var glcp = (('https:' == document.location.protocol) ? 'https://' : 'http://');
            var glcspt = document.createElement('script');
            glcspt.type = 'text/javascript';
            glcspt.async = true;
            glcspt.src = glcpath + 'livechat-new.js';
            var s = document.getElementsByTagName('script')[0];
            s.parentNode.insertBefore(glcspt, s);
        </script>
    </body>
</html>