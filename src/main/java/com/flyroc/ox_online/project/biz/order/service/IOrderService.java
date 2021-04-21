package com.flyroc.ox_online.project.biz.order.service;

import com.flyroc.ox_online.project.biz.activation.domain.Activation;
import com.flyroc.ox_online.project.biz.order.domain.Order;
import com.flyroc.ox_online.project.system.post.domain.Post;

import java.util.List;
import java.util.Map;

/**
 * 用户 业务层
 *
 * @author ruoyi
 */
public interface IOrderService
{
    /**
     * 根据条件分页查询用户列表
     *
     * @param
     * @return 用户信息集合信息
     */
    public List<Map> selectOrderList(Order order);
    /**
     * 查看显示
     */
    public Order selectOrderListById(String userId);
    /**
     * 查看显示
     */
    public List<Map> selectOrderById(Order order);
    /**
     * 查看显示
     */
    public List<Map> selectListById(String id);
    /**
     * 查看显示
     */
    public List<Map> selectWeight(String id);
    /**
     * 查看显示
     */
    public List<Map> selectClassify(String id);
    /**
     * 查看显示
     */
    public List<Map> selectAge(String id);
    /**
     * 查看显示
     */
    public List<Map> selectStore(String id);
    /**
     * 查看显示
     */
    public void updateStore(String id);
    /**
     * 查看显示
     */
    public void updateAffirmStore(String id);
    /**
     * 查看显示
     */
    public void updateDealStore(String id);
    /**
     * 查看显示
     */
    public void updateStoreNo(String id);
    /**
     * 查看显示
     */
    public void updateAuditStore(String id);
    /**
     * 查看显示
     */
    public void updateAddStoreNo(String id);
    /**
     * 查看显示
     */
    public void updateDealStoreNo(String id);
}
