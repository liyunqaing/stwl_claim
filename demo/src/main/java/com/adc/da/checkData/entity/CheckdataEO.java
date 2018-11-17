package com.adc.da.checkData.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>checkData CheckdataEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-16 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class CheckdataEO extends BaseEntity {

    private String id;
    private String address;
    private String organizationaddressProducer;
    private String standardsAndRequirements;
    private String specifications;
    private String organizationnameClient;
    private String organizationaddressClient;
    private String organizationnameProducer;
    private String institutionName;
    private String institutionApprovalNO;
    private String validityPeriod;
    private String businessScope;
    private String agencyStatus;
    private String firstDateOfCertification;
    private String productCategory;
    private String nameAndUnitMain;
    private String unifiedcodeClient;
    private String unifiedcodeProducer;
    private String nameAndUnitSecondary;
    private String certificateAnnexDownload;
    private String informationReportDate;
    private String certificateExpirationDate;
    private String certificateDate;
    private String certificateStatus;
    private String certificateNO;
    private String phone;
    private String changeDate;
    private String del;
    private String url;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>address -> address</li>
     * <li>organizationaddressProducer -> organizationAddress_Producer</li>
     * <li>standardsAndRequirements -> standardsAndRequirements</li>
     * <li>specifications -> specifications</li>
     * <li>organizationnameClient -> organizationName_Client</li>
     * <li>organizationaddressClient -> organizationAddress_Client</li>
     * <li>organizationnameProducer -> organizationName_Producer</li>
     * <li>institutionName -> institutionName</li>
     * <li>institutionApprovalNO -> institutionApprovalNO</li>
     * <li>validityPeriod -> validityPeriod</li>
     * <li>businessScope -> businessScope</li>
     * <li>agencyStatus -> agencyStatus</li>
     * <li>firstDateOfCertification -> firstDateOfCertification</li>
     * <li>productCategory -> productCategory</li>
     * <li>nameAndUnitMain -> nameAndUnitMain</li>
     * <li>unifiedcodeClient -> unifiedCode_Client</li>
     * <li>unifiedcodeProducer -> unifiedCode_Producer</li>
     * <li>nameAndUnitSecondary -> nameAndUnitSecondary</li>
     * <li>certificateAnnexDownload -> certificateAnnexDownload</li>
     * <li>informationReportDate -> informationReportDate</li>
     * <li>certificateExpirationDate -> certificateExpirationDate</li>
     * <li>certificateDate -> certificateDate</li>
     * <li>certificateStatus -> certificateStatus</li>
     * <li>certificateNO -> certificateNO</li>
     * <li>phone -> phone</li>
     * <li>changeDate -> changeDate</li>
     * <li>del -> del</li>
     * <li>url -> url</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "address": return "address";
            case "organizationaddressProducer": return "organizationAddress_Producer";
            case "standardsAndRequirements": return "standardsAndRequirements";
            case "specifications": return "specifications";
            case "organizationnameClient": return "organizationName_Client";
            case "organizationaddressClient": return "organizationAddress_Client";
            case "organizationnameProducer": return "organizationName_Producer";
            case "institutionName": return "institutionName";
            case "institutionApprovalNO": return "institutionApprovalNO";
            case "validityPeriod": return "validityPeriod";
            case "businessScope": return "businessScope";
            case "agencyStatus": return "agencyStatus";
            case "firstDateOfCertification": return "firstDateOfCertification";
            case "productCategory": return "productCategory";
            case "nameAndUnitMain": return "nameAndUnitMain";
            case "unifiedcodeClient": return "unifiedCode_Client";
            case "unifiedcodeProducer": return "unifiedCode_Producer";
            case "nameAndUnitSecondary": return "nameAndUnitSecondary";
            case "certificateAnnexDownload": return "certificateAnnexDownload";
            case "informationReportDate": return "informationReportDate";
            case "certificateExpirationDate": return "certificateExpirationDate";
            case "certificateDate": return "certificateDate";
            case "certificateStatus": return "certificateStatus";
            case "certificateNO": return "certificateNO";
            case "phone": return "phone";
            case "changeDate": return "changeDate";
            case "del": return "del";
            case "url": return "url";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>address -> address</li>
     * <li>organizationAddress_Producer -> organizationaddressProducer</li>
     * <li>standardsAndRequirements -> standardsAndRequirements</li>
     * <li>specifications -> specifications</li>
     * <li>organizationName_Client -> organizationnameClient</li>
     * <li>organizationAddress_Client -> organizationaddressClient</li>
     * <li>organizationName_Producer -> organizationnameProducer</li>
     * <li>institutionName -> institutionName</li>
     * <li>institutionApprovalNO -> institutionApprovalNO</li>
     * <li>validityPeriod -> validityPeriod</li>
     * <li>businessScope -> businessScope</li>
     * <li>agencyStatus -> agencyStatus</li>
     * <li>firstDateOfCertification -> firstDateOfCertification</li>
     * <li>productCategory -> productCategory</li>
     * <li>nameAndUnitMain -> nameAndUnitMain</li>
     * <li>unifiedCode_Client -> unifiedcodeClient</li>
     * <li>unifiedCode_Producer -> unifiedcodeProducer</li>
     * <li>nameAndUnitSecondary -> nameAndUnitSecondary</li>
     * <li>certificateAnnexDownload -> certificateAnnexDownload</li>
     * <li>informationReportDate -> informationReportDate</li>
     * <li>certificateExpirationDate -> certificateExpirationDate</li>
     * <li>certificateDate -> certificateDate</li>
     * <li>certificateStatus -> certificateStatus</li>
     * <li>certificateNO -> certificateNO</li>
     * <li>phone -> phone</li>
     * <li>changeDate -> changeDate</li>
     * <li>del -> del</li>
     * <li>url -> url</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "address": return "address";
            case "organizationAddress_Producer": return "organizationaddressProducer";
            case "standardsAndRequirements": return "standardsAndRequirements";
            case "specifications": return "specifications";
            case "organizationName_Client": return "organizationnameClient";
            case "organizationAddress_Client": return "organizationaddressClient";
            case "organizationName_Producer": return "organizationnameProducer";
            case "institutionName": return "institutionName";
            case "institutionApprovalNO": return "institutionApprovalNO";
            case "validityPeriod": return "validityPeriod";
            case "businessScope": return "businessScope";
            case "agencyStatus": return "agencyStatus";
            case "firstDateOfCertification": return "firstDateOfCertification";
            case "productCategory": return "productCategory";
            case "nameAndUnitMain": return "nameAndUnitMain";
            case "unifiedCode_Client": return "unifiedcodeClient";
            case "unifiedCode_Producer": return "unifiedcodeProducer";
            case "nameAndUnitSecondary": return "nameAndUnitSecondary";
            case "certificateAnnexDownload": return "certificateAnnexDownload";
            case "informationReportDate": return "informationReportDate";
            case "certificateExpirationDate": return "certificateExpirationDate";
            case "certificateDate": return "certificateDate";
            case "certificateStatus": return "certificateStatus";
            case "certificateNO": return "certificateNO";
            case "phone": return "phone";
            case "changeDate": return "changeDate";
            case "del": return "del";
            case "url": return "url";
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
    public String getAddress() {
        return this.address;
    }

    /** ${po.columnComment} **/
    public void setAddress(String address) {
        this.address = address;
    }

    /** ${po.columnComment} **/
    public String getOrganizationaddressProducer() {
        return this.organizationaddressProducer;
    }

    /** ${po.columnComment} **/
    public void setOrganizationaddressProducer(String organizationaddressProducer) {
        this.organizationaddressProducer = organizationaddressProducer;
    }

    /** ${po.columnComment} **/
    public String getStandardsAndRequirements() {
        return this.standardsAndRequirements;
    }

    /** ${po.columnComment} **/
    public void setStandardsAndRequirements(String standardsAndRequirements) {
        this.standardsAndRequirements = standardsAndRequirements;
    }

    /** ${po.columnComment} **/
    public String getSpecifications() {
        return this.specifications;
    }

    /** ${po.columnComment} **/
    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    /** ${po.columnComment} **/
    public String getOrganizationnameClient() {
        return this.organizationnameClient;
    }

    /** ${po.columnComment} **/
    public void setOrganizationnameClient(String organizationnameClient) {
        this.organizationnameClient = organizationnameClient;
    }

    /** ${po.columnComment} **/
    public String getOrganizationaddressClient() {
        return this.organizationaddressClient;
    }

    /** ${po.columnComment} **/
    public void setOrganizationaddressClient(String organizationaddressClient) {
        this.organizationaddressClient = organizationaddressClient;
    }

    /** ${po.columnComment} **/
    public String getOrganizationnameProducer() {
        return this.organizationnameProducer;
    }

    /** ${po.columnComment} **/
    public void setOrganizationnameProducer(String organizationnameProducer) {
        this.organizationnameProducer = organizationnameProducer;
    }

    /** ${po.columnComment} **/
    public String getInstitutionName() {
        return this.institutionName;
    }

    /** ${po.columnComment} **/
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    /** ${po.columnComment} **/
    public String getInstitutionApprovalNO() {
        return this.institutionApprovalNO;
    }

    /** ${po.columnComment} **/
    public void setInstitutionApprovalNO(String institutionApprovalNO) {
        this.institutionApprovalNO = institutionApprovalNO;
    }

    /** ${po.columnComment} **/
    public String getValidityPeriod() {
        return this.validityPeriod;
    }

    /** ${po.columnComment} **/
    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    /** ${po.columnComment} **/
    public String getBusinessScope() {
        return this.businessScope;
    }

    /** ${po.columnComment} **/
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    /** ${po.columnComment} **/
    public String getAgencyStatus() {
        return this.agencyStatus;
    }

    /** ${po.columnComment} **/
    public void setAgencyStatus(String agencyStatus) {
        this.agencyStatus = agencyStatus;
    }

    /** ${po.columnComment} **/
    public String getFirstDateOfCertification() {
        return this.firstDateOfCertification;
    }

    /** ${po.columnComment} **/
    public void setFirstDateOfCertification(String firstDateOfCertification) {
        this.firstDateOfCertification = firstDateOfCertification;
    }

    /** ${po.columnComment} **/
    public String getProductCategory() {
        return this.productCategory;
    }

    /** ${po.columnComment} **/
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    /** ${po.columnComment} **/
    public String getNameAndUnitMain() {
        return this.nameAndUnitMain;
    }

    /** ${po.columnComment} **/
    public void setNameAndUnitMain(String nameAndUnitMain) {
        this.nameAndUnitMain = nameAndUnitMain;
    }

    /** ${po.columnComment} **/
    public String getUnifiedcodeClient() {
        return this.unifiedcodeClient;
    }

    /** ${po.columnComment} **/
    public void setUnifiedcodeClient(String unifiedcodeClient) {
        this.unifiedcodeClient = unifiedcodeClient;
    }

    /** ${po.columnComment} **/
    public String getUnifiedcodeProducer() {
        return this.unifiedcodeProducer;
    }

    /** ${po.columnComment} **/
    public void setUnifiedcodeProducer(String unifiedcodeProducer) {
        this.unifiedcodeProducer = unifiedcodeProducer;
    }

    /** ${po.columnComment} **/
    public String getNameAndUnitSecondary() {
        return this.nameAndUnitSecondary;
    }

    /** ${po.columnComment} **/
    public void setNameAndUnitSecondary(String nameAndUnitSecondary) {
        this.nameAndUnitSecondary = nameAndUnitSecondary;
    }

    /** ${po.columnComment} **/
    public String getCertificateAnnexDownload() {
        return this.certificateAnnexDownload;
    }

    /** ${po.columnComment} **/
    public void setCertificateAnnexDownload(String certificateAnnexDownload) {
        this.certificateAnnexDownload = certificateAnnexDownload;
    }

    /** ${po.columnComment} **/
    public String getInformationReportDate() {
        return this.informationReportDate;
    }

    /** ${po.columnComment} **/
    public void setInformationReportDate(String informationReportDate) {
        this.informationReportDate = informationReportDate;
    }

    /** ${po.columnComment} **/
    public String getCertificateExpirationDate() {
        return this.certificateExpirationDate;
    }

    /** ${po.columnComment} **/
    public void setCertificateExpirationDate(String certificateExpirationDate) {
        this.certificateExpirationDate = certificateExpirationDate;
    }

    /** ${po.columnComment} **/
    public String getCertificateDate() {
        return this.certificateDate;
    }

    /** ${po.columnComment} **/
    public void setCertificateDate(String certificateDate) {
        this.certificateDate = certificateDate;
    }

    /** ${po.columnComment} **/
    public String getCertificateStatus() {
        return this.certificateStatus;
    }

    /** ${po.columnComment} **/
    public void setCertificateStatus(String certificateStatus) {
        this.certificateStatus = certificateStatus;
    }

    /** ${po.columnComment} **/
    public String getCertificateNO() {
        return this.certificateNO;
    }

    /** ${po.columnComment} **/
    public void setCertificateNO(String certificateNO) {
        this.certificateNO = certificateNO;
    }

    /** ${po.columnComment} **/
    public String getPhone() {
        return this.phone;
    }

    /** ${po.columnComment} **/
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /** ${po.columnComment} **/
    public String getChangeDate() {
        return this.changeDate;
    }

    /** ${po.columnComment} **/
    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

    /** ${po.columnComment} **/
    public String getDel() {
        return this.del;
    }

    /** ${po.columnComment} **/
    public void setDel(String del) {
        this.del = del;
    }

    /** ${po.columnComment} **/
    public String getUrl() {
        return this.url;
    }

    /** ${po.columnComment} **/
    public void setUrl(String url) {
        this.url = url;
    }

}
