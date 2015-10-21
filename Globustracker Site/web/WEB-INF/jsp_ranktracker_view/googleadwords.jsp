<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<div class="row" id="adwordsdatahide1" style="display:none">
    <div class="col-md-8 col-md-offset-2 text-center well">
        <h1>AdWords Campaigns Graph</h1>
        <!-- <span>Sessions vs. Users - last 30 days</span> -->
        <div><div id="chart-1-container"></div></div>
    </div>
</div>

<div class="row" id="adwordsdatahide2" style="display:none">
    <div class="col-md-8 col-md-offset-2 text-center well">
        <h1>AdWords Campaigns Details</h1>
        <!-- <span>Sessions vs. Users - last 30 days</span> -->
        <div><div id="chart-2-container"></div></div>
    </div>
</div>

<div class="row" id="adwordsdatahide3" style="display:none">
    <div class="col-md-8 col-md-offset-2 text-center well">
        <h1>Adwords Keywords Graph</h1>
        <!-- <span>Sessions vs. Users - last 30 days</span> -->
        <div><div id="chart-3-container"></div></div>
    </div>
</div>

<div class="row" id="adwordsdatahide4" style="display:none">
    <div class="col-md-12 text-center well">
        <h1>Adwords Keywords Details</h1>
        <!-- <span>Sessions vs. Users - last 30 days</span> -->
        <div><div id="chart-4-container"></div></div>
    </div>
</div>

<div class="row" id="adwordsdatahide5" style="display:none">
    <div class="col-md-8 col-md-offset-2 text-center well">
        <h1>AdWords Search Queries Graph</h1>
        <!-- <span>Sessions vs. Users - last 30 days</span> -->
        <div><div id="chart-5-container"></div></div>
    </div>
</div>

<div class="row" id="adwordsdatahide6" style="display:none">
    <div class="col-md-12 text-center well">
        <h1>AdWords Search Queries Details</h1>
        <!-- <span>Sessions vs. Users - last 30 days</span> -->
        <div><div id="chart-6-container"></div></div>
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
            $("#adwordsdatahide1").hide();
            $("#adwordsdatahide2").hide();
            $("#adwordsdatahide3").hide();
            $("#adwordsdatahide4").hide();
            $("#adwordsdatahide5").hide();
            $("#adwordsdatahide6").hide();
        });

        gapi.analytics.auth.on('success', function (response) {
            console.log("success");
            $("#adwordsdatahide1").show();
            $("#adwordsdatahide2").show();
            $("#adwordsdatahide3").show();
            $("#adwordsdatahide4").show();
            $("#adwordsdatahide5").show();
            $("#adwordsdatahide6").show();
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
                metrics: 'ga:impressions,ga:sessions,ga:adClicks,ga:adCost,ga:CTR,ga:CPC',
                dimensions: 'ga:campaign'
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
                metrics: 'ga:impressions,ga:sessions,ga:adClicks,ga:adCost,ga:CTR,ga:CPC',
                dimensions: 'ga:campaign'
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
                metrics: 'ga:adClicks,ga:adCost,ga:CPC,ga:sessions,ga:bounceRate,ga:pageviewsPerSession,ga:goalConversionRateAll,ga:goalCompletionsAll,ga:goalValueAll',
                dimensions: 'ga:keyword'
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
                metrics: 'ga:adClicks,ga:adCost,ga:CPC,ga:sessions,ga:bounceRate,ga:pageviewsPerSession,ga:goalConversionRateAll,ga:goalCompletionsAll,ga:goalValueAll',
                dimensions: 'ga:date,ga:keyword'
            },
            chart: {
                'container': 'chart-4-container',
                'type': 'TABLE',
                'options': {
                    'width': '100%'
                }
            }
        });

        var dataChart5 = new gapi.analytics.googleCharts.DataChart({
            query: {
                'start-date': '30daysAgo',
                'end-date': 'yesterday',
                metrics: 'ga:adClicks,ga:adCost,ga:CPC,ga:sessions,ga:bounceRate,ga:pageviewsPerSession,ga:goalConversionRateAll,ga:goalCompletionsAll,ga:goalValueAll',
                dimensions: 'ga:adMatchedQuery'

            },
            chart: {
                'container': 'chart-5-container',
                'type': 'LINE',
                'options': {
                    'width': '100%'
                }
            }
        });

        var dataChart6 = new gapi.analytics.googleCharts.DataChart({
            query: {
                'start-date': '30daysAgo',
                'end-date': 'yesterday',
                metrics: 'ga:adClicks,ga:adCost,ga:CPC,ga:sessions,ga:bounceRate,ga:pageviewsPerSession,ga:goalConversionRateAll,ga:goalCompletionsAll,ga:goalValueAll',
                dimensions: 'ga:adMatchedQuery'

            },
            chart: {
                'container': 'chart-6-container',
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

        viewSelector.on('change', function (ids) {
            dataChart5.set({query: {ids: ids}}).execute();
        });

        viewSelector.on('change', function (ids) {
            dataChart6.set({query: {ids: ids}}).execute();
        });
    });
</script>