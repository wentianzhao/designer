package com.wen.designer.singleton.printlog;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @program: designer
 * @description: 日志
 * @author: wentz
 * @create: 2023-08-29 11:17
 **/
@Component
public class Logger {

    private FileWriter fileWriter;

    public Logger() {
        File file = new File("C:/opt/designer/log.txt");
        try {
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void log(String message) {

        //要加类级别的锁，不能加对象锁

        synchronized (Logger.class) {
            try {
                fileWriter.write(message);
                fileWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * 解决方案：
         * 1、类级别锁
         * 2、分布式锁
         * 3、并发队列
         */

    }
}
