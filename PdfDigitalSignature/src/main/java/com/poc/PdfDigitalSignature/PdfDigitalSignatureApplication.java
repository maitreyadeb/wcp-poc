package com.poc.PdfDigitalSignature;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfDigitalSignatureApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfDigitalSignatureApplication.class, args);
		System.out.println("Hello World!!!Ruben");

		// Create a Document object.
		PDDocument pdDocument = new PDDocument();

		// Create a Page object
		PDPage pdPage = new PDPage();
		// Add the page to the document and save the document to a desired file.
		pdDocument.addPage(pdPage);
	
		try {

			PDSignature pdSignature = new PDSignature();
			pdSignature.setFilter(PDSignature.FILTER_VERISIGN_PPKVS);
			pdSignature.setSubFilter(PDSignature.SUBFILTER_ADBE_PKCS7_SHA1);
			pdSignature.setName("Maitreya");
			pdSignature.setLocation("Khardaha");
			pdSignature.setReason("Sample Signature test");
			pdSignature.setSignDate(Calendar.getInstance());
			//Add Signature in PDF
			//InputStream pdfFile = new FileInputStream("C:\\Users\\Ruben\\Desktop\\testPdf.txt");
			//pdSignature.getSignedContent(pdfFile);
			
 			pdDocument.addSignature(pdSignature);
			pdDocument.save("C:\\Users\\Ruben\\Desktop\\signature-sample.pdf");
			pdDocument.close();
			System.out.println("PDF saved to the location !!!");


		} catch (Throwable ioe) {
			ioe.printStackTrace();
		}
	}

}
