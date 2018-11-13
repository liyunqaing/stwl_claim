package com.adc.da.test.controller;

import com.adc.da.excel.poi.excel.ExcelExportUtil;
import com.adc.da.excel.poi.excel.entity.ExportParams;
import com.adc.da.excel.poi.excel.entity.enums.ExcelType;
import com.adc.da.pdf.PDFUtils;
import com.adc.da.test.dto.DemoDto;
import com.adc.da.test.entity.DemoEO;
import com.adc.da.test.entity.PartsEO;
import com.adc.da.test.service.DemoEOService;
import com.adc.da.test.service.PartsEOService;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.itextpdf.text.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
* @Description:   _使用adc-da内部组件完成Excel和pdf的导入导出
* @Author:         yueben
* @CreateDate:     2018/11/13 16:57
*/
@RestController
@RequestMapping("/${restPath}/test/demo")
public class Excel_Pdf_IO {

    private static final Logger logger = LoggerFactory.getLogger(Excel_Pdf_IO.class);

    @Autowired
    private DemoEOService demoEOService;

    @Autowired
    private PartsEOService partsEOService;

    /**
    * @Description:   _Excel导出
    * @Author:         yueben
    * @CreateDate:     2018/11/13 17:09
    */
    @GetMapping("/excel/download")
    public void download(HttpServletResponse response) throws Exception{
        //设置下载文件名
        response.setHeader("Content-Disposition",
                "attachment; filename="+new String("用户信息.xlsx".getBytes(),"iso-8859-1"));
        response.setContentType("application/force-download");

        //创建导出对象
        ExportParams ep = new ExportParams();
        //设置导出对象为Excel2007
        ep.setType(ExcelType.XSSF);

        List<DemoEO> demos = demoEOService.queryAll();
        ArrayList<DemoDto> demoDtos = new ArrayList<>();
        //将EO转换成Dto，用于文档写出
        if(demos != null && !demos.isEmpty()){
            for(DemoEO de : demos){
                DemoDto dto = new DemoDto();
                BeanUtils.copyProperties(de,dto);
                demoDtos.add(dto);
            }
        }
        //生成Excel对象
        Workbook wb = ExcelExportUtil.exportExcel(ep, DemoDto.class, demoDtos);
        //获取输出流
        ServletOutputStream sos = response.getOutputStream();
        //写出Excel
        wb.write(sos);
        sos.flush();
        IOUtils.closeQuietly(sos);
    }

    /**
    * @Description:   _pdf导出
    * @Author:         yueben
    * @CreateDate:     2018/11/13 17:11
    */
    @GetMapping("/pdf/download")
    public void pdfDownload(HttpServletResponse response) throws Exception{
        //设置下载文件名
        response.setHeader("Content-Disposition",
                "attachment; filename=" + new String("用户信息.pdf".getBytes(),"iso-8859-1"));
        response.setContentType("application/force-download");

        //创建图片对象
        Image img = Image.getInstance("6751.jpg");
        //图片缩放
        img.scaleToFit(PageSize.A5.rotate());
        img.setAbsolutePosition(0,0);

        //创建元素集合，用于写入pdf中
        ArrayList<Element> el = new ArrayList<>();
        List<DemoEO> demoEOS = demoEOService.queryAll();
        //将查询出的数据存入元素集合中
        for(DemoEO d : demoEOS){
            el.add(new Paragraph(d.getId()+"\t"+d.getUername()+"\t"+d.getPassword(), PDFUtils.FONTCN));
        }
        el.add(img);

        //pdf保存路径
        new PDFUtils().createPdf("adc_pdf1.pdf",el);
        //将文件响应给前台并删除
        ServletOutputStream sos = response.getOutputStream();
        fileDowm(sos,"adc_pdf1.pdf");


        //创建多页pdf
//        PDFPage page1 = new PDFPage();
//        page1.add(new Paragraph("第一页pdf_1", PDFUtils.FONTCN));
//        page1.add(new Paragraph("第一页pdf_2", PDFUtils.FONTCN));
//        page1.add(img);
//
//        PDFPage page2 = new PDFPage();
//        page2.add(new Paragraph("第二页pdf_1", PDFUtils.FONTCN));
//        page2.add(new Paragraph("第二页pdf_2", PDFUtils.FONTCN));
//        page2.add(img);
//
//        ArrayList<PDFPage> pages = new ArrayList<>();
//        pages.add(page1);
//        pages.add(page2);
//
//        new PDFUtils().createPdfWithNewPage("adc_pdf2.pdf",pages,PageSize.A4);
//        fileDowm(sos,"adc_pdf2.pdf");

    }

