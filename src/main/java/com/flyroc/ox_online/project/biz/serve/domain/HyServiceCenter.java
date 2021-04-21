package com.flyroc.ox_online.project.biz.serve.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyroc.ox_online.framework.aspectj.lang.annotation.Excel;
import com.flyroc.ox_online.framework.web.domain.BaseEntity;

/**
 * 交易市场对象 hy_service_center
 *
 * @author auto
 * @date 2021-01-20
 */
public class HyServiceCenter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 交易市场名称 */
    @Excel(name = "交易市场名称")
    private String serviceCenter;

    /** 所在地（省市区） */
    @Excel(name = "所在地", readConverterExp = "省=市区")
    private String address;

    /** 负责人 */
    @Excel(name = "负责人")
    private String marketOwer;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String marketTel;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String marketAddress;

    /** 位置 */
    @Excel(name = "位置")
    private String location;

    /** 面积 */
    @Excel(name = "面积")
    private String area;

    /** 全名 */
    @Excel(name = "全名")
    private String fullName;

    /** 规模 */
    @Excel(name = "规模")
    private String scale;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setServiceCenter(String serviceCenter)
    {
        this.serviceCenter = serviceCenter;
    }

    public String getServiceCenter()
    {
        return serviceCenter;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setMarketOwer(String marketOwer)
    {
        this.marketOwer = marketOwer;
    }

    public String getMarketOwer()
    {
        return marketOwer;
    }
    public void setMarketTel(String marketTel)
    {
        this.marketTel = marketTel;
    }

    public String getMarketTel()
    {
        return marketTel;
    }
    public void setMarketAddress(String marketAddress)
    {
        this.marketAddress = marketAddress;
    }

    public String getMarketAddress()
    {
        return marketAddress;
    }
    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLocation()
    {
        return location;
    }
    public void setArea(String area)
    {
        this.area = area;
    }

    public String getArea()
    {
        return area;
    }
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getFullName()
    {
        return fullName;
    }
    public void setScale(String scale)
    {
        this.scale = scale;
    }

    public String getScale()
    {
        return scale;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("serviceCenter", getServiceCenter())
                .append("address", getAddress())
                .append("marketOwer", getMarketOwer())
                .append("marketTel", getMarketTel())
                .append("marketAddress", getMarketAddress())
                .append("location", getLocation())
                .append("area", getArea())
                .append("fullName", getFullName())
                .append("scale", getScale())
                .append("createTime", getCreateTime())
                .append("remark", getRemark())
                .toString();
    }
}