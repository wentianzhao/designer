package com.wen.designer.singleton.multiple;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: designer
 * @description: 每个类创建一个单例
 * @author: wentz
 * @create: 2023-09-06 16:32
 **/
public class LoggerName {

    private static final ConcurrentHashMap<String, LoggerName> instance = new ConcurrentHashMap<>();

    private LoggerName() {}

    public static LoggerName getInstance(String name) {
        instance.putIfAbsent(name, new LoggerName());
        return instance.get(name);
    }

    public void log() {
        //打印日志
    }

    public static void main(String[] args) {
        //每一个类，生成一个多例
        LoggerName instance1 = LoggerName.getInstance("User.class");
        LoggerName instance2 = LoggerName.getInstance("Order.class");
    }
}
