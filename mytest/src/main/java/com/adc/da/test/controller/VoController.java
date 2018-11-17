package com.adc.da.test.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.test.entity.DemoEO;
import com.adc.da.test.entity.DemoVo;
import com.adc.da.test.page.DemoVoPage;
import com.adc.da.test.service.DemoEOService;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @Description:   _多表查询
 *                  spring.datasource.url = jdbc:sqlserver://localhost:1433;databaseName=test
 *                  spring.datasource.username = sa
 *                  spring.datasource.password = 12345
* @Author:         yueben
* @CreateDate:     2018/11/14 13:52
*/
@RestController
@RequestMapping("/${restPath}/test/demo")
public class VoController extends BaseController<DemoVo> {

    private static final Logger logger = LoggerFactory.getLogger(VoController.class);

    @Autowired
    private DemoEOService demoEOService;

    /**
    * @Description:   _多表模糊查询，生成代码的分页查询不好使，已修改了sql语句拼写
    * @Author:         yueben
    * @CreateDate:     2018/11/14 20:38
    */
    @GetMapping("/voquery")
    public ResponseMessage<PageInfo<DemoVo>> fuzzyQuery(DemoVoPage page)throws Exception{
        List<DemoVo> demoVos = demoEOService.fuzzyVoQuery(page);
        return Result.success(getPageInfo(page.getPager(),demoVos));
    }



}
