package com.adc.da.excelexport.controller;


import com.adc.da.excelexport.dao.ExcelExportDao;
import com.adc.da.excelexport.entity.ExcelExportEO;
import com.adc.da.pdf.PDFUtils;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/${restPath}/student/student")
@Api(description = "|StudentEO|")
public class PdfExportController {

    @Autowired(required = false)
    private ExcelExportDao dao;

    @ApiOperation(value = "导出pdf")
    @GetMapping("/pdfExport")
    @SuppressWarnings("unchecked")
    public ResponseMessage ExcelExport(HttpServletResponse response) throws Exception {
//             List<ExcelExportEO> pdflsit = dao.exportExcel();
//        File file = new File("C:/Users/0.0/Desktop/example.pdf");
//        file.getParentFile().mkdirs();
//        String path = "C:/Users/0.0/Desktop/example.pdf";
////        new PDFUtils().createPdf(path,pdflsit);
//        FileOutputStream a = new FileOutputStream("C:/Users/0.0/Desktop/.txt");
//        new PDFUtils().createPdf(a, pdflsit);


//        try {
//            List<ExcelExportEO> pdfLsit = dao.exportExcel();
//            List<List<ExcelExportEO>> list = new ArrayList<>();
//            list.add(pdfLsit);
//            String fileName = "example.pdf";
//            StringBuilder pathBuilder = new StringBuilder();
//            pathBuilder.append("/PDF/example.pdf"); //生成一个用于导出的pdf，覆盖原有的example
//            File file = new File(pathBuilder.toString());
//            file.getParentFile().mkdirs();
//            new PDFUtils().createPdf(pathBuilder.toString(),pdfLsit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

/**
 * itextpdf
 */
//        Document document = new Document();
//        try {
//            List<ExcelExportEO> pdflsit = dao.exportExcel();
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/0.0/Desktop/example.pdf"));
//            document.open();
//            document.add(new Paragraph(pdflsit.toString()));
//            document.close();
//            writer.close();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
        return Result.success();
    }
}
