package modelo;

import java.sql.Timestamp;

public class Pedido {

    private int idPedido;
    private int idUsuario;
    private Timestamp fechaPedido;
    private double total;
    private int mesa;
    private String estado;

    public Pedido(int idPedido, int idUsuario, Timestamp fechaPedido, double total, int mesa, String estado) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.mesa = mesa;
        this.estado = estado;
    }

    public Pedido() {

    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Timestamp getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Timestamp fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
