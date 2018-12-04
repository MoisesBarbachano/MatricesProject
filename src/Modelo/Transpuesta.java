package Modelo;

/**
 * Esta clase contiene la funcionalidad de transponer una matriz.
 * @author Moisés Barbachano, José Cetina, Juan Moguel, Gerardo Hau
 */
public class Transpuesta {

    /**
     * Método para transponer una matriz introducida.
     * @param matriz Matriz a querer transponer.
     * @return Matriz transpuesta obtenida.
     */
    //5. D STRUCTURED MEASURE d, D1+MIN(D2), 1+1=2
    public static double[][] transponerMatrices(double[][] matriz) {
        final int PRIMERINDICE = 0;
        final int SEGUNDOINDICE = 1;
        final int DIVISOR_MODULO_PAR = 2;
        int numColumnasMatriz = matriz.length;
        double[][] matrizTranspuesta = new double[matriz[PRIMERINDICE].length][numColumnasMatriz];   //put initialization code directly before the loop
        for (int columna = 0; columna < numColumnasMatriz; columna++) {      //Un loop con una sola funcion (Este loop solo recorre la matriz)
            int numFilasMatriz = matriz[columna].length;                        //Usar nombres significativos de variables para hacer loops más fáciles de leer
            for (int fila = 0; fila < numFilasMatriz; fila++) {
                matrizTranspuesta[fila][columna] = matriz[columna][fila];
            }
        }

        return matrizTranspuesta;
    }
}
