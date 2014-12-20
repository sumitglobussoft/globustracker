<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<style type="text/css">
.pricing_prwrapper
{
	width:1135px;
	height:auto;
	margin:35px auto;
}
.plan-table{	width:100%;	border-collapse:collapse;	border-spacing:0;	font-size:14px;	color:#fff;font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;	}
.plan-table td{	padding:10px 13px;	text-align:center;  width:30px;	}
.plan-table tr.even td{background:#97c428; color:#000}
.plan-table tr.odd td{background:#def3aa; color:#272626;}
.plan-table td.left{	text-align:left;  width:67px;	}
.toptble
{
	width:1140px;
	height:146px;
}

.toptble .pricingd
{
	 color: #222222;
    float: left;
    font-family: "Trebuchet MS",Arial;
    font-size: 39px;
    height: 93px;
    margin-top: 35px;
    text-align: center;
    width: 178px
}
.toptble .pricingbgshow
{
	width:945px;
	height:146px;
	float:right;
}

.toptble .pricingbgshow .leftside
{
	background:url(images/pricing_left.png);
	width:115px;
	height:146px;
	float:left;
}

.toptble .pricingbgshow .rightside
{
	background: url(images/pricing_right.png);
	width:115px;
	height:146px;
	float:left;
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	text-align:center;
	color:#fff;
	font-size:37px;
	text-shadow:0 1px 0 #000;
}

.toptble .pricingbgshow .rightside b
{
	font-size:30px;
}

.toptble .pricingbgshow .rightside a
{
	font-size:18px;
}

.toptble .pricingbgshow .rightside span
{
	font-size:18px;
}

.freetexteffet
{
	width:115px;
	height:auto;
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	text-align:center;
	color:#fff;
	font-size:37px;
	margin-top:47px;
	text-shadow:0 1px 0 #000;
}

.pricinbg
{
	width:115px;
	height:auto;
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	text-align:center;
	color:#fff;
	text-shadow:0 1px 0 #000;
}

.pricinbg b
{
	font-size:30px;
}

.pricinbg a
{
	font-size:18px;
}

.pricinbg span
{
	font-size:18px;
}

.registerbtn
{
	 height: 29px;
    margin: 12px auto 0;
    width: 104px;
}

.rpicdivider
{
	width:2px;
	height:146px;
	float:left;
	background:url(images/pricing_divider.png);
}

.pricinbg
{
	width:116px;
	height:146px;
	float: left;
	background:url(images/pricing_bg.png);
}
.pspce
{
	width:115px; height:6px;
}

.prcing
{
	width:115px; height:21px;
}

.add_fifty
{
	float: left;
    height: 52px;
    margin: 10px 0;
    width: 382px;
}

.table_prbg
{
	width:1135px;
	height:auto;
	float:left;
}

</style>     
             <!-- Body start -->
            <div id="body">              
                  <div class="page_title_bg">
                  		<div class="page_title_wrapper">
                        	<div class="page_title">PRICING <a style="color: white;float: right;" href="signIn.action">Login</a></div>                            
                        </div>
                   </div>   
                   <!--pricing_wrapper-->
                    <div class="pricing_prwrapper">
                    	
                        <div class="toptble">
                           <div class="pricingd">PRICING PLAN</div>
                           <div class="pricingbgshow">
                               <div class="leftside">
                                  <div class="freetexteffet">FREE</div>
                                  <div class="registerbtn"><a href="#"><img src="https://s3.amazonaws.com/images_ranktracker/registerbtn.png" alt="" border="none" /></a></div>
                               </div>
                               <div class="rpicdivider"></div>
                               <div class="pricinbg">
                                  <div class="prcing"></div>
                                   <span>Newbie</span> 
                                   <div class="pspce"></div>
                                   <b>$9</b><a>.99</a>
                                   <div class="pspce"></div>
                                   <div class="registerbtn"><a href="#"><img src="https://s3.amazonaws.com/images_ranktracker/registerbtn.png" alt="" border="none" /></a></div>
                               </div>
                               <div class="rpicdivider"></div>
                               <div class="pricinbg">
                                  <div class="prcing"></div>
                                   <span>Individual</span> 
                                   <div class="pspce"></div>
                                   <b>$19</b><a>.99</a>
                                   <div class="pspce"></div>
                                   <div class="registerbtn"><a href="#"><img src="https://s3.amazonaws.com/images_ranktracker/registerbtn.png" alt="" border="none" /></a></div>
                               </div>
                               <div class="rpicdivider"></div>
                               <div class="pricinbg">
                                  <div class="prcing"></div>
                                   <span>Master</span> 
                                   <div class="pspce"></div>
                                   <b>$34</b><a>.99</a>
                                   <div class="pspce"></div>
                                   <div class="registerbtn"><a href="#"><img src="https://s3.amazonaws.com/images_ranktracker/registerbtn.png" alt="" border="none" /></a></div>
                               </div>
                                <div class="rpicdivider"></div>
                               <div class="pricinbg">
                                  <div class="prcing"></div>
                                   <span>Professional</span> 
                                   <div class="pspce"></div>
                                   <b>$59</b><a>.99</a>
                                   <div class="pspce"></div>
                                   <div class="registerbtn"><a href="#"><img src="https://s3.amazonaws.com/images_ranktracker/registerbtn.png" alt="" border="none" /></a></div>
                               </div>
                                <div class="rpicdivider"></div>
                               <div class="pricinbg">
                                  <div class="prcing"></div>
                                   <span>Agency</span> 
                                   <div class="pspce"></div>
                                   <b>$149</b><a>.99</a>
                                   <div class="pspce"></div>
                                   <div class="registerbtn"><a href="#"><img src="https://s3.amazonaws.com/images_ranktracker/registerbtn.png" alt="" border="none" /></a></div>
                               </div>
                                <div class="rpicdivider"></div>
                               <div class="pricinbg">
                                  <div class="prcing"></div>
                                   <span>Reseller</span> 
                                   <div class="pspce"></div>
                                   <b>$299</b><a>.99</a>
                                   <div class="pspce"></div>
                                   <div class="registerbtn"><a href="#"><img src="https://s3.amazonaws.com/images_ranktracker/registerbtn.png" alt="" border="none" /></a></div>
                               </div>
                               <div class="rpicdivider"></div>
                               <div class="rightside">
                                  <div class="prcing"></div>
                                   <span>Entreprise</span> 
                                   <div class="pspce"></div>
                                   <b>$799</b><a>.99</a>
                                   <div class="pspce"></div>
                                   <div class="registerbtn"><a href="#"><img src="https://s3.amazonaws.com/images_ranktracker/registerbtn.png" alt="" border="none" /></a></div>
                               </div>
                           </div>
                        </div>
                       
                    <div class="table_prbg">
                      <table class="plan-table">
                        <tbody><tr class="even">
                          <td class="left">Campaigns</td>
                         
                          <td>1</td>
                          <td>5</td>
                          <td>10</td>
                          <td>30</td>
                          <td>50</td>
                          <td>250</td>
                          <td>500</td>
                          <td>1500</td>
                        </tr>
                        <tr class="odd">
                          <td class="left">Users</td>
                          
                          <td>1</td>
                          <td>1</td>
                          <td>1</td>
                          <td>3</td>
                          <td>5</td>
                          <td>10</td>
                          <td>Unlimited</td>
                          <td>Unlimited</td>
                        </tr>
                        <tr class="even">
                          <td class="left">Keywords</td>
                         
                          <td>20</td>
                          <td>100</td>
                          <td>200</td>
                          <td>500</td>
                          <td>1000</td>
                          <td>5000</td>
                          <td>10,000</td>
                          <td>30,000</td>
                        </tr>
                       
                      </tbody>
                     </table>
             </div>
             
             <div class="add_fifty"><a href="#"><img src="images/add_fiftybtn.png" alt="" border="none" /></a></div>
  </div>
</div>
             