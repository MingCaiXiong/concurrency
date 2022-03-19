package top.xiongmingcai.syncContainer;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationExceptionExample {

  // java.util.ConcurrentModificationException
  private static void test1(List<Integer> v1) { // foreach
    for (Integer i : v1) {
      if (i.equals(3)) {
        v1.remove(i);
      }
    }
  }
  // success
  private static void test11(List<Integer> v1) { // foreach
    CopyOnWriteArrayList<Integer> integers = Lists.newCopyOnWriteArrayList(v1);
    for (Integer i : integers) {
      if (i.equals(3)) {
        v1.remove(i);
      }
    }
  }

  // 您说的收集后处理，不是直接删除
  private static List<Integer> test111(List<Integer> v1) { // foreach
    List<Integer> result = Lists.newArrayList();
    for (Integer i : v1) {

      if (i.equals(3)) {
        // v1.remove(i);
      } else {
        result.add(i);
      }
    }
    return result;
  }

  // java.util.ConcurrentModificationException
  private static void test2(List<Integer> v1) { // iterator
    Iterator<Integer> iterator = v1.iterator();
    while (iterator.hasNext()) {
      Integer i = iterator.next();
      if (i.equals(3)) {
        v1.remove(i);
      }
    }
  }
  // java.util.ConcurrentModificationException
  private static void test22(List<Integer> v1) { // iterator
    // List<Integer> integers = Lists.newCopyOnWriteArrayList(v1);
    List<Integer> integers = new CopyOnWriteArrayList<>(v1);
    Iterator<Integer> iterator = integers.iterator();
    while (iterator.hasNext()) {
      Integer i = iterator.next();
      if (i.equals(3)) {
        v1.remove(i);
      }
    }
  }

  // success
  private static void test3(List<Integer> v1) { // for
    for (int i = 0; i < v1.size(); i++) {
      if (v1.get(i).equals(3)) {
        v1.remove(i);
      }
    }
  }

  public static void main(String[] args) {

    List<Integer> list = Lists.newArrayList();
    list.add(1);
    list.add(2);
    list.add(3);


    System.out.println("list = " + test111(list));
  }
}
