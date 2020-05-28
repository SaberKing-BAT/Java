<%--
  Created by IntelliJ IDEA.
  User: LYC
  Date: 2020/3/4
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>
        用户添加
    </title>
    <meta name="renderer" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, maximum-scale=1"
    />
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/x-admin.css" media="all"/>
</head>

<body>
<div class="x-body">
    <form class="layui-form layui-form-pane">
        <div class="layui-form-item">
            <label for="L_title" class="layui-form-label">
                身份证号
            </label>
            <div class="layui-input-block">
                <input
                        type="text"
                        id="jid"
                        name="jid"
                        required
                        lay-verify="title"
                        autocomplete="off"
                        class="layui-input"
                />
            </div>
            <label for="L_title" class="layui-form-label">
                姓名
            </label>
            <div class="layui-input-block">
                <input
                        type="text"
                        id="jname"
                        name="jname"
                        required
                        lay-verify="title"
                        autocomplete="off"
                        class="layui-input"
                />
            </div>
            <label class="layui-form-label">
                性别
            </label>
            <div class="layui-input-block">
                <select lay-verify="required" name="jsex" id="jsex">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <label for="L_title" class="layui-form-label">
                年龄
            </label>
            <div class="layui-input-block">
                <input
                        type="text"
                        id="jage"
                        name="jage"
                        required
                        lay-verify="title"
                        autocomplete="off"
                        class="layui-input"
                />
            </div>
            <label for="L_title" class="layui-form-label">
                电话
            </label>
            <div class="layui-input-block">
                <input
                        type="text"
                        id="jphone"
                        name="jphone"
                        required
                        lay-verify="title"
                        autocomplete="off"
                        placeholder="也是登录账号"
                        class="layui-input"
                />
            </div>
            <label for="L_title" class="layui-form-label">
                住址
            </label>
            <div class="layui-input-block">
                <input
                        type="text"
                        id="jadress"
                        name="jadress"
                        required
                        lay-verify="title"
                        autocomplete="off"
                        class="layui-input"
                />
            </div>
            <label for="L_title" class="layui-form-label">
                户籍
            </label>
            <div class="layui-input-block">
                <input
                        type="text"
                        id="idadress"
                        name="idadress"
                        required
                        lay-verify="title"
                        autocomplete="off"
                        class="layui-input"
                />
            </div>
            <label for="L_title" class="layui-form-label">
                入住时间
            </label>
            <div class="layui-input-block">
                <input
                        type="text"
                        id="L_title"
                        name="intime"
                        required
                        lay-verify="title"
                        autocomplete="off"
                        placeholder="格式：2010-01-01"
                        class="layui-input"
                />
            </div>
            <label for="L_title" class="layui-form-label">
                密码
            </label>
            <div class="layui-input-block">
                <input
                        type="text"
                        id="jpw"
                        name="jpw"
                        required
                        lay-verify="title"
                        autocomplete="off"
                        class="layui-input"
                />
            </div>
        </div>
        <div class="layui-form-item">
            <button class="layui-btn" lay-filter="add" lay-submit>
                立即发布
            </button>
        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/js/x-layui.js" charset="utf-8"></script>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>


<script>
    layui.use(['form', 'layer', 'layedit'], function () {
        $ = layui.jquery
        var form = layui.form(),
            layer = layui.layer,
            layedit = layui.layedit
        //创建一个编辑器
        editIndex = layedit.build('L_content')
        //验证
        //监听提交
        form.on('submit(add)', function (data) {
            //判断表单数据是否为空
            var t = $('.layui-form').serializeArray();
            $.each(t,function(i,item){
                if(item['value'] == '') {
                    showMsg('信息不可为空')
                    flag = 1;
                    return false
                } else {
                    flag = 0;
                }
            })
            var  intime= $("input[name='intime']").val();
            if (!intime.match(/^\d{4}-\d{2}-\d{2}$/)){
                layer.msg('日期格式错误！', {icon: '&#x1006'});
            }else {
                //表单序列化，异步提交
                var formdata = $('.layui-form').serialize();
                $.ajax({
                    type: 'post',
                    url: 'updateResident',
                    cache: false,
                    data: formdata, //重点必须为一个变量如：data
                    dataType: 'text',
                    success: function (data) {
                        reslut("修改成功");
                    },
                    error:function () {
                        reslut("修改失败");
                    }
                })
            }
            return false
        })
    })
    function reslut(rmsg) {
        layer.msg(rmsg, {icon: 1},
            function() {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name)
                //关闭当前frame
                parent.layer.close(index)
            });
        setTimeout(function () {
            parent.location.reload();
        }, 1000);
    }
</script>
<script>
    var _hmt = _hmt || []
    ;(function () {
        var hm = document.createElement('script')
        var s = document.getElementsByTagName('script')[0]
        s.parentNode.insertBefore(hm, s)
    })()
</script>
</body>
</html>
