package com.adc.da.stusqlserver.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adc.da.redis.util.JedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.adc.da.base.web.BaseController;
import com.adc.da.stusqlserver.entity.StudentEO;
import com.adc.da.stusqlserver.page.StudentEOPage;
import com.adc.da.stusqlserver.service.StudentEOService;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;


/**
 *
 */
@RestController
@RequestMapping("/${restPath}/stusqlserver/student1")
@Api(description = "|StudentEO1|")
public class StudentEOController extends BaseController<StudentEO> {
    /**
     *
     */
    private static final Logger logger = LoggerFactory.getLogger(StudentEOController.class);

    /**
     *
     */
    @Autowired
    private StudentEOService studentEOService;

    /**
     *
     */
    @ApiOperation(value = "|StudentEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("stusqlserver:student:page1")
    public ResponseMessage<PageInfo<StudentEO>> page(StudentEOPage page) throws Exception {
        List<StudentEO> rows = studentEOService.queryByPage(page);
    return Result.success(getPageInfo(page.getPager(), rows));
    }
    /**
     *
     */
    @ApiOperation(value = "|StudentEO|查询")
    @GetMapping("")
    @RequiresPermissions("stusqlserver:student:list1")
    public ResponseMessage<List<StudentEO>> list(StudentEOPage page) throws Exception {
        return Result.success(studentEOService.queryByList(page));
    }
    /**
     *
     */
    @ApiOperation(value = "|StudentEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("stusqlserver:student:save1")
    public ResponseMessage<StudentEO> create(@RequestBody StudentEO studentEO) throws Exception {
        studentEOService.insertSelective(studentEO);
        return Result.success(studentEO);
    }

    /**
     * 多表查询字段
     * @return
     * @throws Exception
     */

    @ApiOperation(value = "|StudentEO|多表查询1")
    @GetMapping("/allselect")
    @RequiresPermissions("student:student:allselect")
    public ResponseMessage stuSCore() throws Exception {
        return Result.success(studentEOService.allinsert());
    }

    /**
     * 查询某id的name的前几个字
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|StudentEO|查询1")
    @PostMapping("/selectOne")
    @RequiresPermissions("student:student:selectOne")
    public ResponseMessage selectOne(int id) throws Exception {
        return Result.success(studentEOService.selectOne(id));
    }

    /**
     * 查询共有多少条数据
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|StudentEO|和")
    @GetMapping("/selectAll")
    @RequiresPermissions("student:student:selectAll")
    public ResponseMessage selectAll() throws Exception {
        return Result.success(studentEOService.selectAll());
    }

    /**
     * 截取字符串
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|StudentEO|截取")
    @GetMapping("/subString")
    @RequiresPermissions("student:student:selectAll")
    public ResponseMessage subString(int id) throws Exception {
        return Result.success(studentEOService.subString(id));
    }

    /**
     *返回指定字符串中指定子字符串出现的起始位置。如果未找到就返回 0
     * @param str
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|StudentEO|查询指定字符串")
    @GetMapping("/charIndex")
    @RequiresPermissions("student:student:charIndex")
    public ResponseMessage charIndex(String str,int id) throws Exception {

        return Result.success(studentEOService.charIndex(str,id));
    }

    /**
     * 测试redis对字符串的操作
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|StudentEO|Jedis测试")
    @GetMapping("/JedisUtil")
    @RequiresPermissions("student:student:JedisUtil")
    public ResponseMessage JedisUtil() throws Exception {
        Jedis jedis = JedisUtil.getInstance().getJedis();
        System.out.println(jedis.ping());
        //向redis存入一个字符串
        System.out.println(jedis.set("test","myfirsttest"));
        //获取存入的字符串
        System.out.println(jedis.get("test"));
        //截取字符串
        System.out.println(jedis.getrange("str1",1,3));
        jedis.set("str2","12345678");
        //查询多条数据
        System.out.println(jedis.mget("str1","str2"));
        //返回key对应字符串长度
        System.out.println(jedis.strlen("str1")+"");
        //同时设置多个key—value对,成功返回OK
        System.out.println(jedis.mset("str2","string2","str3","string3","str4","string4"));
        //将key中存放的数字加一，返回加一后的数值
        System.out.println("Jedis.incr(key)----\n" + jedis.incr("1"));
        try {
            System.out.println("非数字字符串使用incr()方法——" + jedis.set("a","a"));
            System.out.println(jedis.incr("a"));
        }catch (Exception e){
            System.out.println("程序异常，无法对非数字字符串使用incr()方法");
        }
        //append向同一个key中追加值
        System.out.println("——Jedis.append(key,value)——");
        System.out.println("key存在时————\n" + jedis.append("str1","这是追加的字符串"));
        System.out.println(jedis.get("str1"));
        System.out.println("key不存在时————\n" + jedis.append("str11","这是一个新key值"));
        System.out.println("获取不存在的key————" + jedis.get("str11"));
        return Result.success();
    }

    /**
     * Jedis对List的操作
     * @return
     */
    @ApiOperation(value = "|StudentEO|Jedis对List的操作")
    @GetMapping("/ListJedis")
    @RequiresPermissions("student:student:ListJedis")
    public ResponseMessage ListJedis(){
        Jedis jedis = JedisUtil.getInstance().getJedis();
        //将一个或多个值插入到列表头部,返回去长度
        Long lpush = jedis.lpush("mylist", "a", "b", "1", "2");     //"4"是下标为0的元素
        System.out.println(lpush);
        //获取指定区间元素
        //正数表示元素下标数（从0开始），负数表示倒数位数，如 -1 表示倒数第一个、-2 表示倒数第二个，0 到 -1则表示所有区间
        List<String> lrange = jedis.lrange("mylist", 0, -1);
        for(String v : lrange){
            System.out.println(v);
        }
        //判断key是否存在
        Boolean exists = jedis.exists("mylist1");
        System.out.println(exists);
        //通过索引获取列表中的元素
        String lindex = jedis.lindex("mylist", 5);
        System.out.println(lindex+"");
        //在指定元素之前或之后插入一个值
        //如果命令执行成功，返回插入操作完成之后，列表的长度。 如果没有找到指定元素 ，返回 -1 。
        // 如果 key 不存在或为空列表，返回 0 。
        Long linsert1 = jedis.linsert("mylist", BinaryClient.LIST_POSITION.BEFORE, "aa", "在aa前");
        Long linsert2 = jedis.linsert("mylist", BinaryClient.LIST_POSITION.AFTER, "aa", "在aa后");
        //获取List长度
        Long length = jedis.llen("mylist");
        System.out.println(length+"");
        //移除List中的第一个元素，并返回该元素
        String lpop = jedis.lpop("mylist");
        System.out.println(lpop+"");
        //移除List中的指定值
        //count > 0 : 从表头开始向表尾搜索，移除与 VALUE 相等的元素，数量为 COUNT 。
        //count < 0 : 从表尾开始向表头搜索，移除与 VALUE 相等的元素，数量为 COUNT 的绝对值。
        //count = 0 : 移除表中所有与 VALUE 相等的值。
        //返回值为被移除元素的数量。 列表不存在时返回 0 。
        Long lrem = jedis.lrem("mylist", -1, "aa");
        System.out.println("j.lrem(key,count,value)的返回值为：" + lrem);
        //移除List最后一个元素，返回该元素，当列表不存在时，返回 nil
        String rpop = jedis.rpop("mylist");
        System.out.println(rpop);
        //在列表中添加一个或多个值,作用与lpush类似，不过是从尾部插入List中
        Long rpush = jedis.rpush("mylist", "A", "B", "C", "D");
        return Result.success();
    }

    /**
     * Jedis对Hash的操作
     * @return
     */
    @ApiOperation(value = "|StudentEO|Jedis对Hash的操作")
    @GetMapping("/hashJedis")
    @RequiresPermissions("student:student:hashJedis")
    public ResponseMessage hashJedis(){
        Jedis j = JedisUtil.getInstance().getJedis();
        //设置一个Hash表，并存入一个 field-value 对，成功返回1
        Long hset = j.hset("myhash", "a", "aaaaa");
        System.out.println(hset);
        //删除Hash表中的一条数据,返回删除成功的条数
        Long hdel = j.hdel("myhash", "a", "b", "c");
        System.out.println("hdel(hey,fields...)的返回值为：" + hdel);
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
        System.out.println(hmset);
        //获取存储在哈希表中指定字段的值。
        String hget = j.hget("myhash", "b");
        System.out.println(hget);
        //获取在哈希表中指定 key 的所有字段和值
        Map<String, String> hgetAll = j.hgetAll("myhash");
        for(String key : hgetAll.keySet()){
            String s = hgetAll.get(key);
            System.out.println(key + "——" + s);
        }
        //获取哈希表中所有值
        List<String> hvals = j.hvals("myhash");
        for(String v : hvals){
            System.out.println(v);
        }
        return Result.success();
    }



    /**
     * 清空redis
     * @return
     */
    @ApiOperation(value = "|StudentEO|Jedis清空")
    @GetMapping("/clearnAllRedis")
    @RequiresPermissions("student:student:clearnAllRedis")
    public ResponseMessage clearnAllRedis(){
        //清空redis数据库
        Jedis jedis = JedisUtil.getInstance().getJedis();
        System.out.println(jedis.flushAll());
        return Result.success();
    }


}
