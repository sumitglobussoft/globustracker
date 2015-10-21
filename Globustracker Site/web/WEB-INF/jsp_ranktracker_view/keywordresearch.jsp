<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-bolt fa-fw "></i>
            GlobusTracker
            <span>
                Keyword Research 
            </span>
        </h1>
    </div>
</div>

<style type="text/css">

    .form-wrapper {
        width: 500px;
        padding: 8px;
        // margin: 10px auto;
        overflow: hidden;
        border-width: 1px;
        border-style: solid;
        border-color: #dedede #bababa #aaa #bababa;
        -moz-box-shadow: 0 3px 3px rgba(255,255,255,.1), 0 3px 0 #bbb, 0 4px 0 #aaa, 0 5px 5px #444;
        -webkit-box-shadow: 0 3px 3px rgba(255,255,255,.1), 0 3px 0 #bbb, 0 4px 0 #aaa, 0 5px 5px #444;
        box-shadow: 0 3px 3px rgba(255,255,255,.1), 0 3px 0 #bbb, 0 4px 0 #aaa, 0 5px 5px #444;
        -moz-border-radius: 10px;
        -webkit-border-radius: 10px;
        border-radius: 10px;    
        background-color: #f6f6f6;
        background-image: -webkit-gradient(linear, left top, left bottom, from(#f6f6f6), to(#eae8e8)); 
        background-image: -webkit-linear-gradient(top, #f6f6f6, #eae8e8);
        background-image: -moz-linear-gradient(top, #f6f6f6, #eae8e8);
        background-image: -ms-linear-gradient(top, #f6f6f6, #eae8e8);
        background-image: -o-linear-gradient(top, #f6f6f6, #eae8e8);
        background-image: linear-gradient(top, #f6f6f6, #eae8e8);
    }

    .form-wrapper #search {
        width: 380px;
        height: 42px;
        padding: 10px 5px;
        margin-top: 10px;
        float: left;    
        font: bold 16px 'lucida sans', 'trebuchet MS', 'Tahoma';
        border: 1px solid #ccc;
        -moz-box-shadow: 0 1px 1px #ddd inset, 0 1px 0 #fff;
        -webkit-box-shadow: 0 1px 1px #ddd inset, 0 1px 0 #fff;
        box-shadow: 0 1px 1px #ddd inset, 0 1px 0 #fff;
        -moz-border-radius: 3px;
        -webkit-border-radius: 3px;
        border-radius: 3px;      
    }

    .form-wrapper #search:focus {
        outline: 0; 
        border-color: #aaa;
        -moz-box-shadow: 0 1px 1px #bbb inset;
        -webkit-box-shadow: 0 1px 1px #bbb inset;
        box-shadow: 0 1px 1px #bbb inset;  
    }

    .form-wrapper #search::-webkit-input-placeholder {
        color: #999;
        font-weight: normal;
    }

    .form-wrapper #search:-moz-placeholder {
        color: #999;
        font-weight: normal;
    }

    .form-wrapper #search:-ms-input-placeholder {
        color: #999;
        font-weight: normal;
    }    

    .form-wrapper #submit {
        float: right;    
        border: 1px solid #CA7A71;
        height: 42px;
        width: 100px;
        padding: 0;
        margin-top: 10px;
        cursor: pointer;
        font: bold 15px Arial, Helvetica;
        color: #fafafa;
        text-transform: uppercase;    
        background-color: #CA7A71;
        background-image: -webkit-gradient(linear, left top, left bottom, from(#CA7A94), to(#CA7A71));
        background-image: -webkit-linear-gradient(top, #CA7A94, #CA7A71);
        background-image: -moz-linear-gradient(top, #CA7A94, #CA7A71);
        background-image: -ms-linear-gradient(top, #CA7A94, #CA7A71);
        background-image: -o-linear-gradient(top, #CA7A94, #CA7A71);
        background-image: linear-gradient(top, #CA7A94, #CA7A71);
        -moz-border-radius: 3px;
        -webkit-border-radius: 3px;
        border-radius: 3px;      
        text-shadow: 0 1px 0 rgba(0, 0 ,0, .3);
        -moz-box-shadow: 0 1px 0 rgba(255, 255, 255, 0.3) inset, 0 1px 0 #fff;
        -webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, 0.3) inset, 0 1px 0 #fff;
        box-shadow: 0 1px 0 rgba(255, 255, 255, 0.3) inset, 0 1px 0 #fff;
    }

    .form-wrapper #submit:hover,
    .form-wrapper #submit:focus {		
        background-color: #CA7A71;
        background-image: -webkit-gradient(linear, left top, left bottom, from(#CA7A71), to(#CA7A94));
        background-image: -webkit-linear-gradient(top, #CA7A71, #CA7A94);
        background-image: -moz-linear-gradient(top, #CA7A71, #CA7A94);
        background-image: -ms-linear-gradient(top, #CA7A71, #CA7A94);
        background-image: -o-linear-gradient(top, #CA7A71, #CA7A94);
        background-image: linear-gradient(top, #CA7A71, #CA7A94);
    }	

    .form-wrapper #submit:active {
        outline: 0;    
        -moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.5) inset;
        -webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.5) inset;
        box-shadow: 0 1px 4px rgba(0, 0, 0, 0.5) inset;    
    }

    .form-wrapper #submit::-moz-focus-inner {
        border: 0;
    }


    table.keyword {

        background: none repeat scroll 0 0 #FAFAFA;
        border-radius: 3px;
        box-shadow: 0 2px 0 #FFFFFF inset, 0 2px 4px rgba(52, 79, 90, 0.4);
        color: #777777;                    

        font: normal 14px helvetica, arial;

        margin:1% auto 0;
    }

    table.keyword, .keyword td, .keyword th, .keyword tr{
        font-family: 'Sintony', sans-serif;
    }

    .keyword th, .keyword td {padding:8px; }

    .keyword th {padding:10px; text-shadow: 1px 1px 1px #fff; background:#F0E7CC;}

    .keyword td {border-top:1px solid #e0e0e0; border-right:1px solid #e0e0e0; vertical-align: middle;}

    .keyword tr.odd-row td {background:#ECF3FB;}

    .keyword td.first, .keyword th.first {text-align:left}

    .keyword td.last {border-right:none;}

    .keyword tr:hover td{
        background:#F4F7FC;
    }


    .keyword td {
        background: -moz-linear-gradient(100% 25% 90deg, #fefefe, #f9f9f9);
        background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f9f9f9), to(#fefefe));
    }

    .keyword tr.odd-row td {
        background: -moz-linear-gradient(100% 25% 90deg, #F9FBFF, #F4F7FC);
        background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#F9FBFF), to(#F4F7FC));
    }

    .keyword th {
        background: -moz-linear-gradient(100% 20% 90deg, #e8eaeb, #ededed);
        background: -webkit-gradient(linear, 0% 0%, 0% 20%, from(#ededed), to(#e8eaeb));
    }


    .keyword tr:first-child th.first {
        -moz-border-radius-topleft:5px;
        -webkit-border-top-left-radius:5px; /* Saf3-4 */
    }

    .keyword tr:first-child th.last {
        -moz-border-radius-topright:5px;
        -webkit-border-top-right-radius:5px; /* Saf3-4 */
    }

    .keyword tr:last-child td.first {
        -moz-border-radius-bottomleft:5px;
        -webkit-border-bottom-left-radius:5px; /* Saf3-4 */
    }

    .keyword tr:last-child td.last {
        -moz-border-radius-bottomright:5px;
        -webkit-border-bottom-right-radius:5px; /* Saf3-4 */
    }

    .keyHeading {
        margin:20px 0 20px 0;
        padding:0;
        font:54px/60px 'segoe UI', sans-serif;
        font-weight: 400;
        color: #CA7A71;
        text-align: center;
        letter-spacing: -2px;
    }

    #loading{
        margin:20px 0 20px 0;
        padding:0;
        font:54px/60px 'Sintony', sans-serif;
        font-weight: 700;
        color: #CC3333;
        text-align: center;
        letter-spacing: -2px;
    }

    #error{
        margin:20px 0 20px 0;
        padding:0;
        font:54px/60px 'Sintony', sans-serif;
        font-weight: 700;
        color: #CC3333;
        text-align: center;
        letter-spacing: -2px;
    }
    a.live, a.live:active, a.live:visited{
        color:#0483a0;
    }
    a.live:hover{
        color:#0483a0;
        text-decoration:none;
    }

    #formSubmit input[type=radio] {
        display:none;
        margin:10px;
    }


    #formSubmit input[type=radio] + label {
        display:inline-block;
        margin:-2px;
        padding: 4px 12px;
        background-color: #e7e7e7;
        border-color: #ddd;
    }

    #formSubmit input[type=radio]:checked + label {
        background-image: none;
        background-color:#d0d0d0;
    }



</style>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active">
        <a href="#radio1" aria-controls="search" role="tab" data-toggle="tab">Google</a>
    </li>
    <li role="presentation">
        <a href="#radio2" aria-controls="site" role="tab" data-toggle="tab">Bing</a>
    </li>
    <li role="presentation">
        <a href="#radio3" aria-controls="errorcount" role="tab" data-toggle="tab">Yahoo</a>
    </li>
    <li role="presentation">
        <a href="#radio4" aria-controls="errorsamples" role="tab" data-toggle="tab">Amazon</a>
    </li>
    <li role="presentation">
        <a href="#radio5" aria-controls="site" role="tab" data-toggle="tab">Ebay</a>
    </li>
    <li role="presentation">
        <a href="#radio6" aria-controls="errorcount" role="tab" data-toggle="tab">Youtube</a>
    </li>
    <li role="presentation">
        <a href="#radio7" aria-controls="errorsamples" role="tab" data-toggle="tab">Wikipedia</a>
    </li>
</ul>

<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="radio1">
        <form id="formSubmit1" class="form-inline" onsubmit="return getResults(1)" style="margin-top: 3%;">
            <input type="hidden" id="radio1" name="site" value="google" />
            <input type="text" id="search" style="width: 30%; margin-right: 1%;" class="form-control" name="keyword" placeholder="Enter Keyword..." required />
            <input type="submit" class="btn btn-primary" value="GO" id="submit">
        </form>
    </div>
    <div role="tabpanel" class="tab-pane" id="radio2">
        <form id="formSubmit2" class="form-inline" onsubmit="return getResults(2)" style="margin-top: 3%;">
            <input type="hidden" id="radio2" name="site" value="bing" />
            <input type="text" id="search" style="width: 30%; margin-right: 1%;" class="form-control" name="keyword" placeholder="Enter Keyword..." required />
            <input type="submit" class="btn btn-primary" value="GO" id="submit">
        </form>
    </div>
    <div role="tabpanel" class="tab-pane" id="radio3">
        <form id="formSubmit3" class="form-inline" onsubmit="return getResults(3)" style="margin-top: 3%;">
            <input type="hidden" id="radio3" name="site" value="yahoo" />
            <input type="text" id="search" style="width: 30%; margin-right: 1%;" class="form-control" name="keyword" placeholder="Enter Keyword..." required />
            <input type="submit" class="btn btn-primary" value="GO" id="submit">
        </form>
    </div>
    <div role="tabpanel" class="tab-pane" id="radio4">
        <form id="formSubmit4" class="form-inline" onsubmit="return getResults(4)" style="margin-top: 3%;">
            <input type="hidden" id="radio4" name="site" value="amazon" />
            <input type="text" id="search" style="width: 30%; margin-right: 1%;" class="form-control" name="keyword" placeholder="Enter Keyword..." required />
            <input type="submit" class="btn btn-primary" value="GO" id="submit">
        </form>
    </div>
    <div role="tabpanel" class="tab-pane" id="radio5">
       <form id="formSubmit5" class="form-inline" onsubmit="return getResults(5)" style="margin-top: 3%;">
            <input type="hidden" id="radio5" name="site" value="ebay" />
            <input type="text" id="search" style="width: 30%; margin-right: 1%;" class="form-control" name="keyword" placeholder="Enter Keyword..." required />
            <input type="submit" class="btn btn-primary" value="GO" id="submit">
        </form>
    </div>
    <div role="tabpanel" class="tab-pane" id="radio6">
        <form id="formSubmit6" class="form-inline" onsubmit="return getResults(6)" style="margin-top: 3%;">
            <input type="hidden" id="radio6" name="site" value="youtube" />
            <input type="text" id="search" style="width: 30%; margin-right: 1%;" class="form-control" name="keyword" placeholder="Enter Keyword..." required />
            <input type="submit" class="btn btn-primary" value="GO" id="submit">
        </form>
    </div>
    <div role="tabpanel" class="tab-pane" id="radio7">
        <form id="formSubmit7" class="form-inline" onsubmit="return getResults(7)" style="margin-top: 3%;">
            <input type="hidden" id="radio7" name="site" value="wikipedia" />
            <input type="text" id="search" style="width: 30%; margin-right: 1%;" class="form-control" name="keyword" placeholder="Enter Keyword..." required />
            <input type="submit" class="btn btn-primary" value="GO" id="submit">
        </form>
    </div>
    
</div>

<div style="display:none;" id="loading">
    <p>Please wait the data is loading...</p>
</div>	

<div id="results" style="padding-bottom: 34%;"></div>


<!-- SCRIPTS ON PAGE EVENT -->
<script type="text/javascript">

    function getResults(id) {
        
        var temp="#formSubmit"+id;
        $.ajax({
            type: "GET",
            url: "getkeywords.action",
            data: $(temp).serialize(),
            beforeSend: function (data) {
                $("#loading").css('display', 'inline');
                $('#results').empty();
            },
            success: function (data) {
                $("#loading").css('display', 'none');

                var output = JSON.parse(data);

                var html = '<table width=\'800\' cellspacing=\'0\' cellpadding=\'5\' border=\'0\' align=\'left\' class=\'keyword\'>';
                html = html + '<thead class=\'odd-row\'>';
                html = html + '<th align=\'left\'> # </th>';
                html = html + '<th align=\'left\'> Keyword </th>';
                html = html + '<th> Live Results </th>';
                html = html + '</thead>';
                html = html + '<tbody>';

                for (i = 0; i < output.result.length; i++) {
                    html = html + '<tr><td align=\'left\'>' + (i + 1) + '</td><td  align=\'left\'>' + output.result[i] + '</td>';

                    if (output.site === 'google') {
                        html = html + '<td><a  class=\'live\' target=\'_blank\' href=\'https://www.google.com/search?q=' + encodeURIComponent(output.result[i]) + '\'>TOP LISTINGS</a></td>';
                    }
                    else if (output.site === 'bing') {
                        html = html + '<td><a  class=\'live\'  target=\'_blank\' href=\'http://www.bing.com/search?q=' + encodeURIComponent(output.result[i]) + '\'>TOP LISTINGS</a></td>';
                    }
                    else if (output.site === 'yahoo') {
                        html = html + '<td><a  class=\'live\'  target=\'_blank\' href=\'https://search.yahoo.com/search?p=' + encodeURIComponent(output.result[i]) + '\'>TOP LISTINGS</a></td>';
                    }
                    else if (output.site === 'amazon') {
                        html = html + '<td><a  class=\'live\'  target=\'_blank\' href=\'http://www.amazon.com/s/?field-keywords=' + encodeURIComponent(output.result[i]) + '\'>TOP LISTINGS</a></td>';
                    }
                    else if (output.site === 'youtube') {
                        html = html + '<td><a  class=\'live\'  target=\'_blank\' href=\'https://www.youtube.com/results?search_query=' + encodeURIComponent(output.result[i]) + '\'>TOP LISTINGS</a></td>';
                    }
                    else if (output.site === 'wikipedia') {
                        html = html + '<td><a  class=\'live\'  target=\'_blank\' href=\'http://en.wikipedia.org/w/index.php?search=' + encodeURIComponent(output.result[i]) + '\'>TOP LISTINGS</a></td>';
                    }
                    else if (output.site === 'ebay') {
                        html = html + '<td><a  class=\'live\'  target=\'_blank\' href=\'http://www.ebay.com/sch/i.html?_nkw=' + encodeURIComponent(output.result[i]) + '\'>TOP LISTINGS</a></td>';
                    }
                    html = html + '</tr>';
                }
                html = html + '</tbody></table>';
                $('#results').append(html);
            }
        });

        return false;
    }


</script>
