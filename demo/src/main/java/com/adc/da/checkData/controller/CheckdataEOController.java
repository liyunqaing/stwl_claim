package com.adc.da.checkData.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.checkData.entity.CheckdataEO;
import com.adc.da.checkData.page.CheckdataEOPage;
import com.adc.da.checkData.service.CheckdataEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/checkData/checkdata")
@Api(description = "|CheckdataEO|")
public class CheckdataEOController extends BaseController<CheckdataEO>{

    private static final Logger logger = LoggerFactory.getLogger(CheckdataEOController.class);

    @Autowired
    private CheckdataEOService checkdataEOService;

	@ApiOperation(value = "|CheckdataEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("checkData:checkdata:page")
    public ResponseMessage<PageInfo<CheckdataEO>> page(CheckdataEOPage page) throws Exception {
        List<CheckdataEO> rows = checkdataEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|CheckdataEO|查询")
    @GetMapping("")
    @RequiresPermissions("checkData:checkdata:list")
    public ResponseMessage<List<CheckdataEO>> list(CheckdataEOPage page) throws Exception {
        return Result.success(checkdataEOService.queryByList(page));
	}

    @ApiOperation(value = "|CheckdataEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("checkData:checkdata:get")
    public ResponseMessage<CheckdataEO> find(@PathVariable String id) throws Exception {
        return Result.success(checkdataEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|CheckdataEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("checkData:checkdata:save")
    public ResponseMessage<CheckdataEO> create(@RequestBody CheckdataEO checkdataEO) throws Exception {
        checkdataEOService.insertSelective(checkdataEO);
        return Result.success(checkdataEO);
    }

    @ApiOperation(value = "|CheckdataEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("checkData:checkdata:update")
    public ResponseMessage<CheckdataEO> update(@RequestBody CheckdataEO checkdataEO) throws Exception {
        checkdataEOService.updateByPrimaryKeySelective(checkdataEO);
        return Result.success(checkdataEO);
    }

    @ApiOperation(value = "|CheckdataEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("checkData:checkdata:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        checkdataEOService.deleteByPrimaryKey(id);
        logger.info("delete from checkData where id = {}", id);
        return Result.success();
    }

}
