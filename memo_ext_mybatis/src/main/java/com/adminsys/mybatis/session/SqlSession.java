package com.adminsys.mybatis.session;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 13-06
 **/

public interface SqlSession {
    <T> T getMapper(Class<T> type);
}
