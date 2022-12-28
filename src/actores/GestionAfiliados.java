package actores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * GestionAfiliados contiene solo un atributo de tipo Map, en el cual se van a almacenar
 y a manejar los objetos de tipo Afiliado.
 * @author Jhonnier Hernandez
 */

public class GestionAfiliados implements IGestionDatos{
    
    private Map <Integer, Afiliado> listaAfiliados;
    
    /**
     * Se inicializa el atributo listaAfiliados como un HashMap.
     */
    public GestionAfiliados(){
        
        listaAfiliados = new HashMap<>();
    }
    
    
    /**
     * Crea la ventana donde se obtienen los datos para crear un Afiliado y lo 
     * agrega a listaAfiliados.
     */
    @Override
    public void agregar(){
        
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario a afiliar");
        String dni = JOptionPane.showInputDialog("ingrese el dni del usuario a afiliar");
        int intDni = Integer.parseInt(dni);
        Afiliado afiliado = new Afiliado(nombre, intDni);
        listaAfiliados.put(afiliado.getIdAfiliado(), afiliado);
    }
    
    /**
     * Actualiza los valores para nombreAfiliado del afiliado con el id que se
     * haya suministrado.
     */
    @Override
    public void actualizar(){
        
        String id = JOptionPane.showInputDialog("ingrese el id del afiliado a actualizar");
        int intId = Integer.parseInt(id);
        if(listaAfiliados.containsKey(intId)){
            String nombre = JOptionPane.showInputDialog("ingrese el nuevo nombre del afiliado");
            (listaAfiliados.get(intId)).setNombre(nombre);
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado en la lista de afiliados");
        }
    }
    
    /**
     * Retorna un String con todos los afiliados contenidos en listAfiliados
     * @return los datos de cada afiliado en el atributo listaAfiliados
     */
    @Override
    public String listar(){
        String cadena = "---------- Afiliados ----------\n";
        for(int clave : listaAfiliados.keySet()){
            Afiliado afiliado = listaAfiliados.get(clave);
            cadena += afiliado + "\n";
        }
        return cadena;
    }
    
    /**
     * Cambia el estado del atributo estado del afiliado a false, y lo elimina 
     * de listaAfiliados, con lo cual se entiende que el afiliado esta inactivo.
     */
    @Override
    public void eliminar(){
        
        String id = JOptionPane.showInputDialog("ingrese el id del afiliado a eliminar");
        int intId = Integer.parseInt(id);
        
        if(listaAfiliados.containsKey(intId)){
            (listaAfiliados.get(intId)).setEstado(false);
            listaAfiliados.remove(intId);
            JOptionPane.showMessageDialog(null, "afiliado eliminado con exito del registro de afiliados");
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado en la lista de afiliados o el id ingresado es incorrecto");
        }
    }
    
    /**
     * Genera el archivo csv con los datos basicos de los afiliados, separados
     * por punto y coma (;) para la persistencia de los datos. el formato del
     * archivo es: nombre - dni - id - estado
     */
    @Override
    public void  generarCSV(){
        
        Afiliado afiliado;
        String archivoCsv = "";
        for (int clave:listaAfiliados.keySet()) {
            afiliado = listaAfiliados.get(clave);
            archivoCsv += afiliado.getNombre() + ";" + afiliado.getDni() + ";" + afiliado.getIdAfiliado() + ";" + afiliado.isEstado() + ";" + "\n";
        }
        try {
            /**
             * Metodo para la persistencia de datos en forma de archivo binario:
             */
            FileOutputStream os = new FileOutputStream(new File("src/persistencia/afiliados_csv.txt"));
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
     * El metodo tiene como funcion restaurar los datos llenando el atributo
     * listaAfiliados con los datos almacenados en afiliados_csv.txt
     */
    @Override
    public void restaurarDatos(){
        
        File archivo = new File("src/persistencia/afiliados_csv.txt");
        StringTokenizer st;
        String cadenaDatos = "";
        try {
            FileReader fr = new FileReader(archivo);
            try (BufferedReader br = new BufferedReader(fr)) {
                
                String cadena;
                while ((cadena = br.readLine()) != null){
                    
                    cadenaDatos += cadena;
                    st = new StringTokenizer(cadena,";");
                    if (st.countTokens() % 4 == 0 && st.countTokens() != 0) {
                        String nombre = st.nextToken();
                        int dni = Integer.parseInt(st.nextToken());
                        int id = Integer.parseInt(st.nextToken());
                        boolean estado;
                        String token =st.nextToken();
                        estado = Boolean.parseBoolean(token);
                        System.out.println("Creando y cargando afiliado...");
                        Afiliado afiliado = new Afiliado(nombre, dni);
                        afiliado.setIdAfiliado(id);
                        afiliado.setEstado(estado);
                        listaAfiliados.put(afiliado.getIdAfiliado(), afiliado);
                        System.out.println("afiliado cargado con exito!");
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
            System.out.println("Los datos contenidos en afiliados_csv son: \n" + cadenaDatos);
            System.out.println("la lista de afiliados resultante es: " + listaAfiliados);
        }
    }
    
    /**
     * Retorna el afiliado contenido en listaAfiliados, en la llave idAfiliado.
     * @param idAfiliado es la llave en la cual esta almacenado el afiliado que se 
     * desea acceder.
     * @return el afiliaod contenido en listaAfiliados.get(idAfiliado)
     */
    public Afiliado getAfiliado(int idAfiliado){
        return listaAfiliados.get(idAfiliado);
    }
}
