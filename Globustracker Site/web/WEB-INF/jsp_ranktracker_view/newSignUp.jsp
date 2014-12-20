<%@page import="java.util.Date"%>
<%@taglib prefix="s" uri="/struts-tags" %>

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

    <body id="signup">

        <div class="container">
            <div class="row header">
                <div class="col-md-12">
                    <h3 class="logo">
                        <a href="home.action"><img class="img-responsive img_mid" src="https://s3.amazonaws.com/images-globustracker/Globustracker-logo-present.png"></a>
                    </h3>
                    <h4>Set up your new account today</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-offset-2 col-md-8">
                    <div class="wrapper clearfix">
                        <div id="fade_away1" style="margin-left: -25px; color:#FF0000;">
                            <s:actionerror />                 
                        </div>
                        <div id="fade_away2">              
                            <div class="common_text" id="error" style="margin-left: 0px; color: red"></div>           
                        </div>
                        <div class="formy">
                            <div class="row">
                                <div class="col-md-12">
                                    <s:form action="signUpSubmit.action" id="SignUpForm" validate="true" onsubmit="return validate()" autocomplete="off">
                                        <div class="form-group">
                                            <input title="First Name should contain characters only" class="form-control" placeholder="First Name" type="text" required pattern="[a-zA-Z]*" name="firstNameAdded" id="firstNameAdded" onchange=" this.setCustomValidity(this.validity.patternMismatch ? this.title : '');" />
                                            <s:hidden id="firstName" name="firstName"/>
                                        </div>
                                        <div class="form-group">
                                            <input title="Last Name should contain characters only" class="form-control" type="text" placeholder="Last Name" required pattern="[a-zA-Z]*" name="lastNameAdded" id="lastNameAdded" onchange=" this.setCustomValidity(this.validity.patternMismatch ? this.title : '');" />
                                            <s:hidden id="lastName" name="lastName"/>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="email" required name="emailIdAdded" placeholder="Email Id" id="emailIdAdded" onchange=" this.setCustomValidity(this.validity.patternMismatch ? this.title : '');" />
                                            <s:hidden id="emailId" name="emailId"/> 
                                        </div>

                                        <div class="form-group">
                                            <input class="form-control" type="email" placeholder="Alternate Email address" required name="altEmailIdAdded" id="altEmailIdAdded" onchange=" this.setCustomValidity(this.validity.patternMismatch ? this.title : '');" />
                                            <s:hidden id="altEmailID" name="altEmailID"/>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" title="Password must contain at least 6 characters, including UPPER/lowercase and numbers" type="password" placeholder="Password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="passwordAdded" id="passwordAdded" onchange=" this.setCustomValidity(this.validity.patternMismatch ? this.title : '');
                                                    if (this.checkValidity())
                                                        form.confirmPasswordAdded.pattern = this.value;
                                                   "/>
                                            <s:hidden id="password" name="password"/>
                                        </div>

                                        <div class="form-group">
                                            <input class="form-control" title="Please enter the same Password as above" placeholder="Confirm Password" type="password" required name="confirmPasswordAdded" onchange=" this.setCustomValidity(this.validity.patternMismatch ? this.title : '');" />          
                                        </div>
                                        <!--                                        <div class="checkbox">
                                                                                    <label>
                                                                                        <input type="checkbox"> You have read &amp; agree to the 
                                                                                        <a href="#">Terms of service</a>.
                                                                                    </label>
                                                                                </div>-->
                                        <div class="submit">
                                            <button name="signUp" class="button-clear btn btn-default btn-mini">Create Account</button>
                                        </div>
                                    </s:form>
                                </div>
                            </div>						
                        </div>
                    </div>
                    <div class="already-account">
                        Already have an account?
                        <a href="signIn.action" data-toggle="popover" data-placement="top" data-content="Go to sign in!" data-trigger="manual" data-original-title="" title="">Sign in here</a>
                    </div>
                </div>
            </div>
        </div>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js">
        </script>

        <script>
            $(document).ready(function()
            {
                $("#fade_away1").fadeOut(10000);
            });

            function validate() {
                var email = document.getElementById('emailId');
                email.setAttribute("value", document.getElementById('emailIdAdded').value);
                var firstName = document.getElementById('firstName');
                firstName.setAttribute("value", document.getElementById('firstNameAdded').value);
                var lastName = document.getElementById('lastName');
                lastName.setAttribute("value", document.getElementById('lastNameAdded').value);
                var altEmail = document.getElementById('altEmailID');
                altEmail.setAttribute("value", document.getElementById('altEmailIdAdded').value);
                var pwd = document.getElementById('password');
                pwd.setAttribute("value", document.getElementById('passwordAdded').value);

                if (document.getElementById('firstNameAdded').value === document.getElementById('lastNameAdded').value)
                {
                    $("#fade_away2").show();
                    var error = document.getElementById("error");
                    error.innerHTML = "*First and Last Name should not be same";
                    $("#fade_away2").fadeOut(10000);
                    return false;
                }

                if (document.getElementById('emailIdAdded').value === document.getElementById('altEmailIdAdded').value)
                {
                    $("#fade_away2").show();
                    var error = document.getElementById("error");
                    error.innerHTML = "*Email & Alternate email should not be same";
                    $("#fade_away2").fadeOut(10000);
                    return false;
                }
            }
        </script>

        <!-- javascript -->

        <script src="https://s3.amazonaws.com/js-globustracker/bootstrap.min.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/theme.js"></script>
    </body>
</html>
