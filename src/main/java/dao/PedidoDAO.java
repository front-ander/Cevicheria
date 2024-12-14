package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;

public class PedidoDAO implements GenericDAO<Pedido, Integer> {

    Connection connection;

    public PedidoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Pedido pedido) {
        String sql = "INSERT INTO Pedido (idUsuario, fechaPedido, total, mesa, estado) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, pedido.getIdUsuario());
            stmt.setTimestamp(2, pedido.getFechaPedido());
            stmt.setDouble(3, pedido.getTotal());
            stmt.setInt(4, pedido.getMesa());
            stmt.setString(5, pedido.getEstado());
            int columAfectadas = stmt.executeUpdate();

            if (columAfectadas == 0) {
                throw new SQLException("Fallo al crear el registro");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pedido.setIdPedido(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Fallo al asignar el id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido read(Integer id) {
        String sql = "SELECT * FROM Pedido WHERE idPedido = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdUsuario(rs.getInt("idUsuario"));
                pedido.setFechaPedido(rs.getTimestamp("fechaPedido"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setMesa(rs.getInt("mesa"));
                pedido.setEstado(rs.getString("estado"));
                return pedido;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Pedido pedido) {
        String sql = "UPDATE Pedido SET idUsuario = ?, fechaPedido = ?, total = ?, mesa = ?, estado = ? WHERE idPedido = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getIdUsuario());
            stmt.setTimestamp(2, pedido.getFechaPedido());
            stmt.setDouble(3, pedido.getTotal());
            stmt.setInt(4, pedido.getMesa());
            stmt.setString(5, pedido.getEstado());
            stmt.setInt(6, pedido.getIdPedido());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Pedido WHERE idPedido = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pedido> readAll() {
        String sql = "SELECT * FROM Pedido";
        List<Pedido> pedidos = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdUsuario(rs.getInt("idUsuario"));
                pedido.setFechaPedido(rs.getTimestamp("fechaPedido"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setMesa(rs.getInt("mesa"));
                pedido.setEstado(rs.getString("estado"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public List<Pedido> buscarPorIdUsuario(int idUsuario) {
        String sql = "SELECT * FROM Pedido WHERE idUsuario = ?";
        List<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setIdPedido(rs.getInt("idPedido"));
                    pedido.setIdUsuario(rs.getInt("idUsuario"));
                    pedido.setFechaPedido(rs.getTimestamp("fechaPedido"));
                    pedido.setTotal(rs.getDouble("total"));
                    pedido.setMesa(rs.getInt("mesa"));
                    pedido.setEstado(rs.getString("estado"));
                    pedidos.add(pedido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }
}
