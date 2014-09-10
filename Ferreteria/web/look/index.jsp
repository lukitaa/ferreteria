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
                <div class="jumbotron presentation">
                    <h1>Bienvenido a Ferreter&iacute;a!</h1>
                    <p>This is bootstrap inside a Servlet. Because we are <span>weird</span>.</p>
                    <div class="picture">
                        <img src="http://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Wood_chisel.JPG/1024px-Wood_chisel.JPG">
                        <!--
                        "<a href="http://commons.wikimedia.org/wiki/File:Wood_chisel.JPG#mediaviewer/File:Wood_chisel.JPG">Wood chisel</a>" by Original uploader was <a href="//en.wikipedia.org/wiki/User:Fishdecoy" class="extiw" title="en:User:Fishdecoy">Fishdecoy</a> at <a class="external text" href="http://en.wikipedia.org">en.wikipedia</a> - Transferred from <a class="external text" href="http://en.wikipedia.org">en.wikipedia</a>; transfer was stated to be made by <a href="//commons.wikimedia.org/wiki/User:Satrughna" title="User:Satrughna">User:Satrughna</a>.. Licensed under Public domain via <a href="//commons.wikimedia.org/wiki/">Wikimedia Commons</a>.
                        -->
                    </div>
                    <p class="footer"><a href="Index" class="btn btn-primary btn-lg" role="button">Iniciar Sesi&oacute;n</a></p>
                </div>
            </div>
        </main>
        
        <script src="static/vendors/jquery/js/jquery.min.js"></script>
        <script src="static/vendors/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
