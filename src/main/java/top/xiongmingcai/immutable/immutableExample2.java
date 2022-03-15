package top.xiongmingcai.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

@Slf4j
public class immutableExample2 {

  private static Map<Integer, Integer> map = Maps.newHashMap();

  static {
    map.put(1, 2);
    map.put(2, 3);
    map = Collections.unmodifiableMap(map);
  }

  public static void main(String[] args) {
    map.put(1, 9); // 修改引用地址中的值会抛出异常
    log.info("{}", map);
  }
}
