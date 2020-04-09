package com.adminsys.mybatis.executor;

import com.adminsys.mybatis.mapping.MappedStatement;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-09 15-45
 **/

public abstract class BaseExecutor implements Executor {
    private Map<Object, Object> cache = new HashMap<Object, Object>();
    @Override
    public <E> List<E> query(MappedStatement ms){
        // 先查询一级 已经缓存 返回一级缓存
        List<E> list = (List<E>)cache.get(ms.getMappedStatementKey());
        if (list != null) {
            return list;
        }
        return queryFromDatabase(ms);
    }

    /**
     *  查询数据库
     * @param ms
     * @param <E>
     * @return
     */
    protected <E> List<E> queryFromDatabase(MappedStatement ms){
        List<E> list = doQuery(ms);
        if(list != null){
            cache.put(ms.getMappedStatementKey(), list);
        }
        return list;
    }

    protected abstract <E> List<E> doQuery(MappedStatement ms);
}
