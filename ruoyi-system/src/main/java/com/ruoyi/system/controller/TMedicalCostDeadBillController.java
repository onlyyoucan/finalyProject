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
import com.ruoyi.system.domain.TMedicalCostDeadBill;
import com.ruoyi.system.service.ITMedicalCostDeadBillService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医院烂账记录Controller
 *
 * @author ruoyi
 * @date 2022-09-06
 */
@RestController
@RequestMapping("/system/deadbill")
public class TMedicalCostDeadBillController extends BaseController
{
    @Autowired
    private ITMedicalCostDeadBillService tMedicalCostDeadBillService;

    /**
     * 查询医院烂账记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:bill1:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalCostDeadBill tMedicalCostDeadBill)
    {
        startPage();
        List<TMedicalCostDeadBill> list = tMedicalCostDeadBillService.selectTMedicalCostDeadBillList(tMedicalCostDeadBill);
        return getDataTable(list);
    }

    /**
     * 导出医院烂账记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:bill1:export')")
    @Log(title = "医院烂账记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMedicalCostDeadBill tMedicalCostDeadBill)
    {
        List<TMedicalCostDeadBill> list = tMedicalCostDeadBillService.selectTMedicalCostDeadBillList(tMedicalCostDeadBill);
        ExcelUtil<TMedicalCostDeadBill> util = new ExcelUtil<TMedicalCostDeadBill>(TMedicalCostDeadBill.class);
        util.exportExcel(response, list, "医院烂账记录数据");
    }

    /**
     * 获取医院烂账记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:bill1:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalCostDeadBillService.selectTMedicalCostDeadBillById(id));
    }

    /**
     * 新增医院烂账记录
     */
    @PreAuthorize("@ss.hasPermi('system:bill1:add')")
    @Log(title = "医院烂账记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalCostDeadBill tMedicalCostDeadBill)
    {
        String id = UUID.randomUUID().toString().replace("-", "");
        tMedicalCostDeadBill.setId(id);
        return toAjax(tMedicalCostDeadBillService.insertTMedicalCostDeadBill(tMedicalCostDeadBill));
    }

    /**
     * 修改医院烂账记录
     */
    @PreAuthorize("@ss.hasPermi('system:bill1:edit')")
    @Log(title = "医院烂账记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalCostDeadBill tMedicalCostDeadBill)
    {
        return toAjax(tMedicalCostDeadBillService.updateTMedicalCostDeadBill(tMedicalCostDeadBill));
    }

    /**
     * 删除医院烂账记录
     */
    @PreAuthorize("@ss.hasPermi('system:bill1:remove')")
    @Log(title = "医院烂账记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalCostDeadBillService.deleteTMedicalCostDeadBillByIds(ids));
    }
}
