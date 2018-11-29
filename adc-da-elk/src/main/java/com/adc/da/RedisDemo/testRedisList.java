package com.adc.da.RedisDemo;

import com.adc.da.redis.util.JedisUtil;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * @program: stwl_claim
 * @description: this is the class for RedisList
 * @author: elk_wangchengxin
 * @create: 2018-11-29 14:07
 * @version: 2.0.0
 **/
@RestController
@RequestMapping("/${restPath}/RedisList")
@Api(description = "|Redis存取List类型数据|")
public class testRedisList {

    /**
     * @Description:  测试中间件Redis存储List类型的数据
     * @Param:
     * @return:
     * @Author: elk_wangchengxin
     * @Date:  2018-11-29
    */

    @GetMapping("/List")
    public ResponseMessage testList(){

        /**
         * getInstance()  获取Jedis实例
         * getJedis()  从Jedis连接池中获取Jedis对象
         * */
        Jedis j = JedisUtil.getInstance().getJedis();

        //将一个或多个值插入到列表头部(该方法可以插入一个不存在的List中）
        Long lpush = j.lpush("mylist", "a", "b", "c", "d", "1", "2", "3", "4");     //"4"是下标为0的元素
        System.out.println("lpush(key,values...)的返回值是列表长度：" + lpush);

        System.out.println("=======================分割线==========================");

        //获取指定区间元素
        //正数表示元素下标数（从0开始），负数表示倒数位数，如 -1 表示倒数第一个、-2 表示倒数第二个，0 到 -1则表示所有区间
        List<String> lrange = j.lrange("mylist", 0, -1);
        System.out.println("lrange(key,start,end)的返回类型是List集合：");
        for(String v : lrange){
            System.out.println(v);
        }

        System.out.println("=======================分割线==========================");

        //将一个值插入到列表头部（该方法不能插入一个不存在的List中,返回0），不能插入多个值只能插入一个值，不然会报错
        Long lpushx1 = j.lpushx("mylist", "aa");
        Long lpushx2 = j.lpushx("mylist1", "aa");
        System.out.println("lpushx(key,value)的返回值是列表长度：" + lpushx1);
        //判断key是否存在
        Boolean exists = j.exists("mylist1");
        System.out.println("exists(key)判断key是否存在" + exists);
        System.out.println("lpushx(key,value)插入一个不存在的key：" + lpushx2);

        //查看插入后的List
        forList("mylist");

        System.out.println("=======================分割线==========================");

        //通过索引获取列表中的元素
        String lindex = j.lindex("mylist", 5);
        System.out.println("lindex(key,index)key中下标为index的值为：" + lindex);

        System.out.println("=======================分割线==========================");

        //在指定元素之前或之后插入一个值
        //如果命令执行成功，返回插入操作完成之后，列表的长度。 如果没有找到指定元素 ，返回 -1 。
        // 如果 key 不存在或为空列表，返回 0 。
        Long linsert1 = j.linsert("mylist", BinaryClient.LIST_POSITION.BEFORE, "aa", "在aa前");
        Long linsert2 = j.linsert("mylist", BinaryClient.LIST_POSITION.AFTER, "aa", "在aa后");

        //查看list
        forList("mylist");

        System.out.println("=======================分割线==========================");

        //获取List长度
        Long llen = j.llen("mylist");
        System.out.println("llen(key)返回集合key的长度：" + llen);

        System.out.println("=======================分割线==========================");

        //移除List中的第一个元素，并返回该元素

        String lpop = j.lpop("mylist");
        System.out.println("lpop(key)集合key被移除的第一个元素：" + lpop);

        System.out.println("=======================分割线==========================");

        //查看list
        System.out.println("删除前的list列表：");
        forList("mylist");

        //移除List中的指定值
        //count > 0 : 从表头开始向表尾搜索，移除与 VALUE 相等的元素，数量为 COUNT 。
        //count < 0 : 从表尾开始向表头搜索，移除与 VALUE 相等的元素，数量为 COUNT 的绝对值。
        //count = 0 : 移除表中所有与 VALUE 相等的值。
        //返回值为被移除元素的数量。 列表不存在时返回 0 。
        Long lrem = j.lrem("mylist", -1, "aa");
        System.out.println("j.lrem(key,count,value)的返回值为：" + lrem);

        //查看list
        forList("mylist");

        System.out.println("=======================分割线==========================");

        System.out.println("查看修改前的list：");
        forList("mylist");

        //通过索引设置列表元素的值,成功返回OK，否则返回错误信息。
        String lset = j.lset("mylist", 3, "修改下标为3的值");

        System.out.println("查看修改后的list");
        forList("mylist");

        System.out.println("=======================分割线==========================");

        //裁剪List，命令执行成功时，返回 ok 。
        String ltrim = j.ltrim("mylist", 2, -3);
        System.out.println("j.ltrim(key,start,end)的返回值是：" + ltrim);
        //查看裁剪后的List
        forList("mylist");

        System.out.println("=======================分割线==========================");

        //移除List最后一个元素，返回该元素，当列表不存在时，返回 nil
        String rpop = j.rpop("mylist");
        System.out.println("rpop(key)集合key被移除的最后一个元素：" + rpop);

        //查看List
        forList("mylist");

        System.out.println("=======================分割线==========================");

        //在列表中添加一个或多个值,作用与lpush类似，不过是从尾部插入List中
        Long rpush = j.rpush("mylist", "A", "B", "C", "D");

        //为已存在的列表添加一个值,作用与lpushx类似，不过是用尾部插入List中
        Long rpushx = j.rpushx("mylist", "11");

        System.out.println("j.rpush(key,values...)的返回值为：" + rpush);
        System.out.println("j.rpushx(key,value)的返回值为：" + rpushx);

        //查看List
        forList("mylist");

        System.out.println("=======================分割线==========================");

        //将列表中最后一个值弹出，存入另一个列表里，并返回该值
        String rpoplpush = j.rpoplpush("mylist", "mylist1");
        System.out.println("j.rpoplpush(srckey,dstkey)弹出的值为：" + rpoplpush);

        //查看列表
        System.out.println("mylist:");
        forList("mylist");
        System.out.println("mylist1:");
        forList("mylist1");

        System.out.println("=======================分割线==========================");

        //移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
        //如果列表为空，返回一个 nil 。
        // 否则，返回一个含有两个元素的列表，第一个元素是被弹出元素所属的 key ，第二个元素是被弹出元素的值。
        List<String> blpop = j.blpop(100, "mylist", "mylist1");
        for (String s : blpop){
            System.out.println(s);
        }

        System.out.println("=======================分割线==========================");

        //作用与 blpop 一样只是弹出的是最后一个元素
        List<String> brpop = j.brpop(100, "mylist", "mylist1");
        for (String s : brpop){
            System.out.println(s);
        }

        System.out.println("=======================分割线==========================");

        //从列表中弹出最后一个值，将弹出的元素插入到另外一个列表中并返回它；
        //如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
        //假如在指定时间内没有任何元素被弹出，则返回一个 nil 和等待时长。
        //有值则返回一个含有两个元素的列表，第一个元素是被弹出元素的值，第二个元素是等待时长。
        String brpoplpush = j.brpoplpush("mylist", "mylist1", 100);
        System.out.println(brpoplpush);


        return Result.success();
    }

