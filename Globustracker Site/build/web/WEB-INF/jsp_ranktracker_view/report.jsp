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

<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i> 
            GlobusTracker
            <span>> 
                Reports
            </span>
        </h1>
    </div>
</div>

<% if (session.getAttribute("message") != null) {%>
<div id="fade_away1" style="color:#FF0000; margin-top: 20px;">
    <s:actionmessage />
    <s:actionerror />
</div>
<% session.setAttribute("message", "");%>
<%}%>

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
                    <span class="widget-icon"> <i class="fa fa-file-pdf-o"></i> </span>
                    <h2> Scheduled Email Reports</h2>
                </header>

                <!-- widget div-->
                <div>

                    <!-- widget edit box -->
                    <div class="jarviswidget-editbox">
                        <!-- This area used as dropdown edit box -->

                    </div>
                    <!-- end widget edit box -->
                    <div class="smart-form">
                        <form action="sendReportSetting.action" method="post">
                            <!-- widget content -->
                            <div class="widget-body no-padding">

                                <div class="custom-scroll table-responsive" style="height:290px; overflow-y: scroll;">

                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Campaign</th>
                                                <th>Send Report To</th>
                                                <th>Frequency</th>
                                            </tr>
                                        </thead>
                                        <tbody> 
                                            <s:iterator value="lstCampaigns" status="temp">
                                                <tr>
                                                    <s:hidden value="%{campaignID}" id="campaignId" name="campaignId" />
                                                    <td><a href="#"><s:property value="campaign"/></a></td>
                                                    <td><label class="input col-md-12">
                                                            <input type="text" class="input-sm col-md-12" name="emailTo" value="<s:property value="reportEmailID" />" />
                                                        </label></td>
                                                    <td>
                                                        <label class="select col-md-12">
                                                            <select class="input-sm col-md-12" list="lstFrequency" id="frequency" name="frequency" value="frequencyDetail">

                                                                <s:if test="%{reportFrequency != 24}">
                                                                    <option value="24" >Daily</option>
                                                                </s:if><s:else>
                                                                    <option value="24" selected>Daily</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 1}">
                                                                    <option value="1">Every 1 hour</option>
                                                                </s:if><s:else>
                                                                    <option value="1" selected>Every 1 hour</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 2}">
                                                                    <option value="2">Every 2 hour</option>
                                                                </s:if><s:else>
                                                                    <option value="2" selected>Every 2 hour</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 5}">
                                                                    <option value="5">Every 5 hour</option>
                                                                </s:if><s:else>
                                                                    <option value="5" selected>Every 5 hour</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 10}">
                                                                    <option value="10">Every 10 hour</option>
                                                                </s:if><s:else>
                                                                    <option value="10" selected>Every 10 hour</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 15}">
                                                                    <option value="15">Every 15 hour</option>
                                                                </s:if><s:else>
                                                                    <option value="15" selected>Every 15 hour</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 20}">
                                                                    <option value="20">Every 20 hour</option>
                                                                </s:if><s:else>
                                                                    <option value="20" selected>Every 20 hour</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 24}">
                                                                    <option value="24">Every 1 Day</option>
                                                                </s:if><s:else>
                                                                    <option value="24" selected>Every 1 Day</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 48}">
                                                                    <option value="48">Every 2 Days</option>
                                                                </s:if><s:else>
                                                                    <option value="48" selected>Every 2 Days</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 72}">
                                                                    <option value="72">Every 3 Days</option>
                                                                </s:if><s:else>
                                                                    <option value="72" selected>Every 3 Days</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 96}">
                                                                    <option value="96">Every 4 Days</option>
                                                                </s:if><s:else>
                                                                    <option value="96" selected>Every 4 Days</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 120}">
                                                                    <option value="120">Every 5 Days</option>
                                                                </s:if><s:else>
                                                                    <option value="120" selected>Every 5 Days</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 240}">
                                                                    <option value="240">Every 10 Days</option>
                                                                </s:if><s:else>
                                                                    <option value="240" selected>Every 10 Days</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 360}">
                                                                    <option value="360">Every 15 Days</option>
                                                                </s:if><s:else>
                                                                    <option value="360" selected>Every 15 Days</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 480}">
                                                                    <option value="480">Every 20 Days</option>
                                                                </s:if><s:else>
                                                                    <option value="480" selected>Every 20 Days</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 600}">
                                                                    <option value="600">Every 25 Days</option>
                                                                </s:if><s:else>
                                                                    <option value="600" selected>Every 25 Days</option>
                                                                </s:else>
                                                                <s:if test="%{reportFrequency != 720}">
                                                                    <option value="720">Every 30 Days</option>
                                                                </s:if><s:else>
                                                                    <option value="720" selected>Every 30 Days</option>
                                                                </s:else>
                                                            </select> 
                                                        </label>
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- end widget content -->
                            <footer>
                                <button type="submit" class="btn btn-primary">
                                    Save Changes
                                </button>                     
                            </footer>
                        </form>
                    </div>
                </div>
                <!-- end widget div -->
            </div>
            <!-- end widget -->
        </article>
        <!-- END COL -->
    </div>
    <!-- END ROW -->

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
                    <span class="widget-icon"> <i class="fa fa-file"></i> </span>
                    <h2>Reports Customization </h2>

                </header>

                <!-- widget div-->
                <div>

                    <!-- widget edit box -->
                    <div class="jarviswidget-editbox">
                        <!-- This area used as dropdown edit box -->

                    </div>
                    <!-- end widget edit box -->

                    <!-- widget content -->
                    <div class="widget-body no-padding">

                        <div class="custom-scroll table-responsive" style="height:290px; overflow-y: scroll;">

                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>Campaign</th>
                                        <th>Company Name</th>
                                        <th>Company Url</th>
                                        <th>Company Logo Link</th>
                                        <th>Edit</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:iterator value="lstCampaigns" status="temp">
                                        <s:if test="%{getlstCampaigns().isEmpty()}">
                                            <tr>
                                                <td><s:property value="Campaign"/></td>
                                                <td><s:property value="companyName"/></td>    
                                                <td title="<s:property value="companyURLLink"/>"><s:property value="companyURLLink"/></td>                                                                                              
                                                <td title="<s:property value="companyLogoLink"/>"><s:property value="companyLogoLink"/></td>
                                                <td><a href="#" onclick="edit('<s:property value="campaignID" />', '<s:property value="companyName" />', '<s:property value="companyURLLink" />', '<s:property value="CompanyLogoLink" />');" id="edit" title="Edit"><i class="fa fa-pencil fa-2x txt-color-yellow" data-toggle="modal" data-target="#editmodal"></i></a></td>
                                            </tr>
                                        </s:if>
                                        <s:else>
                                            <tr>
                                                <td><s:property value="Campaign"/></td>
                                                <td><s:property value="companyName"/></td>    
                                                <td title="<s:property value="companyURLLink"/>"><s:property value="companyURLLink"/></td>                                                                                              
                                                <td title="<s:property value="companyLogoLink"/>"><s:property value="companyLogoLink"/></td>
                                                <td><a href="#" onclick="edit('<s:property value="campaignID" />', '<s:property value="companyName" />', '<s:property value="companyURLLink" />', '<s:property value="CompanyLogoLink" />');" id="edit" title="Edit"><i class="fa fa-pencil fa-2x txt-color-yellow" data-toggle="modal" data-target="#editmodal"></i></a></td>
                                            </tr>
                                        </s:else>
                                    </s:iterator>
                                </tbody>
                            </table>

                        </div>

                    </div>
                    <!-- end widget content -->

                </div>
                <!-- end widget div -->

            </div>
            <!-- end widget -->

        </article>
        <!-- END COL -->

    </div>

    <!-- END ROW -->

    <!--edit Modal -->
    <s:form action="" id="editForm" onsubmit="return false;">
        <div class="modal fade" id="editmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Edit !</h4>
                    </div>
                    <div class="modal-body">                     
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Company Name</th>
                                    <th>Company Url</th>
                                    <th>Company Logo Link</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                            <input class="form-control" type="hidden" name="campaignId" id="campaignId" />
                            <td>
                                <label class="input col-md-12">
                                    <input type="text" name="cname" id="editname" class="input-sm col-md-12">                                                                               
                                </label>
                            </td>
                            <td>
                                <label class="input col-md-12">
                                    <input type="url" name="curl" id="editurl" class="input-sm col-md-12">                                          
                                </label>
                            </td>
                            <td>
                                <label class="input col-md-12">
                                    <input type="url" name="clogo" id="editlogo" class="input-sm col-md-12">
                                </label>
                            </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick = "return editPdfOptions();">Save Changes</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->
