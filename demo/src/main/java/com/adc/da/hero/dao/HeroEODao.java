package com.adc.da.hero.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.hero.entity.HeroEO;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>hero HeroEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-12 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface HeroEODao extends BaseDao<HeroEO> {
    /**
     * 获取Hero详情
     * 刘笑天
     * @param heroEO
     * @return
     */
    HeroEO selectHeroByHid(HeroEO heroEO);
}
