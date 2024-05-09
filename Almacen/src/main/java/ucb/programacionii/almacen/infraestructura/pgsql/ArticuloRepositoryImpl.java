package ucb.programacionii.almacen.infraestructura.pgsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ucb.programacionii.almacen.dominio.Articulo;
import ucb.programacionii.almacen.dominio.ArticuloRepository;

/**
 *
 * @author ronal
 */
public class ArticuloRepositoryImpl implements ArticuloRepository {

    @Override
    public boolean store(Articulo articulo) {
        String sql = "INSERT INTO articulo (id, codigo, nombre) "
                + "VALUES (?, ?, ?) "
                + "ON CONFLICT DO UPDATE SET "
                + "codigo = EXCLUDED.codigo "
                + "nombre = EXCLUDED.nombre";
        try (PreparedStatement stm = DB.getConnection().prepareStatement(sql)) {            
            stm.setInt(1, articulo.getId());
            stm.setString(2, articulo.getCodigo());
            stm.setString(3, articulo.getNombre());
            
            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean delete(Articulo articulo) {
        String sql = "DELETE FROM articulo WHERE id = ?";
        try (PreparedStatement stm = DB.getConnection().prepareStatement(sql)) {            
            stm.setInt(1, articulo.getId());
            
            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public Articulo getById(int id) {
        Articulo articulo = null;

        String sql = "SELECT * FROM articulo WHERE id = ?";
        try (PreparedStatement stm = DB.getConnection().prepareStatement(sql)) {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            articulo = null;
            if (rs.next()) {
                articulo = new Articulo(
                        rs.getInt("id"),
                        rs.getString("codigo"),
                        rs.getString("nombre")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return articulo;
    }

    @Override
    public ArrayList<Articulo> search(String filtro) {
        ArrayList<Articulo> lista = new ArrayList();

        String sql = "SELECT * FROM articulo "
                + "WHERE nombre LIKE ? "
                + "OR codigo = ?";

        try (PreparedStatement stm = DB.getConnection().prepareStatement(sql)) {
            stm.setString(1, "%" + filtro + "%");
            stm.setString(2, filtro);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Articulo articulo = new Articulo(
                        rs.getInt("id"),
                        rs.getString("codigo"),
                        rs.getString("nombre")
                );
                lista.add(articulo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public int nextIdentity() {
        try (Statement stm = DB.getConnection().createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT nextval('articulo_id_seq') id");
            if (rs.next()) {
                int id = rs.getInt(1);
                return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

}
