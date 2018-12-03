/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author sulak
 */
public class Basicas {
    final int PRIMERINDICE = 0;
    final int SEGUNDOINDICE = 1;
    final int DIVISOR_MODULO_PAR = 2;
        
    //5. D STRUCTURED MEASURE d, D1+MIN(D2), 1+1=2
    public double[][] transponerMatrices(double[][] matriz)
    {
        int numColumnasMatriz = matriz.length;
        double[][] matrizTranspuesta = new double[matriz[PRIMERINDICE].length][numColumnasMatriz];   //put initialization code directly before the loop
        for (int columna = 0; columna < numColumnasMatriz; columna++) {      //Un loop con una sola funcion (Este loop solo recorre la matriz)
            int numFilasMatriz = matriz[columna].length;                        //Usar nombres significativos de variables para hacer loops más fáciles de leer
            for (int fila = 0; fila <numFilasMatriz; fila++) {
                matrizTranspuesta[fila][columna] = matriz[columna][fila];
            }
        }                                                                  
                                                                    
        
        return matrizTranspuesta;
    }
     
    //2. NUMBER OF EDGES MEASURE , 5-1=4
     public double[][] sumarMatrices(double[][] primeraMatriz, double[][] segundaMatriz){
        int numFilasPrimeraMatriz = primeraMatriz.length;
        int numColumPrimeraMatriz = primeraMatriz[PRIMERINDICE].length;
        double[][] matrizResultante = new double [numFilasPrimeraMatriz][numColumPrimeraMatriz];
        for (int fila = 0; fila < numFilasPrimeraMatriz; fila++) {                //Limitar el alcance de los indices de loop para si mismos
            for (int columna = 0; columna < numColumPrimeraMatriz; columna++) {      //Declarar variables indices dentro de cada loop
                matrizResultante [fila][columna] = primeraMatriz [fila][columna] + segundaMatriz [fila][columna];
            }
        }
        return matrizResultante;
    }
    
    //3. THE LARGEST PRIME MEASURE k, V(f)=1+(MAX(D2+MAX(D3))), 1+1+1=3
     public double[][] multiplicarMatrices(double[][] primeraMatriz, double[][] segundaMatriz){
        double[][] matrizResultante = new double [primeraMatriz.length][segundaMatriz[PRIMERINDICE].length];
        int numFilasPrimeraMatriz = primeraMatriz.length;                                                        //Colocar la declaración de variables inmediatamente afuera de los loop
        for (int filaPrimeraMatriz = 0; filaPrimeraMatriz < numFilasPrimeraMatriz; filaPrimeraMatriz++) {           //Limitar el numero de niveles de loop a 3
            int numColumPrimeraMatriz = primeraMatriz[PRIMERINDICE].length;
            for (int columnaPrimeraMatriz = 0; columnaPrimeraMatriz < numColumPrimeraMatriz; columnaPrimeraMatriz++) {
                int numColumSegundaMatriz = segundaMatriz[PRIMERINDICE].length;
                for (int columnaSegundaMatriz = 0; columnaSegundaMatriz < numColumSegundaMatriz; columnaSegundaMatriz++) {
                    matrizResultante[filaPrimeraMatriz][columnaSegundaMatriz] += primeraMatriz[filaPrimeraMatriz][columnaPrimeraMatriz] * segundaMatriz[columnaPrimeraMatriz][columnaSegundaMatriz];
                }
            }
        }
        return matrizResultante;
    }
}
