<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://ga-dev-tools.appspot.com/public/css/index.css" />

<style>
    #view-selector-container {
        display: inline-flex;
        margin: 2% auto 2% 14%;
    }
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
<div id="view-selector-container"></div>
<div class="row" id="sitespeeddatahide1" style="display:none">
    <div class="col-md-8 col-md-offset-2 well text-center">
        <h3 style="font-weight: bold; font-size: 24px;">Site Speed Page Timings</h3>
        <!-- <span>Sessions vs. Users - last 30 days</span> -->
        <div><div id="chart-1-container"></div></div>
    </div>
</div>

<!--<div class="row" id="sitespeeddatahide2" style="display:none">
    <div class="col-md-8 col-md-offset-2 well text-center">
        <h3 style="font-weight: bold; font-size: 24px;">Site Speed Suggestions</h3>
<!-- <span>Sessions vs. Users - last 30 days</span> -->
<!-- <div><div id="chart-2-container"></div></div>
</div>
</div> -->

<div class="row" id="sitespeeddatahide3" style="display:none">
    <div class="col-md-8 col-md-offset-2 well text-center">
        <h3 style="font-weight: bold; font-size: 24px;">Site Speed User Timings</h3>
        <!-- <span>Sessions vs. Users - last 30 days</span> -->
        <div><div id="chart-3-container"></div></div>
    </div>
</div>

<div class="row" id="sitespeeddatahide4" style="display:none">
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
            $("#sitespeeddatahide1").hide();
            $("#sitespeeddatahide2").hide();
            $("#sitespeeddatahide3").hide();
            $("#sitespeeddatahide4").hide();
        });

        gapi.analytics.auth.on('success', function (response) {
            console.log("success");
            $("#sitespeeddatahide1").show();
            $("#sitespeeddatahide2").show();
            $("#sitespeeddatahide3").show();
            $("#sitespeeddatahide4").show();
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
                metrics: 'ga:bounceRate,ga:pageValue,ga:pageviews,ga:exitRate,ga:avgPageLoadTime',
                dimensions: 'ga:date'
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
                metrics: 'ga:avgDomainLookupTime,ga:avgPageLoadTime,ga:avgRedirectionTime,ga:avgServerConnectionTime,ga:avgServerResponseTime,ga:pageLoadSample,ga:pageviews',
                dimensions: 'ga:date'
            },
            chart: {
                'container': 'chart-2-container',
                'type': 'LINE',
                'options': {
                    'width': '100%'
                }
            }
        });

        var dataChart3 = new gapi.analytics.googleCharts.DataChart({
            query: {
                'start-date': '30daysAgo',
                'end-date': 'yesterday',
                metrics: 'ga:avgUserTimingValue,ga:userTimingSample',
                dimensions: 'ga:date'
            },
            chart: {
                'container': 'chart-3-container',
                'type': 'LINE',
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
    });
</script>

