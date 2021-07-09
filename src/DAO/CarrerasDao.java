/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.conexion;
import JB.Carreras;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Cardozo Villon
 */
public class CarrerasDao {
    private conexion cm;
    public String [] array = new String [5];
     
     public CarrerasDao() throws ClassNotFoundException, SQLException {
        cm = new conexion();
        cm.conectar();
    }
     
     public int insertarCarrera(Carreras ca, int movil, int obtenerIdCarrera) throws SQLException{
        cm.conectar();
        int n=0;
        String insertCarrera=null;
        if (movil==0){
        insertCarrera="INSERT INTO CARRERAS (ID, CLIENTE, REFERENCIA, ORIGEN, DESTINO, TELEFONO, VALOR, MOVIL, RESERVA, ESTADO_CARRERA,FECHA_HORA_REGISTRO, FECHA_HORA_RESERVA, USUARIO_ID) VALUES ((?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), (?), (?), null,(?),(?), to_date(?,'dd/mm/yyyy hh24:mi:ss'), to_date(?,'dd/mm/yyyy hh24:mi:ss'),(?))";
        PreparedStatement ps = cm.preparedStatement(insertCarrera);
        ps.setInt(1, obtenerIdCarrera);
        ps.setString(2, ca.getLv_CLIENTE());
        ps.setString(3, ca.getLv_REFERENCIA());
        ps.setString(4, ca.getLv_ORIGEN());
        ps.setString(5, ca.getLv_DESTINO());
        ps.setString(6, ca.getLv_TELEFONO());
        ps.setFloat(7, ca.getLf_VALOR());
        ps.setString(8, ca.getLv_RESERVA());
        ps.setString(9, ca.getLv_ESTADO_CARRERA());
        ps.setString(10, ca.getlv_FECHA_HORA_REGISTRO());
        ps.setString(11, ca.getLv_FECHA_HORA_RESERVA());
        ps.setString(12, ca.getLv_USUARIO_ID());
        n=ps.executeUpdate();
        cm.desconectar();
        return n;
        }else{
        insertCarrera="INSERT INTO CARRERAS (ID, CLIENTE, REFERENCIA, ORIGEN, DESTINO, TELEFONO, VALOR, MOVIL, RESERVA, ESTADO_CARRERA,FECHA_HORA_REGISTRO, FECHA_HORA_RESERVA, USUARIO_ID) VALUES ((?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), (?), (?), (?),(?),(?), to_date(?,'dd/mm/yyyy hh24:mi:ss'), to_date(?,'dd/mm/yyyy hh24:mi:ss'),(?))";
        PreparedStatement ps = cm.preparedStatement(insertCarrera);
        ps.setInt(1, obtenerIdCarrera);
        ps.setString(2, ca.getLv_CLIENTE());
        ps.setString(3, ca.getLv_REFERENCIA());
        ps.setString(4, ca.getLv_ORIGEN());
        ps.setString(5, ca.getLv_DESTINO());
        ps.setString(6, ca.getLv_TELEFONO());
        ps.setFloat(7, ca.getLf_VALOR());
        ps.setInt(8, movil);
        ps.setString(9, ca.getLv_RESERVA());
        ps.setString(10, ca.getLv_ESTADO_CARRERA());
        ps.setString(11, ca.getlv_FECHA_HORA_REGISTRO());
        ps.setString(12, ca.getLv_FECHA_HORA_RESERVA());
        ps.setString(13, ca.getLv_USUARIO_ID());
        n=ps.executeUpdate();
        cm.desconectar();
        return n;
        }
        
        
    }
     
     public Vector obtenerDatosClientes(String telefono) throws SQLException{
        cm.conectar();
         int i=0;
        String selectDatosClientes="SELECT CL.NOMBRES NOMBRES,CA.ORIGEN ORIGEN,CA.REFERENCIA REFERENCIA,CA.DESTINO DESTINO ,CA.VALOR VALOR FROM CARRERAS CA, CLIENTES CL WHERE CA.FECHA_HORA_REGISTRO = (SELECT MAX (FECHA_HORA_REGISTRO) FROM CARRERAS WHERE TELEFONO =(?)) AND CA.TELEFONO =(?) AND CA.TELEFONO = CL.TELEFONO";
        Vector v1 = new Vector();
        PreparedStatement ps = cm.preparedStatement(selectDatosClientes);
        ps.setString(1, telefono);
        ps.setString(2, telefono);
        ResultSet r = ps.executeQuery();
        while(r.next()){
       v1.addElement(r.getString("NOMBRES"));
       v1.addElement(r.getString("ORIGEN"));
       v1.addElement(r.getString("REFERENCIA"));
       v1.addElement(r.getString("DESTINO"));
       v1.addElement(r.getFloat("VALOR"));
        }
        cm.desconectar();
        return v1;
    }
     
