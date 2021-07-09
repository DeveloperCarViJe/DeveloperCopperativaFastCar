

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class HolaMundoPDF
{
	/**
	 * By:  Daniel Alvarez (a3dany@gmail.com)
	 * For: SoloInformaticaYAlgoMas.blogspot.com
	 * 24/12/2010
	 */
	public static void main(String[] a3d) throws FileNotFoundException, DocumentException
	{
		FileOutputStream archivo = new FileOutputStream("C:\\pruebapdf\\hola.pdf");
		Document documento = new Document();
		PdfWriter.getInstance(documento, archivo);
		documento.open();
		/*documento.add(new Paragraph("Reporte de carreras realizadas",
				FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.BOLD)));             // color
                
                PdfPTable tabla = new PdfPTable(3);
                for (int i = 0; i < 15; i++)
                {
                        tabla.addCell("celda " + i);
                }
                documento.add(tabla);*/
                Paragraph parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.setFont(FontFactory.getFont("Sans",18,Font.BOLD, BaseColor.RED));
                parrafo.add("\n REPORTE SISTEMA FAST-CART");
		documento.close();
	}
}
