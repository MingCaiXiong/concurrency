package top.xiongmingcai.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class immutableExample3 {

  private static ImmutableList<Integer> immutableList = ImmutableList.of(1, 2, 3);
  private static ImmutableMap<String, String> immutableMap = ImmutableMap.of("name", "xmc000");
  private static ImmutableMap<String, String> map =
      ImmutableMap.<String, String>builder().put("name", "xmc000").build();

  public static void main(String[] args) {
    map.put("sex", "1");
    ImmutableSet<Integer> set = ImmutableSet.copyOf(immutableList);
    set.add(4);
    boolean add = immutableList.add(4);
    immutableMap.put("sex", "1");
  }
}
