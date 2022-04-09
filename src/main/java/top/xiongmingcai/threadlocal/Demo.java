package top.xiongmingcai.threadlocal;

public class Demo {
  public static void main(String[] args) {
    int CHUNK_SIZE = 1 << 22;

    System.out.println("CHUNK_SIZE = " + CHUNK_SIZE);

    Demo d = new Demo();
    String str = "BEA";
    d.change(str);
    System.out.println(str);
  }

  void change(String s) {
    s = s.replace('A', 'E');
    s = s.toLowerCase();
  }
}
