<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    if (null == session.getAttribute("customerID")) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.sendRedirect("home.action");
    }
%> 
<link rel="stylesheet" type="text/css" href="http://www.highcharts.com/highslide/highslide.css" />
<style>
    ul.dropdownlist
    { 
        float: left;
        height: auto;
        padding: 0;
        position: relative;
        width: 350px; 
        background: #fff;
    }

    #keypopup {
        border: 1px solid #dfdfdf;
        font-family: "Trebuchet MS",Arial,Helvetica,sans-serif;
        width: 76.4%;
    }

    #keypopup td {
        color: #333;
        cursor: pointer;
    }

    #keypopup td:hover {
        background: none repeat scroll 0 0 #ccc;
    }
</style>

<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i> 
            GlobusTracker
            <span>> 
                Serps Campaign : <s:property value="campaignName" />
            </span>
        </h1>
    </div>
</div>

<div id="fade_away" style="color:#FF0000;">
    <s:actionmessage />
</div>
<!-- widget grid -->
<section id="widget-grid" class="">

    <!-- START ROW -->
    <div class="row">

        <!-- NEW COL START -->
        <article class="col-sm-12 col-md-12 col-lg-12">

            <!-- Widget ID (each widget will need unique ID)-->
            <div class="jarviswidget" id="wid-id-0" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
                <!-- widget options:
                usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

                data-widget-colorbutton="false"
                data-widget-editbutton="false"
                data-widget-togglebutton="false"
                data-widget-deletebutton="false"
                data-widget-fullscreenbutton="false"
                data-widget-custombutton="false"
                data-widget-collapsed="true"
                data-widget-sortable="false"

                -->
                <header>
                    <span class="widget-icon"> <i class="fa fa-clock-o"></i> </span>
                    <h2>Keywords Up</h2>
                </header>

                <s:if test="%{getRankComparision().isEmpty()}"> 

                </s:if>
                <s:else>
                    <!-- widget div-->
                    <div>
                        <!-- start row -->
                        <div class="row">

                            <div class="col-sm-12 col-md-12 col-lg-12">

                                <div class="well">

                                    <div class="row">
                                        <s:iterator value="rankComparision">
                                            <div class="col-md-offset-1 col-sm-2">

                                                <div class="well well-sm bg-color-teal txt-color-white text-center">
                                                    <h5>Top 5</h5>
                                                    <code><s:property value="keywordsRankBelow5" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="well well-sm bg-color-pinkDark txt-color-white text-center">
                                                    <h5>Top 10</h5>
                                                    <code><s:property value="keywordsRankBelow10" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="well well-sm text-center">
                                                    <h5>Top 20</h5>
                                                    <code><s:property value="keywordsRankBelow20" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="well well-sm bg-color-pinkDark txt-color-white text-center">
                                                    <h5>Top 30</h5>
                                                    <code><s:property value="keywordsRankBelow30" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>

                                            <div class="col-sm-2">

                                                <div class="well well-sm bg-color-teal txt-color-white text-center">
                                                    <h5>Top 100</h5>
                                                    <code><s:property value="keywordsRankBelow100" />/<s:property value="totalkeywords" /></code>
                                                    <h5>vs: 0 change: +</h5>
                                                </div>

                                            </div>
                                        </s:iterator>

                                    </div>

                                </div>

                            </div>

                        </div>
                        <!-- end row -->

                    </div>
                    <!-- end widget div -->
                </s:else>

            </div>
            <!-- end widget -->

        </article>
        <!-- END COL -->

    </div>
    <!-- row -->

    <div class="row">

        <!-- NEW WIDGET START -->
        <article class="col-sm-12 col-md-12 col-lg-12">

            <!-- Widget ID (each widget will need unique ID)-->
            <div class="jarviswidget" id="wid-id-0" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
                <!-- widget options:
                usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

                data-widget-colorbutton="false"
                data-widget-editbutton="false"
                data-widget-togglebutton="false"
                data-widget-deletebutton="false"
                data-widget-fullscreenbutton="false"
                data-widget-custombutton="false"
                data-widget-collapsed="true"
                data-widget-sortable="false"

                -->

                <header>
                    <ul class="nav nav-tabs pull-left in">

                        <li class="active">
                            <a data-toggle="tab" href="#hr1"><span class="hidden-mobile hidden-tablet"> SERPS </span>  <i class="fa fa-lg fa-google-plus-square"></i> <i class="fa fa-lg fa-yahoo"></i> <i class="fa fa-lg fa-arrow-circle-o-down"></i></a>
                        </li>

                        <li>
                            <a data-toggle="tab" href="#hr2"><span class="hidden-mobile hidden-tablet"> SEO Data </span> </a>
                        </li>

                        <li>
                            <a data-toggle="tab" href="#hr3"><span class="hidden-mobile hidden-tablet"> SOCIAL <i class="fa fa-thumbs-up fa-fw"></i><i class="fa fa-pinterest-square fa-fw"></i><i class="fa fa-google-plus-square fa-fw"></i><i class="fa fa-linkedin-square fa-fw"></i><i class="fa fa-reddit-square fa-fw"></i></span> </a>
                        </li>

                    </ul>
                    <div class="widget-toolbar">
                        <div class="btn-group">
                            <button class="btn btn-xs dropdown-toggle btn-primary" data-toggle="modal" data-target="#addssurl">
                                + Add Social URL
                            </button>
                        </div>
                    </div>
                    <div class="widget-toolbar">
                        <div class="btn-group">
                            <button class="btn btn-xs dropdown-toggle btn-primary" data-toggle="dropdown">
                                + Add Keyword <i class="fa fa-caret-down"></i>
                            </button>
                            <ul class="dropdown-menu js-status-update pull-right">
                                <li>
                                    <a data-toggle="modal" data-target="#addsinglemodal">Single</a>
                                </li>
                                <li>
                                    <a data-toggle="modal" data-target="#addmulmodal">Multiple</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </header>

                <!-- starting div -->               
                <!-- widget div-->
                <div>

                    <!-- widget edit box -->
                    <div class="jarviswidget-editbox">
                        <!-- This area used as dropdown edit box -->

                    </div>
                    <!-- end widget edit box -->

                    <!-- widget content -->
                    <div class="widget-body">

                        <div class="tab-content">
                            <s:iterator value="lstDisplaysettings" status="temp">
                                <div class="tab-pane active" id="hr1">
                                    <ul class="nav nav-tabs">
                                        <s:if test="%{googletab == 1}">
                                            <li class="active">
                                                <a data-toggle="tab" href="#AA">GOOGLE</a>
                                            </li>
                                        </s:if>
                                        <s:else> 
                                        </s:else>
                                        <s:if test="%{yahootab == 1}">
                                            <li>
                                                <a data-toggle="tab" href="#BB">YAHOO</a>
                                            </li>
                                        </s:if>
                                        <s:else>
                                        </s:else>
                                        <s:if test="%{bingtab == 1}">
                                            <li>
                                                <a data-toggle="tab" href="#CC">BING</a>
                                            </li>
                                        </s:if>
                                        <s:else>
                                        </s:else>
                                    </ul>

                                    <div class="tabbable tabs-below">
                                        <div class="tab-content padding-10">

                                            <s:if test="%{googletab == 1}">                                           
                                                <div class="tab-pane active" id="AA">
                                                    <table class="table table-bordered table-condensed">
                                                        <thead>
                                                            <tr>
                                                                <th style="text-align: center;">Url <a href="javascript:drawComparisionChart('<s:property value="campaignID"/>','30','google');" id="google_comparision_chart"></a></th>
                                                                <th style="text-align: center;">Keyword</th>
                                                                <th style="text-align: center;">Page Rank</th>
                                                                <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/google_icon.png" style="border:none;" width="20" height="20" alt="" /></th>
                                                                <th style="text-align: center;">Best Match Rank</th>
                                                                <s:if test="%{daychangetab == 1}">
                                                                    <th style="text-align: center;">Day</th>
                                                                </s:if>
                                                                <s:if test="%{weekchangetab == 1}">
                                                                    <th style="text-align: center;">Week</th>
                                                                </s:if>       
                                                                <s:if test="%{monthchangetab == 1}">
                                                                    <th style="text-align: center;">Month</th>
                                                                </s:if>
                                                                <th style="text-align: center;">Last Updated</th>
                                                                <th style="text-align: center;">Chart</th>
                                                                <th style="text-align: center;">Edit</th>                                                
                                                                <th style="text-align: center;">Delete</th>   
                                                            </tr>
                                                        </thead>
                                                        <tbody id="googleSerpsBody">

                                                        </tbody>
                                                    </table>
                                                </div>
                                            </s:if>

                                            <s:if test="%{yahootab == 1}">
                                                <div class="tab-pane" id="BB">
                                                    <table class="table table-bordered table-condensed">
                                                        <thead>
                                                            <tr>
                                                                <th style="text-align: center;">Url <a href="javascript:drawComparisionChart('<s:property value="campaignID"/>','30','yahoo');" id="google_comparision_chart"></a></th>
                                                                <th style="text-align: center;">Keyword</th>
                                                                <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/yahooicon.png" width="20" height="20" alt="" /></th>
                                                                <th style="text-align: center;">Best Match Rank</th>
                                                                <s:if test="%{daychangetab == 1}">
                                                                    <th style="text-align: center;">Day</th>
                                                                </s:if>
                                                                <s:if test="%{weekchangetab == 1}">
                                                                    <th style="text-align: center;">Week</th>
                                                                </s:if>       
                                                                <s:if test="%{monthchangetab == 1}">
                                                                    <th style="text-align: center;">Month</th>
                                                                </s:if>
                                                                <th style="text-align: center;">Last Updated</th>
                                                                <th style="text-align: center;">Chart</th>
                                                                <th style="text-align: center;">Edit</th>                                                
                                                                <th style="text-align: center;">Delete</th>       
                                                            </tr>
                                                        </thead>
                                                        <tbody id="yahooSerpsBody">

                                                        </tbody>
                                                    </table>
                                                </div>
                                            </s:if>

                                            <s:if test="%{bingtab == 1}">
                                                <div class="tab-pane" id="CC">
                                                    <table class="table table-bordered table-condensed">
                                                        <thead>
                                                            <tr>
                                                                <th style="text-align: center;">Url <a href="javascript:drawComparisionChart('<s:property value="campaignID"/>','30','bing');" id="google_comparision_chart"></a></th>
                                                                <th style="text-align: center;">Keyword</th>
                                                                <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/bingicon.png" width="20" height="20" alt="" /></th>
                                                                <th style="text-align: center;">Best Match Rank</th>
                                                                <s:if test="%{daychangetab == 1}">
                                                                    <th style="text-align: center;">Day</th>
                                                                </s:if>
                                                                <s:if test="%{weekchangetab == 1}">
                                                                    <th style="text-align: center;">Week</th>
                                                                </s:if>       
                                                                <s:if test="%{monthchangetab == 1}">
                                                                    <th style="text-align: center;">Month</th>
                                                                </s:if>
                                                                <th style="text-align: center;">Last Updated</th>
                                                                <th style="text-align: center;">Chart</th>
                                                                <th style="text-align: center;">Edit</th>                                                
                                                                <th style="text-align: center;">Delete</th>    
                                                            </tr>
                                                        </thead>
                                                        <tbody id="bingSerpsBody">

                                                        </tbody>
                                                    </table>
                                                </div>
                                            </s:if>
                                        </div>
                                    </div>                                                                                  
                                </div>                                

                                <div class="tab-pane" id="hr2">
                                    <table class="table table-bordered table-condensed">
                                        <thead>
                                            <tr>
                                                <th style="text-align: center;">Url</th>
                                                <th style="text-align: center;">Keyword</th>
                                                <th style="text-align: center;">Search Volume</th>
                                                <th style="text-align: center;">CPC</th>
                                                <th style="text-align: center;">Competition</th>
                                                <th style="text-align: center;">Number of Results</th>
                                                <th style="text-align: center;" title="Site Indexing">SI</th>
                                                <s:if test="%{alexatab == 1}">
                                                    <th style="text-align: center;" title="Alexa Ranking">Alexa</th>
                                                </s:if>
                                                <s:if test="%{backlinkstab == 1}">
                                                    <th style="text-align: center;" title="Backlinks">BL</th>
                                                </s:if>
                                                <s:if test="%{monthlysearchstab == 1}">
                                                    <th style="text-align: center;" title="Monthly Searches">MS</th>
                                                </s:if>
                                                <th style="text-align: center;" title="Page Authority">PA</th>
                                                <th style="text-align: center;" title="Domain Authority">DA</th>
                                            </tr>
                                        </thead>
                                        <tbody id="seoKeywordsBody">

                                        </tbody>
                                    </table>
                                </div>

                                <div class="tab-pane" id="hr3">
                                    <table class="table table-bordered table-condensed">
                                        <thead>
                                            <tr>
                                                <th style="text-align: center;">Url</th>
                                                <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/fb_likes.png" style="border:none;" width="24" height="24" alt="" /></th>
                                                <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/fb_share.png" style="border:none;" width="70" height="24" alt="" /></th>
                                                <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/twt_count.png" style="border:none;" width="24" height="24" alt="" /></th>
                                                <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/pintrest.png" style="border:none;" width="24" height="24" alt="" /></th>
                                                <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/google_plus.png" style="border:none;" width="24" height="24" alt="" /></th>
                                                <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/linkedin.png" style="border:none;" width="24" height="24" alt="" /></th>
                                                <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/reddit.png" style="border:none;" width="24" height="24" alt="" /></th>
                                                <th style="text-align: center;"><img src="https://s3.amazonaws.com/images_ranktracker/stumbleupon.png" style="border:none;" width="24" height="24" alt="" /></th>
                                                <th style="text-align: center;">Chart</th>
                                                <th style="text-align: center;">Edit</th>                                                
                                                <th style="text-align: center;">Delete</th>   
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="lstsocialsignalupdate">
                                                <tr>
                                                    <td title="<s:property value="socialSignalUrl" />"><s:property value="socialSignalUrl" /></td>
                                                    <td style="text-align: center;"><s:property value="facebookLike" /></td>
                                                    <td style="text-align: center;"><s:property value="facebookShare" /></td>
                                                    <td style="text-align: center;"><s:property value="tweetCount" /></td>
                                                    <td style="text-align: center;"><s:property value="pinterestPins" /></td>
                                                    <td style="text-align: center;"><s:property value="googlePlusLikes" /></td>
                                                    <td style="text-align: center;"><s:property value="linkedInShares" /></td>
                                                    <td style="text-align: center;"><s:property value="redittVotes" /></td>
                                                    <td style="text-align: center;"><s:property value="stumbleUponLikes" /></td>
                                                    <td style="text-align: center;"><a href="javascript:drawSocialChart('<s:property value="SocialSignalUrlID"/>','30');" id="social_chart" title="Chart"><i class="fa fa-2x fa-bar-chart-o" data-toggle="modal" data-target="#socialchartmodal"></i></a></td>
                                                    <td style="text-align: center;"><a href="javascript:editUrl('<s:property value="SocialSignalUrlID" />', '<s:property value="SocialSignalUrl" />');" id="editssurl" title="Edit"><i class="fa fa-pencil fa-2x txt-color-yellow" data-toggle="modal" data-target="#editssurlmodal"></i></a></td>
                                                    <td style="text-align: center;"><a href="javascript:deleteUrl(<s:property value="SocialSignalUrlID"/>);" title="Delete"><i class="fa fa-trash-o fa-2x" data-toggle="modal" data-target="#deletessurlmodal"></i></a></td>
                                                </tr>
                                            </s:iterator>   

                                        </tbody>
                                    </table>
                                </div>

                            </s:iterator>
                        </div>
                    </div>
                </div>

            </div>
            <!-- end widget -->

        </article>
        <!-- WIDGET END -->

    </div>
    <!-- end row -->

    <!--edit Modal -->
    <s:form action="" onsubmit="return false;" id="editForm">
        <div class="modal fade" id="editmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Edit Keyword!</h4>
                    </div>
                    <div class="modal-body">
                        <!-- widget content -->
                        <div class="widget-body no-padding">

                            <div  class="smart-form">
                                <fieldset>					
                                    <div class="row">
                                        <s:hidden name="keywordId" id="keywordId" />
                                        <section class="col col-6">
                                            <label class="label">URL</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-user"></i>
                                                <input type="text" name="url" id="editurl" placeholder="http://example.com">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="label">Google_Link</label>
                                            <label class="select">
                                                <select id="linkGoogleedit" name="linkGoogle">
                                                    <option value="google.com" selected>google.com</option>
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
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <span style="color: black; font-size: 13px;">Keyword</span>
                                            <span style="margin-left: 68px;  font-size: 13px;">
                                                <input type="checkbox" name="editcheck" id="editcheckbox">
                                                Keyword Suggestion
                                            </span>
                                            <label class="input">
                                                <i class="icon-append fa fa-comment"></i>
                                                <input type="text" name="keyword" id="editkeyword" onkeyup="editfilterChanged();">
                                                <ul class="dropdownlist" style="display: block;">
                                                    <table id="keypopup">
                                                        <tbody id="editpeoplebody" >
                                                        </tbody>
                                                    </table>
                                                </ul>
                                            </label>
                                        </section>
                                    </div>			

                                </fieldset>    
                            </div>
                        </div>
                        <!-- end widget content -->
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="return editSerpsKeyword();">Edit Keyword</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>    
    <!--end of model-->

    <!--Add Single Modal -->
    <s:form action="" onsubmit="return false;" id="addForm">
        <div class="modal fade" id="addsinglemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Add Single !</h4>
                    </div>
                    <div class="modal-body">
                        <!-- widget content -->
                        <div class="widget-body no-padding">

                            <div  class="smart-form">

                                <fieldset>					
                                    <div class="row">
                                        <section class="col col-6">
                                            <label class="label">URL</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-user"></i>
                                                <input type="text" name="url" id="addurl" placeholder="http://example.com">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="label">Google_Link</label>
                                            <label class="select">
                                                <select id="linkGoogle" name="linkGoogle">
                                                    <option value="google.com" selected>google.com</option>
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

                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <span style="color: black; font-size: 13px;">Keyword</span>
                                            <span style="margin-left: 68px;  font-size: 13px;">
                                                <input type="checkbox" name="check" id="checkbox"/>
                                                Keyword Suggestion
                                            </span>
                                            <label class="input">
                                                <i class="icon-append fa fa-comment"></i>
                                                <input type="text" name="keywords" id="addkeyword" onkeyup="filterChanged();"/>
                                                <ul class="dropdownlist" style="display: block;">
                                                    <table id="keypopup">
                                                        <tbody id="peoplebody" >
                                                        </tbody>
                                                    </table>
                                                </ul>
                                            </label>
                                        </section>
                                    </div>			
                                </fieldset>
                            </div>                   			
                        </div>
                        <!-- end widget content -->
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="return addSerpsKeyword();">Add Keyword</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of addsingle model-->

    <!--Add Multiple Modal -->
    <s:form action="" onsubmit="return false;" id="addForm">
        <div class="modal fade" id="addmulmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Add Multiple !</h4>
                    </div>
                    <div class="modal-body">
                        <!-- widget content -->
                        <div class="widget-body no-padding">

                            <div  class="smart-form">
                                <fieldset>					
                                    <div class="row">
                                        <section class="col col-6">
                                            <label class="label">URL</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-user"></i>
                                                <input type="text" name="url" id="addurls" placeholder="http://example.com">
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="label">Google_Link</label>
                                            <label class="select">
                                                <select id="linkGoogles" name="linkGoogle">
                                                    <option value="google.com" selected>google.com</option>
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
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <span style="color: black; font-size: 13px;">Keyword</span>
                                            <span style="margin-left: 68px;  font-size: 13px;">
                                                <input type="checkbox" name="checks" id="checkboxs"/>
                                                Keyword Suggestion
                                            </span>
                                            <label class="textarea">
                                                <textarea rows="4" cols="5" name="keywords" id="addkeywords" onkeyup="filterChangeds();"></textarea>
                                                <ul class="dropdownlist"  style="display: block;">
                                                    <table id="keypopup">
                                                        <tbody id="peoplebodys" >
                                                        </tbody>
                                                    </table>
                                                </ul>
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <p>Note: New line character(Shift+Enter) should be given after each keyword</p>
                                        </section>
                                    </div>			
                                </fieldset>
                            </div>          				
                        </div>
                        <!-- end widget content -->
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="return addSerpsKeywords();">Add Keyword</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of addmul model-->

    <!--delete Modal -->
    <s:form action="" id="deleteForm" onsubmit="return false;">
        <div class="modal fade" id="deletemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Delete !</h4>
                    </div>
                    <div class="modal-body">
                        <h4>Are you sure, you want to delete this? Lost logs cannot be retrieved again.</h4>
                        <input class="form-control" type="hidden" name="keywordId" id="keywordId" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default btn-danger" onclick="deleteSerpsKeyword();">Yes</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of model-->

    <!--Add ssurl Modal -->
    <s:form action="" onsubmit="return false;" id="addUrlForm">       
        <div class="modal fade" id="addssurl" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Add URL!</h4>
                    </div>
                    <div class="modal-body">
                        <!-- widget content -->
                        <div class="widget-body no-padding">

                            <div  class="smart-form">

                                <fieldset>					
                                    <div class="row">
                                        <section class="col col-6">
                                            <label class="label">URL</label>
                                            <label class="input">
                                                <i class="icon-append fa fa-user"></i>
                                                <input type="text" name="url" id="addsocialurl" placeholder="http://example.com">
                                            </label>
                                        </section>
                                    </div>			
                                </fieldset>
                            </div>                   			
                        </div>
                        <!-- end widget content -->
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="return addSocialSignalUrl();">Add Url</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of addssurl model-->

    <!--Edit ssurl Modal -->
    <s:form action="" onsubmit="return false;" id="editUrlForm">  
        <div class="modal fade" id="editssurlmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Edit URL!</h4>
                    </div>
                    <div class="modal-body">
                        <!-- widget content -->
                        <div class="widget-body no-padding">

                            <div  class="smart-form">

                                <fieldset>					
                                    <div class="row">
                                        <section class="col col-6">
                                            <label class="label">URL</label>
                                            <label class="input">
                                                <s:hidden name="urlId" id="urlId" />
                                                <input type="text" name="url" id="editsocialsignalurl" placeholder="http://example.com">
                                            </label>
                                        </section>
                                    </div>			
                                </fieldset>
                            </div>                   			
                        </div>
                        <!-- end widget content -->
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info " onclick="return editSocialSignalUrl();">Edit Url</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of editssurl model-->

    <!--deletessurl Modal -->
    <s:form action="" id="deleteUrlForm" onsubmit="return false;">
        <div class="modal fade" id="deletessurlmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Delete !</h4>
                    </div>
                    <div class="modal-body">
                        <h4>Are you sure, you want to delete this? Lost logs cannot be retrieved again.</h4>
                        <input class="form-control" type="hidden" name="urlId" id="urlId" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default btn-danger" onclick="deleteSocialSignalUrl();">Yes</button>
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </s:form>
    <!--end of deletessurl model-->

    <!--chart Modal -->
    <div class="modal fade" id="chartmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
        <div class="modal-dialog" style="width: 1200px;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">Chart !</h4>
                </div>
                <div class="modal-body">
                    <div id="chartBlock">
                    </div> 	
                </div>
                <div class="modal-footer">

                </div>
            </div>
        </div>
    </div>
    <!--end of model-->

    <!--social chart Modal -->
    <div class="modal fade" id="socialchartmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
        <div class="modal-dialog" style="width: 1200px;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">Chart !</h4>
                </div>
                <div class="modal-body">
                    <div id="socialChartBlock">
                    </div> 	
                </div>
                <div class="modal-footer">

                </div>
            </div>
        </div>
    </div>
    <!--end of model-->

