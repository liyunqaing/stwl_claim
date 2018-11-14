package com.adc.da.hero.service;

import com.adc.da.hero.page.HeroEOPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.hero.dao.HeroEODao;
import com.adc.da.hero.entity.HeroEO;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>hero HeroEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-12 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("heroEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class HeroEOService extends BaseService<HeroEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(HeroEOService.class);

    @Autowired
    private HeroEODao dao;

    public HeroEODao getDao() {
        return dao;
    }

    /**
     * 获取hero详情
     * 刘笑天
     * @param heroEO
     * @return
     */
    public HeroEO selectHeroByHid(HeroEO heroEO){
        return dao.selectHeroByHid(heroEO);
    }

    //from官方文档
    public List<HeroEO> queryByList(HeroEOPage page){
        return dao.queryByList(page);
    }

}
