/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.DetallesPromocionesDao;
import JB.DetallesPromociones;
import java.sql.SQLException;

/**
 *
 * @author Cardozo Villon
 */
public class DetallesPromocionesBo {
    private DAO.DetallesPromocionesDao pro;
    
    public DetallesPromocionesBo() throws ClassNotFoundException, SQLException
    {
      pro = new DetallesPromocionesDao();
    }
    
    public int ObtenerNumerosorteo(int idPromocion) throws SQLException{
        return  pro.obtenerNumeroSorteo(idPromocion);
    }
    
    public int InsertarDetallePromocion(DetallesPromociones pr, int movil, int idPromocion, int idCarrera) throws SQLException{
        return  pro.insertarDetallesPromocines(pr, movil, idPromocion,idCarrera);
    }
    
     public int ActrualizarPromocion(int id, int movil) throws SQLException{
        return  pro.ActualizarPromocion(id, movil);
    }
}
