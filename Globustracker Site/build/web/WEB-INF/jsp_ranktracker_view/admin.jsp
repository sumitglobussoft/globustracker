<%@page import="java.util.Date"%>
<%@taglib  uri="/struts-tags" prefix="s"%>
<style>
    @media
    only screen and (max-width: 760px),
    (min-device-width: 768px) and (max-device-width: 1024px) {
        table, thead, tbody, th, td, tr {
            display: block;
        }
    }
</style>
<!-- begin page-header -->
<h1 class="page-header">WELCOME <span class="text-danger">Admin</span></h1>
<%
    Date date = new Date();
    out.print("<h4 class=\"heading glyphicons calendar\"><i></i>" + date.toString() + "</h4>");
%>
<!-- end page-header -->

<!-- begin row -->

<div id="fade_away" style="color:#FF0000;">
    <br>
    <s:actionmessage />
    <s:actionerror />
</div>

<div class="row">
    &nbsp;
</div>
<!-- end row -->
<!-- begin row -->
<%  int count = 1;%>
<div class="row">
    <div class="tables">
        <table>
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Active</th>
                    <th>Added Date</th>
                    <th>Activate User</th>
                    <th>Deactivate User</th>
                    <th>Account Details</th>
                </tr>
            </thead>

            <tbody>
                <s:iterator value="lstUsers" status="temp">
                    <tr class="selectable">
                        <td class="center" ><%= count++%>
                            <input type="hidden" id="customerID" name="customerID" value="<s:property value="CustomerID.CustomerID" />">
                            <s:hidden value="userID"/>
                        </td>
                        <td class="center"><s:property value="loginID"/></td>
                        <td class="center"><s:property value="password"/></td>
                        <s:if test="%{active == 1}">
                            <td class="center">
                                <i class="fa fa-check text-success"></i>              
                            </td>
                        </s:if>
                        <s:else>
                            <td class="center">
                                <i class="fa fa-ban text-danger"></i>
                            </td>
                        </s:else>
                        <td class="center"><s:property value="addeddate"/></td>
                        <td class="center">
                            <a onclick="active(<s:property value="CustomerID.CustomerID"/>);" style="cursor: pointer"><i class="fa fa-2x fa-check-square-o text-success" data-toggle="modal" data-target="#activemodal"></i></a>
                        </td>
                        <td class="center">
                            <a onclick="deactive(<s:property value="CustomerID.CustomerID"/>);" style="cursor: pointer"><i class="fa fa-2x fa-remove text-danger" data-toggle="modal" data-target="#deactivemodal"></i></a>
                        </td>
                        <td class="center">
                            <a href="userAccount.action?customerID=<s:property value="CustomerID.CustomerID"/>" style="cursor: pointer">Get User Details</a>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>
</div>
<!-- end row -->

<!--delete Modal -->
<s:form action="" id="activeForm" onsubmit="return false;">
    <div class="modal fade" id="activemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">Activate User !</h4>
                </div>
                <div class="modal-body">
                    <h4>Are you sure, you want to activate this user account?</h4>
                    <input class="form-control" type="hidden" name="customerId" id="customerId" />
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-danger" onclick="activateUser();">Yes</button>
                    <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                </div>
            </div>
        </div>
    </div>
</s:form>
<!--end of model-->

<!--delete Modal -->
<s:form action="" id="deactiveForm" onsubmit="return false;">
    <div class="modal fade" id="deactivemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">Deactivate User !</h4>
                </div>
                <div class="modal-body">
                    <h4>Are you sure, you want to deactivate this user account?</h4>
                    <input class="form-control" type="hidden" name="customerId" id="customerId" />
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-danger" onclick="deactivateUser();">Yes</button>
                    <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                </div>
            </div>
        </div>
    </div>
</s:form>
<!--end of model-->

<script type='text/javascript'>   

    function active(customerID)
    {
        try {
            document.activeForm.customerId.value = customerID;
        } catch (e) {
            alert(e);
        }
    }
                            
    function activateUser()
    {
        var jString = document.activeForm.customerId.value;
        $.post(
        'ajax/activateUser.action',
        {
            customerID : jString
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "admin.action";
        },
        'json');       
    }
    
    function deactive(customerID)
    {
        try {
            document.deactiveForm.customerId.value = customerID;
        } catch (e) {
            alert(e);
        }
    }

    function deactivateUser()
    {
        var jString = document.deactiveForm.customerId.value;
        $.post(
        'ajax/deactivateUser.action',
        {
            customerID : jString
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "admin.action";
        },
        'json');
       
    }
</script>   