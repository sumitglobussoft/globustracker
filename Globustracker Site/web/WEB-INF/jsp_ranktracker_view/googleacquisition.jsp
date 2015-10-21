<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="http://static.woopra.com/website/v4/js/jquery.1.7.2.js"></script>
<!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">-->
<link rel="stylesheet" href="https://ga-dev-tools.appspot.com/public/css/index.css" />
<style>
    .Chartjs-legend {
        margin: 0 0 0 12% !important;
        text-align: left !important;
    }
    .ActiveUsers {
        width: 8%;
    }
    td {
        border: 0px solid;
        font-size: 11px !important;
    }
    #chart-container3 td, #chart-container4 td {
        border: 1px solid !important;
    }
    th {
        font-size: 13px !important;
        border: 1px solid !important;
    }
    #datahide1  h1 {
        font-weight: bold !important;
        color : white !important;
    }
    #view-selector-container {
        display: inline-flex;
        margin: 2% auto 2% 14%;
    }
    .DateRangeSelector-item {
        flex: initial !important;
        margin-left: 8% !important;
        margin-bottom: 2% !important;
    }
    .DateRangeSelector-item input {
        height: 25px;
        font-size: 15px;
        width: 165px;
    }
    /* #embed-api-auth-container div:last-child {
         display: none !important;
       } */
</style>

