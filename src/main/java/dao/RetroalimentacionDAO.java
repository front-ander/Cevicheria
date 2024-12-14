package dao;

/**
 *
 * @author Anderson
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Retroalimentacion;

public class RetroalimentacionDAO implements GenericDAO<Retroalimentacion, Integer> {

    Connection connection;

    public RetroalimentacionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Retroalimentacion retroalimentacion) {
        String sql = "INSERT INTO Retroalimentacion (idPedido, comentario, calificacion) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, retroalimentacion.getIdPedido());
            stmt.setString(2, retroalimentacion.getComentario());
            stmt.setInt(3, retroalimentacion.getCalificacion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Retroalimentacion read(Integer id) {
        String sql = "SELECT * FROM Retroalimentacion WHERE idRetroalimentacion = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Retroalimentacion retroalimentacion = new Retroalimentacion();
                retroalimentacion.setIdRetroalimentacion(rs.getInt("idRetroalimentacion"));
                retroalimentacion.setIdPedido(rs.getInt("idPedido"));
                retroalimentacion.setComentario(rs.getString("comentario"));
                retroalimentacion.setCalificacion(rs.getInt("calificacion"));
                return retroalimentacion;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Retroalimentacion retroalimentacion) {
        String sql = "UPDATE Retroalimentacion SET idPedido = ?,  comentario = ?, calificacion = ? WHERE idRetroalimentacion = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, retroalimentacion.getIdPedido());
            stmt.setString(2, retroalimentacion.getComentario());
            stmt.setInt(3, retroalimentacion.getCalificacion());
            stmt.setInt(4, retroalimentacion.getIdRetroalimentacion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Retroalimentacion WHERE idRetroalimentacion = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Retroalimentacion> readAll() {
        String sql = "SELECT * FROM Retroalimentacion";
        List<Retroalimentacion> retroalimentaciones = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Retroalimentacion retroalimentacion = new Retroalimentacion();
                retroalimentacion.setIdRetroalimentacion(rs.getInt("idRetroalimentacion"));
                retroalimentacion.setIdPedido(rs.getInt("idPedido"));
                retroalimentacion.setComentario(rs.getString("comentario"));
                retroalimentacion.setCalificacion(rs.getInt("calificacion"));
                retroalimentaciones.add(retroalimentacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retroalimentaciones;
    }

    public Retroalimentacion buscarPorIdPedido(int idPedido) {
        String sql = "SELECT * FROM Retroalimentacion WHERE idPedido = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idPedido);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Retroalimentacion retroalimentacion = new Retroalimentacion();
                retroalimentacion.setIdRetroalimentacion(rs.getInt("idRetroalimentacion"));
                retroalimentacion.setIdPedido(rs.getInt("idPedido"));
                retroalimentacion.setComentario(rs.getString("comentario"));
                retroalimentacion.setCalificacion(rs.getInt("calificacion"));
                return retroalimentacion;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
