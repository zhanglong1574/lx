package com.flyroc.ox_online.project.biz.record.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyroc.ox_online.project.biz.record.mapper.HyVarietiesRecordMapper;
import com.flyroc.ox_online.project.biz.record.domain.HyVarietiesRecord;
import com.flyroc.ox_online.project.biz.record.service.IHyVarietiesRecordService;
import com.flyroc.ox_online.common.utils.text.Convert;

/**
 * 牛市交易附表Service业务层处理
 * 
 * @author auto
 * @date 2021-01-19
 */
@Service
public class HyVarietiesRecordServiceImpl implements IHyVarietiesRecordService 
{
    @Autowired
    private HyVarietiesRecordMapper hyVarietiesRecordMapper;

    /**
     * 查询牛市交易附表
     * 
     * @param id 牛市交易附表ID
     * @return 牛市交易附表
     */
    @Override
    public HyVarietiesRecord selectHyVarietiesRecordById(String id)
    {
        return hyVarietiesRecordMapper.selectHyVarietiesRecordById(id);
    }

    /**
     * 查询牛市交易附表列表
     * 
     * @param hyVarietiesRecord 牛市交易附表
     * @return 牛市交易附表
     */
    @Override
    public List<HyVarietiesRecord> selectHyVarietiesRecordList(HyVarietiesRecord hyVarietiesRecord)
    {
        return hyVarietiesRecordMapper.selectHyVarietiesRecordList(hyVarietiesRecord);
    }

    /**
     * 新增牛市交易附表
     * 
     * @param hyVarietiesRecord 牛市交易附表
     * @return 结果
     */
    @Override
    public int insertHyVarietiesRecord(HyVarietiesRecord hyVarietiesRecord)
    {
        return hyVarietiesRecordMapper.insertHyVarietiesRecord(hyVarietiesRecord);
    }

    /**
     * 修改牛市交易附表
     * 
     * @param hyVarietiesRecord 牛市交易附表
     * @return 结果
     */
    @Override
    public int updateHyVarietiesRecord(HyVarietiesRecord hyVarietiesRecord)
    {
        return hyVarietiesRecordMapper.updateHyVarietiesRecord(hyVarietiesRecord);
    }

    /**
     * 删除牛市交易附表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyVarietiesRecordByIds(String ids)
    {
        return hyVarietiesRecordMapper.deleteHyVarietiesRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除牛市交易附表信息
     * 
     * @param id 牛市交易附表ID
     * @return 结果
     */
    @Override
    public int deleteHyVarietiesRecordById(String id)
    {
        return hyVarietiesRecordMapper.deleteHyVarietiesRecordById(id);
    }
}
