package actores;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase que modela los servicios medicos que prestara la entidad
 * @author Jhonnier Hernandez
 */
public class GestionServiciosMedicos implements IGestionDatos{
    private List<String> serviciosMedicos;

    public GestionServiciosMedicos() {
        
        serviciosMedicos = new ArrayList<>();
    }
    
    /**
     * Crea la ventana en la que se captura el nombre del servicio medico a 
     * agregar a la lista.
     */
    @Override
    public void agregar() {
        
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Que servicio medico desea agregar: ");
//        String servicio = scanner.nextLine();
//        serviciosMedicos.add(servicio);
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
    public String listar() {
        
        String cadena = "";
        for(var servicio : serviciosMedicos){
            cadena += servicio + "\n";
        }
        return cadena;
    }
    
    public String seleccionarServicio(){
        
        String seleccion = JOptionPane.showInputDialog("Ingrese el numero del servicio medico que precisa");
        int intSeleccion = Integer.parseInt(seleccion);
        
        return serviciosMedicos.get(intSeleccion);
    }
    
    /**
     * Genera el archivo csv para la persistencia.
     */
    @Override
    public void generarCSV() {
        
        
    }
    
}
