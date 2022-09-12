package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TMedicalCostDeadBill;

/**
 * 医院烂账记录Service接口
 *
 * @author ruoyi
 * @date 2022-09-06
 */
public interface ITMedicalCostDeadBillService
{
    /**
     * 查询医院烂账记录
     *
     * @param id 医院烂账记录主键
     * @return 医院烂账记录
     */
    public TMedicalCostDeadBill selectTMedicalCostDeadBillById(String id);

    /**
     * 查询医院烂账记录列表
     *
     * @param tMedicalCostDeadBill 医院烂账记录
     * @return 医院烂账记录集合
     */
    public List<TMedicalCostDeadBill> selectTMedicalCostDeadBillList(TMedicalCostDeadBill tMedicalCostDeadBill);

    /**
     * 新增医院烂账记录
     *
     * @param tMedicalCostDeadBill 医院烂账记录
     * @return 结果
     */
    public int insertTMedicalCostDeadBill(TMedicalCostDeadBill tMedicalCostDeadBill);

    /**
     * 修改医院烂账记录
     *
     * @param tMedicalCostDeadBill 医院烂账记录
     * @return 结果
     */
    public int updateTMedicalCostDeadBill(TMedicalCostDeadBill tMedicalCostDeadBill);

    /**
     * 批量删除医院烂账记录
     *
     * @param ids 需要删除的医院烂账记录主键集合
     * @return 结果
     */
    public int deleteTMedicalCostDeadBillByIds(String[] ids);

    /**
     * 删除医院烂账记录信息
     *
     * @param id 医院烂账记录主键
     * @return 结果
     */
    public int deleteTMedicalCostDeadBillById(String id);
}
