package com.flyroc.ox_online.project.biz.byre.lease.service.impl;

import java.util.List;
import com.flyroc.ox_online.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyroc.ox_online.project.biz.byre.lease.mapper.HyLeaseMapper;
import com.flyroc.ox_online.project.biz.byre.lease.domain.HyLease;
import com.flyroc.ox_online.project.biz.byre.lease.service.IHyLeaseService;
import com.flyroc.ox_online.common.utils.text.Convert;

/**
 * 牛棚租赁记录Service业务层处理
 * 
 * @author auto
 * @date 2021-01-20
 */
@Service
public class HyLeaseServiceImpl implements IHyLeaseService 
{
    @Autowired
    private HyLeaseMapper hyLeaseMapper;

    /**
     * 查询牛棚租赁记录
     * 
     * @param recordId 牛棚租赁记录ID
     * @return 牛棚租赁记录
     */
    @Override
    public HyLease selectHyLeaseById(String recordId)
    {
        return hyLeaseMapper.selectHyLeaseById(recordId);
    }

    /**
     * 查询牛棚租赁记录列表
     * 
     * @param hyLease 牛棚租赁记录
     * @return 牛棚租赁记录
     */
    @Override
    public List<HyLease> selectHyLeaseList(HyLease hyLease)
    {
        return hyLeaseMapper.selectHyLeaseList(hyLease);
    }

    /**
     * 新增牛棚租赁记录
     * 
     * @param hyLease 牛棚租赁记录
     * @return 结果
     */
    @Override
    public int insertHyLease(HyLease hyLease)
    {
        hyLease.setCreateTime(DateUtils.getNowDate());
        return hyLeaseMapper.insertHyLease(hyLease);
    }

    /**
     * 修改牛棚租赁记录
     * 
     * @param hyLease 牛棚租赁记录
     * @return 结果
     */
    @Override
    public int updateHyLease(HyLease hyLease)
    {
        return hyLeaseMapper.updateHyLease(hyLease);
    }

    /**
     * 删除牛棚租赁记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyLeaseByIds(String ids)
    {
        return hyLeaseMapper.deleteHyLeaseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除牛棚租赁记录信息
     * 
     * @param recordId 牛棚租赁记录ID
     * @return 结果
     */
    @Override
    public int deleteHyLeaseById(String recordId)
    {
        return hyLeaseMapper.deleteHyLeaseById(recordId);
    }
}
