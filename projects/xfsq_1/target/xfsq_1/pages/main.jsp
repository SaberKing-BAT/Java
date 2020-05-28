<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html >
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
        .image{
            /*background-size: contain;*/
            width: 1668px;
            height: 700px;
        }
        .image img{
            width: 1668px;
            height: 700px;
        }
    </style>
</head>
<body>
<div class="image">
    <img src="${pageContext.request.contextPath}/static/images/main.jpg"/>
</div>
</body>
</html>