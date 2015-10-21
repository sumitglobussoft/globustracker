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
        width: 12%;
    }
    td {
        font-size: 11px !important;
    }
    #datahide1  h1 {
        font-weight: bold !important;
        color : white !important;
        font-size: 25px;
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
    #datahide1 .well {
        min-height: 145px;
    }
    #view-selector-container {
        display: inline-flex;
        margin: -2% auto 2% 14%;
    }
    #active-users-container {
        font-size: 12px;
        margin-bottom: 2%;
        text-align: center;
    }
    .jarviswidget {
        padding: 2% !important;
    }
    .ViewSelector2-item > select {
        width: 60%;
        height: auto;
    }
    .ViewSelector, .ViewSelector2 {
        margin-left: 6%;
    }
    .ViewSelector2-item > label {
        font-size: 12px;
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

<div id="embed-api-auth-container" style="margin-top: 2%; font-size:13px; margin-left: 1.5%;"></div>	

<div class="row" id="datahide1" style="display:none">
    <div class="col-md-12 jarviswidget">
        <header>
            <span class="widget-icon"> <i class="fa fa-clock-o"></i> </span>
            <h2>Google Analytics</h2>
        </header>
        <div class="well">
            <div class="row">
                <div class="col-md-2">
                    <div class="well text-center bg-color-teal txt-color-white">
                        <h1><span id="pageviews"></span></h1>
                        <h5>Page Views</h5>
                    </div>
                </div>
                <div class="col-md-2 text-center">
                    <div class="well bg-color-pinkDark txt-color-white">
                        <h1><span id="bouncerate"></span></h1>
                        <h5>Bounce Rate</h5>
                    </div>
                </div>
                <div class="col-md-2 text-center">
                    <div class="well bg-color-teal txt-color-white">
                        <h1><span id="users"></span></h1>
                        <h5>Users</h5>
                    </div>
                </div>
                <div class="col-md-2 text-center">
                    <div class="well bg-color-pinkDark txt-color-white">
                        <h1><span id="avgsessionduration"></span></h1>
                        <h5>Avg. Session Duration</h5>
                    </div>
                </div>
                <div class="col-md-2 text-center">
                    <div class="well bg-color-teal txt-color-white">
                        <h1><span id="percentnewsession"></span></h1>
                        <h5>% New Session</h5>
                    </div>
                </div>
                <div class="col-md-2 text-center">
                    <div class="well bg-color-pinkDark txt-color-white">
                        <h1><span id="pageuserSession"></span></h1>
                        <h5>Session</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="view-selector-container" class="datahide4"></div>		
<div id="active-users-container"></div>
<div id="date-range-selector-1-container" class="datahide3" style="display:none"></div>

<div id="datahide2" class="" style="display:none; margin-top:3%;">
    <div class="row">
        <div class="col-md-5 well" style="margin-left: 8%;">
            <div id="chart-container3"></div>
        </div>
        <div class="col-md-5 well" style="margin-left: 15px;">
            <div id="chart-container1"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-5 well" style="margin-left: 8%;">
            <div id="chart-container2"></div>
        </div>
        <div class="col-md-5 well" style="margin-left: 15px;">
            <div id="chart-container"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-5 well" style="margin-left: 8%;">
            <div><div id="chart-container4"></div></div>
        </div>
        <div class="col-md-5 well" style="margin-left: 15px;">
            <div><div id="chart-container5"></div></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-5 well" style="margin-left: 8%; min-height: 269px;">
            <div><div id="chart-container6"></div></div>
        </div>
        <div class="col-md-5 well" style="margin-left: 15px; min-height: 269px;">
            <div><div id="chart-container7"></div></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-5 well" style="margin-left: 8%;">
            <div><div id="chart-container8"></div></div>
        </div>
        <div class="col-md-5 well" style="margin-left: 15px;">
            <div><div id="chart-container9"></div></div>
        </div>
    </div>
    <div id="view-selector-container-1"></div>
    <div class="row" style="margin-top:3%;">
        <div class="col-md-5 well" style="margin-left: 8%;">
            <div><div id="chart-1-container" style="height: 250px; width: 440px;"></div></div>
            <ol id="legend-1-container" class="Chartjs-legend"></ol>
        </div>
        <div class="col-md-5 well" style="margin-left: 15px;">
            <div><div id="chart-2-container" style="height: 250px; width: 440px;"></div></div>
            <ol id="legend-2-container" class="Chartjs-legend"></ol>
        </div>
    </div>
    <div class="row">
        <div class="col-md-5 well" style="margin-left: 8%;">
            <div><div id="chart-3-container" style="height: 250px; width: 440px;"></div></div>
            <ol id="legend-3-container" class="Chartjs-legend"></ol>
        </div>
        <div class="col-md-5 well" style="margin-left: 15px;">
            <div><div id="chart-4-container" style="height: 250px; width: 440px;"></div></div>
            <ol id="legend-4-container" class="Chartjs-legend"></ol>
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
            clientid: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
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
            dataChart.set({query: data}).execute();
            dataChart1.set({query: data}).execute();
            dataChart2.set({query: data}).execute();
            dataChart3.set({query: data}).execute();
            dataChart4.set({query: data}).execute();
            dataChart8.set({query: data}).execute();

            // Update the "from" dates text.
            var datefield = document.getElementById('from-dates');
            datefield.innerHTML = data['start-date'] + '&mdash;' + data['end-date'];
        });


        /**
         * Create a new DataChart instance with the given query parameters
         * and Google chart options. It will be rendered inside an element
         * with the id "chart-container".
         */
        var dataChart = new gapi.analytics.googleCharts.DataChart({
            query: {
                metrics: 'ga:pageviews',
                dimensions: 'ga:date',
                'start-date': '30daysAgo',
                'end-date': 'yesterday'
            },
            chart: {
                container: 'chart-container',
                type: 'LINE',
                options: {
                    width: '100%'
                }
            }
        });

        var dataChart1 = new gapi.analytics.googleCharts.DataChart({
            query: {
                metrics: 'ga:bounceRate',
                dimensions: 'ga:date',
                'start-date': '30daysAgo',
                'end-date': 'yesterday'
            },
            chart: {
                container: 'chart-container1',
                type: 'LINE',
                options: {
                    width: '100%'
                }
            }
        });

        var dataChart2 = new gapi.analytics.googleCharts.DataChart({
            query: {
                metrics: 'ga:percentNewVisits',
                dimensions: 'ga:date',
                'start-date': '30daysAgo',
                'end-date': 'yesterday'
            },
            chart: {
                container: 'chart-container2',
                type: 'LINE',
                options: {
                    width: '100%'
                }
            }
        });

        var dataChart3 = new gapi.analytics.googleCharts.DataChart({
            query: {
                metrics: 'ga:users',
                dimensions: 'ga:date',
                'start-date': '30daysAgo',
                'end-date': 'yesterday'
            },
            chart: {
                container: 'chart-container3',
                type: 'LINE',
                options: {
                    width: '100%'
                }
            }
        });


        var dataChart4 = new gapi.analytics.googleCharts.DataChart({
            query: {
                metrics: 'ga:visits',
                dimensions: 'ga:date',
                'start-date': '30daysAgo',
                'end-date': 'yesterday'
            },
            chart: {
                container: 'chart-container4',
                type: 'LINE',
                options: {
                    width: '100%'
                }
            }
        });

        var dataChart5 = new gapi.analytics.googleCharts.DataChart({
            query: {
                metrics: 'ga:sessions',
                dimensions: 'ga:country',
                'start-date': '30daysAgo',
                'end-date': 'yesterday',
                'max-results': 6,
                sort: '-ga:sessions'
            },
            chart: {
                container: 'chart-container5',
                type: 'PIE',
                options: {
                    width: '100%',
                    pieHole: 4 / 9
                }
            }
        });

        viewSelector.on('change', function (ids) {
            dataChart5.set({query: {ids: ids}}).execute();
        });

        var dataChart6 = new gapi.analytics.googleCharts.DataChart({
            query: {
                ids: 'ga:106063760',
                metrics: 'ga:sessions, ga:percentNewSessions',
                dimensions: 'ga:country',
                'start-date': '30daysAgo',
                'end-date': 'yesterday'
            },
            chart: {
                container: 'chart-container6',
                type: 'TABLE',
                options: {
                    width: '100%',
                    page: 'enable',
                    pageSize: '6'
                }
            }

        });

        viewSelector.on('change', function (ids) {
            dataChart6.set({query: {ids: ids}}).execute();

            setTimeout(function () {
                var totalpercentnewsession = dataChart6['Ei']['totalsForAllResults']['ga:percentNewSessions'];
                var PercentNewSession = parseFloat(totalpercentnewsession).toFixed(2);
                $("#percentnewsession").text(PercentNewSession + " %");
            }, 5000);

        });

        var dataChart7 = new gapi.analytics.googleCharts.DataChart({
            query: {
                ids: 'ga:106063760',
                metrics: 'ga:users',
                dimensions: 'ga:city',
                'start-date': '30daysAgo',
                'end-date': 'yesterday'
            },
            chart: {
                container: 'chart-container7',
                type: 'TABLE',
                options: {
                    width: '100%',
                    page: 'enable',
                    pageSize: '6'

                }
            }

        });

        viewSelector.on('change', function (ids) {
            dataChart7.set({query: {ids: ids}}).execute();

            setTimeout(function () {
                var totalpageuserSession = dataChart7['Ei']['totalsForAllResults']['ga:users'];
                $("#pageuserSession").text(totalpageuserSession);
            }, 5000);

        });

        var dataChart8 = new gapi.analytics.googleCharts.DataChart({
            query: {
                ids: 'ga:106063760',
                metrics: 'ga:avgSessionDuration',
                dimensions: 'ga:nthHour',
                'start-date': '30daysAgo',
                'end-date': 'yesterday',
                'max-results': 6
            },
            chart: {
                container: 'chart-container8',
                type: 'LINE',
                options: {
                    width: '100%'
                }
            }

        });

        viewSelector.on('change', function (ids) {
            dataChart8.set({query: {ids: ids}}).execute();

            setTimeout(function () {
                var totalAvgSessionDuration = dataChart8['Ei']['totalsForAllResults']['ga:avgSessionDuration'];
                var AvgSessionDuration = parseFloat(totalAvgSessionDuration).toFixed(2);
                $("#avgsessionduration").text(AvgSessionDuration + " %");

            }, 5000);

        });


        var dataChart9 = new gapi.analytics.googleCharts.DataChart({
            query: {
                ids: 'ga:106063760',
                metrics: 'ga:organicSearches',
                dimensions: 'ga:date',
                'start-date': '30daysAgo',
                'end-date': 'yesterday',
                segment: 'gaid::-5'
            },
            chart: {
                container: 'chart-container9',
                type: 'LINE',
                options: {
                    width: '100%'
                }
            }

        });

        viewSelector.on('change', function (ids) {
            dataChart9.set({query: {ids: ids}}).execute();
        });
        /**
         * Render the dataChart on the page whenever a new view is selected.
         */
        viewSelector.on('change', function (ids) {

            dataChart.set({query: {ids: ids}}).execute();

            setTimeout(function () {
                var totalpageviews = dataChart['Ei']['totalsForAllResults']['ga:pageviews'];
                $("#pageviews").text(totalpageviews);

                var obj1 = $('#chart-container').children();
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
            dataChart1.set({query: {ids: ids}}).execute();
            setTimeout(function () {
                var totalBounceRate = dataChart1['Ei']['totalsForAllResults']['ga:bounceRate'];
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
                var totalusers = dataChart3['Ei']['totalsForAllResults']['ga:users'];
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
            }, 5000);
        });

        viewSelector.on('change', function (ids) {
            dataChart4.set({query: {ids: ids}}).execute();
            setTimeout(function () {
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
            }, 5000);
        });

        setTimeout(function () {

//            console.log(dataChart3);
            //console.log(dataChart['zt']['totalsForAllResults']);
            var totalpageviews = dataChart['Ei']['totalsForAllResults']['ga:pageviews'];
            console.log("1.TotalPageViews : " + totalpageviews);
            $("#pageviews").text(totalpageviews);

            //console.log(dataChart1);
            //console.log(dataChart1['zt']['totalsForAllResults']);
            var totalBounceRate = dataChart1['Ei']['totalsForAllResults']['ga:bounceRate'];
            var BounceRate = parseFloat(totalBounceRate).toFixed(2);
            console.log("2.TotalBounceRate " + BounceRate + "%");
            $("#bouncerate").text(BounceRate + " %");

            //console.log(dataChart3);					
            //console.log(dataChart3['Ei']['totalsForAllResults']);
            var totalusers = dataChart3['Ei']['totalsForAllResults']['ga:users'];
            console.log("3.TotalUsers : " + totalusers);
            $("#users").text(totalusers);

            //console.log(dataChart8);					
            //console.log(dataChart8['Ei']['totalsForAllResults']);
            var totalAvgSessionDuration = dataChart8['Ei']['totalsForAllResults']['ga:avgSessionDuration'];
            var AvgSessionDuration = parseFloat(totalAvgSessionDuration).toFixed(2);
            console.log("4.TotalAvgSessionDuration : " + AvgSessionDuration);
            $("#avgsessionduration").text(AvgSessionDuration + " %");

            var totalpercentnewsession = dataChart6['Ei']['totalsForAllResults']['ga:percentNewSessions'];
            var PercentNewSession = parseFloat(totalpercentnewsession).toFixed(2);
            console.log("5.TotalPercentNewSession : " + PercentNewSession + "%");
            $("#percentnewsession").text(PercentNewSession + " %");

            var totalpageuserSession = dataChart7['Ei']['totalsForAllResults']['ga:users'];
            console.log("6.TotalPageUserSession : " + totalpageuserSession);
            $("#pageuserSession").text(totalpageuserSession);

            $('#chart-container1').parent().addClass('well');
            $('#chart-container2').parent().addClass('well');
        }, 15000);

        //////////////////////////////////////////
        var activeUsers = new gapi.analytics.ext.ActiveUsers({
            container: 'active-users-container',
            pollingInterval: 5
        });


        /**
         * Add CSS animation to visually show the when users come and go.
         */
        activeUsers.once('success', function () {
            var element = this.container.firstChild;
            var timeout;

            this.on('change', function (data) {
                var element = this.container.firstChild;
                var animationClass = data.delta > 0 ? 'is-increasing' : 'is-decreasing';
                element.className += (' ' + animationClass);

                clearTimeout(timeout);
                timeout = setTimeout(function () {
                    element.className =
                            element.className.replace(/ is-(increasing|decreasing)/g, '');
                }, 3000);
            });
        });


        /**
         * Create a new ViewSelector2 instance to be rendered inside of an
         * element with the id "view-selector-container".
         */
        var viewSelector2 = new gapi.analytics.ext.ViewSelector2({
            container: 'view-selector-container-1',
        })
                .execute();

        /**
         * Update the activeUsers component, the Chartjs charts, and the dashboard
         * title whenever the user changes the view.
         */
        viewSelector2.on('viewChange', function (data) {
            var title = document.getElementById('view-name');
            title.innerHTML = data.property.name + ' (' + data.view.name + ')';

            // Start tracking active users for this view.
            activeUsers.set(data).execute();

            // Render all the of charts for this view.
            renderWeekOverWeekChart(data.ids);
            renderYearOverYearChart(data.ids);
            renderTopBrowsersChart(data.ids);
            renderTopCountriesChart(data.ids);
        });


        /**
         * Draw the a chart.js line chart with data from the specified view that
         * overlays session data for the current week over session data for the
         * previous week.
         */
        function renderWeekOverWeekChart(ids) {

            // Adjust `now` to experiment with different days, for testing only...
            var now = moment(); // .subtract(3, 'day');

            var thisWeek = query({
                'ids': ids,
                'dimensions': 'ga:date,ga:nthDay',
                'metrics': 'ga:sessions',
                'start-date': moment(now).subtract(1, 'day').day(0).format('YYYY-MM-DD'),
                'end-date': moment(now).format('YYYY-MM-DD')
            });

            var lastWeek = query({
                'ids': ids,
                'dimensions': 'ga:date,ga:nthDay',
                'metrics': 'ga:sessions',
                'start-date': moment(now).subtract(1, 'day').day(0).subtract(1, 'week')
                        .format('YYYY-MM-DD'),
                'end-date': moment(now).subtract(1, 'day').day(6).subtract(1, 'week')
                        .format('YYYY-MM-DD')
            });

            Promise.all([thisWeek, lastWeek]).then(function (results) {

                var data1 = results[0].rows.map(function (row) {
                    return +row[2];
                });
                var data2 = results[1].rows.map(function (row) {
                    return +row[2];
                });
                var labels = results[1].rows.map(function (row) {
                    return +row[0];
                });

                labels = labels.map(function (label) {
                    return moment(label, 'YYYYMMDD').format('ddd');
                });

                var data = {
                    labels: labels,
                    datasets: [
                        {
                            label: 'Last Week',
                            fillColor: 'rgba(220,220,220,0.5)',
                            strokeColor: 'rgba(220,220,220,1)',
                            pointColor: 'rgba(220,220,220,1)',
                            pointStrokeColor: '#fff',
                            data: data2
                        },
                        {
                            label: 'This Week',
                            fillColor: 'rgba(151,187,205,0.5)',
                            strokeColor: 'rgba(151,187,205,1)',
                            pointColor: 'rgba(151,187,205,1)',
                            pointStrokeColor: '#fff',
                            data: data1
                        }
                    ]
                };

                new Chart(makeCanvas('chart-1-container')).Line(data);
                generateLegend('legend-1-container', data.datasets);
            });
        }


        /**
         * Draw the a chart.js bar chart with data from the specified view that
         * overlays session data for the current year over session data for the
         * previous year, grouped by month.
         */
        function renderYearOverYearChart(ids) {

            // Adjust `now` to experiment with different days, for testing only...
            var now = moment(); // .subtract(3, 'day');

            var thisYear = query({
                'ids': ids,
                'dimensions': 'ga:month,ga:nthMonth',
                'metrics': 'ga:users',
                'start-date': moment(now).date(1).month(0).format('YYYY-MM-DD'),
                'end-date': moment(now).format('YYYY-MM-DD')
            });

            var lastYear = query({
                'ids': ids,
                'dimensions': 'ga:month,ga:nthMonth',
                'metrics': 'ga:users',
                'start-date': moment(now).subtract(1, 'year').date(1).month(0)
                        .format('YYYY-MM-DD'),
                'end-date': moment(now).date(1).month(0).subtract(1, 'day')
                        .format('YYYY-MM-DD')
            });

            Promise.all([thisYear, lastYear]).then(function (results) {
                var data1 = results[0].rows.map(function (row) {
                    return +row[2];
                });
                var data2 = results[1].rows.map(function (row) {
                    return +row[2];
                });
                var labels = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                    'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];

                // Ensure the data arrays are at least as long as the labels array.
                // Chart.js bar charts don't (yet) accept sparse datasets.
                for (var i = 0, len = labels.length; i < len; i++) {
                    if (data1[i] === undefined)
                        data1[i] = null;
                    if (data2[i] === undefined)
                        data2[i] = null;
                }

                var data = {
                    labels: labels,
                    datasets: [
                        {
                            label: 'Last Year',
                            fillColor: 'rgba(220,220,220,0.5)',
                            strokeColor: 'rgba(220,220,220,1)',
                            data: data2
                        },
                        {
                            label: 'This Year',
                            fillColor: 'rgba(151,187,205,0.5)',
                            strokeColor: 'rgba(151,187,205,1)',
                            data: data1
                        }
                    ]
                };

                new Chart(makeCanvas('chart-2-container')).Bar(data);
                generateLegend('legend-2-container', data.datasets);
            })
                    .catch(function (err) {
                        console.error(err.stack);
                    });
        }


        /**
         * Draw the a chart.js doughnut chart with data from the specified view that
         * show the top 5 browsers over the past seven days.
         */
        function renderTopBrowsersChart(ids) {

            query({
                'ids': ids,
                'dimensions': 'ga:browser',
                'metrics': 'ga:pageviews',
                'sort': '-ga:pageviews',
                'max-results': 5
            })
                    .then(function (response) {

                        var data = [];
                        var colors = ['#4D5360', '#949FB1', '#D4CCC5', '#E2EAE9', '#F7464A'];

                        response.rows.forEach(function (row, i) {
                            data.push({value: +row[1], color: colors[i], label: row[0]});
                        });

                        new Chart(makeCanvas('chart-3-container')).Doughnut(data);
                        generateLegend('legend-3-container', data);
                    });
        }


        /**
         * Draw the a chart.js doughnut chart with data from the specified view that
         * compares sessions from mobile, desktop, and tablet over the past seven
         * days.
         */
        function renderTopCountriesChart(ids) {
            query({
                'ids': ids,
                'dimensions': 'ga:country',
                'metrics': 'ga:sessions',
                'sort': '-ga:sessions',
                'max-results': 5
            })
                    .then(function (response) {

                        var data = [];
                        var colors = ['#4D5360', '#949FB1', '#D4CCC5', '#E2EAE9', '#F7464A'];

                        response.rows.forEach(function (row, i) {
                            data.push({
                                label: row[0],
                                value: +row[1],
                                color: colors[i]
                            });
                        });

                        new Chart(makeCanvas('chart-4-container')).Doughnut(data);
                        generateLegend('legend-4-container', data);
                    });
        }


        /**
         * Extend the Embed APIs `gapi.analytics.report.Data` component to
         * return a promise the is fulfilled with the value returned by the API.
         * @param {Object} params The request parameters.
         * @return {Promise} A promise.
         */
        function query(params) {
            return new Promise(function (resolve, reject) {
                var data = new gapi.analytics.report.Data({query: params});
                data.once('success', function (response) {
                    resolve(response);
                })
                        .once('error', function (response) {
                            reject(response);
                        })
                        .execute();
            });
        }


        /**
         * Create a new canvas inside the specified element. Set it to be the width
         * and height of its container.
         * @param {string} id The id attribute of the element to host the canvas.
         * @return {RenderingContext} The 2D canvas context.
         */
        function makeCanvas(id) {
            var container = document.getElementById(id);
            var canvas = document.createElement('canvas');
            var ctx = canvas.getContext('2d');

            container.innerHTML = '';
            canvas.width = container.offsetWidth;
            canvas.height = container.offsetHeight;
            container.appendChild(canvas);

            return ctx;
        }


        /**
         * Create a visual legend inside the specified element based off of a
         * Chart.js dataset.
         * @param {string} id The id attribute of the element to host the legend.
         * @param {Array.<Object>} items A list of labels and colors for the legend.
         */
        function generateLegend(id, items) {
            var legend = document.getElementById(id);
            legend.innerHTML = items.map(function (item) {
                var color = item.color || item.fillColor;
                var label = item.label;
                return '<li><i style="background:' + color + '"></i>' + label + '</li>';
            }).join('');
        }


        // Set some global Chart.js defaults.
        Chart.defaults.global.animationSteps = 60;
        Chart.defaults.global.animationEasing = 'easeInOutQuart';
        Chart.defaults.global.responsive = true;
        Chart.defaults.global.maintainAspectRatio = false;


    });



    $(document).ready(function () {

        //	$(document.body).on('click','.gapi-analytics-auth-styles-signinbutton',function(){
        //		var temp = $('#embed-api-auth-container').children();
        //		var attr = $(temp[0]).attr('css')
        //		if(attr == "display: none;") {
        //			$('#datahide1').removeClass('hidden');
        //			$('#datahide2').removeClass('hidden');
        //		} else {
        //			$('#datahide1').addClass('hidden');
        //			$('#datahide2').addClass('hidden');
        //		}
        //	});

        var obj1 = $('#chart-container').children();
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
