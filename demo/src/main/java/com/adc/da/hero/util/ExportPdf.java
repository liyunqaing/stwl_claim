package com.adc.da.hero.util;

import com.adc.da.hero.entity.HeroEO;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import java.io.File;

/**
 * @ClassName ExportPdf 生成pdf
 * @Description 通过调用不同的构造方法创建生成pdf的路径 默认为E://pdfs
 * 通过调用不同的重载方法进行pdf的生成 具体参数可自行定义 例如：exportPdf(String folderPath, HeroEO heroEO)
 * @Author 刘笑天
 * @DaTe 2018/11/12 0012 9:56
 */
public class ExportPdf {
    private String foldPath;//文件夹路径
    /**
     * 无参构造方法 声明类对象时进行目录创建
     */
    public ExportPdf() {
        File folder = new File("E://pdfs");
        if (!folder.exists() && !folder.isDirectory()) {//判断指定路径文件夹是否存在 若不存在创建一个文件夹
            folder.mkdir();
            System.out.println("目录创建成功");
        } else {
            System.out.println("目录存在");
        }
    }

    /**
     * 带参构造函数 用于生成自定义路径的文件夹目录
     * @param folderPath 文件夹路径
     */
    public ExportPdf(String folderPath) {
        //默认路径
        if (folderPath == null || folderPath == "") {
            folderPath = "E://pdfs";
        }
        this.foldPath = folderPath;
        File folder = new File(folderPath);
        if (!folder.exists() && !folder.isDirectory()) {//判断指定路径文件夹是否存在 若不存在创建一个文件夹
            folder.mkdir();
            System.out.println("目录创建成功");
        } else {
            System.out.println("目录存在");
        }
    }

    /**
     * 无形参方法 pdf参数固定
     * 刘笑天 20181112
     *
     * @return 返回值意义待定
     * @throws Exception
     */
    public boolean exportPdf() throws Exception {
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter("E://pdfs//test.pdf"));
        Document document = new Document(pdfDocument, new PageSize(PageSize.A4));
        document.setMargins(24, 20, 0, 20);
        //设置字体兼容中文
        PdfFont font = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
        Cell cell;
        Paragraph p;

        p = new Paragraph("标题");
        p.setTextAlignment(TextAlignment.CENTER);//段落位置
        p.setFont(font);//设置字体
        p.setFontSize(12f);//设置字体大小
        document.add(p);

        Table table = new Table(1);//表格设置列数
        table.setWidth(new UnitValue(UnitValue.PERCENT, 100));

        p = new Paragraph("姓名:" + "Nancy");
        p.setTextAlignment(TextAlignment.LEFT);
        p.setFont(font);
        p.setFontSize(12f);
        cell = new Cell();
        cell.setBorder(null);
        cell.add(p);
        table.addCell(cell);

        p = new Paragraph("技能：" + "cute");
        p.setTextAlignment(TextAlignment.LEFT);
        p.setFont(font);
        p.setFontSize(12f);
        cell = new Cell();
        cell.setBorder(null);
        cell.add(p);
        table.addCell(cell);

        //向文档中添加表
        document.add(table);

        //文档设置完毕 关闭document
        document.close();
        return true;
    }

    /**
     * 导出pdf 方法重载 带形参 通过设置形参来控制pdf生成路径以及生成内容
     *
     * @param heroEO     生成内容的实体
     * @return
     * @throws Exception
     */
    public boolean exportPdf(HeroEO heroEO) throws Exception {
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(foldPath + "//test.pdf"));
        Document document = new Document(pdfDocument, new PageSize(PageSize.A4));
        document.setMargins(24, 20, 0, 20);
        //设置字体兼容中文
        PdfFont font = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", false);

        Cell cell;//table单元格
        Paragraph p;//段落单元

        p = new Paragraph("标题");
        p.setTextAlignment(TextAlignment.CENTER);
        p.setFont(font);
        p.setFontSize(12f);
        document.add(p);

        Table table = new Table(1);
        table.setWidth(new UnitValue(UnitValue.PERCENT, 100));

        p = new Paragraph("姓名:" + heroEO.getHname());
        p.setTextAlignment(TextAlignment.LEFT);
        p.setFont(font);
        p.setFontSize(12f);
        cell = new Cell();
        cell.setBorder(null);
        cell.add(p);
        table.addCell(cell);

        p = new Paragraph("技能：" + heroEO.getHability());
        p.setTextAlignment(TextAlignment.LEFT);
        p.setFont(font);
        p.setFontSize(12f);
        cell = new Cell();
        cell.setBorder(null);
        cell.add(p);
        table.addCell(cell);

        //向文档中添加表
        document.add(table);

        //文档设置完毕 关闭document
        document.close();
        return true;
    }
}

