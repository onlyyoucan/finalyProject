package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.TMedicalCostPersonArchives;
import com.ruoyi.system.domain.TMedicalCostPersonArchivesWait;
import com.ruoyi.system.domain.dto.JiandangDto;
import com.ruoyi.system.domain.dto.WaitDto;
import com.ruoyi.system.mapper.TMedicalCostPersonArchivesMapper;
import com.ruoyi.system.mapper.TMedicalCostPersonArchivesWaitMapper;
import com.ruoyi.system.service.ITMedicalCostPersonArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalCostOutpatientInfoMapper;
import com.ruoyi.system.domain.TMedicalCostOutpatientInfo;
import com.ruoyi.system.service.ITMedicalCostOutpatientInfoService;

import javax.annotation.Resource;

/**
 * 门诊卡信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-01
 */
@Service
public class TMedicalCostOutpatientInfoServiceImpl implements ITMedicalCostOutpatientInfoService 
{
    @Resource
    private TMedicalCostOutpatientInfoMapper tMedicalCostOutpatientInfoMapper;
    @Resource
    private TMedicalCostPersonArchivesMapper tMedicalCostPersonArchivesMapper;
    @Resource
    private TMedicalCostPersonArchivesWaitMapper tmedicalCostPersonArchivesMapper;

    /**
     * 查询门诊卡信息
     * 
     * @param id 门诊卡信息主键
     * @return 门诊卡信息
     */
    @Override
    public TMedicalCostOutpatientInfo selectTMedicalCostOutpatientInfoById(Long id)
    {
        return tMedicalCostOutpatientInfoMapper.selectTMedicalCostOutpatientInfoById(id);
    }

    /**
     * 查询门诊卡信息列表
     * 
     * @param tMedicalCostOutpatientInfo 门诊卡信息
     * @return 门诊卡信息
     */
    @Override
    public List<TMedicalCostOutpatientInfo> selectTMedicalCostOutpatientInfoList(TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        return tMedicalCostOutpatientInfoMapper.selectTMedicalCostOutpatientInfoList(tMedicalCostOutpatientInfo);
    }

    /**
     * 新增门诊卡信息
     * 
     * @param tMedicalCostOutpatientInfo 门诊卡信息
     * @return 结果
     */
    @Override
    public int insertTMedicalCostOutpatientInfo(TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        return tMedicalCostOutpatientInfoMapper.insertTMedicalCostOutpatientInfo(tMedicalCostOutpatientInfo);
    }

    /**
     * 修改门诊卡信息
     * 
     * @param tMedicalCostOutpatientInfo 门诊卡信息
     * @return 结果
     */
    @Override
    public int updateTMedicalCostOutpatientInfo(TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        return tMedicalCostOutpatientInfoMapper.updateTMedicalCostOutpatientInfo(tMedicalCostOutpatientInfo);
    }

    /**
     * 批量删除门诊卡信息
     * 
     * @param ids 需要删除的门诊卡信息主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostOutpatientInfoByIds(Long[] ids)
    {
        return tMedicalCostOutpatientInfoMapper.deleteTMedicalCostOutpatientInfoByIds(ids);
    }

    /**
     * 删除门诊卡信息信息
     * 
     * @param id 门诊卡信息主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostOutpatientInfoById(Long id)
    {
        return tMedicalCostOutpatientInfoMapper.deleteTMedicalCostOutpatientInfoById(id);
    }

    @Override
    public int Jiandang(TMedicalCostPersonArchives tMedicalCostPersonArchives) {
        return tMedicalCostPersonArchivesMapper.insertTMedicalCostPersonArchives(tMedicalCostPersonArchives);
    }

    @Override
    public int wait(TMedicalCostPersonArchivesWait tMedicalCostPersonArchivesWait) {
        return tmedicalCostPersonArchivesMapper.insertTMedicalCostPersonArchivesWait(tMedicalCostPersonArchivesWait);
    }
}
