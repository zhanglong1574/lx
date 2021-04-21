package com.flyroc.ox_online.project.biz.exChange.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.flyroc.ox_online.project.biz.exChange.domain.AddMessage;
import com.flyroc.ox_online.project.biz.exChange.domain.SelectAll;

/**
 * 参数配置 数据层
 * 
 * @author ruoyi
 */
public interface ExchangeMapper {
	/**
	 * 显示
	 * 
	 * @param sall
	 * @return
	 */
	public abstract List<Map> selectAllExchange(SelectAll sall);

	/**
	 * 汇总
	 * 
	 * @param newTime1
	 * @param newTime2
	 * @return
	 */
	public abstract String selectCount1(@Param("newTime1") String newTime1, @Param("newTime2") String newTime2);

	public abstract String selectCount2(@Param("newTime1") String newTime1, @Param("newTime2") String newTime2);

	public abstract String selectCount3(@Param("newTime1") String newTime1, @Param("newTime2") String newTime2);

	public abstract String selectCount4(@Param("newTime1") String newTime1, @Param("newTime2") String newTime2);

	/**
	 * 二级显示
	 */
	public abstract List<Map> selectShow(String stus, String print_status, String sell_way, String user_imports,
			String date, String dateEnd, String opt1, String opt2);

	/**
	 * 交易记录作废
	 */
	public abstract void listdel(String hmmId);

	/**
	 * 判断是否存在电话
	 * 
	 * @param sall
	 * @return
	 */
	public abstract List<Map> Pefsell_tel(String tel);

	/**
	 * 查找电话
	 * 
	 * @param card_id
	 * @return
	 */
	public abstract List<Map> storeMesSel(String card_id);
	
	/**
	 * 查找商户信息
	 * 
	 * @param card_id
	 * @return
	 */
	public abstract String Pefsell_suid(String user_id);

	
	/**
	 * 查找品种
	 * 
	 * @return
	 */
	public abstract List<Map> varietiesSel();

	/**
	 * 交易大厅信息记录新增
	 * 
	 * @param addMessage
	 */
	public abstract void btAdd(AddMessage addMessage);

	public abstract void btAddCopy(AddMessage addMessage);

	public abstract void MbtAdd(AddMessage addMessage);

	public abstract void MbtAddCopy(AddMessage addMessage);

	/**
	 * 三级页面显示
	 * 
	 * @param market_id
	 * @return
	 */
	public abstract List<Map> AddMessCopy(String market_id);

	/**
	 * 三级页面修改
	 * 
	 * @param addMessage
	 */
	public abstract void AddMessCopyUpdate(AddMessage addMessage);

	/**
	 * 四级显示
	 * 
	 * @param market_id
	 * @return
	 */
	public abstract List<Map> onSel(String market_id);

	/**
	 * 五级显示
	 * 
	 * @param market_id
	 * @return
	 */
	public abstract List<Map> oxMes(String market_id);
	
	public abstract List<Map> priReturn(String market_id);
	public abstract List<Map> priReturns(String store_tel);
	
}
