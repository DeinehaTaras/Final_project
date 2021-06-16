<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car rental | approve order</title>
</head>
<body>
<h1 align="center">Choose option</h1>
<form action = "approveOrder.jsp" method="post">
    <input type="submit" name="approve" class=c value="Approve order">
</form>
<form action = "declineOrder.jsp" method="post">
    <input type="submit" name="decline" class=c2 value="Decline order">
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
