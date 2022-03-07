package top.xiongmingcai.example;

public class ThreadStyle extends Thread {
  public static void main(String[] args) {
    ThreadStyle threadStyle = new ThreadStyle();
    threadStyle.start();
  }

  @Override
  public void run() {
      System.out.println(
              "Thread.currentThread().getName() = " + Thread.currentThread().getName());

  }
}
