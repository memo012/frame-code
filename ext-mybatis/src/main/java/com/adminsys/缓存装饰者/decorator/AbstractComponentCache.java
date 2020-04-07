package com.adminsys.缓存装饰者.decorator;

/**
 * @Author: qiang
 * @Description: 抽象装饰者
 * @Create: 2020-04-07 17-06
 **/

public class AbstractComponentCache implements ComponentCache {
    private ComponentCache componentCache;

    public AbstractComponentCache(ComponentCache componentCache) {
        this.componentCache = componentCache;
    }

    public Object getCache(String key) {
        return componentCache.getCache(key);
    }

    public void putCache(String key, Object value) {

    }
}
