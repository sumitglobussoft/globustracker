<%@ taglib prefix="s" uri="/struts-tags"%>

<%
    if (session.getAttribute("customerID") == null) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", -1);
        response.sendRedirect("home.action");
    }
%> 

<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i> 
            GlobusTracker
            <span>>
                My Dashboard
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
    <s:if test="%{getLstDisplaysettings().isEmpty()}"> 

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
                    <header>
                        <span class="widget-icon"> <i class="fa fa-edit"></i> </span>
                        <h2>Serp Campaigns</h2>
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
                                                        <th colspan="6">Actions</th>
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
                                                        <th colspan="6">Actions</th>
                                                    </tr>
                                                </thead>
                                                <tbody>		
                                                    <s:iterator value="lstCampaigns" status="temp">
                                                        <s:if test="%{campaignType.equals('serp')}">
                                                            <tr>
                                                                <td><a href="serpskeywords.action?campaignId=<s:property value="campaignID"/>"><s:property value="campaign"/></a></td>
                                                                <td ><a href="#" title="Share Campaign Details" id="share" onclick="copyViewKey('<s:property value="viewKey" />');"><i class="fa fa-share-alt fa-2x" data-toggle="modal" data-target="#viewkeymodal"></i></a></td>
                                                                <td><a href="#" title="Send Campaign Report" onclick="openSerpEmailWindow(<s:property value="campaignID"/>);"><i class="fa fa-envelope fa-2x txt-color-blue" data-toggle="modal" data-target="#serpmailmodal"></i></a></td>
                                                                <td ><a href="generateExcelReport.action?campaignId=<s:property value="campaignID"/>&campaignName=<s:property value="campaign" />" title="Generate Excel Report"><i class="fa fa-file-excel-o fa-2x txt-color-green"></i></a></td>
                                                                <td><a href="generatePDFReport.action?campaignId=<s:property value="campaignID"/>&campaignName=<s:property value="campaign" />" title="Generate PDF Report"><i class="fa fa-file-pdf-o fa-2x txt-color-red"></i></a></td>
                                                                <td ><a href="#" title="Edit Campaign" onclick="openEditCampaign('<s:property value="campaignID"/>', '<s:property value="campaign"/>');"><i class="fa fa-pencil fa-2x txt-color-yellow" data-toggle="modal" data-target="#editmodal"></i></a></td>
                                                                <td><a href="#" title="Delete Campaign" onclick="openDeleteSerpCampaign('<s:property value="campaignID"/>');"><i class="fa fa-trash-o fa-2x" data-toggle="modal" data-target="#deleteserpmodal"></i></a></td>
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
                                <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#addserpmodal">
                                    Add Serp Campaign
                                </button>
                                <!--                                            <button type="button" class="btn btn-default" onclick="window.history.back();">
                                                                                Cancel
                                                                            </button>-->
                            </footer>
                        </div>

                    </div>
                    <!-- end widget -->
                </div>
                <!-- end widget ID -->
            </article>
            <!-- END COL -->

            <!-- NEW COL START -->
            <article class="col-sm-12 col-md-12 col-lg-6">

                <!-- Widget ID (each widget will need unique ID)-->
                <div class="jarviswidget" id="wid-id-2" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
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
                        <span class="widget-icon"> <i class="fa fa-video-camera"></i> </span>
                        <h2>Video Campaigns</h2>

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
                                                        <th colspan="6">Actions</th>
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
                                                        <th colspan="6">Actions</th>
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
                                                                <td ><a href="#" title="Edit Campaign" onclick="openEditCampaign('<s:property value="campaignID"/>', '<s:property value="campaign"/>');"><i class="fa fa-pencil fa-2x txt-color-yellow" data-toggle="modal" data-target="#editmodal"></i></a></td>
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
                                <!--                                            <button type="button" class="btn btn-default" onclick="window.history.back();">
                                                                                Cancel
                                                                            </button>-->
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
    </s:if>
    <s:else>
        <s:iterator value="lstDisplaysettings" status="temp">

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

            <!--START ROW -->     
            <div class="row">

                <!-- serps -->   
                <s:if test="%{serpcampaigntab == 1}">

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
                            <header>
                                <span class="widget-icon"> <i class="fa fa-edit"></i> </span>
                                <h2>Serp Campaigns</h2>
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
                                                                <th colspan="6">Actions</th>
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
                                                                <th colspan="6">Actions</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>		
                                                            <s:iterator value="lstCampaigns" status="temp">
                                                                <s:if test="%{campaignType.equals('serp')}">
                                                                    <tr>
                                                                        <td><a href="serpskeywords.action?campaignId=<s:property value="campaignID"/>"><s:property value="campaign"/></a></td>
                                                                        <td ><a href="#" title="Share Campaign Details" id="share" onclick="copyViewKey('<s:property value="viewKey" />');"><i class="fa fa-share-alt fa-2x" data-toggle="modal" data-target="#viewkeymodal"></i></a></td>
                                                                        <td><a href="#" title="Send Campaign Report" onclick="openSerpEmailWindow(<s:property value="campaignID"/>);"><i class="fa fa-envelope fa-2x txt-color-blue" data-toggle="modal" data-target="#serpmailmodal"></i></a></td>
                                                                        <td ><a href="generateExcelReport.action?campaignId=<s:property value="campaignID"/>&campaignName=<s:property value="campaign" />" title="Generate Excel Report"><i class="fa fa-file-excel-o fa-2x txt-color-green"></i></a></td>
                                                                        <td><a href="generatePDFReport.action?campaignId=<s:property value="campaignID"/>&campaignName=<s:property value="campaign" />" title="Generate PDF Report"><i class="fa fa-file-pdf-o fa-2x txt-color-red"></i></a></td>
                                                                        <td ><a href="#" title="Edit Campaign" onclick="openEditCampaign('<s:property value="campaignID"/>', '<s:property value="campaign"/>');"><i class="fa fa-pencil fa-2x txt-color-yellow" data-toggle="modal" data-target="#editmodal"></i></a></td>
                                                                        <td><a href="#" title="Delete Campaign" onclick="openDeleteSerpCampaign('<s:property value="campaignID"/>');"><i class="fa fa-trash-o fa-2x" data-toggle="modal" data-target="#deleteserpmodal"></i></a></td>
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
                                        <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#addserpmodal">
                                            Add Serp Campaign
                                        </button>
                                    </footer>
                                </div>
                            </div>
                            <!-- end widget -->
                        </div>
                        <!-- end widget ID -->
                    </article>
                    <!-- END COL -->
                </s:if>
                <s:else>
                </s:else>
                <!-- end serps -->   

                <!-- video -->
                <s:if test="%{videocampaigntab == 1}">
                    <!-- NEW COL START -->
                    <article class="col-sm-12 col-md-12 col-lg-6">

                        <!-- Widget ID (each widget will need unique ID)-->
                        <div class="jarviswidget" id="wid-id-2" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
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
                                <span class="widget-icon"> <i class="fa fa-video-camera"></i> </span>
                                <h2>Video Campaigns</h2>

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
                                                                <th colspan="6">Actions</th>
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
                                                                <th colspan="6">Actions</th>
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
                                                                        <td ><a href="#" title="Edit Campaign" onclick="openEditCampaign('<s:property value="campaignID"/>', '<s:property value="campaign"/>');"><i class="fa fa-pencil fa-2x txt-color-yellow" data-toggle="modal" data-target="#editmodal"></i></a></td>
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
                </s:if>
                <s:else>
                </s:else>
                <!-- end video -->   
            </div>
            <!-- END ROW -->
        </s:iterator>
    </s:else>

    <!--Add Campaign Modal -->
    <s:form action="" id="addserpform" onsubmit="return false;" autocomplete="off">
        <div class="modal fade" id="addserpmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Add Campaign !</h4>
                    </div>
                    <div class="modal-body">
                        <h4>Serp Campaign</h4>
                        <input class="form-control" type="text" name="campaignName" id="campaignName" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="addSerpsCampaign();">Add Campaign</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>

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
                        <button type="button" class="btn btn-info " onclick="editCampaign();">Update Campaign</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->

    <!--Delete Campaign Modal -->
    <s:form action="" id="deleteSerpForm" onsubmit="return false;">
        <div class="modal fade" id="deleteserpmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                        <button type="button" class="btn btn-default btn-danger" onclick="deleteSerpsCampaign();">Yes</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>

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
                        <input type="hidden" name="campaignId" id="campaignId" />
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
    <s:form action="" id="serpMailSendForm" onsubmit="return false;">
        <div class="modal fade" id="serpmailmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                        <button type="button" class="btn btn-info " onclick="sendSerpsCampaignMail();">Send</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>

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
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>

