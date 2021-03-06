package Vista;

import Modelo.Determinante;
import Modelo.GaussJordan;
import Modelo.InversaGaussJordan;
import Modelo.Escalar;
import Modelo.Multiplicacion;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que hereda de JFrame mostrada al usuario para introducir datos y mostrar resultados.
 * @author 52999
 */
public class GraficaMatriz extends javax.swing.JFrame {


    /**
     * Constructor que inicializa los componentes de la vista.
     */
    public GraficaMatriz() {
        initComponents();

    }//Cierre del constructor

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfFilas = new javax.swing.JTextField();
        tfColumnas = new javax.swing.JTextField();
        cbopcionesdematriz = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tfDeterminante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        botonfunciones = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablamatrizfunciones = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablamatrizdatos = new javax.swing.JTable();
        botonagregarmatriz = new javax.swing.JToggleButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablamatriz2 = new javax.swing.JTable();
        Botoncambiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfFilasSeg = new javax.swing.JTextField();
        tfColSeg = new javax.swing.JTextField();
        agregarfilcol = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfEscalar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese el número de filas de la matriz");

        jLabel2.setText("Ingrese el número de columnas de la matriz");

        tfColumnas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfColumnasActionPerformed(evt);
            }
        });

        cbopcionesdematriz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Suma", "Multiplicación por escalar", "Multiplicación", "Transpuesta", "Inversa", "Solución Gauss", "Determinante" }));

        jLabel3.setText("Determine la opción que desea realizar a la matriz");

        tfDeterminante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDeterminanteActionPerformed(evt);
            }
        });

        jLabel4.setText("Determinante");

        botonfunciones.setText("Elegir función");
        botonfunciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonfuncionesActionPerformed(evt);
            }
        });

        tablamatrizfunciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablamatrizfunciones);

        tablamatrizdatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablamatrizdatos);

        botonagregarmatriz.setText("Realizar función");
        botonagregarmatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonagregarmatrizActionPerformed(evt);
            }
        });

        tablamatriz2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablamatriz2);

        Botoncambiar.setText("Cambiar función");
        Botoncambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotoncambiarActionPerformed(evt);
            }
        });

        jLabel5.setText("Ingrese el número de filas de la matriz 2 ");

        jLabel6.setText("Ingrese el número de columnas de la matriz 2 ");

        agregarfilcol.setText("Agregar");
        agregarfilcol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarfilcolActionPerformed(evt);
            }
        });

        jLabel7.setText("Escalar");

        jLabel8.setText("Resultado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(118, 118, 118)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfEscalar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tfColumnas, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                                    .addComponent(tfFilasSeg)
                                                    .addComponent(tfColSeg))
                                                .addGap(29, 29, 29)
                                                .addComponent(agregarfilcol)
                                                .addGap(161, 161, 161))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(27, 27, 27)))
                                        .addComponent(tfDeterminante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(botonagregarmatriz))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbopcionesdematriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(botonfunciones)
                                .addGap(34, 34, 34)
                                .addComponent(Botoncambiar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(211, 211, 211))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbopcionesdematriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonfunciones)
                            .addComponent(jLabel4)
                            .addComponent(tfDeterminante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Botoncambiar)
                            .addComponent(jLabel8))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(tfEscalar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregarfilcol))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfFilasSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfColSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(botonagregarmatriz))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfColumnasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfColumnasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfColumnasActionPerformed

    private void tfDeterminanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDeterminanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDeterminanteActionPerformed

    private void botonfuncionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonfuncionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonfuncionesActionPerformed

    private void botonagregarmatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonagregarmatrizActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonagregarmatrizActionPerformed

    private void BotoncambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotoncambiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotoncambiarActionPerformed

    private void agregarfilcolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarfilcolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarfilcolActionPerformed

    /**
     * Método Main que permite visualizar la vista.
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraficaMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaMatriz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Botoncambiar;
    public javax.swing.JButton agregarfilcol;
    public javax.swing.JToggleButton botonagregarmatriz;
    public javax.swing.JButton botonfunciones;
    public javax.swing.JComboBox<String> cbopcionesdematriz;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable tablamatriz2;
    public javax.swing.JTable tablamatrizdatos;
    public javax.swing.JTable tablamatrizfunciones;
    public javax.swing.JTextField tfColSeg;
    public javax.swing.JTextField tfColumnas;
    public javax.swing.JTextField tfDeterminante;
    public javax.swing.JTextField tfEscalar;
    public javax.swing.JTextField tfFilas;
    public javax.swing.JTextField tfFilasSeg;
    // End of variables declaration//GEN-END:variables
}
