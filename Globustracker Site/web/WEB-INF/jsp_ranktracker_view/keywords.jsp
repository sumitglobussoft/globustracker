<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style type="text/css">
    .close_btn
    {
        width: 16px;
        height: 16px;
        float: right;
        margin:5px 5px 0 0;
    }
    ul.actionMessage
    {
        list-style: none;
        font-family: arial;
        font-size:15px;
        color:#BC0909;
        width:600px;
        float:left;
    }
</style>
<%
     if (session.getAttribute("customerID") == null) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.sendRedirect("home.action");
    }
%> 
<link rel="stylesheet" href="https://s3.amazonaws.com/css_ranktracker/tablestyle.css" />
<!-- Body start -->
<div id="body">              
    <div class="page_title_bg">
        <div class="page_title_wrapper">
            <div class="page_title"><section>KEYWORD</section> <section class="campaign"><s:property value="campaignName" /></section> <span style="cursor:pointer;" id="clickme">+Add Keyword</span></div>                            
        </div>
    </div>   
    <!--dashboard_wrapper-->
    <div class="dashboard_wrapper">
        <!--add_site-->
        <s:form action="" onsubmit="return false;" id="addForm">
            <div class="add_keyword_div" id="add_site">
                <div class="keyword_div">
                    <div class="keyword_left">
                        <div class="site_txt">Url</div>
                        <s:textfield  name="url" id="url" maxlength="300"/>

                        <div class="site_txt">Keyword</div>
                        <textarea rows="4" cols="5" name="keywords" id="keywords"></textarea>
                    </div>
                    <div class="keyword_right">
                        <div class="site_txt">Google Link</div>
                        <select id="linkGoogle" name="linkGoogle">
                            <option value="google.com" selected="true">google.com</option>
                            <option value="google.co.uk">google.co.uk</option>
                            <option value="google.com.au">google.com.au</option>
                            <option value="google.ca">google.ca</option>
                            <option value="google.ad">google.ad</option>
                            <option value="google.ae">google.ae</option>
                            <option value="google.com.af">google.com.af</option>
                            <option value="google.com.ag">google.com.ag</option>
                            <option value="google.com.ai">google.com.ai</option>
                            <option value="google.am">google.am</option>
                            <option value="google.co.ao">google.co.ao</option>
                            <option value="google.com.ar">google.com.ar</option>
                            <option value="google.as">google.as</option>
                            <option value="google.at">google.at</option>
                            <option value="google.az">google.az</option>
                            <option value="google.ba">google.ba</option>
                            <option value="google.com.bd">google.com.bd</option>
                            <option value="google.be">google.be</option>
                            <option value="google.bf">google.bf</option>
                            <option value="google.bg">google.bg</option>
                            <option value="google.com.bh">google.com.bh</option>
                            <option value="google.bi">google.bi</option>
                            <option value="google.bj">google.bj</option>
                            <option value="google.com.bn">google.com.bn</option>
                            <option value="google.com.bo">google.com.bo</option>
                            <option value="google.com.br">google.com.br</option>
                            <option value="google.bs">google.bs</option>
                            <option value="google.co.bw">google.co.bw</option>
                            <option value="google.by">google.by</option>
                            <option value="google.com.bz">google.com.bz</option>
                            <option value="google.cd">google.cd</option>
                            <option value="google.cf">google.cf</option>
                            <option value="google.cg">google.cg</option>
                            <option value="google.ch">google.ch</option>
                            <option value="google.ci">google.ci</option>
                            <option value="google.co.ck">google.co.ck</option>
                            <option value="google.cl">google.cl</option>
                            <option value="google.cm">google.cm</option>
                            <option value="google.cn">google.cn</option>
                            <option value="google.com.co">google.com.co</option>
                            <option value="google.co.cr">google.co.cr</option>
                            <option value="google.com.cu">google.com.cu</option>
                            <option value="google.cv">google.cv</option>
                            <option value="google.com.cy">google.com.cy</option>
                            <option value="google.cz">google.cz</option>
                            <option value="google.de">google.de</option>
                            <option value="google.dj">google.dj</option>
                            <option value="google.dk">google.dk</option>
                            <option value="google.dm">google.dm</option>
                            <option value="google.com.do">google.com.do</option>
                            <option value="google.dz">google.dz</option>
                            <option value="google.com.ec">google.com.ec</option>
                            <option value="google.ee">google.ee</option>
                            <option value="google.com.eg">google.com.eg</option>
                            <option value="google.es">google.es</option>
                            <option value="google.com.et">google.com.et</option>
                            <option value="google.fi">google.fi</option>
                            <option value="google.com.fj">google.com.fj</option>
                            <option value="google.fm">google.fm</option>
                            <option value="google.fr">google.fr</option>
                            <option value="google.ga">google.ga</option>
                            <option value="google.ge">google.ge</option>
                            <option value="google.gg">google.gg</option>
                            <option value="google.com.gh">google.com.gh</option>
                            <option value="google.com.gi">google.com.gi</option>
                            <option value="google.gl">google.gl</option>
                            <option value="google.gm">google.gm</option>
                            <option value="google.gp">google.gp</option>
                            <option value="google.gr">google.gr</option>
                            <option value="google.com.gt">google.com.gt</option>
                            <option value="google.gy">google.gy</option>
                            <option value="google.com.hk">google.com.hk</option>
                            <option value="google.hn">google.hn</option>
                            <option value="google.hr">google.hr</option>
                            <option value="google.ht">google.ht</option>
                            <option value="google.hu">google.hu</option>
                            <option value="google.co.id">google.co.id</option>
                            <option value="google.ie">google.ie</option>
                            <option value="google.co.il">google.co.il</option>
                            <option value="google.im">google.im</option>
                            <option value="google.co.in">google.co.in</option>
                            <option value="google.iq">google.iq</option>
                            <option value="google.is">google.is</option>
                            <option value="google.it">google.it</option>
                            <option value="google.je">google.je</option>
                            <option value="google.com.jm">google.com.jm</option>
                            <option value="google.jo">google.jo</option>
                            <option value="google.co.jp">google.co.jp</option>
                            <option value="google.co.ke">google.co.ke</option>
                            <option value="google.com.kh">google.com.kh</option>
                            <option value="google.ki">google.ki</option>
                            <option value="google.kg">google.kg</option>
                            <option value="google.co.kr">google.co.kr</option>
                            <option value="google.com.kw">google.com.kw</option>
                            <option value="google.kz">google.kz</option>
                            <option value="google.la">google.la</option>
                            <option value="google.com.lb">google.com.lb</option>
                            <option value="google.li">google.li</option>
                            <option value="google.lk">google.lk</option>
                            <option value="google.co.ls">google.co.ls</option>
                            <option value="google.lt">google.lt</option>
                            <option value="google.lu">google.lu</option>
                            <option value="google.lv">google.lv</option>
                            <option value="google.com.ly">google.com.ly</option>
                            <option value="google.co.ma">google.co.ma</option>
                            <option value="google.md">google.md</option>
                            <option value="google.me">google.me</option>
                            <option value="google.mg">google.mg</option>
                            <option value="google.mk">google.mk</option>
                            <option value="google.ml">google.ml</option>
                            <option value="google.mn">google.mn</option>
                            <option value="google.ms">google.ms</option>
                            <option value="google.com.mt">google.com.mt</option>
                            <option value="google.mu">google.mu</option>
                            <option value="google.mv">google.mv</option>
                            <option value="google.mw">google.mw</option>
                            <option value="google.com.mx">google.com.mx</option>
                            <option value="google.com.my">google.com.my</option>
                            <option value="google.co.mz">google.co.mz</option>
                            <option value="google.com.na">google.com.na</option>
                            <option value="google.com.nf">google.com.nf</option>
                            <option value="google.com.ng">google.com.ng</option>
                            <option value="google.com.ni">google.com.ni</option>
                            <option value="google.ne">google.ne</option>
                            <option value="google.nl">google.nl</option>
                            <option value="google.no">google.no</option>
                            <option value="google.com.np">google.com.np</option>
                            <option value="google.nr">google.nr</option>
                            <option value="google.nu">google.nu</option>
                            <option value="google.co.nz">google.co.nz</option>
                            <option value="google.com.om">google.com.om</option>
                            <option value="google.com.pa">google.com.pa</option>
                            <option value="google.com.pe">google.com.pe</option>
                            <option value="google.com.ph">google.com.ph</option>
                            <option value="google.com.pk">google.com.pk</option>
                            <option value="google.pl">google.pl</option>
                            <option value="google.pn">google.pn</option>
                            <option value="google.com.pr">google.com.pr</option>
                            <option value="google.ps">google.ps</option>
                            <option value="google.pt">google.pt</option>
                            <option value="google.com.py">google.com.py</option>
                            <option value="google.com.qa">google.com.qa</option>
                            <option value="google.ro">google.ro</option>
                            <option value="google.ru">google.ru</option>
                            <option value="google.rw">google.rw</option>
                            <option value="google.com.sa">google.com.sa</option>
                            <option value="google.com.sb">google.com.sb</option>
                            <option value="google.sc">google.sc</option>
                            <option value="google.se">google.se</option>
                            <option value="google.com.sg">google.com.sg</option>
                            <option value="google.sh">google.sh</option>
                            <option value="google.si">google.si</option>
                            <option value="google.sk">google.sk</option>
                            <option value="google.com.sl">google.com.sl</option>
                            <option value="google.sn">google.sn</option>
                            <option value="google.so">google.so</option>
                            <option value="google.sm">google.sm</option>
                            <option value="google.st">google.st</option>
                            <option value="google.com.sv">google.com.sv</option>
                            <option value="google.td">google.td</option>
                            <option value="google.tg">google.tg</option>
                            <option value="google.co.th">google.co.th</option>
                            <option value="google.com.tj">google.com.tj</option>
                            <option value="google.tk">google.tk</option>
                            <option value="google.tl">google.tl</option>
                            <option value="google.tm">google.tm</option>
                            <option value="google.tn">google.tn</option>
                            <option value="google.to">google.to</option>
                            <option value="google.com.tr">google.com.tr</option>
                            <option value="google.tt">google.tt</option>
                            <option value="google.com.tw">google.com.tw</option>
                            <option value="google.co.tz">google.co.tz</option>
                            <option value="google.com.ua">google.com.ua</option>
                            <option value="google.co.ug">google.co.ug</option>
                            <option value="google.com.uy">google.com.uy</option>
                            <option value="google.co.uz">google.co.uz</option>
                            <option value="google.com.vc">google.com.vc</option>
                            <option value="google.co.ve">google.co.ve</option>
                            <option value="google.vg">google.vg</option>
                            <option value="google.co.vi">google.co.vi</option>
                            <option value="google.com.vn">google.com.vn</option>
                            <option value="google.vu">google.vu</option>
                            <option value="google.ws">google.ws</option>
                            <option value="google.rs">google.rs</option>
                            <option value="google.co.za">google.co.za</option>
                            <option value="google.co.zm">google.co.zm</option>
                            <option value="google.co.zw">google.co.zw</option>
                            <option value="google.cat">google.cat</option>
                        </select> 

                        <input type="submit" name="" value="Add Keyword" onclick="return addKeyword();"/>
                    </div>                                  
                </div>
            </div>
        </s:form>
        <!--end add_site-->
        <div id="se1Loader" style="text-align:center; display: none" ><img width="220" height="50" src="https://s3.amazonaws.com/images_ranktracker/load.gif"/></div>
        <!--edit_keyword-->
        <s:form action="" onsubmit="return false;" id="editForm">
            <div class="add_keyword_div" id="edit_keyword" style="display:none;">
                <div class="close_btn"><a href="#"><img src="https://s3.amazonaws.com/images_ranktracker/icon_close.png" alt="" border="none"/></a></div>
                <div class="keyword_div">
                    <div class="keyword_left">
                        <div class="site_txt">Url</div>
                        <s:hidden name="keywordId" id="keywordId" />
                        <s:textfield  name="url" id="url" maxlength="300"/>

                        <div class="site_txt">Keyword</div>
                        <s:textfield  name="keyword" id="keyword" maxlength="300"/>
                    </div>
                    <div class="keyword_right">
                        <div class="site_txt">Google Link</div>
                        <select id="linkGoogle" name="linkGoogle">
                            <option value="google.com" selected="true">google.com</option>
                            <option value="google.co.uk">google.co.uk</option>
                            <option value="google.com.au">google.com.au</option>
                            <option value="google.ca">google.ca</option>
                            <option value="google.ad">google.ad</option>
                            <option value="google.ae">google.ae</option>
                            <option value="google.com.af">google.com.af</option>
                            <option value="google.com.ag">google.com.ag</option>
                            <option value="google.com.ai">google.com.ai</option>
                            <option value="google.am">google.am</option>
                            <option value="google.co.ao">google.co.ao</option>
                            <option value="google.com.ar">google.com.ar</option>
                            <option value="google.as">google.as</option>
                            <option value="google.at">google.at</option>
                            <option value="google.az">google.az</option>
                            <option value="google.ba">google.ba</option>
                            <option value="google.com.bd">google.com.bd</option>
                            <option value="google.be">google.be</option>
                            <option value="google.bf">google.bf</option>
                            <option value="google.bg">google.bg</option>
                            <option value="google.com.bh">google.com.bh</option>
                            <option value="google.bi">google.bi</option>
                            <option value="google.bj">google.bj</option>
                            <option value="google.com.bn">google.com.bn</option>
                            <option value="google.com.bo">google.com.bo</option>
                            <option value="google.com.br">google.com.br</option>
                            <option value="google.bs">google.bs</option>
                            <option value="google.co.bw">google.co.bw</option>
                            <option value="google.by">google.by</option>
                            <option value="google.com.bz">google.com.bz</option>
                            <option value="google.cd">google.cd</option>
                            <option value="google.cf">google.cf</option>
                            <option value="google.cg">google.cg</option>
                            <option value="google.ch">google.ch</option>
                            <option value="google.ci">google.ci</option>
                            <option value="google.co.ck">google.co.ck</option>
                            <option value="google.cl">google.cl</option>
                            <option value="google.cm">google.cm</option>
                            <option value="google.cn">google.cn</option>
                            <option value="google.com.co">google.com.co</option>
                            <option value="google.co.cr">google.co.cr</option>
                            <option value="google.com.cu">google.com.cu</option>
                            <option value="google.cv">google.cv</option>
                            <option value="google.com.cy">google.com.cy</option>
                            <option value="google.cz">google.cz</option>
                            <option value="google.de">google.de</option>
                            <option value="google.dj">google.dj</option>
                            <option value="google.dk">google.dk</option>
                            <option value="google.dm">google.dm</option>
                            <option value="google.com.do">google.com.do</option>
                            <option value="google.dz">google.dz</option>
                            <option value="google.com.ec">google.com.ec</option>
                            <option value="google.ee">google.ee</option>
                            <option value="google.com.eg">google.com.eg</option>
                            <option value="google.es">google.es</option>
                            <option value="google.com.et">google.com.et</option>
                            <option value="google.fi">google.fi</option>
                            <option value="google.com.fj">google.com.fj</option>
                            <option value="google.fm">google.fm</option>
                            <option value="google.fr">google.fr</option>
                            <option value="google.ga">google.ga</option>
                            <option value="google.ge">google.ge</option>
                            <option value="google.gg">google.gg</option>
                            <option value="google.com.gh">google.com.gh</option>
                            <option value="google.com.gi">google.com.gi</option>
                            <option value="google.gl">google.gl</option>
                            <option value="google.gm">google.gm</option>
                            <option value="google.gp">google.gp</option>
                            <option value="google.gr">google.gr</option>
                            <option value="google.com.gt">google.com.gt</option>
                            <option value="google.gy">google.gy</option>
                            <option value="google.com.hk">google.com.hk</option>
                            <option value="google.hn">google.hn</option>
                            <option value="google.hr">google.hr</option>
                            <option value="google.ht">google.ht</option>
                            <option value="google.hu">google.hu</option>
                            <option value="google.co.id">google.co.id</option>
                            <option value="google.ie">google.ie</option>
                            <option value="google.co.il">google.co.il</option>
                            <option value="google.im">google.im</option>
                            <option value="google.co.in">google.co.in</option>
                            <option value="google.iq">google.iq</option>
                            <option value="google.is">google.is</option>
                            <option value="google.it">google.it</option>
                            <option value="google.je">google.je</option>
                            <option value="google.com.jm">google.com.jm</option>
                            <option value="google.jo">google.jo</option>
                            <option value="google.co.jp">google.co.jp</option>
                            <option value="google.co.ke">google.co.ke</option>
                            <option value="google.com.kh">google.com.kh</option>
                            <option value="google.ki">google.ki</option>
                            <option value="google.kg">google.kg</option>
                            <option value="google.co.kr">google.co.kr</option>
                            <option value="google.com.kw">google.com.kw</option>
                            <option value="google.kz">google.kz</option>
                            <option value="google.la">google.la</option>
                            <option value="google.com.lb">google.com.lb</option>
                            <option value="google.li">google.li</option>
                            <option value="google.lk">google.lk</option>
                            <option value="google.co.ls">google.co.ls</option>
                            <option value="google.lt">google.lt</option>
                            <option value="google.lu">google.lu</option>
                            <option value="google.lv">google.lv</option>
                            <option value="google.com.ly">google.com.ly</option>
                            <option value="google.co.ma">google.co.ma</option>
                            <option value="google.md">google.md</option>
                            <option value="google.me">google.me</option>
                            <option value="google.mg">google.mg</option>
                            <option value="google.mk">google.mk</option>
                            <option value="google.ml">google.ml</option>
                            <option value="google.mn">google.mn</option>
                            <option value="google.ms">google.ms</option>
                            <option value="google.com.mt">google.com.mt</option>
                            <option value="google.mu">google.mu</option>
                            <option value="google.mv">google.mv</option>
                            <option value="google.mw">google.mw</option>
                            <option value="google.com.mx">google.com.mx</option>
                            <option value="google.com.my">google.com.my</option>
                            <option value="google.co.mz">google.co.mz</option>
                            <option value="google.com.na">google.com.na</option>
                            <option value="google.com.nf">google.com.nf</option>
                            <option value="google.com.ng">google.com.ng</option>
                            <option value="google.com.ni">google.com.ni</option>
                            <option value="google.ne">google.ne</option>
                            <option value="google.nl">google.nl</option>
                            <option value="google.no">google.no</option>
                            <option value="google.com.np">google.com.np</option>
                            <option value="google.nr">google.nr</option>
                            <option value="google.nu">google.nu</option>
                            <option value="google.co.nz">google.co.nz</option>
                            <option value="google.com.om">google.com.om</option>
                            <option value="google.com.pa">google.com.pa</option>
                            <option value="google.com.pe">google.com.pe</option>
                            <option value="google.com.ph">google.com.ph</option>
                            <option value="google.com.pk">google.com.pk</option>
                            <option value="google.pl">google.pl</option>
                            <option value="google.pn">google.pn</option>
                            <option value="google.com.pr">google.com.pr</option>
                            <option value="google.ps">google.ps</option>
                            <option value="google.pt">google.pt</option>
                            <option value="google.com.py">google.com.py</option>
                            <option value="google.com.qa">google.com.qa</option>
                            <option value="google.ro">google.ro</option>
                            <option value="google.ru">google.ru</option>
                            <option value="google.rw">google.rw</option>
                            <option value="google.com.sa">google.com.sa</option>
                            <option value="google.com.sb">google.com.sb</option>
                            <option value="google.sc">google.sc</option>
                            <option value="google.se">google.se</option>
                            <option value="google.com.sg">google.com.sg</option>
                            <option value="google.sh">google.sh</option>
                            <option value="google.si">google.si</option>
                            <option value="google.sk">google.sk</option>
                            <option value="google.com.sl">google.com.sl</option>
                            <option value="google.sn">google.sn</option>
                            <option value="google.so">google.so</option>
                            <option value="google.sm">google.sm</option>
                            <option value="google.st">google.st</option>
                            <option value="google.com.sv">google.com.sv</option>
                            <option value="google.td">google.td</option>
                            <option value="google.tg">google.tg</option>
                            <option value="google.co.th">google.co.th</option>
                            <option value="google.com.tj">google.com.tj</option>
                            <option value="google.tk">google.tk</option>
                            <option value="google.tl">google.tl</option>
                            <option value="google.tm">google.tm</option>
                            <option value="google.tn">google.tn</option>
                            <option value="google.to">google.to</option>
                            <option value="google.com.tr">google.com.tr</option>
                            <option value="google.tt">google.tt</option>
                            <option value="google.com.tw">google.com.tw</option>
                            <option value="google.co.tz">google.co.tz</option>
                            <option value="google.com.ua">google.com.ua</option>
                            <option value="google.co.ug">google.co.ug</option>
                            <option value="google.com.uy">google.com.uy</option>
                            <option value="google.co.uz">google.co.uz</option>
                            <option value="google.com.vc">google.com.vc</option>
                            <option value="google.co.ve">google.co.ve</option>
                            <option value="google.vg">google.vg</option>
                            <option value="google.co.vi">google.co.vi</option>
                            <option value="google.com.vn">google.com.vn</option>
                            <option value="google.vu">google.vu</option>
                            <option value="google.ws">google.ws</option>
                            <option value="google.rs">google.rs</option>
                            <option value="google.co.za">google.co.za</option>
                            <option value="google.co.zm">google.co.zm</option>
                            <option value="google.co.zw">google.co.zw</option>
                            <option value="google.cat">google.cat</option>
                        </select> 
                        <input type="submit" name="" value="Save Changes" style="margin-top:25px;" onclick="saveKeyword();" />
                    </div>                                  
                </div>
            </div>
        </s:form>
        <!--end edit_keyword-->

        <!--keyboar link -->
        <s:form name="bestMatchForm" onsubmit="return false;" action="">
            <input type="hidden" name="engine" />
            <input type="hidden" name="linkGoogle">
            <div class="add_keyword_div" id="keyword_link" style="display:none; height: auto;">
                <div class="close_btn"><a href="#"><img src="https://s3.amazonaws.com/images_ranktracker/icon_close.png" alt="" border="none"/></a></div>
                <div class="keyword_div">
                    <div class="keyword_left">
                        <div class="site_txt">Url </div>
                        <input type="text" disabled="disabled" name="url">
                        <div class="site_txt">Keyword </div>
                        <input type="text" disabled="disabled" name="keyword">
                        <div class="site_txt">Rank </div>
                        <input type="text" disabled="disabled" name="rank"> 
                    </div>
                    <div class="keyword_right">   
                        <div class="site_txt">Best Match Rank </div>
                        <input type="text" disabled="disabled" name="matchRank"> 
                        <div class="site_txt">Best Match Link </div>
                        <input type="text" disabled="disabled" name="matchLink"> 
                        <input type="submit" value="Add Keyword" style="margin-top:25px;" onclick="addBestKeyword();" />
                    </div>                                  
                </div>
            </div>
        </s:form >
        <!--end keyboar_link-->

        <!--rank_chart-->
        <div class="chart_div google_chart" id="chartBlock" style="min-width: 400px; margin: -1px auto 20px 0; height: 200px; display: none ">
            <div class="close_btn"><a href="#"><img src="https://s3.amazonaws.com/images_ranktracker/icon_close.png" alt="" border="none"/></a></div>
        </div>
        <!--end rank_chart-->

        <!--social_chart-->
        <div class="chart_div social_chart" id="socialChartBlock" style="min-width: 400px; margin: -1px auto 20px 0; height: 200px; display: none ">
        </div>
        <!--end social_chart-->

        <!--div class="hr"></div-->
        <!--add notification here -->
        <div class="add_site_details_div" id="fade_away">
            <s:actionmessage />
        </div>
        <!--end notification here-->
        <s:form name="deleteform">
            <s:hidden name="keywordId" />
        </s:form>

        <!--new code here 27-07-2013 -->

        <div class="social_site_new" id="social_site_new">                            	 
            <ul>
                <li class="sc_links"><a href="#serps">SERPS</a></li>      
                <li class="sc_links"><a href="#social">SOCIAL</a></li>                         
                <li class="sc_links"><a href="#video">VIDEO</a></li>
            </ul>



            <div id="serps">
                <div class="social_site_div">                            	 
                    <div class="google">GOOGLE</div>      
                    <div class="yahoo">YAHOO!</div>                         
                    <div class="bing">BING</div>
                </div>
                <!--google-->
                <div class="add_site_details_div ggle" style="display:block;" >
                    <s:form name="keywordDetails">
                        <table id="keyword_table">
                            <thead>
                                <tr>
                                    <th><h3>Url</h3></th>
                            <th><h3>Google Link</h3></th>
                            <th><h3>Keyword</h3></th>
                            <th style="width:60px;"><h3><img src="https://s3.amazonaws.com/images_ranktracker/google_icon.png" style="border:none;" width="24" height="24" alt="" /></h3></th>
                            <th><h3>Day </h3></th>
                            <th><h3>Week</h3></th>
                            <th><h3>Month</h3></th>
                            <th><h3>SI</h3></th>
                            <th><h3>Alexa</h3></th>
                            <th><h3>BL</h3></th>
                            <th><h3>MS</h3></th>
                            <th style="padding-top: 0px; line-height: 0px; ">Chart</th>
                            <th style="padding-top: 0px;line-height: 0px;" >Edit</th>                                                
                            <th style="padding-top: 0px; border-right:none; line-height: 0px; ">Delete</th>   
                                
                            </tr>
                            </thead>

                            <s:iterator value="lstkeywords">
                                <tr>
                                    <td class="url" style="text-align: left;"><a href="#"><s:property value="url" /></a></td>
                                    <td><a href="http://<s:property value="url" />" target="_blank"><s:property value="linkGoogle" /></a></td>
                                    <td style="text-align: left;"><s:property value="keyword" /></a></td>
                                    <s:if test="%{rankGoogle!=1000 }">
                                        <td style="text-align: center;"><s:property value="rankGoogle" />
                                        </s:if>
                                        <s:else >
                                        <td style="text-align: center; font-size: 20px;">-
                                        </s:else>
                                        <s:if test="%{bestMatchRankGoogle!=0 }">
                                            <label class="keyword_row keyword_link" id="button12" onclick="bestMatchGoogle('<s:property value="url" />','<s:property value="keyword" />','<s:property value="rankGoogle" />','<s:property value="bestMatchRankGoogle" />','<s:property value="bestMatchLinkGoogle" />','google','<s:property value="linkGoogle" />');"><img src="https://s3.amazonaws.com/images_ranktracker/blinking.gif" style="cursor:pointer;"/></label>
                                            </s:if>
                                    </td>
                                    <td style="text-align: center; width: 40px"><s:property value="rankGoogleDayChange" />
                                        <s:if test="%{rankGoogleDayChange < 0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/red_arrow.png" />
                                        </s:if>
                                        <s:elseif test="%{rankGoogleDayChange > 0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/green_arrow.png" />
                                        </s:elseif>
                                    </td>
                                    <td style="text-align: center;"><s:property value="rankGoogleWeekChange" />
                                        <s:if test="%{rankGoogleWeekChange<0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/red_arrow.png" />
                                        </s:if>
                                        <s:elseif test="%{rankGoogleWeekChange>0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/green_arrow.png" />
                                        </s:elseif>
                                    </td>
                                    <td style="text-align: center;"><s:property value="rankGoogleMonthChange" />
                                        <s:if test="%{rankGoogleMonthChange<0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/red_arrow.png" />
                                        </s:if>
                                        <s:elseif test="%{rankGoogleMonthChange>0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/green_arrow.png" />
                                        </s:elseif>
                                    </td>
                                    <td style="text-align: center"></td>
                                    <td style="text-align: center"><s:property value="rankAlexa" /></td>
                                    <td style="text-align: center;"><s:property value="countBackLinks" /></td>
                                    <td style="text-align: center;"><s:property value="countMonthlySearches" /></td>
                                    <td><a href="javascript:drawChart('<s:property value="keywordId"/>','30');" id="google_chart"><img src="https://s3.amazonaws.com/images_ranktracker/chart.png" width="24" height="24" alt="" /></a></td>
                                    <td><a  href="#" id="edit" onclick="editKeyword(<s:property value="keywordId" />, '<s:property value="url" />', '<s:property value="linkGoogle" />','<s:property value="keyword" />');"><img src="https://s3.amazonaws.com/images_ranktracker/edit.png" width="24" height="25" alt="" /></a></td>
                                    <td style="border-right:none;"><a href="javascript:deleteKeyword(<s:property value="keywordId"/>);" ><img src="https://s3.amazonaws.com/images_ranktracker/delete.png" width="20" height="22" alt="" id="confirm_button"/></a></td>
                                </tr>
                            </s:iterator>  

                        </table>
                    </s:form>
                </div>
                <!--end google-->

                <!--yahoo-->
                <div class="add_site_details_div yhoo">
                    <s:form>
                        <table id="keyword_table1">
                            <thead>
                                <tr>
                                    <th><h3>Url</h3></th>
                            <th><h3>Keyword</h3></th>
                            <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/yahooicon.png" style="border:none;" width="24" height="24" alt="" /></h3></th>
                            <th><h3>Day </h3></th>
                            <th><h3>Week</h3></th>
                            <th><h3>Month</h3></th>
                            <th><h3>Last Updated</h3></th>
                            <th style="padding-top: 0px; line-height: 0px; ">Chart</th>                                              
                            <th style="padding-top: 0px; line-height: 0px; ">Edit</th>                                                
                            <th style="padding-top: 0px; line-height: 0px; border-right:none;">Delete</th>    
                            </tr>
                            </thead>
                            <s:iterator value="lstkeywords">
                                <tr>
                                    <td class="url" style="text-align: left;"><a href="http://<s:property value="url" />" target="_blank"><s:property value="url" /></a></td>
                                    <td style="text-align: left;"><s:property value="keyword" /></a></td>
                                    <s:if test="%{rankYahoo!=1000 }">
                                        <td style="text-align: center;"><s:property value="rankYahoo" />
                                        </s:if>
                                        <s:else >
                                        <td style="text-align: center; font-size: 20px;">-
                                        </s:else>
                                        <s:if test="%{bestMatchRankYahoo!=0 }">
                                            <label class="keyword_row keyword_link" id="button12" onclick="bestMatchYahoo('<s:property value="url" />','<s:property value="keyword" />','<s:property value="rankYahoo" />','<s:property value="bestMatchRankYahoo" />','<s:property value="bestMatchLinkYahoo" />','yahoo','<s:property value="linkGoogle" />');"><img src="https://s3.amazonaws.com/images_ranktracker/blinking.gif" style="cursor:pointer;"/></label>
                                        </s:if></td>
                                    <td style="text-align: center; width: 40px"><s:property value="rankYahooDayChange" />
                                        <s:if test="%{rankYahooDayChange<0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/red_arrow.png" />
                                        </s:if>
                                        <s:elseif test="%{rankYahooDayChange>0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/green_arrow.png" />
                                        </s:elseif>
                                    </td>
                                    <td style="text-align: center;"><s:property value="rankYahooWeekChange" />
                                        <s:if test="%{rankYahooWeekChange<0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/red_arrow.png" />
                                        </s:if>
                                        <s:elseif test="%{rankYahooWeekChange>0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/green_arrow.png" />
                                        </s:elseif>
                                    </td>
                                    <td style="text-align: center;"><s:property value="rankYahooMonthChange" />
                                        <s:if test="%{rankYahooMonthChange<0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/red_arrow.png" />
                                        </s:if>
                                        <s:elseif test="%{rankYahooMonthChange>0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/green_arrow.png" />
                                        </s:elseif>
                                    </td>
                                    <td></td>
                                    <td><a href="javascript:drawChart('<s:property value="keywordId"/>','30');" id="yahoo_chart"><img src="https://s3.amazonaws.com/images_ranktracker/chart.png" width="24" height="24" alt="" /></a></td>
                                    <td><a href="javascript:editKeyword(<s:property value="keywordId" />, '<s:property value="url" />', '<s:property value="linkGoogle" />','<s:property value="keyword" />');" id="edit"><img src="https://s3.amazonaws.com/images_ranktracker/edit.png" width="24" height="25" alt="" /></a></td>
                                    <td style="border-right:none;"><a href="javascript:deleteKeyword(<s:property value="keywordId"/>);" ><img src="https://s3.amazonaws.com/images_ranktracker/delete.png" width="20" height="22" alt="" id="confirm_button" /></a></td>
                                </tr>
                            </s:iterator>
                        </table>
                    </s:form>
                </div>
                <!--end yahoo-->                            

                <!--Bing-->
                <div class="add_site_details_div bng">
                    <s:form >
                        <table id="keyword_table2">
                            <thead>
                                <tr>
                                    <th><h3>Url</h3></th>
                            <th><h3>Keyword</h3></th>
                            <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/bingicon.png" style="border:none;" width="24" height="24" alt="" /></h3></th>
                            <th><h3>Day </h3></th>
                            <th><h3>Week</h3></th>
                            <th><h3>Month</h3></th>
                            <th style="padding-top: 0px; line-height: 0px; ">Chart</th>         
                            <th style="padding-top: 0px; line-height: 0px; ">Edit</th>   
                            <th style=" padding-top: 0px; line-height: 0px; border-right:none;">Delete</th>   
                            </tr>
                            </thead>
                            <s:iterator value="lstkeywords">
                                <tr>
                                    <td class="url" style="text-align: left;"><a href="http://<s:property value="url" />" target="_blank"><s:property value="url" /></a></td>
                                    <td style="text-align: left;"><s:property value="keyword" /></a></td>
                                    <s:if test="%{rankBing!=1000 }">
                                        <td style="text-align: center;"><s:property value="rankBing" />
                                        </s:if>
                                        <s:else >
                                        <td style="text-align: center; font-size: 20px;">-
                                        </s:else>
                                        <s:if test="%{bestMatchRankBing!=0 }">
                                            <label class="keyword_row keyword_link" id="button12" onclick="bestMatchBing('<s:property value="url" />','<s:property value="keyword" />','<s:property value="rankBing" />','<s:property value="bestMatchRankBing" />','<s:property value="bestMatchLinkBing" />','bing','<s:property value="linkGoogle" />');"><img src="https://s3.amazonaws.com/images_ranktracker/blinking.gif" style="cursor:pointer;"/></label>
                                            </s:if>
                                    </td>
                                    <td style="text-align: center; width: 40px"><s:property value="rankBingDayChange" />
                                        <s:if test="%{rankBingDayChange<0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/red_arrow.png" />
                                        </s:if>
                                        <s:elseif test="%{rankBingDayChange>0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/green_arrow.png" />
                                        </s:elseif>
                                    </td>
                                    <td style="text-align: center;"><s:property value="rankBingWeekChange" />
                                        <s:if test="%{rankBingWeekChange<0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/red_arrow.png" />
                                        </s:if>
                                        <s:elseif test="%{rankBingWeekChange>0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/green_arrow.png" />
                                        </s:elseif>
                                    </td>
                                    <td style="text-align: center;"><s:property value="rankBingMonthChange" />
                                        <s:if test="%{rankBingMonthChange<0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/red_arrow.png" />
                                        </s:if>
                                        <s:elseif test="%{rankBingMonthChange>0}">
                                            <img src="https://s3.amazonaws.com/images_ranktracker/green_arrow.png" />
                                        </s:elseif>
                                    </td>
                                    <td><a href="javascript:drawChart('<s:property value="keywordId"/>','30');" id="bing_chart"><img src="https://s3.amazonaws.com/images_ranktracker/chart.png" width="24" height="24" alt="" /></a></td>
                                    <td><a href="javascript:editKeyword(<s:property value="keywordId" />, '<s:property value="url" />', '<s:property value="linkGoogle" />','<s:property value="keyword" />');" id="edit"><img src="https://s3.amazonaws.com/images_ranktracker/edit.png" width="24" height="25" alt="" /></a></td>
                                    <td style="border-right:none;"><a href="javascript:deleteKeyword(<s:property value="keywordId"/>);" ><img src="https://s3.amazonaws.com/images_ranktracker/delete.png" width="20" height="22" alt="" id="confirm_button" /></a></td>
                                </tr>
                            </s:iterator>                                      

                        </table>
                    </s:form >
                </div>
                <!--end bing-->

            </div>

            <!--social-->
            <div id="social" style="display:none;">
                <div class="social_site_div">
                    <div class="social_data">SOCIAL SIGNAL</div>
                </div>       


                <div class="add_site_details_div scl_data" style="display:block;">

                    <table id="keyword_table3">
                        <thead>
                            <tr>
                                <th><h3>Url</h3></th>
                        <th><h3>Keyword</h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/fb_likes.png" style="border:none;" width="24" height="24" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/fb_share.png" style="border:none;" width="70" height="20" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/twt_count.png" style="border:none;" width="24" height="24" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/pintrest.png" style="border:none;" width="24" height="24" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/google_plus.png" style="border:none;" width="24" height="24" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/linkedin.png" style="border:none;" width="24" height="24" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/reddit.png" style="border:none;" width="24" height="24" alt="" /></h3></th>
                        <th><h3><img src="https://s3.amazonaws.com/images_ranktracker/stumbleupon.png" style="border:none;" width="24" height="24" alt="" /></h3></th>
                        <th style="padding-top: 0px; line-height: 0px; ">Chart</th>
                        <th style="padding-top: 0px; line-height: 0px; ">Edit</th>                                                
                        <th style="padding-top: 0px; line-height: 0px; border-right:none;">Delete</th>   
                        </tr>
                        </thead>
                        <s:iterator value="lstkeywords">
                            <tr>
                                <td class="url" style="text-align: left;"><a href="http://<s:property value="url" />" target="_blank"><s:property value="url" /></a></td>
                                <td style="text-align: left;"><s:property value="keyword" /></td>
                                <td style="text-align: center;"><s:property value="facebookLike" /></td>
                                <td style="text-align: center;"><s:property value="facebookShare" /></td>
                                <td style="text-align: center;"><s:property value="tweetCount" /></td>
                                <td style="text-align: center;"><s:property value="pinterestPins" /></td>
                                <td style="text-align: center;"><s:property value="googlePlusLikes" /></td>
                                <td style="text-align: center;"><s:property value="linkedInShares" /></td>
                                <td style="text-align: center;"><s:property value="redittVotes" /></td>
                                <td style="text-align: center;"><s:property value="stumbleUponLikes" /></td>
                                <td><a href="javascript:drawSocialChart('<s:property value="keywordId"/>','30');" id="social_chart"><img src="https://s3.amazonaws.com/images_ranktracker/chart.png" width="24" height="24" alt="" /></a></td>
                                <td><a href="javascript:editKeyword(<s:property value="keywordId" />, '<s:property value="url" />', '<s:property value="linkGoogle" />','<s:property value="keyword" />');" id="edit"><img src="https://s3.amazonaws.com/images_ranktracker/edit.png" width="24" height="25" alt="" /></a></td>
                                <td style="border-right:none;"><a href="javascript:deleteKeyword(<s:property value="keywordId"/>);" ><img src="https://s3.amazonaws.com/images_ranktracker/delete.png" width="20" height="22" alt="" id="confirm_button" /></a></td>
                            </tr>
                        </s:iterator>   
                    </table>
                </div>

            </div>
            <!--end social-->

            <!--video-->
            <div id="video" style="display:none;">            
                <div class="social_site_div">                            	 
                    <div class="google">YOUTUBE</div>      
                    <div class="yahoo">METACAFE</div>                         
                    <div class="bing">VIMEO</div>
                    <div class="bing">DAILY MOTION</div>
                </div>
            </div>
            <!--end video-->
        </div>
        <!--end new code here 27-07-2013 -->


    </div>
    <!--end dashboard_wrapper-->
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <p></p>
</div>

