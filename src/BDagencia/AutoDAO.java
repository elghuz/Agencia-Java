package BDagencia;

import agencia.Auto;
import agencia.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AutoDAO {
    public static boolean guardarAuto(Auto auto) {
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "INSERT INTO Auto (placa, modelo, anio, sucursal_nombre) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, auto.getPlacas());
                statement.setString(2, auto.getModelo());
                statement.setInt(3, auto.getAnio());
                statement.setString(4, auto.getSucursal().getNombre());
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

    public static boolean eliminarAuto(String placas) {
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "DELETE FROM Auto WHERE placa = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, placas);
                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Eliminación exitosa. Filas afectadas: " + filasAfectadas);
                    return true;
                } else {
                    System.out.println("No se eliminó ninguna fila. Verifica tu sentencia SQL.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Auto obtenerAutoPorPlacas(String placas) {
        Auto auto = null;
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT * FROM Auto WHERE placa = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, placas);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String modelo = resultSet.getString("modelo");
                        int anio = resultSet.getInt("anio");
                        String sucursalNombre = resultSet.getString("sucursal_nombre");
                        Sucursal sucReg = new Sucursal(sucursalNombre);
                        auto = new Auto(modelo, anio, placas, sucReg);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auto;
    }

    public static List<Auto> obtenerTodosLosAutos() {
        List<Auto> autos = new ArrayList<>();
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT * FROM Auto";
            try (PreparedStatement statement = conexion.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String modelo = resultSet.getString("modelo");
                    int anio = resultSet.getInt("anio");
                    String placas = resultSet.getString("placa");
                    String color = resultSet.getString("color");
                    String sucursalNombre = resultSet.getString("sucursal_nombre");
                    Sucursal sucReg = new Sucursal(sucursalNombre);
                    Auto auto = new Auto(modelo, anio, placas, sucReg);
                    autos.add(auto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autos;
    }
    public static String obtenerDepartamentoPorPlacas(String placas){
        String departamento = "null";
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT a.placa, " +
                         "CASE " +
                         "    WHEN s.auto_placa IS NOT NULL THEN 'Servicio' " +
                         "    WHEN p.auto_placa IS NOT NULL THEN 'Pintura' " +
                         "    ELSE 'null'" +
                         "END AS estado " +
                         "FROM auto a " +
                         "LEFT JOIN servicio s ON a.placa = s.auto_placa " +
                         "LEFT JOIN pintura p ON a.placa = p.auto_placa " +
                         "WHERE a.placa = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, placas);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        departamento = resultSet.getNString("estado");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departamento;
    }
    
    public static List<Auto> obtenerAutosPorSucursal(String SucurDada){
        List<Auto> autos = new ArrayList<>();
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT * FROM Auto WHERE sucursal_nombre = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, SucurDada);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String modelo = resultSet.getString("modelo");
                        int anio = resultSet.getInt("anio");
                        String placas = resultSet.getString("placa");
                        Sucursal sucReg = new Sucursal(SucurDada);
                        Auto auto = new Auto(modelo, anio, placas, sucReg);
                        autos.add(auto);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autos;
    }
    
    public static boolean modificarSucursal(String nuevaSuc, String placas){
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "UPDATE auto SET sucursal_nombre = ? WHERE placa = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, nuevaSuc);
                statement.setString(2, placas);
                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Update exitoso. Filas afectadas: " + filasAfectadas);
                    return true;
                } else {
                    System.out.println("No se modifico ninguna fila. Verifica tu sentencia SQL.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
