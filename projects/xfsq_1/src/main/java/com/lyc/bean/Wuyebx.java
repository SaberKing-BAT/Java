package com.lyc.bean;

public class Wuyebx {
    private long wid;//编号
    private String wname;//报修人
    private String wphone;//联系电话
    private String waddress;//地址
    private String winfo;//报修信息；
    private String wtime;//报修时间
    private String wschedule;//处理进度

    public long getWid() {
        return wid;
    }

    public void setWid(long wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWphone() {
        return wphone;
    }

    public void setWphone(String wphone) {
        this.wphone = wphone;
    }

    public String getWaddress() {
        return waddress;
    }

    public void setWaddress(String waddress) {
        this.waddress = waddress;
    }

    public String getWinfo() {
        return winfo;
    }

    public void setWinfo(String winfo) {
        this.winfo = winfo;
    }

    public String getWschedule() {
        return wschedule;
    }

    public void setWschedule(String wschedule) {
        this.wschedule = wschedule;
    }

    public String getWtime() {
        return wtime;
    }
    public void setWtime(String wtime) {
        this.wtime = wtime;
    }

    @Override
    public String toString() {
        return "Wuyebx{" +
                "wid=" + wid +
                ", wname='" + wname + '\'' +
                ", wphone='" + wphone + '\'' +
                ", waddress='" + waddress + '\'' +
                ", winfo='" + winfo + '\'' +
                ", wtime='" + wtime + '\'' +
                ", wschedule='" + wschedule + '\'' +
                '}';
    }
}

