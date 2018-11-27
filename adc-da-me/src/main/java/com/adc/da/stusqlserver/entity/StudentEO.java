package com.adc.da.stusqlserver.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>student StudentEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-27 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class StudentEO extends BaseEntity {

    private Integer id;
    private String name;
    private String sex;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>name -> name</li>
     * <li>sex -> sex</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "name": return "name";
            case "sex": return "sex";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>name -> name</li>
     * <li>sex -> sex</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "name": return "name";
            case "sex": return "sex";
            default: return null;
        }
    }
    
    /** ${po.columnComment} **/
    public Integer getId() {
        return this.id;
    }

    /** ${po.columnComment} **/
    public void setId(Integer id) {
        this.id = id;
    }

    /** ${po.columnComment} **/
    public String getName() {
        return this.name;
    }

    /** ${po.columnComment} **/
    public void setName(String name) {
        this.name = name;
    }

    /** ${po.columnComment} **/
    public String getSex() {
        return this.sex;
    }

    /** ${po.columnComment} **/
    public void setSex(String sex) {
        this.sex = sex;
    }

}
