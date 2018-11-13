package com.adc.da.test.dto;

import com.adc.da.base.entity.BaseEntity;
import com.adc.da.excel.annotation.Excel;


/**
 * <b>功能：</b>demo DemoEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-09 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class DemoDto extends BaseEntity {
    @Excel(name = "ID",orderNum = "1")
    private String id;
    @Excel(name = "姓名",orderNum = "2")
    private String uername;
    @Excel(name = "密码",orderNum = "3")
    private String password;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>uername -> uername</li>
     * <li>password -> password</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "uername": return "uername";
            case "password": return "password";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>uername -> uername</li>
     * <li>password -> password</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "uername": return "uername";
            case "password": return "password";
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
    public String getUername() {
        return this.uername;
    }

    /** ${po.columnComment} **/
    public void setUername(String uername) {
        this.uername = uername;
    }

    /** ${po.columnComment} **/
    public String getPassword() {
        return this.password;
    }

    /** ${po.columnComment} **/
    public void setPassword(String password) {
        this.password = password;
    }

}
