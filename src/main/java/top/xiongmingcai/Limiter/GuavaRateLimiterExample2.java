package top.xiongmingcai.Limiter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuavaRateLimiterExample2 {
  // 每秒令牌数
  static double permitsPerSecond = 5;
  static RateLimiter rateLimiter = RateLimiter.create(permitsPerSecond);

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 100; i++) {
      Thread.sleep(100);
      rateLimiter.acquire(5); // 默认拿1个令牌: 拿到5个令牌才去处理
      handle(i);
    }
  }

  private static void handle(int i) {
    log.info("index - {}", i);
  }
}
