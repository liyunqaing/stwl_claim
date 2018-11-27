package com.adc.da.scoresqlserver.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>scores ScoresEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-27 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class ScoresEOPage extends BasePage {

    private String id;
    private String idOperator = "=";
    private String name;
    private String nameOperator = "=";
    private String score;
    private String scoreOperator = "=";

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
