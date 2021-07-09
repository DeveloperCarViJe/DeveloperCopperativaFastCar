/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BO.CarrerasBo;
import BO.ChoferesBo;
import BO.ClientesBo;
import BO.DetallesPromocionesBo;
import BO.PagosDiariosBo;
import BO.PromocionesBo;
import BO.RegistroValoresBo;
import JB.Carreras;
import JB.Choferes;
import JB.Clientes;
import JB.DetallesPromociones;
import JB.Promociones;
import JB.RegistrosValores;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Cardozo Villon
 */
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Image;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import static javax.management.Query.gt;
import static javax.management.Query.lt;
import javax.swing.ImageIcon;
public class IngresoCarrerasRegalos extends javax.swing.JFrame {

    /**
     * Creates new form IngresoCarreras
     */
    public IngresoCarrerasRegalos() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/IMAGENES/icono.png")).getImage());
        setTitle("INGRESO CARRERAS");
        setDefaultCloseOperation(0);
        //txtMovil.setEditable(false);
        btnRegistrar.setEnabled(false);
        lblEstadoCarrera.setVisible(false);
        lblCedulaUsuario.setVisible(false);
        //txtIngresoCarreraEstado.setVisible(false);
        itemDireccion();
        itemDestino();
        IniciarPromociones();
        String NuevaHora=null;
        String NuevoMinuto=null;
        for(int i=0;i<24;i++){
            int length = String.valueOf(i).length();
                if (length == 1){
                    NuevaHora="0"+i;
                }else{
                    NuevaHora=String.valueOf(i);
                }
                    cmbHora.addItem(NuevaHora);
            }
        for(int i=0;i<60;i++){
               int length = String.valueOf(i).length();
                if (length == 1){
                    NuevoMinuto="0"+i;
                }else{
                    NuevoMinuto=String.valueOf(i);
                }
                    cmbMinutos.addItem(NuevoMinuto);
            }
        
        ImageIcon fastcar = new ImageIcon(getClass().getResource("/IMAGENES/fondo.jpeg"));
        ImageIcon icon = new ImageIcon(fastcar.getImage().getScaledInstance(lblfondoPanelCliente.getWidth(), lblfondoPanelCliente.getHeight(), Image.SCALE_DEFAULT));
        lblfondoPanelCliente.setIcon(icon);
        
        fastcar = new ImageIcon(getClass().getResource("/IMAGENES/fondo.jpeg"));
        icon = new ImageIcon(fastcar.getImage().getScaledInstance(lblfondoPanelChoferes.getWidth(), lblfondoPanelChoferes.getHeight(), Image.SCALE_DEFAULT));
        lblfondoPanelChoferes.setIcon(icon);
        
        fastcar = new ImageIcon(getClass().getResource("/IMAGENES/fondo.jpeg"));
        icon = new ImageIcon(fastcar.getImage().getScaledInstance(lblfondoPanelReservar.getWidth(), lblfondoPanelReservar.getHeight(), Image.SCALE_DEFAULT));
        lblfondoPanelReservar.setIcon(icon);
        
