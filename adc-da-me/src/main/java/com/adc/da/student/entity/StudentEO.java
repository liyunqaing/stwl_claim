package com.adc.da.student.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>TS_STUDENT StudentEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-21 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class StudentEO extends BaseEntity {

    private String id;
    private String name;
    private Integer xuehao;
    private Integer classes;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>name -> name</li>
     * <li>xuehao -> xuehao</li>
     * <li>classes -> classes</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "name": return "name";
            case "xuehao": return "xuehao";
            case "classes": return "classes";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>name -> name</li>
     * <li>xuehao -> xuehao</li>
     * <li>classes -> classes</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "name": return "name";
            case "xuehao": return "xuehao";
            case "classes": return "classes";
            default: return null;
        }
    }
    
    /**  **/
    public String getId() {
        return this.id;
    }

    /**  **/
    public void setId(String id) {
        this.id = id;
    }

    /**  **/
    public String getName() {
        return this.name;
    }

    /**  **/
    public void setName(String name) {
        this.name = name;
    }

    /**  **/
    public Integer getXuehao() {
        return this.xuehao;
    }

    /**  **/
    public void setXuehao(Integer xuehao) {
        this.xuehao = xuehao;
    }

    /**  **/
    public Integer getClasses() {
        return this.classes;
    }

    /**  **/
    public void setClasses(Integer classes) {
        this.classes = classes;
    }

}
