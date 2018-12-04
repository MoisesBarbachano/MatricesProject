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
 *
 * @author sulak
 */
public final class ControladorGrafica implements ActionListener {

    final int PRIMERINDICE = 0;

//    Multiplicacion multiplicacion;
//    Sumatoria suma;
//    Transpuesta transponer;
//    Determinante determinante;
//    Escalar escalar;
//    GaussJordan gaussJordan;
//    InversaGaussJordan inversaGaussJordan;
     private GraficaMatriz vista;

    public void iniciar() throws IOException {
        vista.setVisible(true);
        vista.pack();
        vista.setLocationRelativeTo(null);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

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
    }

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
                    cambiarUnicaMatriz();
                    break;
                case 0:
                case 2:
                    cambiarDosMatrices();
                    break;

                case 3:
                case 4:
                case 5:
                case 6:
                    cambiarDisponibilidadFalso();
                    break;
                default:
                    break;
            }
        }
        if (e.getSource() == vista.botonagregarmatriz) {

            double[][] matrizLectura, matrizLecturaSegunda, matrizResultado = null;

            matrizLectura = leermatriz(vista.tablamatrizdatos);
            boolean tablaActualizada = true;
            switch (vista.cbopcionesdematriz.getSelectedIndex()) {
                case 0:
                    matrizResultado = Sumatoria.sumarMatrices(matrizLectura, leermatriz(vista.tablamatriz2));
                    break;

                case 1:
                    matrizResultado = Escalar.multiplicarEscalar(matrizLectura, Double.parseDouble(vista.tfEscalar.getText()));
                    break;

                case 2:
                    matrizResultado = Multiplicacion.multiplicarMatrices(matrizLectura, leermatriz(vista.tablamatriz2));
                    break;

                case 3:
                    matrizResultado = Transpuesta.transponerMatrices(matrizLectura);
                    break;

                case 4:
//                    Determinante determinanteGauss = new Determinante();
                    if ( Determinante.obtenerDeterminante(matrizLectura) != 0) {
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
                actualizarTabla(matrizResultado);
            }
        }
        if (e.getSource() == vista.Botoncambiar) {
            reiniciarVista();
        }
        if (e.getSource() == vista.agregarfilcol) {
            vista.agregarfilcol.setEnabled(false);
            vista.botonagregarmatriz.setEnabled(true);
 
            int numFilas,numColumnas,numFilasSegundaMatriz,numColumSegundaMatriz = 0;
            switch (vista.cbopcionesdematriz.getSelectedIndex()) {
                case 0:
                case 2:

                    numFilas = Integer.parseInt(vista.tfFilas.getText());
                    numColumnas = Integer.parseInt(vista.tfColumnas.getText());
                    numFilasSegundaMatriz = Integer.parseInt(vista.tfFilasSeg.getText());
                    numColumSegundaMatriz = Integer.parseInt(vista.tfColSeg.getText());
                    actualizartablas(numFilas, numColumnas, numFilasSegundaMatriz, numColumSegundaMatriz, vista.tablamatrizdatos, vista.tablamatriz2);
                    break;

                case 1: 
                    vista.tfEscalar.setEnabled(false);

                case 3: case 5: case 6:
                    numFilas = Integer.parseInt(vista.tfFilas.getText());
                    numColumnas = Integer.parseInt(vista.tfColumnas.getText());
                    actualizartabla(numFilas, numColumnas, vista.tablamatrizdatos);
                    break;

                case 4:
                    numFilas = Integer.parseInt(vista.tfFilas.getText());
                    numColumnas = Integer.parseInt(vista.tfColumnas.getText());
                    if (numFilas == numColumnas) {
                        actualizartabla(numFilas, numColumnas, vista.tablamatrizdatos);
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

    public void bloquearCampos() {
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

    public void reiniciarVista() {
        quitartabla(vista.tablamatrizdatos);
        quitartabla(vista.tablamatriz2);
        quitartabla(vista.tablamatrizfunciones);
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

    public void cambiarDisponibilidadCampos() {
        vista.tfFilas.setEnabled(true);
        vista.tfColumnas.setEnabled(true);
        vista.tfDeterminante.setEnabled(false);
    }

    public void cambiarDisponibilidadFalso() {
        vista.tfFilasSeg.setEnabled(false);
        vista.tfColSeg.setEnabled(false);
        vista.tfEscalar.setEnabled(false);
    }

    public void cambiarUnicaMatriz() {
        vista.tfEscalar.setEnabled(true);
        vista.tfFilasSeg.setEnabled(false);
        vista.tfColSeg.setEnabled(false);
    }

    public void cambiarDosMatrices() {
        vista.tfColSeg.setEnabled(true);
        vista.tfFilasSeg.setEnabled(true);
        vista.tfEscalar.setEnabled(false);
    }

    public void actualizarTabla(double[][] matrizResultado) {
        actualizartablafunciones(matrizResultado, vista.tablamatrizfunciones);
        vista.tablamatrizdatos.setEnabled(false);
    }

    public void actualizartabla(int filas, int columnas, JTable tabla) {
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

    public void actualizartablas(int filas, int columnas, int filasseg, int colseg, JTable tabla, JTable tabla2) {
        vista.botonagregarmatriz.setEnabled(true);
        vista.Botoncambiar.setEnabled(true);
        vista.cbopcionesdematriz.setEnabled(false);
        vista.tfFilas.setEnabled(false);
        vista.tfColumnas.setEnabled(false);
        vista.tfFilasSeg.setEnabled(false);
        vista.tfColSeg.setEnabled(false);

        DefaultTableModel modelomatriz = (DefaultTableModel) tabla.getModel();
        modelomatriz.setRowCount(filas);
        modelomatriz.setColumnCount(columnas);
        tabla.setEnabled(true);

        DefaultTableModel modelomatriz2 = (DefaultTableModel) tabla2.getModel();
        modelomatriz2.setRowCount(filasseg);
        modelomatriz2.setColumnCount(colseg);
        tabla2.setEnabled(true);
    }

    public double[][] leermatriz(JTable tabla) {
        int numFilas = tabla.getRowCount();
        int numColumnas = tabla.getColumnCount();

        double[][] matrizleida = new double[numFilas][numColumnas];

        for (int fila = 0; fila < numFilas; fila++) {
            for (int columna = 0; columna < numColumnas; columna++) {

                matrizleida[fila][columna] = Double.parseDouble(tabla.getValueAt(fila, columna).toString());
            }
        }
        return matrizleida;
    }

    public void actualizartablafunciones(double matriz[][], JTable tabla) {
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

    public void quitartabla(JTable tabla) {
        DefaultTableModel modelomatriz = (DefaultTableModel) tabla.getModel();
        modelomatriz.setRowCount(PRIMERINDICE);
        tabla.setEnabled(false);
    }

}
