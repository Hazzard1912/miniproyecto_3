package testPrograma;

/**
 *
 * @author Jhonnier Hernandez
 */

import actores.*;

public class testeoPrograma {

    public static void main(String args[]) {
        Afiliado afiliado1 = new Afiliado("Jhonnier", 1143996353);
        Afiliado afiliado2 = new Afiliado("Juan", 34584);
        Afiliado afiliado3 = new Afiliado("Marco", 6876846);
        Afiliado afiliado4 = new Afiliado("Aurelio", 6876);
        Afiliado afiliado5 = new Afiliado("Messi", 21354);
        Afiliado afiliado6 = new Afiliado("Alegre", 546876);
        GestionAfiliados listaAfiliados = new GestionAfiliados();
        
//        Medico medico1 = new Medico("Jhonnier", 1143996353);
//        GestionMedicos listaMedicos = new GestionMedicos();
//        
//        Especialista ortopediatra = new Especialista("Jhonnier", 123321, "pediatria");
//        listaMedicos.agregar(medico1);
//        listaMedicos.agregar(ortopediatra);
//        listaMedicos.listar();
//        listaMedicos.eliminar(medico1);
//        listaMedicos.listar();
    }
}
