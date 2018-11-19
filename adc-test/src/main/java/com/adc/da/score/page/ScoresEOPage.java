package com.adc.da.score.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>SCORES ScoresEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-16 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class ScoresEOPage extends BasePage {

    private String sid;
    private String sidOperator = "=";
    private String sname;
    private String snameOperator = "=";
    private String score;
    private String scoreOperator = "=";

    public String getSid() {
        return this.sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSidOperator() {
        return this.sidOperator;
    }

    public void setSidOperator(String sidOperator) {
        this.sidOperator = sidOperator;
    }

    public String getSname() {
        return this.sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSnameOperator() {
        return this.snameOperator;
    }

    public void setSnameOperator(String snameOperator) {
        this.snameOperator = snameOperator;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScoreOperator() {
        return this.scoreOperator;
    }

    public void setScoreOperator(String scoreOperator) {
        this.scoreOperator = scoreOperator;
    }

}
