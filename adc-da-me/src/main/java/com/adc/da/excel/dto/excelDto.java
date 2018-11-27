package com.adc.da.excel.dto;

import com.adc.da.excel.annotation.Excel;


/**
 *
 */
public class excelDto {
//mname varchar2(20),
//models number(5),
//price varchar2(20),
//mdate varchar2(20)
    /**
     *
     */
    @Excel(name = "汽车名称", orderNum = "1")
    private String mname;
    /**
     *
     */
    @Excel(name = "车款", orderNum = "2")
    private String models;
    /**
     *
     */
    @Excel(name = "经销商报价", orderNum = "3")
    private String price;
//    @Excel(name="创建时间",orderNum = "4" )
//    private String  mdate;

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
        return "excelDto{"
                +
                "mname='" + mname + '\''
                +
                ", models='" + models + '\''
                +
                ", price='" + price + '\''
                +
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
//        return "excelDto{" +
//                "mname='" + mname + '\'' +
//                ", models='" + models + '\'' +
//                ", price='" + price + '\'' +
//                ", mdate=" + mdate +
//                '}';
//    }

}
