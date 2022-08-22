package com.mrfang.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class ProjectInfo {
    private Integer piId;
    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,64}$)|(^[\\u2E80-\\u9FFF]{2,32}$)",
            message="用户名为2~32位中文,或者6~64位大小写英文、数字、下划线、横杠的组合")
    private String piProjectname;
    //实体类时间注解
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date piStartdate;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date piEnddate;

    private Integer piStatus;//项目的状态 0：已申报 1：审核中 2：已审核

    private Integer acid; //申报人编号 项目和申报人 是： 多对一的关系

    private Applicant applicant;

    @Override
    public String toString() {
        return "ProjectInfo{" +
                "piId=" + piId +
                ", piProjectname='" + piProjectname + '\'' +
                ", piStartdate=" + piStartdate +
                ", piEnddate=" + piEnddate +
                ", piStatus=" + piStatus +
                ", acid=" + acid +
                ", applicant=" + applicant +
                '}';
    }

    public ProjectInfo() {
    }

    public ProjectInfo(Integer piId, String piProjectname, Date piStartdate, Date piEnddate, Integer piStatus, Integer acid, Applicant applicant) {
        this.piId = piId;
        this.piProjectname = piProjectname;
        this.piStartdate = piStartdate;
        this.piEnddate = piEnddate;
        this.piStatus = piStatus;
        this.acid = acid;
        this.applicant = applicant;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Integer getPiId() {
        return piId;
    }

    public void setPiId(Integer piId) {
        this.piId = piId;
    }

    public String getPiProjectname() {
        return piProjectname;
    }

    public void setPiProjectname(String piProjectname) {
        this.piProjectname = piProjectname == null ? null : piProjectname.trim();
    }

    public Date getPiStartdate() {
        return piStartdate;
    }

    public void setPiStartdate(Date piStartdate) {
        this.piStartdate = piStartdate;
    }

    public Date getPiEnddate() {
        return piEnddate;
    }

    public void setPiEnddate(Date piEnddate) {
        this.piEnddate = piEnddate;
    }

    public Integer getPiStatus() {
        return piStatus;
    }

    public void setPiStatus(Integer piStatus) {
        this.piStatus = piStatus;
    }

    public Integer getAcid() {
        return acid;
    }

    public void setAcid(Integer acid) {
        this.acid = acid;
    }
}