package com.flyroc.ox_online.project.biz.varieties.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.flyroc.ox_online.framework.aspectj.lang.annotation.Log;
import com.flyroc.ox_online.framework.aspectj.lang.enums.BusinessType;
import com.flyroc.ox_online.framework.web.controller.BaseController;
import com.flyroc.ox_online.framework.web.domain.AjaxResult;
import com.flyroc.ox_online.framework.web.page.TableDataInfo;
import com.flyroc.ox_online.project.biz.Rrecords.service.RrecordsService;
import com.flyroc.ox_online.project.biz.activation.domain.Activation;
import com.flyroc.ox_online.project.biz.exChange.domain.SelectAll;
import com.flyroc.ox_online.project.biz.exChange.mapper.ExchangeMapper;
import com.flyroc.ox_online.project.biz.exChange.service.ExChangeService;
import com.flyroc.ox_online.project.biz.varieties.domain.Varieties;
import com.flyroc.ox_online.project.biz.varieties.service.VarietiesService;
import com.flyroc.ox_online.project.monitor.online.domain.UserOnline;
import com.flyroc.ox_online.project.tool.gen.domain.GenTable;

import springfox.documentation.spring.web.json.Json;

/**
 * 参数配置 信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/biz")
public class VarietiesController extends BaseController {
	private String prefix = "system/varieties";
	private String varieties_id = "";

	@Autowired
	private VarietiesService varietiesService;

	@RequestMapping("/varieties")
	public String list() {
		return prefix + "/list";
	}

	/**
	 * 显示
	 * 
	 * @param sall
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/varieties/listShow")
	@ResponseBody
	public TableDataInfo listShow() throws Exception {
		startPage();
		List<Map> lst = varietiesService.selectAll();
		return getDataTable(lst);
	}

	/**
	 * 新增操作
	 * 
	 * @param sall
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/varieties/listInsertShow")
	public String listInsertShow() {
		return prefix + "/add";
	}

	@RequestMapping("/varieties/Pefsell_vn")
	@ResponseBody
	public void Pefsell_vn(String vn, HttpServletResponse resp) throws Exception {
		Varieties varieties = varietiesService.Pefsell_vn(vn);
		JSONObject json = new JSONObject();
		if (varieties == null) {
			json.put("boo", true);
		} else {
			json.put("boo", false);
		}
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}

	@RequestMapping("/varieties/listInsert")
	@ResponseBody
	public void listInsert(Varieties varieties, HttpServletResponse resp) throws Exception {
		varietiesService.listInsert(varieties);
		JSONObject json = new JSONObject();
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}

	/**
	 * 更新操作
	 */
	@RequestMapping("/varieties/listUpdateShow/{id}")
	public String listUpdateShow(@PathVariable("id") String id) {
		this.varieties_id = id;
		return prefix + "/edit";
	}

	@RequestMapping("/varieties/listUpdate")
	@ResponseBody
	public void listUpdate(Varieties varieties, HttpServletResponse resp) throws Exception {
		varietiesService.listUpdate(varieties);
		JSONObject json = new JSONObject();
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}

	/**
	 * 根据id查找
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/varieties/listFindById")
	public void listFindById(HttpServletResponse resp) throws Exception {
		Varieties va = varietiesService.listFindById(this.varieties_id);
		JSONObject json = new JSONObject();
		json.put("va", va);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}

	/**
	 * 删除操作
	 * 
	 * @param sall
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/varieties/listdel")
	@ResponseBody
	public void listdel(String varieties_id, HttpServletResponse resp) throws Exception {
		List<Map> lst = varietiesService.selListdel(varieties_id);
		JSONObject json = new JSONObject();
		if (lst.isEmpty()) {
			json.put("boo", true);
			varietiesService.listdel(varieties_id);
		} else {
			json.put("boo", false);
		}
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}

	/**
	 * 删除操作
	 * 
	 * @param sall
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/varieties/deleteList")
	@ResponseBody
	public void deleteList(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		JSONObject json = new JSONObject();
		String[] lst = request.getParameterValues("lst[]");
		for (int i = 0; i < lst.length; i++) {
			List<Map> mps = varietiesService.selListdel(lst[i]);
			if (mps.isEmpty()) {
				json.put("boo", true);
				varietiesService.listdel(lst[i]);
			} else {
				json.put("boo", false);
			}
		}
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}

}
