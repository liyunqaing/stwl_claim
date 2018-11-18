package com.adc.da.test.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.test.entity.DemoEO;
import com.adc.da.test.entity.DemoVo;
import com.adc.da.test.page.DemoVoPage;
import com.adc.da.test.service.DemoEOService;
import com.adc.da.test.service.VoService;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private VoService voService;

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

    //多表删除，通过事务控制，当其中一张表删除失败时，其他已经执行的sql语句会回滚
    @GetMapping("/vodelete")
    public ResponseMessage moreTbaleDelete(String aid){
        try{
            int n = voService.moreTbaleDelete(aid);
            System.out.println(n);
        }catch ( Exception e){
            e.printStackTrace();
            return Result.error("删除失败");
        }
        return Result.success("删除成功");
    }

    @PostMapping("/voupdate")
    public ResponseMessage moreTableUpdate(DemoVo demoVo){
        try {
            int i = voService.moreTableUpdate(demoVo);
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("修改失败");
        }
        return Result.success("修改成功");
    }

    @PostMapping("/voinsert")
    public ResponseMessage moreTableInsert(DemoVo demoVo){
        try {
            int i = voService.moreTableInsert(demoVo);
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("新增失败");
        }

        return Result.success("新增成功");
    }




}
