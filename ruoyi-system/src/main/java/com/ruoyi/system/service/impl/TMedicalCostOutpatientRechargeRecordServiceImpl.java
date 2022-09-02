package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalCostOutpatientRechargeRecordMapper;
import com.ruoyi.system.domain.TMedicalCostOutpatientRechargeRecord;
import com.ruoyi.system.service.ITMedicalCostOutpatientRechargeRecordService;

import javax.annotation.Resource;

/**
 * 门诊卡充值记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
@Service
public class TMedicalCostOutpatientRechargeRecordServiceImpl implements ITMedicalCostOutpatientRechargeRecordService 
{
    @Resource
    private TMedicalCostOutpatientRechargeRecordMapper tMedicalCostOutpatientRechargeRecordMapper;

    /**
     * 查询门诊卡充值记录
     * 
     * @param id 门诊卡充值记录主键
     * @return 门诊卡充值记录
     */
    @Override
    public TMedicalCostOutpatientRechargeRecord selectTMedicalCostOutpatientRechargeRecordById(String id)
    {
        return tMedicalCostOutpatientRechargeRecordMapper.selectTMedicalCostOutpatientRechargeRecordById(id);
    }

    /**
     * 查询门诊卡充值记录列表
     * 
     * @param tMedicalCostOutpatientRechargeRecord 门诊卡充值记录
     * @return 门诊卡充值记录
     */
    @Override
    public List<TMedicalCostOutpatientRechargeRecord> selectTMedicalCostOutpatientRechargeRecordList(TMedicalCostOutpatientRechargeRecord tMedicalCostOutpatientRechargeRecord)
    {
        return tMedicalCostOutpatientRechargeRecordMapper.selectTMedicalCostOutpatientRechargeRecordList(tMedicalCostOutpatientRechargeRecord);
    }

    /**
     * 新增门诊卡充值记录
     * 
     * @param tMedicalCostOutpatientRechargeRecord 门诊卡充值记录
     * @return 结果
     */
    @Override
    public int insertTMedicalCostOutpatientRechargeRecord(TMedicalCostOutpatientRechargeRecord tMedicalCostOutpatientRechargeRecord)
    {
        return tMedicalCostOutpatientRechargeRecordMapper.insertTMedicalCostOutpatientRechargeRecord(tMedicalCostOutpatientRechargeRecord);
    }

    /**
     * 修改门诊卡充值记录
     * 
     * @param tMedicalCostOutpatientRechargeRecord 门诊卡充值记录
     * @return 结果
     */
    @Override
    public int updateTMedicalCostOutpatientRechargeRecord(TMedicalCostOutpatientRechargeRecord tMedicalCostOutpatientRechargeRecord)
    {
        return tMedicalCostOutpatientRechargeRecordMapper.updateTMedicalCostOutpatientRechargeRecord(tMedicalCostOutpatientRechargeRecord);
    }

    /**
     * 批量删除门诊卡充值记录
     * 
     * @param ids 需要删除的门诊卡充值记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostOutpatientRechargeRecordByIds(String[] ids)
    {
        return tMedicalCostOutpatientRechargeRecordMapper.deleteTMedicalCostOutpatientRechargeRecordByIds(ids);
    }

    /**
     * 删除门诊卡充值记录信息
     * 
     * @param id 门诊卡充值记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostOutpatientRechargeRecordById(String id)
    {
        return tMedicalCostOutpatientRechargeRecordMapper.deleteTMedicalCostOutpatientRechargeRecordById(id);
    }


}
