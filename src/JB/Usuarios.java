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
public class Usuarios {
    private String lv_cedula;
    private String lv_nombres;
    private String lv_apellidos;
    private String lv_password;
    
    public Usuarios(String cedula, String nombres, String apellidos,String password){
        this.setLv_cedula(cedula);
        this.setLv_nombres(nombres);
        this.setLv_apellidos(apellidos);
        this.setLv_password(password);
    }

    /**
     * @return the lv_cedula
     */
    public String getLv_cedula() {
        return lv_cedula;
    }

    /**
     * @param lv_cedula the lv_cedula to set
     */
    public void setLv_cedula(String lv_cedula) {
        this.lv_cedula = lv_cedula;
    }

    /**
     * @return the lv_nombres
     */
    public String getLv_nombres() {
        return lv_nombres;
    }

    /**
     * @param lv_nombres the lv_nombres to set
     */
    public void setLv_nombres(String lv_nombres) {
        this.lv_nombres = lv_nombres;
    }

    /**
     * @return the lv_apellidos
     */
    public String getLv_apellidos() {
        return lv_apellidos;
    }

    /**
     * @param lv_apellidos the lv_apellidos to set
     */
    public void setLv_apellidos(String lv_apellidos) {
        this.lv_apellidos = lv_apellidos;
    }

    /**
     * @return the lv_password
     */
    public String getLv_password() {
        return lv_password;
    }

    /**
     * @param lv_password the lv_password to set
     */
    public void setLv_password(String lv_password) {
        this.lv_password = lv_password;
    }
}
