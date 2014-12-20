<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Header start
 <div class="topdividerbg">
      <a href="http://ranktracker.globustracker.com/" style="text-decoration: none;"><div class="ranktracker">Ranktracker</div></a>
      <a href="http://dashboard.globustracker.com/Login.aspx"  style="text-decoration: none;"><div class="social_crm">Social CRM</div></a>
      <a href="http://local.globustracker.com/" style="text-decoration: none;"><div class="lsearchmarketing">Local Search Marketing</div></a>
  </div> -->
<style type="text/css">
    #menu li ul{
        display:none;
        position:absolute;
        z-index: 90000;
    }
    #menu li:hover ul{
        display:block;
        background:#198eca;
        height:auto; width:120px; 
        margin: 0;
        padding: 0 0 0 10px;
    }
    #menu li ul li{
        clear:both;
        border-style:none;
    }
    #menu li ul li a{
        clear:both;
        border-style:none;
        text-decoration: none;
    }
    #menu li ul li a{
        clear:both;
        border-style:none;
        text-decoration: none;
        color: #fff;
    }
    #menu li ul li a:hover{
        clear:both;
        border-style:none;
        text-decoration: none;
        color: #B7FF00 !important;
    }
    .header_logo {
        float: left;
        height: 68px !important;
        margin-top: 0;
        width: 291px;
    }
    #menu li a span span {
        color: #FFFFFF;
        font-family: Arial,Helvetica,sans-serif;
        font-size: 15px;
        font-weight: bold;
        height: auto;
        padding: 0 45px;
        text-shadow: 0 0 3px #333333;
    }
    #menu li a {
        color: #FFFFFF;
        cursor: pointer;
        font-family: Arial,Helvetica,sans-serif;
        font-size: 15px;
        font-weight: bold;
        line-height: 38px;
        text-shadow: 0 0 3px #333333;
    }
    
    </style>
    <%
        if (session.getAttribute("customerID") == null) {
            response.setHeader("Cache-Control", "private,no-store,no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", -1);
            response.sendRedirect("home.action");
        }
    %> 
    <div id="header">		
        <div class="header_wrapper">
            <div class="header_logo">
                <s:if test="%{#session.customerName!=null}">
                    <a href="campaigns.action">
                        <img src="https://s3.amazonaws.com/images_ranktracker/Globustracker-logo-present.png"  alt="" />
                    </a>
                </s:if>
                <s:else>
                    <a href="home.action">
                        <img src="https://s3.amazonaws.com/images_ranktracker/Globustracker-logo-present.png"  alt="" />
                    </a>
                </s:else>
            </div>
            <div class="btn_for_all"><a href="signOut.action">Logout</a></div>
            <div class="divider"></div>
            <div class="user_login_name">Welcome <s:property value="#session.customerName"/></div>
            <!--menu-->
            <div id="menu">
                <ul class="menu">
                    <c:choose>
                        <c:when test="${requestScope.highlight == 'CAMPAIGN'}">
                            <li id="menu_active"><a href="campaigns.action"><span><span>CAMPAIGN</span></span></a>
                                <ul>
                                    <li><a href="serps.action">SERPS</a></li>
                                    <li><a href="video.action">VIDEO</a></li>
                                </ul>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="campaigns.action"><span><span>CAMPAIGN</span></span></a>
                                <ul>
                                    <li><a href="serps.action">SERPS</a></li>
                                    <li><a href="video.action">VIDEO</a></li>
                                </ul>
                            </li>                      
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${requestScope.highlight == 'ALERTS'}">
                            <li class="nav3" id="menu_active"><a href="alerts.action"><span><span>ALERTS</span></span></a></li>   
                        </c:when>
                        <c:otherwise>
                            <li class="nav3"><a href="alerts.action"><span><span>ALERTS</span></span></a></li>   
                        </c:otherwise>
                    </c:choose>


                    <c:choose>
                        <c:when test="${requestScope.highlight == 'REPORTS'}">
                            <li class="nav3" id="menu_active"><a href="report.action"><span><span> REPORTS </span></span></a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav3"><a href="report.action"><span><span> REPORTS </span></span></a></li>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${requestScope.highlight == 'SETTINGS'}">
                            <li class="nav3" id="menu_active"><a href="settings.action"><span><span> SETTINGS </span></span></a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav3"><a href="settings.action"><span><span> SETTINGS </span></span></a></li>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${requestScope.highlight == 'ACCOUNT'}">
                            <li class="nav3" id="menu_active"><a href="myAccount.action"><span><span> MY ACCOUNT </span></span></a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav3"><a href="myAccount.action"><span><span> MY ACCOUNT </span></span></a></li>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${requestScope.highlight == 'UPGRADE'}">
                            <li class="nav3" id="menu_active"><a href="upgradeOption.action"><span><span> UPGRADE </span></span></a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav3"><a href="upgradeOption.action"><span><span> UPGRADE </span></span></a></li>
                        </c:otherwise>
                    </c:choose>

                </ul>
            </div>
            <!--end menu-->
        </div>	
    </div>
    <!-- Header end -->