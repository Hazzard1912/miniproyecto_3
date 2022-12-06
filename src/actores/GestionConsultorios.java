package actores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Almacena en un arreglo los consultorios que hay y permite su modificacion
 * @author Jhonnier Hernandez
 */
public class GestionConsultorios implements IGestionDatos{
    private List<Consultorio> consultorios = new ArrayList<>();

    public GestionConsultorios() {
    }

    @Override
    /**
     * Crea la ventana donde captura los datos para agregar un consultorio al
     * atributo consultorios
     */
    public void agregar() {
    }
    
    /**
     * Crea la ventana donde captura la posicion del consultorio al cual le
     * quiere actualizar el nombre
     */
    @Override
    public void actualizar() {
    }

    @Override
    public void eliminar() {
    }

    @Override
    public String listar() {
        String cadena = "";
        for(var consultorio : consultorios){
            cadena += consultorio + "\n";
        }
        return cadena;
    }

    @Override
    public void generarCSV() {
    }
    
}
