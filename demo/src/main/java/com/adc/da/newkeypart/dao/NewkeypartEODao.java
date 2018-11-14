package com.adc.da.newkeypart.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.newkeypart.entity.NewkeypartEO;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>newkeypart NewkeypartEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-13 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface NewkeypartEODao extends BaseDao<NewkeypartEO> {
    void batchInsert(List<NewkeypartEO> newkeypartEOList);
}
