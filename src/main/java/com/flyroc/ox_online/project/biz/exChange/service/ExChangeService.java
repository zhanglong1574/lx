package com.flyroc.ox_online.project.biz.exChange.service;

import java.util.List;
import java.util.Map;

import com.flyroc.ox_online.project.biz.exChange.domain.AddMessage;
import com.flyroc.ox_online.project.biz.exChange.domain.SelectAll;

/**
 * 参数配置 服务层
 * 
 * @author ruoyi
 */
public interface ExChangeService {

	/**
	 * 显示
	 * 
	 * @param sall
	 * @return
	 * @throws Exception
	 */
	public abstract List<Map> selectAll(SelectAll sall) throws Exception;

	/**
	 * 汇总
	 * 
	 * @return
	 */
	public abstract List<Map> selectCount();

	/**
	 * 二级显示
	 */
	public abstract List<Map> selectShow(String stus, String print_status, String sell_way, String user_imports,
			String date) throws Exception;

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

	public abstract List<Map> storeMesSel(String card_id);

	public abstract List<Map> varietiesSel();

	/**
	 * 交易記錄添加操作
	 * 
	 * @param addMessage
	 */
	public abstract void btAdd(AddMessage addMessage);

	/**
	 * 三級頁面顯示
	 * 
	 * @param market_id
	 * @return
	 */
	public abstract List<Map> AddMessCopy(String market_id);

	/**
	 * 三級頁面更新操作
	 * 
	 * @param addMessage
	 */
	public abstract void AddMessCopyUpdate(AddMessage addMessage);

	/**
	 * 四級頁面顯示
	 * 
	 * @param market_id
	 * @return
	 */
	public abstract List<Map> onSel(String market_id);

	/**
	 * 五级页面显示
	 * 
	 * @param market_id
	 * @return
	 */
	public abstract List<Map> oxMes(String market_id);
	
	public abstract List<Map> priReturn(String market_id);
	public abstract List<Map> priReturns(String store_tel);
}
