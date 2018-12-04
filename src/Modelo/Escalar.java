package Modelo;

/**
 * Esta clase contiene la funcionalidad para multiplicar una matriz por un escalar.
 * @author Moisés Barbachano, José Cetina, Juan Moguel, Gerardo Hau
 */
public class Escalar {
    /**
     * Método para multiplicar una matriz por un escalar.
     * @param matriz Matriz con la que se multiplicará el escalar.
     * @param escalar Número a multiplicar con una matriz.
     * @return Matriz resultante la multiplicación de una matriz con el escalar.
     */
    //1. NUMBER OF NODES MEASURE n, 4-2=2
    public static double[][] multiplicarEscalar(double[][] matriz, double escalar) {
        final int PRIMERINDICE = 0;
        final int SEGUNDOINDICE = 1;
        final int DIVISOR_MODULO_PAR = 2;
        double[][] matrizDuplicada = matriz;
        int numFilasMatriz = matrizDuplicada.length;
        for (int fila = 0; fila < numFilasMatriz; fila++) {    //Limitar el numero de niveles de loop a 3
            int numColumMatriz = matrizDuplicada[PRIMERINDICE].length;
            for (int columna = 0; columna < numColumMatriz; columna++) {
                matrizDuplicada[fila][columna] = escalar * (matrizDuplicada[fila][columna]);
            }
        }
        return matrizDuplicada;
    }
}
