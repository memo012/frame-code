package com.adminsys.mybatis.session;

import com.adminsys.mybatis.executor.SimpleExecutor;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 12-52
 **/

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration, new SimpleExecutor());
    }
}
