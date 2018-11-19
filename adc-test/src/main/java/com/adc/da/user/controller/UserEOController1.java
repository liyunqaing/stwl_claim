package com.adc.da.user.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.user.entity.UserEO;
import com.adc.da.user.page.UserEOPage;
import com.adc.da.user.service.UserEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/user/user")
@Api(description = "|UserEO|")
public class UserEOController1 extends BaseController<UserEO>{

    private static final Logger logger = LoggerFactory.getLogger(UserEOController1.class);

    @Autowired
    private UserEOService userEOService;

	@ApiOperation(value = "|UserEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("user:user:page")
    public ResponseMessage<PageInfo<UserEO>> page(UserEOPage page) throws Exception {
        List<UserEO> rows = userEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|UserEO|查询")
    @GetMapping("")
    @RequiresPermissions("user:user:list")
    public ResponseMessage<List<UserEO>> list(UserEOPage page) throws Exception {
        return Result.success(userEOService.queryByList(page));
	}

    @ApiOperation(value = "|UserEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("user:user:save")
    public ResponseMessage<UserEO> create(@RequestBody UserEO userEO) throws Exception {
        userEOService.insertSelective(userEO);
        return Result.success(userEO);
    }

}
