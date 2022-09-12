package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 药品对象 t_medical_drugs_info
 * 
 * @author ruoyi
 * @date 2022-09-11
 */
public class TMedicalDrugsInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String name;

    /** 规格 */
    @Excel(name = "规格")
    private String specifications;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 药品描述 */
    @Excel(name = "药品描述")
    private String description;

    /** 采购人 */
    @Excel(name = "采购人")
    private String operator;

    /** 生成时间*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createtime;


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
    public void setSpecifications(String specifications) 
    {
        this.specifications = specifications;
    }

    public String getSpecifications() 
    {
        return specifications;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }
    public void setCreatetime(Date createtime){this.createtime = createtime; }

    public Date getCreatetime(){return createtime;}


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("specifications", getSpecifications())
            .append("unit", getUnit())
            .append("description", getDescription())
            .append("operator", getOperator())
            .append("createtime", getCreatetime())
            .toString();
    }
}
