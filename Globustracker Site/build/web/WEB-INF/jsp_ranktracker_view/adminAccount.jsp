<%@taglib  uri="/struts-tags" prefix="s"%>
<!-- begin breadcrumb -->
<ol class="breadcrumb pull-right">
    <li><a href="admin.action">&lt;&lt; &nbsp; Back to admin page</a></li>
</ol>
<!-- end breadcrumb -->
<!-- begin page-header -->
<h1 class="page-header">User Details - <span class="text-danger"><s:property value="account.name" /></span></h1>
<!-- end page-header -->

<!-- begin row -->
<div class="row">
    &nbsp;
</div>
<!-- end row -->
<!-- begin row -->
<div class="row">
    <div class="tables1">
        <table style="border: 2px solid rgb(64, 64, 64) ! important;">
            <thead>
                <tr style="background:#404040; color:#FFF;">
                    <td colspan="2">Current Plan</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td style="width: 25%;"><b>Name</b></td>
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
                <tr>
                    <td></td>
                    <td>
                        <ol class="breadcrumb pull-right">
                            <a href="#" data-toggle="modal" data-target="#updateModal"><span class="text-danger"><b>&lt;&lt;Edit User Plan&gt;&gt;</b></span></a>
                        </ol>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
<!-- end row -->  

<!-- Update Modal -->
<form action="updateUserPlan.action" class="form-group" method="get" validate="true" onsubmit="return validate()" >
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <button aria-hidden="true" data-dismiss="modal" class="close" type="button">&times;</button>
                    <h4 class="modal-title">Change Plan !</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-12">

                            <label class="control-label" hidden="true" id="cust"><s:property value="#session.custID"/></label>
                            <input type="hidden" class="form-control" name="custId" id="custId" />
                            <input type="hidden" class="form-control" name="planId" id="planId" />
                            <input type="hidden" class="form-control" name="amount" id="amount" />

                            <div class="col-md-3" style="margin-top: 1%;">
                                <label class="control-label">Choose Plan</label>
                            </div>
                            <div class="col-md-9">
                                <select class="form-control" id="plans" onclick="selectplan();">
                                    <option>Select Plan</option>
                                    <option>Free</option>
                                    <option>Newbie</option>
                                    <option>Individual</option>
                                    <option>Master</option>
                                    <option>Professional</option>
                                    <option>Agency</option>
                                    <option>Reseller</option>
                                    <option>Enterprise</option>
                                </select> <br />
                            </div>
                            <div class="col-md-3" style="margin-top: 1%;">
                                <label class="control-label">Plan Name</label>
                            </div>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="plan" id="plan" readonly="true" /> <br />
                            </div>
                            <div class="col-md-3" style="margin-top: 1%;">
                                <label class="control-label">Campaigns</label>
                            </div>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="campaign" id="campaign" readonly="true" /> <br />
                            </div>
                            <div class="col-md-3" style="margin-top: 1%;">
                                <label class="control-label">Keywords</label>
                            </div>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="keyword" id="keyword" readonly="true" /> <br />
                            </div>
                            <div class="col-md-3" style="margin-top: 1%;">
                                <label class="control-label">Users</label>
                            </div>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="user" id="user" readonly="true" />
                            </div>                        
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-success">Update Plan</button>
                    <button class="btn btn-danger" data-dismiss="modal">Cancel</button>
                </div>
            </div>
        </div>
    </div>
</form>
<!-- End Update Modal -->

<script type='text/javascript'>
    function selectplan()
    {
        var customer = document.getElementById('custId');
        customer.setAttribute("value", document.getElementById('cust').textContent);
                
        if (document.getElementById('plans').value == 'Select Plan') {
            document.getElementById('plan').setAttribute("value", "");
            document.getElementById('planId').setAttribute("value", "");
            document.getElementById('amount').setAttribute("value", "");
            document.getElementById('campaign').setAttribute("value", "");
            document.getElementById('keyword').setAttribute("value", "");
            document.getElementById('user').setAttribute("value", "");
        }
        else if (document.getElementById('plans').value == 'Free') {
            document.getElementById('plan').setAttribute("value", "Free");
            document.getElementById('planId').setAttribute("value", "1");
            document.getElementById('amount').setAttribute("value", "0");
            document.getElementById('campaign').setAttribute("value", "1");
            document.getElementById('keyword').setAttribute("value", "20");
            document.getElementById('user').setAttribute("value", "1");
        }
        else if (document.getElementById('plans').value == 'Newbie') {
            document.getElementById('plan').setAttribute("value", "Newbie");
            document.getElementById('planId').setAttribute("value", "2");
            document.getElementById('amount').setAttribute("value", "1");
            document.getElementById('campaign').setAttribute("value", "5");
            document.getElementById('keyword').setAttribute("value", "100");
            document.getElementById('user').setAttribute("value", "1");
        }
        else if (document.getElementById('plans').value == 'Individual') {
            document.getElementById('plan').setAttribute("value", "Individual");
            document.getElementById('planId').setAttribute("value", "3");
            document.getElementById('amount').setAttribute("value", "1");
            document.getElementById('campaign').setAttribute("value", "10");
            document.getElementById('keyword').setAttribute("value", "200");
            document.getElementById('user').setAttribute("value", "1");
        }
        else if (document.getElementById('plans').value == 'Master') {
            document.getElementById('plan').setAttribute("value", "Master");
            document.getElementById('planId').setAttribute("value", "4");
            document.getElementById('amount').setAttribute("value", "1");
            document.getElementById('campaign').setAttribute("value", "30");
            document.getElementById('keyword').setAttribute("value", "500");
            document.getElementById('user').setAttribute("value", "3");
        }
        else if (document.getElementById('plans').value == 'Professional') {
            document.getElementById('plan').setAttribute("value", "Professional");
            document.getElementById('planId').setAttribute("value", "5");
            document.getElementById('amount').setAttribute("value", "1");
            document.getElementById('campaign').setAttribute("value", "50");
            document.getElementById('keyword').setAttribute("value", "1000");
            document.getElementById('user').setAttribute("value", "5");
        }
        else if (document.getElementById('plans').value == 'Agency') {
            document.getElementById('plan').setAttribute("value", "Agency");
            document.getElementById('planId').setAttribute("value", "6");
            document.getElementById('amount').setAttribute("value", "1");
            document.getElementById('campaign').setAttribute("value", "250");
            document.getElementById('keyword').setAttribute("value", "5000");
            document.getElementById('user').setAttribute("value", "10");
        }
        else if (document.getElementById('plans').value == 'Reseller') {
            document.getElementById('plan').setAttribute("value", "Reseller");
            document.getElementById('planId').setAttribute("value", "7");
            document.getElementById('amount').setAttribute("value", "1");
            document.getElementById('campaign').setAttribute("value", "500");
            document.getElementById('keyword').setAttribute("value", "10000");
            document.getElementById('user').setAttribute("value", "5000");
        }
        else if (document.getElementById('plans').value == 'Enterprise') {
            document.getElementById('plan').setAttribute("value", "Enterprise");
            document.getElementById('planId').setAttribute("value", "8");
            document.getElementById('amount').setAttribute("value", "1");
            document.getElementById('campaign').setAttribute("value", "1500");
            document.getElementById('keyword').setAttribute("value", "30000");
            document.getElementById('user').setAttribute("value", "10000");
        }
    }
    
    function validate()
    {
        if (document.getElementById('plan').value == '') {
            alert("Please choose the plan to proceed");
            return false;
        }
    }
</script>