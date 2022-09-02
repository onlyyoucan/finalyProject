package com.ruoyi.system.controller;

import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.TMedicalCostOutpatientRechargeRecord;
import com.ruoyi.system.domain.TMedicalCostPersonArchives;
import com.ruoyi.system.domain.dto.JiandangDto;
import com.ruoyi.system.service.ITMedicalCostOutpatientRechargeRecordService;
import com.ruoyi.system.service.ITMedicalCostPersonArchivesService;
import com.ruoyi.system.service.ITMedicalCostPersonArchivesWaitService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TMedicalCostOutpatientInfo;
import com.ruoyi.system.service.ITMedicalCostOutpatientInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 门诊卡信息Controller
 * 
 * @author ruoyi
 * @date 2022-09-01
 */
@RestController
@RequestMapping("/system/info")
public class TMedicalCostOutpatientInfoController extends BaseController
{
    @Autowired
    private ITMedicalCostOutpatientInfoService tMedicalCostOutpatientInfoService;

    @Autowired
    private ITMedicalCostOutpatientRechargeRecordService tMedicalCostOutpatientRechargeRecordService;


    /**
     * 查询门诊卡信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        startPage();
        List<TMedicalCostOutpatientInfo> list = tMedicalCostOutpatientInfoService.selectTMedicalCostOutpatientInfoList(tMedicalCostOutpatientInfo);
        return getDataTable(list);
    }

    /**
     * 导出门诊卡信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "门诊卡信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        List<TMedicalCostOutpatientInfo> list = tMedicalCostOutpatientInfoService.selectTMedicalCostOutpatientInfoList(tMedicalCostOutpatientInfo);
        ExcelUtil<TMedicalCostOutpatientInfo> util = new ExcelUtil<TMedicalCostOutpatientInfo>(TMedicalCostOutpatientInfo.class);
        util.exportExcel(response, list, "门诊卡信息数据");
    }

    /**
     * 获取门诊卡信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tMedicalCostOutpatientInfoService.selectTMedicalCostOutpatientInfoById(id));
    }

    /**
     * 新增门诊卡信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "门诊卡信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        return toAjax(tMedicalCostOutpatientInfoService.insertTMedicalCostOutpatientInfo(tMedicalCostOutpatientInfo));
    }

    /**
     * 新增门诊卡充值记录
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "个人档案信息", businessType = BusinessType.INSERT)
    @RequestMapping("/jiandang")
    public AjaxResult jiandang(@RequestBody TMedicalCostOutpatientRechargeRecord tMedicalCostOutpatientRechargeRecord)
    {
        tMedicalCostOutpatientRechargeRecord.setId(UUID.randomUUID().toString().replace("-", ""));
        TMedicalCostOutpatientInfo info = tMedicalCostOutpatientInfoService.selectTMedicalCostOutpatientInfoById(Long.parseLong(tMedicalCostOutpatientRechargeRecord.getOutpatientid()));
        if(tMedicalCostOutpatientRechargeRecord.getType() == 1){
            info.setMoney(info.getMoney()+tMedicalCostOutpatientRechargeRecord.getMoney());
        }else{
            info.setMoney(info.getMoney()-tMedicalCostOutpatientRechargeRecord.getMoney());
        }
        tMedicalCostOutpatientInfoService.updateTMedicalCostOutpatientInfo(info);
        return toAjax(tMedicalCostOutpatientRechargeRecordService.insertTMedicalCostOutpatientRechargeRecord(tMedicalCostOutpatientRechargeRecord));
    }

    /**
     * 修改门诊卡信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "门诊卡信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        return toAjax(tMedicalCostOutpatientInfoService.updateTMedicalCostOutpatientInfo(tMedicalCostOutpatientInfo));
    }

    /**
     * 删除门诊卡信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "门诊卡信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tMedicalCostOutpatientInfoService.deleteTMedicalCostOutpatientInfoByIds(ids));
    }
}
