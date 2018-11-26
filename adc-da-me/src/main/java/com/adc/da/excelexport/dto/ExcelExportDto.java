package com.adc.da.excelexport.dto;

import com.adc.da.excel.annotation.Excel;

public class ExcelExportDto {

    @Excel(name="汽车名称",orderNum = "1")
    private String mname;
    @Excel(name="车款",orderNum = "2")
    private String models;
    @Excel(name="经销商报价",orderNum = "3")
    private String price;


    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "excelDto{" +
                "mname='" + mname + '\'' +
                ", models='" + models + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