<script> 
    $( "#social_site_new" ).tabs();  
</script>
<!-- Body end -->
<script type="text/javascript" src="https://s3.amazonaws.com/js_ranktracker/jquery.js"></script>
<script>
    $(document).ready(function() 
    {
        $("#clickme").click(function () {
            $("#add_site").slideToggle("slow");
            $("#keyword_link").hide();
            $(".bing_chart").hide();
            $(".yahoo_chart").hide();
            $(".google_chart").hide();
            $(".social_chart").hide();
            $("#edit_keyword").hide();
        });

        $("#fade_away").fadeOut(20000);
        $(".google").click(function () {
            $("#keyword_link").hide();
            $(".ggle").show();
            $(".yhoo").hide();
            $(".bng").hide();
            $("#add_site").hide();
            $("#edit_keyword").hide();
        });	
        $(".yahoo").click(function () {
            $("#keyword_link").hide();
            $(".ggle").hide();
            $(".yhoo").show();
            $(".bng").hide();
            $("#add_site").hide();
            $("#edit_keyword").hide();
        });	
        $(".bing").click(function () {
            $("#keyword_link").hide();
            $(".ggle").hide();
            $(".yhoo").hide();
            $(".bng").show();
            $("#add_site").hide();
            $("#edit_keyword").hide();
        });	
        $(".social_data").click(function () 
        {
            $("#keyword_link").hide();
            $(".ggle").hide();
            $(".yhoo").hide();
            $(".bng").hide();
            $("#add_site").hide();
            $("#edit_keyword").hide();
        });
        
        $("#google_chart").click(function () {
            $(".google_chart").slideToggle("slow");
            $("#keyword_link").hide();
            $(".social_chart").hide();
            $(".yahoo_chart").hide();
            $(".bing_chart").hide();
            $("#add_site").hide();
            $("#edit_keyword").hide();
        });	
        $("#yahoo_chart").click(function () {
            $(".yahoo_chart").slideToggle("slow");
            $("#keyword_link").hide();
            $(".social_chart").hide();
            $(".google_chart").hide();
            $(".bing_chart").hide();
            $("#add_site").hide();
            $("#edit_keyword").hide();
        });	
        $("#bing_chart").click(function () {
            $(".bing_chart").slideToggle("slow");
            $("#keyword_link").hide();
            $(".social_chart").hide();
            $(".yahoo_chart").hide();
            $(".google_chart").hide();
            $("#add_site").hide();
            $("#edit_keyword").hide();
        });
        $("#social_chart").click(function () {
            $(".social_chart").slideToggle("slow");
            $("#keyword_link").hide();
            $(".google_chart").hide();
            $(".yahoo_chart").hide();
            $(".bing_chart").hide();
            $("#add_site").hide();
            $("#edit_keyword").hide();
        });	
        $(".keyword_link").click(function () {
            $("#keyword_link").slideToggle("slow");
            $("#keyword_link").hide();
            $(".yahoo_chart").hide();
            $(".google_chart").hide();
            $(".social_chart").hide();
            $("#add_site").hide();
        });	
        
        $(".close_btn").click(function () {
            //$("#add_site").slideToggle("slow");
            $("#keyword_link").fadeOut("slow");
            $(".yahoo_chart").fadeOut("slow");
            $(".google_chart").fadeOut("slow");
            $(".social_chart").fadeOut("slow");
            $("#add_site").fadeOut("slow");
            $("#edit_keyword").fadeOut("slow");
        });
         
    });	
