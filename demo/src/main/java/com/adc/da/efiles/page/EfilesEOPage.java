package com.adc.da.efiles.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>efiles EfilesEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-13 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class EfilesEOPage extends BasePage {

    private String id;
    private String idOperator = "=";
    private String savePath;
    private String savePathOperator = "=";

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

    public String getSavePath() {
        return this.savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getSavePathOperator() {
        return this.savePathOperator;
    }

    public void setSavePathOperator(String savePathOperator) {
        this.savePathOperator = savePathOperator;
    }

}
