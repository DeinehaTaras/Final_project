<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car rental | modify car info</title>
</head>
<body>
<h1 align="center">Enter the car Id to ban</h1>

<form action = "changeImage" method="post">
    <label for="carId" style="
    position:fixed;
        top: 95px;
        left:385px;
        font-size: xx-large">Car Id :</label>
    <input type="text" name="carId" id="carId" value="" class=c required>
    <label for="image" style="
    position:fixed;
        top: 160px;
        left:385px;
        font-size: xx-large">Image name :</label>
    <input type="text" name="image" id="image" value="" class=c2 required>

    <input type="submit" name="modify" class=c3 value="Modify ">

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

</body>
</html>
