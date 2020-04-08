package com.adminsys.mybatis.mapping;

/**
 * @Author: qiang
 * @Description: 数据库连接类
 * @Create: 2020-04-08 12-39
 **/

public class DataSource {
    /**
     *  驱动类
     */
    private String driver;
    /**
     *  地址
     */
    private String url;
    /**
     *  用户名
     */
    private String username;
    /**
     *  密码
     */
    private String password;

    public DataSource(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
