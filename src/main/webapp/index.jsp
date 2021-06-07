
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<h1 align="center">Авторизация</h1>
<form action = "login" method="post">

    <label for="login" style="position:fixed;
        top: 95px;
        left:430px;
        font-size: xx-large">Логин :</label>
    <input type="text" name="login" id="login" value="" class=c required>

    <label for="password" style="position:fixed;
        top: 160px;
        left:430px;
        font-size: xx-large">Пароль: </label>
    <input type="password" name="password" id="password" value="" class=c2 required>

    <input type="submit" name="signIn" class=c3 value="Войти ">
</form>

</body>
<style>
    .c {
        font-weight: 800;
        font-size: large;
        position: fixed;
        top: 75px;
        left: 570px;
        height: 55px;
        width: 250px
    }

    .c2 {
        font-weight: 800;
        font-size: large;
        position: fixed;
        top: 143px;
        left: 570px;
        height: 55px;
        width: 250px
    }
    .c3 {
        font-weight: 800;
        font-size: large;
        position: fixed;
        top: 211px;
        left: 570px;
        height: 55px;
        width: 250px
    }
</style>


</html>
