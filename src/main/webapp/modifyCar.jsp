<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car rental | modify car info</title>
</head>
<body>
<h1 align="center">Choose option</h1>
<form action="changeColor.jsp" method="post">
    <input type="submit" name="color" class=c value="Change color">
</form>

<form action="changeImage.jsp" method="post">
    <input type="submit" name="image" class=c2 value="Change image">
</form>
<form action="changePrice.jsp" method="post">
    <input type="submit" name="price" class=c3 value="Change price">
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

</body>
</html>
