package com.cafimanager.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;

public class Colonne {

    public String text;
    public int size;
    public BaseColor color;
    public BaseColor background;
    public float padding;
    public int horizontalAlignment;
    public int colspan;

    public PdfPCell pdfCell;
    public Paragraph paragraph;
    public Chunk chunk;
    public Font font;

    public Colonne() {
        text = "";
        size = 10;
        color = BaseColor.BLACK;
        background = BaseColor.WHITE;
        padding = 5;
        horizontalAlignment = PdfPCell.ALIGN_LEFT;
        colspan = 1;
    }

    public Colonne(String text, int size, BaseColor color, BaseColor background, float padding, int horizontalAlignment, int colspan) {

        super();
        this.text = text;
        this.size = size;
        this.color = color;
        this.background = background;
        this.padding = padding;
        this.horizontalAlignment = horizontalAlignment;
        this.colspan = colspan;

        font = new Font(Font.FontFamily.TIMES_ROMAN, size, Font.NORMAL, color);
        chunk = new Chunk(text);
        chunk.setFont(font);
        paragraph = new Paragraph(chunk);
        pdfCell = new PdfPCell(paragraph);
        pdfCell.setBackgroundColor(background);
        pdfCell.setHorizontalAlignment(horizontalAlignment);
        pdfCell.setPadding(padding);
        pdfCell.setColspan(colspan);
    }

    public PdfPCell getPdfCell() {
        return pdfCell;
    }

} 