</script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="https://s3.amazonaws.com/js_ranktracker/highcharts.js"></script>
<script src="https://s3.amazonaws.com/js_ranktracker/exporting.js"></script>
<script type="text/javascript">
    var opened="0";
    function drawSocialChart(keywordId, range){
        // $('#chartBlock').css({display: 'none'});
        var jString = "{\"keywordId\":\"" + keywordId + "\" , \"range\":\"" + range+ "\"}";
        var chart;
        $('#se1Loader').css({display: 'block'});
        $.getJSON(
        'ajax/getSocialData.action',
        {
            jString: jString
        },
        function(jMap) {
            $('#se1Loader').css({display: 'none'});
            chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'socialChartBlock',
                    type: 'line',
                    marginRight: 130,
                    marginBottom: 25,
                    width:1100,
                    height:200
                },
                title: jMap.dataMap.title,
                subtitle: {
                    text: '',
                    x: -20
                },
                credits: {
                    text: 'globustracker.com',
                    href: 'http://www.globustracker.com/'
                },
                xAxis: {
                    type: 'datetime',
                    dateTimeLabelFormats: {
                        day: '%b %e '   
                    }
                },
                yAxis: {
                    title: {
                        text: 'Rankings'
                    },
                    allowDecimals: false,
                    min: 0,
                    tickPixelInterval: 20,
                    plotLines: [{
                            value: 0,
                            width: 1,
                            color: '#808080'
                        }]
                },
                tooltip: {
                    crosshairs: true,
                    shared: true
                },
                legend: {
                    layout: 'horizontal',
                    align: 'top',
                    verticalAlign: 'top',
                    x: 0,
                    y: 0,
                    borderWidth: 0
                },
                
                series: eval(jMap.dataMap.sbData)
            });
               
        });
        $('#socialChartBlock').show();
    }
    
    function drawChart(keywordId, range) {
        var jString = "{\"keywordId\":\"" + keywordId + "\" , \"range\":\"" + range+ "\"}";
        var chart;
        $('#se1Loader').css({display: 'block'});
        $.getJSON(
        'ajax/getData.action',
        {
            jString: jString
        },
        function(jMap) {
            $('#se1Loader').css({display: 'none'});
            chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'chartBlock',
                    type: 'line',
                    marginRight: 130,
                    marginBottom: 25,
                    width:1100,
                    height:200,
                    zoomType: 'x'
                },
                title: jMap.dataMap.title,
                subtitle: {
                    text: '',
                    x: -20
                },
                credits: {
                    text: 'globustracker.com',
                    href: 'http://www.globustracker.com/'
                },
                xAxis: {
                    //categories: eval(jMap.dataMap.sbRange),
                    type: 'datetime',
                    dateTimeLabelFormats: {
                        day: '%b %e '   
                    }
                },
                yAxis: {
                    title: {
                        text: 'Rankings'
                    },
                    allowDecimals: false,
                    reversed : true,
                    min: 0,
                    tickPixelInterval: 20,
                    plotLines: [{
                            value: 0,
                            width: 1,
                            color: '#808080'
                        }]
                },
                tooltip: {
                    crosshairs: true,
                    shared: true
                },
                legend: {
                    layout: 'horizontal',
                    align: 'top',
                    verticalAlign: 'top',
                    x: 300,
                    y: 0,
                    borderWidth: 0
                },
                
                series: eval(jMap.dataMap.sbData)
            });
               
        });
        $('#chartBlock').show();
    }

    var alertMes = "";
    function addKeyword(){
        var keywords = document.addForm.keywords.value;
        var url=document.addForm.url.value;
        var linkGoogle=document.getElementById("linkGoogle").value;
        $('#se1Loader').css({display: 'block'});
        $.post(
        'ajax/addKeyword.action', 
        {
            arrKeywords: keywords,
            url:url,
            linkGoogle:linkGoogle
        }, 
        function(jMessage) {
            alertMes = jMessage.message;
            $('#se1Loader').css({display: 'none'});
            window.location="keywords.action";
        },
        'json');
    }
    
    function editKeyword(keywordId, url, linkGoogle, keyword ){
        
        try{
            document.editForm.keywordId.value = keywordId;
            document.editForm.url.value = url;
            document.editForm.linkGoogle.value = linkGoogle;
            document.editForm.keyword.value = keyword;
            
            $("#edit_keyword").slideToggle("slow");
            $(".yahoo_chart").hide();
            $(".google_chart").hide();
            $("#add_site").hide();
            $(".bing_chart").hide();
            
        }catch(e)
        {alert(e);}
        
    }
    
    function saveKeyword(){
        $('#se1Loader').css({display: 'block'});
        var keywordId = document.editForm.keywordId.value;
        var url = document.editForm.url.value;
        var linkGoogle=document.editForm.linkGoogle.value;
        var keyword  = document.editForm.keyword.value;
        
        if(keyword=="" || url==""){
            return false;
        }
        
        $.post(
        'ajax/editKeyword.action',
        {
            keywordId:keywordId,
            arrKeywords: keyword,
            url:url,
            linkGoogle:linkGoogle
        },
        function(jMessage) {
            $('#se1Loader').css({display: 'none'});
            alertMes = jMessage.message;
            if(alertMes=="Keyword Edited")
            {
                window.location="keywords.action";
            }
        },
        'json');
    }
    
    //ajax call to delete Keyword
    function setKeywordId(keywordId){
        try{
            alert(keywordId);
            document.deleteform.keywordId.value=keywordId;
        }catch(e)
        {
            alert(e);
        }
    }
    
    function bestMatchGoogle(url,keyword,rank,matchRank,matchLink,engine,linkGoogle)
    {
        $(".keyword_link").click(function () {
            $("#keyword_link").show();
            $(".yahoo_chart").hide();
            $(".google_chart").hide();
            $(".social_chart").hide();
            $("#add_site").hide();
        });
               
        document.bestMatchForm.url.value=url;
        document.bestMatchForm.keyword.value=keyword;
        document.bestMatchForm.rank.value=rank;
        document.bestMatchForm.matchRank.value=matchRank;
        document.bestMatchForm.matchLink.value=matchLink;
        document.bestMatchForm.engine.value=engine;
        document.bestMatchForm.linkGoogle.value=linkGoogle;
    }
    
    function bestMatchYahoo(url,keyword,rank,matchRank,matchLink,engine,linkGoogle)
    {
        $(".keyword_link").click(function () {
            $("#keyword_link").show();
            $(".yahoo_chart").hide();
            $(".google_chart").hide();
            $(".social_chart").hide();
            $("#add_site").hide();
        });
        document.bestMatchForm.url.value=url;
        document.bestMatchForm.keyword.value=keyword;
        document.bestMatchForm.rank.value=rank;
        document.bestMatchForm.matchRank.value=matchRank;
        document.bestMatchForm.matchLink.value=matchLink;
        document.bestMatchForm.engine.value=engine;
        document.bestMatchForm.linkGoogle.value=linkGoogle;
    }
       
    function bestMatchBing(url,keyword,rank,matchRank,matchLink,engine,linkGoogle)
    {
        $(".keyword_link").click(function () {
            $("#keyword_link").show();
            $(".yahoo_chart").hide();
            $(".google_chart").hide();
            $(".social_chart").hide();
            $("#add_site").hide();
        });
        document.bestMatchForm.url.value=url;
        document.bestMatchForm.keyword.value=keyword;
        document.bestMatchForm.rank.value=rank;
        document.bestMatchForm.matchRank.value=matchRank;
        document.bestMatchForm.matchLink.value=matchLink;
        document.bestMatchForm.engine.value=engine;
        document.bestMatchForm.linkGoogle.value=linkGoogle;
    }
    
    function addBestKeyword()
    {
        $('#se1Loader').css({display: 'block'});
        var keywords = document.bestMatchForm.keyword.value;
        var url=document.bestMatchForm.url.value;
        var matchRank=document.bestMatchForm.matchRank.value;
        var matchLink=document.bestMatchForm.matchLink.value;
        var engine=document.bestMatchForm.engine.value;
        var linkGoogle=document.bestMatchForm.linkGoogle.value;
        $.post(
        'ajax/addKeyword.action', 
        {
            arrKeywords: keywords,
            url:url,
            matchRank:matchRank,
            matchLink:matchLink,
            engine:engine,
            linkGoogle:linkGoogle
        }, 
        function(jMessage) {
            $('#se1Loader').css({display: 'none'});
            alertMes = jMessage.message;
            if(alertMes=="Keywords Added")
            {
                window.location="keywords.action";}
            //alert(jMessage.message);
        },
        'json'); 
     
    }          
