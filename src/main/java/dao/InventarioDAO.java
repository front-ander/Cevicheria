package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Inventario;

public class InventarioDAO implements GenericDAO<Inventario, Integer> {

    Connection connection;

    public InventarioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Inventario inventario) {
        String sql = "INSERT INTO Inventario (idIngrediente, cantidad, fechaVencimiento) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, inventario.getIdIngrediente());
            stmt.setDouble(2, inventario.getCantidad());
            stmt.setDate(3, inventario.getFechaVencimiento());
            int columAfectadas = stmt.executeUpdate();
            if (columAfectadas == 0) {
                throw new SQLException("Fallo al crear el registro");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    inventario.setIdInventario(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Fallo al asignar el id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Inventario read(Integer id) {
        String sql = "SELECT * FROM Inventario WHERE idInventario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Inventario inventario = new Inventario();
                inventario.setIdInventario(rs.getInt("idInventario"));
                inventario.setIdIngrediente(rs.getInt("idIngrediente"));
                inventario.setCantidad(rs.getDouble("cantidad"));
                inventario.setFechaVencimiento(rs.getDate("fechaVencimiento"));
                return inventario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Inventario inventario) {
        String sql = "UPDATE Inventario SET idIngrediente = ?, cantidad = ?, fechaVencimiento = ? WHERE idInventario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, inventario.getIdIngrediente());
            stmt.setDouble(2, inventario.getCantidad());
            stmt.setDate(3, inventario.getFechaVencimiento());
            stmt.setInt(4, inventario.getIdInventario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Inventario WHERE idInventario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Inventario> readAll() {
        String sql = "SELECT * FROM Inventario";
        List<Inventario> inventarios = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Inventario inventario = new Inventario();
                inventario.setIdInventario(rs.getInt("idInventario"));
                inventario.setIdIngrediente(rs.getInt("idIngrediente"));
                inventario.setCantidad(rs.getDouble("cantidad"));
                inventario.setFechaVencimiento(rs.getDate("fechaVencimiento"));
                inventarios.add(inventario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventarios;
    }

    public Inventario buscarPorIdIngrediente(int idIngrediente) {
        String sql = "SELECT * FROM Inventario WHERE idIngrediente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idIngrediente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Inventario inventario = new Inventario();
                inventario.setIdInventario(rs.getInt("idInventario"));
                inventario.setIdIngrediente(rs.getInt("idIngrediente"));
                inventario.setCantidad(rs.getDouble("cantidad"));
                inventario.setFechaVencimiento(rs.getDate("fechaVencimiento"));
                return inventario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
