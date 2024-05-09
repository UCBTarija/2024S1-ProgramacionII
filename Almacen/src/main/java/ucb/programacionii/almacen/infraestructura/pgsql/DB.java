package ucb.programacionii.almacen.infraestructura.pgsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ronal
 */
public class DB {
    
    // PATRON SINGLETON
    // Este patron devuelve una sola instancia en varias llamadas
    
    private static Connection conn = null;

    public static Connection getConnection() throws SQLException {

        if (conn == null) {
            String url = "jdbc:postgresql://localhost:5432/ucb_almacen";
            conn = DriverManager.getConnection(url, "ucb", "Tarija00");
        }

        return conn;
    }
}
