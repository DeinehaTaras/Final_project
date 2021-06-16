<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car rental | take cars</title>
</head>
<body>
<h1 align="center">Choose option</h1>
<form action = "takeCar.jsp" method="post">
    <input type="submit" name="take" class=c value="Take a car">
</form>
<form action = "giveFine.jsp" method="post">
    <input type="submit" name="giveAFine" class=c2 value="Give a fine">
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

