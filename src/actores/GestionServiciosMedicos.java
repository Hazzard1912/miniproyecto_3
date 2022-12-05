package actores;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela los servicios medicos que prestara la entidad
 * @author Jhonnier Hernandez
 */
public class GestionServiciosMedicos implements IGestionDatos{
    private List<String> serviciosMedicos = new ArrayList<>();

    public GestionServiciosMedicos() {
    }
    
    /**
     * Crea la ventana en la que se captura el nombre del servicio medico a 
     * agregar a la lista.
     */
    @Override
    public void agregar() {
        
    }
    
    /**
     * Crea la ventana que captura los datos (posicion - int y nombre - String)
     * para actualizarlo en la lista.
     */
    @Override
    public void actualizar() {
    }
    
    /**
     * Crea la ventana que captura la posicion que se va a eliminar de la lista.
     */
    @Override
    public void eliminar() {
    }
    
    /**
     * Crea la ventana que lista los servicios medicos que presta la entidad.
     */
    @Override
    public void listar() {
        for(var servicio : serviciosMedicos){
            System.out.println(servicio);
        }
    }
    
    /**
     * Genera el archivo csv para la persistencia.
     */
    @Override
    public void generarCSV() {
    }
    
}
