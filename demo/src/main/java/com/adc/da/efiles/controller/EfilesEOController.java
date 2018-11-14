package com.adc.da.efiles.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.efiles.entity.EfilesEO;
import com.adc.da.efiles.page.EfilesEOPage;
import com.adc.da.efiles.service.EfilesEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/efiles/efiles")
@Api(description = "|EfilesEO|")
public class EfilesEOController extends BaseController<EfilesEO>{

    private static final Logger logger = LoggerFactory.getLogger(EfilesEOController.class);

    @Autowired
    private EfilesEOService efilesEOService;

	@ApiOperation(value = "|EfilesEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("efiles:efiles:page")
    public ResponseMessage<PageInfo<EfilesEO>> page(EfilesEOPage page) throws Exception {
        List<EfilesEO> rows = efilesEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|EfilesEO|查询")
    @GetMapping("")
    @RequiresPermissions("efiles:efiles:list")
    public ResponseMessage<List<EfilesEO>> list(EfilesEOPage page) throws Exception {
        return Result.success(efilesEOService.queryByList(page));
	}

    @ApiOperation(value = "|EfilesEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("efiles:efiles:get")
    public ResponseMessage<EfilesEO> find(@PathVariable String id) throws Exception {
        return Result.success(efilesEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|EfilesEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("efiles:efiles:save")
    public ResponseMessage<EfilesEO> create(@RequestBody EfilesEO efilesEO) throws Exception {
        efilesEOService.insertSelective(efilesEO);
        return Result.success(efilesEO);
    }

    @ApiOperation(value = "|EfilesEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("efiles:efiles:update")
    public ResponseMessage<EfilesEO> update(@RequestBody EfilesEO efilesEO) throws Exception {
        efilesEOService.updateByPrimaryKeySelective(efilesEO);
        return Result.success(efilesEO);
    }

    @ApiOperation(value = "|EfilesEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("efiles:efiles:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        efilesEOService.deleteByPrimaryKey(id);
        logger.info("delete from efiles where id = {}", id);
        return Result.success();
    }

}
