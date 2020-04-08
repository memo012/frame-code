package com.adminsys.mybatis.session;

import com.adminsys.mybatis.builder.XMLConfigBuilder;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 12-28
 **/

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(String properties) {
        XMLConfigBuilder parser = new XMLConfigBuilder(properties);
        return build(parser.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
