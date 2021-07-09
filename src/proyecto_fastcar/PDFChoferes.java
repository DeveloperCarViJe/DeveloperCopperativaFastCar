/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_fastcar;

import CONEXION.*;
import BO.CarrerasBo;
import JB.Carreras;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import static com.itextpdf.text.Element.ALIGN_CENTER;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author jcardozo
 */
public class PDFChoferes {
    PdfWriter writer = null;
 
    public PDFChoferes() {
        super();
    }
 
    public boolean crearPDF(String archivo,String titulo,String texto, Vector datos) throws BadElementException, IOException{
        //Creamos un documento, Hoja tamaño carta y los margenes
        Document documento = new Document(PageSize.LETTER, 0, 0, 0, 0);
 
        try {      
            //Instanciamos el archivo a utilizar
            writer = PdfWriter.getInstance(documento, new FileOutputStream("D:\\DocumentosPdfFastcar\\"+archivo));
 
            //Abrimos el documento para la edicion
            documento.open();
 
            //Vamos a agregar una imagen en la primera parte del documento
 
            try {

              //Para agregar texto al documento se utilizan el Paragrahp,
              //Primero creamos uno para poner un titulo centrado en color rojo

              Paragraph parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.setFont(FontFactory.getFont("Sans",18,Font.BOLD, BaseColor.RED));
                documento.add(parrafo);
                documento.add(new Paragraph("\n"));
                
              Image imagen = Image.getInstance("D:\\ImagenFastcar\\iconoFastcar.png");
              //imagen.setAlignment(Element.ALIGN_RIGHT);
              imagen.scaleToFit(100, 200);
              imagen.setAbsolutePosition(40f, 753f);
              documento.add(imagen);
              
              imagen = Image.getInstance("D:\\ImagenFastcar\\iconoFastcar.png");
              //imagen.setAlignment(Element.ALIGN_RIGHT);
              imagen.scaleToFit(100, 200);
              imagen.setAbsolutePosition(470f, 753f);
              documento.add(imagen);

              parrafo = new Paragraph();
              parrafo.setAlignment(Paragraph.ALIGN_CENTER);
              parrafo.setFont(FontFactory.getFont("Sans",18,Font.BOLD));
              parrafo.add(titulo);
              documento.add(parrafo);
              
            } catch (DocumentException ex) {
              ex.printStackTrace();
              return false;
            }
                Carreras c = (Carreras)datos.get(0);
                
                Paragraph parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.setFont(FontFactory.getFont("Sans",18,Font.BOLD));
                parrafo.add("\n"+texto);
                documento.add(parrafo);
            
                parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.setFont(FontFactory.getFont("Sans",18,Font.BOLD, BaseColor.RED));
                documento.add(parrafo);
                documento.add(new Paragraph("\n"));
                
                parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.setFont(FontFactory.getFont("Sans",15,Font.BOLD));
                parrafo.add("NOMBRE CHOFER: "+c.getLv_CLIENTE()+" "+c.getLv_ORIGEN());
                documento.add(parrafo);
                
                parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.setFont(FontFactory.getFont("Sans",18,Font.BOLD, BaseColor.RED));
                documento.add(parrafo);
                documento.add(new Paragraph("\n"));
                
            //Generar tabla del reporte
                
                PdfPTable tabla = new PdfPTable(3);
                float[] medidaCeldas = {0.30f, 0.20f, 0.55f};
                tabla.setWidths(medidaCeldas);
                
                
                PdfPCell celda =new PdfPCell (new Paragraph("Fecha Registro",
                FontFactory.getFont("arial",   // fuente
                12,// tamaño
                com.itextpdf.text.Font.BOLD)));// color
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);                
                tabla.addCell(celda);
                
                celda =new PdfPCell (new Paragraph("Valor",
                FontFactory.getFont("arial",   // fuente
                12,// tamaño
                com.itextpdf.text.Font.BOLD)));// color
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celda);
                
                celda =new PdfPCell (new Paragraph("Usuario",
                FontFactory.getFont("arial",   // fuente
                12,// tamaño
                com.itextpdf.text.Font.BOLD)));// color
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celda);
                
                float ValorAcum=0;
                for (int i = 0; i < datos.size(); i++)
                {
                        c = (Carreras)datos.get(i);
                        //tabla.addCell(c.getLv_TELEFONO());
                        celda =new PdfPCell (new Paragraph(c.getlv_FECHA_HORA_REGISTRO(),
                        FontFactory.getFont("arial",   // fuente
                        9,                            // tamaño
                        com.itextpdf.text.Font.BOLD)));             // color
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        //tabla.addCell(c.getLv_CLIENTE());
                        celda =new PdfPCell (new Paragraph(String.valueOf(c.getLf_VALOR()),
                        FontFactory.getFont("arial",   // fuente
                        9,                            // tamaño
                        com.itextpdf.text.Font.BOLD)));             // color
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        ValorAcum = ValorAcum + c.getLf_VALOR();
                        
                        celda =new PdfPCell (new Paragraph(c.getLv_USUARIO_ID(),
                        FontFactory.getFont("arial",   // fuente
                        9,                            // tamaño
                        com.itextpdf.text.Font.BOLD)));             // color
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                }

                        celda =new PdfPCell (new Paragraph("TOTAL DE VALORES CANCELADO",
                        FontFactory.getFont("arial",   // fuente
                        9,                            // tamaño
                        com.itextpdf.text.Font.BOLD)));
                        celda.setColspan(2);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda); 
                        
                        celda =new PdfPCell (new Paragraph(String.valueOf(datos.size()),
                        FontFactory.getFont("arial",   // fuente
                        9,                            // tamaño
                        com.itextpdf.text.Font.BOLD)));
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda); 
                        
                        celda =new PdfPCell (new Paragraph("TOTAL DE VALOR",
                        FontFactory.getFont("arial",   // fuente
                        9,                            // tamaño
                        com.itextpdf.text.Font.BOLD)));
                        celda.setColspan(2);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda); 
                        
                        celda =new PdfPCell (new Paragraph(Float.toString(ValorAcum),
                        FontFactory.getFont("arial",   // fuente
                        9,                            // tamaño
                        com.itextpdf.text.Font.BOLD)));
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda); 
            
            
                documento.add(tabla);
            //Se debe cerrar el documento y el writter
            documento.close();
            writer.close();
            return true;
 
        } catch (FileNotFoundException | DocumentException   ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
