<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car rental | Sign in</title>
</head>
<body>
<h1 align="center">Sign in</h1>
<form action="login" method="post">

    <label for="login" style="position:fixed;
        top: 95px;
        left:430px;
        font-size: xx-large">Login :</label>
    <input type="text" name="login" id="login" value="" class=c required>

    <label for="password" style="position:fixed;
        top: 160px;
        left:430px;
        font-size: xx-large">Password: </label>
    <input type="password" name="password" id="password" value="" class=c2 required>

    <input type="submit" name="signIn" class=c3 value="Log in ">
</form>
<form action="signUp.jsp" method="post">
    <input type="submit" name="signUp" class=c4 value="Sign up ">
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
</style>
</html>
