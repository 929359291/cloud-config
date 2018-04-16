package com.demo.demologin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;


/**
 * Created by zengxc on 2018/2/23.
 */
@TableName(value = "sys_user")
@Data
public class User {

    @TableId
    private String id;
    @TableField("nickname")
    private String username;
    @TableField("pswd")
    private String password;
    @TableField("email")
    private String email;
    @TableField("create_time")
    private Date createTime;
    @TableField("last_login_time")
    private Date lastLoginTime;
    @TableField("status")
    private String status;
    @TableField("create_name_id")
    private String createNameId;
    @TableField("last_update_time")
    private Date lastUpdateTime;
    @TableField("last_update_name_id")
    private String lastUpdateNameId;

}
