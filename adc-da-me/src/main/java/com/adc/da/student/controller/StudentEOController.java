package com.adc.da.student.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.student.entity.StudentEO;
import com.adc.da.student.page.StudentEOPage;
import com.adc.da.student.service.StudentEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/student/student")
@Api(description = "|StudentEO|")
public class StudentEOController extends BaseController<StudentEO>{

    private static final Logger logger = LoggerFactory.getLogger(StudentEOController.class);

    @Autowired
    private StudentEOService studentEOService;

	@ApiOperation(value = "|StudentEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("student:student:page")
    public ResponseMessage<PageInfo<StudentEO>> page(StudentEOPage page) throws Exception {
        List<StudentEO> rows = studentEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|StudentEO|查询")
    @GetMapping("")
    @RequiresPermissions("student:student:list")
    public ResponseMessage<List<StudentEO>> list(StudentEOPage page) throws Exception {
        return Result.success(studentEOService.queryByList(page));
	}

    @ApiOperation(value = "|StudentEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("student:student:get")
    public ResponseMessage<StudentEO> find(@PathVariable String id) throws Exception {
        return Result.success(studentEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|StudentEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("student:student:save")
    public ResponseMessage<StudentEO> create(@RequestBody StudentEO studentEO) throws Exception {
        studentEOService.insertSelective(studentEO);
        return Result.success(studentEO);
    }

    @ApiOperation(value = "|StudentEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("student:student:update")
    public ResponseMessage<StudentEO> update(@RequestBody StudentEO studentEO) throws Exception {
        studentEOService.updateByPrimaryKeySelective(studentEO);
        return Result.success(studentEO);
    }

    @ApiOperation(value = "|StudentEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("student:student:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        studentEOService.deleteByPrimaryKey(id);
        logger.info("delete from TS_STUDENT where id = {}", id);
        return Result.success();
    }

    @ApiOperation(value = "|StudentVO1|多表查询1")
    @GetMapping("/searchScore")
    @RequiresPermissions("student:student:scoList")
    public ResponseMessage stuSCore() throws Exception {
        return Result.success(studentEOService.stuSCore());
    }

    @ApiOperation(value = "|StudentVO1|多表查询2")
    @GetMapping("/searchName")
    @RequiresPermissions("student:student:stuList")
    public ResponseMessage osStudent() throws Exception {
        return Result.success(studentEOService.osStudent());
    }


}
