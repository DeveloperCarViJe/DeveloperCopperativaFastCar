/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.ClientesDao;
import JB.Clientes;
import java.sql.SQLException;

/**
 *
 * @author Cardozo Villon
 */
public class ClientesBo {
     private DAO.ClientesDao cl;
    
    public ClientesBo() throws ClassNotFoundException, SQLException
    {
      cl = new ClientesDao();
    }
    
    public int VerificarClientes(String telefono) throws SQLException{
        return cl.VerificarCliente(telefono);
    }
    
    public int RegistrarClientes(Clientes cli) throws SQLException{
        return cl.insertarCliente(cli);
    }
    
    
}
