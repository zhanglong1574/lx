package com.flyroc.ox_online.project.biz.record.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.flyroc.ox_online.framework.aspectj.lang.annotation.Log;
import com.flyroc.ox_online.framework.aspectj.lang.enums.BusinessType;
import com.flyroc.ox_online.project.biz.record.domain.HyVarietiesRecord;
import com.flyroc.ox_online.project.biz.record.service.IHyVarietiesRecordService;
import com.flyroc.ox_online.framework.web.controller.BaseController;
import com.flyroc.ox_online.framework.web.domain.AjaxResult;
import com.flyroc.ox_online.common.utils.poi.ExcelUtil;
import com.flyroc.ox_online.framework.web.page.TableDataInfo;

/**
 * 牛市交易附表Controller
 * 
 * @author auto
 * @date 2021-01-19
 */
@Controller
@RequestMapping("/biz/record")
public class HyVarietiesRecordController extends BaseController
{
    private String prefix = "biz/record";

    @Autowired
    private IHyVarietiesRecordService hyVarietiesRecordService;

    @RequiresPermissions("biz:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询牛市交易附表列表
     */
    @RequiresPermissions("biz:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyVarietiesRecord hyVarietiesRecord)
    {
        startPage();
        List<HyVarietiesRecord> list = hyVarietiesRecordService.selectHyVarietiesRecordList(hyVarietiesRecord);
        return getDataTable(list);
    }

    /**
     * 导出牛市交易附表列表
     */
    @RequiresPermissions("biz:record:export")
    @Log(title = "牛市交易附表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyVarietiesRecord hyVarietiesRecord)
    {
        List<HyVarietiesRecord> list = hyVarietiesRecordService.selectHyVarietiesRecordList(hyVarietiesRecord);
        ExcelUtil<HyVarietiesRecord> util = new ExcelUtil<HyVarietiesRecord>(HyVarietiesRecord.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 新增牛市交易附表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存牛市交易附表
     */
    @RequiresPermissions("biz:record:add")
    @Log(title = "牛市交易附表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyVarietiesRecord hyVarietiesRecord)
    {
        return toAjax(hyVarietiesRecordService.insertHyVarietiesRecord(hyVarietiesRecord));
    }

    /**
     * 修改牛市交易附表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        HyVarietiesRecord hyVarietiesRecord = hyVarietiesRecordService.selectHyVarietiesRecordById(id);
        mmap.put("hyVarietiesRecord", hyVarietiesRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存牛市交易附表
     */
    @RequiresPermissions("biz:record:edit")
    @Log(title = "牛市交易附表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyVarietiesRecord hyVarietiesRecord)
    {
        return toAjax(hyVarietiesRecordService.updateHyVarietiesRecord(hyVarietiesRecord));
    }

    /**
     * 删除牛市交易附表
     */
    @RequiresPermissions("biz:record:remove")
    @Log(title = "牛市交易附表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyVarietiesRecordService.deleteHyVarietiesRecordByIds(ids));
    }
}
