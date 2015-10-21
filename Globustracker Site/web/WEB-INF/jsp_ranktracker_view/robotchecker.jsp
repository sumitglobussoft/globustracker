<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i>
            GlobusTracker
            <span>>
                Robot Checker
            </span>
        </h1>
    </div>
</div>
<style>
    #result-table{
        visibility: hidden;
    }
    .well {
        margin: 1%;
        min-height: 300px;
        max-height: 300px;
    }
    td, th {
        border-color: #ddd !important;
        border-left: 1px #ddd solid;
        border-right: 1px #ddd solid;
    }
</style>


<div class="row">

    <div class="col-md-3 text-center"  style="width: 40%;">
        <form action="#" id="formSubmit" class="form-inline" onsubmit="return getRobotsFile()">
            <input type="url" name="url" class="form-control" placeholder="http://www.abc.com" required="true" id="url_field" style="width: 70%;" />
            <input type="submit" value="GO" class="btn btn-primary" />
        </form>
    </div>

    <div class="col-md-12 text-left" style="margin-top: 3%;">        
        <span id="loading" style="margin-left: 12%;"></span>
    </div>

    <div id="scrollhide"  class="col-md-6 text-center" style="max-height: 350px;overflow-y: scroll; display:none">
        <table id="file-content" >
        </table>
    </div>
</div>
<div class="row">
    <div class="col-md-6 text-center" id="RobotTextBoxHide"  style="display:none">
        <form action="#" id="formAllowanceSubmit" class="form-inline" onsubmit="return getAllowance()">
            <span id="domain-url" style="color:gray;"></span>&nbsp;<input type="text" name="path" class="form-control" required="true" id="url-allowance" style="width: 40%;" />
            <input type="submit" value="Check" class="btn btn-primary" />
        </form>
        <span id="allowance-message"></span>
    </div>

</div>

<script type="text/javascript">

    var isRobotFileExist = false;
    var fileJson = "";

    function getAllowance() {

        if (!isRobotFileExist) {
            alert("Please get the robots.txt file first");
            return false;
        }

        $.ajax({
            type: "GET",
            url: "checkUrlAllowance.action",
            data: "url=" + $('#url_field').val() + '/' + $('#url-allowance').val(),
            beforeSend: function () {
                $('#loading').text('Loading Please Wait...');
            },
            success: function (data) {
                $('#loading').text('');
                $("#RobotTextBoxHide").show();
                $("#scrollhide").show();
                var result = JSON.parse(data);
                console.log('result' + result);
                for (var i = 0; i < fileJson.lines.length; i++) {
                    try {
                        var str = fileJson.lines[i][i];
                        var res = str.split(":");
                        var check = res[1];

                        if ((check === ' ' + $('#url-allowance').val()) || (check === ' /' + $('#url-allowance').val()) || (check === '' + $('#url-allowance').val()) || (check === '/' + $('#url-allowance').val())) {
                            if (result.allowed === false) {
                                $('#allowance-message').text('Blocked');
                                $('#allowance-message').css('color', 'red');
                                $('#line' + i).css('background-color', 'red');
                            }
                            else {
                                $('#allowance-message').text('Allowed');
                                $('#allowance-message').css('color', 'green');
                                $('#line' + i).css('background-color', 'green');
                            }
                        }
                    } catch (err) {
                    }
                }
            },
            error: function (data) {
                console.log(data);
                $("#RobotTextBoxHide").hide();
                $("#scrollhide").hide();
            }
        });
        return false;
    }

    function getRobotsFile() {

        $.ajax({
            type: "GET",
            url: "getRobotFile.action",
            data: $("#formSubmit").serialize(),
            beforeSend: function (data) {
                $('#loading').text('Loading Please Wait...');
            },
            success: function (data) {
                $('#loading').text('');
                $("#RobotTextBoxHide").show();
                $("#scrollhide").show();
                var result = JSON.parse(data);
                if (result.code === 101) {
                    fileJson = result;
                    isRobotFileExist = true;
                    $('#robot-content').val(data);
                    $('#domain-url').text('' + $('#url_field').val());

                    var html = "";
                    for (var i = 0; i < result.lines.length; i++) {
                        html = html + "<tr><td style='color:grey;border-right-color:black' ><b>" + (i + 1) + "</b></td><td style='text-align: left' id='line" + i + "'>" + result.lines[i][i] + "</td></tr>";
                    }
                    $('#file-content').empty();
                    $('#file-content').append(html);
                }
            },
            error: function (data) {
                console.log(data);
                $("#RobotTextBoxHide").hide();
                $("#scrollhide").hide();
            }
        });
        return false;
    }

</script>