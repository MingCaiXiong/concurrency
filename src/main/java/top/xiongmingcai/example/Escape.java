package top.xiongmingcai.example;

import lombok.extern.slf4j.Slf4j;
import top.xiongmingcai.annoations.NotRecommend;

import javax.annotation.concurrent.NotThreadSafe;

@Slf4j
@NotRecommend
@NotThreadSafe
public class Escape {
  private int thisCanBeEscape = 0;

  public Escape() {
    new innerClass();
  }

  private class innerClass {
    public innerClass() {
      log.info("{}", Escape.this.thisCanBeEscape);
    }
  }

  public static void main(String[] args) {
    new Escape();
  }
}
