package com.adminsys.entity;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-20 03-41
 **/

public class WebEntity {

    private String id;

    private Integer visitor;

    public WebEntity(String id, Integer visitor) {
        this.id = id;
        this.visitor = visitor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVisitor() {
        return visitor;
    }

    public void setVisitor(Integer visitor) {
        this.visitor = visitor;
    }

    @Override
    public String toString() {
        return "WebEntity{" +
                "id='" + id + '\'' +
                ", visitor=" + visitor +
                '}';
    }
}
