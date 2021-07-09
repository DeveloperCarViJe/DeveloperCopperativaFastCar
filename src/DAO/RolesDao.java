/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.conexion;
import JB.Roles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Cardozo Villon
 */
public class RolesDao {
    private conexion cm;
     
     public RolesDao() throws ClassNotFoundException, SQLException {
        cm = new conexion();
        cm.conectar();
    }
     
    public Vector obtenerRoles() throws SQLException{
        
        String selectRoles="SELECT ROL FROM ROLES";
        Vector v1 = new Vector();
        PreparedStatement ps = cm.preparedStatement(selectRoles);
        ResultSet r = ps.executeQuery();
        while(r.next()){
        Roles p1 = new Roles(r.getString("ROL"));
        v1.addElement(p1);          
        }
        cm.desconectar();
        return v1;
    }
    
}
