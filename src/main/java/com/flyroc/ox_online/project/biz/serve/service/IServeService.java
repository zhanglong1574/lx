package com.flyroc.ox_online.project.biz.serve.service;

import com.flyroc.ox_online.project.biz.order.domain.Order;
import com.flyroc.ox_online.project.biz.serve.domain.HyServiceCenter;
import com.flyroc.ox_online.project.biz.serve.domain.Serve;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 用户 业务层
 *
 * @author ruoyi
 */
public interface IServeService
{
    /**
     * 根据条件分页查询用户列表
     *
     * @param
     * @return 用户信息集合信息
     */
    public List<Map> selectServeList(Serve serve);

    /**
     * 添加新信息
     */
    public void insertList(HttpServletRequest request);
    /**
     * 删除交易市场信息
     *
     * @param id 交易市场ID
     * @return 结果
     */
    public int deleteHyServiceCenterById(String id);

    /**
     * 修改交易市场
     *
     * @param hyServiceCenter 交易市场
     * @return 结果
     */
    public int updateHyServiceCenter(HyServiceCenter hyServiceCenter);

    /**
     * 查询交易市场
     *
     * @param id 交易市场ID
     * @return 交易市场
     */
    public HyServiceCenter selectHyServiceCenterById(String id);

}
