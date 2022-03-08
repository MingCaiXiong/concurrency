package top.xiongmingcai.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Component
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisClient {

  @Resource(name = "redisPool")
  private JedisPool jedisPool;

  public void set(String key, String value) throws Exception {
    log.info("key={}, value={}", key, value);
    Jedis jedis = null;

    try {
      jedis = jedisPool.getResource();
      jedis.set(key, value);
    } finally {
      if (jedis != null) {
        jedis.close();
      }
    }
  }

  public String get(String key) throws Exception {
    log.info("key={}", key);
    Jedis jedis = null;

    try {
      jedis = jedisPool.getResource();
      return jedis.get(key);
    } finally {
      if (jedis != null) {
        jedis.close();
      }
    }
  }
}
