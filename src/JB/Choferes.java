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
public class Choferes {
    
    private Integer LV_MOVIL;
    private String LV_NOMBRES;      
    private String LV_APELLIDOS;
    private String LV_DIRECCION;
    private String LV_TELEFONO;     
    private String LV_COLOR_VEHICULO;
    private String LV_PLACA;         
    private String LV_MODELO;        

    public Choferes(Integer movil, String nombres, String apellidos, String direccion, String telefono, String color_vehiculo, String placa, String modelo){
        this.setLV_MOVIL(movil);
        this.setLV_NOMBRES(nombres);
        this.setLV_APELLIDOS(apellidos);
        this.setLV_DIRECCION(direccion);
        this.setLV_TELEFONO(telefono);
        this.setLV_COLOR_VEHICULO(color_vehiculo);
        this.setLV_PLACA(placa);
        this.setLV_MODELO(modelo);
    }

    /**
     * @return the LV_MOVIL
     */
    public Integer getLV_MOVIL() {
        return LV_MOVIL;
    }

    /**
     * @param LV_MOVIL the LV_MOVIL to set
     */
    public void setLV_MOVIL(Integer LV_MOVIL) {
        this.LV_MOVIL = LV_MOVIL;
    }

    /**
     * @return the LV_NOMBRES
     */
    public String getLV_NOMBRES() {
        return LV_NOMBRES;
    }

    /**
     * @param LV_NOMBRES the LV_NOMBRES to set
     */
    public void setLV_NOMBRES(String LV_NOMBRES) {
        this.LV_NOMBRES = LV_NOMBRES;
    }

    /**
     * @return the LV_APELLIDOS
     */
    public String getLV_APELLIDOS() {
        return LV_APELLIDOS;
    }

    /**
     * @param LV_APELLIDOS the LV_APELLIDOS to set
     */
    public void setLV_APELLIDOS(String LV_APELLIDOS) {
        this.LV_APELLIDOS = LV_APELLIDOS;
    }

    /**
     * @return the LV_DIRECCION
     */
    public String getLV_DIRECCION() {
        return LV_DIRECCION;
    }

    /**
     * @param LV_DIRECCION the LV_DIRECCION to set
     */
    public void setLV_DIRECCION(String LV_DIRECCION) {
        this.LV_DIRECCION = LV_DIRECCION;
    }

    /**
     * @return the LV_TELEFONO
     */
    public String getLV_TELEFONO() {
        return LV_TELEFONO;
    }

    /**
     * @param LV_TELEFONO the LV_TELEFONO to set
     */
    public void setLV_TELEFONO(String LV_TELEFONO) {
        this.LV_TELEFONO = LV_TELEFONO;
    }

    /**
     * @return the LV_COLOR_VEHICULO
     */
    public String getLV_COLOR_VEHICULO() {
        return LV_COLOR_VEHICULO;
    }

    /**
     * @param LV_COLOR_VEHICULO the LV_COLOR_VEHICULO to set
     */
    public void setLV_COLOR_VEHICULO(String LV_COLOR_VEHICULO) {
        this.LV_COLOR_VEHICULO = LV_COLOR_VEHICULO;
    }

    /**
     * @return the LV_PLACA
     */
    public String getLV_PLACA() {
        return LV_PLACA;
    }

    /**
     * @param LV_PLACA the LV_PLACA to set
     */
    public void setLV_PLACA(String LV_PLACA) {
        this.LV_PLACA = LV_PLACA;
    }

    /**
     * @return the LV_MODELO
     */
    public String getLV_MODELO() {
        return LV_MODELO;
    }

    /**
     * @param LV_MODELO the LV_MODELO to set
     */
    public void setLV_MODELO(String LV_MODELO) {
        this.LV_MODELO = LV_MODELO;
    }
    
}