     public Vector obtenerHistorialCarreras() throws SQLException{
        cm.conectar();
         String selectDatosCarreras="SELECT TABLA.CLIENTE CLIENTE, TABLA.TELEFONO TELEFONO, TABLA.ORIGEN ORIGEN, TABLA.DESTINO DESTINO,TABLA.REFERENCIA REFERENCIA, TABLA.VALOR VALOR, TABLA.MOVIL MOVIL, (SELECT PLACA FROM CHOFERES WHERE MOVIL = TABLA.MOVIL) PLACA, (SELECT NUMERO_SORTEO FROM DETALLES_PROMOCIONES WHERE ID_PROMOCION = (SELECT ID FROM PROMOCIONES WHERE ESTADO='A') AND ID_CARRERA = TABLA.ID) NUMERO_SORTEO, TABLA.FECHA_HORA_REGISTRO FECHA_HORA_REGISTRO, TABLA.RESERVA RESERVA, TABLA.FECHA_HORA_RESERVA FECHA_HORA_RESERVA, TABLA.ESTADO_CARRERA ESTADO_CARRERA FROM (SELECT CLIENTE,ID, TELEFONO, ORIGEN, DESTINO, REFERENCIA, VALOR, MOVIL, TO_CHAR(FECHA_HORA_REGISTRO, 'DD/MM/RRRR HH24:MI:SS') FECHA_HORA_REGISTRO, RESERVA, TO_CHAR(FECHA_HORA_RESERVA, 'DD/MM/RRRR HH24:MI:SS') FECHA_HORA_RESERVA, ESTADO_CARRERA FROM CARRERAS WHERE RESERVA ='A' AND ESTADO_CARRERA = 'NA' ORDER BY ID DESC) TABLA UNION ALL SELECT TABLA.CLIENTE CLIENTE, TABLA.TELEFONO TELEFONO, TABLA.ORIGEN ORIGEN, TABLA.DESTINO DESTINO, TABLA.REFERENCIA REFERENCIA, TABLA.VALOR VALOR, TABLA.MOVIL MOVIL, (SELECT PLACA FROM CHOFERES WHERE MOVIL = TABLA.MOVIL) PLACA, (SELECT NUMERO_SORTEO FROM DETALLES_PROMOCIONES WHERE ID_PROMOCION = (SELECT ID FROM PROMOCIONES WHERE ESTADO='A') AND ID_CARRERA = TABLA.ID) NUMERO_SORTEO, TABLA.FECHA_HORA_REGISTRO FECHA_HORA_REGISTRO, TABLA.RESERVA RESERVA, TABLA.FECHA_HORA_RESERVA FECHA_HORA_RESERVA, TABLA.ESTADO_CARRERA ESTADO_CARRERA FROM (SELECT CLIENTE, ID, TELEFONO, ORIGEN, DESTINO, REFERENCIA, VALOR, MOVIL, TO_CHAR(FECHA_HORA_REGISTRO, 'DD/MM/RRRR HH24:MI:SS') FECHA_HORA_REGISTRO, RESERVA, TO_CHAR(FECHA_HORA_RESERVA, 'DD/MM/RRRR HH24:MI:SS') FECHA_HORA_RESERVA, ESTADO_CARRERA FROM CARRERAS WHERE RESERVA IS NULL OR RESERVA = 'F' OR (RESERVA = 'A' AND ESTADO_CARRERA = 'E') ORDER BY ID DESC) TABLA WHERE ROWNUM <= 80";
        Vector v1 = new Vector();
        PreparedStatement ps = cm.preparedStatement(selectDatosCarreras);
        ResultSet r = ps.executeQuery();
        while(r.next()){
        Carreras p1 = new Carreras(r.getString("CLIENTE"),r.getString("PLACA"),r.getString("REFERENCIA"),r.getString("ORIGEN"),r.getString("DESTINO"),r.getString("TELEFONO"),r.getFloat("VALOR"),r.getInt("MOVIL"),r.getString("RESERVA"), r.getString("ESTADO_CARRERA") ,r.getString("FECHA_HORA_REGISTRO"),r.getString("FECHA_HORA_RESERVA"),r.getString("NUMERO_SORTEO"));
        v1.addElement(p1);          
        }
        cm.desconectar();
        return v1;
}
     
