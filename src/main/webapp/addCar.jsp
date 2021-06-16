<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car rental | Add car</title>
</head>
<body>
<h1 align="center">Write in all fields:</h1>
<form action = "addCar" method="post">

    <label for="brand" style="position:fixed;
        top: 95px;
        left:385px;
        font-size: xx-large">Brand :</label>
    <input type="text" name="brand" id="brand" value="" class=c required>

    <label for="model" style="position:fixed;
        top: 160px;
        left:385px;
        font-size: xx-large">Model: </label>
    <input type="text" name="model" id="model" value="" class=c2 required>

    <label for="year" style="position:fixed;
        top: 225px;
        left:385px;
        font-size: xx-large">Year: </label>
    <input type="text" name="year" id="year" value="" class=c3 required>

    <label for="color" style="position:fixed;
        top: 285px;
        left:385px;
        font-size: xx-large">Color: </label>
    <input type="text" name="color" id="color" value="" class=c4 required>

    <label for="price" style="position:fixed;
        top: 345px;
        left:385px;
        font-size: xx-large">Price: </label>
    <input type="number" name="price" id="price" value="" class=c5 required>

    <label for="pathToImage" style="position:fixed;
        top: 410px;
        left:385px;
        font-size: xx-large">Path to image: </label>
    <input type="text" name="pathToImage" id="pathToImage" value="" class=c6 required>

    <label for="comfortClass" style="position:fixed;
        top: 475px;
        left:385px;
        font-size: xx-large">Comfort class: </label>
    <input type="text" name="comfortClass" id="comfortClass" value="" class=c7 required>

    <input type="submit" name="add" class=c8 value="Add ">
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

    .c5 {
        font-weight: 800;
        font-size: large;
        position: fixed;
        top: 347px;
        left: 570px;
        height: 55px;
        width: 250px
    }
    .c6 {
        font-weight: 800;
        font-size: large;
        position: fixed;
        top: 415px;
        left: 570px;
        height: 55px;
        width: 250px
    }
    .c7 {
        font-weight: 800;
        font-size: large;
        position: fixed;
        top: 483px;
        left: 570px;
        height: 55px;
        width: 250px
    }
    .c8 {
        font-weight: 800;
        font-size: large;
        position: fixed;
        top: 551px;
        left: 570px;
        height: 55px;
        width: 250px
    }
</style>

</body>
</html>
