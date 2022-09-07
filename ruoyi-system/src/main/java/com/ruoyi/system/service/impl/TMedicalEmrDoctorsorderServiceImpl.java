package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalEmrDoctorsorderMapper;
import com.ruoyi.system.domain.TMedicalEmrDoctorsorder;
import com.ruoyi.system.service.ITMedicalEmrDoctorsorderService;

/**
 * 医嘱记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-06
 */
@Service
public class TMedicalEmrDoctorsorderServiceImpl implements ITMedicalEmrDoctorsorderService 
{
    @Autowired
    private TMedicalEmrDoctorsorderMapper tMedicalEmrDoctorsorderMapper;

    /**
     * 查询医嘱记录
     * 
     * @param id 医嘱记录主键
     * @return 医嘱记录
     */
    @Override
    public TMedicalEmrDoctorsorder selectTMedicalEmrDoctorsorderById(String id)
    {
        return tMedicalEmrDoctorsorderMapper.selectTMedicalEmrDoctorsorderById(id);
    }

    /**
     * 查询医嘱记录列表
     * 
     * @param tMedicalEmrDoctorsorder 医嘱记录
     * @return 医嘱记录
     */
    @Override
    public List<TMedicalEmrDoctorsorder> selectTMedicalEmrDoctorsorderList(TMedicalEmrDoctorsorder tMedicalEmrDoctorsorder)
    {
        return tMedicalEmrDoctorsorderMapper.selectTMedicalEmrDoctorsorderList(tMedicalEmrDoctorsorder);
    }

    /**
     * 新增医嘱记录
     * 
     * @param tMedicalEmrDoctorsorder 医嘱记录
     * @return 结果
     */
    @Override
    public int insertTMedicalEmrDoctorsorder(TMedicalEmrDoctorsorder tMedicalEmrDoctorsorder)
    {
        return tMedicalEmrDoctorsorderMapper.insertTMedicalEmrDoctorsorder(tMedicalEmrDoctorsorder);
    }

    /**
     * 修改医嘱记录
     * 
     * @param tMedicalEmrDoctorsorder 医嘱记录
     * @return 结果
     */
    @Override
    public int updateTMedicalEmrDoctorsorder(TMedicalEmrDoctorsorder tMedicalEmrDoctorsorder)
    {
        return tMedicalEmrDoctorsorderMapper.updateTMedicalEmrDoctorsorder(tMedicalEmrDoctorsorder);
    }

    /**
     * 批量删除医嘱记录
     * 
     * @param ids 需要删除的医嘱记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalEmrDoctorsorderByIds(String[] ids)
    {
        return tMedicalEmrDoctorsorderMapper.deleteTMedicalEmrDoctorsorderByIds(ids);
    }

    /**
     * 删除医嘱记录信息
     * 
     * @param id 医嘱记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalEmrDoctorsorderById(String id)
    {
        return tMedicalEmrDoctorsorderMapper.deleteTMedicalEmrDoctorsorderById(id);
    }
}
