/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author 52999
 */
public class Escalar {

    //1. NUMBER OF NODES MEASURE n, 4-2=2
    public static double[][] multiplicarPorEscalar(double[][] matriz, double escalar) {
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
