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
import com.ruoyi.system.domain.TMedicalCostBill;
import com.ruoyi.system.service.ITMedicalCostBillService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 患者费用账单Controller
 *
 * @author ruoyi
 * @date 2022-09-02
 */
@RestController
@RequestMapping("/system/bill")
public class TMedicalCostBillController extends BaseController
{
    @Autowired
    private ITMedicalCostBillService tMedicalCostBillService;

    /**
     * 查询患者费用账单列表
     */
    @PreAuthorize("@ss.hasPermi('system:bill:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalCostBill tMedicalCostBill)
    {
        startPage();
        List<TMedicalCostBill> list = tMedicalCostBillService.selectTMedicalCostBillList(tMedicalCostBill);
        return getDataTable(list);

    }

    /**
     * 导出患者费用账单列表
     */
    @PreAuthorize("@ss.hasPermi('system:bill:export')")
    @Log(title = "患者费用账单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMedicalCostBill tMedicalCostBill)
    {
        List<TMedicalCostBill> list = tMedicalCostBillService.selectTMedicalCostBillList(tMedicalCostBill);
        ExcelUtil<TMedicalCostBill> util = new ExcelUtil<TMedicalCostBill>(TMedicalCostBill.class);
        util.exportExcel(response, list, "患者费用账单数据");
    }

    /**
     * 获取患者费用账单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:bill:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalCostBillService.selectTMedicalCostBillById(id));
    }

    /**
     * 新增患者费用账单
     */
    @PreAuthorize("@ss.hasPermi('system:bill:add')")
    @Log(title = "患者费用账单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalCostBill tMedicalCostBill)
    {
        String id = UUID.randomUUID().toString().replace("-", "");
        tMedicalCostBill.setId(id);
        return toAjax(tMedicalCostBillService.insertTMedicalCostBill(tMedicalCostBill));
    }

    /**
     * 修改患者费用账单
     */
    @PreAuthorize("@ss.hasPermi('system:bill:edit')")
    @Log(title = "患者费用账单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalCostBill tMedicalCostBill)
    {
        return toAjax(tMedicalCostBillService.updateTMedicalCostBill(tMedicalCostBill));
    }

    /**
     * 删除患者费用账单
     */
    @PreAuthorize("@ss.hasPermi('system:bill:remove')")
    @Log(title = "患者费用账单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalCostBillService.deleteTMedicalCostBillByIds(ids));
    }
}
