package com.adminsys.mybatis.session;

import com.adminsys.mybatis.executor.BaseExecutor;
import com.adminsys.mybatis.mapping.MappedStatement;

import java.util.List;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 13-11
 **/

public class DefaultSqlSession implements SqlSession {

    private final Configuration configuration;

    /**
     *  默认执行器
     */
    private BaseExecutor baseExecutor;

    public DefaultSqlSession(Configuration configuration, BaseExecutor baseExecutor) {
        this.configuration = configuration;
        this.baseExecutor = baseExecutor;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public <T> T selectOne(MappedStatement mappedStatement) throws Exception {
        List<T> list = this.<T>selectList(mappedStatement);
        if (list.size() == 1) {
            return list.get(0);
        } else if (list.size() > 1) {
            throw new Exception("Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
        } else {
            return null;
        }
    }

    @Override
    public <E> List<E> selectList(MappedStatement mappedStatement) {
        return baseExecutor.query(mappedStatement);
    }

}
