package com.flyroc.ox_online.project.biz.exChange.domain;

import java.io.Serializable;
import java.util.Date;

import com.flyroc.ox_online.framework.web.domain.BaseEntity;

public class SelectAll extends BaseEntity implements Serializable{
	
	private String opt;
	private String store_ower;
	private String store_tel;
	private String date;
	//在几天内
	//用户姓名
	//用户电话
	//执行的日期
	
	
	public SelectAll(String opt, String store_ower, String store_tel, String date) {
		super();
		this.opt = opt;
		this.store_ower = store_ower;
		this.store_tel = store_tel;
		this.date = date;
	}
	
	
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	public String getStore_ower() {
		return store_ower;
	}
	public void setStore_ower(String store_ower) {
		this.store_ower = store_ower;
	}
	public String getStore_tel() {
		return store_tel;
	}
	public void setStore_tel(String store_tel) {
		this.store_tel = store_tel;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
}
