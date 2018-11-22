package com.adc.da.excelexport.entity;

import com.adc.da.base.entity.BaseEntity;

public class ExcelExportEO extends BaseEntity {

    private String mname;

    private String models;

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
        return "ExcelExportEO{" +
                "mname='" + mname + '\'' +
                ", models='" + models + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
