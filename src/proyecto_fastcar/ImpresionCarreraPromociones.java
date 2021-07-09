/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_fastcar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.ImageIcon;

public class ImpresionCarreraPromociones {
  public static String nameclientv=null;
  public static  String phonev = null;
  public static  String adressv = null;
  public static  String referencev = null;
  public static  String destinov = null;
  public static  String valorv= null;
  public static  String movilv=null;
  public static  String datev = null;
  public static  String numeroSorteov = null;
public ImpresionCarreraPromociones(String nameclient, String phone, String adress, String reference, String destino, String valor, String movil, String date, String numeroSorteo) {
nameclientv = nameclient;
phonev = phone;
adressv = adress;
referencev = reference;
destinov = destino;
valorv = valor;
movilv= movil;
datev = date;
numeroSorteov = numeroSorteo;
}  
  public void print() throws Exception {
    PrinterJob pj = PrinterJob.getPrinterJob();

    PageFormat pf = pj.defaultPage();
    Paper paper = new Paper();
    double margin = 20; // half inch
    paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight()
        - margin * 2);
    pf.setPaper(paper);

    pj.setPrintable(new MyPrintable2(), pf);
    if (pj.printDialog()) {
      try {
        pj.print();
      } catch (PrinterException e) {
        System.out.println(e);
      }
    }
  }
}

class MyPrintable2 implements Printable {

   public int print(Graphics g, PageFormat pf, int pageIndex) {
    if (pageIndex != 0){
      return NO_SUCH_PAGE;
    }
    Graphics2D g2 = (Graphics2D) g;
    g2.setFont(new Font("Calibri", Font.BOLD, 20));
    g2.setPaint(Color.BLACK);
    g2.drawString("FAST-CAR", 75, 35);
    g2.setFont(new Font("Calibri", Font.BOLD, 11));
    g2.setPaint(Color.BLACK);
    g2.drawString("Cliente: "+ImpresionCarreraPromociones.nameclientv.toUpperCase(), 20, 50);
    //if (ImpresionCarreraPromociones.phonev.length()==10 && ImpresionCarreraPromociones.phonev.substring(0,2).equals("09")){
    //    g2.drawString("Telefono: "+ImpresionCarreraPromociones.phonev, 20, 65);
    //}else{
    g2.drawString("Telefono: xxxxxxxxxx", 20, 65);    
    //}
    
    if (ImpresionCarreraPromociones.adressv.length() <23){
     g2.drawString("Direccion: "+ImpresionCarreraPromociones.adressv.toUpperCase(), 20, 80);
    }else{
     g2.drawString("Direccion: "+ImpresionCarreraPromociones.adressv.substring(0, 23).toUpperCase(), 20, 80);
     g2.drawString(ImpresionCarreraPromociones.adressv.substring(23).toUpperCase(), 20, 88);
    }
    
   if ((ImpresionCarreraPromociones.adressv.length() <23 && ImpresionCarreraPromociones.referencev.length() <23)||(ImpresionCarreraPromociones.referencev.length() <23)){
    g2.drawString("Referencia: "+ImpresionCarreraPromociones.referencev.toUpperCase(), 20, 103);
   }else{
    g2.drawString("Referencia: "+ImpresionCarreraPromociones.referencev.substring(0, 23).toUpperCase(), 20, 103);
    g2.drawString(ImpresionCarreraPromociones.referencev.substring(23).toUpperCase(), 20, 111);
    }    
    
    if((ImpresionCarreraPromociones.adressv.length() <23 && ImpresionCarreraPromociones.referencev.length() <23 && ImpresionCarreraPromociones.destinov.length()<23)||(ImpresionCarreraPromociones.destinov.length()<23)){
    g2.drawString("Destino: "+ImpresionCarreraPromociones.destinov.toUpperCase(), 20, 126);
    g2.drawString("Valor: "+ImpresionCarreraPromociones.valorv, 20, 141);
    g2.drawString("Numero sorteo: "+ImpresionCarreraPromociones.numeroSorteov, 20, 156);
     g2.drawString("Movil: "+ImpresionCarreraPromociones.movilv, 20, 171);
     g2.drawString("Fecha: "+ImpresionCarreraPromociones.datev, 20, 186);
    }else{
    g2.drawString("Destino: "+ImpresionCarreraPromociones.destinov.substring(0, 23).toUpperCase(), 20, 126);
    g2.drawString(ImpresionCarreraPromociones.destinov.substring(23).toUpperCase(), 20, 138);
    g2.drawString("Valor: "+ImpresionCarreraPromociones.valorv, 20, 153);
    g2.drawString("Numero sorteo: "+ImpresionCarreraPromociones.numeroSorteov, 20, 168);
     g2.drawString("Movil: "+ImpresionCarreraPromociones.movilv, 20, 183);
     g2.drawString("Fecha: "+ImpresionCarreraPromociones.datev, 20, 198);
    }
    return PAGE_EXISTS;
  }
}

