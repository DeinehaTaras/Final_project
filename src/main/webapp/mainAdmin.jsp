<%@ page contentType="text/html; charset = UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>Car rental | Home</title>
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
<header class="header">
    <div class="header__logo">
        <h1 class="logo__text">CAR<span class="logo__text--grey">rental</span></h1>
    </div>
    <form action="addCar.jsp" method="post">
        <button class="car__button" name="adminButton1" value="rent1">Add car</button>
    </form>
    <form action="removeCar.jsp" method="post">
        <button class="car__button" name="adminButton2" value="rent1">Remove car</button>
    </form>
    <form action="modifyCar.jsp" method="post">
        <button class="car__button" name="adminButton3" value="rent1">Modify car info</button>
    </form>
    <form action="banUser.jsp" method="post">
        <button class="car__button" name="adminButton4" value="rent1">Ban user</button>
    </form>
    <form action="unbanUser.jsp" method="post">
        <button class="car__button" name="adminButton5" value="rent1">Unban user</button>
    </form>
    <form action="addManager.jsp" method="post">
        <button class="car__button" name="rent1" value="rent1">Add manager</button>
    </form>
    <div class="header__auth">
        <div class="userName">
            <img src=images/user.png alt="user" class="user__image"> ${userName}
        </div>
    </div>
</header>

<main class="main">
    <div class="main__pagination">
        <form action="mainAdmin" method="post">
            <ul class="pagination__list">
                <button name="pageNum1" id="pageNum1" value="1" class="pagination__item ${active__item1}">1</button>
                <button name="pageNum2" id="pageNum2" value="2" class="pagination__item ${active__item2}">2</button>
                <button name="pageNum3" id="pageNum3" value="2" class="pagination__item ${active__item3}">3</button>
                <form action="mainAdmin" method="post">
                    <button class="car__button" name="sortButton1" value="sort1">Sort A-Z</button>

                </form>
                <form action="mainAdmin" method="post">
                    <button class="car__button" name="sortButton2" value="sort2">Sort by price (cheap to expensive)</button>

                </form>
                <form action="mainAdmin" method="post">
                    <button class="car__button" name="sortButton3" value="sort3">Sort by class comfort (A-S)</button>

                </form>
            </ul>
        </form>
    </div>
    <div class="main__cars">
        <c:if test ="${counter > 0}">
            <div class="car">
                <div class="car__logo">
                    <img src=images/${image1} alt="car" class="car__image">
                </div>
                <h3 class="car__title">${brand1} ${model1}</h3>
                <div class="car__description">
                    Year: ${year1}<br><br>
                    Color: ${color1}<br><br>
                    Price: ${price1}$ per hour<br><br>
                    Comfort class: ${comfortClass1}<br><br>
                    Status: ${status1}<br><br>
                </div>
                <div class="car__rent">
                    <form action="preRent" method="post">
                        <button class="car__button" name="rent1" value="rent1">Rent</button>
                    </form>
                </div>
            </div>
        </c:if>
        <c:if test ="${counter > 1}">
            <div class="car">
                <div class="car__logo">
                    <img src=images/${image2} alt="car" class="car__image">
                </div>
                <h3 class="car__title">${brand2} ${model2}</h3>
                <div class="car__description">
                    Year: ${year2}<br><br>
                    Color: ${color2}<br><br>
                    Price: ${price2}$ per hour<br><br>
                    Comfort class: ${comfortClass2}<br><br>
                    Status: ${status2}<br><br>
                </div>
                <div class="car__rent">
                    <form action="preRent" method="post">
                        <button class="car__button" name="rent2" value="rent2">Rent</button>
                    </form>
                </div>
            </div>
        </c:if>
        <c:if test ="${counter > 2}">
            <div class="car">
                <div class="car__logo">
                    <img src=images/${image3} alt="car" class="car__image">
                </div>
                <h3 class="car__title">${brand3} ${model3}</h3>
                <div class="car__description">
                    Year: ${year3}<br><br>
                    Color: ${color3}<br><br>
                    Price: ${price3}$ per hour<br><br>
                    Comfort class: ${comfortClass3}<br><br>
                    Status: ${status3}<br><br>
                </div>
                <div class="car__rent">
                    <form action="preRent" method="post">
                        <button class="car__button" name="rent3" value="rent3">Rent</button>
                    </form>
                </div>
            </div>
        </c:if>
        <c:if test ="${counter > 3}">
            <div class="car">
                <div class="car__logo">
                    <img src=images/${image4} alt="car" class="car__image">
                </div>
                <h3 class="car__title">${brand4} ${model4}</h3>
                <div class="car__description">
                    Year: ${year4}<br><br>
                    Color: ${color4}<br><br>
                    Price: ${price4}$ per hour<br><br>
                    Comfort class: ${comfortClass4}<br><br>
                    Status: ${status4}<br><br>
                </div>
                <div class="car__rent">
                    <form action="preRent" method="post">
                        <button class="car__button" name="rent4" value="rent4">Rent</button>
                    </form>
                </div>
            </div>
        </c:if>
    </div>
</main>

</div>
</body>
</html>

