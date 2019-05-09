<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
    <link href="css/login.css" type="text/css" rel="stylesheet" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="js/login.js"></script>
    <script type="text/javascript">
        function reloadCode(){
            var time = new Date().getTime();
            document.getElementById("imgCode").src="/VerifyCode?d=" + time;
        }
    </script>
</head>
<body>
<div class="container center">
    <!-- logo -->
    <div class="row">
        <img src="img/eye-blue.png">
        <span>Foodie</span>
    </div>
    <!-- 登录表单 -->
    <form class="form-horizontal" action="/login" method="post" onsubmit="return check()">
        <div class="row">
            <!-- 用户名 -->
            <input type="text" class="form-control" name="email" placeholder="邮箱">
            <!-- 密码 -->
            <input type="password" class="form-control" name="password" placeholder="密码">

        </div>

        <div class="row">
            <!-- 登录按钮 -->
            <button type="submit" class="btn btn-default btn-success">登录</button>
        </div>
    </form>
</div>

<!-- 页脚 -->


<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
