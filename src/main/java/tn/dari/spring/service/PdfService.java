package tn.dari.spring.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.dari.spring.entity.Credit;


@Service
public class PdfService {

	private static final String PDF_RESOURCES = "/templates/";
    private SpringTemplateEngine templateEngine;
    Credit credit;

    @Autowired
    public PdfService( CreditService creditService, SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public File generatePdf(Optional<Credit> credit) throws IOException, DocumentException {
        Context context = getContext(credit);
        String html = loadAndFillTemplate(context);
        return renderPdf(html);
    }

    private File renderPdf(String html) throws IOException, DocumentException {
        File file = File.createTempFile("credit", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
        renderer.layout();
        try {
			renderer.createPDF(outputStream);
		} catch (com.lowagie.text.DocumentException e) {
			e.printStackTrace();
		}
        outputStream.close();
        file.deleteOnExit();
        return file;
    }
    private Context getContext(Optional<Credit> credit) {
    	
        Context context = new Context();
		context.setVariable("credit", credit.get());
        return context;
    }
    private String loadAndFillTemplate(Context context) {
        return templateEngine.process("credit", context);
    }
    
	
	  public void export(HttpServletResponse response) throws DocumentException,
	  IOException, BadElementException { Document document = new Document();
	  PdfWriter.getInstance(document, response.getOutputStream());
	  
	  document.open(); Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	  font.setSize(18); //font.setColor(Color.BLUE);
	  
	  Paragraph p = new Paragraph("Credit", font);
	  p.setAlignment(Paragraph.ALIGN_CENTER);
	  
	  document.add(p);
	  
	  PdfPTable table = new PdfPTable(4); table.setWidthPercentage(100f);
	  table.setWidths(new float[] {3.0f, 3.0f, 3.0f,3.0f});
	  table.setSpacingBefore(10);
	  
	  //writeTableHeader(table); writeTableData(table);
	  
	  document.add(table);
	  
	  
	  document.close();
	  
	  }
	 
}
