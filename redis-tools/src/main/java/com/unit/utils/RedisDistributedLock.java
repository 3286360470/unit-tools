package com.unit.utils;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.JedisCluster;

import java.util.Collections;
import java.util.UUID;

/**
 * 基于redis实现的分布式锁
 * 参考文章：[基于Redis的分布式锁实现](https://juejin.cn/post/6844903830442737671)
 */
public class RedisDistributedLock {
  private static final String LOCK_SUCCESS = "OK";
  private static final Long RELEASE_SUCCESS = 1L;
  private static final String SET_IF_NOT_EXIST = "NX";
  private static final String SET_WITH_EXPIRE_TIME = "PX";

  /** redis连接客户端 */
  private JedisCluster jedisCluster;
  /** redis锁的key */
  private String lockKey;
  /** 锁的超时时间 */
  private int expireTime = 10 * 1000;
  /** 获取锁的超时时间 */
  private int timeout = 1 * 1000;

  public RedisDistributedLock(JedisCluster jedisCluster, String lockKey, int timeout) {
    this.jedisCluster = jedisCluster;
    this.lockKey = lockKey;
    this.timeout = timeout;
  }

  public RedisDistributedLock(JedisCluster jedisCluster, String lockKey, int timeout, int expireTime) {
    this.jedisCluster = jedisCluster;
    this.lockKey = lockKey;
    this.timeout = timeout;
    this.expireTime = expireTime;
  }

  public String getLock() {
    try {
      // 获取锁的超时时间，超过此时间即放弃获取锁
      long end = System.currentTimeMillis() + timeout;
      // 随机生成一个value
      String randomValue = UUID.randomUUID().toString();
      while (System.currentTimeMillis() < end) {
        String result = jedisCluster.set(lockKey, randomValue, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCK_SUCCESS.equals(result)) {
          return randomValue;
        }
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public boolean releaseLock(String identify) {
    if (identify == null) {
      return false;
    }

    String luaScript = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
    Object result = new Object();
    try {
      result = jedisCluster.eval(luaScript, Collections.singletonList(lockKey), Collections.singletonList(identify));
      if (RELEASE_SUCCESS.equals(result)) {
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (jedisCluster != null) {
        RedisPool.release(jedisCluster);
      }
    }

    return false;
  }


}
