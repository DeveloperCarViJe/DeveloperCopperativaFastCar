/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.RegalosDao;
import JB.Regalos;
import java.sql.SQLException;

/**
 *
 * @author Cardozo Villon
 */
public class RegalosBo {
    private DAO.RegalosDao po;
    
    public RegalosBo() throws ClassNotFoundException, SQLException
    {
      po = new RegalosDao();
    }
    
    public int  ValidarRegalos() throws SQLException{
        return po.ValidarRegalos();
    }
    
    public int  RegistrarRegalos(Regalos p) throws SQLException{
        return po.insertarRegalos(p);
    }
    
    public int  FinalizarRegalos() throws SQLException{
        return po.finalizarRegalos();
    }
    
    public int  ObtenerIdPromociones() throws SQLException{
        return po.ObtenerIdPromociones();
    }
    
    public String  ObtenerDescripcionPromociones() throws SQLException{
        return po.ObtenerDescripcionPromociones();
    }
}
