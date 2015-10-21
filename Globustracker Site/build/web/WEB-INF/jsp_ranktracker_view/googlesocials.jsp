<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="https://ga-dev-tools.appspot.com/public/css/index.css" />
<style>
    h1 {
        font-weight: bold;
    }
    td {
        border: 1px solid !important;
        font-size: 12px !important;
    }
    th {
        font-size: 13px !important;
        border: 1px solid !important;
    }
    .gapi-analytics-data-chart-styles-table-th.unsorted {
        font-size: 10px !important;
    }
</style>
<!--Tracking Code of dev.globustracker domain name-->
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

    ga('create', 'UA-65722895-1', 'auto');
    ga('send', 'pageview');

</script>-->

<!--Tracking Code of globustracker domain name-->
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
<div id="embed-api-auth-container" style="margin-bottom: 3%; margin-left: 1.5%;"></div>
<div id="view-selector-container"></div>
<div class="row" id="socialdatahide1" style="display:none">
    <div class="col-md-8 col-md-offset-2 text-center well">
        <h1>Social Network Refferal Graph</h1>
        <!-- <span>Sessions vs. Users - last 30 days</span> -->
        <div><div id="chart-1-container"></div></div>
    </div>
</div>

<div class="row" id="socialdatahide2" style="display:none">
    <div class="col-md-8 col-md-offset-2 text-center well">
        <h1>Social Network Refferial Details</h1>
        <!-- <span>Sessions vs. Users - last 30 days</span> -->
        <div><div id="chart-2-container"></div></div>
    </div>
</div>

<div class="row" id="socialdatahide3" style="display:none">
    <div class="col-md-8 col-md-offset-2 text-center well">
        <h1>Social Landing Pages Graph</h1>
        <!-- <span>Sessions vs. Users - last 30 days</span> -->
        <div><div id="chart-3-container"></div></div>
    </div>
</div>

<div class="row" id="socialdatahide4" style="display:none">
    <div class="col-md-12 text-center well">
        <h1>Social Landing Pages Details</h1>
        <!-- <span>Sessions vs. Users - last 30 days</span> -->
        <div><div id="chart-4-container"></div></div>
    </div>
</div>

<div class="row">
    <div class="col-md-12">

        <!-- <div style="width: 50%;padding-left: 25% "><div id="chart-1-container"></div></div> -->
        <div id="chart-container"></div>

    </div>
</div>

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
            $("#socialdatahide1").hide();
            $("#socialdatahide2").hide();
            $("#socialdatahide3").hide();
            $("#socialdatahide4").hide();
        });

        gapi.analytics.auth.on('success', function (response) {
            console.log("success");
            $("#socialdatahide1").show();
            $("#socialdatahide2").show();
            $("#socialdatahide3").show();
            $("#socialdatahide4").show();
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

        /**
         * Create a new DataChart instance with the given query parameters
         * and Google chart options. It will be rendered inside an element
         * with the id "chart-container".
         */

        var dataChart1 = new gapi.analytics.googleCharts.DataChart({
            query: {
                'start-date': '30daysAgo',
                'end-date': 'yesterday',
                metrics: 'ga:sessions,ga:pageviews,ga:avgSessionDuration,ga:pageviewsPerSession',
                dimensions: 'ga:socialNetwork'
            },
            chart: {
                'container': 'chart-1-container',
                'type': 'LINE',
                'options': {
                    'width': '100%'
                }
            }
        });

        var dataChart2 = new gapi.analytics.googleCharts.DataChart({
            query: {
                'start-date': '30daysAgo',
                'end-date': 'yesterday',
                metrics: 'ga:sessions,ga:pageviews,ga:avgSessionDuration,ga:pageviewsPerSession',
                dimensions: 'ga:socialNetwork,ga:date'
            },
            chart: {
                'container': 'chart-2-container',
                'type': 'TABLE',
                'options': {
                    'width': '100%'
                }
            }
        });

        var dataChart3 = new gapi.analytics.googleCharts.DataChart({
            query: {
                'start-date': '30daysAgo',
                'end-date': 'yesterday',
                metrics: 'ga:sessions,ga:pageviews,ga:avgSessionDuration,ga:socialActivities,ga:pageviewsPerSession',
                dimensions: 'ga:socialActivityContentUrl'
            },
            chart: {
                'container': 'chart-3-container',
                'type': 'LINE',
                'options': {
                    'width': '100%'
                }
            }
        });

        var dataChart4 = new gapi.analytics.googleCharts.DataChart({
            query: {
                'start-date': '30daysAgo',
                'end-date': 'yesterday',
                metrics: 'ga:sessions,ga:pageviews,ga:avgSessionDuration,ga:socialActivities,ga:pageviewsPerSession',
                dimensions: 'ga:socialActivityContentUrl,ga:date'
            },
            chart: {
                'container': 'chart-4-container',
                'type': 'TABLE',
                'options': {
                    'width': '100%'
                }
            }
        });

        viewSelector.on('change', function (ids) {
            dataChart1.set({query: {ids: ids}}).execute();
        });

        viewSelector.on('change', function (ids) {
            dataChart2.set({query: {ids: ids}}).execute();
        });

        viewSelector.on('change', function (ids) {
            dataChart3.set({query: {ids: ids}}).execute();
        });

        viewSelector.on('change', function (ids) {
            dataChart4.set({query: {ids: ids}}).execute();
        });


    });
</script>