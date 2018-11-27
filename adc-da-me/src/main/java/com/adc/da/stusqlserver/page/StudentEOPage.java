package com.adc.da.stusqlserver.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>student StudentEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-27 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class StudentEOPage extends BasePage {

    private String id;
    private String idOperator = "=";
    private String name;
    private String nameOperator = "=";
    private String sex;
    private String sexOperator = "=";

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

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSexOperator() {
        return this.sexOperator;
    }

    public void setSexOperator(String sexOperator) {
        this.sexOperator = sexOperator;
    }

}
