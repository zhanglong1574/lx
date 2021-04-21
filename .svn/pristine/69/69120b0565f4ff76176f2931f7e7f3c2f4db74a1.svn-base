package com.flyroc.ox_online.project.biz.exChange.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.flyroc.ox_online.project.biz.exChange.domain.AddMessage;
import com.flyroc.ox_online.project.biz.exChange.domain.SelectAll;
import com.flyroc.ox_online.project.biz.exChange.mapper.ExchangeMapper;

import com.flyroc.ox_online.project.biz.exChange.service.ExChangeService;
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
public class ExChangeController extends BaseController {
	private String prefix = "system/ecag";
	private String Strfix = "";
	private String key = "";
	private AddMessage addMessage = new AddMessage();
	private String market_id = "";
	private String sell_way = "";
	private String cuser_imports = "";

	@Autowired
	private ExChangeService exChangeService;

	@RequestMapping("/exchange")
	public String list() {
		return prefix + "/list";
	}

	/**
	 * 一级显示
	 * 
	 * @param sall
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/exchange/listShow")
	@ResponseBody
	public TableDataInfo listShow(SelectAll sall) throws Exception {
		startPage();
		List<Map> lst = exChangeService.selectAll(sall);
		return getDataTable(lst);
	}

	/**
	 * 汇总跳转接口
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/exchange/form")
	public String form(HttpServletRequest request) throws IOException {
		return prefix + "/form";
	}

	/**
	 * 汇总实现接口
	 * 
	 * @param request
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/exchange/formCount")
	public void formCount(HttpServletRequest request, HttpServletResponse resp) throws IOException {

		List<Map> lst = exChangeService.selectCount();
		JSONObject json = new JSONObject();
		json.put("lst", lst);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}

	/**
	 * 二级显示跳转接口
	 * 
	 * @param stus
	 * @return
	 */
	@RequestMapping("/exchange/selShow")
	public String selShow(String stus) {
		this.Strfix = stus;
		return prefix + "/listShow";
	}

	/**
	 * 二级显示
	 * 
	 * @param print_status
	 * @param sell_way
	 * @param user_imports
	 * @param date
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/exchange/selShows")
	@ResponseBody
	public TableDataInfo selShows(String print_status, String sell_way, String user_imports, String date)
			throws Exception {
		startPage();
		List<Map> lst = exChangeService.selectShow(Strfix, print_status, sell_way, user_imports, date);
		return getDataTable(lst);
	}

	/**
	 * 交易信息报废
	 * 
	 * @param hmmId
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/exchange/listdel")
	@ResponseBody
	public void listdel(String hmmId, HttpServletResponse resp) throws IOException {
		exChangeService.listdel(hmmId);
		JSONObject json = new JSONObject();
		json.put("boo", true);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}

	/**
	 * 交易跳转接口
	 * 
	 * @param keys
	 * @return
	 */
	@RequestMapping("/exchange/AddMess")
	public String AddMess(String keys) {
		this.key = keys;
		return prefix + "/AddMess";
	}

	/**
	 * 交易
	 * 
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/exchange/AddMesss")
	public void AddMesss(HttpServletResponse resp) throws IOException {
		List<Map> lst1 = exChangeService.storeMesSel(key);
		List<Map> lst2 = exChangeService.varietiesSel();
		JSONObject json = new JSONObject();
		if (!lst1.isEmpty()) {
			json.put("lst1", lst1);
			json.put("boo", true);
		} else {
			json.put("boo", false);
		}
		json.put("lst2", lst2);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}

	/**
	 * 验证电话号
	 * 
	 * @param tel
	 * @param resp
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/exchange/Pefsell_tel")
	public void Pefsell_tel(String tel, HttpServletResponse resp, HttpServletRequest request) throws IOException {
		List<Map> lst = exChangeService.Pefsell_tel(tel);
		Boolean boo = lst.isEmpty();
		JSONObject json = new JSONObject();
		json.put("boo", boo);
		json.put("lst", lst);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());

	}

	/**
	 * 三级显示接口
	 * 
	 * @param madd
	 * @return
	 */
	@RequestMapping("/exchange/btAdd")
	public String btAdd(AddMessage madd) {
		this.addMessage = madd;
		exChangeService.btAdd(madd);
		return prefix + "/print";
	}

	/**
	 * 交易信息回顯
	 * 
	 * @param request
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/exchange/AddMesssReturn")
	public void AddMesssReturn(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		String name = (String) request.getSession().getAttribute("userName");
		JSONObject json = new JSONObject();
		json.put("msg", this.addMessage);
		json.put("name", name);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}

	/**
	 * 三級跳轉接口
	 * @param market_id
	 * @param sell_way
	 * @return
	 */
	@RequestMapping("/exchange/listShows")
	public String listShows(String market_id, String sell_way,String cuser_imports) {
		this.market_id = market_id;
		this.sell_way = sell_way;
		this.cuser_imports = cuser_imports;
		return prefix + "/AddMessCopy";
	}

	/**
	 * 三級頁面顯示
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/exchange/AddMessCopy")
	public void AddMessCopy(HttpServletResponse resp) throws IOException {
		List<Map> lst2 = exChangeService.varietiesSel();
		JSONObject json = new JSONObject();

		List<Map> lst3 = exChangeService.AddMessCopy(market_id);
		json.put("lst3", lst3);

		if (this.sell_way.equals("线上")) {
			json.put("boo", true);
		} else {
			json.put("boo", false);
		}

		json.put("lst2", lst2);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}

	/**
	 * 三級頁面修改
	 * @param addMessage
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/exchange/AddMessCopyUpdate")
	public void AddMessCopyUpdate(AddMessage addMessage, HttpServletResponse resp) throws IOException {
		addMessage.setId(market_id);
		exChangeService.AddMessCopyUpdate(addMessage);
		JSONObject json = new JSONObject();
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}

	/**
	 * 四級顯示接口
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/exchange/onSelPage")
	public String onSelPage() throws Exception {
		return prefix + "/onSel";
	}

	/**
	 * 四級顯示頁面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/exchange/onSel")
	@ResponseBody
	public TableDataInfo onSel() throws Exception {
		startPage();
		List<Map> lst = exChangeService.onSel(this.market_id);
		return getDataTable(lst);
	}

	/**
	 * 五級顯示接口
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/exchange/oxMesPage")
	public String oxMesPage() throws Exception {
		return prefix + "/oxMesage";
	}

	/**
	 * 五級顯示頁面
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/exchange/oxMesage")
	@ResponseBody
	public void oxMesage(HttpServletResponse resp) throws IOException {
		List<Map> lst = exChangeService.oxMes(market_id);
		JSONObject json = new JSONObject();
		json.put("lst", lst);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}

	/**
	 * 打印跳转接口
	 * 
	 * @param request
	 * @param resp
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/exchange/print")
	public String print(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		// 创建输入流
		return prefix + "/print";
	}
	
	/**
	 * 打印跳转接口2
	 * 
	 * @param request
	 * @param resp
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/exchange/printf")
	public String printf(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		// 创建输入流
		return prefix + "/printf";
	}

	@RequestMapping("/exchange/priReturn")
	public void priReturn(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		List<Map> lst1 = exChangeService.priReturn(market_id);
		System.out.println((String)lst1.get(0).get("sell_tel"));
		List<Map> lst2 = exChangeService.priReturn((String)lst1.get(0).get("sell_tel"));
		JSONObject json = new JSONObject();
		json.put("lst1", lst1);
		json.put("lst2", lst2);
		if(cuser_imports.equals("买入")) {
			json.put("boo", true);
		}
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
	}
}
