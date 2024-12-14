package modelo;

import java.sql.Date;

public class Inventario {

    private int idInventario;
    private int idIngrediente;
    private double cantidad;
    private Date fechaVencimiento;

    public Inventario() {
    }

    public Inventario(int idInventario, int idIngrediente, double cantidad, Date fechaVencimiento) {
        this.idInventario = idInventario;
        this.idIngrediente = idIngrediente;
        this.cantidad = cantidad;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
