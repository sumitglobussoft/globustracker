<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="java.util.Date"%>
<%@taglib  uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
    <!--<![endif]-->
    <head>
        <meta charset="utf-8" />
        <title>Best Rank Tracker | SERP Tracker | Youtube Rank Tracker | Social Signals Tracker</title>
        <meta name="author" content="Globussoft">
        <link rel="shortcut icon" href="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />
        <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
        <!-- ================== BEGIN BASE CSS STYLE ================== -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
        <link href="https://s3.amazonaws.com/css-globustracker/assets/css/jquery-ui.min.css" rel="stylesheet" />
        <link href="https://s3.amazonaws.com/css-globustracker/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" media="screen" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">
        <!--<link href="https://s3.amazonaws.com/css-globustracker/assets/css/font-awesome.min.css" rel="stylesheet" />-->
        <link href="https://s3.amazonaws.com/css-globustracker/assets/css/style.min.css" rel="stylesheet" />
        <link href="https://s3.amazonaws.com/css-globustracker/assets/css/style-responsive.min.css" rel="stylesheet" />
        <link href="https://s3.amazonaws.com/css-globustracker/assets/css/custom.css" rel="stylesheet" />

        <!-- ================== END BASE CSS STYLE ================== -->

        <!-- ================== END PAGE LEVEL STYLE ================== -->
    </head>
    <body>
        <!-- begin #page-loader -->
        <!--<div id="page-loader" class="fade in"><span class="spinner"></span></div>-->
        <!-- end #page-loader -->

        <!-- begin #page-container -->
        <div id="page-container" class="fade page-sidebar-fixed page-header-fixed">
            <!-- begin #header -->
            <div id="header" class="header navbar navbar-default navbar-fixed-top">
                <!-- begin container-fluid -->
                <div class="container-fluid">
                    <!-- begin mobile sidebar expand / collapse button -->
                    <div class="navbar-header">
                        <a href="" class="navbar-brand">
                            <!--<img src="assets/img/logo.png" alt="QuizBattle" width="70%">-->
                            &nbsp;G&nbsp;l&nbsp;o&nbsp;b&nbsp;u&nbsp;s&nbsp;T&nbsp;r&nbsp;a&nbsp;c&nbsp;k&nbsp;e&nbsp;r&nbsp;
                        </a>
                    </div>
                    <!-- end mobile sidebar expand / collapse button -->

                    <!-- begin header navigation right -->
                    <ul class="nav navbar-nav navbar-right">

                        <li class="dropdown navbar-user">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="https://s3.amazonaws.com/images-globustracker/adminuser.png" alt="" /> 
                                <span class="hidden-xs">Sumit Ghosh</span> <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu animated fadeInLeft">
                                <li class="arrow"></li>
                                <li><a href="" data-toggle="modal" data-target="#changepwdmodal">Change Password</a></li>
                                <li class="divider"></li>
                                <li><a href="adminLogout.action">Log Out</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- end header navigation right -->
                </div>
                <!-- end container-fluid -->
            </div>
            <!-- end #header -->

            <!-- begin #sidebar -->
            <div class="sidebar-bg"></div>
            <!-- end #sidebar -->

            <!-- begin #content -->
            <div id="content" class="content">
                <tiles:insertAttribute name="body" />
            </div>
            <!-- end #content -->

            <!-- begin theme-panel -->

            <!-- end theme-panel -->

            <!-- begin scroll to top btn -->
            <a href="#" class="btn btn-icon btn-circle btn-success btn-scroll-to-top fade" data-click="scroll-top"><i class="fa fa-angle-up"></i></a>
            <!-- end scroll to top btn -->
        </div>
        <!-- end page container -->

        <!--- Modal --->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="myModalLabel">Edit User</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-10">
                                <form action="#" class="form-group">
                                    <label>User Name</label>
                                    <input type="text" class="form-control" name="uname" /><br />
                                    <label>Password</label>
                                    <input type="text" class="form-control" name="pass" /><br />
                                    <label>User Type</label>
                                    <input type="text" class="form-control" name="utype" /><br />
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
        <!---End Modal --->

        <!--- Modal --->
        <s:form action="changeAdminPassword.action" method="post">
            <div class="modal fade" id="changepwdmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                            <h4 class="modal-title" id="myModalLabel">Change Password</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-md-10">
                                    <label>Old Password</label>
                                    <input type="password" class="form-control" name="oldpassword" id="oldpassword" autocomplete="off"/>
                                    <br />
                                    <label>New Password</label>
                                    <input type="password" class="form-control" name="newpassword" id ="newpassword" autocomplete="off"/>
                                    <br />                            
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary" onclick="return changepassword();">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </s:form>
        <!---End Modal --->


        <!-- ================== BEGIN BASE JS ================== -->
        <script src="https://s3.amazonaws.com/js-globustracker/assets/jquery-1.8.2.min.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/assets/jquery-ui.min.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/assets/bootstrap.min.js"></script>
        <!--[if lt IE 9]>
                <script src="assets/crossbrowserjs/html5shiv.js"></script>
                <script src="assets/crossbrowserjs/respond.min.js"></script>
                <script src="assets/crossbrowserjs/excanvas.min.js"></script>
        <![endif]-->
        <script src="https://s3.amazonaws.com/js-globustracker/assets/jquery.slimscroll.min.js"></script>

        <!-- ================== END BASE JS ================== -->

        <!-- ================== BEGIN PAGE LEVEL JS ================== -->

        <script src="https://s3.amazonaws.com/js-globustracker/assets/apps.min.js"></script>
        <!-- ================== END PAGE LEVEL JS ================== -->
        <script>
            $(document).ready(function() {
                App.init();
            });
        </script>

        <script type='text/javascript'>
            function changepassword() {
                if ($("#oldpassword").val().trim().length === 0) {
                    alert("Old Password required");
                    return false;
                }
                
                if ($("#newpassword").val().trim().length === 0) {
                    alert("New Password required / Space cannot be consider as Password");
                    return false;
                }                              
            }           
          
        </script>        
        <!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>-->
        <script>
            $(document).ready(function()
            {
                $("#fade_away").fadeOut(5000);
            });
        </script>
    </body>
</html>
