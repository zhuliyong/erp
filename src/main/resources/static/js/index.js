function loadInner() {
    var sId = window.location.hash;
    var pathn, i;
    switch (sId) {
        case "#cgdd":
            pathn = "purchasingOrder.html";
            i = 0;
            break;
        case "#cggl":
            pathn = "purchasingOrderManager.html";
            i = 1;
            break;
        default:
            pathn = "home.html";
            i = 0;
            break;
    }
    $("#content").load(pathn); //加载相对应的内容
    $(".userMenu li").eq(i).addClass("current").siblings().removeClass("current"); //当前列表高亮
}