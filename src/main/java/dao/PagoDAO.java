package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Pago;

public class PagoDAO implements GenericDAO<Pago, Integer> {

    Connection connection;

    public PagoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Pago pago) {
        String sql = "INSERT INTO Pago (idPedido, fechaPago, monto, metodo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pago.getIdPedido());
            stmt.setTimestamp(2, pago.getFechaPago());
            stmt.setDouble(3, pago.getMonto());
            stmt.setString(4, pago.getMetodo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pago read(Integer id) {
        String sql = "SELECT * FROM Pago WHERE idPago = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Pago pago = new Pago();
                pago.setIdPago(rs.getInt("idPago"));
                pago.setIdPedido(rs.getInt("idPedido"));
                pago.setFechaPago(rs.getTimestamp("fechaPago"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setMetodo(rs.getString("metodo"));
                return pago;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Pago pago) {
        String sql = "UPDATE Pago SET idPedido = ?, fechaPago = ?, monto = ?, metodo = ? WHERE idPago = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pago.getIdPedido());
            stmt.setTimestamp(2, pago.getFechaPago());
            stmt.setDouble(3, pago.getMonto());
            stmt.setString(4, pago.getMetodo());
            stmt.setInt(5, pago.getIdPago());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Pago WHERE idPago = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pago> readAll() {
        String sql = "SELECT * FROM Pago";
        List<Pago> pagos = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Pago pago = new Pago();
                pago.setIdPago(rs.getInt("idPago"));
                pago.setIdPedido(rs.getInt("idPedido"));
                pago.setFechaPago(rs.getTimestamp("fechaPago"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setMetodo(rs.getString("metodo"));
                pagos.add(pago);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pagos;
    }
}
