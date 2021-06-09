
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car rental | Sign in</title>
</head>
<body>

<h1 align="center" style="color: red">Wrong login or password</h1>

<form action = "index.jsp" method="post">
    <input type="submit" name="loginBut" value="Try again " style="font-weight: 800;
        font-size: large;
        position: fixed;
        top: 75px;
        left: 570px;
        height: 55px;
        width: 250px">
</form>

<form action = "signUp.jsp" method="post">
    <input type="submit" name="goReg" class=c3 value="Sign up " style="font-weight: 800;
        font-size: large;
        position: fixed;
        top: 143px;
        left: 570px;
        height: 55px;
        width: 250px">
</form>

</body>
</html>
