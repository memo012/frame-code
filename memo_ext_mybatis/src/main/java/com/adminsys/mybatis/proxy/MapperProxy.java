package com.adminsys.mybatis.proxy;

import com.adminsys.mybatis.entity.UserEntity;
import com.adminsys.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 13-23
 **/

public class MapperProxy<T> implements InvocationHandler {
    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return new UserEntity("1", "memo");
    }
}
