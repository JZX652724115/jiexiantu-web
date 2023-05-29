package com.jzx.jiexiantu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author jzx
 * @since 2023-05-24
 */
@Getter
@Setter
@TableName("coord_lines")
public class CoordLines implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("lineId")
    private String lineId;

    @TableField("sLabel")
    private String sLabel;

    @TableField("eLabel")
    private String eLabel;

    @TableField("coordId")
    private Long coordId;
}
