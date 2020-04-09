package com.adminsys.mybatis.executor;

import com.adminsys.mybatis.mapping.MappedStatement;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-09 15-44
 **/

public interface Executor {
    <E> List<E> query(MappedStatement ms) throws SQLException;
}
