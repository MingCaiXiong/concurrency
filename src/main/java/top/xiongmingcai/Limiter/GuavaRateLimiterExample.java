package top.xiongmingcai.Limiter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuavaRateLimiterExample {
  // 每秒令牌数
  static double permitsPerSecond = 5;
  static RateLimiter rateLimiter = RateLimiter.create(permitsPerSecond);

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 100; i++) {
      Thread.sleep(100);
      if (rateLimiter.tryAcquire()) {
          //等待时间要多余令牌生成时间，否则等不到令牌
        // if (rateLimiter.tryAcquire(210, TimeUnit.MILLISECONDS)) {//等到示例
        // if (rateLimiter.tryAcquire(150, TimeUnit.MILLISECONDS)) {//等不到示例
        handle(i);
      }
    }
  }

  private static void handle(int i) {
    log.info("index - {}", i);
  }
}
