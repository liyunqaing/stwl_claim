package com.adc.da.fyxTest.service;

import com.adc.da.excel.poi.excel.ExcelImportUtil;
import com.adc.da.excel.poi.excel.entity.ImportParams;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.fyxTest.dao.EstEODao;
import com.adc.da.fyxTest.entity.EstEO;


import java.io.InputStream;
import java.util.List;


/**
 *
 * <br>
 * <b>功能：</b>Test EstEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-20 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("estEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class EstEOService extends BaseService<EstEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(EstEOService.class);

    @Autowired
    private EstEODao dao;

    public EstEODao getDao() {
        return dao;
    }

    public void ExcelImport(InputStream is, ImportParams params) throws Exception {
        List<EstEO> datas = ExcelImportUtil.importExcel(is, EstEO.class, params );
        importData(datas);
    }
    public void importData(List<EstEO> datas){
        for(EstEO dto : datas){
            EstEO eo = new EstEO();
            BeanUtils.copyProperties(dto, eo);
            eo.setId(DigestUtils.md5Hex(dto.toString()));
            try {
                dao.batchInsert(eo);
            }catch (Exception e){
                logger.error(e.getMessage(), e);
            }
        }
    }

}
