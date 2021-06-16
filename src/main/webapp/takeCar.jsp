<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car rental | take cars</title>
</head>
<body>
<h1 align="center">Enter the user Id to ban</h1>

<form action = "takeCar" method="post">
    <label for="orderId" style="
    position:fixed;
        top: 95px;
        left:385px;
        font-size: xx-large">Order Id :</label>
    <input type="text" name="orderId" id="orderId" value="" class=c required>

    <input type="submit" name="take" class=c2 value="Take a car ">

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
