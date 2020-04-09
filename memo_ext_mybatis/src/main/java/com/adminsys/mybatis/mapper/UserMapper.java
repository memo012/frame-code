package com.adminsys.mybatis.mapper;

import com.adminsys.mybatis.annotations.Select;
import com.adminsys.mybatis.entity.UserEntity;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 13-16
 **/

public interface UserMapper {

    @Select("select * from user where id = '?' ")
    UserEntity selectUser(Integer userId);

}
