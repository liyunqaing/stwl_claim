package com.adc.da.stusqlserver.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.stusqlserver.entity.SelectOneEO;
import com.adc.da.stusqlserver.entity.StudentEO;

import java.util.List;
import com.adc.da.stusqlserver.entity.studentEto;
import org.apache.ibatis.annotations.Param;

/**
 *
 * <br>
 * <b>功能：</b>student StudentEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-27 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface StudentEODao extends BaseDao<StudentEO> {
      List<studentEto> allinsert();

      /**
       * 查询数据的左边2个字符
       * @param id
       * @return
       */
      Object selectOne(int id);
      /**
       *查询有多少条数据
       * @param
       * @return
       */
      Object selectAll();
      /**
       *截取数据
       * @param id
       * @return
       */
      Object subString(int id);

      /**
       * 查询是否含有指定字符串
       * @param str
       * @return
       */
      Object charIndex(@Param("str") String str,@Param("id") int id);


}
