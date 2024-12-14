package modelo;

public class PedidoPlato {

    private int idPedidoPlato;
    private int idPedido;
    private int idPlato;
    private int cantidad;

    public PedidoPlato() {
    }

    public PedidoPlato(int idPedidoPlato, int idPedido, int idPlato, int cantidad) {
        this.idPedidoPlato = idPedidoPlato;
        this.idPedido = idPedido;
        this.idPlato = idPlato;
        this.cantidad = cantidad;
    }

    public int getIdPedidoPlato() {
        return idPedidoPlato;
    }

    public void setIdPedidoPlato(int idPedidoPlato) {
        this.idPedidoPlato = idPedidoPlato;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
