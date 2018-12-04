package Modelo;

/**
 * Esta clase contiene la funcionalidad para multiplicar matrices.
 *
 * @author Moisés Barbachano, José Cetina, Juan Moguel, Gerardo Hau
 */
public class Multiplicacion {

    /**
     * Método para multiplicar dos matrices.
     *
     * @param primeraMatriz Matriz a multiplicar.
     * @param segundaMatriz Matriz a multiplicar.
     * @return Matriz resultante de la multiplicación.
     */
    //3. THE LARGEST PRIME MEASURE k, V(f)=1+(MAX(D2+MAX(D3))), 1+1+1=3
    public static double[][] multiplicarMatrices(double[][] primeraMatriz, double[][] segundaMatriz) {
        final int PRIMERINDICE = 0;
        final int SEGUNDOINDICE = 1;
        final int DIVISOR_MODULO_PAR = 2;
        double[][] matrizResultante = new double[primeraMatriz.length][segundaMatriz[PRIMERINDICE].length];
        int numFilasPrimeraMatriz = primeraMatriz.length;                                                        //Colocar la declaración de variables inmediatamente afuera de los loop
        int numColumPrimeraMatriz = primeraMatriz[PRIMERINDICE].length;
        for (int filaPrimeraMatriz = 0; filaPrimeraMatriz < numFilasPrimeraMatriz; filaPrimeraMatriz++) {           //Limitar el numero de niveles de loop a 3
            for (int columnaPrimeraMatriz = 0; columnaPrimeraMatriz < numColumPrimeraMatriz; columnaPrimeraMatriz++) {
                int numColumSegundaMatriz = segundaMatriz[PRIMERINDICE].length;
                for (int columnaSegundaMatriz = 0; columnaSegundaMatriz < numColumSegundaMatriz; columnaSegundaMatriz++) {
                    matrizResultante[filaPrimeraMatriz][columnaSegundaMatriz] += primeraMatriz[filaPrimeraMatriz][columnaPrimeraMatriz] * segundaMatriz[columnaPrimeraMatriz][columnaSegundaMatriz];
                }
            }
        }
        
        int numFilasMatrizResultante = matrizResultante.length;
        int numColumnasMatrizResultante = matrizResultante[0].length;
        for (int numFilas = 0; numFilas < numFilasMatrizResultante; numFilas++) {
            for (int numColumnas = 0; numColumnas < numColumnasMatrizResultante; numColumnas++) {
                if(matrizResultante[numFilas][numColumnas] == -0.0){
                    matrizResultante[numFilas][numColumnas] = 0.0;
                }
            }
        }
        return matrizResultante;
    }
}
