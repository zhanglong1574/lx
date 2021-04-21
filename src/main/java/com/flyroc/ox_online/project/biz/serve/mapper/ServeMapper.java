package com.flyroc.ox_online.project.biz.serve.mapper;

import com.flyroc.ox_online.project.biz.order.domain.Order;
import com.flyroc.ox_online.project.biz.serve.domain.HyServiceCenter;
import com.flyroc.ox_online.project.biz.serve.domain.Serve;
import com.flyroc.ox_online.project.biz.serve.domain.Servei;

import java.util.List;
import java.util.Map;

/**
 * 用户表 数据层
 *
 * @author ruoy
 */
public interface ServeMapper
{
    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<Map> selectServeList(Serve serve);

    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public void insertList(Servei servei);

    /**
     * 删除交易市场
     *
     * @param id 交易市场ID
     * @return 结果
     */
    public int deleteHyServiceCenterById(String id);
    /**
     * 查询交易市场
     *
     * @param id 交易市场ID
     * @return 交易市场
     */
    public HyServiceCenter selectHyServiceCenterById(String id);


    /**
     * 修改交易市场
     *
     * @param hyServiceCenter 交易市场
     * @return 结果
     */
    public int updateHyServiceCenter(HyServiceCenter hyServiceCenter);
}
