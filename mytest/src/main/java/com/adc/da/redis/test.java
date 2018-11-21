package com.adc.da.redis;


import com.adc.da.redis.util.JedisUtil;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/${restPath}/redis")
public class test {

    /**
    * @Description:   _测试redis字符串操作
    * @Author:         yueben
    * @CreateDate:     2018/11/21 22:52
    */
    @GetMapping("/testString")
    public ResponseMessage demo01(){
        Jedis j = JedisUtil.getInstance().getJedis();
        //测试redis是否连接正常，正常返回PONG
        System.out.println(j.ping());

        //向redis存入一个字符串，成功返回OK       Jedis.set(key,value)
        System.out.println(j.set("str1","abcdefghijk"));

        //通过key向redis中取值                    Jedis.get(key)
        System.out.println(j.get("str1"));

        //截取数据库中某一字符串，截取key-str1对应字符串下标1~3      Jedis.getrange(key,start,end)
        System.out.println(j.getrange("str1",1,3));

        //给key-str1赋上新值，并返回旧值          Jedis.getSet(key,value)
        System.out.println("旧值：" + j.getSet("str1","ABCDEFGHIJK"));
        System.out.println("新值：" + j.get("str1"));

        //Setbit 命令用于对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)。
        //----------这个方法不知道干嘛用的？？？？
        System.out.println(j.setbit("str1",2,"1"));

        //-----这个方法也不知道干嘛用的？？？？？
        System.out.println(j.getbit("str1",2));

        //插入多条数据
        j.set("str2","12345678");
        j.set("str3","1a2b3c4d5e");
        //一次查询多条数据                        Jedis.mget(key1,key2,...)
        System.out.println(j.mget("str1","str2","str3"));

        //给key绑定一个value，并设置过期时间,成功返回OK      Jedis.setex(key,seconds,value)
        System.out.println(j.setex("str4",45,"45秒后过期"));
        System.out.println(j.get("str4"));







        return Result.success();
    }

    /**
    * @Description:   _测试Jedis.setex(key,seconds,value)
    * @Author:         yueben
    * @CreateDate:     2018/11/21 22:51
    */
    @GetMapping("/testSetex")
    public ResponseMessage testSetex(){
        Jedis jedis = JedisUtil.getInstance().getJedis();
        System.out.println(jedis.mget("str1","str2","str3","str4"));
        return Result.success();
    }

}
