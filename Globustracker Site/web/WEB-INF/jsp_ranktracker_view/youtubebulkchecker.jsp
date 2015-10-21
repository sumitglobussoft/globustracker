
<%
    if (session.getAttribute("customerID") == null) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.sendRedirect("home.action");
    }
%> 

<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i> 
            GlobusTracker
            <span>> 
                YouTube Bulk Checker
            </span>
        </h1>
    </div>
</div>

<!-- START ROW -->
<div class="row">

    <!-- NEW COL START -->
    <article class="col-sm-12 col-md-12 col-lg-12">

        <!-- Widget ID (each widget will need unique ID)-->
        <div class="jarviswidget" id="wid-id-0" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
            <!-- widget options:
            usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

            data-widget-colorbutton="false"
            data-widget-editbutton="false"
            data-widget-togglebutton="false"
            data-widget-deletebutton="false"
            data-widget-fullscreenbutton="false"
            data-widget-custombutton="false"
            data-widget-collapsed="true"
            data-widget-sortable="false"

            -->
            <header>
                <span class="widget-icon"> <i class="fa fa-youtube"></i> </span>
                <h2>Add Youtube Links</h2>
            </header>

            <div class="panel-body">
                <div class="row">
                    <div class="col-md-6">
                        <input type="file" class="filestyle" name="file" id="file" data-buttonName="btn-primary"> <br />
                    </div>                    
                    <div class="col-md-1">
                        <input type="button" class="btn btn-primary" value="Check" onclick="go()">
                    </div>
                    <div class="col-md-2">
                        <a onclick="return ExcellentExport.excel(this, 'example', 'Youtube Bulk Checker');" href="#" title="Export to Excel" download="YoutubeChecker.xls"><img style="width: 20%;" src="https://s3.amazonaws.com/images-globustracker/img-xls-icon.png"></a>
                        <!--<a onclick="return ExcellentExport.csv(this, 'example');" href="#" title="Export to CSV" download="YoutubeChecker.csv"><img style="width: 20%; margin-left: 2%;" src="https://s3.amazonaws.com/images-globustracker/img-csv-icon.png"></a>-->
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <p><span class="text-danger">NOTE:</span> Please upload only "txt" file which contains List of YouTube links.</p>
                    </div>
                </div>
            </div>
    </article>
</div>

<div class="container" style="margin-top: 5%; width: 100%;" id="tableData">
    <section>
        <table id="example" class="display" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ACTIVE</th>
                    <th>TITLE</th>                           
                    <th>VIEWS</th>
                    <th>LIKES</th>
                    <th>DISLIKES</th>
                    <th>FAVORITES</th>
                    <th>COMMENTS</th>
                </tr>
            </thead>
        </table>
    </section>
</div>

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="views/js_ranktracker/excellentexport.js" type="text/javascript"></script>
<script src="views/js_ranktracker/bootstrap-filestyle.min.js" type="text/javascript"></script>



<script>
    $(":file").filestyle({buttonName: "btn-primary"});
</script>

<script type="text/javascript">
    
    //    function exportData() {
    //
    //        var $rows = $("#example").find('tr:has(td)'),
    //        // Temporary delimiter characters unlikely to be typed by keyboard
    //        // This is to avoid accidentally splitting the actual contents
    //        tmpColDelim = String.fromCharCode(11), // vertical tab character
    //        tmpRowDelim = String.fromCharCode(0), // null character
    //
    //        // actual delimiter characters for CSV format
    //        colDelim = '","',
    //        rowDelim = '"\r\n"',
    //        // Grab text from table into CSV formatted string
    //        csv = '"' + $rows.map(function(i, row) {
    //            var $row = $(row),
    //            $cols = $row.find('td');
    //
    //            return $cols.map(function(j, col) {
    //                var $col = $(col),
    //                text = $col.text();
    //
    //                return text.replace('"', '""'); // escape double quotes
    //
    //            }).get().join(tmpColDelim);
    //
    //        }).get().join(tmpRowDelim)
    //        .split(tmpRowDelim).join(rowDelim)
    //        .split(tmpColDelim).join(colDelim) + '"',
    //        // Data URI
    //        csvData = 'data:application/csv;charset=utf-8,' + encodeURIComponent(csv);
    //
    //        $(this)
    //        .attr({
    //            'download': 'export.csv',
    //            'href': csvData,
    //            'target': '_blank'
    //        });
    //    }

    function parseJsonAndShowResult(data, totalid) {

        var receivedId = "";
        var output = JSON.parse(data);

        for (i = 0; i < output.items.length; i++) {
            receivedId = receivedId + output.items[i].id;
            var t = $('#example').DataTable();
            t.row.add([
                output.items[i].id,
                'Yes',
                output.items[i].snippet.title,
                output.items[i].statistics.viewCount,
                output.items[i].statistics.likeCount,
                output.items[i].statistics.dislikeCount,
                output.items[i].statistics.favoriteCount,
                output.items[i].statistics.commentCount
            ]).draw();

        }
        var tid = totalid;
        var temp = tid.replace(/(\r\n|\n|\r)/gm, "").split("#");

        console.log('R: ' + receivedId);
        console.log('T: ' + tid.replace(/(\r\n|\n|\r)/gm, ""));
        for (i = 1; i < temp.length; i++) {

            if (!(receivedId.indexOf(temp[i]) > -1)) {
                console.log('NOT FOUND: ' + temp[i]);
                var t = $('#example').DataTable();
                t.row.add([
                    temp[i],
                    'No',
                    '-',
                    '-',
                    '-',
                    '-',
                    '-',
                    '-'
                ]).draw();

            }
            totalid = "";
        }
    }
    
    function ajaxFunction(urlvar, totalid) {
        var ajaxRequest; // The variable that makes Ajax possible!

        try {
            // Opera 8.0+, Firefox, Safari
            ajaxRequest = new XMLHttpRequest();
        } catch (e) {
            //                                    // Internet Explorer Browsers
            try {
                ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {
                    // Something went wrong
                    alert('Your browser broke!');
                }
            }
        }

        ajaxRequest.onreadystatechange = function() {
            if (ajaxRequest.readyState === 4) {
                var result = ajaxRequest.responseText.toString();
                parseJsonAndShowResult(result, totalid);
            }
        };
        ajaxRequest.open("GET", "https://www.googleapis.com/youtube/v3/videos?id=" + urlvar + "&key=AIzaSyATdQ4Z8Sh1PiNsgMmw90L5NALRJdiI_No&part=id,statistics,snippet", false);
        ajaxRequest.send(null);
    }

    function go() {   
        
        var table = $('#example').DataTable();
        table.clear().draw();
    
        var urlvariable = "";
        var file = document.getElementById('file').files[0];
        var reader = new FileReader();
        reader.onload = function() {
            var totalid = "";
            var lines = this.result.split('\n');
            var count = 0;
            for (var line = 0; line < lines.length; line++) {

                count++;
                var id = lines[line] + "";

                if (id.indexOf("www.youtube") > -1) {

                    var parameterValue = decodeURIComponent(id.match(/(\?|&)v\=([^&]*)/)[2]);
                    id = parameterValue;

                }

                else if (id.indexOf("http://youtu") > -1) {
                    id = id.split(".be/")[1];
                }

                totalid = totalid + "#" + id;
                urlvariable = urlvariable + id + ',';
                if (count > 45) {
                    count = 0;
                    ajaxFunction(urlvariable, totalid);
                    urlvariable = "";
                    totalid = "";
                }
            }

            ajaxFunction(urlvariable);
        };
        reader.readAsText(file);
    }

</script>
