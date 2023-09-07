package com.wen.designer.singleton.impl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designer
 * @description: 双重检查锁，支持延迟加载和高并发
 * @author: wentz
 * @create: 2023-09-05 16:47
 **/
public class IDGeneratorDoubleCheck {

    private volatile AtomicLong id = new AtomicLong();

    private static IDGeneratorDoubleCheck instance;

    private IDGeneratorDoubleCheck(){}

    public static IDGeneratorDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (IDGeneratorDoubleCheck.class) { //类级别锁
                if (instance == null) {
                    instance = getInstance();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }


}
