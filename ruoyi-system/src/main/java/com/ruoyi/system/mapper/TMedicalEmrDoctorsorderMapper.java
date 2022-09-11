package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TMedicalEmrDoctorsorder;

/**
 * 医嘱记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-06
 */
public interface TMedicalEmrDoctorsorderMapper 
{
    /**
     * 查询医嘱记录
     * 
     * @param id 医嘱记录主键
     * @return 医嘱记录
     */
    public TMedicalEmrDoctorsorder selectTMedicalEmrDoctorsorderById(String id);

    /**
     * 查询医嘱记录列表
     * 
     * @param tMedicalEmrDoctorsorder 医嘱记录
     * @return 医嘱记录集合
     */
    public List<TMedicalEmrDoctorsorder> selectTMedicalEmrDoctorsorderList(TMedicalEmrDoctorsorder tMedicalEmrDoctorsorder);

    /**
     * 新增医嘱记录
     * 
     * @param tMedicalEmrDoctorsorder 医嘱记录
     * @return 结果
     */
    public int insertTMedicalEmrDoctorsorder(TMedicalEmrDoctorsorder tMedicalEmrDoctorsorder);

    /**
     * 修改医嘱记录
     * 
     * @param tMedicalEmrDoctorsorder 医嘱记录
     * @return 结果
     */
    public int updateTMedicalEmrDoctorsorder(TMedicalEmrDoctorsorder tMedicalEmrDoctorsorder);

    /**
     * 删除医嘱记录
     * 
     * @param id 医嘱记录主键
     * @return 结果
     */
    public int deleteTMedicalEmrDoctorsorderById(String id);

    /**
     * 批量删除医嘱记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTMedicalEmrDoctorsorderByIds(String[] ids);
}
