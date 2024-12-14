package modelo;
/**
 *
 * @author Anderson
 */
public class PlatoIngrediente {

    private int idPlatoIngrediente;
    private int idPlato;
    private int idIngrediente;
    private double cantidadNecesaria;

    public PlatoIngrediente() {
    }

    public PlatoIngrediente(int idPlatoIngrediente, int idPlato, int idIngrediente, double cantidadNecesaria) {
        this.idPlatoIngrediente = idPlatoIngrediente;
        this.idPlato = idPlato;
        this.idIngrediente = idIngrediente;
        this.cantidadNecesaria = cantidadNecesaria;
    }

    public int getIdPlatoIngrediente() {
        return idPlatoIngrediente;
    }

    public void setIdPlatoIngrediente(int idPlatoIngrediente) {
        this.idPlatoIngrediente = idPlatoIngrediente;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public double getCantidadNecesaria() {
        return cantidadNecesaria;
    }

    public void setCantidadNecesaria(double cantidadNecesaria) {
        this.cantidadNecesaria = cantidadNecesaria;
    }

}
