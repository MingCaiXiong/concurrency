package top.xiongmingcai.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Slf4j
public class CountDownLatchExample1 {
  private static final int threadCount = 200;

  public static void main(String[] args) throws InterruptedException {
    ExecutorService  exec = Executors.newCachedThreadPool();
    final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

    for (int i = 0; i < 199; i++) {
      int finalI = i;
      exec.execute(
          () -> {
            try {
              test(finalI);
            } catch (Exception e) {
              throw new RuntimeException(e);
            } finally {
              countDownLatch.countDown();
            }
          });
    }

    countDownLatch.await();

    log.info("finish");

    exec.shutdown();

  }

  public static void test(int i) throws InterruptedException {
    Thread.sleep(100);
    log.info("{}",i);
    Thread.sleep(100);
  }
}
