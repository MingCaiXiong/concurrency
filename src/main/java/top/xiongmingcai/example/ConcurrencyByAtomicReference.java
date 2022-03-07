package top.xiongmingcai.example;

import top.xiongmingcai.annoations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class ConcurrencyByAtomicReference {
  private static AtomicReference count = new AtomicReference(0);

  public static void main(String[] args) {
    count.compareAndSet(0,2);//2
    count.compareAndSet(0,1);//no
    count.compareAndSet(2,3);//3
    count.compareAndSet(2,5);//no

    System.out.println(count.get());
  }
}
