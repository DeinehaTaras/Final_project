<%@ page contentType="text/html; charset = UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>Car rental service | Home</title>
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
<header class="header">
    <div class="header__logo">
        <h1 class="logo__text">CAR<span class="logo__text--grey">rental</span></h1>
    </div>
    <div class="header__auth">
        <button class="auth__button auth__button--sign-in">Sign in</button>
        <button class="auth__button auth__button--sign-up">Sign up</button>
    </div>
</header>

<main class="main">
    <div class="main__pagination">
        <form action="mainUser" method="post">
        <ul class="pagination__list">
            <button name="pageNum1" id="pageNum1" value="1" class="pagination__item ${active__item1}">1</button>
            <button name="pageNum2" id="pageNum2" value="2" class="pagination__item ${active__item2}">2</button>
            <button name="pageNum3" id="pageNum3" value="2" class="pagination__item ${active__item3}">3</button>
        </ul>
        </form>
    </div>
    <div class="main__cars">
        <div class="car">
            <div class="car__logo">
                <img src=${image1} alt="car" class="car__image">
            </div>
            <h3 class="car__title">${brand1} ${model1}</h3>
            <div class="car__description">
                Year: ${year1}<br><br>
                Color: ${color1}<br><br>
                Price: ${price1}<br><br>
            </div>
            <div class="car__rent">
                <form action="rent" method="post">
                    <button class="car__button">Rent</button>
                </form>
            </div>
        </div>
        <div class="car">
            <div class="car__logo">
                <img src=${image2} alt="car" class="car__image">
            </div>
            <h3 class="car__title">${brand2} ${model2}</h3>
            <div class="car__description">
                Year: ${year2}<br><br>
                Color: ${color2}<br><br>
                Price: ${price2}<br><br>
            </div>
            <div class="car__rent">
                <button class="car__button">Rent</button>
            </div>
        </div>
        <div class="car">
            <div class="car__logo">
                <img src=${image3} alt="car" class="car__image">
            </div>
            <h3 class="car__title">${brand3} ${model3}</h3>
            <div class="car__description">
                Year: ${year3}<br><br>
                Color: ${color3}<br><br>
                Price: ${price3}<br><br>
            </div>
            <div class="car__rent">
                <button formaction="" formmethod="post" class="car__button">Rent</button>
            </div>
        </div>
        <div class="car">
            <div class="car__logo">
                <img src=${image4} alt="car" class="car__image">
            </div>
            <h3 class="car__title">${brand4} ${model4}</h3>
            <div class="car__description">
                Year: ${year4}<br><br>
                Color: ${color4}<br><br>
                Price: ${price4}<br><br>
            </div>
            <div class="car__rent">
                <button class="car__button">Rent</button>
            </div>
        </div>
    </div>
</main>

<div class="modal__sign-in modal">
    <h3 class="modal__header">Sign In</h3>
    <div class="modal__body">
        <form action="/login" class="modal__form">
            <input type="email" placeholder="Email" class="form__input">
            <input type="password" placeholder="********" class="form__input">
            <button class="form__button" type="submit">Sign in</button>
        </form>
    </div>
</div>

<div class="modal__sign-up modal">
    <h3 class="modal__header">Sign Up</h3>
    <div class="modal__body">
        <form action="/registration" class="modal__form">
            <label>
                <span class="form__label">Email:</span>
                <input type="email" placeholder="Email" class="form__input">
            </label>
            <label>
                <span class="form__label">Password:</span>
                <input type="password" placeholder="********" class="form__input">
            </label>
            <button class="form__button" type="submit">Sign up</button>
        </form>
    </div>
</div>
</body>
</html>
