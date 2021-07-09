/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BO.CarrerasBo;
import BO.ChoferesBo;
import BO.DetallesPromocionesBo;
import BO.PagosDiariosBo;
import DAO.CarrerasDao;
import JB.Carreras;
import JB.Choferes;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jcardozo
 */
public class HistorialCarreras extends javax.swing.JFrame {

    /**
     * Creates new form HistorialCarreras
     */
    public HistorialCarreras() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/IMAGENES/icono.png")).getImage());
        setTitle("HISTORIAL CARRERAS");
        obtenerDatos();
        jTableHistorialCarreras.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        jTableHistorialCarreras.getColumnModel().getColumn(0).setPreferredWidth(67);
        jTableHistorialCarreras.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableHistorialCarreras.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTableHistorialCarreras.getColumnModel().getColumn(3).setPreferredWidth(35);
        jTableHistorialCarreras.getColumnModel().getColumn(4).setPreferredWidth(35);
        jTableHistorialCarreras.getColumnModel().getColumn(5).setPreferredWidth(105);
        jTableHistorialCarreras.getColumnModel().getColumn(6).setPreferredWidth(200);
        txtHistorialCarreraEstado.setVisible(false);
        
        setDefaultCloseOperation(0);
        
        
    }
    
    public void obtenerDatos(){
        try {
            // TODO add your handling code here:

           /* DefaultTableModel modelo=(DefaultTableModel) jTableHistorialCarreras.getModel();
            //int filas=jTableHistorialCarreras.getRowCount();
            for (int i = 0;20>i; i++) {
                modelo.removeRow(0);
            }*/
            
            //Agregar boton a la tabla
             jTableHistorialCarreras.setDefaultRenderer(Object.class, new Render());
             //jTableHistorialCarreras.setDefaultRenderer(Object.class, new Render2());
            JButton btnAplicar = new JButton("APLICAR");
            btnAplicar.setBackground(java.awt.Color.cyan);
            JButton btnReservar = new JButton("RESERVAR");
            btnReservar.setBackground(java.awt.Color.GREEN);
            
            //label en el jtable
            JLabel lblOkaplicar =  new JLabel("APLICADA");
            lblOkaplicar.setForeground(Color.GREEN);
            JLabel lblNoaplicar =  new JLabel("NO APLICADA");
            lblNoaplicar.setForeground(Color.RED);
            JLabel lblReservada =  new JLabel("RESERVADA");
            lblReservada.setForeground(Color.BLUE);
            
            CarrerasBo bo= new CarrerasBo();
            ChoferesBo bo7 = new ChoferesBo();
            Vector v1 = bo.ObtenerHistorialCarreras();
            
            if (v1.size()>0){
                    //DefaultTableModel modelo=(DefaultTableModel) jTableHistorialCarreras.getModel();
                    //int filas=jTableHistorialCarreras.getRowCount();
                    //for (int i = 0;v1.size()>i; i++) {
                    //    modelo.removeRow(0);
                    //}
                for(int i=0;i<v1.size();i++){
                    
                    Carreras c = (Carreras)v1.get(i);

                    jTableHistorialCarreras.setValueAt(c.getLv_TELEFONO(), i, 0);
                    jTableHistorialCarreras.setValueAt(c.getLv_ORIGEN(), i, 1);
                    jTableHistorialCarreras.setValueAt(c.getLv_DESTINO(), i, 2);
                    jTableHistorialCarreras.setValueAt(c.getLv_REFERENCIA(), i, 3);
                    jTableHistorialCarreras.setValueAt(c.getLf_VALOR(), i, 4);
                    jTableHistorialCarreras.setValueAt(c.getLn_MOVIL(), i, 5);
                    jTableHistorialCarreras.setValueAt(c.getLv_CLIENTE(), i, 6);
                    jTableHistorialCarreras.setValueAt(c.getLv_USUARIO_ID(), i,7);
                    jTableHistorialCarreras.setValueAt(c.getlv_FECHA_HORA_REGISTRO(), i, 8);
                    if (String.valueOf(c.getLv_RESERVA()).equals("A")){
                     jTableHistorialCarreras.setValueAt(lblReservada, i, 11);
                     jTableHistorialCarreras.setValueAt(String.valueOf(c.getLv_FECHA_HORA_RESERVA()).substring(0, 10), i, 9);
                     jTableHistorialCarreras.setValueAt(String.valueOf(c.getLv_FECHA_HORA_RESERVA()).substring(11,19), i, 10);
                    }else{
                        jTableHistorialCarreras.setValueAt(c.getLv_FECHA_HORA_RESERVA(), i, 11);
                    }
                    if(String.valueOf(c.getLv_ESTADO_CARRERA()).equals("NA") && !String.valueOf(c.getLv_RESERVA()).equals("A")){
                        jTableHistorialCarreras.setValueAt(btnAplicar, i, 12);
                    }else if(c.getLv_ESTADO_CARRERA().equals("NA") && String.valueOf(c.getLv_RESERVA()).equals("A")){ 
                        jTableHistorialCarreras.setValueAt(btnReservar, i, 12);
                    } else{
                        jTableHistorialCarreras.setValueAt(lblOkaplicar, i, 11);
                        jTableHistorialCarreras.setValueAt(" ", i, 12);
                    }
                    if(String.valueOf(c.getLv_ESTADO_CARRERA()).equals("E")){
                        jTableHistorialCarreras.setValueAt(lblNoaplicar, i, 11);
                        jTableHistorialCarreras.setValueAt(" ", i, 12);
                    }
                    
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HistorialCarreras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialCarreras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public class Render extends DefaultTableCellRenderer{
        
        public Component getTableCellRendererComponent(JTable table, Object value, 
                boolean isSelected, boolean hasFocus, int row, int column){
            
            if(value instanceof JButton){
                JButton btn = (JButton)value;
                return btn;
            }
            if(value instanceof JLabel){
                JLabel lbl = (JLabel)value;
                return lbl;
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistorialCarreras = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        lblMenuPrincipal = new javax.swing.JLabel();
        txtHistorialCarreraEstado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Aharoni", 0, 8)); // NOI18N

        jTableHistorialCarreras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableHistorialCarreras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TELEFONO", "ORIGEN", "DESTINO", "REFERENCIA", "VALOR", "MOVIL", "PLACA", "SORTEO", "FECHA REGISTRO", "FECHA RESERVA", "HORA RESERVA", "OBSERVACION", "ACCION"
            }
        ));
        jTableHistorialCarreras.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableHistorialCarreras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHistorialCarrerasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableHistorialCarrerasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHistorialCarreras);

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        lblMenuPrincipal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMenuPrincipal.setText("SISTEMA FASTCAR - HISTORIAL DE CARRERAS");
        lblMenuPrincipal.setPreferredSize(new java.awt.Dimension(100, 17));

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtHistorialCarreraEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txtHistorialCarreraEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        obtenerDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jTableHistorialCarrerasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistorialCarrerasMouseClicked
        
        int column = jTableHistorialCarreras.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/jTableHistorialCarreras.getRowHeight();
        
        if(row < jTableHistorialCarreras.getRowCount() && row >= 0 && column < jTableHistorialCarreras.getColumnCount() && column >=0){
            Object value = jTableHistorialCarreras.getValueAt(row, column);
            if(value instanceof JButton){
                try {
                    ((JButton)value).doClick();
                    JButton boton = (JButton)value;
                    String nuevo_estado_reserva=null;
                    int validarCarrera=0;
                    int validarPromocion=0;
                    String movil_aplicar=null;
                    Date myDate = new Date();
                    SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String FechaHoraRegistro = mdyFormat.format(myDate);
                    //Obtener datos para actualizar
                                                                       
                    int movil=(int) jTableHistorialCarreras.getValueAt(row, 5);
                    
                    if (movil ==0){
                         int confirmacion = JOptionPane.showConfirmDialog(rootPane, "DESEA APLICAR LA CARRERA ? ","APLICAR CARRERA",JOptionPane.YES_NO_OPTION);
                         if (confirmacion == 0){
                            movil_aplicar = JOptionPane.showInputDialog("INGRESAR EL MOVIL QUE DESEA APLICAR");
                            if(!movil_aplicar.equals(null)){
                                    int n=0;
                                    int pagoDiario=0;
                                    String estado = null;
                                    ChoferesBo bo = new ChoferesBo();
                                    n=bo.ValidarChoferesRegistrados(Integer.parseInt(movil_aplicar));
                                    if(n==0){
                                        JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA REGISTRADO EL MOVIL "+movil_aplicar, "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);
                                    }else{
                                        estado=bo.EstadoMovil(Integer.parseInt(movil_aplicar));
                                        PagosDiariosBo pbo = new PagosDiariosBo();
                                        pagoDiario=pbo.ValidarPagoChofer(Integer.parseInt(movil_aplicar));
                                        if(pagoDiario>0 || Integer.parseInt(movil_aplicar) == 20 || Integer.parseInt(movil_aplicar) == 37 ||estado.equals("A")){
                                                    

                                                            CarrerasBo cbo = new CarrerasBo();
                                                            Vector v1 = cbo.ObtenerHistorialUpdate((String) jTableHistorialCarreras.getValueAt(row, 0), (String) jTableHistorialCarreras.getValueAt(row, 1), (String) jTableHistorialCarreras.getValueAt(row, 2), (String) jTableHistorialCarreras.getValueAt(row, 8));
                                                                if (v1.size()>0){
                                                                        if(String.valueOf(v1.get(2)).equals("A")){
                                                                            JOptionPane.showMessageDialog(null, "LA CARRERA YA ESTA APLICADA ACTUALIZAR LA PANTALLA POR FAVOR ", "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);    
                                                                        }else{
                                                                            if(String.valueOf(v1.get(1)).equals("A")){
                                                                                nuevo_estado_reserva="F";
                                                                            }else{
                                                                                nuevo_estado_reserva=(String) v1.get(1);
                                                                            }

                                                                         validarCarrera=cbo.ActualizarCarreras2((int) v1.get(0),nuevo_estado_reserva,Integer.parseInt(movil_aplicar));
                                                                         DetallesPromocionesBo bop = new DetallesPromocionesBo();
                                                                         validarPromocion=bop.ActrualizarPromocion((int) v1.get(0), Integer.parseInt(movil_aplicar));
                                                                         if(validarCarrera ==1){
                                                                             //JOptionPane.showMessageDialog(rootPane,"SE APLICO LA CARRERA CORRECTAMENTE, ACTUALIZAR LA PAGINA");
                                                                             ImpresionCarreraPromociones frm = new ImpresionCarreraPromociones();
                                                                            frm.txtCliente.setText((String) v1.get(3));
                                                                            frm.txtTelefono.setText((String) jTableHistorialCarreras.getValueAt(row, 0));
                                                                            frm.txtDireccion.setText((String) jTableHistorialCarreras.getValueAt(row, 1));
                                                                            frm.txtRefrencia.setText((String) v1.get(4));
                                                                            frm.txtDestino.setText((String) jTableHistorialCarreras.getValueAt(row, 2));
                                                                            frm.txtValor.setText(Float.toString((float) jTableHistorialCarreras.getValueAt(row, 4)));
                                                                            frm.txtMovil.setText(movil_aplicar);
                                                                            frm.txtFecha.setText(FechaHoraRegistro);
                                                                            frm.txtNumero.setText((String) v1.get(5));
                                                                            frm.lblBandera.setText("H");
                                                                            frm.show();
                                                                            this.dispose();

                                                                         }
                                                                        }
                                                                }else{
                                                                    CarrerasBo cbo2 = new CarrerasBo();
                                                                    Vector v2 = cbo2.ObtenerHistorialUpdate2((String) jTableHistorialCarreras.getValueAt(row, 0), (String) jTableHistorialCarreras.getValueAt(row, 1), (String) jTableHistorialCarreras.getValueAt(row, 2), (String) jTableHistorialCarreras.getValueAt(row, 8));
                                                                    if(String.valueOf(v2.get(2)).equals("A")){
                                                                            JOptionPane.showMessageDialog(null, "LA CARRERA YA ESTA APLICADA ACTUALIZAR LA PANTALLA POR FAVOR ", "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);    
                                                                        }else{
                                                                            if(String.valueOf(v2.get(1)).equals("A")){
                                                                                nuevo_estado_reserva="F";
                                                                            }else{
                                                                                nuevo_estado_reserva=(String) v2.get(1);
                                                                            }

                                                                         validarCarrera=cbo.ActualizarCarreras2((int) v2.get(0),nuevo_estado_reserva,Integer.parseInt(movil_aplicar));
                                                                         if(validarCarrera ==1){
                                                                             //JOptionPane.showMessageDialog(rootPane,"SE APLICO LA CARRERA CORRECTAMENTE, ACTUALIZAR LA PAGINA");
                                                                            ImpresionCarrera frm = new ImpresionCarrera();
                                                                            frm.txtCliente.setText((String) v2.get(3));
                                                                            frm.txtTelefono.setText((String) jTableHistorialCarreras.getValueAt(row, 0));
                                                                            frm.txtDireccion.setText((String) jTableHistorialCarreras.getValueAt(row, 1));
                                                                            frm.txtRefrencia.setText((String) v2.get(4));
                                                                            frm.txtDestino.setText((String) jTableHistorialCarreras.getValueAt(row, 2));
                                                                            frm.txtValor.setText(Float.toString((float) jTableHistorialCarreras.getValueAt(row, 4)));
                                                                            frm.txtMovil.setText(movil_aplicar);
                                                                            frm.txtFecha.setText(FechaHoraRegistro);
                                                                            frm.lblBandera.setText("H");
                                                                            frm.show();
                                                                            this.dispose();
                                                                         }
                                                                        }
                                                                }
                                                            
                                       
                                        }else{
                                            JOptionPane.showMessageDialog(null, "NO SE PUEDE ASIGNAR EL MOVIL "+movil_aplicar+" , DEBIDO QUE ESTA ATRASADO CON SU PAGO", "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                            }
                        }else{
                                                                CarrerasBo cbo3 = new CarrerasBo();
                                                                int erronea = cbo3.ActualizarErronea((String) jTableHistorialCarreras.getValueAt(row, 0), (String) jTableHistorialCarreras.getValueAt(row, 1), (String) jTableHistorialCarreras.getValueAt(row, 2), (int) jTableHistorialCarreras.getValueAt(row, 5), (String) jTableHistorialCarreras.getValueAt(row, 8));
                                                                if (erronea == 1){
                                                                HistorialCarreras frm = new HistorialCarreras();
                                                                  frm.show();
                                                                  frm.setExtendedState(MAXIMIZED_BOTH);
                                                                    this.dispose();
                                                                }
                                                            }
                    }else{
                    int confirmacion = JOptionPane.showConfirmDialog(rootPane, "DESEA APLICAR LA CARRERA ? ","APLICAR CARRERA",JOptionPane.YES_NO_OPTION);
                    if (confirmacion == 0){
                        CarrerasBo cbo2 = new CarrerasBo();
                        Vector v2 = cbo2.ObtenerHistorialUpdate2((String) jTableHistorialCarreras.getValueAt(row, 0), (String) jTableHistorialCarreras.getValueAt(row, 1), (String) jTableHistorialCarreras.getValueAt(row, 2), (String) jTableHistorialCarreras.getValueAt(row, 8));
                                                           
                                            if(String.valueOf(v2.get(2)).equals("A")){
                                                JOptionPane.showMessageDialog(null, "LA CARRERA YA ESTA APLICADA ACTUALIZAR LA PANTALLA POR FAVOR ", "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);    
                                            }else{
                                                if(String.valueOf(v2.get(1)).equals("A")){
                                                    nuevo_estado_reserva="F";
                                                }else{
                                                    nuevo_estado_reserva=(String) v2.get(1);
                                                }

                                             validarCarrera=cbo2.ActualizarCarreras((int) v2.get(0),nuevo_estado_reserva);
                                             if(validarCarrera ==1){  
                                                    JOptionPane.showMessageDialog(rootPane,"SE APLICO LA CARRERA CORRECTAMENTE, ACTUALIZAR LA PAGINA");
                                             HistorialCarreras frm = new HistorialCarreras();
                                             frm.show();
                                             frm.setExtendedState(MAXIMIZED_BOTH);
                                             this.dispose();
                                             }
                                            }
                                        
                        }else{
                        CarrerasBo cbo3 = new CarrerasBo();
                        int erronea = cbo3.ActualizarErronea((String) jTableHistorialCarreras.getValueAt(row, 0), (String) jTableHistorialCarreras.getValueAt(row, 1), (String) jTableHistorialCarreras.getValueAt(row, 2), (int) jTableHistorialCarreras.getValueAt(row, 5), (String) jTableHistorialCarreras.getValueAt(row, 8));
                        if (erronea == 1){
                        HistorialCarreras frm = new HistorialCarreras();
                          frm.show();
                          frm.setExtendedState(MAXIMIZED_BOTH);
                            this.dispose();
                        }
                    }
                        
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HistorialCarreras.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(HistorialCarreras.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
                
            }
                
        }
    }//GEN-LAST:event_jTableHistorialCarrerasMouseClicked

    private void jTableHistorialCarrerasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistorialCarrerasMousePressed
       if(evt.getClickCount()==2){
        int column = jTableHistorialCarreras.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/jTableHistorialCarreras.getRowHeight();
        
        if(row < jTableHistorialCarreras.getRowCount() && row >= 0 && column < jTableHistorialCarreras.getColumnCount() && column >=0){
            if((int) jTableHistorialCarreras.getValueAt(row, 5) == 0){
                JOptionPane.showMessageDialog(null, "LA CARRERA ESTA RESERVADA", "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);    
            }else{
                ActualizarMovilReferencia frm = new ActualizarMovilReferencia();
                frm.lblTelefono.setText((String) jTableHistorialCarreras.getValueAt(row, 0));
                frm.lblOrigen.setText((String) jTableHistorialCarreras.getValueAt(row, 1));
                frm.lblDestino.setText((String) jTableHistorialCarreras.getValueAt(row, 2));
                frm.lblMovil.setText(Integer.toString((int) jTableHistorialCarreras.getValueAt(row, 5)));
                frm.txtTelefono.setText((String) jTableHistorialCarreras.getValueAt(row, 0));
                frm.txtOrigen.setText((String) jTableHistorialCarreras.getValueAt(row, 1));
                frm.txtDestino.setText((String) jTableHistorialCarreras.getValueAt(row, 2));
                frm.txtMovil.setText(Integer.toString((int) jTableHistorialCarreras.getValueAt(row, 5)));
                frm.lblfechahora.setText((String) jTableHistorialCarreras.getValueAt(row, 8));
                frm.txtReferencia.setText((String) jTableHistorialCarreras.getValueAt(row, 3));
                frm.lblValor.setText(Float.toString((float) jTableHistorialCarreras.getValueAt(row, 4)));
                frm.txtValoor.setText(Float.toString((float) jTableHistorialCarreras.getValueAt(row, 4)));
                frm.lblNumeroSorteo.setText((String) jTableHistorialCarreras.getValueAt(row, 7));
                frm.show();
                this.dispose();
            }
        }
       }
    }//GEN-LAST:event_jTableHistorialCarrerasMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(HistorialCarreras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialCarreras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialCarreras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialCarreras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistorialCarreras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableHistorialCarreras;
    private javax.swing.JLabel lblMenuPrincipal;
    public static javax.swing.JTextField txtHistorialCarreraEstado;
    // End of variables declaration//GEN-END:variables
}
