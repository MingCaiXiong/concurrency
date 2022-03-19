package top.xiongmingcai.threadlocal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormateTest2 {
  static DateFormat df = new SimpleDateFormat("yyyyMMdd,HHmmss");

  public static void main(String[] args) {

    ExecutorService ts = Executors.newFixedThreadPool(100);
    for (; ; ) {
      ts.execute(
          new Runnable() {
            @Override
            public void run() {
              try {
                // 生成随机数，格式化日期
                String format = df.format(new Date(Math.abs(new Random().nextLong())));
                System.out.println(format);
              } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
              }
            }
          });
    }
  }
}
