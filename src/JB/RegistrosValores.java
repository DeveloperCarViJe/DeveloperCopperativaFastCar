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
public class RegistrosValores {
    private String lv_ORIGEN;
    private String lv_DESTINO;
    private float lf_VALOR;
    
    public RegistrosValores(String DESTINO, float VALOR){
        this.setLv_DESTINO(DESTINO);
        this.setLf_VALOR(VALOR);
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
}
