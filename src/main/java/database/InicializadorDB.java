package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InicializadorDB {

    public void inicializar() {

        try (Connection cn = ConexionBD.getInstancia().obtenerConexion();
             Statement st = cn.createStatement()) {

            String crearTablaUsuarios = """
                    CREATE TABLE IF NOT EXISTS usuarios (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL UNIQUE);
                   """;

            String crearTablaTematica = """
                    CREATE TABLE IF NOT EXISTS "tematica" (
                    	"id"	INTEGER,
                    	"nombre"	TEXT,
                    	"usuario"	INTEGER,
                    	PRIMARY KEY("id" AUTOINCREMENT),
                    	CONSTRAINT "usuario_tematica" FOREIGN KEY("usuario") REFERENCES "usuarios"("id")
                    );
                    """;
            String crearTablaTema = """
                    CREATE TABLE IF NOT EXISTS "tema" (
                    	"id"	INTEGER,
                    	"nombre"	TEXT,
                    	"tematica"	INTEGER,
                    	PRIMARY KEY("id" AUTOINCREMENT),
                    	CONSTRAINT "tematica_tema" FOREIGN KEY("tematica") REFERENCES "tematica"("id")
                    );
                    """;

            String crearTablaTarjeta = """
                    CREATE TABLE IF NOT EXISTS "tarjeta" (
                    	"id"	INTEGER,
                    	"caradelantera"	TEXT,
                    	"caratrasera"	TEXT,
                    	"tema"	INTEGER,
                    	PRIMARY KEY("id" AUTOINCREMENT),
                    	CONSTRAINT "tema_tarjeta" FOREIGN KEY("tema") REFERENCES "tema"("id")
                    );
                    """;

            st.execute(crearTablaUsuarios);
            st.execute(crearTablaTematica);
            st.execute(crearTablaTema);
            st.execute(crearTablaTarjeta);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
