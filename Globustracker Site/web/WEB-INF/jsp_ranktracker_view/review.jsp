<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">   
        <title>Globustracker | review</title>
        <meta name="author" content="Globussoft">
        <link rel="shortcut icon" href="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- stylesheets -->
        <link href="https://s3.amazonaws.com/css-globustracker/review/review.css" rel="stylesheet" type="text/css"  />
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">

        <style>
            .part.text.text-block.fb-text-bloc > img {
                height: 16px;
                padding-right: 4%;
            }

            .part.text.text-block.fb-text-bloc {
                display: flex;
            }

/*            .part.text.text-block.fb-text-bloc > p {
                font-weight: bold;
            }*/
        </style>

        <!-- javascript -->
        <script src="https://s3.amazonaws.com/js-globustracker/jquery-1.11.1.min.js"></script>

        <script src="https://s3.amazonaws.com/js-globustracker/bootstrap.min.js"></script>

        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>


    </head>
    <body class="review lang-en"  id="home2">

        <header class="navbar navbar-inverse white" role="banner">
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
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">Versions <span class="caret"></span></a>
                            <ul role="menu" class="dropdown-menu">
                                <li><a target="_blank" href="http://globustracker.org/">Community</a></li>
                                <li><a target="_blank" href="http://globustracker.org/agency/">Agency</a></li>
                                <li><a target="_blank" href="http://globustracker.org/enterprise/">Enterprise</a></li>
                            </ul>
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
                            <a href="payment.action" class="signup visible-md visible-lg">Sign up free</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </header>




        <div style="" class="row text-center">
            <div class="col-md-6 col-md-offset-1">
                <div style="" class="">
                    <div style="" class="">
                        <br>
                        <div class="row">
                            <!--<form id="generate-report" class="ajax-generate-report generate-form ">-->
                            <div class="col-md-6 col-md-offset-1">
                                <input type="url" placeholder="http://www.abc.com" id="sitename" required="" class="form-control">
                            </div>
                            <div class="col-md-3">
                                <input type="submit" value="Website Review" style="margin-top: 1%;" class="btn btn-primary" onclick="return WebsiteReview();">
                            </div><br>
                            <!--</form>-->
                        </div><br>
                    </div>
                </div>
            </div>
        </div>

        <div id="content" itemprop="mainContentOfPage">
            <div id="grid">

                <div id="left-nav">
                    <div id="flying">
                        <div class="nav-section">
                            <nav>
                                <a class="current inpage-link" href="#dashboard">
                                    <span class="fa fa-chevron-up"></span><!--
                                    --><span>Return to top</span>
                                </a>
                            </nav>
                        </div>
                        <div class="nav-section">
                            <nav>
                                <a class="section-title inpage-link" href="#module-section-title-optimize" >Optimize</a>
                                <a class="seo inpage-link" href="#module-seo">
                                    <span class="fa fa-search"></span>
                                    <span>SEO</span>
                                    <span class="fa fa-chevron-right"></span>
                                </a>
                                <a class="mobile inpage-link" href="#module-mobile">
                                    <span class="fa fa-phone"></span>
                                    <span>Mobile</span>
                                    <span class="fa fa-chevron-right"></span>
                                </a>
                                <a class="usability inpage-link" href="#module-usability">
                                    <span class="fa fa-hand-o-up"></span>
                                    <span>Usability</span>
                                    <span class="fa fa-chevron-right"></span>
                                </a>
                                <a class="technologies inpage-link" href="#module-technologies">
                                    <span class="fa fa-cogs"></span>
                                    <span>Technologies</span>
                                    <span class="fa fa-chevron-right"></span>
                                </a>
                            </nav>
                        </div>
                        <div class="nav-section">
                            <nav>
                                <a class="section-title inpage-link" href="#module-section-title-promote" >Promote</a>
                                <a class="social inpage-link" href="#module-social">
                                    <span class="fa fa-thumbs-up"></span>
                                    <span>Social</span>
                                    <span class="fa fa-chevron-right"></span>
                                </a>
                                <a class="local_visibility inpage-link" href="#module-local_visibility">
                                    <span class="fa fa-map-marker"></span>
                                    <span>Local</span>
                                    <span class="fa fa-chevron-right"></span>
                                </a>
                            </nav>
                        </div>
                        <div class="nav-section">
                            <nav>
                                <a class="section-title inpage-link" href="#module-section-title-measure" >Measure</a>
                                <a class="visitors inpage-link" href="#module-visitors">
                                    <span class="fa fa-group"></span>
                                    <span>Visitors</span>
                                    <span class="fa fa-chevron-right"></span>
                                </a>
                            </nav>
                        </div>
                    </div>
                </div>

                <div id="right-panel" class="tbody_font_size free-rev" itemscope itemtype="" >
                    <!--<img src="https://s3.amazonaws.com/images-globustracker/review/sharing-sprite.png" class="img-responsive" />-->
                    <link itemprop="additionalType" content="" />

                    <meta itemprop="thumbnailUrl" content="https://s3.amazonaws.com/images-globustracker/review/socioboard.com.png" />
                    <meta itemprop="url" content="socioboard.com" />
                    <div id="dashboard" class="hreview">
                        <link href="" rel="template" name="parts" class="mustache-to-load" id="parts-mustache-tpl"/>
                        <link href="" rel="partial" name="setDataField" class="mustache-to-load"/>
                        <div class="module-content">
                            <div id="dashboard-content" class="" itemprop="review" itemscope >

                                <div id="dashboard-state">

                                </div>

                                <div id="dashboard-screenshot">
                                    <div id="set51Loader">
                                        <div style="text-align:center; display: block" ><img width="10" height="10" style="height: 7%; width: 20%; margin-top: 19%;" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                    </div>
                                    <img src="" class="test" itemprop="image" alt="" width="202" height="114" id="dashboardImage"/>
                                    <div class="screen"></div>
                                </div>

                                <div id="dashboard-site">
                                    <h1 class="item" itemprop="name" >
                                        <input type="hidden" id="websearchurl" value="${website}"/>
                                        <span class="reviewer ">Globustracker</span>
                                        <a class="fn js-ext-link fit-text" href="ext://${website}" itemprop="itemReviewed" rel="nofollow" target="_blank"
                                           title="${website}" data-url="${website}">
                                            <span class="domain">${website}</span>
                                        </a>
                                    </h1>
                                    <meta itemprop="author" content="Chanchal Santra" />
                                    <meta itemprop="dateCreated" content="2014-10-08" />
                                    <div class="generated-time dtreviewed">
                                        <span class="moment"><%=new java.util.Date().toString()%></span>
                                        <span class="value-title hidden" title="2014-10-08"></span>
                                    </div>
                                    <div id="dashboard-bars" class="dashboard-bars">
                                        <div id="green-bar-counter" class="section">
                                            <span class="fa fa-bullet-result-plain"></span>
                                            <span class="fa fa-bullet-result-check"></span>
                                            <h3>Passed</h3>
                                            <span class="bar">
                                                <span class="percent" id="passedPercent"></span>
                                            </span>
                                        </div>
                                        <div id="orange-bar-counter" class="section">
                                            <span class="fa fa-bullet-result-plain"></span>
                                            <span class="fa fa-bullet-result-warning"></span>
                                            <h3>To Improve</h3>
                                            <span class="bar">
                                                <span class="percent" id="errorPercent"></span>
                                            </span>
                                        </div>
                                        <div id="red-bar-counter" class="section">
                                            <span class="fa fa-bullet-result-plain"></span>
                                            <span class="fa fa-bullet-result-cross"></span>
                                            <h3>Errors</h3>
                                            <span class="bar">
                                                <span class="percent" id="improvePercent"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>



                    </div>

                    <div id="report-content">
                        <div class="module-section" id="module-section-title-optimize">Optimize</div>
                        <div class="module" id="module-seo">
                            <div class="module-content">
                                <h2>SEO</h2>
                                <div id="seo">
                                    <div id="criterium-related_websites" class="criterium result-0 ">

                                        <div class="criterium-head">
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                <span class="fa"></span>Related Websites
                                            </h3>
                                        </div>

                                        <div id="set1Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="RelatedWebsite">
                                            <div class="criterium-content more-less">
                                                <div class="part table more-block" style="height: 125px; overflow: hidden;">
                                                    <table class="tbody_font_size" id="relatedtable">
                                                        <thead>
                                                            <tr>
                                                                <th>URL</th>

                                                            </tr>
                                                        </thead>
                                                        <tbody  class="tbody_font_size" >
                                                            <tr class="">
                                                                <td itemprop="isRelatedTo"><a href="" target="_blank" id="relatedtable"></a></td>

                                                            </tr>

                                                        </tbody>
                                                    </table>

                                                </div>
                                                <a class="adjust showMore" href="#">Show More</a>
                                            </div></div>

                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div>
                                    </div>

                                    <div id="criterium-page_rank" class="criterium result-0">
                                        <div class="criterium-head">
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                <span class="fa"></span>PageRank
                                            </h3>
                                        </div>
                                        <div id="set2Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="PageRank">
                                            <div class="criterium-content">
                                                <div class="part progressbar">
                                                    <div class="content has-title">

                                                        <span class="bar"><span style="width:100%; text-align: center" class="colored-bar" id="pageRank"></span>
                                                            <span class="value" data-abs-value=""></span></span>
                                                    </div></div></div></div>
                                        <div class="criterium-advice-click"><span></span></div>
                                        <div class="criterium-advice">


                                        </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div>
                                    </div>
                                    <div id="criterium-title" class="criterium result-2 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">0.67264573991031</span>
                                            <span class="prio-score hidden">12</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="To Improve">
                                                <span class="fa"></span>Title
                                            </h3>

                                        </div>
                                        <div id="set3Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="Title">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p itemprop="headline" id="title"></p>
                                                    <p><span class="bold">Length:</span><span id="titleLength"></span>character(s)</p>
                                                </div>

                                            </div></div>
                                        <div class="criterium-quicktips">Check the title of your website</div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-description" class="criterium result-2 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">0.67264573991031</span>
                                            <span class="prio-score hidden">12</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="To Improve">
                                                <span class="fa"></span>Description
                                            </h3>

                                        </div>
                                        <div id="set4Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="Description1">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p itemprop="description" id="description"></p>
                                                    <p><span class="bold">Length:</span><span id="descriptionLength"></span>character(s)</p>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="criterium-quicktips">Improve the Meta Description</div>
                                        <div class="delimiter"></div></div>
                                    <!--</div>-->
                                    <div id="criterium-headings" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">0.89686098654709</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Headings
                                            </h3>

                                        </div>
                                        <div id="set5Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="Headings">
                                            <div class="criterium-content more-less">


                                                <div class="part table ">
                                                    <table class="" style="width: 100%;">
                                                        <thead>
                                                            <tr>
                                                                <!--<th>&nbsp; H1</th>-->
                                                                <th> H1</th>
                                                                <th> H2</th>
                                                                <th> H3</th>
                                                                <th> H4</th>
                                                                <th> H5</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody  class="tbody_font_size" >
                                                            <tr class="">
                                                                <td id="heading1"> </td>
                                                                <td id="heading2"> </td>
                                                                <td id="heading3"> </td>
                                                                <td id="heading4"> </td>
                                                                <td id="heading5"> </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>



                                                <div class="part table more-block" style="height: 125px; overflow: hidden;">
                                                    <table class="no-header open" id="headingstable">
                                                        <tbody  class="tbody_font_size" >
                                                            <tr class="" id="h1elements">
                                                            </tr>
                                                            <tr class="over-max-v" id="h2elements">
                                                            </tr>
                                                            <tr class="over-max-v" id="h3elements">
                                                            </tr>
                                                            <tr class="over-max-v" id="h4elements">
                                                            </tr>
                                                            <tr class="over-max-v" id="h5elements">
                                                            </tr>
                                                        </tbody>
                                                    </table>

                                                </div>
                                                <a class="adjust showMore" href="#">Show More</a>
                                            </div></div>
                                        <div class="criterium-quicktips">Add the important keywords in &lt;H&gt; headings</div>
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
                                        <div id="set6Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="MetaKeywords">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p itemprop="keywords" id="keyword"></p>
                                                </div>
                                            </div></div>
                                        <div class="criterium-advice-click"><span></span>
                                        </div>
                                        <div class="criterium-advice">

                                        </div>

                                        <div class="delimiter"></div>
                                    </div>



                                    <div id="criterium-images" class="criterium result-2 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">0.48046124279308</span>
                                            <span class="prio-score hidden">12</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="To Improve">
                                                <span class="fa"></span>Images
                                            </h3>

                                        </div>
                                        <div id="set7Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="Images">
                                            <div class="criterium-content more-less">
                                                <div class="part text ">

                                                </div>

                                                <div class="part list more-block" style="height: 125px; overflow: hidden;">
                                                    <table>
                                                        <tbody  class="tbody_font_size"  id="imagestable">

                                                        </tbody>
                                                    </table>

                                                </div>
                                                <a class="adjust showMore" href="#">Show More</a>
                                            </div> </div>
                                        <div class="criterium-quicktips">Set a name for all your images</div>
                                        <div class="delimiter"></div></div>

                                    <div id="criterium-text_html_ratio" class="criterium result-3 ">
                                        <div class="criterium-head">
                                            <span class="prio-score hidden">15</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Errors">
                                                <span class="fa"></span>Text/HTML Ratio
                                            </h3>

                                        </div>
                                        <div id="set8Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="HTMLRatio">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p id="htmlRatio"></p>
                                                </div>
                                            </div></div>
                                        <div class="criterium-quicktips">Write additional content with more keywords</div>
                                        <div class="delimiter"></div></div>

                                    <div id="criterium-indexed_pages" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">8.9686098654709</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Indexed Pages
                                            </h3>
                                        </div>
                                        <div id="set9Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="IndexedPages">
                                            <div class="criterium-content">
                                                <div class="part progressbar ">

                                                    <div class="content has-title">
                                                        <span class="bar"><span class="colored-bar" style="width:100%; text-align: center;" id="indexedPages"></span><span class="value" data-abs-value=""></span></span>
                                                    </div>
                                                </div>
                                            </div></div>

                                        <div class="criterium-quicktips">Write more content</div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-inside_pages" class="criterium result-0 hidden ">
                                        <div class="criterium-head">

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                <span class="fa"></span>Internal Pages Analysis
                                            </h3>
                                        </div>
                                        <div id="set10Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div class="criterium-content">

                                        </div>
                                        <div class="criterium-quicktips">Write unique titles for each page</div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-popular_pages" class="criterium result-0 hidden ">
                                        <div class="criterium-head">
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                <span class="fa"></span>Popular Pages
                                            </h3>

                                        </div>
                                        <div id="set11Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div class="criterium-content">
                                        </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-google_preview" class="criterium result-0 ">
                                        <div class="criterium-head">

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                <span class="fa"></span>Google Preview
                                            </h3>


                                        </div>
                                        <div id="set12Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="GooglePreview">
                                            <div class="criterium-content">
                                                <div class="part text google-preview">
                                                    <p id="reviewGoogleTitle"></p>
                                                    <p><span class="bold" id="reviewGoogleUrl"></span>/</p>
                                                    <p id="reviewGoogleDesc"></p>
                                                </div>
                                            </div> </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-google_publisher_link" class="criterium result-3 ">
                                        <div class="criterium-head">
                                            <span class="prio-score hidden">10</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Errors">
                                                <span class="fa"></span>Google+ Publisher
                                            </h3>

                                        </div>
                                        <div id="set13Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="GooglePublisher">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p><span class="italic" id="googlePublisher"></span></p>
                                                </div>
                                            </div></div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-top_ranking_keywords" class="criterium result-0 hidden ">
                                        <div class="criterium-head">

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                <span class="fa"></span>Google&trade; Ranking
                                            </h3>

                                        </div>
                                        <div id="set14Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div class="criterium-content">

                                        </div>

                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-links_details" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">1.3452914798206</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>In-Page Links
                                            </h3>

                                        </div>
                                        <div id="set15Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="pageLinks">
                                            <div class="criterium-content more-less">
                                                <div class="part text ">
                                                    <p></p>
                                                </div>

                                                <div class="part table more-block" style="height: 125px; overflow: hidden;">
                                                    <table class="links-details">
                                                        <thead>
                                                            <!--<tr>-->
                                                        <td>Links</td>
                                                        <td>Type</td>
                                                        <td>Title</td>
                                                        <!--</tr>-->
                                                        </thead>
                                                        <tbody  class="tbody_font_size"  id="inpagelinkstable">

                                                        </tbody>
                                                    </table>

                                                </div>
                                                <a class="adjust showMore" href="#">Show More</a>
                                            </div></div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-broken_links" class="criterium result-1 hidden">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">2.2421524663677</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Broken Links
                                            </h3>

                                        </div>
                                        <div id="set16Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p>No broken links were found on this web page</p>
                                            </div>

                                        </div>
                                        <!--                                        <div class="criterium-quicktips">Fix or Delete Broken Links</div>
                                                                                <div class="delimiter"></div></div>
                                                                            <div id="criterium-backlinks_counter" class="criterium result-1">
                                                                                <div class="criterium-head">
                                                                                    <span class="crit-score-pond hidden">6.6794796793857</span>
                                        
                                                                                    <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                                                        <span class="fa"></span>Backlinks Counter
                                                                                    </h3>
                                        
                                        
                                                                                </div>-->
                                        <div id="set17Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="Backlinks">
                                            <div class="criterium-content">
                                                <div class="part progressbar ">
                                                    <div class="content">
                                                        <span class="bar"><span class="colored-bar" style="width:99%; text-align: center;" id="backlinksCounter"></span><span class="value" data-abs-value=""></span></span>
                                                    </div>
                                                </div>
                                            </div></div>
                                        <div class="criterium-quicktips">Build more backlinks pointing to your site</div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-www_resolve" class="criterium result-2 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">1.1210762331839</span>
                                            <span class="prio-score hidden">20</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="To Improve">
                                                <span class="fa"></span>WWW Resolve
                                            </h3>


                                        </div>
                                        <div id="set18Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="Resolve">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p id="wwwresolve"></p>
                                                </div>
                                            </div> </div>
                                        <div class="criterium-quicktips">Redirect non-www to www</div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-ip_canonicalization" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">0.44843049327354</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>IP Canonicalization
                                            </h3>
                                        </div>
                                        <div id="set19Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="Canonicalization">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p id="ipCanonicalization"></p>
                                                </div>
                                            </div></div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-robots_txt" class="criterium result-3 ">
                                        <div class="criterium-head">
                                            <span class="prio-score hidden">30</span>
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Errors">
                                                <span class="fa"></span>Robots.txt
                                            </h3>
                                        </div>
                                        <div id="set20Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="Robots">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p><span class="italic" id="robots"></span></p>
                                                </div>
                                            </div></div>
                                        <div class="criterium-quicktips">Add a robots.txt file</div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-xml_sitemaps" class="criterium result-3 ">
                                        <div class="criterium-head">
                                            <span class="prio-score hidden">20</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Errors">
                                                <span class="fa"></span>XML Sitemap
                                            </h3>


                                        </div>
                                        <div id="set21Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="XMLSitemap">
                                            <div class="criterium-content more-less">
                                                <div class="part text more-block" style="height: 125px; overflow: hidden;">
                                                    <table>
                                                        <tbody  class="tbody_font_size"  id="xmltable">

                                                        </tbody>
                                                    </table>
                                                </div>
                                                <a class="adjust showMore" href="#">Show More</a>
                                            </div></div>
                                        <div class="criterium-quicktips">Add and Optimize your XML sitemap</div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-clean_url" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">0.89686098654709</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>URL Rewrite
                                            </h3>


                                        </div>
                                        <div id="set22Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="Rewrite">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p id="urlDomain"></p>
                                                </div>
                                            </div></div>
                                        <div class="criterium-quicktips">Rewrite your URLs and clean them up.</div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-underscores_url" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">0.89686098654709</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Underscores in the URLs
                                            </h3>


                                        </div>
                                        <div id="set23Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="UnderscoresUrl">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p id="underscores"></p>
                                                </div>
                                            </div> </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-flash" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">0.44843049327354</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Flash
                                            </h3>


                                        </div>
                                        <div id="set24Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="Flash">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p id="flash">No</p>
                                                </div>
                                            </div></div>
                                        <div class="criterium-quicktips">Use Flash content sparingly</div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-frames" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">0.44843049327354</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Frames
                                            </h3>


                                        </div>
                                        <div id="set25Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="Frames">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p id="frames"></p>
                                                </div>
                                            </div></div>
                                        <div class="criterium-quicktips">Check that none of your important content is within a Frame</div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-domain_creation" class="criterium result-3 ">
                                        <div class="criterium-head">

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Errors">
                                                <span class="fa"></span>Domain 1st Registered
                                            </h3>

                                        </div>
                                        <div id="set26Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="DomainRegistered">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p itemprop="dateCreated" id="domainCreated"></p>
                                                </div>
                                            </div>  </div>                                 
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-domain_expiration" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">2.2421524663677</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Domain Expiration
                                            </h3>
                                        </div>
                                        <div id="set27Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="DoaminExpiration">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p id="domainExpired"></p>
                                                </div>
                                            </div></div>
                                        <div class="criterium-quicktips">Extend the registration of your domain</div>
                                        <div class="delimiter"></div>
                                    </div>

                                    <div id="criterium-domain_updated" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">2.2421524663677</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Domain Updated
                                            </h3>
                                        </div>
                                        <div id="set28Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="DomainUpdated">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p id="domainUpdated"></p>
                                                </div>
                                            </div></div>
                                        <div class="criterium-quicktips">Extend the registration of your domain</div>
                                        <div class="delimiter"></div>
                                    </div>

                                    <div id="criterium-blog" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">0.89686098654709</span>
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Blog
                                            </h3>
                                        </div>
                                        <div id="set29Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="blog">
                                            <div class="criterium-content">
                                                <div class="part text ">
                                                    <p>We found a Blog on this website.</p>
                                                </div>
                                            </div></div>
                                        <div class="criterium-quicktips">Consider starting a blog</div>
                                        <div class="delimiter"></div></div>
                                </div>
                            </div>
                            <div class="module" id="module-mobile">
                                <div class="module-content">
                                    <h2>Mobile</h2>
                                    <div id="mobile">
                                        <div id="criterium-mobile_rendering" class="criterium result-0 ">
                                            <div class="criterium-head">

                                                <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                    <span class="fa"></span>Mobile Rendering
                                                </h3>
                                            </div>
                                            <div id="set30Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="mobileRendering">
                                                <div class="criterium-content">
                                                    <div class="part image iphone-thumb">
                                                        <!--<img src="" itemprop="screenshot" alt="Your website on an iPhone" id="iphoneView"/>-->
                                                        <div id="set53Loader">
                                                            <div style="text-align:center; display: block" ><img width="10" height="10" style="height: 30%; width: 30%; margin-top: 35%; margin-left: -7%;" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                                        </div>
                                                        <img alt="" itemprop="screenshot" src="" id="iphoneView">
                                                    </div>
                                                    <div class="part image ipad-thumb">
                                                        <div id="set54Loader">
                                                            <div style="text-align:center; display: block" ><img width="10" height="10" style="height: 30%; width: 30%; margin-top: 24%; margin-left: -3%;" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                                        </div>
                                                        <img src="" itemprop="screenshot"  alt="" id="ipadView"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="criterium-quicktips"></div>
                                            <div class="delimiter"></div></div>


                                        <div id="criterium-mobile_load_time" class="criterium result-1 ">
                                            <div class="criterium-head">
                                                <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                    <span class="fa"></span>Mobile Load Time
                                                </h3>
                                            </div>

                                            <div id="set31Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="mobileTime">
                                                <div class="criterium-content">
                                                    <div class="part progressbar ">
                                                        <div class="content">
                                                            <span class="bar"><span class="colored-bar" style="width:100%; text-align: center" id="mobileLoadTime"></span><span class="value" data-abs-value="1"></span></span>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="criterium-quicktips"></div>
                                            <div class="delimiter"></div></div>
                                        <div id="criterium-mobile_optimization" class="criterium result-3 ">
                                            <div class="criterium-head">
                                                <span class="prio-score hidden">20</span>

                                                <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Errors">
                                                    <span class="fa"></span>Mobile Optimization
                                                </h3>

                                            </div>
                                            <div id="set32Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="mobileOptimization">
                                                <div class="criterium-content">
                                                    <div class="part text ">
                                                        <p>This website is not optimized for Mobile Visitors</p>
                                                    </div>
                                                    <div class="part text checklist">
                                                        <p><span class="icon grey-missing"></span>Mobile CSS</p>
                                                        <p><span class="icon grey-missing"></span>Mobile Redirection</p>
                                                    </div>

                                                    <div class="part text ">
                                                        <p>Additional mobile optimization techniques:</p>
                                                    </div>

                                                    <div class="part text checklist">
                                                        <p><span class="icon grey-missing weak"></span>Meta Viewport Tag</p>
                                                        <p><span class="icon grey-missing weak"></span>Apple Icon</p>
                                                        <p><span class="icon grey-found weak"></span>Flash content</p>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="criterium-quicktips">Optimize your website for Mobile browsing</div>
                                            <div class="delimiter"></div></div>
                                    </div>
                                </div>
                            </div>

                            <!-- usability -->
                            <div class="module" id="module-usability">
                                <div class="module-content">
                                    <h2>Usability</h2>
                                    <div id="criterium-url" class="criterium result-0 hidden">
                                        <div class="criterium-head">
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                <span class="fa"></span>URL
                                            </h3>
                                        </div>
                                        <div id="set33Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p>http://socioboard.com</p>
                                                <p><span class="bold">Length:</span> 10 character(s)</p>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-favicon" class="criterium result-1 hidden">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">1.3452914798206</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Favicon
                                            </h3>

                                        </div>
                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p>Yes</p>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips">Add a Favicon</div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-not_found_error" class="criterium result-1 hidden">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">2.2421524663677</span>
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Custom 404 Page
                                            </h3>
                                        </div>
                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p>Great, your website has a custom 404 error page.</p>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips">Customize the 404 error page</div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-conversion_form" class="criterium result-3 hidden ">
                                        <div class="criterium-head">
                                            <span class="prio-score hidden">20</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Errors">
                                                <span class="fa"></span>Conversion Forms
                                            </h3>

                                        </div>
                                        <div class="criterium-content">

                                        </div>
                                        <div class="criterium-quicktips">Add a conversion form</div>
                                        <div class="delimiter"></div></div>



                                    <div id="criterium-above_fold" class="criterium result-0 ">
                                        <div class="criterium-head">

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                <span class=""></span>Above the Fold Content
                                            </h3>

                                        </div>

                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p>Place the most important content <strong>above the fold line</strong>.</p>
                                            </div>
                                            <div id="set52Loader">
                                                <div style="text-align:center; display: block" ><img width="10" height="10" style="width: 10%;margin-left: -42%; height: 10%; margin-top: 5%;" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="usability">
                                                <div class="part above-fold-wrapper">

                                                    <div class="screen">
                                                        <img id="usabilityImage" src="">
                                                        <div class="line-wrapper">
                                                            <p class="text">Fold line</p>
                                                            <div class="dotted"></div>
                                                        </div>
                                                        <div class="bad-zone"></div>
                                                    </div>
                                                    <div class="screen-foot"></div>
                                                </div></div>
                                        </div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-page_size" class="criterium result-0 hidden">
                                        <div class="criterium-head">
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                <span class="fa"></span>Page Size
                                            </h3>
                                        </div>
                                        <div id="set34Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p itemprop="fileSize">30.7 KB (World Wide Web <a rel="nofollow" href="https://developers.google.com/speed/articles/web-metrics" target="_blank">average is 320 Kb</a>)</p>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>
                                    <div id="criterium-load_time" class="criterium result-1 hidden">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">1.3452914798206</span>
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Load Time
                                            </h3>
                                        </div>
                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p>0.17 second(s) (184.45 kB/s)</p>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips">Speed-up your website</div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-language" class="criterium result-3 hidden">
                                        <div class="criterium-head">
                                            <span class="prio-score hidden">20</span>
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Errors">
                                                <span class="fa"></span>Language</h3>
                                        </div>
                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p itemprop="inLanguage"><span class="bold">Declared:</span> Missing</p>
                                                <p><span class="bold">Detected: </span><i>English</i></p>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips">Declare the language used</div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-printability_css" class="criterium result-3 hidden">
                                        <div class="criterium-head">
                                            <span class="prio-score hidden">10</span>
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Errors">
                                                <span class="fa"></span>Printability
                                            </h3>
                                        </div>
                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p>We could not find a Print-Friendly CSS</p>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-microformats" class="criterium result-3 hidden">
                                        <div class="criterium-head">
                                            <span class="prio-score hidden">30</span>
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Errors">
                                                <span class="fa"></span>Microformats</h3>
                                        </div>
                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p>We found 0 type(s) of Microformat</p>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-dublin_core" class="criterium result-3 hidden">
                                        <div class="criterium-head">
                                            <span class="prio-score hidden">10</span>
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Errors">
                                                <span class="fa"></span>Dublin Core</h3>
                                        </div>
                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p><span class="italic">Missing</span></p>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>



                                    <div id="criterium-tld_cybersquating_prevention" class="criterium result-0 hidden">
                                        <div class="criterium-head">
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                <span class="fa"></span>Domain Availability</h3>
                                        </div>
                                        <div class="criterium-content">
                                            <div class="part table ">
                                                <table class="">
                                                    <thead>
                                                        <tr>
                                                            <th>Domains (<a rel="nofollow" href="http://en.wikipedia.org/wiki/Top-level_domain" target="_blank">TLD</a>)</th>
                                                            <th>Status</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody  class="tbody_font_size" >
                                                        <tr class="">
                                                            <td>socioboard.net</td>
                                                            <td>in 3 months</td>
                                                            <td><span class="fa fa-lock"></span></td>
                                                        </tr>
                                                        <tr class="">
                                                            <td>socioboard.org</td>
                                                            <td>This domain is booked</td>
                                                            <td><span class="fa fa-lock"></span></td>
                                                        </tr>
                                                        <tr class="">
                                                            <td>socioboard.info</td>
                                                            <td>Available. <a rel="nofollow" href="http://bit.ly/1qKTAle" target="_blank">Book it now!</a></td>
                                                            <td><span class="fa fa-check"></span></td>
                                                        </tr>
                                                        <tr class="">
                                                            <td>socioboard.biz</td>
                                                            <td>Available. <a rel="nofollow" href="http://bit.ly/1qKTAle" target="_blank">Book it now!</a></td>
                                                            <td><span class="fa fa-check"></span></td>
                                                        </tr>
                                                        <tr class="">
                                                            <td>socioboard.eu</td>
                                                            <td>Available. <a rel="nofollow" href="http://bit.ly/1qKTAle" target="_blank">Book it now!</a></td>
                                                            <td><span class="fa fa-check"></span></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-typo_cybersquating_prevention" class="criterium result-0 hidden">
                                        <div class="criterium-head">
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                <span class="fa"></span>Typo Availability
                                            </h3>
                                        </div>
                                        <div class="criterium-content">
                                            <div class="part table ">
                                                <table class="">
                                                    <thead>
                                                        <tr>
                                                            <th>Domains (<a rel="nofollow" href="http://en.wikipedia.org/wiki/Top-level_domain" target="_blank">TLD</a>)</th>
                                                            <th>Status</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody  class="tbody_font_size" >
                                                        <tr class="">
                                                            <td>aocioboard.com</td>
                                                            <td>Available. <a rel="nofollow" href="http://bit.ly/1qKTAle" target="_blank">Book it now!</a></td>
                                                            <td><span class="fa fa-check"></span></td>
                                                        </tr>
                                                        <tr class="">
                                                            <td>sicioboard.com</td>
                                                            <td>Available. <a rel="nofollow" href="http://bit.ly/1qKTAle" target="_blank">Book it now!</a></td>
                                                            <td><span class="fa fa-check"></span></td>
                                                        </tr>
                                                        <tr class="">
                                                            <td>soxioboard.com</td>
                                                            <td>Available. <a rel="nofollow" href="http://bit.ly/1qKTAle" target="_blank">Book it now!</a></td>
                                                            <td><span class="fa fa-check"></span></td>
                                                        </tr>
                                                        <tr class="">
                                                            <td>socuoboard.com</td>
                                                            <td>Available. <a rel="nofollow" href="http://bit.ly/1qKTAle" target="_blank">Book it now!</a></td>
                                                            <td><span class="fa fa-check"></span></td>
                                                        </tr>
                                                        <tr class="">
                                                            <td>socioblard.com</td>
                                                            <td>Available. <a rel="nofollow" href="http://bit.ly/1qKTAle" target="_blank">Book it now!</a></td>
                                                            <td><span class="fa fa-check"></span></td>
                                                        </tr>
                                                        <tr class="">
                                                            <td>sociovoard.com</td>
                                                            <td>Available. <a rel="nofollow" href="http://bit.ly/1qKTAle" target="_blank">Book it now!</a></td>
                                                            <td><span class="fa fa-check"></span></td>
                                                        </tr>
                                                        <tr class="over-max">
                                                            <td>sociobozrd.com</td>
                                                            <td>Available. <a rel="nofollow" href="http://bit.ly/1qKTAle" target="_blank">Book it now!</a></td>
                                                            <td><span class="fa fa-check"></span></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                                <div class="show-links">
                                                    <a href="#" class="show-more">Show more</a>
                                                    <a href="#" class="show-less">Show less</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-email_security" class="criterium result-1 hidden">
                                        <div class="criterium-head">
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Email Privacy</h3>
                                        </div>
                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p>Good, no email address has been found in plain text.</p>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips">Hide email addresses to avoid being spammed</div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-spam_threats" class="criterium result-1 hidden ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">2.2421524663677</span>
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Spam Block</h3>
                                        </div>
                                        <div class="criterium-content">
                                        </div>
                                        <div class="criterium-quicktips">Contact Spamcop.net to clean your reputation</div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-trust_indicators" class="criterium result-0 hidden ">
                                        <div class="criterium-head">
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                <span class="fa"></span>Trust Indicators</h3>
                                        </div>
                                        <div class="criterium-content">
                                        </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>


                                    <div id="criterium-safe_browsing" class="criterium result-1 hidden">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">4.4843049327354</span>
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                <span class="fa"></span>Safe Browsing</h3>
                                        </div>
                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p>Yes</p>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips">Are you a spammer?</div>
                                        <div class="delimiter"></div></div>

                                </div>
                            </div>


                            <!-- Technologies -->
                            <div class="module" id="module-technologies">
                                <div class="module-content">
                                    <h2>Technologies</h2>
                                    <div id="technologies">
                                        <div id="criterium-ip_information" class="criterium result-0 ">
                                            <div class="criterium-head">

                                                <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                    <span class="fa"></span>Server IP
                                                </h3>

                                            </div>
                                            <div id="set35Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="serverIP">
                                                <div class="criterium-content">
                                                    <div class="part text ">
                                                        <p id="ipaddress"></p>
                                                        <p  itemprop="contentLocation"><span class="bold">Server location: </span> <span class="flag us" id="location"></span></p>
                                                        <!--<p  itemprop="contentLocation"><span class="bold">Latitude: </span> <span class="flag us" id="latitude"></span></p>-->
                                                        <!--<p  itemprop="contentLocation"><span class="bold">Longitude: </span> <span class="flag us" id="longitude"></span></p>-->
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="criterium-quicktips"></div>
                                            <div class="delimiter"></div></div>


                                        <div id="criterium-technologies" class="criterium result-0 ">
                                            <div class="criterium-head">
                                                <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                    <span class="fa"></span>Technologies</h3>
                                            </div>
                                            <div id="set36Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="technology">
                                                <div class="criterium-content">
                                                    <div class="part text " >
                                                        <table class="no-header">
                                                            <tbody  class="tbody_font_size"  id="technologytable">
                                                            </tbody>
                                                        </table>
                                                        <p id="technologyused"></p>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="criterium-quicktips"></div>
                                            <div class="delimiter"></div></div>

                                        <div id="criterium-analytics_technologies" class="criterium result-1 ">
                                            <div class="criterium-head">
                                                <span class="crit-score-pond hidden">1.3452914798206</span>
                                                <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                    <span class="fa"></span>Analytics
                                                </h3>
                                            </div>
                                            <div id="set38Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="analytics">
                                                <div class="criterium-content">
                                                    <div class="part text ">

                                                        <table class="no-header">
                                                            <tbody  class="tbody_font_size"  id="analyticstable">
                                                            </tbody>
                                                        </table>
                                                        <p id="analytics"></p>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="criterium-quicktips"></div>
                                            <div class="delimiter"></div></div>


                                        <div id="criterium-w3c_validity" class="criterium result-3 ">
                                            <div class="criterium-head">
                                                <span class="prio-score hidden">10</span>
                                                <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Errors">
                                                    <span class="fa"></span>W3C Validity</h3>
                                            </div>
                                            <div id="set39Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="wcvalidity">
                                                <div class="criterium-content">
                                                    <div class="part text ">
                                                        <p><span class="bold first-letter-cap">Invalid:</span><span id="w3cvalidity"></span></p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="criterium-quicktips">Fix the errors in the code syntax</div>
                                            <div class="delimiter"></div>
                                        </div>

                                        <div id="criterium-doctype" class="criterium result-0 ">
                                            <div class="criterium-head">
                                                <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                                    <span class="fa"></span>Doctype</h3>
                                            </div>
                                            <div id="set40Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="doctype1">
                                                <div class="criterium-content">
                                                    <div class="part text ">
                                                        <p itemprop="fileFormat" id="doctype"></p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="criterium-quicktips"></div>
                                            <div class="delimiter"></div></div>


                                        <div id="criterium-encoding" class="criterium result-1 ">
                                            <div class="criterium-head">
                                                <span class="crit-score-pond hidden">0.44843049327354</span>
                                                <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                    <span class="fa"></span>Encoding</h3>
                                            </div>
                                            <div id="set41Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="encoding1">
                                                <div class="criterium-content">
                                                    <div class="part text ">
                                                        <p id="encoding"></p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="criterium-quicktips"></div>
                                            <div class="delimiter"></div></div>

                                        <div id="criterium-deprecated_html_element" class="criterium result-1 hidden ">
                                            <div class="criterium-head">
                                                <span class="crit-score-pond hidden">1.3452914798206</span>
                                                <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                    <span class="fa"></span>Deprecated HTML</h3>
                                            </div>
                                            <div class="criterium-content">
                                            </div>
                                            <div class="criterium-quicktips"></div>
                                            <div class="delimiter"></div></div>

                                        <div id="criterium-directory_browsing" class="criterium result-1 ">
                                            <div class="criterium-head">
                                                <span class="crit-score-pond ">0.44843049327354</span>
                                                <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                    <span class="fa"></span>Directory Browsing</h3>
                                            </div>
                                            <div id="set42Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="directoryBrowsing">
                                                <div class="criterium-content">
                                                    <div class="part text ">
                                                        <p>No</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="criterium-quicktips"></div>
                                            <div class="delimiter"></div></div>


                                        <div id="criterium-server_signature" class="criterium result-1  ">
                                            <div class="criterium-head">
                                                <span class="crit-score-pond ">0.44843049327354</span>
                                                <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed">
                                                    <span class="fa"></span>Server Signature</h3>
                                            </div>
                                            <div id="set43Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="serverSignature">
                                                <div class="criterium-content">
                                                    <div class="part text ">
                                                        <p>No</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="criterium-quicktips"></div>
                                            <div class="delimiter"></div></div>
                                    </div>
                                </div>
                            </div>


                            <div class="module-section" id="module-section-title-promote">Promote</div>
                            <div class="module" id="module-social">
                                <div class="module-content">
                                    <h2>Social</h2>


                                    <!-- Social Shareability -->
                                    <div id="criterium-facebook_brand_page" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">1.3452914798206</span>
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed" style="margin-left: 13%;">
                                                <span class="fa"></span>Social Shareability 
                                            </h3>
                                        </div>
                                        <div id="socialshareability">
                                            <div id="set58Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="socialShareabilitypage">
                                                <div class="criterium-content">

                                                    <div class="part text text-block fb-text-bloc">
                                                        <img src="https://s3.amazonaws.com/images-globustracker/review/alexa_16x16.png" alt=""/>
                                                        <p>Alexa Rank</p>
                                                        <p id="aLexaRank"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <img src="https://s3.amazonaws.com/images-globustracker/review/facebook-shares.png" alt=""/>
                                                        <p>Facebook Shares</p>
                                                        <p id="facebookShareCount"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <img src="https://s3.amazonaws.com/images-globustracker/review/facebook-likes.png" alt=""/>
                                                        <p>Facebook Likes</p>
                                                        <p id="facebookLikesCount"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <img src="https://s3.amazonaws.com/images-globustracker/review/fbcmnt.png" alt=""/>
                                                        <p>Facebook Comment</p>
                                                        <p id="facebookComment"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <img src="https://s3.amazonaws.com/images-globustracker/review/facebooktotal.png" alt=""/>
                                                        <p>Facebook Total</p>
                                                        <p id="facebookTotalCount"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <img src="https://s3.amazonaws.com/images-globustracker/review/click_16x16.png" alt=""/>
                                                        <p>Facebook Click</p>
                                                        <p id="facebookClickCount"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <img src="https://s3.amazonaws.com/images-globustracker/review/Comment-Box.jpg" alt=""/>
                                                        <p>Facebook Comments Box</p>
                                                        <p id="facebookCommentsBoxCount"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <img src="https://s3.amazonaws.com/images-globustracker/review/linkedIn.png" alt=""/>
                                                        <p>LinkedIn Count</p>
                                                        <p id="linkedInCount"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <img src="https://s3.amazonaws.com/images-globustracker/review/pinterest.png" alt=""/>
                                                        <p>Pinterest Count</p>
                                                        <p id="pinterestCount"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <img src="https://s3.amazonaws.com/images-globustracker/review/twitter_b.png" alt=""/>
                                                        <p>Twitter Count</p>
                                                        <p id="twitterCounts"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <img src="https://s3.amazonaws.com/images-globustracker/review/google-plus.png" alt=""/>
                                                        <p>Google Plus Like</p>
                                                        <p id="googlePlusLike"></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>

                                    <!-- twitter_brand_page -->

                                    <div id="criterium-twitter_account" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">1.3452914798206</span>

                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed" style="margin-left: 13%;">
                                                <span class="fa"></span>Twitter Account
                                            </h3>

                                            <div class="icons">
                                                <span class="importance-1 simple-tooltip" data-placement="top" rel="tooltip" data-original-title="Low impact">
                                                    <span class="fa fa-bullet-impact"></span><span class="fa fa-bullet-impact"></span><span class="fa fa-bullet-impact"></span>
                                                    <span>Low impact</span>
                                                </span>
                                            </div>
                                        </div>
                                        <div id="set44Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="twitterAccount">
                                            <div class="criterium-content">
                                                <div class="part image cover-image">
                                                    <img src="" alt="" id="twitterImage">
                                                </div>
                                                <div class="part text ">
                                                    <p> <span class="bold"></span></p>
                                                </div>
                                                <div class="part text ">
                                                    <p itemprop="brand">
                                                        <span class="right-aligned">Name</span>
                                                        <span class="right-aligned-content">
                                                            <a rel="nofollow" href="" target="_blank" id="twitterName"></a>
                                                        </span>
                                                    </p>
                                                    <p>
                                                        <span class="right-aligned">Count</span>
                                                        <span class="right-aligned-content" id="twitterCount"></span>
                                                    </p>
                                                    <p>
                                                        <span class="right-aligned">Following</span>
                                                        <span class="right-aligned-content" id="twitterFollowing"></span>
                                                    </p>
                                                    <p>
                                                        <span class="right-aligned">Followers</span>
                                                        <span class="right-aligned-content" id="twitterFollower"></span>
                                                    </p>
                                                    <p>
                                                        <span class="right-aligned">List</span>
                                                        <span class="right-aligned-content" id="twitterList"></span>
                                                    </p>
                                                    <p>
                                                        <span class="right-aligned">Location</span>
                                                        <span class="right-aligned-content" id="twitterLocation"></span>
                                                    </p>
                                                    <p>
                                                        <span class="right-aligned">Favorities</span>
                                                        <span class="right-aligned-content" id="twitterFavourites"></span>
                                                    </p>
                                                    <p>
                                                        <span class="right-aligned">Joineddate</span>
                                                        <span class="right-aligned-content" id="twitterDate"></span>
                                                    </p>
                                                    <p>
                                                        <span class="right-aligned">Description</span>
                                                        <span class="right-aligned-content" id="twitterDescription"></span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="delimiter"></div>
                                    </div>



                                    <!-- facebook_brand_page -->
                                    <div id="criterium-facebook_brand_page" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">1.3452914798206</span>
                                            <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Passed" style="margin-left: 13%;">
                                                <span class="fa"></span>Facebook Page
                                            </h3>
                                        </div>
                                        <div id="facebook">
                                            <div id="set45Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="facebookPage">
                                                <div class="criterium-content">
                                                    <div class="part image cover-image">
                                                        <img src=""  alt="" id="facebookImage"/>
                                                    </div>
                                                    <div class="part text text-icon-block">
                                                        <p><span class="icon fb-fancount"><i class="fa fa-thumbs-up"></i> Likes</span><span id="facebookLikes"></span></p>
                                                    </div>
                                                    <div class="part text text-icon-block">
                                                        <p><span class="icon fb-talkingaboutcount">Talking About</span><span id="takingAbout"></span></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>URL</p>
                                                        <p><a class="fb-page-url" href="" target="_blank"><span class="fb-bold" id="facebookUrl"></span></a></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Name</p>
                                                        <p id="facebookName"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>About</p>
                                                        <p id="facebookAbout"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Company Overview</p>
                                                        <p id="facebookOverview"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Description</p>
                                                        <p id="facebookDescription"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Products</p>
                                                        <p id="facebookProduct"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Mission</p>
                                                        <p id="facebookMission"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Address</p>
                                                        <p id="facebookAddress"></p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Phone</p>
                                                        <p id="facebookPhone"></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="criterium-quicktips"></div>
                                        <div class="delimiter"></div></div>

                                    <!-- google+_brand_page -->
                                    <div id="criterium-google_plus_page" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">1.3574660633484</span>

                                            <h3 class="simple-tooltip" data-placement="left" style="margin-left: 13%;" rel="tooltip" data-original-title="Passed">
                                                <span class=""></span>Google+ Page
                                            </h3>
                                        </div>
                                        <div id="googleplus">
                                            <div id="set46Loader">
                                                <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                            </div>
                                            <div id="googlePage">
                                                <div class="criterium-content">
                                                    <div class="part image cover-image">
                                                        <img src=""  alt="" id="googleImage" />
                                                    </div>
                                                    <div class="part text text-icon-block">
                                                        <p>
                                                            <span class="icon gp-plusonecount"></span>
                                                        </p>
                                                    </div>
                                                    <div class="part text text-icon-block">
                                                        <p><span class="icon gp-circledbycount"></span></p>
                                                    </div>

                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>URL</p>
                                                        <p>
                                                            <a class="fb-page-url" href="" target="_blank">
                                                                <span class="fb-bold" id="googleUrl"></span>
                                                            </a>
                                                        </p>
                                                    </div>
                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Name</p>
                                                        <p id="googleName"></p>
                                                    </div>

                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Follower</p>
                                                        <p id="googleFollower"></p>
                                                    </div>

                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Views</p>
                                                        <p id="googleViews"></p>
                                                    </div>

                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Verified</p>
                                                        <p id="googleVerified"></p>
                                                    </div>

                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Company Overview</p>
                                                        <p id="googleOverview"></p>
                                                    </div>

                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Tagline</p>
                                                        <p id="googleTagline"></p>
                                                    </div>

                                                    <div class="part text text-block fb-text-bloc">
                                                        <p>Introduction</p>
                                                        <p id="googleIntroduction"></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="criterium-advice-click"><span>?</span></div>
                                        <div class="criterium-advice">
                                            This page is your business listing in Google+. Being active in this social network is important for claiming your brand, influencing your search engine rankings and interacting with your network. You might also consider <a rel="nofollow" href="http://www.google.com/business/" target="_blank">managing your profile</a> with <a rel="" nofollow="" href="http://blog.woorank.com/2014/06/google-places-for-business-is-google-my-business/" target="_blank">Google My Business (formerly Google Places)</a>.

                                        </div>

                                        <div class="delimiter"></div></div>

                                    <!-- linkedin_brand_page -->
                                    <div id="criterium-google_plus_page" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">1.3574660633484</span>

                                            <h3 class="simple-tooltip" data-placement="left" style="margin-left: 13%;" rel="tooltip" data-original-title="Passed">
                                                <span class=""></span>Linkedin
                                            </h3>
                                        </div>
                                        <!--<div id="googleplus">-->
                                        <div id="set56Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="linkedinAccount">
                                            <div class="criterium-content">
                                                <div class="part image cover-image">
                                                    <img src=""  alt="" id="linkedImage" />
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Follower</p>
                                                    <p id="linkedFollower"></p>
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Description</p>
                                                    <p id="linkedDescription"></p>
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Specialties</p>
                                                    <p id="linkedSpecialties"></p>
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Website</p>
                                                    <p id="linkedWebsite"></p>
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Industry</p>
                                                    <p id="linkedIndustry"></p>
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Type</p>
                                                    <p id="linkedType"></p>
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Headquater</p>
                                                    <p id="linkedHeadquater"></p>
                                                </div>
                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Company</p>
                                                    <p id="linkedCompany"></p>
                                                </div>
                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Founded</p>
                                                    <p id="linkedFounded"></p>
                                                </div>
                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Employee</p>
                                                    <p id="linkedEmployee"></p>
                                                </div>

                                            </div>
                                        </div>
                                        <!--</div>-->
                                        <div class="criterium-advice-click"><span>?</span></div>
                                        <div class="criterium-advice">
                                            This page is your business listing in Google+. Being active in this social network is important for claiming your brand, influencing your search engine rankings and interacting with your network. You might also consider <a rel="nofollow" href="http://www.google.com/business/" target="_blank">managing your profile</a> with <a rel="" nofollow="" href="http://blog.woorank.com/2014/06/google-places-for-business-is-google-my-business/" target="_blank">Google My Business (formerly Google Places)</a>.

                                        </div>

                                        <div class="delimiter"></div></div>

                                    <!--Pinterest Page-->

                                    <div id="criterium-google_plus_page" class="criterium result-1 ">
                                        <div class="criterium-head">
                                            <span class="crit-score-pond hidden">1.3574660633484</span>

                                            <h3 class="simple-tooltip" data-placement="left" style="margin-left: 13%;" rel="tooltip" data-original-title="Passed">
                                                <span class=""></span>Pinterest
                                            </h3>
                                        </div>
                                        <div id="set57Loader">
                                            <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                        </div>
                                        <div id="PinterestAccount">
                                            <div class="criterium-content">
                                                <div class="part image cover-image">
                                                    <img src=""  alt="" id="pInterestImage" />
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Name</p>
                                                    <p id="pInterestName"></p>
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Boards</p>
                                                    <p id="pInterestBoards"></p>
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Pins</p>
                                                    <p id="pInterestPins"></p>
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Likes</p>
                                                    <p id="pInterestLikes"></p>
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Follower</p>
                                                    <p id="pInterestFollower"></p>
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Following</p>
                                                    <p id="pInterestFollowing"></p>
                                                </div>

                                                <div class="part text text-block fb-text-bloc">
                                                    <p>Description</p>
                                                    <p id="pInterestDescription"></p>
                                                </div>

                                            </div>
                                        </div>
                                        <!--</div>-->
                                        <div class="criterium-advice-click"><span>?</span></div>
                                        <div class="criterium-advice">
                                            This page is your business listing in Google+. Being active in this social network is important for claiming your brand, influencing your search engine rankings and interacting with your network. You might also consider <a rel="nofollow" href="http://www.google.com/business/" target="_blank">managing your profile</a> with <a rel="" nofollow="" href="http://blog.woorank.com/2014/06/google-places-for-business-is-google-my-business/" target="_blank">Google My Business (formerly Google Places)</a>.

                                        </div>

                                        <div class="delimiter"></div></div>

                                </div>
                            </div>
                        </div>

                        <div class="module-section" id="module-section-title-measure">Measure</div>
                        <!--<div id="visitorsnew">-->
                        <div class="module" id="module-visitors">
                            <div class="module-content">
                                <h2>Visitors</h2>
                                <div id="criterium-alexa" class="criterium result-2">
                                    <div class="criterium-head">
                                        <span class="crit-score-pond hidden">3.5874439461883</span>
                                        <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="To Improve">
                                            <span class="fa"></span>Traffic Estimations</h3>
                                    </div>

                                    <div id="set55Loader">
                                        <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                    </div>
                                    <div id="trafficEstimation1">
                                        <div class="criterium-content">
                                            <div class="part progressbar ">
                                                <div class="content">
                                                    <span class="bar">
                                                        <span class="colored-bar" style="width:100%; text-align: center" id="trafficEstimation"></span>
                                                        <span class="value" data-abs-value=""></span>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="criterium-quicktips"></div>
                                    <div class="delimiter"></div></div>
                                <div id="criterium-trafic_ranking" class="criterium result-0 ">
                                    <div class="criterium-head">

                                        <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                            <span class="fa"></span>Traffic Rank
                                        </h3>

                                    </div>
                                    <div id="set48Loader">
                                        <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                    </div>
                                    <div id="trafficRank1">
                                        <div class="criterium-content">
                                            <div class="part text ">
                                                <p>
                                                    <span class="bold" id="globalrank"></span>
                                                    <span class="superscript">th</span> most visited website in 
                                                    <span class="bold">the World</span>
                                                </p>
                                                <p>
                                                    <a class="wooindex-bl" target="_blank" href="">
                                                        <span class="bold" id="countryRank"></span>
                                                        <span class="superscript">th </span> most visited website in
                                                        <b>the Unites states</b>
                                                    </a>
                                                </p>
                                            </div>           
                                        </div></div>
                                    <div class="criterium-quicktips"></div>
                                    <div class="delimiter"></div></div>

                                <div id="criterium-adwords_traffic" class="criterium result-0 hidden ">
                                    <div class="criterium-head">
                                        <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                            <span class="fa"></span>Adwords Traffic</h3>
                                    </div>
                                    <div id="set49Loader">
                                        <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                    </div>
                                    <div class="criterium-content">
                                    </div>
                                    <div class="criterium-quicktips"></div>
                                    <div class="delimiter"></div></div>


                                <div id="criterium-visitors_loc" class="criterium result-0 ">
                                    <div class="criterium-head">
                                        <h3 class="simple-tooltip" data-placement="left" rel="tooltip" data-original-title="Low impact">
                                            <span class="fa"></span>Server Localization</h3>
                                    </div>
                                    <div id="set50Loader">
                                        <div style="text-align:center; display: block" ><img width="50" height="50" src="https://s3.amazonaws.com/images-globustracker/review/loader_image"/></div>
                                    </div>
                                    <div id="VisitorsLocalization1">
                                        <div class="criterium-content" id="localozation">
                                            <div class="part bar " >

                                                <div id="googleMap" style="width:500px; height:250px;"></div>

                                            </div>
                                            <div class="part table ">
                                                <table class="">
                                                    <thead  class="tbody_font_size">
                                                        <tr>
                                                            <th>Popular Countries</th>
                                                            <th><a rel="nofollow" href="http://en.wikipedia.org/wiki/Country_code_top-level_domain" target="_blank">Percent of Visitors</a></th>
                                                            <th>Rank</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody  class="tbody_font_size"  id="visitortable">
                                                    </tbody>
                                                </table>
                                            </div>    
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="criterium-quicktips"></div>
                            <div class="delimiter"></div></div>
                    </div>
                </div>

                <div class="hidden" id="get-manycontact-quick-wins">
                    <a class="external-link" href="" rel="nofollow" target="_blank">
                        <li><i></i>Add a Conversion Form or use ManyContacts </li>
                    </a>
                </div>
                <div class="hidden" id="translations-glossary">
                    <span class="set_or_create_twitter">[YML:set_or_create_twitter]</span>
                    <span class="field_placeholder_twitter">[YML:field_placeholder_twitter]</span>
                    <span class="set">Set</span>
                </div>
            </div>
        </div>

        <!--</div>-->

        <!--        <script type="text/javascript">
                    var Base64 = {
                        // private property
                        _keyStr: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",
                        // public method for encoding
                        encode: function(input) {
                            var output = "";
                            var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
                            var i = 0;
        
                            input = Base64._utf8_encode(input);
        
                            while (i < input.length) {
        
                                chr1 = input.charCodeAt(i++);
                                chr2 = input.charCodeAt(i++);
                                chr3 = input.charCodeAt(i++);
        
                                enc1 = chr1 >> 2;
                                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                                enc4 = chr3 & 63;
        
                                if (isNaN(chr2)) {
                                    enc3 = enc4 = 64;
                                } else if (isNaN(chr3)) {
                                    enc4 = 64;
                                }
        
                                output = output +
                                        this._keyStr.charAt(enc1) + this._keyStr.charAt(enc2) +
                                        this._keyStr.charAt(enc3) + this._keyStr.charAt(enc4);
        
                            }
        
                            return output;
                        },
                        // public method for decoding
                        decode: function(input) {
                            var output = "";
                            var chr1, chr2, chr3;
                            var enc1, enc2, enc3, enc4;
                            var i = 0;
        
                            input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");
        
                            while (i < input.length) {
        
                                enc1 = this._keyStr.indexOf(input.charAt(i++));
                                enc2 = this._keyStr.indexOf(input.charAt(i++));
                                enc3 = this._keyStr.indexOf(input.charAt(i++));
                                enc4 = this._keyStr.indexOf(input.charAt(i++));
        
                                chr1 = (enc1 << 2) | (enc2 >> 4);
                                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                                chr3 = ((enc3 & 3) << 6) | enc4;
        
                                output = output + String.fromCharCode(chr1);
        
                                if (enc3 != 64) {
                                    output = output + String.fromCharCode(chr2);
                                }
                                if (enc4 != 64) {
                                    output = output + String.fromCharCode(chr3);
                                }
        
                            }
        
                            output = Base64._utf8_decode(output);
        
                            return output;
        
                        },
                        // private method for UTF-8 encoding
                        _utf8_encode: function(string) {
                            string = string.replace(/\r\n/g, "\n");
                            var utftext = "";
        
                            for (var n = 0; n < string.length; n++) {
        
                                var c = string.charCodeAt(n);
        
                                if (c < 128) {
                                    utftext += String.fromCharCode(c);
                                }
                                else if ((c > 127) && (c < 2048)) {
                                    utftext += String.fromCharCode((c >> 6) | 192);
                                    utftext += String.fromCharCode((c & 63) | 128);
                                }
                                else {
                                    utftext += String.fromCharCode((c >> 12) | 224);
                                    utftext += String.fromCharCode(((c >> 6) & 63) | 128);
                                    utftext += String.fromCharCode((c & 63) | 128);
                                }
        
                            }
        
                            return utftext;
                        },
                        // private method for UTF-8 decoding
                        _utf8_decode: function(utftext) {
                            var string = "";
                            var i = 0;
                            var c = c1 = c2 = 0;
        
                            while (i < utftext.length) {
        
                                c = utftext.charCodeAt(i);
        
                                if (c < 128) {
                                    string += String.fromCharCode(c);
                                    i++;
                                }
                                else if ((c > 191) && (c < 224)) {
                                    c2 = utftext.charCodeAt(i + 1);
                                    string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
                                    i += 2;
                                }
                                else {
                                    c2 = utftext.charCodeAt(i + 1);
                                    c3 = utftext.charCodeAt(i + 2);
                                    string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
                                    i += 3;
                                }
        
                            }
        
                            return string;
                        }
        
                    };
        
        
                </script>-->
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>

        <script  type='text/javascript'>

                                    function onoff() {
                                        if (document.getElementById("start_interval").checked) {
                                            document.getElementById('start_interval').setAttribute("value", "1");
                                        }
                                    }
                                    function WebsiteReview() {
                                        var siteurl = $("#sitename").val();

                                        siteurl = siteurl.replace("http://", "").replace("https://", "").replace("www.", "");
                                        window.location.href = siteurl + ".htm";
                                    }
        </script>
        <!--        <script
                    src="http://maps.googleapis.com/maps/api/js">
                </script>-->
        <script type="text/javascript">

            var timeout = 5000;
            ajaxFunction();

            function ajaxFunction() {
                var sitename = document.getElementById('websearchurl').value;

                $.getJSON(
                        'databaseExist.action',
                        {
                            sitename: sitename
                        },
                function (output) {

                    if (output.result === 0) {
                        timeout = 65000;
                    }
                    setData();

                });
            }




