package com.flyroc.ox_online.project.biz.Rrecords.controller;

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
import com.flyroc.ox_online.framework.web.controller.BaseController;
import com.flyroc.ox_online.framework.web.page.TableDataInfo;
import com.flyroc.ox_online.project.biz.Rrecords.service.RrecordsService;
import com.flyroc.ox_online.project.biz.activation.domain.Activation;
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
public class RrecordsController extends BaseController{
	private String prefix = "system/rred";
	
	@Autowired
    private RrecordsService rrecordsService;
	
	@RequestMapping("/byre/lease")
    public String list()
    {
        return prefix+"/list";
    }
	
	/**
	 *     显示
	 * @param sall
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rrecords/listShow")
	@ResponseBody
    public TableDataInfo listShow(String byre_id,String store_ower) throws Exception{
		startPage();
		List<Map> lst = rrecordsService.selectAll(byre_id,store_ower);
        return getDataTable(lst);
    }
	
	/**
	 *     删除操作
	 * @param sall
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rrecords/listdel")
	@ResponseBody
    public void listdel(String record_id,HttpServletResponse resp) throws Exception{
		rrecordsService.listdel(record_id);
		JSONObject json =new JSONObject();
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json.toString());
    }
	
	
	 
}
