package com.adc.da.elk.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>EXCELDATA ExceldataEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-28 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class ExceldataEO extends BaseEntity {

    private String carId;
    private String carName;
    private String carYear;
    private String dealerPrice;
    private String manufacturerPrice;
    private String cc;
    private String fuelConsumption;
    private String gearbox;
    private String carBody;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>carId -> carId</li>
     * <li>carName -> carName</li>
     * <li>carYear -> carYear</li>
     * <li>dealerPrice -> dealerPrice</li>
     * <li>manufacturerPrice -> manufacturerPrice</li>
     * <li>cc -> cc</li>
     * <li>fuelConsumption -> fuelConsumption</li>
     * <li>gearbox -> gearbox</li>
     * <li>carBody -> carBody</li>
     * <li>createDate -> createDate</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "carId": return "carId";
            case "carName": return "carName";
            case "carYear": return "carYear";
            case "dealerPrice": return "dealerPrice";
            case "manufacturerPrice": return "manufacturerPrice";
            case "cc": return "cc";
            case "fuelConsumption": return "fuelConsumption";
            case "gearbox": return "gearbox";
            case "carBody": return "carBody";
            case "createDate": return "createDate";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>carId -> carId</li>
     * <li>carName -> carName</li>
     * <li>carYear -> carYear</li>
     * <li>dealerPrice -> dealerPrice</li>
     * <li>manufacturerPrice -> manufacturerPrice</li>
     * <li>cc -> cc</li>
     * <li>fuelConsumption -> fuelConsumption</li>
     * <li>gearbox -> gearbox</li>
     * <li>carBody -> carBody</li>
     * <li>createDate -> createDate</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "carId": return "carId";
            case "carName": return "carName";
            case "carYear": return "carYear";
            case "dealerPrice": return "dealerPrice";
            case "manufacturerPrice": return "manufacturerPrice";
            case "cc": return "cc";
            case "fuelConsumption": return "fuelConsumption";
            case "gearbox": return "gearbox";
            case "carBody": return "carBody";
            case "createDate": return "createDate";
            default: return null;
        }
    }
    
    /** ${po.columnComment} **/
    public String getCarId() {
        return this.carId;
    }

    /** ${po.columnComment} **/
    public void setCarId(String carId) {
        this.carId = carId;
    }

    /** ${po.columnComment} **/
    public String getCarName() {
        return this.carName;
    }

    /** ${po.columnComment} **/
    public void setCarName(String carName) {
        this.carName = carName;
    }

    /** ${po.columnComment} **/
    public String getCarYear() {
        return this.carYear;
    }

    /** ${po.columnComment} **/
    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    /** ${po.columnComment} **/
    public String getDealerPrice() {
        return this.dealerPrice;
    }

    /** ${po.columnComment} **/
    public void setDealerPrice(String dealerPrice) {
        this.dealerPrice = dealerPrice;
    }

    /** ${po.columnComment} **/
    public String getManufacturerPrice() {
        return this.manufacturerPrice;
    }

    /** ${po.columnComment} **/
    public void setManufacturerPrice(String manufacturerPrice) {
        this.manufacturerPrice = manufacturerPrice;
    }

    /** ${po.columnComment} **/
    public String getCc() {
        return this.cc;
    }

    /** ${po.columnComment} **/
    public void setCc(String cc) {
        this.cc = cc;
    }

    /** ${po.columnComment} **/
    public String getFuelConsumption() {
        return this.fuelConsumption;
    }

    /** ${po.columnComment} **/
    public void setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    /** ${po.columnComment} **/
    public String getGearbox() {
        return this.gearbox;
    }

    /** ${po.columnComment} **/
    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    /** ${po.columnComment} **/
    public String getCarBody() {
        return this.carBody;
    }

    /** ${po.columnComment} **/
    public void setCarBody(String carBody) {
        this.carBody = carBody;
    }

    /** ${po.columnComment} **/
    public Date getCreateDate() {
        return this.createDate;
    }

    /** ${po.columnComment} **/
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
