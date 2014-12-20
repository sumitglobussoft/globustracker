<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">	
        <title>Best Rank Tracker | SERP Tracker | Youtube Rank Tracker | Social Signals Tracker</title>
        <meta name="author" content="Globussoft">
        <link rel="shortcut icon" href="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- stylesheets -->
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/theme.css">
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/animate.css">
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css-globustracker/font-awesome.css">

        <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    </head>
    <body id="signup" style="margin-bottom: 90px;">
        <div class="container">
            <div class="row header" style="margin-top: 24px">
                <div class="col-md-12">
                    <h3 class="logo">
                        <a href="index.html"><img class="img-responsive img_mid" src="https://s3.amazonaws.com/images-globustracker/Globustracker-logo-present.png"></a>
                    </h3>
                    <h4>Forgot Password</h4>
                </div>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-offset-2 col-md-8">
                    <div class="wrapper clearfix">
                        <div id="fade_away" style="width: 510px; margin-top: 10px; margin-left: -27px; margin-bottom: -35px; color:#FF0000;">
                            <s:actionmessage />
                            <s:actionerror />
                            <br>
                        </div>
                        <div class="formy">
                            <div class="row">
                                <div class="col-md-12">
                                    <s:form action="forgotPasswordSubmit">
                                        <div class="form-group">
                                            <label for="email">Email address</label>
                                            <input type="text" class="form-control" id="mailId" name="mailId">
                                        </div>
                                        <div class="submit">
                                            <button name="reset" class="button-clear btn btn-default btn-mini" style="margin-top:1%;">Reset</button>
                                        </div>
                                    </s:form>
                                </div>
                            </div>						
                        </div>
                    </div>
                    <div class="already-account">
                        Get back to home page?
                        <a href="home.action">Click Here</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- javascript -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

        <script src="https://s3.amazonaws.com/js-globustracker/bootstrap.min.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/theme.js"></script>

        <script>
            $(document).ready(function()
            {
                $("#fade_away").fadeOut(10000);
            });
        </script>
    </body>

</html>