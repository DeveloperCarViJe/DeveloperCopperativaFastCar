/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.PromocionesDao;
import JB.Promociones;
import java.sql.SQLException;

/**
 *
 * @author Cardozo Villon
 */
public class PromocionesBo {
    private DAO.PromocionesDao po;
    
    public PromocionesBo() throws ClassNotFoundException, SQLException
    {
      po = new PromocionesDao();
    }
    
    public int  ValidarPromociones() throws SQLException{
        return po.ValidarPromociones();
    }
    
    public int  RegistrarPromociones(Promociones p) throws SQLException{
        return po.insertarPromociones(p);
    }
    
    public int  FinalizarPromociones() throws SQLException{
        return po.finalizarPromocion();
    }
    
    public int  ObtenerIdPromociones() throws SQLException{
        return po.ObtenerIdPromociones();
    }
    
    public String  ObtenerDescripcionPromociones() throws SQLException{
        return po.ObtenerDescripcionPromociones();
    }
}
