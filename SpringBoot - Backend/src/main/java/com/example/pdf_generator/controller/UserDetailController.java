package com.example.pdf_generator.controller;

import com.example.pdf_generator.model.UserDetail;
import com.example.pdf_generator.service.Userservice;
import com.itextpdf.text.*;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.print.Doc;
import java.io.*;
import java.nio.file.FileSystems;
import java.util.List;

@CrossOrigin("*")
@RequestMapping("/testapp")
@Controller
public class UserDetailController
{
    StringReader htmlDoc=null;

    @Autowired
    SpringTemplateEngine templateEngine;
    @Autowired
    Userservice userservice;

    @PostMapping("/getPdf")
    public ResponseEntity<ByteArrayResource> getPdf(@RequestBody List<UserDetail> details) throws IOException, DocumentException {
        Context context = new Context();
        System.out.println(details);
        Document doc=new Document(PageSize.A4);
        context.setVariable("details",details);
        context.setVariable("sometext","This paragraph is to present the text other than the detail array Object");
//        context.setVariable("name",details.getName());
//        context.setVariable("age",details.getAge());
//        context.setVariable("country",details.getCountry());

        String htmlContentToRender = templateEngine.process("pdf-template", context);
        String xHtml = null;
        xHtml = xhtmlConvert(htmlContentToRender);
        //Below steps are to store the pdf inside spring boot
//
//        ITextRenderer renderer = new ITextRenderer();
//
//        String baseUrl = FileSystems
//                .getDefault()
//                .getPath("src", "main", "resources","templates")
//                .toUri()
//                .toURL()
//                .toString();
//        renderer.setDocumentFromString(xHtml, baseUrl);
//        renderer.layout();
//
//        OutputStream outputStream = new FileOutputStream("src//test.pdf");
//        renderer.createPDF(outputStream);
//        outputStream.close();
//
//        return details;




        //Do the below steps in a service call this is to send to angular
        htmlDoc=new StringReader(xHtml);
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        PdfWriter pdfWriter=PdfWriter.getInstance(doc,outputStream);
        doc.open();
        XMLWorkerHelper.getInstance().parseXHtml(pdfWriter,doc,htmlDoc);
        doc.close();

    return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType("application/pdf"))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "Downloads.pdf" + "\"")
            .body(new ByteArrayResource(outputStream.toByteArray()));

    }
//TO-DO in a service class
    private String xhtmlConvert(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setInputEncoding("UTF-8");
        tidy.setOutputEncoding("UTF-8");
        tidy.setXHTML(true);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes("UTF-8"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        tidy.parseDOM(inputStream, outputStream);
        return outputStream.toString("UTF-8");
    }

    @GetMapping("/getdumby")
    public ResponseEntity<?> getdummbyData(){
        List<UserDetail> responsse=userservice.dumbdata();
        System.out.println(responsse);
        return new ResponseEntity<>(responsse, HttpStatus.OK);
    }
}

