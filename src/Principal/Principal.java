package Principal;

import Controlador.ControladorGrafica;
import Vista.GraficaMatriz;
import java.io.IOException;

/**
 * Clase inicial que ejecuta el controlador y por lo tanto la vista y así el programa.
 * @author Moisés Barbachano, José Cetina, Juan Moguel, Gerardo Hau
 */
public class Principal {
    public static void main(String[] args) throws IOException {
        ControladorGrafica ctrlGrafica = new ControladorGrafica();
        ctrlGrafica.iniciar();
        
    }
}
