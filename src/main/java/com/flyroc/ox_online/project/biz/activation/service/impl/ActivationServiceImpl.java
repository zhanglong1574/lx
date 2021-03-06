package com.flyroc.ox_online.project.biz.activation.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyroc.ox_online.common.utils.text.Convert;
import com.flyroc.ox_online.project.biz.activation.domain.Activation;
import com.flyroc.ox_online.project.biz.activation.domain.Str;
import com.flyroc.ox_online.project.biz.activation.mapper.ActivationMapper;
import com.flyroc.ox_online.project.biz.activation.service.ActivationService;

/**
 * 办卡激活Service业务层处理
 *
 * @author ruoyi
 */
@Service
public class ActivationServiceImpl implements ActivationService {

	@Autowired
	private ActivationMapper ActivationMapper;


	/**
	 * 查询办卡激活列表
	 *
	 * @param hyOxMarket 办卡激活
	 * @return 办卡激活
	 */
	@Override
	public List<Activation> selectHyOxMarketList(Activation activation) {
		// TODO Auto-generated method stub
		List<Activation> list = ActivationMapper.selectHyOxMarketList(activation);
		int a = 0;
		// 转换 数字 对应 的 内容 
		for (Activation activation1 : list) {
			if (activation1.getIsActivate().equals("0")) {
				list.get(a).setIsActivate("未激活");
			} else {
				list.get(a).setIsActivate("已激活");
			}
			a++;
		}
		return list;
	}

	/**
	 * 查看显示
	 */
	@Override
	public List<Activation> selectHyOxMarketById(String userId) {
		// TODO Auto-generated method stub
		List<Activation> list = ActivationMapper.selectHyOxMarketById(userId);
		int a = 0;
		// 转换 数字 对应 的 内容 
		for (Activation activation1 : list) {
			if (activation1.getIsFreeze().equals("0")) {
				list.get(a).setIsFreeze("未冻结");
			} else {
				list.get(a).setIsFreeze("已冻结");
			}
			if (activation1.getIsActivate().equals("0")) {
				list.get(a).setIsActivate("未激活");
			} else {
				list.get(a).setIsActivate("已激活");
			}
			a++;
		}
		return list;
	}
	// 统计 办卡人数
	@Override
	public List<HashMap<String, Object>> selectHyOxMarketCount() {
		// TODO Auto-generated method stub
		return ActivationMapper.selectHyOxMarketCount();
	}

	// 统计最大值
	@Override
	public List<HashMap<String, Object>> selectHyOxMarketMax() {
		// TODO Auto-generated method stub
		return ActivationMapper.selectHyOxMarketMax();
	}

	// 统计最小值
	@Override
	public List<HashMap<String, Object>> selectHyOxMarketMin() {
		// TODO Auto-generated method stub
		return ActivationMapper.selectHyOxMarketMin();
	}

	// 个人 统计 入市数量 入市次数
	@Override
	public List<HashMap<String, Object>> selectvarieties(Str str) {
		// TODO Auto-generated method stub
		Date date = new Date();// 获取当前时间
		//转换为字符串形式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cd = Calendar.getInstance();
		cd.setTime(date);
		// 根据 str的内容 写入 一个月 或 一年的 时间
		if (str.getStr() != null) {
			if (str.getStr().equals("一月内")) {
				cd.add(cd.DATE, 1);
				date = cd.getTime();
				str.setY(sdf.format(date));
				cd.add(cd.MONTH, -1);
				date = cd.getTime();
				str.setN(sdf.format(date));
			} else if (str.getStr().equals("一年内")) {
				cd.add(cd.DATE, 1);
				date = cd.getTime();
				str.setY(sdf.format(date));
				cd.add(cd.YEAR, -1);
				date = cd.getTime();
				str.setN(sdf.format(date));
			}
		}
		List<HashMap<String, Object>> map = ActivationMapper.selectvarieties(str);
		if (map == null) {
			map = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> mmap = new HashMap<String, Object>();
			mmap.put("marcount", 0);
			mmap.put("vsum", 0);
			map.add(mmap);
		}
		return map;
	}
	// 个人 统计 交易数量
	@Override
	public HashMap<String, Object> selectmarket(Str str) {
		// TODO Auto-generated method stub
		Date date = new Date();// 获取当前时间
		//转换为字符串形式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cd = Calendar.getInstance();
		cd.setTime(date);
		// 根据 str的内容 写入 一个月 或 一年的 时间
		if (str.getStr() != null) {
			if (str.getStr().equals("一月内")) {
				cd.add(cd.DATE, 1);
				date = cd.getTime();
				str.setY(sdf.format(date));
				cd.setTime(date);
				cd.add(cd.MONTH, -1);
				date = cd.getTime();
				str.setN(sdf.format(date));
			} else if (str.getStr().equals("一年内")) {
				cd.add(cd.DATE, 1);
				date = cd.getTime();
				str.setY(sdf.format(date));
				cd.setTime(date);
				cd.add(cd.YEAR, -1);
				date = cd.getTime();
				str.setN(sdf.format(date));
			}
		}
		HashMap<String, Object> map = ActivationMapper.selectmarket(str);
		// 如果为 空
		if (map == null) {
			map = new HashMap<String, Object>();
			// 写入 - 号
			map.put("mcount", "-");
		}
		return map;
	}

