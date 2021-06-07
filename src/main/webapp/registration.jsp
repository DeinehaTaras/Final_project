<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
</head>
<body>

<h1 align="center">Регистрация</h1>

<form action = "registration" method="post">

    <label for="surname" style="position:fixed;
        top: 95px;
        left:430px;
        font-size: xx-large">Фамилия :</label>
    <input type="text" name="surname" id="surname" value="" class=c required>

    <label for="name" style="position:fixed;
        top: 160px;
        left:430px;
        font-size: xx-large">Имя: </label>
    <input type="text" name="name" id="name" value="" class=c2 required>

    <label for="secondName" style="position:fixed;
        top: 225px;
        left:430px;
        font-size: xx-large">Отчество: </label>
    <input type="text" name="secondName" id="secondName" value="" class=c3 required>

    <label for="phoneNumber" style="position:fixed;
        top: 285px;
        left:430px;
        font-size: xx-large">Номер телефона: </label>
    <input type="text" name="phoneNumber" id="phoneNumber" value="" class=c4>

    <label for="login" style="position:fixed;
        top: 345px;
        left:430px;
        font-size: xx-large">Логин: </label>
    <input type="text" name="login" id="login" value="" class=c5 required>

    <label for="password" style="position:fixed;
        top: 410px;
        left:430px;
        font-size: xx-large">Пароль: </label>
    <input type="password" name="password" id="password" value="" class=c6 required>

    <input type="submit" name="signup" class=c7 value="Зарегистрироваться ">
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

    .c4 {
        font-weight: 800;
        font-size: large;
        position: fixed;
        top: 279px;
        left: 570px;
        height: 55px;
        width: 250px
    }

    .c5 {
        font-weight: 800;
        font-size: large;
        position: fixed;
        top: 347px;
        left: 570px;
        height: 55px;
        width: 250px
    }
    .c6 {
        font-weight: 800;
        font-size: large;
        position: fixed;
        top: 415px;
        left: 570px;
        height: 55px;
        width: 250px
    }
    .c7 {
        font-weight: 800;
        font-size: large;
        position: fixed;
        top: 483px;
        left: 570px;
        height: 55px;
        width: 250px
    }
</style>

</html>

