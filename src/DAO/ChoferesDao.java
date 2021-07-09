/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.conexion;
import JB.Choferes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Cardozo Villon
 */
public class ChoferesDao {
    private conexion cm;
     
     public ChoferesDao() throws ClassNotFoundException, SQLException {
        cm = new conexion();
        cm.conectar();
    }
     
     public int insertarChoferes(Choferes cho, String estado) throws SQLException{
        
         int n=0;
        String insertChofer="INSERT INTO CHOFERES (ID, MOVIL, NOMBRES, APELLIDOS, DIRECCION, TELEFONO, COLOR_VEHICULO, PLACA, MODELO, ESTADO, FECHA_REGISTRO, FECHA_MODIFICACION) VALUES (choferes_id.nextval, (?), UPPER(?), UPPER(?), UPPER(?), (?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), SYSDATE, NULL)";
        PreparedStatement ps = cm.preparedStatement(insertChofer);
        ps.setInt(1, cho.getLV_MOVIL());
        ps.setString(2, cho.getLV_NOMBRES());
        ps.setString(3, cho.getLV_APELLIDOS());
        ps.setString(4, cho.getLV_DIRECCION());
        ps.setString(5, cho.getLV_TELEFONO());
        ps.setString(6, cho.getLV_COLOR_VEHICULO());
        ps.setString(7, cho.getLV_PLACA());
        ps.setString(8, cho.getLV_MODELO());
        ps.setString(9, estado);
        n=ps.executeUpdate();
        cm.desconectar();
        return n;
    }
     
     public int ValidarChoferes (int movil) throws SQLException{

         int cantidad=0;
       String sql="SELECT COUNT(*) CANTIDAD FROM CHOFERES WHERE MOVIL = (?)and ESTADO IN ('A','F')";
       PreparedStatement ps = cm.preparedStatement(sql);
       ps.setInt(1,movil);
       ResultSet rs = ps.executeQuery();
        while(rs.next()){
        cantidad=(rs.getInt("CANTIDAD"));
        }
        cm.desconectar();
        return cantidad;
        
   }
     
     public Vector obtenerDatosChoferes(int movil) throws SQLException{
        cm.conectar();
        String selectDatosChoferes="SELECT A.NOMBRES NOMBRES,A.APELLIDOS APELLIDOS,A.DIRECCION DIRECCION,A.TELEFONO TELEFONO,A.COLOR_VEHICULO COLOR_VEHICULO,A.PLACA PLACA,A.MODELO MODELO FROM CHOFERES A WHERE MOVIL = (?) AND ESTADO <> 'I'";
        Vector v1 = new Vector();
        PreparedStatement ps = cm.preparedStatement(selectDatosChoferes);
        ps.setInt(1, movil);
        ResultSet r = ps.executeQuery();
        while(r.next()){
        Choferes p1 = new Choferes(null,r.getString("NOMBRES"),r.getString("APELLIDOS"),r.getString("DIRECCION"),r.getString("TELEFONO"),r.getString("COLOR_VEHICULO"),r.getString("PLACA"),r.getString("MODELO"));
        v1.addElement(p1);          
        }
        cm.desconectar();
        return v1;
    }
     
     public int ActualizarDatosChoferes(Choferes ch,int movil) throws SQLException{

         int n1=0;
        String ActualizarDatosChofer="UPDATE CHOFERES SET DIRECCION = UPPER(?), TELEFONO = (?), COLOR_VEHICULO = UPPER(?), PLACA = UPPER(?), MODELO = UPPER(?), FECHA_MODIFICACION = SYSDATE WHERE MOVIL = (?)";
        PreparedStatement ps = cm.preparedStatement(ActualizarDatosChofer);
        ps.setString(1, ch.getLV_DIRECCION());
        ps.setString(2, ch.getLV_TELEFONO());
        ps.setString(3, ch.getLV_COLOR_VEHICULO());
        ps.setString(4, ch.getLV_PLACA());
        ps.setString(5, ch.getLV_MODELO());
        ps.setInt(6, movil);
        n1=ps.executeUpdate();
        cm.desconectar();
        return n1;
    }
     
      public int InactivarChofer(int movil) throws SQLException{

          int n1=0;
        String ActualizarDatosChofer="UPDATE CHOFERES SET ESTADO = 'I', FECHA_MODIFICACION = SYSDATE WHERE MOVIL = (?)";
        PreparedStatement ps = cm.preparedStatement(ActualizarDatosChofer);
        ps.setInt(1, movil);
        n1=ps.executeUpdate();
        cm.desconectar();
        return n1;
    }
      
      public String placaMovil(int movil) throws SQLException{
        cm.conectar();
        String placa=null;
        String PlacaDatosChofer="SELECT PLACA FROM CHOFERES WHERE MOVIL = (?)";
        PreparedStatement ps = cm.preparedStatement(PlacaDatosChofer);
        ps.setInt(1, movil);
       ResultSet r = ps.executeQuery();
        while(r.next()){
            placa = r.getString("PLACA");
        }
        
        return placa;
    }
      
      public String EstadoMovil(int movil) throws SQLException{
        cm.conectar();
        String estado=null;
        String EstadoDatosChofer="SELECT ESTADO FROM CHOFERES WHERE MOVIL = (?)";
        PreparedStatement ps = cm.preparedStatement(EstadoDatosChofer);
        ps.setInt(1, movil);
       ResultSet r = ps.executeQuery();
        while(r.next()){
            estado = r.getString("ESTADO");
        }
        
        return estado;
    }
     
  
}
