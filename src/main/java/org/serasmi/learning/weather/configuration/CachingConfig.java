package org.serasmi.learning.weather.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Collections;
import java.util.Objects;

@Configuration
@EnableCaching
public class CachingConfig {
  private SimpleCacheManager cacheManager;

  @Bean
  public CacheManager cacheManager() {
    cacheManager = new SimpleCacheManager();

    cacheManager.setCaches(Collections.singletonList(
        new ConcurrentMapCache("weather")));

    return cacheManager;
  }

  // Schedules cache cleaning every 5 minutes
  @Scheduled(fixedRate = 5 * 60 * 1000)
  public void evictAllcachesAtIntervals() {
    System.out.println("Clear cache");
    evictAllCaches();
  }

  private void evictAllCaches() {
    cacheManager.getCacheNames()
        .forEach(cacheName -> Objects.requireNonNull(cacheManager.getCache(cacheName)).clear());
  }

}