     public Vector obtenerDatosUpdateHistorial(String telefono, String origen, String destino, String fecha_registro) throws SQLException{
        cm.conectar();
        int i=0;
        String selectDatosUpdateHistorial="SELECT C.ID ID, C.RESERVA RESERVA, C.ESTADO_CARRERA ESTADO_CARRERA, C.CLIENTE CLIENTE, C.REFERENCIA REFRENCIA, DP.NUMERO_SORTEO NUMERO_SORTEO FROM CARRERAS C, DETALLES_PROMOCIONES DP, PROMOCIONES P WHERE DP.ID_CARRERA = C.ID AND C.TELEFONO = (?) AND C.ORIGEN = (?) AND C.DESTINO = (?) AND P.ESTADO ='A' AND TO_CHAR(C.FECHA_HORA_REGISTRO, 'DD/MM/RRRR HH24:MI:SS') = (?)";
        Vector v1 = new Vector();
        PreparedStatement ps = cm.preparedStatement(selectDatosUpdateHistorial);
        ps.setString(1, telefono);
        ps.setString(2, origen);
        ps.setString(3, destino);
        ps.setString(4, fecha_registro);
        ResultSet r = ps.executeQuery();
        while(r.next()){
       v1.addElement(r.getInt("ID"));
       v1.addElement(r.getString("RESERVA"));
       v1.addElement(r.getString("ESTADO_CARRERA"));
       v1.addElement(r.getString("CLIENTE"));
       v1.addElement(r.getString("REFRENCIA"));
       v1.addElement(r.getString("NUMERO_SORTEO"));
        }
        cm.desconectar();
        return v1;
    }
     
          public Vector obtenerDatosUpdateHistorial2(String telefono, String origen, String destino, String fecha_registro) throws SQLException{
        cm.conectar();
        int i=0;
        String selectDatosUpdateHistorial="SELECT ID, RESERVA, ESTADO_CARRERA, CLIENTE, REFERENCIA FROM CARRERAS WHERE TELEFONO = (?) AND ORIGEN =(?) AND DESTINO =(?) AND TO_CHAR(FECHA_HORA_REGISTRO,'DD/MM/RRRR HH24:MI:SS') = (?)";
        Vector v1 = new Vector();
        PreparedStatement ps = cm.preparedStatement(selectDatosUpdateHistorial);
        ps.setString(1, telefono);
        ps.setString(2, origen);
        ps.setString(3, destino);
        ps.setString(4, fecha_registro);
        ResultSet r = ps.executeQuery();
        while(r.next()){
       v1.addElement(r.getInt("ID"));
       v1.addElement(r.getString("RESERVA"));
       v1.addElement(r.getString("ESTADO_CARRERA"));
       v1.addElement(r.getString("CLIENTE"));
       v1.addElement(r.getString("REFERENCIA"));
        }
        cm.desconectar();
        return v1;
    }
     
     public int ActualizarDatosChoferes(int id, String estado_reserva) throws SQLException{
        cm.conectar();
         int n1=0;
        String ActualizarDatosCarreras="UPDATE CARRERAS SET RESERVA = (?), ESTADO_CARRERA = 'A' WHERE ID = (?)";
        PreparedStatement ps = cm.preparedStatement(ActualizarDatosCarreras);
        ps.setString(1, estado_reserva);
        ps.setInt(2, id);
        n1=ps.executeUpdate();
        cm.desconectar();
        return n1;
    }
     
