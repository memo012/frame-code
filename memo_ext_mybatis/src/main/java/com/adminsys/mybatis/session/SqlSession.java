package com.adminsys.mybatis.session;

import com.adminsys.mybatis.mapping.MappedStatement;

import java.util.List;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 13-06
 **/

public interface SqlSession {

    <T> T getMapper(Class<T> type);

    <T> T selectOne(MappedStatement mappedStatement) throws Exception;

    public <E> List<E> selectList(MappedStatement mappedStatement);

}
