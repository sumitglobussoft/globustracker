<%-- 
    Document   : strucuturedata
    Created on : Sep 29, 2015, 12:53:01 PM
    Author     : GLB-214
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--<div role="tabpanel" class="tab-pane" id="structuredatausage">-->
<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i>
            GlobusTracker
            <span>
                Structured Data
            </span>
        </h1>
    </div>
</div>
<div class="row">
    <div class="col-md-3 text-center"  style="width: 40%;">
        <form action="#" id="form-Submit-Structured" class="form-inline" onsubmit="return getStructuredDataResults()">
            <input type="url" name="url" class="form-control" placeholder="http://www.abc.com" required="true" id="url_field_data" style="width: 70%;" />
            <input type="submit" value="GO" class="btn btn-primary" />
        </form>
    </div><br/>

    <!--    <div class="col-md-12 text-center" style="margin-top: 3%;">        
            <span id="loading-Structured-Data"></span>
        </div>-->

    <div class="col-md-12 text-left" style="margin-top: 3%;">        
        <span id="loading" style="margin-left: 12%;"></span>
    </div>

    <div id="StructuredDataHide" style="display:none">
        <div class="col-md-12" id="well-content">
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <code>icon</code>
                </div>
                <div class="col-md-8 well" id="id-icon">

                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <code>title</code>
                </div>
                <div class="col-md-8 well">
                    <label><span id="id-title"></span></label>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <code>text</code>
                </div>
                <div class="col-md-8 well">
                    <p id="id-text"></p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <code>type</code>
                </div>
                <div class="col-md-8 well">
                    <p id="id-type"></p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <code>html</code>
                </div>
                <div class="col-md-8 well">
                    <p id="id-html"></p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <code>siteName</code>
                </div>
                <div class="col-md-8 well">
                    <label id="id-siteName"></label>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <code>humanLanguage</code>
                </div>
                <div class="col-md-8 well">
                    <span id="id-human"></span>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <code>pageUrl</code>
                </div>
                <div class="col-md-8 well">
                    <a href="#" id="id-pageUrl"></a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <code>resolvedPageUrl</code>
                </div>
                <div class="col-md-8 well">
                    <a href="#" id="id-resolvedPageUrl"></a>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <code>HTML Content</code>
                </div>
                <div class="col-md-8 well" style="overflow-y: scroll; max-height: 500px;">
                    <p id="id-html-content"></p>
                </div>
            </div>
        </div>
    </div>

</div>

<script type="text/javascript">

    function getStructuredDataResults() {

        $.ajax({
            type: "GET",
            url: "getstructureddata.action",
            data: $("#form-Submit-Structured").serialize(),
            beforeSend: function () {
                $('#loading').text('Loading Please Wait...');
            },
            success: function (data) {
//                console.log(data);
//                var result = JSON.parse(data);
//                console.log(result);
//                var htmlcontent = "";
//                for (var i = 0; i < result.HtmlPage.length; i++) {
//
//                    htmlcontent = result.HtmlPage[i];
//
//                      $("#id-html-content").append(htmlcontent);
//                }



                $("#id-title").empty();
                $("#id-text").empty();
                $("#id-type").empty();
                $("#id-html").empty();
                $("#id-siteName").empty();
                $("#id-human").empty();
                $("#id-pageUrl").empty();
                $("#id-resolvedPageUrl").empty();

                $("#StructuredDataHide").show();
                $('#loading').text('');
                var result = JSON.parse(data);
                console.log(result);
                var html = result.Structured.objects[0].html;
                var human = result.Structured.objects[0].humanLanguage;
                var icon = result.Structured.objects[0].icon;
                var pageUrl = result.Structured.objects[0].pageUrl;
                var resolvedPageUrl = result.Structured.objects[0].resolvedPageUrl;
                var siteName = result.Structured.objects[0].siteName;
                var text = result.Structured.objects[0].text;
                var title = result.Structured.objects[0].title;
                var type = result.Structured.objects[0].type;

                console.log("1 html             : " + html);
                console.log("2 human            : " + human);
                console.log("3 icon             : " + icon);
                console.log("4 page url         : " + pageUrl);
                console.log("5 Resolved pageurl : " + resolvedPageUrl);
                console.log("6 Site Name        : " + siteName);
                console.log("7 Text             : " + text);
                console.log("8 Title            : " + title);
                console.log("9 Type             : " + type);

                $("#id-icon").html('<img src="' + icon + '" class="img-responsive"/>');
                $("#id-title").append(title);
                $("#id-text").append(text);
                $("#id-type").append(type);
                $("#id-html").append(html);
                $("#id-siteName").append(siteName);
                $("#id-human").append(human);
                $("#id-pageUrl").append(pageUrl);
                $("#id-resolvedPageUrl").append(resolvedPageUrl);


//                var result1 = JSON.parse(data);

                var htmlcontent = [];
                for (var i = 0; i < result.HtmlPage.length; i++) {

//                    htmlcontent = result1.HtmlPage[i];
//                    console.log("--------->>>>>>"+htmlcontent);
                    htmlcontent.push(result.HtmlPage[i]);

                }
                $('#id-html-content').empty();
                $("#id-html-content").append(htmlcontent);

            },
            error: function (data) {
                console.log(data);
                $("#StructuredDataHide").hide();
            }
        });
        return false;
    }


</script>
<!--</div>-->
