package com.adc.da.stusqlserver.service;

import com.adc.da.stusqlserver.entity.studentEto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.stusqlserver.dao.StudentEODao;
import com.adc.da.stusqlserver.entity.StudentEO;

import java.util.List;


/**
 *
 * <br>
 * <b>功能：</b>student StudentEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-27 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("studentsqlserverService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class StudentEOService extends BaseService<StudentEO, Void> {

    private static final Logger logger = LoggerFactory.getLogger(StudentEOService.class);

    @Autowired(required = false)
    private StudentEODao dao;

    public StudentEODao getDao() {
        return dao;
    }
     public  List<studentEto> allinsert(){
        return dao.allinsert();
    }

}
