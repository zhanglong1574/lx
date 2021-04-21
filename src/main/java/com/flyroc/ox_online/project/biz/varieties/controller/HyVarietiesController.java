package com.flyroc.ox_online.project.biz.varieties.controller;

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
import com.flyroc.ox_online.project.biz.varieties.domain.HyVarieties;
import com.flyroc.ox_online.project.biz.varieties.service.IHyVarietiesService;
import com.flyroc.ox_online.framework.web.controller.BaseController;
import com.flyroc.ox_online.framework.web.domain.AjaxResult;
import com.flyroc.ox_online.common.utils.poi.ExcelUtil;
import com.flyroc.ox_online.framework.web.page.TableDataInfo;

/**
 * 品种Controller
 * 
 * @author auto
 * @date 2021-01-18
 */
@Controller
@RequestMapping("/biz/varieties")
public class HyVarietiesController extends BaseController
{
    private String prefix = "biz/varieties";

    @Autowired
    private IHyVarietiesService hyVarietiesService;

    @RequiresPermissions("biz:varieties:view")
    @GetMapping()
    public String varieties()
    {
        return prefix + "/varieties";
    }

    /**
     * 查询品种列表
     */
    @RequiresPermissions("biz:varieties:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyVarieties hyVarieties)
    {
        startPage();
        List<HyVarieties> list = hyVarietiesService.selectHyVarietiesList(hyVarieties);
        return getDataTable(list);
    }

    /**
     * 导出品种列表
     */
    @RequiresPermissions("biz:varieties:export")
    @Log(title = "品种", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyVarieties hyVarieties)
    {
        List<HyVarieties> list = hyVarietiesService.selectHyVarietiesList(hyVarieties);
        ExcelUtil<HyVarieties> util = new ExcelUtil<HyVarieties>(HyVarieties.class);
        return util.exportExcel(list, "varieties");
    }

    /**
     * 新增品种
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存品种
     */
    @RequiresPermissions("biz:varieties:add")
    @Log(title = "品种", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyVarieties hyVarieties)
    {
        return toAjax(hyVarietiesService.insertHyVarieties(hyVarieties));
    }

    /**
     * 修改品种
     */
    @GetMapping("/edit/{varietiesId}")
    public String edit(@PathVariable("varietiesId") String varietiesId, ModelMap mmap)
    {
        HyVarieties hyVarieties = hyVarietiesService.selectHyVarietiesById(varietiesId);
        mmap.put("hyVarieties", hyVarieties);
        return prefix + "/edit";
    }

    /**
     * 修改保存品种
     */
    @RequiresPermissions("biz:varieties:edit")
    @Log(title = "品种", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyVarieties hyVarieties)
    {
        return toAjax(hyVarietiesService.updateHyVarieties(hyVarieties));
    }

    /**
     * 删除品种
     */
    @RequiresPermissions("biz:varieties:remove")
    @Log(title = "品种", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyVarietiesService.deleteHyVarietiesByIds(ids));
    }
}
