package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalCostBillMapper;
import com.ruoyi.system.domain.TMedicalCostBill;
import com.ruoyi.system.service.ITMedicalCostBillService;

/**
 * 患者费用账单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
@Service
public class TMedicalCostBillServiceImpl implements ITMedicalCostBillService 
{
    @Autowired
    private TMedicalCostBillMapper tMedicalCostBillMapper;

    /**
     * 查询患者费用账单
     * 
     * @param id 患者费用账单主键
     * @return 患者费用账单
     */
    @Override
    public TMedicalCostBill selectTMedicalCostBillById(String id)
    {
        return tMedicalCostBillMapper.selectTMedicalCostBillById(id);
    }

    /**
     * 查询患者费用账单列表
     * 
     * @param tMedicalCostBill 患者费用账单
     * @return 患者费用账单
     */
    @Override
    public List<TMedicalCostBill> selectTMedicalCostBillList(TMedicalCostBill tMedicalCostBill)
    {
        return tMedicalCostBillMapper.selectTMedicalCostBillList(tMedicalCostBill);
    }

    /**
     * 新增患者费用账单
     * 
     * @param tMedicalCostBill 患者费用账单
     * @return 结果
     */
    @Override
    public int insertTMedicalCostBill(TMedicalCostBill tMedicalCostBill)
    {
        return tMedicalCostBillMapper.insertTMedicalCostBill(tMedicalCostBill);
    }

    /**
     * 修改患者费用账单
     * 
     * @param tMedicalCostBill 患者费用账单
     * @return 结果
     */
    @Override
    public int updateTMedicalCostBill(TMedicalCostBill tMedicalCostBill)
    {
        return tMedicalCostBillMapper.updateTMedicalCostBill(tMedicalCostBill);
    }

    /**
     * 批量删除患者费用账单
     * 
     * @param ids 需要删除的患者费用账单主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostBillByIds(String[] ids)
    {
        return tMedicalCostBillMapper.deleteTMedicalCostBillByIds(ids);
    }

    /**
     * 删除患者费用账单信息
     * 
     * @param id 患者费用账单主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostBillById(String id)
    {
        return tMedicalCostBillMapper.deleteTMedicalCostBillById(id);
    }
}
