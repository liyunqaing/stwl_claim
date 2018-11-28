package com.adc.da.elk.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>UUSERS UusersEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-28 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class UusersEOPage extends BasePage {

    private String uuid;
    private String uuidOperator = "=";
    private String uuname;
    private String uunameOperator = "=";
    private String uupassword;
    private String uupasswordOperator = "=";

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuidOperator() {
        return this.uuidOperator;
    }

    public void setUuidOperator(String uuidOperator) {
        this.uuidOperator = uuidOperator;
    }

    public String getUuname() {
        return this.uuname;
    }

    public void setUuname(String uuname) {
        this.uuname = uuname;
    }

    public String getUunameOperator() {
        return this.uunameOperator;
    }

    public void setUunameOperator(String uunameOperator) {
        this.uunameOperator = uunameOperator;
    }

    public String getUupassword() {
        return this.uupassword;
    }

    public void setUupassword(String uupassword) {
        this.uupassword = uupassword;
    }

    public String getUupasswordOperator() {
        return this.uupasswordOperator;
    }

    public void setUupasswordOperator(String uupasswordOperator) {
        this.uupasswordOperator = uupasswordOperator;
    }

}
