package com.adc.da.hero.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>hero HeroEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-12 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class HeroEOPage extends BasePage {

    private String hid;
    private String hidOperator = "=";
    private String hname;
    private String hnameOperator = "=";
    private String hability;
    private String habilityOperator = "=";

    public String getHid() {
        return this.hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getHidOperator() {
        return this.hidOperator;
    }

    public void setHidOperator(String hidOperator) {
        this.hidOperator = hidOperator;
    }

    public String getHname() {
        return this.hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHnameOperator() {
        return this.hnameOperator;
    }

    public void setHnameOperator(String hnameOperator) {
        this.hnameOperator = hnameOperator;
    }

    public String getHability() {
        return this.hability;
    }

    public void setHability(String hability) {
        this.hability = hability;
    }

    public String getHabilityOperator() {
        return this.habilityOperator;
    }

    public void setHabilityOperator(String habilityOperator) {
        this.habilityOperator = habilityOperator;
    }

}
