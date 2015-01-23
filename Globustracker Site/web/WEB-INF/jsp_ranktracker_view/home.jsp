<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">   
        <title>Best Rank Tracker | SERP Tracker | Youtube Rank Tracker | Social Signals Tracker</title>
        <meta name="author" content="Globussoft">
        <meta name="keywords" content="World's First Open Source Website Tracker,GlobusTracker,Video & Social Media Tracker,Good Tracking Website" />
        <meta name="description" content="GlobusTracker is World's First Open Source Tracker for Your Website, Videos & Social Media Platforms" />
        <meta name="og:title" content="GlobusTracker" />
        <meta name="og:type" content="GlobusTracker" />
        <link rel="shortcut icon" href="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- stylesheets -->
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/theme.css">
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/animate.css">
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/brankic.css">
        <link rel="stylesheet" type="text/css" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/switch.css">

        <link rel="stylesheet" href="https://s3.amazonaws.com/css-globustracker/main.css">

        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />

        <!--[if lt IE 9]>
     <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
   <![endif]-->

        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!--[if IE]>
      <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
        %> 

    </head>
    <!-- Body start -->
    <body id="home2" class="">
        <header class="navbar navbar-inverse white navbar-fixed-top" role="banner">
            <div class="container-fluid" style="padding: 0 8%;">
                <div class="navbar-header">
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="home.action" class="navbar-brand"><img src="https://s3.amazonaws.com/images-globustracker/Globustracker-logo-present.png" class="img-responsive" style="width: 200px;"></a>
                </div>
                <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" >
                                Home
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#tabs">
                                Features 
                            </a>
                        </li>
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">Versions <span class="caret"></span></a>
                            <ul role="menu" class="dropdown-menu">
                                <li><a target="_blank" href="http://globustracker.org/">Community</a></li>
                                <li><a target="_blank" href="http://globustracker.org/agency/">Agency</a></li>
                                <li><a target="_blank" href="http://globustracker.org/enterprise/">Enterprise</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#pricing" >
                                Pricing 
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#second-option" >
                                Faq
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#clients" >
                                Clients
                            </a>
                        </li>
                        <li>
                            <a href="contact.action">
                                Contact us
                            </a>
                        </li>
                        <li>
                            <a href="payment.action" class="signup visible-md visible-lg">Sign up free</a>
                        </li>
                        <li>
                            <a href="signIn.action" class="signup visible-md visible-lg">Sign In</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class='sidebarSmall'>
                <a href="https://www.linkedin.com/company/globustracker/"><i class="fa fa-linkedin-square fa-3x blue"></i></a>
                <a href="https://twitter.com/Globustrackerr"><i class="fa fa-twitter-square fa-3x blue"></i></a>
                <a href="https://www.facebook.com/pages/GlobusTracker/1494928880747668"><i class="fa fa-facebook-square fa-3x blue"></i></a>
                <a href="https://www.youtube.com/channel/UCIRNmEmxjE5v6Nlwa7_i7Cg"><i class="fa fa-youtube-square fa-3x blue"></i></a>
                <a href="http://www.pinterest.com/globustracker/"><i class="fa fa-pinterest-square fa-3x blue"></i></a>
                <a href="https://plus.google.com/u/0/109726630817210747329/posts"><i class="fa fa-google-plus-square fa-3x blue"></i></a>
            </div>
        </header>

        <div id="hero">
            <a class="slide-nav prev" href="#">Prev</a>
            <a class="slide-nav next" href="#">Next</a>
            <nav>
                <a class="" href="#"></a>
                <a href="#" class="active"></a>
                <a href="#" class=""></a>
            </nav>
            <div class="slides">
                <div class="slide first active">
                    <div class="bg"></div>
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-offset-1 col-sm-5 info">
                                <h1 class="hero-text">
                                    Make it awesome.
                                </h1>
                                <p>
                                    GlobusTracker is World's First Open Source Tracker for
                                    Your Website, Videos & Social Media Platforms.
                                    GlobusTracker is the best way to get a great tracking website out of the world with lots of options.
                                </p>
                                <div class="cta">
                                    <a href="payment.action" class="button-outline">
                                        TRY IT FREE
                                        <i class="fa fa-chevron-right"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="col-sm-6 hidden-xs mobiles">
                                <!-- <img src="images/static-hero.png" class="animated fadeInLeft" alt="devices" /> -->
                                <img src="https://s3.amazonaws.com/images-globustracker/devices3.png" class="animated fadeInLeft img-responsive" alt="devices">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="slide second " style="display: block;">
                    <div class="bg"></div>
                    <div class="container">
                        <h1 class="hero-text">The Best Rank Tracker</h1>
                        <p class="sub-text">
                            Watch a demo
                        </p>
                        <div class="video-wrapper">
                            <div class="video animated fadeInUp">
                                <img src="https://s3.amazonaws.com/images-globustracker/player.png" id="demo-player" alt="videoplayer">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="slide third">
                    <div class="bg"></div>
                    <div class="container">
                        <h1 class="hero-text animated fadeInLeft">
                            Track any data point in your app in real time.
                        </h1>
                        <p class="sub-text animated fadeInLeft">
                            Try our 30 day trial so you can check out all the features that we offer, no contracts
                            or credit card required.
                        </p>
                        <div class="cta animated fadeInRight">
                            <a href="https://www.youtube.com/watch?v=a95pHRnDgFU" target="_blank" class="button-outline">See the tour</a>
                            <a href="signIn.action" class="button">Sign in</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="video-modal">
                <div class="wrap"><iframe src="//www.youtube.com/embed/a95pHRnDgFU" width="620" height="350" frameborder="0" webkitallowfullscreen="" mozallowfullscreen="" allowfullscreen=""></iframe></div>
            </div>
        </div>

        <div class="row text-center" style="margin-top: 4%;">
            <div class="col-md-6 col-md-offset-3">
                <div class="panel panel-default" style="background: #E8F7FC; border: #b2e6f4 1px solid;">
                    <div class="panel-body text-center" style="padding-bottom: 7%;">
                        <h3>Website Review</h3><br />
                        <div class="row">
                            <!--<form action="" class="form-group">-->
                            <div class="col-md-3">
                                <label class="control-label" style="margin-top: 7%;">URL</label>
                            </div>
                            <div class="col-md-6">
                                <input type="url" class="form-control" required id="sitename" placeholder="http://www.abc.com" />
                            </div>
                            <div class="col-md-3">
                                <input class="btn btn-primary" style="margin-top: 1%;" type="submit" value="Review My Site" onclick="return searchReview();" />
                            </div>
                            <!--</form>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="tabs" style="margin-top: 1%;">
            <div class="container">
                <div class="row header">
                    <div class="col-md-12">
                        <h3>Best Features</h3>
                        <!-- <p>Choose your favorite formats for your own sites</p> -->
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 tabs-wrapper">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#home" data-toggle="tab">Keyword ranking Reports</a></li>
                            <li class=""><a href="#profile" data-toggle="tab">Powerful rank tracker</a></li>
                            <li class=""><a href="#messages" data-toggle="tab">Quick overview of keywords</a></li>
                            <li class=""><a href="#settings" data-toggle="tab">Instant overview of social signals</a></li>
                        </ul>

                        <div class="tab-content">
                            <div class="tab-pane fade active in" id="home">
                                <div class="col-md-6 info">
                                    <h4>Keyword ranking Reports</h4>
                                    <p>
                                        Reports showing the ranking status of the keywords are e-mailed daily.<br>
                                        The frequency of the e-mail reports can be adjusted. <br>
                                        Let you know about the campaign status in your mail Inbox .
                                    </p>
                                </div>
                                <div class="col-md-6 image">
                                    <img src="https://s3.amazonaws.com/images-globustracker/pic1.png" class="img-responsive" alt="pic1">
                                </div>
                            </div>
                            <div class="tab-pane fade" id="profile">
                                <div class="col-md-6 image">
                                    <img src="https://s3.amazonaws.com/images-globustracker/portfolioitem1.png" class="img-responsive" alt="pic2">
                                </div>
                                <div class="col-md-6 info">
                                    <h4>Powerful rank tracker</h4>
                                    <p>
                                        In GlobusTracker campaigns are sorted efficiently. <br>
                                        Adding, editing and deleting of campaigns can be done easily.<br>
                                        Daily ranking updates are available on this rank tracker. <br>
                                        Manage the strategies in accordance with daily ranking updates. <br>
                                        Campaign reports are available in pdf and excel format and can be easily downloadable.
                                    </p>
                                </div>                          
                            </div>
                            <div class="tab-pane fade" id="messages">
                                <div class="col-md-6 info">
                                    <h4>Quick overview of keywords in Google yahoo and bing</h4>
                                    <p>
                                        Keywords ranking on Google, Yahoo and Bing are available. <br>
                                        Daily, weekly and monthly changes in ranking according to google, yahoo and bing are shown.
                                    </p>
                                    <p>
                                        Adjust the SEO strategies according to the search engine ranking.<br>
                                        Ranking of keywords up to 1000 positions in Google, yahoo and Bing are given.
                                    </p>
                                </div>
                                <div class="col-md-6 image">
                                    <img src="https://s3.amazonaws.com/images-globustracker/pic2.png" class="img-responsive" style="position: relative;top: 15px;" alt="pic3">
                                </div>
                            </div>
                            <div class="tab-pane fade" id="settings">
                                <div class="col-md-6 image">
                                    <img src="https://s3.amazonaws.com/images-globustracker/pic3.png" class="img-responsive" alt="pic4">
                                </div>
                                <div class="col-md-6 info">
                                    <h4>Instant overview of social signals</h4>
                                    <p>
                                        Know the exact number of social signals on each URl. <br>
                                        Plan a social campaign with our Social Signal graph tool. <br>
                                        Full and accurate reports of social signals are available in pdf, excel and graphical format. <br>
                                        Social signals are evaluated using top social networking sites such as on Facebook, Twitter, pinterest, Linkedin, google plus, Reddit and Stumble upon.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="features-hover">
            <div class="container">
                <div class="row header">
                    <div class="col-md-12 images">
                        <h3>Extra Features</h3>
                        <img src="https://s3.amazonaws.com/images-globustracker/services5.png" class="img-responsive active" alt="services1">
                        <img src="https://s3.amazonaws.com/images-globustracker/services6.png" class="img-responsive" alt="services2">
                        <img src="https://s3.amazonaws.com/images-globustracker/services7.png" class="img-responsive" alt="services3">
                    </div>
                </div>
                <div class="row features">
                    <div class="col-md-4">
                        <div class="feature active">
                            <strong>Graphical representation of keyword ranking</strong>
                            <p>Ranking reports are also available in graphical format. <br>
                                See the date wise ranking progress on an instant glimpse. <br>
                                The print format of these charts is easily accessible. <br>
                                These graphs are Java based and can be viewed on cell phones.</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="feature">
                            <strong>Excel report sheets</strong>
                            <p>
                                Excel report sheets of the running campaign are available. <br>
                                Show these excel reports to the clients and plan for the methods accordingly.
                            </p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="feature">
                            <strong>Pdf report sheets</strong>
                            <p>
                                Pdf format of the reports is also available. <br>
                                Download daily Pdf report sheets of the campaigns for record purpose.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="pricing">
            <div class="container">
                <div class="row header">
                    <h3>PRICING</h3>
                    <p>Pricing Plan</p>
                </div>
                <div class="row charts">
                    <div class="col-md-4">
                        <div class="chart first">
                            <div class="quantity">
                                <span class="dollar">$</span>
                                <span class="price">00</span>
                                <span class="period">/month</span>
                            </div>
                            <div class="plan-name">FREE</div>
                            <div class="specs">
                                <div class="spec">
                                    <span class="variable">1</span>
                                    Campaigns
                                </div>
                                <div class="spec">
                                    <span class="variable">1</span>
                                    Users
                                </div>
                                <div class="spec">
                                    <span class="variable">20</span>
                                    Keywords
                                </div>
                            </div>
                            <a class="btn-signup button-clear" href="sessionSaver.action?itemName=FreeBeta">
                                <span>Try It For Free</span>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="chart featured">
                            <div class="popular">Most popular</div>
                            <div class="quantity">
                                <span class="dollar">$</span>
                                <span class="price">59.99</span>
                                <span class="period">/month</span>
                            </div>
                            <div class="plan-name">Profesional</div>
                            <div class="specs">
                                <div class="spec">
                                    <span class="variable">50</span>
                                    Campaigns
                                </div>
                                <div class="spec">
                                    <span class="variable">5</span>
                                    Users
                                </div>
                                <div class="spec">
                                    <span class="variable">1000</span>
                                    Keywords
                                </div>
                            </div>
                            <a class="btn-signup button-clear" href="sessionSaver.action?itemName=Professional">
                                <span>Register</span>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="chart last">
                            <div class="quantity">
                                <span class="dollar">$</span>
                                <span class="price">799.99</span>
                                <span class="period">/month</span>
                            </div>
                            <div class="plan-name">Enterprise</div>
                            <div class="specs">
                                <div class="spec">
                                    <span class="variable">1500</span>
                                    Campaigns
                                </div>
                                <div class="spec">
                                    <span class="variable">Unlimited</span>
                                    Users
                                </div>
                                <div class="spec">
                                    <span class="variable">30,000</span>
                                    Keywords
                                </div>
                            </div>
                            <a class="btn-signup button-clear" href="sessionSaver.action?itemName=Enterprise">
                                <span>Register</span>
                            </a>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="cta animated fadeInRight header">
                    <a href="payment.action" class="button-outline">
                        MORE PLANS
                        <i class="fa fa-chevron-right"></i>
                    </a>
                </div>
            </div>
        </div>

        <div id="second-option">
            <div class="container">
                <div class="row header">
                    <h2>Frequently Asked Questions</h2>
                </div>
                <div class="row">
                    <div class="col-md-4 feature">
                        <!-- <img src="img/creditcard.png" alt="creditcard"> -->
                        <i class="fa fa-globe fa-fw fa-2x"></i>
                        <strong>Q. What is GlobusTracker ?</strong>
                        <p>A online website ranking tool to get accurate keyword ranking and tracking results in an easy way which helps to identify the keywords making your web pages to rank and allows you to track your multiple keyword rankings across Google, Yahoo and Bing.</p>
                    </div>
                    <div class="col-md-4 feature">
                        <i class="fa fa-globe fa-fw fa-2x"></i>
                        <strong>Q. What can I know from GlobusTracker ?</strong>
                        <p>Track keywords to save time and improve your rankings. Know the position of your website. To organize keywords that are specified through the keyword tool.</p>
                    </div>
                    <div class="col-md-4 feature">
                        <i class="fa fa-globe fa-fw fa-2x"></i>
                        <strong>Q. What are the advantages/pros of GlobusTracker ?</strong>
                        <p>Quick and efficient rank tracker. Simply hide the features or information from view which is not needed. Very easy to use and you can view your keywords? rankings in one simple glance. Shows you the BEST keywords to optimize your site for.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 feature">
                        <i class="fa fa-globe fa-fw fa-2x"></i>
                        <strong>Q. What are the plans in GlobusTracker ?</strong>
                        <p>You can choose from the starter membership at $9.99 for 100 keywords, all the way up to $799.99 for 30,000 keywords.</p>
                    </div>
                    <div class="col-md-4 feature">
                        <i class="fa fa-globe fa-fw fa-2x"></i>
                        <strong>Q. What is a Campaign in GlobusTracker ?</strong>
                        <p>Title for Domain URL</p>
                    </div>
                    <div class="col-md-4 feature">
                        <i class="fa fa-globe fa-fw fa-2x"></i>
                        <strong>Q. Which videos I can track in the search engines ?</strong>
                        <p>Youtube, Daily motion, Viemo, Metacafe</p>
                    </div>
                </div>
            </div>
        </div>

        <div id="clients">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h3>Our Customers</h3>
                        <p>
                            These are some of our customers who have helped us by using our product.
                        </p>
                        <div class="logos">
                            <img src="https://s3.amazonaws.com/images-globustracker/airsoftatlanta.png">
                            <img src="https://s3.amazonaws.com/images-globustracker/snoogd.png">
                            <img src="https://s3.amazonaws.com/images-globustracker/Neron_Solutions.png">
                            <img src="https://s3.amazonaws.com/images-globustracker/mba-gambit.png">
                            <img src="https://s3.amazonaws.com/images-globustracker/wirenine.png">
                            <img src="https://s3.amazonaws.com/images-globustracker/rapid.jpg">
                        </div>
                    </div>
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

        <!-- javascript -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

        <script src="https://s3.amazonaws.com/js-globustracker/bootstrap.min.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/theme.js"></script>

        <script type="text/javascript" src="https://s3.amazonaws.com/js-globustracker/main.js"></script>

        <script type="text/javascript">
                                        $(function() {
                                            var $navDots = $("#hero nav a");
                                            var $next = $(".slide-nav.next");
                                            var $prev = $(".slide-nav.prev");
                                            var $slides = $("#hero .slides .slide");
                                            var actualIndex = 0;
                                            var swiping = false;
                                            var interval;

                                            $navDots.click(function(e) {
                                                e.preventDefault();
                                                if (swiping) {
                                                    return;
                                                }
                                                swiping = true;

                                                actualIndex = $navDots.index(this);
                                                updateSlides(actualIndex);
                                            });

                                            $next.click(function(e) {
                                                e.preventDefault();
                                                if (swiping) {
                                                    return;
                                                }
                                                swiping = true;

                                                clearInterval(interval);
                                                interval = null;

                                                actualIndex++;
                                                if (actualIndex >= $slides.length) {
                                                    actualIndex = 0;
                                                }

                                                updateSlides(actualIndex);
                                            });

                                            $prev.click(function(e) {
                                                e.preventDefault();
                                                if (swiping) {
                                                    return;
                                                }
                                                swiping = true;

                                                clearInterval(interval);
                                                interval = null;

                                                actualIndex--;
                                                if (actualIndex < 0) {
                                                    actualIndex = $slides.length - 1;
                                                }

                                                updateSlides(actualIndex);
                                            });

                                            function updateSlides(index) {
                                                // update nav dots
                                                $navDots.removeClass("active");
                                                $navDots.eq(index).addClass("active");

                                                // update slides
                                                var $activeSlide = $("#hero .slide.active");
                                                var $nextSlide = $slides.eq(index);

                                                $activeSlide.fadeOut();
                                                $nextSlide.addClass("next").fadeIn();

                                                setTimeout(function() {
                                                    $slides.removeClass("next").removeClass("active");
                                                    $nextSlide.addClass("active");
                                                    $activeSlide.removeAttr('style');
                                                    swiping = false;
                                                }, 1000);
                                            }


                                            interval = setInterval(function() {
                                                if (swiping) {
                                                    return;
                                                }
                                                swiping = true;

                                                actualIndex++;
                                                if (actualIndex >= $slides.length) {
                                                    actualIndex = 0;
                                                }

                                                updateSlides(actualIndex);
                                            }, 5000);

                                            // demo player
                                            var $videoModal = $(".video-modal");
                                            $("#demo-player").click(function() {
                                                $videoModal.toggleClass("active");
                                                clearInterval(interval);
                                                interval = null;
                                            });
                                            $videoModal.click(function() {
                                                $videoModal.removeClass("active");
                                                setTimeout(function() {
                                                    $videoModal.find(".wrap").html('<iframe src="//www.youtube.com/embed/a95pHRnDgFU" width="620" height="350" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>');
                                                }, 1000);
                                            })
                                            $videoModal.find(".wrap").click(function(e) {
                                                e.stopPropagation();
                                            });
                                        });
        </script>

        <script  type='text/javascript'>

            function onoff() {
                if (document.getElementById("start_interval").checked) {
                    document.getElementById('start_interval').setAttribute("value", "1");
                }
            }

            function searchReview() {
                var siteurl = $("#sitename").val();
//                var encodedURL = encodeURIComponent(siteurl);
//                var isValid = false;
//
//                $.ajax({
//                    url: "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20html%20where%20url%3D%22" + encodedURL + "%22&format=json",
//                    type: "get",
//                    async: false,
//                    dataType: "json",
//                    success: function(data) {
//                        isValid = data.query.results != null;
//                    },
//                    error: function() {
//                        isValid = false;
//                    }
//                });
//
//                if(!isValid){
//                    window.location.href = "error";
//                    return false;
//                }

                siteurl = siteurl.replace("http://", "").replace("https://", "").replace("www.", "");
                window.location.href = "/reviews/site/" + siteurl + ".htm";
            }
        </script>

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

    <!-- Body end -->

</html>