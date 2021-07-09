/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.conexion;
import JB.Regalos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cardozo Villon
 */
public class RegalosDao {
     private conexion cm;
     
    public RegalosDao() throws ClassNotFoundException, SQLException {
        cm = new conexion();
        cm.conectar();
    }
    
    public int ValidarRegalos () throws SQLException{
       
       int cantidad=0;
       String sql="SELECT COUNT(*) CANTIDAD FROM REGALOS WHERE ESTADO='A'";
       PreparedStatement ps = cm.preparedStatement(sql);
       ResultSet rs = ps.executeQuery();
        while(rs.next()){
        cantidad=(rs.getInt("CANTIDAD"));
        }
        cm.desconectar();
        return cantidad;
        
   }
    
     public String ObtenerDescripcionPromociones () throws SQLException{
       
       String descripcion=null;
       String sql="SELECT lower(DESCRIPCION) DESCRIPCION FROM PROMOCIONES WHERE ESTADO='A'";
       PreparedStatement ps = cm.preparedStatement(sql);
       ResultSet rs = ps.executeQuery();
        while(rs.next()){
        descripcion=(rs.getString("DESCRIPCION"));
        }
        cm.desconectar();
        return descripcion;
        
   }
    
    public int ObtenerIdPromociones () throws SQLException{

        int idPromocion=0;
       String sql="SELECT ID FROM PROMOCIONES WHERE ESTADO='A'";
       PreparedStatement ps = cm.preparedStatement(sql);
       ResultSet rs = ps.executeQuery();
        while(rs.next()){
        idPromocion=(rs.getInt("ID"));
        }
        cm.desconectar();
        return idPromocion;
        
   }
    
     public int insertarRegalos(Regalos po) throws SQLException{
        cm.conectar();
         int n=0;
        String insertRegalos="insert into Regalos (id, descripcion, fecha_inicio, fecha_fin) values (REGALOS_ID.Nextval, UPPER(?), SYSDATE, NULL)";
        PreparedStatement ps = cm.preparedStatement(insertRegalos);
        ps.setString(1, po.getLv_DESCRIPCION());
        n=ps.executeUpdate();
        cm.desconectar();
        return n;
    }
     
     public int finalizarRegalos() throws SQLException{
        cm.conectar();
         int n1=0;
        String ActualizarPromociones="update regalos set estado = 'F', fecha_fin = sysdate where estado = 'A'";
        PreparedStatement ps = cm.preparedStatement(ActualizarPromociones);
        n1=ps.executeUpdate();
        cm.desconectar();
        return n1;
    }
}