</script>
<script src="https://s3.amazonaws.com/js_ranktracker/delete_jquery.js" type="text/javascript"></script>
<script src="https://s3.amazonaws.com/js_ranktracker/jquery.ui.draggable.js" type="text/javascript"></script>

<!-- Core files -->
<script src="https://s3.amazonaws.com/js_ranktracker/jquery.alerts.js" type="text/javascript"></script>
<link href="https://s3.amazonaws.com/css_ranktracker/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript">
    function deleteKeyword(keywordId)	{
        $('#se1Loader').css({display: 'block'});
        jConfirm('Are you sure you want to delete this?Lost logs cannot be retrieved again.', 'Keyword Delete', function(r) {
            if(r)
            {
                var jString = keywordId;
                $.post(
                'ajax/deleteKeyword.action',
                {
                    jString: jString
                },
                function(jMessage) {
                    $('#se1Loader').css({display: 'none'});
                    alertMes = jMessage.message;
                    if(alertMes=="Keyword has been Deleted")
                    {
                        window.location="keywords.action";
                    }
                },
                'json');
            }
        });}
</script>

<script type="text/javascript" src="https://s3.amazonaws.com/js_ranktracker/script.js"></script>
<script type="text/javascript">
    var sorter = new TINY.table.sorter("sorter");
    sorter.head = "head";
    sorter.asc = "asc";
    sorter.desc = "desc";
    sorter.even = "evenrow";
    sorter.odd = "oddrow";
    sorter.evensel = "evenselected";
    sorter.oddsel = "oddselected";
    sorter.paginate = false;
    sorter.currentid = "currentpage";
    sorter.limitid = "pagelimit";
    sorter.init("keyword_table1",1);
