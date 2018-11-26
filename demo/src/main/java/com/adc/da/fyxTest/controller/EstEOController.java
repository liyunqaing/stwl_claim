package com.adc.da.fyxTest.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.adc.da.excel.poi.excel.entity.ImportParams;
import com.adc.da.fyxTest.util.ExcelToPicture;
import com.adc.da.fyxTest.util.MemoryTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.fyxTest.entity.EstEO;
import com.adc.da.fyxTest.page.EstEOPage;
import com.adc.da.fyxTest.service.EstEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/${restPath}/fyxTest/est")
@Api(description = "|EstEO|")
public class EstEOController extends BaseController<EstEO>{

    private static final Logger logger = LoggerFactory.getLogger(EstEOController.class);

    @Autowired
    private EstEOService estEOService;

	@ApiOperation(value = "|EstEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("fyxTest:est:page")
    public ResponseMessage<PageInfo<EstEO>> page(EstEOPage page) throws Exception {
        List<EstEO> rows = estEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|EstEO|查询")
    @GetMapping("")
    @RequiresPermissions("fyxTest:est:list")
    public ResponseMessage<List<EstEO>> list(EstEOPage page) throws Exception {
        return Result.success(estEOService.queryByList(page));
	}

    @ApiOperation(value = "|EstEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("fyxTest:est:get")
    public ResponseMessage<EstEO> find(@PathVariable String id) throws Exception {
        return Result.success(estEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|EstEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("fyxTest:est:save")
    public ResponseMessage<EstEO> create(@RequestBody EstEO estEO) throws Exception {
        estEOService.insertSelective(estEO);
        return Result.success(estEO);
    }

    @ApiOperation(value = "|EstEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("fyxTest:est:update")
    public ResponseMessage<EstEO> update(@RequestBody EstEO estEO) throws Exception {
        estEOService.updateByPrimaryKeySelective(estEO);
        return Result.success(estEO);
    }

    @ApiOperation(value = "|EstEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("fyxTest:est:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        estEOService.deleteByPrimaryKey(id);
        logger.info("delete from Test where id = {}", id);
        return Result.success();
    }
    @ApiOperation(value = "无验证的Excel导入")
    @PostMapping("/excelImport")
    public ResponseMessage ExcelImport(@RequestParam("file") MultipartFile file) throws Exception{
        InputStream is = file.getInputStream();
        ImportParams params = new ImportParams();
        estEOService.ExcelImport(is,params);
        return Result.success();
    }
    /**
     * @Description: xls上传导出图片
     * @Param: [file, request]
     * @return: com.adc.da.util.http.ResponseMessage<java.util.Map<java.lang.String,java.lang.String>>
     * @Author: cuiyuxin
     * @Date: 2018/11/14
     */
    @ApiOperation(value = "|ImageUpload|xls上传使用缓存测试 ")
    @PostMapping("XlsUploadTime")
    public ResponseMessage<Map<String,String>> XlsUploadTime(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request) throws IOException {
        estEOService.XlsuploadTime(file,request);
        return Result.success(null);
    }
    /**
     * @Description: 文件上传使用时间大小测试
     * @Param: [file, request]
     * @return: com.adc.da.util.http.ResponseMessage<java.util.Map<java.lang.String,java.lang.String>>
     * @Author: cuiyuxin
     * @Date: 2018/11/14
     */
    @ApiOperation(value = "|ImageUpload|文件上传使用时间大小测试 ")
    @PostMapping("/FileUploadSize")
    public ResponseMessage<Map<String,String>> FileUploadSize(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request) throws IOException {
        estEOService.FileuploadSize(file,request);
        return Result.success(null);
    }






}
