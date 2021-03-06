package com.flyroc.ox_online.project.biz.order.domain;

import com.flyroc.ox_online.framework.web.domain.BaseEntity;

public class Order extends BaseEntity {

    private String id;//唯一标识id
    private String order_num;//订单号
    private String user_id; //用户id
    private String market_id; //市场id
    private String order_status; //订单状态
    private String remark; //备注说明
    private String create_time; //创建时间
    private String tel_user; //客服业务员
    private String tel_time; //处理时间
    private String deal_user; //交易业务员
    private String finish_time; //完成时间
    private String cancel_reason; //取消原因
    private String cancel_user; //售后业务员
    private String cancel_time; //取消时间
    private String store_tel; //联系电话
    private String store_ower; //用户姓名
    private String status; //用户姓名
    private String optionsRadios; //期限选择
    private String NowDate; //期限选择
    private String endDate; //期限选择
    public String getNowDate() {
        return NowDate;
    }

    public void setNowDate(String nowDate) {
        NowDate = nowDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOptionsRadios() {
        return optionsRadios;
    }

    public void setOptionsRadios(String optionsRadios) {
        this.optionsRadios = optionsRadios;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStore_ower() {
        return store_ower;
    }

    public void setStore_ower(String store_ower) {
        this.store_ower = store_ower;
    }

    public String getStore_tel() {
        return store_tel;
    }

    public void setStore_tel(String store_tel) {
        this.store_tel = store_tel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMarket_id() {
        return market_id;
    }

    public void setMarket_id(String market_id) {
        this.market_id = market_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getTel_user() {
        return tel_user;
    }

    public void setTel_user(String tel_user) {
        this.tel_user = tel_user;
    }

    public String getTel_time() {
        return tel_time;
    }

    public void setTel_time(String tel_time) {
        this.tel_time = tel_time;
    }

    public String getDeal_user() {
        return deal_user;
    }

    public void setDeal_user(String deal_user) {
        this.deal_user = deal_user;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
    }

    public String getCancel_reason() {
        return cancel_reason;
    }

    public void setCancel_reason(String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }

    public String getCancel_user() {
        return cancel_user;
    }

    public void setCancel_user(String cancel_user) {
        this.cancel_user = cancel_user;
    }

    public String getCancel_time() {
        return cancel_time;
    }

    public void setCancel_time(String cancel_time) {
        this.cancel_time = cancel_time;
    }
}
