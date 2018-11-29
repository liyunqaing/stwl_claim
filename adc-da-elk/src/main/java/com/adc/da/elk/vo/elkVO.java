package com.adc.da.elk.vo;

/**
 * @program: stwl_claim
 * @description:
 * @author: elk_wangchengxin
 * @create: 2018-11-28 13:45
 * @version: 2.0.0
 **/
public class elkVO {

    //用户表的id
    private String uuid;
    //用户表的用户名
    private String uuname;
    //用户年龄表的年龄
    private  String age;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuname() {
        return uuname;
    }

    public void setUuname(String uuname) {
        this.uuname = uuname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "elkVO{" +
                "uuid='" + uuid + '\'' +
                ", uuname='" + uuname + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

