package com.lyc.bean;

public class PinKun {
    private String pid;//身份证
    private String pname;//名字
    private String pinfo;//申请内容
    private String schedule;//审批
    private String time;//申请时间

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PinKun{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", pinfo='" + pinfo + '\'' +
                ", schedule='" + schedule + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
