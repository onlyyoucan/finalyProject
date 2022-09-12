package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 医院烂账记录对象 t_medical_cost_dead_bill
 *
 * @author ruoyi
 * @date 2022-09-06
 */
public class TMedicalCostDeadBill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 医院烂账记录id */
    private String id;

    /** 实收金额 */
    @Excel(name = "实收金额")
    private Long realnoney;

    /** 账上金额 */
    @Excel(name = "账上金额")
    private Long accountmoney;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String username;

    /** 烂账记录日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "烂账记录日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createtime;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setRealnoney(Long realnoney)
    {
        this.realnoney = realnoney;
    }

    public Long getRealnoney()
    {
        return realnoney;
    }
    public void setAccountmoney(Long accountmoney)
    {
        this.accountmoney = accountmoney;
    }

    public Long getAccountmoney()
    {
        return accountmoney;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
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
                .append("realNoney", getRealnoney())
                .append("accountMoney", getAccountmoney())
                .append("userName", getUsername())
                .append("createTime", getCreatetime())
                .toString();
    }
}
