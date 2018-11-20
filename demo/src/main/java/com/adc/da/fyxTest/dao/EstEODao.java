package com.adc.da.fyxTest.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.fyxTest.entity.EstEO;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>Test EstEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-20 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface EstEODao extends BaseDao<EstEO> {
    void batchInsert(EstEO eo);
    List<EstEO> getData();
    void clear();
}
