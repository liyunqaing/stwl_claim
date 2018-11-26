package com.adc.da.adc_fileload;

import com.adc.da.file.controller.FileUploadRestController;
import com.adc.da.file.entity.FileEO;
import com.adc.da.file.service.FileEOService;
import com.adc.da.file.store.IFileStore;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.utils.FileUtil;
import com.adc.da.util.utils.IOUtils;
import com.adc.da.util.utils.UUID;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/${restPath}/myfileload")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private FileEOService fileEOService;
    @Autowired
    private IFileStore iFileStore;
    private List<String> whiteUrls = new ArrayList();

    public TestController() {
    }

    @PostConstruct
    public void init() {
        InputStream is = FileUploadRestController.class.getClassLoader().getResourceAsStream("white/uploadWhite.txt");
        BufferedReader reader = null;

        try {
            if (is != null) {
                reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                String line;
                while((line = reader.readLine()) != null) {
                    if (!"".equals(line)) {
                        this.whiteUrls.add(line);
                    }
                }
            }
        } catch (Exception var16) {
            logger.error("读取文件上传白名单异常", var16);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException var15) {
                logger.error("InputStream关闭异常", var15);
            }

            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException var14) {
                logger.error("FileInputStream关闭异常", var14);
            }

        }

    }

    @ApiOperation("|MyFile|上传")
    @PostMapping({"/upload"})
    @RequiresPermissions({"sys:file:upload"})
    public ResponseMessage<FileEO> upload(String filePath, String userId, @RequestParam("file") MultipartFile file) throws Exception {
        InputStream is = null;

        ResponseMessage var7;
        try {
            String fileExtension = FileUtil.getFileExtension(file.getOriginalFilename());
            if (this.whiteUrls.contains(fileExtension)) {
                is = file.getInputStream();
                String path = this.iFileStore.storeFile(is, fileExtension, filePath);
                FileEO fileEO = new FileEO();
                fileEO.setFileId(UUID.randomUUID());
                fileEO.setFileName(FileUtil.getFileName(file.getOriginalFilename()));
                fileEO.setFileType(fileExtension);
                fileEO.setContentType(file.getContentType());
                fileEO.setSavePath(path);
                fileEO.setCreateTime(new Date());
                fileEO.setUserId(userId);
                this.fileEOService.insertSelective(fileEO);
                return Result.success(fileEO);
            }

            logger.error("上传文件类型不允许，请重试");
            var7 = Result.error("r0071", "上传文件类型不允许，请重试");
        } catch (IOException var11) {
            logger.error(var11.getMessage(), var11);
            var7 = Result.error("r0072", "文件存储失败，请重试");
            return var7;
        } finally {
            IOUtils.closeQuietly(is);
        }

        return var7;
    }

}