    @GetMapping("/testlrem")
    public ResponseMessage testlrem(){
        Jedis j = JedisUtil.getInstance().getJedis();
        Long lpush = j.lpush("testlrem", "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d");
        System.out.println("---修改前的list：---");
        System.out.println("--------lpush:" + lpush);
        forList("testlrem");

        System.out.println("=======================分割线==========================");

        Long lrem1 = j.lrem("testlrem", 0, "a");
        System.out.println("---j.lrem(\"testlrem\",0,\"a\")---" + lrem1);
        forList("testlrem");

        System.out.println("=======================分割线==========================");

        Long lrem2 = j.lrem("testlrem", -2, "b");
        System.out.println("---j.lrem(\"testlrem\",-2,\"b\")---" + lrem2);
        forList("testlrem");

        System.out.println("=======================分割线==========================");

        Long lrem3 = j.lrem("testlrem", 1, "c");
        System.out.println("---j.lrem(\"testlrem\",1,\"c\")---" + lrem3);
        forList("testlrem");

        Transaction multi = j.multi();

        List<Object> exec = multi.exec();

        return Result.success();
    }

    /**
     * @Description:  遍历list
     * @Param:  String key
     * @return:
     * @Author: elk_wangchengxin
     * @Date:  2018-11-29
    */

    private void forList(String key){
        Jedis j = JedisUtil.getInstance().getJedis();
        List<String> lrange = j.lrange(key, 0, -1);
        for(String v : lrange){
            System.out.println(v);
        }

    }
}

