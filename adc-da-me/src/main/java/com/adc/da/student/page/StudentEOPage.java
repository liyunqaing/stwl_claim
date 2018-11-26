package com.adc.da.student.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>TS_STUDENT StudentEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-21 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class StudentEOPage extends BasePage {

    private String id;
    private String idOperator = "=";
    private String name;
    private String nameOperator = "=";
    private String xuehao;
    private String xuehaoOperator = "=";
    private String classes;
    private String classesOperator = "=";

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOperator() {
        return this.idOperator;
    }

    public void setIdOperator(String idOperator) {
        this.idOperator = idOperator;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOperator() {
        return this.nameOperator;
    }

    public void setNameOperator(String nameOperator) {
        this.nameOperator = nameOperator;
    }

    public String getXuehao() {
        return this.xuehao;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public String getXuehaoOperator() {
        return this.xuehaoOperator;
    }

    public void setXuehaoOperator(String xuehaoOperator) {
        this.xuehaoOperator = xuehaoOperator;
    }

    public String getClasses() {
        return this.classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getClassesOperator() {
        return this.classesOperator;
    }

    public void setClassesOperator(String classesOperator) {
        this.classesOperator = classesOperator;
    }

}
