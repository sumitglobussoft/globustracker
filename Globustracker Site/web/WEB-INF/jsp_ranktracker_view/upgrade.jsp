<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<%

    if (session.getAttribute("customerID") == null) {
        response.sendRedirect("home.action");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
    }

    String plan = "na";
    int keywordCount = (Integer) session.getAttribute("allowedKeywordCount");
    switch (keywordCount) {
        case 20:
            plan = "Free";
            break;
        case 100:
            plan = "Newbie";
            break;
        case 200:
            plan = "Individual";
            break;
        case 500:
            plan = "Master";
            break;
        case 1000:
            plan = "Professional";
            break;
        case 5000:
            plan = "Agency";
            break;
        case 10000:
            plan = "Reseller";
            break;
        case 30000:
            plan = "Enterprise";
            break;
    }
    ////////////////////////////////////////////////////////////

    String currentPlan = "na";
    int campaignsCount = (Integer) session.getAttribute("allowedCampaignCount");
    switch (campaignsCount) {
        case 1:
            currentPlan = "Free";
            break;
        case 5:
            currentPlan = "Newbie";
            break;
        case 10:
            currentPlan = "Individual";
            break;
        case 30:
            currentPlan = "Master";
            break;
        case 50:
            currentPlan = "Professional";
            break;
        case 250:
            currentPlan = "Agency";
            break;
        case 500:
            currentPlan = "Reseller";
            break;
        case 1500:
            currentPlan = "Enterprise";
            break;
    }
    // out.println( currentPlan);
    //out.println( campaignsCount);
    //  out.println( keywordCount);
    //  out.println( plan);
    pageContext.setAttribute("currentPlan", currentPlan);
    pageContext.setAttribute("campaignsCount", campaignsCount);
%>
<style>
    .btn-primary1 {
        background-color: #dff0d8;
        border-color: #d6e9c6;
        color: #3c763d;
    }
</style>

