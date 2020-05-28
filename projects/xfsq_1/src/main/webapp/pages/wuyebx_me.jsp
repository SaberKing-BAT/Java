<%--
  Created by IntelliJ IDEA.
  User: LYC
  Date: 2020/3/13
<%--
  Created by IntelliJ IDEA.
  User: LYC
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
              <a><cite>物业管理</cite></a>
                <a><cite>我要报修</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:window.location.reload();" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <xblock>
        <button class="layui-btn" onclick="person_add('添加信息','${pageContext.request.contextPath}/goWuyebxAddme','400','400')"><i class="layui-icon">&#xe608;</i>我要报修</button>
        <span class="x-right" style="line-height:10px">x条记录</span></xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>报修单号</th>
            <th>报修人</th>
            <th>联系方式</th>
            <th>报修地址</th>
            <th width="30%">报修信息</th>
            <th>报修时间</th>
            <th>处理进度</th>
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
    getlist()
    function getlist() {
        $.ajax({
            type: 'get',
            url: "${pageContext.request.contextPath}/wuyebxMeInfo",
            cache: false,
            dataType:'json',
            success: function (data) {
                showList(data.rlist)
                $('.x-right').text(data.rlist.length+"条记录");
            }
        });
    };
    layui.use(['form','laydate','element','laypage','layer'], function() {
        $ = layui.jquery;//jquery
        var form = layui.form(),
            laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层
    });

    function showList(data){
        var tableHtml="";
        for(var i in data){
            tableHtml += "<tr>";
            tableHtml +=    "<td>"+data[i].wid + "</td>";
            tableHtml +=    "<td>"+data[i].wname + "</td>";
            tableHtml +=    "<td>"+data[i].wphone + "</td>";
            tableHtml +=    "<td>"+data[i].waddress + "</td>";
            tableHtml +=    "<td>"+data[i].winfo + "</td>";
            tableHtml +=    "<td>"+data[i].wtime + "</td>";
            tableHtml +=    "<td>"+"<span class='layui-btn layui-btn-normal layui-btn-mini'>"
            +data[i].wschedule
            +"</span>"
            +"</td>";
            tableHtml += "<tr>";
        }
        $("#table_data").html(tableHtml);
    }

    function question_show (argument) {
        layer.msg('唯一标识',{icon:1,time:1000});
    }
    /*添加*/
    function person_add(title,url,w,h){
        x_admin_show(title,url,w,h);
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
                //数据回显
                var body=layer.getChildFrame('body',index);
                body.contents().find("#wid").val(data.wid);
                body.contents().find("#wname").val(data.wname);
                body.contents().find("#wphone").val(data.wphone);
                body.contents().find("#waddress").val(data.waddress);
                body.contents().find("#winfo").val(data.winfo);
                body.contents().find("#L_title").val(data.wtime);
                body.contents().find("#wschedule").val(data.wschedule);
            }
        })
    }
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