package com.example.labreservesystem.utils;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {

        // 创建 Jedis 对象并连接 Redis 服务器
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 验证 Redis 密码
        jedis.auth("123456");

        // 测试 Redis 服务器连接是否成功
        String pingResult = jedis.ping();
        jedis.append("小猪","芊咪");
        System.out.println(jedis.get("小猪"));
        // 打印 Ping 结果
        System.out.println("Ping result: " + pingResult);

        // 关闭连接
//        jedis.quit();
    }
}

