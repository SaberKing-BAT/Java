package com.lyc.bean;

public class GongGao {
    private long gid;
    private String gname;
    private String ginfo;
    private String gtime;
    private String gtype;

    public long getGid() {
        return gid;
    }

    public void setGid(long gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGinfo() {
        return ginfo;
    }

    public void setGinfo(String ginfo) {
        this.ginfo = ginfo;
    }

    public String getGtime() {
        return gtime;
    }

    public void setGtime(String gtime) {
        this.gtime = gtime;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    @Override
    public String toString() {
        return "GongGao{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", ginfo='" + ginfo + '\'' +
                ", gtime='" + gtime + '\'' +
                ", gtype='" + gtype + '\'' +
                '}';
    }
}
