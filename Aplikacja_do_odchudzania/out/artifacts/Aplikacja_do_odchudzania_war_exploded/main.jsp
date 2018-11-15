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
                <li><a href="MyProfil">Profil</a></li>
                <li><a href="Logout">Wyloguj Sie</a></li>
            </ul>
        </div>


        <body data-spy="scroll" data-target="#myScrollspy" data-offset="20">

        <div class="container">
                    <div class="col-sm-6 col-md-4 col-md-offset-4">
                        <form class="form-signin" method="post" action="SelectDiet">
                            <h2 class="form-signin-heading: text-center">Wylosuj diete dla siebie</h2>
                            <button class="btn btn-lg btn-primary btn-block" type="submit" >No dalej ;) </button>
                        </form>
                    </div>
                </div>



        <div class="container">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <form class="form-signin" method="post" action="DoingSports">
                    <h2 class="form-signin-heading : text-center">Spersonalizowany zestaw cwiczen</h2>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" >Nie wahaj sie :D</button>
                </form>
            </div>
        </div>


        <div class="container">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <form class="form-signin" method="post" action="progress.jsp">
                    <h2 class="form-signin-heading : text-center">Pokaz nam co ostatnio robiles</h2>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" >Smialo :)</button>
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