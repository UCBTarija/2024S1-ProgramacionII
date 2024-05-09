package ucb.programacionii.almacen.dominio;

import java.util.ArrayList;

/**
 *
 * @author ronal
 */
public interface ArticuloRepository {
    public boolean store(Articulo articulo);
    public boolean delete(Articulo articulo);
    public Articulo getById(int id);
    public ArrayList<Articulo> search(String filtro);
    public int nextIdentity();
}
