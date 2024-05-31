package test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Demo {

    public static void main(String[] args) {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxTotal(20);
//        jedisPoolConfig.setMaxIdle(10);
//        jedisPoolConfig.setMinIdle(5);
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379,3000,null);
//        Jedis jedis = null;
//        jedis = jedisPool.getResource();
//        System.out.println(jedis.set("baiqi","111"));
//        System.out.println(jedis.get("baiqi"));
        final String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

    }
}
