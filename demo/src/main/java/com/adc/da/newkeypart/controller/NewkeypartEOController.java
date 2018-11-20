package com.adc.da.newkeypart.controller;

import static com.adc.da.newkeypart.util.SerializeUtil.serialize;
import static com.adc.da.newkeypart.util.SerializeUtil.unserialize;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adc.da.efiles.entity.EfilesEO;
import com.adc.da.efiles.service.EfilesEOService;
import com.adc.da.excel.poi.excel.ExcelExportUtil;
import com.adc.da.excel.poi.excel.ExcelImportUtil;
import com.adc.da.excel.poi.excel.entity.ExportParams;
import com.adc.da.excel.poi.excel.entity.ImportParams;
import com.adc.da.excel.poi.excel.entity.enums.ExcelType;
import com.adc.da.excel.poi.excel.entity.result.ExcelImportResult;
import com.adc.da.excel.poi.excel.entity.result.ExcelVerifyHanlderErrorResult;
import com.adc.da.newkeypart.dto.NewKeypartDto;
import com.adc.da.util.exception.AdcDaBaseException;
import com.adc.da.util.utils.*;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.newkeypart.entity.NewkeypartEO;
import com.adc.da.newkeypart.page.NewkeypartEOPage;
import com.adc.da.newkeypart.service.NewkeypartEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/${restPath}/newkeypart/newkeypart")
@Api(description = "|NewkeypartEO|")
public class NewkeypartEOController extends BaseController<NewkeypartEO> {

    private static final Logger logger = LoggerFactory.getLogger(NewkeypartEOController.class);

    @Autowired
    private NewkeypartEOService newkeypartEOService;

    @Autowired
    private EfilesEOService efilesEOService;

    //    @Autowired
    private JedisUtil jedisUtil;

