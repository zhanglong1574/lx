package com.flyroc.ox_online.project.biz.varieties.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyroc.ox_online.project.biz.Rrecords.mapper.RrecordsMapper;
import com.flyroc.ox_online.project.biz.activation.mapper.ActivationMapper;
import com.flyroc.ox_online.project.biz.exChange.domain.SelectAll;
import com.flyroc.ox_online.project.biz.exChange.mapper.ExchangeMapper;
import com.flyroc.ox_online.project.biz.varieties.domain.Varieties;
import com.flyroc.ox_online.project.biz.varieties.mapper.VarietiesMapper;

/**
 * 参数配置 服务层实现
 * 
 * @author ruoyi
 */
@Service("varietiesService")
public class VarietiesServiceImpl implements VarietiesService{
	
    @Autowired
    private VarietiesMapper varietiesMapper;

    /**
     * 查询显示操作
     */
	@Override
	public List<Map> selectAll() throws Exception {
		return varietiesMapper.selectAll();
	}

	/**
	 * 删除操作
	 */
	@Override
	public void listdel(String varieties_id) {
		varietiesMapper.listdel(varieties_id);
	}

	/**
	 * 添加操作
	 */
	@Override
	public void listInsert(Varieties varieties) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		varieties.setCreate_time(sdf.format(new Date()));
		varieties.setVarieties_id(java.util.UUID.randomUUID().toString().replaceAll("-", ""));
		varietiesMapper.listInsert(varieties);
	}

	/**
	 * 更新操作
	 */
	@Override
	public void listUpdate(Varieties varieties) {
		// TODO Auto-generated method stub
		varietiesMapper.listUpdate(varieties);
	}

	/**
	 * 根据id查找
	 */
	@Override
	public Varieties listFindById(String varieties_id) {
		// TODO Auto-generated method stub
		return varietiesMapper.listFindById(varieties_id);
	}

	@Override
	public Varieties Pefsell_vn(String vn) {
		// TODO Auto-generated method stub
		return varietiesMapper.Pefsell_vn(vn);
	}

	@Override
	public List<Map> selListdel(String varieties_id) {
		// TODO Auto-generated method stub
		return varietiesMapper.selListdel(varieties_id);
	}
   
}
