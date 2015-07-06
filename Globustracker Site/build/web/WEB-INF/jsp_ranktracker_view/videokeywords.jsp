<%@ taglib prefix="s" uri="/struts-tags"%>

<%
    if (session.getAttribute("customerID") == null) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.sendRedirect("home.action");
    }
%> 
<style>
    ul.dropdownlist
    { 
        float: left;
        height: auto;
        padding: 0;
        position: relative;
        width: 350px; 
        background: #fff;
    }

    #keypopup {
        border: 1px solid #dfdfdf;
        font-family: "Trebuchet MS",Arial,Helvetica,sans-serif;
        width: 76.4%;
    }

    #keypopup td {
        color: #333;
        cursor: pointer;
    }

    #keypopup td:hover {
        background: none repeat scroll 0 0 #ccc;
    }
</style>

<div class="row">
    <div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i> 
            GlobusTracker
            <span>> 
                Video Campaign : <s:property value="campaignName" />
            </span>
        </h1>
    </div>

</div>

<div id="fade_away" style="color:#FF0000;">
    <s:actionmessage />
</div>

<!-- widget grid -->
<section id="widget-grid" class="">
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
                    <span class="widget-icon"> <i class="fa fa-clock-o"></i> </span>
                    <h2>Keywords Up</h2>
                </header>
                <s:if test="%{getRankComparision().isEmpty()}"> 
                </s:if>

                <s:else>
                    <!-- widget div-->
                    <div>
                        <!-- start row -->
                        <div class="row">
                            <div class="col-sm-12 col-md-12 col-lg-12">

                                <div class="well">

                                    <div class="row">
                                        <s:iterator value="rankComparision">

                                            <div class="col-md-offset-1 col-sm-2">

                                                <div class="well well-sm bg-color-teal txt-color-white text-center">
                                                    <h5>Top 5</h5>
                                                    <code><s:property value="keywordsRankBelow5" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="well well-sm bg-color-pinkDark txt-color-white text-center">
                                                    <h5>Top 10</h5>
                                                    <code><s:property value="keywordsRankBelow10" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="well well-sm text-center">
                                                    <h5>Top 20</h5>
                                                    <code><s:property value="keywordsRankBelow20" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="well well-sm bg-color-pinkDark txt-color-white text-center">
                                                    <h5>Top 30</h5>
                                                    <code><s:property value="keywordsRankBelow30" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="well well-sm bg-color-teal txt-color-white text-center">
                                                    <h5>Top 100</h5>
                                                    <code><s:property value="keywordsRankBelow100" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>
                                        </s:iterator>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->
                    </div>
                    <!-- end widget div -->
                </s:else>
            </div>
            <!-- end widget -->
        </article>
        <!-- END COL -->
    </div>
    <!-- END ROW -->

    <!-- row -->
    <div class="row">

        <!-- NEW WIDGET START -->
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
                    <ul class="nav nav-tabs pull-left in">
                        <li class="active">
                            <a data-toggle="tab" href="#hr1"><span class="hidden-mobile hidden-tablet"> VIDEO </span></a>
                        </li>
                    </ul>
                    <div class="widget-toolbar">
                        <div class="btn-group">
                            <button class="btn btn-xs dropdown-toggle btn-primary" data-toggle="dropdown">
                                + Add Video <i class="fa fa-caret-down"></i>
                            </button>
                            <ul class="dropdown-menu js-status-update pull-right">
                                <li>
                                    <a data-toggle="modal" data-target="#addsinglemodal">Single</a>
                                </li>
                                <li>
                                    <a data-toggle="modal" data-target="#addmulmodal">Multiple</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </header>

                <!-- widget div-->
                <div>

                    <!-- widget edit box -->
                    <div class="jarviswidget-editbox">
                        <!-- This area used as dropdown edit box -->

                    </div>
                    <!-- end widget edit box -->

                    <!-- widget content -->
                    <div class="widget-body">

                        <div class="tab-content">
                            <div class="tab-pane active" id="hr1">
                                <div class="tabbable tabs-below">
                                    <div class="tab-content padding-10">
                                        <div class="tab-pane active" id="AA">
                                            <table class="table table-bordered table-condensed">

                                                <thead>
                                                    <tr>
                                                        <th style="text-align: center;">Keyword</th>
                                                        <th style="text-align: center;" colspan="2"><img src="https://s3.amazonaws.com/images_ranktracker/youtubeicon.png"  style="border:none;" width="24" height="24" alt="" /></th>
                                                        <th style="text-align: center;" colspan="2"><img src="https://s3.amazonaws.com/images_ranktracker/dailymotion_24.png" style="border:none;" width="24" height="24" alt=""/></th>
                                                        <th style="text-align: center;" colspan="2"><img src="https://s3.amazonaws.com/images_ranktracker/vimeo_logo.JPG" style="border:none;" width="24" height="24" alt="" /></th> 
                                                        <th style="text-align: center;" colspan="2"><img src="https://s3.amazonaws.com/images_ranktracker/metacafe_logo.png" style="border:none;" width="24" height="24" alt="" /></th>
                                                        <th style="text-align: center;">Chart</th>
                                                        <th style="text-align: center;">Edit</th>                                                
                                                        <th style="text-align: center;">Delete</th>   
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <s:iterator value="videotrackhst">
                                                        <tr>
                                                            <td style="text-align: left;"><s:property value="videoKeyword" /></td>
                                                            <td title="<s:property value="youtubeURL" />"><s:property value="youtubeURL" /></td>
                                                            <s:if test="%{rankYoutube!=501 }">
                                                                <td style="text-align: center;"><s:property value="rankYoutube" /></td>
                                                            </s:if>
                                                            <s:else>
                                                                <td style="text-align: center;">N/A</td>
                                                            </s:else>
                                                            <td title="<s:property value="dailymotionURL" />"><s:property value="dailymotionURL" /></td>
                                                            <s:if test="%{rankDailyMotion!=501 }">
                                                                <td style="text-align: center;"><s:property value="rankDailyMotion" /></td>
                                                            </s:if>
                                                            <s:else >
                                                                <td style="text-align: center;">N/A</td>
                                                            </s:else>
                                                            <td title="<s:property value="vimeoURL" />"><s:property value="vimeoURL" /></td>
                                                            <s:if test="%{rankVimeo!=501 }">
                                                                <td style="text-align: center;"><s:property value="rankVimeo" /></td>
                                                            </s:if>
                                                            <s:else >
                                                                <td style="text-align: center;">N/A</td>
                                                            </s:else>
                                                            <td title="<s:property value="metacafeURL" />"><s:property value="metacafeURL" /></td>
                                                            <s:if test="%{rankMetacafe!=501 }">
                                                                <td style="text-align: center;"><s:property value="rankMetacafe" /></td>
                                                            </s:if>
                                                            <s:else >
                                                                <td style="text-align: center;">N/A</td>
                                                            </s:else>
                                                            <td style="text-align: center;"><a href="javascript:drawVideoChart('<s:property value="videokeywordID"/>','30');" id="google_chart" title="Chart"><i class="fa fa-2x fa-bar-chart-o" data-toggle="modal" data-target="#chartmodal"></i></a></td>
                                                            <td style="text-align: center;"><a href="javascript:editKeyword(<s:property value="videokeywordID" />, '<s:property value="youtubeURL" />','<s:property value="dailymotionURL" />','<s:property value="vimeoURL" />', '<s:property value="metacafeURL" />','<s:property value="videoKeyword" />');" id="edit" title="Edit"><i class="fa fa-pencil fa-2x txt-color-yellow" data-toggle="modal" data-target="#editmodal"></i></a></td>
                                                            <td style="text-align: center;"><a href="javascript:deleteKeyword(<s:property value="videokeywordID"/>);" title="Delete"><i class="fa fa-trash-o fa-2x" data-toggle="modal" data-target="#deletemodal"></i></a></td>    
                                                        </tr>
                                                    </s:iterator>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end widget content -->
                </div>
                <!-- end widget div -->
            </div>
            <!-- end widget -->
        </article>
        <!-- WIDGET END -->
    </div>
    <!-- end row -->

    <!--edit Modal -->
    <s:form action="" onsubmit="return false;" id="editForm">
        <div class="modal fade" id="editmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Edit !</h4>
                    </div>
                    <div class="modal-body">
                        <!-- widget content -->
                        <div class="widget-body no-padding">
                            <div class="smart-form">

                                <fieldset>					
                                    <div class="row">
                                        <s:hidden name="keywordId" id="keywordId" />
                                        <section class="col col-6">
                                            <label class="label">Youtube Url</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-link"></i>
                                                <input type="text" name="edityoutubeurl" id="youtubeurl">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="label">Dailymotion Url</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-link"></i>
                                                <input type="text" name="editdailymotionurl" id="dailymotionurl">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="label">Vimeo Url</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-link"></i>
                                                <input type="text" name="editvimeourl" id="vimeourl">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="label">Metacafe Url</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-link"></i>
                                                <input type="text" name="editmetacafeurl" id="metacafeurl">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <span style="color: black; font-size: 13px;">Keyword</span>
                                            <span style="margin-left: 68px;  font-size: 13px;">
                                                <input type="checkbox" name="editcheck" id="editcheckbox"/>
                                                Keyword Suggestion
                                            </span>
                                            <label class="input">
                                                <i class="icon-append fa fa-comment"></i>
                                                <input type="text" name="editkeyword" id="editkeyword" onkeyup="editfilterChanged();"/>
                                                <ul class="dropdownlist"  style=" display: block;"  >
                                                    <table id="keypopup">
                                                        <tbody id="editpeoplebody" >
                                                        </tbody>
                                                    </table>
                                                </ul>
                                            </label>
                                        </section>
                                    </div>			

                                </fieldset>
                            </div>				

                        </div>
                        <!-- end widget content -->
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="return editVideoKeyword();">Edit Keyword</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of model-->

    <!--Add Single Modal -->
    <s:form action="" onsubmit="return false;" id="addForm">
        <div class="modal fade" id="addsinglemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Add Single !</h4>
                    </div>
                    <div class="modal-body">
                        <!-- widget content -->
                        <div class="widget-body no-padding">

                            <div class="smart-form">

                                <fieldset>					
                                    <div class="row">
                                        <section class="col col-6">
                                            <label class="label">Youtube Url</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-link"></i>
                                                <input type="text" name="youtubeurl" id="youtubeurl">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="label">Dailymotion Url</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-link"></i>
                                                <input type="text" name="dailymotionurl" id="dailymotionurl">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="label">Vimeo Url</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-link"></i>
                                                <input type="text" name="vimeourl" id="vimeourl">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="label">Metacafe Url</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-link"></i>
                                                <input type="text" name="metacafeurl" id="metacafeurl">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <span style="color: black; font-size: 13px;">Keyword</span>
                                            <span style="margin-left: 68px;  font-size: 13px;">
                                                <input type="checkbox" name="check" id="checkbox"/>
                                                Keyword Suggestion
                                            </span>
                                            <label class="input">
                                                <i class="icon-append fa fa-comment"></i>
                                                <input type="text" name="videokeyword" id="videokeyword" onkeyup="filterChanged();"/>
                                                <ul class="dropdownlist"  style=" display: block;"  >
                                                    <table id="keypopup">
                                                        <tbody id="peoplebody" >
                                                        </tbody>
                                                    </table>
                                                </ul>
                                            </label>
                                        </section>
                                    </div>			

                                </fieldset>
                            </div>						

                        </div>
                        <!-- end widget content -->
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="return addVideoKeyword();">Add Video</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of addsingle model-->

    <!--Add Multiple Modal -->
    <s:form action="" onsubmit="return false;" id="addForm2">
        <div class="modal fade" id="addmulmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Add Multiple !</h4>
                    </div>
                    <div class="modal-body">
                        <!-- widget content -->
                        <div class="widget-body no-padding">

                            <div class="smart-form">

                                <fieldset>					
                                    <div class="row">
                                        <section class="col col-6">
                                            <label class="label">Youtube Url</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-link"></i>
                                                <input type="text" name="youtubeurl" id="youtubeurls">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="label">Dailymotion Url</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-link"></i>
                                                <input type="text" name="dailymotionurl" id="dailymotionurls">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="label">Vimeo Url</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-link"></i>
                                                <input type="text" name="vimeourl" id="vimeourls">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="label">Metacafe Url</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-link"></i>
                                                <input type="text" name="metacafeurl" id="metacafeurls">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <span style="color: black; font-size: 13px;">Keyword</span>
                                            <span style="margin-left: 68px;  font-size: 13px;">
                                                <input type="checkbox" name="checks" id="checkboxs"/>
                                                Keyword Suggestion
                                            </span>
                                            <label class="textarea">
                                                <textarea rows="4" cols="5" name="videokeywords" id="videokeywords" onkeyup="filterChangeds();"></textarea>
                                                <ul class="dropdownlist"  style=" display: block;"  >
                                                    <table id="keypopup">
                                                        <tbody id="peoplebodys" >
                                                        </tbody>
                                                    </table>
                                                </ul>
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <p>Note: New line character(Shift+Enter) should be given after each keyword</p>
                                        </section>
                                    </div>			

                                </fieldset>
                            </div>						

                        </div>
                        <!-- end widget content -->
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="return addVideoKeywords();">Add Video</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of addmul model-->


    <!--delete Modal -->
    <s:form action="" onsubmit="return false;" id="deleteForm">
        <div class="modal fade" id="deletemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Delete !</h4>
                    </div>
                    <div class="modal-body">
                        <h4>Are you sure, you want to delete this? Lost logs cannot be retrieved again.</h4>
                        <input class="form-control" type="hidden" name="videoKeywordId" id="videoKeywordId" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default btn-danger" onclick="deleteVideoKeyword();">Yes</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of model-->

    <!--chart Modal -->
    <div class="modal fade" id="chartmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
        <div class="modal-dialog" style="width: 1200px;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">View Counts Of Videos</h4>
                </div>
                <div class="modal-body">
                    <div id="chartBlock">
                    </div> 	
                </div>
                <div class="modal-footer">

                </div>
            </div>
        </div>
    </div>
    <!--end of model-->

