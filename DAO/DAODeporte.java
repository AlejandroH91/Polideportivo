/*
 * Clase dao para consultas sobre la clase deporte
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.polideportivo_alejandro.Deporte;
import com.mycompany.polideportivo_alejandro.Persona;

/**
 *
 * @author ahraz
 */
public class DAODeporte {
    
    public List<Deporte> verDeportes(){
        Connection conn = null;
        List<Deporte> nombre_deporte = new ArrayList();
        String deportes= "Select nombre from deportes";
        try{
            conn= ConexionBD.conectarBD();
            Statement statement = conn.createStatement(); 
            ResultSet rs = statement.executeQuery(deportes);
           while(rs.next()){
               Deporte d= new Deporte(rs.getString("nombre"));
                nombre_deporte.add(d);
           }
        } catch (SQLException e) {
            System.err.println("Error en la conexion: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);   
    }
      return nombre_deporte;  
    }
    
    public void insertarDeporte(String persona_id, String deporte_id){
        Connection conn= null;
        String deporte= "INSERT INTO persona_deporte(persona_id,deporte_id)"
                + "VALUES((select id from persona where dni = ?),"
                + " (select id from deportes where nombre = ?))";
        try{
            conn= ConexionBD.conectarBD();
            PreparedStatement pst= conn.prepareStatement(deporte);
            pst.setString(1,persona_id);
            pst.setString(2,deporte_id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en la conexion: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);   
    }
        
    }
    
    public List<String> mostrarDeporteaPesona(String nombre){
        Connection conn= null;
        Deporte dp=null;
        List<String> deportes= new ArrayList();
        String tdDeporte="SELECT p.nombre as 'nombre usuario',p.id, d.nombre as 'nombre deporte'FROM "
                + "usuario as u1 join persona as p on u1.persona_id= p.id join persona_deporte as pd on p.id = pd.persona_id "
                + "join deportes as d on pd.deporte_id = d.id where u1.username=?";
        
        try{
            conn= ConexionBD.conectarBD();
            PreparedStatement pst= conn.prepareStatement(tdDeporte);
            pst.setString(1,nombre);
            //pst.executeUpdate();
            ResultSet rs = pst.executeQuery();
        while (rs.next()) {
           deportes.add(rs.getString("nombre deporte"));
        }
        } catch (SQLException e) {
            System.err.println("Error en la conexion: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        
    }
      return deportes;
}
    
}
