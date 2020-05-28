package com.lyc.bean;
public class Resident {
    private String jid;
    private String jname;
    private String jsex;
    private int jage;
    private String jphone;
    private String jadress;
    private String idadress;
    private String intime;
    private String jpw;

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public String getintime() {
        return intime;
    }

    public void setintime(String intime) {
        this.intime = intime;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getJsex() {
        return jsex;
    }

    public void setJsex(String jsex) {
        this.jsex = jsex;
    }

    public int getJage() {
        return jage;
    }

    public void setJage(int jage) {
        this.jage = jage;
    }

    public String getJphone() {
        return jphone;
    }

    public void setJphone(String jphone) {
        this.jphone = jphone;
    }

    public String getJadress() {
        return jadress;
    }

    public void setJadress(String jadress) {
        this.jadress = jadress;
    }

    public String getidadress() {
        return  idadress;
    }

    public void setidadress(String  idadress) {
        this.idadress =  idadress;
    }

    public String getJpw() {
        return jpw;
    }

    public void setJpw(String jpw) {
        this.jpw = jpw;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "jid='" + jid + '\'' +
                ", jname='" + jname + '\'' +
                ", jsex='" + jsex + '\'' +
                ", jage=" + jage +
                ", jphone='" + jphone + '\'' +
                ", jadress='" + jadress + '\'' +
                ", idadress='" + idadress + '\'' +
                ", intime='" + intime + '\'' +
                ", jpw='" + jpw + '\'' +
                '}';
    }
}
