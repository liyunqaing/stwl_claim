package com.adc.da.elk.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>UUSERS UusersEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-28 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class UusersEO extends BaseEntity {

    private String uuid;
    private String uuname;
    private String uupassword;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>uuid -> uuid</li>
     * <li>uuname -> uuname</li>
     * <li>uupassword -> uupassword</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "uuid": return "uuid";
            case "uuname": return "uuname";
            case "uupassword": return "uupassword";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>uuid -> uuid</li>
     * <li>uuname -> uuname</li>
     * <li>uupassword -> uupassword</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "uuid": return "uuid";
            case "uuname": return "uuname";
            case "uupassword": return "uupassword";
            default: return null;
        }
    }
    
    /** ${po.columnComment} **/
    public String getUuid() {
        return this.uuid;
    }

    /** ${po.columnComment} **/
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /** ${po.columnComment} **/
    public String getUuname() {
        return this.uuname;
    }

    /** ${po.columnComment} **/
    public void setUuname(String uuname) {
        this.uuname = uuname;
    }

    /** ${po.columnComment} **/
    public String getUupassword() {
        return this.uupassword;
    }

    /** ${po.columnComment} **/
    public void setUupassword(String uupassword) {
        this.uupassword = uupassword;
    }

}
