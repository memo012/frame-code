package com.adminsys.缓存装饰者.decorator;

import java.util.HashMap;

/**
 * @Author: qiang
 * @Description: 具体组件
 * @Create: 2020-04-07 17-04
 **/

public class OneLevelCacheComponent implements ComponentCache {

    HashMap<String, Object> oneCache = new HashMap<String, Object>();

    {
        oneCache.put("test", "memo");
    }

    public Object getCache(String key) {
        System.out.println(">>>> 一级缓存");
        return oneCache.get(key);
    }

    public void putCache(String key, Object value) {

    }
}
