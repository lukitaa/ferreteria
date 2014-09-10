<%-- 
    Document   : index
    Created on : Aug 26, 2014, 5:16:07 PM
    Author     : Lucio Martinez <luciomartinez at openmailbox dot org>
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>Ferreter&iacute;a</title>
        
        <link href="/Ferreteria/static/css/styles.css" rel="stylesheet">
        <link href="/Ferreteria/static/vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/Ferreteria/static/vendors/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
        
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Activar navegaci&oacute;n</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/Ferreteria">Hi World :)</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/Ferreteria">Inicio</a></li>
                        <li><a>SomeDay..</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a><%= new SimpleDateFormat("dd 'of' MMM, yyyy").format(Calendar.getInstance().getTime()) %></a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        
        <main role="main" class="container">
            <div class="col-md-10 col-md-offset-1">
                <!-- BEGINS CONTENT -->
                <div class="jumbotron">
                    <h1>ABM Usuarios</h1>
                    <form class="form-inline" role="form">
                        <div class="form-group">
                          <label for="exampleInputEmail1">Email address</label>
                          <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                          <label for="exampleInputPassword1">Password</label>
                          <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <div class="checkbox">
                          <label>
                            <input type="checkbox"> Check me out
                          </label>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>A</th>
                                <th>B</th>
                                <th>C</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>PEPE</td>
                                <td>PEPE</td>
                                <td>PEPE</td>
                            </tr><tr>
                                <td>PEPE</td>
                                <td>PEPE</td>
                                <td>PEPE</td>
                            </tr><tr>
                                <td>PEPE</td>
                                <td>PEPE</td>
                                <td>PEPE</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!-- ENDS CONTENT -->
            </div>
        </main>
        
        <script src="static/vendors/jquery/js/jquery.min.js"></script>
        <script src="static/vendors/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
