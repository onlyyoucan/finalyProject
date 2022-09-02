package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 门诊卡充值记录对象 t_medical_cost_outpatient_recharge_record
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
public class TMedicalCostOutpatientRechargeRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 门诊卡充值记录编号 */
    private String id;

    /** 金额 */
    @Excel(name = "金额")
    private Long money;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    /** 类型 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createtime;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /** 门诊卡编号 */
    @Excel(name = "门诊卡编号")
    private String outpatientid;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setMoney(Long money) 
    {
        this.money = money;
    }

    public Long getMoney() 
    {
        return money;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setOutpatientid(String outpatientid) 
    {
        this.outpatientid = outpatientid;
    }

    public String getOutpatientid() 
    {
        return outpatientid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("money", getMoney())
            .append("type", getType())
            .append("createtime", getCreatetime())
            .append("outpatientid", getOutpatientid())
            .toString();
    }
}