	// 卡号激活
	@Override
	public int updateHystore(Activation str) {
		// TODO Auto-generated method stub
		return ActivationMapper.updateHystore(str);
	}

	// 卡号是否绑定查询
	@Override
	public List<Activation> selectkh(Activation activation) {
		// TODO Auto-generated method stub
		return ActivationMapper.selectkh(activation);
	}
	
	public List<Activation> selectRegisterById(String user_id) {
		return ActivationMapper.selectRegisterById(user_id);
	}
    //入市出市查看记录

	/**
	 * 删除办卡激活对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteHyOxMarketByIds(String ids)
	{
		return ActivationMapper.deleteHyOxMarketByIds(Convert.toStrArray(ids));
	}
	//商家管理
	@Override
	public Map<String, Object> selectStoreService(String b) {
		// TODO Auto-generated method stub
		Map<String, Object> list = ActivationMapper.selectStoreService(b);
		int a = 0;
		// 根据是否冻结 数字转换为对应内容
			if(list.get("is_freeze").equals("0")) {
				list.put("is_freeze", "否");
			}else {
				list.put("is_freeze", "是");
			}
			// 根据店铺状态 数字转换为对应内容
			if(list.get("store_state").equals("0")) {
				list.put("store_state", "驳回");
			}else if(list.get("store_state").equals("1")){
				list.put("store_state", "正常");
			}else if(list.get("store_state").equals("2")){
				list.put("store_state", "通过");
			}else if(list.get("store_state").equals("3")){
				list.put("store_state", "待审核");
			}else if(list.get("store_state").equals("9")){
				list.put("store_state", "经理人");
			}
		return list;
	}
	//商家管理查看
	@Override
	public List<Activation> selectStore(Activation b) {
		// TODO Auto-generated method stub
		if(b.getIsFreeze() != null) {
			// 根据是否冻结 内容转换为对应数字
			if(b.getIsFreeze().equals("请选择")) {
				b.setIsFreeze("");
			}else if(b.getIsFreeze().equals("是")){
				b.setIsFreeze("1");
			}else {
				b.setIsFreeze("0");
			}
		}
		List<Activation> list = ActivationMapper.selectStore(b);
		int a = 0;
		for (Activation hashMap : list) {
			// 根据是否冻结 数字转换为对应内容
			if(hashMap.getIsFreeze().equals("0")) {
				list.get(a).setIsFreeze("否");
			}else {
				list.get(a).setIsFreeze("是");
			}
			// 根据店铺状态 数字转换为对应内容
			if(hashMap.getStoreState().equals("0")) {
				list.get(a).setStoreState("驳回");
			}else if(hashMap.getStoreState().equals("1")){
				list.get(a).setStoreState("正常");
			}else if(hashMap.getStoreState().equals("2")){
				list.get(a).setStoreState("通过");
			}else if(hashMap.getStoreState().equals("3")){
				list.get(a).setStoreState("待审核");
			}else if(hashMap.getStoreState().equals("9")){
				list.get(a).setStoreState("经理人");
			}
			a++;
		}
		return list;
	}
	//是否冻结查询
	@Override
	public List<Activation> selectisFreeze() {
		// TODO Auto-generated method stub
		List<Activation> list = ActivationMapper.selectisFreeze();
		int a = 0;
		// 根据是否冻结 数字转换为对应内容
		for (Activation activation : list) {
			if(activation.getIsFreeze().equals("0")) {
				list.get(a).setIsFreeze("否");
			}else {
				list.get(a).setIsFreeze("是");
			}
			a++;
		}
		return list;
	}
	//更新是否冻结信息
	@Override
	public int updateIsFreeze(Activation a) {
		// TODO Auto-generated method stub
		return ActivationMapper.updateIsFreeze(a);
	}
	//查询农场规模下拉框
	@Override
	public List<String> selectfarmSize() {
		// TODO Auto-generated method stub
		return ActivationMapper.selectfarmSize();
	}
	//查询服务中心下拉框
	@Override
	public List<Map<String, Object>> selectserviceCenter() {
		// TODO Auto-generated method stub
		return ActivationMapper.selectserviceCenter();
	}
	//更新编辑信息
	@Override
	public int updateStore(Activation a) {
		// TODO Auto-generated method stub
		// 根据是否冻结 内容转换为对应数字
		if(a.getIsFreeze().equals("是")) {
			a.setIsFreeze("1");
		}else {
			a.setIsFreeze("0");
		}
		return ActivationMapper.updateStore(a);
	}
    //根据电话号查姓名
    @Override
    public String selectNameByTel(long storeTel){

        return ActivationMapper.selectNameByTel(storeTel);
    }
	//根据电话号查姓名
    @Override
	public String selectIdByTel(long storeTel){

        return ActivationMapper.selectIdByTel(storeTel);
    }
	//根据卡号查数据
	public List<Activation> selectActivationByCardId(String cid){

		return ActivationMapper.selectActivationByCardId(cid);
	}


}
