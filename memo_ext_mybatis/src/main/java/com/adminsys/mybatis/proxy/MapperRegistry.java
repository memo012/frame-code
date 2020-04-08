package com.adminsys.mybatis.proxy;

import com.adminsys.mybatis.session.Configuration;
import com.adminsys.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 13-19
 **/

public class MapperRegistry {

    private final Configuration config;

    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<Class<?>, MapperProxyFactory<?>>();

    public MapperRegistry(Configuration config) {
        this.config = config;
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            try {
                throw new Exception("Type " + type + " is not known to the MapperRegistry.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mapperProxyFactory.newInstance(sqlSession);
    }

    public <T> void addMapper(Class<T> type) {
        knownMappers.put(type, new MapperProxyFactory<T>(type));
    }

}
