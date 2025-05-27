/*
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;


/**
 *
 * @author Alex
 */
public class ConexionBD {
    /**
     * 
     * @return La conexión con la base de datos
     * @throws SQLException lanza el error en caso de fallo a la Base de datos.
     */
     public static Connection conectarBD() throws SQLException  {
        DriverManager.registerDriver(new Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/polideportivo", 
                "root", "");
        return conn;
    }
     /**
      * 
      * @param conn Cierra la conexión.
      */
    public static void desconectarBD(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error al desconectar BD: " + e.getMessage());
        }
    }   
}
