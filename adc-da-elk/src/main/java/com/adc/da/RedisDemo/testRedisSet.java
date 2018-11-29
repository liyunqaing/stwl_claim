package com.adc.da.RedisDemo;

import com.adc.da.redis.util.JedisUtil;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @program: stwl_claim
 * @description: this is the class for RedisSet
 * @author: elk_wangchengxin
 * @create: 2018-11-29 14:31
 * @version: 2.0.0
 **/
@RestController
@RequestMapping("/${restPath}/RedisSet")
@Api(description = "|Redis存取Set类型数据|")
public class testRedisSet {

    /**
     * @Description:  测试Redis存取set类型的数据
     * @Param:
     * @return:  return Result.success();
     * @Author: elk_wangchengxin
     * @Date:  2018-11-29
    */

    @GetMapping("/set")
    public com.adc.da.util.http.ResponseMessage testSetDemo(){

        /**
         * getInstance()  获取Jedis实例
         * getJedis()  从Jedis连接池中获取Jedis对象
         * */
        Jedis jedis = JedisUtil.getInstance().getJedis();
        //PING命令来检查是否服务器正在运行，正常返回PONG
        System.out.println(jedis.ping());
        System.out.println("=======================分割线==========================");

        //向set添加一条记录，如果member已经存在就返回0否则返回1
        System.out.println(jedis.sadd("str1","sets1"));

        System.out.println(jedis.sadd("byte[]1","a","b","c"));

        System.out.println("=======================分割线==========================");

        //获取给定的key中元素的个数

        System.out.println("str1中的元素个数为--"+jedis.scard("str1"));

        System.out.println("byte[]1中的元素个数为--"+jedis.scard("byte[]1"));

        System.out.println("=======================分割线==========================");
        //返回从第一组和所有的给定集合之间的差异的成员
        //只返回参数一的集合中的成员
       /* public Set<String> sdiff(String... keys) {
                        Jedis jedis = getJedis();
                        Set<String> set = jedis.sdiff(keys);
                        returnJedis(jedis);
                        return set;

        }*/
       System.out.println(jedis.sdiff("str1","byte[]1"));

       // 这个命令等于sdiff,但返回的不是结果集,
        // 而是将结果集存储在新的集合中，如果目标已存在，则覆盖。
        /*public long sdiffstore(String newkey, String... keys) {
                         Jedis jedis = getJedis();
                         long s = jedis.sdiffstore(newkey, keys);
                         returnJedis(jedis);
                         return s;

        }*/
        System.out.println(jedis.sdiffstore("newSets","str1","byte[]1"));

        System.out.println("=======================分割线==========================");

        //返回给定集合的成员，如果其中一个集合不存在或者为空，则返回set

        System.out.println("其中一个集合不存在"+jedis.sinter("str1","str"));
        System.out.println("两个集合都不为空"+jedis.sinter("str1","byte[]1"));

        //等于sinter,但返回的不是结果集,而是将结果集存储在新的集合中，
        // 如果目标已存在，则覆盖。
        System.out.println("新集合--"+jedis.sinterstore("new2","str1","byte[]1"));

        System.out.println("=======================分割线==========================");

        //确定一个给定的值在某个集合中是否存在
        // 参数一是判断区间（就是一个集合），参数二是要判断的值
        //存在返回1否则就返回0

        System.out.println("存在返回值1--"+jedis.sismember("byte[]1","a"));

        System.out.println("不存在返回值0"+jedis.sismember("byte[]1","y"));

        System.out.println("=======================分割线==========================");

        //返回集合中的所有成员
        System.out.println("集合中的所有成员"+jedis.smembers("byte[]1"));

        /* 将成员从源集合移出放入目标集合,
           如果源集合不存在或不包含指定成员，不进行任何操作，返回0
           否则该成员从源集合上删除，并添加到目标集合，
           如果目标集合中成员已存在，则只在源集合进行删除
           String  srckey 源集合
           String dstkey 目标集合
           String member 源集合中的成员
           状态码，1成功，0失败
            * */

        System.out.println(jedis.smove("byte[]1","str1","a"));

        System.out.println("=======================分割线==========================");

        //从集合中删除成员，
        System.out.println(jedis.spop("str1"));

        System.out.println("=======================分割线==========================");

        //从集合中删除指定的成员
        System.out.println(jedis.srem("str1","a"));

        System.out.println("=======================分割线==========================");
        /*
         * 合并多个集合并返回合并后的结果，合并后的结果集合并不保存
         * @param String  ... keys
         * @return 合并后的结果集合
         * public Set<String> sunion(String... keys)
         * */
        System.out.println(jedis.sunion("str1","byte[]1"));

        System.out.println("=======================分割线==========================");

        /*
         * 合并多个集合并将合并后的结果集保存在指定的新集合中，如果新集合已经存在则覆盖
         * @param String  newkey 新集合的key
         * @param String ... keys 要合并的集合
         *  public long sunionstore(String newkey, String... keys)
         * **/
        System.out.println(jedis.sunionstore("new2","str1","byte[]1"));

        return Result.success();
    }

}

