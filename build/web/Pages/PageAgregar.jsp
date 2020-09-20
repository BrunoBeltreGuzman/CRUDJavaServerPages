<%-- 
    Document   : add
    Created on : 30-ago-2018, 19:58:16
    Author     : Joel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <br>
                <br>
                <h1>Agregar Usuario</h1>
                <br>
                <br>
                <form action="Controlador">
                   
                    Nombres: <br>
                    <input class="form-control" type="text" name="txtNombre"><br>
                   
                    Apellidos: <br>
                    <input class="form-control" type="text" name="txtApellido"><br>
                    
                    Email: <br>
                    <input class="form-control" type="email" name="txtEmail"><br>
                    
                     User: <br>
                    <input class="form-control" type="text" name="txtUser"><br>
                    
                     PassWord: <br>
                    <input class="form-control" type="password" name="txtPassWord"><br>
                    
                    <input class="btn btn-primary" type="submit" name="accion" value="registrar">
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
