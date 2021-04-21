package com.flyroc.ox_online.project.biz.varieties.mapper;

import com.flyroc.ox_online.project.biz.varieties.domain.HyVarieties;
import java.util.List;

/**
 * 品种Mapper接口
 * 
 * @author auto
 * @date 2021-01-18
 */
public interface HyVarietiesMapper 
{
    /**
     * 查询品种
     * 
     * @param varietiesId 品种ID
     * @return 品种
     */
    public HyVarieties selectHyVarietiesById(String varietiesId);

    /**
     * 查询品种列表
     * 
     * @param hyVarieties 品种
     * @return 品种集合
     */
    public List<HyVarieties> selectHyVarietiesList(HyVarieties hyVarieties);

    /**
     * 新增品种
     * 
     * @param hyVarieties 品种
     * @return 结果
     */
    public int insertHyVarieties(HyVarieties hyVarieties);

    /**
     * 修改品种
     * 
     * @param hyVarieties 品种
     * @return 结果
     */
    public int updateHyVarieties(HyVarieties hyVarieties);

    /**
     * 删除品种
     * 
     * @param varietiesId 品种ID
     * @return 结果
     */
    public int deleteHyVarietiesById(String varietiesId);

    /**
     * 批量删除品种
     * 
     * @param varietiesIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyVarietiesByIds(String[] varietiesIds);
}
