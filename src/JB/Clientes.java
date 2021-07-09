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
public class Clientes {
    private String lv_NOMBRES;
    private String lv_DIRECCION;
    private String lv_TELEFONO;
    
    public Clientes( String NOMBRES, String DIRECCION, String TELEFONO){
        this.setLv_NOMBRES(NOMBRES);
        this.setLv_DIRECCION(DIRECCION);
        this.setLv_TELEFONO(TELEFONO);
    }

    /**
     * @return the lv_NOMBRES
     */
    public String getLv_NOMBRES() {
        return lv_NOMBRES;
    }

    /**
     * @param lv_NOMBRES the lv_NOMBRES to set
     */
    public void setLv_NOMBRES(String lv_NOMBRES) {
        this.lv_NOMBRES = lv_NOMBRES;
    }

    /**
     * @return the lv_APELLIDOS
     */

    /**
     * @return the lv_DIRECCION
     */
    public String getLv_DIRECCION() {
        return lv_DIRECCION;
    }

    /**
     * @param lv_DIRECCION the lv_DIRECCION to set
     */
    public void setLv_DIRECCION(String lv_DIRECCION) {
        this.lv_DIRECCION = lv_DIRECCION;
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
}
