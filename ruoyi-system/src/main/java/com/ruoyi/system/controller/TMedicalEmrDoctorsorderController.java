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
import com.ruoyi.system.domain.TMedicalEmrDoctorsorder;
import com.ruoyi.system.service.ITMedicalEmrDoctorsorderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医嘱记录Controller
 * 
 * @author ruoyi
 * @date 2022-09-06
 */
@RestController
@RequestMapping("/system/doctorsorder")
public class TMedicalEmrDoctorsorderController extends BaseController
{
    @Autowired
    private ITMedicalEmrDoctorsorderService tMedicalEmrDoctorsorderService;

    /**
     * 查询医嘱记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:doctorsorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalEmrDoctorsorder tMedicalEmrDoctorsorder)
    {
        startPage();
        List<TMedicalEmrDoctorsorder> list = tMedicalEmrDoctorsorderService.selectTMedicalEmrDoctorsorderList(tMedicalEmrDoctorsorder);
        return getDataTable(list);
    }

    /**
     * 导出医嘱记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:doctorsorder:export')")
    @Log(title = "医嘱记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMedicalEmrDoctorsorder tMedicalEmrDoctorsorder)
    {
        List<TMedicalEmrDoctorsorder> list = tMedicalEmrDoctorsorderService.selectTMedicalEmrDoctorsorderList(tMedicalEmrDoctorsorder);
        ExcelUtil<TMedicalEmrDoctorsorder> util = new ExcelUtil<TMedicalEmrDoctorsorder>(TMedicalEmrDoctorsorder.class);
        util.exportExcel(response, list, "医嘱记录数据");
    }

    /**
     * 获取医嘱记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:doctorsorder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalEmrDoctorsorderService.selectTMedicalEmrDoctorsorderById(id));
    }

    /**
     * 新增医嘱记录
     */
    @PreAuthorize("@ss.hasPermi('system:doctorsorder:add')")
    @Log(title = "医嘱记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalEmrDoctorsorder tMedicalEmrDoctorsorder)
    {
        tMedicalEmrDoctorsorder.setId(UUID.randomUUID().toString().replace("-", ""));
        return toAjax(tMedicalEmrDoctorsorderService.insertTMedicalEmrDoctorsorder(tMedicalEmrDoctorsorder));
    }

    /**
     * 修改医嘱记录
     */
    @PreAuthorize("@ss.hasPermi('system:doctorsorder:edit')")
    @Log(title = "医嘱记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalEmrDoctorsorder tMedicalEmrDoctorsorder)
    {
        return toAjax(tMedicalEmrDoctorsorderService.updateTMedicalEmrDoctorsorder(tMedicalEmrDoctorsorder));
    }

    /**
     * 删除医嘱记录
     */
    @PreAuthorize("@ss.hasPermi('system:doctorsorder:remove')")
    @Log(title = "医嘱记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalEmrDoctorsorderService.deleteTMedicalEmrDoctorsorderByIds(ids));
    }
}
