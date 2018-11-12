package com.adc.da.test.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>demo DemoEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-09 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class DemoEOPage extends BasePage {

    private String id;
    private String idOperator = "=";
    private String uername;
    private String uernameOperator = "=";
    private String password;
    private String passwordOperator = "=";

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

    public String getUername() {
        return this.uername;
    }

    public void setUername(String uername) {
        this.uername = uername;
    }

    public String getUernameOperator() {
        return this.uernameOperator;
    }

    public void setUernameOperator(String uernameOperator) {
        this.uernameOperator = uernameOperator;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordOperator() {
        return this.passwordOperator;
    }

    public void setPasswordOperator(String passwordOperator) {
        this.passwordOperator = passwordOperator;
    }

}
