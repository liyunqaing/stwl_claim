package com.adc.da.score.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>SCORES ScoresEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-16 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class ScoresEO extends BaseEntity {

    private String sid;
    private String sname;
    private Integer score;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>sid -> sid</li>
     * <li>sname -> sname</li>
     * <li>score -> score</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "sid": return "sid";
            case "sname": return "sname";
            case "score": return "score";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>sid -> sid</li>
     * <li>sname -> sname</li>
     * <li>score -> score</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "sid": return "sid";
            case "sname": return "sname";
            case "score": return "score";
            default: return null;
        }
    }
    
    /**  **/
    public String getSid() {
        return this.sid;
    }

    /**  **/
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**  **/
    public String getSname() {
        return this.sname;
    }

    /**  **/
    public void setSname(String sname) {
        this.sname = sname;
    }

    /**  **/
    public Integer getScore() {
        return this.score;
    }

    /**  **/
    public void setScore(Integer score) {
        this.score = score;
    }

}
