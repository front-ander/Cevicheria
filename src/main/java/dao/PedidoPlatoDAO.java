package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.PedidoPlato;

public class PedidoPlatoDAO implements GenericDAO<PedidoPlato, Integer> {

    Connection connection;

    public PedidoPlatoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(PedidoPlato pedidoPlato) {
        String sql = "INSERT INTO Pedido_Plato (idPedido, idPlato, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pedidoPlato.getIdPedido());
            stmt.setInt(2, pedidoPlato.getIdPlato());
            stmt.setInt(3, pedidoPlato.getCantidad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PedidoPlato read(Integer id) {
        String sql = "SELECT * FROM Pedido_Plato WHERE idPedidoPlato = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                PedidoPlato pedidoPlato = new PedidoPlato();
                pedidoPlato.setIdPedidoPlato(rs.getInt("idPedidoPlato"));
                pedidoPlato.setIdPedido(rs.getInt("idPedido"));
                pedidoPlato.setIdPlato(rs.getInt("idPlato"));
                pedidoPlato.setCantidad(rs.getInt("cantidad"));
                return pedidoPlato;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(PedidoPlato pedidoPlato) {
        String sql = "UPDATE Pedido_Plato SET idPedido = ?, idPlato = ?, cantidad = ? WHERE idPedidoPlato = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pedidoPlato.getIdPedido());
            stmt.setInt(2, pedidoPlato.getIdPlato());
            stmt.setInt(3, pedidoPlato.getCantidad());
            stmt.setInt(4, pedidoPlato.getIdPedidoPlato());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Pedido_Plato WHERE idPedidoPlato = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PedidoPlato> readAll() {
        String sql = "SELECT * FROM Pedido_Plato";
        List<PedidoPlato> pedidoPlatos = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                PedidoPlato pedidoPlato = new PedidoPlato();
                pedidoPlato.setIdPedidoPlato(rs.getInt("idPedidoPlato"));
                pedidoPlato.setIdPedido(rs.getInt("idPedido"));
                pedidoPlato.setIdPlato(rs.getInt("idPlato"));
                pedidoPlato.setCantidad(rs.getInt("cantidad"));
                pedidoPlatos.add(pedidoPlato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidoPlatos;
    }

}
