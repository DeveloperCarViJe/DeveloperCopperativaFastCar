/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.UsuariosDao;
import JB.Usuarios;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Cardozo Villon
 */
public class UsuariosBo {
    private DAO.UsuariosDao user;
    
    public UsuariosBo() throws ClassNotFoundException, SQLException
    {
      user = new UsuariosDao();
    }
    
    public Vector  ValidarUsuariosIngreso(String cedula,String password) throws SQLException{
        return user.ValidarUsuariosSesion(cedula, password);
    }
    
    public int  RegistrarUsuarioNuevo(Usuarios p, int rol) throws SQLException{
        return user.insertarUsuario(p,rol);
    }
    
    public int  ValidarUsuarioRepetidos(String cedula) throws SQLException{
        return user.ValidarUsuariosRegistrados(cedula);
    }
    
    public Vector  ObtenerNombresUsuariosBO(String cedula) throws SQLException{
        return user.obtenerNombreUsuario(cedula);
    }
    
    public int ActualizarUsuarioBO(Usuarios pa, int rol) throws SQLException{
        return user.actualizarUsuario(pa, rol);
    }
    
}
