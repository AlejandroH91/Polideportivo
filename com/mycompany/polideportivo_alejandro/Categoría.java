/*
 * 
 * 
 */
package com.mycompany.polideportivo_alejandro;

/**
 *
 * @author Alex
 */
public enum Categoría {
    BENJAMIN,
    ALEVIN,
    INFANTIL,
    CADETE,
    JUVENIL,
    SENIOR;
    
       public static Categoría categoriaPoEdad(int edad) {
        if (edad >= 8 && edad < 10) {
            return BENJAMIN;
        } else if (edad >= 10 && edad < 12) {
            return ALEVIN;
        } else if (edad >= 12 && edad < 14) {
            return INFANTIL;
        } else if (edad >= 14 && edad < 16) {
            return CADETE;
        } else if (edad >= 16 && edad < 18) {
            return JUVENIL;
        } else {
            return SENIOR;
        }
    }
}
