package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalCostDeadBillMapper;
import com.ruoyi.system.domain.TMedicalCostDeadBill;
import com.ruoyi.system.service.ITMedicalCostDeadBillService;

/**
 * 医院烂账记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
@Service
public class TMedicalCostDeadBillServiceImpl implements ITMedicalCostDeadBillService 
{
    @Autowired
    private TMedicalCostDeadBillMapper tMedicalCostDeadBillMapper;

    /**
     * 查询医院烂账记录
     * 
     * @param id 医院烂账记录主键
     * @return 医院烂账记录
     */
    @Override
    public TMedicalCostDeadBill selectTMedicalCostDeadBillById(String id)
    {
        return tMedicalCostDeadBillMapper.selectTMedicalCostDeadBillById(id);
    }

    /**
     * 查询医院烂账记录列表
     * 
     * @param tMedicalCostDeadBill 医院烂账记录
     * @return 医院烂账记录
     */
    @Override
    public List<TMedicalCostDeadBill> selectTMedicalCostDeadBillList(TMedicalCostDeadBill tMedicalCostDeadBill)
    {
        return tMedicalCostDeadBillMapper.selectTMedicalCostDeadBillList(tMedicalCostDeadBill);
    }

    /**
     * 新增医院烂账记录
     * 
     * @param tMedicalCostDeadBill 医院烂账记录
     * @return 结果
     */
    @Override
    public int insertTMedicalCostDeadBill(TMedicalCostDeadBill tMedicalCostDeadBill)
    {
        return tMedicalCostDeadBillMapper.insertTMedicalCostDeadBill(tMedicalCostDeadBill);
    }

    /**
     * 修改医院烂账记录
     * 
     * @param tMedicalCostDeadBill 医院烂账记录
     * @return 结果
     */
    @Override
    public int updateTMedicalCostDeadBill(TMedicalCostDeadBill tMedicalCostDeadBill)
    {
        return tMedicalCostDeadBillMapper.updateTMedicalCostDeadBill(tMedicalCostDeadBill);
    }

    /**
     * 批量删除医院烂账记录
     * 
     * @param ids 需要删除的医院烂账记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostDeadBillByIds(String[] ids)
    {
        return tMedicalCostDeadBillMapper.deleteTMedicalCostDeadBillByIds(ids);
    }

    /**
     * 删除医院烂账记录信息
     * 
     * @param id 医院烂账记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostDeadBillById(String id)
    {
        return tMedicalCostDeadBillMapper.deleteTMedicalCostDeadBillById(id);
    }
}