</section>
<!-- end widget grid -->

<!--script for keyword suggestion-->
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/interface/Keywordsuggestion.js'></script>
<script type="text/javascript">
    function filterChanged() {
        if (document.getElementById("checkbox").checked) {
            dwr.util.removeAllRows("peoplebody");
            var addkeywords = dwr.util.getValue("videokeyword");
            if (addkeywords.length === 0) {
                dwr.util.removeAllRows("peoplebody");
            } else {
                Keywordsuggestion.getMatchingforKeywords(addkeywords, fillTable);
            }
        }
        else {
            dwr.util.removeAllRows("peoplebody");
        }
    }
    function fillTable(people) {
        var addkeywords = dwr.util.getValue("videokeyword");
        var filtered = [];
        dwr.util.removeAllRows("peoplebody");
        for (i = 0; i < people.length; i++) {
            filtered.push(people[i]);
        }
        if (filtered.length !== 0) {
            dwr.util.addRows("peoplebody", filtered, [
                function(element) {
                    return element;
                }
            ], {escapeHtml: false});
        }
    }
    function filterChangeds() {
        if (document.getElementById("checkboxs").checked) {
            dwr.util.removeAllRows("peoplebodys");
            var addkeywords = dwr.util.getValue("videokeywords");
            if (addkeywords.length === 0) {
                dwr.util.removeAllRows("peoplebodys");
            } else {
                Keywordsuggestion.getMatchingforKeywords(addkeywords, fillTables);
            }
        }
        else {
            dwr.util.removeAllRows("peoplebodys");
        }
    }
    function fillTables(people) {
        var addkeywords = dwr.util.getValue("videokeywords");
        var pattern = new RegExp("(" + addkeywords + ")", "i");
        var filtered = [];
        dwr.util.removeAllRows("peoplebodys");
        for (i = 0; i < people.length; i++) {
            filtered.push(people[i]);
        }
        if (filtered.length !== 0) {
            dwr.util.addRows("peoplebodys", filtered, [
                function(element) {
                    return  element;
                }
            ], {escapeHtml: false});
        }
    }
    function editfilterChanged() {
        if (document.getElementById("editcheckbox").checked) {

            var addkeywords = dwr.util.getValue("editkeyword");
            if (addkeywords.length === 0) {
                dwr.util.removeAllRows("editpeoplebody");
            } else {
                Keywordsuggestion.getMatchingforKeywords(addkeywords, editfillTable);
            }
        }
        else {
            dwr.util.removeAllRows("editpeoplebody");
        }
    }
    function editfillTable(people) {
        var addkeywords = dwr.util.getValue("editkeyword");
        var filtered = [];
        dwr.util.removeAllRows("editpeoplebody");
        for (i = 0; i < people.length; i++) {
            filtered.push(people[i]);
        }
        if (filtered.length !== 0) {
            dwr.util.addRows("editpeoplebody", filtered, [
                function(element) {
                    return element;
                }
            ], {escapeHtml: false});
        }
    }
    function getEventTarget(e) {
        e = e || window.event;
        return e.target || e.srcElement;
    }
    var ul = document.getElementById('peoplebody');
    ul.onclick = function(event) {
        var target = getEventTarget(event);
        document.getElementById("videokeyword").value = target.innerHTML;
        dwr.util.removeAllRows("peoplebody");
    };
    var ul1 = document.getElementById('peoplebodys');
    ul1.onclick = function(event) {
        var target = getEventTarget(event);
        var addkeywords = dwr.util.getValue("videokeywords");
        var res = [];
        res = addkeywords.split("\n");
        var lst = [];
        for (i = 0; i < ((res.length) - 1); i++) {
            lst.push(res[i]);
        }
        var old = lst.toString();
        while (old.indexOf(',') != -1) {
            old = old.replace(',', '\n');
        }
        if (lst == "")
        {
            document.getElementById("videokeywords").value = target.innerHTML;
            dwr.util.removeAllRows("peoplebodys");
        }
        else {
            document.getElementById("videokeywords").value = old + "\n" + target.innerHTML;
            dwr.util.removeAllRows("peoplebodys");
        }
        dwr.util.removeAllRows("peoplebodys");
    };
    var editul = document.getElementById('editpeoplebody');
    editul.onclick = function(event) {
        var target = getEventTarget(event);
        document.getElementById("editkeyword").value = target.innerHTML;
        dwr.util.removeAllRows("editpeoplebody");
    };
