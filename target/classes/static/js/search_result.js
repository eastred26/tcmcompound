var max_content_len = 50;
var page_size = 5;

$(function() {
    var kw = getQueryString('kw');
    var type = getQueryString('type');

    if (kw == null) {
        kw = '';
    }

    $('#query_input').val(kw);

    if(type=='med'){
        $(".tj-content").eq(0).children().eq(0).addClass("active");
        $("input[name='search_type']").eq(0).attr("checked","checked");
    } else if(type=='origin'){
        $(".tj-content").eq(0).children().eq(1).addClass("active");
        $("input[name='search_type']").eq(1).attr("checked","checked");
    } else if(type=='compound'){
        $(".tj-content").eq(0).children().eq(2).addClass("active");
        $("input[name='search_type']").eq(2).attr("checked","checked");
    }

    /*
    * 左侧菜单按钮点击
    */
    $(".tj-content").on("click", "span", function(){
        $this = $(this);
        if ($this.hasClass("active")) return;

        $(".tj-content span").removeClass("active");
        $this.addClass("active");
        type = $(this).closest(".tj-content").data("type");
        switch (type) {
            case "category":
                var query_text = getQueryString('kw');
                var search_type = $this.text().split("(")[0];
                if(search_type == "中药") {
                    search_type = 'med';
                } else if (search_type == "基源") {
                    search_type = 'origin';
                } else if (search_type == "化合物") {
                    search_type = 'compound';
                }
                window.location.href = "/tcmcompound/search/result?kw=" + query_text + '&type=' + search_type;
                break;
            default:
                break;
        }
    });

    $("#identification_search_btn").click(function () {
        var search_type = $("input[name='search_type']:checked").val();
        var query_text = $('#query_input').val();
        if (search_type != null) {
            window.location.href = "/tcmcompound/search/result?kw=" + query_text + '&type=' + search_type;
        }
    });

    $("#query_input").keypress(function (e) {
        if (e.which == 13) {
            var query_text = $('#query_input').val();
            var search_type = $("input[name='search_type']:checked").val();
            if (search_type != null) {
                window.location.href = "/tcmcompound/search/result?kw=" + query_text + '&type=' + search_type;
            }
        }
    });

    search(0);
});

function init_pagination(items, pageNo) {
    $(".nav-pagination").pagination(
        {
            items: items,
            itemsOnPage: page_size,
            cssStyle: 'blue-theme',
            prevText: "上一页",
            nextText: "下一页",
            // hrefTextPrefix: "&pIndex=",
            onPageClick: function (pageNumber, event) {
                // $body = (window.opera) ? (document.compatMode == "CSS1Compat" ? $('html') : $('body')) : $('html,body');// 这行是 Opera 的补丁, 少了它 Opera 是直接用跳的而且画面闪烁 by willin
                // $body.animate({scrollTop: $('.location').offset().top}, 1000);
                search(pageNumber - 1);
            },
            currentPage: pageNo,
        }).show();
}

function search(idx) {
    //清空列表内容，显示loading
    $("#noData").hide();
    $(".nav-pagination").hide();
    $("#loader").show();
    $('#resultList').empty();

    var keyword = $('#query_input').val();
    var type = getQueryString("type");
    if (type == null) {
        type = "";
    }
    var search_data = {keyword: keyword, pIndex: page_size*idx, size: page_size, type: type};
    search_data = JSON.stringify(search_data);
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: './getSearchResult',
        data: search_data,
        dataType: 'json',
        success: function (data) {
            updateSearchResult(data, idx, type);
        },
        error: function (data) {
            console.log(data);
            console.log("get search result error");
        }
    });
}

