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
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i> 
            GlobusTracker
            <span>> 
                Video Campaign
            </span>
        </h1>
    </div>
</div>

<div id="fade_away" style="color:#FF0000;">
    <s:actionmessage />
    <s:actionerror />
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
                                                    <h5>Top 5</h5>
                                                    <code><s:property value="keywordsRankBelow10" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="well well-sm text-center">
                                                    <h5>Top 5</h5>
                                                    <code><s:property value="keywordsRankBelow20" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="well well-sm bg-color-pinkDark txt-color-white text-center">
                                                    <h5>Top 5</h5>
                                                    <code><s:property value="keywordsRankBelow30" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="well well-sm bg-color-teal txt-color-white text-center">
                                                    <h5>Top 5</h5>
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

    <!-- START ROW -->

    <div class="row">

        <!-- NEW COL START -->
        <article class="col-sm-12 col-md-12 col-lg-12">

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
                <header>
                    <span class="widget-icon"> <i class="fa fa-edit"></i> </span>
                    <h2>Video Campaigns</h2>
                    <form action="searchVideoCampaign.action" name="searchCampaign" id="searchCampaign" method="get">
                        <div class="widget-toolbar">
                            <span>Using (<s:property value="activeKeywordsCount" />/<s:property value="allowedKeywordsCount" />) Keywords</span>
                        </div>
                        <div class="widget-toolbar">
                            <!-- add: non-hidden - to disable auto hide -->
                            <div class="btn-group">
                                <input type="text" hidden name="searchVideoCampaign" value="Search Campaign" autocomplete="off" id="videocamp"/>
                                <button class="btn dropdown-toggle btn-xs btn-default" data-toggle="dropdown" id="dropdownvideo">
                                    Search Campaign <i class="fa fa-caret-down"></i>
                                </button>
                                <ul class="dropdown-menu js-status-update pull-right">
                                    <s:iterator value="lstCampaignsSearch" status="temp">
                                        <s:if test="%{campaignType.equals('video')}">
                                            <li>
                                                <a><s:property value="campaign"/></a>
                                            </li> 
                                        </s:if>
                                    </s:iterator>
                                </ul>
                            </div>
                            <button type="submit" class="btn btn-primary btn-xs">
                                <i class="fa fa-search fa-fw"></i>Search
                            </button>
                        </div>
                    </form>
                </header>

                <!-- widget div-->
                <div>

                    <!-- widget edit box -->
                    <div class="jarviswidget-editbox">
                        <!-- This area used as dropdown edit box -->

                    </div>
                    <!-- end widget edit box -->
                    <div class="smart-form">
                        <!-- widget content -->
                        <div class="widget-body no-padding">

                            <div class="custom-scroll table-responsive" style="height:290px; overflow-y: scroll;">
                                <s:if test="%{getLstCampaigns().isEmpty()}"> 
                                    <s:form name="campaignDetail" >
                                        <s:hidden name="campaignId" />

                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th><i class="fa fa-institution"></i> Campaign Name</th>
                                                    <th colspan="7">Actions</th>
                                                </tr>
                                            </thead>

                                        </table>
                                    </s:form >
                                </s:if> 
                                <s:else>
                                    <s:form name="campaignDetail" >
                                        <s:hidden name="campaignId" />
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th><i class="fa fa-institution"></i> Campaign Name</th>
                                                    <th colspan="7">Actions</th>
                                                </tr>
                                            </thead>
                                            <tbody>		
                                                <s:iterator value="lstCampaigns" status="temp">
                                                    <s:if test="%{campaignType.equals('video')}">
                                                        <tr>
                                                            <td><a href="videokeywords.action?campaignId=<s:property value="campaignID"/>"><s:property value="campaign"/></a></td>
                                                            <td ><a href="#" title="Share Campaign Details" id="share" onclick="copyViewKeyVideo('<s:property value="viewKey" />');"><i class="fa fa-share-alt fa-2x" data-toggle="modal" data-target="#viewkeymodal"></i></a></td>
                                                            <td><a href="#" title="Send Campaign Report" onclick="openVideoEmailWindow(<s:property value="campaignID"/>);"><i class="fa fa-envelope fa-2x txt-color-blue" data-toggle="modal" data-target="#videomailmodal"></i></a></td>
                                                            <td ><a href="generateVideoExcelReport.action?campaignId=<s:property value="campaignID"/>&campaignName=<s:property value="campaign" />" title="Generate Excel Report"><i class="fa fa-file-excel-o fa-2x txt-color-green"></i></a></td>
                                                            <td><a href="generateVideoPDFReport.action?campaignId=<s:property value="campaignID"/>&campaignName=<s:property value="campaign" />" title="Generate PDF Report"><i class="fa fa-file-pdf-o fa-2x txt-color-red"></i></a></td>
                                                            <td ><a href="#" title="Edit Campaign" onclick="openVideoEditCampaign('<s:property value="campaignID"/>', '<s:property value="campaign"/>');"><i class="fa fa-pencil fa-2x txt-color-yellow" data-toggle="modal" data-target="#editmodal"></i></a></td>
                                                            <td><a href="#" title="Delete Campaign" onclick="openDeleteVideoCampaign('<s:property value="campaignID"/>');"><i class="fa fa-trash-o fa-2x" data-toggle="modal" data-target="#deletevideomodal"></i></a></td>                                                  
                                                        </tr>
                                                    </s:if>
                                                </s:iterator>
                                        </table>
                                    </s:form >
                                </s:else>
                            </div>
                            <!-- end widget content -->
                        </div>
                        <!-- end widget div -->
                        <footer>
                            <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#addvideomodal">
                                Add Video Campaign
                            </button>                     
                        </footer>
                    </div>
                </div>
                <!-- end widget -->
            </div>
            <!-- end widget ID -->
        </article>
        <!-- END COL -->
    </div>

    <!-- END ROW -->

    <!--Add Campaign Modal -->
    <s:form action="" id="addvideoform" onsubmit="return false;" autocomplete="off">
        <div class="modal fade" id="addvideomodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Add Campaign !</h4>
                    </div>
                    <div class="modal-body">
                        <h4>Video Campaign</h4>
                        <input class="form-control" type="text" name="campaignName" id="campaignName" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="addVideoCampaign();">Add Campaign</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->

    <!--Edit Campaign Modal -->
    <s:form action="" id="editForm" onsubmit="return false;" autocomplete="off">
        <div class="modal fade" id="editmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Edit !</h4>
                    </div>
                    <div class="modal-body">
                        <h4>Update Campaign</h4>
                        <input class="form-control" type="hidden" name="campaignId" id="campaignId" />
                        <input class="form-control" type="text" name="editCampaignName" id="editCampaignName" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="editVideoCampaign();">Update Campaign</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->

    <!--Delete Campaign Modal -->
    <s:form action="" id="deleteVideoForm" onsubmit="return false;">
        <div class="modal fade" id="deletevideomodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Delete !</h4>
                    </div>
                    <div class="modal-body">
                        <h4>Are you sure you want to delete this? Lost logs cannot be retrieved again.</h4>
                        <input class="form-control" type="hidden" name="campaignId" id="campaignId" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default btn-danger" onclick="deleteVideoCampaign();">Yes</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->

    <!--Send Mail Modal -->
    <s:form action="" id="videoMailSendForm" onsubmit="return false;">
        <div class="modal fade" id="videomailmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Send Mail !</h4>
                    </div>
                    <div class="modal-body">
                        <h4>Email Address</h4>
                        <input class="form-control" type="hidden" name="campaignId" id="campaignId" />
                        <input class="form-control" type="text" name="emailID" id="emailID" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="sendVideoCampaignMail();">Send</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->

    <!--Viewkey Modal -->
    <s:form action="" id="viewKeyForm" onsubmit="return false;" autocomplete="off">
        <div class="modal fade" id="viewkeymodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Share Campaign Page !</h4>
                    </div>
                    <div class="modal-body">
                        <a id="viewkey" target="_blank"></a>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->

