package com.jzx.jiexiantu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jzx.jiexiantu.pojo.CoordLines;
import com.jzx.jiexiantu.mapper.CoordLinesMapper;
import com.jzx.jiexiantu.service.CoordLinesService;
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
 * @since 2023-05-24
 */
@Service
public class CoordLinesServiceImpl extends ServiceImpl<CoordLinesMapper, CoordLines> implements CoordLinesService {

    @Autowired
    private CoordLinesMapper coordLinesMapper;

    @Override
    public List<CoordLines> getAllLine() {
        QueryWrapper<CoordLines> wrapper = new QueryWrapper<>();
        return coordLinesMapper.selectList(wrapper);
    }
}
