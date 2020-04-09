package com.adminsys.mybatis.proxy;

import com.adminsys.mybatis.annotations.Select;
import com.adminsys.mybatis.entity.UserEntity;
import com.adminsys.mybatis.mapping.MappedStatement;
import com.adminsys.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 13-23
 **/

public class MapperProxy<T> implements InvocationHandler {

    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Select annotation = method.getAnnotation(Select.class);
        if(annotation == null){
            throw new Exception("该方法上没有定义SQL语句，无法关联MappedStatement");
        }
        MappedStatement mappedStatement = new MappedStatement(method, args);
        return sqlSession.selectOne(mappedStatement);
    }
}
