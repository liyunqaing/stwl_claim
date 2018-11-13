package com.adc.da.test.controller;


import java.net.URLEncoder;
import java.util.List;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.apache.poi.hssf.usermodel.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.test.entity.DemoEO;

import com.adc.da.test.service.DemoEOService;


import io.swagger.annotations.Api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/${restPath}/test/demo")
@Api(description = "|DemoEO|")
public class DemoEOController extends BaseController<DemoEO>{

    private static final Logger logger = LoggerFactory.getLogger(DemoEOController.class);

    @Autowired
    private DemoEOService demoEOService;

   @GetMapping("/pdf")
    public void downpdf(HttpServletRequest request , HttpServletResponse response) throws Exception{
       //设置响应头部，声明文件为附件进行下载
       response.setHeader("Content-type", "application/pdf;charset=utf-8");
       response.setHeader("content-disposition", "attachment;filename=Pdf.pdf");
       //生成pdf对象
       Document document = new Document();
       //设置页面大小
       document.setPageSize(PageSize.A4);

       //设置文件输出路径
       PdfWriter.getInstance(document,response.getOutputStream());
       document.open();

       //设置标题
       Paragraph p = new Paragraph("user_message");
       p.setAlignment(Element.ALIGN_CENTER);
       document.add(p);

       //设置表头
       PdfPTable table = new PdfPTable(3);
       table.addCell(new Paragraph("ID"));
       table.addCell(new Paragraph("name"));
       table.addCell(new Paragraph("pwd"));

       //插入数据库数据
       List<DemoEO> ds = demoEOService.queryAll();
       for(DemoEO d:ds){
           table.addCell(new Paragraph(d.getId()));
           table.addCell(new Paragraph(d.getUername()));
           table.addCell(new Paragraph(d.getPassword()));
       }
       document.add(table);
       document.close();
        System.out.println("输出pdf:");
   }

   @GetMapping("/excel")
    public void getExcel(HttpServletResponse response) throws Exception{
       //设置响应头部，声明文件为附件进行下载
       String filename = "我的_Excel.xlsx";
       filename = URLEncoder.encode(filename,"utf-8");
       response.setHeader("Content-type", "application/pdf;charset=utf-8");
       response.setHeader("content-disposition", "attachment;filename="+filename);

       //生成Excel对象
       HSSFWorkbook wb = new HSSFWorkbook();

       //添加一张表
       HSSFSheet sheet = wb.createSheet("创建sh_1");

       //创建表头
       HSSFRow rowH = sheet.createRow(0);

       //创建单元格设置表头值
       HSSFCellStyle cellStyle = wb.createCellStyle(); //单元格格式对象
       cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //设置单元格居中

       //设置表头(rowH行）的列
       HSSFCell cell = rowH.createCell(0);
       cell.setCellValue("序号");
       cell.setCellStyle(cellStyle);

       cell = rowH.createCell(1);
       cell.setCellValue("姓名");
       cell.setCellStyle(cellStyle);

       cell = rowH.createCell(2);
       cell.setCellValue("密码");
       cell.setCellStyle(cellStyle);

       //插入数据
       List<DemoEO> demoEOS = demoEOService.queryAll();
       HSSFRow row = null;      //插入行对象
       DemoEO d = null;         //插入数据对象
       for(int i=0 ; i<demoEOS.size() ; i++){
           row = sheet.createRow(i+1);      //设置行对象
           d = demoEOS.get(i);                       //获取数据对象
           //插入列数据
           row.createCell(0).setCellValue(d.getId());
           row.createCell(1).setCellValue(d.getUername());
           row.createCell(2).setCellValue(d.getPassword());
       }

       wb.write(response.getOutputStream());
   }

}
