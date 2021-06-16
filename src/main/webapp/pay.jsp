
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car rental | pay</title>
</head>
<body>
<h1 align="center">Price: ${price}$</h1>

<form action = "thxForOrder.jsp" method="post">
    <input type="submit" name="pay" class=c value="Pay">
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

</style>
</body>
</html>