<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa-fw fa fa-bolt"></i>
            RankTracker 
            <span>>
                Pricing 
            </span>
        </h1>
    </div>


    <div class="col-sm-12">

        <div class="well well-light">

            <div class="row">
                <c:set var="counter" value="0"/>
                <c:forEach items="${listPlans}" var="plans">
                    <c:if test="${plans.keywords!=50}">
                        <c:set var="counter" value="${counter+1}"/>
                        <!--counter is used for determining the color of the item. there are 4 colors so %4 is used-->
                        <c:if test="${counter%4 ==1}"> 
                            <div class="col-xs-12 col-sm-6 col-md-3">
                                <div class="panel panel-success pricing-big">

                                    <div class="panel-heading">
                                        <h3 class="panel-title">
                                            ${plans.name}
                                        </h3>
                                    </div>
                                    <div class="panel-body no-padding text-align-center">
                                        <div class="the-price">
                                            <c:if test="${plans.amount>0}">
                                                <h1>
                                                    $<span class="subscript">${plans.amount}</span>
                                                </h1>
                                            </c:if>
                                            <c:if test="${plans.amount==0}">
                                                <h1>
                                                    <strong>FREE</strong>
                                                </h1>
                                            </c:if>

                                        </div>
                                        <div class="price-features">
                                            <ul class="list-unstyled text-left">
                                                <li><i class="fa fa-check text-success"></i><strong>${plans.campaigns}</strong> Campaigns</li>
                                                <li><i class="fa fa-check text-success"></i><strong> ${plans.users}</strong> Users</li>
                                                <li><i class="fa fa-check text-success"></i><strong> ${plans.keywords}</strong> Keywords</li>
                                                        <c:if test="${plans.googleAnalytics ==1}">
                                                    <li><span class="fa fa-check text-success"></span>  Google Analytics</li>
                                                    </c:if>
                                                    <c:if test="${plans.googleAnalytics ==0}">
                                                    <li><span class="fa fa-times text-danger"></span>  Google Analytics</li>
                                                    </c:if>
                                                    <c:if test="${plans.keywordResearch ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Keyword Research</li>
                                                    </c:if>
                                                    <c:if test="${plans.keywordResearch ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Keyword Research</li>
                                                    </c:if>
                                                    <c:if test="${plans.webmastertools ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Webmaster Tool</li>
                                                    </c:if>
                                                    <c:if test="${plans.webmastertools ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Webmaster Tool</li>
                                                    </c:if>
                                                    <c:if test="${plans.websiteReview ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Website Review</li>
                                                    </c:if>
                                                    <c:if test="${plans.websiteReview ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Website Review</li>
                                                    </c:if>
                                                    <c:if test="${plans.accurateLocalRanking ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Accurate Local Ranking</li>
                                                    </c:if>
                                                    <c:if test="${plans.accurateLocalRanking ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Accurate Local Ranking</li>
                                                    </c:if>
                                                    <c:if test="${plans.linkAnalysis ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Link Analysis</li>
                                                    </c:if>
                                                    <c:if test="${plans.linkAnalysis ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Link Analysis</li>
                                                    </c:if>

                                            </ul>
                                        </div>
                                    </div>
                                    <c:if test="${plans.amount>0}">
                                        <!--Upgrade and downgrade is decide on the no.of campaigns. The condition is checked below. 
                                        If the no. of campaigns is morethan campaign in users plan then it says upgrade. 
                                        Else it says downgrade. In the campaigns are equal, it checks the planID. 
                                        If plan id is same it says Current plan. Else Upgrade-->
                                        <div class="panel-footer text-align-center">
                                            <c:if test="${pageScope.campaignsCount!=plans.campaigns&&pageScope.campaignsCount<plans.campaigns}">
                                                <a href="upgrade.action?itemName=${plans.name}" class="btn btn-primary btn-block" role="button">Upgrade</a>
                                            </c:if>
                                            <c:if test="${pageScope.campaignsCount!=plans.campaigns&&pageScope.campaignsCount>plans.campaigns}">
                                                <a href="upgrade.action?itemName=${plans.name}" class="btn btn-primary btn-block" role="button">Downgrade</a>
                                            </c:if>
                                            <c:if test="${pageScope.campaignsCount==plans.campaigns}">
                                                <c:if test="${custPlanID==plans.planID}">
                                                    <div class="btn btn-primary1 btn-block">Current Plan</div>
                                                </c:if>
                                                <c:if test="${custPlanID!=plans.planID}">
                                                    <a href="upgrade.action?itemName=${plans.name}" class="btn btn-primary btn-block" role="button">Upgrade</a>
                                                </c:if>
                                            </c:if>   
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${counter%4 ==2}">
                            <div class="col-xs-12 col-sm-6 col-md-3">
                                <div class="panel panel-teal pricing-big">

                                    <div class="panel-heading">
                                        <h3 class="panel-title">
                                            ${plans.name}
                                        </h3>
                                    </div>
                                    <div class="panel-body no-padding text-align-center">
                                        <div class="the-price">
                                            <c:if test="${plans.amount>0}">
                                                <h1>
                                                    $<span class="subscript">${plans.amount}</span>
                                                </h1>
                                            </c:if>
                                            <c:if test="${plans.amount==0}">
                                                <h1>
                                                    <strong>FREE</strong>
                                                </h1>
                                            </c:if>

                                        </div>
                                        <div class="price-features">
                                            <ul class="list-unstyled text-left">
                                                <li><i class="fa fa-check text-success"></i><strong>${plans.campaigns}</strong> Campaigns</li>
                                                <li><i class="fa fa-check text-success"></i><strong> ${plans.users}</strong> Users</li>
                                                <li><i class="fa fa-check text-success"></i><strong> ${plans.keywords}</strong> Keywords</li>
                                                        <c:if test="${plans.googleAnalytics ==1}">
                                                    <li><span class="fa fa-check text-success"></span>  Google Analytics</li>
                                                    </c:if>
                                                    <c:if test="${plans.googleAnalytics ==0}">
                                                    <li><span class="fa fa-times text-danger"></span>  Google Analytics</li>
                                                    </c:if>
                                                    <c:if test="${plans.keywordResearch ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Keyword Research</li>
                                                    </c:if>
                                                    <c:if test="${plans.keywordResearch ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Keyword Research</li>
                                                    </c:if>
                                                    <c:if test="${plans.webmastertools ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Webmaster Tool</li>
                                                    </c:if>
                                                    <c:if test="${plans.webmastertools ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Webmaster Tool</li>
                                                    </c:if>
                                                    <c:if test="${plans.websiteReview ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Website Review</li>
                                                    </c:if>
                                                    <c:if test="${plans.websiteReview ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Website Review</li>
                                                    </c:if>
                                                    <c:if test="${plans.accurateLocalRanking ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Accurate Local Ranking</li>
                                                    </c:if>
                                                    <c:if test="${plans.accurateLocalRanking ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Accurate Local Ranking</li>
                                                    </c:if>
                                                    <c:if test="${plans.linkAnalysis ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Link Analysis</li>
                                                    </c:if>
                                                    <c:if test="${plans.linkAnalysis ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Link Analysis</li>
                                                    </c:if>

                                            </ul>
                                        </div>
                                    </div>
                                    <c:if test="${plans.amount>0}">
                                        <div class="panel-footer text-align-center">
                                            <c:if test="${pageScope.campaignsCount!=plans.campaigns&&pageScope.campaignsCount<plans.campaigns}">
                                                <a href="upgrade.action?itemName=${plans.name}" class="btn btn-primary btn-block" role="button">Upgrade</a>
                                            </c:if>
                                            <c:if test="${pageScope.campaignsCount!=plans.campaigns&&pageScope.campaignsCount>plans.campaigns}">
                                                <a href="upgrade.action?itemName=${plans.name}" class="btn btn-primary btn-block" role="button">Downgrade</a>
                                            </c:if>
                                            <c:if test="${pageScope.campaignsCount==plans.campaigns}">
                                                <c:if test="${custPlanID==plans.planID}">
                                                    <div class="btn btn-primary1 btn-block">Current Plan</div>
                                                </c:if>
                                                <c:if test="${custPlanID!=plans.planID}">
                                                    <a href="upgrade.action?itemName=${plans.name}" class="btn btn-primary btn-block" role="button">Upgrade</a>
                                                </c:if>
                                            </c:if>   
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${counter%4 ==3}">
                            <div class="col-xs-12 col-sm-6 col-md-3">
                                <div class="panel panel-primary pricing-big">

                                    <div class="panel-heading">
                                        <h3 class="panel-title">
                                            ${plans.name}
                                        </h3>
                                    </div>
                                    <div class="panel-body no-padding text-align-center">
                                        <div class="the-price">
                                            <c:if test="${plans.amount>0}">
                                                <h1>
                                                    $<span class="subscript">${plans.amount}</span>
                                                </h1>
                                            </c:if>
                                            <c:if test="${plans.amount==0}">
                                                <h1>
                                                    <strong>FREE</strong>
                                                </h1>
                                            </c:if>

                                        </div>
                                        <div class="price-features">
                                            <ul class="list-unstyled text-left">
                                                <li><i class="fa fa-check text-success"></i><strong>${plans.campaigns}</strong> Campaigns</li>
                                                <li><i class="fa fa-check text-success"></i><strong> ${plans.users}</strong> Users</li>
                                                <li><i class="fa fa-check text-success"></i><strong> ${plans.keywords}</strong> Keywords</li>
                                                        <c:if test="${plans.googleAnalytics ==1}">
                                                    <li><span class="fa fa-check text-success"></span>  Google Analytics</li>
                                                    </c:if>
                                                    <c:if test="${plans.googleAnalytics ==0}">
                                                    <li><span class="fa fa-times text-danger"></span>  Google Analytics</li>
                                                    </c:if>
                                                    <c:if test="${plans.keywordResearch ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Keyword Research</li>
                                                    </c:if>
                                                    <c:if test="${plans.keywordResearch ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Keyword Research</li>
                                                    </c:if>
                                                    <c:if test="${plans.webmastertools ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Webmaster Tool</li>
                                                    </c:if>
                                                    <c:if test="${plans.webmastertools ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Webmaster Tool</li>
                                                    </c:if>
                                                    <c:if test="${plans.websiteReview ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Website Review</li>
                                                    </c:if>
                                                    <c:if test="${plans.websiteReview ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Website Review</li>
                                                    </c:if>
                                                    <c:if test="${plans.accurateLocalRanking ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Accurate Local Ranking</li>
                                                    </c:if>
                                                    <c:if test="${plans.accurateLocalRanking ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Accurate Local Ranking</li>
                                                    </c:if>
                                                    <c:if test="${plans.linkAnalysis ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Link Analysis</li>
                                                    </c:if>
                                                    <c:if test="${plans.linkAnalysis ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Link Analysis</li>
                                                    </c:if>
                                            </ul>
                                        </div>
                                    </div>
                                    <c:if test="${plans.amount>0}">
                                        <div class="panel-footer text-align-center">
                                            <c:if test="${pageScope.campaignsCount!=plans.campaigns&&pageScope.campaignsCount<plans.campaigns}">
                                                <a href="upgrade.action?itemName=${plans.name}" class="btn btn-primary btn-block" role="button">Upgrade</a>
                                            </c:if>
                                            <c:if test="${pageScope.campaignsCount!=plans.campaigns&&pageScope.campaignsCount>plans.campaigns}">
                                                <a href="upgrade.action?itemName=${plans.name}" class="btn btn-primary btn-block" role="button">Downgrade</a>
                                            </c:if>
                                            <c:if test="${pageScope.campaignsCount==plans.campaigns}">
                                                <c:if test="${custPlanID==plans.planID}">
                                                    <div class="btn btn-primary1 btn-block">Current Plan</div>
                                                </c:if>
                                                <c:if test="${custPlanID!=plans.planID}">
                                                    <a href="upgrade.action?itemName=${plans.name}" class="btn btn-primary btn-block" role="button">Upgrade</a>
                                                </c:if>
                                            </c:if>   
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${counter%4 ==0}">
                            <div class="col-xs-12 col-sm-6 col-md-3">
                                <div class="panel panel-darken pricing-big">

                                    <div class="panel-heading">
                                        <h3 class="panel-title">
                                            ${plans.name}
                                        </h3>
                                    </div>
                                    <div class="panel-body no-padding text-align-center">
                                        <div class="the-price">
                                            <c:if test="${plans.amount>0}">
                                                <h1>
                                                    $<span class="subscript">${plans.amount}</span>
                                                </h1>
                                            </c:if>
                                            <c:if test="${plans.amount==0}">
                                                <h1>
                                                    <strong>FREE</strong>
                                                </h1>
                                            </c:if>

                                        </div>
                                        <div class="price-features">
                                            <ul class="list-unstyled text-left">
                                                <li><i class="fa fa-check text-success"></i><strong>${plans.campaigns}</strong> Campaigns</li>
                                                <li><i class="fa fa-check text-success"></i><strong> ${plans.users}</strong> Users</li>
                                                <li><i class="fa fa-check text-success"></i><strong> ${plans.keywords}</strong> Keywords</li>
                                                        <c:if test="${plans.googleAnalytics ==1}">
                                                    <li><span class="fa fa-check text-success"></span>  Google Analytics</li>
                                                    </c:if>
                                                    <c:if test="${plans.googleAnalytics ==0}">
                                                    <li><span class="fa fa-times text-danger"></span>  Google Analytics</li>
                                                    </c:if>
                                                    <c:if test="${plans.keywordResearch ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Keyword Research</li>
                                                    </c:if>
                                                    <c:if test="${plans.keywordResearch ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Keyword Research</li>
                                                    </c:if>
                                                    <c:if test="${plans.webmastertools ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Webmaster Tool</li>
                                                    </c:if>
                                                    <c:if test="${plans.webmastertools ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Webmaster Tool</li>
                                                    </c:if>
                                                    <c:if test="${plans.websiteReview ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Website Review</li>
                                                    </c:if>
                                                    <c:if test="${plans.websiteReview ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Website Review</li>
                                                    </c:if>
                                                    <c:if test="${plans.accurateLocalRanking ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Accurate Local Ranking</li>
                                                    </c:if>
                                                    <c:if test="${plans.accurateLocalRanking ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Accurate Local Ranking</li>
                                                    </c:if>
                                                    <c:if test="${plans.linkAnalysis ==1}">
                                                    <li><span class="fa fa-check text-success"></span> Link Analysis</li>
                                                    </c:if>
                                                    <c:if test="${plans.linkAnalysis ==0}">
                                                    <li><span class="fa fa-times text-danger"></span> Link Analysis</li>
                                                    </c:if>

                                            </ul>
                                        </div>
                                    </div>
                                    <c:if test="${plans.amount>0}">
                                        <div class="panel-footer text-align-center">
                                            <c:if test="${pageScope.campaignsCount!=plans.campaigns&&pageScope.campaignsCount<plans.campaigns}">
                                                <a href="upgrade.action?itemName=${plans.name}" class="btn btn-primary btn-block" role="button">Upgrade</a>
                                            </c:if>
                                            <c:if test="${pageScope.campaignsCount!=plans.campaigns&&pageScope.campaignsCount>plans.campaigns}">
                                                <a href="upgrade.action?itemName=${plans.name}" class="btn btn-primary btn-block" role="button">Downgrade</a>
                                            </c:if>
                                            <c:if test="${pageScope.campaignsCount==plans.campaigns}">
                                                <c:if test="${custPlanID==plans.planID}">
                                                    <div class="btn btn-primary1 btn-block">Current Plan</div>
                                                </c:if>
                                                <c:if test="${custPlanID!=plans.planID}">
                                                    <a href="upgrade.action?itemName=${plans.name}" class="btn btn-primary btn-block" role="button">Upgrade</a>
                                                </c:if>
                                            </c:if>   
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>

    <%
        if (plan != "na") {
    %>

    <a href="upgrade.action?itemName=Add50Keywords">
        <button type="button" class="col-md-offset-4 btn btn-info btn-lg text-align-center">Add 50 Keywords to any package for $5</button>
    </a>

    <%
        }
    %>
</div>

<script type="text/javascript">

    function payNow(a) {

        window.location = 'paymentPaypal.action?itemName=' + a;
    }

    function payFree(a) {

        //alert(a);
        window.location = 'paymentCoupon.action?coupon=freebeta' + a;
    }
</script>
