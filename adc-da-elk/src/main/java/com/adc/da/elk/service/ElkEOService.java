package com.adc.da.elk.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.elk.dao.ElkEODao;
import com.adc.da.elk.entity.ElkEO;


/**
 *
 * <br>
 * <b>功能：</b>ELK ElkEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-28 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("elkEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class ElkEOService extends BaseService<ElkEO, Integer> {

    private static final Logger logger = LoggerFactory.getLogger(ElkEOService.class);

    @Autowired
    private static ElkEODao dao;

    public ElkEODao getDao() {
        return dao;
    }

}
