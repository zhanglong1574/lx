package com.flyroc.ox_online.project.biz.exChange.statistics.controller;

import com.flyroc.ox_online.framework.web.controller.BaseController;
import com.flyroc.ox_online.framework.web.page.TableDataInfo;
import com.flyroc.ox_online.project.biz.exChange.statistics.service.IStatisticsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/biz/exchange/statistics")
public class StatisticsController extends BaseController {

	private String prefix = "biz/exchange/statistics";

	@Autowired
	private IStatisticsService statisticsService;

	@RequiresPermissions("biz:statistics:view")
	@GetMapping()
	public String statistics(ModelMap mmap) {
		List<String> months=new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH,-12);
		for (int i = 0; i < 12; i++) {
			Date date = calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			String dateStr = sdf.format(date);
			months.add(dateStr);
			calendar.add(Calendar.MONTH,1);
		}

		List<Map> list1 = statisticsService.selectMarket1();
		List<Map> list2 = statisticsService.selectMarket2();
		List<Map> list5 = statisticsService.selectMarket5();
		List<Map> list6 = statisticsService.selectMarket6();
		List<Map> list7 = statisticsService.selectMarket7();
		List<Map> list8 = statisticsService.selectMarket8();
		List<Map> list9 = statisticsService.selectMarket9();
		List<Map> list10 = statisticsService.selectMarket10();

		mmap.put("months",months);
		mmap.put("list1", list1);
		mmap.put("list2", list2);
		mmap.put("list5", list5);
		mmap.put("list6", list6);
		mmap.put("list7", list7);
		mmap.put("list8", list8);
		mmap.put("list9", list9);
		mmap.put("list10", list10);
		return prefix + "/echarts";
	}

	/**
	 * 查询市场交易记录列表
	 */
	@RequiresPermissions("biz:statistics:list")
	@PostMapping("/list")
	@ResponseBody
	public String list()
	{

		return prefix + "/echarts";
	}
	/**
	 * //1
	<select id="selectMarket1"  parameterType="java.util.Map" resultType="java.util.Map">
		SELECT
			count(DATE_FORMAT(create_time, '%Y-%m')) as sl,
			DATE_FORMAT(create_time, '%m') as sj
		FROM
			hy_market
		where
			create_time like concat('%', #{create_time}, '%')
		GROUP BY
			DATE_FORMAT(create_time, '%Y-%m')
	</select>
	//2
	 <select id="selectMarket2" parameterType="com.flyroc.ox_online.project.biz.activation.domain.Str" resultType="java.util.Map">
		select
			COUNT(mar.market_id) as mcount,
			SUBSTRING(create_time,1,10)
		from
			hy_market as mar
		where
			(user_imports = 1 or user_imports = 3)
		<if test="y != null and y != ''">
				<![CDATA[ and mar.create_time < #{y} ]]>
		</if>
		<if test="n != null and n != ''">
				and mar.create_time >= #{n}
		</if>
		GROUP BY
			SUBSTRING(create_time,1,10)
	</select>
	//3
	<select id="selectMarket5" parameterType="com.flyroc.ox_online.project.biz.activation.domain.Str" resultType="java.util.Map">
		select
			COUNT(mar.market_id) as mcount,
			SUM(buy_price),
			SUBSTRING(create_time,1,10)
		from
			hy_market as mar
		where
			(user_imports = 1 or user_imports = 3)
			and 
			sell_way = 0
		GROUP BY
			SUBSTRING(create_time,1,10)
	</select>
	//4
	<select id="selectMarket6" parameterType="com.flyroc.ox_online.project.biz.activation.domain.Str" resultType="java.util.Map">
		select
			COUNT(mar.market_id) as mcount,
			SUM(buy_price),
			SUBSTRING(create_time,1,10)
		from
			hy_market as mar
		where
			(user_imports = 1 or user_imports = 3)
			and 
			sell_way = 1
		GROUP BY
			SUBSTRING(create_time,1,10)
	</select>
	//5
	<select id="selectMarket7" parameterType="com.flyroc.ox_online.project.biz.activation.domain.Str" resultType="java.util.Map">
		select
			COUNT(mar.market_id) as mcount
		from
			hy_market as mar
		where
			(user_imports = 1 or user_imports = 3)
		GROUP BY
			sell_way
	</select>
	//6
	<select id="selectMarket8" parameterType="com.flyroc.ox_online.project.biz.activation.domain.Str" resultType="java.util.Map">
		select
			SUM(buy_price)
		from
			hy_market as mar
		where
			(user_imports = 1 or user_imports = 3)
		GROUP BY
			sell_way
	</select>
	//7
	<select id="selectMarket9" parameterType="com.flyroc.ox_online.project.biz.activation.domain.Str" resultType="java.util.Map">
		select
			COUNT(SUBSTRING(create_time,1,10)) as mcount,
			SUBSTRING(create_time,1,10)
		from
			hy_ox as mar
		where
			id_type = 1
		GROUP BY
			SUBSTRING(create_time,1,10)
			
	</select>
	//8
	<select id="selectMarket10" parameterType="com.flyroc.ox_online.project.biz.activation.domain.Str" resultType="java.util.Map">
		select
			COUNT(SUBSTRING(create_time,1,10)) as mcount,
			SUBSTRING(create_time,1,10)
		from
			hy_store as mar
		GROUP BY
			SUBSTRING(create_time,1,10)
	</select>
	 */
}
