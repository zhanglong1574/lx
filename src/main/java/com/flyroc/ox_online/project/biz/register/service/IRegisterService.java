package com.flyroc.ox_online.project.biz.register.service;

import com.flyroc.ox_online.project.biz.register.domain.Register;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRegisterService {
    public List<HashMap<String, Object>> selectTurnoverMassage(Map map);

    public List<HashMap<String, Object>> selectHyOxMarketCount();

    public List<HashMap<String, Object>> selectHyOxMarketMax();

    public List<HashMap<String, Object>> selectHyOxMarketMin();

    public List<HashMap<String, Object>> selectHyOxMarketMax1();

    public List<HashMap<String, Object>> selectHyOxMarketMin1();

    public int updateRegister(Register register);


}

