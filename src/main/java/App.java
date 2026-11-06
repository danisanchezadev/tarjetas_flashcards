import database.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {

        try (Connection conexion = ConexionBD.getInstancia().obtenerConexion()) {
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
