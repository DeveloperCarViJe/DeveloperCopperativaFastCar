/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BO.RegistroValoresBo;
import JB.RegistrosValores;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Cardozo Villon
 */
public class RegistroValores extends javax.swing.JFrame {

    /**
     * Creates new form RegistroValores
     */
    public RegistroValores() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/IMAGENES/icono.png")).getImage());
        setTitle("REGISTRO VALORES");
        lblEstadoValores.setVisible(false);
        lblCedulaUsuario.setVisible(false);
        setDefaultCloseOperation(0);
        //txtRegistroValoresEstado.setVisible(false);
        ImageIcon fastcar = new ImageIcon(getClass().getResource("/IMAGENES/fondo.jpeg"));
        ImageIcon icon = new ImageIcon(fastcar.getImage().getScaledInstance(lblfondoPanel.getWidth(), lblfondoPanel.getHeight(), Image.SCALE_DEFAULT));
        lblfondoPanel.setIcon(icon);
        
        fastcar = new ImageIcon(getClass().getResource("/IMAGENES/fondo.jpeg"));
        icon = new ImageIcon(fastcar.getImage().getScaledInstance(lblFondoFrame.getWidth(), lblFondoFrame.getHeight(), Image.SCALE_DEFAULT));
        lblFondoFrame.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRegistroValores = new javax.swing.JLabel();
        jPanelRegistroValores = new javax.swing.JPanel();
        lblDestino = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        lvlValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblfondoPanel = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblRegistroValores1 = new javax.swing.JLabel();
        lblFondoFrame = new javax.swing.JLabel();
        lblEstadoValores = new javax.swing.JLabel();
        lblCedulaUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblRegistroValores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRegistroValores.setForeground(new java.awt.Color(255, 255, 255));
        lblRegistroValores.setText("SISTEMA FASTCAR - REGISTRO VALORES");

        jPanelRegistroValores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDestino.setForeground(new java.awt.Color(255, 255, 255));
        lblDestino.setText("DESTINO");

        lvlValor.setForeground(new java.awt.Color(255, 255, 255));
        lvlValor.setText("VALOR");

        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });

        lblfondoPanel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelRegistroValoresLayout = new javax.swing.GroupLayout(jPanelRegistroValores);
        jPanelRegistroValores.setLayout(jPanelRegistroValoresLayout);
        jPanelRegistroValoresLayout.setHorizontalGroup(
            jPanelRegistroValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRegistroValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistroValoresLayout.createSequentialGroup()
                        .addComponent(lblDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRegistroValoresLayout.createSequentialGroup()
                        .addComponent(lvlValor, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelRegistroValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblfondoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
        );
        jPanelRegistroValoresLayout.setVerticalGroup(
            jPanelRegistroValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRegistroValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistroValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lvlValor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanelRegistroValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelRegistroValoresLayout.createSequentialGroup()
                    .addComponent(lblfondoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.setActionCommand("btnRegresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblRegistroValores1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRegistroValores1.setForeground(new java.awt.Color(255, 255, 255));
        lblRegistroValores1.setText("DATOS VALORES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEstadoValores, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(lblRegistroValores, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRegistroValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegistroValores1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(btnRegistrar)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblFondoFrame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(221, 221, 221)
                    .addComponent(lblCedulaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(221, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegistroValores, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstadoValores, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblRegistroValores1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRegistroValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnRegresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblFondoFrame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(lblCedulaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(118, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if(lblEstadoValores.getText().equals("A")){
            MenuPrincipalAdmin me = new MenuPrincipalAdmin();
            me.lblEstado.setText(lblEstadoValores.getText());
            me.lblCedulaUsuario.setText(this.lblCedulaUsuario.getText());
            me.setLocationRelativeTo(null);
            me.show();
            this.dispose();
        }else if (lblEstadoValores.getText().equals("O")) {
            MenuPrincipalOperadoras me = new MenuPrincipalOperadoras();
            me.lblEstado.setText(lblEstadoValores.getText());
            me.lblCedulaUsuario.setText(this.lblCedulaUsuario.getText());
            me.setLocationRelativeTo(null);
            me.show();
            this.dispose();
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(txtDestino.getText().isEmpty() && txtValor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS SON OBLIGATORIOS", "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                int n=0;
                int ingresoRegistro=0;
                float valor=Float.parseFloat(txtValor.getText());
                RegistroValoresBo bo = new RegistroValoresBo();
                n=bo.ValidarRegistroDiario(txtDestino.getText());
                if(n==0){
                    RegistrosValores in = new RegistrosValores(txtDestino.getText(),valor);
                    ingresoRegistro=bo.RegistrarRegistrodiarios(in);
                    if(ingresoRegistro>0){
                        JOptionPane.showMessageDialog(rootPane,"SE REGISTRO CORRECTAMENTE");
                        txtDestino.setText(null);
                        txtValor.setText(null); 
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "LOS DATOS YA ESTAN REGISTRADOS", "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegistroValores.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(RegistroValores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')&&(car!='.')) evt.consume();
    }//GEN-LAST:event_txtValorKeyTyped

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
            java.util.logging.Logger.getLogger(RegistroValores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroValores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroValores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroValores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroValores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanelRegistroValores;
    public static javax.swing.JLabel lblCedulaUsuario;
    private javax.swing.JLabel lblDestino;
    public static javax.swing.JLabel lblEstadoValores;
    private javax.swing.JLabel lblFondoFrame;
    private javax.swing.JLabel lblRegistroValores;
    private javax.swing.JLabel lblRegistroValores1;
    private javax.swing.JLabel lblfondoPanel;
    private javax.swing.JLabel lvlValor;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
