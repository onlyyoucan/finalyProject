package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TMedicalCostOutpatientRechargeRecord;

/**
 * 门诊卡充值记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
public interface TMedicalCostOutpatientRechargeRecordMapper 
{
    /**
     * 查询门诊卡充值记录
     * 
     * @param id 门诊卡充值记录主键
     * @return 门诊卡充值记录
     */
    public TMedicalCostOutpatientRechargeRecord selectTMedicalCostOutpatientRechargeRecordById(String id);

    /**
     * 查询门诊卡充值记录列表
     * 
     * @param tMedicalCostOutpatientRechargeRecord 门诊卡充值记录
     * @return 门诊卡充值记录集合
     */
    public List<TMedicalCostOutpatientRechargeRecord> selectTMedicalCostOutpatientRechargeRecordList(TMedicalCostOutpatientRechargeRecord tMedicalCostOutpatientRechargeRecord);

    /**
     * 新增门诊卡充值记录
     * 
     * @param tMedicalCostOutpatientRechargeRecord 门诊卡充值记录
     * @return 结果
     */
    public int insertTMedicalCostOutpatientRechargeRecord(TMedicalCostOutpatientRechargeRecord tMedicalCostOutpatientRechargeRecord);

    /**
     * 修改门诊卡充值记录
     * 
     * @param tMedicalCostOutpatientRechargeRecord 门诊卡充值记录
     * @return 结果
     */
    public int updateTMedicalCostOutpatientRechargeRecord(TMedicalCostOutpatientRechargeRecord tMedicalCostOutpatientRechargeRecord);

    /**
     * 删除门诊卡充值记录
     * 
     * @param id 门诊卡充值记录主键
     * @return 结果
     */
    public int deleteTMedicalCostOutpatientRechargeRecordById(String id);

    /**
     * 批量删除门诊卡充值记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTMedicalCostOutpatientRechargeRecordByIds(String[] ids);
}