     public int ActualizarDatosChoferes2(int id, String estado_reserva, int movil) throws SQLException{
        cm.conectar();
         int n1=0;
        String ActualizarDatosCarreras="UPDATE CARRERAS SET RESERVA = (?), ESTADO_CARRERA = 'A', MOVIL = (?) WHERE ID = (?)";
        PreparedStatement ps = cm.preparedStatement(ActualizarDatosCarreras);
        ps.setString(1, estado_reserva);
        ps.setInt(2, movil);
        ps.setInt(3, id);
        n1=ps.executeUpdate();
        cm.desconectar();
        return n1;
    }
     
     
     public Vector obtenerHistorialCarrerasTelefono(String telefono, String fechaini, String fechafin) throws SQLException{
        cm.conectar();
        String selectDatosHistorialTelefono="SELECT C.TELEFONO TELEFONO, C.CLIENTE CLIENTE, C.ORIGEN ORIGEN, C.DESTINO DESTINO, C.VALOR VALOR, C.MOVIL MOVIL, to_char(C.FECHA_HORA_REGISTRO,'dd/mm/rrrr hh24:mi:ss') FECHA_HORA_REGISTRO, U.NOMBRES||' '||U.APELLIDOS OPERADORA FROM CARRERAS C,USUARIOS U WHERE C.USUARIO_ID=U.CEDULA AND C.TELEFONO = (?) AND C.FECHA_HORA_REGISTRO  >= TO_DATE((?), 'DD/MM/RRRR') AND C.FECHA_HORA_REGISTRO <= TO_DATE((?), 'DD/MM/RRRR')+1 order by C.FECHA_HORA_REGISTRO asc";
        Vector v1 = new Vector();
        PreparedStatement ps = cm.preparedStatement(selectDatosHistorialTelefono);
        ps.setString(1, telefono);
        ps.setString(2, fechaini);
        ps.setString(3, fechafin);
        ResultSet r = ps.executeQuery();
        while(r.next()){
        Carreras p1 = new Carreras("",r.getString("CLIENTE"),"",r.getString("ORIGEN"),r.getString("DESTINO"),r.getString("TELEFONO"),r.getFloat("VALOR"),r.getInt("MOVIL"),"", "" ,r.getString("FECHA_HORA_REGISTRO"),"",r.getString("OPERADORA"));
        v1.addElement(p1);          
        }
        cm.desconectar();
        return v1;
}
     
     public Vector obtenerHistorialCarrerasMovil(int movil, String fechaini, String fechafin) throws SQLException{
        cm.conectar();
        String selectDatosHistorialMovil="SELECT C.TELEFONO TELEFONO, CO.NOMBRES || ' ' || CO.APELLIDOS NOMBRE_CHOFER, C.CLIENTE CLIENTE, C.ORIGEN ORIGEN, C.DESTINO DESTINO, C.VALOR VALOR, C.MOVIL MOVIL, to_char(C.FECHA_HORA_REGISTRO,'dd/mm/rrrr hh24:mi:ss') FECHA_HORA_REGISTRO, U.NOMBRES||' '||U.APELLIDOS OPERADORA FROM CARRERAS C,USUARIOS U, CHOFERES CO WHERE C.USUARIO_ID=U.CEDULA AND C.MOVIL = CO.MOVIL AND C.MOVIL = (?) AND C.FECHA_HORA_REGISTRO  >= TO_DATE((?), 'DD/MM/RRRR') AND C.FECHA_HORA_REGISTRO <= TO_DATE((?), 'DD/MM/RRRR')+1 order by C.FECHA_HORA_REGISTRO asc";
        Vector v1 = new Vector();
        PreparedStatement ps = cm.preparedStatement(selectDatosHistorialMovil);
        ps.setInt(1, movil);
        ps.setString(2, fechaini);
        ps.setString(3, fechafin);
        ResultSet r = ps.executeQuery();
        while(r.next()){
        Carreras p1 = new Carreras("",r.getString("CLIENTE"), r.getString("NOMBRE_CHOFER"), r.getString("ORIGEN"),r.getString("DESTINO"),r.getString("TELEFONO"),r.getFloat("VALOR"),r.getInt("MOVIL"),"", "" ,r.getString("FECHA_HORA_REGISTRO"),"",r.getString("OPERADORA"));
        v1.addElement(p1);          
        }
        cm.desconectar();
        return v1;
}
     
