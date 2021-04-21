package com.flyroc.ox_online.project.biz.Rrecords.service;

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

/**
 * 参数配置 服务层实现
 * 
 * @author ruoyi
 */
@Service("rrecordsService")
public class RrecordsServiceImpl implements RrecordsService{
	
    @Autowired
    private RrecordsMapper rrecordsMapper;

    /**
     * 查询显示操作
     */
	@Override
	public List<Map> selectAll(String byre_id,String store_ower) throws Exception {
		return rrecordsMapper.selectAll(byre_id, store_ower);
	}

	/**
	 * 删除操作
	 */
	@Override
	public void listdel(String record_id) {
		rrecordsMapper.listdel(record_id);
	}
   
}
