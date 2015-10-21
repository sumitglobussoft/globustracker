<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i>
            GlobusTracker
            <span>
                Accurate Local Ranking > Places Listings
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
    <div class="col-md-3 text-center"  style="width: 40%;">
        <form action="#" id="formSubmit" class="form-inline" onsubmit="return getPlacesList()">
            <input type="url" name="url" class="form-control" placeholder="http://www.abc.com" required="true" id="url_field" style="width: 70%;" />
            <input type="submit" value="GO" class="btn btn-primary" />
        </form>
    </div><br/>

    <div class="col-md-12 text-left" style="margin-top: 3%;">        
        <span id="loading" style="margin-left: 12%;"></span>
    </div>

    <div class="col-md-12 text-center" id="result-table" class="dyna">

    </div>
</div>

<script type="text/javascript">

    var CHART_API_URL = 'http://chart.apis.google.com/chart?';

    function getPlacesList() {

        $.ajax({
            type: "GET",
            url: "getplaceslist.action",
            data: $("#formSubmit").serialize(),
            beforeSend: function (data) {
                $('#loading').text('Loading Please Wait...');
                $('.dyna').empty();
                $('#result-table').css('visibility', 'hidden');
            },
            success: function (data) {
                $('#loading').text('');
                $('#result-table').empty();
                var result = JSON.parse(data);
                $('#result-table').css('visibility', 'visible');
                try {
                    showResult(result);
                } catch (err) {
                }
            }
        });
        return false;
    }


    function showResult(data) {

        var html = '<table border=\'1\' class=\'table table-striped table-hover\' >';
        html = html + "<thead><th><b> NAME </b></th><th><b> ICON </b></th><th><b> VICINITY </b></th><th><b> TYPE </b></th></thead>";

        for (var i = 0; i < data.results.length; i++) {
            var result = data.results[i];
            html = html + "<tr>";

            html = html + "<td>" + result.name + "</td>";
            html = html + "<td><image src='" + result.icon + "' width='20px'/></td>";
            html = html + "<td>" + result.vicinity + "</td>";
            html = html + "<td>";
            for (var j = 0; j < result.types.length; j++) {
                html = html + result.types[j];
                if (j < (result.types.length - 1)) {
                    html = html + ",";
                }
            }
            html = html + "</td>";




            html = html + "</tr>";
        }

        html = html + '</table>';

        $('#result-table').append(html);
    }


</script>