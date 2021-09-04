package com.unit.tools;

import com.unit.utils.RedisDistributedLock;
import com.unit.utils.RedisPool;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.JedisCluster;

/**
 * 基于redis的分布式锁的测试
 */
public class RDLockTest {

  public static void main(String[] args) {
    RedisDistributedLock lock = null;
    String identify = null;
    // redis key
    String lockKey = "test";
    // 持有锁的超时时间600s
    int expireTime = 600 * 1000;
    // 获取锁的等待时间
    int timeout = 1 * 1000;

    try {
      JedisCluster jedisCluster = RedisPool.getJedis();
      lock = new RedisDistributedLock(jedisCluster, lockKey, timeout, expireTime);
      identify = lock.getLock();
      if (StringUtils.isNotBlank(identify)) {
        // do your things
        // log.info("hahahahah");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (lock != null) {
        lock.releaseLock(identify);
      }
    }
  }

}
