package ucb.programacionii.almacen.dominio;

/**
 *
 * @author ronal
 */
public class Articulo {

    private final int id;
    private String codigo;
    private String nombre;
    private float precio;

    public Articulo(int id, String codigo, String nombre, float precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
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
    
    public float getPrecio(){
        return this.precio;
    }
    
    public void setPrecio(float precio){
        this.precio = precio;
    }
}
