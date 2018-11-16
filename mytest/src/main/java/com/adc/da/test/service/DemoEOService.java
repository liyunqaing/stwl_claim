package com.adc.da.test.service;

import com.adc.da.base.page.BasePage;
import com.adc.da.test.entity.DemoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.test.dao.DemoEODao;
import com.adc.da.test.entity.DemoEO;

import java.util.List;


/**
 *
 * <br>
 * <b>功能：</b>demo DemoEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-09 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("demoEOService")
//@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class DemoEOService extends BaseService<DemoEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(DemoEOService.class);

    @Autowired
    private DemoEODao dao;

    public DemoEODao getDao() {
        return dao;
    }

    public List<DemoEO> queryAll(){
        return dao.queryAll();
    }

    public List<DemoEO> fuzzyQuery(BasePage page){
        return dao.fuzzyQuery(page);
    }

    public List<DemoVo> fuzzyVoQuery(BasePage basePage){
        return dao.fuzzyVoQuery(basePage);
    }
}
