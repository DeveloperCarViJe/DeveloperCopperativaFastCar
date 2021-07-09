/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JB;

/**
 *
 * @author Cardozo Villon
 */
public class PagosDiarios {
    private Integer lv_MOVIL;
    private String lv_FECHA_REGISTRO;
    private float lv_VALOR;
    private String lv_USUARIO_ID;
    private String lv_obervacion;
    
    public PagosDiarios(int MOVIL, String FECHA_REGISTRO, float VALOR, String USUARIO_ID, String observacion){
        this.setLv_MOVIL(MOVIL);
        this.setLv_FECHA_REGISTRO(FECHA_REGISTRO);
        this.setLv_VALOR(VALOR);
        this.setLv_USUARIO_ID(USUARIO_ID);
        this.setLv_obervacion(observacion);
    }

    /**
     * @return the lv_MOVIL
     */
    public Integer getLv_MOVIL() {
        return lv_MOVIL;
    }

    /**
     * @param lv_MOVIL the lv_MOVIL to set
     */
    public void setLv_MOVIL(Integer lv_MOVIL) {
        this.lv_MOVIL = lv_MOVIL;
    }

    /**
     * @return the lv_FECHA_REGISTRO
     */
    public String getLv_FECHA_REGISTRO() {
        return lv_FECHA_REGISTRO;
    }

    /**
     * @param lv_FECHA_REGISTRO the lv_FECHA_REGISTRO to set
     */
    public void setLv_FECHA_REGISTRO(String lv_FECHA_REGISTRO) {
        this.lv_FECHA_REGISTRO = lv_FECHA_REGISTRO;
    }

    /**
     * @return the lv_VALOR
     */
    public float getLv_VALOR() {
        return lv_VALOR;
    }

    /**
     * @param lv_VALOR the lv_VALOR to set
     */
    public void setLv_VALOR(float lv_VALOR) {
        this.lv_VALOR = lv_VALOR;
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
     * @return the lv_obervacion
     */
    public String getLv_obervacion() {
        return lv_obervacion;
    }

    /**
     * @param lv_obervacion the lv_obervacion to set
     */
    public void setLv_obervacion(String lv_obervacion) {
        this.lv_obervacion = lv_obervacion;
    }
    
}
