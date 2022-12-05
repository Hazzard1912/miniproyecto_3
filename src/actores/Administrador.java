package actores;

/**
 * Esta clase va a servir para simular el sistema de autenticacion.
 * Al momento de ejecutar el programa se va a crear un objeto de tipo 
 * Administrador con el nombre de usuario y contraseña.
 * @author Jhonnier Hernandez
 */
public class Administrador {
    private final String nombreUsuario = "admin";
    private final char[] contrasena = {'1', '2', '3', '4'};
    
    /**
     * Crea que el administrador simulando tener los datos para hacer la 
     * autenticacion.
     */
    public Administrador() {
    }
    
    /**
     * Retorna el nombre de usuario
     * @return el valor de nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    /**
     * Retorna la contrasena
     * @return el valor de contrasena
     */
    public char[] getContrasena() {
        return contrasena;
    }
}
