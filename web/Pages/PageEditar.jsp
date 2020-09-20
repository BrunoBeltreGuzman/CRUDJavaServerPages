
<%@page import="ModeloDAO.UsuariosDAO"%>
<%@page import="Modelo.Usuarios"%>
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
              <%
              UsuariosDAO usuariosDAO = new UsuariosDAO();
              int id = Integer.parseInt((String)request.getAttribute("idUsuario"));
              Usuarios usuarios =(Usuarios)usuariosDAO.listUsuarios(id);
          %>
          <br>
          <br>
            <h1>Modificar Usuario</h1>
            <br>
            <br>
            <form action="Controlador">
                Nombres:<br>
                <input class="form-control" type="text" name="txtNombre" value="<%= usuarios.getNombre() %>"><br>
                
                Apellidos:<br>
                <input class="form-control" type="text" name="txtApellido" value="<%= usuarios.getApellido()%>"><br>
                
                Email:<br>
                <input class="form-control" type="email" name="txtEmail" value="<%= usuarios.getEmail() %>"><br>
                
                 User:<br>
                 <input class="form-control" type="text" name="txtUser" value="<%= usuarios.getUser()%>"><br>
                 
                 PassWord:<br>
                <input class="form-control" type="password" name="txtPassWord" value="<%= usuarios.getPassWord() %>"><br>
                
                <input type="hidden" name="txtId" value="<%= usuarios.getId()%>">
                
                <input class="btn btn-primary" type="submit" name="accion" value="Editar"> 
                <a href="Controlador?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
