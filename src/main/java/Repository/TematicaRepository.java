package Repository;

import database.ConexionBD;
import models.Tematica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TematicaRepository implements Repository<Tematica> {

    @Override
    public List<Tematica> obtenerTodos(){

        return List.of();
    }

    public List<Tematica> obtenerPorUsuario(int usuarioId){

        List<Tematica> lista = new ArrayList<>();

        String sentencia = "SELECT id, nombre FROM tematica WHERE usuario = ?";

        try(Connection cn = ConexionBD.getInstancia().obtenerConexion();
            PreparedStatement ps = cn.prepareStatement(sentencia)){

            ps.setInt(1,usuarioId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Tematica tematica = new Tematica(rs.getInt("id"), rs.getString("nombre"));

                lista.add(tematica);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return lista;
    }

    @Override
    public Optional<Tematica> obtenerPorID(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void guardar(Tematica entidad) throws SQLException {

    }

    @Override
    public void eliminar(int id) throws SQLException {

    }

    @Override
    public void editar(Tematica entidad) throws SQLException {

    }
}
