package top.xiongmingcai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.xiongmingcai.cache.RedisClient;

import javax.annotation.Resource;

@Controller
@RequestMapping("/cache")
@Slf4j
public class CacheController {
  @Resource private RedisClient redisClient;

  @RequestMapping(value = "/set", method = RequestMethod.GET)
  @ResponseBody
  public String get(
      @RequestParam(value = "k", defaultValue = "hello") String k,
      @RequestParam(value = "v", defaultValue = "hello") String v) {

    try {
      redisClient.set(k, v);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "success";
  }

  @RequestMapping(value = "/get", method = RequestMethod.GET)
  @ResponseBody
  public String get(@RequestParam(value = "k", defaultValue = "hello") String k) {
    try {
      String result = redisClient.get(k);
      log.info("result = {}", result);
      return result;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "error";
  }
}
