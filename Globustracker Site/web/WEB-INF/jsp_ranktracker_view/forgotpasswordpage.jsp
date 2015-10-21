<%@ taglib uri="/struts-tags" prefix="s" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">	
        <title>Best Rank Tracker | SERP Tracker | Youtube Rank Tracker | Social Signals Tracker</title>
        <meta name="author" content="Globussoft">
        <link rel="shortcut icon" href="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">


        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" />

        <style>
            body{
                font-family: "Segoe UI";
                background:rgba(0, 0, 0, 0) url("http://i.imgur.com/bsg2z90.png") no-repeat scroll 0 0 / cover ;
            }
            .login-box{
                position:absolute;
                margin: 10% auto;
                height: auto;
                width:100% !important;
                background-color: #fff;
                padding: 10px;
                border-radius: 3px;
                -webkit-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.33);
                -moz-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.33);
                box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.33);
            }
            .lb-header{
                position:relative;
                color: #00415d;
                margin: 5px 5px 10px 5px;
                padding-bottom:20px;
                border-bottom: 1px solid #eee;
                text-align:center;
            }
            .lb-header a{
                margin: 0 25px;
                padding: 0 20px;
                text-decoration: none;
                color: #666;
                font-weight: bold;
                font-size: 15px;
                -webkit-transition: all 0.1s linear;
                -moz-transition: all 0.1s linear;
                transition: all 0.1s linear;
            }
            .lb-header .active{
                color: #029f5b;
                font-size: 18px;
            }
            .email-login,.email-signup{
                position:relative;
                float: left;
                width: 100%;
                height:auto;
                margin-top: 20px;
                text-align:center;
            }
            .u-form-group{
                width:100%;
                margin-bottom: 10px;
                margin-top:3%;
            }
            .u-form-group input[type="text"],
            .u-form-group input[type="email"],
            .u-form-group input[type="password"]{
                width: calc(61%);
                height:45px;
                outline: none;
                border: 1px solid #ddd;
                padding: 0 10px;
                border-radius: 2px;
                color: #333;
                font-size:1.25rem;
                -webkit-transition:all 0.1s linear;
                -moz-transition:all 0.1s linear;
                transition:all 0.1s linear;
            }
            .u-form-group input:focus{
                border-color: #358efb;
            }
            .u-form-group button{
                width:50%;
                background-color: #1CB94E;
                border: none;
                outline: none;
                color: #fff;
                font-size: 14px;
                font-weight: normal;
                padding: 14px 0;
                border-radius: 2px;
                text-transform: uppercase;
            }
            .forgot-password{
                width:50%;
                text-align: left;
                text-decoration: underline;
                color: #888;
                font-size: 1.25rem;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3" style="margin-top:4%;">
                    <center>
                        <img src="https://s3.amazonaws.com/images-globustracker/Globustracker-logo-present.png" class="img-responsive" />
                    </center>
                    <!-- BEGIN LOGIN -->
                    <div class="login-box">
                        <div class="lb-header">
                            <a href="#" class="active" id="login-box-link">Forget Password</a>
                        </div>
                        <div id="fade_away" style="width: 450px; margin-top: 10px; margin-left: 86px; margin-bottom: -55px; color:#FF0000;">
                            <s:actionmessage />
                            <s:actionerror />
                            <br>
                        </div>
                        <div class="email-login" style="margin-bottom:5%;">
                            <s:form action="forgotPasswordSubmit">
                                <div class="u-form-group">
                                    <input type="email" placeholder="Email" id="mailId" name="mailId" >
                                </div>
                                <div class="u-form-group">
                                    <button>Reset</button>
                                </div>
                            </s:form>
                        </div>
                        <center><strong>Get back to Home page? <a href="home.action">Click Here</a></strong></center>
                    </div>
                    <!-- END LOGIN -->
                </div>
            </div>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-alpha1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function ()
            {
                $("#fade_away").fadeOut(10000);
            });
        </script>


    </body>
</html>
