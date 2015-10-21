<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i>
            GlobusTracker
            <span>
                Link Analysis
            </span>
        </h1>
    </div>
</div>
<style>
    .dyna{
        visibility: hidden;
    }
    .dyna-title{
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
    <div class="col-md-3 text-center"  style="width: 40%;">
        <form action="#" id="formSubmit" class="form-inline" onsubmit="return getLinkAnalysisResults()">
            <input type="url" name="url" class="form-control" placeholder="http://www.abc.com" required="true" id="url_field" style="width: 70%;" />
            <input type="submit" value="GO" class="btn btn-primary" />
        </form>
    </div><br/>

    <div class="col-md-12 text-left" style="margin-top: 3%;">        
        <span id="loading" style="margin-left: 12%;"></span>
    </div>
    <center class="dyna-title"><b><h3>URL METRICS</h3></b></center>
    <div class="col-md-12 text-center" id="url-metrics-result-table" class="dyna">

    </div>

    <center class="dyna-title"><b><h3>LINK METRICS</h3></b></center>
    <div class="col-md-12 text-center" id="link-metrics-result-table" class="dyna">

    </div>

</div>

<script type="text/javascript">

    var CHART_API_URL = 'http://chart.apis.google.com/chart?';

    function getLinkAnalysisResults() {

        $.ajax({
            type: "GET",
            url: "getLinkAnalysisData.action",
            data: $("#formSubmit").serialize(),
            beforeSend: function (data) {
                $('#loading').text('Loading Please Wait...');
                $('.dyna').empty();
            },
            success: function (data) {
                $('#loading').text('');
                $('.dyna-title').css('visibility', 'visible');
                var result = JSON.parse(data);
                $('.dyna').css('visibility', 'visible');

                try {
                    showUrlMetrics(result);
                } catch (err) {
                }

                try {
                    showLinkMetrics(result);
                } catch (err) {
                }
            }
        });
        return false;
    }

    function showUrlMetrics(data) {

        var urlMetrics = data.moz_details.url_metrics;

        var html = '<table border=\'1\' class=\'table table-striped table-hover\' >';
        html = html + "<thead><th><b> DOMAIN AUTHORITY </b></th><th><b> EXTERNAL EQUITY LINKS </b></th><th><b> PAGE AUTHORITY </b></th><th><b> HTTP STATUS CODE </b></th><th><b> MOZRANK URL </b></th><th><b> LINKS </b></th><th><b> TITLE </b></th><th><b> CANONICAL URL </b></th><th><b> MOZRANK SUBDOMAIN </b></th></thead>";

        html = html + "<tr>";

        html = html + "<td>" + parseFloat(urlMetrics.domain_authority).toFixed(2) + "</td>";
        html = html + "<td>" + urlMetrics.external_equity_links + "</td>";
        html = html + "<td>" + parseFloat(urlMetrics.page_authority).toFixed(2) + "</td>";
        html = html + "<td>" + urlMetrics.http_status_code + "</td>";
        html = html + "<td>" + parseFloat(urlMetrics.mozrank_url).toFixed(2) + "</td>";
        html = html + "<td>" + urlMetrics.links + "</td>";
        html = html + "<td>" + urlMetrics.title + "</td>";
        html = html + "<td>" + urlMetrics.canonical_url + "</td>";
        html = html + "<td>" + parseFloat(urlMetrics.mozrank_subdomain).toFixed(2) + "</td>";

        html = html + "</tr>";

        html = html + '</table>';

        $('#url-metrics-result-table').empty();
        $('#url-metrics-result-table').append(html);
    }

    function showLinkMetrics(data) {

        var html = '<table border=\'1\' class=\'table table-striped table-hover\' >';
        html = html + "<thead><th><b> SN. </b></th><th><b> DOMAIN AUTHORITY </b></th><th><b> EXTERNAL EQUITY LINKS </b></th><th><b> PAGE AUTHORITY </b></th><th><b> HTTP STATUS CODE </b></th><th><b> MOZRANK URL </b></th><th><b> LINKS </b></th><th><b> TITLE </b></th><th><b> CANONICAL URL </b></th><th><b> MOZRANK SUBDOMAIN </b></th></thead>";

        var linkMetrics = data.moz_details.link_metrics;

        for (var i = 0; i < linkMetrics.length; i++) {
            var link = linkMetrics[i];

            html = html + "<tr>";

            html = html + "<td>" + (i + 1) + "</td>";
            html = html + "<td>" + parseFloat(link.domain_authority).toFixed(2) + "</td>";
            html = html + "<td>" + link.external_equity_links + "</td>";
            html = html + "<td>" + parseFloat(link.page_authority).toFixed(2) + "</td>";
            html = html + "<td>" + link.http_status_code + "</td>";
            html = html + "<td>" + parseFloat(link.mozrank_url).toFixed(2) + "</td>";
            html = html + "<td>" + link.links + "</td>";
            html = html + "<td>" + link.title + "</td>";
            html = html + "<td>" + link.canonical_url + "</td>";
            html = html + "<td>" + parseFloat(link.mozrank_subdomain).toFixed(2) + "</td>";


            html = html + "</tr>";
        }
        html = html + '</table>';

        $('#link-metrics-result-table').empty();
        $('#link-metrics-result-table').append(html);
    }


</script>