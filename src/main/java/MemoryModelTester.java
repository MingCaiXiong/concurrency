import java.util.Random;

public class MemoryModelTester {

  int x, y, x_read, y_read;

  private Thread createThread1() {
    return new Thread(
        new Runnable() {
          @Override
          public void run() {
            try {
              Thread.sleep(new Random().nextInt(10));
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
            x = 1;
            y_read = y;
          }
        });
  }

  private Thread createThread2() {
    return new Thread(
        new Runnable() {
          @Override
          public void run() {
            try {
              Thread.sleep(new Random().nextInt(10));
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
            y = 1;
            x_read = x;
          }
        });
  }

  public static void main(String[] args) throws InterruptedException {
    while (true) {
      MemoryModelTester modelTester = new MemoryModelTester();
      Thread thread1 = modelTester.createThread1();
      Thread thread2 = modelTester.createThread2();
      thread1.start();
      thread2.start();

      thread1.join();
      thread2.join();

      String print = String.format("(%d, %d)", modelTester.x_read, modelTester.y_read);
      System.out.println(print);
      if (modelTester.x_read == 0 && modelTester.y_read == 0) {
        throw new RuntimeException("Error");
      }
    }
  }
}
