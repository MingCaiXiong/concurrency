package top.xiongmingcai.example;

public class Demo {

  public static void show(int i) {
    do {
      System.out.println("i = " + i);
    } while (--i > 10);
  }

  public static void main(String[] args) {
      Integer i = 10 ;
      show(i);

  }
}
