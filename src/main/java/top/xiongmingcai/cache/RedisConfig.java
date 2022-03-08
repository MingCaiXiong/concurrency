package top.xiongmingcai.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

@Configuration
@Slf4j
public class RedisConfig {
  @Value("${spring.redis.host}")
  private String host;

  @Value("${spring.redis.port}")
  private int port;

  @Bean(name = "redisPool")
  public JedisPool jedisPool() {
    log.info("JedisPoll连接成功：" + host + "\t" + port);
    return new JedisPool(host, port);
  }
}
