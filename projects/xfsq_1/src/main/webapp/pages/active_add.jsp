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
                <span class="x-red">*</span>活动主题
            </label>
            <div class="layui-input-inline">
                <input type="text" id="link" name="hname" required lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="link" class="layui-form-label">
                <span class="x-red">*</span>活动时间
            </label>
            <div class="layui-input-inline">
                <input type="text"  name="htime" required lay-verify="required"
                       placeholder="格式：2020-09-09"   autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="link" class="layui-form-label">
                <span class="x-red">*</span>活动地点
            </label>
            <div class="layui-input-inline">
                <input type="text" id="" name="haddress" required lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="link" class="layui-form-label">
                <span class="x-red">*</span>活动类型
            </label>
            <div class="layui-input-inline">
                <select lay-verify="required" name="htype">
                    <optgroup label="模块">
                        <option value="公益活动" selected="selected">公益活动</option>
                        <option value="文化活动" >文化活动</option>
                        <option value="赛事活动">赛事活动</option>
                    </optgroup>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="link" class="layui-form-label">
                <span class="x-red">*</span>活动状态
            </label>
            <div class="layui-input-inline">
                <select lay-verify="required" id="hstatus" name="hstatus">
                    <option value="人员征集" selected="selected">人员征集</option>
                    <option value="活动开展">活动开展</option>
                    <option value="活动结束">活动结束</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>活动内容
            </label>
            <div class="layui-input-inline">
                        <textarea id="L_content" name="hmatter"
                                  placeholder="简介" class="layui-textarea fly-editor" style="width:500px ;height:400px;"></textarea>
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
            var  intime= $("input[name='htime']").val();
            if (!intime.match(/^\d{4}-\d{2}-\d{2}$/)){
                layer.msg('日期格式错误！', {icon: '&#x1006'});
            }else {
                //表单序列化，异步提交
                var formdata = $('.layui-form').serialize();
                $.ajax({
                    type: 'post',
                    url: 'addActiveInfo',
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
