package com.jzx.jiexiantu.mapper;

import com.jzx.jiexiantu.pojo.CoordLines;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzx.jiexiantu.service.CoordsService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jzx
 * @since 2023-05-24
 */
@Mapper
public interface CoordLinesMapper extends BaseMapper<CoordLines> {
}
