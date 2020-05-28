<%--
  Created by IntelliJ IDEA.
  User: LYC
  Date: 2020/3/8
  Time: 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>数据分析</title>
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
              <a><cite>公益</cite></a>
                <a><cite></cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:window.location.reload();" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div
        class="chart"
        style="width:1800px; height: 500px; text-align: center; position: absolute; top: 100px;"
        ;
>
    <div id="chart1" style="width:400px; height: 400px; float: left;"></div>
    <div id="chart2" style="width:400px; height: 400px;  float: left;"></div>
    <div id="chart3" style="width:400px; height: 400px;  float: left;"></div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script
        type="text/javascript"
        src="${pageContext.request.contextPath}/static/js/echarts.min.js"
></script>

<script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/js/x-layui.js" charset="utf-8"></script>
<script type="text/javascript">
    $(document).ready(function(){
        getData();
    });
    function getData() {

        $.ajax({
            type: 'get',
            url:"residentData",
            dataType: 'json',
            success: function(data) {
                console.table(data)
                mychart(data.ages,data.years)
            }
        })
    }

    //指定图标的配置和数据


    function mychart(ages,years) {
        var option1 = {
            title: {
                text: '近10年人口增量'
            },
            tooltip: {},
            legend: {
                data: ['人数/年']
            },
            xAxis: {
                data: [
                    '2011',
                    '2012',
                    '2013',
                    '2014',
                    '2015',
                    '2016',
                    '2017',
                    '2018',
                    '2019',
                    '2020'
                ]
            },
            yAxis: {},
            series: [
                {
                    name: '人数/年',
                    type: 'line',
                    areaStyle: {
                        normal: { color: '#80ffc0' }
                    },
                    data: years
                }
            ]
        }
        var option2 = {
            color: ['#3398DB'],
            title: {
                text: '居民年龄统计图'
            },
            tooltip: {},
            legend: {
                data: ['人数']
            },
            xAxis: {
                data: ['0-12', '12-18', '18-40', '40-60', '60以上']
            },
            yAxis: {},
            series: [
                {
                    name: '人数',
                    type: 'bar',
                    data: ages
                }
            ]
        }
        option3 = {
            title: {
                text: '居民年龄分布饼图',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: '{a} <br/>{b} : {c} ({d}%)'
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['成年人', '老年人', '青年人', '中老年', '儿童']
            },
            series: [
                {
                    name: '居民年龄分布饼图',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: [
                        { value: ages[0], name: '成年人' },
                        { value: ages[1], name: '老年人' },
                        { value: ages[2], name: '青年人' },
                        { value: ages[3], name: '中老年' },
                        { value: ages[4], name: '儿童' }
                    ],
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        }
        //初始化echarts实例
        var myChart1 = echarts.init(document.getElementById('chart1'))
        //使用制定的配置项和数据显示图表
        myChart1.setOption(option1)
        var myChart2 = echarts.init(document.getElementById('chart2'))
        myChart2.setOption(option2)
        var myChart3 = echarts.init(document.getElementById('chart3'))
        myChart3.setOption(option3)
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
