<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i> 
            <b>GlobusTracker</b>
            <span>> 
                Serps Campaign : <s:property value="campaignName" />
            </span>
        </h1>
    </div>
</div>

<!-- widget grid -->
<section id="widget-grid" class="">

    <!-- START ROW -->
    <div class="row">

        <!-- NEW COL START -->
        <article class="col-sm-12 col-md-12 col-lg-12">

            <!-- Widget ID (each widget will need unique ID)-->
            <div class="jarviswidget" id="wid-id-0" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
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
                    <span class="widget-icon"> <i class="fa fa-clock-o"></i> </span>
                    <h2>Keywords Up</h2>
                </header>

                <!-- widget div-->
                <div>
                    <!-- start row -->
                    <div class="row">

                        <div class="col-sm-12 col-md-12 col-lg-12">

                            <div class="well">

                                <div class="row">
                                    <s:iterator value="rankComparision">
                                        <div class="col-md-offset-1 col-sm-2">

                                            <div class="well well-sm bg-color-teal txt-color-white text-center">
                                                <h5>Top 5</h5>
                                                <code><s:property value="keywordsRankBelow5" />/<s:property value="totalkeywords" /></code>
                                                <h5>vs: 0 change: +</h5>
                                            </div>

                                        </div>

                                        <div class="col-sm-2">

                                            <div class="well well-sm bg-color-pinkDark txt-color-white text-center">
                                                <h5>Top 10</h5>
                                                <code><s:property value="keywordsRankBelow10" />/<s:property value="totalkeywords" /></code>
                                                <h5>vs: 0 change: +</h5>
                                            </div>

                                        </div>

                                        <div class="col-sm-2">

                                            <div class="well well-sm text-center">
                                                <h5>Top 20</h5>
                                                <code><s:property value="keywordsRankBelow20" />/<s:property value="totalkeywords" /></code>
                                                <h5>vs: 0 change: +</h5>
                                            </div>

                                        </div>

                                        <div class="col-sm-2">

                                            <div class="well well-sm bg-color-pinkDark txt-color-white text-center">
                                                <h5>Top 30</h5>
                                                <code><s:property value="keywordsRankBelow30" />/<s:property value="totalkeywords" /></code>
                                                <h5>vs: 0 change: +</h5>
                                            </div>

                                        </div>

                                        <div class="col-sm-2">

                                            <div class="well well-sm bg-color-teal txt-color-white text-center">
                                                <h5>Top 100</h5>
                                                <code><s:property value="keywordsRankBelow100" />/<s:property value="totalkeywords" /></code>
                                                <h5>vs: 0 change: +</h5>
                                            </div>

                                        </div>
                                    </s:iterator>

                                </div>

                            </div>

                        </div>

                    </div>
                    <!-- end row -->

                </div>
                <!-- end widget div -->

            </div>
            <!-- end widget -->

        </article>
        <!-- END COL -->

    </div>
    <!-- row -->

    <div class="row">

        <!-- NEW WIDGET START -->
        <article class="col-sm-12 col-md-12 col-lg-12">

            <!-- Widget ID (each widget will need unique ID)-->
            <div class="jarviswidget" id="wid-id-0" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
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
                    <ul class="nav nav-tabs pull-left in">

                        <li class="active">
                            <a data-toggle="tab" href="#hr1"><span class="hidden-mobile hidden-tablet"> SERPS </span>  <i class="fa fa-lg fa-google-plus-square"></i> <i class="fa fa-lg fa-yahoo"></i> <i class="fa fa-lg fa-arrow-circle-o-down"></i></a>
                        </li>

                        <li>
                            <a data-toggle="tab" href="#hr2"><span class="hidden-mobile hidden-tablet"> SEO Data </span> </a>
                        </li>

                        <li>
                            <a data-toggle="tab" href="#hr3"><span class="hidden-mobile hidden-tablet"> SOCIAL <i class="fa fa-thumbs-up fa-fw"></i><i class="fa fa-pinterest-square fa-fw"></i><i class="fa fa-google-plus-square fa-fw"></i><i class="fa fa-linkedin-square fa-fw"></i><i class="fa fa-reddit-square fa-fw"></i></span> </a>
                        </li>
                    </ul>                  
                </header>

                <!-- widget div-->
                <div>

                    <!-- widget edit box -->
                    <div class="jarviswidget-editbox">
                        <!-- This area used as dropdown edit box -->

                    </div>
                    <!-- end widget edit box -->

                    <!-- widget content -->
                    <div class="widget-body">

                        <div class="tab-content">

                            <div class="tab-pane active" id="hr1">
                                <ul class="nav nav-tabs">
                                    <li class="active">
                                        <a data-toggle="tab" href="#AA">GOOGLE</a>
                                    </li>

                                    <li>
                                        <a data-toggle="tab" href="#BB">YAHOO</a>
                                    </li>

                                    <li>
                                        <a data-toggle="tab" href="#CC">BING</a>
                                    </li>

                                </ul>

                                <div class="tabbable tabs-below">
                                    <div class="tab-content padding-10">

                                        <div class="tab-pane active" id="AA">
                                            <table class="table table-bordered table-condensed">
                                                <thead>
                                                    <tr>
                                                        <th style="text-align: center;">Url <a href="javascript:drawComparisionChart('<s:property value="campaignID"/>','30','google');" id="google_comparision_chart"></a></th>
                                                        <th style="text-align: center;">Keyword</th>
                                                        <th style="text-align: center;">Page Rank</th>
                                                        <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/google_icon.png" style="border:none;" width="20" height="20" alt="" /></th>
                                                        <th style="text-align: center;">Best Match Rank</th>
                                                        <th style="text-align: center;">Day</th>
                                                        <th style="text-align: center;">Week</th>
                                                        <th style="text-align: center;">Month</th>
                                                        <th style="text-align: center;">Last Updated</th>
                                                        <th style="text-align: center;">Chart</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <s:iterator value="lstUpdatedKeywords">
                                                        <tr>
                                                            <td title="<s:property value="url" />"><s:property value="url" /></td>
                                                            <td><s:property value="keyword" /></td>
                                                            <td style="text-align: center;"><s:property value="googlePageRank" /></td>
                                                            <s:if test="%{rankGoogle!=501 }">
                                                                <td style="text-align: center;"><s:property value="rankGoogle" /></td>
                                                            </s:if>
                                                            <s:else >
                                                                <td style="text-align: center;">N/A</td>
                                                            </s:else>
                                                            <s:if test="%{bestMatchRankGoogle!=501 }">
                                                                <td style="text-align: center;"><s:property value="bestMatchRankGoogle" /></td>
                                                            </s:if>
                                                            <s:else >
                                                                <td style="text-align: center;">N/A</td>
                                                            </s:else>

                                                            <td style="text-align: center;"><s:property value="rankGoogleDayChange" />
                                                                <s:if test="%{rankGoogleDayChange < 0}">
                                                                    <i class="fa fa-arrow-down fa-1x fa-fw txt-color-red"></i>
                                                                </s:if>
                                                                <s:elseif test="%{rankGoogleDayChange > 0}">
                                                                    <i class="fa fa-arrow-up fa-1x fa-fw txt-color-green"></i>
                                                                </s:elseif>
                                                            </td>
                                                            <td style="text-align: center;"><s:property value="rankGoogleWeekChange" />
                                                                <s:if test="%{rankGoogleWeekChange<0}">
                                                                    <i class="fa fa-arrow-down fa-1x fa-fw txt-color-red"></i>
                                                                </s:if>
                                                                <s:elseif test="%{rankGoogleWeekChange>0}">
                                                                    <i class="fa fa-arrow-up fa-1x fa-fw txt-color-green"></i>
                                                                </s:elseif>
                                                            </td>
                                                            <td style="text-align: center;"><s:property value="rankGoogleMonthChange" />
                                                                <s:if test="%{rankGoogleMonthChange<0}">
                                                                    <i class="fa fa-arrow-down fa-1x fa-fw txt-color-red"></i>
                                                                </s:if>
                                                                <s:elseif test="%{rankGoogleMonthChange>0}">
                                                                    <i class="fa fa-arrow-up fa-1x fa-fw txt-color-green"></i>
                                                                </s:elseif>
                                                            </td>
                                                            <td style="text-align: center;"> <s:property value="googleUpdatedDate" /> </td>
                                                            <td style="text-align: center;"><a href="javascript:drawChart('<s:property value="keywordID"/>','30');" id="google_chart" title="Chart"><i class="fa fa-2x fa-bar-chart-o" data-toggle="modal" data-target="#chartmodal"></i></a></td>
                                                        </tr>
                                                    </s:iterator>  
                                                </tbody>
                                            </table>
                                        </div>

                                        <div class="tab-pane" id="BB">
                                            <table class="table table-bordered table-condensed">
                                                <thead>
                                                    <tr>
                                                        <th style="text-align: center;">Url</th>
                                                        <th style="text-align: center;">Keyword</th>
                                                        <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/yahooicon.png" width="20" height="20" alt="" /></th>
                                                        <th style="text-align: center;">Best Match Rank</th>
                                                        <th style="text-align: center;">Day</th>
                                                        <th style="text-align: center;">Week</th>
                                                        <th style="text-align: center;">Month</th>
                                                        <th style="text-align: center;">Last Updated</th>
                                                        <th style="text-align: center;">Chart</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <s:iterator value="lstUpdatedKeywords">
                                                        <tr>
                                                            <td title="<s:property value="url" />"><s:property value="url" /></td>
                                                            <td><s:property value="keyword" /></td>
                                                            <s:if test="%{rankYahoo!=501 }">
                                                                <td style="text-align: center;"><s:property value="rankYahoo" /></td>
                                                            </s:if>
                                                            <s:else >
                                                                <td style="text-align: center;">N/A</td>
                                                            </s:else>
                                                            <s:if test="%{bestMatchRankYahoo!=501 }">
                                                                <td style="text-align: center;"><s:property value="bestMatchRankYahoo" /></td>
                                                            </s:if>
                                                            <s:else >
                                                                <td style="text-align: center;">N/A</td>
                                                            </s:else>
                                                            <td style="text-align: center;"><s:property value="rankYahooDayChange" />
                                                                <s:if test="%{rankYahooDayChange<0}">
                                                                    <i class="fa fa-arrow-down fa-1x fa-fw txt-color-red"></i>
                                                                </s:if>
                                                                <s:elseif test="%{rankYahooDayChange>0}">
                                                                    <i class="fa fa-arrow-up fa-1x fa-fw txt-color-green"></i>
                                                                </s:elseif>
                                                            </td>                                                                                                                            
                                                            <td style="text-align: center;"><s:property value="rankYahooWeekChange" />
                                                                <s:if test="%{rankYahooWeekChange<0}">
                                                                    <i class="fa fa-arrow-down fa-1x fa-fw txt-color-red"></i>
                                                                </s:if>
                                                                <s:elseif test="%{rankYahooWeekChange>0}">
                                                                    <i class="fa fa-arrow-up fa-1x fa-fw txt-color-green"></i>
                                                                </s:elseif>
                                                            </td>                                                        
                                                            <td style="text-align: center;"><s:property value="rankYahooMonthChange" />
                                                                <s:if test="%{rankYahooMonthChange<0}">
                                                                    <i class="fa fa-arrow-down fa-1x fa-fw txt-color-red"></i>
                                                                </s:if>
                                                                <s:elseif test="%{rankYahooMonthChange>0}">
                                                                    <i class="fa fa-arrow-up fa-1x fa-fw txt-color-green"></i>
                                                                </s:elseif>
                                                            </td>                                                              
                                                            <td style="text-align: center;"><s:property value="yahooUpdateDate" /></td>
                                                            <td style="text-align: center;"><a href="javascript:drawChart('<s:property value="keywordID"/>','30');" id="yahoo_chart" title="Chart"><i class="fa fa-2x fa-bar-chart-o" data-toggle="modal" data-target="#chartmodal"></i></a></td>
                                                        </tr>
                                                    </s:iterator>
                                                </tbody>
                                            </table>
                                        </div>                                   

                                        <div class="tab-pane" id="CC">
                                            <table class="table table-bordered table-condensed">
                                                <thead>
                                                    <tr>
                                                        <th style="text-align: center;">Url</th>
                                                        <th style="text-align: center;">Keyword</th>
                                                        <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/bingicon.png" width="20" height="20" alt="" /></th>
                                                        <th style="text-align: center;">Best Match Rank</th>
                                                        <th style="text-align: center;">Day</th>
                                                        <th style="text-align: center;">Week</th>                                                       
                                                        <th style="text-align: center;">Month</th>                                                      
                                                        <th style="text-align: center;">Last Updated</th>
                                                        <th style="text-align: center;">Chart</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <s:iterator value="lstUpdatedKeywords">
                                                        <tr>
                                                            <td title="<s:property value="url" />"><s:property value="url" /></td>
                                                            <td><s:property value="keyword" /></td>
                                                            <s:if test="%{rankBing!=501 }">
                                                                <td style="text-align: center;"><s:property value="rankBing" /></td>
                                                            </s:if>
                                                            <s:else >
                                                                <td style="text-align: center; ">N/A</td>
                                                            </s:else>
                                                            <s:if test="%{bestMatchRankBing!=501 }">
                                                                <td style="text-align: center;"><s:property value="bestMatchRankBing" /></td>
                                                            </s:if>
                                                            <s:else >
                                                                <td style="text-align: center;">N/A</td>
                                                            </s:else>
                                                            <td style="text-align: center;"><s:property value="rankBingDayChange" />
                                                                <s:if test="%{rankBingDayChange<0}">
                                                                    <i class="fa fa-arrow-down fa-1x fa-fw txt-color-red"></i>
                                                                </s:if>
                                                                <s:elseif test="%{rankBingDayChange>0}">
                                                                    <i class="fa fa-arrow-up fa-1x fa-fw txt-color-green"></i>
                                                                </s:elseif>
                                                            </td>
                                                            <td style="text-align: center;"><s:property value="rankBingWeekChange" />
                                                                <s:if test="%{rankBingWeekChange<0}">
                                                                    <i class="fa fa-arrow-down fa-1x fa-fw txt-color-red"></i>
                                                                </s:if>
                                                                <s:elseif test="%{rankBingWeekChange>0}">
                                                                    <i class="fa fa-arrow-up fa-1x fa-fw txt-color-green"></i>
                                                                </s:elseif>
                                                            </td>
                                                            <td style="text-align: center;"><s:property value="rankBingMonthChange" />
                                                                <s:if test="%{rankBingMonthChange<0}">
                                                                    <i class="fa fa-arrow-down fa-1x fa-fw txt-color-red"></i>
                                                                </s:if>
                                                                <s:elseif test="%{rankBingMonthChange>0}">
                                                                    <i class="fa fa-arrow-up fa-1x fa-fw txt-color-green"></i>
                                                                </s:elseif>
                                                            </td>
                                                            <td style="text-align: center;"><s:property value="bingUpdateDate" /></td>
                                                            <td style="text-align: center;"><a href="javascript:drawChart('<s:property value="keywordID"/>','30');" id="bing_chart" title="Chart"><i class="fa fa-2x fa-bar-chart-o" data-toggle="modal" data-target="#chartmodal"></i></a></td>
                                                        </tr>
                                                    </s:iterator>                                      
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>                                                                                  
                            </div>                                

                            <div class="tab-pane" id="hr2">
                                <table class="table table-bordered table-condensed">
                                    <thead>
                                        <tr>
                                            <th style="text-align: center;">Url</th>
                                            <th style="text-align: center;">Keyword</th>
                                            <th style="text-align: center;">Search Volume</th>
                                            <th style="text-align: center;">CPC</th>
                                            <th style="text-align: center;">Competition</th>
                                            <th style="text-align: center;">Number of Results</th>
                                            <th style="text-align: center;" title="Site Indexing">SI</th>                                           
                                            <th style="text-align: center;" title="Alexa Ranking">Alexa</th>                                          
                                            <th style="text-align: center;" title="Backlinks">BL</th>                                           
                                            <th style="text-align: center;" title="Monthly Searches">MS</th>                                       
                                            <th style="text-align: center;" title="Page Authority">PA</th>
                                            <th style="text-align: center;" title="Domain Authority">DA</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="lstSeoDetails">
                                            <tr>
                                                <td title="<s:property value="url" />"><s:property value="url" /></td>
                                                <td><s:property value="keyword" /></td>
                                                <td style="text-align: center;"><s:property value="searchVolume" /></td>
                                                <td style="text-align: center;"><s:property value="googleCPC" /></td>
                                                <td style="text-align: center;"><s:property value="keywordCompetition" /></td>
                                                <td style="text-align: center;"><s:property value="numberofResult" /></td>
                                                <td style="text-align: center;"><s:property value="siteIndexing" /></td>
                                                <td style="text-align: center"><s:property value="rankAlexa" /></td>
                                                <td style="text-align: center;"><s:property value="countBackLinks" /></td>
                                                <td style="text-align: center;"><s:property value="countMonthlySearches" /></td>
                                                <td style="text-align: center;"><s:property value="googlePA" /></td>
                                                <td style="text-align: center;"><s:property value="googleDA" /></td>
                                            </tr>
                                        </s:iterator>   
                                    </tbody>
                                </table>
                            </div>

                            <div class="tab-pane" id="hr3">
                                <table class="table table-bordered table-condensed">
                                    <thead>
                                        <tr>
                                            <th style="text-align: center;">Url</th>
                                            <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/fb_likes.png" style="border:none;" width="24" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/fb_share.png" style="border:none;" width="70" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/twt_count.png" style="border:none;" width="24" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/pintrest.png" style="border:none;" width="24" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/google_plus.png" style="border:none;" width="24" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/linkedin.png" style="border:none;" width="24" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/reddit.png" style="border:none;" width="24" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/stumbleupon.png" style="border:none;" width="24" height="24" alt="" /></th>
                                            <th style="text-align: center;">Chart</th>                                                
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="lstsocialsignalupdate">
                                            <tr>
                                                <td title="<s:property value="socialSignalUrl" />"><s:property value="socialSignalUrl" /></td>
                                                <td style="text-align: center;"><s:property value="facebookLike" /></td>
                                                <td style="text-align: center;"><s:property value="facebookShare" /></td>
                                                <td style="text-align: center;"><s:property value="tweetCount" /></td>
                                                <td style="text-align: center;"><s:property value="pinterestPins" /></td>
                                                <td style="text-align: center;"><s:property value="googlePlusLikes" /></td>
                                                <td style="text-align: center;"><s:property value="linkedInShares" /></td>
                                                <td style="text-align: center;"><s:property value="redittVotes" /></td>
                                                <td style="text-align: center;"><s:property value="stumbleUponLikes" /></td>
                                                <td style="text-align: center;"><a href="javascript:drawSocialChart('<s:property value="SocialSignalUrlID"/>','30');" id="social_chart" title="Chart"><i class="fa fa-2x fa-bar-chart-o" data-toggle="modal" data-target="#socialchartmodal"></i></a></td>
                                            </tr>
                                        </s:iterator>   
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <!-- end widget -->

        </article>
        <!-- WIDGET END -->

    </div>
    <!-- end row -->

    <!--chart Modal -->
    <div class="modal fade" id="chartmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
        <div class="modal-dialog" style="width: 1200px;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">Chart !</h4>
                </div>
                <div class="modal-body">
                    <div id="chartBlock">
                    </div> 	
                </div>
                <div class="modal-footer">

                </div>
            </div>
        </div>
    </div>
    <!--end of model-->

    <!--social chart Modal -->
    <div class="modal fade" id="socialchartmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
        <div class="modal-dialog" style="width: 1200px;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">Chart !</h4>
                </div>
                <div class="modal-body">
                    <div id="socialChartBlock">
                    </div> 	
                </div>
                <div class="modal-footer">

                </div>
            </div>
        </div>
    </div>
    <!--end of model-->   