function updateSearchResult(data, idx, type) {
    //隐藏loading画满
    $("#loader").hide();

    $(".resultnum .num").text(data.totalResult);

    if (data == null || data.totalResult == 0) {
        //无相关搜索结果
        $('#noData').show();
        return;
    } else {
        var totalResult = data.totalResult;
        data = data.data;
        console.log(data);
        var med_html_template = '<div class="result-panel">'+
            '                       <div class="result-panel-head">\n'+
            '                           <div class="blue-left-bar">\n</div>\n'+
            '                           <a href="/tcmcompound/medicine/{0}">{1}</a>\n'+
            '                       </div>\n'+
            '                       <div class="result-panel-line">\n'+
            '                           <div class="result-panel-property">拼音</div>\n'+
            '                           <div class="result-panel-text">{2}</div>\n'+
            '                       </div>\n'+
            '                       <div class="result-panel-line">\n'+
            '                           <div class="result-panel-property">拉丁名</div>\n'+
            '                           <div class="result-panel-text">{3}</div>\n'+
            '                       </div>\n'+
            '                       <div class="result-panel-line">\n'+
            '                           <div class="result-panel-property">功效</div>\n'+
            '                           <div class="result-panel-text">{4}</div>\n'+
            '                       </div>\n'+
            '                       <div class="result-panel-line">\n'+
            '                           <div class="result-panel-property">性味</div>\n'+
            '                           <div class="result-panel-text">{5}</div>\n'+
            '                       </div>\n'+
            '                       <div class="clearfix"></div>\n'+
            '                    </div>';

        var compound_html_template = '<div class="result-panel">'+
            '                       <div class="result-panel-head">\n'+
            '                           <div class="blue-left-bar">\n</div>\n'+
            '                           <a href="/tcmcompound/compound/{0}">{1}</a>\n'+
            '                       </div>\n'+
            '                       <div class="result-panel-line">\n'+
            '                           <div class="result-panel-property">CAS</div>\n'+
            '                           <div class="result-panel-text">{2}</div>\n'+
            '                       </div>\n'+
            '                       <div class="result-panel-line">\n'+
            '                           <div class="result-panel-property">中文名</div>\n'+
            '                           <div class="result-panel-text">{3}</div>\n'+
            '                       </div>\n'+
            '                       <div class="result-panel-line">\n'+
            '                           <div class="result-panel-property">类型</div>\n'+
            '                           <div class="result-panel-text">{4}</div>\n'+
            '                       </div>\n'+
            '                       <div class="result-panel-line">\n'+
            '                           <div class="result-panel-property">分子式</div>\n'+
            '                           <div class="result-panel-text">{5}</div>\n'+
            '                       </div>\n'+
            '                       <div class="clearfix"></div>\n'+
            '                    </div>';

        var origin_html_template = '<div class="result-panel">'+
            '                       <div class="result-panel-head">\n'+
            '                           <div class="blue-left-bar">\n</div>\n'+
            '                           <a href="/tcmcompound/origin/{0}">{1}</a>\n'+
            '                       </div>\n'+
            '                       <div class="result-panel-line">\n'+
            '                           <div class="result-panel-property">拼音</div>\n'+
            '                           <div class="result-panel-text">{2}</div>\n'+
            '                       </div>\n'+
            '                       <div class="result-panel-line">\n'+
            '                           <div class="result-panel-property">拉丁名</div>\n'+
            '                           <div class="result-panel-text">{3}</div>\n'+
            '                       </div>\n'+
            '                       <div class="result-panel-line">\n'+
            '                           <div class="result-panel-property">科属</div>\n'+
            '                           <div class="result-panel-text">{4}</div>\n'+
            '                       </div>\n'+
            '                       <div class="clearfix"></div>\n'+
            '                    </div>';

        var html = '';
        for (var i = 0; i < data.length; i++) {
            if(type == 'med'){
                var med_id = data[i].med_id;
                var med_name_zh = data[i].med_name_zh;
                var med_name_pinyin = data[i].med_name_pinyin;
                var med_name_latin = data[i].med_name_latin;
                var med_function = data[i].med_function != null ? data[i].med_function : '';
                var med_property = data[i].med_property != null ? data[i].med_property : '';
                if(med_function > max_content_len) {
                    med_function = med_function.substr(0, max_content_len) + '...';
                }
                html += formatString(med_html_template, med_id, med_name_zh, med_name_pinyin, med_name_latin, med_function, med_property);
            } else if(type == 'origin') {
                var origin_id = data[i].origin_id;
                var origin_name_zh = data[i].origin_name_zh;
                var origin_name_pinyin = data[i].origin_name_pinyin;
                var origin_name_latin = data[i].origin_name_latin;
                var origin_family = data[i].origin_family;
                html += formatString(origin_html_template, origin_id, origin_name_zh, origin_name_pinyin, origin_name_latin, origin_family);
            } else {
                var compound_id = data[i].compound_id;
                var compound_name = data[i].compound_name;
                var compound_cas = data[i].compound_cas;
                var compound_name_zh = data[i].compound_name_zh;
                var compound_structure = data[i].compound_structure;
                var compound_formula = data[i].compound_formula;
                html += formatString(compound_html_template, compound_id, compound_name, compound_cas, compound_name_zh, compound_structure, compound_formula);
            }
        }
        $('#result_list').html(html);
        init_pagination(totalResult, idx + 1);
    }
}