//            function ajaxFunction() {
//
//                var ajaxRequest;  // The variable that makes Ajax possible!
//
//                try {
//                    // Opera 8.0+, Firefox, Safari
//                    ajaxRequest = new XMLHttpRequest();
//
//                } catch (e) {
//                    //                                    // Internet Explorer Browsers
//                    try {
//                        ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
//                    } catch (e) {
//                        try {
//                            ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
//                        } catch (e) {
//                            // Something went wrong
//                            alert('Your browser broke!');
//                        }
//                    }
//                }
//
//                // Create a function that will receive data 
//                // sent from the server and will update
//                // div section in the same page.
//                ajaxRequest.onreadystatechange = function() {
//                    if (ajaxRequest.readyState === 4) {
//
//                        var result = ajaxRequest.responseText.toString();
//                        var output = JSON.parse(result);
////                        console.log(output.result);
//                        if (output.result === 0) {
//                            timeout = 60000;
//                        }
//                        setData();
//                    }
//                };
//                // Now get the value from user and pass it to
//                // server script.
//
//                ajaxRequest.open("GET", "databaseExist.action?sitename=" + document.getElementById('websearchurl').value, false);
//                ajaxRequest.send(null);
//
//            }

            var lat = 0.0;
            var long = 0.0;

            function initialize()
            {
//                console.log('lat ' + lat);
//                console.log('long ' + long);

                var myCenter = new google.maps.LatLng(lat, long);
                var mapProp = {
                    center: myCenter,
                    zoom: 5,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };

                var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);

                var marker = new google.maps.Marker({
                    position: myCenter
                });

                marker.setMap(map);
            }

            var setvalue;

            //  $(document).ready(function() {
            function setData() {

                $("#trafficEstimation1").hide();
                $("#trafficRank1").hide();
                $("#VisitorsLocalization1").hide();
                $("#googlePage").hide();
                $("#facebookPage").hide();
                $("#twitterAccount").hide();
                $("#serverIP").hide();
                $("#technology").hide();
                $("#analytics").hide();
                $("#wcvalidity").hide();
                $("#doctype1").hide();
                $("#encoding1").hide();
                $("#directoryBrowsing").hide();
                $("#serverSignature").hide();
                $("#mobileRendering").hide();
                $("#mobileTime").hide();
                $("#mobileOptimization").hide();
                $("#RelatedWebsite").hide();
                $("#PageRank").hide();
                $("#Description1").hide();
                $("#Headings").hide();
                $("#MetaKeywords").hide();
                $("#Images").hide();
                $("#HTMLRatio").hide();
                $("#IndexedPages").hide();
                $("#GooglePreview").hide();
                $("#GooglePublisher").hide();
                $("#pageLinks").hide();
                $("#Backlinks").hide();
                $("#Resolve").hide();
                $("#Canonicalization").hide();
                $("#Robots").hide();
                $("#XMLSitemap").hide();
                $("#Rewrite").hide();
                $("#UnderscoresUrl").hide();
                $("#Flash").hide();
                $("#Frames").hide();
                $("#DomainRegistered").hide();
                $("#DomainExpiration").hide();
                $("#DomainUpdated").hide();
                $("#blog").hide();
                $("#usability").hide();
                $("#Title").hide();
                $("#linkedinAccount").hide();
                $("#PinterestAccount").hide();
                $('#socialShareabilitypage').hide();

                setvalue = setTimeout(function () {
                    //                    alert("-------1-------------");
                    var url = document.getElementById('websearchurl').value;
                    var imagessrnumber = 1;
                    var pagelinkshumber = 1;
                    //                    alert(url);
                    $.ajax({
                        type: 'POST',
//                        url: '/globustracker/reviews/visitors/' + url + ".htm",
                        url: '/reviews/visitors/' + url + ".htm",
                        data: {websearchurl: url},
                        beforeSend: function (xhr) {
                            xhr.setRequestHeader("Accept", "application/json");
                            xhr.setRequestHeader("Content-Type", "application/json");
                        },
                        success: function (responsejson) {
//                            console.log(responsejson);
                            $('#set1Loader').hide();
                            $('#set2Loader').hide();
                            $('#set3Loader').hide();
                            $('#set4Loader').hide();
                            $('#set5Loader').hide();
                            $('#set6Loader').hide();
                            $('#set7Loader').hide();
                            $('#set8Loader').hide();
                            $('#set9Loader').hide();
                            $('#set10Loader').hide();
                            $('#set11Loader').hide();
                            $('#set12Loader').hide();
                            $('#set13Loader').hide();
                            $('#set14Loader').hide();
                            $('#set15Loader').hide();
                            $('#set16Loader').hide();
                            $('#set17Loader').hide();
                            $('#set18Loader').hide();
                            $('#set19Loader').hide();
                            $('#set20Loader').hide();
                            $('#set21Loader').hide();
                            $('#set22Loader').hide();
                            $('#set23Loader').hide();
                            $('#set24Loader').hide();
                            $('#set25Loader').hide();
                            $('#set26Loader').hide();
                            $('#set27Loader').hide();
                            $('#set28Loader').hide();
                            $('#set29Loader').hide();
                            $('#set30Loader').hide();
                            $('#set31Loader').hide();
                            $('#set32Loader').hide();
                            $('#set33Loader').hide();
                            $('#set34Loader').hide();
                            $('#set35Loader').hide();
                            $('#set36Loader').hide();
                            $('#set37Loader').hide();
                            $('#set38Loader').hide();
                            $('#set39Loader').hide();
                            $('#set40Loader').hide();
                            $('#set41Loader').hide();
                            $('#set42Loader').hide();
                            $('#set43Loader').hide();
                            $('#set44Loader').hide();
                            $('#set45Loader').hide();
                            $('#set46Loader').hide();
                            $('#set47Loader').hide();
                            $('#set48Loader').hide();
                            $('#set49Loader').hide();
                            $('#set50Loader').hide();
                            $('#set51Loader').hide();
                            $('#set52Loader').hide();
                            $('#set53Loader').hide();
                            $('#set54Loader').hide();
                            $('#set55Loader').hide();
                            $('#set56Loader').hide();
                            $('#set57Loader').hide();
                            $('#set58Loader').hide();

                            $("#visitorsnew").show();
                            $("#facebook").show();
                            $("#googleplus").show();
                            $("#mobile").show();
                            $("#seo").show();
                            $("#technologies").show();
                            $("#localozation").show();
                            $("#trafficEstimation1").show();
                            $("#trafficRank1").show();
                            $("#VisitorsLocalization1").show();
                            $("#googlePage").show();
                            $("#facebookPage").show();
                            $("#twitterAccount").show();
                            $("#serverIP").show();
                            $("#technology").show();
                            $("#analytics").show();
                            $("#wcvalidity").show();
                            $("#doctype1").show();
                            $("#encoding1").show();
                            $("#directoryBrowsing").show();
                            $("#serverSignature").show();
                            $("#mobileRendering").show();
                            $("#mobileTime").show();
                            $("#mobileOptimization").show();
                            $("#RelatedWebsite").show();
                            $("#PageRank").show();
                            $("#Description1").show();
                            $("#Headings").show();
                            $("#MetaKeywords").show();
                            $("#Images").show();
                            $("#HTMLRatio").show();
                            $("#IndexedPages").show();
                            $("#GooglePreview").show();
                            $("#GooglePublisher").show();
                            $("#pageLinks").show();
                            $("#Backlinks").show();
                            $("#Resolve").show();
                            $("#Canonicalization").show();
                            $("#Robots").show();
                            $("#XMLSitemap").show();
                            $("#Rewrite").show();
                            $("#UnderscoresUrl").show();
                            $("#Flash").show();
                            $("#Frames").show();
                            $("#DomainRegistered").show();
                            $("#DomainExpiration").show();
                            $("#DomainUpdated").show();
                            $("#blog").show();
                            $("#usability").show();
                            $("#Title").show();
                            $("#linkedinAccount").show();
                            $("#PinterestAccount").show();
                            $("#socialshareability").show();
                            $("#socialShareabilitypage").show();

                            $.each(responsejson.imagedata, function (key, value) {

                                document.getElementById("imagestable").innerHTML = document.getElementById("imagestable").innerHTML + "<tr><td>" + imagessrnumber + "</td><td>" + value + "</td></tr>";
                                imagessrnumber++;
                            });



                            $.each(responsejson.pagelinksdata, function (i, j) {
                                var type;
                                var title = (j.title);
                                var title = title.substring(0, 5) + '..';
                                var sample = "<tr><td>" + j.links + "</td><td>" + j.type + "</td><td title=" + j.title + ">" + title + "</td></tr>";
                                $('#inpagelinkstable').append(sample);
                                //                                }
//                                if (i.contains('type')) {
//                                    type = j;
//                                }
//                                if (!i.contains('type')) {
//                                    // var sample = "<tr><td>" + j + "</td><td>" + type + "</td><td>Title</td></tr>";
//                                    // $('#inpagelinkstable').append(sample);
//                                }
                            });

                            var relatednumber = 1;
                            $.each(responsejson.relatedwebsite, function (key, value) {

                                document.getElementById("relatedtable").innerHTML = document.getElementById("relatedtable").innerHTML + "<tr><td>" + relatednumber + "</td><td>" + value + "</td></tr>";
                                relatednumber++;
                            });

                            var tech;
                            $.each(responsejson.technologydata, function (i, j) {

//                                if (i.contains('techUsed')) {
//                                    var sample = "<tr><td>" + j + "</td><td>" + "</td><td></td></tr>";
//                                    $('#technologytable').append(sample);
//                                }
                                if (i.indexOf('techUsed') !== -1) {
                                    var sample = "<tr><td>" + j + "</td><td>" + "</td><td></td></tr>";
                                    $('#technologytable').append(sample);
                                }

                                if (i.indexOf('analytics') !== -1) {
                                    var sample1 = "<tr><td>" + j + "</td><td>" + "</td><td></td></tr>";
                                    $('#analyticstable').append(sample1);
                                }

//                                if (i.contains('analytics')) {
//                                    var sample1 = "<tr><td>" + j + "</td><td>" + "</td><td></td></tr>";
//                                    $('#analyticstable').append(sample1);
//                                }
                            });

                            var visitorrank = 10000000;
                            var flag = 0;
                            $.each(responsejson.visitorarray, function (i, j) {

//                                if (i.contains('type')) {
//                                    type = j;
//                                }

                                if (i.indexOf('type') !== -1) {
                                    type = j;
                                }
                                /*
                                 if (!i.contains('type')) {
                                 
                                 var sample = "<tr><td>" + j.country + "</td><td>" + j.percent + "</td><td>" + j.rank + "</td></tr>";
                                 $('#visitortable').append(sample);
                                 
                                 }
                                 */
                                if (!i.indexOf('type') !== -1) {
                                    var sample = "<tr><td>" + j.country + "</td><td>" + j.percent + "</td><td>" + j.rank + "</td></tr>";
                                    $('#visitortable').append(sample);
                                }

                            });

                            var xmlnumber = 1;
                            $.each(responsejson.xmldata, function (key, value) {

                                document.getElementById("xmltable").innerHTML = document.getElementById("xmltable").innerHTML + "<tr><td>" + xmlnumber + "</td><td>" + value + "</td></tr>";
                                xmlnumber++;
                            });

                            $.each(responsejson.headingcount, function (key, value) {

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

                            $.each(responsejson.headingelements, function (i, j) {
                                /*
                                 if (i.contains('h1elements')) {
                                 if (j.contains('h1')) {
                                 j = j.replace('h1', '');
                                 }
                                 $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H1&gt;</span>" + j + "</td></tr>");
                                 }
                                 */
                                if (i.indexOf('h1elements') !== -1) {
                                    if (j.indexOf('h1')) {
                                        j = j.replace('h1', '');
                                    }
                                    $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H1&gt;</span>" + j + "</td></tr>");
                                }
                                /*
                                 if (i.contains('h2elements')) {
                                 if (j.contains('h2')) {
                                 j = j.replace('h2', '');
                                 }
                                 $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H2&gt;</span>" + j + "</td></tr>");
                                 }
                                 */
                                if (i.indexOf('h2elements') !== -1) {
                                    if (j.indexOf('h2')) {
                                        j = j.replace('h2', '');
                                    }
                                    $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H2&gt;</span>" + j + "</td></tr>");
                                }
                                /*
                                 if (i.contains('h3elements')) {
                                 if (j.contains('h3')) {
                                 j = j.replace('h3', '');
                                 }
                                 $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H3&gt;</span>" + j + "</td></tr>");
                                 }
                                 */
                                if (i.indexOf('h3elements') !== -1) {
                                    if (j.indexOf('h3')) {
                                        j = j.replace('h3', '');
                                    }
                                    $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H3&gt;</span>" + j + "</td></tr>");
                                }

                                /*
                                 if (i.contains('h4element')) {
                                 if (j.contains('h4')) {
                                 j = j.replace('h4', '');
                                 }
                                 $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H4&gt;</span>" + j + "</td></tr>");
                                 }
                                 */
                                if (i.indexOf('h4elements') !== -1) {
                                    if (j.indexOf('h4')) {
                                        j = j.replace('h4', '');
                                    }
                                    $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H4&gt;</span>" + j + "</td></tr>");
                                }

                                /*
                                 if (i.contains('h5element')) {
                                 if (j.contains('h5')) {
                                 j = j.replace('h5', '');
                                 }
                                 $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H5&gt;</span>" + j + "</td></tr>");
                                 }
                                 */
                                if (i.indexOf('h5elements') !== -1) {
                                    if (j.indexOf('h5')) {
                                        j = j.replace('h5', '');
                                    }
                                    $('.no-header.open').append("<tr class='over-max-v'><td>" + "<span>&lt;H5&gt;</span>" + j + "</td></tr>");
                                }
                            });

                            $.each(responsejson.visitmap, function (key, value) {

                                // alert(key, value);

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
                                    document.getElementById("pageRank").innerHTML = value;
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
                                if (key === 'googleFollower') {
                                    document.getElementById("googleFollower").textContent = value;
                                }
                                if (key === 'googleViews') {
                                    document.getElementById("googleViews").textContent = value;
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
                                /*
                                 $(this).css('display', 'none');
                                 document.getElementById(".test").css({
                                 display: 'block;'
                                 });
                                 */
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
                                if (key === 'twitterName') {
                                    document.getElementById("twitterName").textContent = value;
                                }
                                if (key === 'twitterImage') {
                                    $("#twitterImage").attr('src', value);
                                }
                                if (key === 'twitterCount') {
                                    document.getElementById("twitterCount").textContent = value;
                                }
                                if (key === 'twitterFollowing') {
                                    document.getElementById("twitterFollowing").textContent = value;
                                }
                                if (key === 'twitterFollower') {
                                    document.getElementById("twitterFollower").textContent = value;
                                }
                                if (key === 'twitterList') {
                                    document.getElementById("twitterList").textContent = value;
                                }
                                if (key === 'twitterDescription') {
                                    document.getElementById("twitterDescription").textContent = value;
                                }
                                if (key === 'twitterLocation') {
                                    document.getElementById("twitterLocation").textContent = value;
                                }
                                /*
                                 if (key === 'twitterUrl') {
                                 document.getElementById("twitterUrl").textContent = value;
                                 }
                                 */
                                if (key === 'twitterFavourites') {
                                    document.getElementById("twitterFavourites").textContent = value;
                                }
                                if (key === 'twitterDate') {
                                    document.getElementById("twitterDate").textContent = value;
                                }
                                if (key === 'dashboardImage') {
                                    $("#dashboardImage").attr('src', value);
                                }
                                if (key === 'usabilityImage') {
                                    $("#usabilityImage").attr('src', value);
                                }
                                if (key === 'descriptionLength') {
                                    document.getElementById("descriptionLength").textContent = value;
                                }
                                if (key === 'passedPercent') {
                                    document.getElementById("passedPercent").style = 'width:' + value + '%';
                                }
                                if (key === 'errorPercent') {
                                    document.getElementById("errorPercent").style = 'width:' + value + '%';
                                }
                                if (key === 'improvePercent') {
                                    document.getElementById("improvePercent").style = 'width:' + value + '%';
                                }
                                if (key === 'indexedPages') {
                                    document.getElementById("indexedPages").innerHTML = value;
                                }
                                if (key === 'backlinksCounter') {
                                    document.getElementById("backlinksCounter").innerHTML = value;
                                }
                                if (key === 'facebookDescription') {
                                    document.getElementById("facebookDescription").textContent = value;
                                }
                                if (key === 'mobileLoadTime') {
                                    document.getElementById("mobileLoadTime").textContent = value;
                                }
                                if (key === 'trafficEstimation') {
                                    document.getElementById("trafficEstimation").textContent = value;
                                }
                                /*
                                 if (key === 'scoreValue') {
                                 document.getElementById("scoreValue").innerHTML = value;
                                 }
                                 */

                                if (key === 'pInterestBoards') {
                                    document.getElementById("pInterestBoards").textContent = value;
                                }
                                if (key === 'pInterestPins') {
                                    document.getElementById("pInterestPins").textContent = value;
                                }
                                if (key === 'pInterestLikes') {
                                    document.getElementById("pInterestLikes").textContent = value;
                                }
                                if (key === 'pInterestFollower') {
                                    document.getElementById("pInterestFollower").textContent = value;
                                }
                                if (key === 'pInterestFollowing') {
                                    document.getElementById("pInterestFollowing").textContent = value;
                                }
                                if (key === 'pInterestImage') {
                                    $("#pInterestImage").attr('src', value);
                                }
                                if (key === 'pInterestName') {
                                    document.getElementById("pInterestName").textContent = value;
                                }
                                if (key === 'pInterestDescription') {
                                    document.getElementById("pInterestDescription").textContent = value;
                                }
                                if (key === 'linkedFollower') {
                                    document.getElementById("linkedFollower").textContent = value;
                                }
                                if (key === 'linkedImage') {
                                    $("#linkedImage").attr('src', value);
                                }
                                if (key === 'linkedDescription') {
                                    document.getElementById("linkedDescription").textContent = value;
                                }
                                if (key === 'linkedSpecialties') {
                                    document.getElementById("linkedSpecialties").textContent = value;
                                }
                                if (key === 'linkedWebsite') {
                                    document.getElementById("linkedWebsite").textContent = value;
                                }
                                if (key === 'linkedIndustry') {
                                    document.getElementById("linkedIndustry").textContent = value;
                                }
                                if (key === 'linkedType') {
                                    document.getElementById("linkedType").textContent = value;
                                }
                                if (key === 'linkedHeadquater') {
                                    document.getElementById("linkedHeadquater").textContent = value;
                                }
                                if (key === 'linkedCompany') {
                                    document.getElementById("linkedCompany").textContent = value;
                                }
                                if (key === 'linkedFounded') {
                                    document.getElementById("linkedFounded").textContent = value;
                                }
                                if (key === 'linkedEmployee') {
                                    document.getElementById("linkedEmployee").textContent = value;
                                }
                                if (key === 'latitude') {
                                    lat = value;
                                    initialize();
                                }
                                if (key === 'longitude') {
                                    long = value;
                                }
                                if (key === 'aLexaRank') {
                                    document.getElementById("aLexaRank").textContent = value;
                                }
                                if (key === 'facebookShareCount') {
                                    document.getElementById("facebookShareCount").textContent = value;
                                }
                                if (key === 'facebookLikesCount') {
                                    document.getElementById("facebookLikesCount").textContent = value;
                                }
                                if (key === 'facebookComment') {
                                    document.getElementById("facebookComment").textContent = value;
                                }
                                if (key === 'facebookTotalCount') {
                                    document.getElementById("facebookTotalCount").textContent = value;
                                }
                                if (key === 'facebookClickCount') {
                                    document.getElementById("facebookClickCount").textContent = value;
                                }
                                if (key === 'facebookCommentsBoxCount') {
                                    document.getElementById("facebookCommentsBoxCount").textContent = value;
                                }
                                if (key === 'linkedInCount') {
                                    document.getElementById("linkedInCount").textContent = value;
                                }
                                if (key === 'pinterestCount') {
                                    document.getElementById("pinterestCount").textContent = value;
                                }
                                if (key === 'twitterCounts') {
                                    document.getElementById("twitterCounts").textContent = value;
                                }
                                if (key === 'googlePlusLike') {
                                    document.getElementById("googlePlusLike").textContent = value;
                                }
                            });
                        }
                    });
                }, timeout);
                google.maps.event.addDomListener(window, 'load', initialize);

                //           });

            }



            /* user defined variables */
            /*
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
             */

        </script>
        <script>
            $(function () {

                // The height of the content block when it's not expanded
                var adjustheight = 70;
                // The "more" link text
                var moreText = "Show  More";
                // The "less" link text
                var lessText = "Show Less";
                // Sets the .more-block div to the specified height and hides any content that overflows
                $(".more-less .more-block").css('height', adjustheight).css('overflow', 'hidden');
                // The section added to the bottom of the "more-less" div
                $(".more-less").append('');
                $("a.adjust").text(moreText);
                $(".adjust").toggle(function () {
                    $(this).parents("div:first").find(".more-block").css('height', 'auto').css('overflow', 'visible');
                    // Hide the [...] when expanded
                    $(this).parents("div:first").find("p.continued").css('display', 'none');
                    $(this).text(lessText);
                }, function () {
                    $(this).parents("div:first").find(".more-block").css('height', adjustheight).css('overflow', 'hidden');
                    $(this).parents("div:first").find("p.continued").css('display', 'block');
                    $(this).text(moreText);
                });
            });

        </script>

        <script type="text/javascript" src="https://s3.amazonaws.com/js-globustracker/review/jquery.min.js" ></script>
        <script type="text/javascript" src="https://s3.amazonaws.com/js-globustracker/review/mc.min.js?crc=547697426" ></script>
        <script type="text/javascript" src="https://s3.amazonaws.com/js-globustracker/review/piecon.min.js?crc=-1047366459" ></script>
        <script type="text/javascript" src="https://s3.amazonaws.com/js-globustracker/review/charts.min.js" ></script>
        <script type="text/javascript" src="https://s3.amazonaws.com/js-globustracker/review/mstch.min.js?crc=-1697587399" ></script>
        <script type="text/javascript" src="https://s3.amazonaws.com/js-globustracker/review/push.min.js?crc=-1546243989" ></script>
        <script type="text/javascript" src="https://s3.amazonaws.com/js-globustracker/review/moment.js" ></script>
        <script type="text/javascript" src="https://s3.amazonaws.com/js-globustracker/review/review.min.js" ></script>
        <script type="text/javascript" src="https://s3.amazonaws.com/js-globustracker/review/commons.min.js" ></script>  

    </body>
</html>
