package com.adc.da.excel.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

public class excelEO extends BaseEntity {

    private String id;

    private String mname;

    private String models;

    private String price;

//    private String mdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return "excelEO{" +
                "id='" + id + '\'' +
                ", mname='" + mname + '\'' +
                ", models='" + models + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
//    public String getMdate() {
//        return mdate;
//    }
//
//    public void setMdate(String mdate) {
//        this.mdate = mdate;
//    }

//    @Override
//    public String toString() {
//        return "excelEO{" +
//                "id='" + id + '\'' +
//                ", mname='" + mname + '\'' +
//                ", models='" + models + '\'' +
//                ", price='" + price + '\'' +
//                ", mdate=" + mdate +
//                '}';
//    }
}
