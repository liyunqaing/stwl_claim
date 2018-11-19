package com.adc.da.student.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.student.dao.StudentEODao;
import com.adc.da.student.entity.StudentEO;


/**
 *
 * <br>
 * <b>功能：</b>TS_STUDENT StudentEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-16 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("studentEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class StudentEOService extends BaseService<StudentEO, Void> {

    private static final Logger logger = LoggerFactory.getLogger(StudentEOService.class);

    @Autowired
    private StudentEODao dao;

    public StudentEODao getDao() {
        return dao;
    }

}
