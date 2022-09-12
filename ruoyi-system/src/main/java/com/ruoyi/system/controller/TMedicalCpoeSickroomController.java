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
import com.ruoyi.system.domain.TMedicalCpoeSickroom;
import com.ruoyi.system.service.ITMedicalCpoeSickroomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 病房记录Controller
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
@RestController
@RequestMapping("/system/sickroom")
public class TMedicalCpoeSickroomController extends BaseController
{
    @Autowired
    private ITMedicalCpoeSickroomService tMedicalCpoeSickroomService;

    /**
     * 查询病房记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:sickroom:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalCpoeSickroom tMedicalCpoeSickroom)
    {
        startPage();
        List<TMedicalCpoeSickroom> list = tMedicalCpoeSickroomService.selectTMedicalCpoeSickroomList(tMedicalCpoeSickroom);
        return getDataTable(list);
    }

    /**
     * 导出病房记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:sickroom:export')")
    @Log(title = "病房记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMedicalCpoeSickroom tMedicalCpoeSickroom)
    {
        List<TMedicalCpoeSickroom> list = tMedicalCpoeSickroomService.selectTMedicalCpoeSickroomList(tMedicalCpoeSickroom);
        ExcelUtil<TMedicalCpoeSickroom> util = new ExcelUtil<TMedicalCpoeSickroom>(TMedicalCpoeSickroom.class);
        util.exportExcel(response, list, "病房记录数据");
    }

    /**
     * 获取病房记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sickroom:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalCpoeSickroomService.selectTMedicalCpoeSickroomById(id));
    }

    /**
     * 新增病房记录
     */
    @PreAuthorize("@ss.hasPermi('system:sickroom:add')")
    @Log(title = "病房记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalCpoeSickroom tMedicalCpoeSickroom)
    {
        return toAjax(tMedicalCpoeSickroomService.insertTMedicalCpoeSickroom(tMedicalCpoeSickroom));
    }

    /**
     * 修改病房记录
     */
    @PreAuthorize("@ss.hasPermi('system:sickroom:edit')")
    @Log(title = "病房记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalCpoeSickroom tMedicalCpoeSickroom)
    {
        return toAjax(tMedicalCpoeSickroomService.updateTMedicalCpoeSickroom(tMedicalCpoeSickroom));
    }

    /**
     * 删除病房记录
     */
    @PreAuthorize("@ss.hasPermi('system:sickroom:remove')")
    @Log(title = "病房记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalCpoeSickroomService.deleteTMedicalCpoeSickroomByIds(ids));
    }
}
