<%-- 
    Document   : accountexpired
    Created on : Dec 22, 2014, 12:32:39 PM
    Author     : GLB-170
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">	
        <title>Best Rank Tracker | SERP Tracker | YouTube Rank Tracker | Social Signals Tracker</title>
        <meta name="author" content="Globussoft">
        <link rel="shortcut icon" href="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- stylesheets -->
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/theme.css">
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/animate.css">
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/admin/smartadmin-production.css">
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/font-awesome.css">
        <style>
            .confirm {
                color: #fff;
                margin-top: 9%;
                text-align: center;
                margin-bottom: 2%;
            }
            .confirm1 {
                color: #000;
                margin-top: 9%;
                text-align: center;
                margin-bottom: 2%;
            }
            .highlight-h3 {
                background: none repeat scroll 0 0 #fff;
                color: #000;
                opacity: 0.5;
                padding: 1%;
            }
            .highlight1-h3 {
                background: none repeat scroll 0 0 #000;
                color: #fff;
                opacity: 0.3;
                padding: 1%;
            }
        </style>

        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    </head>
    <body>
        <!--   id="signup" style="margin-bottom: 90px;"      <div class="container-fluid">
                    <div class="row header">
                        <div class="col-md-12">
                            <h3 class="logo">
                                <a href="home.action"><img class="img-responsive img_mid" src="https://s3.amazonaws.com/images-globustracker/Globustracker-logo-present.png"></a>
                            </h3>
                            <div class="confirm">
                                <h3 class="highlight-h3">Thank You for Sign Up</h3><br/>
                                <p>You subscription has been successfully completed.</p>
                                <p>To Login please click here</p>
                            </div>
                            <form action="#" method="post" class="text-center">
                                <a href="#" name="submit">LogIn</a>
                            </form>     
                        </div>
                    </div>
                </div>-->

        <header id="header">
            <div id="logo-group">
                <span id="logo"><img src="https://s3.amazonaws.com/images-globustracker/Globustracker-logo-present.png" alt="SmartAdmin"> </span>           
            </div>
        </header>
        <!-- END HEADER -->


        <!-- MAIN PANEL -->
        <div id="main" role="main">
            <!-- MAIN CONTENT -->
            <div id="content" style="margin-right: 100px; margin-left: -150px; margin-top: 10px;"> 
                <div class="confirm1">
                    <h3 class="highlight1-h3">Your PLAN PERIOD is OVER</h3><br/>
                    <p>Your Activation period has been expired, You need to purchase new plans.<br></p>
                    <p>Please click below for new plans</p>
                </div>
                <form action="renewal.action" method="post" class="text-center">
                    <input type="submit" value="Choose Plan" />
                </form>
            </div>
        </div>

        <!-- JavaScript -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/bootstrap.min.js"></script>

    </body>
</html>