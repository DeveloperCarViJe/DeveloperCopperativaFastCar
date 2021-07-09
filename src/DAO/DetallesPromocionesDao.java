/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.conexion;
import JB.DetallesPromociones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cardozo Villon
 */
public class DetallesPromocionesDao {
    private conexion cm;
     
     public DetallesPromocionesDao() throws ClassNotFoundException, SQLException {
        cm = new conexion();
        cm.conectar();
    }
     
     public int obtenerNumeroSorteo(int id_promocion) throws SQLException{

       int numeroSorteo=0;
       String sql="SELECT MAX(NUMERO_SORTEO)NUMERO_SORTEO FROM DETALLES_PROMOCIONES WHERE ID_PROMOCION = (?)";
       PreparedStatement ps = cm.preparedStatement(sql);
       ps.setInt(1,id_promocion);
       ResultSet rs = ps.executeQuery();
       while(rs.next()){
       numeroSorteo=(rs.getInt("NUMERO_SORTEO"));
       }
       cm.desconectar();
       return numeroSorteo;
    }
     
      public int insertarDetallesPromocines(DetallesPromociones pro, int movil, int idPromociones, int idCarrera) throws SQLException{
          cm.conectar();
          int n=0;
        if(movil == 0){
        String insertDetallePromocion="insert into detalles_promociones (id, TELEFONO_CLIENTE, numero_sorteo, fecha_registro, id_promocion, id_movil, ID_CARRERA) values (DETALLES_PROMOCIONES_id.Nextval, UPPER(?), (?), SYSDATE, (?), null,(?))";
        PreparedStatement ps = cm.preparedStatement(insertDetallePromocion);
        ps.setString(1, pro.getLV_TELEFONO_CLIENTE());
        ps.setInt(2, pro.getln_NUMERO_SORTEO());
        ps.setInt(3, idPromociones);
        ps.setInt(4, idCarrera);
        n=ps.executeUpdate();
        cm.desconectar();
        return n;
        }else{
        String insertDetallePromocion="insert into detalles_promociones (id, TELEFONO_CLIENTE, numero_sorteo, fecha_registro, id_promocion, id_movil, ID_CARRERA) values (DETALLES_PROMOCIONES_id.Nextval, UPPER(?), (?), SYSDATE, (?), (?),(?))";
        PreparedStatement ps = cm.preparedStatement(insertDetallePromocion);
        ps.setString(1, pro.getLV_TELEFONO_CLIENTE());
        ps.setInt(2, pro.getln_NUMERO_SORTEO());
        ps.setInt(3, idPromociones);
        ps.setInt(4, movil);
        ps.setInt(5, idCarrera);
        n=ps.executeUpdate();
        cm.desconectar();
        return n;
        }
        
    }
      
      public int ActualizarPromocion(int id, int movil) throws SQLException{
        cm.conectar();
         int n1=0;
        String ActualizarPromocion="UPDATE DETALLES_PROMOCIONES SET ID_MOVIL = (?) WHERE ID_CARRERA = (?)";
        PreparedStatement ps = cm.preparedStatement(ActualizarPromocion);
        ps.setInt(1, movil);
        ps.setInt(2, id);
        n1=ps.executeUpdate();
        cm.desconectar();
        return n1;
    }
}
