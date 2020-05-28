package com.lyc.bean;

public class ActiveInfo {
    private long hid;        //活动id主键
    private String hname;   //活动主题
    private String htime;    //活动时间
    private String haddress; //活动地点
    private String hmatter;  //活动内容
    private String htype;    //活动类型
    private String hstatus;  //活动状态

    public long getHid() {
        return hid;
    }

    public void setHid(long hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHtime() {
        return htime;
    }

    public void setHtime(String htime) {
        this.htime = htime;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getHmatter() {
        return hmatter;
    }

    public void setHmatter(String hmatter) {
        this.hmatter = hmatter;
    }

    public String getHtype() {
        return htype;
    }

    public void setHtype(String htype) {
        this.htype = htype;
    }

    public String getHstatus() {
        return hstatus;
    }

    public void setHstatus(String hstatus) {
        this.hstatus = hstatus;
    }

    @Override
    public String toString() {
        return "ActiveInfo{" +
                "hid=" + hid +
                ", hname='" + hname + '\'' +
                ", htime='" + htime + '\'' +
                ", haddress='" + haddress + '\'' +
                ", hmatter='" + hmatter + '\'' +
                ", htype='" + htype + '\'' +
                ", hstasus='" + hstatus + '\'' +
                '}';
    }
}
