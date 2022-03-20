package top.xiongmingcai.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {
  public static void main(String[] args) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(5);
    Service service = new Service(latch);
    Runnable task = service::task;

    for (int i = 0; i < 5; i++) {
      Thread thread = new Thread(task);
      thread.start();
    }
    System.out.println(Thread.currentThread().getName() + "==>主线程等待。 ");
    latch.await();
    System.out.println(Thread.currentThread().getName() + "==>主线程完成等待。 ");
  }
}

class Service {
  private CountDownLatch latch;

  public Service(CountDownLatch latch) {
    this.latch = latch;
  }

  public void task() {
    try {
      System.out.println(Thread.currentThread().getName() + "-->执行任务。 ");
      sleep(2);
      System.out.println(Thread.currentThread().getName() + "-->完成的任务。");
    } finally {
      latch.countDown();
    }
  }

  private void sleep(int seconds) {
    try {
      TimeUnit.SECONDS.sleep(seconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
