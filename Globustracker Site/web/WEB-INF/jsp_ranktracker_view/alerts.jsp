<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Body start -->
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
                Alerts
            </span>
        </h1>
    </div>
</div>


<!-- widget grid -->
<section id="widget-grid" class="">

    <!-- START ROW -->
    <div class="row">

        <!-- NEW WIDGET START -->
        <article class="col-sm-12 col-md-12 col-lg-12 text-center">
            <form action="searchCampaignDate.action" name="searchForm" method="post">

                <ul class="pagination pagination-lg">
                    <s:iterator value="lstDate" status="temp" >
                        <s:hidden name="dateValue" value='<s:property />' />

                        <li>
                            <a class="active" href="searchCampaignDate.action?date=<s:property />"><s:property /></a>
                        </li>
                    </s:iterator>
                </ul>

            </form>
        </article>
        <!-- WIDGET END -->
    </div>
    <!-- end Row -->

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
                    <span class="widget-icon"> <i class="fa fa-calendar"></i> </span>
                    <h2><s:date name="currentDate" format="MM/dd/yyyy"/></h2>

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
                                        <th style="text-align: center;"><i class="fa fa-institution"></i> Campaign</th>
                                        <th style="text-align: center;">URL</th>
                                        <th style="text-align: center;">Keyword</th>
                                        <th style="text-align: center;">Search Engine</th>
                                        <th style="text-align: center;">Previous Rank</th>
                                        <th style="text-align: center;">Status</th>
                                        <th style="text-align: center;">Latest Rank</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:iterator value="lstAlertsform" status="temp" >
                                        <tr>
                                            <td style="text-align: center;"><s:property value="campaign" /></td>
                                            <td style="text-align: center;"><a target="_blank" href="http://<s:property value="url" />"><s:property value="url" /></a></td>
                                            <td style="text-align: center;"><s:property value="keyword" /></td>
                                            <td style="text-align: center;"><s:property value="engine" /></td>
                                            <td style="text-align: center;"><s:property value="previousRank" /></td>
                                            <td style="text-align: center;">
                                                <s:if test="%{currentRank < previousRank}">
                                                    <i class="fa fa-arrow-up fa-1x fa-fw txt-color-green"></i><s:property value="previousRank-currentRank" />
                                                </s:if>
                                                <s:elseif test="%{currentRank > previousRank}">
                                                    <i class="fa fa-arrow-down fa-1x fa-fw txt-color-red"></i><s:property value="currentRank-previousRank" />
                                                </s:elseif>
                                            </td>
                                            <td style="text-align: center;"><s:property value="currentRank" /></td>
                                        </tr>
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
</section>
<!-- end widget grid -->