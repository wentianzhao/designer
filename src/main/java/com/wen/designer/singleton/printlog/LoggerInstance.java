package com.wen.designer.singleton.printlog;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @program: designer
 * @description: 单例模式，LoggerInstance
 * @author: wentz
 * @create: 2023-08-29 11:17
 **/
@Component
public class LoggerInstance {

    private FileWriter fileWriter;

    private static final LoggerInstance instance = new LoggerInstance();

    private LoggerInstance() {
        File file = new File("C:/opt/designer/log.txt");
        try {
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static LoggerInstance getInstance() {
        return instance;
    }
    public void log(String message) {

        //要加类级别的锁，不能加对象锁

        synchronized (LoggerInstance.class) {
            try {
                fileWriter.write(message);
                fileWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
