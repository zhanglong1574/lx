package com.flyroc.ox_online.project.biz.serve.service;

import com.flyroc.ox_online.project.biz.order.domain.Order;
import com.flyroc.ox_online.project.biz.order.mapper.OrderMapper;
import com.flyroc.ox_online.project.biz.order.service.IOrderService;
import com.flyroc.ox_online.project.biz.order.service.OrderServiceImpl;
import com.flyroc.ox_online.project.biz.serve.domain.HyServiceCenter;
import com.flyroc.ox_online.project.biz.serve.domain.Serve;
import com.flyroc.ox_online.project.biz.serve.domain.Servei;
import com.flyroc.ox_online.project.biz.serve.mapper.ServeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
public class ServeServiceImpl implements IServeService
{
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private ServeMapper serveMapper;

    private IServeService iServeService;

    @Override
    public List<Map> selectServeList(Serve serve) {
        return serveMapper.selectServeList(serve);
    }

    @Override
    public void insertList(HttpServletRequest request) {
        String id = java.util.UUID.randomUUID().toString().replaceAll("-", "");
        String address = request.getParameter("address");
        String service_center = request.getParameter("service_center");
        String location = request.getParameter("location");
        String full_name = request.getParameter("full_name");
        String market_address = request.getParameter("market_address");
        Servei servei = new Servei();
        servei.setId(id);
        servei.setAddress(address);
        servei.setFull_name(full_name);
        servei.setLocation(location);
        servei.setService_center(service_center);
        servei.setMarket_address(market_address);
        serveMapper.insertList(servei);
    }

    /**
     * 删除交易市场信息
     *
     * @param id 交易市场ID
     * @return 结果
     */
    @Override
    public int deleteHyServiceCenterById(String id)
    {
        return serveMapper.deleteHyServiceCenterById(id);
    }
    /**
     * 查询交易市场
     *
     * @param id 交易市场ID
     * @return 交易市场
     */
    @Override
    public HyServiceCenter selectHyServiceCenterById(String id)
    {
        return serveMapper.selectHyServiceCenterById(id);
    }
    /**
     * 修改交易市场
     *
     * @param hyServiceCenter 交易市场
     * @return 结果
     */
    @Override
    public int updateHyServiceCenter(HyServiceCenter hyServiceCenter)
    {
        return serveMapper.updateHyServiceCenter(hyServiceCenter);
    }

}
