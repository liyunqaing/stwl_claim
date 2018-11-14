package com.adc.da.sys.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.sys.entity.Hpm05userEO;
import com.adc.da.sys.page.Hpm05userEOPage;
import com.adc.da.sys.service.Hpm05userEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/${restPath}/sys/hpm05user")
@Api(description = "|Hpm05userEO|")
public class Hpm05userEOController extends BaseController<Hpm05userEO>{

    private static final Logger logger = LoggerFactory.getLogger(Hpm05userEOController.class);

    @Autowired
    private Hpm05userEOService hpm05userEOService;

	@ApiOperation(value = "|Hpm05userEO|分页查询")
    @GetMapping("/page")
//    @RequiresPermissions("sys:hpm05user:page")
    public ResponseMessage<PageInfo<Hpm05userEO>> page(Hpm05userEOPage page) throws Exception {
        List<Hpm05userEO> rows = hpm05userEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|Hpm05userEO|查询")
    @GetMapping("")
//    @RequiresPermissions("sys:hpm05user:list")
    public ResponseMessage<List<Hpm05userEO>> list(Hpm05userEOPage page) throws Exception {
        return Result.success(hpm05userEOService.queryByList(page));
	}

    @ApiOperation(value = "|Hpm05userEO|详情")
    @GetMapping("/{userid}")
//    @RequiresPermissions("sys:hpm05user:get")
    public ResponseMessage<Hpm05userEO> find(@PathVariable Integer userid) throws Exception {
        return Result.success(hpm05userEOService.selectByPrimaryKey(userid));
    }

    @ApiOperation(value = "|Hpm05userEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
//    @RequiresPermissions("sys:hpm05user:save")
    public ResponseMessage<Hpm05userEO> create(@RequestBody Hpm05userEO hpm05userEO) throws Exception {
        hpm05userEOService.save(hpm05userEO);
        return Result.success(hpm05userEO);
    }

    @ApiOperation(value = "|Hpm05userEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
//    @RequiresPermissions("sys:hpm05user:update")
    public ResponseMessage<Hpm05userEO> update(@RequestBody Hpm05userEO hpm05userEO) throws Exception {
        hpm05userEOService.updateByPrimaryKeySelective(hpm05userEO);
        return Result.success(hpm05userEO);
    }

    @ApiOperation(value = "|Hpm05userEO|删除")
    @DeleteMapping("/{userid}")
//    @RequiresPermissions("sys:hpm05user:delete")
    public ResponseMessage delete(@PathVariable Integer userid) throws Exception {
        hpm05userEOService.deleteByPrimaryKey(userid);
        logger.info("delete from HPM05USER where userid = {}", userid);
        return Result.success();
    }


    /**
     * @Description: xls上传导出图片
     * @Param: [file, request]
     * @return: com.adc.da.util.http.ResponseMessage<java.util.Map<java.lang.String,java.lang.String>>
     * @Author: cuiyuxin
     * @Date: 2018/11/14
     */
    @ApiOperation(value = "|ImageUpload|xls上传 ")
    @PostMapping("XlsUpload")
    public ResponseMessage<Map<String,String>> XlsUpload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) throws IOException {
        hpm05userEOService.Xlsupload(file,request);
        return Result.success(null);
    }
}
