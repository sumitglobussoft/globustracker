<!-- Bread crumb is created dynamically -->
<!-- row -->
<div class="row">

    <!-- col -->
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
        <h1 class="page-title txt-color-blueDark">

            <!-- PAGE HEADER -->
            <i class="fa fa-bolt fa-fw "></i> 
            GlobusTracker
            <span>>  
                Page Speed Analysis
            </span>
        </h1>
    </div>
    <!-- end col -->



</div>
<!-- end row -->

<!--
        The ID "widget-grid" will start to initialize all widgets below 
        You do not need to use widgets if you dont want to. Simply remove 
        the <section></section> and you can use wells or panels instead 
-->

<!-- widget grid -->
<section id="widget-grid" class="">

    <!-- row -->
    <div class="row">

        <!-- NEW WIDGET START -->
        <article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

            <!-- Widget ID (each widget will need unique ID)-->
            <div class="jarviswidget" id="wid-id-0">
                <!-- widget options:
                        usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">
                        
                        data-widget-colorbutton="false"	
                        data-widget-editbutton="false"
                        data-widget-togglebutton="false"
                        data-widget-deletebutton="false"
                        data-widget-fullscreenbutton="false"
                        data-widget-custombutton="false"
                        data-widget-collapsed="true" 
                        data-widget-sortable="false"
                        
                -->
                <!--                <header>
                                    <span class="widget-icon"> <i class="fa fa-tachometer"></i> </span>
                                    <h2>PageSpeed Insights</h2>			
                
                                </header>-->

                <!-- widget div-->
                <div style="border: medium none;">

                    <!-- widget edit box -->
                    <div class="jarviswidget-editbox">
                        <!-- This area used as dropdown edit box -->
                        <input class="form-control" type="text">	
                    </div>
                    <!-- end widget edit box -->

                    <!-- widget content -->
                    <div class="widget-body">
                        <!--                        <div class="alert adjusted alert-info fade in">
                                                    <strong><i class="fa fa-bolt fa-fw"></i>Make your web pages fast on all devices.</strong>
                                                </div>-->
                        <div role="content">

                            <!-- widget edit box -->
                            <div class="jarviswidget-editbox">
                                <!-- This area used as dropdown edit box -->

                            </div>
                            <!-- end widget edit box -->

                            <!-- widget content -->
                            <div class="widget-body">


                                <form class="col-md-offset-2 col-md-8" role="form" id="formSubmit" onsubmit="return getPageSpeedResults()">							
                                    <!--<fieldset>-->
                                    <!--<div class="form-group">-->
                                    <!--<label class="sr-only" for="weburl">Enter a web page URL</label>-->
                                    <!--<div class="input-group">-->	
                                    <input type="url" name="url" class="form-control" required="true" id="url_field" placeholder="http://www.abc.com" style="margin-left:-179px; width: 361px;">
                                    <!--                                                <span class="input-group-btn">
                                                                                        <button type="submit" class="btn btn-primary">
                                                                                            ANALYZE 
                                                                                        </button>
                                                                                    </span>-->
                                    <input type="submit" class="btn btn-primary"  value="ANALYZE"  style="margin-left:184px; margin-top: -54px;"/>
                                    <!--</div>-->									
                                    <!--</div>-->								
                                    <!--</fieldset>-->							
                                </form>

                                <div class="col-md-12 text-left" style="margin-top: 3%; max-height: 10px;">        
                                    <span id="loading" style="margin-left: 12%;"></span>
                                </div>

                                <!-- NEW WIDGET START -->
                                <article class="col-sm-12 col-md-12 col-lg-12">

                                    <!-- Widget ID (each widget will need unique ID)-->
                                    <div class="jarviswidget well hidden" id="wid-id-3" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-togglebutton="false" data-widget-deletebutton="false" data-widget-fullscreenbutton="false" data-widget-custombutton="false" data-widget-sortable="false">
                                        <!-- widget options:
                                        usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">
        
                                        data-widget-colorbutton="false"
                                        data-widget-editbutton="false"
                                        data-widget-togglebutton="false"
                                        data-widget-deletebutton="false"
                                        data-widget-fullscreenbutton="false"
                                        data-widget-custombutton="false"
                                        data-widget-collapsed="true"
                                        data-widget-sortable="false"
        
                                        -->
                                        <header>
                                            <span class="widget-icon"> <i class="fa fa-comments"></i> </span>
                                            <h2>Default Tabs with border </h2>
                                        </header>

                                        <!-- widget div-->
                                        <div id="mobiletabhide">

                                            <!-- widget edit box -->
                                            <div class="jarviswidget-editbox">
                                                <!-- This area used as dropdown edit box -->

                                            </div>
                                            <!-- end widget edit box -->

                                            <!-- widget content -->
                                            <div class="widget-body">

                                                <ul id="myTab1" class="nav nav-tabs bordered">
                                                    <li class="active">
                                                        <a href="#Mobile" data-toggle="tab"><i class=""></i> </a>
                                                    </li>
                                                    <!--                                                    <li>
                                                                                                            <a href="#Desktop" data-toggle="tab"><i class="fa fa-fw fa-lg fa-desktop"></i> Desktop</a>
                                                                                                        </li>-->
                                                </ul>

                                                <div id="myTabContent1" class="tab-content padding-10">

                                                    <div class="tab-pane fade in active" id="Mobile">
                                                        <!--<h4 class="alert alert-success">100/100 </h4>-->
                                                        <h5><strong><i class="fa fa-exclamation fa-fw txt-color-red"></i>Should Fix:</strong></h5>
                                                        <div class="panel-group smart-accordion-default" id="accordion-1">
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-1" href="#collapseOne-1" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Eliminate render-blocking JavaScript and CSS in above-the-fold content </a></h4>
                                                                </div>
                                                                <div id="collapseOne-1" class="panel-collapse collapse MinimizeRenderBlockingResources">
                                                                    <div class="panel-body">
                                                                        <p id="pUrl"></p>
                                                                        <div class="custom-scroll table-responsive renderhidden" style="height:290px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody id="tbody">
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <h5><strong><i class="fa fa-exclamation fa-fw txt-color-orange"></i>Consider Fixing:</strong></h5>
                                                        <div class="panel-group smart-accordion-default" id="accordion-2">

                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseThree-2" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Leverage browser caching </a></h4>
                                                                </div>
                                                                <div id="collapseThree-2" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <!--<b>Your page has 13 blocking CSS resources. This causes a delay in rendering your page.</b>-->
                                                                        <p id="LeverageDescrip"></p>
                                                                        <div class="custom-scroll table-responsive leveragehidden" style="height:290px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody id="LeverageUrl">
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseOne-2" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Optimize images </a></h4>
                                                                </div>
                                                                <div id="collapseOne-2" class="panel-collapse collapse">
                                                                    <div class="panel-body">

                                                                        <p id="OptimizeDescrip"></p>
                                                                        <div class="custom-scroll table-responsive optimizehidden" style="height:290px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody id="OptimizeUrl">
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseTwo-2" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Minify JavaScript </a></h4>
                                                                </div>
                                                                <div id="collapseTwo-2" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <p id="JavaScriptDescrip"></p>
                                                                        <div class="custom-scroll table-responsive tablehidden" style="height:199px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody id="JavaScriptUrl">
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseFour-2" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Reduce server response time </a></h4>
                                                                </div>
                                                                <div id="collapseFour-2" class="panel-collapse collapse">
                                                                    <div class="panel-body">

                                                                        <p id="ServerDescrip"></p>
                                                                        <div class="custom-scroll table-responsive serverhidden" style="height:76px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody id="ServerUrl">
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseFive-2" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Minify HTML </a></h4>
                                                                </div>
                                                                <div id="collapseFive-2" class="panel-collapse collapse">
                                                                    <div class="panel-body">

                                                                        <p id="HTMLDescrip"></p>
                                                                        <div class="custom-scroll table-responsive htmlhidden" style="height:38px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody id="HTMLUrl">
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseSix-2" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Enable compression </a></h4>
                                                                </div>
                                                                <div id="collapseSix-2" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <p id="EnableDescrip"></p>
                                                                        <div class="custom-scroll table-responsive enablehidden" style="height:36px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody id="EnableUrl">
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <h5><strong><i class="fa fa-check fa-fw txt-color-green"></i>3 Passed Rules</strong></h5>
                                                        <div class="panel-group smart-accordion-default" id="accordion-3">
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-3" href="#collapseOne-3" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Avoid landing page redirects </a></h4>
                                                                </div>
                                                                <div id="collapseOne-3" class="panel-collapse collapse">
                                                                    <div class="panel-body">

                                                                        <p id="AvoidDescrip"></p>
                                                                        <div class="custom-scroll table-responsive avoidpagehidden" style="height:36px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody id="AvoidUrl">

                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-3" href="#collapseTwo-3" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Minify CSS </a></h4>
                                                                </div>
                                                                <div id="collapseTwo-3" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <p id="CSSDescrip"></p>
                                                                        <div class="custom-scroll table-responsive csshidden" style="height:36px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody id="CSSUrl">

                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-3" href="#collapseThree-3" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Prioritize visible content </a></h4>
                                                                </div>
                                                                <div id="collapseThree-3" class="panel-collapse collapse">
                                                                    <div class="panel-body">

                                                                        <p id="PrioritizeDescrip"></p>
                                                                        <div class="custom-scroll table-responsive priorityhidden" style="height:33px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody id="PrioritizeUrl">

                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="tab-pane fade" id="Desktop">
                                                        <h4 class="alert alert-danger">50/100 </h4>
                                                        <h5><strong><i class="fa fa-exclamation fa-fw txt-color-red"></i>Should Fix:</strong></h5>
                                                        <div class="panel-group smart-accordion-default" id="accordion-4">
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-4" href="#collapseOne-4" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Eliminate render-blocking JavaScript and CSS in above-the-fold content </a></h4>
                                                                </div>
                                                                <div id="collapseOne-4" class="panel-collapse collapse">
                                                                    <div class="panel-body">

                                                                        <p id="pUrlDesktop"></p>
                                                                        <div class="custom-scroll table-responsive" style="height:290px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody id="pUrlDesktop">
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-4" href="#collapseTwo-4" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Enable compression </a></h4>
                                                                </div>
                                                                <div id="collapseTwo-4" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <b>Your page has 13 blocking CSS resources. This causes a delay in rendering your page.</b>
                                                                        <p>None of the above-the-fold content on your page could be rendered without waiting for the following resources to load. Try to defer or asynchronously load blocking resources, or inline the critical portions of those resources directly in the HTML.<a href="#">Optimize CSS Delivery</a> of the following:</p>
                                                                        <div class="custom-scroll table-responsive" style="height:290px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>	
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-4" href="#collapseThree-4" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Leverage browser caching </a></h4>
                                                                </div>
                                                                <div id="collapseThree-4" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <b>Your page has 13 blocking CSS resources. This causes a delay in rendering your page.</b>
                                                                        <p>None of the above-the-fold content on your page could be rendered without waiting for the following resources to load. Try to defer or asynchronously load blocking resources, or inline the critical portions of those resources directly in the HTML.<a href="#">Optimize CSS Delivery</a> of the following:</p>
                                                                        <div class="custom-scroll table-responsive" style="height:290px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>	
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <h5><strong><i class="fa fa-exclamation fa-fw txt-color-orange"></i>Consider Fixing:</strong></h5>
                                                        <div class="panel-group smart-accordion-default" id="accordion-5">
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-5" href="#collapseOne-5" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Eliminate render-blocking JavaScript and CSS in above-the-fold content </a></h4>
                                                                </div>
                                                                <div id="collapseOne-5" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <b>Your page has 13 blocking CSS resources. This causes a delay in rendering your page.</b>
                                                                        <p>None of the above-the-fold content on your page could be rendered without waiting for the following resources to load. Try to defer or asynchronously load blocking resources, or inline the critical portions of those resources directly in the HTML.<a href="#">Optimize CSS Delivery</a> of the following:</p>
                                                                        <div class="custom-scroll table-responsive" style="height:290px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>	
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-5" href="#collapseTwo-5" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Enable compression </a></h4>
                                                                </div>
                                                                <div id="collapseTwo-5" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <b>Your page has 13 blocking CSS resources. This causes a delay in rendering your page.</b>
                                                                        <p>None of the above-the-fold content on your page could be rendered without waiting for the following resources to load. Try to defer or asynchronously load blocking resources, or inline the critical portions of those resources directly in the HTML.<a href="#">Optimize CSS Delivery</a> of the following:</p>
                                                                        <div class="custom-scroll table-responsive" style="height:290px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>	
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-5" href="#collapseThree-5" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Leverage browser caching </a></h4>
                                                                </div>
                                                                <div id="collapseThree-5" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <b>Your page has 13 blocking CSS resources. This causes a delay in rendering your page.</b>
                                                                        <p>None of the above-the-fold content on your page could be rendered without waiting for the following resources to load. Try to defer or asynchronously load blocking resources, or inline the critical portions of those resources directly in the HTML.<a href="#">Optimize CSS Delivery</a> of the following:</p>
                                                                        <div class="custom-scroll table-responsive" style="height:290px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>	
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <h5><strong><i class="fa fa-check fa-fw txt-color-green"></i>3 Passed Rules</strong></h5>
                                                        <div class="panel-group smart-accordion-default" id="accordion-6">
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-6" href="#collapseOne-6" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Eliminate render-blocking JavaScript and CSS in above-the-fold content </a></h4>
                                                                </div>
                                                                <div id="collapseOne-6" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <b>Your page has 13 blocking CSS resources. This causes a delay in rendering your page.</b>
                                                                        <p>None of the above-the-fold content on your page could be rendered without waiting for the following resources to load. Try to defer or asynchronously load blocking resources, or inline the critical portions of those resources directly in the HTML.<a href="#">Optimize CSS Delivery</a> of the following:</p>
                                                                        <div class="custom-scroll table-responsive" style="height:290px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>	
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-6" href="#collapseTwo-6" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Enable compression </a></h4>
                                                                </div>
                                                                <div id="collapseTwo-6" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <b>Your page has 13 blocking CSS resources. This causes a delay in rendering your page.</b>
                                                                        <p>None of the above-the-fold content on your page could be rendered without waiting for the following resources to load. Try to defer or asynchronously load blocking resources, or inline the critical portions of those resources directly in the HTML.<a href="#">Optimize CSS Delivery</a> of the following:</p>
                                                                        <div class="custom-scroll table-responsive" style="height:290px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>	
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-6" href="#collapseThree-6" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Leverage browser caching </a></h4>
                                                                </div>
                                                                <div id="collapseThree-6" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <b>Your page has 13 blocking CSS resources. This causes a delay in rendering your page.</b>
                                                                        <p>None of the above-the-fold content on your page could be rendered without waiting for the following resources to load. Try to defer or asynchronously load blocking resources, or inline the critical portions of those resources directly in the HTML.<a href="#">Optimize CSS Delivery</a> of the following:</p>
                                                                        <div class="custom-scroll table-responsive" style="height:290px; overflow-y: scroll;">	
                                                                            <table class="table table-bordered">
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>https://s3.amazonaws.com/css-globustracker/theme.css</td>
                                                                                    </tr>	
                                                                                </tbody>
                                                                            </table>						
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                            <!-- end widget content -->

                                        </div>
                                        <!-- end widget div -->

                                    </div>
                                    <!-- end widget -->





                                </article>
                                <!-- WIDGET END -->

                            </div>
                            <!-- end widget content -->

                        </div>


                    </div>
                    <!-- end widget content -->

                </div>
                <!-- end widget div -->

            </div>
            <!-- end widget -->

        </article>
        <!-- WIDGET END -->

    </div>

    <!-- end row -->

    <!-- row -->

    <div class="row">

        <!-- a blank row to get started -->
        <div class="col-sm-12">
            <!-- your contents here -->
        </div>

    </div>

    <!-- end row -->

