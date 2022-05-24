package com.hs.clientManager.entity;

import LYC.注释.ExcelField;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * APP_AD_FLAW_DETECTION
 * @author lyc
 */
public class AppAdFlawDetection implements Serializable {
    /**
     * 设备名称(可选择项：
     钢轨
     道岔
     焊缝)
     */
    @ExcelField(colIndex = 0)
    private String equipName;

    /**
     * 检测日期
     */
    @ExcelField(colIndex = 1,isDate = true)
    private String testDate;

    /**
     * 检测员
     */
    @ExcelField(colIndex = 2)
    private String inspector;

    /**
     * 线名
     */
    @ExcelField(colIndex = 3)
    private String lineName;

    /**
     * 线别
     */
    @ExcelField(colIndex = 4)
    private String lineType;

    /**
     * 行别
     */
    @ExcelField(colIndex =5)
    private String rowType;

    /**
     * 车站
     */
    @ExcelField(colIndex = 6)
    private String station;

    /**
     * 里程
     */
    @ExcelField(colIndex = 7)
    private BigDecimal mileage;

    /**
     * 股道号
     */
    @ExcelField(colIndex = 8)
    private String trackNumber;

    /**
     * 钢轨号
     */
    @ExcelField(colIndex = 9)
    private String railNumber;

    /**
     * 道岔号
     */
    @ExcelField(colIndex = 10)
    private String switchNumber;

    /**
     * 股别
     */
    @ExcelField(colIndex = 11)
    private String trackType;

    /**
     * 叉轨类型
     */
    @ExcelField(colIndex = 12)
    private String forkRailType;

    /**
     * 道岔配轨/焊缝号
     */
    @ExcelField(colIndex = 13)
    private String turnoutNumber;

    /**
     * 设备类型
     */
    @ExcelField(colIndex = 14)
    private String equipType;

    /**
     * 伤损位置
     */
    @ExcelField(colIndex = 15)
    private String injuryLocation;

    /**
     * 伤损类型
     */
    @ExcelField(colIndex = 16)
    private String injuryType;

    /**
     * 孔裂位置
     */
    @ExcelField(colIndex = 17)
    private String porePosition;

    /**
     * 伤损程度
     */
    @ExcelField(colIndex = 18)
    private String damageDegree;

    /**
     * 伤损详情
     */
    @ExcelField(colIndex = 19)
    private String damageDetails;

    /**
     * 伤损编码，excel里写填数字，实际数据有文字所以改为string
     */
    @ExcelField(colIndex = 20)
    private String damageCode;

    /**
     * 新旧伤
     */
    @ExcelField(colIndex = 21)
    private String oldNew;

    /**
     * 探伤设备型号
     */
    @ExcelField(colIndex = 22)
    private String flawDeteEquip;

    /**
     * 接收单位
     */
    @ExcelField(colIndex = 23)
    private String receiveUnit;

    /**
     * 接收人
     */
    @ExcelField(colIndex = 24)
    private String receiver;

    /**
     * 备注
     */
    @ExcelField(colIndex = 25)
    private String renarks;

    /**
     * 铁路局
     */
    @ExcelField(colIndex = 26)
    private String railwayBureau;

    /**
     * 工务段
     */
    @ExcelField(colIndex = 27)
    private String worksSection;

    /**
     * 探伤工区
     */
    @ExcelField(colIndex = 28)
    private String flawDeteArea;

    /**
     * 线路工区
     */
    @ExcelField(colIndex = 29)
    private String lineArea;

    /**
     * 发现单位
     */
    @ExcelField(colIndex = 30)
    private String discoveryUnit;

    /**
     * 发现单位类型
     */
    @ExcelField(colIndex = 31)
    private String discoveryUnitType;

    /**
     * 钢轨热印号
     */
    @ExcelField(colIndex = 32)
    private String railStamp;

    /**
     * 生产厂
     */
    @ExcelField(colIndex = 33)
    private String productPlant;

    /**
     * 材质
     */
    @ExcelField(colIndex = 34)
    private String material;

