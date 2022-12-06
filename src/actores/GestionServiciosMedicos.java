package actores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del servicio medico a agregar");
        serviciosMedicos.add(nombre);
        //Hacer validacion de campo no vacio...
        JOptionPane.showMessageDialog(null, "Servicio agregado con exito a la lista");
    }
    
    /**
     * Crea la ventana que captura los datos (posicion - int y nombre - String)
     * para actualizarlo en la lista.
     */
    @Override
    public void actualizar() {
        
        String nombre = JOptionPane.showInputDialog("ingrese el nombre del servicio medico a actualizar");
        boolean existe = false;
        int posicion;
        for(var servicio : serviciosMedicos){
            if(servicio.equals(nombre)){
                existe = true;
                posicion = serviciosMedicos.indexOf(servicio);
                String nuevoNombre = JOptionPane.showInputDialog("ingrese el nuevo nombre del servicio");
                serviciosMedicos.set(posicion, nuevoNombre);
                JOptionPane.showMessageDialog(null, "servicio agregado a la lista con exito");
            }
        }
        if(existe == false){
            JOptionPane.showMessageDialog(null, "El servicio no se encuentra registrado en la lista");
        }
    }
    
    /**
     * Crea la ventana en la cual se captura el nombre del servicio medico que
     * va a ser eliminado de la lista.
     */
    @Override
    public void eliminar() {
        
        String nombre = JOptionPane.showInputDialog("ingrese el nombre del servicio medico a eliminar");
        boolean existe = false;
        int posicion;
        for(var servicio : serviciosMedicos){
            if(servicio.equals(nombre)){
                existe = true;
                posicion = serviciosMedicos.indexOf(servicio);
                serviciosMedicos.remove(posicion);
                JOptionPane.showMessageDialog(null, "servicio eliminado de la lista con exito");
            }
        }
        if(existe == false){
            JOptionPane.showMessageDialog(null, "El servicio no se encuentra registrado en la lista");
        }
        
    }
    
    /**
     * Retorna un String con los nombres de cada servicio en la lista 
     * serviciosMedicos.
     * @return los valores de los consultorios en el atributo consultorios.
     */
    @Override
    public String listar() {
        
        String cadena = "";
        for(var servicio : serviciosMedicos){
            cadena += servicio + "\n";
        }
        return cadena;
    }
    
    /**
     * Retorna el servicio medico almacenado en la lista serviciosMedicos, en la
     * posicion seleccion.
     * @return el String correspondiente al servicio medico en serviciosMedicos.get(intSeleccion);
     */
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
        
        String archivoCsv = "";
        for (var servicio : serviciosMedicos) {
            archivoCsv += servicio + ";";
        }
        try {
            /**
             * Metodo para la persistencia de datos en forma de archivo binario:
             */
            FileOutputStream os = new FileOutputStream(new File("src/persistencia/servicios_csv.txt"));
            System.out.println("Comenzando a copiar...");
            int aux;
            os.write(archivoCsv.getBytes());
            System.out.println("Copiado con exito!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
