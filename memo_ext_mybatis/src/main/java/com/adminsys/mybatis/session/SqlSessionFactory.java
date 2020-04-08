package com.adminsys.mybatis.session;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 12-52
 **/

public interface SqlSessionFactory {

    SqlSession openSession();
}
