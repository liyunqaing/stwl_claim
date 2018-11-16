package com.adc.da.test.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.test.entity.PartsEO;
import com.adc.da.test.page.PartsEOPage;
import com.adc.da.test.service.PartsEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @Description:   _使用poi-ooxml完成Excel导入数据库
 *                  spring.datasource.url = jdbc:sqlserver://localhost:1433;databaseName=test
 *                  spring.datasource.username = sa
 *                  spring.datasource.password = 12345
* @Author:         yueben
* @CreateDate:     2018/11/13 17:12
*/
@RestController
@RequestMapping("/${restPath}/test/parts")
@Api(description = "|PartsEO|")
public class PartsEOController extends BaseController<PartsEO>{

    private static final Logger logger = LoggerFactory.getLogger(PartsEOController.class);

    @Autowired
    private PartsEOService partsEOService;

    /**
    * @Description:   _Excel导入数据库
    * @Author:         yueben
    * @CreateDate:     2018/11/13 17:24
    */
    @PostMapping("/excelUp")
    public ResponseMessage excelUp() throws Exception {
        //文件路径
        String filepath = "C:\\Users\\11544\\Desktop\\关键件表 CN180C_河西工厂_201809.xlsx";
        //获得Excel对象，HSSFWorkbook只能操作Excel2003的文件（.xls），要操作Excel2007（.xlsx）的文件需要用poi-ooxml依赖中的XSSFWorkbook
        //HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(new String(filepath.getBytes(), "utf-8")));
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new String(filepath.getBytes(), "utf-8")));
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
                return Result.error();
            }
        }
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
            default: return null;
        }
    }

}