</section>

<script>
    function edit(campaignId, cname, curl, clogo) {
        try {
            document.editForm.campaignId.value = campaignId;
            document.editForm.cname.value = cname;
            document.editForm.curl.value = curl;
            document.editForm.clogo.value = clogo;
        } catch (e)
        {
            alert(e);
        }
    }

    function editPdfOptions() {

        var campaignId = document.editForm.campaignId.value;
        var editname = $("#editname").val();
        var editurl = $("#editurl").val();
        var editlogo = $("#editlogo").val();

        var urlexp = new RegExp('(http|ftp|https)://[a-z0-9\-_]+(\.[a-z0-9\-_]+)+([a-z0-9\-\.,@\?^=%&;:/~\+#]*[a-z0-9\-@\?^=%&;/~\+#])?', 'i');
        var validity1 = urlexp.test(editurl);
        var validity2 = urlexp.test(editlogo);
        if (editurl !== "")
        {
            if (!validity1) {
                alert("Please enter a valid Url Link");
                return false;
            }
        }
        if (editlogo !== "")
        {
            if (!validity2) {
                alert("Please enter a valid Logo Link");
                return false;
            }
        }
        $.post(
                'ajax/updatePdfOptions.action',
                {
                    ecampaignId: campaignId,
                    ename: editname,
                    eurl: editurl,
                    elogo: editlogo
                },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "report.action";
        },
                'json');
    }
</script>

