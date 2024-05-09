package ucb.programacionii.almacen.dominio;

/**
 *
 * @author ronal
 */
public class Articulo {

    private final int id;
    private String codigo;
    private String nombre;

    public Articulo(int id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
