package com.cafimanager.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cafimanager.model.Ville;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdfTicket {

	private static final Logger logger = LoggerFactory.getLogger(GeneratePdfTicket.class);

	public static ByteArrayInputStream citiesReport(List<Ville> villes, String id) {

		Rectangle pageSize = new Rectangle(PageSize.A7);
		pageSize.setBorderWidth(1);
		pageSize.setBorderColor(BaseColor.BLACK);
		// pageSize.setTop(50f);
		pageSize.setBackgroundColor(BaseColor.WHITE);
		Document document = new Document(pageSize);

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		Ticket ticket = new Ticket("CAFI MANAGER", "www.cafimanager.com", "71000233", "013", "MyCoffe",
				"Tunis 10 rue bacha cite olympique", "71123456", "2019-12-13", "14:12:06", "Hedi", "ZOUHAIR", "",
				"Merci pour votre visite");
		try {

			PdfPTable table = new PdfPTable(6);
			table.setWidthPercentage(140);
			// table.setWidths(new int[]{1, 1, 1,1,1,1});
			table.getDefaultCell().setBorder(0);
			// ==================================================================================================
			Font fontTitre13 = FontFactory.getFont(FontFactory.COURIER_BOLD, 13);
			Font fontTitre13Oblique = FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE, 13);
			Font fontTitre12 = FontFactory.getFont(FontFactory.COURIER_BOLD, 12);
			Font fontTitre10 = FontFactory.getFont(FontFactory.COURIER_BOLD, 10);
			Font fontTitre9 = FontFactory.getFont(FontFactory.COURIER_BOLD, 9);
			Font fontTitre8 = FontFactory.getFont(FontFactory.COURIER, 8);
			Font fontTitre7 = FontFactory.getFont(FontFactory.COURIER, 7);
			Font fontTitre6 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6);
			PdfPCell hcell;
			// ==================================================================================================
			hcell = new PdfPCell(
					new Phrase(ticket.getSocieteNom() + "\n" + ticket.getSocieteSite() + "\n" + ticket.getSocieteTel(),
							fontTitre7));
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(0);
			hcell.setColspan(3);
			table.addCell(hcell);
			// ================================
			hcell = new PdfPCell(new Phrase(ticket.getDate()+"\n"+ticket.getHeure(), fontTitre6));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(0);
			hcell.setColspan(3);
			table.addCell(hcell);
			// ==================================================================================================
			hcell = new PdfPCell(new Phrase(ticket.getNom(), fontTitre13));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(0);
			hcell.setColspan(6);
			table.addCell(hcell);
			// ==================================================================================================
			hcell = new PdfPCell(new Phrase(ticket.getAdresse(), fontTitre8));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(0);
			hcell.setColspan(6);
			table.addCell(hcell);
			// ==================================================================================================
			hcell = new PdfPCell(new Phrase("----------------------------------------", fontTitre7));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setColspan(6);
			hcell.setBorder(0);
			table.addCell(hcell);
			// ==================================================================================================
			hcell = new PdfPCell(new Phrase("N° :" + ticket.getNumero(), fontTitre7));
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(0);
			hcell.setColspan(6);
			table.addCell(hcell);
			// ================================
			hcell = new PdfPCell(new Phrase("Caissier :" + ticket.getCaissier(), fontTitre7));
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(0);
			hcell.setColspan(6);
			table.addCell(hcell);
			// ================================
			hcell = new PdfPCell(new Phrase("Serveur :" + ticket.getServeur(), fontTitre7));
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(0);
			hcell.setColspan(6);
			table.addCell(hcell);

			// ==================================================================================================
			hcell = new PdfPCell(new Phrase("Désignation", fontTitre9));
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(0);
			hcell.setColspan(2);
			table.addCell(hcell);
			// ================================
			hcell = new PdfPCell(new Phrase("Qte", fontTitre9));
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(0);
			hcell.setColspan(2);
			table.addCell(hcell);
			// ================================
			hcell = new PdfPCell(new Phrase("Total", fontTitre9));
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(0);
			hcell.setColspan(2);
			table.addCell(hcell);
			// ==================================================================================================
			for (Ville ville : villes) {

				PdfPCell cell;
				// ================================
				cell = new PdfPCell(new Phrase(ville.getLibell(), fontTitre7));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setBorder(0);
				cell.setColspan(2);
				table.addCell(cell);
				// ================================
				cell = new PdfPCell(new Phrase(ville.getId() + "", fontTitre7));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setBorder(0);
				cell.setColspan(2);
				table.addCell(cell);
				// ================================
				cell = new PdfPCell(new Phrase(String.valueOf(ville.getLibell()), fontTitre7));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setPaddingRight(5);
				cell.setBorder(0);
				cell.setColspan(2);
				table.addCell(cell);
			}

			// ==================================================================================================
			hcell = new PdfPCell(new Phrase("", fontTitre7));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setColspan(4);
			hcell.setBorder(0);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("-------------", fontTitre7));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setColspan(2);
			hcell.setBorder(0);
			table.addCell(hcell);
			// ================================
			hcell = new PdfPCell(new Phrase("Total", FontFactory.getFont(FontFactory.COURIER_BOLD, 12)));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setColspan(4);
			hcell.setBorder(0);
			table.addCell(hcell);
			// ================================
			hcell = new PdfPCell(new Phrase("3,500", fontTitre9));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			hcell.setColspan(2);
			hcell.setBorder(0);
			table.addCell(hcell);
			// ==================================================================================================
			hcell = new PdfPCell(new Phrase("" + ticket.getRemerciment(), fontTitre13Oblique));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setColspan(6);
			hcell.setBorder(0);
			table.addCell(hcell);

			// ==================================================================================================
			// ==================================================================================================
			PdfWriter.getInstance(document, out);
			document.open();

			document.add(table);
			document.close();
		} catch (DocumentException ex) {
			logger.error("Error occurred: {0}", ex);
		}

		return new ByteArrayInputStream(out.toByteArray());
	}

}