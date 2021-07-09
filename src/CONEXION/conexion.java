  package CONEXION;

/**
 *
 * @author JOHNCARDOZO
 */
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
//import javax.swing.*;
public class conexion {
    static Connection con=null;
    static Statement st=null;
    static ResultSet rs=null;
    
    static String bd="XE";
    
    //static String login="proyecto_coop";
    //static String password="proyecto_coop";
    static String login="coopfastcar";
    static String password="AdminFastcar@_cooperativa";
    //static String login="sms"; //trabajo
    //static String password="sms123"; //trabajo
    static String url="jdbc:oracle:thin:@localhost:1521:XE";

    //static String url="jdbc:oracle:thin:@192.168.37.34:1521:COLECTMP"; //trabajo
    
    public conexion() throws ClassNotFoundException, SQLException{
        Class.forName("oracle.jdbc.OracleDriver");
        con = null;        
    }
    
    public String obtenerIp() throws UnknownHostException{
        InetAddress direccion = InetAddress.getLocalHost();
            String nombreDelHost = direccion.getHostName();//nombre host
            String IP_local = direccion.getHostAddress();//ip como String
            System.out.println("La IP de la maquina local es : " + IP_local);
            System.out.println("El nombre del host local es : " + nombreDelHost);
            return IP_local;
    }
    
    public Connection conectar() throws SQLException{
       // String url2=conexion.obtenerIp();
        //url="jdbc:oracle:thin:@"+obtenerIp.IP_local;
        //conexion con2= new conexion();
        //String url = "jdbc:oracle:thin:@"+con2.obtenerIp()+":1521:XE";
        con = DriverManager.getConnection(url, login,password);  
        return con;
    }
    
    public void desconectar() throws SQLException{
        if(con!=null)
            con.close();
    }
    
    public ResultSet executequery(String sql) throws SQLException{
        PreparedStatement ps;
        ResultSet rs = null;
        ps = con.prepareStatement(sql);        
        rs = ps.executeQuery();
        return rs;
    }
    
     public PreparedStatement preparedStatement(String sql) throws SQLException{
        return con.prepareStatement(sql);
        
    }
}
