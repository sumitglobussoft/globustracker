<%-- 
    Document   : package
    Created on : Oct 5, 2015, 4:20:11 PM
    Author     : GLB-214
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="/struts-tags" prefix="s"%>


<style>
    label.error {
        color: red;
        font-size: 13px;
    }
    .error {
        text-align: left;
    }
    .group:before,
    .group:after {
        content: "";
        display: table;
    } 
    .group:after {
        clear: both;
    }
    .group {
        zoom: 1;  /*For IE 6/7 (trigger hasLayout) */
    }
    .pricing-table {
        /*width: 88%;*/
        margin: 0px auto;
        text-align: center;
        padding: 10px;
        padding-right: 0;
    }
    .pricing-table .heading{
        color: #9C9E9F;
        margin-bottom: 3rem;
    }
    .block{
        /*    width: 20%;    
                margin: 0 15px;*/
        overflow: hidden;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 5px;    
        /*    border: 1px solid red;*/
    }
    /*Shared properties*/
    .title,.pt-footer{
        color: #FEFEFE;
        text-transform: capitalize;
        line-height: 2.5;
        position: relative;
    }
    .content1 {
        position: relative;
        color: #FEFEFE;
        padding: 20px 0 0;
    }
    /*arrow creation*/
    .content1:after, .content1:before,.pt-footer:before,.pt-footer:after {
        top: 100%;
        left: 50%;
        border: solid transparent;
        content: " ";
        height: 0;
        width: 0;
        position: absolute;
        pointer-events: none;
    }
    .pt-footer:after,.pt-footer:before{
        top:0;
    }
    .content1:after,.pt-footer:after {
        border-color: rgba(136, 183, 213, 0);	
        border-width: 5px;
        margin-left: -5px;
    }
    /*/arrow creation*/
    .price{
        position: relative;
        display: inline-block;
        margin-bottom: -1.375rem;
    }
    .price span {    
        font-size: 5rem;
        /*letter-spacing: 8px;*/
        font-weight: bold;        
    }
    .price span input {
        margin-left: 15%;
        text-align: center;
        width: 70%;
    }
    .price sup{
        font-size: 1.5rem;    
        position: absolute;    
        top: 12px;
        left: 16px;
    }
    .hint{
        font-style: italic;
        font-size: 0.9rem;
    }
    .features{
        list-style-type: none;    
        background: #FFFFFF;
        text-align: left;
        color: #9C9C9C;
        padding:30px 10%;
        margin-bottom: 0;
        font-size: 0.9rem;
    }
    .features li{
        padding:5px 0;
        width: 100%;
        font-size: 15px;
        display: inline-flex;
    }
    .features li span{
        padding-right: 0.4rem; 
    }
    .features li input {
        margin-left: 5%;
        margin-right: 5%;
        text-align: center;
        width: 88%;
    }
    .checkboxdata {
        width: auto !important;
    }
    .checkboxSize {
        width: 43% !important;
    }
    .pt-footer{
        font-size: 0.95rem;
        text-transform: capitalize;
        padding: 7%;

    }
    /*PERSONAL*/
    .personal .title{        
        background: #257E78;    
    }
    .personal .content1,.personal .pt-footer{
        background: #2c968f;
    }
    .personal .content1:after{	
        border-top-color: #2c968f;	
    }
    .personal .pt-footer:after{
        border-top-color: #FFFFFF;
    }
    /*PROFESSIONAL*/
    .professional .title{
        background: #1E3944;
    }
    .professional .content1,.professional .pt-footer{
        background: #2e596a;
    }
    .professional .content1:after{	
        border-top-color: #2e596a;	
    }
    .professional .pt-footer:after{
        border-top-color: #FFFFFF;
    }
    /*BUSINESS*/
    .business .title{
        background: #48372F;
    }
    .business .content1,.business .pt-footer{
        background: #5f4234;
    }
    .business .content1:after{	
        border-top-color: #5f4234;	
    }
    .business .pt-footer:after {	
        border-top-color: #FFFFFF;	
    }
    /*MASTER*/
    .master .title{        
        background: #2d2d2d;    
    }
    .master .content1,.master .pt-footer{
        background: #504e4e;
    }
    .master .content1:after{	
        border-top-color: #504e4e;	
    }
    .master .pt-footer:after{
        border-top-color: #FFFFFF;
    }

    .btn-0 {
        background-color: transparent;
        border-color: #fff;
        color: #fff;
    }
    #pricing #third-option {
        margin-bottom: 0 !important;
    }
    sub {
        bottom: 2.75em;	
    }
    .error {
        font-size: 10px !important;
    }

    input.title {
        font-size: 25px;

    }

    @media screen and (-webkit-min-device-pixel-ratio:0) {
        input.title {
            font-size: 25px;
            height: 64px;
            padding: 2%;
            text-align: center;
        }
    }

    #toappenddiv form {
        margin-bottom: 3%;
    }
    .features .form-group {
        width: 55% !important;
    }
