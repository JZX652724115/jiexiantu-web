package com.jzx.jiexiantu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jzx.jiexiantu.pojo.Plants;
import com.jzx.jiexiantu.mapper.PlantsMapper;
import com.jzx.jiexiantu.service.PlantsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jzx
 * @since 2023-05-23
 */
@Service
public class PlantsServiceImpl extends ServiceImpl<PlantsMapper, Plants> implements PlantsService {

    @Autowired
    private PlantsMapper plantsMapper;

    @Override
    public List<Plants> getAll() {
        QueryWrapper<Plants> wrapper = new QueryWrapper<>();
        List<Plants> plants = plantsMapper.selectList(wrapper);
        return plants;
    }
}