<!--Tracking Code of dev.globustracker domain name-->
<script>
    (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function () {
            (i[r].q = i[r].q || []).push(arguments)
        }, i[r].l = 1 * new Date();
        a = s.createElement(o),
                m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

    ga('create', 'UA-65027606-1', 'auto');
    ga('send', 'pageview');

</script>

<!--Tracking Code of globustracker domain name-->
<!--<script>
    (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function () {
            (i[r].q = i[r].q || []).push(arguments)
        }, i[r].l = 1 * new Date();
        a = s.createElement(o),
                m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

    ga('create', 'UA-65027606-1', 'auto');
    ga('send', 'pageview');

</script>-->

<div id="embed-api-auth-container" style="margin-top: 2%; font-size:13px; margin-left: 1.5%;"></div>
<div id="view-selector-container" class="datahide4"></div>		
<div id="active-users-container"></div>
<div id="date-range-selector-1-container" class="datahide3" style="display:none"></div>

<div id="datahide2" class="" style="display:none; margin-top:3%;">
    <div class="row">
        <div class="col-md-5 well" style="margin-left: 8%; height:408px;">
            <h1>Top Channels</h1>

            <div id="chart-container1"></div>
        </div>
        <div class="col-md-5 well" style="margin-left: 15px;">
            <h1>Site Traffic</h1>
            <span>Sessions vs. Users</span>
            <div id="chart-container2"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 well" style="margin-left: 8%; width:84.5%;">
            <div id="chart-container4"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 well" style="margin-left: 8%; min-height: 500px; max-height: 500px; width:84.5%; overflow-y: scroll;" >
            <div id="chart-container3"></div>
        </div>
    </div>
</div>
<div id="view-name" class="Chartjs-legend"></div>


<script src="//www.google-analytics.com/analytics.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>

<script>
    (function (w, d, s, g, js, fs) {
        g = w.gapi || (w.gapi = {});
        g.analytics = {q: [], ready: function (f) {
                this.q.push(f);
            }};
        js = d.createElement(s);
        fs = d.getElementsByTagName(s)[0];
        js.src = 'https://apis.google.com/js/platform.js';
        fs.parentNode.insertBefore(js, fs);
        js.onload = function () {
            g.load('analytics');
        };
    }(window, document, 'script'));
</script>
<script src="https://ga-dev-tools.appspot.com/public/javascript/embed-api/components/view-selector2.js"></script>
<script src="https://ga-dev-tools.appspot.com/public/javascript/embed-api/components/date-range-selector.js"></script>
<script src="https://ga-dev-tools.appspot.com/public/javascript/embed-api/components/active-users.js"></script>
<script>

    gapi.analytics.ready(function () {


        /**
         * Authorize the user immediately if the user has already granted access.
         * If no access has been created, render an authorize button inside the
         * element with the ID "embed-api-auth-container".
         */
        gapi.analytics.auth.authorize({
            container: 'embed-api-auth-container',
            //ClientID for globustracker.com
            clientid: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
        });

        gapi.analytics.auth.on('error', function (response) {
            console.log("error");
            $("#datahide1").hide();
            $("#datahide2").hide();
            $(".datahide3").hide();
        });

        gapi.analytics.auth.on('success', function (response) {
            console.log("success");
            $("#datahide1").show();
            $("#datahide2").show();
            $(".datahide3").show();
        });


        /**
         * Create a new ViewSelector instance to be rendered inside of an
         * element with the id "view-selector-container".
         */
        var viewSelector = new gapi.analytics.ViewSelector({
            container: 'view-selector-container'
        });

        // Render the view selector to the page.
        viewSelector.execute();

        // Date Range selector Code

        var dateRange1 = {
            dimensions: 'ga:date',
            'start-date': '30daysAgo',
            'end-date': 'yesterday'
        };

        var dateRangeSelector1 = new gapi.analytics.ext.DateRangeSelector({
            container: 'date-range-selector-1-container'
        })
                .set(dateRange1)
                .execute();

        dateRangeSelector1.on('change', function (data) {

            if ((data['start-date'].length === 0) || (data['end-date'].length === 0)) {
                alert("Select Valid date");
            }
            else {
                dataChart1.set({query: data}).execute();
                dataChart2.set({query: data}).execute();
                dataChart3.set({query: data}).execute();

                // Update the "from" dates text.
                var datefield = document.getElementById('from-dates');
                datefield.innerHTML = data['start-date'] + '&mdash;' + data['end-date'];
            }
        });


        /**
         * Create a new DataChart instance with the given query parameters
         * and Google chart options. It will be rendered inside an element
         * with the id "chart-container".
         */


        var dataChart1 = new gapi.analytics.googleCharts.DataChart({
            query: {
                metrics: 'ga:sessions',
                dimensions: 'ga:channelGrouping',
                'start-date': '30daysAgo',
                'end-date': 'yesterday',
                'max-results': 6,
                sort: '-ga:sessions'
            },
            chart: {
                container: 'chart-container1',
                type: 'PIE',
                options: {
                    width: '100%',
                    pieHole: 4 / 9
                }
            }
        });

        var dataChart2 = new gapi.analytics.googleCharts.DataChart({
            query: {
                'start-date': '30daysAgo',
                'end-date': 'yesterday',
                'metrics': 'ga:sessions,ga:users',
                'dimensions': 'ga:date'
            },
            chart: {
                'container': 'chart-container2',
                'type': 'LINE',
                'options': {
                    'width': '100%'
                }
            }
        });

        var dataChart3 = new gapi.analytics.googleCharts.DataChart({
            query: {
                ids: 'ga:106063760',
                metrics: 'ga:sessions, ga:percentNewSessions, ga:newUsers, ga:bounceRate, ga:avgSessionDuration, ga:goalConversionRateAll, ga:goalCompletionsAll, ga:goalValueAll',
                dimensions: 'ga:date',
                'start-date': '30daysAgo',
                'end-date': 'yesterday'

            },
            chart: {
                container: 'chart-container3',
                type: 'TABLE',
                options: {
                    width: '100%'
//                    page: 'enable',
//                    pageSize: '10'
                }
            }
        });

        var dataChart4 = new gapi.analytics.googleCharts.DataChart({
            query: {
                ids: 'ga:106063760',
                metrics: 'ga:sessions, ga:percentNewSessions, ga:newUsers, ga:bounceRate, ga:pageviewsPerSession, ga:avgSessionDuration',
                dimensions: 'ga:channelGrouping',
                'start-date': '30daysAgo',
                'end-date': 'yesterday'

            },
            chart: {
                container: 'chart-container4',
                type: 'TABLE',
                options: {
                    width: '100%'
                }
            }
        });

        /**
         * Render the dataChart on the page whenever a new view is selected.
         */


        viewSelector.on('change', function (ids) {
            dataChart1.set({query: {ids: ids}}).execute();
            setTimeout(function () {
                var totalBounceRate = dataChart1['Na']['totalsForAllResults']['ga:bounceRate'];
                var BounceRate = parseFloat(totalBounceRate).toFixed(2);
                $("#bouncerate").text(BounceRate + " %");

                var obj1 = $('#chart-container1').children();
                var obj2 = $(obj1).children();
                var obj3 = $(obj2).children();
                var obj4 = $(obj3).children();
                var obj5 = $(obj4).children();
                var obj6 = $(obj5).children()[3];
                var obj7 = $(obj6).children()[1];
                var line = $(obj7).children()[3];
                var finalline = $(line).children()[0];
                var forcircle = $(obj6).children()[2];
                var circles = $(forcircle).children();
                $(finalline).attr('stroke', '#058DC7');
                $.each(circles, function (i, a) {
                    $(a).attr('fill', '#058DC7');
                });
            }, 5000);
        });

        viewSelector.on('change', function (ids) {
            dataChart2.set({query: {ids: ids}}).execute();
            setTimeout(function () {
                var obj1 = $('#chart-container2').children();
                var obj2 = $(obj1).children();
                var obj3 = $(obj2).children();
                var obj4 = $(obj3).children();
                var obj5 = $(obj4).children();
                var obj6 = $(obj5).children()[3];
                var obj7 = $(obj6).children()[1];
                var line = $(obj7).children()[3];
                var finalline = $(line).children()[0];
                var forcircle = $(obj6).children()[2];
                var circles = $(forcircle).children();
                $(finalline).attr('stroke', '#058DC7');
                $.each(circles, function (i, a) {
                    $(a).attr('fill', '#058DC7');
                });
            }, 5000);
        });


        viewSelector.on('change', function (ids) {
            dataChart3.set({query: {ids: ids}}).execute();
            setTimeout(function () {
                changelogdatachart3();
                var totalusers = dataChart3['Na']['totalsForAllResults']['ga:users'];
                $("#users").text(totalusers);
                var obj1 = $('#chart-container3').children();
                var obj2 = $(obj1).children();
                var obj3 = $(obj2).children();
                var obj4 = $(obj3).children();
                var obj5 = $(obj4).children();
                var obj6 = $(obj5).children()[3];
                var obj7 = $(obj6).children()[1];
                var line = $(obj7).children()[3];
                var finalline = $(line).children()[0];
                var forcircle = $(obj6).children()[2];
                var circles = $(forcircle).children();
                $(finalline).attr('stroke', '#058DC7');
                $.each(circles, function (i, a) {
                    $(a).attr('fill', '#058DC7');
                });
            }, 10000);
        });

        function changelogdatachart3() {
            $(document.body).find('.google-visualization-table-table >tbody>tr').each(function () {
                var row = $(this);//.html();
                row.find('td').each(function () {
                    var td = $(this).html();
                    if ($.isNumeric(td)) {
                        var change = parseFloat(td).toFixed(2);
                        $(this).html(change);
                    }
                });
            });
        }

        viewSelector.on('change', function (ids) {
            dataChart4.set({query: {ids: ids}}).execute();
            setTimeout(function () {
                changelogdatachart4();
                var totalusers = dataChart3['Na']['totalsForAllResults']['ga:users'];
                $("#users").text(totalusers);
                var obj1 = $('#chart-container4').children();
                var obj2 = $(obj1).children();
                var obj3 = $(obj2).children();
                var obj4 = $(obj3).children();
                var obj5 = $(obj4).children();
                var obj6 = $(obj5).children()[3];
                var obj7 = $(obj6).children()[1];
                var line = $(obj7).children()[3];
                var finalline = $(line).children()[0];
                var forcircle = $(obj6).children()[2];
                var circles = $(forcircle).children();
                $(finalline).attr('stroke', '#058DC7');
                $.each(circles, function (i, a) {
                    $(a).attr('fill', '#058DC7');
                });
            }, 10000);
        });

        function changelogdatachart4() {
            $(document.body).find('.google-visualization-table-table >tbody>tr').each(function () {
                var row = $(this);//.html();
                row.find('td').each(function () {
                    var td = $(this).html();
                    if ($.isNumeric(td)) {
                        var change = parseFloat(td).toFixed(2);
                        $(this).html(change);
                    }
                });
            });
        }





    });
</script>

<script>

// == NOTE ==
// This code uses ES6 promises. If you want to use this code in a browser
// that doesn't supporting promises natively, you'll have to include a polyfill.
    $(document).ready(function () {
        gapi.analytics.ready(function () {

            /**
             * Authorize the user immediately if the user has already granted access.
             * If no access has been created, render an authorize button inside the
             * element with the ID "embed-api-auth-container".
             */
            // gapi.analytics.auth.authorize({
            //     container: 'embed-api-auth-container1',
            //     clientid: '335469395184-5qd9putqhbefup0i335ba3dkh227tdd5.apps.googleusercontent.com'
            // });


            /**
             * Create a new ActiveUsers instance to be rendered inside of an
             * element with the id "active-users-container" and poll for changes every
             * five seconds.
             */

        });
    });
</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        function onclickchangingvalue() {
            $(document.body).find('.gapi-analytics-data-chart-styles-table-th').click(function () {
//                alert('test');
                $(document.body).find('.google-visualization-table-table >tbody>tr').each(function () {
                    var row = $(this);//.html();
                    row.find('td').each(function () {
                        var td = $(this).html();
                        if ($.isNumeric(td)) {
                            var change = parseFloat(td).toFixed(2);
                            $(this).html(change);
                        }
                    });
                });
            });
        }
        setTimeout(function () {
            onclickchangingvalue();
        }, 8000);
    });


</script>