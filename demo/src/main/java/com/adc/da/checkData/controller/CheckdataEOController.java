package com.adc.da.checkData.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
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
public class CheckdataEOController extends BaseController<CheckdataEO> {

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

    /**
     * 测试证书校验接口|模拟解析得到数据并解析存入数据库
     * 刘笑天
     * 20181119
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "测试证书校验接口|模拟解析得到数据并解析存入数据库")
    @PostMapping("/testCheckData")
    public ResponseMessage testCheckData() throws Exception {
        // 服务地址
        URL url = new URL("http://localhost:8080/verification/rest/certificate");
        // 设定连接的相关参数
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        // 向服务端发送key=value对
        out.write("certificateNOS=2012011109533586&AppKey=0df9c84524be414696ac5bbeb968716b&signature=60c3722dcb6f8a27fb77b56251a888c5&timestamp=2018");
        out.flush();
        out.close();

        // 获取服务端的反馈
        String strLine = "";
        String strResponse = "";
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while ((strLine = reader.readLine()) != null) {
            strResponse += strLine;
        }
        //模拟得到的数据
//        String simulateStrResponse = "[{\"address\":\"123\",\"id\":\"0\",\"organizationAddress_Producer\":\"123\",\"standardsAndRequirements\":\"123\",\"specifications\":\"123\",\"organizationName_Client\":\"123\",\"organizationAddress_Client\":\"123\",\"organizationName_Producer\":\"123\",\"institutionName\":\"123\",\"institutionApprovalNO\":\"123\",\"validityPeriod\":\"123\",\"businessScope\":\"123\",\"agencyStatus\":\"123\",\"firstDateOfCertification\":\"123\",\"productCategory\":\"123\",\"nameAndUnitMain\":\"123\",\"unifiedCode_Client\":\"123\",\"unifiedCode_Producer\":\"123\",\"nameAndUnitSecondary\":\"123\",\"certificateAnnexDownload\":\"123\",\"informationReportDate\":\"123\",\"certificateExpirationDate\":\"123\",\"certificateDate\":\"123\",\"certificateStatus\":\"无效\",\"certificateNO\":\"2012011109533586\",\"phone\":\"123\",\"changeDate\":\"123\",\"del\":\"网站查询\",\"url\":\"123\"}]";
//        JSONArray jsonArray = JSONArray.parseArray(simulateStrResponse);
        JSONArray jsonArray = JSONArray.parseArray(strResponse);//获得到的list<string>转化为jsonArray
        List<CheckdataEO> list = new ArrayList();//如果使用批量查询 传入该list
        if (!jsonArray.isEmpty()) {
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);//拿到JSONArray里的一个jsonObject
                CheckdataEO checkdataEO = JSON.parseObject(JSON.toJSONString(jsonObject), CheckdataEO.class);//解析JSON对象为数据实体对象
                list.add(checkdataEO);//放到list中
            }
        }
        //一条一条插入数据库 因为到时候只需插入一条数据 不需要批量插入 所以这样就可以了
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).getCertificateStatus().equals("有效")) {//证书有效 插入数据库
                CheckdataEO checkdataEO = list.get(j);
                checkdataEOService.insertSelective(checkdataEO);
            } else {
                System.out.println(list.get(j).getAgencyStatus());
                continue;
            }
        }
        return Result.success();
    }
}
