package com.adc.da.elk.service;

import com.adc.da.elk.vo.elkVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.elk.dao.UusersEODao;
import com.adc.da.elk.entity.UusersEO;

import java.util.List;


/**
 *
 * <br>
 * <b>功能：</b>UUSERS UusersEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-28 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("uusersEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class UusersEOService extends BaseService<UusersEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(UusersEOService.class);

    @Autowired
    private static UusersEODao dao;

    public UusersEODao getDao() {
        return dao;
    }


    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: elk_wangchengxin
     * @Date:
    */

    public List<elkVO> userAge() {
        return dao.userAge();
    }

    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: elk_wangchengxin
     * @Date:
    */

    public List<elkVO> age(){
        return dao.age();
    }
}
