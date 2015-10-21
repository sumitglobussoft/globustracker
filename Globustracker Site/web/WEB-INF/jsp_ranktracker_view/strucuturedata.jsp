<style>
    #custom tr td:first-child {
        font-weight: bold;
    }
    #id-meta {
        padding-left: 5% !important;
        padding-top: 2% !important;
    }
</style>

<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i> 
            GlobusTracker 
            <span>>
                Structured Data Testing Tool
            </span>
        </h1>
    </div>
</div>
<link href="../../views/css_ranktracker/codemirror.css" rel="stylesheet" type="text/css"/>


<!-- widget grid -->
<section id="widget-grid" class="">


    <!-- START ROW -->

    <div class="row">

        <!-- NEW COL START -->
        <article class="col-sm-12 col-md-12 col-lg-6">

            <!-- Widget ID (each widget will need unique ID)-->
            <div class="jarviswidget" id="wid-id-1" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
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
                <!--                <header>
                                    <span class="widget-icon"> <i class="fa fa-link"></i> </span>
                                    <h2>Fetch URL </h2>
                
                                </header>-->

                <!-- widget div-->
                <div style="border: medium none;" style="max-height: 500px; min-height: 387px;">

                    <!-- widget edit box -->
                    <div class="jarviswidget-editbox">
                        <!-- This area used as dropdown edit box -->

                    </div>
                    <!-- end widget edit box -->

                    <!-- widget content -->
                    <div class="widget-body " style="height: 474px;">

                        <form class="form-inline" role="form" id="form-Submit-Structured" onsubmit="return getStructuredDataResults()">                            
                            <fieldset>
                                <div class="form-group" style="width: 100%; display: inline-flex;">
                                    <label class="sr-only" for="Input1">URL</label>
                                    <input type="url" name="url" placeholder="http://www.abc.com" style="width: 100%;" required="true" class="form-control" id="url_field_data">
                                    <input type="submit" value="FETCH &amp; VALIDATE" class="btn btn-primary" style="font-size: 11px; margin-left: 1%;" />
                                </div>



                                <!--                                <button type="submit" class="btn btn-default">
                                                                    Clear
                                                                </button>-->
                            </fieldset>                            
                        </form>
                        <div class="col-md-12 text-left" style="margin-top: 3%; max-height: 10px;">        
                            <span id="loading" style="margin-left: 12%;"></span>
                        </div>
                        <form class="StructuredDataHide" style="position: relative; margin-top: .5em; display: none; height: 437px;">

                            <textarea id="id-html" style="resize: none;  padding-left: 3%; height: 410px; width: 100%;" cols="66" rows="16">
                            </textarea>
                        </form>               

                    </div>
                    <!-- end widget content -->

                </div>
                <!-- end widget div -->

            </div>
            <!-- end widget -->

        </article>
        <!-- END COL -->

        <!-- NEW COL START -->
        <article class="col-sm-12 col-md-12 col-lg-6 StructuredDataHide" style="display: none">

            <!-- Widget ID (each widget will need unique ID)-->
            <div class="jarviswidget" id="wid-id-2" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
                <header>
                    <span class="widget-icon"> <i class="fa fa-file-text-o"></i> </span>
                    <h2>Result </h2>
                </header>

                <!-- widget div-->
                <div style="overflow-y: auto; max-height: 370px;  min-height: 446px;">

                    <!-- widget edit box -->
                    <div class="jarviswidget-editbox">
                        <!-- This area used as dropdown edit box -->

                    </div>
                    <!-- end widget edit box -->

                    <!-- widget content -->
                    <div class="widget-body toappenddiv1" >

                        <!-- Widget ID (each widget will need unique ID)-->
                        <div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-0" data-widget-editbutton="false">
                            <!-- widget options:
                            -->
                            <header>
                                <span class="widget-icon"> <i class="fa fa-table"></i> </span>
                                <h2>Customised Search Result Filter</h2>
                            </header>
                            <!-- widget div-->
                            <div>
                                <!-- widget edit box -->
                                <div class="jarviswidget-editbox">
                                    <!-- This area used as dropdown edit box -->
                                </div>
                                <!-- end widget edit box -->
                                <!-- widget content -->
                                <div class="widget-body metadatahide" style="min-height: auto;">
                                    <div class="panel-group smart-accordion-default" id="accordion">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"> <i class="fa fa-lg fa-angle-down pull-right"></i> <i class="fa fa-lg fa-angle-up pull-right"></i> Customised Search Result Filters </a></h4>
                                            </div>
                                            <div id="collapseOne" class="panel-collapse collapse in">
                                                <div class="panel-body no-padding" id="id-meta">

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- end widget content -->
                            </div>
                            <!-- end widget div -->
                        </div>
                    </div>
                    <!-- end widget -->
                </div></div>
        </article>

        <!--        <div class="col-md-12 text-left" style="margin-top: 3%; max-height: 10px;">        
                    <span id="loading" style="margin-left: 12%;"></span>
                </div>-->
        <!-- END COL -->
    </div>
    <!-- END ROW -->
    <script src="../../views/js_ranktracker/codemirror.js" type="text/javascript"></script>
    <script src="../../views/js_ranktracker/xml.js" type="text/javascript"></script>
    <script type="text/javascript">

                            function getStructuredDataResults() {

                                $.ajax({
                                    type: "GET",
                                    url: "getStructuredToolsDetails.action",
                                    data: $("#form-Submit-Structured").serialize(),
                                    beforeSend: function () {

                                        $('#loading').text('Loading Please Wait...');
                                        $('.StructuredDataHide').hide();
                                        $('.CodeMirror-wrap').remove();

                                    },
                                    success: function (data) {

                                        $("#id-html").empty();
                                        $("#id-meta").empty();
                                        $(".productremove").remove();
                                        $('.StructuredDataHide').show();
                                        $('.toappenddiv1').show();
                                        $('#loading').text('');

                                        var xyz = JSON.parse(data);

                                        var result = JSON.parse(xyz.inputLine);

                                        console.log(result);

                                        var html = result.html;

                                        var html1 = html.replace(/</g, "&lt;");

                                        $("#id-html").append(html1);

                                        var splitmetaname = result.cse;

                                        if (splitmetaname.length > 0) {

                                            for (var i = 1; i < splitmetaname.length; i++) {

                                                var metaname = splitmetaname[i];

                                                $("#id-meta").append(metaname + "<br>");

                                            }

                                        } else {

                                            $("#id-meta").append("<center>No Data Avaliable</center>");

                                        }

                                        var tripleGroups = result.tripleGroups;

                                        for (var i = 0; i < tripleGroups.length; i++) {

                                            var toAppend = "";

                                            console.log("1-----" + result.tripleGroups[i].nodes[0].type.value);

                                            console.log("2-----" + result.tripleGroups[i].nodes[0].id);

                                            toAppend += '<div class="jarviswidget jarviswidget-color-blueDark productremove" id="wid-id-' + i + 1 + '" data-widget-editbutton="false">';
                                            toAppend += '   <header>';
                                            toAppend += '      <span class="widget-icon"> <i class="fa fa-table"></i> </span>';
                                            toAppend += '<h2>' + result.tripleGroups[i].type + '(1)</h2>';
                                            toAppend += '</header>';
                                            toAppend += '<div>';
                                            toAppend += '<div class="jarviswidget-editbox">';
                                            toAppend += '</div>';
                                            toAppend += '<div class="widget-body" style="min-height: auto;">';
                                            toAppend += '<div class="panel-group smart-accordion-default" id="accordion' + i + 1 + '">';
                                            toAppend += '<div class="panel panel-default">';
                                            toAppend += '<div class="panel-heading">';
                                            toAppend += '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion' + i + 1 + '" href="#collapse' + i + 1 + '" class="collapsed"> <i class="fa fa-lg fa-angle-down pull-right"></i> <i class="fa fa-lg fa-angle-up pull-right"></i>' + result.tripleGroups[i].nodes[0].type.value + '(1)</a></h4>';
                                            toAppend += '</div>';
                                            toAppend += '<div id="collapse' + i + 1 + '" class="panel-collapse collapse">';
                                            toAppend += '<div class="panel-body">';
                                            toAppend += '<div class="table-responsive">   ';
                                            toAppend += '<table class="table table-hover" id="custom">';
                                            toAppend += '<thead>';
                                            toAppend += '<tr>';
                                            toAppend += '</tr>';
                                            toAppend += '</thead>';
                                            toAppend += '<tbody class="datatabs">';
                                            toAppend += '<tr><td id="id-dataproduct' + i + '"></td>';
                                            toAppend += '<td id="id-dataproducturl' + i + '"></td>';
                                            toAppend += '</tr>';
                                            toAppend += '<tr>';
                                            toAppend += '<td id="id-dataimages' + i + '"></td>';
                                            toAppend += '<td id="id-dataimagesvalue' + i + '"></td>';
                                            toAppend += '</tr>';
                                            toAppend += '<tr>';
                                            toAppend += '<td id="id-datacurrency' + i + '"></td>';
                                            toAppend += '<td id="id-datacurrencyvalue' + i + '"></td>';
                                            toAppend += '</tr>';
                                            toAppend += '</tbody>';
                                            toAppend += '</table>   ';
                                            toAppend += '</div>';
                                            toAppend += '</div>';
                                            toAppend += '</div>';
                                            toAppend += '</div>';
                                            toAppend += '</div>';
                                            toAppend += '</div>';
                                            toAppend += '</div>';
                                            toAppend += '</div>';

                                            $('.toappenddiv1').append(toAppend);

                                            $('#id-dataproduct' + i).append(result.tripleGroups[i].nodes[0].type.value);

                                            $('#id-dataproducturl' + i).append(result.tripleGroups[i].nodes[0].id);

                                            for (var j = 0; j < result.tripleGroups[i].nodes.length; j++) {

                                                var nodesproperties = result.tripleGroups[i].nodes[j].properties;

                                                for (var k = 0; k < nodesproperties.length; k++) {

                                                    var nodespred = result.tripleGroups[i].nodes[j].properties[k].pred;

                                                    var nodesvalue = result.tripleGroups[i].nodes[j].properties[k].value;

                                                    console.log("Images Url : " + nodespred);

                                                    console.log("Name Desc  : " + nodesvalue);

                                                    $('#id-dataimages' + i).append(nodespred + "<br>");

                                                    $('#id-dataimagesvalue' + i).append(nodesvalue + "<br>");

                                                }

                                                var offers = result.tripleGroups[i].nodes[j].nodeProperties;

                                                var offersTab = "";

                                                if (offers.length > 0) {

                                                    offersTab += '<tr>';

                                                    offersTab += '<td id="id-dataoffer' + i + '"></td>';

                                                    offersTab += '<td id="id-dataofferurl' + i + '"></td>';

                                                    offersTab += '</tr>';

                                                    $(".datatabs").append(offersTab);

                                                }

                                                for (var m = 0; m < offers.length; m++) {

                                                    var offer = result.tripleGroups[i].nodes[j].nodeProperties[m].pred;

                                                    console.log("Offers : " + offer);

                                                    var offerurl = result.tripleGroups[i].nodes[j].nodeProperties[m].target.id;

                                                    console.log("offer url : " + offerurl);

                                                    $('#id-dataoffer' + i).append(offer);

                                                    $('#id-dataofferurl' + i).append(offerurl);

                                                    var price = result.tripleGroups[i].nodes[j].nodeProperties[m].target.properties;

                                                    for (var x = 0; x < price.length; x++) {

                                                        var preddata = result.tripleGroups[i].nodes[j].nodeProperties[m].target.properties[x].pred;

                                                        var valuedata = result.tripleGroups[i].nodes[j].nodeProperties[m].target.properties[x].value;

                                                        console.log(result.tripleGroups[i].nodes[j].nodeProperties[m].target.properties[x].pred);

                                                        console.log(result.tripleGroups[i].nodes[j].nodeProperties[m].target.properties[x].value);

                                                        $('#id-datacurrency' + i).append(preddata + "<br>");

                                                        $('#id-datacurrencyvalue' + i).append(valuedata + "<br>");

                                                    }
                                                }
                                            }
                                        }

                                        $('.tempclass').removeClass('hidden');

                                        var editor = CodeMirror.fromTextArea(document.getElementById("id-html"), {
                                            mode: "application/xml",
                                            styleActiveLine: true,
                                            lineNumbers: true,
                                            lineWrapping: true

                                        });
                                        $('#id-html').html('');
                                        $('#id-html').css('display', 'block');
                                        $('.CodeMirror-wrap').css('height', '402px');
//                                        $('.CodeMirror-wrap').addClass('CodeMirror-focused');
                                        $('#id-html').css('height', '0px');
                                        $('.CodeMirror-vscrollbar').scrollTop('1000');

                                    },
                                    error: function (data) {
                                        console.log(data);
                                        $("#StructuredDataHide").hide();
                                    }
                                });
                                return false;
                            }
    </script>

</section>
<!-- end widget grid -->
