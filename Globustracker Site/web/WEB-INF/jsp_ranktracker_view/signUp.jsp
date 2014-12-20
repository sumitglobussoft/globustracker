<%@taglib prefix="s" uri="/struts-tags" %>
<!-- Body start -->
<div id="body">              
    <div class="page_title_bg">
        <div class="page_title_wrapper">
            <div class="page_title">SIGN UP</div>                            
        </div>                        
    </div>   
    <s:form action="signUpSubmit" id="SignUpForm" validate="true">
        <div class="sign_up_page_wrapper">
            <div class="sign_up_top">Account Information</div>
            
            <div class="sign_up_mid">
                <div class="all_fields_mandatory">All fields mandatory</div>
                <div class="left">
                    <s:textfield tabindex="1" id="emailId" name="emailId" maxlength="50" type="text" onfocus="if(this.value='Email Id') this.value=''" onblur="if(this.value=='') this.value='Email Id'" value="Enter Email" />                                
                    <div class="error"><s:actionerror /></div>
                    <s:textfield tabindex="2" id="firstName" name="firstName" maxlength="20" type="text" onfocus="if(this.value='First Name') this.value=''" onblur="if(this.value=='') this.value='First Name'" value="First Name" />
                    <!--<div class="error">Enter Your First Name!</div>-->
                    <s:textfield tabindex="4" id="phone" name="phone" maxlength="30" type="text" onfocus="if(this.value='Phone No') this.value=''" onblur="if(this.value=='') this.value='Phone No'" value="Phone No" />
                    <!--<div class="error">Please Enter Your Phone No!</div>-->
                    <s:textfield tabindex="6" id="city" name="city" maxlength="20" type="text" onfocus="if(this.value='City') this.value=''" onblur="if(this.value=='') this.value='City'" value="City" />
                    <!--<div class="error">Please Enter Your City!</div>-->
                    <s:textfield tabindex="8" id="country" name="country" maxlength="20" type="text" onfocus="if(this.value='Country') this.value=''" onblur="if(this.value=='') this.value='Country'" value="Country" />
                    <!--<div class="error">Please Enter Your Country!</div>-->
                </div>
                <div class="right">
                    <s:textfield tabindex="3" id="lastName" name="lastName" maxlength="20" type="text" onfocus="if(this.value='Last Name') this.value=''" onblur="if(this.value=='') this.value='Last Name'" value="Last Name" />
                    <!--<div class="error">Please Enter Your Last Name!</div>-->
                    <s:textfield tabindex="5" id="address" name="address" maxlength="50" type="text" onfocus="if(this.value='Address') this.value=''" onblur="if(this.value=='') this.value='Address'" value="Address" />
                    <!--<div class="error">Please Enter Your Address!</div>-->
                    <s:textfield tabindex="7" id="state" name="state" maxlength="20" type="text" onfocus="if(this.value='State') this.value=''" onblur="if(this.value=='') this.value='State'" value="State" />
                    <!--<div class="error">Please Enter Your State!</div>-->
                    <s:textfield tabindex="9" id="zipCode" name="zipCode" maxlength="10" type="text" onfocus="if(this.value='Zip') this.value=''" onblur="if(this.value=='') this.value='Zip'" value="Zip" />
                    <!--<div class="error">Please Enter Zip!</div>-->
                </div>
                    
                    
            </div>
            <div class="sign_up_bot">
                <input type="submit" name="" value="" />
            </div>
        </div>
    </s:form>
    <!--sign_up_blank_div-->
    <div class="sign_up_blank_div"></div>
    <!--end sign_up_blank_div-->
    <p></p>
</div>
<!-- Body end -->