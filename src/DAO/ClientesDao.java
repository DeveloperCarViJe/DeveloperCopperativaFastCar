/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.conexion;
import JB.Clientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cardozo Villon
 */
public class ClientesDao {
    private conexion cm;
     
     public ClientesDao() throws ClassNotFoundException, SQLException {
        cm = new conexion();
        cm.conectar();
    }
     
    public int VerificarCliente(String telefono) throws SQLException{

       int cantidad=0;
       String sql="SELECT COUNT(*) CANTIDAD FROM CLIENTES WHERE TELEFONO =(?)";
       PreparedStatement ps = cm.preparedStatement(sql);
       ps.setString(1,telefono);
       ResultSet rs = ps.executeQuery();
       while(rs.next()){
       cantidad=(rs.getInt("CANTIDAD"));
       }
       cm.desconectar();
       return cantidad;
    }
    
    public int insertarCliente(Clientes cl) throws SQLException{
        cm.conectar();
        int n=0;
        String insertUsuario="INSERT INTO CLIENTES (ID, NOMBRES, DIRECCION, TELEFONO, FECHA_REGISTRO, FECHA_MODIFICACION) VALUES (clientes_id.nextval, UPPER(?), UPPER(?), (?), SYSDATE, NULL)";
        PreparedStatement ps = cm.preparedStatement(insertUsuario);
        ps.setString(1, cl.getLv_NOMBRES());
        ps.setString(2, cl.getLv_DIRECCION());
        ps.setString(3, cl.getLv_TELEFONO());
        n=ps.executeUpdate();
        cm.desconectar();
        return n;
            }
    
   
}
