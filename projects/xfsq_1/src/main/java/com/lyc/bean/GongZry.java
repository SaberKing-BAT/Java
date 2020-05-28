package com.lyc.bean;

public class GongZry {
    private long gid; //雇员id
    private String gname;//名字
    private String gsex;///性别
    private int gage;//年龄
    private String gphone;//电话
    private String gidcard;//身份证
    private String gpost;//具体岗位
    private String gtype;//岗位类型（卫生、安保、业委会、物业）

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

    public String getGsex() {
        return gsex;
    }

    public void setGsex(String gsex) {
        this.gsex = gsex;
    }

    public int getGage() {
        return gage;
    }

    public void setGage(int gage) {
        this.gage = gage;
    }

    public String getGphone() {
        return gphone;
    }

    public void setGphone(String gphone) {
        this.gphone = gphone;
    }

    public String getGidcard() {
        return gidcard;
    }

    public void setGidcard(String gidcard) {
        this.gidcard = gidcard;
    }

    public String getGpost() {
        return gpost;
    }

    public void setGpost(String gpost) {
        this.gpost = gpost;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    @Override
    public String toString() {
        return "GongZry{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gsex='" + gsex + '\'' +
                ", gage=" + gage +
                ", gphone='" + gphone + '\'' +
                ", gidcard='" + gidcard + '\'' +
                ", gpost='" + gpost + '\'' +
                ", gtype='" + gtype + '\'' +
                '}';
    }
}
