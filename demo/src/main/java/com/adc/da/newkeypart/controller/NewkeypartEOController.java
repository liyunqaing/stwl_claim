//package com.adc.da.newkeypart.controller;
//
//import static com.adc.da.newkeypart.util.SerializeUtil.serialize;
//import static com.adc.da.newkeypart.util.SerializeUtil.unserialize;
//import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.*;
//
//import com.adc.da.efiles.entity.EfilesEO;
//import com.adc.da.efiles.service.EfilesEOService;
//import com.adc.da.excel.poi.excel.ExcelExportUtil;
//import com.adc.da.excel.poi.excel.ExcelImportUtil;
//import com.adc.da.excel.poi.excel.entity.ExportParams;
//import com.adc.da.excel.poi.excel.entity.ImportParams;
//import com.adc.da.excel.poi.excel.entity.enums.ExcelType;
//import com.adc.da.excel.poi.excel.entity.result.ExcelImportResult;
//import com.adc.da.excel.poi.excel.entity.result.ExcelVerifyHanlderErrorResult;
//import com.adc.da.file.controller.FileUploadRestController;
//import com.adc.da.file.entity.FileEO;
//import com.adc.da.file.service.FileEOService;
//import com.adc.da.file.store.IFileStore;
//import com.adc.da.newkeypart.dto.NewKeypartDto;
//import com.adc.da.notify.service.NotifyService;
//import com.adc.da.pdf.PDFUtils;
//import com.adc.da.util.exception.AdcDaBaseException;
//import com.adc.da.util.utils.*;
//import com.adc.da.util.utils.UUID;
//import com.alibaba.fastjson.JSON;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.sun.istack.internal.NotNull;
//import org.apache.commons.io.FileUtils;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.adc.da.base.web.BaseController;
//import com.adc.da.newkeypart.entity.NewkeypartEO;
//import com.adc.da.newkeypart.page.NewkeypartEOPage;
//import com.adc.da.newkeypart.service.NewkeypartEOService;
//
//import com.adc.da.util.http.ResponseMessage;
//import com.adc.da.util.http.Result;
//import com.adc.da.util.http.PageInfo;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.web.multipart.MultipartFile;
//import redis.clients.jedis.Jedis;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@RestController
//@RequestMapping("/${restPath}/newkeypart/newkeypart")
//@Api(description = "|NewkeypartEO|")
//public class NewkeypartEOController extends BaseController<NewkeypartEO> {
//
//    private static final Logger logger = LoggerFactory.getLogger(NewkeypartEOController.class);
//
//    @Autowired
//    private NewkeypartEOService newkeypartEOService;
//
//    @Autowired
//    private EfilesEOService efilesEOService;
//    @Autowired
//    private IFileStore iFileStore;
//    @Autowired
//    private FileEOService fileEOService;
//    @Autowired
//    private NotifyService notifyService;
//    // 上传文件类型允许白名单
//    private List<String> whiteUrls;
//    @PostConstruct
//    public void init() {
//        // 读取文件
//        String path = FileUploadRestController.class.getResource("/").getFile();
//        whiteUrls = FileUtil.readAsStringList(path + "white/uploadWhite.txt");
//    }
//
//    @ApiOperation(value = "|NewkeypartEO|分页查询")
//    @GetMapping("/page")
//    @RequiresPermissions("newkeypart:newkeypart:page")
//    public ResponseMessage<PageInfo<NewkeypartEO>> page(NewkeypartEOPage page) throws Exception {
//        List<NewkeypartEO> rows = newkeypartEOService.queryByPage(page);
//        return Result.success(getPageInfo(page.getPager(), rows));
//    }
//
//    @ApiOperation(value = "|NewkeypartEO|查询")
//    @GetMapping("")
//    @RequiresPermissions("newkeypart:newkeypart:list")
//    public ResponseMessage<List<NewkeypartEO>> list(NewkeypartEOPage page) throws Exception {
//        newkeypartEOService.queryByList(page);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "|NewkeypartEO|详情")
//    @GetMapping("/{id}")
//    @RequiresPermissions("newkeypart:newkeypart:get")
//    public ResponseMessage<NewkeypartEO> find(@PathVariable String id) throws Exception {
//        return Result.success(newkeypartEOService.selectByPrimaryKey(id));
//    }
//
//    @ApiOperation(value = "|NewkeypartEO|新增")
//    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
//    @RequiresPermissions("newkeypart:newkeypart:save")
//    public ResponseMessage<NewkeypartEO> create(@RequestBody NewkeypartEO newkeypartEO) throws Exception {
//        newkeypartEOService.insertSelective(newkeypartEO);
//        return Result.success(newkeypartEO);
//    }
//
//    @ApiOperation(value = "|NewkeypartEO|修改")
//    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
//    @RequiresPermissions("newkeypart:newkeypart:update")
//    public ResponseMessage<NewkeypartEO> update(@RequestBody NewkeypartEO newkeypartEO) throws Exception {
//        newkeypartEOService.updateByPrimaryKeySelective(newkeypartEO);
//        return Result.success(newkeypartEO);
//    }
//
//    @ApiOperation(value = "|NewkeypartEO|删除")
//    @DeleteMapping("/{id}")
//    @RequiresPermissions("newkeypart:newkeypart:delete")
//    public ResponseMessage delete(@PathVariable String id) throws Exception {
//        newkeypartEOService.deleteByPrimaryKey(id);
//        logger.info("delete from newkeypart where id = {}", id);
//        return Result.success();
//    }
//
//    /**
//     * 上传excel（固定某个excel）数据到数据库
//     * 刘笑天
//     * 20181121 增加了批量insert83条以上数据的控制
//     * @param fileId
//     * @return
//     * @throws Exception
//     */
//    @ApiOperation(value = "excel数据上传到库")
//    @PostMapping("/newkeyPartExcelImport/{fileId}")
//    public ResponseMessage uploadData(@PathVariable("fileId") String fileId)
//            throws Exception {
//        if (StringUtils.isEmpty(fileId)) {
//            throw new AdcDaBaseException("excel不存在");
//        }
//
//        EfilesEO efilesEO = efilesEOService.selectByPrimaryKey(fileId);
//        if (efilesEO == null) {
//            throw new AdcDaBaseException("excel不存在");
//        }
//
//        // 获取文件输入流
//        //官方文档写法 iFileStore无法识别（已解决 需要引入以来并注入IFileStore）
////        InputStream is1 = iFileStore.loadFile(efilesEO.getSavePath());
//        File initialFile = new File(efilesEO.getSavePath());
//        InputStream is = FileUtils.openInputStream(initialFile);
//        // 导入参数设置，默认即可
//        ImportParams params = new ImportParams();
//        params.setTitleRows(6);//设置表头一共占几行 插入数据库不包含表头
//        params.setKeyIndex(1);//意义不明确 目前认为是设置从非空白列之后的第几列开始读取 目前设置针对对应excel可以进行读取
////        params.setStartRows(1);
//        // 解析excel，并返回校验信息
//        ExcelImportResult<NewKeypartDto> result = ExcelImportUtil.importExcelVerify(is, NewKeypartDto.class, params);
//        // 如果校验不通过，返回错误信息
//        if (result.isVerfiyFail()) {
//            logger.error("excel校验不通过！");
//            List<ExcelVerifyHanlderErrorResult> errors = result.getErrors();
//            StringBuffer stringBuffer = new StringBuffer("");
//            for (ExcelVerifyHanlderErrorResult error : errors) {
//                stringBuffer.append("[").append(error.getRowNum()).append("行")
//                        .append(error.getColumnNum()).append("列]").append(error.getMsg())
//                        .append("/t/n");
//            }
//            return Result.error("r0101", stringBuffer.toString());
//        }
//        // 校验通过，数据入库
//        List<NewKeypartDto> datas = result.getList();
//        List<NewkeypartEO> datasEO = new ArrayList<>();
//        for (NewKeypartDto dto : datas) {
//            NewkeypartEO eo = new NewkeypartEO();
//            BeanUtils.copyProperties(dto, eo);
//            if (eo.getIsNoticed().length() != 0) {
//                eo.setIsNoticed("是");
//            } else {
//                eo.setIsNoticed("否");
//            }
//            if (eo.getIsccc().length() != 0) {
//                eo.setIsccc("是");
//            } else {
//                eo.setIsccc("否");
//            }
//            if (eo.getIsEnvironmentalProtection().length() != 0) {
//                eo.setIsEnvironmentalProtection("是");
//            } else {
//                eo.setIsEnvironmentalProtection("否");
//            }
//            if (eo.getIscccCertificate().length() != 0) {
//                eo.setIscccCertificate("是");
//            } else {
//                eo.setIscccCertificate("否");
//            }
//            eo.setId(UUID.randomUUID());
//            datasEO.add(eo);
//        }
//        //循环批量插入数据库 begin
//        //初始化subList的startindex
//        int startIndex = 0;
//        //初始化subList的endindex
//        int endIndex = 83;
//        //循环insert的次数 以83条/次 为单位插入量
//        int insertTimes = datasEO.size() / 83;
//        //不能被83整除 得到list剩下的内容
//        int restData = datasEO.size() % 83;
//        //为余数部分添加一次insert次数
//        if (restData != 0) {
//            insertTimes++;
//        }
//        //insert开始
//        for (int i = 1; i <= insertTimes; i++) {
//            if (restData != 0 && i == insertTimes) {
//                endIndex += restData;
//                newkeypartEOService.batchInsert(datasEO.subList(startIndex, endIndex));
//            } else {
//                newkeypartEOService.batchInsert(datasEO.subList(startIndex, endIndex));
//                startIndex += 83;
//                if (endIndex == datas.size() - restData) {
//                    continue;
//                }
//                endIndex += 83;
//            }
//        }
//        //insert结束
//        //循环批量出入数据库 end
//
//        /*//循环单条插入数据库 begin
//        for (int i = 0; i < datasEO.size(); i++) {
//            newkeypartEOService.insertSelective(datasEO.get(i));
//        }
//        //循环单条插入数据库 end*/
//
//        return Result.success();
//    }
//
//    /**
//     * 导出数据到excel
//     * 刘笑天
//     * 20181115
//     * @param response
//     * @throws Exception
//     */
//    @ApiOperation(value = "newkeypart表数据导出excel")
//    @GetMapping("/newkeypartExcelExport/download")
//    public void downloadTempData(HttpServletResponse response) throws Exception {
//        OutputStream os = null;
//        Workbook workbook = null;
//        try {
//
//            response.setHeader(
//                    "Content-Disposition",
//                    "attachment; filename=" + Encodes.urlEncode("newkeypart.xlsx"));
//            response.setContentType("application/force-download");
//            ExportParams exportParams = new ExportParams();
//            exportParams.setType(ExcelType.XSSF);
//            List<NewkeypartEO> datas = newkeypartEOService.queryByList(new NewkeypartEOPage());
//            List<NewKeypartDto> datasDto = new ArrayList<>();
//            if (datas != null && !datas.isEmpty()) {
//                for (NewkeypartEO eo : datas) {
//                    NewKeypartDto dto = new NewKeypartDto();
//                    BeanUtils.copyProperties(eo, dto);
//                    datasDto.add(dto);
//                }
//            }
//            workbook = ExcelExportUtil.exportExcel(exportParams, NewKeypartDto.class, datasDto);
//            os = response.getOutputStream();
//            workbook.write(os);
//            os.flush();
//        } catch (IOException e) {
//            logger.error(e.getMessage(), e);
//            throw new AdcDaBaseException("导出数据文件失败，请重试");
//        } finally {
//            IOUtils.closeQuietly(os);
//            /*if(workbook!=null){
////                workbook.close();//新版本没有close方法了
//            }*/
//        }
//    }
//
//    /**
//     * 向redis里存值
//     * 刘笑天
//     * 20181115
//     * @return
//     * @throws Exception
//     */
//    @ApiOperation(value = "redis测试|将值存入redis")
//    @PostMapping("/testAdd2Redis")
//    public ResponseMessage testAdd2Redis() throws Exception {
////        官方网站写法 初始化jedis
//        JedisUtil jedisUtil = JedisUtil.getInstance();
//        jedisUtil.getPool();
//        Jedis jedis = jedisUtil.getJedis();
////        Jedis jedis = new Jedis("localhost");
//        jedis.del("list".getBytes());//首先清空之前list里的内容
//        List<NewkeypartEO> list = newkeypartEOService.queryAll();//操作数据库 得到数据
//        //得到数据后缓存到redis中
//        if (list.size() != 0) {
//            for (int i = 0; i < list.size(); i++) {
//                NewkeypartEO newkeypartEO = new NewkeypartEO();
////                newkeypartEO = newkeypartEOService.queryAll().get(i);
//                newkeypartEO = list.get(i);
//                jedis.lpush("list".getBytes(), serialize(newkeypartEO));//将对象序列化 然后添加到redis的list中
////                jedis.lpush("list", JSON.toJSONString(newkeypartEO));//添加方法2 将对象转化为JSON字符串 未测试是否可行
////            jedis.set("list".getBytes(),serialize(newkeypartEO));
//            }
//            return Result.success();
//        } else {
//            return Result.error("数据库没有数据");
//        }
//
//    }
//
//    /**
//     * 从redis里取值
//     * 刘笑天
//     * 20181115
//     * @return 取到的值
//     * @throws Exception
//     */
//    @ApiOperation(value = "redis测试|从redis里取值")
//    @PostMapping("/testGetFromRedis")
//    public ResponseMessage testGetFromRedis() throws Exception {
//        Jedis jedis = new Jedis("localhost");
////        jedis.get("list").getBytes();
//        List<byte[]> jlist = jedis.lrange("list".getBytes(), 0, -1);//将redis的list中的反序列化 即还原成对象
////        List<String> list2= jedis.lrange("list",0,-1);//取到方法2中存放的值 未测试
//        if (jlist.size() != 0) {
//            List<NewkeypartEO> list = new ArrayList();
//            for (int i = 0; i < jlist.size(); i++) {
//                NewkeypartEO newkeypartEO = (NewkeypartEO) unserialize(jlist.get(i));
////                NewkeypartEO newkeypartEO1 = new NewkeypartEO();
////                (NewkeypartEO) JSON.parseObject(list2.get(i),newkeypartEO1);//此处有问题
//                list.add(newkeypartEO);
//            }
//            return Result.success("","从缓存中取值成功！");
//        } else {
//            return Result.error("缓存中没有数据");
//        }
//    }
//
//    /**
//     * 文件下载
//     * 刘笑天 20181121
//     * @param response
//     * @param fileId
//     * @param fileName
//     * @throws Exception
//     */
//    @ApiOperation(value = "|FileEO|下载")
//    @GetMapping("/{fileId}/download")
//// @RequiresPermissions("sys:file:download")
//    public void downFile(HttpServletResponse response, @NotNull @PathVariable("fileId") String fileId,
//            String fileName) throws Exception {
//        if (StringUtils.isEmpty(fileId)) {
//            throw new AdcDaBaseException("FileId不能为空");
//        }
//
//        FileEO sysFileEO = fileEOService.selectByPrimaryKey(fileId);
//        if (sysFileEO == null) {
//            throw new AdcDaBaseException("FileId[" + fileId + "]不存在");
//        }
//
//        InputStream is = null;
//        OutputStream os = null;
//        try {
//            if (StringUtils.isEmpty(fileName)) {
//                fileName = sysFileEO.getFileName() + "." + sysFileEO.getFileType();
//            }
//
//            response.setHeader("Content-Disposition", "attachment; filename=" + Encodes.urlEncode(fileName));
//            response.setContentType(sysFileEO.getContentType());
//            is = iFileStore.loadFile(sysFileEO.getSavePath());
//            os = response.getOutputStream();
//            IOUtils.copy(is, os);
//            os.flush();
//        } catch (IOException e) {
//            logger.error(e.getMessage(), e);
//            throw new AdcDaBaseException("下载文件失败，请重试");
//        } finally {
//            IOUtils.closeQuietly(is);
//            IOUtils.closeQuietly(os);
//        }
//    }
//
//    /**
//     * 文件上传
//     * 刘笑天 20181121
//     * @param filePath 指定文件上传路径，空则在根路径
//     * @return
//     * @throws Exception
//     */
//    @ApiOperation(value = "|FileEO|上传")
//    @PostMapping("/upload")
//// @RequiresPermissions("sys:file:upload")
//    public ResponseMessage<FileEO> upload(String filePath, String userId, @RequestParam("file") MultipartFile file) throws Exception {
//        Long starttime = System.currentTimeMillis();
//        FileEO fileEO;
//        InputStream is = null;
//        try {
//            String fileExtension = FileUtil.getFileExtension(file.getOriginalFilename());
//            if (!whiteUrls.contains(fileExtension)) {
//                logger.error("上传文件类型不允许，请重试");
//                return Result.error("r0071", "上传文件类型不允许，请重试");
//            }
//
//            is = file.getInputStream();
//            String path = iFileStore.storeFile(is, fileExtension, filePath);
//
//            fileEO = new FileEO();
//            fileEO.setFileId(UUID.randomUUID());
//            fileEO.setFileName(FileUtil.getFileName(file.getOriginalFilename()));
//            fileEO.setFileType(fileExtension);
//            fileEO.setContentType(file.getContentType());
//            fileEO.setSavePath(path);
//            fileEO.setCreateTime(new Date());
//            fileEO.setUserId(userId);
//            fileEOService.insertSelective(fileEO);
//        } catch (IOException e) {
//            logger.error(e.getMessage(), e);
//            return Result.error("r0072", "文件存储失败，请重试");
//        } finally {
//            IOUtils.closeQuietly(is);
//        }
//        Long endtime = System.currentTimeMillis();
//        System.out.println(endtime - starttime + "ms");
//        return Result.success(fileEO);
//    }
//
//    /**
//     * 测试生成pdf
//     * 刘笑天 201811122
//     *
//     * @return
//     * @throws Exception
//     */
//    @ApiOperation(value = "|测试生成pdf|")
//    @PostMapping("/testExportPDF")
//    public ResponseMessage testExprotPDF() throws Exception {
//        //获取对象
//        NewkeypartEO newkeypartEO = newkeypartEOService.selectByPrimaryKey("00179b5952e44607af15e7a6c6771a68");
//
//        //用list记录pdf输入顺序
//        List<Element> pdfList = new ArrayList();
//        //设置标题
//        Paragraph title = new Paragraph("CN180C关键零部件控制清单2018.09", PDFUtils.createfontCN(30));
//        //居中显示
//        title.setAlignment(Element.ALIGN_CENTER);
//
//        //pdf添加标题
//        pdfList.add(title);
//        //一个每行三列的表
//        PdfPTable pdfPTable = new PdfPTable(3);
//
//        //第一行：标题
//        PdfPCell pdfPCell = new PdfPCell(new Paragraph("零部件名称", PDFUtils.createfontCN(20)));
//        //设置单元格边框 0f表示无边框
//        pdfPCell.setBorderWidth(0f);
//        //设置单元格内容位置：居中
//        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        pdfPTable.addCell(pdfPCell);
//
//        pdfPTable.addCell(new Paragraph("公告", PDFUtils.FONTCN));
//        pdfPTable.addCell(new Paragraph("3C", PDFUtils.FONTCN));
//        //第二行：对应参数
//        pdfPTable.addCell(new Paragraph(newkeypartEO.getPartName(), PDFUtils.FONTCN));
//        pdfPTable.addCell(new Paragraph(newkeypartEO.getIsNoticed(), PDFUtils.FONTCN));
//        pdfPTable.addCell(new Paragraph(newkeypartEO.getIsccc(), PDFUtils.FONTCN));
//        //第三行：标题
//        pdfPTable.addCell(new Paragraph("零部件名称", PDFUtils.FONTCN));
//        pdfPTable.addCell(new Paragraph("公告", PDFUtils.FONTCN));
//        pdfPTable.addCell(new Paragraph("3C", PDFUtils.FONTCN));
//        //第四行：对应参数
//        pdfPTable.addCell(new Paragraph(newkeypartEO.getPartName(), PDFUtils.FONTCN));
//        pdfPTable.addCell(new Paragraph(newkeypartEO.getIsNoticed(), PDFUtils.FONTCN));
//        pdfPTable.addCell(new Paragraph(newkeypartEO.getIsccc(), PDFUtils.FONTCN));
//        //表前距
//        pdfPTable.setSpacingBefore(50f);
//        //添加表
//        pdfList.add(pdfPTable);
//
//        //插入图片
//        Image image = Image.getInstance("E:\\files\\meow.gif");
//        image.scaleToFit(PageSize.A5.rotate());
//        //设置图片绝对位置 坐标轴原点位于pdf页面左下角
//        image.setAbsolutePosition(300, 550);
//        //设置图片绝对大小
//        image.scaleAbsolute(100f, 100f);
//        //添加图片
//        pdfList.add(image);
//
//        //生成PDF 位于项目目录根目录下path文件夹内
//        File file = new File("path/filename.pdf");
//        file.getParentFile().mkdirs();
////        //非组件自带 20181121刘笑天添加 用于提示文件是否被占用
////        if (!file.renameTo(file)) {
////            return Result.error("文件被占用，请关闭文件后重新尝试！");
////        }
//        new PDFUtils().createPdf("path/filename.pdf", pdfList);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "|发送邮件测试|")
//    @PostMapping("/sendEmail")
//    public ResponseMessage<Object> sendEmail(MultipartFile multipartFile,@RequestParam String toEmail,@RequestParam String emailTitle,@RequestParam String content, HttpServletResponse response, HttpServletRequest request) throws IOException{
////        String toEmail=request.getParameter("toEmail");
////        String emailTitle=request.getParameter("emailTitle");
////        String content=request.getParameter("content");
//        File file = new File("E:\\files\\heros.xlsx");
//        if(toEmail!=null) {
//            try {
//                //发送普通邮件
////                notifyService.sendEmail(toEmail,emailTitle, content);
//                //发送带附件邮件
//                notifyService.sendMultiEmail(toEmail,emailTitle, content,file);
//            }catch (Exception e) {
//                e.printStackTrace();
//                return Result.error("对方邮件地址是-》" + toEmail + " 内容是-》 " + content);
//            }
//        }
//        return Result.success();
//    }
//}
