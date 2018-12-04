/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author pepe_
 */
public class Sumatoria {

    //2. NUMBER OF EDGES MEASURE , 5-1=4
    public static double[][] sumarMatrices(double[][] primeraMatriz, double[][] segundaMatriz) {
        final int PRIMERINDICE = 0;
        int numFilasPrimeraMatriz = primeraMatriz.length;
        int numColumPrimeraMatriz = primeraMatriz[PRIMERINDICE].length;
        double[][] matrizResultante = new double[numFilasPrimeraMatriz][numColumPrimeraMatriz];
        for (int fila = 0; fila < numFilasPrimeraMatriz; fila++) {                //Limitar el alcance de los indices de loop para si mismos
            for (int columna = 0; columna < numColumPrimeraMatriz; columna++) {      //Declarar variables indices dentro de cada loop
                matrizResultante[fila][columna] = primeraMatriz[fila][columna] + segundaMatriz[fila][columna];
            }
        }
        return matrizResultante;
    }
}
