package com.jzx.jiexiantu.service;

import com.jzx.jiexiantu.pojo.Coords;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jzx
 * @since 2023-05-23
 */
public interface CoordsService extends IService<Coords> {
    List<Coords> getCoordById(Long id);
}
