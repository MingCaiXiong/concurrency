package top.xiongmingcai.joda;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GJChronology;

import java.util.Locale;

public class JodaExample {

  public static void main(String[] args) {

      DateTime dt = new DateTime();
      System.out.println(dt); // 2021-05-18T17:32:27L272+08:00
      System.out.println(dt.plusDays(1)); // 2020-03-01T00:00:00.000+08:00
      System.out.println(dt.minusMonths(1)); // 2020-01-29T00:00:00.000+08:00

      DateTime dateTime = new DateTime("2021-05-18T14:12:48.624+08:00");
      System.out.println(dateTime.monthOfYear().getAsText()); //五月
      System.out.println(dateTime.monthOfYear().getAsText(Locale.KOREAN)); //5월
      System.out.println(dateTime.dayOfWeek().getAsShortText()); //星期二
      System.out.println(dateTime.dayOfWeek().getAsShortText(Locale.CHINESE)); //星期二

      System.out.println(dateTime.dayOfWeek().roundFloorCopy()); // 2021-05-18T00:00:00.000+08:00
      System.out.println(dateTime.dayOfWeek().roundCeilingCopy()); // 2021-05-19T00:00:00.000+08:00
      System.out.println(dateTime.minuteOfDay().roundFloorCopy()); // 2021-05-18T14:18:00.000+08:00
      System.out.println(dateTime.minuteOfDay().roundCeilingCopy()); // 2021-05-18T14:19:00.000+08:00

      // 比如dateTime.year().isLeap()来判断是不是闰年
      System.out.println(dateTime.getYear() + "年是闰年：" + dateTime.year().isLeap()); // 2021年是闰年：false

      //  Joda-Time默认使用的是JDK的时区设置。如果需要的话，这个默认值是可以被覆盖的。
      Chronology coptic = CopticChronology.getInstance();
      System.out.println(coptic); // CopticChronology[Asia/Shanghai]

      //下面的代码获得一个Joda-Time chronology在东京的时区
      DateTimeZone zone = DateTimeZone.forID("Asia/Tokyo");
      Chronology gregorian = GJChronology.getInstance(zone);
      System.out.println(gregorian); // GJChronology[Asia/Tokyo]
  }
}
