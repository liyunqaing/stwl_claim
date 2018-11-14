package com.adc.da.newkeypart.dto;

import com.adc.da.excel.annotation.Excel;

/**
 * <b>功能：</b>keypart KeypartEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-13 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class NewKeypartDto {

    private String id;

    @Excel(name = "零部件名称", orderNum = "1")
    private String partName;

    @Excel(name = "公告", orderNum = "2")
    private String isNoticed;

    @Excel(name = "3C", orderNum = "3")
    private String isccc;

    @Excel(name = "环保", orderNum = "4")
    private String isEnvironmentalProtection;

    @Excel(name = "3C证书", orderNum = "5")
    private String iscccCertificate;

    @Excel(name = "型号规格", orderNum = "6")
    private String specification;

    @Excel(name = "商标", orderNum = "7")
    private String trademark;

    @Excel(name = "生产企业", orderNum = "8")
    private String productionEnterprise;

    @Excel(name = "CCC证书号", orderNum = "9")
    private String cccCertificateNumber;

    @Excel(name = "适用车型", orderNum = "10")
    private String applicableCarType;

    @Excel(name = "责任科室", orderNum = "11")
    private String responsibilityDepartment;

    @Excel(name = "关键件型号一致性确认表是否签署", orderNum = "12")
    private String isSigned;

    @Excel(name = "图纸上是否已填加型号(Y/N)", orderNum = "13")
    private String isAddModel;

    @Excel(name = "3C标识在零件上的施加方式（仅有3C证书的需要填）", orderNum = "14")
    private String cccApplyingWay;

    @Excel(name = "型号、生产企业及3C标识在零件上的位置描述", orderNum = "15")
    private String positionDescription;

    @Excel(name = "型号在零件上的施加方式", orderNum = "16")
    private String recordapplyingway;

    @Excel(name = "中文零件名称", orderNum = "17")
    private String zhPartName;

    @Excel(name = "零件号", orderNum = "18")
    private String partNumber;

    @Excel(name = "英文零件名称", orderNum = "19")
    private String euPartName;

    @Excel(name = "VPPS（结构分类代码）", orderNum = "20")
    private String vpps;

    @Excel(name = "UPC（统一零部件代码）", orderNum = "21")
    private String upc;

    @Excel(name = "FNA（功能名称地址代码）", orderNum = "22")
    private String fna;

    @Excel(name = "工程师签字", orderNum = "23")
    private String engineerSign;

    @Excel(name = "主管签字", orderNum = "24")
    private String directorSign;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getIsNoticed() {
        return isNoticed;
    }

    public void setIsNoticed(String isNoticed) {
        this.isNoticed = isNoticed;
    }

    public String getIsccc() {
        return isccc;
    }

    public void setIsccc(String isccc) {
        this.isccc = isccc;
    }

    public String getIsEnvironmentalProtection() {
        return isEnvironmentalProtection;
    }

    public void setIsEnvironmentalProtection(String isEnvironmentalProtection) {
        this.isEnvironmentalProtection = isEnvironmentalProtection;
    }

    public String getIscccCertificate() {
        return iscccCertificate;
    }

    public void setIscccCertificate(String iscccCertificate) {
        this.iscccCertificate = iscccCertificate;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getProductionEnterprise() {
        return productionEnterprise;
    }

    public void setProductionEnterprise(String productionEnterprise) {
        this.productionEnterprise = productionEnterprise;
    }

    public String getCccCertificateNumber() {
        return cccCertificateNumber;
    }

    public void setCccCertificateNumber(String cccCertificateNumber) {
        this.cccCertificateNumber = cccCertificateNumber;
    }

    public String getApplicableCarType() {
        return applicableCarType;
    }

    public void setApplicableCarType(String applicableCarType) {
        this.applicableCarType = applicableCarType;
    }

    public String getResponsibilityDepartment() {
        return responsibilityDepartment;
    }

    public void setResponsibilityDepartment(String responsibilityDepartment) {
        this.responsibilityDepartment = responsibilityDepartment;
    }

    public String getIsSigned() {
        return isSigned;
    }

    public void setIsSigned(String isSigned) {
        this.isSigned = isSigned;
    }

    public String getIsAddModel() {
        return isAddModel;
    }

    public void setIsAddModel(String isAddModel) {
        this.isAddModel = isAddModel;
    }

    public String getCccApplyingWay() {
        return cccApplyingWay;
    }

    public void setCccApplyingWay(String cccApplyingWay) {
        this.cccApplyingWay = cccApplyingWay;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public String getRecordapplyingway() {
        return recordapplyingway;
    }

    public void setRecordapplyingway(String recordapplyingway) {
        this.recordapplyingway = recordapplyingway;
    }

    public String getZhPartName() {
        return zhPartName;
    }

    public void setZhPartName(String zhPartName) {
        this.zhPartName = zhPartName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getEuPartName() {
        return euPartName;
    }

    public void setEuPartName(String euPartName) {
        this.euPartName = euPartName;
    }

    public String getVpps() {
        return vpps;
    }

    public void setVpps(String vpps) {
        this.vpps = vpps;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getFna() {
        return fna;
    }

    public void setFna(String fna) {
        this.fna = fna;
    }

    public String getEngineerSign() {
        return engineerSign;
    }

    public void setEngineerSign(String engineerSign) {
        this.engineerSign = engineerSign;
    }

    public String getDirectorSign() {
        return directorSign;
    }

    public void setDirectorSign(String directorSign) {
        this.directorSign = directorSign;
    }
}
