package com.jzx.jiexiantu.controller;

import com.jzx.jiexiantu.pojo.Plants;
import com.jzx.jiexiantu.service.PlantsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jzx
 * @since 2023-05-23
 */
@RestController
@RequestMapping("/jiexiantu/plants")
@Tag(name = "Plants类")
public class PlantsController {
    @Autowired
    private PlantsService plantsService;

    @GetMapping("/all")
    public List<Plants> getAll(){
        return plantsService.getAll();
    }
}
