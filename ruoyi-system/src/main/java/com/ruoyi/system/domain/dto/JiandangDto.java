package com.ruoyi.system.domain.dto;

import com.ruoyi.system.domain.TMedicalCostOutpatientInfo;
import com.ruoyi.system.domain.TMedicalCostPersonArchives;

public class JiandangDto {
    private TMedicalCostOutpatientInfo outpatientInfo;

    private TMedicalCostPersonArchives archives;

    public JiandangDto() {

    }

    public TMedicalCostOutpatientInfo getOutpatientInfo() {
        return outpatientInfo;
    }

    public void setOutpatientInfo(TMedicalCostOutpatientInfo outpatientInfo) {
        this.outpatientInfo = outpatientInfo;
    }

    public TMedicalCostPersonArchives getArchives() {
        return archives;
    }

    public void setArchives(TMedicalCostPersonArchives archives) {
        this.archives = archives;
    }

    @Override
    public String toString() {
        return "JiandangDto{" +
                "outpatientInfo=" + outpatientInfo +
                ", archives=" + archives +
                '}';
    }
}
