package com.flyroc.ox_online.project.biz.oxMng.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.flyroc.ox_online.project.biz.activation.domain.Activation;
import com.flyroc.ox_online.project.biz.oxMng.domain.OxMng;
import com.flyroc.ox_online.project.biz.oxMng.mapper.OxMngMapper;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flyroc.ox_online.project.biz.oxMng.service.OxMngService;

/**
 * 办卡激活Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class OxMngServiceImpl implements OxMngService{

	@Autowired
	private OxMngMapper OxMngMapper;
	
	//显示查询
	@Override
	public List<OxMng> selectOxsele(OxMng ox) {
		// TODO Auto-generated method stub
		String a = ox.getOx_state();
		// 转换 内容 对应 的 数字
		if(a != null && !a.equals("")) {
			if(a.equals("下架")) {
				ox.setOx_state("0");
			}else if(a.equals("审核")) {
				ox.setOx_state("1");
			}else if(a.equals("上架")) {
				ox.setOx_state("2");
			}else {
				ox.setOx_state("3");
			}
		}
		List<OxMng> mmap = OxMngMapper.selectOxsele(ox);
		int c = 0;
		// 转换 数字 对应 的 内容 
		for (OxMng map2 : mmap) {
			Object s = map2.getOx_state();
			if(s != null) {
				if(s.equals("0")) {
					mmap.get(c).setOx_state("已下架");
				}else if(s.equals("1")) {
					mmap.get(c).setOx_state("申请中");
				}else if(s.equals("2")) {
					mmap.get(c).setOx_state("已上架");
				}else {
					mmap.get(c).setOx_state("已售");
				}
			}
			c++;
		}
		
		return mmap;
	}
	
	//查询下拉框
	@Override
	public List<OxMng> selectoxTypeId() {
		// TODO Auto-generated method stub
		return OxMngMapper.selectoxTypeId();
	}
	
	//查询下拉框
	@Override
	public List<OxMng> selectoxState() {
		// TODO Auto-generated method stub
		List<OxMng> list = OxMngMapper.selectoxState();
		int a=0;
		// 转换 数字 对应 的 内容 
		for (OxMng ox : list) {
			switch (ox.getOx_state()) {
			case "0":
				list.get(a).setOx_state("下架");
				break;
			case "1":
				list.get(a).setOx_state("审核");
				break;
			case "2":
				list.get(a).setOx_state("上架");
				break;
			default:
				list.get(a).setOx_state("已售");
				break;
			}
			a++;
		}
		return list;
	}
	
	//更新状态
	@Override
	public int updateOxState1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return OxMngMapper.updateOxState1(map);
	}
	
	//更新状态
	@Override
	public int updateOxState2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return OxMngMapper.updateOxState2(map);
	}
	
	//更新状态
	@Override
	public int deleteOxState(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return OxMngMapper.deleteOxState(map);
	}
	
	//审核显示
	@Override
	public List<Map<String, Object>> selectOxCenSto(String str) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> ma = OxMngMapper.selectOxCenSto(str);
		int age_unit = (int) ma.get(0).get("age_unit");
		// 根据 查到的 后缀对应的数字 添加一些 后缀
		if(age_unit == 1) {
			ma.get(0).put("nl", ma.get(0).get("nl") + "月");
		}else {
			ma.get(0).put("nl", ma.get(0).get("nl") + "年");
		}
		ma.get(0).put("tz", ma.get(0).get("tz") + "斤");
		return ma;
	}

	@Override
	public Map<String, Object> selectOxState2(String str) {
		// TODO Auto-generated method stub
		return OxMngMapper.selectOxState2(str);
	}
	
	




}