<div id="dialog" title="Notification">
    <p><s:property value="#session.paymentMessage"/></p>
</div>

<script type="text/javascript" >



                            <%
                            if(Integer.parseInt(""+session.getAttribute("notification"))==0){
                                %>
                                     $(function() {
                                    $("#dialog").dialog();
                                });
                                <%
                                session.setAttribute("notification",1);
                            }
                           %>
                            

                          

                            var alertMes = "";
                            function addSerpsCampaign()
                            {
                                var jString = document.addserpform.campaignName.value;
                                $.post(
                                        'ajax/addserCampaign.action',
                                        {
                                            jString: jString
                                        },
                                function(jMessage) {
                                    alertMes = jMessage.message;
                                    $('#se1Loader').css({display: 'none'});
                                    if (alertMes == "Campaign Value required") {
                                        window.location = "campaigns.action";
                                        document.addserpform.campaignName.focus();
                                    } else if (alertMes == "Campaign has been created. Please Click on Campaign Name to Add Keywords") {
                                        window.location = "campaigns.action";
                                    } else if (alertMes == "Campaign has been Deleted") {
                                        window.location = "campaigns.action";
                                    } else if (alertMes == "Sorry This Campaign value already exist in Database")
                                    {
                                        window.location = "campaigns.action";
                                        document.addserpform.campaignName.focus();
                                    }
                                    else if (alertMes == "Your Assigned Quota for Number of Campaigns is Full.")
                                    {
                                        window.location = "campaigns.action";
                                    }
                                    else if (alertMes == "Campaign Name should be alphanumeric")
                                    {
                                        window.location = "campaigns.action";
                                    }
                                },
                                        'json');
                            }

                            function addVideoCampaign()
                            {
                                $('#se1Loader').css({display: 'block'});
                                $("#add_site_video").hide();
                                var jString = document.addvideoform.campaignName.value;
                                $.post(
                                        'ajax/addvioCampaign.action',
                                        {
                                            jString: jString
                                        },
                                function(jMessage) {
                                    alertMes = jMessage.message;
                                    $('#se1Loader').css({display: 'none'});
                                    if (alertMes === "Campaign Value required") {
                                        window.location = "campaigns.action";
                                        document.addvideoform.campaignName.focus();
                                    } else if (alertMes === "Campaign has been created. Please Click on Campaign Name to Add Keywords") {
                                        window.location = "campaigns.action";
                                    } else if (alertMes === "Campaign has been Deleted") {
                                        window.location = "campaigns.action";
                                    } else if (alertMes === "Sorry This Campaign value already exist in Database")
                                    {
                                        window.location = "campaigns.action";
                                        document.addvideoform.campaignName.focus();
                                    }
                                    else if (alertMes == "Your Assigned Quota for Number of Campaigns is Full.")
                                    {
                                        window.location = "campaigns.action";
                                    }
                                    else if (alertMes == "Campaign Name should be alphanumeric")
                                    {
                                        window.location = "campaigns.action";
                                    }
                                },
                                        'json');
                            }

                            function openEditCampaign(campaignId, campaignName)
                            {
                                try {
                                    document.editForm.campaignId.value = campaignId;
                                    document.editForm.editCampaignName.value = campaignName;
                                } catch (e) {
                                    alert(e);
                                }
                            }

                            function openSerpEmailWindow(campaignId)
                            {
                                try {
                                    document.serpMailSendForm.campaignId.value = campaignId;
                                    document.serpMailSendForm.emailID.value = '';
                                } catch (e)
                                {
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

                            function editCampaign()
                            {
                                try {
                                    var jString = document.editForm.campaignId.value + ":" + document.editForm.editCampaignName.value;
                                    if ($("#editCampaignName").val().trim().length == 0) {
                                        alert("Please provide Campaign Name");
                                        return false;
                                    }
                                    $.post(
                                            'ajax/editCampaign.action',
                                            {
                                                jString: jString
                                            },
                                    function(jMessage) {
                                        alertMes = jMessage.message;
                                        $('#se1Loader').css({display: 'none'});
                                        window.location = "campaigns.action";
                                    },
                                            'json');
                                } catch (e) {
                                    alert(e);
                                }
                            }

                            function sendSerpsCampaignMail()
                            {
                                try {
                                    var email = document.serpMailSendForm.emailID.value;
                                    var cID = document.serpMailSendForm.campaignId.value;
                                    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                                    if (email === '') {
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
                                                    'ajax/sendserpCampaignReport.action',
                                                    {
                                                        jString: jString
                                                    },
                                            function(jMessage) {
                                                alertMes = jMessage.message;
                                                window.location = "campaigns.action";
                                            },
                                                    'json');
                                        }
                                    }
                                }
                                catch (e)
                                {
                                    alert(e);
                                }
                            }

                            function sendVideoCampaignMail()
                            {
                                try {
                                    var email = document.videoMailSendForm.emailID.value;
                                    var cID = document.videoMailSendForm.campaignId.value;
                                    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                                    if (email === '') {
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

                                                window.location = "campaigns.action";
                                            },
                                                    'json');
                                        }
                                    }
                                } catch (e)
                                {
                                    alert(e);
                                }
                            }

                            function copyViewKey(viewKey)
                            {
                                try {
                                    var viewKeyUrl = "http://globustracker.com/viewKey.action?key=" + viewKey;
                                    document.getElementById('viewkey').innerHTML = viewKeyUrl;
                                    document.getElementById('viewkey').href = viewKeyUrl;
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
    function openDeleteSerpCampaign(campaignId)
    {
        try {
            document.deleteSerpForm.campaignId.value = campaignId;
        } catch (e) {
            alert(e);
        }
    }

    function openDeleteVideoCampaign(campaignId)
    {
        try {
            document.deleteVideoForm.campaignId.value = campaignId;
        } catch (e) {
            alert(e);
        }
    }

    function deleteSerpsCampaign()
    {
        var jString = document.deleteSerpForm.campaignId.value;
        $.post(
                'ajax/deleteSerpsCampaign.action',
                {
                    jString: jString
                },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "campaigns.action";
        },
                'json');
    }

    function deleteVideoCampaign()
    {
        var jString = document.deleteVideoForm.campaignId.value;
        $.post(
                'ajax/deleteVideoCampaign.action',
                {
                    jString: jString
                },
        function(jMessage) {
            alertMes = jMessage.message;
            $('#se1Loader').css({display: 'none'});
            window.location = "campaigns.action";
        },
                'json');
    }
</script>

