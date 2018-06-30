package com.proffl.typing.entity;


import javax.persistence.*;

@Entity
@Table(name = "CONFIG")
public class ConfigEntity {
    @Id
    @Column(name="PARAM_ID")
    private Integer paramId;

    @Column(name="IS_MARCH")
    private Boolean isMarch;

    @Column(name="IS_REPEAT")
    private Boolean isRepeat;

    @Column(name="TIPS_ON_EXTRA")
    private Boolean tipsOnExtra;

    @Column(name="TIPS_ON_HARD")
    private Boolean tipsOnHard;

    @Column(name="HARD_TIME")
    private Integer hardTime;

    @Column(name="AUTO_REFRESH")
    private Boolean autoRefresh;

    public ConfigEntity() {
        paramId = 1;
        isMarch = false;
        isRepeat = true;
        tipsOnExtra = false;
        tipsOnHard = false;
        hardTime = 1000;
        autoRefresh = false;
    }

    @Override
    public String toString() {
        return "ConfigEntity{" +
                "paramId=" + paramId +
                ", isMarch=" + isMarch +
                ", isRepeat=" + isRepeat +
                ", tipsOnExtra=" + tipsOnExtra +
                ", tipsOnHard=" + tipsOnHard +
                ", hardTime=" + hardTime +
                ", autoRefresh=" + autoRefresh +
                '}';
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public boolean getIsMarch() {
        return isMarch;
    }

    public void setIsMarch(boolean march) {
        isMarch = march;
    }

    public boolean getIsRepeat() {
        return isRepeat;
    }

    public void setIsRepeat(boolean repeat) {
        isRepeat = repeat;
    }

    public boolean isTipsOnExtra() {
        return tipsOnExtra;
    }

    public void setTipsOnExtra(boolean tipsOnExtra) {
        this.tipsOnExtra = tipsOnExtra;
    }

    public boolean isTipsOnHard() {
        return tipsOnHard;
    }

    public void setTipsOnHard(boolean tipsOnHard) {
        this.tipsOnHard = tipsOnHard;
    }

    public int getHardTime() {
        return hardTime;
    }

    public void setHardTime(int hardTime) {
        this.hardTime = hardTime;
    }

    public boolean isAutoRefresh() {
        return autoRefresh;
    }

    public void setAutoRefresh(boolean autoRefresh) {
        this.autoRefresh = autoRefresh;
    }
}
