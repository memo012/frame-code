package com.adminsys.mybatis.builder;

import com.adminsys.mybatis.session.Configuration;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 12-33
 **/

public class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }
}