</style>
<script src="../../views/js_ranktracker/jquery.js" type="text/javascript"></script>
<!-- begin breadcrumb -->
<ol class="breadcrumb pull-right">
    <li><a href="#">Home</a></li>
    <li><a href="admin.action">User Details</a></li>
    <!--<li class="active">User Details</li>-->
</ol>
<!-- end breadcrumb -->    
<!-- begin row -->
<div class="row">
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"> <i class="fa fa-plus-circle"></i> Add Package </button>
</div>
<!-- end row -->
<!-- begin row -->
<div class="row">
    <div class="">
        <!-- PRICING-TABLE CONTAINER -->
        <div class="pricing-table group">
            <h1 class="heading">PRICING PLANS</h1>
            <p>These are the 8 plans that includes a pretty basic one</p>
            <div class="row" id="toappenddiv">
                <!-- PERSONAL -->
                <%--<c:set var="counter" value="0"/>--%>
                <c:forEach items="${listPlans}" var="location">
                    <%--<c:set var="counter" value="${counter+1}"/>--%>
                    <form  class="block personal fl col-md-3 updateforms" id="updatefeature${location.planID}" data-id="${location.planID}">

                        <input class="form-control title" type="text" id="name${location.planID}" value="${location.name}" />
                        <input type="hidden" class="form-control" id="planID${location.planID}" value="${location.planID}" /> 

                        <div class="content1">
                            <p class="price">
                                <sup>$</sup>
                                <span>
                                    <input type="text" name="amountupdate" class="form-control" id="amount${location.planID}" value="${location.amount}" />
                                </span>
                                <sub>/mon.</sub>
                            </p>
                        </div>
                        <ul style="border: #2c968f 1px solid; border-bottom: 0; border-top: 0;" class="features">
                            <li>
                                <span class="fa fa-cog"></span>
                                <div class="form-group" style="margin-bottom: 0;">
                                    <input name="campaignupdate" type="text" class="form-control" id="campaigns${location.planID}" value="${location.campaigns}" />
                                </div>
                                <span>Campaign</span>
                            </li>
                            <li>
                                <span class="fa fa-star"></span>
                                <div class="form-group" style="margin-bottom: 0;">
                                    <input name="usersupdate" type="text" class="form-control" id="users${location.planID}" value="${location.users}" />
                                </div>
                                <span>Users</span>
                            </li>
                            <li>
                                <span class="fa fa-dashboard"></span>
                                <div class="form-group" style="margin-bottom: 0;">
                                    <input name="keywordsupdate" type="text" class="form-control" id="keywords${location.planID}" value="${location.keywords}" />
                                </div>
                                <span>Keywords</span>
                            </li>

                            <c:if test="${location.googleAnalytics ==1}">
                                <li><input class="checkboxdataupdate${location.planID} checkboxSize" checked="" data-name="googleAnalytics" type="checkbox"  style="margin-left: -15%;" class="pull-left text-left" id="googleAnalytics${location.planID}" value="${location.googleAnalytics}"> <span style="margin-left: -15%;">Google Analytics</span></li>
                                </c:if>
                                <c:if test="${location.googleAnalytics ==0}">
                                <li><input class="checkboxdataupdate${location.planID} checkboxSize" data-name="googleAnalytics" type="checkbox"  style="margin-left: -15%;" class="pull-left text-left" id="googleAnalytics${location.planID}" value="${location.googleAnalytics}"> <span style="margin-left: -15%;">Google Analytics</span></li>
                                </c:if>
                                <c:if test="${location.keywordResearch ==1}">
                                <li><input class="checkboxdataupdate${location.planID} checkboxSize" checked="" data-name="keywordResearch" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="keywordResearch${location.planID}" value="${location.keywordResearch}"> <span style="margin-left: -15%;">Keyword Research</span></li>
                                </c:if>
                                <c:if test="${location.keywordResearch ==0}">
                                <li><input class="checkboxdataupdate${location.planID} checkboxSize" data-name="keywordResearch" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="keywordResearch${location.planID}" value="${location.keywordResearch}"> <span style="margin-left: -15%;">Keyword Research</span></li>
                                </c:if>
                                <c:if test="${location.webmastertools ==1}">
                                <li><input class="checkboxdataupdate${location.planID} checkboxSize" checked="" data-name="webmastertools" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="webmastertools${location.planID}" value="${location.webmastertools}"> <span style="margin-left: -15%;">Webmaster Tool</span></li>
                                </c:if>
                                <c:if test="${location.webmastertools ==0}">
                                <li><input class="checkboxdataupdate${location.planID} checkboxSize" data-name="webmastertools" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="webmastertools${location.planID}" value="${location.webmastertools}"> <span style="margin-left: -15%;">Webmaster Tool</span></li>
                                </c:if>
                                <c:if test="${location.websiteReview ==1}">
                                <li><input class="checkboxdataupdate${location.planID} checkboxSize" checked="" data-name="websiteReview" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="websiteReview${location.planID}" value="${location.websiteReview}"> <span style="margin-left: -15%;">Website Review</span></li>
                                </c:if>
                                <c:if test="${location.websiteReview ==0}">
                                <li><input class="checkboxdataupdate${location.planID} checkboxSize" data-name="websiteReview" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="websiteReview${location.planID}" value="${location.websiteReview}"> <span style="margin-left: -15%;">Website Review</span></li>
                                </c:if>
                                <c:if test="${location.accurateLocalRanking ==1}">
                                <li><input class="checkboxdataupdate${location.planID} checkboxSize" checked="" data-name="accurateLocalRanking" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="accurateLocalRanking${location.planID}" value="${location.accurateLocalRanking}"> <span style="margin-left: -15%;">Accurate Local Ranking</span></li>
                                </c:if>
                                <c:if test="${location.accurateLocalRanking ==0}">
                                <li><input class="checkboxdataupdate${location.planID} checkboxSize" data-name="accurateLocalRanking" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="accurateLocalRanking${location.planID}" value="${location.accurateLocalRanking}"> <span style="margin-left: -15%;">Accurate Local Ranking</span></li>
                                </c:if>
                                <c:if test="${location.linkAnalysis ==1}">
                                <li><input class="checkboxdataupdate${location.planID} checkboxSize" checked="" data-name="linkAnalysis" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="linkAnalysis${location.planID}" value="${location.linkAnalysis}"> <span style="margin-left: -15%;">Link Analysis</span></li>
                                </c:if>
                                <c:if test="${location.linkAnalysis ==0}">
                                <li><input class="checkboxdataupdate${location.planID} checkboxSize"  data-name="linkAnalysis" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="linkAnalysis${location.planID}" value="${location.linkAnalysis}"> <span style="margin-left: -15%;">Link Analysis</span></li>
                                </c:if>

                        </ul>
                        <div class="pt-footer">
                            <button type="submit" class="btn btn-0">Update Package</button> <!-- onclick="getUpdateDetailsFeatures('${location.planID}')"-->
                        </div>
                    </form>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<!-- end row -->

