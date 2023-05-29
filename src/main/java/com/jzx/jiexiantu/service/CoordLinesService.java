package com.jzx.jiexiantu.service;

import com.jzx.jiexiantu.pojo.CoordLines;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jzx
 * @since 2023-05-24
 */
public interface CoordLinesService extends IService<CoordLines> {
    List<CoordLines> getAllLine();
}
