package com.jzx.jiexiantu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jzx.jiexiantu.pojo.Coords;
import com.jzx.jiexiantu.mapper.CoordsMapper;
import com.jzx.jiexiantu.service.CoordsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class CoordsServiceImpl extends ServiceImpl<CoordsMapper, Coords> implements CoordsService {

    @Autowired
    private CoordsMapper coordsMapper;

    @Override
    public List<Coords> getCoordById(Long id) {
        QueryWrapper<Coords> wrapper = new QueryWrapper<>();
        wrapper.eq("coordId",id);
        return coordsMapper.selectList(wrapper);
    }
}
