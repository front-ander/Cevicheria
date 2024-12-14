package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Plato;

public class PlatoDAO implements GenericDAO<Plato, Integer> {

    Connection connection;

    public PlatoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Plato plato) {
        String sql = "INSERT INTO Plato (nombre, descripcion, precio) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, plato.getNombre());
            stmt.setString(2, plato.getDescripcion());
            stmt.setDouble(3, plato.getPrecio());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Plato read(Integer id) {
        String sql = "SELECT * FROM Plato WHERE idPlato = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Plato plato = new Plato();
                plato.setIdPlato(rs.getInt("idPlato"));
                plato.setNombre(rs.getString("nombre"));
                plato.setDescripcion(rs.getString("descripcion"));
                plato.setPrecio(rs.getDouble("precio"));
                return plato;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Plato plato) {
        String sql = "UPDATE Plato SET nombre = ?, descripcion = ?, precio = ? WHERE idPlato = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, plato.getNombre());
            stmt.setString(2, plato.getDescripcion());
            stmt.setDouble(3, plato.getPrecio());
            stmt.setInt(4, plato.getIdPlato());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Plato WHERE idPlato = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Plato> readAll() {
        String sql = "SELECT * FROM Plato";
        List<Plato> platos = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Plato plato = new Plato();
                plato.setIdPlato(rs.getInt("idPlato"));
                plato.setNombre(rs.getString("nombre"));
                plato.setDescripcion(rs.getString("descripcion"));
                plato.setPrecio(rs.getDouble("precio"));
                platos.add(plato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return platos;
    }

    public List<Plato> buscarPlatosPorIdPedido(int idPedido) {
        List<Plato> platos = new ArrayList<>();
        String sql = "SELECT p.idPlato, p.nombre, p.descripcion, p.precio FROM Plato p "
            + "JOIN Pedido_Plato pp ON p.idPlato = pp.idPlato WHERE pp.idPedido = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idPedido);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Plato plato = new Plato();
                    plato.setIdPlato(rs.getInt("idPlato"));
                    plato.setNombre(rs.getString("nombre"));
                    plato.setDescripcion(rs.getString("descripcion"));
                    plato.setPrecio(rs.getDouble("precio"));
                    platos.add(plato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return platos;
    }

    public int obtenerMaxStockDePlato(int idPlato) {
        String sqlIngredientes = "SELECT pi.idIngrediente, pi.cantidadNecesaria, i.cantidadTotal "
            + "FROM Plato_Ingrediente pi "
            + "JOIN Ingrediente i ON pi.idIngrediente = i.idIngrediente "
            + "WHERE pi.idPlato = ?";
        int maxStock = Integer.MAX_VALUE;

        try (PreparedStatement stmt = connection.prepareStatement(sqlIngredientes)) {
            stmt.setInt(1, idPlato);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int idIngrediente = rs.getInt("idIngrediente");
                    double cantidadNecesaria = rs.getDouble("cantidadNecesaria");
                    double cantidadDisponible = rs.getDouble("cantidadTotal");

                    int stockPosible = (int) (cantidadDisponible / cantidadNecesaria);
                    if (stockPosible < maxStock) {
                        maxStock = stockPosible;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxStock;
    }

}
