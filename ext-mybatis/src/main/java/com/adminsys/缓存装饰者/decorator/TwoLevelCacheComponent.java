package com.adminsys.缓存装饰者.decorator;

import java.util.HashMap;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-07 17-21
 **/

public class TwoLevelCacheComponent extends AbstractComponentCache {
    // 二级缓存
    HashMap<String, Object> twoCache = new HashMap<String, Object>();

    public TwoLevelCacheComponent(ComponentCache componentCache){
        super(componentCache);
    }

    @Override
    public Object getCache(String key) {
        System.out.println(">>>> 二级缓存");
        // 先查询二级缓存
        Object twoValue = twoCache.get(key);
        // 如果二级缓存不存在 查询一级缓存
        if(twoValue == null){
            Object oneValue = super.getCache(key);
            // 如果一级缓存在 将一级缓存数据存放到二级缓存数据中
            if(oneValue != null){
                twoCache.put(key, oneValue);
                twoValue = oneValue;
            }
        }
        return twoValue;
    }
}