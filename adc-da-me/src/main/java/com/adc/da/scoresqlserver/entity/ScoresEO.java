package com.adc.da.scoresqlserver.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>scores ScoresEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-27 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class ScoresEO extends BaseEntity {

    private Integer id;
    private String name;
    private Integer score;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>name -> name</li>
     * <li>score -> score</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "name": return "name";
            case "score": return "score";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>name -> name</li>
     * <li>score -> score</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "name": return "name";
            case "score": return "score";
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
    public Integer getScore() {
        return this.score;
    }

    /** ${po.columnComment} **/
    public void setScore(Integer score) {
        this.score = score;
    }

}
