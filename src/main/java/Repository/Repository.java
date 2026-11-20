package Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    List<T> obtenerTodos() throws SQLException;

    Optional<T> obtenerPorID(int id) throws SQLException;

    void guardar(T entidad) throws SQLException;

    void eliminar(int id) throws SQLException;

    void editar(T entidad) throws SQLException;
}
