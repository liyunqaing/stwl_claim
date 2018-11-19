package com.adc.da.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.user.dao.UserEODao;
import com.adc.da.user.entity.UserEO;


/**
 *
 * <br>
 * <b>功能：</b>TS_USER UserEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-16 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("userEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class UserEOService extends BaseService<UserEO, Void> {

    private static final Logger logger = LoggerFactory.getLogger(UserEOService.class);

    @Autowired
    private UserEODao dao;

    public UserEODao getDao() {
        return dao;
    }

}
