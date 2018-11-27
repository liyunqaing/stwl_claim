package com.adc.da.scoresqlserver.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.scoresqlserver.entity.ScoresEO;
import com.adc.da.scoresqlserver.page.ScoresEOPage;
import com.adc.da.scoresqlserver.service.ScoresEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/scoresqlserver/scores1")
@Api(description = "|ScoresEO1|")
public class ScoresEOController extends BaseController<ScoresEO>{

    private static final Logger logger = LoggerFactory.getLogger(ScoresEOController.class);

    @Autowired
    private ScoresEOService scoresEOService;

	@ApiOperation(value = "|ScoresEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("scoresqlserver:scores:page1")
    public ResponseMessage<PageInfo<ScoresEO>> page(ScoresEOPage page) throws Exception {
        List<ScoresEO> rows = scoresEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|ScoresEO|查询")
    @GetMapping("")
    @RequiresPermissions("scoresqlserver:scores:list1")
    public ResponseMessage<List<ScoresEO>> list(ScoresEOPage page) throws Exception {
        return Result.success(scoresEOService.queryByList(page));
	}

    @ApiOperation(value = "|ScoresEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("scoresqlserver:scores:save1")
    public ResponseMessage<ScoresEO> create(@RequestBody ScoresEO scoresEO) throws Exception {
        scoresEOService.insertSelective(scoresEO);
        return Result.success(scoresEO);
    }

}
