package com.adc.da.RedisDemo;

import com.adc.da.redis.util.JedisUtil;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: stwl_claim
 * @description: this is the class for RedisHash
 * @author: elk_wangchengxin
 * @create: 2018-11-29 14:17
 * @version: 2.0.0
 **/
@RestController
@RequestMapping("/${restPath}/RedisHash")
@Api(description = "|Redis存取Hash类型数据|")
public class testRedisHash {

    /**
     * @Description:  测试中间件Redis存储hash类型的数据
     * @Param:
     * @return:
     * @Author: elk_wangchengxin
     * @Date:  2018-11-29
     */
    @GetMapping("/Hash")
    public ResponseMessage testHash(){

        /**
         * getInstance()  获取Jedis实例
         * getJedis()  从Jedis连接池中获取Jedis对象
         * */
        Jedis j = JedisUtil.getInstance().getJedis();

        //设置一个Hash表，并存入一个 field-value 对，成功返回1
        Long hset = j.hset("myhash", "a", "aaaaa");
        System.out.println("hset(key,field,value)的返回值：" + hset);

        System.out.println("=======================分割线==========================");

        //删除Hash表中的一条数据,返回删除成功的条数
        Long hdel = j.hdel("myhash", "a", "b", "c");
        System.out.println("hdel(hey,fields...)的返回值为：" + hdel);

        System.out.println("=======================分割线==========================");

        //同时将多个 f-v 对放到Hash中,执行成功返回OK
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("b","bbbbb");
        hashMap.put("c","cccc");
        hashMap.put("d","dddd");
        hashMap.put("e","eeee");
        hashMap.put("1","10");
        hashMap.put("2","20");
        hashMap.put("3","30");
        String hmset = j.hmset("myhash", hashMap);
        System.out.println("hmset(key,HashMap)的返回值为：" + hmset);

        System.out.println("=======================分割线==========================");

        //获取存储在哈希表中指定字段的值。
        String hget = j.hget("myhash", "b");
        System.out.println("hget(key,field)的返回值为：" + hget);

        System.out.println("=======================分割线==========================");

        //获取在哈希表中指定 key 的所有字段和值
        Map<String, String> hgetAll = j.hgetAll("myhash");
        System.out.println("hgetAll(key)的返回值类型为Map集合:");
        //遍历获取的值
        for(String key : hgetAll.keySet()){
            String s = hgetAll.get(key);
            System.out.println(key + "——" + s);
        }

        System.out.println("=======================分割线==========================");

        //hincrBy()为哈希表 key 中的指定字段的整数值加上增量。增量也可以为负数，相当于对指定字段进行减法操作。
        //如果哈希表的 key 不存在,则创建一个新的hash表并执行 hincrBy() 方法
        //如果指定的字段不存在，那么在执行命令前，字段的值被初始化为 0 。
        //对一个储存字符串值的字段执行 hincrBy() 命令将造成一个错误。
        Long hincrBy = j.hincrBy("myhash", "1", -5);
        System.out.println("hincrBy(key,field,long)的返回值为：" + hincrBy);

        System.out.println("=======================分割线==========================");

        //用于为哈希表中的字段值加上指定浮点数增量值。注意事项参考hincrBy()方法
        Double hincrByFloat = j.hincrByFloat("myhash", "1", -1.8585);
        System.out.println("hincrByFloat(key,field,double)的返回值为：" + hincrByFloat);

        System.out.println("=======================分割线==========================");

        //获取Hash表中所有的字段field
        Set<String> hkeys = j.hkeys("myhash");
        System.out.println("hkeys(key)的返回值类型为Set集合：");
        for (String f : hkeys){
            System.out.println(f);
        }

        System.out.println("=======================分割线==========================");

        //获取哈希表中字段的数量
        Long hlen = j.hlen("myhash");
        System.out.println("hlen(key)的返回值为：" + hlen);

        System.out.println("=======================分割线==========================");

        //获取所有给定字段的值
        List<String> hmget = j.hmget("myhash", "a", "b", "1");
        System.out.println("hmget(key,field...)的返回值类型为List集合：");
        for(String v : hmget){
            System.out.println(v);
        }

        System.out.println("=======================分割线==========================");

        //只有在字段 field 不存在时，设置哈希表字段的值。
        //如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作。
        //如果字段已经存在于哈希表中，操作无效。
        //如果 field 不存在，创建该 field 并执行 HSETNX 命令。
        Long hsetnx1 = j.hsetnx("myhash", "b", "字段b存在");
        Long hsetnx2 = j.hsetnx("myhash1", "a", "表 myhash1 不存在");
        Long hsetnx3 = j.hsetnx("myhash", "f", "字段 f 不存在");

        System.out.println("hsetnx(key,field,value)的返回值为：");
        System.out.println("当field不存在时：" + hsetnx3);
        System.out.println("当field存在时：" + hsetnx1);
        System.out.println("当key不存在时：" + hsetnx2);

        System.out.println("=======================分割线==========================");

        //获取哈希表中所有值
        List<String> hvals = j.hvals("myhash");
        System.out.println("hvals(key)的返回值类型为List集合：");
        for(String v : hvals){
            System.out.println(v);
        }

        return Result.success();
    }
}

