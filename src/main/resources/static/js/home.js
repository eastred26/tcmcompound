function changeState(obj) {
    if(obj.innerText==="更多+")
        obj.innerText="收起";
    else obj.innerText="更多+"
}

$(function(){
    $("#identification_search_btn").click(function () {
        var search_type = $("input[name='search_type']:checked").val();
        search(search_type);
    });

    $("#query_input").keypress(function (e) {
        if (e.which == 13) {
            var search_type = $("input[name='search_type']:checked").val();
            search(search_type);
        }
    });

    function search(search_type) {
        var search_text = $("#query_input").val();
        if (search_text == '') {
            $('#tip-modal').modal();
            return;
        }
        var href = './search/result?kw=' + search_text + '&type=' + search_type;
        window.location.href = href;
    }
});