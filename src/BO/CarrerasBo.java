/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.CarrerasDao;
import JB.Carreras;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Cardozo Villon
 */
public class CarrerasBo {
    private DAO.CarrerasDao ca;
    
    public CarrerasBo() throws ClassNotFoundException, SQLException
    {
      ca = new CarrerasDao();
    }
    
    public int RegistrarClientes(Carreras car, int movil,int obtenerIdCarrera) throws SQLException{
        return ca.insertarCarrera(car, movil,obtenerIdCarrera);
    }
    
     public Vector  ObtenerDatosClientes(String telefono) throws SQLException{
        return ca.obtenerDatosClientes(telefono);
    }
     
     public Vector  ObtenerHistorialCarreras() throws SQLException{
        return ca.obtenerHistorialCarreras();
    }
     
     public Vector  ObtenerHistorialUpdate(String telefono, String origen, String destino, String fecha_registro) throws SQLException{
        return ca.obtenerDatosUpdateHistorial(telefono, origen, destino, fecha_registro);
    }
     
     public Vector  ObtenerHistorialUpdate2(String telefono, String origen, String destino, String fecha_registro) throws SQLException{
        return ca.obtenerDatosUpdateHistorial2(telefono, origen, destino, fecha_registro);
    }
     
     public int ActualizarCarreras(int id, String estado_reserva) throws SQLException{
        return ca.ActualizarDatosChoferes(id, estado_reserva);
    }
     
     public int ActualizarCarreras2(int id, String estado_reserva, int movil) throws SQLException{
        return ca.ActualizarDatosChoferes2(id, estado_reserva,movil);
    }
     
     
     public Vector  ObtenerHistorialCarrerasTelefono(String telefono, String fechaini, String fechafin) throws SQLException{
        return ca.obtenerHistorialCarrerasTelefono(telefono,fechaini,fechafin);
    }
     
     public Vector  ObtenerHistorialCarrerasMovil(int movil, String fechaini, String fechafin) throws SQLException{
        return ca.obtenerHistorialCarrerasMovil(movil,fechaini,fechafin);
    }
     
     public Vector  ObtenerHistorialCarrerasFechas(String fechaini, String fechafin) throws SQLException{
        return ca.obtenerHistorialCarrerasFechas(fechaini,fechafin);
    }
     
     public Vector  ObtenerHistorialChoferesMovil(int movil, String fechaini, String fechafin) throws SQLException{
        return ca.obtenerHistorialChoferesMovil(movil,fechaini,fechafin);
    }
     
     public int ObtenerIdCarrera() throws SQLException{
        return ca.obtenerIdCarrera();
    }
     
     public int ActualizarReferencia(String referencia, float VALOR, String telefono, String origen, String destino, int movil, String Lc_telefono, String lc_origen, String lc_destino, int lc_movil, String fecha_hora) throws SQLException{
        return ca.ActualizarReferencia(referencia, VALOR, telefono, origen, destino, movil, Lc_telefono, lc_origen, lc_destino, lc_movil, fecha_hora);
    }
     
     public int ActualizarMovil(int nuevo_movil, String telefono, String origen, String destino, int movil, String fecha_hora) throws SQLException{
        return ca.ActualizarMovil(nuevo_movil, telefono, origen, destino, movil, fecha_hora);
    }
     
     public int ActualizarErronea(String telefono, String origen, String destino, int movil, String fecha_hora) throws SQLException{
        return ca.ActualizarErronea(telefono, origen, destino, movil, fecha_hora);
    }
     
     public String ObtenerNombrecliente(String telefono, String origen, String destino, String fecha_hora) throws SQLException{
        return ca.obtenerNombrecliente(telefono, origen, destino, fecha_hora);
    }
}
