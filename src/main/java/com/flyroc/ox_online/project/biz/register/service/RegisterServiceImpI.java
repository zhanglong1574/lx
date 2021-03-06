package com.flyroc.ox_online.project.biz.register.service;


import com.flyroc.ox_online.project.biz.register.domain.Register;
import com.flyroc.ox_online.project.biz.register.mapper.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpI implements IRegisterService {

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public List<HashMap<String, Object>> selectTurnoverMassage(Map map) {
//        Register register = new Register();
//        register.setMarket_id();
        return registerMapper.selectTurnoverMassage(map);
    }

    @Override
    public List<HashMap<String, Object>> selectHyOxMarketCount() {
        // TODO Auto-generated method stub
        return registerMapper.selectHyOxMarketCount();
    }


    @Override
    public List<HashMap<String, Object>> selectHyOxMarketMax() {
        // TODO Auto-generated method stub
        return registerMapper.selectHyOxMarketMax();
    }


    @Override
    public List<HashMap<String, Object>> selectHyOxMarketMin() {
        // TODO Auto-generated method stub
        return registerMapper.selectHyOxMarketMin();
    }
    @Override
    public List<HashMap<String, Object>> selectHyOxMarketMax1() {
        // TODO Auto-generated method stub
        return registerMapper.selectHyOxMarketMax1();
    }


    @Override
    public List<HashMap<String, Object>> selectHyOxMarketMin1() {
        // TODO Auto-generated method stub
        return registerMapper.selectHyOxMarketMin1();
    }

    public List<Register> selectRegisterById(String user_id){

        return registerMapper.selectRegisterById(user_id);
    }



    @Override
    public int updateRegister(Register register) {
        return registerMapper.updateRegister(register);
    }
}