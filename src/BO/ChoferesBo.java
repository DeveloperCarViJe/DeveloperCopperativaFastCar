/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.ChoferesDao;
import JB.Choferes;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Cardozo Villon
 */
public class ChoferesBo {
     private DAO.ChoferesDao cho;
    
    public ChoferesBo() throws ClassNotFoundException, SQLException
    {
      cho = new ChoferesDao();
    }
    
    public int  RegistrarChoferNuevo(Choferes ch, String estado) throws SQLException{
        return cho.insertarChoferes(ch,estado);
    }
    
    public int  ValidarChoferesRegistrados(Integer movil) throws SQLException{
        return cho.ValidarChoferes(movil);
    }
    
    public Vector  ObtenerDatosChoferes(int movil) throws SQLException{
        return cho.obtenerDatosChoferes(movil);
    }
    
    public int ActualizarDatosChoferes(Choferes ch, int movil) throws SQLException{
        return cho.ActualizarDatosChoferes(ch, movil);
    }
    
    public int InactivarChofer(int movil) throws SQLException{
        return cho.InactivarChofer(movil);
    }
    
    public String placaMovil(int movil) throws SQLException{
        return cho.placaMovil(movil);
    }
    
    public String EstadoMovil(int movil) throws SQLException{
        return cho.EstadoMovil(movil);
    }
    
}
