package BDagencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexBD {
    private static Connection conexion;

    public static Connection obtenerConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                // Cargar el controlador JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Configurar la conexión a la base de datos
                String url = "jdbc:mysql://localhost:3306/agencia";
                String usuario = "root";
                String contraseña = "";

                // Establecer la conexión
                conexion = DriverManager.getConnection(url, usuario, contraseña);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conexion;
    }
}

