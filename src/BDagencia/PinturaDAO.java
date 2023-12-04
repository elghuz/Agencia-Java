package BDagencia;

import BDagencia.ConexBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PinturaDAO {
    public static boolean guardarPintura(String pintura, String placas, String fechaEntrada, String fechaSalida){
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "INSERT INTO pintura (color, auto_placa, fechaEntrada, fechaSalida) VALUES (?,?,?,?)";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, pintura);
                statement.setString(2, placas);
                statement.setString(3, fechaEntrada);
                statement.setString(4, fechaSalida);
                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Inserción exitosa. Filas afectadas: " + filasAfectadas);
                } else {
                    System.out.println("No se insertó ninguna fila. Verifica tu sentencia SQL.");
                    return false;
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static String obtenerFechaEntrada(String placas){
        String fechaEntrada = null;
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT fechaEntrada FROM pintura WHERE auto_placa = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, placas);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        fechaEntrada = resultSet.getString("fechaEntrada");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fechaEntrada;
    }
    
    public static String obtenerFechaSalida(String placas){
        String fechaSalida = null;
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT fechaSalida FROM pintura WHERE auto_placa = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, placas);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        fechaSalida = resultSet.getString("fechaSalida");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fechaSalida;
    }
    
    public static String obtenerPintura(String placas){
        String pintura = null;
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT color FROM pintura WHERE auto_placa = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, placas);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        pintura = resultSet.getString("color");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pintura;
    }
    
    public static boolean verificarExistenciaAuto (String placa){
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT * FROM pintura where auto_placa = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, placa);
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
