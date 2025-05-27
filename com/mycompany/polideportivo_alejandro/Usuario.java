/* 
 *Clase usuario para comprobar el login de usuario. 
 */
package com.mycompany.polideportivo_alejandro;

import java.util.Objects;

/**
 *
 * @author Alex
 */
public class Usuario {
   private String username;
   private String password;
   private boolean es_Admin;
    
    public Usuario(String username, String password,boolean es_Admin){
        this.username= username;
        this.password=password;
        this.es_Admin=es_Admin;
    }
    public Usuario(String username, String password){
        this.username= username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean es_Admin(){
        return es_Admin;
    }
    public void setEs_Admin(boolean esAdmin) {
    this.es_Admin = esAdmin;
}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.username);
        hash = 61 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }
    
    
}
