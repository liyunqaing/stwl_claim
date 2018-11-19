package com.adc.da.redis;

import com.adc.da.redis.util.JedisUtil;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/${restPath}/redis")
public class test {

//    @Autowired
//    private JedisUtil jedisUtil;

    @GetMapping("/test01")
    public ResponseMessage demo01(){

        return Result.success();
    }
}