     public Vector obtenerHistorialCarrerasFechas(String fechaini, String fechafin) throws SQLException{
        cm.conectar();
        String selectDatosHistorialFechas="SELECT C.TELEFONO TELEFONO, CO.NOMBRES || ' ' || CO.APELLIDOS NOMBRE_CHOFER, C.CLIENTE CLIENTE, C.ORIGEN ORIGEN, C.DESTINO DESTINO, C.VALOR VALOR, C.MOVIL MOVIL, to_char(C.FECHA_HORA_REGISTRO,'dd/mm/rrrr hh24:mi:ss') FECHA_HORA_REGISTRO, U.NOMBRES||' '||U.APELLIDOS OPERADORA FROM CARRERAS C,USUARIOS U, CHOFERES CO WHERE C.USUARIO_ID=U.CEDULA AND C.MOVIL = CO.MOVIL AND C.FECHA_HORA_REGISTRO  >= TO_DATE((?), 'DD/MM/RRRR') AND C.FECHA_HORA_REGISTRO <= TO_DATE((?), 'DD/MM/RRRR')+1 order by C.FECHA_HORA_REGISTRO asc";
        Vector v1 = new Vector();
        PreparedStatement ps = cm.preparedStatement(selectDatosHistorialFechas);
        ps.setString(1, fechaini);
        ps.setString(2, fechafin);
        ResultSet r = ps.executeQuery();
        while(r.next()){
        Carreras p1 = new Carreras("",r.getString("CLIENTE"), r.getString("NOMBRE_CHOFER"), r.getString("ORIGEN"),r.getString("DESTINO"),r.getString("TELEFONO"),r.getFloat("VALOR"),r.getInt("MOVIL"),"", "" ,r.getString("FECHA_HORA_REGISTRO"),"",r.getString("OPERADORA"));
        v1.addElement(p1);          
        }
        cm.desconectar();
        return v1;
}
     
     public Vector obtenerHistorialChoferesMovil(int movil, String fechaini, String fechafin) throws SQLException{
        cm.conectar();
        
        String selectDatosHistorialMovil="SELECT C.NOMBRES NOMBRES, C.APELLIDOS APELLIDOS, to_char(P.FECHA_REGISTRO,'dd/mm/rrrr hh24:mi:ss') FECHA_REGISTRO, P.VALOR VALOR, U.NOMBRES || ' ' || U.APELLIDOS OPERADORA FROM CHOFERES C, PAGOS_DIARIOS P, USUARIOS U WHERE P.MOVIL = C.MOVIL AND P.USUARIO_ID = U.CEDULA AND C.MOVIL = (?) AND P.FECHA_REGISTRO >= TO_DATE((?), 'DD/MM/RRRR') AND P.FECHA_REGISTRO <= TO_DATE((?), 'DD/MM/RRRR') + 1 order by P.FECHA_REGISTRO asc";
        Vector v1 = new Vector();
        PreparedStatement ps = cm.preparedStatement(selectDatosHistorialMovil);
        ps.setInt(1, movil);
        ps.setString(2, fechaini);
        ps.setString(3, fechafin);
        ResultSet r = ps.executeQuery();
        while(r.next()){
        Carreras p1 = new Carreras("",r.getString("NOMBRES"),"",r.getString("APELLIDOS")," "," ",r.getFloat("VALOR"),null,"", "" ,r.getString("FECHA_REGISTRO"),"",r.getString("OPERADORA"));
         v1.addElement(p1);
        }
        cm.desconectar();
        return v1;
}
     
     public int obtenerIdCarrera() throws SQLException{
        cm.conectar();
        int id=0;
        String selectIDCarrera="SELECT max(ID) ID FROM CARRERAS";
        PreparedStatement ps = cm.preparedStatement(selectIDCarrera);
        ResultSet r = ps.executeQuery();
        while(r.next()){
            id = r.getInt("ID");
        }
        cm.desconectar();
        return id;
    }
     
