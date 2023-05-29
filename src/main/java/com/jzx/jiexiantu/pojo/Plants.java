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
 * @since 2023-05-23
 */
@Getter
@Setter
@TableName("plants")
public class Plants implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private String id;

    @TableField("label")
    private String label;

    @TableField("region")
    private String region;

    @TableField("level")
    private Integer level;

    @TableField("value1")
    private Object value1;

    @TableField("value2")
    private Object value2;

    @TableField("value3")
    private Object value3;

    @TableField("name")
    private String name;
}
