package com.synchrony.project.reservation.logging;

import io.lettuce.core.support.caching.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CacheMetricsLogger {

    private static final Logger logger = LoggerFactory.getLogger(CacheMetricsLogger.class);

    @EventListener
    public void logCacheStats(CacheManager cacheManager) {
        cacheManager.getCacheNames().forEach(cacheName -> {
            Cache cache = cacheManager.getCache(cacheName);
            if (cache instanceof RedisCache) {
                logger.info("Cache Name: {}", cacheName);
            }
        });
    }
}

