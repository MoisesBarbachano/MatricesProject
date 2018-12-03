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
public class GaussJordan {
    public double[][] resolverGaussJordan(double[][] matriz){
          int pivote = 0;
          double auxiliarDivision = 0;
          int longitud = matriz.length;
          final int ajusteLongitud=longitud+1;
           // Lineamientos general: No hay ningun loop vacio || cada loop solo tiene una funcion || Cada loop termina || Se usan variables con nombres claros
           for (int contador = 0; contador < longitud; contador++) { // Se usa for ya que se requiere que se ejecute un numero especifico de veces || Los contadores son  enteros 
             auxiliarDivision = matriz[pivote][pivote]; 
            
                for (int contadorOperacion = 0; contadorOperacion < ajusteLongitud; contadorOperacion++) { // hacer los loops cortos || Limitar los Loops anidados a maximo 3 niveles
                    matriz[pivote][contadorOperacion] =( matriz[pivote][contadorOperacion] )/ (auxiliarDivision); 
                 }
           
          
           for (int contadorNoPivote = 0; contadorNoPivote < longitud; contadorNoPivote++) { // entra en un loop de una manera || incializar  variables en el loop || Los lopps evitan crosstalk
            if (contadorNoPivote != pivote) { // Escribir primero los casos normales 
                double valorTemporal = matriz[contadorNoPivote][pivote];
                for (int contadorAjuste = 0; contadorAjuste < ajusteLongitud; contadorAjuste++) {
                    matriz[contadorNoPivote][contadorAjuste] = ( matriz[pivote][contadorAjuste])*(valorTemporal * -1) + matriz[contadorNoPivote][contadorAjuste];
                }
            }
        }

          
            pivote++; // Cuidar los loop-housekeeping
        }
           
        return matriz;
    }
}
