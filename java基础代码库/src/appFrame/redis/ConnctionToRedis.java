package appFrame.redis;

import redis.clients.jedis.Jedis;

public class ConnctionToRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        jedis.set("1","1");
        System.out.println(jedis.get("1"));
    }
}
