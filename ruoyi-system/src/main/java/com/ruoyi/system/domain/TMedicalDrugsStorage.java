package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 药库库存对象 t_medical_drugs_storage
 * 
 * @author ruoyi
 * @date 2022-09-12
 */
public class TMedicalDrugsStorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 药品名称编号 */
    @Excel(name = "药品名称编号")
    private String drugsid;

    /** 数量 */
    @Excel(name = "数量")
    private Long no;

    /** 生成时间*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatetime;

    /** 操作人 */
    @Excel(name = "操作人")
    private String player;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setDrugsid(String drugsid) 
    {
        this.drugsid = drugsid;
    }

    public String getDrugsid() 
    {
        return drugsid;
    }
    public void setNo(Long no) 
    {
        this.no = no;
    }

    public Long getNo() 
    {
        return no;
    }
    public void setUpdatetime(Date updatetime){this.updatetime = updatetime; }

    public Date getUpdatetime(){return updatetime;}
    public void setPlayer(String player) 
    {
        this.player = player;
    }

    public String getPlayer() 
    {
        return player;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("drugsid", getDrugsid())
            .append("no", getNo())
            .append("updatetime", getUpdatetime())
            .append("player", getPlayer())
            .toString();
    }
}
