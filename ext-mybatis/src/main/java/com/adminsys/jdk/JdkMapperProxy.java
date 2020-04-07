package com.adminsys.jdk;

import com.adminsys.entity.WebEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-20 10-34
 **/

public class JdkMapperProxy implements InvocationHandler {

    private Object target;
    public JdkMapperProxy(){

    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return new WebEntity("12", 12);
    }
}
