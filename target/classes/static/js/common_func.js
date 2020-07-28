function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURIComponent(r[2]);
    return null;
}

/*
    函数:格式化字符串
    参数：str:字符串模板； data:数据
    调用方式:formatString("api/values/{id}/{name}",{id:101,name:"test"});
             formatString("api/values/{0}/{1}",101,"test");
*/
function formatString(str, data) {
    if (!str || data == undefined) {
        return str;
    }

    if (typeof data === "object") {
        for (var key in data) {
            if (data.hasOwnProperty(key)) {
                str = str.replace(new RegExp("\{" + key + "\}", "g"), data[key]);
            }
        }
    } else {
        var args = arguments,
            reg = new RegExp("\{([0-" + (args.length - 1) + "])\}", "g");
        return str.replace(reg, function(match, index) {
            return args[index - (-1)];
        });
    }
    return str;
}
