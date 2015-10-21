<%@page import="java.util.Date"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
                margin: 3% auto;
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
                <div class="col-md-6 col-md-offset-3" style="margin-top:2%;">
                    <center>
                        <img src="https://s3.amazonaws.com/images-globustracker/Globustracker-logo-present.png" class="img-responsive" />
                    </center>
                    <!-- BEGIN LOGIN -->
                    <div class="login-box">

                        <div class="lb-header">
                            <a class="active" id="login-box-link">Signup</a>
                        </div>

                        <div id="fade_away1" style="margin-left: 86px; margin-bottom:-35px; color:#FF0000;">
                            <s:actionerror />  
                            <br>
                        </div>
                        <div id="fade_away2">              
                            <div class="common_text" id="error" style="margin-left: 110px; margin-bottom: -25px; color: red"></div>           
                        </div>
                        <div class="email-signup">
                            <s:form action="signUpSubmit.action" id="SignUpForm" validate="true" onsubmit="return validate()" autocomplete="off">
                                <div class="u-form-group">
                                    <input title="First Name should contain characters only"  placeholder="First Name" type="text" required pattern="[a-zA-Z]*" name="firstNameAdded" id="firstNameAdded" onchange=" this.setCustomValidity(this.validity.patternMismatch ? this.title : '');" />
                                    <s:hidden id="firstName" name="firstName"/>
                                </div>
                                <div class="u-form-group">
                                    <input title="Last Name should contain characters only" type="text" placeholder="Last Name" required pattern="[a-zA-Z]*" name="lastNameAdded" id="lastNameAdded" onchange=" this.setCustomValidity(this.validity.patternMismatch ? this.title : '');" />
                                    <s:hidden id="lastName" name="lastName"/>
                                </div>
                                <div class="u-form-group">
                                    <input type="email" required name="emailIdAdded" placeholder="Email Id" id="emailIdAdded" onchange=" this.setCustomValidity(this.validity.patternMismatch ? this.title : '');" />
                                    <s:hidden id="emailId" name="emailId"/> 
                                </div>
                                <div class="u-form-group">
                                    <input  type="email" placeholder="Alternate Email address" required name="altEmailIdAdded" id="altEmailIdAdded" onchange=" this.setCustomValidity(this.validity.patternMismatch ? this.title : '');" />
                                    <s:hidden id="altEmailID" name="altEmailID"/>
                                </div>
                                <div class="u-form-group">
                                    <input  title="Password must contain at least 6 characters, including UPPER/lowercase and numbers" type="password" placeholder="Password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="passwordAdded" id="passwordAdded" onchange=" this.setCustomValidity(this.validity.patternMismatch ? this.title : '');
                                            if (this.checkValidity())
                                                form.confirmPasswordAdded.pattern = this.value;
                                            "/>
                                    <s:hidden id="password" name="password"/>
                                </div>
                                <div class="u-form-group">
                                    <input title="Please enter the same Password as above" placeholder="Confirm Password" type="password" required name="confirmPasswordAdded" onchange=" this.setCustomValidity(this.validity.patternMismatch ? this.title : '');" />          
                                </div>
                                <div class="u-form-group">
                                    <button>SignUp</button>
                                </div>
                                <div class="u-form-group">
                                    <strong>Already have an account? Sign in <a href="signIn.action" class="forgot-password">here</a></strong>
                                </div>
                            </s:form>
                        </div>
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
                                                error.innerHTML = "* Email & Alternate email should not be same";
                                                $("#fade_away2").fadeOut(10000);
                                                return false;
                                            }
                                        }
        </script>

    </body>
</html>
