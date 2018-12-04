package Modelo;

/**
 * Esta clase contiene la funcionalidad para realizarle Gauss Jordan a una
 * matriz.
 *
 * @author Moisés Barbachano, José Cetina, Juan Moguel, Gerardo Hau
 */
public class GaussJordan {

    /**
     * Método para resolver el Gauss Jordan de una matriz.
     *
     * @param matriz Matriz a querer resolver Gauss Jordan.
     * @return Matriz resuelta con Gauss Jordan.
     */
    public static double[][] resolverGaussJordan(double[][] matriz) {
        double[][] matrizGaussJordan = matriz;
        int pivote = 0;
        double auxiliarDivision = 0;
        int longitud = matrizGaussJordan.length;
        final int ajusteLongitud = longitud + 1;
        // Lineamientos general: No hay ningun loop vacio || cada loop solo tiene una funcion || Cada loop termina || Se usan variables con nombres claros
        for (int contador = 0; contador < longitud; contador++) { // Se usa for ya que se requiere que se ejecute un numero especifico de veces || Los contadores son  enteros 
                auxiliarDivision = matrizGaussJordan[pivote][pivote];
            for (int contadorOperacion = 0; contadorOperacion < ajusteLongitud; contadorOperacion++) { // hacer los loops cortos || Limitar los Loops anidados a maximo 3 niveles
                matrizGaussJordan[pivote][contadorOperacion] = (matrizGaussJordan[pivote][contadorOperacion]) / (auxiliarDivision);
            }

            for (int contadorNoPivote = 0; contadorNoPivote < longitud; contadorNoPivote++) { // entra en un loop de una manera || incializar  variables en el loop || Los lopps evitan crosstalk
                if (contadorNoPivote != pivote) { // Escribir primero los casos normales 
                    double valorTemporal = matrizGaussJordan[contadorNoPivote][pivote];
                    for (int contadorAjuste = 0; contadorAjuste < ajusteLongitud; contadorAjuste++) {
                        matrizGaussJordan[contadorNoPivote][contadorAjuste] = (matrizGaussJordan[pivote][contadorAjuste]) * (valorTemporal * -1) + matrizGaussJordan[contadorNoPivote][contadorAjuste];
                    }
                }
            }

            pivote++; // Cuidar los loop-housekeeping
        }

        int numFilasMatrizGauss = matrizGaussJordan.length;
        int numColumnasMatrizGauss = matrizGaussJordan[0].length;
        for (int fila = 0; fila < numFilasMatrizGauss; fila++) {
            for (int columna = 0; columna < numColumnasMatrizGauss; columna++) {
                if (matrizGaussJordan[fila][columna] == -0.0) {
                    matrizGaussJordan[fila][columna] = 0.0;
                }
            }
        }

        return matrizGaussJordan;
    }
}