</section>
<!-- end widget grid -->

<!--script for keyword suggestion-->
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/interface/Keywordsuggestion.js'></script>
<script type="text/javascript">
    function filterChanged() {
        if (document.getElementById("checkbox").checked) {
            dwr.util.removeAllRows("peoplebody");
            var addkeywords = dwr.util.getValue("addkeyword");
            if (addkeywords.length === 0) {
                dwr.util.removeAllRows("peoplebody");
            } else {
                Keywordsuggestion.getMatchingforKeywords(addkeywords, fillTable);
            }
        }
        else {
            dwr.util.removeAllRows("peoplebody");
        }
    }
    function fillTable(people) {
        var addkeywords = dwr.util.getValue("addkeyword");
        var filtered = [];
        dwr.util.removeAllRows("peoplebody");
        for (i = 0; i < people.length; i++) {
            filtered.push(people[i]);
        }
        if (filtered.length !== 0) {
            dwr.util.addRows("peoplebody", filtered, [
                function(element) {
                    return element;
                }
            ], {escapeHtml: false});
        }
    }
    function filterChangeds() {
        if (document.getElementById("checkboxs").checked) {
            dwr.util.removeAllRows("peoplebodys");
            var addkeywords = dwr.util.getValue("addkeywords");
            if (addkeywords.length === 0) {
                dwr.util.removeAllRows("peoplebodys");
            } else {
                Keywordsuggestion.getMatchingforKeywords(addkeywords, fillTables);
            }
        }
        else {
            dwr.util.removeAllRows("peoplebodys");
        }
    }
    function fillTables(people) {
        var addkeywords = dwr.util.getValue("addkeywords");
        var pattern = new RegExp("(" + addkeywords + ")", "i");
        var filtered = [];
        dwr.util.removeAllRows("peoplebodys");
        for (i = 0; i < people.length; i++) {
            filtered.push(people[i]);
        }
        if (filtered.length !== 0) {
            dwr.util.addRows("peoplebodys", filtered, [
                function(element) {
                    return  element;
                }
            ], {escapeHtml: false});
        }
    }
    function editfilterChanged() {
        if (document.getElementById("editcheckbox").checked) {
            var addkeywords = dwr.util.getValue("editkeyword");
            if (addkeywords.length === 0) {
                dwr.util.removeAllRows("editpeoplebody");
            } else {
                Keywordsuggestion.getMatchingforKeywords(addkeywords, editfillTable);
            }
        }
        else {
            dwr.util.removeAllRows("editpeoplebody");
        }
    }
    function editfillTable(people) {
        var addkeywords = dwr.util.getValue("editkeyword");
        var filtered = [];
        dwr.util.removeAllRows("editpeoplebody");
        for (i = 0; i < people.length; i++) {
            filtered.push(people[i]);
        }
        if (filtered.length !== 0) {
            dwr.util.addRows("editpeoplebody", filtered, [
                function(element) {
                    return element;
                }
            ], {escapeHtml: false});
        }
    }
    function getEventTarget(e) {
        e = e || window.event;
        return e.target || e.srcElement;
    }
    var ul = document.getElementById('peoplebody');
    ul.onclick = function(event) {
        var target = getEventTarget(event);
        document.getElementById("addkeyword").value = target.innerHTML;
        dwr.util.removeAllRows("peoplebody");
    };
    var ul1 = document.getElementById('peoplebodys');
    ul1.onclick = function(event) {
        var target = getEventTarget(event);
        var addkeywords = dwr.util.getValue("addkeywords");
        var res = [];
        res = addkeywords.split("\n");
        var lst = [];
        for (i = 0; i < ((res.length) - 1); i++) {
            lst.push(res[i]);
        }
        var old = lst.toString();
        while (old.indexOf(',') != -1) {
            old = old.replace(',', '\n');
        }
        if (lst == "")
        {
            document.getElementById("addkeywords").value = target.innerHTML;
            dwr.util.removeAllRows("peoplebodys");
        }
        else {
            document.getElementById("addkeywords").value = old + "\n" + target.innerHTML;
            dwr.util.removeAllRows("peoplebodys");
        }
        dwr.util.removeAllRows("peoplebodys");
    };
    var editul = document.getElementById('editpeoplebody');
    editul.onclick = function(event) {
        var target = getEventTarget(event);
        document.getElementById("editkeyword").value = target.innerHTML;
        dwr.util.removeAllRows("editpeoplebody");
    };
