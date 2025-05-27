/*
 * Test para clase Persona
 */

import com.mycompany.polideportivo_alejandro.Persona;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author ahraz
 */
public class PersonaTest {

    private Persona persona;

    @BeforeEach
    void setUp() {
        persona = new Persona("Alejandro", "García", "López", "12345678A", "123456789", LocalDate.of(1990, 5, 20));
    }

    @Test
    @DisplayName("Crear Persona válida")
    void crearPersonaValida() {
        assertNotNull(persona, "La persona no debe ser nula");
        assertEquals("Alejandro", persona.getNombre(), "El nombre no coincide");
        assertEquals("García", persona.getApellido1(), "El primer apellido no coincide");
        assertEquals("López", persona.getApellido2(), "El segundo apellido no coincide");
        assertEquals("12345678A", persona.getDni(), "El DNI no coincide");
        assertEquals("123456789", persona.getNum_contacto(), "El número de contacto no coincide");
        assertEquals(LocalDate.of(1990, 5, 20), persona.getF_nac(), "La fecha de nacimiento no coincide");
    }

    @Test
    @DisplayName("Nombre con números que lanza excepción")
    void nombreConNumerosLanzaExcepcion() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Persona("Al3jandro", "García", "López", "12345678A", "123456789", LocalDate.of(1990, 5, 20));
        });
        assertTrue(exception.getMessage().contains("El nombre no puede tener numeros ni carácteres especiales"));
    }
    
    @Test
    @DisplayName("Nombre con inicial en minúsculas que lanza excepcion")
    void nombreConInicialMal(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Persona("alejandro", "garcía", "López", "12345678A", "123456789", LocalDate.of(1990, 5, 20));
        });
        assertFalse(exception.getMessage().contains("El nombre o apellidos no pueden empezar en minusculas"));
    }
    

    @Test
    void crearPersonaConDniInvalido() {
        LocalDate fecha = LocalDate.of(1990, 5, 10);
        assertThrows(IllegalArgumentException.class, () -> {
            new Persona("Ana", "Perez", "Lopez", "1234A", "123456789", fecha);
        });
    }

    @Test
    void crearPersonaConFechaNacimientoFutura() {
        LocalDate fechaFutura = LocalDate.now().plusDays(1);
        assertThrows(IllegalArgumentException.class, () -> {
            new Persona("Ana", "Perez", "Lopez", "12345678A", "123456789", fechaFutura);
        });
    
    }
}
