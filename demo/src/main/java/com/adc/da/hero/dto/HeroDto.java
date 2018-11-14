package com.adc.da.hero.dto;

import com.adc.da.excel.annotation.Excel;

/**
 * @ClassName HeroDto
 * @Description 用于excel操作
 * @Author Administrator
 * @DaTe 2018/11/13 0013 9:01
 */
public class HeroDto {
    @Excel(name = "姓名", orderNum = "1")
    private String hname;

    @Excel(name = "技能", orderNum = "2")
    private String hability;

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHability() {
        return hability;
    }

    public void setHability(String hability) {
        this.hability = hability;
    }
}

