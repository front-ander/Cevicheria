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
import modelo.Usuario;

public class UsuarioDAO implements GenericDAO<Usuario, Integer> {

    Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nombre, correoElectronico, contrasena, idRol) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreoElectronico());
            stmt.setString(3, usuario.getContrasena());
            stmt.setInt(4, usuario.getIdRol());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario read(Integer id) {
        String sql = "SELECT * FROM Usuario WHERE idUsuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreoElectronico(rs.getString("correoElectronico"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setIdRol(rs.getInt("idRol"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Usuario usuario) {
        String sql = "UPDATE Usuario SET nombre = ?, correoElectronico = ?, contrasena = ?, idRol = ? WHERE idUsuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreoElectronico());
            stmt.setString(3, usuario.getContrasena());
            stmt.setInt(4, usuario.getIdRol());
            stmt.setInt(5, usuario.getIdUsuario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Usuario WHERE idUsuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> readAll() {
        String sql = "SELECT * FROM Usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreoElectronico(rs.getString("correoElectronico"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setIdRol(rs.getInt("idRol"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario buscarPorCorreoContrasena(String correo, String contrasena) {
        String sql = "SELECT * FROM Usuario WHERE correoElectronico = ? AND contrasena = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreoElectronico(rs.getString("correoElectronico"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setIdRol(rs.getInt("idRol"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
