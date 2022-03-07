package top.xiongmingcai.example;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
public class Concurrencsynchronized {
  public void test(int j) {
    synchronized (this) {
      for (int i = 0; i < 10; i++) {
        log.info("{} - {}", j, i);
      }
    }
  }

  public synchronized void test2(int j) {

    for (int i = 0; i < 10; i++) {
      log.info("{} - {}", j, i);
    }
  }

  public static void main(String[] args) {
    Concurrencsynchronized example1 = new Concurrencsynchronized();
    // Concurrencsynchronized example2 = new Concurrencsynchronized();
    // Executor executor = Executors.newCachedThreadPool();
    // Executor executor2 = Executors.newCachedThreadPool();
    // executor.execute(
    //     new Runnable() {
    //       @Override
    //       public void run() {
    //         example1.test(1);
    //       }
    //     });
      Thread thread =new Thread(new Runnable() {
          @Override
          public void run() {
              example1.test(2);
          }
      }) ;
      // thread.start();
      // thread.start();

  }
}
