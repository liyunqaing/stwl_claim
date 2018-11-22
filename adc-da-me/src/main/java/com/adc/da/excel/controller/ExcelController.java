package com.adc.da.excel.controller;



import com.adc.da.excel.service.excelService;
import com.adc.da.excel.poi.excel.entity.ImportParams;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/${restPath}/student/student")
@Api(description = "|StudentEO|")
public class ExcelController {
    @Autowired
    private excelService excelServices;

    @ApiOperation(value = "Excel导入")
    @PostMapping("/excelImport")
    public ResponseMessage ExcelImport(@RequestParam("file") MultipartFile file) throws Exception{
        InputStream is = file.getInputStream();
        ImportParams params = new ImportParams();
        excelServices.ExcelImport(is,params);
        return Result.success();
    }

}
