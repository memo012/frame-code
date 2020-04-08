package com.adminsys.mybatis.proxy;

import com.adminsys.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 13-19
 **/

public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;
    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<T>(sqlSession, mapperInterface);
        return newInstance(mapperProxy);
    }

    protected T newInstance(MapperProxy<T> mapperProxy) {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, mapperProxy);
    }

}
