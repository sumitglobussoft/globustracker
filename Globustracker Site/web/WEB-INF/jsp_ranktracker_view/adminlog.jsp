<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
    <!--<![endif]-->
    <head>
        <meta charset="utf-8" />
        <title>Best Rank Tracker | SERP Tracker | Youtube Rank Tracker | Social Signals Tracker</title>
        <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
        <meta name="author" content="Globussoft">
        <link rel="shortcut icon" href="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />
        <!-- ================== BEGIN BASE CSS STYLE ================== -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
        <link href="https://s3.amazonaws.com/css-globustracker/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="https://s3.amazonaws.com/css-globustracker/assets/css/style.min.css" rel="stylesheet" />
        <link href="https://s3.amazonaws.com/css-globustracker/assets/css/custom.css" rel="stylesheet" />

        <!-- ================== END BASE CSS STYLE ================== -->

        <!-- ================== END PAGE LEVEL STYLE ================== -->

    </head>
    <body id="signup" style="background: url(http://us.cdn200.fansshare.com/photo/wallpaperbackground/abstract-background-wallpaper-1773276040.jpg);">
        <!-- begin #page-loader -->
        <!--        <div id="page-loader" class="fade in"><span class="spinner"></span></div>-->
        <!-- end #page-loader -->

        <!-- begin #page-container -->
        <div id="page-container" class="fade page-sidebar-fixed page-header-fixed">
            <div class="container">
                <div class="login-container" style="margin-bottom:0;">
                    <br>
                    <img src="https://s3.amazonaws.com/images-globustracker/Globustracker-logo-present.png" style="height: 30px">
                    <br><h4>ADMIN</h4>
                    <br>
                    <div id="fade_away1" style="margin-left: -25px; color:#FF0000;">
                        <s:actionmessage />
                        <s:actionerror />
                    </div>
                    <div class="form-box">
                        <s:form method="post" action="adminsigninform" name="adminsignin">
                            <input type="text" name="userName" id="adminusername" placeholder="username" autocomplete="off">
                            <input type="password" name="password" id="adminpassword" placeholder="password" autocomplete="off">
                            <button class="btn btn-info btn-block login" type="submit">Login</button>
                        </s:form>
                    </div>
                    <div>
                        Get back to home page?
                        <a href="home.action">Click Here</a>
                    </div>
                </div>
            </div>
        </div>       
        <!-- end page container -->

        <!-- ================== BEGIN BASE JS ================== -->
        <script src="https://s3.amazonaws.com/js-globustracker/assets/jquery-1.8.2.min.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/assets/jquery-ui.min.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/assets/bootstrap.min.js"></script>
        <!--[if lt IE 9]>
                <script src="assets/crossbrowserjs/html5shiv.js"></script>
                <script src="assets/crossbrowserjs/respond.min.js"></script>
                <script src="assets/crossbrowserjs/excanvas.min.js"></script>
        <![endif]-->
        <!-- ================== END BASE JS ================== -->

        <!-- ================== BEGIN PAGE LEVEL JS ================== -->

        <script src="https://s3.amazonaws.com/js-globustracker/assets/apps.min.js"></script>
        <!-- ================== END PAGE LEVEL JS ================== -->
        <script>
            $(document).ready(function() {
                App.init();
            });
        </script>
    </body>
</html>
