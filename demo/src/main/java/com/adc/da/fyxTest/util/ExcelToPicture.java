package com.adc.da.fyxTest.util;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: stwl_claim xls导出图片
 * @description: excel导图片
 * @author: cuiyuxin
 * @create: 2018-11-14 09:08
 * @version: 2.0.0
 **/
public class ExcelToPicture {

    //excel保存路径
    private  static String filePath;
    //图片保存路径
    private static  String savePicPath;
    //文件输入流
    private static FileInputStream fis;
    //poi 工作簿
    private static Workbook wookbook;
    //poi workbook窗口中的表格
    private  static Sheet sheet;
    //存储图片位置和数据
    private  static Map<String, PictureData> maplist;


    /**
     * @Description:  初始化
     * @Param: []
     * @return:
     * @Author: cuiyuxin
     * @Date: 2018/11/14
    */
    public ExcelToPicture(String savePicPath) {
        this.fis =null;
        this.wookbook = null;
        this.sheet =null;
        this.maplist=null;
        this.savePicPath=savePicPath;

    }
    /** 
     * @Description: 处理excel文件 
     * @Param: [file, request] 
     * @return: void 
     * @Author: cuiyuxin
     * @Date: 2018/11/14 
    */
    public static  void excelToPicture(MultipartFile file,HttpServletRequest request) throws IOException {
        // 获得原始文件名
        String fileName = file.getOriginalFilename();
        System.out.println("原始文件名:" + fileName);
        // 新文件名
        String newFileName = UUID.randomUUID() + fileName;
        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String path = sc.getRealPath("/img") + "/"; // 设定文件保存的目录

        File f = new File(path);
        if (!f.exists())
            f.mkdirs();
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(path + newFileName);
                InputStream in = file.getInputStream();
                int b = 0;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        filePath=path + newFileName;
        //将excel根据后缀处理
        getDataFromExcel();
    }
    /** 
     * @Description: 将excel文件根据后缀分开处理
     * @Param: [] 
     * @return: void 
     * @Author: cuiyuxin
     * @Date: 2018/11/14 
    */
    private static void getDataFromExcel() throws IOException
    {
        //String filePath = "E:\\123.xlsx";
        //判断是否为excel类型文件
        if(!filePath.endsWith(".xls")&&!filePath.endsWith(".xlsx"))
        {
            System.out.println("文件不是excel类型");
        }
        //获取一个绝对地址的流
        fis = new FileInputStream(filePath);
        if (filePath.endsWith(".xls")) {
            //2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(fis);//得到工作簿
        }else {
            //2007版本的excel，用.xlsx结尾
            wookbook = new XSSFWorkbook(fis);//得到工作簿
        }
        //获取excel sheet总数
        int sheetNumbers = wookbook.getNumberOfSheets();
        sheet = wookbook.getSheetAt(0);
        // 判断用07还是03的方法获取图片
        if (filePath.endsWith(".xls")) {
            maplist = getPictures1((HSSFSheet) sheet);
        } else if(filePath.endsWith(".xlsx")){
           /* maplist = getPictures2((XSSFSheet) sheet);*///暂时废弃xlsx
        }
        printImg(maplist);
        fis.close();
    }
    /**
     * 获取图片和位置 (xls)
     * @param sheet
     * @return
     * @throws IOException
     */
    private static Map<String, PictureData> getPictures1 (HSSFSheet sheet) throws IOException {
        Map<String, PictureData> map = new HashMap<String, PictureData>();
        List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
        for (HSSFShape shape : list) {
            if (shape instanceof HSSFPicture) {
                HSSFPicture picture = (HSSFPicture) shape;
                HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
                PictureData pdata = picture.getPictureData();
                String key = cAnchor.getRow1() + "-" + cAnchor.getCol1(); // 行号-列号
                map.put(key, pdata);
            }
        }
        return map;
    }

//
//     * 获取图片和位置 (xlsx)
//     * @param sheet
//     * @return
//     * @throws IOException

    /*public static Map<String, PictureData> getPictures2 (XSSFSheet sheet) throws IOException {
        Map<String, PictureData> map = new HashMap<String, PictureData>();
        List<POIXMLDocumentPart> list = sheet.getRelations();
        for (POIXMLDocumentPart part : list) {
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    if(shape instanceof XSSFPicture){
                        XSSFPicture picture = (XSSFPicture) shape;
                        XSSFClientAnchor anchor = picture.getPreferredSize();
                        CTMarker marker = anchor.getFrom(); String key = marker.getRow() + "-" + marker.getCol();
                        map.put(key, picture.getPictureData());
                    }
                }
            }
        }
        return map;
    }*/
    /** 
     * @Description: 将图片写到固定地址
     * @Param: [sheetList] 
     * @return: void 
     * @Author: cuiyuxin
     * @Date: 2018/11/14 
    */
    private static void printImg(Map<String, PictureData> sheetList) throws IOException {
        Object key[] = sheetList.keySet().toArray();
        for (int i = 0; i < sheetList.size(); i++) {
            // 获取图片流
            PictureData pic = sheetList.get(key[i]);
            // 获取图片索引
            String picName = key[i].toString();
            // 获取图片格式
            String ext = pic.suggestFileExtension();

            byte[] data = pic.getData();
            //图片保存路径
            FileOutputStream out = new FileOutputStream(savePicPath + picName + "." + ext);
            out.write(data);
            out.close();
        }
    }
}
