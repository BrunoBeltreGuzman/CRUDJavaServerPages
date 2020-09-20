
<%@page import="Modelo.Usuarios"%>
<%@page import="ModeloDAO.UsuariosDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
            <br>
            <h1>Registros</h1>
            <br>
            <br>
            <a class="btn btn-success" href="Controlador?accion=accesoRegistrar">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Id</th>
                        <th class="text-center">Nombres</th>
                        <th class="text-center">Apellidos</th>
                        <th class="text-center">Email</th>
                        <th class="text-center">User</th>
                        <th class="text-center">PassWord</th>
                        <th class="text-center"> </th>
                    </tr>
                </thead>
                <%
                    UsuariosDAO usuariosDAO = new UsuariosDAO();
                    List<Usuarios> listUsuario = usuariosDAO.listarUsuarios();
                    Iterator<Usuarios> iterator = listUsuario.iterator();
                    Usuarios usuarios = null;
                    while (iterator.hasNext()) {
                        usuarios = iterator.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= usuarios.getId() %></td>
                        <td class="text-center"><%= usuarios.getNombre() %></td>
                        <td class="text-center"><%= usuarios.getApellido() %></td>
                        <td class="text-center"><%= usuarios.getEmail() %></td>
                        <td class="text-center"><%= usuarios.getUser() %></td>
                        <td class="text-center"><%= usuarios.getPassWord() %></td>
                        
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?accion=accesoEditar&txtId=<%= usuarios.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?accion=eliminar&txtId=<%= usuarios.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
