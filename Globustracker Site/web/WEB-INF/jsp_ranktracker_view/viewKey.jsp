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
                                                <h5>vs: <s:property value="previouskeywordsRankBelow5" /> change: <s:property value="currentkeywordsRankBelow5" /></h5>
                                            </div>

                                        </div>

                                        <div class="col-sm-2">

                                            <div class="well well-sm bg-color-pinkDark txt-color-white text-center">
                                                <h5>Top 10</h5>
                                                <code><s:property value="keywordsRankBelow10" />/<s:property value="totalkeywords" /></code>
                                                <h5>vs: <s:property value="previouskeywordsRankBelow10" /> change: <s:property value="currentkeywordsRankBelow10" /></h5>
                                            </div>

                                        </div>

                                        <div class="col-sm-2">

                                            <div class="well well-sm text-center">
                                                <h5>Top 20</h5>
                                                <code><s:property value="keywordsRankBelow20" />/<s:property value="totalkeywords" /></code>
                                                <h5>vs: <s:property value="previouskeywordsRankBelow20" /> change: <s:property value="currentkeywordsRankBelow20" /></h5>
                                            </div>

                                        </div>

                                        <div class="col-sm-2">

                                            <div class="well well-sm bg-color-pinkDark txt-color-white text-center">
                                                <h5>Top 30</h5>
                                                <code><s:property value="keywordsRankBelow30" />/<s:property value="totalkeywords" /></code>
                                                <h5>vs: <s:property value="previouskeywordsRankBelow30" /> change: <s:property value="currentkeywordsRankBelow30" /></h5>
                                            </div>

                                        </div>

                                        <div class="col-sm-2">

                                            <div class="well well-sm bg-color-teal txt-color-white text-center">
                                                <h5>Top 100</h5>
                                                <code><s:property value="keywordsRankBelow100" />/<s:property value="totalkeywords" /></code>
                                                <h5>vs: <s:property value="previouskeywordsRankBelow100" /> change: <s:property value="currentkeywordsRankBelow100" /></h5>
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
                                                        <th style="text-align: center;">Start</th>
                                                        <th style="text-align: center;"><img src="views/images_ranktracker/google_icon.png" style="border:none;" width="20" height="20" alt="" /></th>
                                                        <th style="text-align: center;">Best Match Rank</th>
                                                        <th style="text-align: center;">Day</th>
                                                        <th style="text-align: center;">Week</th>
                                                        <th style="text-align: center;">Month</th>
                                                        <th style="text-align: center;">Life</th>
                                                        <th style="text-align: center;">Last Updated</th>
                                                        <th style="text-align: center;">Chart</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="googleSerpsBody">

                                                </tbody>
                                            </table>
                                        </div>

                                        <div class="tab-pane" id="BB">
                                            <table class="table table-bordered table-condensed">
                                                <thead>
                                                    <tr>
                                                        <th style="text-align: center;">Url</th>
                                                        <th style="text-align: center;">Keyword</th>
                                                        <th style="text-align: center;">Start</th>
                                                        <th style="text-align: center;"><img src="views/images_ranktracker/yahooicon.png" width="20" height="20" alt="" /></th>
                                                        <th style="text-align: center;">Best Match Rank</th>
                                                        <th style="text-align: center;">Day</th>
                                                        <th style="text-align: center;">Week</th>
                                                        <th style="text-align: center;">Month</th>
                                                        <th style="text-align: center;">Life</th>
                                                        <th style="text-align: center;">Last Updated</th>
                                                        <th style="text-align: center;">Chart</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="yahooSerpsBody">

                                                </tbody>
                                            </table>
                                        </div>                                   

                                        <div class="tab-pane" id="CC">
                                            <table class="table table-bordered table-condensed">
                                                <thead>
                                                    <tr>
                                                        <th style="text-align: center;">Url</th>
                                                        <th style="text-align: center;">Keyword</th>
                                                        <th style="text-align: center;">Start</th>
                                                        <th style="text-align: center;"><img src="views/images_ranktracker/bingicon.png" width="20" height="20" alt="" /></th>
                                                        <th style="text-align: center;">Best Match Rank</th>
                                                        <th style="text-align: center;">Day</th>
                                                        <th style="text-align: center;">Week</th>                                                       
                                                        <th style="text-align: center;">Month</th>    
                                                        <th style="text-align: center;">Life</th>
                                                        <th style="text-align: center;">Last Updated</th>
                                                        <th style="text-align: center;">Chart</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="bingSerpsBody">

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
                                    <tbody id="seoKeywordsBody">

                                    </tbody>
                                </table>
                            </div>

                            <div class="tab-pane" id="hr3">
                                <table class="table table-bordered table-condensed">
                                    <thead>
                                        <tr>
                                            <th style="text-align: center;">Url</th>
                                            <th style="text-align: center;"><img src="views/images_ranktracker/fb_likes.png" style="border:none;" width="24" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="views/images_ranktracker/fb_share.png" style="border:none;" width="70" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="views/images_ranktracker/twt_count.png" style="border:none;" width="24" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="views/images_ranktracker/pintrest.png" style="border:none;" width="24" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="views/images_ranktracker/google_plus.png" style="border:none;" width="24" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="views/images_ranktracker/linkedin.png" style="border:none;" width="24" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="views/images_ranktracker/reddit.png" style="border:none;" width="24" height="24" alt="" /></th>
                                            <th style="text-align: center;"><img src="views/images_ranktracker/stumbleupon.png" style="border:none;" width="24" height="24" alt="" /></th>
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
                    <h4 class="modal-title">
                        <div class="row">
                            <div class="col-md-3">
                                Chart
                            </div>
                            <div class="col-md-8">
                                <span>KEYWORD : </span>
                                <span id="keywordname"></span>
                                <s:property value="keyword" />
                            </div>
                        </div>
                    </h4>
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

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
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
        function (jMap) {
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
        function (jMap) {
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
            $('#keywordname').html(jMap.dataMap.keyword);
        });
    }
