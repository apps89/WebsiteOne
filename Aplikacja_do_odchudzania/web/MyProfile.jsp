<%@ page import="beans.UserHistory" %>
<%@ page import="java.util.List" %>
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



        <b><h1 class="text-center">Przebieg naszej diety:</h1></b>
        <table style="width:80%" border="2">
            <tr>
                <th>Data</th>
                <th>Opis</th>
                <th>Waga</th>
            </tr>
                <%
        List<UserHistory> userHistoryList = (List<UserHistory>)request.getAttribute("userHistory");
        if(userHistoryList != null)
            for(UserHistory userHistory: userHistoryList) {
    %>
            <tr>
                <td><%= userHistory.getDate() %></td>
                <td><%= userHistory.getDescribe() %></td>
                <td><%= userHistory.getWeight() %></td>

            </tr>
                <%
            }
    %>


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