package top.xiongmingcai.singleton;

public class Singleton1 {
  private static final Singleton1 INSTANCE;

  static {
    INSTANCE = new Singleton1();
  }

  private Singleton1() {}

  public static Singleton1 getInstance() {
    return INSTANCE;
  }

  public static void main(String[] args) {
      Singleton1 singleton1 = new Singleton1();
      Singleton1 singleton2 = new Singleton1();
    System.out.println("singleton1 = " + singleton1);
    System.out.println("singleton2 = " + singleton2);
  }
}
