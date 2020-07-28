
$(function(){
    /**
     * 导航栏 hover显示事件
     */
    $(".rButton").hover(function(){
        $(this).find(".layerbox").slideDown(500);
    }, function(){
        $(this).find(".layerbox").slideUp(500);
    })
})
