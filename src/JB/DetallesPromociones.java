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
public class DetallesPromociones {
    private String LV_TELEFONO_CLIENTE;
    private Integer ln_NUMERO_SORTEO;
    
    public DetallesPromociones(String TELEFONO_CLIENTE, int NUMERO_SORTEO){
        this.setLV_TELEFONO_CLIENTE(TELEFONO_CLIENTE);
        this.setln_NUMERO_SORTEO(NUMERO_SORTEO);
    }

    /**
     * @return the lv_CLIENTE
     */
    public String getLV_TELEFONO_CLIENTE() {
        return LV_TELEFONO_CLIENTE;
    }

    /**
     * @param lv_CLIENTE the lv_CLIENTE to set
     */
    public void setLV_TELEFONO_CLIENTE(String lv_CLIENTE) {
        this.LV_TELEFONO_CLIENTE = lv_CLIENTE;
    }

    /**
     * @return the lv_NUMERO_SORTEO
     */
    public int getln_NUMERO_SORTEO() {
        return ln_NUMERO_SORTEO;
    }

    /**
     * @param lv_NUMERO_SORTEO the lv_NUMERO_SORTEO to set
     */
    public void setln_NUMERO_SORTEO(int ln_NUMERO_SORTEO) {
        this.ln_NUMERO_SORTEO = ln_NUMERO_SORTEO;
    }
}
