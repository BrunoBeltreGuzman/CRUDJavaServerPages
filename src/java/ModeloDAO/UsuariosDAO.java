package ModeloDAO;

import Connection.ConexionBD;
import Intefaces.IUsuario;
import Modelo.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO implements IUsuario {

    ConexionBD conexionBD = new ConexionBD();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Usuarios usuarios = new Usuarios();

    @Override
    public List listarUsuarios() {
        ArrayList<Usuarios> list = new ArrayList<>();
        String sql = "select * from usuarios";
        try {
            connection = conexionBD.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuarios usuarios = new Usuarios();
                usuarios.setId(resultSet.getInt("Id"));
                usuarios.setNombre(resultSet.getString("nombre"));
                usuarios.setApellido(resultSet.getString("apellido"));
                usuarios.setEmail(resultSet.getString("email"));
                usuarios.setUser(resultSet.getString("user"));
                usuarios.setPassWord(resultSet.getString("passWord"));
                list.add(usuarios);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Usuarios listUsuarios(int id) {
        String sql = "select * from usuarios a where Id=" + id;
        try {
            connection = conexionBD.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuarios.setId(resultSet.getInt("Id"));
                usuarios.setNombre(resultSet.getString("nombre"));
                usuarios.setApellido(resultSet.getString("apellido"));
                usuarios.setEmail(resultSet.getString("email"));
                usuarios.setUser(resultSet.getString("user"));
                usuarios.setPassWord(resultSet.getString("passWord"));
            }
        } catch (Exception e) {
        }
        return usuarios;
    }

    @Override
    public boolean registrar(Usuarios usuarios) {
        try {
            connection = conexionBD.getConnection();
            String sql = "insert into usuarios (nombre, apellido, email, user, passWord) "
                    + "Values (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuarios.getNombre());
            preparedStatement.setString(2, usuarios.getApellido());
            preparedStatement.setString(3, usuarios.getEmail());
            preparedStatement.setString(4, usuarios.getUser());
            preparedStatement.setString(5, usuarios.getPassWord());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editar(Usuarios usuarios) {
        try {
            connection = conexionBD.getConnection();
            String sql = "update usuarios set nombre = ?, apellido = ?, "
                    + "email = ?, user = ?, passWord = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuarios.getNombre());
            preparedStatement.setString(2, usuarios.getApellido());
            preparedStatement.setString(3, usuarios.getEmail());
            preparedStatement.setString(4, usuarios.getUser());
            preparedStatement.setString(5, usuarios.getPassWord());
            preparedStatement.setInt(6, usuarios.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        try {
            connection = conexionBD.getConnection();
            String sql = "delete from usuarios where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}
