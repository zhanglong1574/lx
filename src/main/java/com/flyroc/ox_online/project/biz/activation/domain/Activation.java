package com.flyroc.ox_online.project.biz.activation.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.flyroc.ox_online.framework.aspectj.lang.annotation.Excel;
import com.flyroc.ox_online.framework.web.domain.BaseEntity;

/**
 * 参数配置表 hy_store
 * 
 * @author ruoyi
 */
public class Activation extends BaseEntity{

	private static final long serialVersionUID = 1L;

	 /** 主键 */
    private String userId;

    /** 店铺名 */
    @Excel(name = "店铺名")
    private String hyName;

    /** 店主姓名 */
    @Excel(name = "经理姓名")
    private String storeOwer;

    /** 店铺号 */
    private String storeCard;

    /** 行政区划代码 */
    private String regionCode;

    /** 农场详细地址 */
    private String farmAddress;

    /** 所在地 */
    @Excel(name = "所在地")
    private String storeAddress;

    /** 地区编号 */
    private String regionValue;

    /** 服务中心 */
    private String serviceCenter;

    /** 身份证号 */
    private String card;

    /** 家庭住址 */
    private String family;

    /** 密码 */
    private String password;

    /** 店铺电话 */
    @Excel(name = "店铺电话")
    private String storeTel;

    /** 店铺状态 0-驳回 1-正常 2-通过  3-待审核 9-经理人 */
    @Excel(name = "店铺状态 ")
    private String storeState;

    /** logo路径 */
    private String logoUrl;

    /** 农场横幅图片 */
    private String bannerUrl;

    /** 登录名 */
    @Excel(name = "登录名 ")
    private String loginName;

    /** 邮箱 */
    private String email;

    /** 身份证正面照 */
    private String cardImgFront;

    /** 身份证反面照 */
    private String cardImgBack;

    /** 店铺类型 */
    private String typeId;

    /** 店铺简介 */
    private String introduction;

    /** 客服联系方式 */
    private String customerContact;

    /** 企业名称 */
    private String businessName;

    /** 机构代码 */
    private String orgCode;

    /** 法人代表 */
    private String legalName;

    /** 营业执照 */
    private String licenseUrl;

    /** 营业地址 */
    private String businessAddress;

    /** 主营业务/主要产品 */
    private String businessMain;

    /** 企业简介 */
    private String businessIntro;

    /** 身份标识；1个人2企业 */
    private String idStatus;

    /** 审核人类型 0:经理人 1:管理员/业务员 */
    private Integer createType;

    /** 审核人 */
    private String createUser;

    /** 是否冻结0-否 1-是 */
    @Excel(name = "是否冻结 ")
    private String isFreeze;

    /** clientId */
    private String cid;

    /** 经理人id */
    private String handlerId;

    /** 经理人审核状态 0-正常 1-驳回 2-通过 3-待审核 */
    private String handlerStatus;

    /** 驳回原因 */
    private String rejectReason;

    /** 农场规模 */
    private String farmSize;

    /** 申请认证时间 */
    private Date applyAuthTime;

    /** 认证完成时间 */
    private Date updateAuthTime;

    /** 是否激活， */
    private String isActivate;
    
    /** 激活时间， */
    private Date isActivateTime;

    /** 激活时间， */
    private String carNum;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Date getIsActivateTime() {
		return isActivateTime;
	}

	public void setIsActivateTime(Date isActivateTime) {
		this.isActivateTime = isActivateTime;
	}

	public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setHyName(String hyName) 
    {
        this.hyName = hyName;
    }

    public String getHyName() 
    {
        return hyName;
    }
    public void setStoreOwer(String storeOwer) 
    {
        this.storeOwer = storeOwer;
    }

    public String getStoreOwer() 
    {
        return storeOwer;
    }
    public void setStoreCard(String storeCard) 
    {
        this.storeCard = storeCard;
    }

    public String getStoreCard() 
    {
        return storeCard;
    }
    public void setRegionCode(String regionCode) 
    {
        this.regionCode = regionCode;
    }

    public String getRegionCode() 
    {
        return regionCode;
    }
    public void setFarmAddress(String farmAddress) 
    {
        this.farmAddress = farmAddress;
    }

    public String getFarmAddress() 
    {
        return farmAddress;
    }
    public void setStoreAddress(String storeAddress) 
    {
        this.storeAddress = storeAddress;
    }

    public String getStoreAddress() 
    {
        return storeAddress;
    }
    public void setRegionValue(String regionValue) 
    {
        this.regionValue = regionValue;
    }

    public String getRegionValue() 
    {
        return regionValue;
    }
    public void setServiceCenter(String serviceCenter) 
    {
        this.serviceCenter = serviceCenter;
    }

    public String getServiceCenter() 
    {
        return serviceCenter;
    }
    public void setCard(String card) 
    {
        this.card = card;
    }

    public String getCard() 
    {
        return card;
    }
    public void setFamily(String family) 
    {
        this.family = family;
    }

