package com.flyroc.ox_online.project.biz.byre.controller;

import com.alibaba.fastjson.JSONObject;
import com.flyroc.ox_online.common.utils.poi.ExcelUtil;
import com.flyroc.ox_online.framework.aspectj.lang.annotation.Log;
import com.flyroc.ox_online.framework.aspectj.lang.enums.BusinessType;
import com.flyroc.ox_online.framework.web.controller.BaseController;
import com.flyroc.ox_online.framework.web.domain.AjaxResult;
import com.flyroc.ox_online.framework.web.page.TableDataInfo;
import com.flyroc.ox_online.project.biz.activation.service.ActivationService;
import com.flyroc.ox_online.project.biz.byre.domain.HyByre;
import com.flyroc.ox_online.project.biz.byre.lease.domain.HyLease;
import com.flyroc.ox_online.project.biz.byre.lease.service.IHyLeaseService;
import com.flyroc.ox_online.project.biz.byre.service.IHyByreService;
import com.flyroc.ox_online.project.biz.varieties.domain.HyVarieties;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/biz/byre")
public class HyByreController extends BaseController {
    private String prefix = "biz/byre";

    @Autowired
    private IHyByreService hyByreService;

    @Autowired
    private IHyLeaseService hyLeaseService;

    @Autowired
    private ActivationService activationService;


    @RequiresPermissions("biz:byre:view")
    @GetMapping()
    public String byre() {
        return prefix + "/list";
    }

    String us = "";

    /**
     * 查询牛棚信息列表
     */
    @RequiresPermissions("biz:byre:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyByre hyByre, ModelMap mmap) {
        startPage();
        List<HyByre> list = hyByreService.selectHyByreList(hyByre);
        /*Date date = new Date();
        for (int i = 0; i < list.size(); i++) {
            if (date.after(list.get(i).getStartTime()) && date.before(list.get(i).getEndTime())) {

            }

        }*/

        mmap.put("list", list);

        return getDataTable(list);
    }

    /**
     *   个人 统计搜索
     */
    /*@RequiresPermissions("biz:oxMarket:list2")
    @PostMapping("/list2")
    @ResponseBody
    public TableDataInfo list2(HttpServletRequest request, HttpServletResponse response)
    {
        startPage();
        Str str = new Str();
        str.setUserId(us);
        String s = request.getParameter("str");
        if(s != null) {
            str.setStr(s);
        }
        List<HashMap<String,Object>> selectHyByreList = hyByreService.selectHyByreList(str);
        HashMap<String,Object> selectmarket = hyByreService.selectmarket(str);
        selectHyByreList.get(0).put("mcount", selectmarket.get("mcount"));
        List<HashMap<String,Object>> list = selectHyByreList;
        return getDataTable(list);
    }*/

    /**
     * 导出牛棚信息列表
     */
    @RequiresPermissions("biz:byre:export")
    @Log(title = "牛棚信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public String export(HyByre hyByre) {
        List<HyByre> list = hyByreService.selectHyByreList(hyByre);
        ExcelUtil<HyByre> util = new ExcelUtil<HyByre>(HyByre.class);
        return "util.exportExcel(list, byre)";
    }

    /**
     * 新增牛棚信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 服务中心下拉框数据
     *
     * @param request
     * @param response
     * @param hyByre
     * @param hyVarieties
     * @throws Exception
     */
    @RequestMapping(value = "infoSave.do", method = RequestMethod.POST)
    public void infoSave(HttpServletRequest request, HttpServletResponse response, HyByre hyByre, HyVarieties hyVarieties) throws Exception {

        List<HyByre> list = hyByreService.selectServiceCenter();

        int isTrue = 0;
        JSONObject json = new JSONObject();
        if (list.size() > 0) {
            isTrue = 1;//有值
            json.put("list", list);
        } else {
            isTrue = 2;//没值
        }
        json.put("isTrue", isTrue);
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        out = response.getWriter();
        out.write(json.toString());
    }

    /**
     * 根据电话号判断姓名
     *
     * @param request
     * @param response
     * @param hyByre
     * @param hyVarieties
     * @throws Exception
     */
    @RequestMapping(value = "infoSaves.do", method = RequestMethod.POST)
    public void infoSaves(HttpServletRequest request, HttpServletResponse response, HyByre hyByre, HyVarieties hyVarieties) throws Exception {
        Long a = Long.parseLong(request.getParameter("storeTel"));
        String userId = activationService.selectNameByTel(a);

        int isTrue = 0;
        JSONObject json = new JSONObject();
        if (userId.equals("") && userId != null) {
            isTrue = 1;//没值
        } else {
            isTrue = 2;//有值
            json.put("userId", userId);
        }
        json.put("isTrue", isTrue);
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        out = response.getWriter();
        out.write(json.toString());
    }

    /**
     * 新增保存牛棚信息
     */
    @RequiresPermissions("biz:byre:add")
    @Log(title = "牛棚信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HttpServletRequest request, HyByre hyByre) throws IOException {
        String serviceCenter = request.getParameter("serviceCenter");//服务中心id
        int byre_num = Integer.parseInt(request.getParameter("num"));//添加牛棚的数量
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int a = 0;
        for (int i = 0; i < byre_num; i++) {
            String uuid = java.util.UUID.randomUUID().toString().replaceAll("-", "");//随机id
            if (hyByreService.selectServiceCenterNum(hyByre) == null) {
                a = 0;
            } else {
                a = Integer.parseInt(hyByreService.selectServiceCenterNum(hyByre));
            }

            hyByre.setByreId(uuid);
            hyByre.setServiceCenter(serviceCenter);
            hyByre.setByreNum(a + 1);
            hyByreService.insertHyByre(hyByre);
        }
        return toAjax(byre_num);
    }

    /**
     * 租赁牛棚信息
     */
    @GetMapping("/edit/{byreId}")
    public String edit(@PathVariable("byreId") String byreId, ModelMap mmap) {
        HyByre hyByre = hyByreService.selectHyByreById(byreId);
        mmap.put("hyByre", hyByre);
        return prefix + "/edit";
    }

    /**
     * 保存租赁牛棚信息
     */
    @RequiresPermissions("biz:byre:edit")
    @Log(title = "牛棚信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HttpServletRequest request, HyByre hyByre) {
//
        Long userId = Long.parseLong(request.getParameter("userId"));

        String byreId = request.getParameter("byreId");
        String recordId = java.util.UUID.randomUUID().toString().replaceAll("-", "");//随机id

        HyLease hyLease = new HyLease();
        hyLease.setRecordId(recordId);
        hyLease.setByreId(byreId);
        hyLease.setUserId(activationService.selectIdByTel(userId));
        hyLease.setStartTime(hyByre.getStartTime());
        hyLease.setEndTime(hyByre.getEndTime());

        return toAjax(hyLeaseService.insertHyLease(hyLease));
    }

    /**
     * 删除牛棚信息
     */
    @RequiresPermissions("biz:byre:remove")
    @Log(title = "牛棚信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(hyByreService.deleteHyByreByIds(ids));
    }

}
