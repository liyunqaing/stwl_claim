package com.adc.da.rabbitMQ;


import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
@RequestMapping("/${restPath}/stusqlserver/MQ")
@Api(description = "|rabbitMQ|")
public class MQ {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * MQ发送消息
     * @return
     */
    @ApiOperation(value = "|rabbitMQ|MQ发送消息")
    @GetMapping("/HelloSender")
    @RequiresPermissions("rabbitMQ:rabbitmq:HelloSender")
    public ResponseMessage  helloSender(){
        String sendMsg = "Hi " + new Date();
        System.out.println("sendHi : " + sendMsg);
        this.rabbitTemplate.convertAndSend("adc-exchange", "adc-key", sendMsg);
        return Result.success();
    }

    /**
     * MQ接收消息
     * @param hello
     * @return
     */
    @ApiOperation(value = "|rabbitMQ|MQ接收消息")
    @GetMapping("/receivehello")
    @RequiresPermissions("rabbitMQ:rabbitmq:receivehello")
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "helloQueue", durable = "true"),
            exchange = @Exchange(value = "adc-exchange", ignoreDeclarationExceptions = "true"),
            key = "cdf-key"))
    public  ResponseMessage receivehello(String hello) {
        System.out.println("hello Receiver : " + hello);
        return Result.success();
    }
}