</script>

<script type="text/javascript">
    var sorter1 = new TINY.table.sorter("sorter1");
    sorter1.head = "head";
    sorter1.asc = "asc";
    sorter1.desc = "desc";
    sorter1.even = "evenrow";
    sorter1.odd = "oddrow";
    sorter1.evensel = "evenselected";
    sorter1.oddsel = "oddselected";
    sorter1.paginate = false;
    sorter1.currentid = "currentpage";
    sorter1.limitid = "pagelimit";
    sorter1.init("keyword_table",1);
</script>

<script type="text/javascript">
    var sorter2 = new TINY.table.sorter("sorter2");
    sorter2.head = "head";
    sorter2.asc = "asc";
    sorter2.desc = "desc";
    sorter2.even = "evenrow";
    sorter2.odd = "oddrow";
    sorter2.evensel = "evenselected";
    sorter2.oddsel = "oddselected";
    sorter2.paginate = false;
    sorter2.currentid = "currentpage";
    sorter2.limitid = "pagelimit";
    sorter2.init("keyword_table2",1);
</script>

<script type="text/javascript">
    var sorter3 = new TINY.table.sorter("sorter3");
    sorter3.head = "head";
    sorter3.asc = "asc";
    sorter3.desc = "desc";
    sorter3.even = "evenrow";
    sorter3.odd = "oddrow";
    sorter3.evensel = "evenselected";
    sorter3.oddsel = "oddselected";
    sorter3.paginate = false;
    sorter3.currentid = "currentpage";
    sorter3.limitid = "pagelimit";
    sorter3.init("keyword_table3",1);
  
</script>