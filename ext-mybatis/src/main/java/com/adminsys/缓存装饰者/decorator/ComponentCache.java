package com.adminsys.缓存装饰者.decorator;

/**
 * 抽象组件
 */
public interface ComponentCache {
    public Object getCache(String key);
    public void putCache(String key, Object value);
}