</section>
<!-- end widget grid -->

<script type="text/javascript" >
    var alertMes = "";
    function addVideoCampaign() {
        var jString = document.addvideoform.campaignName.value;
        $.post(
                'ajax/addVideoCampaign.action',
                {
                    jString: jString
                },
        function(jMessage) {
            alertMes = jMessage.message;
            if (alertMes == "Campaign Value required") {
                window.location = "video.action";
                document.addvideoform.campaignName.focus();
            } else if (alertMes == "Campaign has been created. Please Click on Campaign Name to Add Keywords") {
                window.location = "video.action";
            } else if (alertMes == "Campaign has been Deleted") {
                window.location = "video.action";
            } else if (alertMes == "Sorry This Campaign value already exist in Database")
            {
                window.location = "video.action";
                document.addvideoform.campaignName.focus();
            }
            else if (alertMes == "Your Assigned Quota for Number of Campaigns is Full.")
            {
                window.location = "video.action";
            }
            else if (alertMes == "Campaign Name should be alphanumeric")
            {
                window.location = "video.action";
            }
        },
                'json');

    }

    function openVideoEditCampaign(campaignId, campaignName) {
        try {
            document.editForm.campaignId.value = campaignId;
            document.editForm.editCampaignName.value = campaignName;
        } catch (e) {
            alert(e);
        }
    }

    function openVideoEmailWindow(campaignId)
    {
        try {
            document.videoMailSendForm.campaignId.value = campaignId;
            document.videoMailSendForm.emailID.value = '';
        } catch (e)
        {
            alert(e);
        }
    }

    function editVideoCampaign() {
        try {
            var jString = document.editForm.campaignId.value + ":" + document.editForm.editCampaignName.value;
            if ($("#editCampaignName").val().trim().length === 0)
            {
                alert('Please provide Campaign Name');
                return false;
            }
            $.post(
                    'ajax/editVideoCampaign.action',
                    {
                        jString: jString
                    },
            function(jMessage) {
                alertMes = jMessage.message;
                window.location = "video.action";
            },
                    'json');
        } catch (e) {
            alert(e);
        }
    }

    function sendVideoCampaignMail()
    {
        try {
            var email = document.videoMailSendForm.emailID.value;
            var cID = document.videoMailSendForm.campaignId.value;
            var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            if (email == '') {
                alert('Please provide Email address');
                return false;
            } else {
                if (!filter.test(email)) {
                    alert('Please provide a valid Email address');
                    return false;
                }
                else {
                    var jString = cID + ':' + email;
                    $.post(
                            'ajax/sendvideoCampaignReport.action',
                            {
                                jString: jString
                            },
                    function(jMessage) {
                        alertMes = jMessage.message;
                        window.location = "video.action";
                    },
                            'json');
                }
            }
        } catch (e)
        {
            alert(e);
        }
    }

    function copyViewKeyVideo(viewKey)
    {
        try {
            var viewKeyUrl = "http://globustracker.com/viewKeyVideo.action?key=" + viewKey;
            document.getElementById('viewkey').innerHTML = viewKeyUrl;
            document.getElementById('viewkey').href = viewKeyUrl;
        } catch (e)
        {
            alert(e);
        }
    }

</script>

<script type="text/javascript">

    function openDeleteVideoCampaign(campaignId)
    {
        try {
            document.deleteVideoForm.campaignId.value = campaignId;
        } catch (e) {
            alert(e);
        }
    }

    function deleteVideoCampaign() {
        var jString = document.deleteVideoForm.campaignId.value;
        $.post(
                'ajax/deleteVideoCampaign.action',
                {
                    jString: jString
                },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "video.action";
        },
                'json');
    }

</script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>

<script type="text/javascript">
    $(".js-status-update a").click(function() {
        var selText = $(this).text();
        var $this = $(this);
        document.getElementById("videocamp").value = selText;
        $this.parents('.btn-group').find('.dropdown-toggle').html(selText + ' <span class="caret"></span>');
        $this.parents('.dropdown-menu').find('li').removeClass('active');
        $this.parent().addClass('active');
    });
</script>
