package com.adc.da.thread.ThreadService;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MythreadService {

    @Async
    public void func1(){
        for(int i=0 ; i < 1000 ; i++){
            System.out.println("这是线程AAA：" + i);
        }
    }

    @Async
    public void func2(){
        for(int i=0 ; i < 500 ; i++){
            System.out.println("这是线程BBB：" + i);
        }
    }
}
