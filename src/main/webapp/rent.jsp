
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Car rental | checkout</title>
</head>
<body>

<h1 align="center">Enter order details</h1>

<form action = "rent" method="post">
    <label for="series__passport" style="position:fixed;
        top: 95px;
        left:370px;
        font-size: large">Passport series :</label>
    <input type="text" name="series__passport" id="series__passport" value="" class=c required>

    <label for="number__passport" style="position:fixed;
        top: 160px;
        left:370px;
        font-size: large">Passport number: </label>
    <input type="text" name="number__passport" id="number__passport" value="" class=c2 required>

    <label for="time" style="position:fixed;
        top: 225px;
        left:370px;
        font-size: large">Rental time (in hours): </label>
    <input type="text" name="time" id="time" value="" class=c3 required>

    <input type="checkbox" style=" position: fixed; top: 283px; left: 596px" id="driver" name="driver" value="">
    <label for="driver" style=" position: fixed; top: 284px; left: 619px">With driver (5$/hour) </label><br>
    <input type="checkbox" style=" position: fixed; top: 312px; left: 596px" id="driver2" name="driver2" value="">
    <label for="driver2" style=" position: fixed; top: 312px; left: 619px">Without driver</label><br>
    <input type="submit" name="rent" class=c4 value="Rent ">
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
        top: 345px;
        left: 573px;
        height: 55px;
        width: 250px
    }
</style>
</html>
