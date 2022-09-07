package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医嘱记录对象 t_medical_emr_doctorsorder
 * 
 * @author ruoyi
 * @date 2022-09-06
 */
public class TMedicalEmrDoctorsorder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 患者编号 */
    @Excel(name = "患者编号")
    private String personid;

    /** 主治医生编号 */
    @Excel(name = "主治医生编号")
    private String doctorid;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    /** 医嘱描述 */
    @Excel(name = "医嘱描述")
    private String description;



    @Excel(name = "医嘱时间")
    private String createtime;

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public TMedicalEmrDoctorsorder(String id, String personid, String doctorid, Long status, Long type, String description, String createtime) {
        this.id = id;
        this.personid = personid;
        this.doctorid = doctorid;
        this.status = status;
        this.type = type;
        this.description = description;
        this.createtime = createtime;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
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
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("personid", getPersonid())
            .append("doctorid", getDoctorid())
            .append("status", getStatus())
            .append("type", getType())
            .append("description", getDescription())
            .append("createtime", getCreateTime())
            .toString();
    }
}
