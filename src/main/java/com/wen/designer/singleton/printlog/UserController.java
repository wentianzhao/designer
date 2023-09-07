package com.wen.designer.singleton.printlog;

import com.wen.designer.singleton.lock.IDGenerator;
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
public class UserController {

    /*@Autowired
    private Logger logger;*/

    @PostMapping("login")
    public void login(String userName, String password) {
        //todo
        Logger logger1 = new Logger();
        for (int i = 0; i < 100; i++) {
            logger1.log(userName + "logined！");
        }
    }

    @PostMapping("testId")
    public void testId() {
            for (int i = 0; i < 100; i++) {
                System.out.println(IDGenerator.getInstance().getId());
            }
            //不能直接new，权限访问限制
//            IDGenerator idGenerator = new IDGenerator();
    }
}
