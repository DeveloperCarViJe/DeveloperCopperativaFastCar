/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.conexion;
import JB.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Cardozo Villon
 */
public class UsuariosDao {
    private conexion cm;
     
     public UsuariosDao() throws ClassNotFoundException, SQLException {
        cm = new conexion();
        cm.conectar();
    }
     
     public Vector ValidarUsuariosSesion (String cedula,String password) throws SQLException{
         
       Vector v1 = new Vector();
       String sql="select R.ESTADO ESTADO, U.CEDULA CEDULA ,U.NOMBRES||' '||U.APELLIDOS NOMBRES from USUARIOS U, ROLES R where CEDULA= UPPER(?) and upper(PASSWORD)= UPPER(?) AND U.ID_ROLES = R.ID";
       PreparedStatement ps = cm.preparedStatement(sql);
       ps.setString(1,cedula);
       ps.setString(2,password);
       ResultSet rs = ps.executeQuery();
        while(rs.next()){
        v1.addElement(rs.getString("ESTADO"));
        v1.addElement(rs.getString("CEDULA"));
        v1.addElement(rs.getString("NOMBRES"));
        }
        cm.desconectar();
        return v1;
        
   }
     
       public int ValidarUsuariosRegistrados (String cedula) throws SQLException{
           
           int cantidad=0;
       String sql="select count(*)USUARIOS  from USUARIOS where CEDULA= UPPER(?)";
       PreparedStatement ps = cm.preparedStatement(sql);
       ps.setString(1,cedula);
       ResultSet rs = ps.executeQuery();
        while(rs.next()){
        cantidad=(rs.getInt("USUARIOS"));
        }
        cm.desconectar();
        return cantidad;
        
   }
     
     public int insertarUsuario(Usuarios p,int rol) throws SQLException{
        
         int n=0;
        String insertUsuario="insert into USUARIOS (id, cedula, nombres, apellidos, password, fecha_registro, fecha_modificacion, id_roles) values (usuarios_id.nextval, UPPER(?), UPPER(?), UPPER(?), UPPER(?), sysdate, null, ?)";

        PreparedStatement ps = cm.preparedStatement(insertUsuario);
        ps.setString(1, p.getLv_cedula());
        ps.setString(2, p.getLv_nombres());
        ps.setString(3, p.getLv_apellidos());
        ps.setString(4, p.getLv_password());
        ps.setInt(5, rol);
        n=ps.executeUpdate();
        cm.desconectar();
        return n;
            }
     
        public Vector obtenerNombreUsuario(String cedula) throws SQLException{
            
            String selectNombreUsuario="SELECT NOMBRES, APELLIDOS FROM USUARIOS WHERE CEDULA=(?)";
        Vector v1 = new Vector();
        PreparedStatement ps = cm.preparedStatement(selectNombreUsuario);
        ps.setString(1, cedula);
        ResultSet r = ps.executeQuery();
        while(r.next()){
        Usuarios p1 = new Usuarios("",r.getString("NOMBRES"),r.getString("APELLIDOS"),"");
        v1.addElement(p1);          
        }
        cm.desconectar();
        return v1;
    }
        
        public int actualizarUsuario(Usuarios np,int rol) throws SQLException{
        
            int n1=0;
        String ActualizarUsuarios="UPDATE USUARIOS SET PASSWORD=(?), FECHA_MODIFICACION=SYSDATE,ID_ROLES =(?) WHERE CEDULA=(?)";
        PreparedStatement ps = cm.preparedStatement(ActualizarUsuarios);
        ps.setString(1, np.getLv_password());
        ps.setInt(2, rol);
        ps.setString(3,np.getLv_cedula());
        n1=ps.executeUpdate();
        cm.desconectar();
        return n1;
    }
}