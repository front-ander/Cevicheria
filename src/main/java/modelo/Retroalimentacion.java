package modelo;

/**
 *
 * @author Anderson
 */
public class Retroalimentacion {

    private int idRetroalimentacion;
    private int idPedido;
    private String comentario;
    private int calificacion;

    public Retroalimentacion() {
    }

    public Retroalimentacion(int idRetroalimentacion, int idPedido, String comentario, int calificacion) {
        this.idRetroalimentacion = idRetroalimentacion;
        this.idPedido = idPedido;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public int getIdRetroalimentacion() {
        return idRetroalimentacion;
    }

    public void setIdRetroalimentacion(int idRetroalimentacion) {
        this.idRetroalimentacion = idRetroalimentacion;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

}
