package com.adc.da.stusqlserver.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.stusqlserver.entity.StudentEO;
import com.adc.da.stusqlserver.page.StudentEOPage;
import com.adc.da.stusqlserver.service.StudentEOService;
import com.adc.da.stusqlserver.entity.studentEto;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/stusqlserver/student1")
@Api(description = "|StudentEO1|")
public class StudentEOController extends BaseController<StudentEO>{

    private static final Logger logger = LoggerFactory.getLogger(StudentEOController.class);

    @Autowired
    private StudentEOService studentEOService;

	@ApiOperation(value = "|StudentEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("stusqlserver:student:page1")
    public ResponseMessage<PageInfo<StudentEO>> page(StudentEOPage page) throws Exception {
        List<StudentEO> rows = studentEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|StudentEO|查询")
    @GetMapping("")
    @RequiresPermissions("stusqlserver:student:list1")
    public ResponseMessage<List<StudentEO>> list(StudentEOPage page) throws Exception {
        return Result.success(studentEOService.queryByList(page));
	}

    @ApiOperation(value = "|StudentEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("stusqlserver:student:save1")
    public ResponseMessage<StudentEO> create(@RequestBody StudentEO studentEO) throws Exception {
        studentEOService.insertSelective(studentEO);
        return Result.success(studentEO);
    }
    @ApiOperation(value = "|StudentEO|多表查询1")
    @GetMapping("/allselect")
    @RequiresPermissions("student:student:allselect")
    public ResponseMessage stuSCore() throws Exception {
        return Result.success(studentEOService.allinsert());
    }

}
