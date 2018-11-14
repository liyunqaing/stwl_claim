package com.adc.da.hero.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>hero HeroEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-12 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class HeroEO extends BaseEntity {

    private String hid;
    private String hname;
    private String hability;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>hid -> hid</li>
     * <li>hname -> hname</li>
     * <li>hability -> hability</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "hid": return "hid";
            case "hname": return "hname";
            case "hability": return "hability";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>hid -> hid</li>
     * <li>hname -> hname</li>
     * <li>hability -> hability</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "hid": return "hid";
            case "hname": return "hname";
            case "hability": return "hability";
            default: return null;
        }
    }
    
    /** ${po.columnComment} **/
    public String getHid() {
        return this.hid;
    }

    /** ${po.columnComment} **/
    public void setHid(String hid) {
        this.hid = hid;
    }

    /** ${po.columnComment} **/
    public String getHname() {
        return this.hname;
    }

    /** ${po.columnComment} **/
    public void setHname(String hname) {
        this.hname = hname;
    }

    /** ${po.columnComment} **/
    public String getHability() {
        return this.hability;
    }

    /** ${po.columnComment} **/
    public void setHability(String hability) {
        this.hability = hability;
    }

}
