/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONEXION;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import static com.itextpdf.text.Element.ALIGN_CENTER;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author jcardozo
 */
public class PDF {
    PdfWriter writer = null;
 
    public PDF() {
        super();
    }
 
    public boolean crearPDF(String archivo,String titulo,String texto){
        //Creamos un documento, Hoja tamaño carta y los margenes
        Document documento = new Document(PageSize.LETTER, 0, 0, 0, 0);
 
        try {      
            //Instanciamos el archivo a utilizar
            writer = PdfWriter.getInstance(documento, new FileOutputStream("E:\\pdffastcart\\"+archivo));
 
            //Abrimos el documento para la edicion
            documento.open();
 
            //Vamos a agregar una imagen en la primera parte del documento
 
            try {
              //Para agregar texto al documento se utilizan el Paragrahp,
              //Primero creamos uno para poner un titulo centrado en color rojo
              Paragraph parrafo = new Paragraph();
              parrafo.setAlignment(Paragraph.ALIGN_CENTER);
              parrafo.setFont(FontFactory.getFont("Sans",18,Font.BOLD));
              parrafo.add("\n"+titulo);
              //Agregamos el titulo y el texto al documento
              documento.add(parrafo);
            } catch (DocumentException ex) {
              ex.printStackTrace();
              return false;
            }
            
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
                
            //Generar tabla del reporte
                PdfPTable tabla = new PdfPTable(7);
                
                
                PdfPCell celda =new PdfPCell (new Paragraph("Telefono",
                FontFactory.getFont("arial",   // fuente
                10,// tamaño
                com.itextpdf.text.Font.BOLD)));// color
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celda);
                
                celda =new PdfPCell (new Paragraph("Cliente",
                FontFactory.getFont("arial",   // fuente
                10,// tamaño
                com.itextpdf.text.Font.BOLD)));// color
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celda);
                
                celda =new PdfPCell (new Paragraph("Origen",
                FontFactory.getFont("arial",   // fuente
                10,                            // tamaño
                com.itextpdf.text.Font.BOLD)));             // color
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celda);
                
                celda =new PdfPCell (new Paragraph("Destino",
                FontFactory.getFont("arial",   // fuente
                10,                            // tamaño
                com.itextpdf.text.Font.BOLD)));             // color
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celda);
                
                celda =new PdfPCell (new Paragraph("Valor",
                FontFactory.getFont("arial",   // fuente
                10,                            // tamaño
                com.itextpdf.text.Font.BOLD)));             // color
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celda);
                
                celda =new PdfPCell (new Paragraph("Movil",
                FontFactory.getFont("arial",   // fuente
                10,                            // tamaño
                com.itextpdf.text.Font.BOLD)));             // color
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celda);
                
                celda =new PdfPCell (new Paragraph("Fecha hora Registro",
                FontFactory.getFont("arial",   // fuente
                10,                            // tamaño
                com.itextpdf.text.Font.BOLD)));             // color
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celda);

                for (int i = 0; i < 21; i++)
                {
                        tabla.addCell("celda " + i);
                }
                
                PdfPCell celdaFinal = new PdfPCell(new Paragraph("Final de la tabla"));
             
            // Indicamos cuantas columnas ocupa la celda
            celdaFinal.setColspan(3);
            tabla.addCell(celdaFinal);
            
            
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
    public static void main(String[] args) {
        PDF pdf = new PDF();
        pdf.crearPDF("archivo.pdf", "REPORTE SISTEMA FAST-CART", "Reporte de las carreras del dia");
    }
}