<!-- begin theme-panel -->

<!-- end theme-panel -->

<!-- begin scroll to top btn -->
<a href="#" class="btn btn-icon btn-circle btn-success btn-scroll-to-top fade" data-click="scroll-top"><i class="fa fa-angle-up"></i></a>
<!-- end scroll to top btn -->
</div>
<!-- end page container -->

<!-- begin Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Add Package</h4>
            </div>
            <s:form  id="formSubmit"  method="POST">
                <div class="modal-body">
                    <div class="form-group">

                        <input type="text"  name="name1" class="form-control" placeholder="Package Name" id="name" value="" />

                    </div>
                    <div class="form-group">

                        <input type="text"  name="amount1" class="form-control" placeholder="Price" id="amount" value=""/>

                    </div>
                    <div class="form-group">

                        <input type="text"  name="campaigns1" class="form-control" placeholder="No. of Campaigns" id="campaigns" value=""/>

                    </div>
                    <div class="form-group">

                        <input type="text"  name="users1" class="form-control" placeholder="No. of Users" id="users" value=""/>

                    </div>
                    <div class="form-group">

                        <input type="text"  name="keywords1" class="form-control" placeholder="No. of Keywords" id="keywords" value=""/>

                    </div>
                    <div class="form-group">

                        <input class="checkboxdata"  type="checkbox"  style="margin-right:2%;" name="websiteReview" id="websiteReview" data-name="websiteReview"/> Web Review

                    </div>
                    <div class="form-group">

                        <input class="checkboxdata" type="checkbox"  style="margin-right:2%;" name="keywordResearch" id="keywordResearch" data-name="keywordResearch"/> Keyword Research

                    </div>
                    <div class="form-group">

                        <input class="checkboxdata"  type="checkbox" style="margin-right:2%; " name="webmastertools" data-name="webmastertools"/> Google Webmaster

                    </div>
                    <div class="form-group">

                        <input class="checkboxdata"  type="checkbox"  style="margin-right:2%;" name="googleAnalytics" data-name="googleAnalytics"/> Google Analytics

                    </div>
                    <div class="form-group">

                        <input class="checkboxdata" type="checkbox"  style="margin-right:2%;" name="accurateLocalRanking" data-name="accurateLocalRanking"/> Accurate Local Ranking

                    </div>
                    <div class="form-group">

                        <input class="checkboxdata"  type="checkbox"  style="margin-right:2%;" name="linkAnalysis" data-name="linkAnalysis"/> Link Analysis

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" id="modalclose">Close</button>
                        <button type="submit" class="btn btn-primary"  id="createpackage">Create Package</button>
                    </div>
                </div> 
            </s:form>
        </div>
    </div>
    <!-- end Modal -->

    <script>

        $(document).ready(function () {
            var updateforms = $('.updateforms');

            $.each(updateforms, function (i, a) {
                var formid = $(a).attr('data-id');
                var form = $('#updatefeature' + formid);
                $(form).validate({
                    rules: {
                        amountupdate: {
                            required: true,
                            digits: true
                        },
                        campaignupdate: {
                            required: true,
                            digits: true
                        },
                        usersupdate: {
                            required: true,
                            digits: true
                        },
                        keywordsupdate: {
                            required: true,
                            digits: true
                        }
                    },
                    messages: {
                        amountupdate: {
                            required: "Please enter amount name"
                        },
                        campaignupdate: {
                            required: "Please enter number of campaigns",
                            digits: "Please enter a number"
                        },
                        usersupdate: {
                            required: "Please enter number of users",
                            digits: "Please enter a number"
                        },
                        keywordsupdate: {
                            required: "Please enter number of keywords",
                            digits: "Please enter a number"
                        }
                    },
                    submitHandler: function (form) {

                        var cbs = $('.checkboxdataupdate' + formid);
                        var myarr = new Array();
                        $.each(cbs, function (i, a) {
                            var cval = $(this).is(':checked');
                            var cname = $(this).attr('data-name');
                            if (cval === false) {
                                cval = 0;
                            } else {
                                cval = 1;
                            }
                            myarr[cname] = cval;
                        });
                        var planID = $('#planID' + formid).val();
                        var name = $('#name' + formid).val();
                        var campaigns = $('#campaigns' + formid).val();
                        var keywords = $('#keywords' + formid).val();
                        var users = $('#users' + formid).val();
                        var amount = $('#amount' + formid).val();
                        $.ajax({
                            type: "POST",
                            url: "updateFeatureDetails.action",
                            data: {
                                websiteReview: myarr['websiteReview'],
                                keywordResearch: myarr['keywordResearch'],
                                webmastertools: myarr['webmastertools'],
                                googleAnalytics: myarr['googleAnalytics'],
                                accurateLocalRanking: myarr['accurateLocalRanking'],
                                linkAnalysis: myarr['linkAnalysis'],
                                planID: planID,
                                name: name,
                                campaigns: campaigns,
                                keywords: keywords,
                                users: users,
                                amount: amount
                            },
                            success: function (response) {

                                console.log(response);
                                alert("Updated the Plans");
                            },
                            error: function (data) {
                                console.log(data);
                            }

                        });

                    }
                });
            });
        });
    </script>


    <script>
        $(document).ready(function () {
//            $(document.body).on('click', '#createpackage', function (e) {
//                e.preventDefault();
            var form2 = $('#formSubmit');
            $(form2).validate({
                rules: {
                    name1: {
                        required: true
                    },
                    amount1: {
                        required: true,
                        digits: true
                    },
                    campaigns1: {
                        required: true,
                        digits: true
                    },
                    users1: {
                        required: true,
                        digits: true
                    },
                    keywords1: {
                        required: true,
                        digits: true
                    }
                },
                messages: {
                    name1: {
                        required: "Please enter package name"
                    },
                    amount1: {
                        required: "Please enter a amount",
                        digits: "Please enter a number"
                    },
                    campaigns1: {
                        required: "Please enter number of campaigns",
                        digits: "Please enter a number"
                    },
                    users1: {
                        required: "Please enter number of users",
                        digits: "Please enter a number"
                    },
                    keywords1: {
                        required: "Please enter number of keywords",
                        digits: "Please enter a number"
                    }
                },
                submitHandler: function (form) {
                    var cbs = $('.checkboxdata');
                    var myarr = new Array();
                    $.each(cbs, function (i, a) {
                        var cval = $(this).is(':checked');
                        var cname = $(this).attr('data-name');
                        if (cval === false) {
                            cval = 0;
                        } else {
                            cval = 1;
                        }
                        myarr[cname] = cval;
                    });
                    var name = $('#name').val();
                    var campaigns = $('#campaigns').val();
                    var keywords = $('#keywords').val();
                    var users = $('#users').val();
                    var amount = $('#amount').val();
                    console.log(myarr);
                    $.ajax({
                        type: "POST",
                        url: "getfeatures.action",
                        data: {
                            websiteReview: myarr['websiteReview'],
                            keywordResearch: myarr['keywordResearch'],
                            webmastertools: myarr['webmastertools'],
                            googleAnalytics: myarr['googleAnalytics'],
                            accurateLocalRanking: myarr['accurateLocalRanking'],
                            linkAnalysis: myarr['linkAnalysis'],
                            name: name,
                            campaigns: campaigns,
                            keywords: keywords,
                            users: users,
                            amount: amount
                        },
                        dataType: "json",
                        success: function (response) {

                            var result = JSON.stringify(response);
                            var json = JSON.parse(result);

                            var toAppend = '<form  class="block personal fl col-md-3 updateforms" id="updatefeature' + json.PlanID + '" data-id="' + json.planID + '">';
                            toAppend += '<input class="form-control title" type="text" id="name' + json.PlanID + '" value="' + json.Name + '" />';
                            toAppend += '<input type="hidden" class="form-control" id="planID' + json.PlanID + '" value="' + json.PlanID + '" />';
                            toAppend += '<div class="content1">';
                            toAppend += '<p class="price">';
                            toAppend += '<sup>$</sup>';
                            toAppend += '<span>';
                            toAppend += '<input type="text" name="amountupdate" class="form-control" id="amount' + json.PlanID + '" value="' + json.Amount + '" />';
                            toAppend += '</span>';
                            toAppend += '<sub>/mon.</sub>';
                            toAppend += '</p>';
                            toAppend += '</div>';
                            toAppend += '<ul style="border: #2c968f 1px solid; border-bottom: 0; border-top: 0;" class="features">';
                            toAppend += '<li>';
                            toAppend += '<span class="fa fa-cog"></span>';
                            toAppend += '<div class="form-group" style="margin-bottom: 0;">';
                            toAppend += '<input name="campaignupdate" type="text" class="form-control" id="campaigns' + json.PlanID + '" value="' + json.Campaigns + '" />';
                            toAppend += '</div>';
                            toAppend += '<span>Campaign</span>';
                            toAppend += '</li>';
                            toAppend += '<li>';
                            toAppend += '<span class="fa fa-star"></span>';
                            toAppend += '<div class="form-group" style="margin-bottom: 0;">';
                            toAppend += '<input name="usersupdate" type="text" class="form-control" id="users' + json.PlanID + '" value="' + json.Users + '" />';
                            toAppend += '</div>';
                            toAppend += '<span>Users</span>';
                            toAppend += '</li>';
                            toAppend += '<li>';
                            toAppend += '<span class="fa fa-dashboard"></span>';
                            toAppend += '<div class="form-group" style="margin-bottom: 0;">';
                            toAppend += '<input name="keywordsupdate" type="text" class="form-control" id="keywords' + json.PlanID + '" value="' + json.Keywords + '" />';
                            toAppend += '</div>';
                            toAppend += '<span>Keywords</span>';
                            toAppend += '</li>';
                            toAppend += '<li><input class="checkboxdataupdate' + json.PlanID + ' checkboxSize"  data-name="googleAnalytics" type="checkbox"  style="margin-left: -15%;" class="pull-left text-left" id="googleAnalytics' + json.PlanID + '"';
                            if (json.googleAnalytics === 1) {
                                toAppend += "checked";
                            }
                            toAppend += '> <span style="margin-left: -15%;">Google Analytics</span></li>';

                            toAppend += '<li><input class="checkboxdataupdate' + json.PlanID + ' checkboxSize"  data-name="keywordResearch" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="keywordResearch' + json.PlanID + '"';
                            if (json.keywordResearch === 1) {
                                toAppend += "checked";
                            }
                            toAppend += '> <span style="margin-left: -15%;">Keyword Research</span></li>';

                            toAppend += '<li><input class="checkboxdataupdate' + json.PlanID + ' checkboxSize"  data-name="webmastertools" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="webmastertools' + json.PlanID + '"';
                            if (json.webmastertools === 1) {
                                toAppend += "checked";
                            }
                            toAppend += '> <span style="margin-left: -15%;">Webmaster Tool</span></li>';

                            toAppend += '<li><input class="checkboxdataupdate' + json.PlanID + ' checkboxSize"  data-name="websiteReview" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="websiteReview' + json.PlanID + '"';
                            if (json.websiteReview === 1) {
                                toAppend += "checked";
                            }
                            toAppend += '> <span style="margin-left: -15%;">Website Review</span></li>';

                            toAppend += '<li><input class="checkboxdataupdate' + json.PlanID + ' checkboxSize"  data-name="accurateLocalRanking" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="accurateLocalRanking' + json.PlanID + '"';
                            if (json.accurateLocalRanking === 1) {
                                toAppend += "checked";
                            }
                            toAppend += '> <span style="margin-left: -15%;">Accurate Local Ranking</span></li>';

                            toAppend += '<li><input class="checkboxdataupdate' + json.PlanID + ' checkboxSize"  data-name="linkAnalysis" type="checkbox" style="margin-left: -15%;" class="pull-left text-left" id="linkAnalysis' + json.PlanID + '"';
                            if (json.linkAnalysis === 1) {
                                toAppend += "checked";
                            }
                            toAppend += '> <span style="margin-left: -15%;">Link Analysis</span></li>';

                            toAppend += '</ul>';
                            toAppend += '<div class="pt-footer">';
                            toAppend += '<button type="submit" class="btn btn-0">Update Package</button>';
                            toAppend += '</div>';
                            toAppend += '</form>';
                            $('#toappenddiv').append(toAppend);
                            
                            var formid = json.PlanID;
                            var form = $('#updatefeature' + formid);
                            $(form).validate({
                                rules: {
                                    amountupdate: {
                                        required: true,
                                        digits: true
                                    },
                                    campaignupdate: {
                                        required: true,
                                        digits: true
                                    },
                                    usersupdate: {
                                        required: true,
                                        digits: true
                                    },
                                    keywordsupdate: {
                                        required: true,
                                        digits: true
                                    }
                                },
                                messages: {
                                    amountupdate: {
                                        required: "Please enter amount name"
                                    },
                                    campaignupdate: {
                                        required: "Please enter number of campaigns",
                                        digits: "Please enter a number"
                                    },
                                    usersupdate: {
                                        required: "Please enter number of users",
                                        digits: "Please enter a number"
                                    },
                                    keywordsupdate: {
                                        required: "Please enter number of keywords",
                                        digits: "Please enter a number"
                                    }
                                },
                                submitHandler: function (form) {

                                    var cbs = $('.checkboxdataupdate' + formid);
                                    var myarr = new Array();
                                    $.each(cbs, function (i, a) {
                                        var cval = $(this).is(':checked');
                                        var cname = $(this).attr('data-name');
                                        if (cval === false) {
                                            cval = 0;
                                        } else {
                                            cval = 1;
                                        }
                                        myarr[cname] = cval;
                                    });
                                    var planID = $('#planID' + formid).val();
                                    var name = $('#name' + formid).val();
                                    var campaigns = $('#campaigns' + formid).val();
                                    var keywords = $('#keywords' + formid).val();
                                    var users = $('#users' + formid).val();
                                    var amount = $('#amount' + formid).val();
                                    $.ajax({
                                        type: "POST",
                                        url: "updateFeatureDetails.action",
                                        data: {
                                            websiteReview: myarr['websiteReview'],
                                            keywordResearch: myarr['keywordResearch'],
                                            webmastertools: myarr['webmastertools'],
                                            googleAnalytics: myarr['googleAnalytics'],
                                            accurateLocalRanking: myarr['accurateLocalRanking'],
                                            linkAnalysis: myarr['linkAnalysis'],
                                            planID: planID,
                                            name: name,
                                            campaigns: campaigns,
                                            keywords: keywords,
                                            users: users,
                                            amount: amount
                                        },
                                        success: function (response) {

                                            console.log(response);
                                            alert("Updated the Plans");
                                        },
                                        error: function (data) {
                                            console.log(data);
                                        }

                                    });

                                }
                            });
                            $('#modalclose').click();
                            $('#name').val("");
                            $('#amount').val("");
                            $('#campaigns').val("");
                            $('#users').val("");
                            $('#keywords').val("");

                        }
                    });
                }
            });
//            });
        });

    </script>