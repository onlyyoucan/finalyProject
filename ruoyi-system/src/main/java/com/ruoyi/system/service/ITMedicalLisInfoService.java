package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TMedicalLisInfo;

/**
 * Lis检验信息Service接口
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
public interface ITMedicalLisInfoService 
{
    /**
     * 查询Lis检验信息
     * 
     * @param id Lis检验信息主键
     * @return Lis检验信息
     */
    public TMedicalLisInfo selectTMedicalLisInfoById(String id);

    /**
     * 查询Lis检验信息列表
     * 
     * @param tMedicalLisInfo Lis检验信息
     * @return Lis检验信息集合
     */
    public List<TMedicalLisInfo> selectTMedicalLisInfoList(TMedicalLisInfo tMedicalLisInfo);

    /**
     * 新增Lis检验信息
     * 
     * @param tMedicalLisInfo Lis检验信息
     * @return 结果
     */
    public int insertTMedicalLisInfo(TMedicalLisInfo tMedicalLisInfo);

    /**
     * 修改Lis检验信息
     * 
     * @param tMedicalLisInfo Lis检验信息
     * @return 结果
     */
    public int updateTMedicalLisInfo(TMedicalLisInfo tMedicalLisInfo);

    /**
     * 批量删除Lis检验信息
     * 
     * @param ids 需要删除的Lis检验信息主键集合
     * @return 结果
     */
    public int deleteTMedicalLisInfoByIds(String[] ids);

    /**
     * 删除Lis检验信息信息
     * 
     * @param id Lis检验信息主键
     * @return 结果
     */
    public int deleteTMedicalLisInfoById(String id);
}
