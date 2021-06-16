<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Car rental | create manager</title>
</head>
<body>

<h1 align="center">Write in all fields:</h1>

<form action = "createManager" method="post">

    <label for="surname" style="position:fixed;
        top: 95px;
        left:385px;
        font-size: xx-large">Surname :</label>
    <input type="text" name="surname" id="surname" value="" class=c required>

    <label for="name" style="position:fixed;
        top: 160px;
        left:385px;
        font-size: xx-large">Name: </label>
    <input type="text" name="name" id="name" value="" class=c2 required>

    <label for="secondName" style="position:fixed;
        top: 225px;
        left:385px;
        font-size: xx-large">Second name: </label>
    <input type="text" name="secondName" id="secondName" value="" class=c3 required>

    <label for="date" style="position:fixed;
        top: 285px;
        left:385px;
        font-size: xx-large">Date of birth: </label>
    <input type="date" name="date" id="date" value="2021-06-09" class=c4 required>

    <label for="phoneNumber" style="position:fixed;
        top: 345px;
        left:385px;
        font-size: xx-large">Phone number: </label>
    <input type="text" name="phoneNumber" id="phoneNumber" value="" class=c5>

    <label for="login" style="position:fixed;
        top: 410px;
        left:385px;
        font-size: xx-large">Login: </label>
    <input type="text" name="login" id="login" value="" class=c6 required>

    <label for="password" style="position:fixed;
        top: 475px;
        left:385px;
        font-size: xx-large">Password: </label>
    <input type="password" name="password" id="password" value="" class=c7 required>

    <input type="submit" name="signup" class=c8 value="Submit ">
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

</html>
