package BDagencia;

import BDagencia.ConexBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class ServicioDAO {
    public static boolean guardarServicio(String tipo, boolean pagado, int presupuesto, String placas){
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "INSERT INTO servicio (tipo, pagado, presupuesto, auto_placa) VALUES (?,?,?,?)";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, tipo);
                statement.setBoolean(2, pagado);
                statement.setInt(3, presupuesto);
                statement.setString(4, placas);
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
    
    public static String obtenerTipo(String placas){
        String tipo = null;
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT tipo FROM servicio WHERE auto_placa = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, placas);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        tipo = resultSet.getString("tipo");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipo;
    }
    
    public static boolean isPagado(String placas){
        boolean pagado = false;
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT pagado FROM servicio WHERE auto_placa = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, placas);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        pagado = resultSet.getBoolean("pagado");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pagado;
    }
    
    public static int getPresupuesto(String placas){
        int presupuesto = 0;
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT presupuesto FROM servicio WHERE auto_placa = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, placas);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        presupuesto = resultSet.getInt("presupuesto");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return presupuesto;
    }
    
    public static boolean verificarExistenciaAuto (String placa){
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT * FROM servicio where auto_placa = ?";
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
