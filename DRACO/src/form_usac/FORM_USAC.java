package form_usac;
 
import GUI.Principal; 
/**
 *
 * @author joseph
 */
public class FORM_USAC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        iniciarInterfaz(args); 
         
    }
    
    /**
     * Main que inicializa la interfaz
     * @param args 
     */
    public static void iniciarInterfaz(String[] args) {
        System.out.println("Inicializando...");
        Principal pri = new Principal();

        pri.correr(args);
    }
}
