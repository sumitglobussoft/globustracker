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
            GlobusTracker
            <span>
                Speed Analysis
            </span>
        </h1>
    </div>
</div>

<div class="row">
    <div class="col-md-3 text-center"  style="width: 40%;">
        <!--<h1><b>Web Page Speed Test Tool</b></h1><hr /><br />-->
        <form action="#" id="formSubmit" class="form-inline" onsubmit="return getPageSpeedResults()">
            <input type="url" name="url" class="form-control" placeholder="http://www.abc.com" style="width: 70%;" required="true" id="url_field" />
            <input type="submit" class="btn btn-primary" value="GO" />
        </form>
    </div><br/>

     <div class="col-md-12 text-left" style="margin-top: 3%;">
        <span id="loading" style="margin-left: 12%;"></span>
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