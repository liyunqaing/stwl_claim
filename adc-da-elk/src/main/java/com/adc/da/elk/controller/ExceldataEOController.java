package com.adc.da.elk.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adc.da.elk.dto.ExceldataEODto;
import com.adc.da.excel.poi.excel.ExcelExportUtil;
import com.adc.da.excel.poi.excel.ExcelImportUtil;
import com.adc.da.excel.poi.excel.entity.ExportParams;
import com.adc.da.excel.poi.excel.entity.ImportParams;
import com.adc.da.excel.poi.excel.entity.TemplateExportParams;
import com.adc.da.excel.poi.excel.entity.enums.ExcelType;
import com.adc.da.excel.poi.excel.entity.result.ExcelImportResult;
import com.adc.da.excel.poi.excel.entity.result.ExcelVerifyHanlderErrorResult;
import com.adc.da.excel.poi.word.WordExportUtil;
import com.adc.da.excel.poi.word.entity.MyXWPFDocument;
import com.adc.da.excel.poi.word.entity.WordImageEntity;
import com.adc.da.file.entity.FileEO;
import com.adc.da.file.service.FileEOService;
import com.adc.da.file.store.IFileStore;
import com.adc.da.util.exception.AdcDaBaseException;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.utils.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.elk.entity.ExceldataEO;
import com.adc.da.elk.page.ExceldataEOPage;
import com.adc.da.elk.service.ExceldataEOService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/${restPath}/elk/exceldata")
@Api(description = "|ExceldataEO|")
public class ExceldataEOController extends BaseController<ExceldataEO> {

    private static final Logger logger = LoggerFactory.getLogger(ExceldataEOController.class);

    @Autowired
    private ExceldataEOService exceldataEOService;
    @Autowired
    private FileEOService fileEOService;
    @Autowired
    private IFileStore iFileStore;

    @ApiOperation(value = "word文件下载")
    @GetMapping("/exp/tem/download")
    public void uploadData(HttpServletResponse response) throws Exception {
        Resource resource = SpringContextHolder.getApplicationContext()
                .getResource("classpath:yyyy.docx");
        Resource picture = SpringContextHolder.getApplicationContext()
                .getResource("classpath:20180315001.jpg");
        InputStream is = null;
        OutputStream os = null;
        MyXWPFDocument doc = null;
        try {

            response.setHeader("Content-Disposition",
                    "attachment; filename=" + Encodes.urlEncode("word_template.docx"));
            response.setContentType("application/force-download");

            TemplateExportParams templateExportParams = new TemplateExportParams();
            templateExportParams.setTemplateUrl(resource.getFile().getAbsolutePath());

            Map<String, Object> params = new HashMap<String, Object>();
            WordImageEntity pic = new WordImageEntity(picture.getFile().getAbsolutePath(),200, 200);
            params.put("reportDate", "today");
            params.put("AppleAmt", "100");
            params.put("BananaAmt", "200");
            params.put("TotalAmt", "300");
            params.put("picture", pic);

            is = resource.getInputStream();
            doc = new MyXWPFDocument(is);
            WordExportUtil.exportWord07(doc,params);
            os = response.getOutputStream();
            doc.write(os);
            os.flush();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new AdcDaBaseException("下载word文件失败，请重试");
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
            if (doc != null) {
                os.close();
            }
        }
    }

    /**
     * @Description:  表格文件下载
     * @Param:  HttpServletResponse response
     * @return:
     * @Author: elk_wangchengxin
     * @Date:  2018/11
    */

    @ApiOperation(value = "Excel数据下载")
    @GetMapping("/exp/data/download")
    public void download(HttpServletResponse response) throws Exception {
        OutputStream os = null;
        Workbook workbook = null;
        try {

            response.setHeader("Content-Disposition",
                    "attachment; filename=" + Encodes.urlEncode("表格数据.xlsx"));
            response.setContentType("application/force-download");
            ExportParams exportParams = new ExportParams();
            exportParams.setType(ExcelType.XSSF);
            List<ExceldataEO> datas = ExceldataEOService.queryByList(new ExceldataEOPage());
            List<ExceldataEO> datasDto = new ArrayList<>();
            if(datas!=null && !datas.isEmpty()){
                for(ExceldataEO eo : datas){
                    ExceldataEODto dto = new ExceldataEODto();
                    BeanUtils.copyProperties(eo, dto);
                    datasDto.add(dto);
                }
            }
            workbook = ExcelExportUtil.exportExcel(exportParams, ExceldataEODto.class, datasDto);
            os = response.getOutputStream();
            workbook.write(os);
            os.flush();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new AdcDaBaseException("下载汽车报价数据文件失败，请重试");
        } finally {
            IOUtils.closeQuietly(os);
            if(workbook!=null){
                os.close();
            }
        }
    }

