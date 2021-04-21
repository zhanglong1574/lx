package com.flyroc.ox_online.project.biz.activation.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flyroc.ox_online.project.biz.activation.domain.Activation;
import com.flyroc.ox_online.project.biz.activation.domain.Str;

/**
 * 办卡激活Mapper接口
 * 
 * @author ruoyi
 */
public interface ActivationMapper{


	/**
	 * 查询
	 */
	public List<Activation> selectHyOxMarketList(Activation activation);

	/**
	 * 查看显示
	 */
	public List<Activation> selectHyOxMarketById(String userId);

	// 统计 办卡人数
	public List<HashMap<String,Object>> selectHyOxMarketCount();
	// 统计 最大值
	public List<HashMap<String,Object>> selectHyOxMarketMax();
	// 统计最小值
	public List<HashMap<String,Object>> selectHyOxMarketMin();
	//个人 统计 入市数量 入市次数
	public List<HashMap<String,Object>> selectvarieties(Str str);
	//个人 统计 交易数量
	public HashMap<String,Object> selectmarket(Str str);
	// 卡号是否绑定查询
	public List<Activation> selectkh(Activation activation);
	// 卡号激活
	public int updateHystore(Activation str);
	//入市出市查看记录
	public List<Activation> selectRegisterById(String user_id);

	/**
	 * 批量删除办卡激活
	 * 
	 * @param strings 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyOxMarketByIds(String[] strings);

	// 商家管理显示
	public List<Activation> selectStore(Activation a);
	// 商家管理查看显示
	public Map<String, Object> selectStoreService(String a);
	// 是否冻结下拉框显示
	public List<Activation> selectisFreeze();
	// 农场规模下拉框显示
	public List<String> selectfarmSize();
	// 服务中心下拉框显示
	public List<Map<String, Object>> selectserviceCenter();
	// 更新是否冻结
	public int updateIsFreeze(Activation a);
	// 更新编辑
		public int updateStore(Activation a);
	//根据电话号查姓名
	public String selectNameByTel(long storeTel);
	//根据电话号查id
	public String selectIdByTel(long storeTel);
	//根据卡号查数据
	public List<Activation> selectActivationByCardId(String cid);
}
