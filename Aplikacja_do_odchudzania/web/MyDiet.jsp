<%@ page import="beans.UserHistory" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Breakfast" %>
<%@ page import="beans.Dinner" %>
<%@ page import="beans.Supper" %>
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


        <b><h1 class="text-center">Tygodniowa rozpisza Twojej diety </h1></b>
        <b><h2 class="text-left">Koszt Twojej tygodniowej diety to:  <%= request.getAttribute("price") %></h2></b>
        <b><h2 class="text-left">Srednia dzienna wartosc energetyczna:  <%= request.getAttribute("kalorie") %> kalorii</h2></b>


        <table style="width:100%" border="3">

            <tr>
                <th>Dzien </th>
                <th>Nazwa</th>
                <th>Opis</th>
                <th>sredni koszt</th>
                <th>Potrzebne skladniki</th>
                <th>Ilosc kalorii </th>
            </tr>
                <%
                int a = 1;
             List<Breakfast> breakfasts = (List<Breakfast>)request.getAttribute("breakfast");
                if(breakfasts != null)
                for(Breakfast breakfast: breakfasts) {
             %>
            <tr>
                <td>Dzien <%= a %></td>
                <td><%= breakfast.getName() %></td>
                <td><%= breakfast.getDescriptions() %></td>
                <td><%= breakfast.getCost()%></td>
                <td><%= breakfast.getIngredients()%></td>
                <td><%= breakfast.getCalory()%></td>


            </tr>
                <%
                a++;
            }
    %>


            <h2 class="text-center">Sniadania </h2>
            <table style="width: 100%" border="2">
                <tr>
                    <th>Dzien </th>
                    <th>Pierwsze danie</th>
                    <th>Drugie danie</th>
                    <th>Opis</th>
                    <th>sredni koszt</th>
                    <th>Potrzebne skladniki</th>
                    <th>Ilosc kalorii </th>
                </tr>
                    <%
                int b = 1;
             List<Dinner> dinners = (List<Dinner>)request.getAttribute("dinner");
                if(dinners != null)
                for(Dinner dinner: dinners) {
             %>
                <tr>
                    <td>Dzien <%=b%></td>
                    <td><%= dinner.getFirstDish() %></td>
                    <td><%= dinner.getSecondDish() %></td>
                    <td><%= dinner.getDescriptions() %></td>
                    <td><%= dinner.getCost()%></td>
                    <td><%= dinner.getIngredients()%></td>
                    <td><%= dinner.getCalory()%></td>


                </tr>
                    <%
                b++;
            }
    %>

                <h2 class="text-center">Obiady</h2>
                <table style="width:100%" border="2">
                    <tr>
                        <th>Dzien </th>
                        <th>Nazwa</th>
                        <th>Opis</th>
                        <th>sredni koszt</th>
                        <th>Potrzebne skladniki</th>
                        <th>Ilosc kalorii </th>
                    </tr>
                        <%
                        int c =1;
             List<Supper> suppers = (List<Supper>)request.getAttribute("supper");
                if(suppers != null)
                for(Supper supper: suppers) {
             %>
                    <tr>
                        <td>Dzien <%= c %></td>
                        <td><%= supper.getName() %></td>
                        <td><%= supper.getDescriptions() %></td>
                        <td><%= supper.getCost()%></td>
                        <td><%= supper.getIngredients()%></td>
                        <td><%= supper.getCalory()%></td>


                    </tr>
                        <%
        c++;
            }
    %>

                    <h2 class="text-center">Kolacje</h2>



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