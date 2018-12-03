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
public class Determinante {
final int PRIMERINDICE = 0;
    final int SEGUNDOINDICE = 1;
    final int DIVISOR_MODULO_PAR = 2;
    
    public double obtenerDeterminante(double[][] matriz)
    {
        double determinante;
        int numColumnasMatriz = matriz[PRIMERINDICE].length;
        int numFilasMatriz = matriz.length;
        int numColumnasMatrizBasica = 2;
        if(numColumnasMatriz==numColumnasMatrizBasica)
        {
            determinante=(matriz[PRIMERINDICE][PRIMERINDICE]*matriz[SEGUNDOINDICE][SEGUNDOINDICE])-(matriz[SEGUNDOINDICE][PRIMERINDICE]*matriz[PRIMERINDICE][SEGUNDOINDICE]);
            return determinante;
        }
        double sumatoriaDeterminante=0;
        for(int columna=0; columna<numColumnasMatriz; columna++)                         //Mantener como máximo 3 niveles de LOOPS
        {                                                                                 //Hacer loops largos especialmente claros
            int ultimoIndice = numColumnasMatriz - 1;
            double[][] matrizReordenada = new double[ultimoIndice][ultimoIndice];
            for(int fila=0; fila<numFilasMatriz; fila++)                            //Hacer los loops tan cortos como se pueda ver dentro de tu pantalla
            {
                if(fila!=columna)              //Poner los casos más comunes primeros
                {
                    for(int ColumMatrizReOrdenada=1; ColumMatrizReOrdenada<numColumnasMatriz; ColumMatrizReOrdenada++){                 
                        int indiceMatrizReordenada = 0;
                        if(fila <= (columna-1))              //Sigue la clausula if con una sentencia significativa(no colocar null en la sentencia if, y hacerlo dentro del else)
                        {
                            indiceMatrizReordenada=fila;
                        }else if((fila-1) >= columna)
                        {
                            indiceMatrizReordenada=fila-1;
                        }
                        matrizReordenada[indiceMatrizReordenada][ColumMatrizReOrdenada-1] = matriz[fila][ColumMatrizReOrdenada];
                    }
                }
            }                                                                                   
            if(columna%DIVISOR_MODULO_PAR==0)
            sumatoriaDeterminante+=matriz[columna][PRIMERINDICE] * obtenerDeterminante(matrizReordenada);
            else                                                                                                            //Considera la clausula else
            sumatoriaDeterminante-=matriz[columna][PRIMERINDICE] * obtenerDeterminante(matrizReordenada);
        }                                                                                                                   //Se evita usar código que dependa de los valores de los indices finales de los loop
        return sumatoriaDeterminante;
    } 
    
    
}
