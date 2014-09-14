<%-- 
    Document   : index
    Created on : Aug 26, 2014, 5:16:07 PM
    Author     : Lucio Martinez <luciomartinez at openmailbox dot org>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>Ferreter&iacute;a - TITLE</title>
        
        <base href="${pageContext.request.contextPath}/" >
        
        <link href="static/css/styles.css" rel="stylesheet">
        <link href="static/vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/vendors/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
        
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        
        <!-- BEGINS NAV -->
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Activar navegaci&oacute;n</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="inicio">Ferreter&iacute;a</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="inicio">Inicio</a></li>
                        <li class="active"><a href="inicio">Compras</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a>Hola, YO!</a></li>
                        <li><a href="logout">Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- ENDS NAV -->
        
        <main role="main" class="container">
            <div class="col-md-10 col-md-offset-1">
                <!-- BEGINS BREADCRUMBS -->
                <ol class="breadcrumb">
                    <li><a href="inicio">Home</a></li>
                    <li class="active">Compras</li>
                </ol>
                <!-- ENDS BREADCRUMBS -->
                <!-- BEGINS CONTENT -->
                <div class="jumbotron presentation purchase">
                    <h1 class="header">Comprar productos</h1>
                    <form class="purchase" action="javascript:console.log(0)">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Producto</th>
                                    <th>Precio</th>
                                    <th>Unidades</th>
                                    <th>Agregar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr id="product-1">
                                    <td>Lorem Pizza</td>
                                    <td class="price">100</td>
                                    <td class="stock">5</td>
                                    <td><input type="number" min="0" max="5" value="0"></td>
                                </tr><tr id="product-2">
                                    <td>Lorem Pizza</td>
                                    <td class="price">100</td>
                                    <td class="stock">5</td>
                                    <td><input type="number" min="0" max="5" value="0"></td>
                                </tr><tr id="product-4">
                                    <td>Lorem Pizza</td>
                                    <td class="price">100</td>
                                    <td class="stock">5</td>
                                    <td><input type="number" min="0" max="5" value="0"></td>
                                </tr><tr id="product-5">
                                    <td>Lorem Pizza</td>
                                    <td class="price">100</td>
                                    <td class="stock">5</td>
                                    <td><input type="number" min="0" max="5" value="0"></td>
                                </tr>
                            </tbody>
                        </table>
                        <button type="submit" class="btn btn-primary">Comprar</button>
                    </form>
                </div>
                <!-- ENDS CONTENT -->
            </div>
        </main>
        
        <script src="static/vendors/jquery/js/jquery.min.js"></script>
        <script src="static/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="static/js/scripts.js"></script>
    </body>
</html>