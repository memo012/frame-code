package com.adminsys.mybatis.executor;

import com.adminsys.mybatis.entity.UserEntity;
import com.adminsys.mybatis.mapping.MappedStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-09 15-58
 **/

public class SimpleExecutor extends BaseExecutor {
    @Override
    protected <E> List<E> doQuery(MappedStatement ms) {
        // 开启执行数据库...
        UserEntity userEntity = new UserEntity("1", "memo");
        List<E> list = new ArrayList<E>();
        list.add((E) userEntity);
        return list;
    }
}
