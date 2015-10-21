<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i>
            GlobusTracker
            <span>
                Mobile Usability
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
</style>


<div class="row">
    <div class="col-md-3 text-center"  style="width: 40%;">
        <form action="#" id="formSubmit" class="form-inline" onsubmit="return getMobileUsabilityResults()">
            <input type="url" name="url" class="form-control" placeholder="http://www.abc.com" required="true" id="url_field" style="width: 70%;" />
            <input type="submit" value="GO" class="btn btn-primary" />
        </form>
    </div><br/>

    <div class="col-md-12 text-left" style="margin-top: 3%;">        
        <span id="loading" style="margin-left: 12%;"></span>
    </div>

    <div class="col-md-12 text-center" id="result-table">
        <div class="row">
            <div class="col-md-5 text-center" style="margin-left: 6%;">
                <div class="well">
                    <div>
                        <h3>Score</h3>
                        <span id="score" class="dyna"></span>
                    </div>
                    <div>
                        <span id="message"></span>
                    </div>
                </div>

                <div class="well" style="margin-top: 5%;">
                    <div>
                        <h3>Details</h3>
                        <div id="details" class="dyna"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-5 well text-center" style="margin-top: 5px; min-height: 622px;">
                <div>
                    <h3>Mobile View</h3>
                    <div id="mobile-view" class="dyna"></div>
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
        document.getElementById('score').insertBefore(i, null);

        if (pass) {
            $('#message').text('This page is mobile-friendly.');
        } else {
            $('#message').text('This page is not mobile-friendly');
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

        $('#details').append(html);
    }


</script>