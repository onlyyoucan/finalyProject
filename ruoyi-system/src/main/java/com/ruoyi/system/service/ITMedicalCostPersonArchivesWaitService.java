package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TMedicalCostPersonArchivesWait;

/**
 * 候诊室Service接口
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
public interface ITMedicalCostPersonArchivesWaitService 
{
    /**
     * 查询候诊室
     * 
     * @param id 候诊室主键
     * @return 候诊室
     */
    public TMedicalCostPersonArchivesWait selectTMedicalCostPersonArchivesWaitById(String id);

    /**
     * 查询候诊室列表
     * 
     * @param tMedicalCostPersonArchivesWait 候诊室
     * @return 候诊室集合
     */
    public List<TMedicalCostPersonArchivesWait> selectTMedicalCostPersonArchivesWaitList(TMedicalCostPersonArchivesWait tMedicalCostPersonArchivesWait);

    /**
     * 新增候诊室
     * 
     * @param tMedicalCostPersonArchivesWait 候诊室
     * @return 结果
     */
    public int insertTMedicalCostPersonArchivesWait(TMedicalCostPersonArchivesWait tMedicalCostPersonArchivesWait);

    /**
     * 修改候诊室
     * 
     * @param tMedicalCostPersonArchivesWait 候诊室
     * @return 结果
     */
    public int updateTMedicalCostPersonArchivesWait(TMedicalCostPersonArchivesWait tMedicalCostPersonArchivesWait);

    /**
     * 批量删除候诊室
     * 
     * @param ids 需要删除的候诊室主键集合
     * @return 结果
     */
    public int deleteTMedicalCostPersonArchivesWaitByIds(String[] ids);

    /**
     * 删除候诊室信息
     * 
     * @param id 候诊室主键
     * @return 结果
     */
    public int deleteTMedicalCostPersonArchivesWaitById(String id);
}
