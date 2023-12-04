package BDagencia;

import BDagencia.ConexBD;
import agencia.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAO {
    public static void guardarSucursal(Sucursal sucursal) {
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "INSERT INTO Sucursal (nombre) VALUES (?)";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, sucursal.getNombre());
                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Inserción exitosa. Filas afectadas: " + filasAfectadas);
                } else {
                    System.out.println("No se insertó ninguna fila. Verifica tu sentencia SQL.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Sucursal obtenerSucursalPorNombre(String nombre) {
        Sucursal sucursal = null;
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT * FROM Sucursal WHERE nombre = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, nombre);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        sucursal = new Sucursal(resultSet.getString("nombre"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sucursal;
    }

    public static List<Sucursal> desplegarTodasLasSucursales() {
        List<Sucursal> sucursales = new ArrayList<>();
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT * FROM Sucursal";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                    String sucursalNombre = resultSet.getString("nombre");
                    Sucursal sucReg = new Sucursal(sucursalNombre);
                    sucursales.add(sucReg);
                    }
                }
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return sucursales;
    }
    
    public static boolean eliminarSucursal(String nombreSuc){
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "DELETE FROM sucursal WHERE nombre = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, nombreSuc);
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
    
    public static int getCantidadSucursales(){
        int cantidad = 0;
        try (Connection conexion = ConexBD.obtenerConexion()) {
            String sql = "SELECT COUNT(*) AS cantidad FROM sucursal";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                try(ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()) {
                        cantidad = resultSet.getInt("cantidad");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cantidad;
    }
}
