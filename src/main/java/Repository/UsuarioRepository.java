package Repository;

import database.ConexionBD;
import models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository implements Repository<Usuario> {

    @Override
    public List<Usuario> obtenerTodos() throws SQLException {

        List<Usuario> listaDescargada = new ArrayList<>();

        String sentencia = "SELECT * FROM usuarios";

        try (Connection conexion = ConexionBD.getInstancia().obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sentencia)) {

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                listaDescargada.add(
                        new Usuario(
                                resultado.getInt("id"),
                                resultado.getString("nombre"
                                )));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaDescargada;
    }

    @Override
    public Optional<Usuario> obtenerPorID(int id) throws SQLException {

        try (Connection conexion = ConexionBD.getInstancia().obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement("SELECT * FROM usuarios WHERE id = ?")){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    Usuario u = new Usuario(rs.getInt("id"), rs.getString("nombre"));

                    return Optional.of(u);

            }
        }
        return Optional.empty();
    }

    @Override
    public void guardar(Usuario entidad) throws SQLException {

        String sentencia = "INSERT INTO usuarios (nombre) VALUES (?)";

        try(Connection conexion = ConexionBD.getInstancia().obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sentencia)){

            ps.setString(1, entidad.getNombre());

            ps.executeUpdate();
        }
    }


    @Override
    public void eliminar(int id) throws SQLException {

        String sentencia = "DELETE FROM usuarios WHERE id = ?";

        try(Connection conexion = ConexionBD.getInstancia().obtenerConexion();
        PreparedStatement ps = conexion.prepareStatement(sentencia)){

            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();

            System.out.println(filasAfectadas > 0 ? "Se eliminó el usuario " + id + ".": "No se encontró al usuario.");
        }
    }

    @Override
    public void editar(Usuario entidad) throws SQLException {

        String sentencia = "UPDATE usuarios SET nombre = ? WHERE id = ?";

        try(Connection conexion = ConexionBD.getInstancia().obtenerConexion();
        PreparedStatement ps = conexion.prepareStatement(sentencia)){

            ps.setString(1, entidad.getNombre());
            ps.setInt(2, entidad.getId());

            int filasAfectadas = ps.executeUpdate();

            System.out.println(filasAfectadas > 0 ? "Se editó el usuario " + entidad.getId() + ".": "No se encontró al usuario.");

        }
    }
}
