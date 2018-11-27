package com.adc.da.student.service;

import com.adc.da.student.vo.StudentVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.student.dao.StudentEODao1;
import com.adc.da.student.entity.StudentEO;

import java.util.List;


/**
 *
 * <br>
 * <b>功能：</b>TS_STUDENT StudentEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-21 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("studentEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class StudentEOService1 extends BaseService<StudentEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(StudentEOService1.class);

    @Autowired(required = false)
    private StudentEODao1 dao;

    public StudentEODao1 getDao() {
        return dao;
    }

    //通过TS_STUDENT表跟SCORES表查询学生的学号，姓名及成绩
    public List<StudentVO> stuSCore(){
        return dao.stuScore();
    }

    //查询1班成绩大于80的学生
    public List<StudentVO> osStudent(){
        return dao.osStudent();
    }


}
