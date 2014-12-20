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
                Admin Panel
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
                    <span class="widget-icon"> <i class="fa fa-users"></i> </span>
                    <h2>Proxies List</h2>
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

                                <s:form action="" method="post" >
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>IP Adress</th>
                                                <th>Port Number</th>
                                                <th>Username</th>
                                                <th>Password</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="lstProxies" status="temp">
                                                <tr>
                                                    <td><s:property value="iPAddress" /></td>
                                                    <td><s:property value="portNo" /></td>
                                                    <td><s:property value="proxyUser" /></td>
                                                    <td><s:property value="proxyPassword" /></td>
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

                        <footer>
                            <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#addmodal">
                                Add User
                            </button>                     
                        </footer>

                    </div>
                    <!-- end widget div -->

                </div>

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
                    <span class="widget-icon"> <i class="fa fa-users"></i> </span>
                    <h2>Users List</h2>
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

                        <footer>
                            <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#addmodal">
                                Add User
                            </button>                     
                        </footer>

                    </div>
                    <!-- end widget div -->

                </div>

            </div>
            <!-- end widget -->

        </article>
        <!-- END COL -->

    </div>
    <!-- END ROW -->

    <!--add Modal -->
    <s:form action="addUser.action" method="post">
        <div class="modal fade" id="addmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Add User !</h4>
                    </div>
                    <div class="modal-body">
                        <table class="table table-bordered">
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
                                            <input type="email" name="useremail" id="useremail" class="input-sm col-md-12" autocomplete="off" />
                                        </label>
                                    </td>
                                    <td>
                                        <label class="input col-md-12">
                                            <input type="password" name="userpassword" id="userpassword" class="input-sm col-md-12" autocomplete="off" />
                                        </label>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-info " onclick = "return adduser();">Add User</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of modal-->

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
            window.location = "adminPanel.action";
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
            window.location = "adminPanel.action";
        },
                'json');
    }

</script>

<!-- Body end -->