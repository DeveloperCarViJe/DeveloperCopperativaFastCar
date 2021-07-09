/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_fastcar;

import CONEXION.conexion;
import java.sql.SQLException;

/**
 *
 * @author Cardozo Villon
 */
public class Proyecto_Fastcar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        conexion co= new conexion();
        co.conectar();
    }
    
}
