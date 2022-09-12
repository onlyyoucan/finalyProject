package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.xmlbeans.GDate;

import java.util.Date;

/**
 * Lis检验信息对象 t_medical_lis_info
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
public class TMedicalLisInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 消费事项 */
    @Excel(name = "消费事项")
    private String name;

    /** 患者编号 */
    @Excel(name = "患者编号")
    private String personid;

    /** 医生编号 */
    @Excel(name = "医生编号")
    private String doctorid;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 生成日期 */
    @Excel(name = "生成日期 ")
    private Date createTime;


    /** 门诊医生接诊记录编号 */
    @Excel(name = "门诊医生接诊记录编号")
    private String receiverecordid;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPersonid(String personid) 
    {
        this.personid = personid;
    }

    public String getPersonid() 
    {
        return personid;
    }
    public void setDoctorid(String doctorid) 
    {
        this.doctorid = doctorid;
    }

    public String getDoctorid() 
    {
        return doctorid;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setReceiverecordid(String receiverecordid) 
    {
        this.receiverecordid = receiverecordid;
    }

    public String getReceiverecordid() 
    {
        return receiverecordid;
    }




    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("personid", getPersonid())
            .append("doctorid", getDoctorid())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .append("receiverecordid", getReceiverecordid())
            .toString();
    }
}
