package modelo;

public class Plato {

    private int idPlato;
    private String nombre;
    private String descripcion;
    private double precio;

    public Plato(int idPlato, String nombre, String descripcion, double precio) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Plato() {
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " | Precio = S/." + precio;
    }

}
