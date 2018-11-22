package com.adc.da.scores.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.scores.entity.ScoresEO;
import com.adc.da.scores.page.ScoresEOPage;
import com.adc.da.scores.service.ScoresEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/scores/scores")
@Api(description = "|ScoresEO|")
public class ScoresEOController extends BaseController<ScoresEO>{

    private static final Logger logger = LoggerFactory.getLogger(ScoresEOController.class);

    @Autowired
    private ScoresEOService scoresEOService;

	@ApiOperation(value = "|ScoresEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("scores:scores:page")
    public ResponseMessage<PageInfo<ScoresEO>> page(ScoresEOPage page) throws Exception {
        List<ScoresEO> rows = scoresEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|ScoresEO|查询")
    @GetMapping("")
    @RequiresPermissions("scores:scores:list")
    public ResponseMessage<List<ScoresEO>> list(ScoresEOPage page) throws Exception {
        return Result.success(scoresEOService.queryByList(page));
	}

    @ApiOperation(value = "|ScoresEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("scores:scores:save")
    public ResponseMessage<ScoresEO> create(@RequestBody ScoresEO scoresEO) throws Exception {
        scoresEOService.insertSelective(scoresEO);
        return Result.success(scoresEO);
    }

}
