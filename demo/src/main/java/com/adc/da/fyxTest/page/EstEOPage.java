package com.adc.da.fyxTest.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>Test EstEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-20 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class EstEOPage extends BasePage {

    private String id;
    private String idOperator = "=";
    private String name;
    private String nameOperator = "=";
    private String age;
    private String ageOperator = "=";

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

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAgeOperator() {
        return this.ageOperator;
    }

    public void setAgeOperator(String ageOperator) {
        this.ageOperator = ageOperator;
    }

}
