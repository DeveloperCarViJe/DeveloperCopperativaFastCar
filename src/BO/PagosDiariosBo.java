/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.PagosDiariosDao;
import JB.PagosDiarios;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Cardozo Villon
 */
public class PagosDiariosBo {
    private DAO.PagosDiariosDao pd;
    
    public PagosDiariosBo() throws ClassNotFoundException, SQLException
    {
      pd = new PagosDiariosDao();
    }
    
    public int  RegistrarPagosDiarios(PagosDiarios p) throws SQLException{
        return pd.insertarPagosDiarios(p);
    }
    
    public int  ValidarPagoDiarios(String FechaRegistro, int movil) throws SQLException{
        return pd.ValidarPagoDiario(FechaRegistro, movil);
    }
    
    public int  ValidarPagoChofer(int movil) throws SQLException{
        return pd.ValidarPagoChofer(movil);
    }
    
    public Vector  ValidarPagoDiarioChofer(int movil,String fechaPago) throws SQLException{
        return pd.ValidarPagoDiarioChofer(movil,fechaPago);
    }
    
    public int  ValidarPagoChoferApoyo(int movil) throws SQLException{
        return pd.ValidarPagoDiarioChoferApoyo(movil);
    }
    
     public Vector  ObtenerPaosDiariosFechas(String fechaini,String fechafin) throws SQLException{
        return pd.obtenerPagosDiariosFechas(fechaini,fechafin);
    }
}
