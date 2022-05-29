package com.FJ28.easylearning.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    // autofill when adding
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    // autofill when adding or updating
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    // version control
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    // logic delete
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;



}
