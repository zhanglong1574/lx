package com.flyroc.ox_online.project.biz.byre.domain;

import com.flyroc.ox_online.framework.aspectj.lang.annotation.Excel;
import com.flyroc.ox_online.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

public class HyByre extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 牛棚id */
    private String byreId;

    /** 服务中心 */
    @Excel(name = "服务中心")
    private String serviceCenter;

    /** 服务中心id */
    @Excel(name = "服务中心id")
    private String id;

    /** 牛棚编号 */
    @Excel(name = "牛棚编号")
    private Integer byreNum;

    /** 所属人id */
    @Excel(name = "所属人id")
    private String userId;

    /** 开始时间 */
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setByreId(String byreId)
    {
        this.byreId = byreId;
    }

    public String getByreId()
    {
        return byreId;
    }
    public void setServiceCenter(String serviceCenter)
    {
        this.serviceCenter = serviceCenter;
    }

    public String getServiceCenter()
    {
        return serviceCenter;
    }
    public void setByreNum(Integer byreNum)
    {
        this.byreNum = byreNum;
    }

    public Integer getByreNum()
    {
        return byreNum;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserId()
    {
        return userId;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("byreId", getByreId())
                .append("serviceCenter", getServiceCenter())
                .append("byreNum", getByreNum())
                .append("userId", getUserId())
                .append("createTime", getCreateTime())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("id", getId())
                .toString();
    }
}
