/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.conexion;
import JB.PagosDiarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Cardozo Villon
 */
public class PagosDiariosDao {
    private conexion cm;
     
     public PagosDiariosDao() throws ClassNotFoundException, SQLException {
        cm = new conexion();
        cm.conectar();
    }
     
     public int insertarPagosDiarios(PagosDiarios p) throws SQLException{
        cm.conectar();
         int n=0;
        String insertPagosDiarios="INSERT INTO PAGOS_DIARIOS (ID, MOVIL, FECHA_REGISTRO, VALOR, USUARIO_ID, OBSERVACION) VALUES (pagos_diarios_id.nextval, (?), to_date(?,'dd/mm/yyyy hh24:mi:ss'), (?), (?),(?))";
        PreparedStatement ps = cm.preparedStatement(insertPagosDiarios);
        ps.setInt(1, p.getLv_MOVIL());
        ps.setString(2, p.getLv_FECHA_REGISTRO());
        ps.setFloat(3, p.getLv_VALOR());
        ps.setString(4, p.getLv_USUARIO_ID());
        ps.setString(5, p.getLv_obervacion());
        n=ps.executeUpdate();
        cm.desconectar();
        return n;
        }
     
     public int ValidarPagoDiario (String fechaRegistro,int movil) throws SQLException{
         
         int cantidad=0;
       String sql="SELECT COUNT(*) CANTIDAD FROM PAGOS_DIARIOS WHERE TO_CHAR(FECHA_REGISTRO,'DD/MM/RRRR')=(?) AND MOVIL = (?)";
       PreparedStatement ps = cm.preparedStatement(sql);
       ps.setString(1,fechaRegistro);
       ps.setInt(2,movil);
       ResultSet rs = ps.executeQuery();
        while(rs.next()){
        cantidad=(rs.getInt("CANTIDAD"));
        }
        cm.desconectar();
        return cantidad;
        
   }
     
    public int ValidarPagoChofer (int movil) throws SQLException{
       
        int cantidad=0;
       String sql="SELECT COUNT(*) CANTIDAD FROM PAGOS_DIARIOS WHERE TO_DATE(FECHA_REGISTRO,'DD/MM/RRRR')>= TO_DATE(SYSDATE,'DD/MM/RRRR')-2 AND MOVIL = (?)";
       PreparedStatement ps = cm.preparedStatement(sql);
       ps.setInt(1,movil);
       ResultSet rs = ps.executeQuery();
        while(rs.next()){
        cantidad=(rs.getInt("CANTIDAD"));
        }
        cm.desconectar();
        return cantidad; 
   }
    
    public Vector ValidarPagoDiarioChofer (int movil, String fechaPago) throws SQLException{
       cm.conectar();
       String sql="SELECT TO_DATE((?),'DD/MM/RRRR') - TO_DATE((SELECT MAX (FECHA_REGISTRO)FROM PAGOS_DIARIOS WHERE MOVIL =(?)),'DD/MM/RRRR') CANTIDAD,TO_CHAR((SELECT MAX (FECHA_REGISTRO)FROM PAGOS_DIARIOS WHERE MOVIL =(?)),'DD/MM/RRRR') FECHA FROM DUAL";
       PreparedStatement ps = cm.preparedStatement(sql);
       Vector v1 = new Vector();
       ps.setString(1,fechaPago);
       ps.setInt(2,movil);
       ps.setInt(3,movil);
       ResultSet r = ps.executeQuery();
       while(r.next()){
       v1.addElement(r.getInt("CANTIDAD"));
       v1.addElement(r.getString("FECHA"));
        }
        cm.desconectar();
        return v1; 
   }
    
    public int ValidarPagoDiarioChoferApoyo (int movil) throws SQLException{
       cm.conectar();
       int obtenerPago=0;
       String sql="SELECT COUNT(*) CANTIDAD FROM PAGOS_DIARIOS WHERE MOVIL = (?) AND TO_CHAR(FECHA_REGISTRO,'DD/MM/YYYY') = (SELECT TO_CHAR(MAX(FECHA_HORA_REGISTRO),'DD/MM/YYYY') FROM CARRERAS WHERE MOVIL = (?))";
       PreparedStatement ps = cm.preparedStatement(sql);
       ps.setInt(1,movil);
       ps.setInt(2,movil);
       ResultSet r = ps.executeQuery();
       while(r.next()){
       obtenerPago=(r.getInt("CANTIDAD"));
        }
        cm.desconectar();
        return obtenerPago; 
   }
    
    public Vector obtenerPagosDiariosFechas(String fechaini, String fechafin) throws SQLException{
        cm.conectar();
        String selectDatosHistorialFechas="select C.MOVIL MOVIL, to_char(C.FECHA_REGISTRO,'dd/mm/rrrr') FECHA_REGISTRO, C.VALOR VALOR, C.OBSERVACION OBSERVACION, U.NOMBRES || ' ' || U.APELLIDOS OPERADORA from PAGOS_DIARIOS C, USUARIOS U WHERE U.CEDULA = C.USUARIO_ID AND C.FECHA_REGISTRO >= TO_DATE(?, 'DD/MM/RRRR') AND C.FECHA_REGISTRO <= TO_DATE(?, 'DD/MM/RRRR') + 1 order by MOVIL, FECHA_REGISTRO asc";
        Vector v1 = new Vector();
        PreparedStatement ps = cm.preparedStatement(selectDatosHistorialFechas);
        ps.setString(1, fechaini);
        ps.setString(2, fechafin);
        ResultSet r = ps.executeQuery();
        while(r.next()){
        PagosDiarios p1 = new PagosDiarios(r.getInt("MOVIL"),r.getString("FECHA_REGISTRO"), r.getFloat("VALOR"), r.getString("OPERADORA"),r.getString("OBSERVACION"));
        v1.addElement(p1);          
        }
        cm.desconectar();
        return v1;
}
}
