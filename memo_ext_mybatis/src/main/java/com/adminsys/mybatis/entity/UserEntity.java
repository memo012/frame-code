package com.adminsys.mybatis.entity;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 13-16
 **/

public class UserEntity {
    private String id;
    private String name;

    public UserEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
