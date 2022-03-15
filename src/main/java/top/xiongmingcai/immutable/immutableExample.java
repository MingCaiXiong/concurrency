package top.xiongmingcai.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class immutableExample {
  private static final Integer anInt = 1;
  private static final String s = "s";
  private static final int i = 1;
  private static final Map<Integer, Integer> map = Maps.newHashMap();

  static {
    map.put(1, 2);
    map.put(2, 3);
  }

  public static void main(String[] args) {
    // anInt =2;
    //   i  = 2;
    // map = Maps.newHashMap();//不能修改引用地址
    map.put(1, 9);//可以修改引用地址中的值
    log.info("{}", map.get(1));
  }
}