      public int ActualizarReferencia(String referencia, float VALOR, String telefono, String origen, String destino, int movil, String Lc_telefono, String lc_origen, String lc_destino, int lc_movil, String fecha_hora) throws SQLException{
        cm.conectar();
        int n1=0;
        String ActualizarReferencia="UPDATE  CARRERAS A SET A.REFERENCIA = UPPER(?), A.VALOR = (?), A.TELEFONO = UPPER(?), A.ORIGEN = UPPER(?), A.DESTINO = UPPER(?), A.MOVIL = (?) WHERE A.TELEFONO = UPPER(?) AND A.ORIGEN = UPPER(?) AND A.DESTINO = UPPER(?) AND A.MOVIL = (?) AND TO_CHAR(A.FECHA_HORA_REGISTRO,'DD/MM/YYYY HH24:MI:SS') = (?)";
        PreparedStatement ps = cm.preparedStatement(ActualizarReferencia);
        ps.setString(1, referencia);
        ps.setFloat(2, VALOR);
        ps.setString(3, telefono);
        ps.setString(4, origen);
        ps.setString(5, destino);
        ps.setInt(6, movil);
        ps.setString(7, Lc_telefono);
        ps.setString(8, lc_origen);
        ps.setString(9, lc_destino);
        ps.setInt(10, lc_movil);
        ps.setString(11, fecha_hora);
        n1=ps.executeUpdate();
        cm.desconectar();
        return n1;
    }
      
         public int ActualizarMovil(int nuevo_movil, String telefono, String origen, String destino, int movil, String fecha_hora) throws SQLException{
        cm.conectar();
        int n1=0;
        String ActualizarMovil="UPDATE  CARRERAS A SET A.MOVIL = (?) WHERE A.TELEFONO = (?) AND A.ORIGEN = (?) AND A.DESTINO = (?) AND A.MOVIL = (?) AND TO_CHAR(A.FECHA_HORA_REGISTRO,'DD/MM/YYYY HH24:MI:SS') = (?)";
        PreparedStatement ps = cm.preparedStatement(ActualizarMovil);
        ps.setInt(1, nuevo_movil);
        ps.setString(2, telefono);
        ps.setString(3, origen);
        ps.setString(4, destino);
        ps.setInt(5, movil);
        ps.setString(6, fecha_hora);
        n1=ps.executeUpdate();
        cm.desconectar();
        return n1;
    }
     
     public int ActualizarErronea(String telefono, String origen, String destino, int movil, String fecha_hora) throws SQLException{
        cm.conectar();
        int n1=0;
        String ActualizarErronea=null;
        if(movil ==0){
            ActualizarErronea="UPDATE  CARRERAS A SET A.ESTADO_CARRERA = 'E' WHERE A.TELEFONO = (?) AND A.ORIGEN = (?) AND A.DESTINO = (?) AND TO_CHAR(A.FECHA_HORA_REGISTRO,'DD/MM/YYYY HH24:MI:SS') = (?)";
            PreparedStatement ps = cm.preparedStatement(ActualizarErronea);
            ps.setString(1, telefono);
            ps.setString(2, origen);
            ps.setString(3, destino);
            ps.setString(4, fecha_hora);
            n1=ps.executeUpdate();
        }else{
            ActualizarErronea="UPDATE  CARRERAS A SET A.ESTADO_CARRERA = 'E' WHERE A.TELEFONO = (?) AND A.ORIGEN = (?) AND A.DESTINO = (?) AND A.MOVIL = (?) AND TO_CHAR(A.FECHA_HORA_REGISTRO,'DD/MM/YYYY HH24:MI:SS') = (?)";
            PreparedStatement ps = cm.preparedStatement(ActualizarErronea);
            ps.setString(1, telefono);
            ps.setString(2, origen);
            ps.setString(3, destino);
            ps.setInt(4, movil);
            ps.setString(5, fecha_hora);
            n1=ps.executeUpdate();
        }
        
        
        cm.desconectar();
        return n1;
    }
     
      public String obtenerNombrecliente(String telefono, String origen, String destino, String fecha) throws SQLException{
        cm.conectar();
        String nombrecliente = null;
        String selectNombreCliente="SELECT A.CLIENTE CLIENTE FROM CARRERAS A WHERE A.TELEFONO = (?) AND A.ORIGEN = (?) AND A.DESTINO = (?) AND TO_CHAR(A.FECHA_HORA_REGISTRO, 'DD/MM/YYYY HH24:MI:SS') = (?) ";
        PreparedStatement ps = cm.preparedStatement(selectNombreCliente);
        ps.setString(1, telefono);
        ps.setString(2, origen);
        ps.setString(3, destino);
        ps.setString(4, fecha);
        ResultSet r = ps.executeQuery();
        while(r.next()){
            nombrecliente = r.getString("CLIENTE");
        }
        cm.desconectar();
        return nombrecliente;
    }
}