</script>

<script type="text/javascript" src="https://s3.amazonaws.com/js_ranktracker/script.js"></script>

<script type="text/javascript">


    var initial = 0;

    var keyvalue = '<%=request.getParameter("key")%>';
//     alert(key);

    ajaxFunction();

    function ajaxFunction() {
        var ajaxRequest;  // The variable that makes Ajax possible!

        try {
            // Opera 8.0+, Firefox, Safari
            ajaxRequest = new XMLHttpRequest();

        } catch (e) {
            //                                    // Internet Explorer Browsers
            try {
                ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {
                    // Something went wrong
                    alert('Your browser broke!');

                }
            }
        }

        // Create a function that will receive data 
        // sent from the server and will update
        // div section in the same page.
        ajaxRequest.onreadystatechange = function () {
            if (ajaxRequest.readyState == 4) {
                //var ajaxDisplay = document.getElementById('ajaxDiv');
                //alert("hiii"+ajaxRequest.responseText)
                //ajaxDisplay.innerHTML = ajaxRequest.responseText;
                var result = ajaxRequest.responseText.toString();
                updategoogleSerpsBody(result);
                updateyahooSerpsBody(result);
                updatebingSerpsBody(result);
                updateseoKeywordsBody(result);
                initial += 50;

            }
        }
        // Now get the value from user and pass it to
        // server script.

        ajaxRequest.open("GET", "limitedserpskeywordsForKeyView.action?initial=" + initial + "&key=" + keyvalue, false);
        ajaxRequest.send(null);

    }

    var counter = 0;

    var scrollvalue = 0;
    $(window).scroll(function () {


        if ($(window).scrollTop() > scrollvalue) {
            counter++;
        }
        scrollvalue = $(window).scrollTop();
        console.log(counter);
        if (counter % 50 === 0)
        {
            ajaxFunction();
        }
//        if ($(window).scrollTop() + $(window).height() == $(document).height()) {
//            alert('hii');
//            //ajaxFunction();
//        }

    });



    //GoogleSerpsBody
    function updategoogleSerpsBody(result) {

        var output = JSON.parse(result);
        var htmlResult = "";
        var i = 0;

        for (i = 0; i < output.serpskeywords.length; i++) {

            htmlResult = htmlResult + "<tr>";
            htmlResult = htmlResult + "<td title='" + output.serpskeywords[i].Url + "'><a href='generateCrawledHistory.action?keywordId=" + output.serpskeywords[i].KeywordID + "' title='Google crawl history'><img src='https://s3.amazonaws.com/images_ranktracker/history.png' width='20' height='22' alt='' style='cursor:pointer;'  /></a>" + output.serpskeywords[i].Url + "</td>";
            htmlResult = htmlResult + "<td>" + output.serpskeywords[i].Keyword + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].GooglePageRank + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].StartGoogle + "</td>";

            if ((output.serpskeywords[i].RankGoogle !== 0) || (output.serpskeywords[i].GoogleUpdatedDate == '-')) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankGoogle + "</td>";
            }
            else {
                htmlResult = htmlResult + "<td style='text-align: center;'>N/A</td>";
            }

            if ((output.serpskeywords[i].BestMatchRankGoogle !== 0) || (output.serpskeywords[i].GoogleUpdatedDate == '-')) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].BestMatchRankGoogle + "</td>";
            }
            else {
                htmlResult = htmlResult + "<td style='text-align: center;'>N/A</td>";
            }


            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankGoogleDayChange + "";

            if (output.serpskeywords[i].RankGoogleDayChange < 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
            }
            else if (output.serpskeywords[i].RankGoogleDayChange > 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
            }
            htmlResult = htmlResult + "</td>";



            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankGoogleWeekChange + "";

            if (output.serpskeywords[i].RankGoogleWeekChange < 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
            }
            else if (output.serpskeywords[i].RankGoogleWeekChange > 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
            }
            htmlResult = htmlResult + "</td>";



            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankGoogleMonthChange + "";

            if (output.serpskeywords[i].RankGoogleMonthChange < 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
            }
            else if (output.serpskeywords[i].RankGoogleMonthChange > 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
            }
            htmlResult = htmlResult + "</td>";

            var life = output.serpskeywords[i].StartGoogle - output.serpskeywords[i].RankGoogle;

            htmlResult = htmlResult + "<td style='text-align: center;'>" + Math.abs(life) + "";

            if (life < 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
            }
            else if (life > 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
            }
            htmlResult = htmlResult + "</td>";


            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].GoogleUpdatedDate + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'><a href=\"javascript:drawChart(" + output.serpskeywords[i].KeywordID + ",30);\" id='google_chart' title='Chart'><i class='fa fa-2x fa-bar-chart-o' data-toggle='modal' data-target='#chartmodal'></i></a></td>";
            htmlResult = htmlResult + "<tr>";
        }

        document.getElementById('googleSerpsBody').innerHTML = document.getElementById('googleSerpsBody').innerHTML + htmlResult;
    }

    //YahooSerpsBody
    function updateyahooSerpsBody(result) {

        var output = JSON.parse(result);
        var htmlResult = "";
        var i = 0;

        for (i = 0; i < output.serpskeywords.length; i++) {

            htmlResult = htmlResult + "<tr>";
            htmlResult = htmlResult + "<td title='" + output.serpskeywords[i].Url + "'>" + output.serpskeywords[i].Url + "</td>";
            htmlResult = htmlResult + "<td>" + output.serpskeywords[i].Keyword + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].StartYahoo + "</td>";

            if ((output.serpskeywords[i].RankYahoo !== 0) || (output.serpskeywords[i].YahooUpdateDate == '-')) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahoo + "</td>";
            }
            else {
                htmlResult = htmlResult + "<td style='text-align: center;'>N/A</td>";
            }

            if ((output.serpskeywords[i].BestMatchRankYahoo !== 0) || (output.serpskeywords[i].YahooUpdateDate == '-')) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].BestMatchRankYahoo + "</td>";
            }
            else {
                htmlResult = htmlResult + "<td style='text-align: center;'>N/A</td>";
            }


            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahooDayChange + "";

            if (output.serpskeywords[i].RankYahooDayChange < 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
            }
            else if (output.serpskeywords[i].RankYahooDayChange > 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
            }
            htmlResult = htmlResult + "</td>";



            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahooWeekChange + "";

            if (output.serpskeywords[i].RankYahooWeekChange < 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
            }
            else if (output.serpskeywords[i].RankYahooWeekChange > 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
            }
            htmlResult = htmlResult + "</td>";



            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahooMonthChange + "";

            if (output.serpskeywords[i].RankYahooMonthChange < 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
            }
            else if (output.serpskeywords[i].RankYahooMonthChange > 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
            }
            htmlResult = htmlResult + "</td>";

            var life = output.serpskeywords[i].StartYahoo - output.serpskeywords[i].RankYahoo;

            htmlResult = htmlResult + "<td style='text-align: center;'>" + Math.abs(life) + "";

            if (life < 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
            }
            else if (life > 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
            }
            htmlResult = htmlResult + "</td>";

            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].YahooUpdateDate + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'><a href=\"javascript:drawChart(" + output.serpskeywords[i].KeywordID + ",30);\" id='yahoo_chart' title='Chart'><i class='fa fa-2x fa-bar-chart-o' data-toggle='modal' data-target='#chartmodal'></i></a></td>";
            htmlResult = htmlResult + "<tr>";
        }

        document.getElementById('yahooSerpsBody').innerHTML = document.getElementById('yahooSerpsBody').innerHTML + htmlResult;
    }

    //BingSerpsBody
    function updatebingSerpsBody(result) {

        var output = JSON.parse(result);
        var htmlResult = "";
        var i = 0;

        for (i = 0; i < output.serpskeywords.length; i++) {

            htmlResult = htmlResult + "<tr>";
            htmlResult = htmlResult + "<td title='" + output.serpskeywords[i].Url + "'>" + output.serpskeywords[i].Url + "</td>";
            htmlResult = htmlResult + "<td>" + output.serpskeywords[i].Keyword + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].StartBing + "</td>";

            if ((output.serpskeywords[i].RankBing !== 0) || (output.serpskeywords[i].BingUpdateDate == '-')) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankBing + "</td>";
            }
            else {
                htmlResult = htmlResult + "<td style='text-align: center;'>N/A</td>";
            }

            if ((output.serpskeywords[i].BestMatchRankBing !== 0) || (output.serpskeywords[i].BingUpdateDate == '-')) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].BestMatchRankBing + "</td>";
            }
            else {
                htmlResult = htmlResult + "<td style='text-align: center;'>N/A</td>";
            }


            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahooDayChange + "";

            if (output.serpskeywords[i].RankYahooDayChange < 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
            }
            else if (output.serpskeywords[i].RankYahooDayChange > 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
            }
            htmlResult = htmlResult + "</td>";



            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahooWeekChange + "";

            if (output.serpskeywords[i].RankYahooWeekChange < 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
            }
            else if (output.serpskeywords[i].RankYahooWeekChange > 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
            }
            htmlResult = htmlResult + "</td>";



            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahooMonthChange + "";

            if (output.serpskeywords[i].RankYahooMonthChange < 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
            }
            else if (output.serpskeywords[i].RankYahooMonthChange > 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
            }
            htmlResult = htmlResult + "</td>";

            var life = output.serpskeywords[i].StartBing - output.serpskeywords[i].RankBing;

            htmlResult = htmlResult + "<td style='text-align: center;'>" + Math.abs(life) + "";

            if (life < 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
            }
            else if (life > 0) {
                htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
            }
            htmlResult = htmlResult + "</td>";

            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].BingUpdateDate + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'><a href=\"javascript:drawChart(" + output.serpskeywords[i].KeywordID + ",30);\" id='bing_chart' title='Chart'><i class='fa fa-2x fa-bar-chart-o' data-toggle='modal' data-target='#chartmodal'></i></a></td>";
            htmlResult = htmlResult + "<tr>";
        }

        document.getElementById('bingSerpsBody').innerHTML = document.getElementById('bingSerpsBody').innerHTML + htmlResult;
    }

    //SEOKeywordsBody
    function updateseoKeywordsBody(result) {

        var output = JSON.parse(result);
        var htmlResult = "";
        var i = 0;

        for (i = 0; i < output.seokeywords.length; i++) {

            htmlResult = htmlResult + "<tr>";
            htmlResult = htmlResult + "<td title='" + output.seokeywords[i].Url + "'>" + output.seokeywords[i].Url + "</td>";
            htmlResult = htmlResult + "<td>" + output.seokeywords[i].Keyword + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].SearchVolume + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].GoogleCPC + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].KeywordCompetition + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].NumberofResult + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].SiteIndexing + "</td>";

            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].RankAlexa + "</td>";


            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].CountBackLinks + "</td>";

            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].CountMonthlySearches + "</td>";


            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].GooglePA + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].GoogleDA + "</td>";
            htmlResult = htmlResult + "<tr>";
        }

        document.getElementById('seoKeywordsBody').innerHTML = document.getElementById('seoKeywordsBody').innerHTML + htmlResult;
    }
</script>