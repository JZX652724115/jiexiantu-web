package com.jzx.jiexiantu.controller;


import com.jzx.jiexiantu.dto.CoordLinesDto;
import com.jzx.jiexiantu.pojo.CoordLines;
import com.jzx.jiexiantu.pojo.Coords;
import com.jzx.jiexiantu.service.CoordLinesService;
import com.jzx.jiexiantu.service.CoordsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jzx
 * @since 2023-05-24
 */
@RestController
@RequestMapping("/jiexiantu/coordLines")
@Tag(name = "CoordLines类")
public class CoordLinesController {
    @Autowired
    private CoordLinesService coordLinesService;
    @Autowired
    private CoordsService coordsService;

    @GetMapping("/all")
    public List<CoordLinesDto> getAll(){
        List<CoordLinesDto> coordLinesDtos = new ArrayList<>();
        List<CoordLines> allLine = coordLinesService.getAllLine();
        for (CoordLines coordLines : allLine) {
            Long coordId = coordLines.getCoordId();
            List<Coords> coordById = coordsService.getCoordById(coordId);
            CoordLinesDto coordLinesDto = new CoordLinesDto();
            coordLinesDto.setCoords(coordById);
            coordLinesDto.setLineId(coordLines.getLineId());
            coordLinesDto.setELabel(coordLines.getELabel());
            coordLinesDto.setSLabel(coordLines.getSLabel());
            coordLinesDtos.add(coordLinesDto);
        }
        return coordLinesDtos;
    }
}
