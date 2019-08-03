/*添加计量单位*/
function addUnit (){
    var code = $("#newUnit-code").val().trim();
    var name = $("#newUnit-name").val().trim();
    var flag = 1;
    if(code == null || code ==""){
        flag = 0;
    }
    if(name == null || name ==""){
        flag = 0;
    }
    //数据合格则发送请求
    if(flag){
        $.ajax({
            url: "http://192.168.2.26:8080/unit/new",
            data: {
                "unitCode": code,
                "unitName": name
            },
            type: "post",
            dataType: "json",
            success: function (res) {
                if(res.status == 1){
                    $("#newUnit").hide();
                    $("#backfloat").hide();
                    alert("添加成功!");
                }
            },
            error: function () {
                console.log("添加单位发生异常")
            }
        })

    }else{
        alert("请录入完整数据");
    }
}


/*打开弹窗*/
function showPop(){
    $("#newUnit").show();
    $("#backfloat").show();
}

/*关闭添加弹窗*/
function closePop(){
    $("#newUnit").hide();
    $("#backfloat").hide();
}

/*分页列表数据*/
function pageList(pageNo,pageSize){
    $.ajax({
        url: "http://192.168.2.26:8080/unit/page",
        data: {
            "pageNo":pageNo,
            "pageSize":pageSize
        },
        type: "post",
        dataType: "json",
        success: function (res) {
            if(res.status == 1){
                var pageNo = res.data.pageNum;
                console.log("pageNo:"+pageNo);
                var len = res.data.total;
                var pageSize =res.data.pages;
                console.log("len:"+len+",pageSize:"+pageSize);
                page(pageNo,len);
            }
        },
        error: function () {
            console.log("添加单位发生异常")
        }
    })
}


/*加载分页*/
function page(pageNo,num){
    $("#myPage").sPage({
        page:pageNo,//当前页码，必填
        total:num,//数据总条数，必填
        pageSize:2,//每页显示多少条数据，默认10条
        totalTxt:"共{total}条",//数据总条数文字描述，{total}为占位符，默认"共{total}条"
        showTotal:true,//是否显示总条数，默认关闭：false
        showSkip:true,//是否显示跳页，默认关闭：false
        showPN:true,//是否显示上下翻页，默认开启：true
        prevPage:"上一页",//上翻页文字描述，默认“上一页”
        nextPage:"下一页",//下翻页文字描述，默认“下一页”
        backFun:function(page){
            //点击分页按钮回调函数，返回当前页码
            console.log(page);
        }
    });
}