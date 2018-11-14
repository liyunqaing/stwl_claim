package com.adc.da.efiles.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>efiles EfilesEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-13 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class EfilesEO extends BaseEntity {

    private String id;
    private String savePath;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>savePath -> savePath</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "savePath": return "savePath";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>savePath -> savePath</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "savePath": return "savePath";
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
    public String getSavePath() {
        return this.savePath;
    }

    /** ${po.columnComment} **/
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

}