</script>
<!--script for keyword suggestion-->

<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="https://s3.amazonaws.com/js_ranktracker/highcharts.js"></script>
<script src="https://s3.amazonaws.com/js_ranktracker/exporting.js"></script>
<script type="text/javascript" src="http://www.highcharts.com/highslide/highslide-full.min.js"></script>
<script type="text/javascript" src="http://www.highcharts.com/highslide/highslide.config.js" charset="utf-8"></script>

<script type="text/javascript">
    var opened = "0";
    var alertMes = "";
    function drawSocialChart(urlId, range) {
        var jString = "{\"urlId\":\"" + urlId + "\" , \"range\":\"" + range + "\"}";
        var chart;
        $.getJSON(
        'ajax/getSocialData.action',
        {
            jString: jString
        },
        function(jMap) {
            chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'socialChartBlock',
                    type: 'line',
                    marginRight: 130,
                    marginBottom: 25,
                    width: 1100,
                    height: 200
                },
                title: jMap.dataMap.title,
                subtitle: {
                    text: '',
                    x: -20
                },
                credits: {
                    enabled: false
                    // text: 'globustracker.com',
                    // href: 'http://www.globustracker.com/'
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
    }

    function drawChart(keywordId, range) {
        var jString = "{\"keywordId\":\"" + keywordId + "\" , \"range\":\"" + range + "\"}";
        var chart;
        $.getJSON(
        'ajax/getData.action',
        {
            jString: jString
        },
        function(jMap) {
            chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'chartBlock',
                    type: 'line',
                    marginRight: 130,
                    marginBottom: 25,
                    width: 1100,
                    height: 200,
                    zoomType: 'x'
                },
                title: jMap.dataMap.title,
                subtitle: {
                    text: '',
                    x: -20
                },
                credits: {
                    enabled: false
                },
                xAxis: {
                    //categories: eval(jMap.dataMap.sbRange),
                    type: 'datetime',
                    dateTimeLabelFormats: {
                        day: '%b %e '
                    },
                    plotBands: eval(jMap.dataMap.gtEvent)
                },
                yAxis: {
                    title: {
                        text: 'Rankings'
                    },
                    allowDecimals: false,
                    reversed: true,
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
                //                                                                exporting: {
                //                                                                    buttons: {
                //                                                                        customButton: {
                //                                                                            x: -62,
                //                                                                            symbol: 'url(https://cdn1.iconfinder.com/data/icons/large-glossy-icons/20/Target.png)',
                //                                                                            symbolX: 7.5,
                //                                                                            symbolY: 6,
                //                                                                            onclick: function() {
                //                                                                                $("#myGoal").toggle();
                //                                                                                $("#goalkewordId").val(keywordId);
                //                                                                                $("#backgrd").attr("class", "modal-backdrop fade in");
                //                                                                            }
                //                                                                        }
                //                                                                    }
                //                                                                },
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
    }

    function drawComparisionChart(campaignId, range, engine) {
        var jString = "{\"campaignId\":\"" + campaignId + "\" , \"range\":\"" + range + "\" , \"engine\":\"" + engine + "\"}";
        var chart;
        $.getJSON(
        'ajax/getCampaignChartData.action',
        {
            jString: jString
        },
        function(jMap) {
            chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'chartBlock',
                    type: 'line',
                    marginRight: 130,
                    marginBottom: 25,
                    width: 1100,
                    height: 200,
                    zoomType: 'x'
                },
                title: jMap.dataMap.title,
                subtitle: {
                    text: '',
                    x: -20
                },
                credits: {
                    enabled: false
                    //                    text: 'globustracker.com',
                    //                    href: 'http://www.globustracker.com/'
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
                    reversed: true,
                    min: 0,
                    tickPixelInterval: 20

                },
                tooltip: {
                    crosshairs: true,
                    shared: true
                },
                legend: {
                    layout: 'horizontal',
                    align: 'center',
                    verticalAlign: 'top',
                    // x: 55,
                    y: 0,
                    itemDistance: 14,
                    borderWidth: 0
                },
                series: eval(jMap.dataMap.sbData)
            });

        });
    }

    function addSerpsKeyword() {
        var keywords = $("#addkeyword").val();
        var url = $("#addurl").val();
        var linkGoogle = $("#linkGoogle").val();

        if ($("#addurl").val().trim().length === 0) {
            alert("Please enter URL");
            return false;
        }

        var pattern = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
        if (!pattern.test(url)) {
            alert("Url is not valid! Please enter the URL in correct format");
            return false;
        }

        if ($("#addkeyword").val().trim().length === 0) {
            alert("Please enter Keyword");
            return false;
        }
        //  var regexp=/^[a-zA-Z0-9_\d\s]+$/i;
        //  var validity=regexp.test(keywords);
        //  if (!validity) {
        //      alert("Keyword can have alphanumeric character and special character '_' ");
        //      return false;
        //  }

        $.post(
        'ajax/addSerpsKeyword.action',
        {
            arrKeywords: keywords,
            url: url,
            linkGoogle: linkGoogle
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "serpskeywords.action";
        },
        'json');
    }

    function addSerpsKeywords() {
        var keywords = $("#addkeywords").val();
        var url = $("#addurls").val();
        var linkGoogle = $("#linkGoogles").val();

        if ($("#addurls").val().trim().length === 0) {
            alert("Please enter URL");
            return false;
        }

        var pattern = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
        if (!pattern.test(url)) {
            alert("Url is not valid! Please enter the URL in correct format");
            return false;
        }

        if ($("#addkeywords").val().trim().length === 0) {
            alert("Please enter Keyword");
            return false;
        }
        //  var regexp=/^[a-zA-Z0-9_\d\s]+$/i;

        //  var eachkeyword= keywords.split( "\n" );

        //  for( var i = 0; i < eachkeyword.length; ++i ) {
        //      var check = regexp.test(eachkeyword[ i ]); 
        //      if( !check ) {
        //          alert("Keyword can have alphanumeric character and special character '_' ");
        //          return false;
        //      }
        //  }

        $.post(
        'ajax/addSerpsKeyword.action',
        {
            arrKeywords: keywords,
            url: url,
            linkGoogle: linkGoogle
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "serpskeywords.action";
        },
        'json');
    }

    function addSocialSignalUrl()
    {
        var url = $("#addsocialurl").val();
        if ($("#addsocialurl").val().trim().length === 0) {
            alert("Please enter URL");
            return false;
        }

        var pattern = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
        if (!pattern.test(url)) {
            alert("Url is not valid! Please enter the URL in correct format");
            return false;
        }

        $.post(
        'ajax/addSocialSignalUrl.action',
        {
            addUrl: url
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "serpskeywords.action";
        },
        'json');
    }

    function editKeyword(keywordId, url, linkGoogle, keyword) {
        try {
            document.editForm.keywordId.value = keywordId;
            document.editForm.url.value = url;
            document.editForm.linkGoogle.value = linkGoogle;
            document.editForm.keyword.value = keyword;
        } catch (e)
        {
            alert(e);
        }

    }

    function editUrl(urlId, url) {
        try {
            url = "http://" + url;
            document.editUrlForm.urlId.value = urlId;
            document.editUrlForm.editsocialsignalurl.value = url;

        } catch (e)
        {
            alert(e);
        }
    }

    function editSerpsKeyword() {
        var ekeywordId = $("#keywordId").val();
        var editurl = $("#editurl").val();
        var linkGoogle = $("#linkGoogleedit").val();
        var ekeyword = $("#editkeyword").val();

        if ($("#editurl").val().trim().length === 0) {
            alert("Please enter Url");
            return false;
        }

        if ($("#editkeyword").val().trim().length === 0) {
            alert("Please enter Keyword");
            return false;
        }

        //   var regexp=/^[a-zA-Z0-9_\d\s]+$/i;
        //  var validity=regexp.test(ekeyword);
        //   if (!validity) {
        //       alert("Keyword can have alphanumeric character and special character '_' ");
        //       return false;
        //   }

        $.post(
        'ajax/editSerpsKeyword.action',
        {
            editkeywordId: ekeywordId,
            editarrKeywords: ekeyword,
            editurl: editurl,
            editlinkGoogle: linkGoogle
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "serpskeywords.action";
        },
        'json');
    }

    function editSocialSignalUrl() {
        var eurlId = $("#urlId").val();
        var eurl = $("#editsocialsignalurl").val();

        if ($("#editsocialsignalurl").val().trim().length === 0) {
            alert("Please enter Url");
            return false;
        }

        var pattern = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
        if (!pattern.test(eurl)) {
            alert("Url is not valid! Please enter the URL in correct format");
            return false;
        }

        $.post(
        'ajax/editSocialSignalUrl.action',
        {
            eurlId: eurlId,
            eurl: eurl
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "serpskeywords.action";
        },
        'json');
    }


</script>

<script type="text/javascript" src="https://s3.amazonaws.com/js_ranktracker/script.js"></script>
<script type="text/javascript">

    function deleteKeyword(keywordId)
    {
        try {
            document.deleteForm.keywordId.value = keywordId;
        } catch (e) {
            alert(e);
        }
    }
    function deleteSerpsKeyword() {
        var jString = document.deleteForm.keywordId.value;
        $.post(
        'ajax/deleteSerpsKeyword.action',
        {
            jString: jString
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "serpskeywords.action";
        },
        'json');
    }

    function deleteUrl(urlId)
    {
        try {
            document.deleteUrlForm.urlId.value = urlId;
        } catch (e) {
            alert(e);
        }
    }

    function deleteSocialSignalUrl() {
        var delurlId = document.deleteUrlForm.urlId.value;

        $.post(
        'ajax/deleteSocialSignalUrl.action',
        {
            delurlId: delurlId
        },
        function(jMessage) {
            alertMes = jMessage.message;
            window.location = "serpskeywords.action";
        },
        'json');
    }
</script>

<script type="text/javascript">

    var initial = 0;

    var campaignsID =<%=session.getAttribute("campaignId")%>;
    // alert(campaignsID);

    ajaxFunction();

    function ajaxFunction() {
        var ajaxRequest;  // The variable that makes Ajax possible!

        try {
            // Opera 8.0+, Firefox, Safari
            ajaxRequest = new XMLHttpRequest();

        } catch (e) {
            //                                    // Internet Explorer Browsers
            try {
                ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {
                    // Something went wrong
                    alert('Your browser broke!');

                }
            }
        }

        // Create a function that will receive data 
        // sent from the server and will update
        // div section in the same page.
        ajaxRequest.onreadystatechange = function() {
            if (ajaxRequest.readyState == 4) {
                //var ajaxDisplay = document.getElementById('ajaxDiv');
                //alert("hiii"+ajaxRequest.responseText)
                //ajaxDisplay.innerHTML = ajaxRequest.responseText;
                var result = ajaxRequest.responseText.toString();
                updategoogleSerpsBody(result);
                updateyahooSerpsBody(result);
                updatebingSerpsBody(result);
                updateseoKeywordsBody(result);
                initial += 50;

            }
        }
        // Now get the value from user and pass it to
        // server script.

        ajaxRequest.open("GET", "limitedserpskeywords.action?initial=" + initial + "&campaignId=" + campaignsID, false);
        ajaxRequest.send(null);

    }

    $(window).scroll(function() {

        if ($(window).scrollTop() + $(window).height() == $(document).height()) {
            ajaxFunction();
        }
    });

    //GoogleSerpsBody
    function updategoogleSerpsBody(result) {

        var output = JSON.parse(result);
        var htmlResult = "";
        var i = 0;

        for (i = 0; i < output.serpskeywords.length; i++) {

            htmlResult = htmlResult + "<tr>";
            htmlResult = htmlResult + "<td title='" + output.serpskeywords[i].Url + "'><a href='generateCrawledHistory.action?keywordId=" + output.serpskeywords[i].KeywordID + "' title='Google crawl history'><img src='https://s3.amazonaws.com/images_ranktracker/history.png' width='20' height='22' alt='' style='cursor:pointer;'  /></a>" + output.serpskeywords[i].Url + "</td>";
            htmlResult = htmlResult + "<td>" + output.serpskeywords[i].Keyword + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].GooglePageRank + "</td>";

            if ((output.serpskeywords[i].RankGoogle !== 0) || (output.serpskeywords[i].GoogleUpdatedDate == '-')) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankGoogle + "</td>";
            }
            else {
                htmlResult = htmlResult + "<td style='text-align: center;'>N/A</td>";
            }

            if ((output.serpskeywords[i].BestMatchRankGoogle !== 0) || (output.serpskeywords[i].GoogleUpdatedDate == '-')) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].BestMatchRankGoogle + "</td>";
            }
            else {
                htmlResult = htmlResult + "<td style='text-align: center;'>N/A</td>";
            }

            if (output.displaySettings.Daychangetab === 1) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankGoogleDayChange + "";

                if (output.serpskeywords[i].RankGoogleDayChange < 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
                }
                else if (output.serpskeywords[i].RankGoogleDayChange > 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
                }
                htmlResult = htmlResult + "</td>";
            }

            if (output.displaySettings.Weekchangetab === 1) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankGoogleWeekChange + "";

                if (output.serpskeywords[i].RankGoogleWeekChange < 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
                }
                else if (output.serpskeywords[i].RankGoogleWeekChange > 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
                }
                htmlResult = htmlResult + "</td>";
            }

            if (output.displaySettings.Monthchangetab === 1) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankGoogleMonthChange + "";

                if (output.serpskeywords[i].RankGoogleMonthChange < 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
                }
                else if (output.serpskeywords[i].RankGoogleMonthChange > 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
                }
                htmlResult = htmlResult + "</td>";
            }

            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].GoogleUpdatedDate + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'><a href=\"javascript:drawChart(" + output.serpskeywords[i].KeywordID + ",30);\" id='google_chart' title='Chart'><i class='fa fa-2x fa-bar-chart-o' data-toggle='modal' data-target='#chartmodal'></i></a></td>";
            htmlResult = htmlResult + "<td style='text-align: center;'><a  href='#' id='edit' onclick=\"editKeyword(" + output.serpskeywords[i].KeywordID + ", '" + output.serpskeywords[i].Url + "', '" + output.serpskeywords[i].LinkGoogle + "', '" + output.serpskeywords[i].Keyword + "');\" title='Edit'><i class='fa fa-pencil fa-2x txt-color-yellow' data-toggle='modal' data-target='#editmodal'></i></a></td>";
            htmlResult = htmlResult + "<td style='text-align: center;'><a href='#' id='delete' title='Delete' onclick='deleteKeyword(" + output.serpskeywords[i].KeywordID + ");' ><i class='fa fa-trash-o fa-2x' data-toggle='modal' data-target='#deletemodal'></i></a></td>";
            htmlResult = htmlResult + "<tr>";
        }

        document.getElementById('googleSerpsBody').innerHTML = document.getElementById('googleSerpsBody').innerHTML + htmlResult;
    }

    //YahooSerpsBody
    function updateyahooSerpsBody(result) {

        var output = JSON.parse(result);
        var htmlResult = "";
        var i = 0;

        for (i = 0; i < output.serpskeywords.length; i++) {

            htmlResult = htmlResult + "<tr>";
            htmlResult = htmlResult + "<td title='" + output.serpskeywords[i].Url + "'>" + output.serpskeywords[i].Url + "</td>";
            htmlResult = htmlResult + "<td>" + output.serpskeywords[i].Keyword + "</td>";

            if ((output.serpskeywords[i].RankYahoo !== 0) || (output.serpskeywords[i].YahooUpdateDate == '-')) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahoo + "</td>";
            }
            else {
                htmlResult = htmlResult + "<td style='text-align: center;'>N/A</td>";
            }

            if ((output.serpskeywords[i].BestMatchRankYahoo !== 0) || (output.serpskeywords[i].YahooUpdateDate == '-')) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].BestMatchRankYahoo + "</td>";
            }
            else {
                htmlResult = htmlResult + "<td style='text-align: center;'>N/A</td>";
            }

            if (output.displaySettings.Daychangetab === 1) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahooDayChange + "";

                if (output.serpskeywords[i].RankYahooDayChange < 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
                }
                else if (output.serpskeywords[i].RankYahooDayChange > 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
                }
                htmlResult = htmlResult + "</td>";
            }

            if (output.displaySettings.Weekchangetab === 1) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahooWeekChange + "";

                if (output.serpskeywords[i].RankYahooWeekChange < 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
                }
                else if (output.serpskeywords[i].RankYahooWeekChange > 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
                }
                htmlResult = htmlResult + "</td>";
            }

            if (output.displaySettings.Monthchangetab === 1) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahooMonthChange + "";

                if (output.serpskeywords[i].RankYahooMonthChange < 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
                }
                else if (output.serpskeywords[i].RankYahooMonthChange > 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
                }
                htmlResult = htmlResult + "</td>";
            }

            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].YahooUpdateDate + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'><a href=\"javascript:drawChart(" + output.serpskeywords[i].KeywordID + ",30);\" id='yahoo_chart' title='Chart'><i class='fa fa-2x fa-bar-chart-o' data-toggle='modal' data-target='#chartmodal'></i></a></td>";
            htmlResult = htmlResult + "<td style='text-align: center;'><a href=\"javascript:editKeyword(" + output.serpskeywords[i].KeywordID + ", '" + output.serpskeywords[i].Url + "', '" + output.serpskeywords[i].LinkGoogle + "','" + output.serpskeywords[i].Keyword + "');\" id='edit' title='Edit'><i class='fa fa-pencil fa-2x txt-color-yellow' data-toggle='modal' data-target='#editmodal'></i></a></td>";
            htmlResult = htmlResult + "<td style='text-align: center;'><a href='#' id='delete' title='Delete' onclick='deleteKeyword(" + output.serpskeywords[i].KeywordID + ");' ><i class='fa fa-trash-o fa-2x' data-toggle='modal' data-target='#deletemodal'></i></a></td>";
            htmlResult = htmlResult + "<tr>";
        }

        document.getElementById('yahooSerpsBody').innerHTML = document.getElementById('yahooSerpsBody').innerHTML + htmlResult;
    }

    //BingSerpsBody
    function updatebingSerpsBody(result) {

        var output = JSON.parse(result);
        var htmlResult = "";
        var i = 0;

        for (i = 0; i < output.serpskeywords.length; i++) {

            htmlResult = htmlResult + "<tr>";
            htmlResult = htmlResult + "<td title='" + output.serpskeywords[i].Url + "'>" + output.serpskeywords[i].Url + "</td>";
            htmlResult = htmlResult + "<td>" + output.serpskeywords[i].Keyword + "</td>";

            if ((output.serpskeywords[i].RankBing !== 0) || (output.serpskeywords[i].BingUpdateDate == '-')) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankBing + "</td>";
            }
            else {
                htmlResult = htmlResult + "<td style='text-align: center;'>N/A</td>";
            }

            if ((output.serpskeywords[i].BestMatchRankBing !== 0) || (output.serpskeywords[i].BingUpdateDate == '-')) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].BestMatchRankBing + "</td>";
            }
            else {
                htmlResult = htmlResult + "<td style='text-align: center;'>N/A</td>";
            }

            if (output.displaySettings.Daychangetab === 1) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahooDayChange + "";

                if (output.serpskeywords[i].RankYahooDayChange < 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
                }
                else if (output.serpskeywords[i].RankYahooDayChange > 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
                }
                htmlResult = htmlResult + "</td>";
            }

            if (output.displaySettings.Weekchangetab === 1) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahooWeekChange + "";

                if (output.serpskeywords[i].RankYahooWeekChange < 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
                }
                else if (output.serpskeywords[i].RankYahooWeekChange > 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
                }
                htmlResult = htmlResult + "</td>";
            }

            if (output.displaySettings.Monthchangetab === 1) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].RankYahooMonthChange + "";

                if (output.serpskeywords[i].RankYahooMonthChange < 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-down fa-1x fa-fw txt-color-red'></i>";
                }
                else if (output.serpskeywords[i].RankYahooMonthChange > 0) {
                    htmlResult = htmlResult + "<i class='fa fa-arrow-up fa-1x fa-fw txt-color-green'></i>";
                }
                htmlResult = htmlResult + "</td>";
            }

            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.serpskeywords[i].BingUpdateDate + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'><a href=\"javascript:drawChart(" + output.serpskeywords[i].KeywordID + ",30);\" id='bing_chart' title='Chart'><i class='fa fa-2x fa-bar-chart-o' data-toggle='modal' data-target='#chartmodal'></i></a></td>";
            htmlResult = htmlResult + "<td style='text-align: center;'><a href=\"javascript:editKeyword(" + output.serpskeywords[i].KeywordID + ", '" + output.serpskeywords[i].Url + "', '" + output.serpskeywords[i].LinkGoogle + "','" + output.serpskeywords[i].Keyword + "');\" id='edit' title='Edit'><i class='fa fa-pencil fa-2x txt-color-yellow' data-toggle='modal' data-target='#editmodal'></i></a></td>";
            htmlResult = htmlResult + "<td style='text-align: center;'><a href='#' id='delete' title='Delete' onclick='deleteKeyword(" + output.serpskeywords[i].KeywordID + ");' ><i class='fa fa-trash-o fa-2x' data-toggle='modal' data-target='#deletemodal'></i></a></td>";
            htmlResult = htmlResult + "<tr>";
        }

        document.getElementById('bingSerpsBody').innerHTML = document.getElementById('bingSerpsBody').innerHTML + htmlResult;
    }

    //SEOKeywordsBody
    function updateseoKeywordsBody(result) {

        var output = JSON.parse(result);
        var htmlResult = "";
        var i = 0;

        for (i = 0; i < output.seokeywords.length; i++) {

            htmlResult = htmlResult + "<tr>";
            htmlResult = htmlResult + "<td title='" + output.seokeywords[i].Url + "'>" + output.seokeywords[i].Url + "</td>";
            htmlResult = htmlResult + "<td>" + output.seokeywords[i].Keyword + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].SearchVolume + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].GoogleCPC + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].KeywordCompetition + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].NumberofResult + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].SiteIndexing + "</td>";

            if (output.displaySettings.Alexatab === 1) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].RankAlexa + "</td>";
            }

            if (output.displaySettings.Backlinkstab === 1) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].CountBackLinks + "</td>";
            }

            if (output.displaySettings.Monthlysearchstab === 1) {
                htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].CountMonthlySearches + "</td>";
            }

            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].GooglePA + "</td>";
            htmlResult = htmlResult + "<td style='text-align: center;'>" + output.seokeywords[i].GoogleDA + "</td>";
            htmlResult = htmlResult + "<tr>";
        }
        
        document.getElementById('seoKeywordsBody').innerHTML = document.getElementById('seoKeywordsBody').innerHTML + htmlResult;
    }
</script>