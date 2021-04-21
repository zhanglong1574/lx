package com.flyroc.ox_online.project.biz.serve.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flyroc.ox_online.framework.aspectj.lang.annotation.Log;
import com.flyroc.ox_online.framework.aspectj.lang.enums.BusinessType;
import com.flyroc.ox_online.framework.web.controller.BaseController;
import com.flyroc.ox_online.framework.web.domain.AjaxResult;
import com.flyroc.ox_online.framework.web.page.TableDataInfo;
import com.flyroc.ox_online.project.biz.order.domain.Order;
import com.flyroc.ox_online.project.biz.order.service.IOrderService;
import com.flyroc.ox_online.project.biz.serve.domain.HyServiceCenter;
import com.flyroc.ox_online.project.biz.serve.domain.Serve;
import com.flyroc.ox_online.project.biz.serve.service.IServeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/biz/oxServiceCenter")
public class ServeController extends BaseController
{
    private String prefix = "/biz/serve";

    @Autowired
    private IServeService iServeService;


    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/serve";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Serve serve)
    {
        startPage();
        List<Map> list = iServeService.selectServeList(serve);
        return getDataTable(list);
    }
    @GetMapping("/addServe")
    public String addServe(Serve serve)
    {
        return prefix + "/add";
    }

    @GetMapping("/msg")
    public void msg(HttpServletRequest request, HttpServletResponse response)
    {
        iServeService.insertList(request);
    }

    /**
     * 编辑
     */
    @GetMapping("/add/{Id}")
    public String add(@PathVariable("Id") String Id)
    {
        return prefix + "/edit3?id="+Id;
    }
    /**
     * 删除交易市场
     */
    @RequiresPermissions("system:center:remove")
    @Log(title = "交易市场", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(iServeService.deleteHyServiceCenterById(ids));
    }

    /**
     * 修改交易市场
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        HyServiceCenter hyServiceCenter = iServeService.selectHyServiceCenterById(id);
        mmap.put("hyServiceCenter", hyServiceCenter);
        return prefix + "/edit";
    }

    /**
     * 修改保存交易市场
     */
    @RequiresPermissions("system:center:edit")
    @Log(title = "交易市场", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyServiceCenter hyServiceCenter)
    {
        return toAjax(iServeService.updateHyServiceCenter(hyServiceCenter));
    }
}