package com.adminsys.mybatis.test;

import com.adminsys.mybatis.entity.UserEntity;
import com.adminsys.mybatis.mapper.UserMapper;
import com.adminsys.mybatis.session.SqlSession;
import com.adminsys.mybatis.session.SqlSessionFactory;
import com.adminsys.mybatis.session.SqlSessionFactoryBuilder;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 12-58
 **/
public class TestMyBatis {
    public static void main(String[] args) {
        String resource = "my_config.properties";
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession = build.openSession();
        // 生成UserMapper 代理类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行MapperProxy invoke
        UserEntity userEntity = mapper.selectUser();
        System.out.println(userEntity.toString());
    }
}