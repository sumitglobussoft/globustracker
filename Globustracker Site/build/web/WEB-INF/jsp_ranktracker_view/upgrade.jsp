
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
            GlobusTracker 
            <span>>
                Pricing 
            </span>
        </h1>
    </div>


    <div class="col-sm-12">

        <div class="well well-light">

            <div class="row">

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <div class="panel panel-success pricing-big">

                        <div class="panel-heading">
                            <h3 class="panel-title">
                                Light version
                            </h3>
                        </div>
                        <div class="panel-body no-padding text-align-center">
                            <div class="the-price">
                                <h1>
                                    <strong>FREE</strong>
                                </h1>
                            </div>
                            <div class="price-features">
                                <ul class="list-unstyled text-left">
                                    <li><i class="fa fa-check text-success"></i><strong> 1</strong> Campaigns</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 1</strong> Users</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 20</strong> Keywords</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <div class="panel panel-teal pricing-big">

                        <div class="panel-heading">
                            <h3 class="panel-title">
                                Newbie
                            </h3>
                        </div>
                        <div class="panel-body no-padding text-align-center">
                            <div class="the-price">
                                <h1>
                                    $9<span class="subscript">.99</span>
                                </h1>
                            </div>
                            <div class="price-features">
                                <ul class="list-unstyled text-left">
                                    <li><i class="fa fa-check text-success"></i><strong> 5</strong> Campaigns</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 1</strong> Users</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 100</strong> Keywords</li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel-footer text-align-center">
                            <c:if test="${pageScope.campaignsCount!=5&&pageScope.campaignsCount<5}">
                                <a href="upgrade.action?itemName=Newbie" class="btn btn-primary btn-block" role="button">Upgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount!=5&&pageScope.campaignsCount>5}">
                                <a href="upgrade.action?itemName=Newbie" class="btn btn-primary btn-block" role="button">Downgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount==5}">
                                <div class="btn btn-primary1 btn-block">Current Plan</div>
                            </c:if>   
                        </div>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <div class="panel panel-primary pricing-big">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                Individual
                            </h3>
                        </div>
                        <div class="panel-body no-padding text-align-center">
                            <div class="the-price">
                                <h1>
                                    $19<span class="subscript">.99</span>
                                </h1>
                            </div>
                            <div class="price-features">
                                <ul class="list-unstyled text-left">
                                    <li><i class="fa fa-check text-success"></i><strong> 10</strong> Campaigns</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 1</strong> Users</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 200</strong> Keywords</li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel-footer text-align-center">
                            <c:if test="${pageScope.campaignsCount!=10&&pageScope.campaignsCount<10}">
                                <a href="upgrade.action?itemName=Individual" class="btn btn-primary btn-block" role="button">Upgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount!=10&&pageScope.campaignsCount>10}">
                                <a href="upgrade.action?itemName=Individual" class="btn btn-primary btn-block" role="button">Downgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount==10}">
                                <div class="btn btn-primary1 btn-block">Current Plan</div>
                            </c:if> 
                        </div>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <div class="panel panel-darken pricing-big">

                        <div class="panel-heading">
                            <h3 class="panel-title">
                                Master
                            </h3>
                        </div>
                        <div class="panel-body no-padding text-align-center">
                            <div class="the-price">
                                <h1>
                                    $34<span class="subscript">.99</span>
                                </h1>
                            </div>
                            <div class="price-features">
                                <ul class="list-unstyled text-left">
                                    <li><i class="fa fa-check text-success"></i><strong> 30</strong> Campaigns</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 3</strong> Users</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 500</strong> Keywords</li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel-footer text-align-center">
                            <c:if test="${pageScope.campaignsCount!=30&&pageScope.campaignsCount<30}">
                                <a href="upgrade.action?itemName=Master" class="btn btn-primary btn-block" role="button">Upgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount!=30&&pageScope.campaignsCount>30}">
                                <a href="upgrade.action?itemName=Master" class="btn btn-primary btn-block" role="button">Downgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount==30}">
                                <div class="btn btn-primary1 btn-block">Current Plan</div>
                            </c:if> 
                        </div>
                    </div>
                </div>
            </div>

            <hr>

            <div class="row">

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <div class="panel panel-success pricing-big">

                        <div class="panel-heading">
                            <h3 class="panel-title">
                                Professional
                            </h3>
                        </div>
                        <div class="panel-body no-padding text-align-center">
                            <div class="the-price">
                                <h1>
                                    $59<span class="subscript">.99</span>
                                </h1>
                            </div>
                            <div class="price-features">
                                <ul class="list-unstyled text-left">
                                    <li><i class="fa fa-check text-success"></i><strong> 50</strong> Campaigns</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 5</strong> Users</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 1000</strong> Keywords</li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel-footer text-align-center">
                            <c:if test="${pageScope.campaignsCount!=50&&pageScope.campaignsCount<50}">
                                <a href="upgrade.action?itemName=Professional" class="btn btn-primary btn-block" role="button">Upgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount!=50&&pageScope.campaignsCount>50}">
                                <a href="upgrade.action?itemName=Professional" class="btn btn-primary btn-block" role="button">Downgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount==50}">
                                <div class="btn btn-primary1 btn-block">Current Plan</div>
                            </c:if> 
                        </div>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <div class="panel panel-teal pricing-big">

                        <div class="panel-heading">
                            <h3 class="panel-title">
                                Agency
                            </h3>
                        </div>
                        <div class="panel-body no-padding text-align-center">
                            <div class="the-price">
                                <h1>
                                    $149<span class="subscript">.99</span>
                                </h1>
                            </div>
                            <div class="price-features">
                                <ul class="list-unstyled text-left">
                                    <li><i class="fa fa-check text-success"></i><strong> 250</strong> Campaigns</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 10</strong> Users</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 5000</strong> Keywords</li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel-footer text-align-center">
                            <c:if test="${pageScope.campaignsCount!=250&&pageScope.campaignsCount<250}">
                                <a href="upgrade.action?itemName=Agency" class="btn btn-primary btn-block" role="button">Upgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount!=250&&pageScope.campaignsCount>250}">
                                <a href="upgrade.action?itemName=Agency" class="btn btn-primary btn-block" role="button">Downgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount==250}">
                                <div class="btn btn-primary1 btn-block">Current Plan</div>
                            </c:if> 
                        </div>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <div class="panel panel-primary pricing-big">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                Reseller
                            </h3>
                        </div>
                        <div class="panel-body no-padding text-align-center">
                            <div class="the-price">
                                <h1>
                                    $299<span class="subscript">.99</span>
                                </h1>
                            </div>
                            <div class="price-features">
                                <ul class="list-unstyled text-left">
                                    <li><i class="fa fa-check text-success"></i><strong> 500</strong> Campaigns</li>
                                    <li><i class="fa fa-check text-success"></i><strong> Unlimited</strong> Users</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 10,000</strong> Keywords</li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel-footer text-align-center">
                            <c:if test="${pageScope.campaignsCount!=500&&pageScope.campaignsCount<500}">
                                <a href="upgrade.action?itemName=Reseller" class="btn btn-primary btn-block" role="button">Upgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount!=500&&pageScope.campaignsCount>500}">
                                <a href="upgrade.action?itemName=Reseller" class="btn btn-primary btn-block" role="button">Downgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount==500}">
                                <div class="btn btn-primary1 btn-block">Current Plan</div>
                            </c:if> 
                        </div>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <div class="panel panel-darken pricing-big">

                        <div class="panel-heading">
                            <h3 class="panel-title">
                                Enterprise
                            </h3>
                        </div>
                        <div class="panel-body no-padding text-align-center">
                            <div class="the-price">
                                <h1>
                                    $799<span class="subscript">.99</span>
                                </h1>
                            </div>
                            <div class="price-features">
                                <ul class="list-unstyled text-left">
                                    <li><i class="fa fa-check text-success"></i><strong> 1500</strong> Campaigns</li>
                                    <li><i class="fa fa-check text-success"></i><strong> Unlimited</strong> Users</li>
                                    <li><i class="fa fa-check text-success"></i><strong> 30,000</strong> Keywords</li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel-footer text-align-center">
                            <c:if test="${pageScope.campaignsCount!=1500&&pageScope.campaignsCount<500}">
                                <a href="upgrade.action?itemName=Enterprise" class="btn btn-primary btn-block" role="button">Upgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount!=1500&&pageScope.campaignsCount>500}">
                                <a href="upgrade.action?itemName=Enterprise" class="btn btn-primary btn-block" role="button">Downgrade</a>
                            </c:if>
                            <c:if test="${pageScope.campaignsCount==1500}">
                                <div class="btn btn-primary1 btn-block">Current Plan</div>
                            </c:if> 
                        </div>
                    </div>
                </div>		    	
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
