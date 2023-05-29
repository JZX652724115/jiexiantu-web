package com.jzx.jiexiantu.service;

import com.jzx.jiexiantu.pojo.Plants;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jzx
 * @since 2023-05-23
 */
public interface PlantsService extends IService<Plants> {
    List<Plants> getAll();
}
