package com.adminsys.mybatis.session;

import com.adminsys.mybatis.mapping.DataSource;
import com.adminsys.mybatis.proxy.MapperRegistry;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 12-38
 **/

public class Configuration {

    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     *  数据源配置
     */
    private DataSource dataSource;

    /**
     *  扫包范围
     */
    private String mappers;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setMappers(String mappers) {
        this.mappers = mappers;
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

}
