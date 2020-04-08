package com.adminsys.mybatis.session;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 13-11
 **/

public class DefaultSqlSession implements SqlSession {

    private final Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }
}
