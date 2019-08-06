/*添加计量单位*/
function addUnit (){
    var code = $("#newUnit-code").val().trim();
    var name = $("#newUnit-name").val().trim();
    var id = $("#curr_unitId").val();
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
            url: path+"/unit/new",
            data: {
                "unitCode": code,
                "unitName": name,
                "unitId": id
            },
            type: "post",
            dataType: "json",
            success: function (res) {
                if(res.status == 1){
                    $("#newUnit").hide();
                    $("#backfloat").hide();
                    window.location.reload();
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

/*删除行元素*/
function delUnit(){
    var unitId = $(this).parents("tr").children("td").eq(0).html();
    $.ajax({
        url: path+"/unit/del",
        data: {
            "unitId":unitId
        },
        type: "post",
        dataType: "json",
        success: function (res) {
            if(res.status == 1){
                window.location.reload();
            }else{
                alert("删除失败")
            }
        },
        error: function () {
            console.log("删除失败")
        }
    })
}

/*编辑*/
function editUtil(){
    var unitId = $(this).parents("tr").children("td").eq(0).html();
    var unitCode = $(this).parents("tr").children("td").eq(1).html();
    var unitName = $(this).parents("tr").children("td").eq(2).html();
    $("#newUnit-code").val(unitCode);
    $("#newUnit-name").val(unitName);
    $("#curr_unitId").val(unitId);
    $("#newUnit").show();
    $("#backfloat").show();

}


/*打开弹窗*/
function showPop(){
    $("#newUnit").show();
    $("#backfloat").show();
    $("#newUnit-code").val("");
    $("#newUnit-name").val("");

}

/*关闭添加弹窗*/
function closePop(){
    $("#newUnit").hide();
    $("#backfloat").hide();
    $("#newUnit-code").val("");
    $("#newUnit-name").val("");
}

/*分页数据初始化*/
function pageList(pageNo,pageSize){
    $.ajax({
        url: path+"/unit/page",
        data: {
            "pageNo":pageNo,
            "pageSize":pageSize
        },
        type: "post",
        dataType: "json",
        success: function (res) {
            if(res.status == 1){
                //存入隐藏域，初始化加载
                var pageNo = res.data.pageNum; //当前页
                var total = res.data.total;  //总数量
                page(pageNo,total);

                //获取数据并向表体添加
                var datalength = res.data.list.length;
                var unitTable=$("#unit-tbody");
                for(var i=0;i<datalength;i++){
                    var unitName = res.data.list[i].unitName;
                    var unitCode = res.data.list[i].unitCode;
                    var unitId = res.data.list[i].unitId;
                    //向表体添加行
                    var str = ""+ "<tr><td class='unit-id' style='display: none'>" +unitId
                        + "</td><td>"+unitCode+"</td><td>"+unitName+"</td>"
                        +'<td><input class="tb-b-edit" type="button" value="编辑">&nbsp;&nbsp;' +
                        '<input class="tb-b-del" type="button" value="删除"></td>';
                    var $tr = $(str);
                    unitTable.append($tr);
                }

            }
        },
        error: function () {
            console.log("添加单位发生异常")
        }
    })
}


/*加载分页*/
//pageNo 当前页码
//num 数据总条数
function page(pageNo,total){
    $("#myPage").sPage({
        page:pageNo,//当前页码，必填
        total:total,//数据总条数，必填
        pageSize:10,//每页显示多少条数据，默认10条
        totalTxt:"共{total}条",//数据总条数文字描述，{total}为占位符，默认"共{total}条"
        showTotal:true,//是否显示总条数，默认关闭：false
        showSkip:true,//是否显示跳页，默认关闭：false
        showPN:true,//是否显示上下翻页，默认开启：true
        prevPage:"上一页",//上翻页文字描述，默认“上一页”
        nextPage:"下一页",//下翻页文字描述，默认“下一页”
        backFun:function(page){
            //点击分页按钮回调函数，返回当前页码
             //清空记录
             $("#unit-tbody").html("");
             //加载数据，调用 分页单击事件
             findPage(page,10)
        }
    });
}

//分页单击事件
function findPage(pageNo,pageSize){
    $.ajax({
        url: path+"/unit/page",
        data: {
            "pageNo":pageNo,
            "pageSize":pageSize
        },
        type: "post",
        dataType: "json",
        success: function (res) {
            if(res.status == 1){
                //获取数据并向表体添加
                var datalength = res.data.list.length;
                var unitTable = $("#unit-table");
                for(var i=0;i<datalength;i++){
                    var unitName = res.data.list[i].unitName;
                    var unitCode = res.data.list[i].unitCode;
                    var unitId = res.data.list[i].unitId;
                    //向表体添加行
                    unitTable.append( "<tr><td class='unit-id' style='display: none'>" +unitId
                        + "</td><td>"+unitCode+"</td><td>"+unitName+"</td>"
                        +'<td><input class="tb-b-edit" type="button" value="编辑">&nbsp;&nbsp;' +
                        '<input class="tb-b-del" type="button" value="删除"></td>');
                }

            }
        },
        error: function () {
            console.log("添加单位发生异常")
        }
    })
}