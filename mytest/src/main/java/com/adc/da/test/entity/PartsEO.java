package com.adc.da.test.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>parts PartsEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-12 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class PartsEO extends BaseEntity {

    private String id;
    private String parts;
    private String partsName;
    private String announcement;
    private String c3;
    private String ep;
    private String c3Certificate;
    private String printWay;
    private String partsCname;
    private String partsNum;
    private String partsEname;
    private String vpps;
    private String upc;
    private String fna;
    private String engineerEng;
    private String directorEng;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>parts -> parts</li>
     * <li>partsName -> partsName</li>
     * <li>announcement -> announcement</li>
     * <li>c3 -> c3</li>
     * <li>ep -> ep</li>
     * <li>c3Certificate -> c3_certificate</li>
     * <li>printWay -> print_way</li>
     * <li>partsCname -> parts_cname</li>
     * <li>partsNum -> parts_num</li>
     * <li>partsEname -> parts_ename</li>
     * <li>vpps -> vpps</li>
     * <li>upc -> upc</li>
     * <li>fna -> fna</li>
     * <li>engineerEng -> engineer_eng</li>
     * <li>directorEng -> director_eng</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "parts": return "parts";
            case "partsName": return "partsName";
            case "announcement": return "announcement";
            case "c3": return "c3";
            case "ep": return "ep";
            case "c3Certificate": return "c3_certificate";
            case "printWay": return "print_way";
            case "partsCname": return "parts_cname";
            case "partsNum": return "parts_num";
            case "partsEname": return "parts_ename";
            case "vpps": return "vpps";
            case "upc": return "upc";
            case "fna": return "fna";
            case "engineerEng": return "engineer_eng";
            case "directorEng": return "director_eng";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>parts -> parts</li>
     * <li>partsName -> partsName</li>
     * <li>announcement -> announcement</li>
     * <li>c3 -> c3</li>
     * <li>ep -> ep</li>
     * <li>c3_certificate -> c3Certificate</li>
     * <li>print_way -> printWay</li>
     * <li>parts_cname -> partsCname</li>
     * <li>parts_num -> partsNum</li>
     * <li>parts_ename -> partsEname</li>
     * <li>vpps -> vpps</li>
     * <li>upc -> upc</li>
     * <li>fna -> fna</li>
     * <li>engineer_eng -> engineerEng</li>
     * <li>director_eng -> directorEng</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "parts": return "parts";
            case "partsName": return "partsName";
            case "announcement": return "announcement";
            case "c3": return "c3";
            case "ep": return "ep";
            case "c3_certificate": return "c3Certificate";
            case "print_way": return "printWay";
            case "parts_cname": return "partsCname";
            case "parts_num": return "partsNum";
            case "parts_ename": return "partsEname";
            case "vpps": return "vpps";
            case "upc": return "upc";
            case "fna": return "fna";
            case "engineer_eng": return "engineerEng";
            case "director_eng": return "directorEng";
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
    public String getParts() {
        return this.parts;
    }

    /** ${po.columnComment} **/
    public void setParts(String parts) {
        this.parts = parts;
    }

    /** ${po.columnComment} **/
    public String getPartsName() {
        return this.partsName;
    }

    /** ${po.columnComment} **/
    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    /** ${po.columnComment} **/
    public String getAnnouncement() {
        return this.announcement;
    }

    /** ${po.columnComment} **/
    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    /** ${po.columnComment} **/
    public String getC3() {
        return this.c3;
    }

    /** ${po.columnComment} **/
    public void setC3(String c3) {
        this.c3 = c3;
    }

    /** ${po.columnComment} **/
    public String getEp() {
        return this.ep;
    }

    /** ${po.columnComment} **/
    public void setEp(String ep) {
        this.ep = ep;
    }

    /** ${po.columnComment} **/
    public String getC3Certificate() {
        return this.c3Certificate;
    }

    /** ${po.columnComment} **/
    public void setC3Certificate(String c3Certificate) {
        this.c3Certificate = c3Certificate;
    }

    /** ${po.columnComment} **/
    public String getPrintWay() {
        return this.printWay;
    }

    /** ${po.columnComment} **/
    public void setPrintWay(String printWay) {
        this.printWay = printWay;
    }

    /** ${po.columnComment} **/
    public String getPartsCname() {
        return this.partsCname;
    }

    /** ${po.columnComment} **/
    public void setPartsCname(String partsCname) {
        this.partsCname = partsCname;
    }

    /** ${po.columnComment} **/
    public String getPartsNum() {
        return this.partsNum;
    }

    /** ${po.columnComment} **/
    public void setPartsNum(String partsNum) {
        this.partsNum = partsNum;
    }

    /** ${po.columnComment} **/
    public String getPartsEname() {
        return this.partsEname;
    }

    /** ${po.columnComment} **/
    public void setPartsEname(String partsEname) {
        this.partsEname = partsEname;
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
    public String getEngineerEng() {
        return this.engineerEng;
    }

    /** ${po.columnComment} **/
    public void setEngineerEng(String engineerEng) {
        this.engineerEng = engineerEng;
    }

    /** ${po.columnComment} **/
    public String getDirectorEng() {
        return this.directorEng;
    }

    /** ${po.columnComment} **/
    public void setDirectorEng(String directorEng) {
        this.directorEng = directorEng;
    }

}
