<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://ga-dev-tools.appspot.com/public/css/index.css" />
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

    ga('create', 'UA-65722895-1', 'auto');
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

<style>
    .gapi-analytics-data-chart .google-visualization-table-td-bool, .gapi-analytics-data-chart .google-visualization-table-td-center, .gapi-analytics-data-chart .google-visualization-table-td-number {
        text-align: left;
        border-left: 1px solid !important;
    }
    td {
        border: 0px solid;
        font-size: 12px !important;
    }
    #chart-1-container td {
        border: 1px solid !important;
    }
    th {
        font-size: 13px !important;
        border: 1px solid !important;
    }
    h3 {
        font-size: 16px !important;
        font-weight:bold;
    }
    span {
        font-size: 13px !important;
    }
    strong {
        font-size: 16px !important;
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
    #view-selector-container {
        display: inline-flex;
        margin: 2% auto 0 14%;
    }
</style>

<div id="embed-api-auth-container" style="margin-top: 2%; font-size:13px; margin-left: 1.5%;"></div>
<div id="view-selector-container"></div>
<div id="date-range-selector-1-container" class="datahide3" style="display:none; margin-top: 3%;"></div>
<!--<div class="row" id="browsemobiledatahide1" style="display:none">
    <div class="col-md-10 col-md-offset-1 well text-center">
        <div class="col-md-12 text-left">
            <strong>Browser Details</strong>
        </div>
        <h3>Browser Traffic</h3>
        <span>Users - last 30 days</span>
        <div style="margin-top:3%;"><div id="chart-1-container"></div></div>
    </div>
</div> -->

<div class="row" id="browsemobiledatahide2" style="display:none; margin-top: 5%;">
    <div class="col-md-10 col-md-offset-1 well text-center">
        <div class="col-md-12 text-left">
            <strong>Browser Details</strong>
        </div>

        <div id="chart-1-container"></div>
        <!-- <div id="chart-container"></div> -->

    </div>
</div>
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
            clientid: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
        });

        gapi.analytics.auth.on('error', function (response) {
            console.log("error");
            //$("#browsemobiledatahide1").hide();
            $("#browsemobiledatahide2").hide();
            $(".datahide3").hide();
        });

        gapi.analytics.auth.on('success', function (response) {
            console.log("success");
            //$("#browsemobiledatahide1").show();
            $("#browsemobiledatahide2").show();
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
            dataChart1.set({query: data}).execute();


            // Update the "from" dates text.
            var datefield = document.getElementById('from-dates');
            datefield.innerHTML = data['start-date'] + '&mdash;' + data['end-date'];
        });

        /**
         * Create a new DataChart instance with the given query parameters
         * and Google chart options. It will be rendered inside an element
         * with the id "chart-container".
         */
        //    var dataChart = new gapi.analytics.googleCharts.DataChart({
        //        query: {
        //            metrics: 'ga:users',
        //            dimensions: 'ga:date,ga:mobileDeviceBranding,ga:mobileDeviceModel,ga:mobileDeviceInfo,ga:operatingSystem,ga:networkLocation,ga:screenResolution',
        //            'start-date': '30daysAgo',
        //            'end-date': 'yesterday'
        //        },
        //        chart: {
        //            container: 'chart-container',
        //            type: 'TABLE',
        //            options: {
        //                width: '100%'
        //            }
        //        }
        //    });
        //
        //    var dataChart1 = new gapi.analytics.googleCharts.DataChart({
        //        query: {
        //            'start-date': '30daysAgo',
        //            'end-date': 'yesterday',
        //            'metrics': 'ga:users',
        //            dimensions: 'ga:date,ga:browser,ga:browserVersion'
        //        },
        //        chart: {
        //            'container': 'chart-1-container',
        //            'type': 'TABLE',
        //            'options': {
        //                'width': '100%'
        //            }
        //        }
        //    });

        var dataChart1 = new gapi.analytics.googleCharts.DataChart({
            query: {
                'start-date': '30daysAgo',
                'end-date': 'yesterday',
                'metrics': 'ga:sessions, ga:percentNewSessions, ga:newUsers, ga:bounceRate, ga:pageviewsPerSession, ga:avgSessionDuration',
                dimensions: 'ga:browser'
            },
            chart: {
                'container': 'chart-1-container',
                'type': 'TABLE',
                'options': {
                    'width': '100%'
                }
            }
        });

        /**
         * Render the dataChart on the page whenever a new view is selected.
         */
        //    viewSelector.on('change', function (ids) {
        //        dataChart.set({query: {ids: ids}}).execute();
        //
        //    });
        //
        //    viewSelector.on('change', function (ids) {
        //        dataChart1.set({query: {ids: ids}}).execute();
        //
        //    });

        viewSelector.on('change', function (ids) {
            dataChart1.set({query: {ids: ids}}).execute();

        });
    });
</script>
