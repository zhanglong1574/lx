package com.flyroc.ox_online.project.biz.oxMng.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.flyroc.ox_online.framework.aspectj.lang.annotation.Excel;
import com.flyroc.ox_online.framework.web.domain.BaseEntity;

public class OxMng extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 /** 主键 */
    private String ox_id;

    /** 牛编号 */
    @Excel(name = "牛编号")
    private String ox_num;

    /** 黄牛品种编码 */
    @Excel(name = "黄牛品种编码")
    private String ox_type_id;
    
    /** 牧场主 */
    @Excel(name = "牧场主")
    private String goods_name;
    
    /** 原价 */
    @Excel(name = "原价")
    private String normal_price;
    
    /** 体重 */
    @Excel(name = "体重")
    private String tz;
    
    /** 分类 */
    @Excel(name = "分类")
    private String xb;
    
    /** 创建时间 */
    @Excel(name = "创建时间")
    private Date create_time;
    
    /** 状态 */
    @Excel(name = "状态")
    private String ox_state;
    
    
    
    public String getOx_id() {
		return ox_id;
	}



	public void setOx_id(String ox_id) {
		this.ox_id = ox_id;
	}



	public String getOx_num() {
		return ox_num;
	}



	public void setOx_num(String ox_num) {
		this.ox_num = ox_num;
	}



	public String getOx_type_id() {
		return ox_type_id;
	}



	public void setOx_type_id(String ox_type_id) {
		this.ox_type_id = ox_type_id;
	}



	public String getGoods_name() {
		return goods_name;
	}



	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}



	public String getNormal_price() {
		return normal_price;
	}



	public void setNormal_price(String normal_price) {
		this.normal_price = normal_price;
	}



	public String getTz() {
		return tz;
	}



	public void setTz(String tz) {
		this.tz = tz;
	}



	public String getXb() {
		return xb;
	}



	public void setXb(String xb) {
		this.xb = xb;
	}



	public Date getCreate_time() {
		return create_time;
	}



	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}



	public String getOx_state() {
		return ox_state;
	}



	public void setOx_state(String ox_state) {
		this.ox_state = ox_state;
	}



	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ox_id", getOx_id())
            .append("ox_num", getOx_num())
            .append("ox_type_id", getOx_type_id())
            .append("goods_name", getGoods_name())
            .append("normal_price", getNormal_price())
            .append("tz", getTz())
            .append("xb", getXb())
            .append("update_time", getCreate_time())
            .append("ox_state", getOx_state())
            .toString();
    }

	
}
