package com.adc.da.excelexport.dao;

import com.adc.da.excelexport.entity.ExcelExportEO;
import com.adc.da.base.dao.BaseDao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ExcelExportDao extends BaseDao<ExcelExportEO> {

    List<ExcelExportEO> exportExcel();


}
