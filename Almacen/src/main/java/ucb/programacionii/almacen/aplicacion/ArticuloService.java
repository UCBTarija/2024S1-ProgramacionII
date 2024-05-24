package ucb.programacionii.almacen.aplicacion;

import java.util.ArrayList;
import ucb.programacionii.almacen.dominio.Articulo;
import ucb.programacionii.almacen.dominio.ArticuloRepository;

/**
 *
 * @author ronal
 */
public class ArticuloService {

    private final ArticuloRepository articuloRepository;

    public ArticuloService(ArticuloRepository repository) {
        this.articuloRepository = repository;
    }

    // (C)REATE
    public Articulo createArticulo() {
        int id = this.articuloRepository.nextIdentity();
        Articulo articulo = new Articulo(id, "", "", 0);
        return articulo;
    }

    public Articulo addArticulo(Articulo articulo) throws Exception {
        // 1: validación de datos

        // 2: guarda el objeto
        if (this.articuloRepository.store(articulo)) {
            return articulo;
        } else {
            throw new Exception("No se pudo guardar el artículo");
        }
    }

    // (R)EAD
    public Articulo getArticulo(int id) {
        return this.articuloRepository.getById(id);
    }

    public ArrayList<Articulo> search(String filtro) {
        return this.articuloRepository.search(filtro);
    }

    // (U)PDATE
    public boolean updateArticulo(Articulo articulo) throws Exception {
        //1: valida los nuevos datos
        // 2.1: recupera objeto original            
        // 2.2: compara y valida datos

        // guarda el objeto
        if (this.articuloRepository.store(articulo)) {
            return true;
        } else {
            throw new Exception("No se pudo guardar el artículo");
        }
    }

    // (D)ELETE
    public boolean deleteArticulo(Articulo articulo) throws Exception {
        //1: valida si se puede borrar

        //2: borra el objeto
        return this.articuloRepository.delete(articulo);
    }
}
