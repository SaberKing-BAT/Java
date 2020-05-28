<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>
        心健新闻-添加
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
<div class="x-body">
    <form class="layui-form">
        <div class="layui-form-item">
            <label for="link" class="layui-form-label">
                <span class="x-red">*</span>身份证
            </label>
            <div class="layui-input-inline">
                <input type="text" id=pid name="pid" required lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="link" class="layui-form-label">
                <span class="x-red">*</span>申请人
            </label>
            <div class="layui-input-inline">
                <input type="text" id="link" name="pname" required lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="link" class="layui-form-label">
                <span class="x-red">*</span>申请时间
            </label>
            <div class="layui-input-inline">
                <input type="text"  name="time" required lay-verify="required"
                       placeholder="格式：2020-09-09"   autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="link" class="layui-form-label">
                <span class="x-red">*</span>审核状态
            </label>
            <div class="layui-input-inline">
                <select lay-verify="required" id="schedule" name="schedule">
                    <option value="一级贫困" selected="selected">一级贫困</option>
                    <option value="二级贫困">二级贫困</option>
                    <option value="三级贫困">三级贫困</option>
                    <option value="未通过">未通过</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>贫困情况
            </label>
            <div class="layui-input-inline">
                        <textarea id="L_content" name="pinfo"
                                  placeholder="贫困情况" class="layui-textarea fly-editor" style="width:500px ;height:400px;"></textarea>
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="add" lay-submit="">
                立即发布
            </button>
        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8">
</script>
<script src="${pageContext.request.contextPath}/static/js/x-layui.js" charset="utf-8">
</script>
<script>
    layui.use(['form','layer','upload'], function(){
        $ = layui.jquery;
        var form = layui.form()
            ,layer = layui.layer;
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
            var  intime= $("input[name='time']").val();
            if (!intime.match(/^\d{4}-\d{2}-\d{2}$/)){
                layer.msg('日期格式错误！', {icon: '&#x1006'});
            }else {
                //表单序列化，异步提交
                var formdata = $('.layui-form').serialize();
                $.ajax({
                    type: 'post',
                    url: 'addPinKun',
                    cache: false,
                    data: formdata, //重点必须为一个变量如：data
                    dataType: 'text',
                    success: function (data) {
                        reslut("添加成功");
                    },
                    error:function () {
                        reslut("添加失败")
                    }
                })
            }
            return false
        })
    });
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
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>

</html>
