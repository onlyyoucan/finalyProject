package com.ruoyi.system.controller;

import java.util.List;
import java.util.UUID;
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
import com.ruoyi.system.domain.TMedicalDrugsInfo;
import com.ruoyi.system.service.ITMedicalDrugsInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药品Controller
 * 
 * @author ruoyi
 * @date 2022-09-11
 */
@RestController
@RequestMapping("/system/pharmacy/info")
public class TMedicalDrugsInfoController extends BaseController
{
    @Autowired
    private ITMedicalDrugsInfoService tMedicalDrugsInfoService;

    /**
     * 查询药品列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        startPage();
        List<TMedicalDrugsInfo> list = tMedicalDrugsInfoService.selectTMedicalDrugsInfoList(tMedicalDrugsInfo);
        return getDataTable(list);
    }

    /**
     * 导出药品列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "药品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        List<TMedicalDrugsInfo> list = tMedicalDrugsInfoService.selectTMedicalDrugsInfoList(tMedicalDrugsInfo);
        ExcelUtil<TMedicalDrugsInfo> util = new ExcelUtil<TMedicalDrugsInfo>(TMedicalDrugsInfo.class);
        util.exportExcel(response, list, "药品数据");
    }

    /**
     * 获取药品详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalDrugsInfoService.selectTMedicalDrugsInfoById(id));
    }

    /**
     * 新增药品
     */
    @PreAuthorize("@ss.hasPermi('system:pharmacy:info:add')")
    @Log(title = "药品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        String id = UUID.randomUUID().toString().replace("-","");
        tMedicalDrugsInfo.setId(id);
        System.out.println("123:"+id);
        return toAjax(tMedicalDrugsInfoService.insertTMedicalDrugsInfo(tMedicalDrugsInfo));
    }

    /**
     * 修改药品
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "药品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        return toAjax(tMedicalDrugsInfoService.updateTMedicalDrugsInfo(tMedicalDrugsInfo));
    }

    /**
     * 删除药品
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "药品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalDrugsInfoService.deleteTMedicalDrugsInfoByIds(ids));
    }
}
