package com.adc.da.student.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.student.entity.StudentEO;
import com.adc.da.student.vo.StudentVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>TS_STUDENT StudentEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-21 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Mapper
public interface StudentEODao1 extends BaseDao<StudentEO> {

    //通过TS_STUDENT表跟SCORES表查询学生的学号，姓名及成绩
    List<StudentVO> stuScore();

    //查询1班成绩大于80的学生
    List<StudentVO> osStudent();
}
