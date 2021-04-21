package com.flyroc.ox_online.project.biz.byre.service;

import com.flyroc.ox_online.common.utils.DateUtils;
import com.flyroc.ox_online.common.utils.text.Convert;
import com.flyroc.ox_online.project.biz.byre.domain.HyByre;
import com.flyroc.ox_online.project.biz.byre.mapper.HyByreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class HyByreServiceImpl implements IHyByreService {
    @Autowired
    private HyByreMapper hyByreMapper;


    public List<HyByre> selectHyByreVo() {
        return hyByreMapper.selectHyByreVo();
    }

    /**
     * 查询牛棚信息
     *
     * @param byreId 牛棚信息ID
     * @return 牛棚信息
     */
    @Override
    public HyByre selectHyByreById(String byreId) {
        return hyByreMapper.selectHyByreById(byreId);
    }

    /**
     * 查询牛棚信息列表
     *
     * @param hyByre 牛棚信息
     * @return 牛棚信息
     */
    @Override
    public List<HyByre> selectHyByreList(HyByre hyByre) {
        return hyByreMapper.selectHyByreList(hyByre);
    }

    /**
     * 新增牛棚信息
     *
     * @param hyByre 牛棚信息
     * @return 结果
     */
    @Override
    public int insertHyByre(HyByre hyByre) {
        hyByre.setCreateTime(DateUtils.getNowDate());
        return hyByreMapper.insertHyByre(hyByre);
    }

    /**
     * 修改牛棚信息
     *
     * @param hyByre 牛棚信息
     * @return 结果
     */
    @Override
    public int updateHyByre(HyByre hyByre) {
        return hyByreMapper.updateHyByre(hyByre);
    }

    /**
     * 删除牛棚信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyByreByIds(String ids) {
        return hyByreMapper.deleteHyByreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除牛棚信息信息
     *
     * @param byreId 牛棚信息ID
     * @return 结果
     */
    @Override
    public int deleteHyByreById(String byreId) {
        return hyByreMapper.deleteHyByreById(byreId);
    }

    /**
     * 删除牛棚信息信息
     *
     * @return 结果
     */
    @Override
    public List<HyByre> selectServiceCenter() {
        return hyByreMapper.selectServiceCenter();
    }

    @Override
    public String selectServiceCenterNum(HyByre hyByre) {
        return hyByreMapper.selectServiceCenterNum(hyByre);
    }


}