    /**
     * @Description:  表格文件上传
     * @Param:  String fileId
     * @return: Result.success()
     * @Author: elk_wangchengxin
     * @Date:  2018/11
     */
    @ApiOperation(value = "Excle数据上传")
    @PostMapping("/imp/data/upload/{fileId}")
    public ResponseMessage uploadData(@NotNull @PathVariable("fileId") String fileId)
            throws Exception {
        if (StringUtils.isEmpty(fileId)) {
            throw new AdcDaBaseException("模板上传失败！请重新上传！");
        }

        FileEO fileEO = fileEOService.selectByPrimaryKey(fileId);
        if (fileEO == null) {
            throw new AdcDaBaseException("模板上传失败！请重新上传！");
        }

        // 获取文件输入流
        InputStream is = iFileStore.loadFile(fileEO.getSavePath());
        // 导入参数设置，默认即可
        ImportParams params = new ImportParams();
        // 解析excel，并返回校验信息
        ExcelImportResult<ExceldataEODto> result = ExcelImportUtil.importExcelVerify(is, ExceldataEODto.class, params );
        // 如果校验不通过，返回错误信息
        if(result.isVerfiyFail()){
            logger.error("excel校验不通过！");
            List<ExcelVerifyHanlderErrorResult> errors = result.getErrors();
            StringBuffer sb = new StringBuffer("");
            for(ExcelVerifyHanlderErrorResult error : errors){
                sb.append("[").append(error.getRowNum()).append("行")
                        .append(error.getColumnNum()).append("列]").append(error.getMsg())
                        .append("/t/n");
            }
            return Result.error("r0101", sb.toString());
        }
        // 校验通过，数据入库
        List<ExceldataEODto> datas = result.getList();
        List<ExceldataEO> datasEO = new ArrayList<>();
        for(ExceldataEODto dto : datas){
            ExceldataEO eo = new ExceldataEO();
            BeanUtils.copyProperties(dto, eo);
            eo.setCarId(UUID.randomUUID());
            datasEO.add(eo);
        }

        ExceldataEOService.batchInsert(datasEO);

        return Result.success();
    }

	/*@ApiOperation(value = "|ExceldataEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("elk:exceldata:page")
    public ResponseMessage<PageInfo<ExceldataEO>> page(ExceldataEOPage page) throws Exception {
        List<ExceldataEO> rows = exceldataEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|ExceldataEO|查询")
    @GetMapping("")
    @RequiresPermissions("elk:exceldata:list")
    public ResponseMessage<List<ExceldataEO>> list(ExceldataEOPage page) throws Exception {
        return Result.success(exceldataEOService.queryByList(page));
	}

    @ApiOperation(value = "|ExceldataEO|详情")
    @GetMapping("/{carId}")
    @RequiresPermissions("elk:exceldata:get")
    public ResponseMessage<ExceldataEO> find(@PathVariable String carId) throws Exception {
        return Result.success(exceldataEOService.selectByPrimaryKey(carId));
    }

    @ApiOperation(value = "|ExceldataEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("elk:exceldata:save")
    public ResponseMessage<ExceldataEO> create(@RequestBody ExceldataEO exceldataEO) throws Exception {
        exceldataEOService.insertSelective(exceldataEO);
        return Result.success(exceldataEO);
    }

    @ApiOperation(value = "|ExceldataEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("elk:exceldata:update")
    public ResponseMessage<ExceldataEO> update(@RequestBody ExceldataEO exceldataEO) throws Exception {
        exceldataEOService.updateByPrimaryKeySelective(exceldataEO);
        return Result.success(exceldataEO);
    }

    @ApiOperation(value = "|ExceldataEO|删除")
    @DeleteMapping("/{carId}")
    @RequiresPermissions("elk:exceldata:delete")
    public ResponseMessage delete(@PathVariable String carId) throws Exception {
        exceldataEOService.deleteByPrimaryKey(carId);
        logger.info("delete from EXCELDATA where carId = {}", carId);
        return Result.success();
    }*/

}
