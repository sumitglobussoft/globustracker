<%@taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                                    <c:forEach items="${listPlans}" var="plans">
                                        <option>${plans.name}</option>
                                    </c:forEach>

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
                                <input type="text" class="form-control" name="user" id="user" readonly="true" /> <br />
                            </div>
                            <div class="col-md-3" style="margin-top: 1%;">
                                <label class="control-label">GoogleAnalytics</label>
                            </div>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="googleAnalytics" id="googleAnalytics" readonly="true" /> <br />
                            </div> 
                            <div class="col-md-3" style="margin-top: 1%;">
                                <label class="control-label">KeywordResearch</label>
                            </div>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="keywordResearch" id="keywordResearch" readonly="true" /> <br />
                            </div> 
                            <div class="col-md-3" style="margin-top: 1%;">
                                <label class="control-label">Webmastertools</label>
                            </div>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="webmastertools" id="webmastertools" readonly="true" /> <br />
                            </div> 
                            <div class="col-md-3" style="margin-top: 1%;">
                                <label class="control-label">WebsiteReview</label>
                            </div>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="websiteReview" id="websiteReview" readonly="true" /> <br />
                            </div> 
                            <div class="col-md-3" style="margin-top: 1%;">
                                <label class="control-label">AccurateLocalRanking</label>
                            </div>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="accurateLocalRanking" id="accurateLocalRanking" readonly="true" /> <br />
                            </div> 
                            <div class="col-md-3" style="margin-top: 1%;">
                                <label class="control-label">LinkAnalysis</label>
                            </div>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="linkAnalysis" id="linkAnalysis" readonly="true" />
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
            document.getElementById('googleAnalytics').setAttribute("value", "");
            document.getElementById('keywordResearch').setAttribute("value", "");
            document.getElementById('webmastertools').setAttribute("value", "");
            document.getElementById('websiteReview').setAttribute("value", "");
            document.getElementById('accurateLocalRanking').setAttribute("value", "");
            document.getElementById('linkAnalysis').setAttribute("value", "");
        }
        else {
    <c:forEach items="${listPlans}" var="plans">
            if (document.getElementById('plans').value === '${plans.name}') {

                document.getElementById('plan').setAttribute("value", '${plans.name}');
                document.getElementById('planId').setAttribute("value", '${plans.planID}');
                document.getElementById('amount').setAttribute("value", '${plans.amount}');
                document.getElementById('campaign').setAttribute("value", '${plans.campaigns}');
                document.getElementById('keyword').setAttribute("value", '${plans.keywords}');
                document.getElementById('user').setAttribute("value", '${plans.users}');
                document.getElementById('googleAnalytics').setAttribute("value", '${plans.googleAnalytics}');
                document.getElementById('keywordResearch').setAttribute("value", '${plans.keywordResearch}');
                document.getElementById('webmastertools').setAttribute("value", '${plans.webmastertools}');
                document.getElementById('websiteReview').setAttribute("value", '${plans.websiteReview}');
                document.getElementById('accurateLocalRanking').setAttribute("value", '${plans.accurateLocalRanking}');
                document.getElementById('linkAnalysis').setAttribute("value", '${plans.linkAnalysis}');
            }

    </c:forEach>
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