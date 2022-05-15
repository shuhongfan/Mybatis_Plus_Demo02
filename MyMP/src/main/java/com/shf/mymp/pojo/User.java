package com.shf.mymp.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.shf.mymp.enums.SexEnum;
import lombok.Data;

import java.io.Serializable;

@Data
//@TableName("t_user") // 设置实体类所对应的表名
public class User implements Serializable {
    @TableId(value = "uid",type = IdType.AUTO)   // 将属性所对应的字段指定为主键
    private Long id;

    @TableField("user_name")
    private String name;

    private Integer age;
    private String email;

    private SexEnum sex;

    @TableLogic // 逻辑删除
    private Integer isDeleted;
}
