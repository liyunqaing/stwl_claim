package com.adc.da.sys.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>HPM05USER Hpm05userEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-06 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class Hpm05userEO extends BaseEntity {

    private Integer userid;
    private String companycode;
    private String companyname;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdate;
    private Integer createerid;
    private String departcode;
    private String email;
    private Integer failedtimes;
    private String ipaddr;
    private String jobcode;
    private String jobname;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastlogin;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastreq;
    private String usercode;
    private String online;
    private String paswd;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date pswupdatedate;
    private String py;
    private String relation;
    private String remark;
    private String roleid;
    private String rolename;
    private String sp1;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date sp10;
    private String sp11;
    private String sp12;
    private String sp2;
    private String sp3;
    private String sp4;
    private String sp5;
    private String sp6;
    private Integer sp7;
    private Integer sp8;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date sp9;
    private String status;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedate;
    private Integer updateerid;
    private String username;
    private String usertype;
    private Integer fileid;
    private String signtype;
    private String ispaswd;
    private String approvepaswd;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>userid -> userid</li>
     * <li>companycode -> companycode</li>
     * <li>companyname -> companyname</li>
     * <li>createdate -> createdate</li>
     * <li>createerid -> createerid</li>
     * <li>departcode -> departcode</li>
     * <li>email -> email</li>
     * <li>failedtimes -> failedtimes</li>
     * <li>ipaddr -> ipaddr</li>
     * <li>jobcode -> jobcode</li>
     * <li>jobname -> jobname</li>
     * <li>lastlogin -> lastlogin</li>
     * <li>lastreq -> lastreq</li>
     * <li>usercode -> usercode</li>
     * <li>online -> online</li>
     * <li>paswd -> paswd</li>
     * <li>pswupdatedate -> pswupdatedate</li>
     * <li>py -> py</li>
     * <li>relation -> relation</li>
     * <li>remark -> remark</li>
     * <li>roleid -> roleid</li>
     * <li>rolename -> rolename</li>
     * <li>sp1 -> sp1</li>
     * <li>sp10 -> sp10</li>
     * <li>sp11 -> sp11</li>
     * <li>sp12 -> sp12</li>
     * <li>sp2 -> sp2</li>
     * <li>sp3 -> sp3</li>
     * <li>sp4 -> sp4</li>
     * <li>sp5 -> sp5</li>
     * <li>sp6 -> sp6</li>
     * <li>sp7 -> sp7</li>
     * <li>sp8 -> sp8</li>
     * <li>sp9 -> sp9</li>
     * <li>status -> status</li>
     * <li>updatedate -> updatedate</li>
     * <li>updateerid -> updateerid</li>
     * <li>username -> username</li>
     * <li>usertype -> usertype</li>
     * <li>fileid -> fileid</li>
     * <li>signtype -> signtype</li>
     * <li>ispaswd -> ispaswd</li>
     * <li>approvepaswd -> approvepaswd</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "userid": return "userid";
            case "companycode": return "companycode";
            case "companyname": return "companyname";
            case "createdate": return "createdate";
            case "createerid": return "createerid";
            case "departcode": return "departcode";
            case "email": return "email";
            case "failedtimes": return "failedtimes";
            case "ipaddr": return "ipaddr";
            case "jobcode": return "jobcode";
            case "jobname": return "jobname";
            case "lastlogin": return "lastlogin";
            case "lastreq": return "lastreq";
            case "usercode": return "usercode";
            case "online": return "online";
            case "paswd": return "paswd";
            case "pswupdatedate": return "pswupdatedate";
            case "py": return "py";
            case "relation": return "relation";
            case "remark": return "remark";
            case "roleid": return "roleid";
            case "rolename": return "rolename";
            case "sp1": return "sp1";
            case "sp10": return "sp10";
            case "sp11": return "sp11";
            case "sp12": return "sp12";
            case "sp2": return "sp2";
            case "sp3": return "sp3";
            case "sp4": return "sp4";
            case "sp5": return "sp5";
            case "sp6": return "sp6";
            case "sp7": return "sp7";
            case "sp8": return "sp8";
            case "sp9": return "sp9";
            case "status": return "status";
            case "updatedate": return "updatedate";
            case "updateerid": return "updateerid";
            case "username": return "username";
            case "usertype": return "usertype";
            case "fileid": return "fileid";
            case "signtype": return "signtype";
            case "ispaswd": return "ispaswd";
            case "approvepaswd": return "approvepaswd";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>userid -> userid</li>
     * <li>companycode -> companycode</li>
     * <li>companyname -> companyname</li>
     * <li>createdate -> createdate</li>
     * <li>createerid -> createerid</li>
     * <li>departcode -> departcode</li>
     * <li>email -> email</li>
     * <li>failedtimes -> failedtimes</li>
     * <li>ipaddr -> ipaddr</li>
     * <li>jobcode -> jobcode</li>
     * <li>jobname -> jobname</li>
     * <li>lastlogin -> lastlogin</li>
     * <li>lastreq -> lastreq</li>
     * <li>usercode -> usercode</li>
     * <li>online -> online</li>
     * <li>paswd -> paswd</li>
     * <li>pswupdatedate -> pswupdatedate</li>
     * <li>py -> py</li>
     * <li>relation -> relation</li>
     * <li>remark -> remark</li>
     * <li>roleid -> roleid</li>
     * <li>rolename -> rolename</li>
     * <li>sp1 -> sp1</li>
     * <li>sp10 -> sp10</li>
     * <li>sp11 -> sp11</li>
     * <li>sp12 -> sp12</li>
     * <li>sp2 -> sp2</li>
     * <li>sp3 -> sp3</li>
     * <li>sp4 -> sp4</li>
     * <li>sp5 -> sp5</li>
     * <li>sp6 -> sp6</li>
     * <li>sp7 -> sp7</li>
     * <li>sp8 -> sp8</li>
     * <li>sp9 -> sp9</li>
     * <li>status -> status</li>
     * <li>updatedate -> updatedate</li>
     * <li>updateerid -> updateerid</li>
     * <li>username -> username</li>
     * <li>usertype -> usertype</li>
     * <li>fileid -> fileid</li>
     * <li>signtype -> signtype</li>
     * <li>ispaswd -> ispaswd</li>
     * <li>approvepaswd -> approvepaswd</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "userid": return "userid";
            case "companycode": return "companycode";
            case "companyname": return "companyname";
            case "createdate": return "createdate";
            case "createerid": return "createerid";
            case "departcode": return "departcode";
            case "email": return "email";
            case "failedtimes": return "failedtimes";
            case "ipaddr": return "ipaddr";
            case "jobcode": return "jobcode";
            case "jobname": return "jobname";
            case "lastlogin": return "lastlogin";
            case "lastreq": return "lastreq";
            case "usercode": return "usercode";
            case "online": return "online";
            case "paswd": return "paswd";
            case "pswupdatedate": return "pswupdatedate";
            case "py": return "py";
            case "relation": return "relation";
            case "remark": return "remark";
            case "roleid": return "roleid";
            case "rolename": return "rolename";
            case "sp1": return "sp1";
            case "sp10": return "sp10";
            case "sp11": return "sp11";
            case "sp12": return "sp12";
            case "sp2": return "sp2";
            case "sp3": return "sp3";
            case "sp4": return "sp4";
            case "sp5": return "sp5";
            case "sp6": return "sp6";
            case "sp7": return "sp7";
            case "sp8": return "sp8";
            case "sp9": return "sp9";
            case "status": return "status";
            case "updatedate": return "updatedate";
            case "updateerid": return "updateerid";
            case "username": return "username";
            case "usertype": return "usertype";
            case "fileid": return "fileid";
            case "signtype": return "signtype";
            case "ispaswd": return "ispaswd";
            case "approvepaswd": return "approvepaswd";
            default: return null;
        }
    }
    
    /** ${po.columnComment} **/
    public Integer getUserid() {
        return this.userid;
    }

    /** ${po.columnComment} **/
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /** ${po.columnComment} **/
    public String getCompanycode() {
        return this.companycode;
    }

    /** ${po.columnComment} **/
    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    /** ${po.columnComment} **/
    public String getCompanyname() {
        return this.companyname;
    }

    /** ${po.columnComment} **/
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    /** ${po.columnComment} **/
    public Date getCreatedate() {
        return this.createdate;
    }

    /** ${po.columnComment} **/
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /** ${po.columnComment} **/
    public Integer getCreateerid() {
        return this.createerid;
    }

    /** ${po.columnComment} **/
    public void setCreateerid(Integer createerid) {
        this.createerid = createerid;
    }

    /** ${po.columnComment} **/
    public String getDepartcode() {
        return this.departcode;
    }

    /** ${po.columnComment} **/
    public void setDepartcode(String departcode) {
        this.departcode = departcode;
    }

    /** ${po.columnComment} **/
    public String getEmail() {
        return this.email;
    }

    /** ${po.columnComment} **/
    public void setEmail(String email) {
        this.email = email;
    }

    /** ${po.columnComment} **/
    public Integer getFailedtimes() {
        return this.failedtimes;
    }

    /** ${po.columnComment} **/
    public void setFailedtimes(Integer failedtimes) {
        this.failedtimes = failedtimes;
    }

    /** ${po.columnComment} **/
    public String getIpaddr() {
        return this.ipaddr;
    }

    /** ${po.columnComment} **/
    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    /** ${po.columnComment} **/
    public String getJobcode() {
        return this.jobcode;
    }

    /** ${po.columnComment} **/
    public void setJobcode(String jobcode) {
        this.jobcode = jobcode;
    }

    /** ${po.columnComment} **/
    public String getJobname() {
        return this.jobname;
    }

    /** ${po.columnComment} **/
    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    /** ${po.columnComment} **/
    public Date getLastlogin() {
        return this.lastlogin;
    }

    /** ${po.columnComment} **/
    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    /** ${po.columnComment} **/
    public Date getLastreq() {
        return this.lastreq;
    }

    /** ${po.columnComment} **/
    public void setLastreq(Date lastreq) {
        this.lastreq = lastreq;
    }

    /** ${po.columnComment} **/
    public String getUsercode() {
        return this.usercode;
    }

    /** ${po.columnComment} **/
    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    /** ${po.columnComment} **/
    public String getOnline() {
        return this.online;
    }

    /** ${po.columnComment} **/
    public void setOnline(String online) {
        this.online = online;
    }

    /** ${po.columnComment} **/
    public String getPaswd() {
        return this.paswd;
    }

    /** ${po.columnComment} **/
    public void setPaswd(String paswd) {
        this.paswd = paswd;
    }

    /** ${po.columnComment} **/
    public Date getPswupdatedate() {
        return this.pswupdatedate;
    }

    /** ${po.columnComment} **/
    public void setPswupdatedate(Date pswupdatedate) {
        this.pswupdatedate = pswupdatedate;
    }

    /** ${po.columnComment} **/
    public String getPy() {
        return this.py;
    }

    /** ${po.columnComment} **/
    public void setPy(String py) {
        this.py = py;
    }

    /** ${po.columnComment} **/
    public String getRelation() {
        return this.relation;
    }

    /** ${po.columnComment} **/
    public void setRelation(String relation) {
        this.relation = relation;
    }

    /** ${po.columnComment} **/
    public String getRemark() {
        return this.remark;
    }

    /** ${po.columnComment} **/
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** ${po.columnComment} **/
    public String getRoleid() {
        return this.roleid;
    }

    /** ${po.columnComment} **/
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    /** ${po.columnComment} **/
    public String getRolename() {
        return this.rolename;
    }

    /** ${po.columnComment} **/
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /** ${po.columnComment} **/
    public String getSp1() {
        return this.sp1;
    }

    /** ${po.columnComment} **/
    public void setSp1(String sp1) {
        this.sp1 = sp1;
    }

    /** ${po.columnComment} **/
    public Date getSp10() {
        return this.sp10;
    }

    /** ${po.columnComment} **/
    public void setSp10(Date sp10) {
        this.sp10 = sp10;
    }

    /** ${po.columnComment} **/
    public String getSp11() {
        return this.sp11;
    }

    /** ${po.columnComment} **/
    public void setSp11(String sp11) {
        this.sp11 = sp11;
    }

    /** ${po.columnComment} **/
    public String getSp12() {
        return this.sp12;
    }

    /** ${po.columnComment} **/
    public void setSp12(String sp12) {
        this.sp12 = sp12;
    }

    /** ${po.columnComment} **/
    public String getSp2() {
        return this.sp2;
    }

    /** ${po.columnComment} **/
    public void setSp2(String sp2) {
        this.sp2 = sp2;
    }

    /** ${po.columnComment} **/
    public String getSp3() {
        return this.sp3;
    }

    /** ${po.columnComment} **/
    public void setSp3(String sp3) {
        this.sp3 = sp3;
    }

    /** ${po.columnComment} **/
    public String getSp4() {
        return this.sp4;
    }

    /** ${po.columnComment} **/
    public void setSp4(String sp4) {
        this.sp4 = sp4;
    }

    /** ${po.columnComment} **/
    public String getSp5() {
        return this.sp5;
    }

    /** ${po.columnComment} **/
    public void setSp5(String sp5) {
        this.sp5 = sp5;
    }

    /** ${po.columnComment} **/
    public String getSp6() {
        return this.sp6;
    }

    /** ${po.columnComment} **/
    public void setSp6(String sp6) {
        this.sp6 = sp6;
    }

    /** ${po.columnComment} **/
    public Integer getSp7() {
        return this.sp7;
    }

    /** ${po.columnComment} **/
    public void setSp7(Integer sp7) {
        this.sp7 = sp7;
    }

    /** ${po.columnComment} **/
    public Integer getSp8() {
        return this.sp8;
    }

    /** ${po.columnComment} **/
    public void setSp8(Integer sp8) {
        this.sp8 = sp8;
    }

    /** ${po.columnComment} **/
    public Date getSp9() {
        return this.sp9;
    }

    /** ${po.columnComment} **/
    public void setSp9(Date sp9) {
        this.sp9 = sp9;
    }

    /** ${po.columnComment} **/
    public String getStatus() {
        return this.status;
    }

    /** ${po.columnComment} **/
    public void setStatus(String status) {
        this.status = status;
    }

    /** ${po.columnComment} **/
    public Date getUpdatedate() {
        return this.updatedate;
    }

    /** ${po.columnComment} **/
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /** ${po.columnComment} **/
    public Integer getUpdateerid() {
        return this.updateerid;
    }

    /** ${po.columnComment} **/
    public void setUpdateerid(Integer updateerid) {
        this.updateerid = updateerid;
    }

    /** ${po.columnComment} **/
    public String getUsername() {
        return this.username;
    }

    /** ${po.columnComment} **/
    public void setUsername(String username) {
        this.username = username;
    }

    /** ${po.columnComment} **/
    public String getUsertype() {
        return this.usertype;
    }

    /** ${po.columnComment} **/
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    /** ${po.columnComment} **/
    public Integer getFileid() {
        return this.fileid;
    }

    /** ${po.columnComment} **/
    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }

    /** ${po.columnComment} **/
    public String getSigntype() {
        return this.signtype;
    }

    /** ${po.columnComment} **/
    public void setSigntype(String signtype) {
        this.signtype = signtype;
    }

    /** ${po.columnComment} **/
    public String getIspaswd() {
        return this.ispaswd;
    }

    /** ${po.columnComment} **/
    public void setIspaswd(String ispaswd) {
        this.ispaswd = ispaswd;
    }

    /** ${po.columnComment} **/
    public String getApprovepaswd() {
        return this.approvepaswd;
    }

    /** ${po.columnComment} **/
    public void setApprovepaswd(String approvepaswd) {
        this.approvepaswd = approvepaswd;
    }

}
