package com.flyroc.ox_online.project.biz.exChange.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyroc.ox_online.project.biz.activation.mapper.ActivationMapper;
import com.flyroc.ox_online.project.biz.exChange.domain.AddMessage;
import com.flyroc.ox_online.project.biz.exChange.domain.SelectAll;
import com.flyroc.ox_online.project.biz.exChange.mapper.ExchangeMapper;

/**
 * 参数配置 服务层实现
 * 
 * @author ruoyi
 */
@Service("exChangeService")
public class ExChangeServiceImpl implements ExChangeService {

	@Autowired
	private ExchangeMapper exchangeMapper;
	
	private String opt1;
	private String opt2;

	/**
	 * 一級頁面顯示
	 */
	@Override
	public List<Map> selectAll(SelectAll sall) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String opt = sall.getOpt();
		String dat = sall.getDate();
		// date默认为当天
		if (dat == null || "".equals(dat)) {
			sall.setDate(sdf1.format(new Date()));
		}
		Date newDate = sdf2.parse(sall.getDate());

		// 几天内？判断
		if (opt != null) {
			if (opt.equals("option1")) {
				calendar.setTime(newDate);
				calendar.add(Calendar.DATE, -3);
				opt = sdf1.format(calendar.getTime());
				sall.setOpt(opt);
				this.opt1 = opt;
			} else if (opt.equals("option2")) {
				calendar.setTime(newDate);
				calendar.add(Calendar.DATE, -7);
				opt = sdf1.format(calendar.getTime());
				sall.setOpt(opt);
				this.opt1 = opt;
			} else if (opt.equals("option3")) {
				calendar.setTime(newDate);
				calendar.add(Calendar.DATE, -30);
				;
				opt = sdf1.format(calendar.getTime());
				sall.setOpt(opt);
				this.opt1 = opt;
			}
		}
		this.opt2 = sall.getDate();
		return exchangeMapper.selectAllExchange(sall);
	}

	/**
	 * 汇总实现
	 */
	@Override
	public List<Map> selectCount() {
		// TODO Auto-generated method stub
		/**
		 * 以datetime的形式，明确范围在当天内
		 */
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		String newTime1 = sp.format(new Date(System.currentTimeMillis())) + " 00:00:00";
		String newTime2 = sp.format(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) + " 00:00:00";
		Map map = new HashMap<String, String>();
		map.put("usernum", exchangeMapper.selectCount1(newTime1, newTime2));
		map.put("vrnum", exchangeMapper.selectCount2(newTime1, newTime2));
		map.put("bynum", exchangeMapper.selectCount3(newTime1, newTime2));
		map.put("sernum", exchangeMapper.selectCount4(newTime1, newTime2));
		List<Map> lst = new ArrayList<Map>();
		lst.add(map);
		return lst;
	}

	/**
	 * 二级显示
	 * 
	 * @throws Exception
	 */
	@Override
	public List<Map> selectShow(String stus, String print_status, String sell_way, String user_imports, String date)
			throws Exception {
		// TODO Auto-generated method stub
		String dateEnd;
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		if (date == null || "".equals(date)) {
			date = "";
			dateEnd = "";
		} else {
			Date dateEnds = new Date();
			dateEnds.setTime(sp.parse(date).getTime() + 1000 * 60 * 60 * 24);
			dateEnd = sp.format(dateEnds) + " 00:00:00";
			date = date + " 00:00:00";
		}
		System.out.println(dateEnd + "-   **    -" + date);
		return exchangeMapper.selectShow(stus, print_status, sell_way, user_imports, date, dateEnd, this.opt1, this.opt2);
	}

	/**
	 * 交易记录作废
	 */
	@Override
	public void listdel(String hmmId) {
		exchangeMapper.listdel(hmmId);
	}

	/**
	 * 查詢電話號
	 */
	@Override
	public List<Map> Pefsell_tel(String tel) {
		// TODO Auto-generated method stub
		return exchangeMapper.Pefsell_tel(tel);
	}

	/**
	 * 查詢商店信息
	 */
	@Override
	public List<Map> storeMesSel(String card_id) {
		// TODO Auto-generated method stub
		return exchangeMapper.storeMesSel(card_id);
	}

	/**
	 * 查詢品種
	 */
	@Override
	public List<Map> varietiesSel() {
		// TODO Auto-generated method stub
		return exchangeMapper.varietiesSel();
	}

	/**
	 * 添加交易記錄
	 */
	@Override
	public void btAdd(AddMessage addMessage) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		addMessage.setCreate_time(sdf1.format(new Date()));
		addMessage.setId(java.util.UUID.randomUUID().toString().replaceAll("-", ""));
		addMessage.setMarket_id(java.util.UUID.randomUUID().toString().replaceAll("-", ""));
		addMessage.setDeal_id(java.util.UUID.randomUUID().toString().replaceAll("-", ""));
		exchangeMapper.btAdd(addMessage);
		exchangeMapper.btAddCopy(addMessage);

		
		addMessage.setId(java.util.UUID.randomUUID().toString().replaceAll("-", ""));
		addMessage.setMarket_id(java.util.UUID.randomUUID().toString().replaceAll("-", ""));
		addMessage.setDeal_id(java.util.UUID.randomUUID().toString().replaceAll("-", ""));
		String store_tel = exchangeMapper.Pefsell_suid(addMessage.getUser_id());
		addMessage.setUser_id(addMessage.getBystID());
		addMessage.setSell_tel(store_tel);
		exchangeMapper.MbtAdd(addMessage);
		exchangeMapper.MbtAddCopy(addMessage);
	}

	/**
	 * 三級頁面顯示
	 */
	@Override
	public List<Map> AddMessCopy(String market_id) {
		// TODO Auto-generated method stub
		return exchangeMapper.AddMessCopy(market_id);
	}

	/**
	 * 三級頁面更新
	 */
	@Override
	public void AddMessCopyUpdate(AddMessage addMessage) {
		// TODO Auto-generated method stub
		exchangeMapper.AddMessCopyUpdate(addMessage);
	}

	/**
	 * 四級頁面顯示
	 */

	@Override
	public List<Map> onSel(String market_id) {
		return exchangeMapper.onSel(market_id);
	}

	/**
	 * 五級頁面顯示
	 */
	@Override
	public List<Map> oxMes(String market_id) {
		// TODO Auto-generated method stub
		return exchangeMapper.oxMes(market_id);
	}

	@Override
	public List<Map> priReturn(String market_id) {
		// TODO Auto-generated method stub
		return exchangeMapper.priReturn(market_id);
	}

	@Override
	public List<Map> priReturns(String store_tel) {
		// TODO Auto-generated method stub
		return exchangeMapper.priReturns(store_tel);
	}


}
