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
public class Regalos {
    private int    ln_ID;
    private String lv_DESCRIPCION;
    
    public Regalos(int ID,String DESCRIPCION){
        this.setLn_ID(ID);
        this.setLv_DESCRIPCION(DESCRIPCION);
    }

    /**
     * @return the lv_DESCRIPCION
     */
    public String getLv_DESCRIPCION() {
        return lv_DESCRIPCION;
    }

    /**
     * @param lv_DESCRIPCION the lv_DESCRIPCION to set
     */
    public void setLv_DESCRIPCION(String lv_DESCRIPCION) {
        this.lv_DESCRIPCION = lv_DESCRIPCION;
    }

    /**
     * @return the ln_ID
     */
    public int getLn_ID() {
        return ln_ID;
    }

    /**
     * @param ln_ID the ln_ID to set
     */
    public void setLn_ID(int ln_ID) {
        this.ln_ID = ln_ID;
    }
}
