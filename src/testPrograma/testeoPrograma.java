package testPrograma;

/**
 *
 * @author Jhonnier Hernandez
 */

import actores.*;
import java.util.Calendar;
import java.util.Date;
import vista.VentanaInicial;

public class testeoPrograma {

    public static void main(String args[]) {
        Afiliado afiliado = new Afiliado("Alex", 1235453);
        Medico medico = new Medico("Juan", 13543135);
        GestionServiciosMedicos serviciosMedicos = new GestionServiciosMedicos();
        serviciosMedicos.agregar();
        Consultorio consultorio = new Consultorio("Laboratorio 1", true);
        Calendar cal = Calendar.getInstance();
        cal.set(2022, 11, 6, 11, 30);
        CitaMedica cita = new CitaMedica(afiliado,serviciosMedicos.seleccionarServicio(),medico,consultorio,cal);
        System.out.println("cita = " + cita);
    }
}
