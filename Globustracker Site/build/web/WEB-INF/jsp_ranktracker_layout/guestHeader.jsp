<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Header start 
<div class="topdividerbg">
    <a href="http://ranktracker.globustracker.com/" style="text-decoration: none;"><div class="ranktracker">Ranktracker</div></a>
    <a href="http://dashboard.globustracker.com/Login.aspx"  style="text-decoration: none;"><div class="social_crm">Social CRM</div></a>
    <a href="http://local.globustracker.com/" style="text-decoration: none;"><div class="lsearchmarketing">Local Search Marketing</div></a>
</div>-->

<div id="header">		
    <div class="header_wrapper">
        <div class="header_logo"><a href="home.action"><img src="https://s3.amazonaws.com/images_ranktracker/Globustracker-logo-present.png" alt="" /></a></div>
        <div class="btn_for_all"><a href="payment.action">Try it for FREE!</a></div>

        <!--menu-->
        <div id="menu">
            <ul class="menu">

                <c:choose>
                    <c:when test="${requestScope.highlight == 'HOME'}">
                        <li id="menu_active"><a href="home.action"><span><span>HOME</span></span></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="home.action"><span><span>HOME</span></span></a></li>
                    </c:otherwise>
                </c:choose>

                <!--<c:choose>
                    <c:when test="${requestScope.highlight == 'ABOUT'}">
                        <li id="menu_active"><a href="about.action"><span><span>ABOUT US</span></span></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="about.action"><span><span>ABOUT US</span></span></a></li>
                    </c:otherwise>
                </c:choose>-->

                <c:choose>
                    <c:when test="${requestScope.highlight == 'FEATURES'}">
                        <li id="menu_active"><a href="features.action"><span><span>FEATURES</span></span></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="features.action"><span><span>FEATURES</span></span></a></li>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${requestScope.highlight == 'PRICING'}">
                        <li id="menu_active"><a href="tour.action"><span><span>PRICING</span></span></a></li>
                    </c:when>
                    <c:otherwise>
                        <li ><a href="pricing.action"><span><span>PRICING</span></span></a></li>
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${requestScope.highlight == 'TOUR'}">
                        <li id="menu_active"><a href="tour.action"><span><span>TAKE A TOUR</span></span></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="tour.action"><span><span>TAKE A TOUR</span></span></a></li>
                    </c:otherwise>
                </c:choose>


                <!--li><a href="http://blog.globustracker.com" target="_blank"><span><span>BLOG</span></span></a></li-->

                <c:choose>
                    <c:when test="${requestScope.highlight == 'CONTACT'}">
                        <li id="menu_active"><a href="contact.action"><span><span>CONTACT</span></span></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="contact.action"><span><span>CONTACT</span></span></a></li>
                    </c:otherwise>
                </c:choose>
                        
                         <c:choose>
                    <c:when test="${requestScope.highlight == 'FAQ'}">
                        <li id="menu_active"><a href="faq.action"><span><span>FAQ</span></span></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="faq.action"><span><span>FAQ</span></span></a></li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
        <!--end menu-->
    </div>	
</div>
<!-- Header end -->