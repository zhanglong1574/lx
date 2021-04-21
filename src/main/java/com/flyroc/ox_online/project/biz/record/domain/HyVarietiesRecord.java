package com.flyroc.ox_online.project.biz.record.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyroc.ox_online.framework.aspectj.lang.annotation.Excel;
import com.flyroc.ox_online.framework.web.domain.BaseEntity;

/**
 * 牛市交易附表对象 hy_varieties_record
 * 
 * @author auto
 * @date 2021-01-19
 */
public class HyVarietiesRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 交易或入市Id */
    @Excel(name = "交易或入市Id")
    private String dealId;

    /** 进市场数量 */
    @Excel(name = "进市场数量")
    private Long num;

    /** 品种Id */
    @Excel(name = "品种Id")
    private String varietiesId;

    /** 交易牛id */
    @Excel(name = "交易牛id")
    private String oxId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setDealId(String dealId) 
    {
        this.dealId = dealId;
    }

    public String getDealId() 
    {
        return dealId;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }
    public void setVarietiesId(String varietiesId) 
    {
        this.varietiesId = varietiesId;
    }

    public String getVarietiesId() 
    {
        return varietiesId;
    }
    public void setOxId(String oxId) 
    {
        this.oxId = oxId;
    }

    public String getOxId() 
    {
        return oxId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dealId", getDealId())
            .append("num", getNum())
            .append("varietiesId", getVarietiesId())
            .append("oxId", getOxId())
            .toString();
    }
}
