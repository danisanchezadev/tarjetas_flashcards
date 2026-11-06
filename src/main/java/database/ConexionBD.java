package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final ConexionBD INSTANCIA = new ConexionBD();

    private ConexionBD() {
    }

    public static ConexionBD getInstancia() {
        return INSTANCIA;
    }

    public Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:data/flashcards.db");
    }
}
