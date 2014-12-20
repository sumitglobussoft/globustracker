<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
    <div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i> 
            <b>GlobusTracker</b>
            <span>> 
                Video Campaign : <s:property value="campaignName" />
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
    <!-- END ROW -->

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
                            <a data-toggle="tab" href="#hr1"><span class="hidden-mobile hidden-tablet"> VIDEO </span></a>
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
                                <div class="tabbable tabs-below">
                                    <div class="tab-content padding-10">
                                        <div class="tab-pane active" id="AA">
                                            <table class="table table-bordered table-condensed">
                                                <thead>
                                                    <tr>
                                                        <th style="text-align: center;">Keyword</th>
                                                        <th style="text-align: center;" colspan="2"><img src="https://s3.amazonaws.com/images_ranktracker/youtubeicon.png"  style="border:none;" width="24" height="24" alt="" /></th>
                                                        <th style="text-align: center;" colspan="2"><img src="https://s3.amazonaws.com/images_ranktracker/dailymotion_24.png" style="border:none;" width="24" height="24" alt=""/></th>
                                                        <th style="text-align: center;" colspan="2"><img src="https://s3.amazonaws.com/images_ranktracker/vimeo_logo.JPG" style="border:none;" width="24" height="24" alt="" /></th> 
                                                        <th style="text-align: center;" colspan="2"><img src="https://s3.amazonaws.com/images_ranktracker/metacafe_logo.png" style="border:none;" width="24" height="24" alt="" /></th>
                                                        <th style="text-align: center;">Chart</th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <s:iterator value="videotrackhst">
                                                        <tr>
                                                        <tr>
                                                            <td style="text-align: left;"><s:property value="videoKeyword" /></td>
                                                            <td title="<s:property value="youtubeURL" />"><s:property value="youtubeURL" /></td>
                                                            <s:if test="%{rankYoutube!=501 }">
                                                                <td style="text-align: center;"><s:property value="rankYoutube" /></td>
                                                            </s:if>
                                                            <s:else>
                                                                <td style="text-align: center;">N/A</td>
                                                            </s:else>
                                                            <td title="<s:property value="dailymotionURL" />"><s:property value="dailymotionURL" /></td>
                                                            <s:if test="%{rankDailyMotion!=501 }">
                                                                <td style="text-align: center;"><s:property value="rankDailyMotion" /></td>
                                                            </s:if>
                                                            <s:else >
                                                                <td style="text-align: center;">N/A</td>
                                                            </s:else>
                                                            <td title="<s:property value="vimeoURL" />"><s:property value="vimeoURL" /></td>
                                                            <s:if test="%{rankVimeo!=501 }">
                                                                <td style="text-align: center;"><s:property value="rankVimeo" /></td>
                                                            </s:if>
                                                            <s:else >
                                                                <td style="text-align: center;">N/A</td>
                                                            </s:else>
                                                            <td title="<s:property value="metacafeURL" />"><s:property value="metacafeURL" /></td>
                                                            <s:if test="%{rankMetacafe!=501 }">
                                                                <td style="text-align: center;"><s:property value="rankMetacafe" /></td>
                                                            </s:if>
                                                            <s:else >
                                                                <td style="text-align: center;">N/A</td>
                                                            </s:else>
                                                            <td style="text-align: center;"><a href="javascript:drawVideoChart('<s:property value="videokeywordID"/>','30');" id="google_chart" title="Chart"><i class="fa fa-2x fa-bar-chart-o" data-toggle="modal" data-target="#chartmodal"></i></a></td>
                                                        </tr>
                                                    </s:iterator>
                                                </tbody>
                                            </table>
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
    <!-- end row -->

      <!--chart Modal -->
    <div class="modal fade" id="chartmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
        <div class="modal-dialog" style="width: 1200px;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">View Counts Of Videos</h4>
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

</section>
<!-- end widget grid -->

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="https://s3.amazonaws.com/js_ranktracker/highcharts.js"></script> 
<script src="https://s3.amazonaws.com/js_ranktracker/exporting.js"></script>
<script type="text/javascript">
    var opened = "0";
    function drawVideoChart(keywordId, range) {
        var jString = "{\"keywordId\":\"" + keywordId + "\" , \"range\":\"" + range + "\"}";
        var chart;
        $.getJSON(
        'ajax/getVideoChartData.action',
        {
            jString: jString
        },
        function(jMap) {
            chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'chartBlock',
                    type: 'column',
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
                    //                    text: 'globustracker.com',
                    //                    href: 'http://www.globustracker.com/'
                },
                xAxis: {
                    categories:
                        eval(jMap.dataMap.category),
                    //                        ['View Count', 'Like Count' ,  'DisLike Count',  'Comment Count ',  'Daily View Count'  ],
                    labels: {
                        x: 3,
                        style: {
                            fontSize: '13px',
                            fontFamily: 'Verdana, sans-serif',
                            //  color: "black",
                            color: "{point.color}",
                            fontWeight: 'bold'
                        }
                    }//, offset: -16
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'View Count'
                    }
                },
                tooltip: {
                    pointFormat: '<b>{point.y}</b>'
                },
                legend: {
                    enabled: false
                },
                series: eval(jMap.dataMap.sbData)
            });

        });
    }   
</script>
