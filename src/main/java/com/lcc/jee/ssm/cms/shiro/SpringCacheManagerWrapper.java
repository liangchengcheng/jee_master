package com.lcc.jee.ssm.cms.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * Created by asus on 2017/3/19.
 */
public class SpringCacheManagerWrapper implements CacheManager {
    private org.springframework.cache.CacheManager cacheManager;

    /**
     * 设置spring cache manager
     */
    public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return null;
    }
}
