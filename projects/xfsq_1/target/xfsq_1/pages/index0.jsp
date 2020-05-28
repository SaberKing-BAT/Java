<%--
  Created by IntelliJ IDEA.
  User: LYC
  Date: 2020/3/3
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        index
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/x-admin.css" media="all">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <a class="logo">
                <img src="${pageContext.request.contextPath}/static/images/banner1.png"></img>
            </a>
            <ul class="layui-nav" lay-filter="">
                <li class="layui-nav-item"><img src="${pageContext.request.contextPath}/static/images/0.jpg" class="layui-circle" style="border: 2px solid #A9B7B7;" width="35px" alt=""></li>
                <li class="layui-nav-item">
                    <a href="javascript:;">admin</a>
                    <dl class="layui-nav-child"> <!-- 二级菜单 -->
                        <dd><a href="${pageContext.request.contextPath}/loginout">切换帐号</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/loginout">退出</a></dd>
                    </dl>
                </li>

                <%--                <li class="layui-nav-item x-index"><a href=".${pageContext.request.contextPath}/static/网页/index.html">前台首页</a></li>--%>
            </ul>
        </div>
    </div>
    <div class="layui-side layui-bg-black x-side">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">

                <!--********社区管理********-->
                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">
                        <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>物业报修</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd class="">
                        <dd class="">
                            <a href="javascript:;" _href="${pageContext.request.contextPath}/goWuyebxMe">
                                <i class="layui-icon"></i><cite>我要报修</cite>
                            </a>
                        </dd>
                        </dd>
                    </dl>
                </li>
                <!--********爱心帮扶********-->
                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">
                        <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>卫生安全</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd class="">
                        <dd class="">
                            <a href="javascript:;" _href="${pageContext.request.contextPath}/goMyGongGaoMain">
                                <i class="layui-icon"></i><cite>小区公告</cite>
                            </a>
                        </dd>
                    </dl>
                </li>
                <!--********志愿活动********-->
                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">
                        <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>公益文化</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd class="">
                        <dd class="">
                            <a href="javascript:;" _href="${pageContext.request.contextPath}/goActiveInfo">
                                <i class="layui-icon"></i><cite>小区活动</cite>
                            </a>
                        </dd>
                        </dd>
                    </dl>
                </li>

                <!--********扶贫********-->
                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">
                        <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>小区扶贫</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd class="">
                        <dd class="">
                            <a href="javascript:;" _href="${pageContext.request.contextPath}/goMainMe">
                                <i class="layui-icon"></i><cite>贫困申报</cite>
                            </a>
                        </dd>
                        </dd>
                    </dl>
                </li>
                <!--********个人中心********-->
                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">
                        <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>个人中心</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd class="">
                        <dd class="">
                            <a href="javascript:;" _href="${pageContext.request.contextPath}/goPassword">
                                <i class="layui-icon"></i><cite>密码重置</cite>
                            </a>
                        </dd>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>

    </div>
    <div class="layui-tab layui-tab-card site-demo-title x-main" lay-filter="x-tab" lay-allowclose="true">
        <div class="x-slide_left"></div>
        <ul class="layui-tab-title">
            <li class="layui-this">
                数据管理
                <i class="layui-icon layui-unselect layui-tab-close">ဆ</i>
            </li>
        </ul>
        <div class="layui-tab-content site-demo site-demo-body">
            <div class="layui-tab-item layui-show">
                <iframe frameborder="0" src="${pageContext.request.contextPath}/pages/main.jsp" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
    <div class="site-mobile-shade">
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/js/x-admin.js"></script>
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
