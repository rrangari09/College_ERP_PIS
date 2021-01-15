/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Date;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 *
 * @author RohanShweta
 */
public class GeneratePDFAction extends org.apache.struts.action.Action {
    private static String FILE = "c:/temp/FirstPdf1.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);


    /* forward name="success" path="" */
    private static final String HOME = "home";
    HashMap<String,String> pdf_info;
    GenerateIDDAO id_dao=new GenerateIDDAO();

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          try {
            HttpSession hs=request.getSession(true);
            pdf_info=id_dao.generate_id(String.valueOf(hs.getAttribute("EmailID")),Integer.getInteger(String.valueOf((hs.getAttribute("UserID")))));
            String filename="R:\\software\\test.pdf";
            Document document = new Document();
            System.out.printf("PDF GEnerated");
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
   
        return mapping.findForward(HOME);
    }
    
     private static void addMetaData(Document document) {
        document.addTitle("ID Card");
        document.addSubject("Student ID");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("NITK Admin");
        document.addCreator("Auto");
    }

    private static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        preface.add(new Paragraph("IDENTITY CARD", catFont));
        preface.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(preface,2);
        preface.add(new Paragraph("NATIONAL INSTITUTE OF TECHNOLOGY KARNATAKA SURATHKAL",catFont));
        addEmptyLine(preface,2);
        preface.add(new Paragraph(
                "Mangaluru - 575 025, INDIA",
                smallBold));
         preface.setAlignment(Element.ALIGN_CENTER);
           preface.add(new Paragraph(
                "Ph: +91-824-2474000/23 Lines",
                smallBold));
           preface.setAlignment(Element.ALIGN_CENTER);
         preface.add(new Paragraph("",smallBold));   

        document.add(preface);
    }


    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
