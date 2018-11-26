package com.adc.da.redis;


import com.adc.da.redis.util.JedisUtil;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/${restPath}/redisString")
@Api(description = "|测试Redis存取String|")
public class StringController {

    /**
    * @Description:   _测试redis字符串操作
    * @Author:         yueben
    * @CreateDate:     2018/11/21 22:52
    */
    @GetMapping("/String")
    public ResponseMessage demo01(){
        Jedis j = JedisUtil.getInstance().getJedis();
        //测试redis是否连接正常，正常返回PONG
        System.out.println(j.ping());

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //向redis存入一个字符串，成功返回OK       Jedis.set(key,value)
        System.out.println(j.set("str1","abcdefghijk"));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //通过key向redis中取值                    Jedis.get(key)
        System.out.println(j.get("str1"));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //截取数据库中某一字符串，截取key-str1对应字符串下标1~3      Jedis.getrange(key,start,end)
        System.out.println(j.getrange("str1",1,3));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //给key-str1赋上新值，并返回旧值          Jedis.getSet(key,value)
        System.out.println("旧值：" + j.getSet("str1","ABCDEFGHIJK"));
        System.out.println("新值：" + j.get("str1"));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //Setbit 命令用于对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)。
        //----------这个方法不知道干嘛用的？？？？
        System.out.println(j.setbit("str1",2,"1"));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //-----这个方法也不知道干嘛用的？？？？？
        System.out.println(j.getbit("str1",2));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //插入多条数据
        j.set("str2","12345678");
        j.set("str3","1a2b3c4d5e");
        //一次查询多条数据                        Jedis.mget(key1,key2,...)
        System.out.println(j.mget("str1","str2","str3"));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //给key绑定一个value，并设置过期时间,成功返回OK      Jedis.setex(key,seconds,value)
        System.out.println(j.setex("str4",45,"45秒后过期"));
        System.out.println(j.get("str4"));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //当key不存在时设置value，成功返回1，失败返回0，当设置的key存在时是无法设置的返回0                  Jedis.setnx(key,value)
        System.out.println("Jedis.setnx --key存在时--\n" + j.setnx("str1","222222"));
        System.out.println("设置的key存在时----" + j.get("str1"));
        System.out.println("Jedis.setnx --key不存在时--\n" + j.setnx("str5","1111111"));
        System.out.println("设置的key不存在时 ----" + j.get("str5"));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //从某一位开始截取字符串并拼接上value,返回拼接后字符串长度     Jedis.setrange(key,index,value)
        System.out.println("Jedis.setrange(key,index,value)----\n" + j.setrange("str5",3,"22222"));
        System.out.println("拼接后字符串：" + j.get("str5"));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //返回key对应字符串长度              Jedis.strlen(key)
        System.out.println("Jedis.strlen(key)----\n" + j.strlen("str5"));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //同时设置多个key—value对,成功返回OK                  Jedis.mset(k1,v1,k2,v2 ......)
        System.out.println("Jedis.mset(k1,v1,k2,v2 ......)----\n" + j.mset("str6","string6","str7","string7","str8","string8"));
        System.out.println("str6----" + j.get("str6"));
        System.out.println("str7----" + j.get("str7"));
        System.out.println("str8----" + j.get("str8"));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在。当设置的key有一个存在时则不能设置成功返回0，成功返回1          Jedis.msetnx(k1,v1,k2,v2 ......)
        System.out.println("Jedis.j.msetnx(k1,v1,k2,v2 ......)----\n" + j.msetnx("str8","string_8","str9","string_9","str10","string_10"));
        System.out.println("获取设置的值：" + j.mget("str8","str9","str10"));
        System.out.println(j.msetnx("1","11111","2","22222","3","33333"));
        System.out.println("获取设置的值：" + j.mget("1","2","3"));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //设置 key-value 对和过期时间，时间单位是毫秒，与setex方法类似 ,成功返回OK    Jedis.psetex(key,milli,value)
        System.out.println("Jedis.psetex(key,milli,value)----\n" + j.psetex("psetex",(long)30000,"以毫秒为单位设置过期时间"));

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //将key中存放的数字加一，返回加一后的数值         Jedis.incr(key)
        System.out.println("Jedis.incr(key)----\n" + j.incr("1"));
        try {
            System.out.println("非数字字符串使用incr()方法——" + j.set("a","a"));
            System.out.println(j.incr("a"));
        }catch (Exception e){
            System.out.println("程序异常，无法对非数字字符串使用incr()方法");
        }

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //将 key 所储存的值加上给定的增量值,放回加上后的值，当key不存在时则新建一个 k-v 对，并返回加值   Jedis.incrBy(key,long)
        System.out.println("——Jedis.incrBy(key,long)——");
        System.out.println("key存在时————\n" + j.incrBy("2",22222));
        System.out.println("key不存在时————\n" + j.incrBy("4",22222));
        System.out.println("获取不存在的key————" + j.get("4"));
        try {
            System.out.println("当key对应的值不是数值时————\n" + j.incrBy("str1",1000));
        }catch (Exception e){
            System.out.println("程序异常，无法对非数字字符串使用incrBy()方法");
        }

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //将 key 所储存的值加上给定的浮点增量值
        System.out.println("——Jedis.incrByFloat(key,double)——");
        System.out.println("key存在时————\n" + j.incrByFloat("3",7.68));
        System.out.println("key不存在时————\n" + j.incrByFloat("5",3.1415));
        System.out.println("获取不存在的key————" + j.get("5"));
        try {
            System.out.println("当key对应的值不是数值时————\n" + j.incrByFloat("str1",3.14159));
        }catch (Exception e){
            System.out.println("程序异常，无法对非数字字符串使用incrByFloat()方法");
        }

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //将 key 中储存的数字值减一。
        System.out.println("——Jedis.decr(key)——");
        System.out.println("key存在时————\n" + j.decr("1"));
        System.out.println("key不存在时————\n" + j.decr("6"));
        System.out.println("获取不存在的key————" + j.get("6"));
        try {
            System.out.println("当key对应的值不是数值时————\n" + j.decr("str1"));
        }catch (Exception e){
            System.out.println("程序异常，无法对非数字字符串使用decr()方法");
        }

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //key 所储存的值减去给定的减量值
        System.out.println("——Jedis.decrBy(key,long)——");
        System.out.println("key存在时————\n" + j.decrBy("1",50));
        System.out.println("key不存在时————\n" + j.decrBy("7",100));
        System.out.println("获取不存在的key————" + j.get("7"));
        try {
            System.out.println("当key对应的值不是数值时————\n" + j.decrBy("str1",150));
        }catch (Exception e){
            System.out.println("程序异常，无法对非数字字符串使用decrBy()方法");
        }

        System.out.println("->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->");

        //如果 key 已经存在并且是一个字符串， APPEND 命令将指定的 value 追加到该 key 原来值（value）的末尾,返回拼接完后字符串的长度，汉字占三个字节
        System.out.println("——Jedis.append(key,value)——");
        System.out.println("key存在时————\n" + j.append("str1","这是追加的字符串"));
        System.out.println(j.get("str1"));
        System.out.println("key不存在时————\n" + j.append("str11","这是一个新key值"));
        System.out.println("获取不存在的key————" + j.get("str11"));

        return Result.success();
    }

    /**
    * @Description:   _测试Jedis.setex(key,seconds,value)
    * @Author:         yueben
    * @CreateDate:     2018/11/21 22:51
    */
    @GetMapping("/testSetexAndPsetex")
    public ResponseMessage testSetex(){
        Jedis jedis = JedisUtil.getInstance().getJedis();
        System.out.println(jedis.mget("str1","str2","str3","str4","psetex"));
        //返回key过期剩余时间setex方法设置的
        System.out.println("返回key的过期时间(setex)----" + jedis.ttl("str4"));
        //返回key过期剩余时间psetex方法设置的
        System.out.println("返回key的过期时间(psetex)----" + jedis.pttl("psetex"));
        return Result.success();
    }

    /**
    * @Description:   _清空redis数据库
    * @Author:         yueben
    * @CreateDate:     2018/11/22 13:30
    */
    @GetMapping("/clearnAllRedis")
    public ResponseMessage clearnAllRedis(){
        //清空redis数据库
        Jedis jedis = JedisUtil.getInstance().getJedis();
        System.out.println(jedis.flushAll());
        return Result.success();
    }

}
