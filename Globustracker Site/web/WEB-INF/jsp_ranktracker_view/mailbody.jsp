<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <style>
            body {
                font-family: "Segoe UI", Helvetica, Arial, sans-serif;
            }
        </style>
    </head>
    <body>
        <s:if test="%{mailType == 1}">
            <!--- mailType 1 is for signup confirmation mail  -->

            <div style="width:90%;margin-left:5%;margin-top:4%;">
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#000;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width: 0px;">&nbsp; </td>
                            <td style="">
                                <a target="_blank" href="http://www.globustracker.com">
                                    <img alt="GlobusTracker" src="views/images_ranktracker/Globustracker-logo-present.png" style="width:30%;margin-left:-1%;margin-top:.7%;">
                                </a>
                            </td>
                            <td style="width:5%">&nbsp; </td>
                        </tr>
                    </tbody>
                </table>
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#f5f5f5;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%;background:#f5f5f5">&nbsp; </td>
                            <td>
                    <center>
                        <table width="95%" cellspacing="6" cellpadding="6" style="width:100%;margin:0;padding:0">
                            <tbody>
                                <tr>
                                    <td style="padding:0 5px 0px 0px">
                                        <h3 align="left">Hi,&nbsp;<s:property value="data.get('name')"/></h3>
                                        <p align="left">
                                            Welcome to <strong>GlobusTracker</strong>.<br><br>
                                            This is a confirmation that your email address '<s:property value="data.get('username')"/>' has been registered with us. In order to complete the set-up process and to continue monitoring the progress of your project(s), Please click on the confirmation button below. 
                                            <br><br> <a target="_blank" href="http://www.globustracker.com/accountActivation.action?token=<s:property value="data.get('token')"/>&itemName=<s:property value="data.get('itemName')"/>" style="border: 3px solid #0073ae; padding: 0.5%; text-decoration: none;">Confirm</a> <br><br>
                                            Have a Nice day..!!<br><br>
                                            Best Regards,<br>
                                            The GlobusTracker Team.
                                        </p>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </center>
                    </td>
                    <td style="width:5%;background:#f5f5f5">&nbsp; </td>
                    </tr>
                    </tbody>
                </table>
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#e8e8e8;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%;background:#e8e8e8">&nbsp; </td>
                            <td style="width:90%;background:#e8e8e8">
                                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#e8e8e8;padding:10px;width:100%">
                                    <tbody>
                                        <tr>
                                            <td width="80%" align="left">
                                                &copy; 2014. All Rights Reserved. <a href="http://www.globustracker.com">GlobusTracker</a>.
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                            <td style="width:5%;background:#e8e8e8">&nbsp; </td>
                        </tr>
                    </tbody>
                </table>
            </div>  
        </s:if>

        <s:if test="%{mailType == 2}">
            <div style="width:90%;margin-left:5%;margin-top:4%;">
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#000;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%"> &nbsp;</td>
                            <td>
                                <a target="_blank" href="http://www.globustracker.com">
                                    <img alt="GlobusTracker" src="views/images_ranktracker/Globustracker-logo-present.png" style="width:30%;margin-left:-1%;margin-top:.7%;">
                                </a>
                            </td>
                            <td style="width:5%"> &nbsp;</td>
                        </tr>
                    </tbody>
                </table>
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#f5f5f5;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%;background:#f5f5f5"> &nbsp;</td>
                            <td>
                    <center>
                        <table width="95%" cellspacing="6" cellpadding="6" style="width:100%;margin:0;padding:0">
                            <tbody>
                                <tr>
                                    <td style="padding:0 5px 0px 0px">
                                        <h3 align="left">Hi,&nbsp;<s:property value="data.get('name')"/></h3>
                                        <p align="left">
                                            You have requested your mail ID & Password information.<br><br> <span style="background:#e8e8e8;display:block;padding:5px 10px;margin-bottom:8px;border:1px solid #dedede"><b>Your Registration Email ID : </b><s:property value="data.get('username')"/><br></span><span style="background:#e8e8e8;display:block;padding:5px 10px;margin-bottom:8px;border:1px solid #dedede"><b>Your Password : </b> <s:property value="data.get('password')"/></span><br><br>
                                            Best Regards,<br>
                                            The GlobusTracker Team<br>
                                        </p>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </center>
                    </td>
                    <td style="width:5%;background:#f5f5f5"> &nbsp;</td>
                    </tr>
                    </tbody>
                </table>
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#e8e8e8;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%;background:#e8e8e8"> &nbsp;</td>
                            <td style="width:90%;background:#e8e8e8">
                                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#e8e8e8;padding:10px;width:100%">
                                    <tbody>
                                        <tr>
                                            <td width="80%" align="left">
                                                &copy; 2014. All Rights Reserved. <a href="http://www.globustracker.com">GlobusTracker</a>.
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                            <td style="width:5%;background:#e8e8e8"> &nbsp;</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </s:if>

        <s:if test="%{mailType == 3}">

            <div style="width:90%;margin-left:5%;margin-top:4%;">
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#000;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%"> &nbsp;</td>
                            <td>
                                <a target="_blank" href="http://www.globustracker.com">
                                    <img alt="GlobusTracker" src="views/images_ranktracker/Globustracker-logo-present.png" style="width:30%;margin-left:-1%;margin-top:.7%;">
                                </a>
                            </td>
                            <td style="width:5%"> &nbsp;</td>
                        </tr>
                    </tbody>
                </table>
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#f5f5f5;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%;background:#f5f5f5"> &nbsp;</td>
                            <td>
                    <center>
                        <table width="95%" cellspacing="6" cellpadding="6" style="width:100%;margin:0;padding:0">
                            <tbody>
                                <tr>
                                    <td style="padding:0 5px 0px 0px">
                                        <h3 align="left">Hi,&nbsp;<s:property value="data.get('name')"/></h3>
                                        <p align="left">
                                            Your password has been changed successfully<br><br> <span style="background:#e8e8e8;display:block;padding:5px 10px;margin-bottom:8px;border:1px solid #dedede"><b>Your Registration Email ID : </b><s:property value="data.get('username')"/></span><span style="background:#e8e8e8;display:block;padding:5px 10px;margin-bottom:8px;border:1px solid #dedede"><b>Your Password : </b> <s:property value="data.get('password')"/></span><br><br>
                                            Best Regards,<br>
                                            The GlobusTracker Team<br>
                                        </p>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </center>
                    </td>
                    <td style="width:5%;background:#f5f5f5"> &nbsp;</td>
                    </tr>
                    </tbody>
                </table>
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#e8e8e8;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%;background:#e8e8e8"> &nbsp;</td>
                            <td style="width:90%;background:#e8e8e8">
                                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#e8e8e8;padding:10px;width:100%">
                                    <tbody>
                                        <tr>
                                            <td width="80%" align="left">
                                                &copy; 2014. All Rights Reserved. <a href="http://www.globustracker.com">GlobusTracker</a>.
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                            <td style="width:5%;background:#e8e8e8"> &nbsp;</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </s:if>

        <s:if test="%{mailType == 4}">
            <div style="width:90%;margin-left:5%;margin-top:4%;">
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#000;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%">&nbsp; </td>
                            <td>
                                <a target="_blank" href="http://www.globustracker.com">
                                    <img alt="GlobusTracker" src="views/images_ranktracker/Globustracker-logo-present.png" style="width:30%;margin-left:-1%;margin-top:.7%;">
                                </a>
                            </td>
                            <td style="width:5%">&nbsp; </td>
                        </tr>
                    </tbody>
                </table>
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#f5f5f5;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%;background:#f5f5f5">&nbsp; </td>
                            <td>
                    <center>
                        <table width="95%" cellspacing="6" cellpadding="6" style="width:100%;margin:0;padding:0">
                            <tbody>
                                <tr>
                                    <td style="padding:0 5px 0px 0px">
                                        <h3 align="left">GlobusTracker's ContactUs mail</h3>
                                        <p align="left">
                                            Customer's Feedback,<br><br> <span style="background:#e8e8e8;display:block;padding:5px 10px;margin-bottom:8px;border:1px solid #dedede"><b>Name : </b><s:property value="data.get('name')"/><br></span><span style="background:#e8e8e8;display:block;padding:5px 10px;margin-bottom:8px;border:1px solid #dedede"><b>Email ID : </b><a target="_blank" href="mailto:<s:property value="data.get('email')"/>"><s:property value="data.get('email')"/></a><br></span><span style="background:#e8e8e8;display:block;padding:5px 10px;margin-bottom:8px;border:1px solid #dedede"><b>Member : </b> <s:property value="data.get('member')"/><br></span><span style="background:#e8e8e8;display:block;padding:5px 10px;margin-bottom:8px;border:1px solid #dedede"><b>Message : </b><s:property value="data.get('message')"/></span><br><br>
                                            Best Regards,<br>
                                            The GlobusTracker Team<br>
                                        </p>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </center>
                    </td>
                    <td style="width:5%;background:#f5f5f5">&nbsp; </td>
                    </tr>
                    </tbody>
                </table>
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#e8e8e8;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%;background:#e8e8e8">&nbsp; </td>
                            <td style="width:90%;background:#e8e8e8">
                                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#e8e8e8;padding:10px;width:100%">
                                    <tbody>
                                        <tr>
                                            <td width="80%" align="left">
                                                &copy; 2014. All Rights Reserved. <a href="http://www.globustracker.com">GlobusTracker</a>.
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                            <td style="width:5%;background:#e8e8e8">&nbsp; </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </s:if>    

        <s:if test="%{mailType == 5}">
            <div style="width:90%;margin-left:5%;margin-top:4%;">
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#000;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%"> &nbsp;</td>
                            <td>
                                <a target="_blank" href="http://www.globustracker.com">
                                    <img alt="GlobusTracker" src="views/images_ranktracker/Globustracker-logo-present.png" style="width:30%;margin-left:-1%;margin-top:.7%;">
                                </a>
                            </td>
                            <td style="width:5%">&nbsp; </td>
                        </tr>
                    </tbody>
                </table>
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#f5f5f5;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%;background:#f5f5f5">&nbsp; </td>
                            <td>
                    <center>
                        <table width="95%" cellspacing="6" cellpadding="6" style="width:100%;margin:0;padding:0">
                            <tbody>
                                <tr>
                                    <td style="padding:0 5px 0px 0px">
                                        <h3 align="left">Hi,</h3>
                                        <p align="left">
                                            Please find requested report as attachment.<br><br> 
                                            Have a Nice day..!!<br><br>
                                            Best Regards,<br>
                                            The GlobusTracker Team.
                                        </p>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </center>
                    </td>
                    <td style="width:5%;background:#f5f5f5">&nbsp; </td>
                    </tr>
                    </tbody>
                </table>
                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#e8e8e8;padding:0;margin:0">
                    <tbody>
                        <tr>
                            <td style="width:5%;background:#e8e8e8">&nbsp; </td>
                            <td style="width:90%;background:#e8e8e8">
                                <table width="100%" cellspacing="0" cellpadding="0" border="0" style="background:#e8e8e8;padding:10px;width:100%">
                                    <tbody>
                                        <tr>
                                            <td width="80%" align="left">
                                                &copy; 2014. All Rights Reserved. <a href="http://www.globustracker.com">GlobusTracker</a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                            <td style="width:5%;background:#e8e8e8">&nbsp; </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </s:if>
    </body>
</html>