    public String getFamily() 
    {
        return family;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setStoreTel(String storeTel) 
    {
        this.storeTel = storeTel;
    }

    public String getStoreTel() 
    {
        return storeTel;
    }
    public void setStoreState(String storeState) 
    {
        this.storeState = storeState;
    }

    public String getStoreState() 
    {
        return storeState;
    }
    public void setLogoUrl(String logoUrl) 
    {
        this.logoUrl = logoUrl;
    }

    public String getLogoUrl() 
    {
        return logoUrl;
    }
    public void setBannerUrl(String bannerUrl) 
    {
        this.bannerUrl = bannerUrl;
    }

    public String getBannerUrl() 
    {
        return bannerUrl;
    }
    public void setLoginName(String loginName) 
    {
        this.loginName = loginName;
    }

    public String getLoginName() 
    {
        return loginName;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setCardImgFront(String cardImgFront) 
    {
        this.cardImgFront = cardImgFront;
    }

    public String getCardImgFront() 
    {
        return cardImgFront;
    }
    public void setCardImgBack(String cardImgBack) 
    {
        this.cardImgBack = cardImgBack;
    }

    public String getCardImgBack() 
    {
        return cardImgBack;
    }
    public void setTypeId(String typeId) 
    {
        this.typeId = typeId;
    }

    public String getTypeId() 
    {
        return typeId;
    }
    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }
    public void setCustomerContact(String customerContact) 
    {
        this.customerContact = customerContact;
    }

    public String getCustomerContact() 
    {
        return customerContact;
    }
    public void setBusinessName(String businessName) 
    {
        this.businessName = businessName;
    }

    public String getBusinessName() 
    {
        return businessName;
    }
    public void setOrgCode(String orgCode) 
    {
        this.orgCode = orgCode;
    }

    public String getOrgCode() 
    {
        return orgCode;
    }
    public void setLegalName(String legalName) 
    {
        this.legalName = legalName;
    }

    public String getLegalName() 
    {
        return legalName;
    }
    public void setLicenseUrl(String licenseUrl) 
    {
        this.licenseUrl = licenseUrl;
    }

    public String getLicenseUrl() 
    {
        return licenseUrl;
    }
    public void setBusinessAddress(String businessAddress) 
    {
        this.businessAddress = businessAddress;
    }

    public String getBusinessAddress() 
    {
        return businessAddress;
    }
    public void setBusinessMain(String businessMain) 
    {
        this.businessMain = businessMain;
    }

    public String getBusinessMain() 
    {
        return businessMain;
    }
    public void setBusinessIntro(String businessIntro) 
    {
        this.businessIntro = businessIntro;
    }

    public String getBusinessIntro() 
    {
        return businessIntro;
    }
    public void setIdStatus(String idStatus) 
    {
        this.idStatus = idStatus;
    }

    public String getIdStatus() 
    {
        return idStatus;
    }
    public void setCreateType(Integer createType) 
    {
        this.createType = createType;
    }

    public Integer getCreateType() 
    {
        return createType;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setIsFreeze(String isFreeze) 
    {
        this.isFreeze = isFreeze;
    }

    public String getIsFreeze() 
    {
        return isFreeze;
    }
    public void setCid(String cid) 
    {
        this.cid = cid;
    }

    public String getCid() 
    {
        return cid;
    }
    public void setHandlerId(String handlerId) 
    {
        this.handlerId = handlerId;
    }

    public String getHandlerId() 
    {
        return handlerId;
    }
    public void setHandlerStatus(String handlerStatus) 
    {
        this.handlerStatus = handlerStatus;
    }

    public String getHandlerStatus() 
    {
        return handlerStatus;
    }
    public void setRejectReason(String rejectReason) 
    {
        this.rejectReason = rejectReason;
    }

    public String getRejectReason() 
    {
        return rejectReason;
    }
    public void setFarmSize(String farmSize) 
    {
        this.farmSize = farmSize;
    }

    public String getFarmSize() 
    {
        return farmSize;
    }
    public void setApplyAuthTime(Date applyAuthTime) 
    {
        this.applyAuthTime = applyAuthTime;
    }

    public Date getApplyAuthTime() 
    {
        return applyAuthTime;
    }
    public void setUpdateAuthTime(Date updateAuthTime) 
    {
        this.updateAuthTime = updateAuthTime;
    }

    public Date getUpdateAuthTime() 
    {
        return updateAuthTime;
    }
    public void setIsActivate(String isActivate) 
    {
        this.isActivate = isActivate;
    }

    public String getIsActivate() 
    {
        return isActivate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("hyName", getHyName())
            .append("storeOwer", getStoreOwer())
            .append("storeCard", getStoreCard())
            .append("regionCode", getRegionCode())
            .append("farmAddress", getFarmAddress())
            .append("storeAddress", getStoreAddress())
            .append("regionValue", getRegionValue())
            .append("serviceCenter", getServiceCenter())
            .append("card", getCard())
            .append("family", getFamily())
            .append("password", getPassword())
            .append("storeTel", getStoreTel())
            .append("storeState", getStoreState())
            .append("logoUrl", getLogoUrl())
            .append("bannerUrl", getBannerUrl())
            .append("loginName", getLoginName())
            .append("email", getEmail())
            .append("cardImgFront", getCardImgFront())
            .append("cardImgBack", getCardImgBack())
            .append("typeId", getTypeId())
            .append("introduction", getIntroduction())
            .append("customerContact", getCustomerContact())
            .append("businessName", getBusinessName())
            .append("orgCode", getOrgCode())
            .append("legalName", getLegalName())
            .append("licenseUrl", getLicenseUrl())
            .append("businessAddress", getBusinessAddress())
            .append("businessMain", getBusinessMain())
            .append("businessIntro", getBusinessIntro())
            .append("idStatus", getIdStatus())
            .append("createType", getCreateType())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isFreeze", getIsFreeze())
            .append("cid", getCid())
            .append("handlerId", getHandlerId())
            .append("handlerStatus", getHandlerStatus())
            .append("rejectReason", getRejectReason())
            .append("farmSize", getFarmSize())
            .append("applyAuthTime", getApplyAuthTime())
            .append("updateAuthTime", getUpdateAuthTime())
            .append("isActivate", getIsActivate())
            .append("carNum", getCarNum())
            .toString();
    }


}
