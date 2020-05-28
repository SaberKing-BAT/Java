<%--
  Created by IntelliJ IDEA.
  User: LYC
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
                <a><cite>报修管理</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:window.location.reload();" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <xblock>
        <button class="layui-btn" onclick="person_add('我要申报','${pageContext.request.contextPath}/goAddPinKunMe','800','500')"><i class="layui-icon">&#xe608;</i>我要申报</button>
        <span class="x-right" style="line-height:10px">x条记录</span></xblock>
    <table class="layui-table" id="maintable">
        <thead>
        <tr>
            <th>身份证</th>
            <th>申报人</th>
            <th>申报内容</th>
            <th>审批状态</th>
            <th>申请时间</th>
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
<script src="${pageContext.request.contextPath}/static/excel_js/jszip.js"></script>
<script src="${pageContext.request.contextPath}/static/excel_js/FileSaver.js"></script>
<script src="${pageContext.request.contextPath}/static/excel_js/excel-gen.js"></script>
<script>
    getList();
    function getList(){
        $.ajax({
            type: 'get',
            url: "${pageContext.request.contextPath}/myPinKun",
            cache: false,
            dataType: 'json',
            success: function(data) {
                //alert(data.rlist[1]+data.counts);
                $('.x-right').text(data.rlist.length+"条记录");
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

    });
    function showList(data){
        var tableHtml="";
        for(var i in data){
            resident=JSON.stringify(data[i]);
            var info=JSON.stringify(data[i].pinfo)
            tableHtml += "<tr>";
            tableHtml +=    "<td>"+data[i].pid + "</td>";
            tableHtml +=    "<td>"+data[i].pname + "</td>";
            tableHtml +=  " <td class='td-manage'>"
                +"<a title='修改' href='javascript:;' onclick='person_look(&quot;查看&quot; ,&quot;goinfo&quot;, "+info+",&quot;850&quot;,&quot;650&quot;)' class='ml-5' style='text-decoration:none'>"

                +  "<i class='layui-icon'><img src='${pageContext.request.contextPath}/static/images/look.png' width='15' height='15'></img></i>"
                +"</a>"
                +"</td>"
           /* tableHtml +=    "<td>"+data[i].pinfo + "</td>";*/
            tableHtml +=    "<td>"+"<span class='layui-btn layui-btn-normal layui-btn-mini'>"
                +data[i].schedule
                +"</span>"
                +"</td>";
            tableHtml +=    "<td>"+data[i].time + "</td>";
            tableHtml += "<tr>";
        }
        $("#table_data").html(tableHtml);
    }

    /*添加*/
    function person_add(title,url,w,h){
        x_admin_show(title,url,w,h);
    }
    //修改
    function person_look (title,url,data,w,h) {
        x_admin_showm(title,url,data,w,h);
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
                body.contents().find("#pid").val(data);
                body.contents().find("#allinfo").val(data);
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