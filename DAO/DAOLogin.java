/*
 * Clase para objeto de confirmación en el login.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.polideportivo_alejandro.Persona;
import java.sql.PreparedStatement;
import com.mycompany.polideportivo_alejandro.Usuario;

/**
 *
 * @author Alex
 */
public class DAOLogin extends ConexionBD {
    ConexionBD conn;
    
    public Usuario confirmacionLogin(String username, String password) {
        //Creo conexión y usuario vacío para usarlos después.
        Connection conn= null;
        Usuario usuario= null;
        String nombre_pass = "select username, password, es_Admin from usuario where "
                + "username = ? and password = ?";
        try{
            conn= ConexionBD.conectarBD();
            PreparedStatement statement = conn.prepareStatement(nombre_pass); 
            statement.setString(1, username);
            statement.setString(2, password);
            //Ejecutamos la consulta
            ResultSet resultSet = statement.executeQuery();
            //Si hay resultado, crea un usuario con nombre y pass, con los datos de la BD.
            if(resultSet.next()){
                usuario = new Usuario(resultSet.getString("username"),resultSet.getString("password"), resultSet.getBoolean("es_Admin"));
                //si hay resultado
            }
        } catch (SQLException e) {
            System.err.println("confirmacion: " + e.getMessage());
        }  finally {
            ConexionBD.desconectarBD(conn);   
    }
        return usuario;
   }    
}
