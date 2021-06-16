<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car rental | add manager</title>
</head>
<body>
<h1 align="center">Choose option</h1>
<form action = "appointManager.jsp" method="post">
    <input type="submit" name="appoint" class=c value="Appoint a manager">
</form>
<form action = "createManager.jsp" method="post">
    <input type="submit" name="create" class=c2 value="Create a manager">
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
