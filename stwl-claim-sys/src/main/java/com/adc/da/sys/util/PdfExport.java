package com.adc.da.sys.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class PdfExport {
    //文件导出路径
    private static String FILE_DIR;
    //文件名字
    private static String FILE_NAME;
    //标题字体对象
    private static Font titleFont;
    //文本字体对象
    private static Font headFont;
    //Dom操作对象
    private static Document document;
    //图片操作对象
    private static Image image;
    //设置中文
    private static BaseFont bfChinese;
    //初始化导出PDF格式编码（避免中文到处失败）
    static {
        try {
            bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //构造函数，激活document对象，初始化到处路径和文件名
    public PdfExport(String FILE_DIR,String FILE_NAME) {
        this.FILE_DIR = FILE_DIR;
        this.FILE_NAME = FILE_NAME;
        this.document = new Document();
    }
    //打开document对象流，设定读取文件
    public void PdfExportFileOpen() throws Exception{
        //设置页面大小
        this.document.setPageSize(PageSize.A4);
        //设置边距
        this.document.setMargins(50, 50, 50, 50);
        //Step 2—Get a PdfWriter instance.
        PdfWriter.getInstance(document, new FileOutputStream(FILE_DIR + FILE_NAME+".PDF"));
        //Step 3—Open the Document.
        this.document.open();
    }

    /**
     *
     * @param contentList  文本内容
     * @param CONTENT_SIZE  文本文字大小
     * @param TABLE_SIZE    表单长度
     * @param TABLE_POSITION  表格在整个A4的位置0是靠左1是剧中2是靠右
     * @param CONTENT_POSITION   文本在对应表格背景下位置0是靠左1是剧中2是靠右
     * @param IS_BORDER  是否含有边框
     * @param Color    单元格背景颜色
     * @param TABLE_LONG  表格长度
     * @throws Exception   处理异常
     */
    public void PdfExportSetContent (List<String> contentList,int CONTENT_SIZE,int TABLE_SIZE,int TABLE_POSITION,int CONTENT_POSITION,boolean IS_BORDER,BaseColor Color,int TABLE_LONG) throws Exception {
        //Step 4—Add content.
        //添加文本内容
        //设置表格内容字体大小
        this.headFont = new Font(this.bfChinese, CONTENT_SIZE, Font.NORMAL);
            //设定表格长度
            PdfPTable content = new PdfPTable(TABLE_SIZE);
            content.setTotalWidth(TABLE_LONG);
            //循环遍历输出
            for(int i = 0;i < contentList.size();i++) {
                content.setTotalWidth(TABLE_LONG);
                content.setHorizontalAlignment(TABLE_POSITION);
                Paragraph ph = new Paragraph(contentList.get(i),this.headFont);
                ph.setAlignment(CONTENT_POSITION);
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(ph);
                cell.setHorizontalAlignment(CONTENT_POSITION);
                //是否有边框
                if(!IS_BORDER) {
                    cell.setBorder(Rectangle.NO_BORDER);
                }
                cell.setBackgroundColor(Color);
                content.addCell(cell);
            }
            this.document.add(content);
        //Step 5—Close the Document.

    }
    //打开图片对象流

    /**
     * xf
     * @param imgFilePath 文件路径
     * @param scaleX  横向位置
     * @param scaleY  竖向位置
     * @throws Exception
     */
    public void PdfExportImage(String imgFilePath,int scaleX,int scaleY) throws Exception{
        //读取一个图片
        this.image=Image.getInstance(imgFilePath);
        this.image.setAbsolutePosition(scaleX, scaleY);
        this.document.add(this.image);
    }


    /**
     *
     * @param titleList 标题内容
     * @param TITLE_SIZE 标题大小
     * @param TABLE_SIZE
     * @param TABLE_POSITION
     * @param CONTENT_POSITION
     * @param IS_BORDER
     * @param Color
     * @param TABLE_LONG
     * @throws Exception
     */
    public void PdfExportSetTitle(List<String> titleList,int TITLE_SIZE,int TABLE_SIZE,int TABLE_POSITION,int CONTENT_POSITION,boolean IS_BORDER,BaseColor Color,int TABLE_LONG) throws Exception{
        //设置标题字体大小
        this.titleFont = new Font(bfChinese, TITLE_SIZE, Font.BOLD);
            PdfPTable content = new PdfPTable(TABLE_SIZE);
            content.setTotalWidth(TABLE_LONG);
            //循环遍历输出
            for(int i = 0;i < titleList.size();i++) {
                content.setHorizontalAlignment(TABLE_POSITION);
                Paragraph ph = new Paragraph(titleList.get(i),this.titleFont);
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(ph);
                cell.setHorizontalAlignment(CONTENT_POSITION);
                //是否需要边框
                if(!IS_BORDER) {
                    cell.setBorder(Rectangle.NO_BORDER);
                }
                cell.setBackgroundColor(Color);
                content.addCell(cell);
            }
            this.document.add(content);
        //Step 5—Close the Document.
    }
    //换行方法
    public void PdfExportEnter() throws DocumentException {
        this.document.add(new Paragraph("\n\n"));
    }
    //关闭流
    public void PdfExportFileClose(){
        this.document.close();
    }
}
