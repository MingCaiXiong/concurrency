package top.xiongmingcai.singleton;

import top.xiongmingcai.annoations.*;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class AtomicSingleton {

  private AtomicSingleton() {}

  private static AtomicReference<AtomicSingleton> instance = new AtomicReference<>();

  public static AtomicSingleton getInstance() {
    if (instance.get() == null) {
      instance.compareAndSet(null, new AtomicSingleton());
    }
    return instance.get();
  }

  public static void main(String[] args) {
    AtomicSingleton instance = AtomicSingleton.getInstance();
    AtomicSingleton instance2 = AtomicSingleton.getInstance();

    System.out.println("instance = " + instance);
    System.out.println("instance2 = " + instance2);
  }
}
