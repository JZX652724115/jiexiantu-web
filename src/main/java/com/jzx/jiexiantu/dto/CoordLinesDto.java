package com.jzx.jiexiantu.dto;

import com.jzx.jiexiantu.pojo.CoordLines;
import com.jzx.jiexiantu.pojo.Coords;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoordLinesDto extends CoordLines {
    List<Coords> coords = new ArrayList<>();
}
