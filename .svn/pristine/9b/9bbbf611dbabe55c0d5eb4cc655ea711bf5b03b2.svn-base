package com.flyroc.ox_online.project.biz.varieties.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyroc.ox_online.framework.aspectj.lang.annotation.Excel;
import com.flyroc.ox_online.framework.web.domain.BaseEntity;

/**
 * 品种对象 hy_varieties
 * 
 * @author auto
 * @date 2021-01-18
 */
public class HyVarieties extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 品种Id */
    @Excel(name = "品种Id")
    private String varietiesId;

    /** 品种名 */
    @Excel(name = "品种名")
    private String varietiesName;

    /** 服务费 */
    @Excel(name = "服务费")
    private String serviceFee;

    /** 定金 */
    @Excel(name = "定金")
    private String beforePrice;

    public void setVarietiesId(String varietiesId) 
    {
        this.varietiesId = varietiesId;
    }

    public String getVarietiesId() 
    {
        return varietiesId;
    }
    public void setVarietiesName(String varietiesName) 
    {
        this.varietiesName = varietiesName;
    }

    public String getVarietiesName() 
    {
        return varietiesName;
    }
    public void setServiceFee(String serviceFee) 
    {
        this.serviceFee = serviceFee;
    }

    public String getServiceFee() 
    {
        return serviceFee;
    }
    public void setBeforePrice(String beforePrice) 
    {
        this.beforePrice = beforePrice;
    }

    public String getBeforePrice() 
    {
        return beforePrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("varietiesId", getVarietiesId())
            .append("varietiesName", getVarietiesName())
            .append("serviceFee", getServiceFee())
            .append("beforePrice", getBeforePrice())
            .append("createTime", getCreateTime())
            .toString();
    }
}