</section>
<!-- end widget grid -->

<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="https://s3.amazonaws.com/js_ranktracker/highcharts.js"></script>
<script src="https://s3.amazonaws.com/js_ranktracker/exporting.js"></script>
<script type="text/javascript" src="http://www.highcharts.com/highslide/highslide-full.min.js"></script>
<script type="text/javascript" src="http://www.highcharts.com/highslide/highslide.config.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="http://www.highcharts.com/highslide/highslide.css" />
<script type="text/javascript">
    var opened = "0";
    var alertMes = "";
    function drawSocialChart(urlId, range) {
        var jString = "{\"urlId\":\"" + urlId + "\" , \"range\":\"" + range + "\"}";
        var chart;
        $.getJSON(
        'ajax/getSocialData.action',
        {
            jString: jString
        },
        function(jMap) {
            chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'socialChartBlock',
                    type: 'line',
                    marginRight: 130,
                    marginBottom: 25,
                    width: 1100,
                    height: 200
                },
                title: jMap.dataMap.title,
                subtitle: {
                    text: '',
                    x: -20
                },
                credits: {
                    enabled: false
                    // text: 'globustracker.com',
                    // href: 'http://www.globustracker.com/'
                },
                xAxis: {
                    type: 'datetime',
                    dateTimeLabelFormats: {
                        day: '%b %e '
                    }
                },
                yAxis: {
                    title: {
                        text: 'Rankings'
                    },
                    allowDecimals: false,
                    min: 0,
                    tickPixelInterval: 20,
                    plotLines: [{
                            value: 0,
                            width: 1,
                            color: '#808080'
                        }]
                },
                tooltip: {
                    crosshairs: true,
                    shared: true
                },
                legend: {
                    layout: 'horizontal',
                    align: 'top',
                    verticalAlign: 'top',
                    x: 0,
                    y: 0,
                    borderWidth: 0
                },
                series: eval(jMap.dataMap.sbData)
            });

        });
    }

    function drawChart(keywordId, range) {
        var jString = "{\"keywordId\":\"" + keywordId + "\" , \"range\":\"" + range + "\"}";
        var chart;
        $.getJSON(
        'ajax/getData.action',
        {
            jString: jString
        },
        function(jMap) {
            chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'chartBlock',
                    type: 'line',
                    marginRight: 130,
                    marginBottom: 25,
                    width: 1100,
                    height: 200,
                    zoomType: 'x'
                },
                title: jMap.dataMap.title,
                subtitle: {
                    text: '',
                    x: -20
                },
                credits: {
                    enabled: false
                },
                xAxis: {
                    //categories: eval(jMap.dataMap.sbRange),
                    type: 'datetime',
                    dateTimeLabelFormats: {
                        day: '%b %e '
                    },
                    plotBands: eval(jMap.dataMap.gtEvent)
                },
                yAxis: {
                    title: {
                        text: 'Rankings'
                    },
                    allowDecimals: false,
                    reversed: true,
                    min: 0,
                    tickPixelInterval: 20,
                    plotLines: [{
                            value: 0,
                            width: 1,
                            color: '#808080'
                        }]
                },
                tooltip: {
                    crosshairs: true,
                    shared: true
                },
                //                                                                exporting: {
                //                                                                    buttons: {
                //                                                                        customButton: {
                //                                                                            x: -62,
                //                                                                            symbol: 'url(https://cdn1.iconfinder.com/data/icons/large-glossy-icons/20/Target.png)',
                //                                                                            symbolX: 7.5,
                //                                                                            symbolY: 6,
                //                                                                            onclick: function() {
                //                                                                                $("#myGoal").toggle();
                //                                                                                $("#goalkewordId").val(keywordId);
                //                                                                                $("#backgrd").attr("class", "modal-backdrop fade in");
                //                                                                            }
                //                                                                        }
                //                                                                    }
                //                                                                },
                legend: {
                    layout: 'horizontal',
                    align: 'top',
                    verticalAlign: 'top',
                    x: 300,
                    y: 0,
                    borderWidth: 0
                },
                series: eval(jMap.dataMap.sbData)
            });

        });
    }
</script>

<script type="text/javascript" src="https://s3.amazonaws.com/js_ranktracker/script.js"></script>
