/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REPORTES;

import CONEXION.conexion;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.util.JRLoader;
//import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Cardozo Villon
 */
public class prueba {
    private conexion cm;
     
     public prueba() throws ClassNotFoundException, SQLException {
        cm = new conexion();
        cm.conectar();
    }
    public void reporteCarreraMovil(){

        /*try{
            JasperReport reporte = (JasperReport) JRLoader.loadObject("CarrerasMovil.jasper");
            Map parametro = new HashMap();
            parametro.put("Movil", 37);
            parametro.put("FechaIni", "25/03/2017");
            parametro.put("FechaFin", "08/04/2017");
            JasperPrint j = JasperFillManager.fillReport(reporte, parametro,cm.conectar());
            JasperViewer jv = new JasperViewer(j,false);
            jv.setTitle("REPORTES CARRERAS MOVIL");
            jv.setVisible(true);
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "Error al mostrar el reporte"+e);
        }*/
    }
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
        prueba p = new prueba();
        p.reporteCarreraMovil();
    }
}