</section>
<!-- end widget grid -->
<script>

    var CHART_API_URL = 'http://chart.apis.google.com/chart?';
    var callbacks = {};
    var RESOURCE_TYPE_INFO = [
        {label: 'JavaScript', field: 'javascriptResponseBytes', color: 'e2192c'},
        {label: 'Images', field: 'imageResponseBytes', color: 'f3ed4a'},
        {label: 'CSS', field: 'cssResponseBytes', color: 'ff7008'},
        {label: 'HTML', field: 'htmlResponseBytes', color: '43c121'},
        {label: 'Flash', field: 'flashResponseBytes', color: 'f8ce44'},
        {label: 'Text', field: 'textResponseBytes', color: 'ad6bc5'},
        {label: 'Other', field: 'otherResponseBytes', color: '1051e8'}
    ];

    function getPageSpeedResults() {

        $.ajax({
            type: "GET",
            url: "getpagespeedresults.action",
            data: $("#formSubmit").serialize(),
            beforeSend: function (data) {
                $('#loading').text('Loading Please Wait...');
                $('#wid-id-3').hide();
            },
            success: function (data) {
                $('#wid-id-3').removeClass('hidden');
                $('#loading').text('');
                $('#wid-id-3').show();

                var result = JSON.parse(data);
//                displayPageSpeedScore(result);
//                displayTopPageSpeedSuggestions(result);
//                displayResourceSizeBreakdown(result);
                try {
//                    showPageStats(result);
                } catch (err) {
                }
                try {
                    showAvoidLandingPageRedirects(result);
                } catch (err) {
                }
                try {
                    showEnableGzipCompression(result);
                } catch (err) {
                }
                try {
                    showLeverageBrowserCaching(result);
                } catch (err) {
                }
                try {
                    showMinifyHTML(result);
                } catch (err) {
                }
                try {
                    showMinifyJavaScript(result);
                } catch (err) {
                }
                try {
                    showMinifyCss(result);
                } catch (err) {
                }
                try {
                    showPrioritizeVisibleContent(result);
                } catch (err) {
                }
                try {
                    showMainResourceServerResponseTime(result);
                } catch (err) {
                }

                try {
                    showOptimizeImages(result);
                } catch (err) {
                }
                try {
                    showMinimizeRenderBlockingResources(result);
                } catch (err) {
                }

            }
        });


        function displayPageSpeedScore(result) {

            var score = result.score;
            // Construct the query to send to the Google Chart Tools.
            var query = [
                'chtt=Page+Speed+score:+' + score,
                'chs=180x100',
                'cht=gom',
                'chd=t:' + score,
                'chxt=x,y',
                'chxl=0:|' + score
            ].join('&');
            var i = document.createElement('img');
            i.src = CHART_API_URL + query;
            document.getElementById('score').insertBefore(i, null);
        }

        function displayResourceSizeBreakdown(result) {
            var stats = result.pageStats;
            var labels = [];
            var data = [];
            var colors = [];
            var totalBytes = 0;
            var largestSingleCategory = 0;
            for (var i = 0, len = RESOURCE_TYPE_INFO.length; i < len; ++i) {
                var label = RESOURCE_TYPE_INFO[i].label;
                var field = RESOURCE_TYPE_INFO[i].field;
                var color = RESOURCE_TYPE_INFO[i].color;
                if (field in stats) {
                    var val = Number(stats[field]);
                    totalBytes += val;
                    if (val > largestSingleCategory)
                        largestSingleCategory = val;
                    labels.push(label);
                    data.push(val);
                    colors.push(color);
                }
            }
            // Construct the query to send to the Google Chart Tools.
            var query = [
                'chs=300x140',
                'cht=p3',
                'chts=' + ['000000', 16].join(','),
                'chco=' + colors.join('|'),
                'chd=t:' + data.join(','),
                'chdl=' + labels.join('|'),
                'chdls=000000,14',
                'chp=1.6',
                'chds=0,' + largestSingleCategory
            ].join('&');
            var i = document.createElement('img');
            i.src = 'http://chart.apis.google.com/chart?' + query;
            document.getElementById('code').insertBefore(i, null);
        }

        function displayTopPageSpeedSuggestions(result) {
            var results = [];
            var ruleResults = result.formattedResults.ruleResults;
            for (var i in ruleResults) {
                var ruleResult = ruleResults[i];
                // Don't display lower-impact suggestions.
                if (ruleResult.ruleImpact < 3.0)
                    continue;
                results.push({name: ruleResult.localizedRuleName,
                    impact: ruleResult.ruleImpact});
            }
            results.sort(sortByImpact);
            var ul = document.createElement('ul');
            for (var i = 0, len = results.length; i < len; ++i) {
                var r = document.createElement('li');
                r.innerHTML = results[i].name;
                ul.insertBefore(r, null);
            }
            if (ul.hasChildNodes()) {
                document.getElementById('suggestions').insertBefore(ul, null);
            } else {
                var div = document.createElement('div');
                div.innerHTML = 'No high impact suggestions. Good job!';
                document.getElementById('suggestions').insertBefore(div, null);
            }
        }

        function sortByImpact(a, b) {
            return b.impact - a.impact;
        }

        function showPageStats(result) {
            var html = "<ul>";
            html = html + "<li>Other Response Bytes -" + result.pageStats.otherResponseBytes + "</li>";
            html = html + "</ul>";

            html = html + "<ul>";
            html = html + "<li>Text Response Bytes -" + result.pageStats.textResponseBytes + "</li>";
            html = html + "</ul>";

            html = html + "<ul>";
            html = html + "<li>Flash Response Bytes -" + result.pageStats.flashResponseBytes + "</li>";
            html = html + "</ul>";

            html = html + "<ul>";
            html = html + "<li>Html Response Bytes -" + result.pageStats.htmlResponseBytes + "</li>";
            html = html + "</ul>";

            html = html + "<ul>";
            html = html + "<li>Css Response Bytes -" + result.pageStats.cssResponseBytes + "</li>";
            html = html + "</ul>";

            html = html + "<ul>";
            html = html + "<li>Image Response Bytes -" + result.pageStats.imageResponseBytes + "</li>";
            html = html + "</ul>";

            html = html + "<ul>";
            html = html + "<li>Javascript Response Bytes -" + result.pageStats.javascriptResponseBytes + "</li>";
            html = html + "</ul>";


            $('#page-stats').append(html);

        }

        return false;
    }

    function showAvoidLandingPageRedirects(result) {

        console.log('showAvoidLandingPageRedirects');

        console.log('urlBlocks');

        $('#AvoidDescrip').empty();

        $('#AvoidUrl').empty();

        var blocks = result.formattedResults.ruleResults.AvoidLandingPageRedirects.urlBlocks[1];

        console.log("- - - - - - -AVLPR Enable- - - - - - -" + blocks);

        if (blocks !== undefined) {

            for (var i = 0; i < result.formattedResults.ruleResults.AvoidLandingPageRedirects.urlBlocks.length; i++) {

                var block = result.formattedResults.ruleResults.AvoidLandingPageRedirects.urlBlocks[i];

                var header = result.formattedResults.ruleResults.AvoidLandingPageRedirects.urlBlocks[0].header.format;

                console.log(header);

                $('#AvoidDescrip').append(header);

                for (var j = 0; j < block.header.args.length; j++) {

                    var arg = block.header.args[j];

                    console.log('       value : ' + arg.value);

                    $('#AvoidUrl').append('<tr><td>' + arg.value + '<br></td></tr>');
                }
            }

            $('.avoidpagehidden').removeClass('hidden');

        } else {

            $('#AvoidDescrip').append('Your page has no redirects. Learn more about https://developers.google.com/speed/docs/insights/AvoidRedirects');

            $('.avoidpagehidden').addClass('hidden');
        }
    }

    function showEnableGzipCompression(result) {

        console.log('EnableGzipCompression');

        console.log('urlBlocks');

        $('#EnableDescrip').empty();

        $('#EnableUrl').empty();

        var blocks = result.formattedResults.ruleResults.EnableGzipCompression.urlBlocks[1];

        console.log("- - - - - -Enable Blocks - - - - - - -" + blocks)

        if (blocks !== undefined) {

            var block = result.formattedResults.ruleResults.EnableGzipCompression;//.urlBlocks[1];

            for (var j = 0; j < block.urlBlocks.length; j++) {

                var url = block.urlBlocks[j].header.format;

                console.log("URL :" + url);

                $('#EnableDescrip').append(url);

                var valuedata = block.urlBlocks[j].header.args[0].value;

                console.log("VALUE DATA : " + valuedata);

                $('#EnableUrl').append('<tr><td>' + valuedata + '<br></td></tr>');
            }

            $('.enablehidden').removeClass('hidden');

        } else {

            $('#EnableDescrip').append("No Avaliable Data");

            $('.enablehidden').addClass('hidden');
        }
    }

    function showLeverageBrowserCaching(result) {

        console.log('LeverageBrowserCaching');

        console.log('urlBlocks');

        $('#LeverageDescrip').empty();

        $('#LeverageUrl').empty();

        var block = result.formattedResults.ruleResults.LeverageBrowserCaching.urlBlocks[1];

        console.log("------------Leverage Block--------------" + block);

        if (block !== undefined) {

            var details1 = result.formattedResults.ruleResults.LeverageBrowserCaching.urlBlocks[0].header.format;

            var details2 = result.formattedResults.ruleResults.LeverageBrowserCaching.urlBlocks[1].header.format;

            $('#LeverageDescrip').append(details1);

            $('#LeverageDescrip').append(details2);

            console.log(details1);

            console.log(details2);

            for (var j = 0; j < block.urls.length; j++) {

                var url = block.urls[j];

                var arg = url.result.args[0];

                console.log('value : ' + arg.value);

                $('#LeverageUrl').append('<tr><td>' + arg.value + '<br></td></tr>');
            }

            $('.leveragehidden').removeClass('hidden');

        } else {

            $('#LeverageDescrip').append("You have enabled browser caching. Learn more about https://developers.google.com/speed/docs/insights/LeverageBrowserCaching");

            $('.leveragehidden').addClass('hidden');

        }
    }

    function showMinifyHTML(result) {

        console.log('MinifyHTML');

        console.log('urlBlocks');

        $('#HTMLDescrip').empty();

        $('#HTMLUrl').empty();

        var block = result.formattedResults.ruleResults.MinifyHTML.urlBlocks[1];

        console.log("- - - - - - MinifyHTML Block - - - - - - - -" + block);

        if (block !== undefined) {

            var header = result.formattedResults.ruleResults.MinifyHTML.urlBlocks[0].header.format;

            var header1 = result.formattedResults.ruleResults.MinifyHTML.urlBlocks[1].header.format;

            $('#HTMLDescrip').append(header);

            $('#HTMLDescrip').append(header1);

            console.log(header);

            console.log(header1);

            for (var j = 0; j < block.urls.length; j++) {

                var url = block.urls[j];

                var arg = url.result.args[0];

                console.log('       value : ' + arg.value);

                $('#HTMLUrl').append('<tr><td>' + arg.value + '<br></td></tr>');
            }

            $('.htmlhidden').removeClass('hidden');

        } else {

            $('#HTMLDescrip').append("Your HTML is minified. Learn more about https://developers.google.com/speed/docs/insights/MinifyResources");

            $('.htmlhidden').addClass('hidden');
        }
    }

    function showMinifyJavaScript(result) {

        console.log('MinifyJavaScript');

        console.log('urlBlocks');

        $('#JavaScriptDescrip').empty();

        $('#JavaScriptUrl').empty();

        var html = "";

        var block = result.formattedResults.ruleResults.MinifyJavaScript.urlBlocks[1];

        if (block !== undefined) {

            var header = result.formattedResults.ruleResults.MinifyJavaScript.urlBlocks[0].header.format;

            var header1 = result.formattedResults.ruleResults.MinifyJavaScript.urlBlocks[1].header.format;

            $('#JavaScriptDescrip').append(header);

            $('#JavaScriptDescrip').append(header1);

            for (var j = 0; j < block.urls.length; j++) {

                var url = block.urls[j];

                var arg = url.result.args[0];

                $('#JavaScriptUrl').append('<tr><td>' + arg.value + '<br></td></tr>');
            }

            $('.tablehidden').removeClass('hidden');

        } else {

            $('#JavaScriptDescrip').append("Your CSS is minified. Learn more about https://developers.google.com/speed/docs/insights/MinifyResources");

            $('.tablehidden').addClass('hidden');
        }
    }

    function showMinifyCss(result) {

        console.log('MinifyCss');

        console.log('urlBlocks');

        $('#CSSDescrip').empty();

        $('#CSSUrl').empty();

        var block = result.formattedResults.ruleResults.MinifyCss.urlBlocks[1];

        console.log("- - - - - - -CSS Block- - - - - - - - -" + block);

        if (block !== undefined) {

            for (var i = 0; i < result.formattedResults.ruleResults.MinifyCss.urlBlocks.length; i++) {

                var block = result.formattedResults.ruleResults.MinifyCss.urlBlocks[i];

                var header = result.formattedResults.ruleResults.MinifyCss.urlBlocks[0].header.format;

                console.log(header);

                $('#CSSDescrip').append(header);

                for (var j = 0; j < block.header.args.length; j++) {

                    var arg = block.header.args[j];

                    console.log('       value : ' + arg.value);

                    $('#CSSUrl').append('<tr><td>' + arg.value + '<br></td></tr>');
                }
            }

            $('.csshidden').removeClass('hidden');

        } else {

            $('#CSSDescrip').append("Your CSS is minified. Learn more about https://developers.google.com/speed/docs/insights/MinifyResources");

            $('.csshidden').addClass('hidden');
        }
    }

    function showPrioritizeVisibleContent(result) {

        console.log('PrioritizeVisibleContent');

        console.log('urlBlocks');

        $('#PrioritizeDescrip').empty();

        $('#PrioritizeUrl').empty();

        var blocks = result.formattedResults.ruleResults.PrioritizeVisibleContent.urlBlocks[0];

        console.log("- - - - - - -PRIORITY Blocks- - - - - - - - - -" + blocks);

        if (blocks !== undefined) {

            var block = result.formattedResults.ruleResults.PrioritizeVisibleContent.urlBlocks[0].header.args;

            var header = result.formattedResults.ruleResults.PrioritizeVisibleContent.urlBlocks[0].header.format;

            $('#PrioritizeDescrip').append(header);

            console.log("--header--" + header);

            console.log("---block-" + block[0].value);

            var hyperlink = block[0].value;

            $('#PrioritizeUrl').append(hyperlink);

            $('.priorityhidden').removeClass('hidden');

        } else {

            $('#PrioritizeDescrip').append("You have the above-the-fold content properly prioritized. Learn more about https://developers.google.com/speed/docs/insights/PrioritizeVisibleContent");

            $('.priorityhidden').addClass('hidden');
        }

    }

    function showMainResourceServerResponseTime(result) {

        console.log('MainResourceServerResponseTime');

        console.log('urlBlocks');

        $('#ServerDescrip').empty();

        $('#ServerUrl').empty();

        var blocks = result.formattedResults.ruleResults.MainResourceServerResponseTime.urlBlocks[0];

        console.log("- - - - - - RESPONSE TIME BLOCK - - - - - - " + blocks);

        if (blocks !== undefined) {

            var block = result.formattedResults.ruleResults.MainResourceServerResponseTime.urlBlocks[0].header;

            var header = result.formattedResults.ruleResults.MainResourceServerResponseTime.urlBlocks[0].header.format;

            console.log("--header--" + header);

            $('#ServerDescrip').append(header);

            for (var j = 0; j < block.args.length; j++) {

                var url = block.args[j];

                console.log(j + "----" + url.value);

                $('#ServerUrl').append('<tr><td>' + url.value + '<br></td></tr>');
            }

            $('.serverhidden').removeClass('hidden');

        } else {
            $('#ServerDescrip').append('No Data Avaliable');

            $('.serverhidden').addClass('hidden');
        }
    }

    function showOptimizeImages(result) {

        console.log('OptimizeImages');

        console.log('urlBlocks');

        $('#OptimizeDescrip').empty();

        $('#OptimizeUrl').empty();

        var block = result.formattedResults.ruleResults.OptimizeImages.urlBlocks[1];

        console.log("----------Optimize Image Block----------" + block);

        if (block !== undefined) {

            $('#OptimizeDescrip').append(block.header.format);

            for (var j = 0; j < block.urls.length; j++) {

                var url = block.urls[j];

                var arg = url.result.args[0];

                var Losslesslyformat = url.result.format;

                console.log('       value : ' + arg.value);

                $('#OptimizeUrl').append('<tr><td>' + arg.value + '<br></td></tr>');
            }

            $('.optimizehidden').removeClass('hidden');

        } else
        {
            $('#OptimizeDescrip').append("Your images are optimized. Learn more about https://developers.google.com/speed/docs/insights/OptimizeImages");

            $('.optimizehidden').addClass('hidden');
        }
    }

    function showMinimizeRenderBlockingResources(result) {

        console.log('MinimizeRenderBlockingResources');

        console.log('urlBlocks');

        $('#pUrl').empty();

        $('#tbody').empty();

        var blocks = result.formattedResults.ruleResults.MinimizeRenderBlockingResources.urlBlocks[1];

        console.log("- - - - - - - - Blocks - - - - - - - - - " + blocks);

        if (blocks !== undefined) {

            var block = result.formattedResults.ruleResults.MinimizeRenderBlockingResources;

            for (var j = 0; j < block.urlBlocks.length; j++)
            {
                try {

                    var url = block.urlBlocks[j].header.format;

                    console.log(url);

                    $('#pUrl').append(url);

                    var url1 = block.urlBlocks[j];

                    if (typeof url1.urls !== 'undefined')
                    {
                        for (var k = 0; k < url1.urls.length; k++)
                        {
                            var args = url1.urls[k].result.args[0];

                            if (typeof args !== 'undefined')
                            {
                                var valuetext = args.value;

                                console.log("============" + valuetext);

                                $('#tbody').append('<tr><td>' + valuetext + '<br></td></tr>');
                            }
                        }
                    }
                } catch (err)
                {
                    console.log(err);
                }
            }

            $('.renderhidden').removeClass('hidden');

        } else {

            $('#pUrl').append("No Data is Avaliable");

            $('.renderhidden').addClass('hidden');
        }
    }
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
    $('#sFix').click(function () {
        $('#sFix span.less, #sFix span.more').toggleClass('hidden');
    });
    $('#sFix2').click(function () {
        $('#sFix2 span.less, #sFix2 span.more').toggleClass('hidden');
    });
    $('#sFix3').click(function () {
        $('#sFix3 span.less, #sFix3 span.more').toggleClass('hidden');
    });
    $('#sFix4').click(function () {
        $('#sFix4 span.less, #sFix4 span.more').toggleClass('hidden');
    });
    $('#sFix5').click(function () {
        $('#sFix5 span.less, #sFix5 span.more').toggleClass('hidden');
    });
    $('#sFix6').click(function () {
        $('#sFix6 span.less, #sFix6 span.more').toggleClass('hidden');
    });
    $('#sFix7').click(function () {
        $('#sFix7 span.less, #sFix7 span.more').toggleClass('hidden');
    });
    $('#sFix8').click(function () {
        $('#sFix8 span.less, #sFix8 span.more').toggleClass('hidden');
    });
    $('#sFix9').click(function () {
        $('#sFix9 span.less, #sFix9 span.more').toggleClass('hidden');
    });
    $('#sFix10').click(function () {
        $('#sFix10 span.less, #sFix10 span.more').toggleClass('hidden');
    });
</script>