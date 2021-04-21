package com.flyroc.ox_online.project.biz.activation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.flyroc.ox_online.framework.aspectj.lang.annotation.Excel;
import com.flyroc.ox_online.framework.web.domain.BaseEntity;

/**
 * 参数配置表 hy_store
 * 
 * @author ruoyi
 */
public class Str extends BaseEntity{

	private static final long serialVersionUID = 1L;

	/** 主键 */
	private String userId;

	private String str;// 搜索条件

	private String y; // 根据搜索条件搜索的时间
	
	private String n; // 根据搜索条件搜索的时间

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	


}
