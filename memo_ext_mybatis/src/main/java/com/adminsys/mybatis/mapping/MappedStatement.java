package com.adminsys.mybatis.mapping;

import com.adminsys.mybatis.annotations.Select;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author: qiang
 * @Description: MappedStatement 关联SQL语句
 * @Create: 2020-04-09 15-20
 **/

public class MappedStatement {

    /**
     * SQL语句
     */
    private String sqlValue;

    /**
     * SQL语句类型
     */
    private Annotation sqlType;

    /**
     * 返回结果
     */
    private Class<?> resultType;

    /**
     * 参数
     */
    private Object[] paramType;

    public MappedStatement(Method method, Object[] paramType) {
        this.resultType = method.getReturnType();
        this.paramType = paramType;
        // 问题存在注解 获取很麻烦的问题 用一个集合存放在当前定义所有注解 策略模式循环判断
        this.sqlType = method.getAnnotation(Select.class);
        setSqlValue();
    }

    /**
     * 判断SQL类型
     *
     */
    private void setSqlValue() {
        if (sqlType instanceof Select) {
            this.sqlValue = ((Select) sqlType).value();
        }
    }

    public Annotation getSqlType() {
        return sqlType;
    }

    public void setSqlType(Annotation sqlType) {
        this.sqlType = sqlType;
    }

    public Class<?> getResultType() {
        return resultType;
    }

    public void setResultType(Class<?> resultType) {
        this.resultType = resultType;
    }

    public Object[] getParamType() {
        return paramType;
    }

    public void setParamType(Object[] paramType) {
        this.paramType = paramType;
    }

    public String getSqlValue() {
        return sqlValue;
    }

    public void setSqlValue(String sqlValue) {
        this.sqlValue = sqlValue;
    }

    public String getMappedStatementKey() {
        return sqlValue + paramType == null ? "" : paramType.toString() + resultType;
    }
}
