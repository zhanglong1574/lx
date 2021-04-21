package com.flyroc.ox_online.project.biz.byre.lease.controller;

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
import com.flyroc.ox_online.project.biz.byre.lease.domain.HyLease;
import com.flyroc.ox_online.project.biz.byre.lease.service.IHyLeaseService;
import com.flyroc.ox_online.framework.web.controller.BaseController;
import com.flyroc.ox_online.framework.web.domain.AjaxResult;
import com.flyroc.ox_online.common.utils.poi.ExcelUtil;
import com.flyroc.ox_online.framework.web.page.TableDataInfo;

/**
 * 牛棚租赁记录Controller
 * 
 * @author auto
 * @date 2021-01-20
 */
@Controller
@RequestMapping("/biz/lease")
public class HyLeaseController extends BaseController
{
    private String prefix = "biz/lease";

    @Autowired
    private IHyLeaseService hyLeaseService;

    @RequiresPermissions("biz:lease:view")
    @GetMapping()
    public String lease()
    {
        return prefix + "/lease";
    }

    /**
     * 查询牛棚租赁记录列表
     */
    @RequiresPermissions("biz:lease:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyLease hyLease)
    {
        startPage();
        List<HyLease> list = hyLeaseService.selectHyLeaseList(hyLease);
        return getDataTable(list);
    }

    /**
     * 导出牛棚租赁记录列表
     */
    @RequiresPermissions("biz:lease:export")
    @Log(title = "牛棚租赁记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyLease hyLease)
    {
        List<HyLease> list = hyLeaseService.selectHyLeaseList(hyLease);
        ExcelUtil<HyLease> util = new ExcelUtil<HyLease>(HyLease.class);
        return util.exportExcel(list, "lease");
    }

    /**
     * 新增牛棚租赁记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存牛棚租赁记录
     */
    @RequiresPermissions("biz:lease:add")
    @Log(title = "牛棚租赁记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyLease hyLease)
    {
        return toAjax(hyLeaseService.insertHyLease(hyLease));
    }

    /**
     * 修改牛棚租赁记录
     */
    @GetMapping("/edit/{recordId}")
    public String edit(@PathVariable("recordId") String recordId, ModelMap mmap)
    {
        HyLease hyLease = hyLeaseService.selectHyLeaseById(recordId);
        mmap.put("hyLease", hyLease);
        return prefix + "/edit";
    }

    /**
     * 修改保存牛棚租赁记录
     */
    @RequiresPermissions("biz:lease:edit")
    @Log(title = "牛棚租赁记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyLease hyLease)
    {
        return toAjax(hyLeaseService.updateHyLease(hyLease));
    }

    /**
     * 删除牛棚租赁记录
     */
    @RequiresPermissions("biz:lease:remove")
    @Log(title = "牛棚租赁记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyLeaseService.deleteHyLeaseByIds(ids));
    }
}
