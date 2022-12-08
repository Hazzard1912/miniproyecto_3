package actores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que modela los servicios medicos que prestara la entidad
 * @author Jhonnier Hernandez
 */
public class GestionServiciosMedicos implements IGestionDatos{
    private List<String> serviciosMedicos;
    
    /**
     * Construye el objeto e inicializa el atributo serviciosMedicos como un ArrayList
     */
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
        
        String cadena = "---------- Servicios ----------\n";
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
            archivoCsv += servicio + ";" + "\n";
        }
        try {
            /**
             * Metodo para la persistencia de datos en forma de archivo binario:
             */
            FileOutputStream os = new FileOutputStream(new File("src/persistencia/servicios_csv.txt"));
            System.out.println("Comenzando a copiar...");
            os.write(archivoCsv.getBytes());
            System.out.println("Copiado con exito!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Crea y carga los datos contenidos en servicios_csv.txt a el atributo 
     * servicios medicos, de modo que restaura la informacion guardada anteriormente
     */
    @Override
    public void restaurarDatos(){
        
        File archivo = new File("src/persistencia/servicios_csv.txt");
        StringTokenizer st;
        String cadenaDatos = "";
        try {
            FileReader fr = new FileReader(archivo);
            try (BufferedReader br = new BufferedReader(fr)) {
                
                String cadena;
                while((cadena = br.readLine())!=null){
                    
                    cadenaDatos += cadena;
                    st = new StringTokenizer(cadena,";");
                    if (st.countTokens() % 1 == 0 && st.countTokens() != 0) {
                        
                        String nombre = st.nextToken();
                        System.out.println("Creando y cargando servicio medico...");
                        serviciosMedicos.add(nombre);
                        System.out.println("servicio medico cargado con exito!");
                    } 
                }
                System.out.println("Se han cargado todos los datos exitosamente");
            }
        }
         catch (FileNotFoundException ex) {
            Logger.getLogger(GestionAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("Los datos contenidos en servicios_csv son: \n" + cadenaDatos);
            System.out.println("la lista de servicios medicos resultante es: " + serviciosMedicos);
        }
    }
    
    /**
     * Retorna el servicio almacenado en la posicion del parametro en serviciosMedicos
     * @param posicion es la posicion de la cual se va a obtener el servicio en 
     * serviciosMedicos
     * @return el valor almacenado en serviciosMedicos.get(posicion)
     */
    public String getServicio(int posicion){
        return serviciosMedicos.get(posicion);
    }
}
