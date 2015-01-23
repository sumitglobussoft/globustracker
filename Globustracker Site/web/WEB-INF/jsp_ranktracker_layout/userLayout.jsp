<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en-us">
    <head>
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="author" content="Globussoft">
        <link rel="shortcut icon" href="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />
        <meta name="keywords" content="World's First Open Source Website Tracker,GlobusTracker,Video & Social Media Tracker,Good Tracking Website" />
        <meta name="description" content="GlobusTracker is World's First Open Source Tracker for Your Website, Videos & Social Media Platforms" />
        <meta name="og:title" content="GlobusTracker" />
        <meta name="og:type" content="GlobusTracker" />
        <meta name="og:url" content="http://globustracker.com/" />
        <meta name="og:image" content="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />   

        <!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

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

        <!-- Basic Styles -->
        <link rel="stylesheet" type="text/css" media="screen" href="https://s3.amazonaws.com/css-globustracker/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" media="screen" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">

        <!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
        <link rel="stylesheet" type="text/css" media="screen" href="https://s3.amazonaws.com/css-globustracker/admin/smartadmin-production.css">
        <link rel="stylesheet" type="text/css" media="screen" href="https://s3.amazonaws.com/css-globustracker/admin/smartadmin-skins.css">

        <!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
        <link rel="stylesheet" type="text/css" media="screen" href="https://s3.amazonaws.com/css-globustracker/admin/demo.css">


        <!-- GOOGLE FONT -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

    </head>
    <body class="">
        <!-- HEADER -->
        <header id="header">
            <div id="logo-group">

                <!-- PLACE YOUR LOGO HERE -->
                <span id="logo"> <img src="https://s3.amazonaws.com/images-globustracker/Globustracker-logo-present.png" alt="SmartAdmin"> </span>
                <!-- END LOGO PLACEHOLDER -->
            </div>

            <!-- pulled right: nav area -->
            <div class="pull-right">
                <div class="btn-header transparent pull-right">
                    <span>
                        <ul class="nav navbar-nav navbar-right user-nav">
                            <li class="dropdown profile_menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding-top: 0px; height: 49px;">
                                    <s:property value="#session.customerName"/>
                                    <span></span> <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="myAccount.action"><i class="fa fa-lg fa-fw fa-user"></i>My Profile</a></li>
                                    <li><a href="settings.action"><i class="fa fa-lg fa-fw fa-wrench"></i>Display Settings</a></li>
                                    <li><a href="upgradeOption.action"><i class="fa fa-lg fa-fw fa-rocket"></i>Upgrade</a></li>
                                    <!--                                    <li><a href="adminPanel.action">Admin Panel</a></li>-->
                                    <li><a href="" data-toggle="modal" data-target="#editchangepwdmodal"><i class="fa fa-lg fa-fw fa-edit"></i>Change Password</a></li>
                                    <li class="divider"></li>
                                    <li><div id="logout" style=" padding-left: 21px"><span><a href="signOut.action" title="Sign Out" data-logout-msg="You can improve your security further after logging out by closing this opened browser"><i class="fa fa-lg fa-fw fa-sign-out"></i>Sign Out</a></span></div></li>
                                </ul>
                            </li>
                        </ul>
                    </span>
                </div>

                <!-- collapse menu button -->
                <div id="hide-menu" class="btn-header pull-right">
                    <span> <a href="javascript:void(0);" title="Collapse Menu"><i class="fa fa-reorder"></i></a> </span>
                </div>
                <!-- end collapse menu -->

                <!-- logout button -->
                <div id="logout" class="btn-header transparent pull-right">
                    <span> <a href="signOut.action" title="Sign Out" data-logout-msg="You can improve your security further after logging out by closing this opened browser"><i class="fa fa-sign-out"></i></a> </span>
                </div>
                <!-- end logout button -->

                <!-- search mobile button (this is hidden till mobile view port) -->
                <!--                <div id="search-mobile" class="btn-header transparent pull-right">
                                    <span> <a href="javascript:void(0)" title="Search"><i class="fa fa-search"></i></a> </span>
                                </div>-->
                <!-- end search mobile button -->

                <!-- input: search field -->
                <!--                <form action="#" class="header-search pull-right">
                                    <input type="text" name="param" placeholder="Find reports and more" id="search-fld">
                                    <button type="submit">
                                        <i class="fa fa-search"></i>
                                    </button>
                                    <a href="javascript:void(0);" id="cancel-search-js" title="Cancel Search"><i class="fa fa-times"></i></a>
                                </form>-->
                <!-- end input: search field -->

                <!-- fullscreen button -->
                <!--                <div id="fullscreen" class="btn-header transparent pull-right">
                                    <span> <a href="javascript:void(0);" onclick="launchFullscreen(document.documentElement);" title="Full Screen"><i class="fa fa-arrows-alt"></i></a> </span>
                                </div>-->
                <!-- end fullscreen button -->


            </div>
            <!-- end pulled right: nav area -->

        </header>
        <!-- END HEADER -->

        <!-- Left panel : Navigation area -->
        <!-- Note: This width of the aside area can be adjusted through LESS variables -->
        <aside id="left-panel">

            <!-- User info -->
            <div class="login-info">
                <span> <!-- User image size is adjusted inside CSS, it should stay as it --> 

                    <a href="" style="cursor: default;">
                        <!--<img src="https://scontent-a-cdg.xx.fbcdn.net/hphotos-xfa1/t31.0-8/p417x417/10001012_850400818319046_6328835026567166562_o.jpg" alt="me" class="online" />--> 
                        <span>
                            &nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#session.customerName"/>
                        </span>
                    </a> 

                </span>
            </div>
            <!-- end user info -->
            <nav>
                <ul>
                    <li hidden="true">
                        <a href="" title="Dashboard"><i class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent"></span></a>
                    </li>
                    <li>
                        <a href="campaigns.action"><i class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Dashboard</span></a>
                    </li>
                    <li>
                        <a href="serps.action"><i class="fa fa-lg fa-fw fa-search"></i> <span class="menu-item-parent">Serps</span></a>
                    </li>
                    <li>
                        <a href="video.action"><i class="fa fa-lg fa-fw fa-video-camera"></i> <span class="menu-item-parent">Video</span></a>
                    </li>
                    <li>
                        <a href="alerts.action"><i class="fa fa-lg fa-fw fa-bell"></i> <span class="menu-item-parent">Alerts</span></a>
                    </li>
                    <li>
                        <a href="report.action"><i class="fa fa-lg fa-fw fa-file"></i> <span class="menu-item-parent">Reports</span></a>
                    </li>
                    <li>
                        <a href="settings.action"><i class="fa fa-lg fa-fw fa-wrench"></i> <span class="menu-item-parent">Settings</span></a>
                    </li>
                    <li>
                        <a href="myAccount.action"><i class="fa fa-lg fa-fw fa-user"></i> <span class="menu-item-parent">My Account</span></a>
                    </li>
                    <!--                    <li>
                                            <a href="seoIntelligence.action"><i class="fa fa-lg fa-fw fa-magic"></i> <span class="menu-item-parent">SEO Intelligence</span></a>
                                        </li>-->
                    <li>
                        <a href="upgradeOption.action"><i class="fa fa-lg fa-fw fa-rocket"></i> <span class="menu-item-parent">Upgrade</span></a>
                    </li>
                </ul>
            </nav>
            <span class="minifyme"> <i class="fa fa-arrow-circle-left hit"></i> </span>

        </aside>
        <!-- END NAVIGATION -->

        <!-- MAIN PANEL -->
        <div id="main" role="main">

            <!-- MAIN CONTENT -->
            <div id="content">
                <tiles:insertAttribute name="body" />
                <br>
                <br>
                <!--Edit ssurl Modal -->
                <s:form action="changePassword.action" method="post">
                    <div class="modal fade" id="editchangepwdmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                    <h4 class="modal-title">Change Password!</h4>
                                </div>
                                <div class="modal-body">
                                    <!-- widget content -->
                                    <div class="widget-body no-padding">

                                        <div  class="smart-form">

                                            <fieldset>					
                                                <div class="row">
                                                    <section class="col col-6">
                                                        <label class="label">Old Password</label>
                                                        <label class="input">
                                                            <input type="password"  name="oldpassword" id="oldpassword" autocomplete="off"/>
                                                        </label>
                                                    </section>
                                                    <section class="col col-6">
                                                        <label class="label">New Password</label>
                                                        <label class="input">
                                                            <input type="password" name="newpassword" id ="newpassword" autocomplete="off"/>
                                                        </label>
                                                    </section>
                                                </div>			
                                            </fieldset>
                                        </div>                   			
                                    </div>
                                    <!-- end widget content -->
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-info " onclick="return changepassword();">Save Changes</button>
                                    <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </s:form>
                <!--end of editssurl model-->
            </div>
            <!-- END MAIN CONTENT -->

        </div>
        <!-- END MAIN PANEL -->

        <!--================================================== -->

        <!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)
        <script data-pace-options='{ "restartOnRequestAfter": true }' src="js/admin/plugin/pace/pace.min.js"></script>-->

        <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script>
            if (!window.jQuery) {
                document.write('<script src="https://s3.amazonaws.com/js-globustracker/admin/libs/jquery-2.0.2.min.js"><\/script>');
            }
        </script>

        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
        <script>
            if (!window.jQuery.ui) {
                document.write('<script src="https://s3.amazonaws.com/js-globustracker/admin/libs/jquery-ui-1.10.3.min.js"><\/script>');
            }
        </script>

        <!-- JS TOUCH : include this plugin for mobile drag / drop touch events
        <script src="js/admin/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

        <!-- BOOTSTRAP JS -->
        <script src="https://s3.amazonaws.com/js-globustracker/admin/bootstrap/bootstrap.min.js"></script>

        <!-- CUSTOM NOTIFICATION -->
        <script src="https://s3.amazonaws.com/js-globustracker/admin/notification/SmartNotification.min.js"></script>

        <!-- JARVIS WIDGETS -->
        <!--        <script src="https://s3.amazonaws.com/js-globustracker/admin/smartwidgets/jarvis.widget.min.js"></script>-->

        <!-- EASY PIE CHARTS -->
        <script src="https://s3.amazonaws.com/js-globustracker/admin/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

        <!-- SPARKLINES -->
        <script src="https://s3.amazonaws.com/js-globustracker/admin/plugin/sparkline/jquery.sparkline.min.js"></script>

        <!-- JQUERY VALIDATE -->
        <script src="https://s3.amazonaws.com/js-globustracker/admin/plugin/jquery-validate/jquery.validate.min.js"></script>

        <!-- JQUERY MASKED INPUT -->
        <script src="https://s3.amazonaws.com/js-globustracker/admin/plugin/masked-input/jquery.maskedinput.min.js"></script>

        <!-- JQUERY SELECT2 INPUT -->
        <script src="https://s3.amazonaws.com/js-globustracker/admin/plugin/select2/select2.min.js"></script>

        <!-- JQUERY UI + Bootstrap Slider -->
        <script src="https://s3.amazonaws.com/js-globustracker/admin/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

        <!-- browser msie issue fix -->
        <script src="https://s3.amazonaws.com/js-globustracker/admin/plugin/msie-fix/jquery.mb.browser.min.js"></script>

        <!-- FastClick: For mobile devices: you can disable this in app.js
        <script src="js/admin/plugin/fastclick/fastclick.js"></script> -->

        <!--[if IE 7]>

        <h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

        <![endif]-->

        <!-- Demo purpose only -->
        <script src="https://s3.amazonaws.com/js-globustracker/admin/demo.js"></script>

        <!-- MAIN APP JS FILE -->
        <script src="https://s3.amazonaws.com/js-globustracker/admin/app.js"></script>

        <script type="text/javascript">
            // DO NOT REMOVE : GLOBAL FUNCTIONS!
            pageSetUp();

            // PAGE RELATED SCRIPTS
        </script>

        <script>
            $(document).ready(function()
            {
                $("#fade_away").fadeOut(5000);
                $("#fade_away1").fadeOut(5000);
            });
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

        <script type='text/javascript'>
            function changepassword() {
                var oldpassword = $("#oldpassword").val();
                if (oldpassword === null || oldpassword === "") {
                    alert("Old Password required");
                    return false;
                }
                var newpassword = $("#newpassword").val();

                var passwordReg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
                if (!passwordReg.test(newpassword)) {
                    alert("New Password must contain at least 6 characters, including UPPER/lowercase and numbers");
                    return false;
                }
            }
        </script>

    </body>

</html>