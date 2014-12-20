<%@ taglib uri="/struts-tags" prefix="s" %>
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
                Settings
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
                    <span class="widget-icon"> <i class="fa fa-wrench"></i> </span>
                    <h2>Display Settings</h2>
                </header>

                <!-- widget div-->
                <div>

                    <!-- widget edit box -->
                    <div class="jarviswidget-editbox">
                        <!-- This area used as dropdown edit box -->

                    </div>
                    <!-- end widget edit box -->

                    <div class="smart-form">
                        <form action="tabSettings.action" method="get">
                            <input type="hidden" id="googletab" name="googletab">
                            <input type="hidden" id="yahootab" name="yahootab">
                            <input type="hidden" id="bingtab" name="bingtab">
                            <input type="hidden" id="daychangetab" name="daychange">
                            <input type="hidden" id="weekchangetab" name="weektab">
                            <input type="hidden" id="monthchangetab" name="monthtab">
                            <input type="hidden" id="alexatab" name="alexatab">
                            <input type="hidden" id="backlinkstab" name="backlinktab">
                            <input type="hidden" id="monthlysearchstab" name="monthlysearch">
                            <input type="hidden" id="serpcampaigntab" name="serpcampaigntab">
                            <input type="hidden" id="videocampaigntab" name="videocampaigntab">

                            <!-- widget content -->
                            <div class="widget-body no-padding">

                                <fieldset>

                                    <label class="toggle">
                                        <s:if test="%{getLstDisplaysettings().isEmpty()}">                                           
                                            <label class="toggle state-success">
                                                <input type="checkbox" name="checkbox-toggle" checked id="googlecheck">
                                                <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Google Rank
                                            </label>
                                            <label class="toggle state-success">
                                                <input type="checkbox" name="checkbox-toggle" checked id="yahoocheck">
                                                <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Yahoo Rank
                                            </label>
                                            <label class="toggle state-success">
                                                <input type="checkbox" name="checkbox-toggle" checked id="bingcheck">
                                                <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Bing Rank
                                            </label>
                                            <label class="toggle state-success">
                                                <input type="checkbox" name="checkbox-toggle" checked id="daycheck">
                                                <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Day Change
                                            </label>
                                            <label class="toggle state-success">
                                                <input type="checkbox" name="checkbox-toggle" checked id="weekcheck">
                                                <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Week Change
                                            </label>
                                            <label class="toggle state-success">
                                                <input type="checkbox" name="checkbox-toggle" checked id="monthcheck">
                                                <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Month Change
                                            </label>
                                            <label class="toggle state-success">
                                                <input type="checkbox" name="checkbox-toggle" checked id="alexacheck">
                                                <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Alexa Rank
                                            </label>
                                            <label class="toggle state-success">
                                                <input type="checkbox" name="checkbox-toggle" checked id="blcheck">
                                                <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Back Links
                                            </label>
                                            <label class="toggle state-success">
                                                <input type="checkbox" name="checkbox-toggle" checked id="mscheck">
                                                <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Monthly Searches
                                            </label>
                                            <label class="toggle state-success">
                                                <input type="checkbox" name="checkbox-toggle" checked id="serpcheck">
                                                <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Serp Campaign
                                            </label>
                                            <label class="toggle state-success">
                                                <input type="checkbox" name="checkbox-toggle" checked id="videocheck">
                                                <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Video Campaign
                                            </label>                                    
                                        </s:if>
                                        <s:else>
                                            <s:iterator value="lstDisplaysettings" status="temp">
                                                <label class="toggle state-success">
                                                    <s:if test="%{googletab == 1}">
                                                        <input type="checkbox" name="checkbox-toggle" checked id="googlecheck">
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Google Rank
                                                    </s:if>
                                                    <s:else>
                                                        <input type="checkbox" name="checkbox-toggle" id="googlecheck">
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Google Rank
                                                    </s:else>
                                                </label>
                                                <label class="toggle state-success">
                                                    <s:if test="%{yahootab == 1}">
                                                        <input type="checkbox" name="checkbox-toggle" checked id="yahoocheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Yahoo Rank
                                                    </s:if>
                                                    <s:else>
                                                        <input type="checkbox" name="checkbox-toggle" id="yahoocheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Yahoo Rank
                                                    </s:else>
                                                </label>
                                                <label class="toggle state-success">
                                                    <s:if test="%{bingtab == 1}">
                                                        <input type="checkbox" name="checkbox-toggle" checked id="bingcheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Bing Rank
                                                    </s:if>
                                                    <s:else>
                                                        <input type="checkbox" name="checkbox-toggle" id="bingcheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Bing Rank
                                                    </s:else>
                                                </label>
                                                <label class="toggle state-success">
                                                    <s:if test="%{daychangetab == 1}">
                                                        <input type="checkbox" name="checkbox-toggle" checked id="daycheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Day Change
                                                    </s:if>
                                                    <s:else>
                                                        <input type="checkbox" name="checkbox-toggle" id="daycheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Day Change
                                                    </s:else>
                                                </label>
                                                <label class="toggle state-success">
                                                    <s:if test="%{weekchangetab == 1}">
                                                        <input type="checkbox" name="checkbox-toggle" checked id="weekcheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Week Change
                                                    </s:if>
                                                    <s:else>
                                                        <input type="checkbox" name="checkbox-toggle" id="weekcheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Week Change
                                                    </s:else>
                                                </label>
                                                <label class="toggle state-success">
                                                    <s:if test="%{monthchangetab == 1}">
                                                        <input type="checkbox" name="checkbox-toggle" checked id="monthcheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Month Change
                                                    </s:if>
                                                    <s:else>
                                                        <input type="checkbox" name="checkbox-toggle" id="monthcheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Month Change
                                                    </s:else>
                                                </label>
                                                <label class="toggle state-success">
                                                    <s:if test="%{alexatab == 1}">
                                                        <input type="checkbox" name="checkbox-toggle" checked id="alexacheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Alexa Rank
                                                    </s:if>
                                                    <s:else>
                                                        <input type="checkbox" name="checkbox-toggle" id="alexacheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Alexa Rank
                                                    </s:else>
                                                </label>
                                                <label class="toggle state-success">
                                                    <s:if test="%{backlinkstab == 1}">
                                                        <input type="checkbox" name="checkbox-toggle" checked id="blcheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Back Links
                                                    </s:if>
                                                    <s:else>
                                                        <input type="checkbox" name="checkbox-toggle" id="blcheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Back Links
                                                    </s:else>
                                                </label>
                                                <label class="toggle state-success">
                                                    <s:if test="%{monthlysearchstab == 1}">
                                                        <input type="checkbox" name="checkbox-toggle" checked id="mscheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Monthly Searches
                                                    </s:if>
                                                    <s:else>
                                                        <input type="checkbox" name="checkbox-toggle" id="mscheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Monthly Searches
                                                    </s:else>
                                                </label>
                                                <label class="toggle state-success">
                                                    <s:if test="%{serpcampaigntab == 1}">
                                                        <input type="checkbox" name="checkbox-toggle" checked id="serpcheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Serp Campaign
                                                    </s:if>
                                                    <s:else>
                                                        <input type="checkbox" name="checkbox-toggle" id="serpcheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Serp Campaign
                                                    </s:else>
                                                </label>
                                                <label class="toggle state-success">
                                                    <s:if test="%{videocampaigntab == 1}">
                                                        <input type="checkbox" name="checkbox-toggle" checked id="videocheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Video Campaign
                                                    </s:if>
                                                    <s:else>
                                                        <input type="checkbox" name="checkbox-toggle" id="videocheck">                                                        
                                                        <i data-swchon-text="ON" data-swchoff-text="OFF"></i>Video Campaign
                                                    </s:else>
                                                </label>                                            
                                            </s:iterator>
                                        </s:else>
                                    </label>

                                </fieldset>

                                <footer>
                                    <button type="submit" class="btn btn-primary" onclick="editTabSettings();"> 
                                        Save Changes
                                    </button>
                                </footer>
                            </div>
                            <!-- end widget content -->
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
                    <span class="widget-icon"> <i class="fa fa-key"></i> </span>
                    <h2>Change Password </h2>

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

                            <s:form action="changePassword.action" method="post">

                                <fieldset>
                                    <section>
                                        <label class="label">Old Password</label>
                                        <label class="input">
                                            <input type="password"  name="oldpassword" id="oldpassword" class="input-xs" autocomplete="off"/>
                                        </label>
                                    </section>

                                    <section>
                                        <label class="label">New Password</label>
                                        <label class="input">
                                            <input type="password" name="newpassword" id ="newpassword" class="input-xs" autocomplete="off"/>
                                        </label>
                                    </section>
                                </fieldset>

                                <footer>
                                    <button type="submit" class="btn btn-primary" onclick="return changepassword();">
                                        Save Changes
                                    </button>
                                </footer>
                            </s:form>

                        </div>
                        <!-- end widget content -->
                    </div>

                </div>
                <!-- end widget div -->

            </div>
            <!-- end widget -->

        </article>
        <!-- END COL -->

        <s:if test="%{userType == 0}">
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
                        <span class="widget-icon"> <i class="fa fa-user"></i> </span>
                        <h2>Add User </h2>

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

                                <s:form action="addUser.action" method="post">

                                    <fieldset>

                                        <section>
                                            <label class="label">Email Address</label>
                                            <label class="input">
                                                <input type="email" name="useremail" id="useremail" class="input-xs" autocomplete="off" />
                                            </label>
                                        </section>

                                        <section>
                                            <label class="label">Password</label>
                                            <label class="input">
                                                <input type="password" name="userpassword" id="userpassword" class="input-xs" autocomplete="off" />
                                            </label>
                                        </section>

                                    </fieldset>

                                    <footer>
                                        <button type="submit" class="btn btn-primary" onclick="return adduser();">
                                            Add User
                                        </button>
                                    </footer>
                                </s:form>

                            </div>
                            <!-- end widget content -->
                        </div>
                    </div>
                    <!-- end widget div -->

                </div>
                <!-- end widget -->

            </article>
            <!-- END COL -->
        </s:if>

    </div>
    <!-- END ROW -->


    <s:if test="%{userType == 0}">
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
                        <span class="widget-icon"> <i class="fa fa-users"></i> </span>
                        <h2>Added User</h2>
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

                                <s:form action="" method="post" >
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Email Address</th>
                                                <th>Password</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="lstUsers" status="temp">
                                                <tr>
                                                    <td><s:property value="loginID" /></td>
                                                    <td><s:property value="password" /></td>
                                                    <td><a  href="#" id="edit" onclick="edit(<s:property value="userID" />, '<s:property value="loginID" />', '<s:property value="password" />');" title="Edit"><i class="fa fa-pencil fa-2x txt-color-yellow" data-toggle="modal" data-target="#editmodal"></i></a></td>
                                                    <td ><a href="#" id="delete" onclick="deleteform(<s:property value="userID"/>);" ><i class="fa fa-trash-o fa-2x" data-toggle="modal" data-target="#deletemodal"></i></a></td>
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>
                                </s:form>

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
    </s:if>

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
                        <table class="table table-bordered">
                            <s:hidden name="eUserId" id="userId"/>
                            <thead>
                                <tr>
                                    <th>Email Address</th>
                                    <th>Password</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <label class="input col-md-12">
                                            <input type="text" class="input-sm col-md-12" name="eLoginId" id="editLoginId"/>
                                        </label>
                                    </td>
                                    <td>
                                        <label class="input col-md-12">
                                            <input type="text" class="input-sm col-md-12" name="ePassword" id="editPassword"/>
                                        </label>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick = "return editUserDetails();">Save Change</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->

    <!--delete Modal -->
    <s:form action="" id="deleteForm" onsubmit="return false;">
        <div class="modal fade" id="deletemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Delete !</h4>
                    </div>
                    <div class="modal-body">
                        <h4>Are you sure want to delete this user?</h4>
                        <input class="form-control" type="hidden" name="campaignId" id="campaignId" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default btn-danger" onclick="deleteUser();">Yes</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of model-->

