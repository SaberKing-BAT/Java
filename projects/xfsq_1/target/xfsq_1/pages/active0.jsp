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
                <a><cite>活动组织</cite></a>
                <a><cite></cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:window.location.reload();" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <table class="layui-table">
        <thead>
        <tr>
            <th>主题</th>
            <th>时间</th>
            <th>地点</th>
            <th>内容</th>
            <th >活动类型</th>
            <th >活动状态</th>
            <th>一键报名</th>
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
    getList()
    function getList(){
        $.ajax({
            type: 'get',
            url: "${pageContext.request.contextPath}/ifActive",
            cache: false,
            data:{
                tiaojian:"4",
                canshu:"人员征集"
            },
            dataType: 'json',
            success: function(data) {
               /* console.table(data)
                alert(data.rlist);*/
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
            var info=JSON.stringify(data[i].hmatter)
            tableHtml += "<tr>";
            tableHtml +=    "<td>"+data[i].hname + "</td>";
            tableHtml +=    "<td>"+data[i].htime + "</td>";
            tableHtml +=    "<td>"+data[i].haddress + "</td>";
            tableHtml +=  " <td class='td-manage'>"                                                    /*info这里有大问题，数字可以，字符串不行*/
                +"<a title='查看' href='javascript:;' onclick='person_look(&quot;修改&quot; ,&quot;goinfo&quot;,"+info+",&quot;700&quot;,&quot;500&quot;)' class='ml-5' style='text-decoration:none'>"
                +  "<i class='layui-icon'><img src='${pageContext.request.contextPath}/static/images/look.png' width='15' height='15'></img></i>"
                +"</a>"
                +"</td>"
            /*tableHtml +=    "<td>"+data[i].hmatter + "</td>";*/
            tableHtml +=    "<td>"+"<span class='layui-btn '>"
                +data[i].htype
                +"</span>"
                +"</td>";
            tableHtml +=    "<td>"+"<span class='layui-btn layui-btn-warm'>"
                +data[i].hstatus
                +"</span>"
                +"</td>";
            tableHtml +=  " <td class='td-manage'>"
                +"<a title='报名' href='javascript:;' onclick='person_add( "+data[i].hid+")' class='ml-5' style='text-decoration:none'>"

                +  "<i class='layui-icon'><img src='${pageContext.request.contextPath}/static/images/look.png' width='15' height='15'></img></i>"
                +"</a>"

            tableHtml += "<tr>";
        }
        $("#table_data").html(tableHtml);
    }


    function question_show (argument) {
        layer.msg('唯一标识',{icon:1,time:1000});
    }
    /*（一键报名）添加*/
    function person_add(hid){
        $.ajax({
            type: 'post',
            url: "${pageContext.request.contextPath}/ActiveManAdd",
            cache: false,
            data:{
                aid:hid
            },
            dataType: 'text',
            success: function(data) {
                /* console.table(data)*/
                layer.alert(
                    '报名成功！' ,
                    { icon: 6 }
                )
               // showList(data.rlist);
            },
            error: function() {
                layer.alert(
                    '不可重复报名！' ,
                    { icon: 7 }
                )
            }
        })
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
                console.table(data)
                //数据回显
                var body=layer.getChildFrame('body',index);
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