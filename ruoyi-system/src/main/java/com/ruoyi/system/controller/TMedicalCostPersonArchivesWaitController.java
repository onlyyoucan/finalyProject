package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TMedicalCostPersonArchivesWait;
import com.ruoyi.system.service.ITMedicalCostPersonArchivesWaitService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 候诊室Controller
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
@RestController
@RequestMapping("/system/wait")
public class TMedicalCostPersonArchivesWaitController extends BaseController
{
    @Autowired
    private ITMedicalCostPersonArchivesWaitService tMedicalCostPersonArchivesWaitService;

    /**
     * 查询候诊室列表
     */
    @PreAuthorize("@ss.hasPermi('system:wait:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalCostPersonArchivesWait tMedicalCostPersonArchivesWait)
    {
        startPage();
        List<TMedicalCostPersonArchivesWait> list = tMedicalCostPersonArchivesWaitService.selectTMedicalCostPersonArchivesWaitList(tMedicalCostPersonArchivesWait);
        return getDataTable(list);
    }

    /**
     * 导出候诊室列表
     */
    @PreAuthorize("@ss.hasPermi('system:wait:export')")
    @Log(title = "候诊室", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMedicalCostPersonArchivesWait tMedicalCostPersonArchivesWait)
    {
        List<TMedicalCostPersonArchivesWait> list = tMedicalCostPersonArchivesWaitService.selectTMedicalCostPersonArchivesWaitList(tMedicalCostPersonArchivesWait);
        ExcelUtil<TMedicalCostPersonArchivesWait> util = new ExcelUtil<TMedicalCostPersonArchivesWait>(TMedicalCostPersonArchivesWait.class);
        util.exportExcel(response, list, "候诊室数据");
    }

    /**
     * 获取候诊室详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:wait:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalCostPersonArchivesWaitService.selectTMedicalCostPersonArchivesWaitById(id));
    }

    /**
     * 新增候诊室
     */
    @PreAuthorize("@ss.hasPermi('system:wait:add')")
    @Log(title = "候诊室", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalCostPersonArchivesWait tMedicalCostPersonArchivesWait)
    {
        return toAjax(tMedicalCostPersonArchivesWaitService.insertTMedicalCostPersonArchivesWait(tMedicalCostPersonArchivesWait));
    }

    /**
     * 修改候诊室
     */
    @PreAuthorize("@ss.hasPermi('system:wait:edit')")
    @Log(title = "候诊室", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalCostPersonArchivesWait tMedicalCostPersonArchivesWait)
    {
        return toAjax(tMedicalCostPersonArchivesWaitService.updateTMedicalCostPersonArchivesWait(tMedicalCostPersonArchivesWait));
    }

    /**
     * 删除候诊室
     */
    @PreAuthorize("@ss.hasPermi('system:wait:remove')")
    @Log(title = "候诊室", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalCostPersonArchivesWaitService.deleteTMedicalCostPersonArchivesWaitByIds(ids));
    }
}
