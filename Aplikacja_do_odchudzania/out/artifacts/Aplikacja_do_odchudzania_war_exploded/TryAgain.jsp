<!DOCTYPE html>
<html>

<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.min.css" rel="stylesheet">
</head>

<body>

<nav class = "navbar  navbar-default">
    <div class="container">
        <a href="#" class="navbar-brand">Schudnij z nami</a>

        <div class="collapse navbar-collapse navCollapse">
            <ul class="nav navbar-nav navbar-right">

                <div class="container">
                    <div class="col-sm-6 col-md-4 col-md-offset-4">
                        <form class="form-signin" method="post" action="LoginServlet">
                            <h2 class="form-signin-heading : text-center">Login lub haslo jest bledne, sprobuj jeszcze raz</h2>

                            <h2 class="form-signin-heading">Zaloguj</h2>
                            <input name="Username" type="text" name="inputUsername" class="form-control" placeholder="Nazwa uzytkownika" required autofocus />
                            <input name="Password" type="password" class="form-control" placeholder="Haslo" required />
                            <button class="btn btn-lg btn-primary btn-block" type="submit" >Zaloguj</button>
                        </form>
                    </div>
                </div>



                <div class="container">
                    <div class="col-sm-6 col-md-4 col-md-offset-4">
                        <form class="form-signin" method="post" action="RegistredServlet">
                            <h2 class="form-signin-heading">Zarejestruj sie</h2>
                            <input name="email" type="email" class="form-control" placeholder="Email" required autofocus />
                            <input name="username" type="text" name="inputUsername" class="form-control" placeholder="Nazwa uzytkownika" required autofocus />
                            <input name="password" type="password" class="form-control" placeholder="Haslo" required />
                            <input name="height" type="number" class="form-control" placeholder="wzrost" required />
                            <input name="weight" type="text" class="form-control" placeholder="waga" required />
                            <input name="age" type="text" class="form-control" placeholder="wiek" required />
                            <input name="sex" type="text" class="form-control" placeholder="plec" required />


                            <button class="btn btn-lg btn-primary btn-block" type="submit" >Zarejestruj</button>
                        </form>
                    </div>
                </div>

                <footer class="navbar navbar-default navbar-static-bottom">
                    <div class="container">
                        <p class="navbar-text">Schudnij z nami autor Slawomir Guzik</p>
                    </div>
                </footer>
                <button class="navbar-toggle" data-toggle="collapse" data-target=".navCollapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>



<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>

</body>
</html>