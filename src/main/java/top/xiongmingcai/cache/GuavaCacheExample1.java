package top.xiongmingcai.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GuavaCacheExample1 {
  public static void main(String[] args) {
    LoadingCache<String, String> loadingCache =
        CacheBuilder.newBuilder()
            .maximumSize(10) // 基于容量大小回收；最多存放多少数据
                // .maximumWeight()基于内存大小回收
            .expireAfterWrite(10, TimeUnit.SECONDS)//write操作
                // .expireAfterAccess()//因为read和write操作
            .recordStats()//开启记录数据状态功能
            .build(
                new CacheLoader<String, String>() {
                  @Override
                  public String load(String s) throws Exception {
                    return "慢数据获取";
                  }
                });

    log.info("getIfPresent={}", loadingCache.getIfPresent("key"));
    loadingCache.put("key", "hello world");
    log.info("测试设置getIfPresent2={}", loadingCache.getIfPresent("key"));

    loadingCache.invalidate("key");
    log.info("测试丢弃某个key getIfPresent2={}", loadingCache.getIfPresent("key"));

    try {
      String value = loadingCache.get("key", new Callable<String>() {
        @Override
        public String call() throws Exception {
          return "Callable 方式加载";
        }
      });
      log.info("loadingCache.get value={}", value);
        for (int i = 2; i < 13; i++) {
            loadingCache.put("key"+i, "hello-- "+i);
        }
        log.info("loadingCache.size() = {}", loadingCache.size());
        log.info("测试超出大小getIfPresent2={}", loadingCache.getIfPresent("key2"));
        log.info("测试没超出时间{}",loadingCache.getIfPresent("key8"));
        Thread.sleep(11_000);

        log.info("测试超出时间{}",loadingCache.getIfPresent("key8"));

        log.info("命中次数:{} 未命中: {}",loadingCache.stats().hitCount(),loadingCache.stats().missCount());
        log.info("命中概率:{} 未命中概率: {}",loadingCache.stats().hitRate(),loadingCache.stats().missRate());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
