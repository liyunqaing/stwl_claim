package com.adc.da.checkData.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.checkData.dao.CheckdataEODao;
import com.adc.da.checkData.entity.CheckdataEO;


/**
 *
 * <br>
 * <b>功能：</b>checkData CheckdataEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-16 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("checkdataEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class CheckdataEOService extends BaseService<CheckdataEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(CheckdataEOService.class);

    @Autowired
    private CheckdataEODao dao;

    public CheckdataEODao getDao() {
        return dao;
    }

}
