package com.wen.designer.singleton.printlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: designer
 * @description:
 * @author: wentz
 * @create: 2023-08-29 11:24
 **/
@RestController
public class OrderController {

    /*@Autowired
    private Logger logger;*/

    @Autowired
    private LoggerInstance instance;

    @PostMapping("create")
    public void create(@RequestBody String orderName) {
        //todo
//        Logger logger1 = new Logger();
        LoggerInstance instance1 = LoggerInstance.getInstance();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    instance1.log(i + "instance1111！\n");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    instance.log(i + "instance！\n");
                }
            }
        }).start();

    }
}
