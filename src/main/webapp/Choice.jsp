
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>

<h1 align="center" style="color: red">Логин или пароль неверный</h1>

<form action = "oneMoreLogin" method="post">
    <input type="submit" name="loginBut" value="Попробывать ещё раз " style="font-weight: 800;
        font-size: large;
        position: fixed;
        top: 75px;
        left: 570px;
        height: 55px;
        width: 250px">
</form>

<form action = "doRegist" method="post">
    <input type="submit" name="goReg" class=c3 value="Зарегистрироваться " style="font-weight: 800;
        font-size: large;
        position: fixed;
        top: 143px;
        left: 570px;
        height: 55px;
        width: 250px">
</form>

</body>
</html>
