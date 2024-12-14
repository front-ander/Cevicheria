package modelo;

import java.sql.Timestamp;

public class Pago {

    private int idPago;
    private int idPedido;
    private Timestamp fechaPago;
    private double monto;
    private String metodo;

    public Pago() {
    }

    public Pago(int idPago, int idPedido, Timestamp fechaPago, double monto, String metodo) {
        this.idPago = idPago;
        this.idPedido = idPedido;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.metodo = metodo;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Timestamp getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Timestamp fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

}
