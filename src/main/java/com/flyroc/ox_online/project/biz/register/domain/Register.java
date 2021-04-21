package com.flyroc.ox_online.project.biz.register.domain;

import com.flyroc.ox_online.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Register {


    /**
     * 主键
     */
    @Excel(name = "市场交易id")
    private String market_id;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private String user_id;
    /**
     * 用户id
     */
    @Excel(name = "用户姓名")
    private String store_ower;

    /**
     * 交易id
     */
    @Excel(name = "交易id")
    private String deal_id;

    /**
     * 进出市场状态
     * "0"进入，"1"卖出，"2""线下交易（暂弃）"，"3"买入，"4"出市
     */
    @Excel(name = "进出市场状态")
    private String user_imports;

    /**
     * 购买价格
     */
    @Excel(name = "购买价格")
    private String buy_price;

    /**
     * 卖家电话
     */
    @Excel(name = "卖家电话")
    private String sell_tel;

    /**
     * 交易方式，0：线下；1：线上
     */
    @Excel(name = "交易方式")
    private String sell_way;

    /**
     * 订单状态（0：待付款，1：待开票，2：已完成）
     */
    @Excel(name = "订单状态")
    private String print_status;

    /**
     * 服务中心
     */
    @Excel(name = "服务中心")
    private String service_center;

    /**
     * 车牌号
     */
    @Excel(name = "车牌号")
    private int car_num;

    /**
     * 创建时间
     */
    @Excel(name = "创建时间")
    private String create_time;

    /**
     * 总数量（暂弃）
     */
    @Excel(name = "总数量")
    private String num;

    /**
     * 买入数量
     */
    @Excel(name = "买入数量")
    private String buy_num;

    /**
     * 买家电话（暂弃）
     */
    @Excel(name = "买家电话")
    private String buy_tel;

    /**
     * 卖出数量（暂弃）
     */
    @Excel(name = "卖出数量")
    private String sell_num;

    /**
     * 卖出价格（暂弃）
     */
    @Excel(name = "卖出价格")
    private String sell_price;

    /**
     * 交易种类(字典)（暂弃）
     */
    @Excel(name = "交易种类")
    private String shop_type;

    /**
     * 没用了
     */
    @Excel(name = "没用了")
    private String register_status;

    public String getMarket_id() {
        return market_id;
    }

    public void setMarket_id(String market_id) {
        this.market_id = market_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStore_ower() {
        return store_ower;
    }

    public void setStore_ower(String store_ower) {
        this.store_ower = store_ower;
    }

    public String getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(String deal_id) {
        this.deal_id = deal_id;
    }

    public String getUser_imports() {
        return user_imports;
    }

    public void setUser_imports(String user_imports) {
        this.user_imports = user_imports;
    }

    public String getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(String buy_price) {
        this.buy_price = buy_price;
    }

    public String getSell_tel() {
        return sell_tel;
    }

    public void setSell_tel(String sell_tel) {
        this.sell_tel = sell_tel;
    }

    public String getSell_way() {
        return sell_way;
    }

    public void setSell_way(String sell_way) {
        this.sell_way = sell_way;
    }

    public String getPrint_status() {
        return print_status;
    }

    public void setPrint_status(String print_status) {
        this.print_status = print_status;
    }

    public String getService_center() {
        return service_center;
    }

    public void setService_center(String service_center) {
        this.service_center = service_center;
    }

    public int getCar_num() {
        return car_num;
    }

    public void setCar_num(int car_num) {
        this.car_num = car_num;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBuy_num() {
        return buy_num;
    }

    public void setBuy_num(String buy_num) {
        this.buy_num = buy_num;
    }

    public String getBuy_tel() {
        return buy_tel;
    }

    public void setBuy_tel(String buy_tel) {
        this.buy_tel = buy_tel;
    }

    public String getSell_num() {
        return sell_num;
    }

    public void setSell_num(String sell_num) {
        this.sell_num = sell_num;
    }

    public String getSell_price() {
        return sell_price;
    }

    public void setSell_price(String sell_price) {
        this.sell_price = sell_price;
    }

    public String getShop_type() {
        return shop_type;
    }

    public void setShop_type(String shop_type) {
        this.shop_type = shop_type;
    }

    public String getRegister_status() {
        return register_status;
    }

    public void setRegister_status(String register_status) {
        this.register_status = register_status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("market_id", getMarket_id())
                .append("user_id", getUser_id())
                .append("store_ower", getStore_ower())
                .append("deal_id", getDeal_id())
                .append("user_imports", getUser_imports())
                .append("buy_price", getBuy_price())
                .append("sell_tel", getSell_tel())
                .append("sell_way", getSell_way())
                .append("print_status", getPrint_status())
                .append("service_center", getService_center())
                .append("car_num", getCar_num())
                .append("create_time", getCreate_time())
                .append("num", getNum())
                .append("buy_num", getBuy_num())
                .append("buy_tel", getBuy_tel())
                .append("sell_num", getSell_num())
                .append("sell_price", getSell_price())
                .append("shop_type", getShop_type())
                .append("register_status", getRegister_status())
                .toString();
    }
}
