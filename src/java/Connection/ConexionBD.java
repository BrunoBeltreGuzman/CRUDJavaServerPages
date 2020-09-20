package Connection;

import java.sql.*;

public class ConexionBD {

    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final String HOST = "localhost";
    public static final String PORT = "3306";
    public static final String DATABASE = "bdjavaweb";
    public static final String CLASSNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

    public Connection connection;

    public ConexionBD() {

        try {
            Class.forName(CLASSNAME);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

  
}

