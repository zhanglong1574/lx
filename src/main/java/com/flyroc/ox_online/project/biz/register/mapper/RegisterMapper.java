package com.flyroc.ox_online.project.biz.register.mapper;

import com.flyroc.ox_online.project.biz.register.domain.Register;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RegisterMapper {
    public List<HashMap<String, Object>> selectTurnoverMassage(Map map);

    // 查询所有的数量
    public List<HashMap<String, Object>> selectHyOxMarketCount();

    // 查询人的最大值
    public List<HashMap<String, Object>> selectHyOxMarketMax();

    // 查询人的最小值
    public List<HashMap<String, Object>> selectHyOxMarketMin();

    // 查询牛的最大值
    public List<HashMap<String, Object>> selectHyOxMarketMax1();

    // 查询牛的最大值
    public List<HashMap<String, Object>> selectHyOxMarketMin1();

    public List<Register> selectRegisterById(String user_id);

    public int updateRegister(Register register);

}
