package com.adc.da.sys.service;

import com.adc.da.sys.util.Md5Encrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.sys.dao.Hpm05userEODao;
import com.adc.da.sys.entity.Hpm05userEO;


/**
 *
 * <br>
 * <b>功能：</b>HPM05USER Hpm05userEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-06 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("hpm05userEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class Hpm05userEOService extends BaseService<Hpm05userEO, Integer> {

    private static final Logger logger = LoggerFactory.getLogger(Hpm05userEOService.class);

    @Autowired
    private Hpm05userEODao dao;

    public Hpm05userEODao getDao() {
        return dao;
    }

    public Hpm05userEO save(Hpm05userEO hpm05userEO) {
        hpm05userEO.setPaswd(Md5Encrypt.generatePassword(hpm05userEO.getPaswd()));
        dao.insertSelective(hpm05userEO);
        return hpm05userEO;
    }
}