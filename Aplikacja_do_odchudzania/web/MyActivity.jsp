<%@ page import="beans.Sport" %>
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
                <li><a href="main.jsp">Strona Glowna</a></li>
                <li><a href="Logout">Wyloguj Sie</a></li>
            </ul>
        </div>


        <%
            Sport sport = (Sport) request.getAttribute("sport");
        %>
        <div class="container">
            <div class="col-md-8 col-md-offset-2">
                    <h1 class="text-center">Twoje Cwiczenie na Dzis:</h1>
                <u><i> <h2> <p class="text-center"><%= sport.getDescribe() %></p></h2></i></u>

                    <h2 class ="text-center", class="form-signin-heading">Wykonujac to cwiczenie spalisz:</h2>
                <i><b> <h2 class="text-center"> <%= sport.getCalories()%>  kalorie</h2></b></i>



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