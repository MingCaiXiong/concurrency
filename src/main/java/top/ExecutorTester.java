package top;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorTester {
  public static AtomicInteger count = new AtomicInteger(0);

  public static void main(String[] args) {
    //
    List<Future> tasklist = new LinkedList<>();
    //   ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
    ExecutorService service = Executors.newFixedThreadPool(3);
    for (int i = 0; i < 10; i++) {
      Future<?> submit =
          service.submit(
              () -> {
                System.out.println("writing code " + count.getAndAdd(1));
                try {

                  Thread.sleep(3000);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              });

      tasklist.add(submit);
    }

    for (Future future : tasklist) {
      //
      try {
        future.get();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
    System.out.println("all tasks finished");
    service.shutdown();
  }
}
