<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car rental | remove car</title>
</head>
<body>
<h1 align="center">Enter the user Id to unban</h1>

<form action = "unbanUser" method="post">
    <label for="userId" style="position:fixed;
        top: 95px;
        left:385px;
        font-size: xx-large">User Id :</label>
    <input type="text" name="userId" id="userId" value="" class=c required>

    <input type="submit" name="unban" class=c2 value="Unban ">

</form>

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
</style>

</body>
</html>

