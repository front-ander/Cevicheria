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
import modelo.PlatoIngrediente;

public class PlatoIngredienteDAO implements GenericDAO<PlatoIngrediente, Integer> {

    Connection connection;

    public PlatoIngredienteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(PlatoIngrediente platoIngrediente) {
        String sql = "INSERT INTO Plato_Ingrediente (idPlato, idIngrediente, cantidadNecesaria) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, platoIngrediente.getIdPlato());
            stmt.setInt(2, platoIngrediente.getIdIngrediente());
            stmt.setDouble(3, platoIngrediente.getCantidadNecesaria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PlatoIngrediente read(Integer id) {
        String sql = "SELECT * FROM Plato_Ingrediente WHERE idPlatoIngrediente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                PlatoIngrediente platoIngrediente = new PlatoIngrediente();
                platoIngrediente.setIdPlatoIngrediente(rs.getInt("idPlatoIngrediente"));
                platoIngrediente.setIdPlato(rs.getInt("idPlato"));
                platoIngrediente.setIdIngrediente(rs.getInt("idIngrediente"));
                platoIngrediente.setCantidadNecesaria(rs.getDouble("cantidadNecesaria"));
                return platoIngrediente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(PlatoIngrediente platoIngrediente) {
        String sql = "UPDATE Plato_Ingrediente SET idPlato = ?, idIngrediente = ?, cantidadNecesaria = ? WHERE idPlatoIngrediente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, platoIngrediente.getIdPlato());
            stmt.setInt(2, platoIngrediente.getIdIngrediente());
            stmt.setDouble(3, platoIngrediente.getCantidadNecesaria());
            stmt.setInt(4, platoIngrediente.getIdPlatoIngrediente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Plato_Ingrediente WHERE idPlatoIngrediente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PlatoIngrediente> readAll() {
        String sql = "SELECT * FROM Plato_Ingrediente";
        List<PlatoIngrediente> platoIngredientes = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                PlatoIngrediente platoIngrediente = new PlatoIngrediente();
                platoIngrediente.setIdPlatoIngrediente(rs.getInt("idPlatoIngrediente"));
                platoIngrediente.setIdPlato(rs.getInt("idPlato"));
                platoIngrediente.setIdIngrediente(rs.getInt("idIngrediente"));
                platoIngrediente.setCantidadNecesaria(rs.getDouble("cantidadNecesaria"));
                platoIngredientes.add(platoIngrediente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return platoIngredientes;
    }
}