</section>
<!-- end widget grid -->

<script type="text/javascript">
    function editTabSettings() {
        if (document.getElementById("googlecheck").checked) {
            document.getElementById('googletab').setAttribute("value", "1");
        }
        else
        {
            document.getElementById('googletab').setAttribute("value", "0");
        }
        if (document.getElementById("yahoocheck").checked) {
            document.getElementById('yahootab').setAttribute("value", "1");
        }
        else
        {
            document.getElementById('yahootab').setAttribute("value", "0");
        }
        if (document.getElementById("bingcheck").checked) {
            document.getElementById('bingtab').setAttribute("value", "1");
        }
        else
        {
            document.getElementById('bingtab').setAttribute("value", "0");
        }
        if (document.getElementById("daycheck").checked) {
            document.getElementById('daychangetab').setAttribute("value", "1");
        }
        else
        {
            document.getElementById('daychangetab').setAttribute("value", "0");
        }
        if (document.getElementById("weekcheck").checked) {
            document.getElementById('weekchangetab').setAttribute("value", "1");
        }
        else
        {
            document.getElementById('weekchangetab').setAttribute("value", "0");
        }
        if (document.getElementById("monthcheck").checked) {
            document.getElementById('monthchangetab').setAttribute("value", "1");
        }
        else
        {
            document.getElementById('monthchangetab').setAttribute("value", "0");
        }
        if (document.getElementById("alexacheck").checked) {
            document.getElementById('alexatab').setAttribute("value", "1");
        }
        else
        {
            document.getElementById('alexatab').setAttribute("value", "0");
        }
        if (document.getElementById("blcheck").checked) {
            document.getElementById('backlinkstab').setAttribute("value", "1");
        }
        else
        {
            document.getElementById('backlinkstab').setAttribute("value", "0");
        }
        if (document.getElementById("mscheck").checked) {
            document.getElementById('monthlysearchstab').setAttribute("value", "1");
        }
        else
        {
            document.getElementById('monthlysearchstab').setAttribute("value", "0");
        }
        if (document.getElementById("serpcheck").checked) {
            document.getElementById('serpcampaigntab').setAttribute("value", "1");
        }
        else
        {
            document.getElementById('serpcampaigntab').setAttribute("value", "0");
        }
        if (document.getElementById("videocheck").checked) {
            document.getElementById('videocampaigntab').setAttribute("value", "1");
        }
        else
        {
            document.getElementById('videocampaigntab').setAttribute("value", "0");
        }
        if (document.getElementById("summarycheck").checked) {
            document.getElementById('summarytab').setAttribute("value", "1");
        }
        else
        {
            document.getElementById('summarytab').setAttribute("value", "0");
        }
    }

    var alertmsg = "";

    function changepassword() {
        var oldpassword = $("#oldpassword").val();
        if (oldpassword === null || oldpassword === "") {
            alert("Old Password required");
            return false;
        }
        var newpassword = $("#newpassword").val();

        var passwordReg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
        if (!passwordReg.test(newpassword)) {
            alert("Password must contain at least 6 characters, including UPPER/lowercase and numbers");
            return false;
        }
    }

    function adduser() {
        var useremail = $("#useremail").val();

        if ($("#useremail").val() === "") {
            alert("EmailId is required");
            return false;
        }

        var emailReg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (!emailReg.test(useremail)) {
            alert("Enter valid Email Address");
            return false;
        }

        var newpassword = $("#userpassword").val();

        var passwordReg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
        if (!passwordReg.test(newpassword)) {
            alert("Password must contain at least 6 characters, including UPPER/lowercase and numbers");
            return false;
        }

    }

    function edit(loginId, password, userId) {
        try {
            document.editForm.eUserId.value = loginId;
            document.editForm.eLoginId.value = password;
            document.editForm.ePassword.value = userId;
        } catch (e)
        {
            alert(e);
        }
    }

    function editUserDetails() {
        var userId = $("#userId").val();
        var editLoginId = $("#editLoginId").val();
        var editPassword = $("#editPassword").val();

        if (editLoginId === null || editLoginId === "") {
            alert("Email Address required");
            return false;
        }

        var emailReg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (!emailReg.test(editLoginId)) {
            alert("Enter valid Email Address");
            return false;
        }

        var newpassword = $("#editPassword").val();

        var passwordReg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
        if (!passwordReg.test(newpassword)) {
            alert("Password must contain at least 6 characters, including UPPER/lowercase and numbers");
            return false;
        }

        $.post(
        'ajax/updateUserDetails.action',
        {
            editUserId: userId,
            editLoginId: editLoginId,
            editPassword: editPassword
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "settings.action";
        },
        'json');
    }

    function deleteform(campaignId)
    {
        try {
            document.deleteForm.campaignId.value = campaignId;
        } catch (e) {
            alert(e);
        }
    }

    function deleteUser() {

        var jString = document.deleteForm.campaignId.value;
        $.post(
        'ajax/deleteUser.action',
        {
            delUserId: jString
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "settings.action";
        },
        'json');
    }

</script>

<!-- Body end -->