<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
    />

    <title>登录</title>
    <link
            rel="stylesheet"
            href="./static/lib/layui/css/layui.css"
            media="all"
    />
    <link rel="stylesheet" href="./static/css//login.css" />
</head>

<body class="beg-login-bg" background="./static/images/bg.jpg">
<div class="beg-login-box">
    <header>
        <h1>欢迎登录</h1>
    </header>
    <div class="beg-login-main">
        <form class="layui-form">
            <input
                    name="__RequestVerificationToken"
                    type="hidden"
                    value="fkfh8D89BFqTdrE2iiSdG_L781RSRtdWOH411poVUWhxzA5MzI8es07g6KPYQh9Log-xf84pIR2RIAEkOokZL3Ee3UKmX0Jc8bW8jOdhqo81"
            />

            <!---->
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe612;</i>
                </label>
                <select name="userType">
                    <option value="0">用户登录</option>
                    <option value="1">管理员登陆</option>
                </select>
            </div>
            <!---->

            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe612;</i>
                </label>
                <input
                        type="text"
                        name="userName"
                        lay-verify="userName"
                        autocomplete="off"
                        placeholder="请输入账号"
                        class="layui-input"
                        id="username"
                />
            </div>
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe642;</i>
                </label>
                <input
                        type="password"
                        name="password"
                        lay-verify="password"
                        autocomplete="off"
                        placeholder="请输入密码"
                        class="layui-input"
                        id="password"
                />
            </div>
            <div class="layui-form-item">
                <div class="beg-pull-left beg-login-remember">
                    <label>记住帐号？</label>
                    <input
                            type="checkbox"
                            name="rememberMe"
                            value="true"
                            lay-skin="switch"
                            checked
                            title="记住帐号"
                    />
                </div>
                <div class="beg-pull-right">
                    <button
                            class="layui-btn layui-btn-primary"
                            lay-submit
                            lay-filter="login"
                    >
                        <i class="layui-icon">&#xe650;</i> 登录
                    </button>
                </div>
                <div class="beg-clear"></div>
            </div>
        </form>
    </div>
</div>
<!--必须按顺序引入-->
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript" src="./static/lib//layui/layui.js"></script>
<script>
    <!--读取cookie-->
    $(document).ready(function(){
        var cookiename=$.cookie('username');
        var cookiepass=$.cookie('password')
        if (cookiename!=null){
            $("#username").val(cookiename);
            $("#password").val(cookiepass);
        }
    })
    layui.use(['layer', 'form'], function() {
        var layer = layui.layer,
            $ = layui.jquery,
            form = layui.form()

        form.on('submit(login)', function(data) {
            var userName = $("input[name='userName']").val();
            var password = $("input[name='password']").val();
            var userType = $("select[name='userType']").val();
            if (userName == '' && password == '') {
                alert('账号或密码不能为空！')
                //阻止表单提交（阻止元素发生默认的行为。）
                event.preventDefault()
            } else {
                //var targetUrl = $('#addForm').attr('action')
                var data = $('.layui-form').serialize();
                $.ajax({
                    type: 'post',
                    url: 'login',
                    cache: false,
                    data: data, //重点必须为一个变量如：data
                    dataType: 'text',
                    success: function(result) {
                        if(result=="seccuss"){
                            layer.alert(
                                '登录成功',
                                { icon: 6 }
                            )
                            location.href="goindex/"+userType;
                        }else {
                            layer.alert(
                                '请检查账号密码！' ,
                                { icon: 6 }
                            )
                        }
                    },
                    error: function() {
                        layer.alert(
                            '请检查账号密码！' ,
                            { icon: 6 }
                        )
                    }
                })
            }
            return false
        })
    })

</script>
</body>
</html>
