package actores;

import java.util.Calendar;

/**
 * Clase que se crea con los datos necesarios para una cita medica
 * @author Jhonnier Hernandez 
 */
public class CitaMedica {
    private Afiliado afiliado;
    private String servicioMedico;
    private Medico medico;
    private Consultorio consultorio;
    private Calendar fechaYHora;
    
    /**
     * Crea la cita asignandole los valores a cada atributo.
     * @param afiliado es el afiliado que pide la cita
     * @param servicioMedico es el servicio que el afiliado requiere
     * @param medico es el medico asignado a la cita
     * @param consultorio es el lugar en el cual se dara la atencion
     * @param fechaYHora es la fecha de la cita
     */
    public CitaMedica(Afiliado afiliado, String servicioMedico, Medico medico, Consultorio consultorio, Calendar fechaYHora) {
        this.afiliado = afiliado;
        this.servicioMedico = servicioMedico;
        this.medico = medico;
        this.consultorio = consultorio;
        this.fechaYHora = fechaYHora;
    }
    
    /**
     * Retorna el afiliado de esta cita
     * @return el valor de afiliado
     */
    public Afiliado getAfiliado() {
        return afiliado;
    }
    
    /**
     * Retorna el servicio medico de esta cita
     * @return el valor de servicioMedico
     */
    public String getServicioMedico() {
        return servicioMedico;
    }
    
    /**
     * Retorna el medico asignado a esta cita
     * @return el valor de medico
     */
    public Medico getMedico() {
        return medico;
    }
    
    /**
     * Retorna el consultorio asignado a esta cita
     * @return el valor de consultorio
     */
    public Consultorio getConsultorio() {
        return consultorio;
    }
    
    /**
     * Retorna la fecha y hora de la cita.
     * @return el valor de fechaYHora
     */
    public Calendar getFechaYHora() {
        return fechaYHora;
    }

    @Override
    public String toString() {
        return "CitaMedica\n" + afiliado + "\nservicio = " + servicioMedico + "\n" + medico + "\n" + consultorio + "\nfechaYHora = " + fechaYHora.getTime();
    }
    
    /**
     * modifica la fecha de la cita.
     * @param fechaYHora es el nuevo valor que debe tener el atributo fechaYHora
     */
    public void setFechaYHora(Calendar fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
    
}
