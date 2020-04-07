package com.adminsys.缓存装饰者.decorator;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-07 17-23
 **/

public class CacheFactory {
    public static ComponentCache getCacheFactory(){
        return new TwoLevelCacheComponent(new OneLevelCacheComponent());
    }

    public static void main(String[] args) {
        ComponentCache cacheFactory = getCacheFactory();
        System.out.println(cacheFactory.getCache("test"));
        System.out.println(cacheFactory.getCache("test"));
    }
}