    private void fileDowm(ServletOutputStream sos,String path) throws IOException {
        //将文件响应给前台下载
        FileInputStream fis = new FileInputStream(path);

        int b;
        byte[] buf = new byte[1024];
        while((b = fis.read(buf)) != -1){
            sos.write(buf,0,b);
        }

        fis.close();
        //下载完毕后删除
        new File(path).delete();
    }

    /**
    * @Description:   _文件上传
    * @Author:         yueben
    * @CreateDate:     2018/11/13 21:53
    */
//    @PostMapping("/excel/upFile")
//    public ResponseMessage upDataBase(HttpServletRequest request)throws Exception{
//        DiskFileItemFactory dfif = new DiskFileItemFactory();
//        //设置上传临界值
//        dfif.setSizeThreshold(1024*1024);
//        //设置临时存储目录
//        dfif.setRepository(new File(""));
//
//        ServletFileUpload sfu = new ServletFileUpload(dfif);
//        //设置上传文件最大值
//        sfu.setSizeMax(1024*1024*2);
//        //设置编码格式
//        sfu.setHeaderEncoding("utf-8");
//        //获取请求中的文件集
//        List<FileItem> list = sfu.parseRequest(request);
//        System.out.println(list.size());
//        for(FileItem f : list){
//            if(f.isFormField()){
//                System.out.println("普通表单项：" + f.getName());
//            }else {
//                f.write(new File("C:\\Users\\11544\\Desktop\\stwl_claim\\"+f.getName()));
//            }
//        }
//        return Result.success();
//    }

    /**
    * @Description:   _上传Excel文件存放到数据库
    * @Author:         yueben
    * @CreateDate:     2018/11/13 21:49
    */
    @PostMapping("/excel/upfile")
    public ResponseMessage getupfile( @RequestParam("file") MultipartFile file) throws Exception{
        System.out.println(file.getOriginalFilename());
        //判断上传文件类型
        if(!(file.getOriginalFilename().endsWith(".xls")||file.getOriginalFilename().endsWith(".xlsx"))){
            return Result.error("请上传Exce文件");
        }

        XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());

        //获取Excel中的第一张表
        XSSFSheet sh1 = wb.getSheetAt(0);

        //获取文件数据行数
        int allrows = sh1.getPhysicalNumberOfRows();
        //从Excel表格中第七行开始读取
        for (int i = 7; i < allrows; i++) {
            int cellNum = 1;
            //获取行对象
            XSSFRow row = sh1.getRow(i);
            if(row == null){
                break;
            }
            //创建数据存储对象
            PartsEO pe = new PartsEO();

            //获取列中的数据存放到对象中
            pe.setId(i - 4 + "");
            pe.setParts(getValue(row.getCell(cellNum++)));
            pe.setPartsName(getValue(row.getCell(cellNum++)));
            cellNum++;//跳过合并的单元格
            pe.setAnnouncement(getValue(row.getCell(cellNum++)));
            pe.setC3(getValue(row.getCell(cellNum++)));
            pe.setEp(getValue(row.getCell(cellNum++)));
            pe.setC3Certificate(getValue(row.getCell(cellNum++)));
            pe.setPrintWay(getValue(row.getCell(cellNum++)));
            pe.setPartsCname(getValue(row.getCell(cellNum++)));
            pe.setPartsNum(getValue(row.getCell(cellNum++)));
            pe.setPartsEname(getValue(row.getCell(cellNum++)));
            pe.setVpps(getValue(row.getCell(cellNum++)));
            pe.setUpc(getValue(row.getCell(cellNum++)));
            pe.setFna(getValue(row.getCell(cellNum++)));
            pe.setEngineerEng(getValue(row.getCell(cellNum++)));
            pe.setDirectorEng(getValue(row.getCell(cellNum++)));

            if (partsEOService.insertSelective(pe) != 1) {
                return Result.error("存储数据失败");
            }
        }


//        //将文件写入磁盘
//        InputStream is = file.getInputStream();
//        FileOutputStream fos = new FileOutputStream(file.getOriginalFilename());
//        int b;
//        byte[] bytes = new byte[1024];
//        while((b=is.read(bytes))!=-1){
//            fos.write(bytes,0,b);
//        }
//        is.close();
//        fos.close();


        return Result.success();
    }

    //转换数据类型
    public String getValue(XSSFCell cell){
        //判断单元格数据类型，进行处理
        switch (cell.getCellType()){
            case XSSFCell.CELL_TYPE_STRING:
                Integer asc = Integer.valueOf(cell.getStringCellValue().charAt(0));
                //判断是否是特殊字符
                if(asc == 9679) return "是";
                return cell.getStringCellValue()==null?"":cell.getStringCellValue();
            case XSSFCell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue()+"";
            default: return "";
        }
    }

}
