package com.adc.da.elk.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>ELK ElkEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-28 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class ElkEO extends BaseEntity {

    private Integer eid;
    private String ename;
    private String epwd;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>eid -> eid</li>
     * <li>ename -> ename</li>
     * <li>epwd -> epwd</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "eid": return "eid";
            case "ename": return "ename";
            case "epwd": return "epwd";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>eid -> eid</li>
     * <li>ename -> ename</li>
     * <li>epwd -> epwd</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "eid": return "eid";
            case "ename": return "ename";
            case "epwd": return "epwd";
            default: return null;
        }
    }
    
    /** ${po.columnComment} **/
    public Integer getEid() {
        return this.eid;
    }

    /** ${po.columnComment} **/
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /** ${po.columnComment} **/
    public String getEname() {
        return this.ename;
    }

    /** ${po.columnComment} **/
    public void setEname(String ename) {
        this.ename = ename;
    }

    /** ${po.columnComment} **/
    public String getEpwd() {
        return this.epwd;
    }

    /** ${po.columnComment} **/
    public void setEpwd(String epwd) {
        this.epwd = epwd;
    }

}
