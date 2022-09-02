package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalCostPersonArchivesWaitMapper;
import com.ruoyi.system.domain.TMedicalCostPersonArchivesWait;
import com.ruoyi.system.service.ITMedicalCostPersonArchivesWaitService;

import javax.annotation.Resource;

/**
 * 候诊室Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
@Service
public class TMedicalCostPersonArchivesWaitServiceImpl implements ITMedicalCostPersonArchivesWaitService 
{
    @Resource
    private TMedicalCostPersonArchivesWaitMapper tMedicalCostPersonArchivesWaitMapper;

    /**
     * 查询候诊室
     * 
     * @param id 候诊室主键
     * @return 候诊室
     */
    @Override
    public TMedicalCostPersonArchivesWait selectTMedicalCostPersonArchivesWaitById(String id)
    {
        return tMedicalCostPersonArchivesWaitMapper.selectTMedicalCostPersonArchivesWaitById(id);
    }

    /**
     * 查询候诊室列表
     * 
     * @param tMedicalCostPersonArchivesWait 候诊室
     * @return 候诊室
     */
    @Override
    public List<TMedicalCostPersonArchivesWait> selectTMedicalCostPersonArchivesWaitList(TMedicalCostPersonArchivesWait tMedicalCostPersonArchivesWait)
    {
        return tMedicalCostPersonArchivesWaitMapper.selectTMedicalCostPersonArchivesWaitList(tMedicalCostPersonArchivesWait);
    }

    /**
     * 新增候诊室
     * 
     * @param tMedicalCostPersonArchivesWait 候诊室
     * @return 结果
     */
    @Override
    public int insertTMedicalCostPersonArchivesWait(TMedicalCostPersonArchivesWait tMedicalCostPersonArchivesWait)
    {
        return tMedicalCostPersonArchivesWaitMapper.insertTMedicalCostPersonArchivesWait(tMedicalCostPersonArchivesWait);
    }

    /**
     * 修改候诊室
     * 
     * @param tMedicalCostPersonArchivesWait 候诊室
     * @return 结果
     */
    @Override
    public int updateTMedicalCostPersonArchivesWait(TMedicalCostPersonArchivesWait tMedicalCostPersonArchivesWait)
    {
        return tMedicalCostPersonArchivesWaitMapper.updateTMedicalCostPersonArchivesWait(tMedicalCostPersonArchivesWait);
    }

    /**
     * 批量删除候诊室
     * 
     * @param ids 需要删除的候诊室主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostPersonArchivesWaitByIds(String[] ids)
    {
        return tMedicalCostPersonArchivesWaitMapper.deleteTMedicalCostPersonArchivesWaitByIds(ids);
    }

    /**
     * 删除候诊室信息
     * 
     * @param id 候诊室主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostPersonArchivesWaitById(String id)
    {
        return tMedicalCostPersonArchivesWaitMapper.deleteTMedicalCostPersonArchivesWaitById(id);
    }
}
