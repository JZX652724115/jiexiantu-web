package com.jzx.jiexiantu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2023-05-23
 */
@Getter
@Setter
@TableName("coords")
public class Coords implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @TableField("coordId")
    private Long coordId;

    @TableField("value1")
    private Double value1;

    @TableField("value2")
    private Double value2;
}
