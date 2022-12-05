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
    
    @Override
    public void agregar() {
        
    }

    @Override
    public void actualizar() {
    }

    @Override
    public void eliminar() {
    }

    @Override
    public void listar() {
        for(var servicio : serviciosMedicos){
            System.out.println(servicio);
        }
    }

    @Override
    public void generarCSV() {
    }
    
}
