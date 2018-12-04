/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Scanner;

/**
 *
 * @author 52999
 */
public class InversaGaussJordan {

    /**
     * @param args the command line arguments
     */
    public static double[][] invertirGaussJordan(double matrizEntrada[][]) {
        double[][] matrizInvertida = matrizEntrada;
        int tamanioMatriz = matrizInvertida.length;
        double matrizResultado[][] = new double[tamanioMatriz][tamanioMatriz];
        double matrizAuxiliar[][] = new double[tamanioMatriz][tamanioMatriz];

        for (int contadorCreacion = 0; contadorCreacion < tamanioMatriz; ++contadorCreacion) { //INICIALIZAR LAS VARIABLES ANTES DE LOS LOOPS
            matrizAuxiliar[contadorCreacion][contadorCreacion] = 1;                       //LOOP CON UNA SOLA FUNCION
        }

        int indice[] = new int[tamanioMatriz];
        int tamanioIndice = indice.length;
        double vectorFactores[] = new double[tamanioIndice];

        for (int i = 0; i < tamanioIndice; ++i) {
            indice[i] = i;
        }

        for (int fila = 0; fila < tamanioIndice; ++fila) {
            double factorTemporal1 = 0;
            for (int columna = 0; columna < tamanioIndice; ++columna) {
                double factorTemporal2 = Math.abs(matrizInvertida[fila][columna]);
                if (factorTemporal2 > factorTemporal1) {
                    factorTemporal1 = factorTemporal2;
                }
            }
            vectorFactores[fila] = factorTemporal1;
        }

        int contadorPivote = 0;
        for (int filaPivote = 0; filaPivote < tamanioIndice - 1; ++filaPivote) {
            double primerPivote = 0;
            for (int columnaPivote = filaPivote; columnaPivote < tamanioIndice; ++columnaPivote) {

                double pivoteCero = Math.abs(matrizInvertida[indice[columnaPivote]][filaPivote]);
                pivoteCero /= vectorFactores[indice[columnaPivote]];
                if (pivoteCero > primerPivote) {     //COLOCAR SENTENCIA SIGNIFICATIVA DENTRO DE LA CLAUSULA IF
                    primerPivote = pivoteCero;
                    contadorPivote = columnaPivote;
                }
            }

            int indiceTemporal = indice[filaPivote];
            indice[filaPivote] = indice[contadorPivote];
            indice[contadorPivote] = indiceTemporal;
            for (int filaMatriz = filaPivote + 1; filaMatriz < tamanioIndice; ++filaMatriz) {
                double elementoMatriz = matrizInvertida[indice[filaMatriz]][filaPivote] / matrizInvertida[indice[filaPivote]][filaPivote];
                matrizInvertida[indice[filaMatriz]][filaPivote] = elementoMatriz;
                for (int columnaMatriz = filaPivote + 1; columnaMatriz < tamanioIndice; ++columnaMatriz) {
                    matrizInvertida[indice[filaMatriz]][columnaMatriz] -= elementoMatriz * matrizInvertida[indice[filaPivote]][columnaMatriz];
                }
            }
        }

        for (int contadorEscalona = 0; contadorEscalona < tamanioMatriz - 1; ++contadorEscalona) { //USAR NOMBRE SIGNIFICATIVO DE VARIABLES PARA HACER LOS LOOPS MAS FACIL DE LEER - EVITAR LOS CROSSTALK
            for (int contadorFilas = contadorEscalona + 1; contadorFilas < tamanioMatriz; ++contadorFilas) { //LIMITAR EL ALCANCE DE LOS INDICES DEL LOOP PARA SI MISMOS
                for (int contadorColumnas = 0; contadorColumnas < tamanioMatriz; ++contadorColumnas) { //DECLARAR VARIABLES INDICES DENTRO DE CADA LOOP 
                    matrizAuxiliar[indice[contadorFilas]][contadorColumnas]
                            -= matrizInvertida[indice[contadorFilas]][contadorEscalona] * matrizAuxiliar[indice[contadorEscalona]][contadorColumnas];
                }
            }
        }

        //LIMITAR LOS LOOPS ANIDADOS A MAXIMO 3 NIVELES
        for (int contadorIdentidad = 0; contadorIdentidad < tamanioMatriz; ++contadorIdentidad) {
            matrizResultado[tamanioMatriz - 1][contadorIdentidad] = matrizAuxiliar[indice[tamanioMatriz - 1]][contadorIdentidad] / matrizInvertida[indice[tamanioMatriz - 1]][tamanioMatriz - 1];
            for (int filaMatriz = tamanioMatriz - 2; filaMatriz >= 0; --filaMatriz) {
                matrizResultado[filaMatriz][contadorIdentidad] = matrizAuxiliar[indice[filaMatriz]][contadorIdentidad];
                for (int columnaMatriz = filaMatriz + 1; columnaMatriz < tamanioMatriz; ++columnaMatriz) {
                    matrizResultado[filaMatriz][contadorIdentidad] -= matrizInvertida[indice[filaMatriz]][columnaMatriz] * matrizResultado[columnaMatriz][contadorIdentidad];
                }

                matrizResultado[filaMatriz][contadorIdentidad] /= matrizInvertida[indice[filaMatriz]][filaMatriz];
            }
        }

        return matrizResultado;
    }
}
