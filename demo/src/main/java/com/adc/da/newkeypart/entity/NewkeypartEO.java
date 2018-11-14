package com.adc.da.newkeypart.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>newkeypart NewkeypartEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-13 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class NewkeypartEO extends BaseEntity {

    private String id;
    private String partName;
    private String isNoticed;
    private String isccc;
    private String isEnvironmentalProtection;
    private String iscccCertificate;
    private String specification;
    private String trademark;
    private String productionEnterprise;
    private String cccCertificateNumber;
    private String applicableCarType;
    private String responsibilityDepartment;
    private String isSigned;
    private String isAddModel;
    private String cccApplyingWay;
    private String positionDescription;
    private String recordapplyingway;
    private String zhPartName;
    private String partNumber;
    private String euPartName;
    private String vpps;
    private String upc;
    private String fna;
    private String engineerSign;
    private String directorSign;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>partName -> partName</li>
     * <li>isNoticed -> isNoticed</li>
     * <li>isccc -> isccc</li>
     * <li>isEnvironmentalProtection -> isEnvironmentalProtection</li>
     * <li>iscccCertificate -> iscccCertificate</li>
     * <li>specification -> specification</li>
     * <li>trademark -> trademark</li>
     * <li>productionEnterprise -> productionEnterprise</li>
     * <li>cccCertificateNumber -> cccCertificateNumber</li>
     * <li>applicableCarType -> applicableCarType</li>
     * <li>responsibilityDepartment -> responsibilityDepartment</li>
     * <li>isSigned -> isSigned</li>
     * <li>isAddModel -> isAddModel</li>
     * <li>cccApplyingWay -> cccApplyingWay</li>
     * <li>positionDescription -> positionDescription</li>
     * <li>recordapplyingway -> recordapplyingway</li>
     * <li>zhPartName -> zhPartName</li>
     * <li>partNumber -> partNumber</li>
     * <li>euPartName -> euPartName</li>
     * <li>vpps -> vpps</li>
     * <li>upc -> upc</li>
     * <li>fna -> fna</li>
     * <li>engineerSign -> engineerSign</li>
     * <li>directorSign -> directorSign</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "partName": return "partName";
            case "isNoticed": return "isNoticed";
            case "isccc": return "isccc";
            case "isEnvironmentalProtection": return "isEnvironmentalProtection";
            case "iscccCertificate": return "iscccCertificate";
            case "specification": return "specification";
            case "trademark": return "trademark";
            case "productionEnterprise": return "productionEnterprise";
            case "cccCertificateNumber": return "cccCertificateNumber";
            case "applicableCarType": return "applicableCarType";
            case "responsibilityDepartment": return "responsibilityDepartment";
            case "isSigned": return "isSigned";
            case "isAddModel": return "isAddModel";
            case "cccApplyingWay": return "cccApplyingWay";
            case "positionDescription": return "positionDescription";
            case "recordapplyingway": return "recordapplyingway";
            case "zhPartName": return "zhPartName";
            case "partNumber": return "partNumber";
            case "euPartName": return "euPartName";
            case "vpps": return "vpps";
            case "upc": return "upc";
            case "fna": return "fna";
            case "engineerSign": return "engineerSign";
            case "directorSign": return "directorSign";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>partName -> partName</li>
     * <li>isNoticed -> isNoticed</li>
     * <li>isccc -> isccc</li>
     * <li>isEnvironmentalProtection -> isEnvironmentalProtection</li>
     * <li>iscccCertificate -> iscccCertificate</li>
     * <li>specification -> specification</li>
     * <li>trademark -> trademark</li>
     * <li>productionEnterprise -> productionEnterprise</li>
     * <li>cccCertificateNumber -> cccCertificateNumber</li>
     * <li>applicableCarType -> applicableCarType</li>
     * <li>responsibilityDepartment -> responsibilityDepartment</li>
     * <li>isSigned -> isSigned</li>
     * <li>isAddModel -> isAddModel</li>
     * <li>cccApplyingWay -> cccApplyingWay</li>
     * <li>positionDescription -> positionDescription</li>
     * <li>recordapplyingway -> recordapplyingway</li>
     * <li>zhPartName -> zhPartName</li>
     * <li>partNumber -> partNumber</li>
     * <li>euPartName -> euPartName</li>
     * <li>vpps -> vpps</li>
     * <li>upc -> upc</li>
     * <li>fna -> fna</li>
     * <li>engineerSign -> engineerSign</li>
     * <li>directorSign -> directorSign</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "partName": return "partName";
            case "isNoticed": return "isNoticed";
            case "isccc": return "isccc";
            case "isEnvironmentalProtection": return "isEnvironmentalProtection";
            case "iscccCertificate": return "iscccCertificate";
            case "specification": return "specification";
            case "trademark": return "trademark";
            case "productionEnterprise": return "productionEnterprise";
            case "cccCertificateNumber": return "cccCertificateNumber";
            case "applicableCarType": return "applicableCarType";
            case "responsibilityDepartment": return "responsibilityDepartment";
            case "isSigned": return "isSigned";
            case "isAddModel": return "isAddModel";
            case "cccApplyingWay": return "cccApplyingWay";
            case "positionDescription": return "positionDescription";
            case "recordapplyingway": return "recordapplyingway";
            case "zhPartName": return "zhPartName";
            case "partNumber": return "partNumber";
            case "euPartName": return "euPartName";
            case "vpps": return "vpps";
            case "upc": return "upc";
            case "fna": return "fna";
            case "engineerSign": return "engineerSign";
            case "directorSign": return "directorSign";
            default: return null;
        }
    }
    
    /** ${po.columnComment} **/
    public String getId() {
        return this.id;
    }

    /** ${po.columnComment} **/
    public void setId(String id) {
        this.id = id;
    }

    /** ${po.columnComment} **/
    public String getPartName() {
        return this.partName;
    }

    /** ${po.columnComment} **/
    public void setPartName(String partName) {
        this.partName = partName;
    }

    /** ${po.columnComment} **/
    public String getIsNoticed() {
        return this.isNoticed;
    }

    /** ${po.columnComment} **/
    public void setIsNoticed(String isNoticed) {
        this.isNoticed = isNoticed;
    }

    /** ${po.columnComment} **/
    public String getIsccc() {
        return this.isccc;
    }

    /** ${po.columnComment} **/
    public void setIsccc(String isccc) {
        this.isccc = isccc;
    }

    /** ${po.columnComment} **/
    public String getIsEnvironmentalProtection() {
        return this.isEnvironmentalProtection;
    }

    /** ${po.columnComment} **/
    public void setIsEnvironmentalProtection(String isEnvironmentalProtection) {
        this.isEnvironmentalProtection = isEnvironmentalProtection;
    }

    /** ${po.columnComment} **/
    public String getIscccCertificate() {
        return this.iscccCertificate;
    }

    /** ${po.columnComment} **/
    public void setIscccCertificate(String iscccCertificate) {
        this.iscccCertificate = iscccCertificate;
    }

    /** ${po.columnComment} **/
    public String getSpecification() {
        return this.specification;
    }

    /** ${po.columnComment} **/
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /** ${po.columnComment} **/
    public String getTrademark() {
        return this.trademark;
    }

    /** ${po.columnComment} **/
    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    /** ${po.columnComment} **/
    public String getProductionEnterprise() {
        return this.productionEnterprise;
    }

    /** ${po.columnComment} **/
    public void setProductionEnterprise(String productionEnterprise) {
        this.productionEnterprise = productionEnterprise;
    }

    /** ${po.columnComment} **/
    public String getCccCertificateNumber() {
        return this.cccCertificateNumber;
    }

    /** ${po.columnComment} **/
    public void setCccCertificateNumber(String cccCertificateNumber) {
        this.cccCertificateNumber = cccCertificateNumber;
    }

    /** ${po.columnComment} **/
    public String getApplicableCarType() {
        return this.applicableCarType;
    }

    /** ${po.columnComment} **/
    public void setApplicableCarType(String applicableCarType) {
        this.applicableCarType = applicableCarType;
    }

    /** ${po.columnComment} **/
    public String getResponsibilityDepartment() {
        return this.responsibilityDepartment;
    }

    /** ${po.columnComment} **/
    public void setResponsibilityDepartment(String responsibilityDepartment) {
        this.responsibilityDepartment = responsibilityDepartment;
    }

    /** ${po.columnComment} **/
    public String getIsSigned() {
        return this.isSigned;
    }

    /** ${po.columnComment} **/
    public void setIsSigned(String isSigned) {
        this.isSigned = isSigned;
    }

    /** ${po.columnComment} **/
    public String getIsAddModel() {
        return this.isAddModel;
    }

    /** ${po.columnComment} **/
    public void setIsAddModel(String isAddModel) {
        this.isAddModel = isAddModel;
    }

    /** ${po.columnComment} **/
    public String getCccApplyingWay() {
        return this.cccApplyingWay;
    }

    /** ${po.columnComment} **/
    public void setCccApplyingWay(String cccApplyingWay) {
        this.cccApplyingWay = cccApplyingWay;
    }

    /** ${po.columnComment} **/
    public String getPositionDescription() {
        return this.positionDescription;
    }

    /** ${po.columnComment} **/
    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    /** ${po.columnComment} **/
    public String getRecordapplyingway() {
        return this.recordapplyingway;
    }

    /** ${po.columnComment} **/
    public void setRecordapplyingway(String recordapplyingway) {
        this.recordapplyingway = recordapplyingway;
    }

    /** ${po.columnComment} **/
    public String getZhPartName() {
        return this.zhPartName;
    }

    /** ${po.columnComment} **/
    public void setZhPartName(String zhPartName) {
        this.zhPartName = zhPartName;
    }

    /** ${po.columnComment} **/
    public String getPartNumber() {
        return this.partNumber;
    }

    /** ${po.columnComment} **/
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    /** ${po.columnComment} **/
    public String getEuPartName() {
        return this.euPartName;
    }

    /** ${po.columnComment} **/
    public void setEuPartName(String euPartName) {
        this.euPartName = euPartName;
    }

    /** ${po.columnComment} **/
    public String getVpps() {
        return this.vpps;
    }

    /** ${po.columnComment} **/
    public void setVpps(String vpps) {
        this.vpps = vpps;
    }

    /** ${po.columnComment} **/
    public String getUpc() {
        return this.upc;
    }

    /** ${po.columnComment} **/
    public void setUpc(String upc) {
        this.upc = upc;
    }

    /** ${po.columnComment} **/
    public String getFna() {
        return this.fna;
    }

    /** ${po.columnComment} **/
    public void setFna(String fna) {
        this.fna = fna;
    }

    /** ${po.columnComment} **/
    public String getEngineerSign() {
        return this.engineerSign;
    }

    /** ${po.columnComment} **/
    public void setEngineerSign(String engineerSign) {
        this.engineerSign = engineerSign;
    }

    /** ${po.columnComment} **/
    public String getDirectorSign() {
        return this.directorSign;
    }

    /** ${po.columnComment} **/
    public void setDirectorSign(String directorSign) {
        this.directorSign = directorSign;
    }

}
