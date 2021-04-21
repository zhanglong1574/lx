package com.flyroc.ox_online.project.biz.byre.service;

import com.flyroc.ox_online.project.biz.byre.domain.HyByre;

import java.util.HashMap;
import java.util.List;

public interface IHyByreService {

    public List<HyByre> selectHyByreVo();

    /**
     * 查询牛棚信息
     *
     * @param byreId 牛棚信息ID
     * @return 牛棚信息
     */
    public HyByre selectHyByreById(String byreId);

    /**
     * 查询牛棚信息列表
     *
     * @param hyByre 牛棚信息
     * @return 牛棚信息集合
     */
    public List<HyByre> selectHyByreList(HyByre hyByre);

    /**
     * 新增牛棚信息
     *
     * @param hyByre 牛棚信息
     * @return 结果
     */
    public int insertHyByre(HyByre hyByre);

    /**
     * 修改牛棚信息
     *
     * @param hyByre 牛棚信息
     * @return 结果
     */
    public int updateHyByre(HyByre hyByre);

    /**
     * 批量删除牛棚信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyByreByIds(String ids);

    /**
     * 删除牛棚信息信息
     *
     * @param byreId 牛棚信息ID
     * @return 结果
     */
    public int deleteHyByreById(String byreId);

    /**
     * 查询服务中心信息列表
     *
     * @return 服务中心信息集合
     */
    public List<HyByre> selectServiceCenter();

    /**
     * 牛棚数量
     *
     * @return 牛棚数量
     */
    public String selectServiceCenterNum(HyByre hyByre);
}
