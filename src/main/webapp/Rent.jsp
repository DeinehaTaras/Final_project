
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Rent</title>
</head>
<body>

<h1 align="center">Оформить заказ</h1>

<form action = "" method="post">

    <label for="series__passport" style="position:fixed;
        top: 95px;
        left:370px;
        font-size: large">Серия паспорта :</label>
    <input type="text" name="series__passport" id="series__passport" value="" class=c required>

    <label for="number__passport" style="position:fixed;
        top: 160px;
        left:370px;
        font-size: large">Номер паспорта: </label>
    <input type="text" name="number__passport" id="number__passport" value="" class=c2 required>

    <label for="time" style="position:fixed;
        top: 225px;
        left:370px;
        font-size: large">Срок аренды (в часах): </label>
    <input type="text" name="time" id="time" value="" class=c3 required>

    <input type="checkbox" id="driver" name="driver" value="">
    <label for="driver">С водителем</label><br>
    <input type="checkbox" id="driver2" name="driver2" value="">
    <label for="driver2">Без водителя</label><br>
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
</style>
</html>
