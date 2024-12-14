package modelo;

public class Ingrediente {

    private int idIngrediente;
    private String nombre;
    private String unidadMedida;
    private double cantidadTotal;

    public Ingrediente() {
    }

    public Ingrediente(int idIngrediente, String nombre, String unidadMedida, double cantidadTotal) {
        this.idIngrediente = idIngrediente;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadTotal = cantidadTotal;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(double cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

}