    @ApiOperation(value = "|NewkeypartEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("newkeypart:newkeypart:page")
    public ResponseMessage<PageInfo<NewkeypartEO>> page(NewkeypartEOPage page) throws Exception {
        List<NewkeypartEO> rows = newkeypartEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    @ApiOperation(value = "|NewkeypartEO|查询")
    @GetMapping("")
    @RequiresPermissions("newkeypart:newkeypart:list")
    public ResponseMessage<List<NewkeypartEO>> list(NewkeypartEOPage page) throws Exception {
        return Result.success(newkeypartEOService.queryByList(page));
    }

    @ApiOperation(value = "|NewkeypartEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("newkeypart:newkeypart:get")
    public ResponseMessage<NewkeypartEO> find(@PathVariable String id) throws Exception {
        return Result.success(newkeypartEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|NewkeypartEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("newkeypart:newkeypart:save")
    public ResponseMessage<NewkeypartEO> create(@RequestBody NewkeypartEO newkeypartEO) throws Exception {
        newkeypartEOService.insertSelective(newkeypartEO);
        return Result.success(newkeypartEO);
    }

    @ApiOperation(value = "|NewkeypartEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("newkeypart:newkeypart:update")
    public ResponseMessage<NewkeypartEO> update(@RequestBody NewkeypartEO newkeypartEO) throws Exception {
        newkeypartEOService.updateByPrimaryKeySelective(newkeypartEO);
        return Result.success(newkeypartEO);
    }

    @ApiOperation(value = "|NewkeypartEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("newkeypart:newkeypart:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        newkeypartEOService.deleteByPrimaryKey(id);
        logger.info("delete from newkeypart where id = {}", id);
        return Result.success();
    }

    /**
     * 上传excel数据到数据库
     * 刘笑天
     *
     * @param fileId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "excel数据上传到库")
    @PostMapping("/newkeyPartExcelImport/{fileId}")
    public ResponseMessage uploadData(@PathVariable("fileId") String fileId)
            throws Exception {
        if (StringUtils.isEmpty(fileId)) {
            throw new AdcDaBaseException("excel不存在");
        }

        EfilesEO efilesEO = efilesEOService.selectByPrimaryKey(fileId);
        if (efilesEO == null) {
            throw new AdcDaBaseException("excel不存在");
        }

        // 获取文件输入流
//        InputStream is1 = iFileStore.loadFile(efilesEO.getSavePath());//官方文档写法 iFileStore无法识别
        File initialFile = new File(efilesEO.getSavePath());
        InputStream is = FileUtils.openInputStream(initialFile);
        // 导入参数设置，默认即可
        ImportParams params = new ImportParams();
        params.setTitleRows(6);//设置表头一共占几行 插入数据库不包含表头
        params.setKeyIndex(1);//意义不明确 目前认为是设置从非空白列之后的第几列开始读取 目前设置针对对应excel可以进行读取
//        params.setStartRows(1);
        // 解析excel，并返回校验信息
        ExcelImportResult<NewKeypartDto> result = ExcelImportUtil.importExcelVerify(is, NewKeypartDto.class, params);
        // 如果校验不通过，返回错误信息
        if (result.isVerfiyFail()) {
            logger.error("excel校验不通过！");
            List<ExcelVerifyHanlderErrorResult> errors = result.getErrors();
            StringBuffer stringBuffer = new StringBuffer("");
            for (ExcelVerifyHanlderErrorResult error : errors) {
                stringBuffer.append("[").append(error.getRowNum()).append("行")
                        .append(error.getColumnNum()).append("列]").append(error.getMsg())
                        .append("/t/n");
            }
            return Result.error("r0101", stringBuffer.toString());
        }
        // 校验通过，数据入库
        List<NewKeypartDto> datas = result.getList();
        List<NewkeypartEO> datasEO = new ArrayList<>();
        for (NewKeypartDto dto : datas) {
            NewkeypartEO eo = new NewkeypartEO();
            BeanUtils.copyProperties(dto, eo);
            if (eo.getIsNoticed().length() != 0) {
                eo.setIsNoticed("是");
            } else {
                eo.setIsNoticed("否");
            }
            if (eo.getIsccc().length() != 0) {
                eo.setIsccc("是");
            } else {
                eo.setIsccc("否");
            }
            if (eo.getIsEnvironmentalProtection().length() != 0) {
                eo.setIsEnvironmentalProtection("是");
            } else {
                eo.setIsEnvironmentalProtection("否");
            }
            if (eo.getIscccCertificate().length() != 0) {
                eo.setIscccCertificate("是");
            } else {
                eo.setIscccCertificate("否");
            }
            eo.setId(UUID.randomUUID());
            datasEO.add(eo);
        }

        newkeypartEOService.batchInsert(datasEO);

        return Result.success();
    }

    /**
     * 导出数据到excel
     * 刘笑天
     *
     * @param response
     * @throws Exception
     */
    @ApiOperation(value = "newkeypart表数据导出excel")
    @GetMapping("/newkeypartExcelExport/download")
    public void downloadTempData(HttpServletResponse response) throws Exception {
        OutputStream os = null;
        Workbook workbook = null;
        try {

            response.setHeader(
                    "Content-Disposition",
                    "attachment; filename=" + Encodes.urlEncode("newkeypart.xlsx"));
            response.setContentType("application/force-download");
            ExportParams exportParams = new ExportParams();
            exportParams.setType(ExcelType.XSSF);
            List<NewkeypartEO> datas = newkeypartEOService.queryByList(new NewkeypartEOPage());
            List<NewKeypartDto> datasDto = new ArrayList<>();
            if (datas != null && !datas.isEmpty()) {
                for (NewkeypartEO eo : datas) {
                    NewKeypartDto dto = new NewKeypartDto();
                    BeanUtils.copyProperties(eo, dto);
                    datasDto.add(dto);
                }
            }
            workbook = ExcelExportUtil.exportExcel(exportParams, NewKeypartDto.class, datasDto);
            os = response.getOutputStream();
            workbook.write(os);
            os.flush();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new AdcDaBaseException("导出数据文件失败，请重试");
        } finally {
            IOUtils.closeQuietly(os);
            /*if(workbook!=null){
//                workbook.close();//新版本没有close方法了
            }*/
        }
    }

    /**
     * 向redis里存值
     * 刘笑天
     * 20181115
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "redis测试|将值存入redis")
    @PostMapping("/testAdd2Redis")
    public ResponseMessage testAdd2Redis() throws Exception {
//        官方网站写法 初始化jedis
        JedisUtil jedisUtil = JedisUtil.getInstance();
        jedisUtil.getJedis();
        jedisUtil.getPool();
        Jedis jedis = new Jedis("localhost");
        jedis.lpop("list".getBytes());//首先清空之前list里的内容
        List<NewkeypartEO> list = newkeypartEOService.queryAll();//操作数据库 得到数据
        //得到数据后缓存到redis中
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                NewkeypartEO newkeypartEO = new NewkeypartEO();
//                newkeypartEO = newkeypartEOService.queryAll().get(i);
                newkeypartEO = list.get(i);
                jedis.lpush("list".getBytes(), serialize(newkeypartEO));//将对象序列化 然后添加到redis的list中
//                jedis.lpush("list", JSON.toJSONString(newkeypartEO));//添加方法2 将对象转化为JSON字符串 未测试是否可行
//            jedis.set("list".getBytes(),serialize(newkeypartEO));
            }
            return Result.success(newkeypartEOService.queryAll());
        } else {
            return Result.error("数据库没有数据");
        }

    }

    /**
     * 从redis里取值
     * 刘笑天
     * 20181115
     * @return 取到的值
     * @throws Exception
     */
    @ApiOperation(value = "redis测试|从redis里取值")
    @PostMapping("/testGetFromRedis")
    public ResponseMessage testGetFromRedis() throws Exception {
        Jedis jedis = new Jedis("localhost");
//        jedis.get("list").getBytes();
        List<byte[]> jlist = jedis.lrange("list".getBytes(), 0, -1);//将redis的list中的反序列化 即还原成对象
//        List<String> list2= jedis.lrange("list",0,-1);//取到方法2中存放的值 未测试
        if (jlist.size() != 0) {
            List<NewkeypartEO> list = new ArrayList();
            for (int i = 0; i < jlist.size(); i++) {
                NewkeypartEO newkeypartEO = (NewkeypartEO) unserialize(jlist.get(i));
//                NewkeypartEO newkeypartEO1 = new NewkeypartEO();
//                (NewkeypartEO) JSON.parseObject(list2.get(i),newkeypartEO1);//此处有问题
                list.add(newkeypartEO);
            }
            return Result.success(list);
        } else {
            return Result.error("缓存中没有数据");
        }
    }
}
