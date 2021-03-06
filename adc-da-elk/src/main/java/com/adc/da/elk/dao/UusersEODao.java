package com.adc.da.elk.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.elk.entity.UusersEO;
import com.adc.da.elk.vo.elkVO;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>UUSERS UusersEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-28 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface UusersEODao extends BaseDao<UusersEO> {

    List<elkVO> userAge();

    List<elkVO> age();

}
