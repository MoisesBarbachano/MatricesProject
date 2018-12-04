/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Multiplicacion;
import Modelo.Determinante;
import Modelo.Escalar;
import Modelo.GaussJordan;
import Modelo.InversaGaussJordan;
import Modelo.Sumatoria;
import Modelo.Transpuesta;
import Vista.GraficaMatriz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase permite controlar a la vista Grafica para que la vista no se
 * entere de los cambios hechos por el usuario, solo permita introducir y
 * mostrar datos sin realizar operaciones dentro de la misma.
 *
 * @author Moisés Barbachano, José Cetina, Juan Moguel, Gerardo Hau
 */
public final class ControladorGrafica implements ActionListener {

    //Campos de la clase
    final int PRIMERINDICE = 0;

    
//    Multiplicacion multiplicacion;
//    Sumatoria suma;
//    Transpuesta transponer;
//    Determinante determinante;
//    Escalar escalar;
//    GaussJordan gaussJordan;
//    InversaGaussJordan inversaGaussJordan;
    private GraficaMatriz vista;

    /**
     * Método para mostrar la vista Gráfica y posicionarla
     *
     * @throws IOException Excepcion en caso de que no se permita mostrar la
     * vista
     */
    public void iniciar() throws IOException {
        vista.setVisible(true);
        vista.pack();
        vista.setLocationRelativeTo(null);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Constructor para el controlador de la Gráfica, setea los atributos con
     * instancias de las clases necesarias para realizar las funcionalidades
     */
    public ControladorGrafica() {
        this.vista = new GraficaMatriz();
//        this.suma = new Sumatoria();
//        this.transponer = new Transpuesta();
//        this.multiplicacion = new Multiplicacion();
//        this.determinante = new Determinante();
//        this.escalar = new Escalar();
//        this.gaussJordan = new GaussJordan();
//        this.inversaGaussJordan = new InversaGaussJordan();

        this.vista.botonfunciones.addActionListener(this);
        this.vista.botonagregarmatriz.addActionListener(this);
        this.vista.Botoncambiar.addActionListener(this);
        this.vista.agregarfilcol.addActionListener(this);

        //Inicializacion
        bloquearCampos();
    }//Cierre del constructor

    /**
     * Método para escuchar un evento ocasionado por el usuario en la vista
     *
     * @param e El evento ocasionado por el usuario
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.botonfunciones) {
            vista.cbopcionesdematriz.setEnabled(false);
            vista.botonfunciones.setEnabled(false);
            vista.Botoncambiar.setEnabled(true);
            vista.agregarfilcol.setEnabled(true);

            cambiarDisponibilidadCampos();
            switch (vista.cbopcionesdematriz.getSelectedIndex()) {
                case 1:
                    cambiarAUnicaMatriz();
                    break;
                case 0:
                case 2:
                    cambiarADosMatrices();
                    break;

                case 3:
                case 4:
                case 5:
                case 6:
                    cambiarDisponibilidadAFalso();
                    break;
                default:
                    break;
            }
        }
        if (e.getSource() == vista.botonagregarmatriz) {

            double[][] matrizLectura, matrizLecturaSegunda, matrizResultado = null;

            matrizLectura = leerMatriz(vista.tablamatrizdatos);
            boolean tablaActualizada = true;
            switch (vista.cbopcionesdematriz.getSelectedIndex()) {
                case 0:
                    matrizResultado = Sumatoria.sumarMatrices(matrizLectura, leerMatriz(vista.tablamatriz2));
                    break;

                case 1:
                    matrizResultado = Escalar.multiplicarPorEscalar(matrizLectura, Double.parseDouble(vista.tfEscalar.getText()));
                    break;

                case 2:
                    matrizResultado = Multiplicacion.multiplicarMatrices(matrizLectura, leerMatriz(vista.tablamatriz2));
                    break;

                case 3:
                    matrizResultado = Transpuesta.transponerMatrices(matrizLectura);
                    break;

                case 4:
//                    Determinante determinanteGauss = new Determinante();
                    if (Determinante.obtenerDeterminante(matrizLectura) != 0) {
                        matrizResultado = InversaGaussJordan.invertirGaussJordan(matrizLectura);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "No puedes realizar la función porque la determinante de la matriz es igual a 0");
                        tablaActualizada = false;
                    }
                    break;

                case 5:
                    matrizResultado = GaussJordan.resolverGaussJordan(matrizLectura);
                    break;

                case 6:
                    tablaActualizada = false;
                    vista.tfDeterminante.setText(String.valueOf(Determinante.obtenerDeterminante(matrizLectura)));
                    vista.tablamatrizdatos.setEnabled(false);
                    break;
                default:
                    break;

            }
            if (tablaActualizada == true) {
                actualizarTablaResultante(matrizResultado);
            }
        }
        if (e.getSource() == vista.Botoncambiar) {
            reiniciarVista();
        }
        if (e.getSource() == vista.agregarfilcol) {
            vista.agregarfilcol.setEnabled(false);
            vista.botonagregarmatriz.setEnabled(true);

            int numFilas, numColumnas, numFilasSegundaMatriz, numColumSegundaMatriz = 0;
            switch (vista.cbopcionesdematriz.getSelectedIndex()) {
                case 0:
                case 2:

                    numFilas =(Integer.parseInt(vista.tfFilas.getText()));
                    numColumnas=(Integer.parseInt(vista.tfColumnas.getText()));
                    numFilasSegundaMatriz = Integer.parseInt(vista.tfFilasSeg.getText());
                    numColumSegundaMatriz = Integer.parseInt(vista.tfColSeg.getText());
                    inicializarTablasDeMatrices(numFilas, numColumnas, numFilasSegundaMatriz, numColumSegundaMatriz, vista.tablamatrizdatos, vista.tablamatriz2);
                    break;

                case 1:
                    vista.tfEscalar.setEnabled(false);

                case 3:
                case 5:
                case 6:
                    numFilas=(Integer.parseInt(vista.tfFilas.getText()));
                    numColumnas=(Integer.parseInt(vista.tfColumnas.getText()));
                    inicializarTablaDeUnaMatriz(numFilas, numColumnas, vista.tablamatrizdatos);
                    break;

                case 4:
                    numFilas=(Integer.parseInt(vista.tfFilas.getText()));
                    numColumnas=(Integer.parseInt(vista.tfColumnas.getText()));
                    if (numFilas == numColumnas) {
                        inicializarTablaDeUnaMatriz(numFilas, numColumnas, vista.tablamatrizdatos);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "La inversa solo se puede realizar para matrices cuadradas");
                        vista.agregarfilcol.setEnabled(false);
                        break;
                    }

                default:
                    break;

            }
        }
    }

    /**
     * Método que bloquea todos los campos donde el usuario puede introducir
     * datos
     */
    private void bloquearCampos() {
        vista.tablamatrizfunciones.setEnabled(false);
        vista.tablamatriz2.setEnabled(false);
        vista.tablamatrizdatos.setEnabled(false);
        vista.botonagregarmatriz.setEnabled(false);
        vista.Botoncambiar.setEnabled(false);
        vista.agregarfilcol.setEnabled(false);
        vista.tfColSeg.setEnabled(false);
        vista.tfColumnas.setEnabled(false);
        vista.tfFilas.setEnabled(false);
        vista.tfFilasSeg.setEnabled(false);
        vista.tfDeterminante.setEnabled(false);
        vista.tfEscalar.setEnabled(false);
    }

    /**
     * Método para reiniciar la vista en caso de querer realizar un nuevo método
     * para poder limpiar los campos de datos introducidos ya no necesarios.
     */
    private void reiniciarVista() {
        desactivarTabla(vista.tablamatrizdatos);
        desactivarTabla(vista.tablamatriz2);
        desactivarTabla(vista.tablamatrizfunciones);
        vista.botonfunciones.setEnabled(true);
        vista.tablamatrizfunciones.setEnabled(false);
        vista.tablamatriz2.setEnabled(false);
        vista.tablamatrizdatos.setEnabled(false);
        vista.botonagregarmatriz.setEnabled(false);
        vista.Botoncambiar.setEnabled(false);
        vista.cbopcionesdematriz.setEnabled(true);
        vista.tfColSeg.setEnabled(false);
        vista.tfColumnas.setEnabled(false);
        vista.tfFilas.setEnabled(false);
        vista.tfFilasSeg.setEnabled(false);
        vista.tfDeterminante.setEnabled(false);
        vista.tfEscalar.setEnabled(false);
        vista.agregarfilcol.setEnabled(false);
        vista.tfColSeg.setText("");
        vista.tfColumnas.setText("");
        vista.tfFilas.setText("");
        vista.tfFilasSeg.setText("");
        vista.tfDeterminante.setText("");
        vista.tfEscalar.setText("");
    }

    /**
     * Método para permitir introducir datos a filas y columnas, pero no al
     * campo de determinante.
     */
    private void cambiarDisponibilidadCampos() {
        vista.tfFilas.setEnabled(true);
        vista.tfColumnas.setEnabled(true);
        vista.tfDeterminante.setEnabled(false);
    }

    /**
     * Método para prohibir la entrada de datos para el campo determinante y los
     * campos de la segunda matriz.
     */
    private void cambiarDisponibilidadAFalso() {
        vista.tfFilasSeg.setEnabled(false);
        vista.tfColSeg.setEnabled(false);
        vista.tfEscalar.setEnabled(false);
    }

    /**
     * Método para permitir la entrada de datos para el campo determinante y
     * prohibir los campos de la segunda matriz.
     */
    private void cambiarAUnicaMatriz() {
        vista.tfEscalar.setEnabled(true);
        vista.tfFilasSeg.setEnabled(false);
        vista.tfColSeg.setEnabled(false);
    }

    /**
     * Método para permitir la entrada de datos para los campos de una segunda
     * matriz y prohibir el campo de determinante.
     */
    private void cambiarADosMatrices() {
        vista.tfColSeg.setEnabled(true);
        vista.tfFilasSeg.setEnabled(true);
        vista.tfEscalar.setEnabled(false);
    }

    /**
     * Método para actualizar la tabla de la vista conforme a los datos de la
     * matriz resultada de la operacion realizada.
     *
     * @param matrizResultado matriz obtenida de la operacion escogida por el
     * usuario.
     */
    private void actualizarTablaResultante(double[][] matrizResultado) {
        actualizarTablaResultados(matrizResultado, vista.tablamatrizfunciones);
        vista.tablamatrizdatos.setEnabled(false);
    }

    /**
     * Método para setear la primera tabla para permitir al usuario introducir
     * datos conforme al numero de filas y columnas deseadas
     *
     * @param filas Número de filas deseadas por el usuario para la matriz.
     * @param columnas Número de columnas deseadas por el usuario para la
     * matriz.
     * @param tabla Componente gráfico de la vista en donde se colocará el
     * modelo y se introducirán los espacios de la matriz.
     */
    private void inicializarTablaDeUnaMatriz(int filas, int columnas, JTable tabla) {
        vista.botonagregarmatriz.setEnabled(true);
        vista.Botoncambiar.setEnabled(true);
        vista.cbopcionesdematriz.setEnabled(false);
        vista.tfFilas.setEnabled(false);
        vista.tfColumnas.setEnabled(false);
        DefaultTableModel modelomatriz = (DefaultTableModel) tabla.getModel();
        modelomatriz.setRowCount(filas);
        modelomatriz.setColumnCount(columnas);
        tabla.setEnabled(true);
    }

    /**
     * Método para setear las 2 tablas para permitir al usuario introducir datos
     * conforme al numero de filas y columnas deseadas para la primera y segunda
     * tabla respectivamente.
     *
     * @param filas Número de filas deseadas por el usuario para la primera
     * matriz.
     * @param columnas Número de columnas deseadas por el usuario para la
     * primera matriz.
     * @param filasseg Número de filas deseadas por el usuario para la segunda
     * matriz.
     * @param colseg Número de columnas deseadas por el usuario para la segunda
     * matriz.
     * @param tabla Componente gráfico de la vista en donde se colocará el
     * modelo y se introducirán los espacios de la primera matriz.
     * @param tabla2 Componente gráfico de la vista en donde se colocará el
     * modelo y se introducirán los espacios de la segunda matriz.
     */
    private void inicializarTablasDeMatrices(int filas, int columnas, int filasseg, int colseg, JTable tabla, JTable tabla2) {
        inicializarTablaDeUnaMatriz(filas, columnas, tabla);
        vista.tfFilasSeg.setEnabled(false);
        vista.tfColSeg.setEnabled(false);

        DefaultTableModel modelomatriz2 = (DefaultTableModel) tabla2.getModel();
        modelomatriz2.setRowCount(filasseg);
        modelomatriz2.setColumnCount(colseg);
        tabla2.setEnabled(true);
    }

    /**
     * Método para leer los datos de un componente grafico tabla de la vista.
     *
     * @param tabla Componente gráfica de donde se recolentan los datos
     * introducidos por el usuario.
     * @return Devuelve una matriz con los datos introducidos por el usuario.
     */
    private double[][] leerMatriz(JTable tabla) {
        int numeroFilas = tabla.getRowCount();
        int numeroColumnas = tabla.getColumnCount();

        double[][] matrizleida = new double[numeroFilas][numeroColumnas];

        for (int fila = 0; fila < numeroFilas; fila++) {
            for (int columna = 0; columna < numeroColumnas; columna++) {

                matrizleida[fila][columna] = Double.parseDouble(tabla.getValueAt(fila, columna).toString());
            }
        }
        return matrizleida;
    }

    /**
     * Método para actualizar la vista de la tabla resultados con los valores
     * obtenidos de la función escogida por el usuario.
     *
     * @param matriz Matriz con los datos obtenidos de la funcion escogida por
     * el usuario.
     * @param tabla Componente gráfico donde se mostrarán los datos obtenidos de
     * la función escogida por el usuario.
     */
    private void actualizarTablaResultados(double matriz[][], JTable tabla) {
        int filasmatriz = matriz.length;
        int colmatriz = matriz[PRIMERINDICE].length;

        DefaultTableModel modelomatriz = (DefaultTableModel) tabla.getModel();
        modelomatriz.setRowCount(filasmatriz);
        modelomatriz.setColumnCount(colmatriz);

        for (int fila = 0; fila < filasmatriz; fila++) {
            for (int columna = 0; columna < colmatriz; columna++) {

                vista.tablamatrizfunciones.setValueAt(matriz[fila][columna], fila, columna);
            }
        }
    }

    /**
     * Método para eliminar los datos de vista de la tabla y bloquearla para no
     * ser utilizada u observada por el usuario.
     *
     * @param tabla Componente gráfico donse se muestran los datos obtenidos de
     * la función escogida por el usuario.
     */
    private void desactivarTabla(JTable tabla) {
        DefaultTableModel modelomatriz = (DefaultTableModel) tabla.getModel();
        modelomatriz.setRowCount(PRIMERINDICE);
        tabla.setEnabled(false);
    }

}
