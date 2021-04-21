package com.flyroc.ox_online.project.biz.varieties.service.impl;

import java.util.List;
import com.flyroc.ox_online.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyroc.ox_online.project.biz.varieties.mapper.HyVarietiesMapper;
import com.flyroc.ox_online.project.biz.varieties.domain.HyVarieties;
import com.flyroc.ox_online.project.biz.varieties.service.IHyVarietiesService;
import com.flyroc.ox_online.common.utils.text.Convert;

/**
 * 品种Service业务层处理
 * 
 * @author auto
 * @date 2021-01-18
 */
@Service
public class HyVarietiesServiceImpl implements IHyVarietiesService 
{
    @Autowired
    private HyVarietiesMapper hyVarietiesMapper;

    /**
     * 查询品种
     * 
     * @param varietiesId 品种ID
     * @return 品种
     */
    @Override
    public HyVarieties selectHyVarietiesById(String varietiesId)
    {
        return hyVarietiesMapper.selectHyVarietiesById(varietiesId);
    }

    /**
     * 查询品种列表
     * 
     * @param hyVarieties 品种
     * @return 品种
     */
    @Override
    public List<HyVarieties> selectHyVarietiesList(HyVarieties hyVarieties)
    {
        return hyVarietiesMapper.selectHyVarietiesList(hyVarieties);
    }

    /**
     * 新增品种
     * 
     * @param hyVarieties 品种
     * @return 结果
     */
    @Override
    public int insertHyVarieties(HyVarieties hyVarieties)
    {
        hyVarieties.setCreateTime(DateUtils.getNowDate());
        return hyVarietiesMapper.insertHyVarieties(hyVarieties);
    }

    /**
     * 修改品种
     * 
     * @param hyVarieties 品种
     * @return 结果
     */
    @Override
    public int updateHyVarieties(HyVarieties hyVarieties)
    {
        return hyVarietiesMapper.updateHyVarieties(hyVarieties);
    }

    /**
     * 删除品种对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyVarietiesByIds(String ids)
    {
        return hyVarietiesMapper.deleteHyVarietiesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除品种信息
     * 
     * @param varietiesId 品种ID
     * @return 结果
     */
    @Override
    public int deleteHyVarietiesById(String varietiesId)
    {
        return hyVarietiesMapper.deleteHyVarietiesById(varietiesId);
    }
}
