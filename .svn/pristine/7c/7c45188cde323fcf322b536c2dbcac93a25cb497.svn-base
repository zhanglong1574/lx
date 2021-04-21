package com.flyroc.ox_online.project.biz.byre.lease.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyroc.ox_online.framework.aspectj.lang.annotation.Excel;
import com.flyroc.ox_online.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 牛棚租赁记录对象 hy_lease
 * 
 * @author auto
 * @date 2021-01-20
 */
public class HyLease extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录id */
    private String recordId;

    /** 牛棚id */
    @Excel(name = "牛棚id")
    private String byreId;

    /** 租赁者id */
    @Excel(name = "租赁者id")
    private String userId;

    /** 开始时间 */
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    public void setRecordId(String recordId) 
    {
        this.recordId = recordId;
    }

    public String getRecordId() 
    {
        return recordId;
    }
    public void setByreId(String byreId) 
    {
        this.byreId = byreId;
    }

    public String getByreId() 
    {
        return byreId;
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
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("byreId", getByreId())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .toString();
    }
}