</script>
<!--script for keyword suggestion-->

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="https://s3.amazonaws.com/js_ranktracker/highcharts.js"></script> 
<script src="https://s3.amazonaws.com/js_ranktracker/exporting.js"></script>
<script type="text/javascript">
    var opened = "0";
    function drawVideoChart(keywordId, range) {
        var jString = "{\"keywordId\":\"" + keywordId + "\" , \"range\":\"" + range + "\"}";
        var chart;
        $.getJSON(
        'ajax/getVideoChartData.action',
        {
            jString: jString
        },
        function(jMap) {
            chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'chartBlock',
                    type: 'column',
                    marginRight: 130,
                    marginBottom: 25,
                    width: 1100,
                    height: 200
                },
                title: jMap.dataMap.title,
                subtitle: {
                    text: '',
                    x: -20
                },
                credits: {
                    enabled: false
                    //                    text: 'globustracker.com',
                    //                    href: 'http://www.globustracker.com/'
                },
                xAxis: {
                    categories:
                        eval(jMap.dataMap.category),
                    //                        ['View Count', 'Like Count' ,  'DisLike Count',  'Comment Count ',  'Daily View Count'  ],
                    labels: {
                        x: 3,
                        style: {
                            fontSize: '13px',
                            fontFamily: 'Verdana, sans-serif',
                            //  color: "black",
                            color: "{point.color}",
                            fontWeight: 'bold'
                        }
                    }//, offset: -16
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'View Count'
                    }
                },
                tooltip: {
                    pointFormat: '<b>{point.y}</b>'
                },
                legend: {
                    enabled: false
                },
                series: eval(jMap.dataMap.sbData)
            });

        });
    }

    var alertMes = "";
    function addVideoKeyword() {
        var keyword = document.addForm.videokeyword.value;
        var youtubeurl = document.addForm.youtubeurl.value;
        var vimeourl = document.addForm.vimeourl.value;
        var metacafeurl = document.addForm.metacafeurl.value;
        var dailymotionurl = document.addForm.dailymotionurl.value;
        var filter = new RegExp('(http|ftp|https)://[a-z0-9\-_]+(\.[a-z0-9\-_]+)+([a-z0-9\-\.,@\?^=%&;:/~\+#]*[a-z0-9\-@\?^=%&;/~\+#])?', 'i');

        if ($("#videokeyword").val().trim().length === 0) {
            alert("Please enter Keyword");
            return false;
        }
        if (youtubeurl === '' && vimeourl === '' && metacafeurl === '' && dailymotionurl === '') {
            alert("Please provide atleast one Url");
            return false;
        }
        if (youtubeurl !== '')
        {
            var y = youtubeurl.search("youtube.com");
            if (!filter.test(youtubeurl) || y === -1)
            {
                alert('Please provide a valid YoutubeUrl');
                return false;
            }
        }
        if (vimeourl !== '')
        {
            var v = vimeourl.search("vimeo.com");
            if (!filter.test(vimeourl) || v === -1)
            {
                alert('Please provide a valid VimeoUrl');
                return false;
            }
        }
        if (dailymotionurl !== '')
        {
            var d = dailymotionurl.search("dailymotion.com");
            if (!filter.test(dailymotionurl) || d === -1)
            {
                alert('Please provide a valid DailymotionUrl');
                return false;
            }
        }
        if (metacafeurl !== '')
        {
            var m = metacafeurl.search("metacafe.com");
            if (!filter.test(metacafeurl) || m === -1)
            {
                alert('Please provide a valid MetacafeUrl');
                return false;
            }
        }
        $.post(
        'ajax/addVideoKeyword.action',
        {
            arrKeywords: keyword,
            youtubeurl: youtubeurl,
            vimeourl: vimeourl,
            metacafeurl: metacafeurl,
            dailymotionurl: dailymotionurl
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "videokeywords.action";
        },
        'json');
    }

    function addVideoKeywords() {
        var keywords = document.addForm2.videokeywords.value;
        var youtubeurl = document.addForm2.youtubeurls.value;
        var vimeourl = document.addForm2.vimeourls.value;
        var metacafeurl = document.addForm2.metacafeurls.value;
        var dailymotionurl = document.addForm2.dailymotionurls.value;
        var filter = new RegExp('(http|ftp|https)://[a-z0-9\-_]+(\.[a-z0-9\-_]+)+([a-z0-9\-\.,@\?^=%&;:/~\+#]*[a-z0-9\-@\?^=%&;/~\+#])?', 'i');

        if ($("#videokeywords").val().trim().length === 0) {
            alert("Please enter Keyword");
            return false;
        }
        if (youtubeurl === '' && vimeourl === '' && metacafeurl === '' && dailymotionurl === '') {
            alert("Please provide atleast one Url");
            return false;
        }
        if (youtubeurl !== '')
        {
            var y = youtubeurl.search("youtube.com");
            if (!filter.test(youtubeurl) || y === -1)
            {
                alert('Please provide a valid YoutubeUrl');
                return false;
            }
        }
        if (vimeourl !== '')
        {
            var v = vimeourl.search("vimeo.com");
            if (!filter.test(vimeourl) || v === -1)
            {
                alert('Please provide a valid VimeoUrl');
                return false;
            }
        }
        if (dailymotionurl !== '')
        {
            var d = dailymotionurl.search("dailymotion.com");
            if (!filter.test(dailymotionurl) || d === -1)
            {
                alert('Please provide a valid DailymotionUrl');
                return false;
            }
        }
        if (metacafeurl !== '')
        {
            var m = metacafeurl.search("metacafe.com");
            if (!filter.test(metacafeurl) || m === -1)
            {
                alert('Please provide a valid MetacafeUrl');
                return false;
            }
        }
        $.post(
        'ajax/addVideoKeyword.action',
        {
            arrKeywords: keywords,
            youtubeurl: youtubeurl,
            vimeourl: vimeourl,
            metacafeurl: metacafeurl,
            dailymotionurl: dailymotionurl
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "videokeywords.action";
        },
        'json');
    }

    function editKeyword(keywordId, youtubeurl, dailymotionurl, vimeourl, metacafeurl, keyword) {

        try {
            if (youtubeurl !== '')
            {
                youtubeurl = "http://www." + youtubeurl;
            }
            if (dailymotionurl !== '')
            {
                dailymotionurl = "http://www." + dailymotionurl;
            }
            if (vimeourl !== '')
            {
                vimeourl = "http://www." + vimeourl;
            }
            if (metacafeurl !== '')
            {
                metacafeurl = "http://www." + metacafeurl;
            }
            document.editForm.keywordId.value = keywordId;
            document.editForm.youtubeurl.value = youtubeurl;
            document.editForm.dailymotionurl.value = dailymotionurl;
            document.editForm.vimeourl.value = vimeourl;
            document.editForm.metacafeurl.value = metacafeurl;
            document.editForm.editkeyword.value = keyword;
        } catch (e)
        {
            alert(e);
        }
    }

    function editVideoKeyword() {
        var keywordId = document.editForm.keywordId.value;
        var youtubeurl = document.editForm.youtubeurl.value;
        var dailymotionurl = document.editForm.dailymotionurl.value;
        var vimeourl = document.editForm.vimeourl.value;
        var metacafeurl = document.editForm.metacafeurl.value;
        var keyword = document.editForm.editkeyword.value;
        var filter = new RegExp('(http|ftp|https)://[a-z0-9\-_]+(\.[a-z0-9\-_]+)+([a-z0-9\-\.,@\?^=%&;:/~\+#]*[a-z0-9\-@\?^=%&;/~\+#])?', 'i');

        if ($("#editkeyword").val().trim().length === 0) {
            alert("Please enter Keyword");
            return false;
        }

        if (youtubeurl === '' && vimeourl === '' && metacafeurl === '' && dailymotionurl === '') {
            alert("Please provide atleast one Url");
            return false;
        }
        if (youtubeurl !== '')
        {
            var y = youtubeurl.search("youtube.com");
            if (!filter.test(youtubeurl) || y === -1)
            {
                alert('Please provide a valid YoutubeUrl');
                return false;
            }
        }
        if (vimeourl !== '')
        {
            var v = vimeourl.search("vimeo.com");
            if (!filter.test(vimeourl) || v === -1)
            {
                alert('Please provide a valid VimeoUrl');
                return false;
            }
        }
        if (dailymotionurl !== '')
        {
            var d = dailymotionurl.search("dailymotion.com");
            if (!filter.test(dailymotionurl) || d === -1)
            {
                alert('Please provide a valid DailymotionUrl');
                return false;
            }
        }
        if (metacafeurl !== '')
        {
            var m = metacafeurl.search("metacafe.com");
            if (!filter.test(metacafeurl) || m === -1)
            {
                alert('Please provide a valid MetacafeUrl');
                return false;
            }
        }
        $.post(
        'ajax/editVideoKeyword.action',
        {
            keywordId: keywordId,
            arrKeywords: keyword,
            youtubeurl: youtubeurl,
            dailymotionurl: dailymotionurl,
            vimeourl: vimeourl,
            metacafeurl: metacafeurl
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "videokeywords.action";
        },
        'json');
    }

    function deleteKeyword(keywordId)
    {
        document.deleteForm.videoKeywordId.value = keywordId;
    }

    function deleteVideoKeyword() {
        var jString = document.deleteForm.videoKeywordId.value;
        $.post(
        'ajax/deleteVideoKeyword.action',
        {
            jString: jString
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "videokeywords.action";
        },
        'json');
    }

</script>
