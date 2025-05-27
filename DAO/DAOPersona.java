/*
 * 
 * 
 */
package DAO;


import grafica.ventAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.mycompany.polideportivo_alejandro.Deporte;
import com.mycompany.polideportivo_alejandro.Persona;

/**
 *
 * @author usuarioDAW
 */
public class DAOPersona  {
    
    public List<Persona> verInformacion(){
        Connection conn= null;
        List<Persona> personas = new ArrayList();
        String info = "select * from persona";
        try{
            conn= ConexionBD.conectarBD();
            Statement statement = conn.createStatement(); 
            ResultSet rs = statement.executeQuery(info);
            while(rs.next()){
               Persona p= new Persona(rs.getString("nombre"),
               rs.getString("apellido1"),rs.getString("apellido2"));
               p.setNum_contacto(rs.getString("numero_contacto"));
               p.setDni(rs.getString("dni"));
               p.setF_nac(rs.getDate("f_nac").toLocalDate());
               personas.add(p);
                
            }
        } catch (SQLException e) {
            System.err.println("Error en la conexion: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);   
    }
        return personas;
}
     public Persona verInformacionPersona(String username){
        Connection conn= null;
        Persona p = null;
        String info = "select nombre, apellido1, apellido2,numero_contacto,dni,f_nac"+
                " from persona as p join usuario as u on u.persona_id = p.id where u.username =?";
        try{
            conn= ConexionBD.conectarBD();
             PreparedStatement pst= conn.prepareStatement(info); 
             pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p = new Persona(rs.getString("nombre"),
                        rs.getString("apellido1"), rs.getString("apellido2"));
                p.setNum_contacto(rs.getString("numero_contacto"));
                p.setDni(rs.getString("dni"));
                p.setF_nac(rs.getDate("f_nac").toLocalDate());
            }
            
        } catch (SQLException e) {
            System.err.println("Error en la conexion: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);   
    }
        return p;
}
    public Persona insertarPersona(Persona persona){
       Connection conn= null;
       Persona p1= null;
        String crear= "INSERT INTO persona (nombre, apellido1, apellido2, f_nac, "
                + "numero_contacto, dni) VALUES (?,?,?,?,?,?)" ;
        
        try{
            conn=ConexionBD.conectarBD();
            PreparedStatement pst= conn.prepareStatement(crear);
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido1());
            pst.setString(3, persona.getApellido2());
            pst.setDate(4,java.sql.Date.valueOf(persona.getF_nac()));
            pst.setString(5, persona.getNum_contacto());
            pst.setString(6, persona.getDni());
            pst.executeUpdate();
            
        }catch (SQLException e){
            System.err.println("Insertar Usuario: Error en la conexión al servidor. " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);   
    }
        return p1;
    }
    public void eliminarPersona(String dni){
        Connection conn= null;
        Persona p= null;
        String borrar_usu = "delete from persona where id in "
                + "(select id from persona where dni = ?) ";
        try{
            conn=ConexionBD.conectarBD();
            PreparedStatement pst= conn.prepareStatement(borrar_usu);
            pst.setString(1,dni);
            pst.executeUpdate();
        }catch (SQLException e){
            System.err.println("Insertar Usuario: Error en la conexión al servidor. " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);   
    }
        
    }
    public Persona actualizarPersona(Persona persona){
            Connection conn=null;
            Persona p1=null;
            String actualizar="UPDATE persona SET nombre= ?,"
                + " apellido1=?, apellido2=?,f_nac=?,numero_contacto=? WHERE dni= ?";
     
      try{
            conn=ConexionBD.conectarBD();
            PreparedStatement pst= conn.prepareStatement(actualizar);
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido1());
            pst.setString(3, persona.getApellido2());
            pst.setDate(4,java.sql.Date.valueOf(persona.getF_nac()));
            pst.setString(5, persona.getNum_contacto());
            pst.setString(6, persona.getDni());
            
            pst.executeUpdate();
            
        }catch (SQLException e){
            System.err.println("Insertar Usuario: Error en la conexión al servidor. " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);   
    }
        return p1;
    }
}       
