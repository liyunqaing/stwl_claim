package com.adc.da.excel.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.excel.entity.excelEO;
public interface ExcelDao extends BaseDao<excelEO> {

    void batchInsert(excelEO eo);

}
