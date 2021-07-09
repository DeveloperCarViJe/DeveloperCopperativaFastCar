/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.RolesDao;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Cardozo Villon
 */
public class RolesBo {
    private DAO.RolesDao roles;
    
    public RolesBo() throws ClassNotFoundException, SQLException
    {
      roles = new RolesDao();
    }
    
    public Vector  ObtenerRolesBO() throws SQLException{
        return roles.obtenerRoles();
    }
}
