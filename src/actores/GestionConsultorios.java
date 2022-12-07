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
 * Almacena en un arreglo los consultorios que hay y permite su modificacion
 * @author Jhonnier Hernandez
 */
public class GestionConsultorios implements IGestionDatos{
    
    private List<Consultorio> consultorios = new ArrayList<>();

    public GestionConsultorios() {
    }
    
    /**
     * Crea la ventana donde captura los datos para agregar un consultorio al
     * atributo consultorios
     */
    @Override
    public void agregar() {
        
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del consultorio a agregar");
        boolean estado = true;
        Consultorio consultorio = new Consultorio(nombre, estado);
        consultorios.add(consultorio);
    }
    
    /**
     * Crea la ventana donde captura el nombre del consultorio al cual se le
     * va a actualizar el nombre.
     */
    @Override
    public void actualizar() {
        
        String nombre = JOptionPane.showInputDialog("ingrese el nombre del consultorio a actualizar");
        boolean existe = false;
        int posicion = 0;
        for(var consultorio : consultorios){
            if((consultorio.getNombre()).equals(nombre)){
                existe = true;
                posicion = consultorios.indexOf(consultorio);
                String nuevoNombre = JOptionPane.showInputDialog("ingrese el nuevo nombre del consultorio");
                (consultorios.get(posicion)).setNombre(nuevoNombre);
            }
        }
        if(existe == false){
            JOptionPane.showMessageDialog(null, "El consultorio no se encuentra registrado en la lista");
        }
    }
    
    /**
     * Crea la ventana en la cual se captura el nombre del consultorio que va a
     * ser eliminado de la lista.
     */
    @Override
    public void eliminar() {
        
        String nombre = JOptionPane.showInputDialog("ingrese el nombre del consultorio a eliminar");
        boolean existe = false;
        int posicion;
        for(var consultorio : consultorios){
            if((consultorio.getNombre()).equals(nombre)){
                existe = true;
                posicion = consultorios.indexOf(consultorio);
                consultorios.remove(posicion);
                JOptionPane.showMessageDialog(null, "Consultorio eliminado satisfactoriamente");
                break;
            }
        }
        if(existe == false){
            JOptionPane.showMessageDialog(null, "El consultorio no se encuentra registrado en la lista");
        }
    }
    
    /**
     * Retorna un String con los datos de cada consultorio en la lista consultorios.
     * @return los valores de los consultorios en el atributo consultorios.
     */
    @Override
    public String listar() {
        
        String cadena = "";
        for(var consultorio : consultorios){
            cadena += consultorio + "\n";
        }
        return cadena;
    }
    
    /**
     * Genera el archivo csv con los datos de los consultorios, separados
     * por punto y coma (;) para la persistencia de los datos. el formato del
     * archivo es: nombre - estado
     */
    @Override
    public void generarCSV() {
        
        String archivoCsv = "";
        for (var consultorio : consultorios) {
            archivoCsv += consultorio.getNombre() + ";" + consultorio.isDisponibilidad()+ ";" + "\n";
        }
        try {
            /**
             * Metodo para la persistencia de datos en forma de archivo binario:
             */
            FileOutputStream os = new FileOutputStream(new File("src/persistencia/consultorios_csv.txt"));
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
    
    
    @Override
    public void restaurarDatos(){
        
    }
}
