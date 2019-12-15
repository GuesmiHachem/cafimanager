package com.cafimanager.pdf;

import com.cafimanager.model.Ville;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class GeneratePdfReport {

    private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);

    public static  ByteArrayInputStream citiesReport(List<Ville> villes ,String id) {

    	Rectangle pageSize = new Rectangle(PageSize.A7);
    	pageSize.setBackgroundColor(BaseColor.WHITE);
    	Document document = new Document( pageSize );
    	
    	//Document document = new Document();
        //document.setPageSize(PageSize.A4.rotate());
       // document.setPageSize(PageSize.A7);
       // document.setPageSize(PageSize.A7);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
       

        try {

        	
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(140);
            table.setWidths(new int[]{3, 1, 3});
            
            table.getDefaultCell().setBorder(0);
            Font headFont = FontFactory.getFont(FontFactory.COURIER,8);
            
            PdfPCell hcell;
            
            hcell = new PdfPCell(new Phrase("Désignation", FontFactory.getFont(FontFactory.COURIER_BOLD,8)));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBorder(0);
            table.addCell(hcell);
            
            
            hcell = new PdfPCell(new Phrase("Qte", FontFactory.getFont(FontFactory.COURIER_BOLD,8)));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBorder(0);
            table.addCell(hcell);

           

            hcell = new PdfPCell(new Phrase("Total", FontFactory.getFont(FontFactory.COURIER_BOLD,8)));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBorder(0);
            table.addCell(hcell);
           

            for (Ville ville : villes) {

                PdfPCell cell;

                

                cell = new PdfPCell(new Phrase(ville.getLibell(), headFont));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(0);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(ville.getId()+"", headFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(0);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(ville.getLibell()), headFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPaddingRight(5);
                cell.setBorder(0);
                table.addCell(cell);
            }
            hcell = new PdfPCell(new Phrase("-----------------------------------", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setColspan(3);
            hcell.setPaddingRight(5);
            hcell.setBorder(0);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Total", FontFactory.getFont(FontFactory.COURIER_BOLD,12)));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setColspan(2);
            hcell.setPaddingRight(5);
            hcell.setBorder(0);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("3,500", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setColspan(1);
            hcell.setPaddingRight(5);
            hcell.setBorder(0);
            table.addCell(hcell);
            
            
            
            
            
            PdfWriter.getInstance(document, out);
            document.open();
            document.addAuthor("Guesmi Hachem");
            document.addLanguage("FR");
            document.addCreationDate();
            
            //document.top(2);
            Paragraph cafiManager=new Paragraph("CafiManager",FontFactory.getFont(FontFactory.TIMES_BOLD,8));
            cafiManager.setAlignment(Element.ALIGN_LEFT);
            //cafiManager.setPaddingTop(10);
            document.add(cafiManager);
            
            Paragraph nomCafe=new Paragraph("MyCoffe\n",FontFactory.getFont(FontFactory.TIMES_ROMAN,13));
            nomCafe.setAlignment(Element.ALIGN_CENTER);
            document.add(nomCafe);
            
            Paragraph adresse=new Paragraph("Tunis 10 rue bacha cite olympique",FontFactory.getFont(FontFactory.COURIER,7));
            adresse.setAlignment(Element.ALIGN_CENTER);
            document.add(adresse);
            
            
            document.add(table);

          
          /*  try {
    		createTitle3(document,"Titre 3"+id);
    		} catch (DocumentException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            */
            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }
        

        return new ByteArrayInputStream(out.toByteArray());
    }
    
    
    
    public static void createTitle3(Document document, String chaine) throws DocumentException, IOException {

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(140);
       //table.set
       // table.setWidths(new int[]{1});

        PdfPCell cell1 = new Colonne(chaine, 7, BaseColor.BLACK, BaseColor.ORANGE, 5, PdfPCell.ALIGN_CENTER, 1).getPdfCell();
        PdfPCell cell2 = new Colonne(chaine, 7, BaseColor.BLACK, BaseColor.BLUE, 5, PdfPCell.ALIGN_CENTER, 1).getPdfCell();
        PdfPCell cell3 = new Colonne(chaine, 7, BaseColor.BLACK, BaseColor.CYAN, 5, PdfPCell.ALIGN_CENTER, 1).getPdfCell();
        PdfPCell cell4 = new Colonne(chaine, 7, BaseColor.BLACK, BaseColor.DARK_GRAY, 5, PdfPCell.ALIGN_CENTER, 1).getPdfCell();
        PdfPCell cell5 = new Colonne(chaine, 7, BaseColor.BLACK, BaseColor.GRAY, 5, PdfPCell.ALIGN_CENTER, 1).getPdfCell();
        PdfPCell cell6 = new Colonne(chaine, 7, BaseColor.BLACK, BaseColor.GREEN, 5, PdfPCell.ALIGN_CENTER, 1).getPdfCell();
        PdfPCell cell7 = new Colonne(chaine, 7, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_CENTER, 1).getPdfCell();
        PdfPCell cell8 = new Colonne(chaine, 7, BaseColor.BLACK, BaseColor.MAGENTA, 5, PdfPCell.ALIGN_CENTER, 1).getPdfCell();
        PdfPCell cell9 = new Colonne(chaine, 7, BaseColor.BLACK, BaseColor.PINK, 5, PdfPCell.ALIGN_CENTER, 1).getPdfCell();
        PdfPCell cell10 = new Colonne(chaine, 7, BaseColor.BLACK, BaseColor.RED, 5, PdfPCell.ALIGN_CENTER, 1).getPdfCell();
        
        //Colonne cell = new Colonne(chaine, 12, BaseColor.BLACK, BaseColor.ORANGE, 5, PdfPCell.ALIGN_CENTER, 1);
        
        //cell.setBorder(Rectangle.BOX);
        //cell.setBorderWidth(0);
        // cell.setBorderColor(BaseColor.BLUE);
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        
        
        table.addCell(cell5);
        table.addCell(cell6);
        table.addCell(cell7);
        table.addCell(cell8);
        
        table.addCell(cell9);
        table.addCell(cell10);
        table.addCell(cell9);
        table.addCell(cell10);
        
        document.add(table);
    }
    
    
    
   
    
   
}