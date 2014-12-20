<!DOCTYPE html">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
    <head>
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <link rel="shortcut icon" href="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content=""/>
        <meta property="description" content="" />
        <meta property="og:title" content="" />
        <meta property="og:type" content="" />
        <meta property="og:url" content="http://globustracker.com/" />
        <meta property="og:image" content="https://s3.amazonaws.com/images_ranktracker/GlobustrackerIcon.png" />   
        <style type="text/css">
            <%@ include file="../css_ranktracker/style.css" %>
        </style>
        <!--<link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css_ranktracker/style.css" />-->
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css_ranktracker/jquery.css" />
        <link rel="stylesheet" type="text/css" href="https://s3.amazonaws.com/css_ranktracker/settings_style.css" />

        <script type="text/javascript">var switchTo5x=true;</script>
        <script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
        <!--<script type="text/javascript" src="http://s.sharethis.com/loader.js"></script>-->
        <script src="https://s3.amazonaws.com/js_ranktracker/jquery-1.8.3.js" type="text/javascript"></script>

        <!--        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>-->
        <script src="https://s3.amazonaws.com/js_ranktracker/switch-setting.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(function(){
                $('select').switchify();
                $('select').data('switch').bind('slide', function(e, type) {
                    $('ul').append('<li>Switching ' + type); 
                });
            });
            
        </script>
    </head>
    <body>
        <div id="main_bg">

            <!-- setting the tiles attribute for 'header' , 'body' , 'footer' 
            all these properties are configured in tiles.xml
            -->

            <tiles:insertAttribute name="header" />
            <tiles:insertAttribute name="body" />
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>
