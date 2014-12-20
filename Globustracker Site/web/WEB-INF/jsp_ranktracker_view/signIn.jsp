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
            <div class="row header">
                <div class="col-md-12">
                    <h3 class="logo">
                        <a href="home.action"><img class="img-responsive img_mid" src="https://s3.amazonaws.com/images-globustracker/Globustracker-logo-present.png"></a>
                    </h3>
                    <h4>Sign in to your account</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-offset-3 col-md-6">
                    <div class="wrapper clearfix">
                        <div id="fade_away" style="width: 300px; margin-top: 10px; margin-left: -27px; margin-bottom: -35px; color:#FF0000;">
                            <s:actionmessage />
                            <s:actionerror />
                            <br>
                        </div>
                        <div class="formy">
                            <div class="row">
                                <div class="col-md-12">
                                    <s:form  action="logInSubmit" onsubmit="return validate()">
                                        <div class="form-group">
                                            <label for="email">Email address</label>
                                            <input type="text" class="form-control" id="emailAdded" name="emailAdded" value="<s:property value="userName"/>">
                                            <s:hidden name="userName" id="userName" />
                                        </div>
                                        <div class="form-group" style="margin-bottom: 3px">
                                            <label for="password">Password</label>
                                            <input type="password" class="form-control" id="passwordAdded" name="passwordAdded">
                                            <s:hidden name="password" id="password" />
                                        </div>
                                        <!--                                        <div class="checkbox">
                                                                                    <label>
                                                                                        <input type="checkbox"> Remember me
                                                                                    </label>
                                                                                </div>-->

                                        <div class="form-group pull-right" style="margin-bottom: auto">
                                            <label for="password"><a href="forgotPassword.action"><h5>Forgot password?</h5></a></label>
                                        </div>
                                        <div class="col-md-12" style="padding-bottom: 15px">
                                            <div class="submit">
                                                <button name="login" class="button-clear btn btn-default btn-mini">Sign in</button>
                                            </div>
                                        </div>
                                    </s:form>
                                </div>
                            </div>						
                        </div>
                    </div>
                    <div class="already-account">
                        Don't have an account?
                        <a href="payment.action">Create one here</a>
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

            function validate() {
                var userName = document.getElementById('userName');
                userName.setAttribute("value", document.getElementById('emailAdded').value);
                var pwd = document.getElementById('password');
                pwd.setAttribute("value", document.getElementById('passwordAdded').value);

            }
        </script>

    </body>

</html>