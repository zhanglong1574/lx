package com.flyroc.ox_online.project.biz.order.service;

import com.flyroc.ox_online.common.exception.BusinessException;
import com.flyroc.ox_online.common.utils.text.Convert;
import com.flyroc.ox_online.framework.aspectj.lang.annotation.DataScope;
import com.flyroc.ox_online.project.biz.activation.domain.Activation;
import com.flyroc.ox_online.project.biz.activation.domain.Str;
import com.flyroc.ox_online.project.biz.activation.mapper.ActivationMapper;
import com.flyroc.ox_online.project.biz.order.domain.Order;
import com.flyroc.ox_online.project.biz.order.mapper.OrderMapper;
import com.flyroc.ox_online.project.system.post.domain.Post;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户 业务层处理
 *
 * @author ruoyi
 */
@Service
public class OrderServiceImpl implements IOrderService
{
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;

    private IOrderService postService;

    /**
     * 根据条件分页查询用户列表
     *
     * @param
     * @return 用户信息集合信息
     */
    @Override
    public List<Map> selectOrderList(Order order) {
//        订单状态（1：待处理；2：待确认；3：现场交易；4：已完成；5：申请取消；6：已取消；7：申诉）
        Calendar now = Calendar.getInstance();
        Calendar now1 = Calendar.getInstance();
        String Date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now1.getTime());
        order.setNowDate(Date);
        String optionsRadios = order.getOptionsRadios();

        if (optionsRadios != null){
            if (optionsRadios.equals("three_day")){
                now.add(Calendar.DAY_OF_MONTH, -3);
                String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
                order.setEndDate(endDate);
            }
            else if (optionsRadios.equals("one_week")){
                now.add(Calendar.DAY_OF_MONTH, -7);
                String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
                order.setEndDate(endDate);
            }
            else if (optionsRadios.equals("one_month")){
                now.add(Calendar.DAY_OF_MONTH, -30);
                String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
                order.setEndDate(endDate);
            }
        }

        List<Map> map = orderMapper.selectOrderList(order);
        for (int i = 0; i < map.size(); i++) {
            String a = (String) map.get(i).get("order_status");
            if (a.equals("1")){
                map.get(i).put("status","待处理");
            }
            if (a.equals("2")){
                map.get(i).put("status","待确认");
            }
            if (a.equals("3")){
                map.get(i).put("status","现场交易");
            }
            if (a.equals("4")){
                map.get(i).put("status","已完成");
            }
            if (a.equals("5")){
                map.get(i).put("status","申请取消");
            }
            if (a.equals("6")){
                map.get(i).put("status","已取消");
            }
            if (a.equals("7")){
                map.get(i).put("status","申诉");
            }
        }
        return map;
    }
    @Override
    public Order selectOrderListById(String userId) {
        // TODO Auto-generated method stub
        Order order = new Order();
        List<Map> list = orderMapper.selectOrderListById(userId);
        Map map = list.get(0);
        String order_num = (String) map.get("order_num");
        String store_ower = (String) map.get("store_ower");
        String store_tel = (String) map.get("store_tel");
        Date time = (Date) map.get("create_time");
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String create_time = ft.format(time);
        order.setOrder_num(order_num);
        order.setStore_ower(store_ower);
        order.setStore_tel(store_tel);
        order.setCreate_time(create_time);
        return order;
    }

    @Override
    public List<Map> selectOrderById(Order order) {
        List<Map> map = orderMapper.selectOrderById(order);
        for (int i = 0; i < map.size(); i++) {
            String a = (String) map.get(i).get("order_status");
            if (a.equals("1")){
                map.get(i).put("status","正常");
            }
            else if(a.equals("2")){
                map.get(i).put("status","取消");
            }
        }
        return map;
    }

    @Override
    public List<Map> selectListById(String id) {
        List<Map> map = orderMapper.selectListById(id);
        return map;
    }
    @Override
    public List<Map> selectWeight(String id) {
        List<Map> map = orderMapper.selectWeight(id);
        return map;
    }

    @Override
    public List<Map> selectClassify(String id) {
        List<Map> map = orderMapper.selectClassify(id);
        return map;
    }
    @Override
    public List<Map> selectAge(String id) {
        List<Map> map = orderMapper.selectAge(id);
        return map;
    }

    @Override
    public List<Map> selectStore(String id) {
        List<Map> map = orderMapper.selectStore(id);
        return map;
    }
    @Override
    public void updateStore(String id) {
        orderMapper.updateStore(id);
    }

    @Override
    public void updateAffirmStore(String id) {
        orderMapper.updateAffirmStore(id);
    }
    @Override
    public void updateDealStore(String id) {
        orderMapper.updateDealStore(id);
    }
    @Override
    public void updateStoreNo(String id) {
        orderMapper.updateStoreNo(id);
    }
    @Override
    public void updateAuditStore(String id) {
        orderMapper.updateAuditStore(id);
    }
    @Override
    public void updateAddStoreNo(String id) {
        orderMapper.updateAddStoreNo(id);
    }
    @Override
    public void updateDealStoreNo(String id) {
        orderMapper.updateDealStoreNo(id);
    }


}
