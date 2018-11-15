<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.min.css" rel="stylesheet">

</head>

<body>

<nav class = "navbar navbar-default ">
    <div class="container">
        <a href="#" class="navbar-brand">Witaj <%= session.getAttribute("username") %></a>
        <div class="collapse navbar-collapse navCollapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="main.jsp">Stron Glowna</a></li>
                <li><a href="Logout">Wyloguj Sie</a></li>
            </ul>
        </div>



        <div class="container">
            <div class="col-md-8 col-md-offset-2">
                <form class="form-signin" method="post" action="NewUserHistory">
                    <h2 class="form-signin-heading : text-center">Pochwal sie swoimi postepami</h2>
                    <input name="weight" type="text" class="form-control" placeholder="Jaka jest Twoja aktualna waga?"
                           required autofocus />
                    <textarea name="description" rows="12" name="progress"
                              class="form-control" placeholder="Opisz nam czy trzymales sie diety, czy cwiczyles sumiennie" required autofocus></textarea>
                    <input class="btn btn-lg btn-primary btn-block" type="submit"
                           value="Wyslij" />
                </form>
            </div>
        </div>



        <footer class="navbar navbar-default navbar-static-top">
            <div class="container">
                <p class="navbar-text">Schudnij z nami autor Slawomir Guzik</p>
            </div>
        </footer>
        <button class="navbar-toggle" data-toggle="collapse" data-target=".navCollapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

    </div>
</nav>


<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="jquery.scrollTo.min.js"></script>


</body>
</html>