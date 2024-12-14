package dao;

public class DAOManager {

    private UsuarioDAO usuarioDAO;
    private PlatoDAO platoDAO;
    private IngredienteDAO ingredienteDAO;
    private InventarioDAO inventarioDAO;
    private PedidoDAO pedidoDAO;
    private PedidoPlatoDAO pedidoPlatoDAO;
    private PlatoIngredienteDAO platoIngredienteDAO;
    private PagoDAO pagoDAO;
    private RetroalimentacionDAO retroalimentacionDAO;

    public DAOManager() {
        this.usuarioDAO = new UsuarioDAO(DatabaseConnection.getConnection());
        this.platoDAO = new PlatoDAO(DatabaseConnection.getConnection());
        this.ingredienteDAO = new IngredienteDAO(DatabaseConnection.getConnection());
        this.inventarioDAO = new InventarioDAO(DatabaseConnection.getConnection());
        this.pedidoDAO = new PedidoDAO(DatabaseConnection.getConnection());
        this.pedidoPlatoDAO = new PedidoPlatoDAO(DatabaseConnection.getConnection());
        this.platoIngredienteDAO = new PlatoIngredienteDAO(DatabaseConnection.getConnection());
        this.pagoDAO = new PagoDAO(DatabaseConnection.getConnection());
        this.retroalimentacionDAO = new RetroalimentacionDAO(DatabaseConnection.getConnection());
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public PlatoDAO getPlatoDAO() {
        return platoDAO;
    }

    public IngredienteDAO getIngredienteDAO() {
        return ingredienteDAO;
    }

    public InventarioDAO getInventarioDAO() {
        return inventarioDAO;
    }

    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public PedidoPlatoDAO getPedidoPlatoDAO() {
        return pedidoPlatoDAO;
    }

    public PlatoIngredienteDAO getPlatoIngredienteDAO() {
        return platoIngredienteDAO;
    }

    public PagoDAO getPagoDAO() {
        return pagoDAO;
    }

    public RetroalimentacionDAO getRetroalimentacionDAO() {
        return retroalimentacionDAO;
    }
}
