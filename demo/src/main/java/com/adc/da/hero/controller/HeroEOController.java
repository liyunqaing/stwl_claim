package com.adc.da.hero.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.adc.da.efiles.entity.EfilesEO;
import com.adc.da.efiles.service.EfilesEOService;
import com.adc.da.excel.poi.excel.ExcelExportUtil;
import com.adc.da.excel.poi.excel.ExcelImportUtil;
import com.adc.da.excel.poi.excel.entity.ExportParams;
import com.adc.da.excel.poi.excel.entity.ImportParams;
import com.adc.da.excel.poi.excel.entity.enums.ExcelType;
import com.adc.da.excel.poi.excel.entity.result.ExcelImportResult;
import com.adc.da.hero.dto.HeroDto;
import com.adc.da.hero.util.ExportPdf;
import com.adc.da.util.exception.AdcDaBaseException;
import com.adc.da.util.utils.*;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.hero.entity.HeroEO;
import com.adc.da.hero.page.HeroEOPage;
import com.adc.da.hero.service.HeroEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/${restPath}/hero/hero")
@Api(description = "|HeroEO|")
public class HeroEOController extends BaseController<HeroEO> {

    private static final Logger logger = LoggerFactory.getLogger(HeroEOController.class);

    @Autowired
    private HeroEOService heroEOService;

    @Autowired
    private EfilesEOService efilesEOService;

    @ApiOperation(value = "|HeroEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("hero:hero:page")
    public ResponseMessage<PageInfo<HeroEO>> page(HeroEOPage page) throws Exception {
        List<HeroEO> rows = heroEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    @ApiOperation(value = "|HeroEO|查询")
    @GetMapping("")
    @RequiresPermissions("hero:hero:list")
    public ResponseMessage<List<HeroEO>> list(HeroEOPage page) throws Exception {
        return Result.success(heroEOService.queryByList(page));
    }

    @ApiOperation(value = "|HeroEO|详情")
    @GetMapping("/{hid}")
    @RequiresPermissions("hero:hero:get")
    public ResponseMessage<HeroEO> find(@PathVariable String hid) throws Exception {
        return Result.success(heroEOService.selectByPrimaryKey(hid));
    }

    @ApiOperation(value = "|HeroEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("hero:hero:save")
    public ResponseMessage<HeroEO> create(@RequestBody HeroEO heroEO) throws Exception {
        heroEOService.insertSelective(heroEO);
        return Result.success(heroEO);
    }

    @ApiOperation(value = "|HeroEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("hero:hero:update")
    public ResponseMessage<HeroEO> update(@RequestBody HeroEO heroEO) throws Exception {
        heroEOService.updateByPrimaryKeySelective(heroEO);
        return Result.success(heroEO);
    }

    @ApiOperation(value = "|HeroEO|删除")
    @DeleteMapping("/{hid}")
    @RequiresPermissions("hero:hero:delete")
    public ResponseMessage delete(@PathVariable String hid) throws Exception {
        heroEOService.deleteByPrimaryKey(hid);
        logger.info("delete from hero where hid = {}", hid);
        return Result.success();
    }

    /**
     * 生成HeroPDF
     * @param folderPath 自定义生成路径（可选）
     * @param heroEO     数据实体 但只需要前端传输ID 主要用于数据库查询
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|HeroEO|生成HeroPDF")
    @PostMapping("/exportHeroPdf")
    public ResponseMessage exportHeroPdf(String folderPath, @RequestBody HeroEO heroEO) throws Exception {
        HeroEO heroEO1 = heroEOService.selectHeroByHid(heroEO);
        ExportPdf exportPdf = new ExportPdf(folderPath);
        exportPdf.exportPdf(heroEO1);
        return Result.success();
    }
}
