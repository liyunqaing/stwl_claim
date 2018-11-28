package com.adc.da.elk.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>ELK ElkEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-28 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class ElkEOPage extends BasePage {

    private String eid;
    private String eidOperator = "=";
    private String ename;
    private String enameOperator = "=";
    private String epwd;
    private String epwdOperator = "=";

    public String getEid() {
        return this.eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEidOperator() {
        return this.eidOperator;
    }

    public void setEidOperator(String eidOperator) {
        this.eidOperator = eidOperator;
    }

    public String getEname() {
        return this.ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEnameOperator() {
        return this.enameOperator;
    }

    public void setEnameOperator(String enameOperator) {
        this.enameOperator = enameOperator;
    }

    public String getEpwd() {
        return this.epwd;
    }

    public void setEpwd(String epwd) {
        this.epwd = epwd;
    }

    public String getEpwdOperator() {
        return this.epwdOperator;
    }

    public void setEpwdOperator(String epwdOperator) {
        this.epwdOperator = epwdOperator;
    }

}
