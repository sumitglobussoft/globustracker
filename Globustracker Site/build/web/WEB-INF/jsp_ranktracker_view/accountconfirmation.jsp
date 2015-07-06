<%-- 
    Document   : accountconfirmation
    Created on : Dec 23, 2014, 12:34:33 PM
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
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/font-awesome.css">
        <style>
            .confirm {
                color: #fff;
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
        </style>

        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    </head>
    <body id="signup" style="margin-bottom: 90px;">
        <div class="container-fluid">
            <div class="row header">
                <div class="col-md-12">
                    <h3 class="logo">
                        <a href="home.action"><img class="img-responsive img_mid" src="https://s3.amazonaws.com/images-globustracker/Globustracker-logo-present.png"></a>
                    </h3>
                    <div class="confirm">
                        <h3 class="highlight-h3">Thank You for Sign Up</h3><br/>
                        <p>Your Account has been Activated,</p>
                        <p> Please click below to Login in Your Account</p>
                    </div>

                    <form action="signIn.action" method="post" class="text-center">
                        <input type="submit" name="submit" value="Signin" align="center" />
                    </form>   

                </div>
            </div>
        </div>

        <!-- JavaScript -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/bootstrap.min.js"></script>

    </body>
</html>
