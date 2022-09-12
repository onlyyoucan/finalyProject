package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalLisInfoMapper;
import com.ruoyi.system.domain.TMedicalLisInfo;
import com.ruoyi.system.service.ITMedicalLisInfoService;

/**
 * Lis检验信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
@Service
public class TMedicalLisInfoServiceImpl implements ITMedicalLisInfoService 
{
    @Autowired
    private TMedicalLisInfoMapper tMedicalLisInfoMapper;

    /**
     * 查询Lis检验信息
     * 
     * @param id Lis检验信息主键
     * @return Lis检验信息
     */
    @Override
    public TMedicalLisInfo selectTMedicalLisInfoById(String id)
    {
        return tMedicalLisInfoMapper.selectTMedicalLisInfoById(id);
    }

    /**
     * 查询Lis检验信息列表
     * 
     * @param tMedicalLisInfo Lis检验信息
     * @return Lis检验信息
     */
    @Override
    public List<TMedicalLisInfo> selectTMedicalLisInfoList(TMedicalLisInfo tMedicalLisInfo)
    {
        return tMedicalLisInfoMapper.selectTMedicalLisInfoList(tMedicalLisInfo);
    }

    /**
     * 新增Lis检验信息
     * 
     * @param tMedicalLisInfo Lis检验信息
     * @return 结果
     */
    @Override
    public int insertTMedicalLisInfo(TMedicalLisInfo tMedicalLisInfo)
    {
        return tMedicalLisInfoMapper.insertTMedicalLisInfo(tMedicalLisInfo);
    }

    /**
     * 修改Lis检验信息
     * 
     * @param tMedicalLisInfo Lis检验信息
     * @return 结果
     */
    @Override
    public int updateTMedicalLisInfo(TMedicalLisInfo tMedicalLisInfo)
    {
        return tMedicalLisInfoMapper.updateTMedicalLisInfo(tMedicalLisInfo);
    }

    /**
     * 批量删除Lis检验信息
     * 
     * @param ids 需要删除的Lis检验信息主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalLisInfoByIds(String[] ids)
    {
        return tMedicalLisInfoMapper.deleteTMedicalLisInfoByIds(ids);
    }

    /**
     * 删除Lis检验信息信息
     * 
     * @param id Lis检验信息主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalLisInfoById(String id)
    {
        return tMedicalLisInfoMapper.deleteTMedicalLisInfoById(id);
    }
}
