<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (session.getAttribute("customerID") == null) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.sendRedirect("home.action");
    }
%>

<!-- Bread crumb is created dynamically -->
<!-- row -->
<div class="row">
    <!-- col -->
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
        <h1 class="page-title txt-color-blueDark">
            <!-- PAGE HEADER --><i class="fa-fw fa fa-bolt"></i> 
            GlobusTracker 
            <span>
                > Profile
            </span>
        </h1>
    </div>
    <!-- end col -->
</div>
<!-- end row -->

<!-- widget -->    
<div class="jarviswidget jarviswidget-color-darken" id="wid-id-1" data-widget-editbutton="false">
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
        <span class="widget-icon"> <i class="fa fa-table"></i> </span>
        <h2>My Profile</h2>
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

            <div class="alert alert-info no-margin fade in">
                <i class="fa-fw fa fa-info"></i>
                Current plan
            </div>

            <div class="table-responsive">

                <table class="table table-bordered table-striped">
                    <tbody>
                        <tr>
                            <td><b>Name</b></td>
                            <td><s:property value="account.name" /></td>
                        </tr>
                        <tr>
                            <td><b>Email Address</b></td>
                            <td><s:property value="account.mail" /></td>
                        </tr>
                        <tr>
                            <td><b>Plan Name</b></td>
                            <td><s:property value="account.planName" /></td>
                        </tr>
                        <tr>
                            <td><b>Campaigns</b></td>
                            <td><s:property value="account.campaignDetail" /></td>
                        </tr>
                        <tr>
                            <td><b>Keywords</b></td>
                            <td><s:property value="account.keywordDetail" /></td>
                        </tr>
                        <tr>
                            <td><b>Active Users</b></td>
                            <td><s:property value="account.userDetail" /></td>
                        </tr>
                    </tbody>
                </table>

            </div>

        </div>
        <!-- end widget content -->

    </div>
    <!-- end widget div -->

</div>
<!-- end widget -->