package com.adc.da.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.test.dao.PartsEODao;
import com.adc.da.test.entity.PartsEO;


/**
 *
 * <br>
 * <b>功能：</b>parts PartsEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-12 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("partsEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class PartsEOService extends BaseService<PartsEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(PartsEOService.class);

    @Autowired
    private PartsEODao dao;

    public PartsEODao getDao() {
        return dao;
    }

}