        fastcar = new ImageIcon(getClass().getResource("/IMAGENES/fondo.jpeg"));
        icon = new ImageIcon(fastcar.getImage().getScaledInstance(lblFondoFrame.getWidth(), lblFondoFrame.getHeight(), Image.SCALE_DEFAULT));
        lblFondoFrame.setIcon(icon);
    }
    
    public void itemDireccion(){

    }
    
    public void itemDestino(){
        try {
            TextAutoCompleter autocompleter = new TextAutoCompleter(txtDestino);
            RegistroValoresBo bo= new RegistroValoresBo();
            Vector v1 = bo.ObtenerDestinoValores();
            for(int i=0;i<v1.size();i++){
                RegistrosValores rv = (RegistrosValores)v1.get(i);
                autocompleter.addItem(rv.getLv_DESTINO());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void IniciarPromociones(){
        try {
            int n=0;
            PromocionesBo bo = new PromocionesBo();
            n=bo.ValidarPromociones();
            if(n==0){
                lblPromociones.setVisible(false);
                rbtPromocionSi.setVisible(false);
                rbtPromocionNo.setVisible(false);
            }else{
                rbtPromocionSi.setSelected(true);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
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

        btngpromociones = new javax.swing.ButtonGroup();
        lblIngresoCarrera = new javax.swing.JLabel();
        jPanelDatosCliente = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblReferencia = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        lblDestino = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        txtValoor = new javax.swing.JTextField();
        rbtPromocionSi = new javax.swing.JRadioButton();
        rbtPromocionNo = new javax.swing.JRadioButton();
        lblPromociones = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        lblfondoPanelCliente = new javax.swing.JLabel();
        jPanelDatosChofer = new javax.swing.JPanel();
        lblMovil = new javax.swing.JLabel();
        txtMovil = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        lblPlaca = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        lblfondoPanelChoferes = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jPanelDatosCliente1 = new javax.swing.JPanel();
        lblFechaReservacion = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox();
        jDateFecha = new com.toedter.calendar.JDateChooser();
        lblMinuto = new javax.swing.JLabel();
        cmbMinutos = new javax.swing.JComboBox();
        lblfondoPanelReservar = new javax.swing.JLabel();
        btnReservar = new javax.swing.JButton();
        lblIngresoCarrera1 = new javax.swing.JLabel();
        lblIngresoCarrera2 = new javax.swing.JLabel();
        lblIngresoCarrera3 = new javax.swing.JLabel();
        lblEstadoCarrera = new javax.swing.JLabel();
        lblCedulaUsuario = new javax.swing.JLabel();
        lblFondoFrame = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frmIngresoCarreras"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblIngresoCarrera.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblIngresoCarrera.setForeground(new java.awt.Color(255, 255, 255));
        lblIngresoCarrera.setText("SISTEMA FASTCAR - INGRESO CARRERA");

        jPanelDatosCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblCliente.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCliente.setText("CLIENTE");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("TELEFONO");

        lblDireccion.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion.setText("DIRECCION");

        lblReferencia.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblReferencia.setForeground(new java.awt.Color(255, 255, 255));
        lblReferencia.setText("REFERENCIA");

        txtReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReferenciaActionPerformed(evt);
            }
        });

        lblDestino.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblDestino.setForeground(new java.awt.Color(255, 255, 255));
        lblDestino.setText("DESTINO");

        txtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinoActionPerformed(evt);
            }
        });

        lblValor.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblValor.setForeground(new java.awt.Color(255, 255, 255));
        lblValor.setText("VALOR");

        txtValoor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValoorKeyTyped(evt);
            }
        });

        btngpromociones.add(rbtPromocionSi);
        rbtPromocionSi.setText("SI");
        rbtPromocionSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtPromocionSiMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtPromocionSiMousePressed(evt);
            }
        });

        btngpromociones.add(rbtPromocionNo);
        rbtPromocionNo.setText("NO");
        rbtPromocionNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtPromocionNoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtPromocionNoMousePressed(evt);
            }
        });
        rbtPromocionNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtPromocionNoActionPerformed(evt);
            }
        });

        lblPromociones.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblPromociones.setForeground(new java.awt.Color(255, 255, 255));
        lblPromociones.setText("APLICAR PROMOCION");

        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });
        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosClienteLayout = new javax.swing.GroupLayout(jPanelDatosCliente);
        jPanelDatosCliente.setLayout(jPanelDatosClienteLayout);
        jPanelDatosClienteLayout.setHorizontalGroup(
            jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                        .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtReferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(txtDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombreCliente))
                            .addComponent(txtValoor, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(lblPromociones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtPromocionSi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtPromocionNo)
                        .addContainerGap(133, Short.MAX_VALUE))))
            .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblfondoPanelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
        );
        jPanelDatosClienteLayout.setVerticalGroup(
            jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReferencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValoor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtPromocionSi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtPromocionNo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPromociones, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblfondoPanelCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
        );

        jPanelDatosChofer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMovil.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblMovil.setForeground(new java.awt.Color(255, 255, 255));
        lblMovil.setText("MOVIL");

        txtMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMovilActionPerformed(evt);
            }
        });
        txtMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMovilKeyTyped(evt);
            }
        });

        lblColor.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblColor.setForeground(new java.awt.Color(255, 255, 255));
        lblColor.setText("COLOR");

        txtColor.setEditable(false);

        lblPlaca.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblPlaca.setForeground(new java.awt.Color(255, 255, 255));
        lblPlaca.setText("PLACA");

        txtPlaca.setEditable(false);

        lblModelo.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblModelo.setForeground(new java.awt.Color(255, 255, 255));
        lblModelo.setText("MODELO");

        txtModelo.setEditable(false);

        javax.swing.GroupLayout jPanelDatosChoferLayout = new javax.swing.GroupLayout(jPanelDatosChofer);
        jPanelDatosChofer.setLayout(jPanelDatosChoferLayout);
        jPanelDatosChoferLayout.setHorizontalGroup(
            jPanelDatosChoferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosChoferLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosChoferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblColor)
                    .addComponent(lblMovil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosChoferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtColor)
                    .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosChoferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlaca)
                    .addComponent(lblModelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosChoferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(jPanelDatosChoferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblfondoPanelChoferes, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
        );
        jPanelDatosChoferLayout.setVerticalGroup(
            jPanelDatosChoferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosChoferLayout.createSequentialGroup()
                .addGroup(jPanelDatosChoferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosChoferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanelDatosChoferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblfondoPanelChoferes, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
        );

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setText("LIMPIAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jPanelDatosCliente1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblFechaReservacion.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblFechaReservacion.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaReservacion.setText("FECHA RESERVACION");

        lblHora.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("HORA");

        cmbHora.setToolTipText("");

        lblMinuto.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        lblMinuto.setForeground(new java.awt.Color(255, 255, 255));
        lblMinuto.setText("MINUTOS");

        cmbMinutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMinutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosCliente1Layout = new javax.swing.GroupLayout(jPanelDatosCliente1);
        jPanelDatosCliente1.setLayout(jPanelDatosCliente1Layout);
        jPanelDatosCliente1Layout.setHorizontalGroup(
            jPanelDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosCliente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosCliente1Layout.createSequentialGroup()
                        .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosCliente1Layout.createSequentialGroup()
                        .addComponent(lblFechaReservacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(jPanelDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblfondoPanelReservar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
        );
        jPanelDatosCliente1Layout.setVerticalGroup(
            jPanelDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosCliente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblfondoPanelReservar, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
        );

        btnReservar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReservar.setText("RESERVAR");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        lblIngresoCarrera1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblIngresoCarrera1.setForeground(new java.awt.Color(255, 255, 255));
        lblIngresoCarrera1.setText("DATOS CLIENTE");

        lblIngresoCarrera2.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblIngresoCarrera2.setForeground(new java.awt.Color(255, 255, 255));
        lblIngresoCarrera2.setText("DATOS CHOFER");

        lblIngresoCarrera3.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblIngresoCarrera3.setForeground(new java.awt.Color(255, 255, 255));
        lblIngresoCarrera3.setText("DATOS RESERVAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnRegistrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRegresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReservar))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanelDatosCliente1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanelDatosChofer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIngresoCarrera3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblEstadoCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblIngresoCarrera1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblIngresoCarrera2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIngresoCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(195, 195, 195)
                    .addComponent(lblCedulaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(219, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblFondoFrame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEstadoCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIngresoCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIngresoCarrera1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblIngresoCarrera2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDatosChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblIngresoCarrera3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDatosCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnRegresar)
                    .addComponent(btnReservar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(289, 289, 289)
                    .addComponent(lblCedulaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(290, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblFondoFrame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReferenciaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        
        txtTelefono.setText(null);
        txtNombreCliente.setText(null);
        txtDireccion.setText(null);
        txtReferencia.setText(null);
        txtDestino.setText(null);
        txtValoor.setText(null);
        txtMovil.setText(null);
        txtColor.setText(null);
        txtPlaca.setText(null);
        txtModelo.setText(null);
        jDateFecha.setToolTipText(null);

        
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        try {
            int n=0;
            ClientesBo bo= new ClientesBo();
            n = bo.VerificarClientes(txtTelefono.getText());
            if(n==1){
                CarrerasBo cbo = new CarrerasBo();
                Vector v1 = cbo.ObtenerDatosClientes(txtTelefono.getText());
                if(v1.size()>0){
                        txtNombreCliente.setText((String)v1.get(0));
                        txtDireccion.setText((String)v1.get(1));
                        txtReferencia.setText((String)v1.get(2));
                        txtDestino.setText((String)v1.get(3));
                        txtValoor.setText(String.valueOf((float)v1.get(4)));
                        //txtMovil.setEditable(true);
                }else{
                JOptionPane.showMessageDialog(null, "NO EXISTEN DATOS DEL CLIENTE: "+txtTelefono.getText(), "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);
                txtNombreCliente.setEditable(true);
                txtMovil.setEditable(true);
            }
                        
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTEN DATOS DEL CLIENTE: "+txtTelefono.getText(), "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);
                txtNombreCliente.setEditable(true);
                txtMovil.setEditable(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinoActionPerformed
        try {
        if(txtDestino.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "El CAMPO DESTINO ES OBLIGATORIOS", "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);
        }else{
                float valorCarrera=0;
                RegistroValoresBo bo= new RegistroValoresBo();
                valorCarrera = bo.ObtenerRegistroValor(txtDestino.getText());
                if(valorCarrera==0){
                    JOptionPane.showMessageDialog(null, "NO EXISTE VALOR PARA EL DESTINO "+txtDestino.getText()+", FAVOR INGRESAR EL VALOR", "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);
                    txtValoor.setText(null);
                }else{
                    txtValoor.setText(String.valueOf(valorCarrera));
                }
        }     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_txtDestinoActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        
        char car = evt.getKeyChar();
        if((car<'0' || car>'9' || txtTelefono.getText().length()>=10)) evt.consume();
        
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtValoorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValoorKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')&&(car!='.')) evt.consume();
    }//GEN-LAST:event_txtValoorKeyTyped

    private void txtMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMovilActionPerformed
        try {
            int n=0;
            int pagoDiario=0;
            String estado=null;
            int movil=Integer.parseInt(txtMovil.getText());
            ChoferesBo bo = new ChoferesBo();
            n=bo.ValidarChoferesRegistrados(movil);
            if(n==0){
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA REGISTRADO EL MOVIL "+movil, "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);
            }else{
                estado=bo.EstadoMovil(movil);
                PagosDiariosBo pbo = new PagosDiariosBo();
                pagoDiario=pbo.ValidarPagoChofer(movil);
                if(pagoDiario>0 || Integer.parseInt(txtMovil.getText()) == 20 || Integer.parseInt(txtMovil.getText()) == 37 || estado.equals("A")){
                    Vector v1 = bo.ObtenerDatosChoferes(Integer.parseInt(txtMovil.getText()));
                    for(int i=0;i<v1.size();i++){
                        Choferes ch = (Choferes)v1.get(i);
                        txtColor.setText(ch.getLV_COLOR_VEHICULO());
                        txtPlaca.setText(ch.getLV_PLACA());
                        txtModelo.setText(ch.getLV_MODELO());
                        btnRegistrar.setEnabled(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE ASIGNAR EL MOVIL "+movil+" , DEBIDO QUE ESTA ATRASADO CON SU PAGO", "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtMovilActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if((txtNombreCliente.getText().isEmpty() && txtDireccion.getText().isEmpty() &&txtReferencia.getText().isEmpty() && txtDestino.getText().isEmpty() && txtValoor.getText().isEmpty()) ||(txtNombreCliente.getText().equals("") && txtDireccion.getText().equals("") &&txtReferencia.getText().equals("") && txtDestino.getText().equals("") && txtValoor.getText().equals(""))){
            JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS SON OBLIGATORIOS", "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                int n=0;
                int ingresoClientes=0;
                int ingreso_carreras=0;
                int ingresoRegistro=0;
                int idPromociones=0;
                int ingresoDetalesPromociones=0;
                int numeroSorteo=0;
                int numeroSorteoCliente=0;
                int obtenerIdCarrera=0;
                int obtenerIdCarreraNuevo=0;
                ClientesBo bo= new ClientesBo();
                n = bo.VerificarClientes(txtTelefono.getText());
                if(n==1){
                    //Obtener el ultimo ID de la tabla carreras
                    CarrerasBo cbo = new CarrerasBo();
                    obtenerIdCarrera = cbo.ObtenerIdCarrera();
                    obtenerIdCarreraNuevo = obtenerIdCarrera + 1;
                        Date myDate = new Date();
                        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String FechaHoraRegistro = mdyFormat.format(myDate);
                        String NombreCliente=txtNombreCliente.getText();
                        Carreras car = new Carreras(null,NombreCliente,txtReferencia.getText(),txtDireccion.getText(),txtDestino.getText(),txtTelefono.getText(),Float.parseFloat(txtValoor.getText()),null,null,"NA",FechaHoraRegistro,null,lblCedulaUsuario.getText());
                        ingreso_carreras=cbo.RegistrarClientes(car,Integer.parseInt(txtMovil.getText()),obtenerIdCarreraNuevo);
                        if(ingreso_carreras>0){
                            
                            /*RegistroValoresBo bo2 = new RegistroValoresBo();
                            n=bo2.ValidarRegistroDiario(txtDestino.getText());
                            if(n==0){
                                RegistrosValores in = new RegistrosValores(txtDestino.getText(),Float.parseFloat(txtValoor.getText()));
                                ingresoRegistro=bo2.RegistrarRegistrodiarios(in);
                            }*/
                            if(rbtPromocionSi.isSelected()){
                            PromocionesBo bo3 = new PromocionesBo();
                            idPromociones=bo3.ObtenerIdPromociones();
                                DetallesPromocionesBo bopro = new DetallesPromocionesBo();
                                numeroSorteo=bopro.ObtenerNumerosorteo(idPromociones);
                                    if(numeroSorteo==0){
                                        numeroSorteoCliente=1000;
                                    }else{
                                        numeroSorteoCliente = numeroSorteo + 1;
                                    }
                                    
                                        DetallesPromociones inpro = new DetallesPromociones(txtTelefono.getText(),numeroSorteoCliente);
                                        ingresoDetalesPromociones=bopro.InsertarDetallePromocion(inpro, Integer.parseInt(txtMovil.getText()), idPromociones,obtenerIdCarreraNuevo);
                            }
                                    //Envio para imprimir
                            if(numeroSorteoCliente==0){
                                    ImpresionCarrera frm = new ImpresionCarrera();
                                    frm.txtCliente.setText(NombreCliente.toLowerCase());
                                    frm.txtTelefono.setText(this.txtTelefono.getText());
                                    frm.txtDireccion.setText(this.txtDireccion.getText().toLowerCase());
                                    frm.txtRefrencia.setText(this.txtReferencia.getText().toLowerCase());
                                    frm.txtDestino.setText(this.txtDestino.getText().toLowerCase());
                                    frm.txtValor.setText(this.txtValoor.getText());
                                    frm.txtMovil.setText(this.txtMovil.getText());
                                    frm.txtFecha.setText(FechaHoraRegistro);
                                    frm.lblEstadoImpresion.setText(lblEstadoCarrera.getText());
                                    frm.lblCedulaUsuario.setText(this.lblCedulaUsuario.getText());
                                    
                                            txtTelefono.setText(null);
                                            txtNombreCliente.setText(null);
                                            txtDireccion.setText(null);
                                            txtReferencia.setText(null);
                                            txtDestino.setText(null);
                                            txtValoor.setText(null);
                                            txtMovil.setText(null);
                                            txtColor.setText(null);
                                            txtPlaca.setText(null);
                                            txtModelo.setText(null);
                                    frm.show();
                                    this.dispose();
                            }else{
                                ImpresionCarreraPromociones frm = new ImpresionCarreraPromociones();
                                    frm.txtCliente.setText(NombreCliente.toLowerCase());
                                    frm.txtTelefono.setText(this.txtTelefono.getText());
                                    frm.txtDireccion.setText(this.txtDireccion.getText().toLowerCase());
                                    frm.txtRefrencia.setText(this.txtReferencia.getText().toLowerCase());
                                    frm.txtDestino.setText(this.txtDestino.getText().toLowerCase());
                                    frm.txtValor.setText(this.txtValoor.getText());
                                    frm.txtMovil.setText(this.txtMovil.getText());
                                    frm.txtFecha.setText(FechaHoraRegistro);
                                    frm.lblEstadoImpresion.setText(lblEstadoCarrera.getText());
                                    frm.lblCedulaUsuario.setText(this.lblCedulaUsuario.getText());
                                    frm.txtNumero.setText(String.valueOf(numeroSorteoCliente));
                                    
                                            txtTelefono.setText(null);
                                            txtNombreCliente.setText(null);
                                            txtDireccion.setText(null);
                                            txtReferencia.setText(null);
                                            txtDestino.setText(null);
                                            txtValoor.setText(null);
                                            txtMovil.setText(null);
                                            txtColor.setText(null);
                                            txtPlaca.setText(null);
                                            txtModelo.setText(null);
                                    frm.show();
                                    this.dispose();
                            }

                                    //Limpiar los botones
                                            
                                    
                        }
                }else{
                    Clientes cli = new Clientes(txtNombreCliente.getText(),txtDireccion.getText(),txtTelefono.getText());
                    ingresoClientes=bo.RegistrarClientes(cli);
                    if(ingresoClientes>0){
                        CarrerasBo cbo = new CarrerasBo();
                        obtenerIdCarrera = cbo.ObtenerIdCarrera();
                        obtenerIdCarreraNuevo = obtenerIdCarrera + 1;
                        Date myDate = new Date();
                        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String FechaHoraRegistro = mdyFormat.format(myDate);
                        String NombreCliente=txtNombreCliente.getText();
                        Carreras car = new Carreras(null,NombreCliente,txtReferencia.getText(),txtDireccion.getText(),txtDestino.getText(),txtTelefono.getText(),Float.parseFloat(txtValoor.getText()),null,null,"NA",FechaHoraRegistro,null,lblCedulaUsuario.getText());
                        ingreso_carreras=cbo.RegistrarClientes(car,Integer.parseInt(txtMovil.getText()),obtenerIdCarreraNuevo);
                        if(ingreso_carreras>0){
                            
                            /*RegistroValoresBo bo2 = new RegistroValoresBo();
                            n=bo2.ValidarRegistroDiario(txtDestino.getText());
                            if(n==0){
                                RegistrosValores in = new RegistrosValores(txtDestino.getText(),Float.parseFloat(txtValoor.getText()));
                                ingresoRegistro=bo2.RegistrarRegistrodiarios(in);
                            }*/
                            if(rbtPromocionSi.isSelected()){
                            PromocionesBo bo3 = new PromocionesBo();
                            idPromociones=bo3.ObtenerIdPromociones();
                                DetallesPromocionesBo bopro = new DetallesPromocionesBo();
                                numeroSorteo=bopro.ObtenerNumerosorteo(idPromociones);
                                    if(numeroSorteo==0){
                                        numeroSorteoCliente=1000;
                                    }else{
                                        numeroSorteoCliente = numeroSorteo + 1;
                                    }
                                    
                                        DetallesPromociones inpro = new DetallesPromociones(txtTelefono.getText(),numeroSorteoCliente);
                                        ingresoDetalesPromociones=bopro.InsertarDetallePromocion(inpro, Integer.parseInt(txtMovil.getText()), idPromociones,obtenerIdCarreraNuevo);
                                    }
                                    if(numeroSorteoCliente==0){
                                    ImpresionCarrera frm = new ImpresionCarrera();
                                    frm.txtCliente.setText(NombreCliente);
                                    frm.txtTelefono.setText(this.txtTelefono.getText());
                                    frm.txtDireccion.setText(this.txtDireccion.getText());
                                    frm.txtRefrencia.setText(this.txtReferencia.getText());
                                    frm.txtDestino.setText(this.txtDestino.getText());
                                    frm.txtValor.setText(this.txtValoor.getText());
                                    frm.txtMovil.setText(this.txtMovil.getText());
                                    frm.txtFecha.setText(FechaHoraRegistro);
                                    frm.lblEstadoImpresion.setText(lblEstadoCarrera.getText());
                                    frm.lblCedulaUsuario.setText(this.lblCedulaUsuario.getText());
                                    
                                            txtTelefono.setText(null);
                                            txtNombreCliente.setText(null);
                                            txtDireccion.setText(null);
                                            txtReferencia.setText(null);
                                            txtDestino.setText(null);
                                            txtValoor.setText(null);
                                            txtMovil.setText(null);
                                            txtColor.setText(null);
                                            txtPlaca.setText(null);
                                            txtModelo.setText(null);
                                    frm.show();
                                    this.dispose();
                            }else{
                                ImpresionCarreraPromociones frm = new ImpresionCarreraPromociones();
                                    frm.txtCliente.setText(NombreCliente);
                                    frm.txtTelefono.setText(this.txtTelefono.getText());
                                    frm.txtDireccion.setText(this.txtDireccion.getText());
                                    frm.txtRefrencia.setText(this.txtReferencia.getText());
                                    frm.txtDestino.setText(this.txtDestino.getText());
                                    frm.txtValor.setText(this.txtValoor.getText());
                                    frm.txtMovil.setText(this.txtMovil.getText());
                                    frm.txtFecha.setText(FechaHoraRegistro);
                                    frm.lblEstadoImpresion.setText(lblEstadoCarrera.getText());
                                    frm.lblCedulaUsuario.setText(this.lblCedulaUsuario.getText());
                                    frm.txtNumero.setText(String.valueOf(numeroSorteoCliente));
                                    
                                            txtTelefono.setText(null);
                                            txtNombreCliente.setText(null);
                                            txtDireccion.setText(null);
                                            txtReferencia.setText(null);
                                            txtDestino.setText(null);
                                            txtValoor.setText(null);
                                            txtMovil.setText(null);
                                            txtColor.setText(null);
                                            txtPlaca.setText(null);
                                            txtModelo.setText(null);
                                    frm.show();
                                    this.dispose();
                            }
                        }
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void rbtPromocionSiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtPromocionSiMouseClicked
        // TODO add your handling code here
    }//GEN-LAST:event_rbtPromocionSiMouseClicked

    private void rbtPromocionSiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtPromocionSiMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtPromocionSiMousePressed

    private void rbtPromocionNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtPromocionNoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtPromocionNoMouseClicked

    private void rbtPromocionNoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtPromocionNoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtPromocionNoMousePressed

    private void rbtPromocionNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtPromocionNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtPromocionNoActionPerformed

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void txtNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyTyped
        // TODO add your handling code here:
       char car = evt.getKeyChar();
        if((car<'a' || car>'z')&&(car<'A' || car>'Z') && (car !=' ')) evt.consume();
    }//GEN-LAST:event_txtNombreClienteKeyTyped

    private void cmbMinutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMinutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMinutosActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        if((txtNombreCliente.getText().isEmpty() && txtDireccion.getText().isEmpty() &&txtReferencia.getText().isEmpty() && txtDestino.getText().isEmpty() && txtValoor.getText().isEmpty()) ||(txtNombreCliente.getText().equals("") && txtDireccion.getText().equals("") &&txtReferencia.getText().equals("") && txtDestino.getText().equals("") && txtValoor.getText().equals(""))){
            JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS SON OBLIGATORIOS", "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);
        }else{
            if(jDateFecha.getDate()==null && cmbHora.getSelectedIndex()==0 && cmbMinutos.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR LOS DATOS PARA LA RESERVACION FECHA Y HORA", "MENSAJE ALERTA", JOptionPane.ERROR_MESSAGE);
        }else{
                    try {
                        int n=0;
                        int reservarControl=0;
                        int ingresoClientes=0;
                        int ingreso_carreras=0;
                        int ingresoRegistro=0;
                        int idPromociones=0;
                        int ingresoDetalesPromociones=0;
                        int numeroSorteo=0;
                        int numeroSorteoCliente=0;
                        int obtenerIdCarrera=0;
                        int obtenerIdCarreraNuevo=0;
                        ClientesBo bo= new ClientesBo();
                        n = bo.VerificarClientes(txtTelefono.getText());
                        if(n==1){
                            CarrerasBo cbo = new CarrerasBo();
                            obtenerIdCarrera = cbo.ObtenerIdCarrera();
                            obtenerIdCarreraNuevo = obtenerIdCarrera + 1;
                                Date myDate = new Date();
                                SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                String FechaHoraRegistro = mdyFormat.format(myDate);
                                //obtener la fecha y hora de reservacion
                                String diaf=null;
                                String mesf=null;
                                String dia = Integer.toString(jDateFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
                                String mes = Integer.toString(jDateFecha.getCalendar().get(Calendar.MONTH)+ 1);
                                String year = Integer.toString(jDateFecha.getCalendar().get(Calendar.YEAR));
                                if(dia.length()==1){
                                    diaf="0"+dia;
                                    
                                }else{
                                    diaf=dia;
                                }
                                if (mes.length()==1){
                                    mesf="0"+mes;
                                }else{
                                    
                                    mesf=mes;
                                }
                                String fecha = (diaf + "/" + mesf+ "/" + year);
                                String Hora = (String) cmbHora.getSelectedItem();
                                String Minuto = (String) cmbMinutos.getSelectedItem();
                                String Fecha_hora_reservacion=fecha+" "+Hora+":"+Minuto+":"+"00";

                                String NombreCliente=txtNombreCliente.getText();
                                Carreras car = new Carreras(null,NombreCliente,txtReferencia.getText(),txtDireccion.getText(),txtDestino.getText(),txtTelefono.getText(),Float.parseFloat(txtValoor.getText()),null,"A","NA",FechaHoraRegistro,Fecha_hora_reservacion,lblCedulaUsuario.getText());
                                ingreso_carreras=cbo.RegistrarClientes(car,reservarControl,obtenerIdCarreraNuevo);
                                if(ingreso_carreras>0){

                                   /* RegistroValoresBo bo2 = new RegistroValoresBo();
                                    n=bo2.ValidarRegistroDiario(txtDestino.getText());
                                    if(n==0){
                                        RegistrosValores in = new RegistrosValores(txtDestino.getText(),Float.parseFloat(txtValoor.getText()));
                                        ingresoRegistro=bo2.RegistrarRegistrodiarios(in);
                                    }*/
                                    if(rbtPromocionSi.isSelected()){
                                    PromocionesBo bo3 = new PromocionesBo();
                                    idPromociones=bo3.ObtenerIdPromociones();
                                        DetallesPromocionesBo bopro = new DetallesPromocionesBo();
                                        numeroSorteo=bopro.ObtenerNumerosorteo(idPromociones);
                                            if(numeroSorteo==0){
                                                numeroSorteoCliente=1000;
                                            }else{
                                                numeroSorteoCliente = numeroSorteo + 1;
                                            }

                                                DetallesPromociones inpro = new DetallesPromociones(txtTelefono.getText(),numeroSorteoCliente);
                                                ingresoDetalesPromociones=bopro.InsertarDetallePromocion(inpro, reservarControl, idPromociones,obtenerIdCarreraNuevo);
                                    }
                                            JOptionPane.showMessageDialog(rootPane,"SE INGRESO CORRECTAMENTE");
                                                    txtTelefono.setText(null);
                                                    txtNombreCliente.setText(null);
                                                    txtDireccion.setText(null);
                                                    txtReferencia.setText(null);
                                                    txtDestino.setText(null);
                                                    txtValoor.setText(null);
                                                    txtMovil.setText(null);
                                                    txtColor.setText(null);
                                                    txtPlaca.setText(null);
                                                    txtModelo.setText(null);
                                                            

                                }
                        }else{
                            Clientes cli = new Clientes(txtNombreCliente.getText(),txtDireccion.getText(),txtTelefono.getText());
                            ingresoClientes=bo.RegistrarClientes(cli);
                            if(ingresoClientes>0){
                                CarrerasBo cbo = new CarrerasBo();
                                obtenerIdCarrera = cbo.ObtenerIdCarrera();
                                obtenerIdCarreraNuevo = obtenerIdCarrera + 1;
                                Date myDate = new Date();
                                SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                String FechaHoraRegistro = mdyFormat.format(myDate);
                                //obtener la fecha y hora de reservacion
                                String diaf=null;
                                String mesf=null;
                                String dia = Integer.toString(jDateFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
                                String mes = Integer.toString(jDateFecha.getCalendar().get(Calendar.MONTH)+ 1);
                                String year = Integer.toString(jDateFecha.getCalendar().get(Calendar.YEAR));
                                if(dia.length()==1 && mes.length()==1){
                                    diaf="0"+dia;
                                    mesf="0"+mes;
                                }else{
                                    diaf=dia;
                                    mesf=mes;
                                }
                                String fecha = (diaf + "/" + mesf+ "/" + year);
                                String Hora = (String) cmbHora.getSelectedItem();
                                String Minuto = (String) cmbMinutos.getSelectedItem();
                                String Fecha_hora_reservacion=fecha+" "+Hora+":"+Minuto+":"+"00";
                                String NombreCliente=txtNombreCliente.getText();
                                Carreras car = new Carreras(null,NombreCliente,txtReferencia.getText(),txtDireccion.getText(),txtDestino.getText(),txtTelefono.getText(),Float.parseFloat(txtValoor.getText()),null,"A","NA",FechaHoraRegistro,Fecha_hora_reservacion,lblCedulaUsuario.getText());
                                ingreso_carreras=cbo.RegistrarClientes(car,reservarControl,obtenerIdCarreraNuevo);
                                if(ingreso_carreras>0){

                                    /*RegistroValoresBo bo2 = new RegistroValoresBo();
                                    n=bo2.ValidarRegistroDiario(txtDestino.getText());
                                    if(n==0){
                                        RegistrosValores in = new RegistrosValores(txtDestino.getText(),Float.parseFloat(txtValoor.getText()));
                                        ingresoRegistro=bo2.RegistrarRegistrodiarios(in);
                                    }*/
                                    if(rbtPromocionSi.isSelected()){
                                    PromocionesBo bo3 = new PromocionesBo();
                                    idPromociones=bo3.ObtenerIdPromociones();
                                        DetallesPromocionesBo bopro = new DetallesPromocionesBo();
                                        numeroSorteo=bopro.ObtenerNumerosorteo(idPromociones);
                                            if(numeroSorteo==0){
                                                numeroSorteoCliente=1000;
                                            }else{
                                                numeroSorteoCliente = numeroSorteo + 1;
                                            }

                                                DetallesPromociones inpro = new DetallesPromociones(txtTelefono.getText(),numeroSorteoCliente);
                                                ingresoDetalesPromociones=bopro.InsertarDetallePromocion(inpro, reservarControl, idPromociones,obtenerIdCarreraNuevo);
                                            }
                                            JOptionPane.showMessageDialog(rootPane,"SE INGRESO CORRECTAMENTE");
                                            txtTelefono.setText(null);
                                            txtNombreCliente.setText(null);
                                            txtDireccion.setText(null);
                                            txtReferencia.setText(null);
                                            txtDestino.setText(null);
                                            txtValoor.setText(null);
                                            txtMovil.setText(null);
                                            txtColor.setText(null);
                                            txtPlaca.setText(null);
                                            txtModelo.setText(null);
                                            
                                }
                            }
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
    }//GEN-LAST:event_btnReservarActionPerformed

    private void txtMovilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMovilKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();

    }//GEN-LAST:event_txtMovilKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        //MenuPrincipalAdmin.TstVentCarrera=true;
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoCarrerasRegalos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoCarrerasRegalos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnReservar;
    private javax.swing.ButtonGroup btngpromociones;
    private javax.swing.JComboBox cmbHora;
    private javax.swing.JComboBox cmbMinutos;
    private com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JPanel jPanelDatosChofer;
    private javax.swing.JPanel jPanelDatosCliente;
    private javax.swing.JPanel jPanelDatosCliente1;
    public static javax.swing.JLabel lblCedulaUsuario;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblDireccion;
    public static javax.swing.JLabel lblEstadoCarrera;
    private javax.swing.JLabel lblFechaReservacion;
    private javax.swing.JLabel lblFondoFrame;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblIngresoCarrera;
    private javax.swing.JLabel lblIngresoCarrera1;
    private javax.swing.JLabel lblIngresoCarrera2;
    private javax.swing.JLabel lblIngresoCarrera3;
    private javax.swing.JLabel lblMinuto;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblMovil;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblPromociones;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblfondoPanelChoferes;
    private javax.swing.JLabel lblfondoPanelCliente;
    private javax.swing.JLabel lblfondoPanelReservar;
    private javax.swing.JRadioButton rbtPromocionNo;
    private javax.swing.JRadioButton rbtPromocionSi;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMovil;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtValoor;
    // End of variables declaration//GEN-END:variables
}
