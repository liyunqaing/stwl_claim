package com.adc.da.newkeypart.service;

import com.adc.da.newkeypart.page.NewkeypartEOPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.newkeypart.dao.NewkeypartEODao;
import com.adc.da.newkeypart.entity.NewkeypartEO;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>newkeypart NewkeypartEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-13 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("newkeypartEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class NewkeypartEOService extends BaseService<NewkeypartEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(NewkeypartEOService.class);

    @Autowired
    private NewkeypartEODao dao;

    public NewkeypartEODao getDao() {
        return dao;
    }

    public List<NewkeypartEO> queryByList(NewkeypartEOPage page) {
        return dao.queryByList(page);
    }

    public void batchInsert(List<NewkeypartEO> newkeypartEOList) {
        dao.batchInsert(newkeypartEOList);
    }

}
