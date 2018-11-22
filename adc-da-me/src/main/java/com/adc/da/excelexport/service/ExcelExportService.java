package com.adc.da.excelexport.service;

import com.adc.da.excel.poi.excel.ExcelExportUtil;
import com.adc.da.excel.poi.excel.entity.ExportParams;
import com.adc.da.excelexport.dto.ExcelExportDto;
import com.adc.da.excelexport.entity.ExcelExportEO;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adc.da.excelexport.dao.ExcelExportDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("ExcelExportService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public class ExcelExportService {
    @Autowired(required = false)
    private ExcelExportDao dao;
        public Workbook ExcelExport(ExportParams params) throws Exception {
            List<ExcelExportEO> eos = dao.exportExcel();
            List<ExcelExportDto> dtos = new ArrayList<>();
            copyPropertiesToDto(eos,dtos);
            return ExcelExportUtil.exportExcel(params,ExcelExportDto.class,dtos);
    }

    public void copyPropertiesToDto(List<ExcelExportEO> eos,List<ExcelExportDto> dtos){
        if(eos!=null && !eos.isEmpty()){
            for(ExcelExportEO eo : eos){
                ExcelExportDto dto = new ExcelExportDto();
                BeanUtils.copyProperties(eo, dto);
                dtos.add(dto);
            }
        }
    }


}
