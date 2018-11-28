package com.adc.da.elk.service;

import com.adc.da.elk.page.ExceldataEOPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.elk.dao.ExceldataEODao;
import com.adc.da.elk.entity.ExceldataEO;

import java.util.List;


/**
 *
 * <br>
 * <b>功能：</b>EXCELDATA ExceldataEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-28 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("exceldataEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class ExceldataEOService extends BaseService<ExceldataEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(ExceldataEOService.class);

    @Autowired
    private static ExceldataEODao dao;

    /**
     * @Description:  批量插入数据的方法
     * @Param:
     * @return:
     * @Author: elk_wangchengxin
     * @Date:
    */
    public static void batchInsert(List<ExceldataEO> datasEO) {
    }

    public ExceldataEODao getDao() {
        return dao;
    }

    public static List<ExceldataEO> queryByList(ExceldataEOPage page){
        return dao.queryByList(page);
    }

}
