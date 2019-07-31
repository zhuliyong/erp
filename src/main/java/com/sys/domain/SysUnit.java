package com.sys.domain;

public class SysUnit {
    private Integer unitId;

    private String unitCode;

    private String unitName;

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public String getUnitName() {
        return unitName;
    }
}