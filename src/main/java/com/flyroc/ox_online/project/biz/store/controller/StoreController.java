package com.flyroc.ox_online.project.biz.store.controller;

import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.flyroc.ox_online.common.utils.poi.ExcelUtil;
import com.flyroc.ox_online.framework.aspectj.lang.annotation.Log;
import com.flyroc.ox_online.framework.aspectj.lang.enums.BusinessType;
import com.flyroc.ox_online.framework.web.controller.BaseController;
import com.flyroc.ox_online.framework.web.domain.AjaxResult;
import com.flyroc.ox_online.framework.web.page.TableDataInfo;
import com.flyroc.ox_online.project.biz.activation.domain.Activation;
import com.flyroc.ox_online.project.biz.activation.domain.Str;
import com.flyroc.ox_online.project.biz.activation.service.ActivationService;
import com.flyroc.ox_online.project.biz.oxMng.domain.OxMng;

/**
 * 参数配置 信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/biz/store")
public class StoreController extends BaseController{
	private String prefix = "biz/store";

	@Autowired
	private ActivationService activationService;

	String us = "";


	@RequiresPermissions("biz:store:view")
	@GetMapping()
	public String oxMarket(){
		return prefix + "/list";
	}

	/**
	 * 查询参数配置列表
	 */
	@RequiresPermissions("biz:store:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Activation activation)
	{
		startPage();
		//搜索显示查询
		List<Activation> list = activationService.selectStore(activation);
		return getDataTable(list);
	}

	/**
	 *	是否冻结下拉框显示
	 */
	@PostMapping("/gg")
	@ResponseBody
	public void gg(HttpServletRequest request, HttpServletResponse response){
		JSONObject json = new JSONObject();
		// 是否冻结下拉框显示查询
		List<Activation> list = activationService.selectisFreeze();
		json.put("list", list);
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
	 *	更新是否冻结信息
	 */
	@PostMapping("/dd")
	@ResponseBody
	public void dd(HttpServletRequest request, HttpServletResponse response){
		JSONObject json = new JSONObject();
		// 获取值写入 实体类
		Activation ac = new Activation();
		ac.setUserId(request.getParameter("id"));
		ac.setIsFreeze(request.getParameter("i"));
		// 更新是否冻结信息
		int a = activationService.updateIsFreeze(ac);
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
	 * 导出列表
	 */
	@RequiresPermissions("biz:store:export")
	@Log(title = "商家管理", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Activation activation)
	{
		// 根据搜索条件查询 
		List<Activation> list = activationService.selectStore(activation);
		// 导出
		ExcelUtil<Activation> util = new ExcelUtil<Activation>(Activation.class);
		return util.exportExcel(list, "varieties");
	}



	/**
	 *  删除品种
	 */
	@RequiresPermissions("biz:store:remove")
	@Log(title = "品种", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		//根据获取的id数组进行删除 
		return toAjax(activationService.deleteHyOxMarketByIds(ids));
	}

	/**
	 * 查看按钮显示
	 */
	@GetMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") String userId, ModelMap mmap)
	{
		//根据id查询信息
		Map<String, Object> list = activationService.selectStoreService(userId);
		// 使用ModelMap传到前台
		mmap.put("list", list);

		return prefix + "/edit";
	}


	/**
	 * 编辑按钮
	 */
	@GetMapping("/add/{userId}")
	public String add(@PathVariable("userId") String userId, ModelMap mmap)
	{
		//根据id查询信息
		Map<String, Object> list = activationService.selectStoreService(userId);
		// 使用ModelMap传到前台
		mmap.put("list", list);
		
		return prefix + "/add";
	}
	
	/**
	 *	下拉框显示
	 */
	@PostMapping("/gs")
	@ResponseBody
	public void gs(HttpServletRequest request, HttpServletResponse response){
		JSONObject json = new JSONObject();
		//农场规模下拉框
		List<Map<String, Object>> Center = activationService.selectserviceCenter();
		//服务中心下拉框
		List<String> size = activationService.selectfarmSize();
		json.put("Center", Center);
		json.put("size", size);
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
	 *	编辑按钮
	 */
	@PostMapping("/xgsh")
	@ResponseBody
	public void xgsh(HttpServletRequest request, HttpServletResponse response){
		JSONObject json = new JSONObject();
		Activation ac = new Activation();
		ac.setUserId(request.getParameter("user_id"));
		ac.setHyName(request.getParameter("hy_name"));
		ac.setFarmAddress(request.getParameter("farm_address"));
		ac.setStoreTel(request.getParameter("store_tel"));
		ac.setLogoUrl(request.getParameter("logo_url"));
		ac.setLoginName(request.getParameter("login_name"));
		ac.setIsFreeze(request.getParameter("is_freeze"));
		ac.setFarmSize(request.getParameter("farm_size"));
		ac.setServiceCenter(request.getParameter("service_center"));
		// 更新编辑信息
		int a = activationService.updateStore(ac);
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
	 *	RequestParam（“file”）: formData中的name=“file”，指文件
	 *	String imgsrc：formData中的name="imgsrc"，指路径
	 *	由于本次只有一个文件，故 MultipartFile 不用数组形式  // MultipartFile[]
	 */
	@RequestMapping("/file")
	@ResponseBody
	public void uploadPicture(@RequestParam("file") MultipartFile file, String imgsrc, HttpServletRequest request,HttpServletResponse response) throws Exception {
 		String filePath = Class.class.getClass().getResource("/").getPath() + "static/";
		if(StringUtils.isNotBlank(imgsrc)){    //判断路径是否为空，如果不为空，说明已经有了一张图片，那我点击上传文件按钮就要替换掉这张图片，为了不占电脑容量，同时要删掉本地文件
			String initPicPath = filePath + imgsrc;
			File initFile = new File(initPicPath);
			if(initFile.exists() && initFile.isFile()){
				initFile.delete();    //删除文件
			}
		}
		String fileName = file.getOriginalFilename();    //获取文件名称
		//  以下为创建新存储的文件路径
		String uuidFileName =  UUID.randomUUID().toString() + fileName;
		String localPath = filePath + "file/image/";
		File upimagesFile = new File(localPath);  // 没有D://test/upimage文件夹的话就新疆文件夹
		if (!upimagesFile.exists()) {
			upimagesFile.mkdirs();
		}
		String localFilePath = localPath + uuidFileName;
		
		File picFile = new File(localFilePath);   //创建图片文件
		if (!picFile.exists()) {
			picFile.createNewFile();
		}
		file.transferTo(picFile);   //保存文件
		try {
			JSONObject json = new JSONObject();
			json.put("i" , "file/image/" + uuidFileName);
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = null;
			out = response.getWriter();
			out.write(json.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		return "保存成功";//若使用方法1，则返回文件保存提示即可，或者不返回也行
		// return upimages + uuidFileName;   //若使用方法2，则返回文件路径
	}





}
