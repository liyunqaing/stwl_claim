package com.adc.da.elk.dto;

import com.adc.da.elk.entity.ExceldataEO;
import com.adc.da.excel.annotation.Excel;

import java.util.Date;

/**
 * @program: stwl_claim
 * @description: this is Excel文件和Word文件的dto文件
 * @author: elk_wangchengxin
 * @create: 2018-11-28 09:48
 * @version: 2.0.0
 **/
public class ExceldataEODto extends ExceldataEO {
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    // 汽车名称
    @Excel(name = "汽车名称", orderNum = "1")
    private String carname;
    // 车款
    @Excel(name = "车款", orderNum = "2")
    private String caryear;
    // 经销商报价
    @Excel(name = "经销商报价", orderNum = "3")
    private String dealerprice;
    // 厂商指导价
    @Excel(name = "厂商指导价", orderNum = "4")
    private String manufacturerprice;
    // 排量
    @Excel(name = "排量", orderNum = "5")
    private String cc;
    // 油耗
    @Excel(name = "油耗", orderNum = "6")
    private String fuelconsumption;
    // 变速箱
    @Excel(name = "变速箱", orderNum = "7")
    private String gearbox;
    // 车身
    @Excel(name = "车身", orderNum = "8")
    private String carbody;
    // 创建日期
    @Excel(name = "创建日期", orderNum = "9", format="yyyy-MM-dd")
    private Date createdate;

    private String carid;
    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>createdate -> createdate</li>
     * <li>carbody -> carbody</li>
     * <li>gearbox -> gearbox</li>
     * <li>fuelconsumption -> fuelconsumption</li>
     * <li>cc -> cc</li>
     * <li>manufacturerprice -> manufacturerprice</li>
     * <li>dealerprice -> dealerprice</li>
     * <li>caryear -> caryear</li>
     * <li>carname -> carname</li>
     * <li>carid -> carid</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "createdate": return "createdate";
            case "carbody": return "carbody";
            case "gearbox": return "gearbox";
            case "fuelconsumption": return "fuelconsumption";
            case "cc": return "cc";
            case "manufacturerprice": return "manufacturerprice";
            case "dealerprice": return "dealerprice";
            case "caryear": return "caryear";
            case "carname": return "carname";
            case "carid": return "carid";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>createdate -> createdate</li>
     * <li>carbody -> carbody</li>
     * <li>gearbox -> gearbox</li>
     * <li>fuelconsumption -> fuelconsumption</li>
     * <li>cc -> cc</li>
     * <li>manufacturerprice -> manufacturerprice</li>
     * <li>dealerprice -> dealerprice</li>
     * <li>caryear -> caryear</li>
     * <li>carname -> carname</li>
     * <li>carid -> carid</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "createdate": return "createdate";
            case "carbody": return "carbody";
            case "gearbox": return "gearbox";
            case "fuelconsumption": return "fuelconsumption";
            case "cc": return "cc";
            case "manufacturerprice": return "manufacturerprice";
            case "dealerprice": return "dealerprice";
            case "caryear": return "caryear";
            case "carname": return "carname";
            case "carid": return "carid";
            default: return null;
        }
    }

    /**  **/
    public Date getCreatedate() {
        return this.createdate;
    }

    /**  **/
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**  **/
    public String getCarbody() {
        return this.carbody;
    }

    /**  **/
    public void setCarbody(String carbody) {
        this.carbody = carbody;
    }

    /**  **/
    public String getGearbox() {
        return this.gearbox;
    }

    /**  **/
    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    /**  **/
    public String getFuelconsumption() {
        return this.fuelconsumption;
    }

    /**  **/
    public void setFuelconsumption(String fuelconsumption) {
        this.fuelconsumption = fuelconsumption;
    }

    /**  **/
    public String getCc() {
        return this.cc;
    }

    /**  **/
    public void setCc(String cc) {
        this.cc = cc;
    }

    /**  **/
    public String getManufacturerprice() {
        return this.manufacturerprice;
    }

    /**  **/
    public void setManufacturerprice(String manufacturerprice) {
        this.manufacturerprice = manufacturerprice;
    }

    /**  **/
    public String getDealerprice() {
        return this.dealerprice;
    }

    /**  **/
    public void setDealerprice(String dealerprice) {
        this.dealerprice = dealerprice;
    }

    /**  **/
    public String getCaryear() {
        return this.caryear;
    }

    /**  **/
    public void setCaryear(String caryear) {
        this.caryear = caryear;
    }

    /**  **/
    public String getCarname() {
        return this.carname;
    }

    /**  **/
    public void setCarname(String carname) {
        this.carname = carname;
    }

    /**  **/
    public String getCarid() {
        return this.carid;
    }

    /**  **/
    public void setCarid(String carid) {
        this.carid = carid;
    }
}

