package com.flyroc.ox_online.project.biz.byre.lease.mapper;

import com.flyroc.ox_online.project.biz.byre.lease.domain.HyLease;
import java.util.List;

/**
 * 牛棚租赁记录Mapper接口
 * 
 * @author auto
 * @date 2021-01-20
 */
public interface HyLeaseMapper 
{
    /**
     * 查询牛棚租赁记录
     * 
     * @param recordId 牛棚租赁记录ID
     * @return 牛棚租赁记录
     */
    public HyLease selectHyLeaseById(String recordId);

    /**
     * 查询牛棚租赁记录列表
     * 
     * @param hyLease 牛棚租赁记录
     * @return 牛棚租赁记录集合
     */
    public List<HyLease> selectHyLeaseList(HyLease hyLease);

    /**
     * 新增牛棚租赁记录
     * 
     * @param hyLease 牛棚租赁记录
     * @return 结果
     */
    public int insertHyLease(HyLease hyLease);

    /**
     * 修改牛棚租赁记录
     * 
     * @param hyLease 牛棚租赁记录
     * @return 结果
     */
    public int updateHyLease(HyLease hyLease);

    /**
     * 删除牛棚租赁记录
     * 
     * @param recordId 牛棚租赁记录ID
     * @return 结果
     */
    public int deleteHyLeaseById(String recordId);

    /**
     * 批量删除牛棚租赁记录
     * 
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyLeaseByIds(String[] recordIds);
}
