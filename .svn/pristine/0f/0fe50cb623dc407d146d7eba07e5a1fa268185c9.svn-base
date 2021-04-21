package com.flyroc.ox_online.project.biz.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.flyroc.ox_online.framework.aspectj.lang.annotation.Log;
import com.flyroc.ox_online.framework.aspectj.lang.enums.BusinessType;
import com.flyroc.ox_online.framework.web.controller.BaseController;
import com.flyroc.ox_online.framework.web.domain.AjaxResult;
import com.flyroc.ox_online.framework.web.page.TableDataInfo;
import com.flyroc.ox_online.project.biz.activation.domain.Activation;
import com.flyroc.ox_online.project.biz.order.domain.Order;
import com.flyroc.ox_online.project.biz.order.service.IOrderService;
import com.flyroc.ox_online.project.system.post.domain.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/biz/hyOrder")
public class OrderController extends BaseController
{
    private String ox_id;

    private String prefix = "/biz/order";

    @Autowired
    private IOrderService orderService;


    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/order";
    }

    /**
     * 新增岗位
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }


    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Order order)
    {
        startPage();
        List<Map> list = orderService.selectOrderList(order);
        return getDataTable(list);
    }

    @PostMapping("/list2")
    @ResponseBody
    public TableDataInfo list2(Order order)
    {
        startPage();
        List<Map> list = orderService.selectOrderById(order);
        return getDataTable(list);
    }
    @PostMapping("/addchange")
    @ResponseBody
    public void addchange(HttpServletRequest request, HttpServletResponse response)
    {
        String id = request.getParameter("order_num");
        orderService.updateStore(id);
    }
    @PostMapping("/affirmchange1")
    @ResponseBody
    public void affirmchange1(HttpServletRequest request, HttpServletResponse response)
    {
        String id = request.getParameter("order_num");
        orderService.updateStoreNo(id);
    }
    @PostMapping("/addchange1")
    @ResponseBody
    public void addchange1(HttpServletRequest request, HttpServletResponse response)
    {
        String id = request.getParameter("order_num");
        orderService.updateAddStoreNo(id);
    }
    @PostMapping("/auditchange")
    @ResponseBody
    public void auditchange(HttpServletRequest request, HttpServletResponse response)
    {
        String id = request.getParameter("order_num");
        orderService.updateAuditStore(id);
    }
    @PostMapping("/affirmchange")
    @ResponseBody
    public void affirmchange(HttpServletRequest request, HttpServletResponse response)
    {
        String id = request.getParameter("order_num");
        orderService.updateAffirmStore(id);
    }
    @PostMapping("/dealchange")
    @ResponseBody
    public void dealchange(HttpServletRequest request, HttpServletResponse response)
    {
        String id = request.getParameter("order_num");
        orderService.updateDealStore(id);
    }
    @PostMapping("/dealchange1")
    @ResponseBody
    public void dealchange1(HttpServletRequest request, HttpServletResponse response)
    {
        String id = request.getParameter("order_num");
        orderService.updateDealStoreNo(id);
    }

    /**
     * 跳转查看页面
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") String userId,ModelMap mmap)
    {

        Order order = orderService.selectOrderListById(userId);
        mmap.put("Order",order);
        return prefix + "/edit";
    }

    /**
     * 查看按钮显示
     */
    @GetMapping("/edit2/{Ox_Id}")
    public String edit2(@PathVariable("Ox_Id") String Ox_Id,ModelMap mmap)
    {
        ox_id = Ox_Id;
        return prefix + "/edit2";
    }

    /**
     * 跳转处理页面
     */
    @GetMapping("/add/{Ox_Id}")
    public String add(@PathVariable("Ox_Id") String Ox_Id,ModelMap mmap)
    {
        Order order = orderService.selectOrderListById(Ox_Id);
        mmap.put("Order",order);
        return prefix + "/add";
    }

    /**
     *	  个人 统计
     */
    @GetMapping("/affirm")
    public String edit2(HttpServletRequest request, HttpServletResponse response,ModelMap mmap)
    {
        String a = request.getParameter("userId");
        Order order = orderService.selectOrderListById(a);
        mmap.put("Order",order);
        return prefix + "/affirm";
    }
    /**
     *	  个人 统计
     */
    @GetMapping("/deal")
    public String deal(HttpServletRequest request, HttpServletResponse response,ModelMap mmap)
    {
        String a = request.getParameter("userId");
        Order order = orderService.selectOrderListById(a);
        mmap.put("Order",order);
        return prefix + "/deal";
    }
    /**
     *	  个人 统计
     */
    @GetMapping("/audit")
    public String audit(HttpServletRequest request, HttpServletResponse response,ModelMap mmap)
    {
        String a = request.getParameter("userId");
        Order order = orderService.selectOrderListById(a);
        mmap.put("Order",order);
        return prefix + "/audit";
    }
    /**
     * 查看按钮显示
     */
    @PostMapping("/msg")
    @ResponseBody
    public void msg(HttpServletRequest request, HttpServletResponse response)
    {
        List<Map> map = orderService.selectListById(ox_id);
        List<Map> weight = orderService.selectWeight(ox_id);
        List<Map> classify = orderService.selectClassify(ox_id);
        List<Map> age = orderService.selectAge(ox_id);
        List<Map> store = orderService.selectStore(ox_id);


        JSONObject json = new JSONObject();
        json.put("a", map);
        json.put("weight", weight);
        json.put("classify", classify);
        json.put("age", age);
        json.put("store", store);
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = null;
            out = response.getWriter();
            out.write(json.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}