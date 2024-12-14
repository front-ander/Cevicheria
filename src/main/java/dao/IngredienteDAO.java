package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Ingrediente;

public class IngredienteDAO implements GenericDAO<Ingrediente, Integer> {

    Connection connection;

    public IngredienteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Ingrediente ingrediente) {
        String sql = "INSERT INTO Ingrediente (nombre, unidadMedida, cantidadTotal) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ingrediente.getNombre());
            stmt.setString(2, ingrediente.getUnidadMedida());
            stmt.setDouble(3, ingrediente.getCantidadTotal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ingrediente read(Integer id) {
        String sql = "SELECT * FROM Ingrediente WHERE idIngrediente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setIdIngrediente(rs.getInt("idIngrediente"));
                ingrediente.setNombre(rs.getString("nombre"));
                ingrediente.setUnidadMedida(rs.getString("unidadMedida"));
                ingrediente.setCantidadTotal(rs.getDouble("cantidadTotal"));
                return ingrediente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Ingrediente ingrediente) {
        String sql = "UPDATE Ingrediente SET nombre = ?, unidadMedida = ?, cantidadTotal = ? WHERE idIngrediente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ingrediente.getNombre());
            stmt.setString(2, ingrediente.getUnidadMedida());
            stmt.setDouble(3, ingrediente.getCantidadTotal());
            stmt.setInt(4, ingrediente.getIdIngrediente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Ingrediente WHERE idIngrediente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ingrediente> readAll() {
        String sql = "SELECT * FROM Ingrediente";
        List<Ingrediente> ingredientes = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setIdIngrediente(rs.getInt("idIngrediente"));
                ingrediente.setNombre(rs.getString("nombre"));
                ingrediente.setUnidadMedida(rs.getString("unidadMedida"));
                ingrediente.setCantidadTotal(rs.getDouble("cantidadTotal"));
                ingredientes.add(ingrediente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredientes;

    }

    public void quitarCantidadSegunPlato(int idPlato, int cantidad) throws SQLException {
        agregarCantidadSegunPlato(idPlato, -1 * cantidad);
    }

    public void agregarCantidadSegunPlato(int idPlato, int cantidad) throws SQLException {
        String sql = "UPDATE i "
            + "SET i.cantidadTotal = i.cantidadTotal + (pi.cantidadNecesaria * ?) "
            + "FROM Ingrediente i "
            + "INNER JOIN Plato_Ingrediente pi ON i.idIngrediente = pi.idIngrediente "
            + "WHERE pi.idPlato = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cantidad);
            stmt.setInt(2, idPlato);
            stmt.executeUpdate();
        }
    }

}
