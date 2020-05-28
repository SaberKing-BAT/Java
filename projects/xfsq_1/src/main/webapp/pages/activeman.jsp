<%--
  Created by IntelliJ IDEA.
  User: LYC
  Date: 2020/4/3
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: LYC
  Date: 2020/3/3
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        数据管理
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/x-admin.css" media="all">
</head>
<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>公益文化</cite></a>
                <a><cite>参与人员</cite></a>
                <a><cite></cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:window.location.reload();" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <form class="layui-form x-center"  id="sousuoform" style="width: 530px">
        <div class="layui-form-pane">
            <div class="layui-form-item">
                <div class="layui-input-inline layui-bg-cyan"  style="width: 120px">
                    <select lay-verify="required" id="tianjian" name="tiaojian">
                        <option value="0" selected="selected">活动编号</option>
                    </select>
                </div>
                <div class="layui-input-inline" style="width: 280px">
                    <input type="text" name="aaid"  placeholder="输入唯一id" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline" style="width: 100px">
                    <button class="layui-btn"id="sousuo" type="button"  lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                </div>
            </div>
        </div>
    </form>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon">&#xe640;</i>批量删除</button>
        <span class="x-right" style="line-height:10px">x条记录</span></xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <input type="checkbox" name="" value="" id="selectAll">
            </th>
            <th>唯一id</th>
            <th>活动id</th>
            <th>活动名称</th>
            <th>参与人员</th>
            <th>审核状态</th>
            <th>评价</th>
            <th>修改</th>
        </tr>
        </thead>
        <tbody id ="table_data">
        </tbody>
    </table>

    <div id="page"></div>
</div>
<br /><br /><br />
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/js/x-layui.js" charset="utf-8"></script>
<script>
    totaldatas=123;//总数据
    totalpage=1;//总页数
    curr=1;//当前页
    pageSize=5; //一页数据量
    getList(1,5);
    function getList(pageNo,pageSize){
        $.ajax({
            type: 'get',
            url: "activeManList",
            cache: false,
            data:{
                pageNo:pageNo,
                pageSize:pageSize
            },
            dataType: 'json',
            success: function(data) {
                console.table(data)
                //alert(data.rlist);
                $('.x-right').text(data.counts+"条记录");
                curr=data.pageNo;
                totalpage=Math.ceil(data.counts/pageSize);
                showList(data.rlist);
            }
        })
    }


    layui.use(['form','laydate','element','laypage','layer'], function(){
        $ = layui.jquery;//jquery
        var form = layui.form(),
            laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层
        //调用分页
        laypage({
            cont: 'page',  //分页需要显示的地方
            pages: totalpage,    //总页数
            curr: curr,     //当前页
            groups: 10,//连续显示分页数
            skip: true,     //是否开启跳页
            first: '首页',
            last: '尾页',
            skin: 'molv',   //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00
            prev: '<', //若不显示，设置false即可
            next: '>', //若不显示，设置false即可
            jump: function (e, first) { //触发分页后的回调
                if (!first) { //一定要加此判断，否则初始时会无限刷新
                    curr = e.curr;
                    getList(curr,pageSize);
                }
            }
        });


    });
    function showList(data){
        var tableHtml="";
        for(var i in data){
            resident=JSON.stringify(data[i]);
            aaid=JSON.stringify(data[i].aaid);
            tableHtml += "<tr>";
            tableHtml += "<td>"+" <input type='checkbox' value="+aaid+" name='checkbox1' id='resident_id'>" + "</td>";
            tableHtml +=    "<td>"+data[i].aaid + "</td>";
            tableHtml +=    "<td>"+data[i].activeInfo.hid + "</td>";
            tableHtml +=    "<td>"+data[i].activeInfo.hname + "</td>";
            tableHtml +=    "<td>"+data[i].resident.jname + "</td>";
            tableHtml +=    "<td>"+"<span class='layui-btn '>"
                +data[i].schedule
                +"</span>"
                +"</td>";
            tableHtml +=    "<td>"+data[i].aresult + "</td>";
            tableHtml +=  " <td class='td-manage'>"
                +"<a title='修改' href='javascript:;' onclick='person_look(&quot;修改&quot; ,&quot;goActiveManUpdate&quot;, "+data[i].aaid+",&quot;400&quot;,&quot;400&quot;)' class='ml-5' style='text-decoration:none'>"

                +  "<i class='layui-icon'><img src='${pageContext.request.contextPath}/static/images/look.png' width='15' height='15'></img></i>"
                +"</a>"

            tableHtml += "<tr>";
        }
        $("#table_data").html(tableHtml);
    }

    //批量删除提交
    function delAll () {
        layer.confirm('确认要删除吗？',function(){
            var checkedList=new  Array();
            //捉到所有被选中的，发异步进行删除
            $("input[name='checkbox1']:checked").each(function () {
                checkedList.push($(this).val());
            });
            if (checkedList.length==0){
                layer.msg('请至少选择一条数据'+checkedList, {icon: 1});
            }else {
                aaids=checkedList;
                $.ajax({
                    type:"post",
                    url: "delActiveMan",
                    data:{aaids:aaids},
                    dataType: "text",
                    success:function (data) {
                        //$("input[name='checkbox1']:checked").attr("checkde",false);
                        layer.msg('删除成功', {icon: 1});
                        //延迟1秒刷新页面
                        setTimeout(function () {
                            window.location.reload();
                        }, 1000);
                    }
                });
            }
        });
    }
    // 复选框的全选和全不选
    $(function() {
        // 获得上面的复选框
        var $selectAll = $("#selectAll");
        // alert($selectAll.prop("checked")); // 返回undefined未定义
        $selectAll.click(function() {
            // alert($selectAll.prop("checked"));
            if ($selectAll.prop("checked") == true) {
                // 上面的复选框已被选中
                $(":checkbox[name='checkbox1']").prop("checked", true);
            } else {
                // 上面的复选框没被选中
                $(":checkbox[name='checkbox1']").prop("checked", false);
            }
        });
    });
    function question_show (argument) {
        layer.msg('唯一标识',{icon:1,time:1000});
    }
    /*添加*/
    function person_add(title,url,w,h){
        x_admin_show(title,url,w,h);
    }

    //修改
    function person_look (title,url,data,w,h) {
        x_admin_showm(title,url,data,w,h);
    }

    /*删除*/
    function person_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            alert()
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }
    <!--此段代码有毒，放到x-layui.js下报错未定义-->
    function x_admin_showm(title, url, data, w, h) {
        if (title == null || title == '') {
            title = false
        }
        if (url == null || url == '') {
            url = '404.html'
        }
        if (w == null || w == '') {
            w = 800
        }
        if (h == null || h == '') {
            h = $(window).height() - 50
        }
        layer.open({
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false, //不固定
            maxmin: true,
            shadeClose: true,
            shade: 0.4,
            title: title,
            content: url,
            success:function (layero, index) {
                console.table(data)
                //数据回显
                var body=layer.getChildFrame('body',index);
                body.contents().find("#aaid").val(data);

            }
        })
    }
    //条件查询
    $("#sousuo").click(function() {
        $.ajax({
            type: 'get',
            url: "${pageContext.request.contextPath}/ifActiveMan",
            cache: false,
            data:  $('#sousuoform').serialize(),
            dataType:'json',
            success: function (data) {
                showList(data.rlist)
                $('.x-right').text(data.rlist.length+"条记录");
                $("#page").hide();
            }
        });
    });
</script>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>

</body>
</html>
