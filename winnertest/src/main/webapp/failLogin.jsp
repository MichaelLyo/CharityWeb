<%@ page language="java" contentType="text/html; charset=GB18030"
         pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
    <title>登陸</title>
    <link rel="stylesheet" href="assets/css/reset.css">
    <link rel="stylesheet" href="assets/css/supersized.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/button.css">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>

<div class="page-container">
    <div class="wrapper">
        <div class="container">
            <strong><span style="font-weight: bold;font-size: 25px;">登  录</span></strong>
            <form class="form" action="login.do" method="post">
                <input type="text" name="username" placeholder="Username">
                <input type="password" name="password"  placeholder="Password">
                <span style="font-weight: 500;font-size: 13px;color:#FF0000">用户名和密码错误，请重试</span>
                <button type="submit" id="login-button" class="button button-3d button-plain button-border button-royal">登录</button>
                <button type="submit" id="regist-button" class="button button-3d button-plain button-border button-royal">注册</button>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<!-- Javascript -->
<script src="assets/js/jquery-1.8.2.min.js"></script>
<script src="assets/js/supersized.3.2.7.min.js"></script>
<script src="assets/js/supersized-init.js"></script>
<script src="assets/js/scripts.js"></script>

</body>
</html>