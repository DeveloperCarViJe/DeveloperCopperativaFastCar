/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BO.PromocionesBo;
import java.awt.*;
import java.awt.print.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Cardozo Villon
 */
public class ImpresionCarrera extends javax.swing.JFrame
{

    /**
     * Creates new form ImpresionCarrera
     */
    public ImpresionCarrera() {

            initComponents();
            lblEstadoImpresion.setVisible(false);
            lblCedulaUsuario.setVisible(false);
            lblBandera.setVisible(false);
            setLocationRelativeTo(null);
            setIconImage(new ImageIcon(getClass().getResource("/IMAGENES/icono.png")).getImage());
            setTitle("IMPRIMIR CARRERA");
            setDefaultCloseOperation(0);
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCarrera = new javax.swing.JPanel();
        lblFastcar = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblRefrencia = new javax.swing.JLabel();
        lblDestino = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        txtDestino = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JLabel();
        txtRefrencia = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        txtValor = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JLabel();
        lbMovil = new javax.swing.JLabel();
        txtMovil = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        lblEstadoImpresion = new javax.swing.JLabel();
        lblCedulaUsuario = new javax.swing.JLabel();
        lblBandera = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpCarrera.setBackground(new java.awt.Color(255, 255, 255));
        jpCarrera.setForeground(new java.awt.Color(255, 255, 255));
        jpCarrera.setLayout(null);

        lblFastcar.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lblFastcar.setText("FAST-CAR");
        jpCarrera.add(lblFastcar);
        lblFastcar.setBounds(70, 0, 110, 20);

        lblCliente.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        lblCliente.setText("Cliente:");
        jpCarrera.add(lblCliente);
        lblCliente.setBounds(0, 30, 50, 20);

        lblTelefono.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        lblTelefono.setText("Telefono:");
        jpCarrera.add(lblTelefono);
        lblTelefono.setBounds(0, 50, 60, 20);

        lblDireccion.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        lblDireccion.setText("Direccion:");
        jpCarrera.add(lblDireccion);
        lblDireccion.setBounds(0, 70, 70, 20);

        lblRefrencia.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        lblRefrencia.setText("Referencia:");
        jpCarrera.add(lblRefrencia);
        lblRefrencia.setBounds(0, 90, 70, 20);

        lblDestino.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        lblDestino.setText("Destino:");
        jpCarrera.add(lblDestino);
        lblDestino.setBounds(0, 110, 60, 20);

        lblValor.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        lblValor.setText("Valor:");
        jpCarrera.add(lblValor);
        lblValor.setBounds(0, 130, 40, 20);

        txtDestino.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jpCarrera.add(txtDestino);
        txtDestino.setBounds(70, 110, 250, 20);

        txtCliente.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jpCarrera.add(txtCliente);
        txtCliente.setBounds(70, 30, 210, 20);

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jpCarrera.add(txtDireccion);
        txtDireccion.setBounds(70, 70, 200, 20);

        txtRefrencia.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jpCarrera.add(txtRefrencia);
        txtRefrencia.setBounds(70, 90, 250, 20);

        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jpCarrera.add(txtFecha);
        txtFecha.setBounds(40, 160, 160, 20);

        txtValor.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jpCarrera.add(txtValor);
        txtValor.setBounds(40, 130, 40, 20);

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jpCarrera.add(txtTelefono);
        txtTelefono.setBounds(70, 50, 80, 20);

        lbMovil.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        lbMovil.setText("Movil:");
        jpCarrera.add(lbMovil);
        lbMovil.setBounds(100, 130, 50, 20);

        txtMovil.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jpCarrera.add(txtMovil);
        txtMovil.setBounds(140, 130, 40, 20);

        lblFecha.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        lblFecha.setText("Fecha:");
        jpCarrera.add(lblFecha);
        lblFecha.setBounds(0, 160, 40, 20);

        btnImprimir.setText("IMPRIMIR");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCarrera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 119, Short.MAX_VALUE)
                    .addComponent(lblEstadoImpresion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 119, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 116, Short.MAX_VALUE)
                    .addComponent(lblCedulaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 115, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addComponent(lblBandera, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(221, 221, 221)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir)
                    .addComponent(btnCancelar))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 109, Short.MAX_VALUE)
                    .addComponent(lblEstadoImpresion, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 108, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 109, Short.MAX_VALUE)
                    .addComponent(lblCedulaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 109, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(55, Short.MAX_VALUE)
                    .addComponent(lblBandera, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(162, 162, 162)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
    
    
        try {
            
            
            proyecto_fastcar.ImpresionCarrera t = new proyecto_fastcar.ImpresionCarrera(txtCliente.getText(),txtTelefono.getText(),txtDireccion.getText(),txtRefrencia.getText(),txtDestino.getText(),txtValor.getText(),txtMovil.getText(),txtFecha.getText());
            System.out.println(txtCliente.getText() + txtTelefono.getText() + txtDireccion.getText() + txtRefrencia.getText() + txtDestino.getText() + txtValor.getText() + txtMovil.getText() + txtFecha.getText());
            t.print();
            if (lblBandera.getText()=="H"){
                     HistorialCarreras frm = new HistorialCarreras();
                     frm.show();
                     frm.setExtendedState(MAXIMIZED_BOTH);
                     this.dispose();
                }else{
                    IngresoCarreras frm = new IngresoCarreras();
                    frm.lblEstadoCarrera.setText(this.lblEstadoImpresion.getText());
                    frm.lblCedulaUsuario.setText(this.lblCedulaUsuario.getText());
                    frm.show();
                    this.dispose();
                }
       } catch (IOException ex) {
            Logger.getLogger(ImpresionCarrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ImpresionCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        if (lblBandera.getText()=="H"){
                     HistorialCarreras frm = new HistorialCarreras();
                     frm.show();
                     frm.setExtendedState(MAXIMIZED_BOTH);
                     this.dispose();
                }else{
                    IngresoCarreras frm = new IngresoCarreras();
                    frm.lblEstadoCarrera.setText(this.lblEstadoImpresion.getText());
                    frm.lblCedulaUsuario.setText(this.lblCedulaUsuario.getText());
                    frm.show();
                    this.dispose();
                }
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(ImpresionCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImpresionCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImpresionCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImpresionCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImpresionCarrera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JPanel jpCarrera;
    private javax.swing.JLabel lbMovil;
    public static javax.swing.JLabel lblBandera;
    public static javax.swing.JLabel lblCedulaUsuario;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblDireccion;
    public static javax.swing.JLabel lblEstadoImpresion;
    private javax.swing.JLabel lblFastcar;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblRefrencia;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblValor;
    public static javax.swing.JLabel txtCliente;
    public static javax.swing.JLabel txtDestino;
    public static javax.swing.JLabel txtDireccion;
    public static javax.swing.JLabel txtFecha;
    public static javax.swing.JLabel txtMovil;
    public static javax.swing.JLabel txtRefrencia;
    public static javax.swing.JLabel txtTelefono;
    public static javax.swing.JLabel txtValor;
    // End of variables declaration//GEN-END:variables

    
}
