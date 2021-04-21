package com.flyroc.ox_online.project.biz.oxMng.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flyroc.ox_online.common.utils.poi.ExcelUtil;
import com.flyroc.ox_online.framework.aspectj.lang.annotation.Log;
import com.flyroc.ox_online.framework.aspectj.lang.enums.BusinessType;
import com.flyroc.ox_online.framework.web.controller.BaseController;
import com.flyroc.ox_online.framework.web.domain.AjaxResult;
import com.flyroc.ox_online.framework.web.page.TableDataInfo;
import com.flyroc.ox_online.project.biz.activation.domain.Activation;
import com.flyroc.ox_online.project.biz.activation.service.ActivationService;
import com.flyroc.ox_online.project.biz.oxMng.domain.OxMng;
import com.flyroc.ox_online.project.biz.oxMng.service.OxMngService;

/**
 * 参数配置 信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/biz/oxMng")
public class OxMngController extends BaseController{
	private String prefix = "biz/oxMng";

	@Autowired
	private OxMngService oxMngService;
	

	//跳转页面
	@RequiresPermissions("biz:oxMng:view")
	@GetMapping()
	public String oxMarket(){
		return prefix + "/list";
	}
	
	 /**
     *	下拉框显示
     */
    @PostMapping("/cx")
	@ResponseBody
    public void pk(HttpServletRequest request, HttpServletResponse response){
    	JSONObject json = new JSONObject();
    	List<OxMng> list = oxMngService.selectoxState();
    	List<OxMng> list2 = oxMngService.selectoxTypeId();
    	
    	json.put("ox_type_id", list2);
    	json.put("ox_state", list);
    	try {
			request.setCharacterEncoding("utf-8");
	    	response.setContentType("application/json;charset=utf-8");
	    	PrintWriter out = null;
	    	out = response.getWriter();
	    	out.write(json.toString());
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     *	更新上下架信息
     */
    @PostMapping("/gg")
	@ResponseBody
    public void gg(HttpServletRequest request, HttpServletResponse response){
    	JSONObject json = new JSONObject();
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("ox_id", request.getParameter("ox_id"));
    	String s = request.getParameter("pd");
    	if(s.equals("2")) {
    		map.put("ox_state", 0);
    	}else {
    		Map<String, Object> ma = oxMngService.selectOxState2((String)map.get("ox_id"));
    		if(ma != null) {
    			map.put("ox_state", 1);
    		}else {
    			map.put("ox_state", 2);
    		}
    	}
    	map.put("update_time", new Date());
    	
    	int a = oxMngService.updateOxState1(map);
    	
    	json.put("a", a);
    	try {
			request.setCharacterEncoding("utf-8");
	    	response.setContentType("application/json;charset=utf-8");
	    	PrintWriter out = null;
	    	out = response.getWriter();
	    	out.write(json.toString());
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 *	查询
	 */
	@RequiresPermissions("biz:oxMng:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(OxMng ox)
	{
		startPage();
		String ox_type_id = ox.getOx_type_id();
		String ox_state = ox.getOx_state();
		if(ox_type_id != null && ox_state != null) {
			if(ox_type_id.equals("所有")) {
				ox.setOx_type_id("");
			}
			if(ox_state.equals("所有")) {
				ox.setOx_state("");
			}
		}

		List<OxMng> list = oxMngService.selectOxsele(ox);
		return getDataTable(list);
	}
	
	/**
	 * 查看按钮
	 */
    @GetMapping("/add/{userId}")
    public String add(@PathVariable("userId") String userId, ModelMap mmap)
    {
    	List<Map<String, Object>> list = oxMngService.selectOxCenSto(userId);
    	if(list.size() > 0){
    		Map<String, Object> map = list.get(0);
            mmap.put("map", map);
    	}
        return prefix + "/add";
    }
    
    /**
	 * 审核按钮
	 */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") String userId, ModelMap mmap)
    {
    	
    	List<Map<String, Object>> list = oxMngService.selectOxCenSto(userId);
    	if(list.size() > 0){
    		Map<String, Object> map = list.get(0);
            mmap.put("map", map);
    	}
        return prefix + "/edit";
    }
    
    /**
     *	通过按钮
     */
    @PostMapping("/gx")
    @ResponseBody
    public void store(HttpServletRequest request, HttpServletResponse response){
    	JSONObject json = new JSONObject();
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("ox_id", request.getParameter("ox_id"));
    	map.put("ox_state", 0);
    	map.put("update_time", new Date());
    	
    	if(request.getParameter("ox_reason") != null) {
    		
    		int a = oxMngService.updateOxState1(map);
        	map.put("ox_state", 3);
    		map.put("ox_reason", request.getParameter("ox_reason"));
    		int a1 = oxMngService.updateOxState2(map);
    		json.put("a", a);
    		json.put("a1", a1);
    		
    	}else {
    		map.put("ox_state", 2);
    		int a = oxMngService.updateOxState1(map);
    		int b = oxMngService.deleteOxState(map);
        	json.put("a", a);
    		json.put("b", b);
    		
    	}
    	
    	try {
			request.setCharacterEncoding("utf-8");
	    	response.setContentType("application/json;charset=utf-8");
	    	PrintWriter out = null;
	    	out = response.getWriter();
	    	out.write(json.toString());
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     *	驳回跳转
     */
    @GetMapping("/bh")
    public String bh()
    {
        return prefix + "/bh";
    }
    
    /**
     * 导出信息管理列表
     */
    @RequiresPermissions("biz:oxMng:export")
    @Log(title = "信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OxMng ox)
    {
    	String ox_type_id = ox.getOx_type_id();
		String ox_state = ox.getOx_state();
		if(ox_type_id != null && ox_state != null) {
			if(ox_type_id.equals("所有")) {
				ox.setOx_type_id("");
			}
			if(ox_state.equals("所有")) {
				ox.setOx_state("");
			}
		}
    	List<OxMng> list = oxMngService.selectOxsele(ox);
        ExcelUtil<OxMng> util = new ExcelUtil<OxMng>(OxMng.class);
        return util.exportExcel(list, "varieties");
    }
    
	
}
