package com.unit.utils;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.*;

/**
 * redis连接池
 */
public class RedisPool {

  private static final int REDIS_POOL_SIZE = 30;
  // 最大连接数
  private static final int MAX_TOTAL = 1024;
  // 最大空闲数
  private static final int MAX_IDLE = 200;
  // 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时，若超过等待时间，则直接抛出JedisConnectionException异常
  private static final int MAX_WAIT = 10000;
  // 连接超时时间
  private static final int TIMEOUT = 10000;

  public static List<JedisCluster> jedisClusters = new ArrayList<>(REDIS_POOL_SIZE);

  /**
   * 获取redis连接
   */
  public static JedisCluster getJedis() {
    JedisCluster jedisCluster = null;
    synchronized (RedisPool.class) {
      try {
        if (!jedisClusters.isEmpty()) {
          jedisCluster = jedisClusters.get(0);
          jedisClusters.remove(0);
        } else {
          for (int i = 0; i < REDIS_POOL_SIZE; i++) {
            GenericObjectPoolConfig<Object> poolConfig = new GenericObjectPoolConfig<>();
            poolConfig.setMaxIdle(MAX_IDLE);
            poolConfig.setMaxTotal(MAX_TOTAL);
            poolConfig.setMaxWaitMillis(MAX_WAIT);

            Set<HostAndPort> hostAndPorts = new HashSet<>(Arrays.asList(new HostAndPort[]{new HostAndPort("", 7070), new HostAndPort("", 7071)}));
            jedisCluster = new JedisCluster(hostAndPorts, TIMEOUT, poolConfig);
            jedisClusters.remove(i);

          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return jedisCluster;
  }

  /**
   * 释放redis连接
   */
  public synchronized static void release(JedisCluster jedisCluster) {
    if (jedisClusters != null && jedisClusters.size() < REDIS_POOL_SIZE) {
      jedisClusters.add(jedisCluster);
    }
  }

}
