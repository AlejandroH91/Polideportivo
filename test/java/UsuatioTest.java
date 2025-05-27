/*
 * Test básicos del usuario.
 */

import com.mycompany.polideportivo_alejandro.Usuario;
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
public class UsuatioTest {

    Usuario u1 = null;
    

    @BeforeEach
    public void setUp() {
        u1 = new Usuario("Marina", "pass53", false);
        
    }

    @Test
    @DisplayName("Crear Usuario válido")
    void crearUsuarioValido() {
        assertEquals("Marina", u1.getUsername(), "El nombre no coincide");
        assertEquals("pass53", u1.getPassword(), "La password no es correcta");
        assertFalse(u1.es_Admin(), "El rol del usuario no es correcto");
    }
    
    @Test
    @DisplayName("Modificar nombre de usuario")
    void modificarNombreUsuario() {
        u1.setUsername("Laura");
        assertEquals("Laura", u1.getUsername(), "El nombre de usuario no se modificó correctamente");
    }
     @Test
    @DisplayName("Modificar contraseña del usuario")
    void modificarPassword() {
        u1.setPassword("nuevaPass");
        assertEquals("nuevaPass", u1.getPassword(), "La contraseña no se modificó correctamente");
    }

    @Test
    @DisplayName("Cambiar rol de usuario a administrador")
    void cambiarRolAAdministrador() {
        u1.setEs_Admin(true);
        assertTrue(u1.es_Admin(), "El usuario debería tener rol de administrador");
    }
}
