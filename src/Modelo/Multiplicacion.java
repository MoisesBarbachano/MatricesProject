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
public class Multiplicacion {

    //3. THE LARGEST PRIME MEASURE k, V(f)=1+(MAX(D2+MAX(D3))), 1+1+1=3
    public static double[][] multiplicarMatrices(double[][] primeraMatriz, double[][] segundaMatriz) {
        final int PRIMERINDICE = 0;
        final int SEGUNDOINDICE = 1;
        final int DIVISOR_MODULO_PAR = 2;
        double[][] matrizResultante = new double[primeraMatriz.length][segundaMatriz[PRIMERINDICE].length];
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
