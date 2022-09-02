package com.ruoyi.system.domain.dto;

import com.ruoyi.system.domain.TMedicalCostOutpatientInfo;
import com.ruoyi.system.domain.TMedicalCostPersonArchivesWait;

public class WaitDto {

    private TMedicalCostPersonArchivesWait wait;

    private TMedicalCostOutpatientInfo info;

    public TMedicalCostPersonArchivesWait getWait() {
        return wait;
    }

    public void setWait(TMedicalCostPersonArchivesWait wait) {
        this.wait = wait;
    }

    public TMedicalCostOutpatientInfo getInfo() {
        return info;
    }

    public void setInfo(TMedicalCostOutpatientInfo info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "WaitDto{" +
                "wait=" + wait +
                ", info=" + info +
                '}';
    }
}
