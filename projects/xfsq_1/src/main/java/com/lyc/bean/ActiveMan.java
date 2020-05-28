package com.lyc.bean;

public class ActiveMan {
    private long aaid;//唯一标识
    private long aid;
    private String aphone;
    private String aresult;
    private String schedule;
    private Resident resident=null;
    private ActiveInfo activeInfo=null;

    public long getAaid() {
        return aaid;
    }

    public void setAaid(long aaid) {
        this.aaid = aaid;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public String getAresult() {
        return aresult;
    }

    public void setAresult(String aresult) {
        this.aresult = aresult;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public ActiveInfo getActiveInfo() {
        return activeInfo;
    }

    public void setActiveInfo(ActiveInfo activeInfo) {
        this.activeInfo = activeInfo;
    }

    @Override
    public String toString() {
        return "ActiveMan{" +
                "aaid=" + aaid +
                ", aid=" + aid +
                ", aphone='" + aphone + '\'' +
                ", aresult='" + aresult + '\'' +
                ", schedule='" + schedule + '\'' +
                ", resident=" + resident +
                ", activeInfo=" + activeInfo +
                '}';
    }
}
/*
* SELECT activeman.aid,activeman.aresult,resident.jname,activeinfo.hname From resident inner join
activeman inner join activeinfo  on jphone=aphone and  aid=hid;
* */