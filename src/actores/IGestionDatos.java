package actores;

/**
 * Interfaz que define los metodos necesarios para realizar el manejo 
 * CRUD de la gestion de datos.
 * @author Jhonnier Hernandez
 */


public interface IGestionDatos {
    public void agregar();
    public void actualizar();
    public void eliminar();
    public void listar();
    public void generarCSV();
}