    /**
     * 年通过总重
     */
    @ExcelField(colIndex = 35)
    private BigDecimal throughYerr;

    /**
     * 出厂年月
     */
    @ExcelField(colIndex = 36)
    private String deliveryDate;

    /**
     * 桥隧道口
     */
    @ExcelField(colIndex = 37)
    private String bridgeEntr;

    /**
     * 曲线半径
     */
    @ExcelField(colIndex = 38)
    private BigDecimal radiusCurve;

    /**
     * 坡度
     */
    @ExcelField(colIndex = 39)
    private BigDecimal grade;

    /**
     * 轨枕
     */
    @ExcelField(colIndex = 40)
    private String rail;

    /**
     * 轨型
     */
    @ExcelField(colIndex = 41)
    private String railType;

    /**
     * 线路性质
     */
    @ExcelField(colIndex = 42)
    private String lineNature;

    /**
     * 位置信息
     */
    @ExcelField(colIndex = 43)
    private String position;

    /**
     * 已处置/未处置
     */
    private String status;

    private static final long serialVersionUID = 1L;

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public String getRowType() {
        return rowType;
    }

    public void setRowType(String rowType) {
        this.rowType = rowType;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public void setMileage(BigDecimal mileage) {
        this.mileage = mileage;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getRailNumber() {
        return railNumber;
    }

    public void setRailNumber(String railNumber) {
        this.railNumber = railNumber;
    }

    public String getSwitchNumber() {
        return switchNumber;
    }

    public void setSwitchNumber(String switchNumber) {
        this.switchNumber = switchNumber;
    }

    public String getTrackType() {
        return trackType;
    }

    public void setTrackType(String trackType) {
        this.trackType = trackType;
    }

    public String getForkRailType() {
        return forkRailType;
    }

    public void setForkRailType(String forkRailType) {
        this.forkRailType = forkRailType;
    }

    public String getTurnoutNumber() {
        return turnoutNumber;
    }

    public void setTurnoutNumber(String turnoutNumber) {
        this.turnoutNumber = turnoutNumber;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getInjuryLocation() {
        return injuryLocation;
    }

    public void setInjuryLocation(String injuryLocation) {
        this.injuryLocation = injuryLocation;
    }

    public String getInjuryType() {
        return injuryType;
    }

    public void setInjuryType(String injuryType) {
        this.injuryType = injuryType;
    }

    public String getPorePosition() {
        return porePosition;
    }

    public void setPorePosition(String porePosition) {
        this.porePosition = porePosition;
    }

    public String getDamageDegree() {
        return damageDegree;
    }

    public void setDamageDegree(String damageDegree) {
        this.damageDegree = damageDegree;
    }

    public String getDamageDetails() {
        return damageDetails;
    }

    public void setDamageDetails(String damageDetails) {
        this.damageDetails = damageDetails;
    }

    public String getDamageCode() {
        return damageCode;
    }

    public void setDamageCode(String damageCode) {
        this.damageCode = damageCode;
    }

    public String getOldNew() {
        return oldNew;
    }

    public void setOldNew(String oldNew) {
        this.oldNew = oldNew;
    }

    public String getFlawDeteEquip() {
        return flawDeteEquip;
    }

    public void setFlawDeteEquip(String flawDeteEquip) {
        this.flawDeteEquip = flawDeteEquip;
    }

    public String getReceiveUnit() {
        return receiveUnit;
    }

    public void setReceiveUnit(String receiveUnit) {
        this.receiveUnit = receiveUnit;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getRenarks() {
        return renarks;
    }

    public void setRenarks(String renarks) {
        this.renarks = renarks;
    }

    public String getRailwayBureau() {
        return railwayBureau;
    }

    public void setRailwayBureau(String railwayBureau) {
        this.railwayBureau = railwayBureau;
    }

    public String getWorksSection() {
        return worksSection;
    }

    public void setWorksSection(String worksSection) {
        this.worksSection = worksSection;
    }

    public String getFlawDeteArea() {
        return flawDeteArea;
    }

    public void setFlawDeteArea(String flawDeteArea) {
        this.flawDeteArea = flawDeteArea;
    }

    public String getLineArea() {
        return lineArea;
    }

    public void setLineArea(String lineArea) {
        this.lineArea = lineArea;
    }

    public String getDiscoveryUnit() {
        return discoveryUnit;
    }

    public void setDiscoveryUnit(String discoveryUnit) {
        this.discoveryUnit = discoveryUnit;
    }

    public String getDiscoveryUnitType() {
        return discoveryUnitType;
    }

    public void setDiscoveryUnitType(String discoveryUnitType) {
        this.discoveryUnitType = discoveryUnitType;
    }

    public String getRailStamp() {
        return railStamp;
    }

    public void setRailStamp(String railStamp) {
        this.railStamp = railStamp;
    }

    public String getProductPlant() {
        return productPlant;
    }

    public void setProductPlant(String productPlant) {
        this.productPlant = productPlant;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public BigDecimal getThroughYerr() {
        return throughYerr;
    }

    public void setThroughYerr(BigDecimal throughYerr) {
        this.throughYerr = throughYerr;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getBridgeEntr() {
        return bridgeEntr;
    }

    public void setBridgeEntr(String bridgeEntr) {
        this.bridgeEntr = bridgeEntr;
    }

    public BigDecimal getRadiusCurve() {
        return radiusCurve;
    }

    public void setRadiusCurve(BigDecimal radiusCurve) {
        this.radiusCurve = radiusCurve;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public String getRail() {
        return rail;
    }

    public void setRail(String rail) {
        this.rail = rail;
    }

    public String getRailType() {
        return railType;
    }

    public void setRailType(String railType) {
        this.railType = railType;
    }

    public String getLineNature() {
        return lineNature;
    }

    public void setLineNature(String lineNature) {
        this.lineNature = lineNature;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AppAdFlawDetection{" +
                "equipName='" + equipName + '\'' +
                ", testDate=" + testDate +
                ", inspector='" + inspector + '\'' +
                ", lineName='" + lineName + '\'' +
                ", lineType='" + lineType + '\'' +
                ", rowType='" + rowType + '\'' +
                ", station='" + station + '\'' +
                ", mileage=" + mileage +
                ", trackNumber='" + trackNumber + '\'' +
                ", railNumber='" + railNumber + '\'' +
                ", switchNumber='" + switchNumber + '\'' +
                ", trackType='" + trackType + '\'' +
                ", forkRailType='" + forkRailType + '\'' +
                ", turnoutNumber='" + turnoutNumber + '\'' +
                ", equipType='" + equipType + '\'' +
                ", injuryLocation='" + injuryLocation + '\'' +
                ", injuryType='" + injuryType + '\'' +
                ", porePosition='" + porePosition + '\'' +
                ", damageDegree='" + damageDegree + '\'' +
                ", damageDetails='" + damageDetails + '\'' +
                ", damageCode=" + damageCode +
                ", oldNew='" + oldNew + '\'' +
                ", flawDeteEquip='" + flawDeteEquip + '\'' +
                ", receiveUnit='" + receiveUnit + '\'' +
                ", receiver='" + receiver + '\'' +
                ", renarks='" + renarks + '\'' +
                ", railwayBureau='" + railwayBureau + '\'' +
                ", worksSection='" + worksSection + '\'' +
                ", flawDeteArea='" + flawDeteArea + '\'' +
                ", lineArea='" + lineArea + '\'' +
                ", discoveryUnit='" + discoveryUnit + '\'' +
                ", discoveryUnitType='" + discoveryUnitType + '\'' +
                ", railStamp='" + railStamp + '\'' +
                ", productPlant='" + productPlant + '\'' +
                ", material='" + material + '\'' +
                ", throughYerr=" + throughYerr +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", bridgeEntr='" + bridgeEntr + '\'' +
                ", radiusCurve=" + radiusCurve +
                ", grade=" + grade +
                ", rail='" + rail + '\'' +
                ", railType='" + railType + '\'' +
                ", lineNature='" + lineNature + '\'' +
                ", position='" + position + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}