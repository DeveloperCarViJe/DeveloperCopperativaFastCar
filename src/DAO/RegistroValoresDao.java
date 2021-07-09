/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.conexion;
import JB.RegistrosValores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Cardozo Villon
 */
public class RegistroValoresDao {
    private conexion cm;
     
    public RegistroValoresDao() throws ClassNotFoundException, SQLException {
        cm = new conexion();
        cm.conectar();
    }
    
    public int insertarRegistrosDiarios(RegistrosValores rv) throws SQLException{
        cm.conectar();
        int n=0;
        String insertRegistroDiarios="INSERT INTO REGISTROS_VALORES (ID, DESTINO, VALOR, FECHA_REGISTRO, FECHA_MODIFICACION) VALUES (registros_valores_id.nextval, UPPER(?), (?),sysdate, null)";
        PreparedStatement ps = cm.preparedStatement(insertRegistroDiarios);
        ps.setString(1, rv.getLv_DESTINO());
        ps.setFloat(2, rv.getLf_VALOR());
        n=ps.executeUpdate();
        cm.desconectar();
        return n;
    }
    
    public int ValidarRegistrosDiarios (String destino) throws SQLException{

        int cantidad=0;
       String sql="SELECT COUNT(*) CANTIDAD FROM REGISTROS_VALORES WHERE DESTINO=UPPER(?)";
       PreparedStatement ps = cm.preparedStatement(sql);
       ps.setString(1,destino);
       ResultSet rs = ps.executeQuery();
        while(rs.next()){
        cantidad=(rs.getInt("CANTIDAD"));
        }
        cm.desconectar();
        return cantidad;
        
   }
    
     
     public Vector obtenerDestinoCarreas() throws SQLException{

         String selectOrigenCarreras="SELECT DISTINCT(DESTINO) DESTINO FROM REGISTROS_VALORES";
        Vector v1 = new Vector();
        PreparedStatement ps = cm.preparedStatement(selectOrigenCarreras);
        ResultSet r = ps.executeQuery();
        while(r.next()){
        RegistrosValores p1 = new RegistrosValores(r.getString("DESTINO"),0);
        v1.addElement(p1);          
        }
        cm.desconectar();
        return v1;
    }
     
    public float ObtenerValorCarrera (String destino) throws SQLException{

        float valor=0;
       String sql="SELECT VALOR FROM REGISTROS_VALORES WHERE DESTINO=UPPER(?)";
       PreparedStatement ps = cm.preparedStatement(sql);
       ps.setString(1,destino);
       ResultSet rs = ps.executeQuery();
        while(rs.next()){
        valor=(rs.getFloat("VALOR"));
        }
        cm.desconectar();
        return valor;
        
   }
}
