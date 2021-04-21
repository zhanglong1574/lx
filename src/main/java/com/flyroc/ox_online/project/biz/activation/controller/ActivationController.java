package com.flyroc.ox_online.project.biz.activation.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
import com.flyroc.ox_online.framework.web.controller.BaseController;
import com.flyroc.ox_online.framework.web.page.TableDataInfo;
import com.flyroc.ox_online.project.biz.activation.domain.Activation;
import com.flyroc.ox_online.project.biz.activation.domain.Str;
import com.flyroc.ox_online.project.biz.activation.service.ActivationService;

/**
 * 参数配置 信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/biz/oxMarket")
public class ActivationController extends BaseController{
	private String prefix = "biz/activation";

	@Autowired
	private ActivationService activationService;
	
	String us = "";


	@RequiresPermissions("biz:oxMarket:view")
	@GetMapping()
	public String oxMarket(){
		return prefix + "/list";
	}

	/**
	 * 查询参数配置列表
	 */
	@RequiresPermissions("biz:oxMarket:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Activation activation)
	{
		startPage();
		List<Activation> list = activationService.selectHyOxMarketList(activation);
		return getDataTable(list);
	}
	
	/**
	 * 查看按钮显示
	 */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") String userId, ModelMap mmap)
    {
    	List<Activation> list = activationService.selectHyOxMarketById(userId);
    	if(list.size() > 0){
    		Activation activation = list.get(0);
    		mmap.put("Activation", activation);
    	}
        
        return prefix + "/edit";
    }
    
    /**
                 * 统计
     */
    @GetMapping("/statistics")
    public String editSave(ModelMap mmap)
    {
    	List<HashMap<String,Object>> map = activationService.selectHyOxMarketCount();
    	List<HashMap<String,Object>> max = activationService.selectHyOxMarketMax();
    	List<HashMap<String,Object>> min = activationService.selectHyOxMarketMin();
    	Object ax = max.get(0).get("count");
    	Object in = min.get(0).get("count");
    	Object[] count = new Object[map.size()];
    	Object[] time = new Object[map.size()]; 
    	int a = 0;
    	for (HashMap<String, Object> map2 : map) {
    		count[a] = map2.get("count");
    		time[a] = map2.get("time");
    		if(map2.get("time").equals(max.get(0).get("time"))) {
    			mmap.put("max", a);
    		}
    		if(map2.get("time").equals(min.get(0).get("time"))) {
    			mmap.put("min", a);
    		}
    		a++;
    	}
    	mmap.put("count", count);
    	mmap.put("time", time);
    	mmap.put("ax", ax);
    	mmap.put("in", in);
    	return prefix + "/edit2";
    }
    
    /**
     *	  个人 统计
     */
    @GetMapping("/statistics2")
    public String edit2(HttpServletRequest request, HttpServletResponse response)
    {
    	us = request.getParameter("userId");
    	return prefix + "/statistics";
    }
    
    /**
	 *   个人 统计搜索
	 */
	@RequiresPermissions("biz:oxMarket:list2")
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
		List<HashMap<String,Object>> selectvarieties = activationService.selectvarieties(str);
		HashMap<String,Object> selectmarket = activationService.selectmarket(str);
		selectvarieties.get(0).put("mcount", selectmarket.get("mcount"));
		List<HashMap<String,Object>> list = selectvarieties;
		return getDataTable(list);
	}
	
	/**
	 * 激活按钮
	 */
    @GetMapping("/add/{userId}")
    public String add(@PathVariable("userId") String userId, ModelMap mmap)
    {
    	List<Activation> list = activationService.selectHyOxMarketById(userId);
    	if(list.size() > 0){
    	Activation activation = list.get(0);
        mmap.put("Activation", activation);
    	}
        return prefix + "/add";
    }
    
    /**
     *	  卡号激活
     */
    @PostMapping("/add")
	@ResponseBody
    public void add(HttpServletRequest request, HttpServletResponse response){
    	JSONObject json = new JSONObject();
    	Activation activation = new Activation();
    	activation.setUserId(request.getParameter("userId"));
    	activation.setCid(request.getParameter("cid"));
    	activation.setIsActivateTime(new Date());
    	List<Activation> selectkh = activationService.selectkh(activation);
    	if(selectkh.size() == 0) {
    		int a = activationService.updateHystore(activation);
    		json.put("a", a);
    	}else {
    		json.put("a", 50);
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
     *	  判断卡号是否绑定
     */
    @PostMapping("/pk")
	@ResponseBody
    public void pk(HttpServletRequest request, HttpServletResponse response){
    	JSONObject json = new JSONObject();
    	Activation activation = new Activation();
    	activation.setCid(request.getParameter("cid"));
    	List<Activation> selectkh = activationService.selectkh(activation);
    	if(selectkh.size() == 0) {
    		json.put("a", 1);
    	}else {
    		json.put("a", 50);
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
     *	  判断卡号是否绑定
     */
    @PostMapping("/store")
    @ResponseBody
    public void store(HttpServletRequest request, HttpServletResponse response){
    	JSONObject json = new JSONObject();
    	Activation activation = new Activation();
    	activation.setStoreTel(request.getParameter("storeTel"));
    	List<Activation> selectkh = activationService.selectHyOxMarketList(activation);
    	if(selectkh.size() != 0) {
    		json.put("a", 1);
    		json.put("selectkh", selectkh);
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
     *	  新增卡号
     */
    @GetMapping("/add2")
    public String xz(HttpServletRequest request, HttpServletResponse response, ModelMap mmap)
    {
    	String str = request.getParameter("str");
    	mmap.put("cid", str);
    	return prefix + "/add2";
    }
    



}
