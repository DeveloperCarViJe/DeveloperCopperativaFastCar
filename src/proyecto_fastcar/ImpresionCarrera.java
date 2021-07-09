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

public class ImpresionCarrera {
  public static String nameclientv=null;
  public static  String phonev = null;
  public static  String adressv = null;
  public static  String referencev = null;
  public static  String destinov = null;
  public static  String valorv= null;
  public static  String movilv=null;
  public static  String datev = null;
public ImpresionCarrera(String nameclient, String phone, String adress, String reference, String destino, String valor, String movil, String date) {
nameclientv = nameclient;
phonev = phone;
adressv = adress;
referencev = reference;
destinov = destino;
valorv = valor;
movilv= movil;
datev = date;
}  
  public void print() throws Exception {
    PrinterJob pj = PrinterJob.getPrinterJob();

    PageFormat pf = pj.defaultPage();
    Paper paper = new Paper();
    double margin = 20; // half inch
    paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight()
        - margin * 2);
    pf.setPaper(paper);

    pj.setPrintable(new MyPrintable(), pf);
    if (pj.printDialog()) {
      try {
        pj.print();
      } catch (PrinterException e) {
        System.out.println(e);
      }
    }
  }
}

class MyPrintable implements Printable {

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
    System.out.println(ImpresionCarrera.phonev.substring(0,2));
    g2.drawString("Cliente: "+ImpresionCarrera.nameclientv.toUpperCase(), 20, 50);
    //if (ImpresionCarrera.phonev.length()==10 && ImpresionCarrera.phonev.substring(0,2).equals("09")){
    //g2.drawString("Telefono: "+ImpresionCarrera.phonev, 20, 65);
    //}else{
    g2.drawString("Telefono: xxxxxxxxxx", 20, 65);    
    //}
        
    
    if (ImpresionCarrera.adressv.length() <23){
     g2.drawString("Direccion: "+ImpresionCarrera.adressv.toUpperCase(), 20, 80);
    }else{
     g2.drawString("Direccion: "+ImpresionCarrera.adressv.substring(0, 23).toUpperCase(), 20, 80);
     g2.drawString(ImpresionCarrera.adressv.substring(23).toUpperCase(), 20, 88);
    }
    
   if ((ImpresionCarrera.adressv.length() <23 && ImpresionCarrera.referencev.length() <23)||(ImpresionCarrera.referencev.length() <23)){
    g2.drawString("Referencia: "+ImpresionCarrera.referencev.toUpperCase(), 20, 103);
   }else{
    g2.drawString("Referencia: "+ImpresionCarrera.referencev.substring(0, 23).toUpperCase(), 20, 103);
    g2.drawString(ImpresionCarrera.referencev.substring(23).toUpperCase(), 20, 111);
    }    
    
    if((ImpresionCarrera.adressv.length() <23 && ImpresionCarrera.referencev.length() <23 && ImpresionCarrera.destinov.length()<23)||(ImpresionCarrera.destinov.length()<23)){
    g2.drawString("Destino: "+ImpresionCarrera.destinov.toUpperCase(), 20, 126);
    g2.drawString("Valor: "+ImpresionCarrera.valorv, 20, 141);
     g2.drawString("Movil: "+ImpresionCarrera.movilv, 20, 156);
     g2.drawString("Fecha: "+ImpresionCarrera.datev, 20, 171);
    }else{
    g2.drawString("Destino: "+ImpresionCarrera.destinov.substring(0, 23).toUpperCase(), 20, 126);
    g2.drawString(ImpresionCarrera.destinov.substring(23).toUpperCase(), 20, 138);
    g2.drawString("Valor: "+ImpresionCarrera.valorv, 20, 153);
     g2.drawString("Movil: "+ImpresionCarrera.movilv, 20, 168);
     g2.drawString("Fecha: "+ImpresionCarrera.datev, 20, 183);
     
    }
    return PAGE_EXISTS;
  }
}

