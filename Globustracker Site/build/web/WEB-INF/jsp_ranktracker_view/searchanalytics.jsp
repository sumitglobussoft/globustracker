<%-- 
    Document   : searchanalytics
    Created on : Aug 11, 2015, 12:54:35 PM
    Author     : Ajeet
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<style>
    .m-top-xs{margin-top: 5px;}
    .bold{font-weight: 500;}
    .b-b2{border-bottom: 2px solid #3A3633;}
    .paddingLR-25{padding-left: 25px;padding-right: 25px;}
    .paddingLR-lg{padding-left: 40px;padding-right: 40px;}
    .m-left-lg{margin-left: 40px;}
    .border-light{border: 1px solid #ccc;}
    .btn.btn-grey{background-color: #3A3633;color: white;}
    .border-bottom-1{border-bottom: 1px solid #3A3633;}
    .loading{position: absolute;top: 30%;left: 27%;z-index: 100;}
    #well-content .well {min-height: auto;}
    #structuredatausage .well {max-height: 200px; overflow: auto;}
    .loading {
        left: 50% !important;
        top: 90% !important;
    }
</style>
<link href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css" rel="stylesheet"> 
<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="https://s3.amazonaws.com/js-globustracker/highcharts.js"></script>
<script src="https://s3.amazonaws.com/js-globustracker/exporting.js"></script>-->




<!--        <div class="col-sm-6 col-xs-offset-0 col-sm-offset-2">
            <div class="padding-10">
                <button class="btn btn-grey paddingLR-25" href="webmasterdata.htm">Click here to Authenticate</button>
            </div>
        </div>-->

<div class="loading hidden">
    <span><i class="fa fa-5x fa-spinner fa-spin"></i></span>
</div>
<div class="loading hidden" id="loading1">
    <span><i class="fa fa-5x fa-spinner fa-spin"></i></span>
</div>
<div class="loading hidden" id="Loading-Error-Count">
    <span><i class="fa fa-5x fa-spinner fa-spin"></i></span>
</div>
<div class="loading hidden" id="Loading-Error-Samples">
    <span><i class="fa fa-5x fa-spinner fa-spin"></i></span>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active">
        <a href="#search" aria-controls="search" role="tab" data-toggle="tab">Search Analytics</a>
    </li>
    <li role="presentation">
        <a href="#site" aria-controls="site" role="tab" data-toggle="tab">Sitemap</a>
    </li>
    <li role="presentation">
        <a href="#errorcount" aria-controls="errorcount" role="tab" data-toggle="tab">Crawl Error Count</a>
    </li>
    <li role="presentation">
        <a href="#errorsamples" aria-controls="errorsamples" role="tab" data-toggle="tab">Crawl URL Error</a>
    </li>
<!--    <li role="presentation">
        <a href="#pagespeed" aria-controls="pagespeed" role="tab" data-toggle="tab">Page Speed Analysis</a>
    </li>
    <li role="presentation">
        <a href="#mobileusage" aria-controls="mobileusage" role="tab" data-toggle="tab">Mobile Usability</a>
    </li>
    <li role="presentation">
        <a href="#structuredatausage" aria-controls="structuredatausage" role="tab" data-toggle="tab">Structured Data</a>
    </li>
    <li role="presentation">
        <a href="#robotchecker" aria-controls="robotchecker" role="tab" data-toggle="tab">Robot Checker</a>
    </li>-->
</ul>

<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="search">
        <div class="row" style="margin-top:3%;">
            <div class="col-sm-6">
                <form action="javascript:urllist();" id="site-data-details">
                    <div class="form-group" style="display: inline-flex;">
                        <div class="input-group col-xs-10">
                            <select id="urlID" class="form-control cus-select" name="domainName">
                                <option default value="">Select a Site to Display WebMaster Graph Analytics </option>
                                <c:forEach items="${sitelist}" var="objurl">
                                    <option value="${objurl}"><strong>${objurl}</strong></option>
                                    </c:forEach>
                            </select>
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </span>
                        </div>

                        <img style="display:none;" onload="show_login_status(1)" src="https://accounts.google.com/CheckCookie?continue=https%3A%2F%2Fwww.google.com%2Fintl%2Fen%2Fimages%2Flogos%2Faccounts_logo.png&followup=https%3A%2F%2Fwww.google.com%2Fintl%2Fen%2Fimages%2Flogos%2Faccounts_logo.png&chtml=LoginDoneHtml&checkedDomains=youtube&checkConnection=youtube%3A291%3A1"/> 
                        <div class="col-xs-2">
                            <a href="#" id="authorisation" data-toggle="tooltip" data-placement="bottom" title="Click to get fresh data from web master" class="btn btn-success" onclick="authoriseUnauthorise()">Authorise</a>
                        </div>
                    </div>
                </form>
            </div>

            <div class="col-sm-5">
                <div class="form-group text-center">

                </div>
            </div>
        </div>

        <div id="searchAnalysis"  style="display:none">
            <div class="row">
                <div class="col-md-12">
                    <div>
                        <h2 class="border-bottom-1 p-b-5 bold">Google's Search Analysis</h2>
                    </div>
                    <div id="chartLine1" style="min-width: 310px; height: 200px; margin: 0 auto"></div>
                </div>
            </div>

            <div class="row" >
                <div class="col-md-12">
                    <h2 class="bold">Top Queries</h2>
                </div>
                <div class="col-md-12">
                    <div class="table-responsive" style="margin-top: 50px;">
                        <table id="analyticsTable" class="table analyticsTable">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Query</th>
                                    <th>Clicks</th>
                                    <th>Impressions</th>
                                    <th>CTR</th>
                                    <th>Position</th>
                                </tr>
                            </thead>
                            <tbody id="query">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/highcharts.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/exporting.js"></script>-->
        <script>

            function show_login_status(a) {
                if (a === 1)
                {
                    document.getElementById("authorisation").textContent = "Unauthorise";
                }
            }
            function authoriseUnauthorise()
            {
                var x = document.getElementById("authorisation").textContent;

                if (x === 'Authorise')
                {
                    window.location = "refreshdata.action";
                    document.getElementById("authorisation").textContent = "Unauthorise";
                }
                else {
                    window.open('https://mail.google.com/mail/u/0/?logout&hl=en', '_blank');
                    document.getElementById("authorisation").textContent = "Authorise";
                }

            }
            function urllist() {
                //                var data = $('.analyticsTable').dataTable();
                $('.loading').removeClass("hidden");
                var jstring = $("#urlID").val();
                console.log(jstring);
                $.ajax({
                    type: "GET",
                    url: "sitedata.action",
                    data: $("#site-data-details").serialize(),
                    success: function (response) {

                        console.log(response);

                        var obj = JSON.parse(response);
//                        alert(obj.querylist.length);
                        if (obj.querylist.length > 0) {
                            $("#searchAnalysis").show();
                        } else {
                            $("#searchAnalysis").hide();
                        }
                        var i = 1;
                        var data = $('.analyticsTable').dataTable();
                        data.fnClearTable();
                        $.each(obj.querylist, function (index, objquery) {
                            data.fnAddData([i++, objquery.query, objquery.clicks, objquery.impression, objquery.ctr + "%", objquery.position]);
                        });
                        $('.loading').addClass("hidden");
                        //                     web masters graph data 
                        console.log(obj.graphlist);
                        var clicksArray = [];
                        var impressionsArray = [];
                        var CTRArray = [];
                        var positionArray = [];
                        var dateArray = [];
                        var datetimeSplit = "";

                        for (index in obj.graphlist) {
                            clicksArray.push(obj.graphlist[index]["clicks"]);
                            impressionsArray.push(obj.graphlist[index]["impression"]);
                            CTRArray.push(obj.graphlist[index]["ctr"]);
                            positionArray.push(obj.graphlist[index]["position"]);
                            dateArray.push(obj.graphlist[index]["datestring"]);
                        }
                        try {
                            console.log(dateArray[0]);
                            datetimeSplit = dateArray[0].split("-");
                        } catch (e) {
                            console.log(e);
                        }

                        var month = datetimeSplit[1] - 1;
                        console.log(month);

                        $('#chartLine1').highcharts({
                            title: {
                                text: '',
                                x: -20 //center
                            },
                            subtitle: {
                                text: '',
                                x: -20
                            },
                            xAxis: {
                                type: 'datetime',
                                maxZoom: 24 * 3600 * 1000
                            },
                            yAxis: {
                                title: {
                                    text: ''
                                },
                                plotLines: [{
                                        value: 0,
                                        width: 1,
                                        color: '#808080'
                                    }]
                            },
                            tooltip: {
                                valueSuffix: ''
                            },
                            legend: {
                                enabled: false,
                                align: 'center',
                                borderWidth: 0
                            },
                            exporting: {enabled: false},
                            credits: {enabled: false},
                            series: [{
                                    name: 'Clicks',
                                    data: clicksArray,
                                    pointStart: Date.UTC(datetimeSplit[0], month, datetimeSplit[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                },
                                {
                                    name: 'Impressions',
                                    data: impressionsArray,
                                    pointStart: Date.UTC(datetimeSplit[0], month, datetimeSplit[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                },
                                {
                                    name: 'CTR',
                                    data: CTRArray,
                                    pointStart: Date.UTC(datetimeSplit[0], month, datetimeSplit[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                },
                                {
                                    name: 'Position',
                                    data: positionArray,
                                    pointStart: Date.UTC(datetimeSplit[0], month, datetimeSplit[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                }]
                        });
                    },
                    error: function (data) {
                        console.log(data);
                        $("#searchAnalysis").hide();
                    }
                });
            }
            //            $(document).ready(function () {

            $(function () {
                $('#chartLine1').highcharts({
                    title: {
                        text: '',
                        x: -20 //center
                    },
                    subtitle: {
                        text: '',
                        x: -20
                    },
                    xAxis: {
                        type: 'datetime',
                        maxZoom: 48 * 3600 * 1000
                    },
                    yAxis: {
                        title: {
                            text: ''
                        },
                        plotLines: [{
                                value: 0,
                                width: 1,
                                color: '#808080'
                            }]
                    },
                    tooltip: {
                        valueSuffix: ''
                    },
                    legend: {
                        enabled: false,
                        align: 'center',
                        borderWidth: 0
                    },
                    exporting: {enabled: false},
                    credits: {enabled: false},
                    series: [{
                            name: 'Clicks',
                            data: [],
                            pointStart: Date.UTC(2015, 0, 1),
                            pointInterval: 24 * 3600 * 1000 // one day
                        },
                        {
                            name: 'Impressions',
                            data: [],
                            pointStart: Date.UTC(2015, 0, 1),
                            pointInterval: 24 * 3600 * 1000 // one day
                        },
                        {
                            name: 'CTR',
                            data: [],
                            pointStart: Date.UTC(2015, 0, 1),
                            pointInterval: 24 * 3600 * 1000 // one day
                        },
                        {
                            name: 'Position',
                            data: [],
                            pointStart: Date.UTC(2015, 0, 1),
                            pointInterval: 24 * 3600 * 1000 // one day
                        }]
                });
            });
            //        });

        </script>

        <script>
            $(document).ready(function () {
                $('.analyticsTable').dataTable();
            });
        </script>
    </div>
    <div role="tabpanel" class="tab-pane" id="site">
        <div class="row" style="margin-top: 3%;">
            <div class="col-sm-6">
                <form action="javascript:urllist1();">
                    <div class="form-group">
                        <div class="input-group col-xs-12">
                            <select id="urlID1" class="form-control cus-select">
                                <option default value="">Select a Site to Display WebMaster Sitemap</option>
                                <c:forEach items="${sitelist}" var="objurl">
                                    <option value="${objurl}"><strong>${objurl}</strong></option>
                                    </c:forEach>
                            </select>
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div id="searchAnalysis1"  style="display:none">
            <div class="row">
                <div class="col-md-12">
                    <div>
                        <h2 class="border-bottom-1 p-b-5 bold">Webmaster Tools Sitemap</h2>
                    </div>
                    <div id="chartLine2" style="min-width: 310px; height: 200px; margin: 0 auto"></div>
                </div>
            </div>

            <div class="row" >
                <div class="col-md-12">
                    <h2 class="bold">Top Queries</h2>
                </div>
                <div class="col-md-12">
                    <div class="table-responsive" style="margin-top: 50px;">
                        <table id="analyticsTable1" class="table analyticsTable">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Sitemap</th>
                                    <th>Type</th>
                                    <th>Processed</th>
                                    <th>Issues</th>
                                    <th>Items</th>
                                    <th>Submitted</th>
                                    <th>Indexed</th>
                                </tr>
                            </thead>
                            <tbody id="query">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>


        <!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/highcharts.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/exporting.js"></script>-->
        <script>

            function urllist1() {
                //                var data = $('.analyticsTable').dataTable();
                $('#loading1').removeClass("hidden");
                var jstring = $("#urlID1").val();
                $.ajax({
                    type: "Get",
                    url: "sitemapdata.action",
                    data: {
                        domain: jstring
                    },
                    success: function (response) {
                        console.log("--------- RESPONSE --------- : " + response);

                        var obj = JSON.parse(response);

                        if (obj.sitemaplist.length > 0) {
                            $("#searchAnalysis1").show();
                        } else {
                            $("#searchAnalysis1").hide();
                        }

                        console.log(obj);
//                        var id = obj.sitemaplist[0].id;
//                        var lastsubmitted = obj.sitemaplist[0].lastsubmitteddate;
//                        var error = obj.sitemaplist[0].errors;
//                        var lastdownloaded = obj.sitemaplist[0].lastdownloadeddate;
//                        var indexed = obj.sitemaplist[0].indexed;
//                        var submitted = obj.sitemaplist[0].submitted;
//                        var path = obj.sitemaplist[0].path;
//                        var type = obj.sitemaplist[0].type;
//                        var warning = obj.sitemaplist[0].warning;
//                        var typemap = obj.sitemaplist[0].typemap;

//                        console.log("ID              : " + id);
//                        console.log("Last Submitted  : " + lastsubmitted);
//                        console.log("Errors          : " + error);
//                        console.log("Last Downloaded : " + lastdownloaded);
//                        console.log("Indexed         : " + indexed);
//                        console.log("Submitted       : " + submitted);
//                        console.log("Path            : " + path);
//                        console.log("Type            : " + type);
//                        console.log("Warning         : " + warning);
//                        console.log("Type Map        : " + typemap);

                        var i = 1;
                        var data = $('#analyticsTable1').dataTable();
                        data.fnClearTable();
                        $.each(obj.sitemaplist, function (index, objquery) {
                            data.fnAddData([i++, objquery.path, objquery.typemap, objquery.lastdownloadeddate, objquery.warning + " warnings ", objquery.type, objquery.submitted, objquery.indexed]);
                        });
                        $('#loading1').addClass("hidden");
                        //                     web masters graph data 
//                                        console.log(obj.sitemapList);
                        var indexedArray = [];
                        var submittedArray = [];
                        var lastsubmittedArray = [];
                        var lastdownloadedArray = [];
                        var datetimeSplit = '';
                        var datetimeSplit1 = '';
                        for (var index in obj.sitemaplist) {
                            indexedArray.push(obj.sitemaplist[index]["indexed"]);
                            submittedArray.push(obj.sitemaplist[index]["submitted"]);
                            lastsubmittedArray.push(obj.sitemaplist[index]["lastsubmitteddate"]);
                            lastdownloadedArray.push(obj.sitemaplist[index]["lastdownloadeddate"]);

                        }
//                        try {
//                            console.log(lastsubmittedArray[0]);
//                            datetimeSplit = lastsubmittedArray[0].split("-");
//                            var myDate = new Date(datetimeSplit[1] + " 1, 2000");
//                            var monthDigit = myDate.getMonth();
//                            datetimeSplit1 = lastdownloadedArray[0].split("-");
//                            var myDate1 = new Date(datetimeSplit1[1] + " 1, 2000");
//                            var monthDigit1 = myDate.getMonth();
//                        } catch (e) {
//                            console.log(e);
//                        }
//
//                        var month = monthDigit - 1;
//                                        console.log(month);

                        try {
                            datetimeSplit = lastsubmittedArray[0].split("-");
                            datetimeSplit1 = lastdownloadedArray[0].split("-");
                        } catch (e) {
                            console.log(e);
                        }

                        var month = datetimeSplit[1] - 1;
                        var month1 = datetimeSplit1[1] - 1;
                        console.log(month);

                        $('#chartLine2').highcharts({
                            title: {
                                text: '',
                                x: -20 //center
                            },
                            subtitle: {
                                text: '',
                                x: -20
                            },
                            xAxis: {
                                type: 'datetime',
                                maxZoom: 24 * 3600 * 1000
                            },
                            yAxis: {
                                title: {
                                    text: ''
                                },
                                plotLines: [{
                                        value: 0,
                                        width: 1,
                                        color: '#808080'
                                    }]
                            },
                            tooltip: {
                                valueSuffix: ''
                            },
                            legend: {
                                enabled: false,
                                align: 'center',
                                borderWidth: 0
                            },
                            exporting: {enabled: false},
                            credits: {enabled: false},
                            series: [{
                                    name: 'Indexed',
                                    data: indexedArray,
                                    pointStart: Date.UTC(datetimeSplit[0], month, datetimeSplit[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                },
                                {
                                    name: 'Submitted',
                                    data: submittedArray,
                                    pointStart: Date.UTC(datetimeSplit1[0], month1, datetimeSplit1[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                }]
                        });
                    },
                    error: function (data) {
                        console.log(data);
                        $("#searchAnalysis1").hide();
                    }
                });
            }

            $(document).ready(function () {

                $(function () {
                    $('#chartLine2').highcharts({
                        title: {
                            text: '',
                            x: -20 //center
                        },
                        subtitle: {
                            text: '',
                            x: -20
                        },
                        xAxis: {
                            type: 'datetime',
                            maxZoom: 48 * 3600 * 1000
                        },
                        yAxis: {
                            title: {
                                text: ''
                            },
                            plotLines: [{
                                    value: 0,
                                    width: 1,
                                    color: '#808080'
                                }]
                        },
                        tooltip: {
                            valueSuffix: ''
                        },
                        legend: {
                            enabled: false,
                            align: 'center',
                            borderWidth: 0
                        },
                        exporting: {enabled: false},
                        credits: {enabled: false},
                        series: [{
                                name: 'Indexed',
                                data: [],
                                pointStart: Date.UTC(2015, 0, 1),
                                pointInterval: 24 * 3600 * 1000 // one day
                            },
                            {
                                name: 'Submitted',
                                data: [],
                                pointStart: Date.UTC(2015, 0, 1),
                                pointInterval: 24 * 3600 * 1000 // one day
                            }]
                    });
                });
            });

        </script>

        <script>
            $(document).ready(function () {
                $('.analyticsTable1').dataTable();
            });
        </script>
    </div>
    <!--*******************Crawl Error Count Data***************************-->

    <div role="tabpanel" class="tab-pane" id="errorcount">
        <div class="row" style="margin-top: 3%;">
            <div class="col-sm-6">
                <form action="javascript:urllist2();">
                    <div class="form-group">
                        <div class="input-group col-xs-12">
                            <select id="urlID2" class="form-control cus-select">
                                <option default value="">Select a Site to Display WebMaster Crawl Error Count </option>
                                <c:forEach items="${sitelist}" var="objurl">
                                    <option value="${objurl}"><strong>${objurl}</strong></option>
                                    </c:forEach>
                            </select>
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div id="searchAnalysis2" style="display:none">
            <div class="row">
                <div class="col-md-12">
                    <div>
                        <h2 class="border-bottom-1 p-b-5 bold">Webmaster Tools Crawl Errors</h2>
                    </div>
                    <div id="chartLine3" style="min-width: 310px; height: 200px; margin: 0 auto"></div>
                </div>
            </div>

            <div class="row" >
                <div class="col-md-12">
                    <h2 class="bold">Top Queries</h2>
                </div>
                <div class="col-md-12">
                    <div class="table-responsive" style="margin-top: 50px;">
                        <table id="analytics-Table-Error-Count" class="table analyticsTable">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Site URL</th>
                                    <th>Platform</th>
                                    <th>Category</th>
                                    <th>Count</th>
                                    <th>Detected Code</th>
                                </tr>
                            </thead>
                            <tbody id="query">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>


        <!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/highcharts.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/exporting.js"></script>-->
        <script>

            function urllist2() {
                //                var data = $('.analyticsTable').dataTable();
                $('#Loading-Error-Count').removeClass("hidden");
                var jstring = $("#urlID2").val();
                $.ajax({
                    type: "Get",
                    url: "crawlerrorcountdata.action",
                    data: {
                        domain: jstring
                    },
                    success: function (response) {
                        console.log("--------- RESPONSE --------- : " + response);

                        var obj = JSON.parse(response);
//                        console.log(obj);
                        if (obj.errorcountlist.length > 0) {
                            $("#searchAnalysis2").show();
                        } else {
                            $("#searchAnalysis2").hide();
                        }
//                        
//                        var id = obj.errorcountlist[0].id;
//                        var siteurl = obj.errorcountlist[0].siteurl;
//                        var platform = obj.errorcountlist[0].platform;
//                        var category = obj.errorcountlist[0].category;
//                        var count = obj.errorcountlist[0].count;
//                        var datestring = obj.errorcountlist[0].datestring;


//                        console.log("ID          : " + id);
//                        console.log("Siteurl     : " + siteurl);
//                        console.log("Platform    : " + platform);
//                        console.log("Category    : " + category);
//                        console.log("Count       : " + count);
//                        console.log("Datestring  : " + datestring);

                        var i = 1;
                        var data = $('#analytics-Table-Error-Count').dataTable();
                        data.fnClearTable();
                        $.each(obj.errorcountlist, function (index, objquery) {
                            data.fnAddData([i++, objquery.siteurl, objquery.platform, objquery.category, objquery.count, objquery.datestring]);
                        });
                        $('#Loading-Error-Count').addClass("hidden");
                        //                     web masters graph data 
                        console.log(obj.errorcountlist);
                        var platformArray = [];
                        var categoryArray = [];
                        var countArray = [];
                        var datestringArray = [];
                        var datetimeSplit = '';
//                        var datetimeSplit1 = '';
                        for (var index in obj.errorcountlist) {
                            platformArray.push(obj.errorcountlist[index]["platform"]);
                            categoryArray.push(obj.errorcountlist[index]["category"]);
                            countArray.push(obj.errorcountlist[index]["count"]);
                            datestringArray.push(obj.errorcountlist[index]["datestring"]);

                        }

                        try {
                            datetimeSplit = datestringArray[0].split("-");
//                            datetimeSplit1 = lastdownloadedArray[0].split("-");
                        } catch (e) {
                            console.log(e);
                        }
//
                        var month = datetimeSplit[1] - 1;
//                         var month1 = datetimeSplit1[1] - 1;
                        console.log(month);

                        $('#chartLine3').highcharts({
                            title: {
                                text: '',
                                x: -20 //center
                            },
                            subtitle: {
                                text: '',
                                x: -20
                            },
                            xAxis: {
                                type: 'datetime',
                                maxZoom: 24 * 3600 * 1000
                            },
                            yAxis: {
                                title: {
                                    text: ''
                                },
                                plotLines: [{
                                        value: 0,
                                        width: 1,
                                        color: '#808080'
                                    }]
                            },
                            tooltip: {
                                valueSuffix: ''
                            },
                            legend: {
                                enabled: false,
                                align: 'center',
                                borderWidth: 0
                            },
                            exporting: {enabled: false},
                            credits: {enabled: false},
                            series: [{
                                    name: 'Platform',
                                    data: platformArray,
                                    pointStart: Date.UTC(datetimeSplit[0], month, datetimeSplit[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                },
                                {
                                    name: 'Category',
                                    data: categoryArray,
                                    pointStart: Date.UTC(datetimeSplit[0], month, datetimeSplit[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                },
                                {
                                    name: 'Count',
                                    data: countArray,
                                    pointStart: Date.UTC(datetimeSplit[0], month, datetimeSplit[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                },
                                {
                                    name: 'Datestring',
                                    data: datestringArray,
                                    pointStart: Date.UTC(datetimeSplit[0], month, datetimeSplit[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                }]
                        });
                    },
                    error: function (data) {
                        console.log(data);
                        $("#searchAnalysis2").hide();
                    }
                });
            }

            $(document).ready(function () {

                $(function () {
                    $('#chartLine3').highcharts({
                        title: {
                            text: '',
                            x: -20 //center
                        },
                        subtitle: {
                            text: '',
                            x: -20
                        },
                        xAxis: {
                            type: 'datetime',
                            maxZoom: 48 * 3600 * 1000
                        },
                        yAxis: {
                            title: {
                                text: ''
                            },
                            plotLines: [{
                                    value: 0,
                                    width: 1,
                                    color: '#808080'
                                }]
                        },
                        tooltip: {
                            valueSuffix: ''
                        },
                        legend: {
                            enabled: false,
                            align: 'center',
                            borderWidth: 0
                        },
                        exporting: {enabled: false},
                        credits: {enabled: false},
                        series: [{
                                name: 'Platform',
                                data: [],
                                pointStart: Date.UTC(2015, 0, 1),
                                pointInterval: 24 * 3600 * 1000 // one day
                            },
                            {
                                name: 'Category',
                                data: [],
                                pointStart: Date.UTC(2015, 0, 1),
                                pointInterval: 24 * 3600 * 1000 // one day
                            },
                            {
                                name: 'Count',
                                data: [],
                                pointStart: Date.UTC(2015, 0, 1),
                                pointInterval: 24 * 3600 * 1000 // one day
                            },
                            {
                                name: 'Datestring',
                                data: [],
                                pointStart: Date.UTC(2015, 0, 1),
                                pointInterval: 24 * 3600 * 1000 // one day
                            }]
                    });
                });
            });

        </script>

        <script>
            $(document).ready(function () {
                $('.analytics-Table-Error-Count').dataTable();
            });
        </script>
    </div>
    <!--*******************Crawl Error Samples Data***************************-->
    <div role="tabpanel" class="tab-pane" id="errorsamples">
        <div class="row" style="margin-top: 3%;">
            <div class="col-sm-6">
                <form action="javascript:urllist3();">
                    <div class="form-group">
                        <div class="input-group col-xs-12">
                            <select id="urlID3" class="form-control cus-select">
                                <option default value="">Select a Site to Display WebMaster Crawl Errors Samples </option>
                                <c:forEach items="${sitelist}" var="objurl">
                                    <option value="${objurl}"><strong>${objurl}</strong></option>
                                    </c:forEach>
                            </select>
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div id="searchAnalysis3" style="display:none">
            <div class="row">
                <div class="col-md-12">
                    <div>
                        <h2 class="border-bottom-1 p-b-5 bold">Webmaster Tools Crawl URL Errors</h2>
                    </div>
                    <div id="chartLine4" style="min-width: 310px; height: 200px; margin: 0 auto"></div>
                </div>
            </div>

            <div class="row" >
                <div class="col-md-12">
                    <h2 class="bold">Top Queries</h2>
                </div>
                <div class="col-md-12">
                    <div class="table-responsive" style="margin-top: 50px;">
                        <table id="analytics-Table-Error-Samples" class="table analyticsTable">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Site URL</th>
                                    <th>Page URL</th>
                                    <th>First Detected</th>
                                    <th>Last Detected</th>
                                    <th>Response Code</th>
                                </tr>
                            </thead>
                            <tbody id="query">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>


        <!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/highcharts.js"></script>
        <script src="https://s3.amazonaws.com/js-globustracker/exporting.js"></script>-->
        <script>

            function urllist3() {
                //                var data = $('.analyticsTable').dataTable();
                $('#Loading-Error-Samples').removeClass("hidden");
                var jstring = $("#urlID3").val();
                $.ajax({
                    type: "Get",
                    url: "crawlerrorsamplesdata.action",
                    data: {
                        domain: jstring
                    },
                    success: function (response) {
                        console.log("--------- RESPONSE --------- : " + response);

                        var obj = JSON.parse(response);
//                        console.log(obj);

                        if (obj.errorsampleslist.length > 0) {
                            $("#searchAnalysis3").show();
                        } else {
                            $("#searchAnalysis3").hide();
                        }

//                        var id = obj.errorsampleslist[0].id;
//                        var siteurl = obj.errorsampleslist[0].siteurl;
//                        var pageurl = obj.errorsampleslist[0].pageurl;
//                        var firstdetected = obj.errorsampleslist[0].firstdetected;
//                        var lastcrawled = obj.errorsampleslist[0].lastcrawled;
//                        var responsecode = obj.errorsampleslist[0].responsecode;
//                        var pageurlsize = obj.pageurlsize;
//
//                        console.log("ID             : " + id);
//                        console.log("Siteurl        : " + siteurl);
//                        console.log("Page URL       : " + pageurl);
//                        console.log("First Detected : " + firstdetected);
//                        console.log("Last Detected  : " + lastcrawled);
//                        console.log("Response Code  : " + responsecode);
//                        console.log("Page Size      : " + pageurlsize);

                        var i = 1;
                        var data = $('#analytics-Table-Error-Samples').dataTable();
                        data.fnClearTable();
                        $.each(obj.errorsampleslist, function (index, objquery) {
                            data.fnAddData([i++, objquery.siteurl, objquery.pageurl, objquery.firstdetected, objquery.lastcrawled, objquery.responsecode]);
                        });
                        $('#Loading-Error-Samples').addClass("hidden");
                        //                     web masters graph data 
                        console.log(obj.errorsampleslist);
                        var pageurlArray = [];
                        var firstdetectedArray = [];
                        var lastcrawledArray = [];
                        var responsecodeArray = [];
                        var pageurlsizeArray = [];
                        var datetimeSplit = '';
                        var datetimeSplit1 = '';
                        for (var index in obj.errorsampleslist) {
                            pageurlArray.push(obj.errorsampleslist[index]["pageurl"]);
                            firstdetectedArray.push(obj.errorsampleslist[index]["firstdetected"]);
                            lastcrawledArray.push(obj.errorsampleslist[index]["lastcrawled"]);
                            responsecodeArray.push(obj.errorsampleslist[index]["responsecode"]);
                            pageurlsizeArray.push(obj.errorsampleslist[index]["pageurlsize"]);

                        }

                        try {
                            datetimeSplit = firstdetectedArray[0].split("-");
//                            datetimeSplit1 = lastcrawledArray[0].split("-");
                        } catch (e) {
                            console.log(e);
                        }
//
                        var month = datetimeSplit[1] - 1;
//                        var month1 = datetimeSplit1[1] - 1;
//                        console.log(month);

                        $('#chartLine4').highcharts({
                            title: {
                                text: '',
                                x: -20 //center
                            },
                            subtitle: {
                                text: '',
                                x: -20
                            },
                            xAxis: {
                                type: 'datetime',
                                maxZoom: 24 * 3600 * 1000
                            },
                            yAxis: {
                                title: {
                                    text: ''
                                },
                                plotLines: [{
                                        value: 0,
                                        width: 1,
                                        color: '#808080'
                                    }]
                            },
                            tooltip: {
                                valueSuffix: ''
                            },
                            legend: {
                                enabled: false,
                                align: 'center',
                                borderWidth: 0
                            },
                            exporting: {enabled: false},
                            credits: {enabled: false},
                            series: [{
                                    name: 'Page Url',
                                    data: pageurlsizeArray,
                                    pointStart: Date.UTC(datetimeSplit[0], month, datetimeSplit[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                },
                                {
                                    name: 'First Detected',
                                    data: firstdetectedArray,
                                    pointStart: Date.UTC(datetimeSplit[0], month, datetimeSplit[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                },
                                {
                                    name: 'Last Detected',
                                    data: lastcrawledArray,
                                    pointStart: Date.UTC(datetimeSplit[0], month, datetimeSplit[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                },
                                {
                                    name: 'Response Code',
                                    data: responsecodeArray,
                                    pointStart: Date.UTC(datetimeSplit[0], month, datetimeSplit[2]),
                                    pointInterval: 24 * 3600 * 1000 // one day
                                }
                            ]
                        });
                    },
                    error: function (data) {
                        console.log(data);
                        $("#searchAnalysis3").hide();
                    }
                });
            }

            $(document).ready(function () {

                $(function () {
                    $('#chartLine4').highcharts({
                        title: {
                            text: '',
                            x: -20 //center
                        },
                        subtitle: {
                            text: '',
                            x: -20
                        },
                        xAxis: {
                            type: 'datetime',
                            maxZoom: 48 * 3600 * 1000
                        },
                        yAxis: {
                            title: {
                                text: ''
                            },
                            plotLines: [{
                                    value: 0,
                                    width: 1,
                                    color: '#808080'
                                }]
                        },
                        tooltip: {
                            valueSuffix: ''
                        },
                        legend: {
                            enabled: false,
                            align: 'center',
                            borderWidth: 0
                        },
                        exporting: {enabled: false},
                        credits: {enabled: false},
                        series: [{
                                name: 'Page Url',
                                data: [],
                                pointStart: Date.UTC(2015, 0, 1),
                                pointInterval: 24 * 3600 * 1000 // one day
                            },
                            {
                                name: 'First Detected',
                                data: [],
                                pointStart: Date.UTC(2015, 0, 1),
                                pointInterval: 24 * 3600 * 1000 // one day
                            },
                            {
                                name: 'Last Detected',
                                data: [],
                                pointStart: Date.UTC(2015, 0, 1),
                                pointInterval: 24 * 3600 * 1000 // one day
                            },
                            {
                                name: 'Response Code',
                                data: [],
                                pointStart: Date.UTC(2015, 0, 1),
                                pointInterval: 24 * 3600 * 1000 // one day
                            }]
                    });
                });
            });

        </script>

        <script>
            $(document).ready(function () {
                $('.analytics-Table-Error-Samples').dataTable();
            });
        </script>
    </div>

    <!--*******************Page Speed Data***************************-->
    <div role="tabpanel" class="tab-pane" id="pagespeed">
        <style>
            #result-table	{
                visibility: hidden;
            }

            #result-table .well	{
                min-height: 250px;
                max-height: 250px;
                margin: 1%;
            }

            ul, ol {
                text-align: left;
            }

            #score > img {
                width: 50%;
            }
        </style>

        <div class="row">
            <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
                <h1 class="page-title txt-color-blueDark">
                    <i class="fa fa-bolt fa-fw "></i>
                    Webmaster Tools
                    <span>
                        Speed Analysis
                    </span>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center">
                <h1><b>Web Page Speed Test Tool</b></h1><hr /><br />
                <form action="#" id="formSubmit" class="form-inline" onsubmit="return getPageSpeedResults()">
                    <input type="url" name="url" class="form-control" style="width: 70%;" required="true" id="url_field" />
                    <input type="submit" class="btn btn-primary" value="GO" />
                </form>
            </div><br/>

            <div class="col-md-12 text-center">
                <span id="loading"></span>
            </div>

            <div class="col-md-12 text-center" id="result-table">
                <div class="row">
                    <div class="col-md-5 well" style="margin-left: 8%;">
                        <h3>Page Speed Score</h3>
                        <span id="score" class="dyna"></span>
                    </div>
                    <div class="col-md-5 well">
                        <h3>Page Code Analysis</h3>
                        <span id="code" class="dyna"></span>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5 well" style="margin-left: 8%;">
                        <h3>Page Optimization Suggestions</h3>
                        <span id="suggestions" class="dyna"></span>
                    </div>
                    <div class="col-md-5 well">
                        <h3>Page Stats</h3>
                        <div id="page-stats" style="max-height: 150px;overflow-y: scroll;" class="dyna"></div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5 well" style="margin-left: 8%;">
                        <h3>Avoid landing page redirects</h3>
                        <div id="AvoidLandingPageRedirects" class="dyna"></div>
                    </div>
                    <div class="col-md-5 well">
                        <h3>Enable compression</h3>
                        <div id="EnableGzipCompression" style="max-height: 150px;overflow-y: scroll;" class="dyna"></div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5 well" style="margin-left: 8%;">
                        <h3>Leverage browser caching</h3>
                        <div id="LeverageBrowserCaching" style="max-height: 150px;overflow-y: scroll;" class="dyna"></div>
                    </div>
                    <div class="col-md-5 well">
                        <h3>Minify HTML</h3>
                        <div id="MinifyHTML" style="max-height: 150px;overflow-y: scroll;" class="dyna"></div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5 well" style="margin-left: 8%;">
                        <h3>Minify JavaScript</h3>
                        <div id="MinifyJavaScript" style="max-height: 150px;overflow-y: scroll;" class="dyna"></div>
                    </div>
                    <div class="col-md-5 well">
                        <h3>Minify CSS</h3>
                        <div id="MinifyCss" style="max-height: 150px;overflow-y: scroll;" class="dyna"></div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5 well" style="margin-left: 8%;">
                        <h3>Prioritize visible content</h3>
                        <div id="PrioritizeVisibleContent" style="max-height: 150px;overflow-y: scroll;" class="dyna"></div>
                    </div>
                    <div class="col-md-5 well">
                        <h3>Reduce Server Response Time</h3>
                        <div id="MainResourceServerResponseTime" style="max-height: 150px;overflow-y: scroll;" class="dyna"></div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5 well" style="margin-left: 8%;">
                        <h3>Optimize Images</h3>
                        <div id="OptimizeImages" style="max-height: 150px;overflow-y: scroll;" class="dyna"></div>
                    </div>
                    <div class="col-md-5 well">
                        <h3>Minimize Render Blocking Resources</h3>
                        <div id="MinimizeRenderBlockingResources" style="max-height: 150px;overflow-y: scroll;" class="dyna"></div>
                    </div>
                </div>
            </div>
        </div>

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
                        $('.dyna').empty();
                        $('#result-table').css('visibility', 'hidden');
                    },
                    success: function (data) {
                        $('#loading').text('');
                        var result = JSON.parse(data);
                        $('#result-table').css('visibility', 'visible');
                        displayPageSpeedScore(result);
                        displayTopPageSpeedSuggestions(result);
                        displayResourceSizeBreakdown(result);
                        try {
                            showPageStats(result);
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
                var html = "<p>Rule Impact : " + (parseFloat(result.formattedResults.ruleResults.AvoidLandingPageRedirects.ruleImpact)).toFixed(2) + "</p>";

                for (var i = 0; i < result.formattedResults.ruleResults.AvoidLandingPageRedirects.urlBlocks.length; i++) {
                    var block = result.formattedResults.ruleResults.AvoidLandingPageRedirects.urlBlocks[i];

                    for (var j = 0; j < block.header.args.length; j++) {
                        var arg = block.header.args[j];
                        console.log('       type : ' + arg.type);
                        console.log('       value : ' + arg.value);
                        html = html + "<ul><li><b>Type:</b> " + arg.type + " <b><br>Value:</b> " + arg.value + "</li></ul>";
                    }
                    console.log('   format : ' + block.header.format);
                }
                $('#AvoidLandingPageRedirects').append(html);
            }

            function showEnableGzipCompression(result) {

                console.log('EnableGzipCompression');
                console.log('urlBlocks');
                var html = "<p>Rule Impact : " + (parseFloat(result.formattedResults.ruleResults.EnableGzipCompression.ruleImpact)).toFixed(2) + "</p>";
                var block = result.formattedResults.ruleResults.EnableGzipCompression.urlBlocks[1];

                for (var j = 0; j < block.urls.length; j++) {

                    var url = block.urls[j];

                    for (var k = 0; k < url.result.args.length; k++) {
                        var arg = url.result.args[k];
                        console.log('       type : ' + arg.type);
                        console.log('       value : ' + arg.value);
                        html = html + "<ul><li><b>Type:</b> " + arg.type + " <b><br>Value:</b> " + arg.value + "</li></ul>";
                    }
                }

                $('#EnableGzipCompression').append(html);

            }

            function showLeverageBrowserCaching(result) {

                console.log('LeverageBrowserCaching');
                console.log('urlBlocks');
                var html = "<p>Rule Impact : " + (parseFloat(result.formattedResults.ruleResults.LeverageBrowserCaching.ruleImpact)).toFixed(2) + "</p>";
                var block = result.formattedResults.ruleResults.LeverageBrowserCaching.urlBlocks[1];

                for (var j = 0; j < block.urls.length; j++) {

                    var url = block.urls[j];

                    for (var k = 0; k < url.result.args.length; k++) {
                        var arg = url.result.args[k];
                        console.log('       type : ' + arg.type);
                        console.log('       value : ' + arg.value);
                        html = html + "<ul><li><b>Type:</b> " + arg.type + " <b><br>Value:</b> " + arg.value + "</li></ul>";
                    }
                }
                $('#LeverageBrowserCaching').append(html);
            }

            function showMinifyHTML(result) {

                console.log('MinifyHTML');
                console.log('urlBlocks');
                var html = "<p>Rule Impact : " + (parseFloat(result.formattedResults.ruleResults.MinifyHTML.ruleImpact)).toFixed(2) + "</p>";
                var block = result.formattedResults.ruleResults.MinifyHTML.urlBlocks[1];

                for (var j = 0; j < block.urls.length; j++) {

                    var url = block.urls[j];

                    for (var k = 0; k < url.result.args.length; k++) {
                        var arg = url.result.args[k];
                        console.log('       type : ' + arg.type);
                        console.log('       value : ' + arg.value);
                        html = html + "<ul><li><b>Type:</b> " + arg.type + " <b><br>Value:</b> " + arg.value + "</li></ul>";
                    }
                }
                $('#MinifyHTML').append(html);
            }

            function showMinifyJavaScript(result) {

                console.log('MinifyJavaScript');
                console.log('urlBlocks');
                var html = "<p>Rule Impact : " + (parseFloat(result.formattedResults.ruleResults.MinifyJavaScript.ruleImpact)).toFixed(2) + "</p>";
                var block = result.formattedResults.ruleResults.MinifyJavaScript.urlBlocks[1];

                for (var j = 0; j < block.urls.length; j++) {

                    var url = block.urls[j];

                    for (var k = 0; k < url.result.args.length; k++) {
                        var arg = url.result.args[k];
                        console.log('       type : ' + arg.type);
                        console.log('       value : ' + arg.value);
                        html = html + "<ul><li><b>Type:</b> " + arg.type + " <b><br>Value:</b> " + arg.value + "</li></ul>";
                    }
                }
                $('#MinifyJavaScript').append(html);
            }

            function showMinifyCss(result) {

                console.log('MinifyCss');
                console.log('urlBlocks');
                var html = "<p>Rule Impact : " + (parseFloat(result.formattedResults.ruleResults.MinifyCss.ruleImpact)).toFixed(2) + "</p>";
                var block = result.formattedResults.ruleResults.MinifyCss.urlBlocks[1];

                for (var j = 0; j < block.urls.length; j++) {

                    var url = block.urls[j];

                    for (var k = 0; k < url.result.args.length; k++) {
                        var arg = url.result.args[k];
                        console.log('       type : ' + arg.type);
                        console.log('       value : ' + arg.value);
                        html = html + "<ul><li><b>Type:</b> " + arg.type + " <b><br>Value:</b> " + arg.value + "</li></ul>";
                    }
                }
                $('#MinifyCss').append(html);
            }

            function showPrioritizeVisibleContent(result) {

                console.log('PrioritizeVisibleContent');
                console.log('urlBlocks');
                var html = "<p>Rule Impact : " + (parseFloat(result.formattedResults.ruleResults.PrioritizeVisibleContent.ruleImpact)).toFixed(2) + "</p>";
                var block = result.formattedResults.ruleResults.PrioritizeVisibleContent.urlBlocks[1];

                for (var j = 0; j < block.urls.length; j++) {

                    var url = block.urls[j];

                    for (var k = 0; k < url.result.args.length; k++) {
                        var arg = url.result.args[k];
                        console.log('       type : ' + arg.type);
                        console.log('       value : ' + arg.value);
                        html = html + "<ul><li><b>Type:</b> " + arg.type + " <b><br>Value:</b> " + arg.value + "</li></ul>";
                    }
                }
                $('#PrioritizeVisibleContent').append(html);
            }

            function showMainResourceServerResponseTime(result) {

                console.log('MainResourceServerResponseTime');
                console.log('urlBlocks');
                var html = "<p>Rule Impact : " + (parseFloat(result.formattedResults.ruleResults.MainResourceServerResponseTime.ruleImpact)).toFixed(2) + "</p>";
                var block = result.formattedResults.ruleResults.MainResourceServerResponseTime.urlBlocks[1];

                for (var j = 0; j < block.urls.length; j++) {

                    var url = block.urls[j];

                    for (var k = 0; k < url.result.args.length; k++) {
                        var arg = url.result.args[k];
                        console.log('       type : ' + arg.type);
                        console.log('       value : ' + arg.value);
                        html = html + "<ul><li><b>Type:</b> " + arg.type + " <b><br>Value:</b> " + arg.value + "</li></ul>";
                    }
                }
                $('#MainResourceServerResponseTime').append(html);
            }

            function showOptimizeImages(result) {

                console.log('OptimizeImages');
                console.log('urlBlocks');
                var html = "<p>Rule Impact : " + (parseFloat(result.formattedResults.ruleResults.OptimizeImages.ruleImpact)).toFixed(2) + "</p>";
                var block = result.formattedResults.ruleResults.OptimizeImages.urlBlocks[1];

                for (var j = 0; j < block.urls.length; j++) {

                    var url = block.urls[j];

                    for (var k = 0; k < url.result.args.length; k++) {
                        var arg = url.result.args[k];
                        console.log('       type : ' + arg.type);
                        console.log('       value : ' + arg.value);
                        html = html + "<ul><li><b>Type:</b> " + arg.type + " <b><br>Value:</b> " + arg.value + "</li></ul>";
                    }
                }
                $('#OptimizeImages').append(html);
            }

            function showMinimizeRenderBlockingResources(result) {

                console.log('MinimizeRenderBlockingResources');
                console.log('urlBlocks');
                var html = "<p>Rule Impact : " + (parseFloat(result.formattedResults.ruleResults.MinimizeRenderBlockingResources.ruleImpact)).toFixed(2) + "</p>";
                var block = result.formattedResults.ruleResults.MinimizeRenderBlockingResources.urlBlocks[1];

                for (var j = 0; j < block.urls.length; j++) {

                    var url = block.urls[j];

                    for (var k = 0; k < url.result.args.length; k++) {
                        var arg = url.result.args[k];
                        console.log('       type : ' + arg.type);
                        console.log('       value : ' + arg.value);
                        html = html + "<ul><li><b>Type:</b> " + arg.type + " <b><br>Value:</b> " + arg.value + "</li></ul>";
                    }
                }
                $('#MinimizeRenderBlockingResources').append(html);
            }
        </script>
    </div>

    <!--*******************Mobile Usability Data***************************-->
    <div role="tabpanel" class="tab-pane" id="mobileusage">
        <div class="row">
            <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
                <h1 class="page-title txt-color-blueDark">
                    <i class="fa fa-bolt fa-fw "></i>
                    Webmaster Tools
                    <span>
                        Mobile usability
                    </span>
                </h1>
            </div>
        </div>
        <style>
            #result-table-mobile{
                visibility: hidden;
            }
            .well1 {
                margin: 1%;
                min-height: 300px;
                max-height: 300px;
            }
        </style>


        <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center">
                <form action="#" id="formSubmit-mobile" class="form-inline" onsubmit="return getMobileUsabilityResults()">
                    <input type="url" name="url" class="form-control" required="true" id="url_field" style="width: 70%;" />
                    <input type="submit" value="GO" class="btn btn-primary" />
                </form>
            </div><br/>

            <div class="col-md-12 text-center" style="margin-top: 3%;">        
                <span id="loading-mobile"></span>
            </div>

            <div class="col-md-12 text-center" id="result-table-mobile">
                <div class="row">
                    <div class="col-md-5 text-center" style="margin-left: 6%;">
                        <div class="well well1">
                            <div>
                                <h3>Score</h3>
                                <span id="score-mobile" class="dyna-mobile"></span>
                            </div>
                            <div>
                                <span id="message-mobile"></span>
                            </div>
                        </div>

                        <div class="well well1" style="margin-top: 5%;">
                            <div>
                                <h3>Details</h3>
                                <div id="details-mobile" class="dyna-mobile"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5 well well1 text-center" style="margin-top: 5px; min-height: 622px;">
                        <div>
                            <h3>Mobile View</h3>
                            <div id="mobile-view" class="dyna-mobile"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">

            var CHART_API_URL = 'http://chart.apis.google.com/chart?';

            function getMobileUsabilityResults() {

                $.ajax({
                    type: "GET",
                    url: "getpagemobileusability.action",
                    data: $("#formSubmit-mobile").serialize(),
                    beforeSend: function (data) {
                        $('#loading-mobile').text('Loading Please Wait...');
                        $('.dyna-mobile').empty();
                        $('#result-table-mobile').css('visibility', 'hidden');
                    },
                    success: function (data) {
                        $('#loading-mobile').text('');
                        var result = JSON.parse(data);
                        $('#result-table-mobile').css('visibility', 'visible');
                        try {
                            displayScore(result);
                        } catch (err) {
                        }

                        try {
                            showMobileView(result);
                        } catch (err) {
                        }
                        try {
                            showDetails(result);
                        } catch (err) {
                        }
                    }
                });
                return false;
            }
            var pass = false, score = 0;
            function displayScore(result) {

                score = result.ruleGroups.USABILITY.score;
                pass = result.ruleGroups.USABILITY.pass;
                // Construct the query to send to the Google Chart Tools.
                var query = [
                    'chtt=Mobile+Friendliness+Score:+' + score,
                    'chs=300x150',
                    'cht=gom',
                    'chd=t:' + score,
                    'chxt=x,y',
                    'chxl=0:|' + score
                ].join('&');
                var i = document.createElement('img');
                i.src = CHART_API_URL + query;
                document.getElementById('score-mobile').insertBefore(i, null);

                if (pass) {
                    $('#message-mobile').text('This page is mobile-friendly.');
                } else {
                    $('#message-mobile').text('This page is not mobile-friendly');
                }
            }

            function showMobileView(result) {
                var screen_data = result.screenshot.data;
                var html = "<img src='data:image/jpeg;base64," + screen_data + "' />";
                $('#mobile-view').append(html);
            }

            function showDetails(result) {

                html = "<ol type='A'>";
                var common = result.formattedResults.ruleResults;
                if (common.ConfigureViewport.ruleImpact > 0) {
                    html = html + "<li>" + common.ConfigureViewport.localizedRuleName + "</li>";
                }
                if (common.UseLegibleFontSizes.ruleImpact > 0) {
                    html = html + "<li>" + common.UseLegibleFontSizes.localizedRuleName + "</li>";
                }
                if (common.SizeContentToViewport.ruleImpact > 0) {
                    html = html + "<li>" + common.SizeContentToViewport.localizedRuleName + "</li>";
                }
                if (common.AvoidPlugins.ruleImpact > 0) {
                    html = html + "<li>" + common.AvoidPlugins.localizedRuleName + "</li>";
                }
                if (common.SizeTapTargetsAppropriately.ruleImpact > 0) {
                    html = html + "<li>" + common.SizeTapTargetsAppropriately.localizedRuleName + "</li>";
                }

                html = html + "</ol>";

                $('#details-mobile').append(html);
            }


        </script>
    </div>


    <!--*******************Structured Data***************************-->
    <div role="tabpanel" class="tab-pane" id="structuredatausage">
        <div class="row">
            <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
                <h1 class="page-title txt-color-blueDark">
                    <i class="fa fa-bolt fa-fw "></i>
                    Webmaster Tools
                    <span>
                        Structured Data
                    </span>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center">
                <form action="#" id="form-Submit-Structured" class="form-inline" onsubmit="return getStructuredDataResults()">
                    <input type="url" name="url" class="form-control" required="true" id="url_field_data" style="width: 70%;" />
                    <input type="submit" value="GO" class="btn btn-primary" />
                </form>
            </div><br/>

            <div class="col-md-12 text-center" style="margin-top: 3%;">        
                <span id="loading-Structured-Data"></span>
            </div>

            <div class="col-md-12" id="well-content">
                <div class="row">
                    <div class="col-md-2 col-md-offset-1">
                        <code>icon</code>
                    </div>
                    <div class="col-md-8 well" id="id-icon">

                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2 col-md-offset-1">
                        <code>title</code>
                    </div>
                    <div class="col-md-8 well">
                        <label><span id="id-title"></span></label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2 col-md-offset-1">
                        <code>text</code>
                    </div>
                    <div class="col-md-8 well">
                        <p id="id-text"></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2 col-md-offset-1">
                        <code>type</code>
                    </div>
                    <div class="col-md-8 well">
                        <p id="id-type"></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2 col-md-offset-1">
                        <code>html</code>
                    </div>
                    <div class="col-md-8 well">
                        <p id="id-html"></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2 col-md-offset-1">
                        <code>siteName</code>
                    </div>
                    <div class="col-md-8 well">
                        <label id="id-siteName"></label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2 col-md-offset-1">
                        <code>humanLanguage</code>
                    </div>
                    <div class="col-md-8 well">
                        <span id="id-human"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2 col-md-offset-1">
                        <code>pageUrl</code>
                    </div>
                    <div class="col-md-8 well">
                        <a href="#" id="id-pageUrl"></a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2 col-md-offset-1">
                        <code>resolvedPageUrl</code>
                    </div>
                    <div class="col-md-8 well">
                        <a href="#" id="id-resolvedPageUrl"></a>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">

            function getStructuredDataResults() {

                $.ajax({
                    type: "GET",
                    url: "getstructureddata.action",
                    data: $("#form-Submit-Structured").serialize(),
                    success: function (data) {
//                        console.log(data);
                        var result = JSON.parse(data);
                        console.log(result);
                        var html = result.objects[0].html;
                        var human = result.objects[0].humanLanguage;
                        var icon = result.objects[0].icon;
                        var pageUrl = result.objects[0].pageUrl;
                        var resolvedPageUrl = result.objects[0].resolvedPageUrl;
                        var siteName = result.objects[0].siteName;
                        var text = result.objects[0].text;
                        var title = result.objects[0].title;
                        var type = result.objects[0].type;

                        console.log("1 html             : " + html);
                        console.log("2 human            : " + human);
                        console.log("3 icon             : " + icon);
                        console.log("4 page url         : " + pageUrl);
                        console.log("5 Resolved pageurl : " + resolvedPageUrl);
                        console.log("6 Site Name        : " + siteName);
                        console.log("7 Text             : " + text);
                        console.log("8 Title            : " + title);
                        console.log("9 Type             : " + type);

                        $("#id-icon").html('<img src="' + icon + '" class="img-responsive"/>');
                        $("#id-title").append(title);
                        $("#id-text").append(text);
                        $("#id-type").append(type);
                        $("#id-html").append(html);
                        $("#id-siteName").append(siteName);
                        $("#id-human").append(human);
                        $("#id-pageUrl").append(pageUrl);
                        $("#id-resolvedPageUrl").append(resolvedPageUrl);





                    }
                });
                return false;
            }


        </script>
    </div>

    <!--*******************Robot Checker Data***************************-->
    <div role="tabpanel" class="tab-pane" id="robotchecker">
        <div class="row">
            <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
                <h1 class="page-title txt-color-blueDark">
                    <i class="fa fa-bolt fa-fw "></i>
                    Webmaster Tools
                    <span>
                        Robot Checker
                    </span>
                </h1>
            </div>
        </div>

        <style>
            #result-table{
                visibility: hidden;
            }
            .well {
                margin: 1%;
                min-height: 300px;
                max-height: 300px;
            }
            td, th {
                border-color: #ddd !important;
                border-left: 1px #ddd solid;
                border-right: 1px #ddd solid;
            }
        </style>


        <div class="row">

            <div class="col-md-6 col-md-offset-3 text-center">
                <form action="#" id="formrobotSubmit" class="form-inline" onsubmit="return getRobotsFile()">
                    <input type="url" name="url" class="form-control" required="true" id="url_field_robot" style="width: 70%;" />
                    <input type="submit" value="Get" class="btn btn-primary" />
                </form>
            </div>

            <div class="col-md-12 text-center" style="margin-top: 3%;">        
                <span id="loading-robot"></span>
            </div>

            <div class="col-md-6 col-md-offset-3 text-center" style="max-height: 350px;overflow-y: scroll;">
                <table id="file-content" >
                </table>
            </div>
            <br/><br/>
            <div class="col-md-6 col-md-offset-3 text-center">
                <form action="#" id="formAllowanceSubmit" class="form-inline" onsubmit="return getAllowance()">
                    <span id="domain-url-robot" style="color:gray;"></span>&nbsp;<input type="text" name="path" class="form-control" required="true" id="url-allowance" style="width: 40%;" />
                    <input type="submit" value="Check" class="btn btn-primary" />
                </form>
                <span id="allowance-message"></span>
            </div>

        </div>

        <script type="text/javascript">

            var isRobotFileExist = false;
            var fileJson = "";

            function getAllowance() {

                if (!isRobotFileExist) {
                    alert("Please get the robots.txt file first");
                    return false;
                }

                $.ajax({
                    type: "GET",
                    url: "checkUrlAllowance.action",
                    data: "url=" + $('#url_field_robot').val() + '/' + $('#url-allowance').val(),
                    beforeSend: function () {
                        $('#loading-robot').text('Loading Please Wait...');
                    },
                    success: function (data) {
                        $('#loading-robot').text('');
                        var result = JSON.parse(data);
                        console.log('result' + result);
                        for (var i = 0; i < fileJson.lines.length; i++) {
                            try {
                                var str = fileJson.lines[i][i];
                                var res = str.split(":");
                                var check = res[1];

                                if ((check === ' ' + $('#url-allowance').val()) || (check === ' /' + $('#url-allowance').val()) || (check === '' + $('#url-allowance').val()) || (check === '/' + $('#url-allowance').val())) {
                                    if (result.allowed === false) {
                                        $('#allowance-message').text('Blocked');
                                        $('#allowance-message').css('color', 'red');
                                        $('#line' + i).css('background-color', 'red');
                                    }
                                    else {
                                        $('#allowance-message').text('Allowed');
                                        $('#allowance-message').css('color', 'green');
                                        $('#line' + i).css('background-color', 'green');
                                    }
                                }
                            } catch (err) {
                            }
                        }
                    }
                });
                return false;
            }

            function getRobotsFile() {

                $.ajax({
                    type: "GET",
                    url: "getRobotFile.action",
                    data: $("#formrobotSubmit").serialize(),
                    beforeSend: function (data) {
                        $('#loading-robot').text('Loading Please Wait...');
                    },
                    success: function (data) {
                        $('#loading-robot').text('');
                        var result = JSON.parse(data);
                        if (result.code === 101) {
                            fileJson = result;
                            isRobotFileExist = true;
                            $('#robot-content').val(data);
                            $('#domain-url-robot').text('' + $('#url_field_robot').val());

                            var html = "";
                            for (var i = 0; i < result.lines.length; i++) {
                                html = html + "<tr><td style='color:grey;border-right-color:black' ><b>" + (i + 1) + "</b></td><td style='text-align: left' id='line" + i + "'>" + result.lines[i][i] + "</td></tr>";
                            }
                            $('#file-content').empty();
                            $('#file-content').append(html);
                        }
                    }
                });
                return false;
            }

        </script>
    </div>
</div>
