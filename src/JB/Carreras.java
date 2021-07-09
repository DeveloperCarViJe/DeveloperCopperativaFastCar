/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JB;

import java.util.Date;

/**
 *
 * @author Cardozo Villon
 */
public class Carreras {
    private String  lv_CLIENTE;      
    private String  lv_REFERENCIA;
    private String  lv_ORIGEN;       
    private String  lv_DESTINO;     
    private String  lv_TELEFONO;    
    private float   lf_VALOR;       
    private Integer ln_MOVIL;           
    private String  lv_RESERVA;
    private String lv_ESTADO_CARRERA;
    private String    lv_FECHA_HORA_REGISTRO;
    private String lv_FECHA_HORA_RESERVA;
    private String lv_USUARIO_ID;
    private String nombre_cliente;
    
    public Carreras(String nombre_cliente, String CLIENTE, String REFERENCIA, String ORIGEN, String DESTINO, String TELEFONO, float VALOR, Integer MOVIL, String RESERVA, String ESTADO_CARRERA, String FECHA_HORA_REGISTRO, String FECHA_HORA_RESERVA, String USUARIO_ID){
        this.setNombre_cliente(nombre_cliente);
        this.setLv_CLIENTE(CLIENTE);
        this.setLv_REFERENCIA(REFERENCIA);
        this.setLv_ORIGEN(ORIGEN);
        this.setLv_DESTINO(DESTINO);
        this.setLv_TELEFONO(TELEFONO);
        this.setLf_VALOR(VALOR);
        this.setLn_MOVIL(MOVIL);        
        this.setLv_RESERVA(RESERVA);
        this.setLv_ESTADO_CARRERA(ESTADO_CARRERA);
        this.setlv_FECHA_HORA_REGISTRO(FECHA_HORA_REGISTRO);
        this.setLv_FECHA_HORA_RESERVA(FECHA_HORA_RESERVA);
        this.setLv_USUARIO_ID(USUARIO_ID);
    }

    /**
     * @return the lv_CLIENTE
     */
    public String getLv_CLIENTE() {
        return lv_CLIENTE;
    }

    /**
     * @param lv_CLIENTE the lv_CLIENTE to set
     */
    public void setLv_CLIENTE(String lv_CLIENTE) {
        this.lv_CLIENTE = lv_CLIENTE;
    }

    /**
     * @return the lv_REFERENCIA
     */
    public String getLv_REFERENCIA() {
        return lv_REFERENCIA;
    }

    /**
     * @param lv_REFERENCIA the lv_REFERENCIA to set
     */
    public void setLv_REFERENCIA(String lv_REFERENCIA) {
        this.lv_REFERENCIA = lv_REFERENCIA;
    }

    /**
     * @return the lv_ORIGEN
     */
    public String getLv_ORIGEN() {
        return lv_ORIGEN;
    }

    /**
     * @param lv_ORIGEN the lv_ORIGEN to set
     */
    public void setLv_ORIGEN(String lv_ORIGEN) {
        this.lv_ORIGEN = lv_ORIGEN;
    }

    /**
     * @return the lv_DESTINO
     */
    public String getLv_DESTINO() {
        return lv_DESTINO;
    }

    /**
     * @param lv_DESTINO the lv_DESTINO to set
     */
    public void setLv_DESTINO(String lv_DESTINO) {
        this.lv_DESTINO = lv_DESTINO;
    }

    /**
     * @return the lv_TELEFONO
     */
    public String getLv_TELEFONO() {
        return lv_TELEFONO;
    }

    /**
     * @param lv_TELEFONO the lv_TELEFONO to set
     */
    public void setLv_TELEFONO(String lv_TELEFONO) {
        this.lv_TELEFONO = lv_TELEFONO;
    }

    /**
     * @return the lf_VALOR
     */
    public float getLf_VALOR() {
        return lf_VALOR;
    }

    /**
     * @param lf_VALOR the lf_VALOR to set
     */
    public void setLf_VALOR(float lf_VALOR) {
        this.lf_VALOR = lf_VALOR;
    }

    /**
     * @return the ln_MOVIL
     */
    public Integer getLn_MOVIL() {
        return ln_MOVIL;
    }

    /**
     * @param ln_MOVIL the ln_MOVIL to set
     */
    public void setLn_MOVIL(Integer ln_MOVIL) {
        this.ln_MOVIL = ln_MOVIL;
    }

    /**
     * @return the ld_FECHA_REGISTRO
     */
    public String getlv_FECHA_HORA_REGISTRO() {
        return lv_FECHA_HORA_REGISTRO;
    }

    /**
     * @param ld_FECHA_REGISTRO the ld_FECHA_REGISTRO to set
     */
    public void setlv_FECHA_HORA_REGISTRO(String ld_FECHA_REGISTRO) {
        this.lv_FECHA_HORA_REGISTRO = ld_FECHA_REGISTRO;
    }

    /**
     * @return the lv_RESERVA
     */
    public String getLv_RESERVA() {
        return lv_RESERVA;
    }

    /**
     * @param lv_RESERVA the lv_RESERVA to set
     */
    public void setLv_RESERVA(String lv_RESERVA) {
        this.lv_RESERVA = lv_RESERVA;
    }

    /**
     * @return the lv_ESTADO_CARRERA
     */
    public String getLv_ESTADO_CARRERA() {
        return lv_ESTADO_CARRERA;
    }

    /**
     * @param lv_ESTADO_CARRERA the lv_ESTADO_CARRERA to set
     */
    public void setLv_ESTADO_CARRERA(String lv_ESTADO_CARRERA) {
        this.lv_ESTADO_CARRERA = lv_ESTADO_CARRERA;
    }

    /**
     * @return the lv_FECHA_HORA_RESERVA
     */
    public String getLv_FECHA_HORA_RESERVA() {
        return lv_FECHA_HORA_RESERVA;
    }

    /**
     * @param lv_FECHA_HORA_RESERVA the lv_FECHA_HORA_RESERVA to set
     */
    public void setLv_FECHA_HORA_RESERVA(String lv_FECHA_HORA_RESERVA) {
        this.lv_FECHA_HORA_RESERVA = lv_FECHA_HORA_RESERVA;
    }

    /**
     * @return the lv_USUARIO_ID
     */
    public String getLv_USUARIO_ID() {
        return lv_USUARIO_ID;
    }

    /**
     * @param lv_USUARIO_ID the lv_USUARIO_ID to set
     */
    public void setLv_USUARIO_ID(String lv_USUARIO_ID) {
        this.lv_USUARIO_ID = lv_USUARIO_ID;
    }

    /**
     * @return the nombre_cliente
     */
    public String getNombre_cliente() {
        return nombre_cliente;
    }

    /**
     * @param nombre_cliente the nombre_cliente to set
     */
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }




}
