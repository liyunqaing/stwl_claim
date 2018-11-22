package com.adc.da.excel.service;


import org.apache.log4j.Logger;
import com.adc.da.excel.dto.excelDto;
import com.adc.da.excel.dao.ExcelDao;
import com.adc.da.excel.entity.excelEO;
import com.adc.da.excel.poi.excel.ExcelImportUtil;
import com.adc.da.excel.poi.excel.entity.ImportParams;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Service("excelEOServicen")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class excelService {
    @Autowired(required = false)
    private ExcelDao dao;
    private Logger logger;
////无验证的Excel导入
    public void ExcelImport(InputStream is, ImportParams params) throws Exception {

        List<excelDto> datas = ExcelImportUtil.importExcel(is, excelDto.class, params);
        System.out.println(datas.toString());
        System.out.println(datas.get(4));
        importData(datas);
    }

    public void importData (List < excelDto > datas) {
        for (excelDto dto : datas) {
            excelEO eo = new excelEO();
            BeanUtils.copyProperties(dto, eo);
            eo.setId(DigestUtils.md5Hex(dto.toString()));
            System.out.println(eo.toString());
            try {
                dao.batchInsert(eo);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}

