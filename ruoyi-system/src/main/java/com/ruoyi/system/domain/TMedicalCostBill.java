package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 患者费用账单对象 t_medical_cost_bill
 *
 * @author ruoyi
 * @date 2022-09-02
 */
public class TMedicalCostBill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 患者费用账单编号 */
    private String id;

    /** 门诊卡id */
    @Excel(name = "门诊卡id")
    private String outpatientid;

    /** 金额 */
    @Excel(name = "金额")
    private Long money;

    /** 充值取现日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "充值取现日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createtime;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setOutpatientid(String outpatientid)
    {
        this.outpatientid = outpatientid;
    }

    public String getOutpatientid()
    {
        return outpatientid;
    }
    public void setMoney(Long money)
    {
        this.money = money;
    }

    public Long getMoney()
    {
        return money;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("outpatientid", getOutpatientid())
                .append("money", getMoney())
                .append("createtime", getCreatetime())
                .toString();
    }
}
