package com.adc.da.excelexport.controller;


import com.adc.da.excelexport.dao.ExcelExportDao;
import com.adc.da.pdf.PDFUtils;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
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

    /**
     *生成pdf文件
     */
    @ApiOperation(value = "导出pdf")
    @GetMapping("/pdfExport")
    @SuppressWarnings("unchecked")
    public ResponseMessage ExcelExport(HttpServletResponse response) throws Exception {
        List<Element> pdfList = new ArrayList<>();
        pdfList.add(new Paragraph(dao.exportExcel().toString(),PDFUtils.FONTCN));
        //若输入有中文，需要指定生成字体为PDFUtils.FONTCN
        pdfList.add(new Paragraph("测试文本字体大小55",PDFUtils.createfontCN(55)));
        //调整字体大小为55
        pdfList.add(new Paragraph("测试文本字体大小44",PDFUtils.createfontCN(44)));
        pdfList.add(new Paragraph("testcase_1"));
        //纯英文可以不指定字体，大小32磅
        PdfPTable table = new PdfPTable(3); //规定列数为3
        table.addCell("hi");
        table.addCell("hi");
        table.addCell("hi");               //每三个为一行

        table.addCell("hi");
        table.addCell("hi");
        table.addCell("hi");               //第二行

        table.addCell("hi");               //这行不满足三个不会显示
        table.addCell("hi");
        table.addCell("hi");
        pdfList.add(table);
        File file = new File("path/example.pdf");
        file.getParentFile().mkdirs();
        new PDFUtils().createPdf("path/example.pdf", pdfList);
        return Result.success();
    }
}
