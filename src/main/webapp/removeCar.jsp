<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car rental | remove car</title>
</head>
<body>
<h1 align="center">Enter the car Id to remove</h1>

<form action = "removeCar" method="post">
    <label for="carId" style="position:fixed;
        top: 95px;
        left:385px;
        font-size: xx-large">Car Id :</label>
    <input type="text" name="carId" id="carId" value="" class=c required>

    <input type="submit" name="remove" class=c2 value="Remove ">

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
