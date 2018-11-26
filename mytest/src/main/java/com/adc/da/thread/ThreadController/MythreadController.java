package com.adc.da.thread.ThreadController;


import com.adc.da.thread.ThreadService.MythreadService;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/${restPath}/thread")
@Api(description = "|多线程|")
public class MythreadController {

    @Autowired
    private MythreadService service;

    @GetMapping("/test")
    public ResponseMessage test(){
        service.func1();
        service.func2();

        

        return Result.success();
    }

}
