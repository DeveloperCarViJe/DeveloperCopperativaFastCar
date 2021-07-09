/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.RegistroValoresDao;
import JB.RegistrosValores;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Cardozo Villon
 */
public class RegistroValoresBo {
    private DAO.RegistroValoresDao rv;
    
    public RegistroValoresBo() throws ClassNotFoundException, SQLException
    {
      rv = new RegistroValoresDao();
    }
    
    public int  RegistrarRegistrodiarios(RegistrosValores r) throws SQLException{
        return rv.insertarRegistrosDiarios(r);
    }
    
    public int  ValidarRegistroDiario(String destino) throws SQLException{
        return rv.ValidarRegistrosDiarios(destino);
    }
    
    public Vector  ObtenerDestinoValores() throws SQLException{
        return rv.obtenerDestinoCarreas();
    }
    
    public float  ObtenerRegistroValor(String destino) throws SQLException{
        return rv.ObtenerValorCarrera(destino);
    }
}
