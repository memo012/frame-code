package com.adminsys.mybatis.builder;

import com.adminsys.mybatis.mapping.DataSource;
import com.adminsys.mybatis.session.Configuration;
import com.adminsys.mybatis.utils.ClassUtil;
import com.adminsys.mybatis.utils.PropertiesUtils;

import java.util.Set;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 12-30
 **/

public class XMLConfigBuilder extends BaseBuilder {

    private String propertiesName = null;

    private PropertiesUtils propertiesUtils = null;

    public XMLConfigBuilder(String propertiesName) {
        super(new Configuration());
        this.propertiesName = propertiesName;
        propertiesUtils = new PropertiesUtils(propertiesName);
    }


    public Configuration parse() {
        // 加载SQL配置文件
        environmentsElement();
        // 加载mapper扫包范围
        mapperElement();
        return configuration;
    }

    /**
     * 加载mapper下接口
     */
    private void mapperElement() {
        String mappers = propertiesUtils.getValue("mappers");
        configuration.setMappers(mappers);
        Set<Class<?>> classSet = ClassUtil.getClasses(mappers);
        for (Class<?> classes:
             classSet) {
            configuration.addMapper(classes);
        }
    }


    /**
     * 加载SQL驱动类
     */
    private void environmentsElement() {

        String driver = propertiesUtils.getValue("driver");
        String url = propertiesUtils.getValue("url");
        String username = propertiesUtils.getValue("username");
        String password = propertiesUtils.getValue("password");
        DataSource dataSource = new DataSource(driver, url, username, password);
        configuration.setDataSource(dataSource);
    }

}
