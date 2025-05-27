package com.mycompany.polideportivo_alejandro;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/*
 * Clase usuario con características básicas.
 */
/**
 *
 * @author Alex
 */
public class Persona {
   
    private String nombre,apellido1,apellido2,dni,num_contacto;
    private Categoría categoria;
    private LocalDate f_nac;
    /**
     * @param Constructor1 para traer la información de la BD, con sus restricciones.
     * @param nombre Definimos el nombre del objeto persona
     * @param apellido1 Definimos el apellido del objeto persona
     * @param apellido2 Definimos el apellido del objeto persona
     * @param dni Definimos el DNI del objeto persona
     */
    public Persona(String nombre, String apellido1,String apellido2){
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
    }
    /**
     * @param Constructor2 Para lanzar una nueva persona que respete las restricciones de la BD.
     * @param nombre devuelve el nombre de la persona.
     * @param apellido1 devuelve el apellido de la persona.
     * @param apellido2 devuelve el apellido de la persona.
     * @param dni devuelve el dni de la persona.
     * @param num_contacto devuelve el numero de contacto de la persona.
     * @param f_nac devuelve la fecha de nacimiento de la persona.(Desde ella se calcula la edad).
     */ 
    public Persona(String nombre, String apellido1,String apellido2,String dni,String num_contacto,LocalDate f_nac){ 
	if (nombre.matches("[A-ZÁÉÍÓÚÑ][a-záéíóúñ]*")) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre no puede tener numeros ni carácteres especiales"
                    + " y tiene que empezar por mayusculas.");
        }
        //Comprobamos que no tenga numeros ni otros caracteres.
        if (apellido1.matches("[A-ZÁÉÍÓÚÑ][a-záéíóúñ]*")) {
            this.apellido1 = apellido1;
        } else {
            throw new IllegalArgumentException("El nombre no puede tener numeros ni carácteres especiales"
                    + "y tiene que empezar por mayusculas.");
        //Comprobamos que no tenga numeros ni otros caracteres.
        }
        if (apellido2.matches("[A-ZÁÉÍÓÚÑ][a-záéíóúñ]*")) {
            this.apellido2 = apellido2;
        } else {
            throw new IllegalArgumentException("El nombre no puede tener numeros ni carácteres especiales "
                    + "y tiene que empezar por mayusculas.");
        }
	if(dni.matches("\\d{8}[A-Z]")){
	this.dni=dni;
	}else{
	    throw new IllegalArgumentException("El DNI son 8 numeros y una letra MAYUSCULA.");
        }
        if(num_contacto.matches("\\d{9}")){
            this.num_contacto= num_contacto;
        }
        LocalDate hoy= LocalDate.now();
        if(f_nac.isBefore(hoy)){
            this.f_nac=f_nac;
        }else{
            throw new IllegalArgumentException("La fecha no pudeser después del dia de hoy.");
        }
        
}
   /**
    * 
    * @return La edad de la persona en función de su fecha de nacimiento.
    */
    public int getEdad(){
        LocalDate hoy= LocalDate.now();
        return Period.between(f_nac, hoy).getYears();
    }
    /**
     * 
     * @return La categoría en función de la edad.
     */
    public Categoría getCategoria(){
        return Categoría.categoriaPoEdad(getEdad());
    }
    
     public int setEdad(int edad){
        LocalDate hoy= LocalDate.now();
        return Period.between(f_nac, hoy).getYears();
    }
   /**
    * 
    * @return devuelve el nombre de la persona
    */
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @return Obtiene el apellido de la persona
     */
    public String getApellido1() {
        return apellido1;
    }
    /**
     * 
     * @return Devuelve el segundo apellido de la persona
     */
    public String getApellido2() {
        return apellido2;
    }

    public String getDni() {
        return dni;
    }
    /**
     * 
     * @return devuelve el numero de contacto de la persona.
     */
    public String getNum_contacto() {
        return num_contacto;
    }
  

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNum_contacto(String num_contacto) {
        this.num_contacto = num_contacto;
    }

    public LocalDate getF_nac() {
        return f_nac;
    }

    public void setF_nac(LocalDate f_nac) {
        this.f_nac = f_nac;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.dni);
        hash = 13 * hash + Objects.hashCode(this.num_contacto);
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return Objects.equals(this.num_contacto, other.num_contacto);
    }

    @Override
    public String toString() {
        return "Nombre: "+ nombre + " apellido: " + apellido1 + " apellido: " + apellido2 + " Dni: " + dni;
    }

}
