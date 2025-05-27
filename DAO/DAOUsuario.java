/*
 * Clase DAO, para las acciones con objetos Usuario y datos de la BD
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mycompany.polideportivo_alejandro.Persona;

/**
 *
 * @author ahraz
 */
public class DAOUsuario {
  
  public void insertarUsuario(String dni,String username,String password){
      Connection conn=null;
      String usu="insert into usuario(persona_id,username, password)"
              + "values((select id from persona where dni = ?),?,?)";
      try{
         conn= ConexionBD.conectarBD();
         PreparedStatement pst= conn.prepareStatement(usu);
         pst.setString(1, dni);         
         pst.setString(2, username);         
         pst.setString(3, password);         
         pst.executeUpdate();
      }catch (SQLException e){
            System.err.println("Insertar Usuario: Error en la conexión al servidor. " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);   
    }
  }
}
